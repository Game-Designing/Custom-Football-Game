package com.inmobi.ads;

import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.p207a.C10299n;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.inmobi.ads.bw */
/* compiled from: VastNetworkClient */
final class C10472bw {

    /* renamed from: d */
    public static final Executor f31859d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final String f31860e = C10472bw.class.getSimpleName();

    /* renamed from: g */
    private static final int f31861g = Runtime.getRuntime().availableProcessors();

    /* renamed from: h */
    private static final int f31862h = Math.max(2, Math.min(f31861g - 1, 4));

    /* renamed from: i */
    private static final int f31863i = ((f31861g * 2) + 1);

    /* renamed from: j */
    private static final ThreadFactory f31864j = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f31870a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("VastNetworkTask #");
            sb.append(this.f31870a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: k */
    private static final BlockingQueue<Runnable> f31865k = new LinkedBlockingQueue(128);
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public C10676c f31866a;

    /* renamed from: b */
    WeakReference<C10471bv> f31867b;

    /* renamed from: c */
    long f31868c = 0;

    /* renamed from: f */
    private final CountDownLatch f31869f;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f31862h, f31863i, 30, TimeUnit.SECONDS, f31865k, f31864j);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f31859d = threadPoolExecutor;
    }

    public C10472bw(C10471bv bvVar, int i, CountDownLatch countDownLatch) {
        this.f31866a = new C10676c("GET", bvVar.f31854a);
        C10676c cVar = this.f31866a;
        cVar.f32580r = i;
        cVar.f32569A = false;
        this.f31867b = new WeakReference<>(bvVar);
        this.f31869f = countDownLatch;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34191a() {
        CountDownLatch countDownLatch = this.f31869f;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* renamed from: a */
    public final void mo34192a(C10677d dVar) {
        new StringBuilder("Vast Media Header Request fetch failed:").append(dVar.f32591b.f32553b);
        try {
            C10299n.m33566a().mo33663a(this.f31866a.mo34509g());
            C10299n.m33566a().mo33664b(dVar.mo34513c());
        } catch (Exception e) {
            new StringBuilder("Handling Vast Media Header Request fetch failed encountered an unexpected error: ").append(e.getMessage());
        } catch (Throwable th) {
            mo34191a();
            throw th;
        }
        mo34191a();
    }
}
