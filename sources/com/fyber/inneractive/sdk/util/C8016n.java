package com.fyber.inneractive.sdk.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;

/* renamed from: com.fyber.inneractive.sdk.util.n */
public final class C8016n {
    @TargetApi(23)
    /* renamed from: a */
    public static boolean m18093a() {
        if (VERSION.SDK_INT >= 23) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        return true;
    }
}
