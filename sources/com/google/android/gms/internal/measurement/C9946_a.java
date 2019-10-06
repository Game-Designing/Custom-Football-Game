package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement._a */
final class C9946_a {

    /* renamed from: a */
    private static final Logger f30052a = Logger.getLogger(C9946_a.class.getName());

    /* renamed from: b */
    private static final Unsafe f30053b = m32009d();

    /* renamed from: c */
    private static final Class<?> f30054c = C9905F.m31780b();

    /* renamed from: d */
    private static final boolean f30055d = m32012d(Long.TYPE);

    /* renamed from: e */
    private static final boolean f30056e = m32012d(Integer.TYPE);

    /* renamed from: f */
    private static final C9950d f30057f;

    /* renamed from: g */
    private static final boolean f30058g = m32017f();

    /* renamed from: h */
    private static final boolean f30059h = m32015e();

    /* renamed from: i */
    private static final long f30060i = ((long) m31998b(byte[].class));

    /* renamed from: j */
    private static final long f30061j = ((long) m31998b(boolean[].class));

    /* renamed from: k */
    private static final long f30062k = ((long) m32003c(boolean[].class));

    /* renamed from: l */
    private static final long f30063l = ((long) m31998b(int[].class));

    /* renamed from: m */
    private static final long f30064m = ((long) m32003c(int[].class));

    /* renamed from: n */
    private static final long f30065n = ((long) m31998b(long[].class));

    /* renamed from: o */
    private static final long f30066o = ((long) m32003c(long[].class));

    /* renamed from: p */
    private static final long f30067p = ((long) m31998b(float[].class));

    /* renamed from: q */
    private static final long f30068q = ((long) m32003c(float[].class));

    /* renamed from: r */
    private static final long f30069r = ((long) m31998b(double[].class));

    /* renamed from: s */
    private static final long f30070s = ((long) m32003c(double[].class));

    /* renamed from: t */
    private static final long f30071t = ((long) m31998b(Object[].class));

    /* renamed from: u */
    private static final long f30072u = ((long) m32003c(Object[].class));

    /* renamed from: v */
    private static final long f30073v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final boolean f30074w = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.android.gms.internal.measurement._a$a */
    static final class C9947a extends C9950d {
        C9947a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: f */
        public final byte mo32706f(Object obj, long j) {
            if (C9946_a.f30074w) {
                return C9946_a.m32023k(obj, j);
            }
            return C9946_a.m32024l(obj, j);
        }

        /* renamed from: a */
        public final void mo32699a(Object obj, long j, byte b) {
            if (C9946_a.f30074w) {
                C9946_a.m32004c(obj, j, b);
            } else {
                C9946_a.m32010d(obj, j, b);
            }
        }

        /* renamed from: c */
        public final boolean mo32703c(Object obj, long j) {
            if (C9946_a.f30074w) {
                return C9946_a.m32025m(obj, j);
            }
            return C9946_a.m32026n(obj, j);
        }

        /* renamed from: a */
        public final void mo32702a(Object obj, long j, boolean z) {
            if (C9946_a.f30074w) {
                C9946_a.m32011d(obj, j, z);
            } else {
                C9946_a.m32014e(obj, j, z);
            }
        }

        /* renamed from: d */
        public final float mo32704d(Object obj, long j) {
            return Float.intBitsToFloat(mo32707a(obj, j));
        }

