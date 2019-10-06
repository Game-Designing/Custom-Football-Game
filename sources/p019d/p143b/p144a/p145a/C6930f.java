package p019d.p143b.p144a.p145a;

import android.net.Uri;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.f */
public class C6930f {

    /* renamed from: a */
    private int f12762a;

    /* renamed from: b */
    private int f12763b;

    /* renamed from: c */
    private Uri f12764c;

    /* renamed from: d */
    private C6933i f12765d;

    /* renamed from: e */
    private Set<C6936l> f12766e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C6936l>> f12767f = new HashMap();

    private C6930f() {
    }

    /* renamed from: a */
    public static C6930f m14171a(C7217uc ucVar, C6930f fVar, C6931g gVar, C7267q qVar) {
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (qVar != null) {
            if (fVar == null) {
                try {
                    fVar = new C6930f();
                } catch (Throwable th) {
                    qVar.mo23049b().mo22917b("VastCompanionAd", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (fVar.f12762a == 0 && fVar.f12763b == 0) {
                int f = C7209sc.m15491f((String) ucVar.mo23350b().get("width"));
                int f2 = C7209sc.m15491f((String) ucVar.mo23350b().get("height"));
                if (f > 0 && f2 > 0) {
                    fVar.f12762a = f;
                    fVar.f12763b = f2;
                }
            }
            fVar.f12765d = C6933i.m14186a(ucVar, fVar.f12765d, qVar);
            if (fVar.f12764c == null) {
                C7217uc b = ucVar.mo23349b("CompanionClickThrough");
                if (b != null) {
                    String c = b.mo23352c();
                    if (C7269s.m15819a(c)) {
                        fVar.f12764c = Uri.parse(c);
                    }
                }
            }
            C6938n.m14209a(ucVar.mo23348a("CompanionClickTracking"), fVar.f12766e, gVar, qVar);
            C6938n.m14208a(ucVar, fVar.f12767f, gVar, qVar);
            return fVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo22431a() {
        return this.f12764c;
    }

    /* renamed from: b */
    public C6933i mo22432b() {
        return this.f12765d;
    }

    /* renamed from: c */
    public Set<C6936l> mo22433c() {
        return this.f12766e;
    }

    /* renamed from: d */
    public Map<String, Set<C6936l>> mo22434d() {
        return this.f12767f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6930f)) {
            return false;
        }
        C6930f fVar = (C6930f) obj;
        if (this.f12762a != fVar.f12762a || this.f12763b != fVar.f12763b) {
            return false;
        }
        Uri uri = this.f12764c;
        if (uri == null ? fVar.f12764c != null : !uri.equals(fVar.f12764c)) {
            return false;
        }
        C6933i iVar = this.f12765d;
        if (iVar == null ? fVar.f12765d != null : !iVar.equals(fVar.f12765d)) {
            return false;
        }
        Set<C6936l> set = this.f12766e;
        if (set == null ? fVar.f12766e != null : !set.equals(fVar.f12766e)) {
            return false;
        }
        Map<String, Set<C6936l>> map = this.f12767f;
        if (map != null) {
            z = map.equals(fVar.f12767f);
        } else if (fVar.f12767f != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = ((this.f12762a * 31) + this.f12763b) * 31;
        Uri uri = this.f12764c;
        int i2 = 0;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C6933i iVar = this.f12765d;
        int hashCode2 = (hashCode + (iVar != null ? iVar.hashCode() : 0)) * 31;
        Set<C6936l> set = this.f12766e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C6936l>> map = this.f12767f;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastCompanionAd{width=");
        sb.append(this.f12762a);
        sb.append(", height=");
        sb.append(this.f12763b);
        sb.append(", destinationUri=");
        sb.append(this.f12764c);
        sb.append(", nonVideoResource=");
        sb.append(this.f12765d);
        sb.append(", clickTrackers=");
        sb.append(this.f12766e);
        sb.append(", eventTrackers=");
        sb.append(this.f12767f);
        sb.append('}');
        return sb.toString();
    }
}
