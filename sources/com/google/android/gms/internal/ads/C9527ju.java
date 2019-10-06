package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ju */
final class C9527ju extends C9637ou<zzaab> {

    /* renamed from: b */
    private final /* synthetic */ Context f22633b;

    /* renamed from: c */
    private final /* synthetic */ zzyh f22634c;

    C9527ju(zzyh zzyh, Context context) {
        this.f22634c = zzyh;
        this.f22633b = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22633b, "mobile_ads_settings");
        return new zzabr();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22634c.f29783c.mo29489b(this.f22633b);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22633b), 15000000);
    }
}