        /* renamed from: a */
        public final void mo32701a(Object obj, long j, float f) {
            mo32708a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: e */
        public final double mo32705e(Object obj, long j) {
            return Double.longBitsToDouble(mo32710b(obj, j));
        }

        /* renamed from: a */
        public final void mo32700a(Object obj, long j, double d) {
            mo32709a(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement._a$b */
    static final class C9948b extends C9950d {
        C9948b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: f */
        public final byte mo32706f(Object obj, long j) {
            if (C9946_a.f30074w) {
                return C9946_a.m32023k(obj, j);
            }
            return C9946_a.m32024l(obj, j);
        }

        /* renamed from: a */
        public final void mo32699a(Object obj, long j, byte b) {
            if (C9946_a.f30074w) {
                C9946_a.m32004c(obj, j, b);
            } else {
                C9946_a.m32010d(obj, j, b);
            }
        }

        /* renamed from: c */
        public final boolean mo32703c(Object obj, long j) {
            if (C9946_a.f30074w) {
                return C9946_a.m32025m(obj, j);
            }
            return C9946_a.m32026n(obj, j);
        }

        /* renamed from: a */
        public final void mo32702a(Object obj, long j, boolean z) {
            if (C9946_a.f30074w) {
                C9946_a.m32011d(obj, j, z);
            } else {
                C9946_a.m32014e(obj, j, z);
            }
        }

        /* renamed from: d */
        public final float mo32704d(Object obj, long j) {
            return Float.intBitsToFloat(mo32707a(obj, j));
        }

        /* renamed from: a */
        public final void mo32701a(Object obj, long j, float f) {
            mo32708a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: e */
        public final double mo32705e(Object obj, long j) {
            return Double.longBitsToDouble(mo32710b(obj, j));
        }

        /* renamed from: a */
        public final void mo32700a(Object obj, long j, double d) {
            mo32709a(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement._a$c */
    static final class C9949c extends C9950d {
        C9949c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: f */
        public final byte mo32706f(Object obj, long j) {
            return this.f30075a.getByte(obj, j);
        }

        /* renamed from: a */
        public final void mo32699a(Object obj, long j, byte b) {
            this.f30075a.putByte(obj, j, b);
        }

        /* renamed from: c */
        public final boolean mo32703c(Object obj, long j) {
            return this.f30075a.getBoolean(obj, j);
        }

        /* renamed from: a */
        public final void mo32702a(Object obj, long j, boolean z) {
            this.f30075a.putBoolean(obj, j, z);
        }

        /* renamed from: d */
        public final float mo32704d(Object obj, long j) {
            return this.f30075a.getFloat(obj, j);
        }

        /* renamed from: a */
        public final void mo32701a(Object obj, long j, float f) {
            this.f30075a.putFloat(obj, j, f);
        }

        /* renamed from: e */
        public final double mo32705e(Object obj, long j) {
            return this.f30075a.getDouble(obj, j);
        }

        /* renamed from: a */
        public final void mo32700a(Object obj, long j, double d) {
            this.f30075a.putDouble(obj, j, d);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement._a$d */
    static abstract class C9950d {

        /* renamed from: a */
        Unsafe f30075a;

        C9950d(Unsafe unsafe) {
            this.f30075a = unsafe;
        }

        /* renamed from: a */
        public abstract void mo32699a(Object obj, long j, byte b);

        /* renamed from: a */
        public abstract void mo32700a(Object obj, long j, double d);

        /* renamed from: a */
        public abstract void mo32701a(Object obj, long j, float f);

        /* renamed from: a */
        public abstract void mo32702a(Object obj, long j, boolean z);

        /* renamed from: c */
        public abstract boolean mo32703c(Object obj, long j);

        /* renamed from: d */
        public abstract float mo32704d(Object obj, long j);

        /* renamed from: e */
        public abstract double mo32705e(Object obj, long j);

        /* renamed from: f */
        public abstract byte mo32706f(Object obj, long j);

        /* renamed from: a */
        public final int mo32707a(Object obj, long j) {
            return this.f30075a.getInt(obj, j);
        }

        /* renamed from: a */
        public final void mo32708a(Object obj, long j, int i) {
            this.f30075a.putInt(obj, j, i);
        }

        /* renamed from: b */
        public final long mo32710b(Object obj, long j) {
            return this.f30075a.getLong(obj, j);
        }

        /* renamed from: a */
        public final void mo32709a(Object obj, long j, long j2) {
            this.f30075a.putLong(obj, j, j2);
        }
    }

    private C9946_a() {
    }

    /* renamed from: b */
    static boolean m32002b() {
        return f30059h;
    }

    /* renamed from: c */
    static boolean m32006c() {
        return f30058g;
    }

    /* renamed from: a */
    static <T> T m31987a(Class<T> cls) {
        try {
            return f30053b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private static int m31998b(Class<?> cls) {
        if (f30059h) {
            return f30057f.f30075a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: c */
    private static int m32003c(Class<?> cls) {
        if (f30059h) {
            return f30057f.f30075a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: a */
    static int m31986a(Object obj, long j) {
        return f30057f.mo32707a(obj, j);
    }

    /* renamed from: a */
    static void m31992a(Object obj, long j, int i) {
        f30057f.mo32708a(obj, j, i);
    }

    /* renamed from: b */
    static long m31999b(Object obj, long j) {
        return f30057f.mo32710b(obj, j);
    }

    /* renamed from: a */
    static void m31993a(Object obj, long j, long j2) {
        f30057f.mo32709a(obj, j, j2);
    }

    /* renamed from: c */
    static boolean m32007c(Object obj, long j) {
        return f30057f.mo32703c(obj, j);
    }

    /* renamed from: a */
    static void m31995a(Object obj, long j, boolean z) {
        f30057f.mo32702a(obj, j, z);
    }

    /* renamed from: d */
    static float m32008d(Object obj, long j) {
        return f30057f.mo32704d(obj, j);
    }

    /* renamed from: a */
    static void m31991a(Object obj, long j, float f) {
        f30057f.mo32701a(obj, j, f);
    }

    /* renamed from: e */
    static double m32013e(Object obj, long j) {
        return f30057f.mo32705e(obj, j);
    }

    /* renamed from: a */
    static void m31990a(Object obj, long j, double d) {
        f30057f.mo32700a(obj, j, d);
    }

    /* renamed from: f */
    static Object m32016f(Object obj, long j) {
        return f30057f.f30075a.getObject(obj, j);
    }

    /* renamed from: a */
    static void m31994a(Object obj, long j, Object obj2) {
        f30057f.f30075a.putObject(obj, j, obj2);
    }

    /* renamed from: a */
    static byte m31985a(byte[] bArr, long j) {
        return f30057f.mo32706f(bArr, f30060i + j);
    }

    /* renamed from: a */
    static void m31996a(byte[] bArr, long j, byte b) {
        f30057f.mo32699a((Object) bArr, f30060i + j, b);
    }

    /* renamed from: d */
    static Unsafe m32009d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C9953ab());
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: e */
    private static boolean m32015e() {
        Unsafe unsafe = f30053b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (C9905F.m31779a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f30052a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: f */
    private static boolean m32017f() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = f30053b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (m32019g() == null) {
                return false;
            }
            if (C9905F.m31779a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str2, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f30052a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m32012d(Class<?> cls) {
        if (!C9905F.m31779a()) {
            return false;
        }
        try {
            Class<?> cls2 = f30054c;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: g */
    private static Field m32019g() {
        if (C9905F.m31779a()) {
            Field a = m31988a(Buffer.class, "effectiveDirectAddress");
            if (a != null) {
                return a;
            }
        }
        Field a2 = m31988a(Buffer.class, AgentOptions.ADDRESS);
        if (a2 == null || a2.getType() != Long.TYPE) {
            return null;
        }
        return a2;
    }

    /* renamed from: a */
    private static Field m31988a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static byte m32023k(Object obj, long j) {
        return (byte) (m31986a(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static byte m32024l(Object obj, long j) {
        return (byte) (m31986a(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m32004c(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        m31992a(obj, j2, ((255 & b) << i) | (m31986a(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m32010d(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m31992a(obj, j2, ((255 & b) << i) | (m31986a(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static boolean m32025m(Object obj, long j) {
        return m32023k(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static boolean m32026n(Object obj, long j) {
        return m32024l(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m32011d(Object obj, long j, boolean z) {
        m32004c(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m32014e(Object obj, long j, boolean z) {
        m32010d(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f7  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement._a> r0 = com.google.android.gms.internal.measurement.C9946_a.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f30052a = r0
            sun.misc.Unsafe r0 = m32009d()
            f30053b = r0
            java.lang.Class r0 = com.google.android.gms.internal.measurement.C9905F.m31780b()
            f30054c = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = m32012d(r0)
            f30055d = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = m32012d(r0)
            f30056e = r0
            sun.misc.Unsafe r0 = f30053b
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.measurement.C9905F.m31779a()
            if (r0 == 0) goto L_0x004d
            boolean r0 = f30055d
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.measurement._a$b r1 = new com.google.android.gms.internal.measurement._a$b
            sun.misc.Unsafe r0 = f30053b
            r1.<init>(r0)
            goto L_0x0054
        L_0x0040:
            boolean r0 = f30056e
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement._a$a r1 = new com.google.android.gms.internal.measurement._a$a
            sun.misc.Unsafe r0 = f30053b
            r1.<init>(r0)
            goto L_0x0054
        L_0x004c:
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.measurement._a$c r1 = new com.google.android.gms.internal.measurement._a$c
            sun.misc.Unsafe r0 = f30053b
            r1.<init>(r0)
        L_0x0054:
            f30057f = r1
            boolean r0 = m32017f()
            f30058g = r0
            boolean r0 = m32015e()
            f30059h = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30060i = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30061j = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30062k = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30063l = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30064m = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30065n = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30066o = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30067p = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30068q = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30069r = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30070s = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = m31998b(r0)
            long r0 = (long) r0
            f30071t = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = m32003c(r0)
            long r0 = (long) r0
            f30072u = r0
            java.lang.reflect.Field r0 = m32019g()
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.measurement._a$d r1 = f30057f
            if (r1 != 0) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            sun.misc.Unsafe r1 = r1.f30075a
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00eb
        L_0x00e9:
            r0 = -1
        L_0x00eb:
            f30073v = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            f30074w = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C9946_a.<clinit>():void");
    }
}
