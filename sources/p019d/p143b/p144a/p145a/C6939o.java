package p019d.p143b.p144a.p145a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p144a.p147c.C7178l;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7212tb;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.o */
public class C6939o {

    /* renamed from: a */
    private List<C6942r> f12808a;

    /* renamed from: b */
    private List<String> f12809b;

    /* renamed from: c */
    private int f12810c;

    /* renamed from: d */
    private Uri f12811d;

    /* renamed from: e */
    private final Set<C6936l> f12812e = new HashSet();

    /* renamed from: f */
    private final Map<String, Set<C6936l>> f12813f = new HashMap();

    private C6939o() {
        List<C6942r> list = Collections.EMPTY_LIST;
        this.f12808a = list;
        this.f12809b = list;
    }

    private C6939o(C6931g gVar) {
        List<C6942r> list = Collections.EMPTY_LIST;
        this.f12808a = list;
        this.f12809b = list;
        this.f12809b = gVar.mo22445h();
    }

    /* renamed from: a */
    private static int m14218a(String str, C7267q qVar) {
        try {
            List a = C7178l.m15310a(str, ":");
            if (a.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds((long) C7209sc.m15491f((String) a.get(0))) + TimeUnit.MINUTES.toSeconds((long) C7209sc.m15491f((String) a.get(1))) + ((long) C7209sc.m15491f((String) a.get(2))));
            }
        } catch (Throwable th) {
            C7262l b = qVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to parse duration from \"");
            sb.append(str);
            sb.append("\"");
            b.mo22916b("VastVideoCreative", sb.toString());
        }
        return 0;
    }

    /* renamed from: a */
    public static C6939o m14219a(C7217uc ucVar, C6939o oVar, C6931g gVar, C7267q qVar) {
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (qVar != null) {
            if (oVar == null) {
                try {
                    oVar = new C6939o(gVar);
                } catch (Throwable th) {
                    qVar.mo23049b().mo22917b("VastVideoCreative", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (oVar.f12810c == 0) {
                C7217uc b = ucVar.mo23349b("Duration");
                if (b != null) {
                    int a = m14218a(b.mo23352c(), qVar);
                    if (a > 0) {
                        oVar.f12810c = a;
                    }
                }
            }
            C7217uc b2 = ucVar.mo23349b("MediaFiles");
            if (b2 != null) {
                List<C6942r> a2 = m14220a(b2, qVar);
                if (a2 != null && a2.size() > 0) {
                    if (oVar.f12808a != null) {
                        a2.addAll(oVar.f12808a);
                    }
                    oVar.f12808a = a2;
                }
            }
            C7217uc b3 = ucVar.mo23349b("VideoClicks");
            if (b3 != null) {
                if (oVar.f12811d == null) {
                    C7217uc b4 = b3.mo23349b("ClickThrough");
                    if (b4 != null) {
                        String c = b4.mo23352c();
                        if (C7269s.m15819a(c)) {
                            oVar.f12811d = Uri.parse(c);
                        }
                    }
                }
                C6938n.m14209a(b3.mo23348a("ClickTracking"), oVar.f12812e, gVar, qVar);
            }
            C6938n.m14208a(ucVar, oVar.f12813f, gVar, qVar);
            return oVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static List<C6942r> m14220a(C7217uc ucVar, C7267q qVar) {
        String str = "VastVideoCreative";
        List<C7217uc> a = ucVar.mo23348a("MediaFile");
        ArrayList arrayList = new ArrayList(a.size());
        C7212tb tbVar = new C7212tb(qVar);
        List a2 = C7178l.m15309a(tbVar.mo23261C());
        List a3 = C7178l.m15309a(tbVar.mo23262D());
        for (C7217uc a4 : a) {
            C6942r a5 = C6942r.m14229a(a4, qVar);
            if (a5 != null) {
                try {
                    String d = a5.mo22480d();
                    if (!C7269s.m15819a(d) || a2.contains(d)) {
                        if (tbVar.mo23263E()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(a5.mo22478b().toString());
                            if (C7269s.m15819a(fileExtensionFromUrl) && !a3.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C7262l b = qVar.mo23049b();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Video file not supported: ");
                        sb.append(a5);
                        b.mo22913a(str, sb.toString());
                    }
                    arrayList.add(a5);
                } catch (Throwable th) {
                    C7262l b2 = qVar.mo23049b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to validate vidoe file: ");
                    sb2.append(a5);
                    b2.mo22917b(str, sb2.toString(), th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C6942r mo22465a(C6941q qVar) {
        List<C6942r> list = this.f12808a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String str : this.f12809b) {
            for (C6942r rVar : this.f12808a) {
                String d = rVar.mo22480d();
                if (C7269s.m15819a(d) && str.equalsIgnoreCase(d)) {
                    arrayList.add(rVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f12808a;
        }
        Collections.sort(arrayList, new C6940p(this));
        int size = qVar == C6941q.LOW ? 0 : qVar == C6941q.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1;
        return (C6942r) arrayList.get(size);
    }

    /* renamed from: a */
    public List<C6942r> mo22466a() {
        return this.f12808a;
    }

    /* renamed from: b */
    public int mo22467b() {
        return this.f12810c;
    }

    /* renamed from: c */
    public Uri mo22468c() {
        return this.f12811d;
    }

    /* renamed from: d */
    public Set<C6936l> mo22469d() {
        return this.f12812e;
    }

    /* renamed from: e */
    public Map<String, Set<C6936l>> mo22470e() {
        return this.f12813f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6939o)) {
            return false;
        }
        C6939o oVar = (C6939o) obj;
        if (this.f12810c != oVar.f12810c) {
            return false;
        }
        List<C6942r> list = this.f12808a;
        if (list == null ? oVar.f12808a != null : !list.equals(oVar.f12808a)) {
            return false;
        }
        Uri uri = this.f12811d;
        if (uri == null ? oVar.f12811d != null : !uri.equals(oVar.f12811d)) {
            return false;
        }
        Set<C6936l> set = this.f12812e;
        if (set == null ? oVar.f12812e != null : !set.equals(oVar.f12812e)) {
            return false;
        }
        Map<String, Set<C6936l>> map = this.f12813f;
        if (map != null) {
            z = map.equals(oVar.f12813f);
        } else if (oVar.f12813f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        List<C6942r> list = this.f12808a;
        int i = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f12810c) * 31;
        Uri uri = this.f12811d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C6936l> set = this.f12812e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C6936l>> map = this.f12813f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastVideoCreative{videoFiles=");
        sb.append(this.f12808a);
        sb.append(", durationSeconds=");
        sb.append(this.f12810c);
        sb.append(", destinationUri=");
        sb.append(this.f12811d);
        sb.append(", clickTrackers=");
        sb.append(this.f12812e);
        sb.append(", eventTrackers=");
        sb.append(this.f12813f);
        sb.append('}');
        return sb.toString();
    }
}
