package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.q */
final class C9997q extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ Long f30157e;

    /* renamed from: f */
    private final /* synthetic */ String f30158f;

    /* renamed from: g */
    private final /* synthetic */ String f30159g;

    /* renamed from: h */
    private final /* synthetic */ Bundle f30160h;

    /* renamed from: i */
    private final /* synthetic */ boolean f30161i = true;

    /* renamed from: j */
    private final /* synthetic */ boolean f30162j;

    /* renamed from: k */
    private final /* synthetic */ zzea f30163k;

    C9997q(zzea zzea, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        this.f30163k = zzea;
        this.f30157e = l;
        this.f30158f = str;
        this.f30159g = str2;
        this.f30160h = bundle;
        this.f30162j = z2;
        super(zzea);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        Long l = this.f30157e;
        this.f30163k.f30232j.mo32772a(this.f30158f, this.f30159g, this.f30160h, this.f30161i, this.f30162j, l == null ? this.f30236a : l.longValue());
    }
}
