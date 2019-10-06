package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p019d.p143b.p149c.C7248b;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.gb */
abstract class C7160gb implements C7060F, C7248b {

    /* renamed from: a */
    protected final C7142c f13541a;

    /* renamed from: b */
    protected final C7262l f13542b;

    /* renamed from: c */
    protected final Object f13543c = new Object();

    /* renamed from: d */
    protected final Map<C7059Ec, C7164hb> f13544d = new HashMap();

    /* renamed from: e */
    protected final Map<C7059Ec, C7164hb> f13545e = new HashMap();

    /* renamed from: f */
    protected final Map<C7059Ec, Object> f13546f = new HashMap();

    /* renamed from: g */
    protected final Set<C7059Ec> f13547g = new HashSet();

    C7160gb(C7142c cVar) {
        this.f13541a = cVar;
        this.f13542b = cVar.mo23049b();
        mo22955a();
    }

    /* renamed from: k */
    private C7164hb m15193k(C7059Ec ec) {
        return (C7164hb) this.f13544d.get(ec);
    }

    /* renamed from: l */
    private C7164hb m15194l(C7059Ec ec) {
        return (C7164hb) this.f13545e.get(ec);
    }

    /* renamed from: m */
    private C7164hb m15195m(C7059Ec ec) {
        synchronized (this.f13543c) {
            C7164hb l = m15194l(ec);
            if (l != null && l.mo23161a() > 0) {
                return l;
            }
            C7164hb k = m15193k(ec);
            return k;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C7059Ec mo22953a(C7231ya yaVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C7184mb mo22954a(C7059Ec ec);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo22955a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo22956a(Object obj, C7059Ec ec, int i);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo22957a(Object obj, C7231ya yaVar);

    /* renamed from: a */
    public void mo22958a(LinkedHashSet<C7059Ec> linkedHashSet) {
        Map<C7059Ec, Object> map = this.f13546f;
        if (map != null && !map.isEmpty()) {
            synchronized (this.f13543c) {
                Iterator it = this.f13546f.keySet().iterator();
                while (it.hasNext()) {
                    C7059Ec ec = (C7059Ec) it.next();
                    if (!ec.mo22814m() && !linkedHashSet.contains(ec)) {
                        Object obj = this.f13546f.get(ec);
                        it.remove();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to load ad for zone (");
                        sb.append(ec.mo22799a());
                        sb.append("). Please check that the zone has been added to your AppLovin account.");
                        this.f13542b.mo22921e("AppLovinAdService", sb.toString());
                        mo22956a(obj, ec, -7);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo23140a(C7059Ec ec, Object obj) {
        boolean z;
        synchronized (this.f13543c) {
            if (!mo23147j(ec)) {
                mo22960b(ec, obj);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public void mo22959b(C7059Ec ec, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            mo22965i(ec);
        }
    }

    /* renamed from: b */
    public void mo22960b(C7059Ec ec, Object obj) {
        synchronized (this.f13543c) {
            if (this.f13546f.containsKey(ec)) {
                this.f13542b.mo22913a("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f13546f.put(ec, obj);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23141b(C7231ya yaVar) {
        mo22965i(mo22953a(yaVar));
    }

    /* renamed from: b */
    public boolean mo23142b(C7059Ec ec) {
        return this.f13546f.containsKey(ec);
    }

    /* renamed from: c */
    public C7231ya mo23143c(C7059Ec ec) {
        C7231ya f;
        synchronized (this.f13543c) {
            C7164hb m = m15195m(ec);
            f = m != null ? m.mo23168f() : null;
        }
        return f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23144c(C7059Ec ec, int i) {
        Object remove;
        C7262l lVar = this.f13542b;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to pre-load an ad of zone ");
        sb.append(ec);
        sb.append(", error code ");
        sb.append(i);
        lVar.mo22918c("PreloadManager", sb.toString());
        synchronized (this.f13543c) {
            remove = this.f13546f.remove(ec);
            this.f13547g.add(ec);
        }
        if (remove != null) {
            try {
                mo22956a(remove, ec, i);
            } catch (Throwable th) {
                this.f13541a.mo23049b().mo22919c("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo23145c(C7231ya yaVar) {
        Object obj;
        C7262l lVar;
        String str;
        String sb;
        C7059Ec a = mo22953a(yaVar);
        boolean l = a.mo22813l();
        synchronized (this.f13543c) {
            obj = this.f13546f.get(a);
            this.f13546f.remove(a);
            this.f13547g.add(a);
            if (obj != null) {
                if (!l) {
                    lVar = this.f13542b;
                    str = "PreloadManager";
                    sb = "Additional callback found or dummy ads are enabled; skipping enqueue...";
                    lVar.mo22918c(str, sb);
                }
            }
            m15193k(a).mo23163a(yaVar);
            lVar = this.f13542b;
            str = "PreloadManager";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad enqueued: ");
            sb2.append(yaVar);
            sb = sb2.toString();
            lVar.mo22918c(str, sb);
        }
        if (obj != null) {
            C7262l lVar2 = this.f13542b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Called additional callback regarding ");
            sb3.append(yaVar);
            lVar2.mo22918c("PreloadManager", sb3.toString());
            if (l) {
                try {
                    mo22957a(obj, (C7231ya) new C7048C(a, this.f13541a));
                } catch (Throwable th) {
                    this.f13541a.mo23049b().mo22919c("PreloadManager", "Encountered throwable while notifying user callback", th);
                }
            } else {
                mo22957a(obj, yaVar);
                mo23141b(yaVar);
            }
        }
        C7262l lVar3 = this.f13542b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Pulled ad from network and saved to preload cache: ");
        sb4.append(yaVar);
        lVar3.mo22918c("PreloadManager", sb4.toString());
    }

    /* renamed from: d */
    public C7231ya mo23146d(C7059Ec ec) {
        C7231ya e;
        synchronized (this.f13543c) {
            C7164hb m = m15195m(ec);
            e = m != null ? m.mo23167e() : null;
        }
        return e;
    }

    /* renamed from: e */
    public C7231ya mo22961e(C7059Ec ec) {
        C7231ya yaVar;
        String str;
        StringBuilder sb;
        C7262l lVar;
        C7231ya c;
        synchronized (this.f13543c) {
            C7164hb k = m15193k(ec);
            yaVar = null;
            if (k != null) {
                if (ec.mo22813l()) {
                    C7164hb l = m15194l(ec);
                    if (l.mo23165c()) {
                        c = new C7048C(ec, this.f13541a);
                    } else if (k.mo23161a() > 0) {
                        l.mo23163a(k.mo23167e());
                        c = new C7048C(ec, this.f13541a);
                    } else if (l.mo23161a() > 0 && ((Boolean) this.f13541a.mo23039a(C7196pb.f13767Vc)).booleanValue()) {
                        c = new C7048C(ec, this.f13541a);
                    }
                    yaVar = c;
                } else {
                    yaVar = k.mo23167e();
                }
            }
        }
        if (yaVar != null) {
            lVar = this.f13542b;
            sb = new StringBuilder();
            str = "Retrieved ad of zone ";
        } else {
            lVar = this.f13542b;
            sb = new StringBuilder();
            str = "Unable to retrieve ad of zone ";
        }
        sb.append(str);
        sb.append(ec);
        sb.append("...");
        lVar.mo22918c("PreloadManager", sb.toString());
        return yaVar;
    }

    /* renamed from: f */
    public boolean mo22962f(C7059Ec ec) {
        boolean c;
        synchronized (this.f13543c) {
            C7164hb k = m15193k(ec);
            c = k != null ? k.mo23165c() : false;
        }
        return c;
    }

    /* renamed from: g */
    public void mo22963g(C7059Ec ec) {
        if (ec != null) {
            int i = 0;
            synchronized (this.f13543c) {
                C7164hb k = m15193k(ec);
                if (k != null) {
                    i = k.mo23164b() - k.mo23161a();
                }
            }
            mo22959b(ec, i);
        }
    }

    /* renamed from: h */
    public void mo22964h(C7059Ec ec) {
        synchronized (this.f13543c) {
            C7164hb k = m15193k(ec);
            if (k != null) {
                k.mo23162a(ec.mo22806f());
            } else {
                this.f13544d.put(ec, new C7164hb(ec.mo22806f()));
            }
            C7164hb l = m15194l(ec);
            if (l != null) {
                l.mo23162a(ec.mo22807g());
            } else {
                this.f13545e.put(ec, new C7164hb(ec.mo22807g()));
            }
        }
    }

    /* renamed from: i */
    public void mo22965i(C7059Ec ec) {
        if (((Boolean) this.f13541a.mo23039a(C7196pb.f13719L)).booleanValue() && !mo22962f(ec)) {
            C7262l lVar = this.f13542b;
            StringBuilder sb = new StringBuilder();
            sb.append("Preloading ad for zone ");
            sb.append(ec);
            sb.append("...");
            lVar.mo22918c("PreloadManager", sb.toString());
            this.f13541a.mo23027C().mo22971a(mo22954a(ec), C7113Tb.MAIN, 500);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public boolean mo23147j(C7059Ec ec) {
        boolean contains;
        synchronized (this.f13543c) {
            contains = this.f13547g.contains(ec);
        }
        return contains;
    }
}
