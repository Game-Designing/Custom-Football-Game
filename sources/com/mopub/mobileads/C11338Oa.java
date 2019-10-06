package com.mopub.mobileads;

import com.mopub.common.util.DeviceUtils.ForceOrientation;

/* renamed from: com.mopub.mobileads.Oa */
/* compiled from: VastVideoViewController */
/* synthetic */ class C11338Oa {

    /* renamed from: a */
    static final /* synthetic */ int[] f34889a = new int[ForceOrientation.values().length];

    static {
        try {
            f34889a[ForceOrientation.FORCE_PORTRAIT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f34889a[ForceOrientation.FORCE_LANDSCAPE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f34889a[ForceOrientation.DEVICE_ORIENTATION.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f34889a[ForceOrientation.UNDEFINED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
