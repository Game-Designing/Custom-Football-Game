package p019d.p143b.p144a.p147c;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p019d.p143b.p150d.C7264n;

/* renamed from: d.b.a.c.f */
public class C7154f implements C7064G, C7231ya {

    /* renamed from: a */
    private final C7142c f13511a;

    /* renamed from: b */
    private final C7059Ec f13512b;

    /* renamed from: c */
    private final String f13513c;

    /* renamed from: d */
    private final String f13514d;

    /* renamed from: e */
    private final String f13515e;

    /* renamed from: f */
    private final String f13516f;

    /* renamed from: g */
    private final String f13517g;

    /* renamed from: h */
    private final String f13518h;

    /* renamed from: i */
    private final String f13519i;

    /* renamed from: j */
    private final String f13520j;

    /* renamed from: k */
    private final String f13521k;

    /* renamed from: l */
    private final String f13522l;

    /* renamed from: m */
    private final String f13523m;

    /* renamed from: n */
    private final String f13524n;

    /* renamed from: o */
    private final String f13525o;

    /* renamed from: p */
    private final String f13526p;

    /* renamed from: q */
    private final long f13527q;

    /* renamed from: r */
    private final List<String> f13528r;

    /* renamed from: s */
    private String f13529s;

    /* renamed from: t */
    private String f13530t;

    /* renamed from: u */
    private float f13531u;

    /* renamed from: v */
    private String f13532v;

    /* renamed from: w */
    private AtomicBoolean f13533w;

    private C7154f(C7059Ec ec, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, float f, String str11, String str12, String str13, String str14, String str15, String str16, String str17, long j, List<String> list, C7142c cVar) {
        this.f13533w = new AtomicBoolean();
        this.f13512b = ec;
        this.f13513c = str;
        this.f13514d = str2;
        this.f13515e = str3;
        this.f13516f = str4;
        this.f13517g = str5;
        this.f13518h = str6;
        this.f13519i = str7;
        this.f13520j = str8;
        this.f13529s = str9;
        this.f13530t = str10;
        this.f13531u = f;
        this.f13532v = str11;
        this.f13522l = str12;
        this.f13523m = str13;
        this.f13524n = str14;
        this.f13525o = str15;
        this.f13526p = str16;
        this.f13521k = str17;
        this.f13527q = j;
        this.f13528r = list;
        this.f13511a = cVar;
    }

    /* renamed from: a */
    public C7059Ec mo23111a() {
        return this.f13512b;
    }

    /* renamed from: a */
    public void mo23112a(C7264n nVar) {
        if (!this.f13533w.getAndSet(true)) {
            this.f13511a.mo23049b().mo22918c("AppLovinNativeAd", "Tracking impression...");
            this.f13511a.mo23078w().mo23136a(this.f13522l, nVar);
        } else if (nVar != null) {
            nVar.onPostbackFailure(this.f13522l, -702);
        }
    }

    /* renamed from: a */
    public void mo23113a(String str) {
        this.f13529s = str;
    }

    /* renamed from: b */
    public List<String> mo23114b() {
        return this.f13528r;
    }

    /* renamed from: b */
    public void mo23115b(String str) {
        this.f13530t = str;
    }

    /* renamed from: c */
    public String mo23116c() {
        return this.f13514d;
    }

    /* renamed from: c */
    public void mo23117c(String str) {
        this.f13532v = str;
    }

    /* renamed from: d */
    public String mo23118d() {
        return this.f13515e;
    }

