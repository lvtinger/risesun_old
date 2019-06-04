package org.risesun.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        if (null == loader) {
            loader = ClassUtils.class.getClassLoader();
            if (null == loader) {
                loader = ClassLoader.getSystemClassLoader();
            }
        }

        return loader;

    }

    public static Class<?> getClassByName(String className) {
        if (StringUtils.isEmpty(className)) {
            return null;
        }
        try {
            return ClassUtils.getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Set<Class<?>> doScan(String... packages) {
        Set<Class<?>> classes = new HashSet<>();
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        for (String $package : packages) {
            Enumeration<URL> resources = null;
            try {
                resources = classLoader.getResources($package.replace(".", "/"));
            } catch (IOException ignored) {
            }

            if (null == resources) {
                continue;
            }

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    doScanDirectory(classes, $package, url.getPath());
                }
            }
        }

        return classes;
    }

    private static void doScanDirectory(Set<Class<?>> classes, String $package, String path) {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        File[] files =
                directory.listFiles(file -> file.isDirectory() || file.getName().endsWith(".class"));
        if (null == files || files.length == 0) {
            return;
        }
        for (File file : files) {
            String className = file.getName();

            if (file.isDirectory()) {
                doScanDirectory(classes, $package + "." + className, file.getPath());
            } else if (file.isFile()) {
                className = className.substring(0, className.length() - 6);
                className = $package + "." + className;
                Class<?> type = ClassUtils.getClassByName(className);
                if (null != type) {
                    classes.add(type);
                }
            }
        }
    }

    public static Set<Class<?>> doScan(ClassFilter filter, String... packages) {
        Set<Class<?>> classes = new HashSet<>();
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        for (String $package : packages) {
            Enumeration<URL> resources = null;
            try {
                resources = classLoader.getResources($package.replace(".", "/"));
            } catch (IOException ignored) {
            }

            if (null == resources) {
                continue;
            }

            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    doScanDirectory(classes, filter, $package, url.getPath());
                }
            }
        }

        return classes;
    }

    private static void doScanDirectory(Set<Class<?>> classes, ClassFilter filter, String $package, String path) {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        File[] files =
                directory.listFiles(file -> file.isDirectory() || file.getName().endsWith(".class"));
        if (null == files || files.length == 0) {
            return;
        }
        for (File file : files) {
            String className = file.getName();

            if (file.isDirectory()) {
                doScanDirectory(classes, filter, $package + "." + className, file.getPath());
            } else if (file.isFile()) {
                className = className.substring(0, className.length() - 6);
                className = $package + "." + className;
                Class<?> type = ClassUtils.getClassByName(className);
                if (null != type && filter.math(type)) {
                    classes.add(type);
                }
            }
        }
    }
}
