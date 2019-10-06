package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public final class zzcni extends zzcoj {

    /* renamed from: i */
    private zzbvj f27075i;

    /* renamed from: j */
    private zzbrp f27076j;

    public zzcni(zzbri zzbri, zzbrt zzbrt, zzbse zzbse, zzbso zzbso, zzbrp zzbrp, zzbtp zzbtp, zzbvq zzbvq, zzbsv zzbsv, zzbvj zzbvj) {
        super(zzbri, zzbrt, zzbse, zzbso, zzbtp, zzbsv, zzbvq);
        this.f27075i = zzbvj;
        this.f27076j = zzbrp;
    }

    /* renamed from: N */
    public final void mo29868N() {
        this.f27075i.mo29743E();
    }

    /* renamed from: d */
    public final void mo29873d(int i) throws RemoteException {
        this.f27076j.mo30876d(i);
    }

    /* renamed from: wa */
    public final void mo29885wa() throws RemoteException {
        this.f27075i.mo29742D();
    }

    /* renamed from: a */
    public final void mo29872a(zzatq zzatq) throws RemoteException {
        this.f27075i.mo29744a(new zzato(zzatq.getType(), zzatq.getAmount()));
    }

    /* renamed from: a */
    public final void mo29871a(zzato zzato) {
        this.f27075i.mo29744a(zzato);
    }

    /* renamed from: M */
    public final void mo29867M() {
        this.f27075i.mo29742D();
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }
}
