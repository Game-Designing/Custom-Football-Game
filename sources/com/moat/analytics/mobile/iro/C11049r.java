package com.moat.analytics.mobile.iro;

import android.graphics.Rect;
import android.view.View;
import com.moat.analytics.mobile.iro.NativeDisplayTracker.MoatUserInteractionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.iro.r */
final class C11049r extends C11015c implements NativeDisplayTracker {

    /* renamed from: ʻ */
    private final Set<MoatUserInteractionType> f33776 = new HashSet();

    /* renamed from: ʼ */
    private final Map<String, String> f33777;

    C11049r(View view, Map<String, String> map) {
        super(view, true, false);
        String str = "NativeDisplayTracker";
        C11011b.m36234(3, str, this, "Initializing.");
        this.f33777 = map;
        String str2 = "[ERROR] ";
        String str3 = "NativeDisplayTracker initialization not successful, ";
        if (view == null) {
            String str4 = "Target view is null";
            StringBuilder sb = new StringBuilder(str3);
            sb.append(str4);
            String sb2 = sb.toString();
            C11011b.m36234(3, str, this, sb2);
            C11011b.m36232(str2, sb2);
            this.f33652 = new C11043o(str4);
        } else if (map == null || map.isEmpty()) {
            StringBuilder sb3 = new StringBuilder(str3);
            String str5 = "AdIds is null or empty";
            sb3.append(str5);
            String sb4 = sb3.toString();
            C11011b.m36234(3, str, this, sb4);
            C11011b.m36232(str2, sb4);
            this.f33652 = new C11043o(str5);
        } else {
            C11011b bVar = ((C11031j) MoatAnalytics.getInstance()).f33730;
            if (bVar == null) {
                String str6 = "prepareNativeDisplayTracking was not called successfully";
                StringBuilder sb5 = new StringBuilder(str3);
                sb5.append(str6);
                String sb6 = sb5.toString();
                C11011b.m36234(3, str, this, sb6);
                C11011b.m36232(str2, sb6);
                this.f33652 = new C11043o(str6);
                return;
            }
            this.f33654 = bVar.f33637;
            try {
                super.mo36059(bVar.f33639);
                if (this.f33654 != null) {
                    this.f33654.mo36079(m36376());
                }
                StringBuilder sb7 = new StringBuilder("NativeDisplayTracker created for ");
                sb7.append(mo36056());
                sb7.append(", with adIds:");
                sb7.append(map.toString());
                C11011b.m36232("[SUCCESS] ", sb7.toString());
            } catch (C11043o e) {
                this.f33652 = e;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ */
    public final String mo36057() {
        return "NativeDisplayTracker";
    }

    public final void reportUserInteractionEvent(MoatUserInteractionType moatUserInteractionType) {
        String str = "NativeDisplayTracker";
        try {
            StringBuilder sb = new StringBuilder("reportUserInteractionEvent:");
            sb.append(moatUserInteractionType.name());
            C11011b.m36234(3, str, this, sb.toString());
            if (!this.f33776.contains(moatUserInteractionType)) {
                this.f33776.add(moatUserInteractionType);
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("adKey", this.f33653);
                jSONObject.accumulate("event", moatUserInteractionType.name().toLowerCase());
                if (this.f33654 != null) {
                    this.f33654.mo36081(jSONObject.toString());
                }
            }
        } catch (JSONException e) {
            C11011b.m36235(str, this, "Got JSON exception");
            C11043o.m36351(e);
        } catch (Exception e2) {
            C11043o.m36351(e2);
        }
    }

    /* renamed from: ᐝ */
    private String m36376() {
        try {
            Map<String, String> map = this.f33777;
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
            String jSONObject = new JSONObject(linkedHashMap).toString();
            StringBuilder sb5 = new StringBuilder("Parsed ad ids = ");
            sb5.append(jSONObject);
            C11011b.m36234(3, "NativeDisplayTracker", this, sb5.toString());
            StringBuilder sb6 = new StringBuilder("{\"adIds\":");
            sb6.append(jSONObject);
            sb6.append(", \"adKey\":\"");
            sb6.append(this.f33653);
            sb6.append("\", \"adSize\":");
            sb6.append(m36375());
            sb6.append("}");
            return sb6.toString();
        } catch (Exception e) {
            C11043o.m36351(e);
            return "";
        }
    }

    /* renamed from: ˊॱ */
    private String m36375() {
        try {
            Rect r0 = C11067y.m36416(super.mo36054());
            int width = r0.width();
            int height = r0.height();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.toString(width));
            hashMap.put("height", Integer.toString(height));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            C11043o.m36351(e);
            return null;
        }
    }
}
