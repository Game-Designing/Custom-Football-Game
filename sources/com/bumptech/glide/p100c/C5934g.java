package com.bumptech.glide.p100c;

import android.content.Context;
import android.support.p000v4.content.C0510b;
import android.util.Log;
import com.bumptech.glide.p100c.C5929c.C5930a;

/* renamed from: com.bumptech.glide.c.g */
/* compiled from: DefaultConnectivityMonitorFactory */
public class C5934g implements C5931d {
    /* renamed from: a */
    public C5929c mo18596a(Context context, C5930a listener) {
        String str;
        boolean hasPermission = C0510b.m2565a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        String str2 = "ConnectivityMonitor";
        if (Log.isLoggable(str2, 3)) {
            if (hasPermission) {
                str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            } else {
                str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d(str2, str);
        }
        return hasPermission ? new C5933f(context, listener) : new C5938k();
    }
}
