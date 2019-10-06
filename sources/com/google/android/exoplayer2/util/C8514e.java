package com.google.android.exoplayer2.util;

import android.text.TextUtils;

/* renamed from: com.google.android.exoplayer2.util.e */
/* compiled from: Assertions */
public final class C8514e {
    /* renamed from: a */
    public static void m20488a(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static void m20489a(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    /* renamed from: a */
    public static int m20485a(int index, int start, int limit) {
        if (index >= start && index < limit) {
            return index;
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public static void m20490b(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public static void m20491b(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    /* renamed from: a */
    public static <T> T m20486a(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static String m20487a(String string) {
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        throw new IllegalArgumentException();
    }
}
