package com.google.android.gms.internal.ads;

import android.webkit.ConsoleMessage.MessageLevel;

/* renamed from: com.google.android.gms.internal.ads.Pe */
final /* synthetic */ class C9059Pe {

    /* renamed from: a */
    static final /* synthetic */ int[] f21582a = new int[MessageLevel.values().length];

    static {
        try {
            f21582a[MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f21582a[MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f21582a[MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f21582a[MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f21582a[MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
