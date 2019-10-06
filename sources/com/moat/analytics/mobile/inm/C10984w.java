package com.moat.analytics.mobile.inm;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.moat.analytics.mobile.inm.w */
class C10984w {

    /* renamed from: h */
    private static C10984w f33559h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Queue<C10991c> f33560i = new ConcurrentLinkedQueue();

    /* renamed from: a */
    volatile C10992d f33561a = C10992d.OFF;

    /* renamed from: b */
    volatile boolean f33562b = false;

    /* renamed from: c */
    volatile boolean f33563c = false;

    /* renamed from: d */
    volatile int f33564d = 200;

    /* renamed from: e */
    volatile int f33565e = 10;

    /* renamed from: f */
    private long f33566f = BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f33567g = 60000;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f33568j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final AtomicBoolean f33569k = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public volatile long f33570l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final AtomicInteger f33571m = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final AtomicBoolean f33572n = new AtomicBoolean(false);

    /* renamed from: com.moat.analytics.mobile.inm.w$a */
    private class C10988a implements Runnable {

        /* renamed from: b */
        private final Handler f33578b;

        /* renamed from: c */
        private final String f33579c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C10993e f33580d;

        private C10988a(String str, Handler handler, C10993e eVar) {
            this.f33580d = eVar;
            this.f33578b = handler;
            StringBuilder sb = new StringBuilder("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("c334ae83accfebb8da23104450c896463c9cfab7".substring(0, 7));
            sb.append("/status.json");
            this.f33579c = sb.toString();
        }

        /* renamed from: a */
        private void m36167a() {
            String b = m36168b();
            final C10959l lVar = new C10959l(b);
            C10984w.this.f33562b = lVar.mo35956a();
            C10984w.this.f33563c = lVar.mo35957b();
            C10984w.this.f33564d = lVar.mo35958c();
            C10984w.this.f33565e = lVar.mo35959d();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    try {
                        C10988a.this.f33580d.mo35978a(lVar);
                    } catch (Exception e) {
                        C10960m.m36077a(e);
                    }
                }
            });
            C10984w.this.f33570l = System.currentTimeMillis();
            C10984w.this.f33572n.compareAndSet(true, false);
            if (b != null) {
                C10984w.this.f33571m.set(0);
            } else if (C10984w.this.f33571m.incrementAndGet() < 10) {
                C10984w wVar = C10984w.this;
                wVar.m36152a(wVar.f33567g);
            }
        }

        /* renamed from: b */
        private String m36168b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f33579c);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=2.5.0");
            try {
                return (String) C10970q.m36118a(sb.toString()).mo35880b();
            } catch (Exception e) {
                return null;
            }
        }

        public void run() {
            try {
                m36167a();
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
            this.f33578b.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$b */
    interface C10990b {
        /* renamed from: c */
        void mo35954c();

        /* renamed from: d */
        void mo35955d();
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$c */
    private class C10991c {

        /* renamed from: a */
        final Long f33583a;

        /* renamed from: b */
        final C10990b f33584b;

        C10991c(Long l, C10990b bVar) {
            this.f33583a = l;
            this.f33584b = bVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$d */
    enum C10992d {
        OFF,
        ON
    }

    /* renamed from: com.moat.analytics.mobile.inm.w$e */
    interface C10993e {
        /* renamed from: a */
        void mo35978a(C10959l lVar);
    }

    private C10984w() {
        try {
            this.f33568j = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    static synchronized C10984w m36151a() {
        C10984w wVar;
        synchronized (C10984w.class) {
            if (f33559h == null) {
                f33559h = new C10984w();
            }
            wVar = f33559h;
        }
        return wVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36152a(final long j) {
        if (this.f33572n.compareAndSet(false, true)) {
            C10969p.m36113a(3, "OnOff", (Object) this, "Performing status check.");
            new Thread() {
                public void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    C10988a aVar = new C10988a("INM", handler, new C10993e() {
                        /* renamed from: a */
                        public void mo35978a(C10959l lVar) {
                            synchronized (C10984w.f33560i) {
                                boolean z = ((C10958k) MoatAnalytics.getInstance()).f33506a;
                                if (C10984w.this.f33561a != lVar.mo35960e() || (C10984w.this.f33561a == C10992d.OFF && z)) {
                                    C10984w.this.f33561a = lVar.mo35960e();
                                    if (C10984w.this.f33561a == C10992d.OFF && z) {
                                        C10984w.this.f33561a = C10992d.ON;
                                    }
                                    if (C10984w.this.f33561a == C10992d.ON) {
                                        C10969p.m36113a(3, "OnOff", (Object) this, "Moat enabled - Version 2.5.0");
                                    }
                                    for (C10991c cVar : C10984w.f33560i) {
                                        if (C10984w.this.f33561a == C10992d.ON) {
                                            cVar.f33584b.mo35954c();
                                        } else {
                                            cVar.f33584b.mo35955d();
                                        }
                                    }
                                }
                                while (!C10984w.f33560i.isEmpty()) {
                                    C10984w.f33560i.remove();
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
    public void m36159d() {
        synchronized (f33560i) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f33560i.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C10991c) it.next()).f33583a.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f33560i.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f33560i.remove();
                }
            }
        }
    }

    /* renamed from: e */
    private void m36161e() {
        if (this.f33569k.compareAndSet(false, true)) {
            this.f33568j.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (C10984w.f33560i.size() > 0) {
                            C10984w.this.m36159d();
                            C10984w.this.f33568j.postDelayed(this, 60000);
                            return;
                        }
                        C10984w.this.f33569k.compareAndSet(true, false);
                        C10984w.this.f33568j.removeCallbacks(this);
                    } catch (Exception e) {
                        C10960m.m36077a(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35975a(C10990b bVar) {
        if (this.f33561a == C10992d.ON) {
            bVar.mo35954c();
            return;
        }
        m36159d();
        f33560i.add(new C10991c(Long.valueOf(System.currentTimeMillis()), bVar));
        m36161e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35976b() {
        if (System.currentTimeMillis() - this.f33570l > this.f33566f) {
            m36152a(0);
        }
    }
}
