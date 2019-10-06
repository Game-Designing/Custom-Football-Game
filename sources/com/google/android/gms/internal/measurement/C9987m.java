package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.m */
final class C9987m extends C10018b {

    /* renamed from: e */
    private final /* synthetic */ String f30129e;

    /* renamed from: f */
    private final /* synthetic */ String f30130f;

    /* renamed from: g */
    private final /* synthetic */ boolean f30131g;

    /* renamed from: h */
    private final /* synthetic */ C10017a f30132h;

    /* renamed from: i */
    private final /* synthetic */ zzea f30133i;

    C9987m(zzea zzea, String str, String str2, boolean z, C10017a aVar) {
        this.f30133i = zzea;
        this.f30129e = str;
        this.f30130f = str2;
        this.f30131g = z;
        this.f30132h = aVar;
        super(zzea);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo32712a() throws RemoteException {
        this.f30133i.f30232j.mo32775a(this.f30129e, this.f30130f, this.f30131g, (zzdq) this.f30132h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo32716b() {
        this.f30132h.zzb(null);
    }
}
