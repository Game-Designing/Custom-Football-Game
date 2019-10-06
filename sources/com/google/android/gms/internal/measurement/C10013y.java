package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.y */
final class C10013y extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30203e;

    /* renamed from: f */
    private final /* synthetic */ C10017a f30204f;

    /* renamed from: g */
    private final /* synthetic */ C10019c f30205g;

    C10013y(C10019c cVar, Activity activity, C10017a aVar) {
        this.f30205g = cVar;
        this.f30203e = activity;
        this.f30204f = aVar;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32762a(ObjectWrapper.m22188a(this.f30203e), (zzdq) this.f30204f, this.f30237b);
    }
}
