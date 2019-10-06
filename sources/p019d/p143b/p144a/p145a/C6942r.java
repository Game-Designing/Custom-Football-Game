package p019d.p143b.p144a.p145a;

import android.net.Uri;
import android.webkit.URLUtil;
import java.util.Locale;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.r */
public class C6942r {

    /* renamed from: a */
    private Uri f12820a;

    /* renamed from: b */
    private Uri f12821b;

    /* renamed from: c */
    private C6943s f12822c;

    /* renamed from: d */
    private String f12823d;

    /* renamed from: e */
    private int f12824e;

    /* renamed from: f */
    private int f12825f;

    /* renamed from: g */
    private int f12826g;

    private C6942r() {
    }

    /* renamed from: a */
    public static C6942r m14229a(C7217uc ucVar, C7267q qVar) {
        String str = "VastVideoFile";
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (qVar != null) {
            try {
                String c = ucVar.mo23352c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C6942r rVar = new C6942r();
                    rVar.f12820a = parse;
                    rVar.f12821b = parse;
                    rVar.f12826g = C7209sc.m15491f((String) ucVar.mo23350b().get("bitrate"));
                    rVar.f12822c = m14230a((String) ucVar.mo23350b().get("delivery"));
                    rVar.f12825f = C7209sc.m15491f((String) ucVar.mo23350b().get("height"));
                    rVar.f12824e = C7209sc.m15491f((String) ucVar.mo23350b().get("width"));
                    rVar.f12823d = ((String) ucVar.mo23350b().get("type")).toLowerCase(Locale.ENGLISH);
                    return rVar;
                }
                qVar.mo23049b().mo22916b(str, "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                qVar.mo23049b().mo22917b(str, "Error occurred while initializing", th);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static C6943s m14230a(String str) {
        if (C7269s.m15819a(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C6943s.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C6943s.Streaming;
            }
        }
        return C6943s.Progressive;
    }

    /* renamed from: a */
    public Uri mo22476a() {
        return this.f12820a;
    }

    /* renamed from: a */
    public void mo22477a(Uri uri) {
        this.f12821b = uri;
    }

    /* renamed from: b */
    public Uri mo22478b() {
        return this.f12821b;
    }

    /* renamed from: c */
    public boolean mo22479c() {
        return this.f12822c == C6943s.Streaming;
    }

    /* renamed from: d */
    public String mo22480d() {
        return this.f12823d;
    }

    /* renamed from: e */
    public int mo22481e() {
        return this.f12826g;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6942r)) {
            return false;
        }
        C6942r rVar = (C6942r) obj;
        if (this.f12824e != rVar.f12824e || this.f12825f != rVar.f12825f || this.f12826g != rVar.f12826g) {
            return false;
        }
        Uri uri = this.f12820a;
        if (uri == null ? rVar.f12820a != null : !uri.equals(rVar.f12820a)) {
            return false;
        }
        Uri uri2 = this.f12821b;
        if (uri2 == null ? rVar.f12821b != null : !uri2.equals(rVar.f12821b)) {
            return false;
        }
        if (this.f12822c != rVar.f12822c) {
            return false;
        }
        String str = this.f12823d;
        if (str != null) {
            z = str.equals(rVar.f12823d);
        } else if (rVar.f12823d != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        Uri uri = this.f12820a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f12821b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        C6943s sVar = this.f12822c;
        int hashCode3 = (hashCode2 + (sVar != null ? sVar.hashCode() : 0)) * 31;
        String str = this.f12823d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.f12824e) * 31) + this.f12825f) * 31) + this.f12826g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastVideoFile{sourceVideoUri=");
        sb.append(this.f12820a);
        sb.append(", videoUri=");
        sb.append(this.f12821b);
        sb.append(", deliveryType=");
        sb.append(this.f12822c);
        sb.append(", fileType='");
        sb.append(this.f12823d);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.f12824e);
        sb.append(", height=");
        sb.append(this.f12825f);
        sb.append(", bitrate=");
        sb.append(this.f12826g);
        sb.append('}');
        return sb.toString();
    }
}
