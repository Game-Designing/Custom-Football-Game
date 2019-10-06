package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;

@zzard
public final class zzbhf {
    /* renamed from: a */
    public static zzbbh<zzbgz> m26876a(Context context, zzbai zzbai, String str, zzdh zzdh, zza zza) {
        C9290_c a = zzbar.m26376a(null);
        C9167Ue ue = new C9167Ue(context, zzdh, zzbai, zza, str);
        return zzbar.m26379a((zzbbh<A>) a, (zzbal<? super A, ? extends B>) ue, zzbbm.f25064a);
    }

    /* renamed from: a */
    public static zzbgz m26877a(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) throws zzbhj {
        zzacu.m24782a(context);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23987Pa)).booleanValue()) {
            return zzbit.m27063a(context, zzbin, str, z, z2, zzdh, zzbai, null, zzj, zza, zzwj);
        }
        try {
            C9188Ve ve = new C9188Ve(context, zzbin, str, z, z2, zzdh, zzbai, null, zzj, zza, zzwj);
            return (zzbgz) zzazl.m26285a(ve);
        } catch (Throwable th) {
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
