package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.iu */
final class C9505iu extends C9637ou<zzzf> {

    /* renamed from: b */
    private final /* synthetic */ Context f22581b;

    /* renamed from: c */
    private final /* synthetic */ String f22582c;

    /* renamed from: d */
    private final /* synthetic */ zzamp f22583d;

    /* renamed from: e */
    private final /* synthetic */ zzyh f22584e;

    C9505iu(zzyh zzyh, Context context, String str, zzamp zzamp) {
        this.f22584e = zzyh;
        this.f22581b = context;
        this.f22582c = str;
        this.f22583d = zzamp;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22581b, "native_ad");
        return new zzabl();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22584e.f29782b.mo32372a(this.f22581b, this.f22582c, this.f22583d);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22581b), this.f22582c, this.f22583d, 15000000);
    }
}
