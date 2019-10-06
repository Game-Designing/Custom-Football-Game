package com.moat.analytics.mobile.iro;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.moat.analytics.mobile.iro.t */
final class C11054t {
    /* access modifiers changed from: private */

    /* renamed from: ʻ */
    public static final Queue<C11059b> f33789 = new ConcurrentLinkedQueue();

    /* renamed from: ʽ */
    private static C11054t f33790;
    /* access modifiers changed from: private */

    /* renamed from: ʼ */
    public long f33791 = 60000;

    /* renamed from: ˊ */
    volatile int f33792 = 10;

    /* renamed from: ˊॱ */
    private long f33793 = BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS;

    /* renamed from: ˋ */
    volatile int f33794 = C11060c.f33810;
    /* access modifiers changed from: private */

    /* renamed from: ˋॱ */
    public final AtomicInteger f33795 = new AtomicInteger(0);

    /* renamed from: ˎ */
    volatile boolean f33796 = false;

    /* renamed from: ˏ */
    volatile boolean f33797 = false;
    /* access modifiers changed from: private */

    /* renamed from: ˏॱ */
    public final AtomicBoolean f33798 = new AtomicBoolean(false);

    /* renamed from: ॱ */
    volatile int f33799 = 200;
    /* access modifiers changed from: private */

    /* renamed from: ॱˊ */
    public final AtomicBoolean f33800 = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: ॱˋ */
    public volatile long f33801 = 0;
    /* access modifiers changed from: private */

    /* renamed from: ᐝ */
    public Handler f33802;

    /* renamed from: com.moat.analytics.mobile.iro.t$a */
    interface C11058a {
        /* renamed from: ॱ */
        void mo36109() throws C11043o;
    }

    /* renamed from: com.moat.analytics.mobile.iro.t$b */
    class C11059b {

        /* renamed from: ˋ */
        final C11058a f33807;

        /* renamed from: ॱ */
        final Long f33809;

        C11059b(Long l, C11058a aVar) {
            this.f33809 = l;
            this.f33807 = aVar;
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.t$c */
    enum C11060c {
        ;
        

        /* renamed from: ˊ */
        public static final int f33810 = 0;

        /* renamed from: ॱ */
        public static final int f33811 = 0;

        static {
            f33810 = 1;
            f33811 = 2;
            int[] iArr = {1, 2};
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.t$d */
    class C11061d implements Runnable {

        /* renamed from: ˋ */
        private final Handler f33812;
        /* access modifiers changed from: private */

        /* renamed from: ˎ */
        public final C110572 f33813;

        /* renamed from: ˏ */
        private final String f33814;

        private C11061d(String str, Handler handler, C110572 r4) {
            this.f33813 = r4;
            this.f33812 = handler;
            StringBuilder sb = new StringBuilder("https://z.moatads.com/");
            sb.append(str);
            sb.append("/android/");
            sb.append("2bc3418b93f01686fcbd1ebebcc04694651821b2".substring(0, 7));
            sb.append("/status.json");
            this.f33814 = sb.toString();
        }

        public final void run() {
            try {
                String r0 = m36404();
                final C11030i iVar = new C11030i(r0);
                C11054t.this.f33796 = iVar.mo36102();
                C11054t.this.f33797 = iVar.mo36104();
                C11054t.this.f33799 = iVar.mo36103();
                C11054t.this.f33792 = iVar.mo36106();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        try {
                            C11061d.this.f33813.mo36129(iVar);
                        } catch (Exception e) {
                            C11043o.m36351(e);
                        }
                    }
                });
                C11054t.this.f33801 = System.currentTimeMillis();
                C11054t.this.f33798.compareAndSet(true, false);
                if (r0 != null) {
                    C11054t.this.f33795.set(0);
                } else if (C11054t.this.f33795.incrementAndGet() < 10) {
                    C11054t.this.m36392(C11054t.this.f33791);
                }
            } catch (Exception e) {
                C11043o.m36351(e);
            }
            this.f33812.removeCallbacks(this);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                myLooper.quit();
            }
        }

        /* renamed from: ॱ */
        private String m36404() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f33814);
            sb.append("?ts=");
            sb.append(System.currentTimeMillis());
            sb.append("&v=2.4.0");
            try {
                return (String) C11035l.m36343(sb.toString()).get();
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* renamed from: com.moat.analytics.mobile.iro.t$e */
    interface C11063e {
        /* renamed from: ˋ */
        void mo36129(C11030i iVar) throws C11043o;
    }

    /* renamed from: ˋ */
    static synchronized C11054t m36390() {
        C11054t tVar;
        synchronized (C11054t.class) {
            if (f33790 == null) {
                f33790 = new C11054t();
            }
            tVar = f33790;
        }
        return tVar;
    }

    private C11054t() {
        try {
            this.f33802 = new Handler(Looper.getMainLooper());
        } catch (Exception e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ */
    public final void mo36125() {
        if (System.currentTimeMillis() - this.f33801 > this.f33793) {
            m36392(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ */
    public void m36392(final long j) {
        if (this.f33798.compareAndSet(false, true)) {
            C11011b.m36234(3, "OnOff", this, "Performing status check.");
            new Thread() {
                public final void run() {
                    Looper.prepare();
                    Handler handler = new Handler();
                    C11061d dVar = new C11061d("IRO", handler, new C11063e() {
                        /* renamed from: ˋ */
                        public final void mo36129(C11030i iVar) throws C11043o {
                            synchronized (C11054t.f33789) {
                                boolean z = ((C11031j) MoatAnalytics.getInstance()).f33735;
                                if (C11054t.this.f33794 != iVar.mo36105() || (C11054t.this.f33794 == C11060c.f33810 && z)) {
                                    C11054t.this.f33794 = iVar.mo36105();
                                    if (C11054t.this.f33794 == C11060c.f33810 && z) {
                                        C11054t.this.f33794 = C11060c.f33811;
                                    }
                                    if (C11054t.this.f33794 == C11060c.f33811) {
                                        C11011b.m36234(3, "OnOff", this, "Moat enabled - Version 2.4.0");
                                    }
                                    for (C11059b bVar : C11054t.f33789) {
                                        if (C11054t.this.f33794 == C11060c.f33811) {
                                            bVar.f33807.mo36109();
                                        }
                                    }
                                }
                                while (!C11054t.f33789.isEmpty()) {
                                    C11054t.f33789.remove();
                                }
                            }
                        }
                    });
                    handler.postDelayed(dVar, j);
                    Looper.loop();
                }
            }.start();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ */
    public final void mo36126(C11058a aVar) throws C11043o {
        if (this.f33794 == C11060c.f33811) {
            aVar.mo36109();
            return;
        }
        m36388();
        f33789.add(new C11059b(Long.valueOf(System.currentTimeMillis()), aVar));
        if (this.f33800.compareAndSet(false, true)) {
            this.f33802.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (C11054t.f33789.size() > 0) {
                            C11054t.m36388();
                            C11054t.this.f33802.postDelayed(this, 60000);
                            return;
                        }
                        C11054t.this.f33800.compareAndSet(true, false);
                        C11054t.this.f33802.removeCallbacks(this);
                    } catch (Exception e) {
                        C11043o.m36351(e);
                    }
                }
            }, 60000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ */
    public static void m36388() {
        synchronized (f33789) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it = f33789.iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - ((C11059b) it.next()).f33809.longValue() >= 60000) {
                    it.remove();
                }
            }
            if (f33789.size() >= 15) {
                for (int i = 0; i < 5; i++) {
                    f33789.remove();
                }
            }
        }
    }
}
