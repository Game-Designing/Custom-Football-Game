package p320f.p321a.p327d.p329b;

import p320f.p321a.p326c.C13202d;

/* renamed from: f.a.d.b.b */
/* compiled from: ObjectHelper */
public final class C13264b {

    /* renamed from: a */
    static final C13202d<Object, Object> f40353a = new C13265a();

    /* renamed from: f.a.d.b.b$a */
    /* compiled from: ObjectHelper */
    static final class C13265a implements C13202d<Object, Object> {
        C13265a() {
        }

        public boolean test(Object o1, Object o2) {
            return C13264b.m43227a(o1, o2);
        }
    }

    /* renamed from: a */
    public static <T> T m43226a(T object, String message) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException(message);
    }

    /* renamed from: a */
    public static boolean m43227a(Object o1, Object o2) {
        return o1 == o2 || (o1 != null && o1.equals(o2));
    }

    /* renamed from: a */
    public static int m43221a(int v1, int v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m43223a(long v1, long v2) {
        if (v1 < v2) {
            return -1;
        }
        return v1 > v2 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> C13202d<T, T> m43225a() {
        return f40353a;
    }

    /* renamed from: a */
    public static int m43222a(int value, String paramName) {
        if (value > 0) {
            return value;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(paramName);
        sb.append(" > 0 required but it was ");
        sb.append(value);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public static long m43224a(long value, String paramName) {
        if (value > 0) {
            return value;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(paramName);
        sb.append(" > 0 required but it was ");
        sb.append(value);
        throw new IllegalArgumentException(sb.toString());
    }
}
