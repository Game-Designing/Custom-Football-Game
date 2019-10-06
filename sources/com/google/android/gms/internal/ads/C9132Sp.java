package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.runtime.AgentOptions;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.ads.Sp */
final class C9132Sp {

    /* renamed from: a */
    private static final Logger f21713a = Logger.getLogger(C9132Sp.class.getName());

    /* renamed from: b */
    private static final Unsafe f21714b = m23002d();

    /* renamed from: c */
    private static final Class<?> f21715c = C9587mo.m23885b();

    /* renamed from: d */
    private static final boolean f21716d = m23005d(Long.TYPE);

    /* renamed from: e */
    private static final boolean f21717e = m23005d(Integer.TYPE);

    /* renamed from: f */
    private static final C9136d f21718f;

    /* renamed from: g */
    private static final boolean f21719g = m23012g();

    /* renamed from: h */
    private static final boolean f21720h = m23010f();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final long f21721i = ((long) m22991b(byte[].class));

    /* renamed from: j */
    private static final long f21722j = ((long) m22991b(boolean[].class));

    /* renamed from: k */
    private static final long f21723k = ((long) m22996c(boolean[].class));

    /* renamed from: l */
    private static final long f21724l = ((long) m22991b(int[].class));

    /* renamed from: m */
    private static final long f21725m = ((long) m22996c(int[].class));

    /* renamed from: n */
    private static final long f21726n = ((long) m22991b(long[].class));

    /* renamed from: o */
    private static final long f21727o = ((long) m22996c(long[].class));

    /* renamed from: p */
    private static final long f21728p = ((long) m22991b(float[].class));

    /* renamed from: q */
    private static final long f21729q = ((long) m22996c(float[].class));

    /* renamed from: r */
    private static final long f21730r = ((long) m22991b(double[].class));

    /* renamed from: s */
    private static final long f21731s = ((long) m22996c(double[].class));

    /* renamed from: t */
    private static final long f21732t = ((long) m22991b(Object[].class));

    /* renamed from: u */
    private static final long f21733u = ((long) m22996c(Object[].class));

