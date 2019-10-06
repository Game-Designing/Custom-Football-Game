package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d.b.a.c.Ka */
class C7081Ka {

    /* renamed from: a */
    private final String f13270a;

    /* renamed from: b */
    private final String f13271b;

    /* renamed from: c */
    private final String f13272c;

    /* renamed from: d */
    private final long f13273d;

    /* renamed from: e */
    private final Map<String, Long> f13274e;

    private C7081Ka(String str, String str2, String str3) {
        this.f13274e = new HashMap();
        this.f13270a = str;
        this.f13271b = str2;
        this.f13272c = str3;
        this.f13273d = System.currentTimeMillis();
    }

    /* synthetic */ C7081Ka(String str, String str2, String str3, C7175ka kaVar) {
        this(str, str2, str3);
    }

    /* renamed from: a */
    private JSONObject m14809a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pk", this.f13270a);
        jSONObject.put("ts", this.f13273d);
        if (!TextUtils.isEmpty(this.f13271b)) {
            jSONObject.put("sk1", this.f13271b);
        }
        if (!TextUtils.isEmpty(this.f13272c)) {
            jSONObject.put("sk2", this.f13272c);
        }
        for (Entry entry : this.f13274e.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m14810b() throws JSONException {
        return m14809a().toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22879a(String str, long j) {
        this.f13274e.put(str, Long.valueOf(j));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[AdEventStats pk: ");
        sb.append(this.f13270a);
        sb.append(", size: ");
        sb.append(this.f13274e.size());
        sb.append("]");
        return sb.toString();
    }
}
