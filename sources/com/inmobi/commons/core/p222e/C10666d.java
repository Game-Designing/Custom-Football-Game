package com.inmobi.commons.core.p222e;

import com.inmobi.commons.core.configs.C10639a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.e.d */
/* compiled from: TelemetryConfig */
class C10666d extends C10639a {

    /* renamed from: j */
    private static final String f32518j = C10666d.class.getSimpleName();

    /* renamed from: a */
    C10664c f32519a = new C10664c();

    /* renamed from: b */
    String f32520b = "https://telemetry.sdk.inmobi.com/metrics";

    /* renamed from: c */
    long f32521c = 300;

    /* renamed from: d */
    int f32522d = 3;

    /* renamed from: e */
    int f32523e = 1000;

    /* renamed from: f */
    long f32524f = 259200;

    /* renamed from: g */
    long f32525g = 600;

    /* renamed from: h */
    C10667a f32526h;

    /* renamed from: i */
    C10667a f32527i;

    /* renamed from: com.inmobi.commons.core.e.d$a */
    /* compiled from: TelemetryConfig */
    public final class C10667a {

        /* renamed from: a */
        long f32528a;

        /* renamed from: b */
        int f32529b;

        /* renamed from: c */
        int f32530c;

        public C10667a() {
        }

        /* renamed from: a */
        public final boolean mo34493a() {
            int i = this.f32530c;
            if (i <= C10666d.this.f32523e && this.f32528a > 0 && i > 0) {
                int i2 = this.f32529b;
                if (i2 > 0 && i2 <= i) {
                    return true;
                }
            }
            return false;
        }
    }

    public C10666d() {
        String str = "maxBatchSize";
        String str2 = "minBatchSize";
        String str3 = "retryInterval";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str3, 60);
            jSONObject2.put(str2, 20);
            jSONObject2.put(str, 50);
            jSONObject.put("wifi", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str3, 60);
            jSONObject3.put(str2, 20);
            jSONObject3.put(str, 50);
            jSONObject.put("others", jSONObject3);
            m35000b(jSONObject);
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public final String mo33671a() {
        return "telemetry";
    }

    /* renamed from: c */
    public final boolean mo33674c() {
        if (this.f32519a == null || this.f32520b.trim().length() == 0 || (!this.f32520b.startsWith("http://") && !this.f32520b.startsWith("https://"))) {
            return false;
        }
        long j = this.f32525g;
        long j2 = this.f32521c;
        if (j >= j2) {
            long j3 = this.f32524f;
            if (j > j3 || j3 < j2 || !this.f32526h.mo34493a() || !this.f32527i.mo34493a() || this.f32521c <= 0 || this.f32522d < 0 || this.f32525g <= 0 || this.f32524f <= 0 || this.f32523e <= 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m35000b(JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            C10667a aVar = new C10667a();
            aVar.f32528a = jSONObject2.getLong("retryInterval");
            aVar.f32529b = jSONObject2.getInt("minBatchSize");
            aVar.f32530c = jSONObject2.getInt("maxBatchSize");
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
                this.f32526h = aVar;
            } else {
                this.f32527i = aVar;
            }
        }
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        super.mo33672a(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("base");
        this.f32519a.f32513b = jSONObject2.getBoolean("enabled");
        this.f32519a.f32512a = jSONObject2.getInt("samplingFactor");
        this.f32520b = jSONObject.getString("telemetryUrl");
        this.f32521c = jSONObject.getLong("processingInterval");
        this.f32522d = jSONObject.getInt("maxRetryCount");
        this.f32523e = jSONObject.getInt("maxEventsToPersist");
        this.f32524f = jSONObject.getLong("eventTTL");
        this.f32525g = jSONObject.getLong("txLatency");
        m35000b(jSONObject.getJSONObject("networkType"));
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        JSONObject b = super.mo33673b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", this.f32519a.f32513b);
        jSONObject.put("samplingFactor", this.f32519a.f32512a);
        b.put("base", jSONObject);
        b.put("telemetryUrl", this.f32520b);
        b.put("processingInterval", this.f32521c);
        b.put("maxRetryCount", this.f32522d);
        b.put("maxEventsToPersist", this.f32523e);
        b.put("eventTTL", this.f32524f);
        b.put("txLatency", this.f32525g);
        JSONObject jSONObject2 = new JSONObject();
        C10667a aVar = this.f32527i;
        JSONObject jSONObject3 = new JSONObject();
        String str = "retryInterval";
        jSONObject3.put(str, aVar.f32528a);
        String str2 = "minBatchSize";
        jSONObject3.put(str2, aVar.f32529b);
        String str3 = "maxBatchSize";
        jSONObject3.put(str3, aVar.f32530c);
        jSONObject2.put("wifi", jSONObject3);
        C10667a aVar2 = this.f32526h;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(str, aVar2.f32528a);
        jSONObject4.put(str2, aVar2.f32529b);
        jSONObject4.put(str3, aVar2.f32530c);
        jSONObject2.put("others", jSONObject4);
        b.put("networkType", jSONObject2);
        return b;
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10666d();
    }
}
