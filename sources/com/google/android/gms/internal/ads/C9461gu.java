package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.gu */
final class C9461gu extends C9637ou<zzzk> {

    /* renamed from: b */
    private final /* synthetic */ Context f22393b;

    /* renamed from: c */
    private final /* synthetic */ zzyd f22394c;

    /* renamed from: d */
    private final /* synthetic */ String f22395d;

    /* renamed from: e */
    private final /* synthetic */ zzyh f22396e;

    C9461gu(zzyh zzyh, Context context, zzyd zzyd, String str) {
        this.f22396e = zzyh;
        this.f22393b = context;
        this.f22394c = zzyd;
        this.f22395d = str;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22393b, "search");
        return new zzabp();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22396e.f29781a.mo32373a(this.f22393b, this.f22394c, this.f22395d, null, 3);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22393b), this.f22394c, this.f22395d, 15000000);
    }
}
