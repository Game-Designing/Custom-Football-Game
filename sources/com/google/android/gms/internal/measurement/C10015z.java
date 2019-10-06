package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.z */
final class C10015z extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30210e;

    /* renamed from: f */
    private final /* synthetic */ C10019c f30211f;

    C10015z(C10019c cVar, Activity activity) {
        this.f30211f = cVar;
        this.f30210e = activity;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32779b(ObjectWrapper.m22188a(this.f30210e), this.f30237b);
    }
}
