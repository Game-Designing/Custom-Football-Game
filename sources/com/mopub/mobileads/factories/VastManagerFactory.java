package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;

public class VastManagerFactory {

    /* renamed from: a */
    protected static VastManagerFactory f35267a = new VastManagerFactory();

    public static VastManager create(Context context) {
        return f35267a.internalCreate(context, true);
    }

    public static VastManager create(Context context, boolean preCacheVideo) {
        return f35267a.internalCreate(context, preCacheVideo);
    }

    public VastManager internalCreate(Context context, boolean preCacheVideo) {
        return new VastManager(context, preCacheVideo);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory factory) {
        f35267a = factory;
    }
}
