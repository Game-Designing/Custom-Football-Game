package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mopub.common.AdType;

/* renamed from: com.google.android.gms.internal.ads.hu */
final class C9483hu extends C9637ou<zzzk> {

    /* renamed from: b */
    private final /* synthetic */ Context f22530b;

    /* renamed from: c */
    private final /* synthetic */ zzyd f22531c;

    /* renamed from: d */
    private final /* synthetic */ String f22532d;

    /* renamed from: e */
    private final /* synthetic */ zzamp f22533e;

    /* renamed from: f */
    private final /* synthetic */ zzyh f22534f;

    C9483hu(zzyh zzyh, Context context, zzyd zzyd, String str, zzamp zzamp) {
        this.f22534f = zzyh;
        this.f22530b = context;
        this.f22531c = zzyd;
        this.f22532d = str;
        this.f22533e = zzamp;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22530b, AdType.INTERSTITIAL);
        return new zzabp();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22534f.f29781a.mo32373a(this.f22530b, this.f22531c, this.f22532d, this.f22533e, 2);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zzb(ObjectWrapper.m22188a(this.f22530b), this.f22531c, this.f22532d, this.f22533e, 15000000);
    }
}
