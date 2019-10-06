package com.inmobi.p207a;

import com.inmobi.commons.core.utilities.p225b.C10698h;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.a.k */
/* compiled from: IceSample */
public class C10294k {

    /* renamed from: d */
    private static final String f31185d = C10294k.class.getSimpleName();

    /* renamed from: a */
    Map<String, Object> f31186a;

    /* renamed from: b */
    C10698h f31187b;

    /* renamed from: c */
    List<C10295l> f31188c;

    /* renamed from: e */
    private long f31189e = Calendar.getInstance().getTimeInMillis();

    C10294k() {
    }

    /* renamed from: a */
    public final JSONObject mo33653a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", this.f31189e);
            if (this.f31186a != null && !this.f31186a.isEmpty()) {
                jSONObject.put("l", new JSONObject(this.f31186a));
            }
            if (this.f31187b != null) {
                jSONObject.put("s", this.f31187b.mo34522b());
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f31188c.size(); i++) {
                jSONArray.put(((C10295l) this.f31188c.get(i)).mo33654a());
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("w", jSONArray);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
