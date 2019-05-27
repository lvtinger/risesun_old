package org.risesun.data.core.source;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 平滑加权轮询算法
 *
 * @author qiuxu
 * @since 20190515
 * @param <T> 加权对象类型，根据业务需要重写equals方法
 */
public class WeightRoundRobin<T> {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private List<Node<T>> nodes;

    private int totalWeight;

    /**
     * 构造函数
     *
     * @param nodes 权重节点
     */
    public WeightRoundRobin(List<Node<T>> nodes) {
        if (null == nodes || nodes.size() == 0) {
            throw new IllegalArgumentException("nodes is not null or empty");
        }

        this.nodes = nodes;
        this.totalWeight = this.nodes.stream().mapToInt(Node::getDefaultWeight).sum();
    }

    /**
     * 轮询节点
     *
     * @return {@link T}
     */
    public T roundRobin() {
        if(null == this.nodes || this.nodes.size() == 0){
            return null;
        }

        Lock lock = this.readWriteLock.readLock();
        boolean locked = false;
        try {
            if (locked = lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                if(null == this.nodes || this.nodes.size() == 0){
                    return null;
                }
                this.nodes.forEach(Node::before);
                Node<T> current = this.nodes.stream().max(Node::compareTo).orElse(null);
                if(null != current){
                    current.after(totalWeight);
                    return current.getNode();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (InterruptedException e) {
            return null;
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    /**
     * 移除节点
     *
     * <p>成功移除节点和无需移除节点返回true；没有获取写锁、线程终端以及代码异常均返回false，需要重写移除；
     *
     * @param element {@link T }
     * @return 移除结果
     */
    public boolean remove(T element) {
        if (null == element) {
            throw new NullPointerException();
        }

        Lock lock = this.readWriteLock.writeLock();
        boolean locked = false;
        try {
            if (locked = lock.tryLock(10, TimeUnit.MILLISECONDS)) {

                if (this.nodes.removeIf(x -> x.equals(new Node<>(element, 1)))) {
                    this.nodes.forEach(Node::reload);
                    this.totalWeight = nodes.stream().mapToInt(Node::getDefaultWeight).sum();
                }

                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            return false;
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    /**
     * 添加节点
     *
     * <p>添加成功和无需添加返回true；获取写锁失败、线程中断和代码异常返回false；
     *
     * @param element {@link T }
     * @return 添加结果
     */
    public boolean attach(T element, int weight) {
        Node<T> node = new Node<>(element, weight);

        if (this.nodes.contains(node)) {
            return true;
        }

        Lock lock = this.readWriteLock.writeLock();
        boolean locked = false;
        try {
            if (locked = lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                if(null == this.nodes){
                    this.nodes = new ArrayList<>();
                    this.nodes.add(new Node<>(element, weight));
                } else if(this.nodes.size() == 0){
                    this.nodes.add(new Node<>(element, weight));
                } else if (this.nodes.stream().noneMatch(x -> x.equals(node))) {
                    if (this.nodes.add(node)) {
                        this.nodes.forEach(Node::reload);
                        this.totalWeight = this.nodes.stream().mapToInt(Node::getDefaultWeight).sum();
                    }
                }

                return true;
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            return false;
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

}
