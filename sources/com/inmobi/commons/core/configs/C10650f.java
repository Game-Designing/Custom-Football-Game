package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.utilities.uid.C10711d;
import com.inmobi.commons.p217a.C10619a;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.f */
/* compiled from: ConfigNetworkRequest */
final class C10650f extends C10676c {

    /* renamed from: d */
    private static final String f32462d = C10650f.class.getSimpleName();

    /* renamed from: a */
    int f32463a;

    /* renamed from: b */
    int f32464b;

    /* renamed from: c */
    Map<String, C10639a> f32465c;

    C10650f(Map<String, C10639a> map, C10711d dVar, String str, int i, int i2, int i3) {
        this(map, dVar, str, i, i2, false, i3);
    }

    C10650f(Map<String, C10639a> map, C10711d dVar, String str, int i, int i2, boolean z, int i3) {
        if (str == null || str.trim().length() == 0) {
            str = z ? "https://config.inmobi.cn/config-server/v1/config/secure.cfg" : "https://config.inmobi.com/config-server/v1/config/secure.cfg";
        }
        super("POST", str, dVar, i3);
        this.f32465c = map;
        this.f32463a = i;
        this.f32464b = i2;
    }

    /* renamed from: a */
    public final void mo34263a() {
        super.mo34263a();
        this.f32577o.put("p", m34946c());
        this.f32577o.put("im-accid", C10619a.m34847e());
    }

    /* renamed from: c */
    private String m34946c() {
        C10646c cVar = new C10646c();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f32465c.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("n", entry.getKey());
                jSONObject.put("t", cVar.mo34461b((String) entry.getKey()));
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
