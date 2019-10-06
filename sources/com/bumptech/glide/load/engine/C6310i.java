package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6145c;

/* renamed from: com.bumptech.glide.load.engine.i */
/* compiled from: DecodeJob */
/* synthetic */ class C6310i {

    /* renamed from: a */
    static final /* synthetic */ int[] f11190a = new int[C6317f.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f11191b = new int[C6318g.values().length];

    /* renamed from: c */
    static final /* synthetic */ int[] f11192c = new int[C6145c.values().length];

    static {
        try {
            f11192c[C6145c.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11192c[C6145c.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11191b[C6318g.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11191b[C6318g.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11191b[C6318g.SOURCE.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11191b[C6318g.FINISHED.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f11191b[C6318g.INITIALIZE.ordinal()] = 5;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f11190a[C6317f.INITIALIZE.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f11190a[C6317f.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f11190a[C6317f.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
    }
}
