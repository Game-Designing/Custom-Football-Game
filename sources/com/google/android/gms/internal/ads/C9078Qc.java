package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.ads.Qc */
final /* synthetic */ class C9078Qc implements Runnable {

    /* renamed from: a */
    private final Iterable f21606a;

    /* renamed from: b */
    private final zzbbr f21607b;

    C9078Qc(Iterable iterable, zzbbr zzbbr) {
        this.f21606a = iterable;
        this.f21607b = zzbbr;
    }

    public final void run() {
        Iterable<zzbbh> iterable = this.f21606a;
        zzbbr zzbbr = this.f21607b;
        ArrayList arrayList = new ArrayList();
        for (zzbbh zzbbh : iterable) {
            try {
                arrayList.add(zzbbh.get());
            } catch (ExecutionException e) {
                zzbbr.mo30337a(e.getCause());
            } catch (Exception | InterruptedException e2) {
                zzbbr.mo30337a(e2);
            }
        }
        zzbbr.mo30338b(arrayList);
    }
}
