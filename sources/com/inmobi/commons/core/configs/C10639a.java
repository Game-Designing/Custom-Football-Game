package com.inmobi.commons.core.configs;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.a */
/* compiled from: Config */
public abstract class C10639a {

    /* renamed from: p */
    public C10640a f32441p = new C10640a();

    /* renamed from: com.inmobi.commons.core.configs.a$a */
    /* compiled from: Config */
    public static final class C10640a {

        /* renamed from: a */
        public HashMap<String, Boolean> f32442a = new HashMap<>();

        public C10640a() {
            HashMap<String, Boolean> hashMap = this.f32442a;
            Boolean valueOf = Boolean.valueOf(true);
            hashMap.put("O1", valueOf);
            this.f32442a.put("UM5", valueOf);
            this.f32442a.put("GPID", valueOf);
            HashMap<String, Boolean> hashMap2 = this.f32442a;
            Boolean valueOf2 = Boolean.valueOf(false);
            hashMap2.put("SHA1_IMEI", valueOf2);
            this.f32442a.put("MD5_IMEI", valueOf2);
        }
    }

    /* renamed from: a */
    public abstract String mo33671a();

    /* renamed from: c */
    public abstract boolean mo33674c();

    /* renamed from: d */
    public abstract C10639a mo33675d();

    /* renamed from: a */
    public void mo33672a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("includeIds");
        for (int i = 0; i < jSONObject2.length(); i++) {
            String str = "O1";
            this.f32441p.f32442a.put(str, Boolean.valueOf(jSONObject2.getBoolean(str)));
            String str2 = "UM5";
            this.f32441p.f32442a.put(str2, Boolean.valueOf(jSONObject2.getBoolean(str2)));
            String str3 = "GPID";
            this.f32441p.f32442a.put(str3, Boolean.valueOf(jSONObject2.getBoolean(str3)));
            String str4 = "SHA1_IMEI";
            this.f32441p.f32442a.put(str4, Boolean.valueOf(jSONObject2.optBoolean(str4, false)));
            String str5 = "MD5_IMEI";
            this.f32441p.f32442a.put(str5, Boolean.valueOf(jSONObject2.optBoolean(str5, false)));
        }
    }

    /* renamed from: b */
    public JSONObject mo33673b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "O1";
        jSONObject2.put(str, this.f32441p.f32442a.get(str));
        String str2 = "UM5";
        jSONObject2.put(str2, this.f32441p.f32442a.get(str2));
        String str3 = "GPID";
        jSONObject2.put(str3, this.f32441p.f32442a.get(str3));
        String str4 = "SHA1_IMEI";
        jSONObject2.put(str4, this.f32441p.f32442a.get(str4));
        String str5 = "MD5_IMEI";
        jSONObject2.put(str5, this.f32441p.f32442a.get(str5));
        jSONObject.put("includeIds", jSONObject2);
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass() || !mo33671a().equals(((C10639a) obj).mo33671a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return mo33671a().hashCode();
    }
}
