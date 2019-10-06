package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Ue */
final /* synthetic */ class C9167Ue implements zzbal {

    /* renamed from: a */
    private final Context f21800a;

    /* renamed from: b */
    private final zzdh f21801b;

    /* renamed from: c */
    private final zzbai f21802c;

    /* renamed from: d */
    private final zza f21803d;

    /* renamed from: e */
    private final String f21804e;

    C9167Ue(Context context, zzdh zzdh, zzbai zzbai, zza zza, String str) {
        this.f21800a = context;
        this.f21801b = zzdh;
        this.f21802c = zzbai;
        this.f21803d = zza;
        this.f21804e = str;
    }

    /* renamed from: a */
    public final zzbbh mo26658a(Object obj) {
        Context context = this.f21800a;
        zzdh zzdh = this.f21801b;
        zzbai zzbai = this.f21802c;
        zza zza = this.f21803d;
        String str = this.f21804e;
        zzk.zzlh();
        zzbgz a = zzbhf.m26877a(context, zzbin.m27015b(), "", false, false, zzdh, zzbai, null, null, zza, zzwj.m31331a());
        zzbbq c = zzbbq.m26396c(a);
        a.mo28714a().mo30597a((zzbij) new C9209We(c));
        a.loadUrl(str);
        return c;
    }
}
