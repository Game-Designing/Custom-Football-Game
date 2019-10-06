package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.p222e.C10659b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

final class ConfigNetworkResponse {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f32431b = ConfigNetworkResponse.class.getName();

    /* renamed from: a */
    Map<String, ConfigResponse> f32432a = new HashMap();

    /* renamed from: c */
    private Map<String, C10639a> f32433c;

    /* renamed from: d */
    private C10677d f32434d;

    /* renamed from: e */
    private C10647d f32435e;

    /* renamed from: f */
    private long f32436f;

    public static class ConfigResponse {

        /* renamed from: a */
        ConfigResponseStatus f32437a;

        /* renamed from: b */
        C10639a f32438b;

        /* renamed from: c */
        C10647d f32439c;

        public enum ConfigResponseStatus {
            SUCCESS(200),
            NOT_MODIFIED(304),
            PRODUCT_NOT_FOUND(404),
            INTERNAL_ERROR(500),
            UNKNOWN(-1);
            

            /* renamed from: a */
            private int f32440a;

            private ConfigResponseStatus(int i) {
                this.f32440a = i;
            }

            public final int getValue() {
                return this.f32440a;
            }

            public static ConfigResponseStatus fromValue(int i) {
                ConfigResponseStatus[] values;
                for (ConfigResponseStatus configResponseStatus : values()) {
                    if (configResponseStatus.f32440a == i) {
                        return configResponseStatus;
                    }
                }
                return UNKNOWN;
            }
        }

        public ConfigResponse(JSONObject jSONObject, C10639a aVar) {
            String str = " Error message:";
            String str2 = " Error code:";
            String str3 = "Config type:";
            this.f32438b = aVar;
            if (jSONObject != null) {
                try {
                    this.f32437a = ConfigResponseStatus.fromValue(jSONObject.getInt("status"));
                    if (this.f32437a == ConfigResponseStatus.SUCCESS) {
                        this.f32438b.mo33672a(jSONObject.getJSONObject("content"));
                        if (!this.f32438b.mo33674c()) {
                            this.f32439c = new C10647d(2, "The received config has failed validation.");
                            ConfigNetworkResponse.f32431b;
                            StringBuilder sb = new StringBuilder(str3);
                            sb.append(this.f32438b.mo33671a());
                            sb.append(str2);
                            sb.append(this.f32439c.f32456a);
                            sb.append(str);
                            sb.append(this.f32439c.f32457b);
                        }
                    } else if (this.f32437a == ConfigResponseStatus.NOT_MODIFIED) {
                        ConfigNetworkResponse.f32431b;
                        StringBuilder sb2 = new StringBuilder(str3);
                        sb2.append(this.f32438b.mo33671a());
                        sb2.append(" Config not modified");
                    } else {
                        this.f32439c = new C10647d(1, this.f32437a.toString());
                        ConfigNetworkResponse.f32431b;
                        StringBuilder sb3 = new StringBuilder(str3);
                        sb3.append(this.f32438b.mo33671a());
                        sb3.append(str2);
                        sb3.append(this.f32439c.f32456a);
                        sb3.append(str);
                        sb3.append(this.f32439c.f32457b);
                    }
                } catch (JSONException e) {
                    this.f32439c = new C10647d(2, e.getLocalizedMessage());
                    ConfigNetworkResponse.f32431b;
                    StringBuilder sb4 = new StringBuilder(str3);
                    sb4.append(this.f32438b.mo33671a());
                    sb4.append(str2);
                    sb4.append(this.f32439c.f32456a);
                    sb4.append(str);
                    sb4.append(this.f32439c.f32457b);
                }
            }
        }

        /* renamed from: a */
        public final boolean mo34448a() {
            return this.f32439c != null;
        }
    }

    ConfigNetworkResponse(Map<String, C10639a> map, C10677d dVar, long j) {
        this.f32433c = map;
        this.f32434d = dVar;
        this.f32436f = j;
        m34907c();
    }

    /* renamed from: c */
    private void m34907c() {
        JSONObject jSONObject;
        String str = "InvalidConfig";
        String str2 = "root";
        String str3 = "latency";
        String str4 = "reason";
        String str5 = "errorCode";
        String str6 = "name";
        String str7 = ")";
        String str8 = "Error in submitting telemetry event : (";
        String str9 = " Error message:";
        String str10 = "Error code:";
        if (!this.f32434d.mo34510a()) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.f32434d.mo34511b());
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str11 = (String) keys.next();
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str11);
                    if (this.f32433c.get(str11) != null) {
                        jSONObject = jSONObject2;
                        this.f32432a.put(str11, new ConfigResponse(jSONObject3, (C10639a) this.f32433c.get(str11)));
                    } else {
                        jSONObject = jSONObject2;
                    }
                    jSONObject2 = jSONObject;
                }
            } catch (JSONException e) {
                this.f32435e = new C10647d(2, e.getLocalizedMessage());
                StringBuilder sb = new StringBuilder(str10);
                sb.append(this.f32435e.f32456a);
                sb.append(str9);
                sb.append(this.f32435e.f32457b);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(str6, m34905a(this.f32433c));
                    hashMap.put(str5, "ParsingError");
                    hashMap.put(str4, e.getLocalizedMessage());
                    hashMap.put(str3, Long.valueOf(this.f32436f));
                    C10659b.m34983a();
                    C10659b.m34987a(str2, str, hashMap);
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder(str8);
                    sb2.append(e2.getMessage());
                    sb2.append(str7);
                }
            }
        } else {
            Iterator it = this.f32433c.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                ConfigResponse configResponse = new ConfigResponse(null, (C10639a) entry.getValue());
                Iterator it2 = it;
                configResponse.f32439c = new C10647d(0, "Network error in fetching config.");
                this.f32432a.put(entry.getKey(), configResponse);
                it = it2;
            }
            this.f32435e = new C10647d(0, this.f32434d.f32591b.f32553b);
            StringBuilder sb3 = new StringBuilder(str10);
            sb3.append(this.f32435e.f32456a);
            sb3.append(str9);
            sb3.append(this.f32435e.f32457b);
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str6, m34905a(this.f32433c));
                hashMap2.put(str5, String.valueOf(this.f32434d.f32591b.f32552a.getValue()));
                hashMap2.put(str4, this.f32434d.f32591b.f32553b);
                hashMap2.put(str3, Long.valueOf(this.f32436f));
                C10659b.m34983a();
                C10659b.m34987a(str2, str, hashMap2);
            } catch (Exception e3) {
                StringBuilder sb4 = new StringBuilder(str8);
                sb4.append(e3.getMessage());
                sb4.append(str7);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo34447a() {
        C10677d dVar = this.f32434d;
        if (dVar != null) {
            NetworkError networkError = dVar.f32591b;
            if (networkError != null) {
                ErrorCode errorCode = networkError.f32552a;
                if (errorCode != ErrorCode.BAD_REQUEST) {
                    int value = errorCode.getValue();
                    if (500 <= value && value < 600) {
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m34905a(Map<String, C10639a> map) {
        String str = "";
        for (String str2 : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(",");
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }
}