    /* renamed from: v */
    private static final long f21734v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final boolean f21735w = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    /* renamed from: com.google.android.gms.internal.ads.Sp$a */
    static final class C9133a extends C9136d {
        C9133a(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo28592a(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        /* renamed from: f */
        public final byte mo28601f(Object obj, long j) {
            if (C9132Sp.f21735w) {
                return C9132Sp.m23017k(obj, j);
            }
            return C9132Sp.m23018l(obj, j);
        }

        /* renamed from: a */
        public final void mo28593a(Object obj, long j, byte b) {
            if (C9132Sp.f21735w) {
                C9132Sp.m22997c(obj, j, b);
            } else {
                C9132Sp.m23003d(obj, j, b);
            }
        }

        /* renamed from: c */
        public final boolean mo28598c(Object obj, long j) {
            if (C9132Sp.f21735w) {
                return C9132Sp.m23019m(obj, j);
            }
            return C9132Sp.m23020n(obj, j);
        }

        /* renamed from: a */
        public final void mo28596a(Object obj, long j, boolean z) {
            if (C9132Sp.f21735w) {
                C9132Sp.m23004d(obj, j, z);
            } else {
                C9132Sp.m23008e(obj, j, z);
            }
        }

        /* renamed from: d */
        public final float mo28599d(Object obj, long j) {
            return Float.intBitsToFloat(mo28602a(obj, j));
        }

        /* renamed from: a */
        public final void mo28595a(Object obj, long j, float f) {
            mo28603a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: e */
        public final double mo28600e(Object obj, long j) {
            return Double.longBitsToDouble(mo28605b(obj, j));
        }

        /* renamed from: a */
        public final void mo28594a(Object obj, long j, double d) {
            mo28604a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo28597a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.Sp$b */
    static final class C9134b extends C9136d {
        C9134b(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo28592a(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        /* renamed from: f */
        public final byte mo28601f(Object obj, long j) {
            if (C9132Sp.f21735w) {
                return C9132Sp.m23017k(obj, j);
            }
            return C9132Sp.m23018l(obj, j);
        }

        /* renamed from: a */
        public final void mo28593a(Object obj, long j, byte b) {
            if (C9132Sp.f21735w) {
                C9132Sp.m22997c(obj, j, b);
            } else {
                C9132Sp.m23003d(obj, j, b);
            }
        }

        /* renamed from: c */
        public final boolean mo28598c(Object obj, long j) {
            if (C9132Sp.f21735w) {
                return C9132Sp.m23019m(obj, j);
            }
            return C9132Sp.m23020n(obj, j);
        }

        /* renamed from: a */
        public final void mo28596a(Object obj, long j, boolean z) {
            if (C9132Sp.f21735w) {
                C9132Sp.m23004d(obj, j, z);
            } else {
                C9132Sp.m23008e(obj, j, z);
            }
        }

        /* renamed from: d */
        public final float mo28599d(Object obj, long j) {
            return Float.intBitsToFloat(mo28602a(obj, j));
        }

        /* renamed from: a */
        public final void mo28595a(Object obj, long j, float f) {
            mo28603a(obj, j, Float.floatToIntBits(f));
        }

        /* renamed from: e */
        public final double mo28600e(Object obj, long j) {
            return Double.longBitsToDouble(mo28605b(obj, j));
        }

        /* renamed from: a */
        public final void mo28594a(Object obj, long j, double d) {
            mo28604a(obj, j, Double.doubleToLongBits(d));
        }

        /* renamed from: a */
        public final void mo28597a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.Sp$c */
    static final class C9135c extends C9136d {
        C9135c(Unsafe unsafe) {
            super(unsafe);
        }

        /* renamed from: a */
        public final void mo28592a(long j, byte b) {
            this.f21736a.putByte(j, b);
        }

        /* renamed from: f */
        public final byte mo28601f(Object obj, long j) {
            return this.f21736a.getByte(obj, j);
        }

        /* renamed from: a */
        public final void mo28593a(Object obj, long j, byte b) {
            this.f21736a.putByte(obj, j, b);
        }

        /* renamed from: c */
        public final boolean mo28598c(Object obj, long j) {
            return this.f21736a.getBoolean(obj, j);
        }

        /* renamed from: a */
        public final void mo28596a(Object obj, long j, boolean z) {
            this.f21736a.putBoolean(obj, j, z);
        }

        /* renamed from: d */
        public final float mo28599d(Object obj, long j) {
            return this.f21736a.getFloat(obj, j);
        }

        /* renamed from: a */
        public final void mo28595a(Object obj, long j, float f) {
            this.f21736a.putFloat(obj, j, f);
        }

        /* renamed from: e */
        public final double mo28600e(Object obj, long j) {
            return this.f21736a.getDouble(obj, j);
        }

        /* renamed from: a */
        public final void mo28594a(Object obj, long j, double d) {
            this.f21736a.putDouble(obj, j, d);
        }

        /* renamed from: a */
        public final void mo28597a(byte[] bArr, long j, long j2, long j3) {
            this.f21736a.copyMemory(bArr, C9132Sp.f21721i + j, null, j2, j3);
        }
    }

    /* renamed from: com.google.android.gms.internal.ads.Sp$d */
    static abstract class C9136d {

        /* renamed from: a */
        Unsafe f21736a;

        C9136d(Unsafe unsafe) {
            this.f21736a = unsafe;
        }

        /* renamed from: a */
        public abstract void mo28592a(long j, byte b);

        /* renamed from: a */
        public abstract void mo28593a(Object obj, long j, byte b);

        /* renamed from: a */
        public abstract void mo28594a(Object obj, long j, double d);

        /* renamed from: a */
        public abstract void mo28595a(Object obj, long j, float f);

        /* renamed from: a */
        public abstract void mo28596a(Object obj, long j, boolean z);

        /* renamed from: a */
        public abstract void mo28597a(byte[] bArr, long j, long j2, long j3);

        /* renamed from: c */
        public abstract boolean mo28598c(Object obj, long j);

        /* renamed from: d */
        public abstract float mo28599d(Object obj, long j);

        /* renamed from: e */
        public abstract double mo28600e(Object obj, long j);

        /* renamed from: f */
        public abstract byte mo28601f(Object obj, long j);

        /* renamed from: a */
        public final int mo28602a(Object obj, long j) {
            return this.f21736a.getInt(obj, j);
        }

        /* renamed from: a */
        public final void mo28603a(Object obj, long j, int i) {
            this.f21736a.putInt(obj, j, i);
        }

        /* renamed from: b */
        public final long mo28605b(Object obj, long j) {
            return this.f21736a.getLong(obj, j);
        }

        /* renamed from: a */
        public final void mo28604a(Object obj, long j, long j2) {
            this.f21736a.putLong(obj, j, j2);
        }
    }

    private C9132Sp() {
    }

    /* renamed from: b */
    static boolean m22995b() {
        return f21720h;
    }

    /* renamed from: c */
    static boolean m22999c() {
        return f21719g;
    }

    /* renamed from: a */
    static <T> T m22978a(Class<T> cls) {
        try {
            return f21714b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private static int m22991b(Class<?> cls) {
        if (f21720h) {
            return f21718f.f21736a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: c */
    private static int m22996c(Class<?> cls) {
        if (f21720h) {
            return f21718f.f21736a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: a */
    static int m22976a(Object obj, long j) {
        return f21718f.mo28602a(obj, j);
    }

    /* renamed from: a */
    static void m22984a(Object obj, long j, int i) {
        f21718f.mo28603a(obj, j, i);
    }

    /* renamed from: b */
    static long m22992b(Object obj, long j) {
        return f21718f.mo28605b(obj, j);
    }

    /* renamed from: a */
    static void m22985a(Object obj, long j, long j2) {
        f21718f.mo28604a(obj, j, j2);
    }

    /* renamed from: c */
    static boolean m23000c(Object obj, long j) {
        return f21718f.mo28598c(obj, j);
    }

    /* renamed from: a */
    static void m22987a(Object obj, long j, boolean z) {
        f21718f.mo28596a(obj, j, z);
    }

    /* renamed from: d */
    static float m23001d(Object obj, long j) {
        return f21718f.mo28599d(obj, j);
    }

    /* renamed from: a */
    static void m22983a(Object obj, long j, float f) {
        f21718f.mo28595a(obj, j, f);
    }

    /* renamed from: e */
    static double m23006e(Object obj, long j) {
        return f21718f.mo28600e(obj, j);
    }

    /* renamed from: a */
    static void m22982a(Object obj, long j, double d) {
        f21718f.mo28594a(obj, j, d);
    }

    /* renamed from: f */
    static Object m23009f(Object obj, long j) {
        return f21718f.f21736a.getObject(obj, j);
    }

    /* renamed from: a */
    static void m22986a(Object obj, long j, Object obj2) {
        f21718f.f21736a.putObject(obj, j, obj2);
    }

    /* renamed from: a */
    static byte m22975a(byte[] bArr, long j) {
        return f21718f.mo28601f(bArr, f21721i + j);
    }

    /* renamed from: a */
    static void m22988a(byte[] bArr, long j, byte b) {
        f21718f.mo28593a((Object) bArr, f21721i + j, b);
    }

    /* renamed from: a */
    static void m22989a(byte[] bArr, long j, long j2, long j3) {
        f21718f.mo28597a(bArr, j, j2, j3);
    }

    /* renamed from: a */
    static void m22980a(long j, byte b) {
        f21718f.mo28592a(j, b);
    }

    /* renamed from: a */
    static long m22977a(ByteBuffer byteBuffer) {
        return f21718f.mo28605b(byteBuffer, f21734v);
    }

    /* renamed from: d */
    static Unsafe m23002d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C9178Up());
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: f */
    private static boolean m23010f() {
        Unsafe unsafe = f21714b;
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
            if (C9587mo.m23884a()) {
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
            Logger logger = f21713a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: g */
    private static boolean m23012g() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = f21714b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (m23014h() == null) {
                return false;
            }
            if (C9587mo.m23884a()) {
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
            Logger logger = f21713a;
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
    private static boolean m23005d(Class<?> cls) {
        if (!C9587mo.m23884a()) {
            return false;
        }
        try {
            Class<?> cls2 = f21715c;
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

    /* renamed from: h */
    private static Field m23014h() {
        if (C9587mo.m23884a()) {
            Field a = m22979a(Buffer.class, "effectiveDirectAddress");
            if (a != null) {
                return a;
            }
        }
        Field a2 = m22979a(Buffer.class, AgentOptions.ADDRESS);
        if (a2 == null || a2.getType() != Long.TYPE) {
            return null;
        }
        return a2;
    }

    /* renamed from: a */
    private static Field m22979a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static byte m23017k(Object obj, long j) {
        return (byte) (m22976a(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static byte m23018l(Object obj, long j) {
        return (byte) (m22976a(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m22997c(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        m22984a(obj, j2, ((255 & b) << i) | (m22976a(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m23003d(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        m22984a(obj, j2, ((255 & b) << i) | (m22976a(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static boolean m23019m(Object obj, long j) {
        return m23017k(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public static boolean m23020n(Object obj, long j) {
        return m23018l(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m23004d(Object obj, long j, boolean z) {
        m22997c(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static void m23008e(Object obj, long j, boolean z) {
        m23003d(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f7  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.Sp> r0 = com.google.android.gms.internal.ads.C9132Sp.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            f21713a = r0
            sun.misc.Unsafe r0 = m23002d()
            f21714b = r0
            java.lang.Class r0 = com.google.android.gms.internal.ads.C9587mo.m23885b()
            f21715c = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = m23005d(r0)
            f21716d = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = m23005d(r0)
            f21717e = r0
            sun.misc.Unsafe r0 = f21714b
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.ads.C9587mo.m23884a()
            if (r0 == 0) goto L_0x004d
            boolean r0 = f21716d
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.ads.Sp$b r1 = new com.google.android.gms.internal.ads.Sp$b
            sun.misc.Unsafe r0 = f21714b
            r1.<init>(r0)
            goto L_0x0054
        L_0x0040:
            boolean r0 = f21717e
            if (r0 == 0) goto L_0x004c
            com.google.android.gms.internal.ads.Sp$a r1 = new com.google.android.gms.internal.ads.Sp$a
            sun.misc.Unsafe r0 = f21714b
            r1.<init>(r0)
            goto L_0x0054
        L_0x004c:
            goto L_0x0054
        L_0x004d:
            com.google.android.gms.internal.ads.Sp$c r1 = new com.google.android.gms.internal.ads.Sp$c
            sun.misc.Unsafe r0 = f21714b
            r1.<init>(r0)
        L_0x0054:
            f21718f = r1
            boolean r0 = m23012g()
            f21719g = r0
            boolean r0 = m23010f()
            f21720h = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21721i = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21722j = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21723k = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21724l = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21725m = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21726n = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21727o = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21728p = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21729q = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21730r = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21731s = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = m22991b(r0)
            long r0 = (long) r0
            f21732t = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = m22996c(r0)
            long r0 = (long) r0
            f21733u = r0
            java.lang.reflect.Field r0 = m23014h()
            if (r0 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.Sp$d r1 = f21718f
            if (r1 != 0) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            sun.misc.Unsafe r1 = r1.f21736a
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00eb
        L_0x00e9:
            r0 = -1
        L_0x00eb:
            f21734v = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            f21735w = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9132Sp.<clinit>():void");
    }
}
