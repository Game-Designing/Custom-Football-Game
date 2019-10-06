package p026rx.exceptions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import p026rx.p400f.C14953x;

/* renamed from: rx.exceptions.OnErrorThrowable */
public final class OnErrorThrowable extends RuntimeException {

    /* renamed from: rx.exceptions.OnErrorThrowable$OnNextValue */
    public static class OnNextValue extends RuntimeException {

        /* renamed from: a */
        private final Object f44246a;

        /* renamed from: rx.exceptions.OnErrorThrowable$OnNextValue$a */
        static final class C14926a {

            /* renamed from: a */
            static final Set<Class<?>> f44247a = m46669a();

            /* renamed from: a */
            private static Set<Class<?>> m46669a() {
                Set<Class<?>> set = new HashSet<>();
                set.add(Boolean.class);
                set.add(Character.class);
                set.add(Byte.class);
                set.add(Short.class);
                set.add(Integer.class);
                set.add(Long.class);
                set.add(Float.class);
                set.add(Double.class);
                return set;
            }
        }

        public OnNextValue(Object value) {
            Object v;
            StringBuilder sb = new StringBuilder();
            sb.append("OnError while emitting onNext value: ");
            sb.append(m46667a(value));
            super(sb.toString());
            if (value instanceof Serializable) {
                v = value;
            } else {
                try {
                    v = String.valueOf(value);
                } catch (Throwable ex) {
                    v = ex.getMessage();
                }
            }
            this.f44246a = v;
        }

        /* renamed from: a */
        public Object mo46133a() {
            return this.f44246a;
        }

        /* renamed from: a */
        static String m46667a(Object value) {
            if (value == null) {
                return "null";
            }
            if (C14926a.f44247a.contains(value.getClass())) {
                return value.toString();
            }
            if (value instanceof String) {
                return (String) value;
            }
            if (value instanceof Enum) {
                return ((Enum) value).name();
            }
            String pluggedRendering = C14953x.m46727c().mo46162b().mo46138a(value);
            if (pluggedRendering != null) {
                return pluggedRendering;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(value.getClass().getName());
            sb.append(".class");
            return sb.toString();
        }
    }

    /* renamed from: a */
    public static Throwable m46666a(Throwable e, Object value) {
        if (e == null) {
            e = new NullPointerException();
        }
        Throwable lastCause = C14927a.m46670a(e);
        if ((lastCause instanceof OnNextValue) && ((OnNextValue) lastCause).mo46133a() == value) {
            return e;
        }
        C14927a.m46671a(e, (Throwable) new OnNextValue(value));
        return e;
    }
}
