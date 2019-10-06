package p026rx.p390c.p395e.p397b;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: rx.c.e.b.G */
/* compiled from: UnsafeAccess */
public final class C14839G {

    /* renamed from: a */
    public static final Unsafe f44131a;

    /* renamed from: b */
    private static final boolean f44132b = (System.getProperty("rx.unsafe-disable") != null);

    static {
        Unsafe u = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            u = (Unsafe) field.get(null);
        } catch (Throwable th) {
        }
        f44131a = u;
    }

    /* renamed from: a */
    public static boolean m46555a() {
        return f44131a != null && !f44132b;
    }

    /* renamed from: a */
    public static long m46554a(Class<?> clazz, String fieldName) {
        try {
            return f44131a.objectFieldOffset(clazz.getDeclaredField(fieldName));
        } catch (NoSuchFieldException ex) {
            InternalError ie = new InternalError();
            ie.initCause(ex);
            throw ie;
        }
    }
}
