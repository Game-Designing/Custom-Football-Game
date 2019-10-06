package com.moat.analytics.mobile.vng;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.moat.analytics.mobile.vng.w */
class C11198w {

    /* renamed from: g */
    private static C11198w f34156g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Queue<C11205c> f34157h = new ConcurrentLinkedQueue();

    /* renamed from: a */
    volatile C11206d f34158a = C11206d.OFF;

    /* renamed from: b */
    volatile boolean f34159b = false;

    /* renamed from: c */
    volatile boolean f34160c = false;

    /* renamed from: d */
    volatile int f34161d = 200;

    /* renamed from: e */
    private long f34162e = BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f34163f = 60000;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f34164i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicBoolean f34165j = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile long f34166k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final AtomicInteger f34167l = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final AtomicBoolean f34168m = new AtomicBoolean(false);

    /* renamed from: com.moat.analytics.mobile.vng.w$a */
    private class C11202a implements Runnable {

        /* renamed from: b */
        private final Handler f34174b;

        /* renamed from: c */
        private final String f34175c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C11207e f34176d;

        private C11202a(String str, Handler handler, C11207e eVar) {
            this.f34176d = eVar;
            this.f34174b = handler;
            StringBuilder sb = new StringBuilder();
            sb.append("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("3f2ae9c1894282b5e0222f0d06bbf457191f816f".substring(0, 7));
            sb.append("/status.json");
            this.f34175c = sb.toString();
        }

        /* renamed from: a */
        private void m36861a() {
            String b = m36862b();
            final C11175l lVar = new C11175l(b);
            C11198w.this.f34159b = lVar.mo36369a();
            C11198w.this.f34160c = lVar.mo36370b();
            C11198w.this.f34161d = lVar.mo36371c();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        C11202a.this.f34176d.mo36388a(lVar);
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            });
            C11198w.this.f34166k = System.currentTimeMillis();
            C11198w.this.f34168m.compareAndSet(true, false);
            if (b != null) {
                C11198w.this.f34167l.set(0);
            } else if (C11198w.this.f34167l.incrementAndGet() < 10) {
                C11198w wVar = C11198w.this;
                wVar.m36846a(wVar.f34163f);
            }
        }

        /* renamed from: b */
        private String m36862b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f34175c);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=");
            sb.append("2.2.0");
            try {
                return (String) C11186q.m36821a(sb.toString()).mo36305b();
            } catch (Exception e) {
                return null;
            }
        }

        public void run() {
            try {
                m36861a();
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
            this.f34174b.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$b */
    interface C11204b {
        /* renamed from: b */
        void mo36367b();

        /* renamed from: c */
        void mo36368c();
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$c */
    private class C11205c {

        /* renamed from: a */
        final Long f34179a;

        /* renamed from: b */
        final C11204b f34180b;

        C11205c(Long l, C11204b bVar) {
            this.f34179a = l;
            this.f34180b = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$d */
    enum C11206d {
        OFF,
        ON
    }

    /* renamed from: com.moat.analytics.mobile.vng.w$e */
    interface C11207e {
        /* renamed from: a */
        void mo36388a(C11175l lVar);
    }

    private C11198w() {
        try {
            this.f34164i = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: a */
    static synchronized C11198w m36845a() {
        C11198w wVar;
        synchronized (C11198w.class) {
            if (f34156g == null) {
                f34156g = new C11198w();
            }
            wVar = f34156g;
        }
        return wVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36846a(final long j) {
        if (this.f34168m.compareAndSet(false, true)) {
            C11185p.m36817a(3, "OnOff", (Object) this, "Performing status check.");
            new Thread() {
                public void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    C11202a aVar = new C11202a("VNG", handler, new C11207e() {
                        /* renamed from: a */
                        public void mo36388a(C11175l lVar) {
                            synchronized (C11198w.f34157h) {
                                boolean z = ((C11174k) MoatAnalytics.getInstance()).f34119a;
                                if (C11198w.this.f34158a != lVar.mo36372d() || (C11198w.this.f34158a == C11206d.OFF && z)) {
                                    C11198w.this.f34158a = lVar.mo36372d();
                                    if (C11198w.this.f34158a == C11206d.OFF && z) {
                                        C11198w.this.f34158a = C11206d.ON;
                                    }
                                    if (C11198w.this.f34158a == C11206d.ON) {
                                        C11185p.m36817a(3, "OnOff", (Object) this, "Moat enabled - Version 2.2.0");
                                    }
                                    for (C11205c cVar : C11198w.f34157h) {
                                        if (C11198w.this.f34158a == C11206d.ON) {
                                            cVar.f34180b.mo36367b();
                                        } else {
                                            cVar.f34180b.mo36368c();
                                        }
                                    }
                                }
                                while (!C11198w.f34157h.isEmpty()) {
                                    C11198w.f34157h.remove();
                                }
                            }
                        }
                    });
                    handler.postDelayed(aVar, j);
                    Looper.loop();
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36853d() {
        synchronized (f34157h) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f34157h.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C11205c) it.next()).f34179a.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f34157h.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f34157h.remove();
                }
            }
        }
    }

    /* renamed from: e */
    private void m36855e() {
        if (this.f34165j.compareAndSet(false, true)) {
            this.f34164i.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (C11198w.f34157h.size() > 0) {
                            C11198w.this.m36853d();
                            C11198w.this.f34164i.postDelayed(this, 60000);
                            return;
                        }
                        C11198w.this.f34165j.compareAndSet(true, false);
                        C11198w.this.f34164i.removeCallbacks(this);
                    } catch (Exception e) {
                        C11176m.m36783a(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36385a(C11204b bVar) {
        if (this.f34158a == C11206d.ON) {
            bVar.mo36367b();
            return;
        }
        m36853d();
        f34157h.add(new C11205c(Long.valueOf(System.currentTimeMillis()), bVar));
        m36855e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36386b() {
        if (System.currentTimeMillis() - this.f34166k > this.f34162e) {
            m36846a(0);
        }
    }
}
