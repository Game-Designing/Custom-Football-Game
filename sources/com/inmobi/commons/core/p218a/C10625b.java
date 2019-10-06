package com.inmobi.commons.core.p218a;

import com.inmobi.commons.core.configs.C10639a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.a.b */
/* compiled from: CrashConfig */
public class C10625b extends C10639a {

    /* renamed from: m */
    private static final String f32365m = C10625b.class.getSimpleName();

    /* renamed from: a */
    public String f32366a = "https://crash-metrics.sdk.inmobi.com/trace";

    /* renamed from: b */
    long f32367b = 60;

    /* renamed from: c */
    int f32368c = 3;

    /* renamed from: d */
    int f32369d = 50;

    /* renamed from: e */
    long f32370e = 259200;

    /* renamed from: f */
    long f32371f = 120;

    /* renamed from: g */
    boolean f32372g = false;

    /* renamed from: h */
    boolean f32373h = false;

    /* renamed from: i */
    JSONObject f32374i;

    /* renamed from: j */
    JSONObject f32375j;

    /* renamed from: k */
    C10626a f32376k;

    /* renamed from: l */
    C10626a f32377l;

    /* renamed from: com.inmobi.commons.core.a.b$a */
    /* compiled from: CrashConfig */
    public final class C10626a {

        /* renamed from: a */
        long f32378a;

        /* renamed from: b */
        int f32379b;

        /* renamed from: c */
        int f32380c;

        public C10626a() {
        }

        /* renamed from: a */
        public final boolean mo34427a() {
            int i = this.f32380c;
            if (i <= C10625b.this.f32369d && this.f32378a > 0 && i > 0) {
                int i2 = this.f32379b;
                if (i2 > 0 && i2 <= i) {
                    return true;
                }
            }
            return false;
        }
    }

    public C10625b() {
        String str = "samplingFactor";
        String str2 = "enabled";
        String str3 = "maxBatchSize";
        String str4 = "minBatchSize";
        String str5 = "retryInterval";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str5, 10);
            jSONObject2.put(str4, 1);
            jSONObject2.put(str3, 2);
            jSONObject.put("wifi", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str5, 10);
            jSONObject3.put(str4, 1);
            jSONObject3.put(str3, 2);
            jSONObject.put("others", jSONObject3);
            m34863b(jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(str2, false);
            jSONObject5.put(str, 0);
            jSONObject4.put("catchEvent", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(str2, false);
            jSONObject6.put(str, 0);
            jSONObject4.put("crashEvent", jSONObject6);
            m34864c(jSONObject4);
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public final String mo33671a() {
        return "crashReporting";
    }

    /* renamed from: c */
    public final boolean mo33674c() {
        if (this.f32366a.trim().length() == 0 || (!this.f32366a.startsWith("http://") && !this.f32366a.startsWith("https://"))) {
            return false;
        }
        long j = this.f32371f;
        long j2 = this.f32367b;
        if (j >= j2) {
            long j3 = this.f32370e;
            if (j > j3 || j3 < j2 || !this.f32376k.mo34427a() || !this.f32377l.mo34427a() || this.f32367b <= 0 || this.f32368c < 0 || this.f32371f <= 0 || this.f32370e <= 0 || this.f32369d <= 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m34863b(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            C10626a aVar = new C10626a();
            aVar.f32378a = jSONObject2.getLong("retryInterval");
            aVar.f32379b = jSONObject2.getInt("minBatchSize");
            aVar.f32380c = jSONObject2.getInt("maxBatchSize");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode != -1006804125) {
                    if (hashCode == 3649301 && str.equals("wifi")) {
                        c = 0;
                    }
                } else if (str.equals("others")) {
                    c = 2;
                }
            } else if (str.equals("mobile")) {
                c = 1;
            }
            if (c != 0) {
                this.f32376k = aVar;
            } else {
                this.f32377l = aVar;
            }
        }
    }

    /* renamed from: c */
    private void m34864c(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -488533857) {
                if (hashCode == 1411010355 && str.equals("crashEvent")) {
                    c = 1;
                }
            } else if (str.equals("catchEvent")) {
                c = 0;
            }
            if (c == 0) {
                this.f32375j = jSONObject.getJSONObject(str);
            } else if (c == 1) {
                this.f32374i = jSONObject.getJSONObject(str);
            }
        }
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        super.mo33672a(jSONObject);
        this.f32366a = jSONObject.getString("url");
        this.f32367b = jSONObject.getLong("processingInterval");
        this.f32368c = jSONObject.getInt("maxRetryCount");
        this.f32369d = jSONObject.getInt("maxEventsToPersist");
        this.f32370e = jSONObject.getLong("eventTTL");
        this.f32371f = jSONObject.getLong("txLatency");
        this.f32372g = jSONObject.getBoolean("crashEnabled");
        this.f32373h = jSONObject.getBoolean("catchEnabled");
        m34863b(jSONObject.getJSONObject("networkType"));
        m34864c(jSONObject.getJSONObject("telemetry"));
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        JSONObject b = super.mo33673b();
        new JSONObject();
        b.put("url", this.f32366a);
        b.put("processingInterval", this.f32367b);
        b.put("maxRetryCount", this.f32368c);
        b.put("maxEventsToPersist", this.f32369d);
        b.put("eventTTL", this.f32370e);
        b.put("txLatency", this.f32371f);
        b.put("crashEnabled", this.f32372g);
        b.put("catchEnabled", this.f32373h);
        JSONObject jSONObject = new JSONObject();
        C10626a aVar = this.f32377l;
        JSONObject jSONObject2 = new JSONObject();
        String str = "retryInterval";
        jSONObject2.put(str, aVar.f32378a);
        String str2 = "minBatchSize";
        jSONObject2.put(str2, aVar.f32379b);
        String str3 = "maxBatchSize";
        jSONObject2.put(str3, aVar.f32380c);
        jSONObject.put("wifi", jSONObject2);
        C10626a aVar2 = this.f32376k;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(str, aVar2.f32378a);
        jSONObject3.put(str2, aVar2.f32379b);
        jSONObject3.put(str3, aVar2.f32380c);
        jSONObject.put("others", jSONObject3);
        b.put("networkType", jSONObject);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("crashEvent", this.f32374i);
        jSONObject4.put("catchEvent", this.f32375j);
        b.put("telemetry", jSONObject4);
        return b;
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10625b();
    }
}
