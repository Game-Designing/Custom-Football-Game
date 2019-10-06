package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {

    /* renamed from: a */
    private final BlockingQueue<zzr<?>> f28938a;

    /* renamed from: b */
    private final zzm f28939b;

    /* renamed from: c */
    private final zzb f28940c;

    /* renamed from: d */
    private final zzab f28941d;

    /* renamed from: e */
    private volatile boolean f28942e = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzm, zzb zzb, zzab zzab) {
        this.f28938a = blockingQueue;
        this.f28939b = zzm;
        this.f28940c = zzb;
        this.f28941d = zzab;
    }

    /* renamed from: a */
    public final void mo32021a() {
        this.f28942e = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                m30782b();
            } catch (InterruptedException e) {
                if (this.f28942e) {
                    Thread.currentThread().interrupt();
                    return;
                } else {
                    zzag.m24968b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        }
    }

    /* renamed from: b */
    private final void m30782b() throws InterruptedException {
        zzr zzr = (zzr) this.f28938a.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        zzr.mo32122a(3);
        try {
            zzr.mo32126a("network-queue-take");
            zzr.mo32132i();
            TrafficStats.setThreadStatsTag(zzr.mo32133j());
            zzp a = this.f28939b.mo29752a(zzr);
            zzr.mo32126a("network-http-complete");
            if (!a.f29064e || !zzr.mo32141z()) {
                zzy a2 = zzr.mo30196a(a);
                zzr.mo32126a("network-parse-complete");
                if (zzr.mo32137v() && a2.f29745b != null) {
                    this.f28940c.mo29888a(zzr.mo32134s(), a2.f29745b);
                    zzr.mo32126a("network-cache-written");
                }
                zzr.mo32140y();
                this.f28941d.mo29405a(zzr, a2);
                zzr.mo32125a(a2);
                zzr.mo32122a(4);
                return;
            }
            zzr.mo32128b("not-modified");
            zzr.mo32119A();
        } catch (zzaf e) {
            e.mo29668a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f28941d.mo29404a(zzr, e);
            zzr.mo32119A();
        } catch (Exception e2) {
            zzag.m24967a(e2, "Unhandled exception %s", e2.toString());
            zzaf zzaf = new zzaf((Throwable) e2);
            zzaf.mo29668a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f28941d.mo29404a(zzr, zzaf);
            zzr.mo32119A();
        } finally {
            zzr.mo32122a(4);
        }
    }
}
