package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(26)
public class zzaxx extends zzaxw {
    /* renamed from: a */
    public final zzwx mo30248a(Context context, TelephonyManager telephonyManager) {
        zzk.zzlg();
        if (zzaxi.m26116a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
        }
        return zzwx.ENUM_FALSE;
    }
}
