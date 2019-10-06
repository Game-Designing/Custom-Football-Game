package p019d.p143b.p144a.p145a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.mopub.mobileads.VastResourceXmlManager;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.i */
public class C6933i {

    /* renamed from: a */
    private C6934j f12790a;

    /* renamed from: b */
    private Uri f12791b;

    /* renamed from: c */
    private String f12792c;

    private C6933i() {
    }

    /* renamed from: a */
    static C6933i m14186a(C7217uc ucVar, C6933i iVar, C7267q qVar) {
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (qVar != null) {
            if (iVar == null) {
                try {
                    iVar = new C6933i();
                } catch (Throwable th) {
                    qVar.mo23049b().mo22917b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (iVar.f12791b == null && !C7269s.m15819a(iVar.f12792c)) {
                String a = m14187a(ucVar, VastResourceXmlManager.STATIC_RESOURCE);
                if (URLUtil.isValidUrl(a)) {
                    iVar.f12791b = Uri.parse(a);
                    iVar.f12790a = C6934j.STATIC;
                    return iVar;
                }
                String a2 = m14187a(ucVar, VastResourceXmlManager.IFRAME_RESOURCE);
                if (C7269s.m15819a(a2)) {
                    iVar.f12790a = C6934j.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        iVar.f12791b = Uri.parse(a2);
                    } else {
                        iVar.f12792c = a2;
                    }
                    return iVar;
                }
                String a3 = m14187a(ucVar, VastResourceXmlManager.HTML_RESOURCE);
                if (C7269s.m15819a(a3)) {
                    iVar.f12790a = C6934j.HTML;
                    if (URLUtil.isValidUrl(a3)) {
                        iVar.f12791b = Uri.parse(a3);
                    } else {
                        iVar.f12792c = a3;
                    }
                }
            }
            return iVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static String m14187a(C7217uc ucVar, String str) {
        C7217uc b = ucVar.mo23349b(str);
        if (b != null) {
            return b.mo23352c();
        }
        return null;
    }

    /* renamed from: a */
    public C6934j mo22448a() {
        return this.f12790a;
    }

    /* renamed from: a */
    public void mo22449a(Uri uri) {
        this.f12791b = uri;
    }

    /* renamed from: a */
    public void mo22450a(String str) {
        this.f12792c = str;
    }

    /* renamed from: b */
    public Uri mo22451b() {
        return this.f12791b;
    }

    /* renamed from: c */
    public String mo22452c() {
        return this.f12792c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6933i)) {
            return false;
        }
        C6933i iVar = (C6933i) obj;
        if (this.f12790a != iVar.f12790a) {
            return false;
        }
        Uri uri = this.f12791b;
        if (uri == null ? iVar.f12791b != null : !uri.equals(iVar.f12791b)) {
            return false;
        }
        String str = this.f12792c;
        if (str != null) {
            z = str.equals(iVar.f12792c);
        } else if (iVar.f12792c != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        C6934j jVar = this.f12790a;
        int i = 0;
        int hashCode = (jVar != null ? jVar.hashCode() : 0) * 31;
        Uri uri = this.f12791b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f12792c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastNonVideoResource{type=");
        sb.append(this.f12790a);
        sb.append(", resourceUri=");
        sb.append(this.f12791b);
        sb.append(", resourceContents='");
        sb.append(this.f12792c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
