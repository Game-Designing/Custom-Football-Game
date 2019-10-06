package p019d.p143b.p144a.p147c;

import android.util.Log;
import org.json.JSONObject;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;

/* renamed from: d.b.a.c.C */
public final class C7048C extends C7071Hc {

    /* renamed from: i */
    private C7251a f13168i;

    /* renamed from: j */
    private final C7059Ec f13169j;

    public C7048C(C7059Ec ec, C7142c cVar) {
        super(new JSONObject(), new JSONObject(), C7047Bc.UNKNOWN, cVar);
        this.f13169j = ec;
    }

    /* renamed from: s */
    private C7251a m14608s() {
        return (C7251a) this.f13235c.mo23063h().mo23143c(this.f13169j);
    }

    /* renamed from: t */
    private String m14609t() {
        C7059Ec n = mo22762n();
        if (n == null || n.mo22814m()) {
            return null;
        }
        return n.mo22799a();
    }

    /* renamed from: a */
    public C7257g mo22756a() {
        C7257g gVar = C7257g.f14096c;
        try {
            return mo22762n().mo22801b();
        } catch (Throwable th) {
            Log.e("AppLovinAd", "Failed to retrieve ad size", th);
            return gVar;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22757a(C7251a aVar) {
        this.f13168i = aVar;
    }

    /* renamed from: b */
    public long mo22758b() {
        try {
            C7251a r = mo22765r();
            if (r != null) {
                return r.mo22758b();
            }
            return 0;
        } catch (Throwable th) {
            Log.e("AppLovinAd", "Failed to retrieve ad id number", th);
            return 0;
        }
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ boolean mo22402c() {
        return super.mo22402c();
    }

    /* renamed from: d */
    public C7258h mo22759d() {
        C7258h hVar = C7258h.f14102a;
        try {
            return mo22762n().mo22802c();
        } catch (Throwable th) {
            Log.e("AppLovinAd", "Failed to retrieve ad type", th);
            return hVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C7048C.class != obj.getClass()) {
            return false;
        }
        C7251a r = mo22765r();
        return r != null ? r.equals(obj) : super.equals(obj);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ long mo22404f() {
        return super.mo22404f();
    }

    /* renamed from: g */
    public C7063Fc mo22760g() {
        C7063Fc fc = C7063Fc.f13210b;
        try {
            return mo22762n().mo22803d();
        } catch (Throwable th) {
            Log.e("AppLovinAd", "Failed to return ad mediation type", th);
            return fc;
        }
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ String mo22761h() {
        return super.mo22761h();
    }

    public int hashCode() {
        C7251a r = mo22765r();
        return r != null ? r.hashCode() : super.hashCode();
    }

    /* renamed from: n */
    public C7059Ec mo22762n() {
        C7071Hc hc = (C7071Hc) mo22765r();
        return hc != null ? hc.mo22762n() : this.f13169j;
    }

    /* renamed from: o */
    public C7047Bc mo22763o() {
        C7071Hc hc = (C7071Hc) mo22765r();
        return hc != null ? hc.mo22763o() : C7047Bc.UNKNOWN;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public C7251a mo22764q() {
        return this.f13168i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public C7251a mo22765r() {
        C7251a aVar = this.f13168i;
        return aVar != null ? aVar : m14608s();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[AppLovinAd #");
        sb.append(mo22758b());
        sb.append(" adType=");
        sb.append(mo22759d());
        sb.append(", adSize=");
        sb.append(mo22756a());
        sb.append(", zoneId=");
        sb.append(m14609t());
        sb.append("]");
        return sb.toString();
    }
}
