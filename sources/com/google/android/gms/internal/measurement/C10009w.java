package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.w */
final class C10009w extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30180e;

    /* renamed from: f */
    private final /* synthetic */ C10019c f30181f;

    C10009w(C10019c cVar, Activity activity) {
        this.f30181f = cVar;
        this.f30180e = activity;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32789d(ObjectWrapper.m22188a(this.f30180e), this.f30237b);
    }
}
