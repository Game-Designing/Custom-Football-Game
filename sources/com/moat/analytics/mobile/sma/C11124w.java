package com.moat.analytics.mobile.sma;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.moat.analytics.mobile.sma.w */
class C11124w {

    /* renamed from: g */
    private static C11124w f33969g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Queue<C11131c> f33970h = new ConcurrentLinkedQueue();

    /* renamed from: a */
    volatile C11132d f33971a = C11132d.OFF;

    /* renamed from: b */
    volatile boolean f33972b = false;

    /* renamed from: c */
    volatile boolean f33973c = false;

    /* renamed from: d */
    volatile int f33974d = 200;

    /* renamed from: e */
    private long f33975e = BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public long f33976f = 60000;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f33977i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final AtomicBoolean f33978j = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile long f33979k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final AtomicInteger f33980l = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final AtomicBoolean f33981m = new AtomicBoolean(false);

    /* renamed from: com.moat.analytics.mobile.sma.w$a */
    private class C11128a implements Runnable {

        /* renamed from: b */
        private final Handler f33987b;

        /* renamed from: c */
        private final String f33988c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C11133e f33989d;

        private C11128a(String str, Handler handler, C11133e eVar) {
            this.f33989d = eVar;
            this.f33987b = handler;
            StringBuilder sb = new StringBuilder();
            sb.append("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("953154ac4464acdcdc8f392f879c5bd5798cd286".substring(0, 7));
            sb.append("/status.json");
            this.f33988c = sb.toString();
        }

        /* renamed from: a */
        private void m36621a() {
            String b = m36622b();
            final C11101l lVar = new C11101l(b);
            C11124w.this.f33972b = lVar.mo36237a();
            C11124w.this.f33973c = lVar.mo36238b();
            C11124w.this.f33974d = lVar.mo36239c();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        C11128a.this.f33989d.mo36256a(lVar);
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            });
            C11124w.this.f33979k = System.currentTimeMillis();
            C11124w.this.f33981m.compareAndSet(true, false);
            if (b != null) {
                C11124w.this.f33980l.set(0);
            } else if (C11124w.this.f33980l.incrementAndGet() < 10) {
                C11124w wVar = C11124w.this;
                wVar.m36606a(wVar.f33976f);
            }
        }

        /* renamed from: b */
        private String m36622b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f33988c);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=");
            sb.append("2.3.0");
            try {
                return (String) C11112q.m36581a(sb.toString()).mo36175b();
            } catch (Exception e) {
                return null;
            }
        }

        public void run() {
            try {
                m36621a();
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
            this.f33987b.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.sma.w$b */
    interface C11130b {
        /* renamed from: b */
        void mo36235b();

        /* renamed from: c */
        void mo36236c();
    }

    /* renamed from: com.moat.analytics.mobile.sma.w$c */
    private class C11131c {

        /* renamed from: a */
        final Long f33992a;

        /* renamed from: b */
        final C11130b f33993b;

        C11131c(Long l, C11130b bVar) {
            this.f33992a = l;
            this.f33993b = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.sma.w$d */
    enum C11132d {
        OFF,
        ON
    }

    /* renamed from: com.moat.analytics.mobile.sma.w$e */
    interface C11133e {
        /* renamed from: a */
        void mo36256a(C11101l lVar);
    }

    private C11124w() {
        try {
            this.f33977i = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: a */
    static synchronized C11124w m36605a() {
        C11124w wVar;
        synchronized (C11124w.class) {
            if (f33969g == null) {
                f33969g = new C11124w();
            }
            wVar = f33969g;
        }
        return wVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36606a(final long j) {
        if (this.f33981m.compareAndSet(false, true)) {
            C11111p.m36577a(3, "OnOff", (Object) this, "Performing status check.");
            new Thread() {
                public void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    C11128a aVar = new C11128a("SMA", handler, new C11133e() {
                        /* renamed from: a */
                        public void mo36256a(C11101l lVar) {
                            synchronized (C11124w.f33970h) {
                                boolean z = ((C11100k) MoatAnalytics.getInstance()).f33932a;
                                if (C11124w.this.f33971a != lVar.mo36240d() || (C11124w.this.f33971a == C11132d.OFF && z)) {
                                    C11124w.this.f33971a = lVar.mo36240d();
                                    if (C11124w.this.f33971a == C11132d.OFF && z) {
                                        C11124w.this.f33971a = C11132d.ON;
                                    }
                                    if (C11124w.this.f33971a == C11132d.ON) {
                                        C11111p.m36577a(3, "OnOff", (Object) this, "Moat enabled - Version 2.3.0");
                                    }
                                    for (C11131c cVar : C11124w.f33970h) {
                                        if (C11124w.this.f33971a == C11132d.ON) {
                                            cVar.f33993b.mo36235b();
                                        } else {
                                            cVar.f33993b.mo36236c();
                                        }
                                    }
                                }
                                while (!C11124w.f33970h.isEmpty()) {
                                    C11124w.f33970h.remove();
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
    public void m36613d() {
        synchronized (f33970h) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f33970h.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C11131c) it.next()).f33992a.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f33970h.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f33970h.remove();
                }
            }
        }
    }

    /* renamed from: e */
    private void m36615e() {
        if (this.f33978j.compareAndSet(false, true)) {
            this.f33977i.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (C11124w.f33970h.size() > 0) {
                            C11124w.this.m36613d();
                            C11124w.this.f33977i.postDelayed(this, 60000);
                            return;
                        }
                        C11124w.this.f33978j.compareAndSet(true, false);
                        C11124w.this.f33977i.removeCallbacks(this);
                    } catch (Exception e) {
                        C11102m.m36543a(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36253a(C11130b bVar) {
        if (this.f33971a == C11132d.ON) {
            bVar.mo36235b();
            return;
        }
        m36613d();
        f33970h.add(new C11131c(Long.valueOf(System.currentTimeMillis()), bVar));
        m36615e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36254b() {
        if (System.currentTimeMillis() - this.f33979k > this.f33975e) {
            m36606a(0);
        }
    }
}
