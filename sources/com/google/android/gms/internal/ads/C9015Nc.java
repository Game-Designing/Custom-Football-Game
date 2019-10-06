package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.ads.Nc */
final /* synthetic */ class C9015Nc implements Runnable {

    /* renamed from: a */
    private final zzban f21503a;

    /* renamed from: b */
    private final zzbbh f21504b;

    C9015Nc(zzban zzban, zzbbh zzbbh) {
        this.f21503a = zzban;
        this.f21504b = zzbbh;
    }

    public final void run() {
        Throwable e;
        zzban zzban = this.f21503a;
        try {
            zzban.mo27998a(this.f21504b.get());
        } catch (ExecutionException e2) {
            e = e2.getCause();
            zzban.mo27999a(e);
        } catch (InterruptedException e3) {
            e = e3;
            Thread.currentThread().interrupt();
            zzban.mo27999a(e);
        } catch (Exception e4) {
            e = e4;
            zzban.mo27999a(e);
        }
    }
}
