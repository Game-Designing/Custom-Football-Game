package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;

@ShowFirstParty
@KeepForSdk
public class GoogleApiAvailabilityLight {
    @KeepForSdk

    /* renamed from: a */
    public static final int f19526a = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b */
    private static final GoogleApiAvailabilityLight f19527b = new GoogleApiAvailabilityLight();

    @KeepForSdk
    public static GoogleApiAvailabilityLight getInstance() {
        return f19527b;
    }

    @KeepForSdk
    GoogleApiAvailabilityLight() {
    }

    @KeepForSdk
    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return mo27294a(context, f19526a);
    }

    @KeepForSdk
    /* renamed from: a */
    public int mo27294a(Context context, int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    @KeepForSdk
    /* renamed from: c */
    public boolean mo27307c(int i) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public Intent mo27311a(int i) {
        return mo27299a((Context) null, i, (String) null);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: a */
    public Intent mo27299a(Context context, int i, String str) {
        String str2 = "com.google.android.gms";
        if (i == 1 || i == 2) {
            if (context == null || !DeviceProperties.m22095d(context)) {
                return zzg.m21995a(str2, m21086b(context, str));
            }
            return zzg.m21993a();
        } else if (i != 3) {
            return null;
        } else {
            return zzg.m21994a(str2);
        }
    }

    @KeepForSdk
    /* renamed from: a */
    public PendingIntent mo27297a(Context context, int i, int i2) {
        return mo27310a(context, i, i2, null);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: a */
    public PendingIntent mo27310a(Context context, int i, int i2, String str) {
        Intent a = mo27299a(context, i, str);
        if (a == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a, 134217728);
    }

    @KeepForSdk
    /* renamed from: a */
    public void mo27312a(Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: b */
    public int mo27314b(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @ShowFirstParty
    @KeepForSdk
    /* renamed from: b */
    public boolean mo27315b(Context context, int i) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
    }

    @KeepForSdk
    /* renamed from: a */
    public boolean mo27313a(Context context, String str) {
        return GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(context, str);
    }

    @KeepForSdk
    /* renamed from: b */
    public String mo27303b(int i) {
        return GooglePlayServicesUtilLight.getErrorString(i);
    }

    @VisibleForTesting
    /* renamed from: b */
    private static String m21086b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f19526a);
        String str2 = "-";
        sb.append(str2);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(str2);
        if (context != null) {
            try {
                sb.append(Wrappers.m22139a(context).mo27947b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return sb.toString();
    }
}
