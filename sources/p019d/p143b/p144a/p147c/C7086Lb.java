package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.Lb */
public class C7086Lb {

    /* renamed from: a */
    private final C7071Hc f13287a;

    /* renamed from: b */
    private final long f13288b;

    /* renamed from: c */
    private final C7072I f13289c;

    /* renamed from: d */
    private final C7076J f13290d;

    /* renamed from: e */
    private final C7142c f13291e;

    /* renamed from: f */
    private final Object f13292f = new Object();

    /* renamed from: g */
    private long f13293g;

    /* renamed from: h */
    private long f13294h;

    /* renamed from: i */
    private long f13295i;

    public C7086Lb(C7251a aVar, C7267q qVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (qVar != null) {
            C7142c cVar = (C7142c) qVar;
            this.f13289c = cVar.mo23062g();
            this.f13290d = cVar.mo23061f();
            this.f13291e = cVar;
            if (aVar instanceof C7071Hc) {
                this.f13287a = (C7071Hc) aVar;
                this.f13288b = this.f13287a.mo22404f();
                this.f13289c.mo22853a(C7162h.f13562b, (long) this.f13287a.mo22763o().ordinal(), this.f13287a);
                return;
            }
            this.f13287a = null;
            this.f13288b = 0;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    static void m14818a(long j, C7071Hc hc, C7142c cVar) {
        if (hc != null && cVar != null) {
            cVar.mo23062g().mo22853a(C7162h.f13563c, j, hc);
        }
    }

    /* renamed from: a */
    static void m14819a(C7071Hc hc, C7142c cVar) {
        if (hc != null && cVar != null) {
            cVar.mo23062g().mo22853a(C7162h.f13564d, hc.mo22849l(), hc);
            cVar.mo23062g().mo22853a(C7162h.f13565e, hc.mo22850m(), hc);
        }
    }

    /* renamed from: a */
    private void m14820a(C7162h hVar) {
        synchronized (this.f13292f) {
            if (this.f13293g > 0) {
                this.f13289c.mo22853a(hVar, System.currentTimeMillis() - this.f13293g, this.f13287a);
            }
        }
    }

    /* renamed from: a */
    static void m14821a(C7174k kVar, C7071Hc hc, C7142c cVar) {
        if (hc != null && cVar != null && kVar != null) {
            cVar.mo23062g().mo22853a(C7162h.f13566f, kVar.mo23182a(), hc);
            cVar.mo23062g().mo22853a(C7162h.f13567g, kVar.mo23184b(), hc);
            cVar.mo23062g().mo22853a(C7162h.f13582v, kVar.mo23188e(), hc);
            cVar.mo23062g().mo22853a(C7162h.f13583w, kVar.mo23189f(), hc);
        }
    }

    /* renamed from: a */
    public void mo22884a() {
        this.f13289c.mo22853a(C7162h.f13571k, this.f13290d.mo22861a("ad_imp"), this.f13287a);
        this.f13289c.mo22853a(C7162h.f13570j, this.f13290d.mo22861a("ad_imp_session"), this.f13287a);
        synchronized (this.f13292f) {
            long j = 0;
            if (this.f13288b > 0) {
                this.f13293g = System.currentTimeMillis();
                this.f13289c.mo22853a(C7162h.f13569i, this.f13293g - this.f13291e.mo23074s(), this.f13287a);
                this.f13289c.mo22853a(C7162h.f13568h, this.f13293g - this.f13288b, this.f13287a);
                if (C7202r.m15406a(this.f13291e.mo23068m(), this.f13291e)) {
                    j = 1;
                }
                this.f13289c.mo22853a(C7162h.f13577q, j, this.f13287a);
            }
        }
    }

    /* renamed from: a */
    public void mo22885a(long j) {
        this.f13289c.mo22853a(C7162h.f13578r, j, this.f13287a);
    }

    /* renamed from: b */
    public void mo22886b() {
        synchronized (this.f13292f) {
            if (this.f13294h < 1) {
                this.f13294h = System.currentTimeMillis();
                if (this.f13293g > 0) {
                    this.f13289c.mo22853a(C7162h.f13574n, this.f13294h - this.f13293g, this.f13287a);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo22887b(long j) {
        this.f13289c.mo22853a(C7162h.f13579s, j, this.f13287a);
    }

    /* renamed from: c */
    public void mo22888c() {
        m14820a(C7162h.f13572l);
    }

    /* renamed from: c */
    public void mo22889c(long j) {
        synchronized (this.f13292f) {
            if (this.f13295i < 1) {
                this.f13295i = j;
                this.f13289c.mo22853a(C7162h.f13580t, j, this.f13287a);
            }
        }
    }

    /* renamed from: d */
    public void mo22890d() {
        m14820a(C7162h.f13575o);
    }

    /* renamed from: e */
    public void mo22891e() {
        m14820a(C7162h.f13576p);
    }

    /* renamed from: f */
    public void mo22892f() {
        m14820a(C7162h.f13573m);
    }

    /* renamed from: g */
    public void mo22893g() {
        this.f13289c.mo22853a(C7162h.f13581u, 1, this.f13287a);
    }
}
