package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.ads.lu */
final class C9571lu extends C9637ou<zzaer> {

    /* renamed from: b */
    private final /* synthetic */ View f22746b;

    /* renamed from: c */
    private final /* synthetic */ HashMap f22747c;

    /* renamed from: d */
    private final /* synthetic */ HashMap f22748d;

    /* renamed from: e */
    private final /* synthetic */ zzyh f22749e;

    C9571lu(zzyh zzyh, View view, HashMap hashMap, HashMap hashMap2) {
        this.f22749e = zzyh;
        this.f22746b = view;
        this.f22747c = hashMap;
        this.f22748d = hashMap2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22746b.getContext(), "native_ad_view_holder_delegate");
        return new zzabu();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22749e.f29788h.mo29738a(this.f22746b, this.f22747c, this.f22748d);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zza(ObjectWrapper.m22188a(this.f22746b), ObjectWrapper.m22188a(this.f22747c), ObjectWrapper.m22188a(this.f22748d));
    }
}
