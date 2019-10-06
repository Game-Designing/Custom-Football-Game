package com.moat.analytics.mobile.sma;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.sma.NativeDisplayTracker.MoatUserInteractionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.t */
class C11116t extends C11079b implements NativeDisplayTracker {

    /* renamed from: f */
    private final Map<String, String> f33967f;

    /* renamed from: g */
    private final Set<MoatUserInteractionType> f33968g = new HashSet();

    C11116t(View view, Map<String, String> map) {
        super(view, true, false);
        C11111p.m36577a(3, "NativeDisplayTracker", (Object) this, "Initializing.");
        this.f33967f = map;
        C11085g gVar = ((C11100k) MoatAnalytics.getInstance()).f33935d;
        if (gVar != null) {
            super.mo36183a(gVar.f33879b);
            super.mo36182a(gVar.f33878a);
        }
        m36594g();
        StringBuilder sb = new StringBuilder();
        sb.append(mo36181a());
        sb.append(" created for ");
        sb.append(mo36188e());
        sb.append(", with adIds:");
        sb.append(map.toString());
        C11111p.m36579a("[SUCCESS] ", sb.toString());
    }

    /* renamed from: a */
    private static String m36593a(Map<String, String> map) {
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
    private void m36594g() {
        C11095j jVar = this.f33856a;
        if (jVar != null) {
            jVar.mo36223a(m36595h());
        }
    }

    /* renamed from: h */
    private String m36595h() {
        try {
            String a = m36593a(this.f33967f);
            StringBuilder sb = new StringBuilder();
            sb.append("Parsed ad ids = ");
            sb.append(a);
            C11111p.m36577a(3, "NativeDisplayTracker", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{\"adIds\":");
            sb2.append(a);
            sb2.append(", \"adKey\":\"");
            sb2.append(this.f33857b);
            sb2.append("\", \"adSize\":");
            sb2.append(m36596i());
            sb2.append("}");
            return sb2.toString();
        } catch (Exception e) {
            C11102m.m36543a(e);
            return "";
        }
    }

    /* renamed from: i */
    private String m36596i() {
        try {
            Rect a = C11139z.m36644a(super.mo36187d());
            int width = a.width();
            int height = a.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C11102m.m36543a(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo36181a() {
        return "NativeDisplayTracker";
    }

    public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        String str = "NativeDisplayTracker";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C11111p.m36577a(3, str, (Object) this, sb.toString());
            if (!this.f33968g.contains(moatUserInteractionType)) {
                this.f33968g.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f33857b);
                jSONObject.accumulate("event", moatUserInteractionType.name().toLowerCase());
                if (this.f33856a != null) {
                    this.f33856a.mo36225b(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            e = e;
            C11111p.m36580b(2, str, this, "Got JSON exception");
            C11102m.m36543a(e);
        } catch (Exception e2) {
            e = e2;
            C11102m.m36543a(e);
        }
    }
}
