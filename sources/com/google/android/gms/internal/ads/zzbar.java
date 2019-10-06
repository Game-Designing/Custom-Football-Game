package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zzard
public final class zzbar {
    /* renamed from: a */
    public static <V> void m26383a(zzbbh<V> zzbbh, zzban<? super V> zzban, Executor executor) {
        zzbbh.mo28811a(new C9015Nc(zzban, zzbbh), executor);
    }

    /* renamed from: a */
    public static <A, B> zzbbh<B> m26380a(zzbbh<A> zzbbh, zzbam<A, B> zzbam, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        zzbbh.mo28811a(new C9036Oc(zzbbr, zzbam, zzbbh), executor);
        m26389b(zzbbr, zzbbh);
        return zzbbr;
    }

    /* renamed from: a */
    public static <A, B> zzbbh<B> m26379a(zzbbh<A> zzbbh, zzbal<? super A, ? extends B> zzbal, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        zzbbh.mo28811a(new C9057Pc(zzbbr, zzbal, zzbbh), executor);
        m26389b(zzbbr, zzbbh);
        return zzbbr;
    }

    /* renamed from: a */
    public static <V> zzbbh<List<V>> m26382a(Iterable<? extends zzbbh<? extends V>> iterable) {
        zzbbr zzbbr = new zzbbr();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh zzbbh : iterable) {
            atomicInteger.incrementAndGet();
            m26389b(zzbbr, zzbbh);
        }
        C9078Qc qc = new C9078Qc(iterable, zzbbr);
        for (zzbbh zzbbh2 : iterable) {
            zzbbh2.mo28811a(new C9098Rc(zzbbh2, atomicInteger, qc, zzbbr), zzbbm.f25065b);
        }
        return zzbbr;
    }

    /* renamed from: a */
    public static <V> zzbbh<V> m26378a(zzbbh<V> zzbbh, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzbbr zzbbr = new zzbbr();
        m26389b(zzbbr, zzbbh);
        ScheduledFuture schedule = scheduledExecutorService.schedule(new C9119Sc(zzbbr), j, timeUnit);
        m26384a(zzbbh, zzbbr);
        zzbbr.mo28811a(new C9144Tc(schedule), zzbbm.f25065b);
        return zzbbr;
    }

    /* renamed from: a */
    public static <V, X extends Throwable> zzbbh<V> m26381a(zzbbh<? extends V> zzbbh, Class<X> cls, zzbal<? super X, ? extends V> zzbal, Executor executor) {
        zzbbr zzbbr = new zzbbr();
        m26389b(zzbbr, zzbbh);
        C9165Uc uc = new C9165Uc(zzbbr, zzbbh, cls, zzbal, executor);
        zzbbh.mo28811a(uc, zzbbm.f25065b);
        return zzbbr;
    }

    /* renamed from: a */
    public static <V> zzbbc<V> m26377a(zzbbh<? extends V>... zzbbhArr) {
        return m26388b(Arrays.asList(zzbbhArr));
    }

    /* renamed from: b */
    public static <V> zzbbc<V> m26388b(Iterable<? extends zzbbh<? extends V>> iterable) {
        return new zzbbc<>(iterable);
    }

    /* renamed from: a */
    public static <T> C9290_c<T> m26376a(T t) {
        return new C9290_c<>(t);
    }

    /* renamed from: a */
    public static <T> C9270Zc<T> m26375a(Throwable th) {
        return new C9270Zc<>(th);
    }

    /* renamed from: a */
    private static <V> void m26384a(zzbbh<? extends V> zzbbh, zzbbr<V> zzbbr) {
        m26389b(zzbbr, zzbbh);
        zzbbh.mo28811a(new C9186Vc(zzbbr, zzbbh), zzbbm.f25065b);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static <A, B> void m26389b(zzbbh<A> zzbbh, Future<B> future) {
        zzbbh.mo28811a(new C9207Wc(zzbbh, future), zzbbm.f25065b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ void m26387a(com.google.android.gms.internal.ads.zzbbr r1, com.google.android.gms.internal.ads.zzbbh r2, java.lang.Class r3, com.google.android.gms.internal.ads.zzbal r4, java.util.concurrent.Executor r5) {
        /*
            java.lang.Object r2 = r2.get()     // Catch:{ ExecutionException -> 0x0013, InterruptedException -> 0x000a, Exception -> 0x0008 }
            r1.mo30338b(r2)     // Catch:{ ExecutionException -> 0x0013, InterruptedException -> 0x000a, Exception -> 0x0008 }
            return
        L_0x0008:
            r2 = move-exception
            goto L_0x0019
        L_0x000a:
            r2 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x0019
        L_0x0013:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
        L_0x0019:
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L_0x002d
            com.google.android.gms.internal.ads._c r2 = m26376a((T) r2)
            com.google.android.gms.internal.ads.zzbbh r2 = m26379a(r2, r4, r5)
            m26384a(r2, r1)
            return
        L_0x002d:
            r1.mo30337a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbar.m26387a(com.google.android.gms.internal.ads.zzbbr, com.google.android.gms.internal.ads.zzbbh, java.lang.Class, com.google.android.gms.internal.ads.zzbal, java.util.concurrent.Executor):void");
    }

    /* renamed from: a */
    static final /* synthetic */ void m26386a(zzbbr zzbbr, zzbal zzbal, zzbbh zzbbh) {
        if (!zzbbr.isCancelled()) {
            try {
                m26384a(zzbal.mo26658a(zzbbh.get()), zzbbr);
            } catch (CancellationException e) {
                zzbbr.cancel(true);
            } catch (ExecutionException e2) {
                zzbbr.mo30337a(e2.getCause());
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
                zzbbr.mo30337a(e3);
            } catch (Exception e4) {
                zzbbr.mo30337a(e4);
            }
        }
    }
}
