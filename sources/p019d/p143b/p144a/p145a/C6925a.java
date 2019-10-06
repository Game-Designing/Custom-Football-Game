package p019d.p143b.p144a.p145a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p019d.p143b.p144a.p147c.C7167ia;
import p019d.p143b.p144a.p147c.C7178l;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7234z;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.a */
public class C6925a extends C7234z {

    /* renamed from: j */
    private final String f12732j;

    /* renamed from: k */
    private final String f12733k;

    /* renamed from: l */
    private final C6935k f12734l;

    /* renamed from: m */
    private final long f12735m;

    /* renamed from: n */
    private final C6939o f12736n;

    /* renamed from: o */
    private final C6930f f12737o;

    /* renamed from: p */
    private final Set<C6936l> f12738p;

    /* renamed from: q */
    private final Set<C6936l> f12739q;

    private C6925a(C6927c cVar) {
        super(cVar.f12740a, cVar.f12741b, cVar.f12742c, cVar.f12743d);
        this.f12732j = cVar.f12745f;
        this.f12734l = cVar.f12747h;
        this.f12733k = cVar.f12746g;
        this.f12736n = cVar.f12748i;
        this.f12737o = cVar.f12749j;
        this.f12738p = cVar.f12750k;
        this.f12739q = cVar.f12751l;
        this.f12735m = cVar.f12744e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0030  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<p019d.p143b.p144a.p145a.C6936l> m14122a(p019d.p143b.p144a.p145a.C6928d r6, java.lang.String[] r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x0049
            int r0 = r7.length
            if (r0 <= 0) goto L_0x0049
            r0 = 0
            d.b.a.a.d r1 = p019d.p143b.p144a.p145a.C6928d.VIDEO
            if (r6 != r1) goto L_0x0013
            d.b.a.a.o r1 = r5.f12736n
            if (r1 == 0) goto L_0x0013
            java.util.Map r0 = r1.mo22470e()
            goto L_0x001f
        L_0x0013:
            d.b.a.a.d r1 = p019d.p143b.p144a.p145a.C6928d.COMPANION_AD
            if (r6 != r1) goto L_0x001f
            d.b.a.a.f r6 = r5.f12737o
            if (r6 == 0) goto L_0x001f
            java.util.Map r0 = r6.mo22434d()
        L_0x001f:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            if (r0 == 0) goto L_0x0044
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0044
            int r1 = r7.length
            r2 = 0
        L_0x002e:
            if (r2 >= r1) goto L_0x0044
            r3 = r7[r2]
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0041
            java.lang.Object r3 = r0.get(r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r6.addAll(r3)
        L_0x0041:
            int r2 = r2 + 1
            goto L_0x002e
        L_0x0044:
            java.util.Set r6 = java.util.Collections.unmodifiableSet(r6)
            return r6
        L_0x0049:
            java.util.Set r6 = java.util.Collections.emptySet()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p145a.C6925a.m14122a(d.b.a.a.d, java.lang.String[]):java.util.Set");
    }

    /* renamed from: pa */
    public static C6927c m14123pa() {
        return new C6927c();
    }

    /* renamed from: wa */
    private C6941q m14124wa() {
        C6941q[] a = C6941q.m14228a();
        int z = new C7212tb(this.f13235c).mo23328z();
        return (z < 0 || z >= a.length) ? C6941q.UNSPECIFIED : a[z];
    }

    /* renamed from: xa */
    private Set<C6936l> m14125xa() {
        C6939o oVar = this.f12736n;
        return oVar != null ? oVar.mo22469d() : Collections.emptySet();
    }

    /* renamed from: ya */
    private Set<C6936l> m14126ya() {
        C6930f fVar = this.f12737o;
        return fVar != null ? fVar.mo22433c() : Collections.emptySet();
    }

    /* renamed from: a */
    public Set<C6936l> mo22396a(C6929e eVar, String str) {
        return mo22397a(eVar, new String[]{str});
    }

    /* renamed from: a */
    public Set<C6936l> mo22397a(C6929e eVar, String[] strArr) {
        C7262l b = this.f13235c.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Retrieving trackers of type '");
        sb.append(eVar);
        String str = "' and events '";
        sb.append(str);
        sb.append(strArr);
        sb.append("'...");
        String str2 = "VastAd";
        b.mo22918c(str2, sb.toString());
        if (eVar == C6929e.IMPRESSION) {
            return this.f12738p;
        }
        if (eVar == C6929e.VIDEO_CLICK) {
            return m14125xa();
        }
        if (eVar == C6929e.COMPANION_CLICK) {
            return m14126ya();
        }
        if (eVar == C6929e.VIDEO) {
            return m14122a(C6928d.VIDEO, strArr);
        }
        if (eVar == C6929e.COMPANION) {
            return m14122a(C6928d.COMPANION_AD, strArr);
        }
        if (eVar == C6929e.ERROR) {
            return this.f12739q;
        }
        C7262l b2 = this.f13235c.mo23049b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to retrieve trackers of invalid type '");
        sb2.append(eVar);
        sb2.append(str);
        sb2.append(strArr);
        sb2.append("'");
        b2.mo22916b(str2, sb2.toString());
        return Collections.emptySet();
    }

    /* renamed from: a */
    public boolean mo22398a(C7267q qVar) {
        return C7167ia.m15256a(this.f13233a, "cache_companion_ad", Boolean.valueOf(true), qVar).booleanValue();
    }

    /* renamed from: b */
    public String mo22399b(String str) {
        String str2 = "";
        try {
            String a = C7167ia.m15258a(this.f13233a, "vimp_url", str2, (C7267q) this.f13235c);
            if (C7269s.m15819a(a)) {
                String replace = a.replace("{CLCODE}", C7209sc.m15487d(mo22761h()));
                String str3 = "{PLACEMENT}";
                return (C7269s.m15819a(str) ? replace.replace(str3, C7209sc.m15487d(str)) : replace.replace(str3, str2)).toString();
            }
        } catch (Throwable th) {
            this.f13235c.mo23049b().mo22917b("VastAd", "Unable to create VAST impression URL", th);
        }
        return str2;
    }

    /* renamed from: b */
    public boolean mo22400b(C7267q qVar) {
        return C7167ia.m15256a(this.f13233a, "cache_video", Boolean.valueOf(true), qVar).booleanValue();
    }

    /* renamed from: c */
    public void mo22401c(String str) {
        try {
            synchronized (this.f13238f) {
                this.f13233a.put("html_template", str);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public boolean mo22402c() {
        C6939o oVar = this.f12736n;
        if (oVar == null) {
            return false;
        }
        List a = oVar.mo22466a();
        return a != null && a.size() > 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6925a) || !super.equals(obj)) {
            return false;
        }
        C6925a aVar = (C6925a) obj;
        String str = this.f12732j;
        if (str == null ? aVar.f12732j != null : !str.equals(aVar.f12732j)) {
            return false;
        }
        String str2 = this.f12733k;
        if (str2 == null ? aVar.f12733k != null : !str2.equals(aVar.f12733k)) {
            return false;
        }
        C6935k kVar = this.f12734l;
        if (kVar == null ? aVar.f12734l != null : !kVar.equals(aVar.f12734l)) {
            return false;
        }
        C6939o oVar = this.f12736n;
        if (oVar == null ? aVar.f12736n != null : !oVar.equals(aVar.f12736n)) {
            return false;
        }
        C6930f fVar = this.f12737o;
        if (fVar == null ? aVar.f12737o != null : !fVar.equals(aVar.f12737o)) {
            return false;
        }
        Set<C6936l> set = this.f12738p;
        if (set == null ? aVar.f12738p != null : !set.equals(aVar.f12738p)) {
            return false;
        }
        Set<C6936l> set2 = this.f12739q;
        if (set2 != null) {
            z = set2.equals(aVar.f12739q);
        } else if (aVar.f12739q != null) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public long mo22404f() {
        return this.f12735m;
    }

    /* renamed from: ha */
    public boolean mo22405ha() {
        C6942r qa = mo22410qa();
        if (qa != null) {
            return qa.mo22479c();
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f12732j;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f12733k;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        C6935k kVar = this.f12734l;
        int hashCode4 = (hashCode3 + (kVar != null ? kVar.hashCode() : 0)) * 31;
        C6939o oVar = this.f12736n;
        int hashCode5 = (hashCode4 + (oVar != null ? oVar.hashCode() : 0)) * 31;
        C6930f fVar = this.f12737o;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        Set<C6936l> set = this.f12738p;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        Set<C6936l> set2 = this.f12739q;
        if (set2 != null) {
            i = set2.hashCode();
        }
        return hashCode7 + i;
    }

    /* renamed from: ia */
    public Uri mo22407ia() {
        C6942r qa = mo22410qa();
        if (qa != null) {
            return qa.mo22478b();
        }
        return null;
    }

    /* renamed from: ja */
    public Uri mo22408ja() {
        C6939o oVar = this.f12736n;
        if (oVar != null) {
            return oVar.mo22468c();
        }
        return null;
    }

    /* renamed from: oa */
    public C6939o mo22409oa() {
        return this.f12736n;
    }

    /* renamed from: qa */
    public C6942r mo22410qa() {
        C6939o oVar = this.f12736n;
        if (oVar != null) {
            return oVar.mo22465a(m14124wa());
        }
        return null;
    }

    /* renamed from: ra */
    public C6930f mo22411ra() {
        return this.f12737o;
    }

    /* renamed from: sa */
    public List<String> mo22412sa() {
        return C7178l.m15309a(C7167ia.m15258a(this.f13233a, "vast_resource_cache_prefix", (String) null, (C7267q) this.f13235c));
    }

    /* renamed from: ta */
    public boolean mo22413ta() {
        return C7167ia.m15256a(this.f13233a, "vast_fire_click_trackers_on_html_clicks", Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastAd{title='");
        sb.append(this.f12732j);
        sb.append('\'');
        sb.append(", adDescription='");
        sb.append(this.f12733k);
        sb.append('\'');
        sb.append(", systemInfo=");
        sb.append(this.f12734l);
        sb.append(", videoCreative=");
        sb.append(this.f12736n);
        sb.append(", companionAd=");
        sb.append(this.f12737o);
        sb.append(", impressionTrackers=");
        sb.append(this.f12738p);
        sb.append(", errorTrackers=");
        sb.append(this.f12739q);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: ua */
    public String mo22415ua() {
        return C7167ia.m15258a(this.f13233a, "html_template", "", (C7267q) this.f13235c);
    }

    /* renamed from: v */
    public boolean mo22416v() {
        return mo22408ja() != null;
    }

    /* renamed from: va */
    public Uri mo22417va() {
        String a = C7167ia.m15258a(this.f13233a, "html_template_url", (String) null, (C7267q) this.f13235c);
        if (C7269s.m15819a(a)) {
            return Uri.parse(a);
        }
        return null;
    }
}
