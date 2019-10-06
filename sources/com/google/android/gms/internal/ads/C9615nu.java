package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.nu */
final class C9615nu extends C9637ou<zzatt> {

    /* renamed from: b */
    private final /* synthetic */ Context f22824b;

    /* renamed from: c */
    private final /* synthetic */ String f22825c;

    /* renamed from: d */
    private final /* synthetic */ zzamp f22826d;

    /* renamed from: e */
    private final /* synthetic */ zzyh f22827e;

    C9615nu(zzyh zzyh, Context context, String str, zzamp zzamp) {
        this.f22827e = zzyh;
        this.f22824b = context;
        this.f22825c = str;
        this.f22826d = zzamp;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22824b, "rewarded");
        return new zzabv();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return zzauj.m25860a(this.f22824b, this.f22825c, this.f22826d);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zzb(ObjectWrapper.m22188a(this.f22824b), this.f22825c, this.f22826d, 15000000);
    }
}
