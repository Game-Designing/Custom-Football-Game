package com.google.android.exoplayer2;

import java.util.HashSet;

/* renamed from: com.google.android.exoplayer2.m */
/* compiled from: ExoPlayerLibraryInfo */
public final class C8331m {

    /* renamed from: a */
    private static final HashSet<String> f17993a = new HashSet<>();

    /* renamed from: b */
    private static String f17994b = "goog.exo.core";

    /* renamed from: a */
    public static synchronized String m19553a() {
        String str;
        synchronized (C8331m.class) {
            str = f17994b;
        }
        return str;
    }
}
