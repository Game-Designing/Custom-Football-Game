package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.Rc */
final /* synthetic */ class C9098Rc implements Runnable {

    /* renamed from: a */
    private final zzbbh f21648a;

    /* renamed from: b */
    private final AtomicInteger f21649b;

    /* renamed from: c */
    private final Runnable f21650c;

    /* renamed from: d */
    private final zzbbr f21651d;

    C9098Rc(zzbbh zzbbh, AtomicInteger atomicInteger, Runnable runnable, zzbbr zzbbr) {
        this.f21648a = zzbbh;
        this.f21649b = atomicInteger;
        this.f21650c = runnable;
        this.f21651d = zzbbr;
    }

    public final void run() {
        zzbbh zzbbh = this.f21648a;
        AtomicInteger atomicInteger = this.f21649b;
        Runnable runnable = this.f21650c;
        zzbbr zzbbr = this.f21651d;
        try {
            zzbbh.get();
            if (atomicInteger.decrementAndGet() == 0) {
                runnable.run();
            }
        } catch (ExecutionException e) {
            zzbbr.mo30337a(e.getCause());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbbr.mo30337a(e2);
        } catch (Exception e3) {
            zzbbr.mo30337a(e3);
        }
    }
}
