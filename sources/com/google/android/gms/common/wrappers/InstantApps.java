package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps {

    /* renamed from: a */
    private static Context f20328a;

    /* renamed from: b */
    private static Boolean f20329b;

    @KeepForSdk
    /* renamed from: a */
    public static synchronized boolean m22131a(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (f20328a == null || f20329b == null || f20328a != applicationContext) {
                f20329b = null;
                if (PlatformVersion.m22117k()) {
                    f20329b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        f20329b = Boolean.valueOf(true);
                    } catch (ClassNotFoundException e) {
                        f20329b = Boolean.valueOf(false);
                    }
                }
                f20328a = applicationContext;
                boolean booleanValue = f20329b.booleanValue();
                return booleanValue;
            }
            boolean booleanValue2 = f20329b.booleanValue();
            return booleanValue2;
        }
    }
}
