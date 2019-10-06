package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.u */
final class C10005u extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30176e;

    /* renamed from: f */
    private final /* synthetic */ C10019c f30177f;

    C10005u(C10019c cVar, Activity activity) {
        this.f30177f = cVar;
        this.f30176e = activity;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32785c(ObjectWrapper.m22188a(this.f30176e), this.f30237b);
    }
}
