package org.risesun.data.mysql.test.repository;

public interface CrudRepository<T, ID> extends Repository<T, ID> {
    void create(T entity);

    void update(T entity);

    void delete(ID id);

    T findById(ID id);
}