package com.flurry.sdk;

import android.text.TextUtils;
import com.mopub.common.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.oa */
public class C7569oa implements C7493ad<C7515f> {

    /* renamed from: a */
    private static final String f14967a = C7569oa.class.getSimpleName();

    /* renamed from: a */
    public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
        return m16751b(inputStream);
    }

    /* renamed from: b */
    private static C7515f m16751b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        String str = new String(C7354Ad.m16264a(inputStream));
        C7513ec.m16639a(5, f14967a, "Proton response string: ".concat(String.valueOf(str)));
        C7515f fVar = new C7515f();
        try {
            JSONObject jSONObject = new JSONObject(str);
            fVar.f14822a = jSONObject.optLong("issued_at", -1);
            fVar.f14823b = jSONObject.optLong("refresh_ttl", 3600);
            fVar.f14824c = jSONObject.optLong("expiration_ttl", 86400);
            JSONObject optJSONObject = jSONObject.optJSONObject("global_settings");
            fVar.f14825d = new C7557m();
            if (optJSONObject != null) {
                fVar.f14825d.f14941a = m16748a(optJSONObject.optString("log_level"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pulse");
            C7504d dVar = new C7504d();
            if (optJSONObject2 != null) {
                m16750a(dVar, optJSONObject2.optJSONArray("callbacks"));
                dVar.f14781b = optJSONObject2.optInt("max_callback_retries", 3);
                dVar.f14782c = optJSONObject2.optInt("max_callback_attempts_per_report", 15);
                dVar.f14783d = optJSONObject2.optInt("max_report_delay_seconds", 600);
                dVar.f14784e = optJSONObject2.optString("agent_report_url", "");
            }
            fVar.f14826e = dVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("analytics");
            fVar.f14827f = new C7574p();
            if (optJSONObject3 != null) {
                fVar.f14827f.f14982b = optJSONObject3.optBoolean("analytics_enabled", true);
                fVar.f14827f.f14981a = optJSONObject3.optInt("max_session_properties", 10);
            }
            return fVar;
        } catch (JSONException e) {
            throw new IOException("Exception while deserialize: ", e);
        }
    }

    /* renamed from: a */
    private static C7563n m16748a(String str) {
        C7563n nVar = C7563n.OFF;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (C7563n) Enum.valueOf(C7563n.class, str);
            }
            return nVar;
        } catch (Exception e) {
            return nVar;
        }
    }

    /* renamed from: a */
    private static void m16750a(C7504d dVar, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C7499c cVar = new C7499c();
                    String str = "";
                    cVar.f14762b = optJSONObject.optString("partner", str);
                    m16749a(cVar, optJSONObject.optJSONArray(Constants.VIDEO_TRACKING_EVENTS_KEY));
                    cVar.f14764d = m16752b(optJSONObject.optString("method"));
                    cVar.f14765e = optJSONObject.optString("uri_template", str);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("body_template");
                    if (optJSONObject2 != null) {
                        String str2 = "null";
                        String optString = optJSONObject2.optString("string", str2);
                        if (!optString.equals(str2)) {
                            cVar.f14766f = optString;
                        }
                    }
                    cVar.f14767g = optJSONObject.optInt("max_redirects", 5);
                    cVar.f14768h = optJSONObject.optInt("connect_timeout", 20);
                    cVar.f14769i = optJSONObject.optInt("request_timeout", 20);
                    cVar.f14761a = optJSONObject.optLong("callback_id", -1);
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("headers");
                    if (optJSONObject3 != null) {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("map");
                        if (optJSONObject4 != null) {
                            cVar.f14770j = C7359Bd.m16273a(optJSONObject4);
                        }
                    }
                    arrayList.add(cVar);
                }
            }
            dVar.f14780a = arrayList;
        }
    }

    /* renamed from: a */
    private static void m16749a(C7499c cVar, JSONArray jSONArray) {
        String[] strArr;
        if (jSONArray != null) {
            List<C7533i> list = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String str = "string";
                    String str2 = "";
                    if (optJSONObject.has(str)) {
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        C7533i iVar = new C7533i();
                        iVar.f14875a = optJSONObject.optString(str, str2);
                        list.add(iVar);
                    } else {
                        String str3 = "com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger";
                        if (optJSONObject.has(str3)) {
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str3);
                            if (optJSONObject2 != null) {
                                C7539j jVar = new C7539j();
                                jVar.f14875a = optJSONObject2.optString("event_name", str2);
                                jVar.f14893c = optJSONObject2.optString("event_parameter_name", str2);
                                JSONArray optJSONArray = optJSONObject2.optJSONArray("event_parameter_values");
                                if (optJSONArray != null) {
                                    strArr = new String[optJSONArray.length()];
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        strArr[i2] = optJSONArray.optString(i2, str2);
                                    }
                                } else {
                                    strArr = new String[0];
                                }
                                jVar.f14894d = strArr;
                                list.add(jVar);
                            }
                        }
                    }
                }
            }
            cVar.f14763c = list;
        }
    }

    /* renamed from: b */
    private static C7546ka m16752b(String str) {
        C7546ka kaVar = C7546ka.f14902a;
        try {
            if (!TextUtils.isEmpty(str)) {
                return (C7546ka) Enum.valueOf(C7546ka.class, str);
            }
            return kaVar;
        } catch (Exception e) {
            return kaVar;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
        throw new IOException("Serialize not supported for response");
    }
}
