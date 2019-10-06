package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.measurement.e */
final class C9963e extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Activity f30102e;

    /* renamed from: f */
    private final /* synthetic */ String f30103f;

    /* renamed from: g */
    private final /* synthetic */ String f30104g;

    /* renamed from: h */
    private final /* synthetic */ zzea f30105h;

    C9963e(zzea zzea, Activity activity, String str, String str2) {
        this.f30105h = zzea;
        this.f30102e = activity;
        this.f30103f = str;
        this.f30104g = str2;
        super(zzea);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        this.f30105h.f30232j.mo32764a(ObjectWrapper.m22188a(this.f30102e), this.f30103f, this.f30104g, this.f30236a);
    }
}
