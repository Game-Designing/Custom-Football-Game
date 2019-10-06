package com.bumptech.glide.p107h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.bumptech.glide.load.p111b.C6124r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.h.k */
/* compiled from: Util */
public final class C6026k {

    /* renamed from: a */
    private static final char[] f10665a = "0123456789abcdef".toCharArray();

    /* renamed from: b */
    private static final char[] f10666b = new char[64];

    /* renamed from: a */
    public static String m11277a(byte[] bytes) {
        String a;
        synchronized (f10666b) {
            a = m11278a(bytes, f10666b);
        }
        return a;
    }

    /* renamed from: a */
    private static String m11278a(byte[] bytes, char[] hexChars) {
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 255;
            int i = j * 2;
            char[] cArr = f10665a;
            hexChars[i] = cArr[v >>> 4];
            hexChars[(j * 2) + 1] = cArr[v & 15];
        }
        return new String(hexChars);
    }

    @TargetApi(19)
    /* renamed from: a */
    public static int m11274a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException e) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot obtain size for recycled Bitmap: ");
        sb.append(bitmap);
        sb.append("[");
        sb.append(bitmap.getWidth());
        sb.append("x");
        sb.append(bitmap.getHeight());
        sb.append("] ");
        sb.append(bitmap.getConfig());
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public static int m11272a(int width, int height, Config config) {
        return width * height * m11273a(config);
    }

    /* renamed from: a */
    private static int m11273a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        int i = C6025j.f10664a[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        if (i != 4) {
            return 4;
        }
        return 8;
    }

    /* renamed from: b */
    public static boolean m11285b(int width, int height) {
        return m11284b(width) && m11284b(height);
    }

    /* renamed from: b */
    private static boolean m11284b(int dimen) {
        return dimen > 0 || dimen == Integer.MIN_VALUE;
    }

    /* renamed from: b */
    public static void m11283b() {
        if (!m11288d()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: a */
    public static void m11281a() {
        if (!m11287c()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    /* renamed from: d */
    public static boolean m11288d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: c */
    public static boolean m11287c() {
        return !m11288d();
    }

    /* renamed from: a */
    public static <T> Queue<T> m11280a(int size) {
        return new ArrayDeque(size);
    }

    /* renamed from: a */
    public static <T> List<T> m11279a(Collection<T> other) {
        List<T> result = new ArrayList<>(other.size());
        for (T item : other) {
            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

    /* renamed from: b */
    public static boolean m11286b(Object a, Object b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    /* renamed from: a */
    public static boolean m11282a(Object a, Object b) {
        if (a == null) {
            return b == null;
        } else if (a instanceof C6124r) {
            return ((C6124r) a).mo18945a(b);
        } else {
            return a.equals(b);
        }
    }

    /* renamed from: a */
    public static int m11271a(int value, int accumulator) {
        return (accumulator * 31) + value;
    }

    /* renamed from: a */
    public static int m11269a(float value) {
        return m11270a(value, 17);
    }

    /* renamed from: a */
    public static int m11270a(float value, int accumulator) {
        return m11271a(Float.floatToIntBits(value), accumulator);
    }

    /* renamed from: a */
    public static int m11275a(Object object, int accumulator) {
        return m11271a(object == null ? 0 : object.hashCode(), accumulator);
    }

    /* renamed from: a */
    public static int m11276a(boolean value, int accumulator) {
        return m11271a((int) value, accumulator);
    }
}
