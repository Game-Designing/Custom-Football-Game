package p362h;

import java.nio.charset.Charset;

/* renamed from: h.E */
/* compiled from: Util */
final class C14183E {

    /* renamed from: a */
    public static final Charset f43062a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static void m45554a(long size, long offset, long byteCount) {
        if ((offset | byteCount) < 0 || offset > size || size - offset < byteCount) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(size), Long.valueOf(offset), Long.valueOf(byteCount)}));
        }
    }

    /* renamed from: a */
    public static short m45553a(short s) {
        int i = 65535 & s;
        return (short) (((65280 & i) >>> 8) | ((i & 255) << 8));
    }

    /* renamed from: a */
    public static int m45552a(int i) {
        return ((-16777216 & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8) | ((i & 255) << 24);
    }

    /* renamed from: a */
    public static void m45555a(Throwable t) {
        m45557b(t);
        throw null;
    }

    /* renamed from: b */
    private static <T extends Throwable> void m45557b(Throwable t) throws Throwable {
        throw t;
    }

    /* renamed from: a */
    public static boolean m45556a(byte[] a, int aOffset, byte[] b, int bOffset, int byteCount) {
        for (int i = 0; i < byteCount; i++) {
            if (a[i + aOffset] != b[i + bOffset]) {
                return false;
            }
        }
        return true;
    }
}
