package com.mopub.common;

import com.mopub.common.LocationService.ValidLocationProvider;

/* renamed from: com.mopub.common.o */
/* compiled from: LocationService */
/* synthetic */ class C11255o {

    /* renamed from: a */
    static final /* synthetic */ int[] f34429a = new int[ValidLocationProvider.values().length];

    static {
        try {
            f34429a[ValidLocationProvider.NETWORK.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f34429a[ValidLocationProvider.GPS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
