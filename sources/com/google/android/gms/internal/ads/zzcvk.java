package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

public final class zzcvk implements zzcva<zzcvj> {

    /* renamed from: a */
    private final zzbbl f27457a;

    /* renamed from: b */
    private final Context f27458b;

    public zzcvk(zzbbl zzbbl, Context context) {
        this.f27457a = zzbbl;
        this.f27458b = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcvj> mo28586a() {
        return this.f27457a.mo30326a((Callable<T>) new C9174Ul<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcvj mo31270b() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.f27458b.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzk.zzlg();
        int i4 = -1;
        if (zzaxi.m26116a(this.f27458b, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f27458b.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                i = i4;
                i2 = i3;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i = i4;
                i2 = i3;
                z = false;
            }
        } else {
            i2 = -2;
            z = false;
            i = -1;
        }
        zzcvj zzcvj = new zzcvj(networkOperator, i2, networkType, phoneType, z, i);
        return zzcvj;
    }
}
