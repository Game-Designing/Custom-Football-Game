package p019d.p143b.p144a.p145a;

import com.unity3d.ads.metadata.MediationMetaData;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.k */
public class C6935k {

    /* renamed from: a */
    private String f12798a;

    /* renamed from: b */
    private String f12799b;

    private C6935k() {
    }

    /* renamed from: a */
    public static C6935k m14193a(C7217uc ucVar, C6935k kVar, C7267q qVar) {
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (qVar != null) {
            if (kVar == null) {
                try {
                    kVar = new C6935k();
                } catch (Throwable th) {
                    qVar.mo23049b().mo22917b("VastSystemInfo", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (!C7269s.m15819a(kVar.f12798a)) {
                String c = ucVar.mo23352c();
                if (C7269s.m15819a(c)) {
                    kVar.f12798a = c;
                }
            }
            if (!C7269s.m15819a(kVar.f12799b)) {
                String str = (String) ucVar.mo23350b().get(MediationMetaData.KEY_VERSION);
                if (C7269s.m15819a(str)) {
                    kVar.f12799b = str;
                }
            }
            return kVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6935k)) {
            return false;
        }
        C6935k kVar = (C6935k) obj;
        String str = this.f12798a;
        if (str == null ? kVar.f12798a != null : !str.equals(kVar.f12798a)) {
            return false;
        }
        String str2 = this.f12799b;
        if (str2 != null) {
            z = str2.equals(kVar.f12799b);
        } else if (kVar.f12799b != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f12798a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12799b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastSystemInfo{name='");
        sb.append(this.f12798a);
        sb.append('\'');
        sb.append(", version='");
        sb.append(this.f12799b);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
