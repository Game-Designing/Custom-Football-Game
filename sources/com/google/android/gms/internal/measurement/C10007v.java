package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.v */
final class C10007v extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30178e;

    /* renamed from: f */
    private final /* synthetic */ C10019c f30179f;

    C10007v(C10019c cVar, Activity activity) {
        this.f30179f = cVar;
        this.f30178e = activity;
        super(zzea.this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        zzea.this.f30232j.mo32791e(ObjectWrapper.m22188a(this.f30178e), this.f30237b);
    }
}
