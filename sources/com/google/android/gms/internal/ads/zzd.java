package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {

    /* renamed from: a */
    private static final boolean f27709a = zzag.f24300b;

    /* renamed from: b */
    private final BlockingQueue<zzr<?>> f27710b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BlockingQueue<zzr<?>> f27711c;

    /* renamed from: d */
    private final zzb f27712d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzab f27713e;

    /* renamed from: f */
    private volatile boolean f27714f = false;

    /* renamed from: g */
    private final C8861Fq f27715g;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzb, zzab zzab) {
        this.f27710b = blockingQueue;
        this.f27711c = blockingQueue2;
        this.f27712d = zzb;
        this.f27713e = zzab;
        this.f27715g = new C8861Fq(this);
    }

    /* renamed from: a */
    public final void mo31335a() {
        this.f27714f = true;
        interrupt();
    }

    public final void run() {
        if (f27709a) {
            zzag.m24969c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f27712d.mo29887E();
        while (true) {
            try {
                m29061b();
            } catch (InterruptedException e) {
                if (this.f27714f) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    zzag.m24968b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private final void m29061b() throws InterruptedException {
        zzr zzr = (zzr) this.f27710b.take();
        zzr.mo32126a("cache-queue-take");
        zzr.mo32122a(1);
        try {
            zzr.mo32132i();
            zzc c = this.f27712d.mo29889c(zzr.mo32134s());
            if (c == null) {
                zzr.mo32126a("cache-miss");
                if (!this.f27715g.m22543b(zzr)) {
                    this.f27711c.put(zzr);
                }
            } else if (c.mo31083a()) {
                zzr.mo32126a("cache-hit-expired");
                zzr.mo32120a(c);
                if (!this.f27715g.m22543b(zzr)) {
                    this.f27711c.put(zzr);
                }
                zzr.mo32122a(2);
            } else {
                zzr.mo32126a("cache-hit");
                zzy a = zzr.mo30196a(new zzp(c.f26224a, c.f26230g));
                zzr.mo32126a("cache-hit-parsed");
                if (!(c.f26229f < System.currentTimeMillis())) {
                    this.f27713e.mo29405a(zzr, a);
                } else {
                    zzr.mo32126a("cache-hit-refresh-needed");
                    zzr.mo32120a(c);
                    a.f29747d = true;
                    if (!this.f27715g.m22543b(zzr)) {
                        this.f27713e.mo29406a(zzr, a, new C9823xq(this, zzr));
                    } else {
                        this.f27713e.mo29405a(zzr, a);
                    }
                }
                zzr.mo32122a(2);
            }
        } finally {
            zzr.mo32122a(2);
        }
    }
}
