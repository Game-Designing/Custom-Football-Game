package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Ve */
final /* synthetic */ class C9188Ve implements Callable {

    /* renamed from: a */
    private final Context f21839a;

    /* renamed from: b */
    private final zzbin f21840b;

    /* renamed from: c */
    private final String f21841c;

    /* renamed from: d */
    private final boolean f21842d;

    /* renamed from: e */
    private final boolean f21843e;

    /* renamed from: f */
    private final zzdh f21844f;

    /* renamed from: g */
    private final zzbai f21845g;

    /* renamed from: h */
    private final zzadi f21846h = null;

    /* renamed from: i */
    private final zzj f21847i;

    /* renamed from: j */
    private final zza f21848j;

    /* renamed from: k */
    private final zzwj f21849k;

    C9188Ve(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        this.f21839a = context;
        this.f21840b = zzbin;
        this.f21841c = str;
        this.f21842d = z;
        this.f21843e = z2;
        this.f21844f = zzdh;
        this.f21845g = zzbai;
        this.f21847i = zzj;
        this.f21848j = zza;
        this.f21849k = zzwj;
    }

    public final Object call() {
        Context context = this.f21839a;
        zzbin zzbin = this.f21840b;
        String str = this.f21841c;
        boolean z = this.f21842d;
        boolean z2 = this.f21843e;
        zzdh zzdh = this.f21844f;
        zzbai zzbai = this.f21845g;
        zzadi zzadi = this.f21846h;
        zzj zzj = this.f21847i;
        zza zza = this.f21848j;
        zzwj zzwj = this.f21849k;
        zzbhk zzbhk = new zzbhk(C9251Ye.m23250a(context, zzbin, str, z, z2, zzdh, zzbai, zzadi, zzj, zza, zzwj));
        zzbhk.setWebViewClient(zzk.zzli().mo30247a(zzbhk, zzwj, z2));
        zzbhk.setWebChromeClient(new zzbgr(zzbhk));
        return zzbhk;
    }
}
