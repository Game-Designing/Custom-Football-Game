package com.moat.analytics.mobile.vng;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.vng.NativeDisplayTracker.MoatUserInteractionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.t */
class C11190t extends C11153b implements NativeDisplayTracker {

    /* renamed from: f */
    private final Map<String, String> f34154f;

    /* renamed from: g */
    private final Set<MoatUserInteractionType> f34155g = new HashSet();

    C11190t(View view, Map<String, String> map) {
        super(view, true, false);
        C11185p.m36817a(3, "NativeDisplayTracker", (Object) this, "Initializing.");
        this.f34154f = map;
        C11159g gVar = ((C11174k) MoatAnalytics.getInstance()).f34122d;
        if (gVar != null) {
            super.mo36318a(gVar.f34066b);
            super.mo36317a(gVar.f34065a);
        }
        m36834g();
        StringBuilder sb = new StringBuilder();
        sb.append(mo36311a());
        sb.append(" created for ");
        sb.append(mo36323e());
        sb.append(", with adIds:");
        sb.append(map.toString());
        C11185p.m36819a("[SUCCESS] ", sb.toString());
    }

    /* renamed from: a */
    private static String m36833a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("moatClientLevel");
            sb.append(i);
            String sb2 = sb.toString();
            if (map.containsKey(sb2)) {
                linkedHashMap.put(sb2, map.get(sb2));
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("moatClientSlicer");
            sb3.append(i2);
            String sb4 = sb3.toString();
            if (map.containsKey(sb4)) {
                linkedHashMap.put(sb4, map.get(sb4));
            }
        }
        for (String str : map.keySet()) {
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, (String) map.get(str));
            }
        }
        return new JSONObject(linkedHashMap).toString();
    }

    /* renamed from: g */
    private void m36834g() {
        C11169j jVar = this.f34043a;
        if (jVar != null) {
            jVar.mo36355a(m36835h());
        }
    }

    /* renamed from: h */
    private String m36835h() {
        try {
            String a = m36833a(this.f34154f);
            StringBuilder sb = new StringBuilder();
            sb.append("Parsed ad ids = ");
            sb.append(a);
            C11185p.m36817a(3, "NativeDisplayTracker", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{\"adIds\":");
            sb2.append(a);
            sb2.append(", \"adKey\":\"");
            sb2.append(this.f34044b);
            sb2.append("\", \"adSize\":");
            sb2.append(m36836i());
            sb2.append("}");
            return sb2.toString();
        } catch (Exception e) {
            C11176m.m36783a(e);
            return "";
        }
    }

    /* renamed from: i */
    private String m36836i() {
        try {
            Rect a = C11213z.m36884a(super.mo36322d());
            int width = a.width();
            int height = a.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C11176m.m36783a(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36311a() {
        return "NativeDisplayTracker";
    }

    public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        String str = "NativeDisplayTracker";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C11185p.m36817a(3, str, (Object) this, sb.toString());
            if (!this.f34155g.contains(moatUserInteractionType)) {
                this.f34155g.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f34044b);
                jSONObject.accumulate("event", moatUserInteractionType.name().toLowerCase());
                if (this.f34043a != null) {
                    this.f34043a.mo36357b(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            e = e;
            C11185p.m36820b(2, str, this, "Got JSON exception");
            C11176m.m36783a(e);
        } catch (Exception e2) {
            e = e2;
            C11176m.m36783a(e);
        }
    }
}
