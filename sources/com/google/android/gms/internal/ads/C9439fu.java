package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.fu */
final class C9439fu extends C9637ou<zzaqg> {

    /* renamed from: b */
    private final /* synthetic */ Activity f22362b;

    /* renamed from: c */
    private final /* synthetic */ zzyh f22363c;

    C9439fu(zzyh zzyh, Activity activity) {
        this.f22363c = zzyh;
        this.f22362b = activity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22362b, "ad_overlay");
        return null;
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22363c.f29787g.mo30002a(this.f22362b);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zzf(ObjectWrapper.m22188a(this.f22362b));
    }
}
