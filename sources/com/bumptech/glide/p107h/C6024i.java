package com.bumptech.glide.p107h;

import android.text.TextUtils;
import java.util.Collection;

/* renamed from: com.bumptech.glide.h.i */
/* compiled from: Preconditions */
public final class C6024i {
    /* renamed from: a */
    public static void m11268a(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /* renamed from: a */
    public static <T> T m11264a(T arg) {
        m11265a(arg, "Argument must not be null");
        return arg;
    }

    /* renamed from: a */
    public static <T> T m11265a(T arg, String message) {
        if (arg != null) {
            return arg;
        }
        throw new NullPointerException(message);
    }

    /* renamed from: a */
    public static String m11266a(String string) {
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    /* renamed from: a */
    public static <T extends Collection<Y>, Y> T m11267a(T collection) {
        if (!collection.isEmpty()) {
            return collection;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }
}
