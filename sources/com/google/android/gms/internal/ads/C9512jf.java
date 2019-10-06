package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.jf */
final /* synthetic */ class C9512jf implements Callable {

    /* renamed from: a */
    private final Context f22609a;

    /* renamed from: b */
    private final zzbin f22610b;

    /* renamed from: c */
    private final String f22611c;

    /* renamed from: d */
    private final boolean f22612d;

    /* renamed from: e */
    private final boolean f22613e;

    /* renamed from: f */
    private final zzdh f22614f;

    /* renamed from: g */
    private final zzbai f22615g;

    /* renamed from: h */
    private final zzadi f22616h;

    /* renamed from: i */
    private final zzj f22617i;

    /* renamed from: j */
    private final zza f22618j;

    /* renamed from: k */
    private final zzwj f22619k;

    C9512jf(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        this.f22609a = context;
        this.f22610b = zzbin;
        this.f22611c = str;
        this.f22612d = z;
        this.f22613e = z2;
        this.f22614f = zzdh;
        this.f22615g = zzbai;
        this.f22616h = zzadi;
        this.f22617i = zzj;
        this.f22618j = zza;
        this.f22619k = zzwj;
    }

    public final Object call() {
        Context context = this.f22609a;
        zzbin zzbin = this.f22610b;
        String str = this.f22611c;
        boolean z = this.f22612d;
        boolean z2 = this.f22613e;
        zzdh zzdh = this.f22614f;
        zzbai zzbai = this.f22615g;
        zzadi zzadi = this.f22616h;
        zzj zzj = this.f22617i;
        zza zza = this.f22618j;
        zzwj zzwj = this.f22619k;
        zzbio zzbio = new zzbio();
        zzbio zzbio2 = zzbio;
        C9534kf kfVar = new C9534kf(new zzbim(context), zzbio, zzbin, str, z, z2, zzdh, zzbai, zzadi, zzj, zza, zzwj);
        zzbhk zzbhk = new zzbhk(kfVar);
        kfVar.setWebChromeClient(new zzbgr(zzbhk));
        zzbio2.mo30655a((zzbgz) zzbhk, z2);
        return zzbhk;
    }
}
