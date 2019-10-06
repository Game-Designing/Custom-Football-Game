package com.fyber.inneractive.sdk.util;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

/* renamed from: com.fyber.inneractive.sdk.util.f */
public final class C8000f {
    /* renamed from: a */
    static boolean m18044a(Context context) {
        try {
            return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
        } catch (Throwable th) {
            IAlog.m18019a(C8017o.m18096a(th));
            return false;
        }
    }
}
