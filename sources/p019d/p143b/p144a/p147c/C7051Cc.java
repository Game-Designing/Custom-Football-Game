package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Cc */
class C7051Cc {

    /* renamed from: a */
    private final C7142c f13176a;

    /* renamed from: b */
    private final String f13177b;

    C7051Cc(String str, C7142c cVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Identifier is empty");
        } else if (cVar != null) {
            this.f13177b = str;
            this.f13176a = cVar;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    private String m14633a(C7204rb rbVar) {
        for (String str : this.f13176a.mo23050b(rbVar)) {
            if (this.f13177b.startsWith(str)) {
                return str;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo22773a() {
        return this.f13177b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C7055Dc mo22774b() {
        return m14633a(C7196pb.f13866pd) != null ? C7055Dc.f13185b : m14633a(C7196pb.f13871qd) != null ? C7055Dc.f13186c : C7055Dc.f13184a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo22775c() {
        String a = m14633a(C7196pb.f13866pd);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = m14633a(C7196pb.f13871qd);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public JSONObject mo22776d() {
        String str = "AdToken";
        if (mo22774b() == C7055Dc.f13186c) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f13177b.substring(mo22775c().length()), 0), "UTF-8"));
                C7262l b = this.f13176a.mo23049b();
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded token into ad response: ");
                sb.append(jSONObject);
                b.mo22918c(str, sb.toString());
                return jSONObject;
            } catch (JSONException e) {
                C7262l b2 = this.f13176a.mo23049b();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to decode token '");
                sb2.append(this.f13177b);
                sb2.append("' into JSON");
                b2.mo22917b(str, sb2.toString(), e);
            } catch (Throwable th) {
                C7262l b3 = this.f13176a.mo23049b();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to process ad response from token '");
                sb3.append(this.f13177b);
                sb3.append("'");
                b3.mo22917b(str, sb3.toString(), th);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7051Cc)) {
            return false;
        }
        C7051Cc cc = (C7051Cc) obj;
        String str = this.f13177b;
        if (str != null) {
            z = str.equals(cc.f13177b);
        } else if (cc.f13177b != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this.f13177b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String a = C7209sc.m15467a(32, this.f13177b);
        StringBuilder sb = new StringBuilder();
        sb.append("AdToken{id=");
        sb.append(a);
        sb.append(", type=");
        sb.append(mo22774b());
        sb.append('}');
        return sb.toString();
    }
}
