package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.Ec */
public final class C7059Ec {

    /* renamed from: a */
    private static final Map<String, C7059Ec> f13195a = new HashMap();

    /* renamed from: b */
    private static final Object f13196b = new Object();

    /* renamed from: c */
    private C7142c f13197c;

    /* renamed from: d */
    private C7262l f13198d;

    /* renamed from: e */
    private JSONObject f13199e;

    /* renamed from: f */
    private final String f13200f;

    /* renamed from: g */
    private String f13201g;

    /* renamed from: h */
    private C7257g f13202h;

    /* renamed from: i */
    private C7258h f13203i;

    /* renamed from: j */
    private C7063Fc f13204j;

    private C7059Ec(C7257g gVar, C7258h hVar, C7063Fc fc, String str, C7142c cVar) {
        if (!TextUtils.isEmpty(str) || !(hVar == null || gVar == null || fc == C7063Fc.f13209a)) {
            this.f13197c = cVar;
            this.f13198d = cVar != null ? cVar.mo23049b() : null;
            this.f13202h = gVar;
            this.f13203i = hVar;
            this.f13204j = fc;
            if (!TextUtils.isEmpty(str)) {
                this.f13200f = str.toLowerCase(Locale.ENGLISH);
                this.f13201g = str.toLowerCase(Locale.ENGLISH);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(gVar.mo23473b());
            String str2 = "_";
            sb.append(str2);
            sb.append(hVar.mo23476a());
            sb.append(str2);
            sb.append(fc.toString());
            this.f13200f = sb.toString().toLowerCase(Locale.ENGLISH);
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type/size/mediation type specified");
    }

    /* renamed from: a */
    public static C7059Ec m14670a(C7257g gVar, C7258h hVar, C7063Fc fc, C7142c cVar) {
        return m14671a(gVar, hVar, fc, null, cVar);
    }

    /* renamed from: a */
    public static C7059Ec m14671a(C7257g gVar, C7258h hVar, C7063Fc fc, String str, C7142c cVar) {
        C7059Ec ec = new C7059Ec(gVar, hVar, fc, str, cVar);
        synchronized (f13196b) {
            String str2 = ec.f13200f;
            if (f13195a.containsKey(str2)) {
                ec = (C7059Ec) f13195a.get(str2);
            } else {
                f13195a.put(str2, ec);
            }
        }
        return ec;
    }

    /* renamed from: a */
    public static C7059Ec m14672a(String str, C7142c cVar) {
        return m14671a(null, null, C7063Fc.f13209a, str, cVar);
    }

    /* renamed from: a */
    public static C7059Ec m14673a(String str, JSONObject jSONObject, C7142c cVar) {
        C7059Ec a = m14672a(str, cVar);
        a.f13199e = jSONObject;
        return a;
    }

    /* renamed from: a */
    private C7204rb m14674a(String str, C7204rb rbVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.f13200f);
        return this.f13197c.mo23038a(sb.toString(), rbVar);
    }

    /* renamed from: a */
    private boolean m14675a(C7204rb<String> rbVar, C7257g gVar) {
        return ((String) this.f13197c.mo23039a(rbVar)).toUpperCase(Locale.ENGLISH).contains(gVar.mo23473b());
    }

    /* renamed from: b */
    public static C7059Ec m14676b(String str, C7142c cVar) {
        return m14671a(C7257g.f14098e, C7258h.f14104c, C7063Fc.f13210b, str, cVar);
    }

    /* renamed from: b */
    public static Collection<C7059Ec> m14677b(C7142c cVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(8);
        Collections.addAll(linkedHashSet, new C7059Ec[]{m14678c(cVar), m14679d(cVar), m14680e(cVar), m14681f(cVar), m14682g(cVar), m14683h(cVar), m14684i(cVar), m14685j(cVar)});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: c */
    public static C7059Ec m14678c(C7142c cVar) {
        return m14670a(C7257g.f14094a, C7258h.f14102a, C7063Fc.f13210b, cVar);
    }

    /* renamed from: d */
    public static C7059Ec m14679d(C7142c cVar) {
        return m14670a(C7257g.f14097d, C7258h.f14102a, C7063Fc.f13210b, cVar);
    }

    /* renamed from: e */
    public static C7059Ec m14680e(C7142c cVar) {
        return m14670a(C7257g.f14095b, C7258h.f14102a, C7063Fc.f13210b, cVar);
    }

    /* renamed from: f */
    public static C7059Ec m14681f(C7142c cVar) {
        return m14670a(C7257g.f14096c, C7258h.f14102a, C7063Fc.f13210b, cVar);
    }

    /* renamed from: g */
    public static C7059Ec m14682g(C7142c cVar) {
        return m14670a(C7257g.f14096c, C7258h.f14102a, C7063Fc.f13211c, cVar);
    }

    /* renamed from: h */
    public static C7059Ec m14683h(C7142c cVar) {
        return m14670a(C7257g.f14096c, C7258h.f14103b, C7063Fc.f13210b, cVar);
    }

    /* renamed from: i */
    public static C7059Ec m14684i(C7142c cVar) {
        return m14670a(C7257g.f14096c, C7258h.f14103b, C7063Fc.f13211c, cVar);
    }

    /* renamed from: j */
    public static C7059Ec m14685j(C7142c cVar) {
        return m14670a(C7257g.f14098e, C7258h.f14104c, C7063Fc.f13210b, cVar);
    }

    /* renamed from: n */
    private boolean m14686n() {
        boolean z = false;
        try {
            if (!TextUtils.isEmpty(this.f13201g)) {
                return true;
            }
            if (mo22803d() == C7063Fc.f13210b) {
                return C7258h.f14103b.equals(mo22802c()) ? ((Boolean) this.f13197c.mo23039a(C7196pb.f13748R)).booleanValue() : m14675a(C7196pb.f13739P, mo22801b());
            }
            if (mo22803d() == C7063Fc.f13211c) {
                if (C7258h.f14103b.equals(mo22802c())) {
                    return ((Boolean) this.f13197c.mo23039a(C7196pb.f13752S)).booleanValue();
                }
                z = m14675a(C7196pb.f13744Q, mo22801b());
            }
            return z;
        } catch (Throwable th) {
            this.f13198d.mo22917b("AdZone", "Unable to safely test preload merge capability", th);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo22799a() {
        return this.f13200f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22800a(C7142c cVar) {
        this.f13197c = cVar;
        this.f13198d = cVar.mo23049b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C7257g mo22801b() {
        if (this.f13202h == null) {
            String str = "ad_size";
            if (C7167ia.m15265a(this.f13199e, str)) {
                this.f13202h = new C7257g(C7167ia.m15258a(this.f13199e, str, (String) null, (C7267q) this.f13197c));
            }
        }
        return this.f13202h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C7258h mo22802c() {
        if (this.f13203i == null) {
            String str = "ad_type";
            if (C7167ia.m15265a(this.f13199e, str)) {
                this.f13203i = new C7258h(C7167ia.m15258a(this.f13199e, str, (String) null, (C7267q) this.f13197c));
            }
        }
        return this.f13203i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C7063Fc mo22803d() {
        if (this.f13204j == C7063Fc.f13209a) {
            String str = "type";
            if (C7167ia.m15265a(this.f13199e, str)) {
                this.f13204j = C7063Fc.m14702a(C7167ia.m15258a(this.f13199e, str, (String) null, (C7267q) this.f13197c));
            }
        }
        return this.f13204j;
    }

    /* renamed from: e */
    public boolean mo22804e() {
        return C7257g.f14098e.equals(mo22801b()) && C7258h.f14104c.equals(mo22802c());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C7059Ec.class != obj.getClass()) {
            return false;
        }
        return this.f13200f.equalsIgnoreCase(((C7059Ec) obj).f13200f);
    }

    /* renamed from: f */
    public int mo22806f() {
        String str = "capacity";
        if (C7167ia.m15265a(this.f13199e, str)) {
            return C7167ia.m15254a(this.f13199e, str, 0, (C7267q) this.f13197c);
        }
        if (!TextUtils.isEmpty(this.f13201g)) {
            return mo22804e() ? ((Integer) this.f13197c.mo23039a(C7196pb.f13735Oa)).intValue() : ((Integer) this.f13197c.mo23039a(C7196pb.f13730Na)).intValue();
        }
        return ((Integer) this.f13197c.mo23039a(m14674a("preload_capacity_", (C7204rb) C7196pb.f13883ta))).intValue();
    }

    /* renamed from: g */
    public int mo22807g() {
        String str = "extended_capacity";
        if (C7167ia.m15265a(this.f13199e, str)) {
            return C7167ia.m15254a(this.f13199e, str, 0, (C7267q) this.f13197c);
        }
        if (TextUtils.isEmpty(this.f13201g)) {
            return ((Integer) this.f13197c.mo23039a(m14674a("extended_preload_capacity_", (C7204rb) C7196pb.f13680Da))).intValue();
        } else if (mo22804e()) {
            return 0;
        } else {
            return ((Integer) this.f13197c.mo23039a(C7196pb.f13740Pa)).intValue();
        }
    }

    /* renamed from: h */
    public int mo22808h() {
        return C7167ia.m15254a(this.f13199e, "preload_count", 0, (C7267q) this.f13197c);
    }

    public int hashCode() {
        return this.f13200f.hashCode();
    }

    /* renamed from: i */
    public boolean mo22810i() {
        C7142c cVar;
        C7204rb<Boolean> rbVar;
        Boolean bool;
        String str = "refresh_enabled";
        if (C7167ia.m15265a(this.f13199e, str)) {
            bool = C7167ia.m15256a(this.f13199e, str, Boolean.valueOf(false), (C7267q) this.f13197c);
        } else {
            if (C7257g.f14094a.equals(mo22801b())) {
                cVar = this.f13197c;
                rbVar = C7196pb.f13684E;
            } else if (C7257g.f14097d.equals(mo22801b())) {
                cVar = this.f13197c;
                rbVar = C7196pb.f13694G;
            } else if (!C7257g.f14095b.equals(mo22801b())) {
                return false;
            } else {
                cVar = this.f13197c;
                rbVar = C7196pb.f13704I;
            }
            bool = (Boolean) cVar.mo23039a(rbVar);
        }
        return bool.booleanValue();
    }

    /* renamed from: j */
    public long mo22811j() {
        String str = "refresh_seconds";
        if (C7167ia.m15265a(this.f13199e, str)) {
            return (long) C7167ia.m15254a(this.f13199e, str, 0, (C7267q) this.f13197c);
        }
        if (C7257g.f14094a.equals(mo22801b())) {
            return ((Long) this.f13197c.mo23039a(C7196pb.f13689F)).longValue();
        }
        if (C7257g.f14097d.equals(mo22801b())) {
            return ((Long) this.f13197c.mo23039a(C7196pb.f13699H)).longValue();
        }
        if (C7257g.f14095b.equals(mo22801b())) {
            return ((Long) this.f13197c.mo23039a(C7196pb.f13709J)).longValue();
        }
        return -1;
    }

    /* renamed from: k */
    public boolean mo22812k() {
        boolean z = false;
        if (!((Boolean) this.f13197c.mo23039a(C7196pb.f13719L)).booleanValue() || !m14686n()) {
            return false;
        }
        if (TextUtils.isEmpty(this.f13201g)) {
            C7204rb a = m14674a("preload_merge_init_tasks_", (C7204rb) null);
            if (a != null && ((Boolean) this.f13197c.mo23039a(a)).booleanValue() && mo22806f() > 0) {
                z = true;
            }
            return z;
        } else if (this.f13199e != null && mo22808h() == 0) {
            return false;
        } else {
            String upperCase = ((String) this.f13197c.mo23039a(C7196pb.f13739P)).toUpperCase(Locale.ENGLISH);
            return (upperCase.contains(C7257g.f14096c.mo23473b()) || upperCase.contains(C7257g.f14094a.mo23473b()) || upperCase.contains(C7257g.f14097d.mo23473b()) || upperCase.contains(C7257g.f14095b.mo23473b())) ? ((Boolean) this.f13197c.mo23039a(C7196pb.f13849mb)).booleanValue() : this.f13197c.mo23029E().mo22822a(this) && mo22808h() > 0 && ((Boolean) this.f13197c.mo23039a(C7196pb.f13775Xc)).booleanValue();
        }
    }

    /* renamed from: l */
    public boolean mo22813l() {
        String str = "wrapped_ads_enabled";
        return C7167ia.m15265a(this.f13199e, str) ? C7167ia.m15256a(this.f13199e, str, Boolean.valueOf(false), (C7267q) this.f13197c).booleanValue() : mo22801b() != null ? this.f13197c.mo23050b((C7204rb) C7196pb.f13763Uc).contains(mo22801b().mo23473b()) : ((Boolean) this.f13197c.mo23039a(C7196pb.f13759Tc)).booleanValue();
    }

    /* renamed from: m */
    public boolean mo22814m() {
        return m14677b(this.f13197c).contains(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdZone{identifier=");
        sb.append(this.f13200f);
        sb.append(", zoneObject=");
        sb.append(this.f13199e);
        sb.append('}');
        return sb.toString();
    }
}
