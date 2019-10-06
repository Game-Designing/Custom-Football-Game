package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.t */
final class C10003t extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30171e;

    /* renamed from: f */
    private final /* synthetic */ Bundle f30172f;

    /* renamed from: g */
    private final /* synthetic */ C10019c f30173g;

    C10003t(C10019c cVar, Activity activity, Bundle bundle) {
        this.f30173g = cVar;
        this.f30171e = activity;
        this.f30172f = bundle;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32761a(ObjectWrapper.m22188a(this.f30171e), this.f30172f, this.f30237b);
    }
}
