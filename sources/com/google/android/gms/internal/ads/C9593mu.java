package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mopub.common.AdType;

/* renamed from: com.google.android.gms.internal.ads.mu */
final class C9593mu extends C9637ou<zzasw> {

    /* renamed from: b */
    private final /* synthetic */ Context f22792b;

    /* renamed from: c */
    private final /* synthetic */ zzamp f22793c;

    /* renamed from: d */
    private final /* synthetic */ zzyh f22794d;

    C9593mu(zzyh zzyh, Context context, zzamp zzamp) {
        this.f22794d = zzyh;
        this.f22792b = context;
        this.f22793c = zzamp;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22792b, AdType.REWARDED_VIDEO);
        return new zzabx();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22794d.f29785e.mo30069a(this.f22792b, this.f22793c);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22792b), this.f22793c, 15000000);
    }
}
