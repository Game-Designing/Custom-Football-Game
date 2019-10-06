package com.inmobi.ads;

import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.bt */
/* compiled from: VastCompanionAd */
public class C10468bt {

    /* renamed from: f */
    static final ArrayList<String> f31837f = new ArrayList<>(Arrays.asList(new String[]{"image/jpeg", "image/png"}));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final String f31838h = C10468bt.class.getSimpleName();

    /* renamed from: a */
    int f31839a;

    /* renamed from: b */
    int f31840b;

    /* renamed from: c */
    List<C10469a> f31841c = new ArrayList();

    /* renamed from: d */
    List<NativeTracker> f31842d = new ArrayList();

    /* renamed from: e */
    String f31843e;

    /* renamed from: g */
    boolean f31844g;

    /* renamed from: i */
    private String f31845i;

    /* renamed from: com.inmobi.ads.bt$a */
    /* compiled from: VastCompanionAd */
    static final class C10469a {

        /* renamed from: a */
        int f31846a;

        /* renamed from: b */
        String f31847b;

        C10469a(int i, String str) {
            this.f31846a = i;
            this.f31847b = str;
        }

        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.inmobi.ads.C10468bt.C10469a m34262a(org.json.JSONObject r8) {
            /*
                java.lang.String r0 = "type"
                java.lang.String r0 = r8.getString(r0)     // Catch:{ JSONException -> 0x0069 }
                r1 = 1
                r2 = 0
                r3 = 3
                r4 = 2
                if (r0 == 0) goto L_0x005b
                java.lang.String r5 = r0.trim()     // Catch:{ JSONException -> 0x0069 }
                int r5 = r5.length()     // Catch:{ JSONException -> 0x0069 }
                if (r5 != 0) goto L_0x0017
                goto L_0x005b
            L_0x0017:
                java.util.Locale r5 = java.util.Locale.US     // Catch:{ JSONException -> 0x0069 }
                java.lang.String r0 = r0.toLowerCase(r5)     // Catch:{ JSONException -> 0x0069 }
                r5 = -1
                int r6 = r0.hashCode()     // Catch:{ JSONException -> 0x0069 }
                r7 = 4
                switch(r6) {
                    case -1191214428: goto L_0x0045;
                    case -892481938: goto L_0x003b;
                    case -284840886: goto L_0x0031;
                    case 3213227: goto L_0x0027;
                    default: goto L_0x0026;
                }     // Catch:{ JSONException -> 0x0069 }
            L_0x0026:
                goto L_0x004e
            L_0x0027:
                java.lang.String r6 = "html"
                boolean r0 = r0.equals(r6)     // Catch:{ JSONException -> 0x0069 }
                if (r0 == 0) goto L_0x0026
                r5 = 3
                goto L_0x004e
            L_0x0031:
                java.lang.String r6 = "unknown"
                boolean r0 = r0.equals(r6)     // Catch:{ JSONException -> 0x0069 }
                if (r0 == 0) goto L_0x0026
                r5 = 1
                goto L_0x004e
            L_0x003b:
                java.lang.String r6 = "static"
                boolean r0 = r0.equals(r6)     // Catch:{ JSONException -> 0x0069 }
                if (r0 == 0) goto L_0x0026
                r5 = 2
                goto L_0x004e
            L_0x0045:
                java.lang.String r6 = "iframe"
                boolean r0 = r0.equals(r6)     // Catch:{ JSONException -> 0x0069 }
                if (r0 == 0) goto L_0x0026
                r5 = 4
            L_0x004e:
                if (r5 == r4) goto L_0x0059
                if (r5 == r3) goto L_0x0057
                if (r5 == r7) goto L_0x0055
                goto L_0x005c
            L_0x0055:
                r2 = 3
                goto L_0x005c
            L_0x0057:
                r2 = 2
                goto L_0x005c
            L_0x0059:
                r2 = 1
                goto L_0x005c
            L_0x005b:
            L_0x005c:
                java.lang.String r0 = "content"
                java.lang.String r8 = r8.getString(r0)     // Catch:{ JSONException -> 0x0069 }
                com.inmobi.ads.bt$a r0 = new com.inmobi.ads.bt$a     // Catch:{ JSONException -> 0x0069 }
                r0.<init>(r2, r8)     // Catch:{ JSONException -> 0x0069 }
                return r0
            L_0x0069:
                r8 = move-exception
                com.inmobi.ads.C10468bt.f31838h
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Error building resource from JSONObject; "
                r0.<init>(r1)
                java.lang.String r1 = r8.getMessage()
                r0.append(r1)
                com.inmobi.commons.core.a.a r0 = com.inmobi.commons.core.p218a.C10621a.m34854a()
                com.inmobi.commons.core.e.a r1 = new com.inmobi.commons.core.e.a
                r1.<init>(r8)
                r0.mo34423a(r1)
                r8 = 0
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10468bt.C10469a.m34262a(org.json.JSONObject):com.inmobi.ads.bt$a");
        }

        public final String toString() {
            String str;
            JSONObject jSONObject = new JSONObject();
            String str2 = "type";
            try {
                int i = this.f31846a;
                if (i == 1) {
                    str = "static";
                } else if (i == 2) {
                    str = AdType.HTML;
                } else if (i != 3) {
                    str = "unknown";
                } else {
                    str = "iframe";
                }
                jSONObject.put(str2, str);
                jSONObject.put("content", this.f31847b);
                return jSONObject.toString();
            } catch (JSONException e) {
                C10468bt.f31838h;
                new StringBuilder("Error serializing resource: ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
                return "";
            }
        }
    }

    public C10468bt(int i, int i2, String str, String str2) {
        this.f31845i = str2;
        this.f31839a = i;
        this.f31840b = i2;
        this.f31843e = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List<C10469a> mo34184a(int i) {
        ArrayList arrayList = new ArrayList();
        for (C10469a aVar : this.f31841c) {
            if (aVar.f31846a == i) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34187a(C10469a aVar) {
        this.f31841c.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final List<NativeTracker> mo34185a(TrackerEventType trackerEventType) {
        ArrayList arrayList = new ArrayList();
        for (NativeTracker nativeTracker : this.f31842d) {
            if (nativeTracker.f31378b.equals(trackerEventType)) {
                arrayList.add(nativeTracker);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo34186a(NativeTracker nativeTracker) {
        this.f31842d.add(nativeTracker);
    }

    /* renamed from: a */
    static C10468bt m34256a(JSONObject jSONObject) {
        String str = "clickThroughUrl";
        try {
            C10468bt btVar = new C10468bt(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.has(str) ? jSONObject.getString(str) : null, jSONObject.optString("id", null));
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.getString("trackers"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    NativeTracker a = NativeTracker.m33703a(new JSONObject(jSONArray.getString(i)));
                    if (a != null) {
                        btVar.mo34186a(a);
                    }
                }
            } catch (JSONException e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
            try {
                JSONArray jSONArray2 = new JSONArray(jSONObject.getString("resources"));
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    C10469a a2 = C10469a.m34262a(new JSONObject(jSONArray2.getString(i2)));
                    if (a2 != null) {
                        btVar.mo34187a(a2);
                    }
                }
            } catch (JSONException e2) {
                C10621a.m34854a().mo34423a(new C10658a(e2));
            }
            return btVar;
        } catch (JSONException e3) {
            new StringBuilder("Error building companion from JSON: ").append(e3.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e3));
            return null;
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f31845i != null) {
                jSONObject.put("id", this.f31845i);
            }
            jSONObject.put("width", this.f31839a);
            jSONObject.put("height", this.f31840b);
            jSONObject.put("clickThroughUrl", this.f31843e);
            JSONArray jSONArray = new JSONArray();
            for (C10469a aVar : this.f31841c) {
                jSONArray.put(aVar.toString());
            }
            jSONObject.put("resources", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (NativeTracker nativeTracker : this.f31842d) {
                jSONArray2.put(nativeTracker.toString());
            }
            jSONObject.put("trackers", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder("Error serializing an ");
            sb.append(f31838h);
            sb.append(" instance: ");
            sb.append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }
}
