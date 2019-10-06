package com.moat.analytics.mobile.inm;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.inm.NativeDisplayTracker.MoatUserInteractionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.t */
class C10976t extends C10935b implements NativeDisplayTracker {

    /* renamed from: g */
    private final Map<String, String> f33556g;

    /* renamed from: h */
    private final Set<MoatUserInteractionType> f33557h = new HashSet();

    C10976t(View view, Map<String, String> map) {
        super(view, true, false);
        String str = "NativeDisplayTracker";
        C10969p.m36113a(3, str, (Object) this, "Initializing.");
        this.f33556g = map;
        String str2 = "[ERROR] ";
        String str3 = "NativeDisplayTracker initialization not successful, ";
        if (view == null) {
            String str4 = "Target view is null";
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str4);
            C10969p.m36114a(str2, 3, str, this, sb.toString());
            this.f33421a = new C10960m(str4);
        } else if (map == null || map.isEmpty()) {
            StringBuilder sb2 = new StringBuilder(str3);
            String str5 = "AdIds is null or empty";
            sb2.append(str5);
            C10969p.m36114a(str2, 3, str, this, sb2.toString());
            this.f33421a = new C10960m(str5);
        } else {
            C10941g gVar = ((C10958k) MoatAnalytics.getInstance()).f33509d;
            if (gVar == null) {
                String str6 = "prepareNativeDisplayTracking was not called successfully";
                StringBuilder sb3 = new StringBuilder(str3);
                sb3.append(str6);
                C10969p.m36114a(str2, 3, str, this, sb3.toString());
                this.f33421a = new C10960m(str6);
                return;
            }
            super.mo35888a(gVar.f33447b);
            try {
                super.mo35887a(gVar.f33446a);
                m36138i();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mo35886a());
                sb4.append(" created for ");
                sb4.append(mo35897g());
                sb4.append(", with adIds:");
                sb4.append(map.toString());
                C10969p.m36116a("[SUCCESS] ", sb4.toString());
            } catch (C10960m e) {
                this.f33421a = e;
            }
        }
    }

    /* renamed from: a */
    private static String m36137a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < 8; i++) {
            StringBuilder sb = new StringBuilder("moatClientLevel");
            sb.append(i);
            String sb2 = sb.toString();
            if (map.containsKey(sb2)) {
                linkedHashMap.put(sb2, map.get(sb2));
            }
        }
        for (int i2 = 0; i2 < 8; i2++) {
            StringBuilder sb3 = new StringBuilder("moatClientSlicer");
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

    /* renamed from: i */
    private void m36138i() {
        C10953j jVar = this.f33423c;
        if (jVar != null) {
            jVar.mo35940a(m36139j());
        }
    }

    /* renamed from: j */
    private String m36139j() {
        try {
            String a = m36137a(this.f33556g);
            StringBuilder sb = new StringBuilder("Parsed ad ids = ");
            sb.append(a);
            C10969p.m36113a(3, "NativeDisplayTracker", (Object) this, sb.toString());
            StringBuilder sb2 = new StringBuilder("{\"adIds\":");
            sb2.append(a);
            sb2.append(", \"adKey\":\"");
            sb2.append(this.f33425e);
            sb2.append("\", \"adSize\":");
            sb2.append(m36140k());
            sb2.append("}");
            return sb2.toString();
        } catch (Exception e) {
            C10960m.m36077a(e);
            return "";
        }
    }

    /* renamed from: k */
    private String m36140k() {
        try {
            Rect a = C10999z.m36191a(super.mo35896f());
            int width = a.width();
            int height = a.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C10960m.m36077a(e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo35886a() {
        return "NativeDisplayTracker";
    }

    public void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        String str = "NativeDisplayTracker";
        try {
            StringBuilder sb = new StringBuilder("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C10969p.m36113a(3, str, (Object) this, sb.toString());
            if (!this.f33557h.contains(moatUserInteractionType)) {
                this.f33557h.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f33425e);
                jSONObject.accumulate("event", moatUserInteractionType.name().toLowerCase());
                if (this.f33423c != null) {
                    this.f33423c.mo35944b(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            C10969p.m36117b(2, str, this, "Got JSON exception");
            C10960m.m36077a(e);
        } catch (Exception e2) {
            C10960m.m36077a(e2);
        }
    }
}
