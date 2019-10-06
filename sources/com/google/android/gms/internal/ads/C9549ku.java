package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ku */
final class C9549ku extends C9637ou<zzaem> {

    /* renamed from: b */
    private final /* synthetic */ FrameLayout f22704b;

    /* renamed from: c */
    private final /* synthetic */ FrameLayout f22705c;

    /* renamed from: d */
    private final /* synthetic */ Context f22706d;

    /* renamed from: e */
    private final /* synthetic */ zzyh f22707e;

    C9549ku(zzyh zzyh, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f22707e = zzyh;
        this.f22704b = frameLayout;
        this.f22705c = frameLayout2;
        this.f22706d = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Object mo28933a() {
        zzyh.m31521b(this.f22706d, "native_ad_view_delegate");
        return new zzabt();
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo28935b() throws RemoteException {
        return this.f22707e.f29784d.mo29737a(this.f22706d, this.f22704b, this.f22705c);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo28934a(zzzv zzzv) throws RemoteException {
        return zzzv.zzc(ObjectWrapper.m22188a(this.f22704b), ObjectWrapper.m22188a(this.f22705c));
    }
}
