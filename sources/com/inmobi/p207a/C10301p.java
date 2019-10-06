package com.inmobi.p207a;

import com.inmobi.commons.core.configs.C10639a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.a.p */
/* compiled from: SignalsConfig */
public final class C10301p extends C10639a {

    /* renamed from: d */
    private static final String f31221d = C10639a.class.getSimpleName();

    /* renamed from: a */
    public C10303b f31222a = new C10303b();

    /* renamed from: b */
    C10302a f31223b = new C10302a();

    /* renamed from: c */
    JSONObject f31224c;

    /* renamed from: com.inmobi.a.p$a */
    /* compiled from: SignalsConfig */
    public static class C10302a {

        /* renamed from: a */
        boolean f31225a = false;

        /* renamed from: b */
        String f31226b = "https://dock.inmobi.com/carb/v1/i";

        /* renamed from: c */
        String f31227c = "https://dock.inmobi.com/carb/v1/o";

        /* renamed from: d */
        int f31228d = 86400;

        /* renamed from: e */
        int f31229e = 3;

        /* renamed from: f */
        int f31230f = 60;

        /* renamed from: g */
        int f31231g = 60;

        /* renamed from: h */
        long f31232h = 307200;
    }

    /* renamed from: com.inmobi.a.p$b */
    /* compiled from: SignalsConfig */
    public static class C10303b {

        /* renamed from: a */
        public boolean f31233a = false;

        /* renamed from: b */
        int f31234b = 300;

        /* renamed from: c */
        int f31235c = 3;

        /* renamed from: d */
        int f31236d = 50;

        /* renamed from: e */
        String f31237e = "https://sdkm.w.inmobi.com/user/e.asm";

        /* renamed from: f */
        int f31238f = 3;

        /* renamed from: g */
        int f31239g = 60;

        /* renamed from: h */
        boolean f31240h = false;

        /* renamed from: i */
        boolean f31241i = false;

        /* renamed from: j */
        public int f31242j = 0;

        /* renamed from: k */
        boolean f31243k = false;

        /* renamed from: l */
        public boolean f31244l = false;

        /* renamed from: m */
        public int f31245m = 0;

        /* renamed from: n */
        public boolean f31246n = false;

        /* renamed from: o */
        public boolean f31247o = false;

        /* renamed from: p */
        public boolean f31248p = false;

        /* renamed from: a */
        public final boolean mo33676a() {
            return this.f31240h && this.f31233a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final boolean mo33677b() {
            return this.f31241i && this.f31233a;
        }
    }

