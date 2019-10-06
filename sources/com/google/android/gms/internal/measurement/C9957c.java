package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.c */
final class C9957c extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ String f30087e;

    /* renamed from: f */
    private final /* synthetic */ String f30088f;

    /* renamed from: g */
    private final /* synthetic */ Bundle f30089g;

    /* renamed from: h */
    private final /* synthetic */ zzea f30090h;

    C9957c(zzea zzea, String str, String str2, Bundle bundle) {
        this.f30090h = zzea;
        this.f30087e = str;
        this.f30088f = str2;
        this.f30089g = bundle;
        super(zzea);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        this.f30090h.f30232j.mo32783b(this.f30087e, this.f30088f, this.f30089g);
    }
}
