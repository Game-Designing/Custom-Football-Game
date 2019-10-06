package p346g.p347a.p356a;

import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import p346g.p347a.p356a.p358b.C14114b;
import p346g.p347a.p356a.p358b.C14120c;
import p346g.p347a.p356a.p358b.p359a.C14112b;
import p346g.p347a.p356a.p358b.p359a.C14113c;
import p346g.p347a.p356a.p358b.p360b.C14115a;
import p346g.p347a.p356a.p358b.p360b.C14116b;
import p346g.p347a.p356a.p358b.p360b.C14118d;
import p346g.p347a.p356a.p358b.p360b.C14119e;

/* renamed from: g.a.a.l */
/* compiled from: DNSTaskStarter */
public interface C14149l {

    /* renamed from: g.a.a.l$a */
    /* compiled from: DNSTaskStarter */
    public static final class C14150a implements C14149l {

        /* renamed from: a */
        private final C14164v f42982a;

        /* renamed from: b */
        private final Timer f42983b;

        /* renamed from: c */
        private final Timer f42984c;

        /* renamed from: g.a.a.l$a$a */
        /* compiled from: DNSTaskStarter */
        public static class C14151a extends Timer {

            /* renamed from: a */
            private volatile boolean f42985a = false;

            public C14151a(String name, boolean isDaemon) {
                super(name, isDaemon);
            }

            public synchronized void cancel() {
                if (!this.f42985a) {
                    this.f42985a = true;
                    super.cancel();
                }
            }

            public synchronized void schedule(TimerTask task, long delay) {
                if (!this.f42985a) {
                    super.schedule(task, delay);
                }
            }

            public synchronized void schedule(TimerTask task, Date time) {
                if (!this.f42985a) {
                    super.schedule(task, time);
                }
            }

            public synchronized void schedule(TimerTask task, long delay, long period) {
                if (!this.f42985a) {
                    super.schedule(task, delay, period);
                }
            }

            public synchronized void schedule(TimerTask task, Date firstTime, long period) {
                if (!this.f42985a) {
                    super.schedule(task, firstTime, period);
                }
            }

            public synchronized void scheduleAtFixedRate(TimerTask task, long delay, long period) {
                if (!this.f42985a) {
                    super.scheduleAtFixedRate(task, delay, period);
                }
            }

            public synchronized void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
                if (!this.f42985a) {
                    super.scheduleAtFixedRate(task, firstTime, period);
                }
            }
        }

        public C14150a(C14164v jmDNSImpl) {
            this.f42982a = jmDNSImpl;
            StringBuilder sb = new StringBuilder();
            String str = "JmDNS(";
            sb.append(str);
            sb.append(this.f42982a.mo44087G());
            sb.append(").Timer");
            this.f42983b = new C14151a(sb.toString(), true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(this.f42982a.mo44087G());
            sb2.append(").State.Timer");
            this.f42984c = new C14151a(sb2.toString(), true);
        }

        /* renamed from: e */
        public void mo44033e() {
            this.f42983b.purge();
        }

        /* renamed from: i */
        public void mo44037i() {
            this.f42984c.purge();
        }

        /* renamed from: b */
        public void mo44030b() {
            this.f42983b.cancel();
        }

        /* renamed from: a */
        public void mo44026a() {
            this.f42984c.cancel();
        }

        /* renamed from: c */
        public void mo44031c() {
            new C14118d(this.f42982a).mo43909a(this.f42984c);
        }

        /* renamed from: h */
        public void mo44036h() {
            new C14115a(this.f42982a).mo43894a(this.f42984c);
        }

        /* renamed from: d */
        public void mo44032d() {
            new C14119e(this.f42982a).mo43911a(this.f42984c);
        }

        /* renamed from: f */
        public void mo44034f() {
            new C14116b(this.f42982a).mo43900a(this.f42984c);
        }

        /* renamed from: g */
        public void mo44035g() {
            new C14114b(this.f42982a).mo43889a(this.f42983b);
        }

        /* renamed from: a */
        public void mo44027a(C14096C info) {
            new C14112b(this.f42982a, info).mo43884a(this.f42983b);
        }

        /* renamed from: a */
        public void mo44029a(String type) {
            new C14113c(this.f42982a, type).mo43884a(this.f42983b);
        }

        /* renamed from: a */
        public void mo44028a(C14123d in, InetAddress addr, int port) {
            new C14120c(this.f42982a, in, addr, port).mo43913a(this.f42983b);
        }
    }

    /* renamed from: g.a.a.l$b */
    /* compiled from: DNSTaskStarter */
    public static final class C14152b {

        /* renamed from: a */
        private static volatile C14152b f42986a;

        /* renamed from: b */
        private static final AtomicReference<C14153a> f42987b = new AtomicReference<>();

        /* renamed from: c */
        private final ConcurrentMap<C14164v, C14149l> f42988c = new ConcurrentHashMap(20);

        /* renamed from: g.a.a.l$b$a */
        /* compiled from: DNSTaskStarter */
        public interface C14153a {
            /* renamed from: a */
            C14149l mo44047a(C14164v vVar);
        }

        private C14152b() {
        }

        /* renamed from: c */
        protected static C14149l m45424c(C14164v jmDNSImpl) {
            C14149l instance = null;
            C14153a delegate = (C14153a) f42987b.get();
            if (delegate != null) {
                instance = delegate.mo44047a(jmDNSImpl);
            }
            return instance != null ? instance : new C14150a(jmDNSImpl);
        }

        /* renamed from: a */
        public static C14152b m45423a() {
            if (f42986a == null) {
                synchronized (C14152b.class) {
                    if (f42986a == null) {
                        f42986a = new C14152b();
                    }
                }
            }
            return f42986a;
        }

        /* renamed from: b */
        public C14149l mo44046b(C14164v jmDNSImpl) {
            C14149l starter = (C14149l) this.f42988c.get(jmDNSImpl);
            if (starter != null) {
                return starter;
            }
            this.f42988c.putIfAbsent(jmDNSImpl, m45424c(jmDNSImpl));
            return (C14149l) this.f42988c.get(jmDNSImpl);
        }

        /* renamed from: a */
        public void mo44045a(C14164v jmDNSImpl) {
            this.f42988c.remove(jmDNSImpl);
        }
    }

    /* renamed from: a */
    void mo44026a();

    /* renamed from: a */
    void mo44027a(C14096C c);

    /* renamed from: a */
    void mo44028a(C14123d dVar, InetAddress inetAddress, int i);

    /* renamed from: a */
    void mo44029a(String str);

    /* renamed from: b */
    void mo44030b();

    /* renamed from: c */
    void mo44031c();

    /* renamed from: d */
    void mo44032d();

    /* renamed from: e */
    void mo44033e();

    /* renamed from: f */
    void mo44034f();

    /* renamed from: g */
    void mo44035g();

    /* renamed from: h */
    void mo44036h();

    /* renamed from: i */
    void mo44037i();
}
