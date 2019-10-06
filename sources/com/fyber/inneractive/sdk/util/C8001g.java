package com.fyber.inneractive.sdk.util;

import android.location.Location;

/* renamed from: com.fyber.inneractive.sdk.util.g */
public final class C8001g {

    /* renamed from: a */
    private static boolean f16330a = false;

    /* renamed from: b */
    private static Boolean f16331b = null;

    /* renamed from: com.fyber.inneractive.sdk.util.g$a */
    public interface C8002a {
        /* renamed from: a */
        void mo24840a(Location location);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m18045a(android.content.Context r1, com.fyber.inneractive.sdk.util.C8001g.C8002a r2) {
        /*
            java.lang.Boolean r0 = f16331b
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = "com.google.android.gms.common.GoogleApiAvailability"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x001a }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "com.google.android.gms.location.LocationServices"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x001a }
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            f16330a = r0     // Catch:{ ClassNotFoundException -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r0 = move-exception
        L_0x001b:
            boolean r0 = f16330a
            if (r0 == 0) goto L_0x002b
            boolean r0 = com.fyber.inneractive.sdk.util.C8000f.m18044a(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            f16331b = r0
            goto L_0x002f
        L_0x002b:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            f16331b = r0
        L_0x002f:
            java.lang.Boolean r0 = f16331b
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.fyber.inneractive.sdk.util.C8006j.m18073b(r0)
            if (r0 == 0) goto L_0x005a
        L_0x0047:
            com.google.android.gms.location.FusedLocationProviderClient r1 = com.google.android.gms.location.LocationServices.m32675a(r1)     // Catch:{ Throwable -> 0x0059 }
            com.google.android.gms.tasks.Task r1 = r1.mo33017h()     // Catch:{ Throwable -> 0x0059 }
            com.fyber.inneractive.sdk.util.e$1 r0 = new com.fyber.inneractive.sdk.util.e$1     // Catch:{ Throwable -> 0x0059 }
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0059 }
            r1.mo33174a(r0)     // Catch:{ Throwable -> 0x0059 }
            return
        L_0x0059:
            r1 = move-exception
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8001g.m18045a(android.content.Context, com.fyber.inneractive.sdk.util.g$a):void");
    }
}
