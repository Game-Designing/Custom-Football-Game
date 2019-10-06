package com.inmobi.p207a;

import com.inmobi.p207a.p209b.C10281a;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.a.l */
/* compiled from: IceWifiSample */
public class C10295l {

    /* renamed from: d */
    private static final String f31190d = C10295l.class.getSimpleName();

    /* renamed from: a */
    C10281a f31191a;

    /* renamed from: b */
    List<C10281a> f31192b;

    /* renamed from: c */
    Map<String, String> f31193c;

    /* renamed from: e */
    private long f31194e = Calendar.getInstance().getTimeInMillis();

    C10295l() {
    }

    /* renamed from: a */
    public final JSONObject mo33654a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", this.f31194e);
            if (this.f31193c != null && !this.f31193c.isEmpty()) {
                for (Entry entry : this.f31193c.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            if (this.f31191a != null) {
                jSONObject.put("c-ap", this.f31191a.mo33647a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.f31192b != null) {
                for (int i = 0; i < this.f31192b.size(); i++) {
                    jSONArray.put(((C10281a) this.f31192b.get(i)).mo33647a());
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("v-ap", jSONArray);
                }
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
