package com.bumptech.glide.load.engine.p120a;

import android.graphics.Bitmap.Config;

/* renamed from: com.bumptech.glide.load.engine.a.n */
/* compiled from: SizeConfigStrategy */
/* synthetic */ class C6264n {

    /* renamed from: a */
    static final /* synthetic */ int[] f11083a = new int[Config.values().length];

    static {
        try {
            f11083a[Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11083a[Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11083a[Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11083a[Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