    public C10301p() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enabled", true);
            jSONObject.put("samplingFactor", 0);
            this.f31224c = jSONObject;
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public final String mo33671a() {
        return "signals";
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        super.mo33672a(jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("ice");
        this.f31222a.f31234b = jSONObject2.getInt("sampleInterval");
        this.f31222a.f31236d = jSONObject2.getInt("sampleHistorySize");
        this.f31222a.f31235c = jSONObject2.getInt("stopRequestTimeout");
        String str = "enabled";
        this.f31222a.f31233a = jSONObject2.getBoolean(str);
        this.f31222a.f31237e = jSONObject2.getString("endPoint");
        String str2 = "maxRetries";
        this.f31222a.f31238f = jSONObject2.getInt(str2);
        String str3 = "retryInterval";
        this.f31222a.f31239g = jSONObject2.getInt(str3);
        this.f31222a.f31240h = jSONObject2.getBoolean("locationEnabled");
        this.f31222a.f31241i = jSONObject2.getBoolean("sessionEnabled");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("w");
        this.f31222a.f31242j = jSONObject3.getInt("wf");
        this.f31222a.f31244l = jSONObject3.getBoolean("cwe");
        this.f31222a.f31243k = jSONObject3.getBoolean("vwe");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("c");
        this.f31222a.f31246n = jSONObject4.getBoolean("oe");
        this.f31222a.f31248p = jSONObject4.getBoolean("cce");
        this.f31222a.f31247o = jSONObject4.getBoolean("vce");
        this.f31222a.f31245m = jSONObject4.getInt("cof");
        JSONObject jSONObject5 = jSONObject.getJSONObject("carb");
        this.f31223b.f31225a = jSONObject5.getBoolean(str);
        this.f31223b.f31226b = jSONObject5.getString("getEndPoint");
        this.f31223b.f31227c = jSONObject5.getString("postEndPoint");
        this.f31223b.f31228d = jSONObject5.getInt("retrieveFrequency");
        this.f31223b.f31229e = jSONObject5.getInt(str2);
        this.f31223b.f31230f = jSONObject5.getInt(str3);
        this.f31223b.f31231g = jSONObject5.getInt("timeoutInterval");
        this.f31223b.f31232h = jSONObject5.getLong("maxGetResponseSize");
        this.f31224c = jSONObject.optJSONObject("telemetry");
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        JSONObject b = super.mo33673b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sampleInterval", this.f31222a.f31234b);
        jSONObject.put("stopRequestTimeout", this.f31222a.f31235c);
        jSONObject.put("sampleHistorySize", this.f31222a.f31236d);
        String str = "enabled";
        jSONObject.put(str, this.f31222a.f31233a);
        jSONObject.put("endPoint", this.f31222a.f31237e);
        String str2 = "maxRetries";
        jSONObject.put(str2, this.f31222a.f31238f);
        String str3 = "retryInterval";
        jSONObject.put(str3, this.f31222a.f31239g);
        jSONObject.put("locationEnabled", this.f31222a.f31240h);
        jSONObject.put("sessionEnabled", this.f31222a.f31241i);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("wf", this.f31222a.f31242j);
        jSONObject2.put("vwe", this.f31222a.f31243k);
        jSONObject2.put("cwe", this.f31222a.f31244l);
        jSONObject.put("w", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("cof", this.f31222a.f31245m);
        jSONObject3.put("vce", this.f31222a.f31247o);
        jSONObject3.put("cce", this.f31222a.f31248p);
        jSONObject3.put("oe", this.f31222a.f31246n);
        jSONObject.put("c", jSONObject3);
        b.put("ice", jSONObject);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put(str, this.f31223b.f31225a);
        jSONObject4.put("getEndPoint", this.f31223b.f31226b);
        jSONObject4.put("postEndPoint", this.f31223b.f31227c);
        jSONObject4.put("retrieveFrequency", this.f31223b.f31228d);
        jSONObject4.put(str2, this.f31223b.f31229e);
        jSONObject4.put(str3, this.f31223b.f31230f);
        jSONObject4.put("timeoutInterval", this.f31223b.f31231g);
        jSONObject4.put("maxGetResponseSize", this.f31223b.f31232h);
        b.put("carb", jSONObject4);
        b.put("telemetry", this.f31224c);
        return b;
    }

    /* renamed from: c */
    public final boolean mo33674c() {
        C10303b bVar = this.f31222a;
        if (bVar.f31234b >= 0 && bVar.f31236d >= 0 && bVar.f31235c >= 0 && bVar.f31237e.trim().length() != 0) {
            C10303b bVar2 = this.f31222a;
            if (bVar2.f31238f >= 0 && bVar2.f31239g >= 0 && bVar2.f31242j >= 0 && bVar2.f31245m >= 0 && this.f31223b.f31226b.trim().length() != 0 && this.f31223b.f31227c.trim().length() != 0) {
                String str = "http://";
                String str2 = "https://";
                if ((this.f31223b.f31226b.startsWith(str) || this.f31223b.f31226b.startsWith(str2)) && (this.f31223b.f31227c.startsWith(str) || this.f31223b.f31227c.startsWith(str2))) {
                    C10302a aVar = this.f31223b;
                    if (aVar.f31228d >= 0 && aVar.f31229e >= 0 && aVar.f31230f >= 0 && aVar.f31231g >= 0 && aVar.f31232h >= 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10301p();
    }
}
