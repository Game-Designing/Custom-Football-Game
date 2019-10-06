package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static class MethodBuilder {

        /* renamed from: a */
        private final Object f34597a;

        /* renamed from: b */
        private final String f34598b;

        /* renamed from: c */
        private Class<?> f34599c;

        /* renamed from: d */
        private List<Class<?>> f34600d = new ArrayList();

        /* renamed from: e */
        private List<Object> f34601e = new ArrayList();

        /* renamed from: f */
        private boolean f34602f;

        /* renamed from: g */
        private boolean f34603g;

        public MethodBuilder(Object instance, String methodName) {
            Preconditions.checkNotNull(methodName);
            this.f34597a = instance;
            this.f34598b = methodName;
            this.f34599c = instance != null ? instance.getClass() : null;
        }

        public <T> MethodBuilder addParam(Class<T> clazz, T parameter) {
            Preconditions.checkNotNull(clazz);
            this.f34600d.add(clazz);
            this.f34601e.add(parameter);
            return this;
        }

        public MethodBuilder addParam(String className, Object parameter) throws ClassNotFoundException {
            Preconditions.checkNotNull(className);
            this.f34600d.add(Class.forName(className));
            this.f34601e.add(parameter);
            return this;
        }

        public MethodBuilder setAccessible() {
            this.f34602f = true;
            return this;
        }

        public MethodBuilder setStatic(Class<?> clazz) {
            Preconditions.checkNotNull(clazz);
            this.f34603g = true;
            this.f34599c = clazz;
            return this;
        }

        public MethodBuilder setStatic(String className) throws ClassNotFoundException {
            Preconditions.checkNotNull(className);
            this.f34603g = true;
            this.f34599c = Class.forName(className);
            return this;
        }

        public Object execute() throws Exception {
            Method method = Reflection.getDeclaredMethodWithTraversal(this.f34599c, this.f34598b, (Class[]) this.f34600d.toArray(new Class[this.f34600d.size()]));
            if (this.f34602f) {
                method.setAccessible(true);
            }
            Object[] parameters = this.f34601e.toArray();
            if (this.f34603g) {
                return method.invoke(null, parameters);
            }
            return method.invoke(this.f34597a, parameters);
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        Preconditions.checkNotNull(methodName);
        Preconditions.checkNotNull(parameterTypes);
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean classFound(String className) {
        Preconditions.checkNotNull(className);
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static <T> T instantiateClassWithEmptyConstructor(String className, Class<? extends T> superclass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NullPointerException {
        Preconditions.checkNotNull(className);
        Preconditions.checkNotNull(superclass);
        Constructor<? extends T> constructor = Class.forName(className).asSubclass(superclass).getDeclaredConstructor(null);
        constructor.setAccessible(true);
        return constructor.newInstance(new Object[0]);
    }

    public static <T> T instantiateClassWithConstructor(String className, Class<? extends T> superClass, Class[] classes, Object[] parameters) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Preconditions.checkNotNull(className);
        Preconditions.checkNotNull(superClass);
        Preconditions.checkNotNull(classes);
        Preconditions.checkNotNull(parameters);
        Constructor<? extends T> constructor = Class.forName(className).asSubclass(superClass).getDeclaredConstructor(classes);
        constructor.setAccessible(true);
        return constructor.newInstance(parameters);
    }

    public static Field getPrivateField(Class classType, String fieldName) throws NoSuchFieldException {
        Field declaredField = classType.getDeclaredField(fieldName);
        declaredField.setAccessible(true);
        return declaredField;
    }
}
