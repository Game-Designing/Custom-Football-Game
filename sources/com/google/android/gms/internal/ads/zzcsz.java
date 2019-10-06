package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.Callable;

public final class zzcsz implements zzcva<zzcsy> {

    /* renamed from: a */
    private final zzbbl f27351a;

    /* renamed from: b */
    private final zzcxv f27352b;

    public zzcsz(zzbbl zzbbl, zzcxv zzcxv) {
        this.f27351a = zzbbl;
        this.f27352b = zzcxv;
    }

    /* renamed from: a */
    public final zzbbh<zzcsy> mo28586a() {
        return this.f27351a.mo30326a((Callable<T>) new C9797wl<T>(this));
    }

    /* renamed from: a */
    private static int m28851a(zzzy zzzy) {
        long j;
        if (zzzy != null) {
            try {
                j = zzzy.getValue();
            } catch (RemoteException e) {
                zzbad.m26359d("Cannot get correlation id, default to 0.");
            }
            return (int) j;
        }
        j = 0;
        return (int) j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcsy mo31257b() throws Exception {
        return new zzcsy(m28851a(this.f27352b.f27597a), this.f27352b.f27600d);
    }
}
