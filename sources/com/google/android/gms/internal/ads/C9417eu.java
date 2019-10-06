package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.eu */
final class C9417eu extends C9637ou<zzzk> {

    /* renamed from: b */
    private final /* synthetic */ Context f22273b;

    /* renamed from: c */
    private final /* synthetic */ zzyd f22274c;

    /* renamed from: d */
    private final /* synthetic */ String f22275d;

    /* renamed from: e */
    private final /* synthetic */ zzamp f22276e;

    /* renamed from: f */
    private final /* synthetic */ zzyh f22277f;

    C9417eu(zzyh zzyh, Context context, zzyd zzyd, String str, zzamp zzamp) {
        this.f22277f = zzyh;
        this.f22273b = context;
        this.f22274c = zzyd;
        this.f22275d = str;
        this.f22276e = zzamp;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22273b, "banner");
        return new zzabp();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22277f.f29781a.mo32373a(this.f22273b, this.f22274c, this.f22275d, this.f22276e, 1);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22273b), this.f22274c, this.f22275d, this.f22276e, 15000000);
    }
}