    /* renamed from: e */
    public String mo23119e() {
        return this.f13517g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C7154f.class != obj.getClass()) {
            return false;
        }
        C7154f fVar = (C7154f) obj;
        C7059Ec ec = this.f13512b;
        if (ec == null ? fVar.f13512b != null : !ec.equals(fVar.f13512b)) {
            return false;
        }
        String str = this.f13520j;
        if (str == null ? fVar.f13520j != null : !str.equals(fVar.f13520j)) {
            return false;
        }
        String str2 = this.f13526p;
        if (str2 == null ? fVar.f13526p != null : !str2.equals(fVar.f13526p)) {
            return false;
        }
        String str3 = this.f13523m;
        if (str3 == null ? fVar.f13523m != null : !str3.equals(fVar.f13523m)) {
            return false;
        }
        String str4 = this.f13521k;
        if (str4 == null ? fVar.f13521k != null : !str4.equals(fVar.f13521k)) {
            return false;
        }
        String str5 = this.f13519i;
        if (str5 == null ? fVar.f13519i != null : !str5.equals(fVar.f13519i)) {
            return false;
        }
        String str6 = this.f13522l;
        if (str6 == null ? fVar.f13522l != null : !str6.equals(fVar.f13522l)) {
            return false;
        }
        String str7 = this.f13514d;
        if (str7 == null ? fVar.f13514d != null : !str7.equals(fVar.f13514d)) {
            return false;
        }
        String str8 = this.f13515e;
        if (str8 == null ? fVar.f13515e != null : !str8.equals(fVar.f13515e)) {
            return false;
        }
        String str9 = this.f13516f;
        if (str9 == null ? fVar.f13516f != null : !str9.equals(fVar.f13516f)) {
            return false;
        }
        String str10 = this.f13517g;
        if (str10 == null ? fVar.f13517g != null : !str10.equals(fVar.f13517g)) {
            return false;
        }
        String str11 = this.f13518h;
        if (str11 == null ? fVar.f13518h != null : !str11.equals(fVar.f13518h)) {
            return false;
        }
        String str12 = this.f13525o;
        if (str12 == null ? fVar.f13525o != null : !str12.equals(fVar.f13525o)) {
            return false;
        }
        String str13 = this.f13524n;
        if (str13 == null ? fVar.f13524n != null : !str13.equals(fVar.f13524n)) {
            return false;
        }
        List<String> list = this.f13528r;
        return list == null ? fVar.f13528r == null : list.equals(fVar.f13528r);
    }

    public String getIconUrl() {
        return this.f13529s;
    }

    public String getTitle() {
        return this.f13518h;
    }

    public int hashCode() {
        String str = this.f13514d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f13515e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f13516f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f13517g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f13518h;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f13519i;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f13520j;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f13521k;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f13522l;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f13523m;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.f13524n;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.f13525o;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.f13526p;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        C7059Ec ec = this.f13512b;
        int hashCode14 = (hashCode13 + (ec != null ? ec.hashCode() : 0)) * 31;
        List<String> list = this.f13528r;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode14 + i;
    }

    /* renamed from: j */
    public float mo23124j() {
        return this.f13531u;
    }

    /* renamed from: k */
    public String mo23125k() {
        return this.f13530t;
    }

    /* renamed from: l */
    public String mo23126l() {
        return this.f13523m;
    }

    /* renamed from: m */
    public long mo23127m() {
        return this.f13527q;
    }

    /* renamed from: n */
    public String mo23128n() {
        return this.f13519i;
    }

    /* renamed from: o */
    public String mo23129o() {
        return this.f13521k;
    }

    /* renamed from: p */
    public String mo23130p() {
        return this.f13532v;
    }

    /* renamed from: q */
    public boolean mo23131q() {
        String str = this.f13529s;
        boolean z = str != null && !str.equals(this.f13514d);
        String str2 = this.f13530t;
        return z && (str2 != null && !str2.equals(this.f13515e));
    }

    /* renamed from: r */
    public boolean mo23132r() {
        String str = this.f13532v;
        return str != null && !str.equals(this.f13517g);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppLovinNativeAd{clCode='");
        sb.append(this.f13526p);
        sb.append('\'');
        sb.append(", adZone='");
        sb.append(this.f13512b);
        sb.append('\'');
        sb.append(", sourceIconUrl='");
        sb.append(this.f13514d);
        sb.append('\'');
        sb.append(", sourceImageUrl='");
        sb.append(this.f13515e);
        sb.append('\'');
        sb.append(", sourceStarRatingImageUrl='");
        sb.append(this.f13516f);
        sb.append('\'');
        sb.append(", sourceVideoUrl='");
        sb.append(this.f13517g);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.f13518h);
        sb.append('\'');
        sb.append(", descriptionText='");
        sb.append(this.f13519i);
        sb.append('\'');
        sb.append(", captionText='");
        sb.append(this.f13520j);
        sb.append('\'');
        sb.append(", ctaText='");
        sb.append(this.f13521k);
        sb.append('\'');
        sb.append(", iconUrl='");
        sb.append(this.f13529s);
        sb.append('\'');
        sb.append(", imageUrl='");
        sb.append(this.f13530t);
        sb.append('\'');
        sb.append(", starRating='");
        sb.append(this.f13531u);
        sb.append('\'');
        sb.append(", videoUrl='");
        sb.append(this.f13532v);
        sb.append('\'');
        sb.append(", impressionTrackingUrl='");
        sb.append(this.f13522l);
        sb.append('\'');
        sb.append(", clickUrl='");
        sb.append(this.f13523m);
        sb.append('\'');
        sb.append(", videoStartTrackingUrl='");
        sb.append(this.f13524n);
        sb.append('\'');
        sb.append(", videoEndTrackingUrl='");
        sb.append(this.f13525o);
        sb.append('\'');
        sb.append(", resourcePrefixes=");
        sb.append(this.f13528r);
        sb.append('}');
        return sb.toString();
    }
}
