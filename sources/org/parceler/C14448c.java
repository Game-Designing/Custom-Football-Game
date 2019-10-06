package org.parceler;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/* renamed from: org.parceler.c */
/* compiled from: InjectionUtil */
public final class C14448c {

    /* renamed from: org.parceler.c$a */
    /* compiled from: InjectionUtil */
    private static abstract class C14449a<T, E extends AccessibleObject> implements PrivilegedExceptionAction<T> {

        /* renamed from: a */
        private final E f43282a;

        /* renamed from: a */
        public abstract T mo45551a(E e) throws Exception;

        protected C14449a(E accessible) {
            this.f43282a = accessible;
        }

        public T run() throws Exception {
            boolean previous = this.f43282a.isAccessible();
            this.f43282a.setAccessible(true);
            T output = mo45551a(this.f43282a);
            this.f43282a.setAccessible(previous);
            return output;
        }
    }

    /* renamed from: org.parceler.c$b */
    /* compiled from: InjectionUtil */
    private static final class C14450b<T> extends C14449a<T, Field> {

        /* renamed from: b */
        private final Object f43283b;

        private C14450b(Field classField, Object target) {
            super(classField);
            this.f43283b = target;
        }

        /* renamed from: a */
        public T mo45551a(Field classField) throws IllegalAccessException {
            return classField.get(this.f43283b);
        }
    }

    /* renamed from: org.parceler.c$c */
    /* compiled from: InjectionUtil */
    private static final class C14451c extends C14449a<Void, Field> {

        /* renamed from: b */
        private final Object f43284b;

        /* renamed from: c */
        private final Object f43285c;

        private C14451c(Field classField, Object target, Object value) {
            super(classField);
            this.f43284b = target;
            this.f43285c = value;
        }

        /* renamed from: a */
        public Void mo45551a(Field classField) throws IllegalAccessException {
            classField.set(this.f43284b, this.f43285c);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m46062a(Class<T> cls, Class<?> targetClass, Object target, String field) {
        try {
            return AccessController.doPrivileged(new C14450b(targetClass.getDeclaredField(field), target));
        } catch (NoSuchFieldException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("NoSuchFieldException Exception during field injection: ");
            sb.append(field);
            sb.append(" in ");
            sb.append(target.getClass());
            throw new ParcelerRuntimeException(sb.toString(), e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }

    /* renamed from: a */
    public static void m46063a(Class<?> targetClass, Object target, String field, Object value) {
        try {
            AccessController.doPrivileged(new C14451c(targetClass.getDeclaredField(field), target, value));
        } catch (NoSuchFieldException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("NoSuchFieldException Exception during field injection: ");
            sb.append(field);
            sb.append(" in ");
            sb.append(target.getClass());
            throw new ParcelerRuntimeException(sb.toString(), e);
        } catch (PrivilegedActionException e2) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", e2);
        } catch (Exception e3) {
            throw new ParcelerRuntimeException("Exception during field injection", e3);
        }
    }
}
