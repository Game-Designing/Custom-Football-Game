package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.x */
final class C10011x extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30182e;

    /* renamed from: f */
    private final /* synthetic */ C10019c f30183f;

    C10011x(C10019c cVar, Activity activity) {
        this.f30183f = cVar;
        this.f30182e = activity;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32760a(ObjectWrapper.m22188a(this.f30182e), this.f30237b);
    }
}
