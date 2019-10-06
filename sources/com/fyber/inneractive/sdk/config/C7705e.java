package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.common.GoogleApiAvailability;

/* renamed from: com.fyber.inneractive.sdk.config.e */
final class C7705e {

    /* renamed from: com.fyber.inneractive.sdk.config.e$a */
    interface C7707a {
        /* renamed from: a */
        void mo24181a(String str, boolean z);
    }

    /* renamed from: a */
    static boolean m17041a(Context context) {
        try {
            boolean z = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
            StringBuilder sb = new StringBuilder("isGooglePlayServicesAvailable = ");
            sb.append(z);
            IAlog.m18021b(sb.toString());
            return z;
        } catch (Throwable th) {
            IAlog.m18019a("Handled Exception:");
            IAlog.m18019a(C8017o.m18096a(th));
            IAlog.m18021b("isGooglePlayServicesAvailable = FALSE! :( ");
            return false;
        }
    }
}
