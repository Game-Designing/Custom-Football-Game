package com.inmobi.ads;

import android.graphics.Point;
import android.webkit.URLUtil;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10441ba.C10442a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.mopub.common.Constants;
import com.mopub.common.MoPubBrowser;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.ao */
/* compiled from: NativeDataModel */
public class C10406ao {

    /* renamed from: l */
    private static final String f31650l = C10406ao.class.getSimpleName();

    /* renamed from: a */
    int f31651a;

    /* renamed from: b */
    public boolean f31652b;

    /* renamed from: c */
    public boolean f31653c;

    /* renamed from: d */
    public C10402am f31654d;

    /* renamed from: e */
    JSONArray f31655e;

    /* renamed from: f */
    final C10406ao f31656f;

    /* renamed from: g */
    Map<String, String> f31657g;

    /* renamed from: h */
    Map<String, List<C10400ak>> f31658h;

    /* renamed from: i */
    C10407a f31659i;

    /* renamed from: j */
    boolean f31660j;

    /* renamed from: k */
    C10451bf f31661k;

    /* renamed from: m */
    private JSONObject f31662m;

    /* renamed from: n */
    private JSONObject f31663n;

    /* renamed from: o */
    private Map<String, C10400ak> f31664o;

    /* renamed from: p */
    private Map<String, String> f31665p;

    /* renamed from: q */
    private C10475bx f31666q;

    /* renamed from: r */
    private C10478c f31667r;

    /* renamed from: s */
    private PlacementType f31668s;

    /* renamed from: t */
    private boolean f31669t;

    /* renamed from: com.inmobi.ads.ao$a */
    /* compiled from: NativeDataModel */
    class C10407a {

        /* renamed from: a */
        JSONObject f31670a;

        /* renamed from: b */
        C10408a f31671b = new C10408a();

        /* renamed from: c */
        C10400ak f31672c;

        /* renamed from: com.inmobi.ads.ao$a$a */
        /* compiled from: NativeDataModel */
        class C10408a {

            /* renamed from: a */
            public String f31674a;

            /* renamed from: b */
            public String f31675b;

            /* renamed from: c */
            public String f31676c;

            /* renamed from: d */
            public String f31677d;

            /* renamed from: e */
            public float f31678e;

            /* renamed from: f */
            public String f31679f;

            /* renamed from: g */
            public boolean f31680g;

            C10408a() {
            }
        }

        C10407a() {
        }
    }

    C10406ao() {
        this.f31656f = null;
    }

    public C10406ao(PlacementType placementType, JSONObject jSONObject, C10478c cVar, C10475bx bxVar) {
        this(placementType, jSONObject, null, false, cVar, bxVar);
    }

    public C10406ao(PlacementType placementType, JSONObject jSONObject, C10406ao aoVar, boolean z, C10478c cVar, C10475bx bxVar) {
        this(placementType, jSONObject, aoVar, z, cVar, bxVar, 0);
    }

    private C10406ao(PlacementType placementType, JSONObject jSONObject, C10406ao aoVar, boolean z, C10478c cVar, C10475bx bxVar, byte b) {
        this.f31668s = placementType;
        this.f31656f = aoVar;
        if (cVar == null) {
            cVar = new C10478c();
        }
        this.f31667r = cVar;
        this.f31662m = jSONObject;
        this.f31651a = 0;
        this.f31652b = false;
        this.f31666q = bxVar;
        this.f31664o = new HashMap();
        this.f31665p = new HashMap();
        this.f31658h = new HashMap();
        this.f31659i = new C10407a();
        this.f31669t = z;
        m34094f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final JSONObject mo34104a() {
        try {
            return this.f31655e.getJSONObject(0);
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final int mo34105b() {
        C10402am amVar = this.f31654d;
        if (amVar == null) {
            return 0;
        }
        Iterator it = amVar.iterator();
        while (it.hasNext()) {
            C10400ak akVar = (C10400ak) it.next();
            if (akVar.f31611d.equalsIgnoreCase("card_scrollable")) {
                return ((C10402am) akVar).f31646C;
            }
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C10402am mo34103a(int i) {
        Iterator it = this.f31654d.iterator();
        while (it.hasNext()) {
            C10400ak akVar = (C10400ak) it.next();
            if (akVar.f31611d.equalsIgnoreCase("card_scrollable")) {
                C10402am amVar = (C10402am) akVar;
                if (i >= amVar.f31646C) {
                    return null;
                }
                return (C10402am) amVar.mo34098a(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    static C10402am m34070a(C10400ak akVar) {
        if (akVar instanceof C10402am) {
            C10402am amVar = (C10402am) akVar;
            if (m34078a(amVar)) {
                return amVar;
            }
        }
        for (C10402am amVar2 = (C10402am) akVar.f31627t; amVar2 != null; amVar2 = (C10402am) amVar2.f31627t) {
            if (m34078a(amVar2)) {
                return amVar2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m34078a(C10402am amVar) {
        return "card_scrollable".equalsIgnoreCase(amVar.f31611d);
    }

    /* renamed from: a */
    private static void m34075a(C10449be beVar) {
        beVar.f31631x = 8;
        HashMap hashMap = new HashMap();
        hashMap.put("[ERRORCODE]", "601");
        beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_ERROR, (Map<String, String>) hashMap);
    }

    /* renamed from: d */
    private void m34088d() {
        List list;
        C10469a aVar;
        for (C10400ak akVar : mo34107c("IMAGE")) {
            if (!URLUtil.isValidUrl((String) akVar.f31612e)) {
                C10400ak a = m34067a(this, akVar);
                if (a == null) {
                    StringBuilder sb = new StringBuilder("Could not find referenced asset for asset (");
                    sb.append(akVar.f31611d);
                    sb.append(")");
                } else if (a.f31609b.equals(akVar.f31609b)) {
                    akVar.f31612e = a.f31612e;
                } else {
                    if ("VIDEO".equals(a.f31609b)) {
                        int i = a.f31620m;
                        if (1 != i && 2 == i) {
                            C10449be beVar = (C10449be) a;
                            C10476by b = beVar.mo34158b();
                            C10468bt a2 = C10467bs.m34255a(beVar, akVar);
                            if (a2 == null) {
                                list = null;
                            } else {
                                list = a2.mo34184a(1);
                            }
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    aVar = (C10469a) it.next();
                                    if (URLUtil.isValidUrl(aVar.f31847b)) {
                                        break;
                                    }
                                }
                            }
                            aVar = null;
                            if (a2 != null && aVar != null) {
                                b.mo34197a(a2);
                                new StringBuilder("Setting image asset value: ").append(aVar.f31847b);
                                akVar.f31612e = aVar.f31847b;
                                akVar.mo34088a(a2.mo34185a(TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW));
                                akVar.mo34089a(beVar.f31628u, TrackerEventType.TRACKER_EVENT_TYPE_ERROR);
                            } else if (b.mo34201e().size() > 0) {
                                m34075a(beVar);
                                m34076a(a2 == null ? "NoBestFitCompanion" : "NoValidResource", "Static", MoPubBrowser.DESTINATION_URL_KEY, (String) null, (String) null);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m34076a(String str, String str2, String str3, String str4, String str5) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", str);
            hashMap.put("type", str2);
            hashMap.put("dataType", str3);
            hashMap.put("clientRequestId", null);
            hashMap.put("impId", null);
            C10659b.m34983a();
            C10659b.m34987a("ads", "EndCardCompanionFailure", hashMap);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error in sendTelemetryEventForCompanionFailure : (");
            sb.append(e.getMessage());
            sb.append(")");
        }
    }

    /* renamed from: a */
    private static String m34072a(C10468bt btVar, C10451bf bfVar) {
        String str = "REF_HTML";
        String str2 = "Rich";
        String str3 = "MalformedURL";
        String str4 = "REF_IFRAME";
        if (str.equals(bfVar.f31795z)) {
            List a = btVar.mo34184a(2);
            if (a.size() > 0) {
                return ((C10469a) a.get(0)).f31847b;
            }
            List a2 = btVar.mo34184a(3);
            if (a2.size() > 0) {
                String str5 = ((C10469a) a2.get(0)).f31847b;
                if (URLUtil.isValidUrl(str5)) {
                    bfVar.f31795z = str4;
                    return str5;
                }
                m34076a(str3, str2, str, (String) null, (String) null);
            }
        } else if (str4.equals(bfVar.f31795z)) {
            List a3 = btVar.mo34184a(3);
            if (a3.size() > 0) {
                String str6 = ((C10469a) a3.get(0)).f31847b;
                if (URLUtil.isValidUrl(str6)) {
                    bfVar.f31795z = str4;
                    return str6;
                }
                m34076a(str3, str2, str4, (String) null, (String) null);
            } else {
                List a4 = btVar.mo34184a(2);
                if (a4.size() > 0) {
                    bfVar.f31795z = str;
                    return ((C10469a) a4.get(0)).f31847b;
                }
            }
        }
        return null;
    }

    /* renamed from: e */
    private void m34091e() {
        String str;
        for (C10400ak akVar : mo34107c("WEBVIEW")) {
            C10451bf bfVar = (C10451bf) akVar;
            if (!MoPubBrowser.DESTINATION_URL_KEY.equals(bfVar.f31795z)) {
                if (!"HTML".equals(bfVar.f31795z)) {
                    C10400ak a = m34067a(this, akVar);
                    if (a == null) {
                        StringBuilder sb = new StringBuilder("Could not find referenced asset for asset (");
                        sb.append(akVar.f31611d);
                        sb.append(")");
                    } else if (a.f31609b.equals(akVar.f31609b)) {
                        akVar.f31612e = a.f31612e;
                    } else {
                        if ("VIDEO".equals(a.f31609b) && 2 == a.f31620m) {
                            C10449be beVar = (C10449be) a;
                            C10476by b = beVar.mo34158b();
                            C10468bt a2 = C10467bs.m34255a(beVar, akVar);
                            if (a2 == null) {
                                str = null;
                            } else {
                                str = m34072a(a2, bfVar);
                            }
                            boolean equals = "REF_IFRAME".equals(bfVar.f31795z);
                            boolean equals2 = "REF_HTML".equals(bfVar.f31795z);
                            if (a2 == null || ((equals && !URLUtil.isValidUrl(str)) || (equals2 && str == null))) {
                                if (b.mo34201e().size() > 0) {
                                    m34075a(beVar);
                                    m34076a(a2 == null ? "NoBestFitCompanion" : "NoValidResource", "Rich", bfVar.f31795z, (String) null, (String) null);
                                }
                                bfVar.f31795z = "UNKNOWN";
                            } else {
                                b.mo34197a(a2);
                                akVar.f31612e = str;
                                akVar.mo34088a(a2.mo34185a(TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW));
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e A[Catch:{ JSONException -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074 A[Catch:{ JSONException -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0253 A[Catch:{ JSONException -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0258 A[Catch:{ JSONException -> 0x02a7 }] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m34094f() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "action"
            java.lang.String r2 = "openMode"
            java.lang.String r3 = "itemUrl"
            java.lang.String r4 = "onClick"
            java.lang.String r5 = "adContent"
            java.lang.String r6 = "passThroughJson"
            java.lang.String r7 = "orientation"
            java.lang.String r8 = "rewards"
            org.json.JSONObject r9 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r10 = "styleRefs"
            org.json.JSONObject r9 = r9.optJSONObject(r10)     // Catch:{ JSONException -> 0x02a7 }
            r1.f31663n = r9     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r9 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            boolean r9 = r9.isNull(r7)     // Catch:{ JSONException -> 0x02a7 }
            r10 = 2
            r11 = 1
            r12 = 0
            if (r9 == 0) goto L_0x0029
            r7 = 0
            goto L_0x0075
        L_0x0029:
            org.json.JSONObject r9 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r7 = r9.getString(r7)     // Catch:{ JSONException -> 0x02a7 }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r7 = r7.toLowerCase(r9)     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r7 = r7.trim()     // Catch:{ JSONException -> 0x02a7 }
            r9 = -1
            int r13 = r7.hashCode()     // Catch:{ JSONException -> 0x02a7 }
            r14 = -1626174665(0xffffffff9f128b37, float:-3.103186E-20)
            r15 = 3
            if (r13 == r14) goto L_0x0063
            r14 = 729267099(0x2b77bb9b, float:8.8012383E-13)
            if (r13 == r14) goto L_0x0059
            r14 = 1430647483(0x5545f2bb, float:1.36028944E13)
            if (r13 == r14) goto L_0x004f
        L_0x004e:
            goto L_0x006c
        L_0x004f:
            java.lang.String r13 = "landscape"
            boolean r7 = r7.equals(r13)     // Catch:{ JSONException -> 0x02a7 }
            if (r7 == 0) goto L_0x004e
            r9 = 3
            goto L_0x006c
        L_0x0059:
            java.lang.String r13 = "portrait"
            boolean r7 = r7.equals(r13)     // Catch:{ JSONException -> 0x02a7 }
            if (r7 == 0) goto L_0x004e
            r9 = 2
            goto L_0x006c
        L_0x0063:
            java.lang.String r13 = "unspecified"
            boolean r7 = r7.equals(r13)     // Catch:{ JSONException -> 0x02a7 }
            if (r7 == 0) goto L_0x004e
            r9 = 1
        L_0x006c:
            if (r9 == r10) goto L_0x0074
            if (r9 == r15) goto L_0x0072
            r7 = 0
            goto L_0x0075
        L_0x0072:
            r7 = 2
            goto L_0x0075
        L_0x0074:
            r7 = 1
        L_0x0075:
            r1.f31651a = r7     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r7 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r9 = "shouldAutoOpenLandingPage"
            boolean r7 = r7.optBoolean(r9, r11)     // Catch:{ JSONException -> 0x02a7 }
            r1.f31660j = r7     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r7 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r9 = "disableBackButton"
            boolean r7 = r7.optBoolean(r9, r12)     // Catch:{ JSONException -> 0x02a7 }
            r1.f31652b = r7     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r7 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r9 = "rootContainer"
            org.json.JSONObject r7 = r7.getJSONObject(r9)     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r9 = "CONTAINER"
            java.lang.String r13 = "/rootContainer"
            r14 = 0
            com.inmobi.ads.ak r7 = r1.m34068a(r7, r9, r13, r14)     // Catch:{ JSONException -> 0x02a7 }
            com.inmobi.ads.am r7 = (com.inmobi.ads.C10402am) r7     // Catch:{ JSONException -> 0x02a7 }
            r1.f31654d = r7     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r7 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            boolean r7 = r7.isNull(r6)     // Catch:{ JSONException -> 0x018c }
            if (r7 != 0) goto L_0x00b3
            com.inmobi.ads.ao$a r7 = r1.f31659i     // Catch:{ JSONException -> 0x018c }
            org.json.JSONObject r9 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            org.json.JSONObject r6 = r9.getJSONObject(r6)     // Catch:{ JSONException -> 0x018c }
            r7.f31670a = r6     // Catch:{ JSONException -> 0x018c }
        L_0x00b3:
            org.json.JSONObject r6 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            boolean r6 = r6.isNull(r5)     // Catch:{ JSONException -> 0x018c }
            if (r6 != 0) goto L_0x010c
            org.json.JSONObject r6 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            org.json.JSONObject r5 = r6.getJSONObject(r5)     // Catch:{ JSONException -> 0x018c }
            if (r5 == 0) goto L_0x010c
            com.inmobi.ads.ao$a$a r6 = new com.inmobi.ads.ao$a$a     // Catch:{ JSONException -> 0x018c }
            com.inmobi.ads.ao$a r7 = r1.f31659i     // Catch:{ JSONException -> 0x018c }
            r7.getClass()     // Catch:{ JSONException -> 0x018c }
            r6.<init>()     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "title"
            java.lang.String r7 = r5.optString(r7, r14)     // Catch:{ JSONException -> 0x018c }
            r6.f31674a = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "description"
            java.lang.String r7 = r5.optString(r7, r14)     // Catch:{ JSONException -> 0x018c }
            r6.f31675b = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "ctaText"
            java.lang.String r7 = r5.optString(r7, r14)     // Catch:{ JSONException -> 0x018c }
            r6.f31677d = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "iconUrl"
            java.lang.String r7 = r5.optString(r7, r14)     // Catch:{ JSONException -> 0x018c }
            r6.f31676c = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "rating"
            r10 = 0
            long r10 = r5.optLong(r7, r10)     // Catch:{ JSONException -> 0x018c }
            float r7 = (float) r10     // Catch:{ JSONException -> 0x018c }
            r6.f31678e = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "landingPageUrl"
            java.lang.String r7 = r5.optString(r7, r14)     // Catch:{ JSONException -> 0x018c }
            r6.f31679f = r7     // Catch:{ JSONException -> 0x018c }
            java.lang.String r7 = "isApp"
            boolean r5 = r5.optBoolean(r7)     // Catch:{ JSONException -> 0x018c }
            r6.f31680g = r5     // Catch:{ JSONException -> 0x018c }
            com.inmobi.ads.ao$a r5 = r1.f31659i     // Catch:{ JSONException -> 0x018c }
            r5.f31671b = r6     // Catch:{ JSONException -> 0x018c }
        L_0x010c:
            com.inmobi.ads.ak r5 = new com.inmobi.ads.ak     // Catch:{ JSONException -> 0x018c }
            r5.<init>()     // Catch:{ JSONException -> 0x018c }
            org.json.JSONObject r6 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            boolean r6 = r6.isNull(r4)     // Catch:{ JSONException -> 0x018c }
            if (r6 != 0) goto L_0x0174
            org.json.JSONObject r6 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            org.json.JSONObject r4 = r6.getJSONObject(r4)     // Catch:{ JSONException -> 0x018c }
            boolean r6 = r4.isNull(r3)     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x0131
            java.lang.String r3 = r4.getString(r3)     // Catch:{ JSONException -> 0x0159 }
            r11 = 1
            goto L_0x0133
        L_0x0131:
            r3 = r7
            r11 = 0
        L_0x0133:
            boolean r6 = r4.isNull(r0)     // Catch:{ JSONException -> 0x0159 }
            if (r6 != 0) goto L_0x013e
            java.lang.String r7 = r4.getString(r0)     // Catch:{ JSONException -> 0x0159 }
            r11 = 1
        L_0x013e:
            r5.mo34087a(r3)     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r0 = "fallbackUrl"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x0159 }
            r5.mo34090b(r0)     // Catch:{ JSONException -> 0x0159 }
            r5.f31617j = r7     // Catch:{ JSONException -> 0x0159 }
            r5.f31615h = r11     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r0 = "appBundleId"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x0159 }
            r5.f31630w = r0     // Catch:{ JSONException -> 0x0159 }
            goto L_0x015a
        L_0x0159:
            r0 = move-exception
        L_0x015a:
            boolean r0 = r4.isNull(r2)     // Catch:{ JSONException -> 0x018c }
            if (r0 != 0) goto L_0x0174
            java.lang.String r0 = r4.getString(r2)     // Catch:{ JSONException -> 0x018c }
            int r0 = m34086d(r0)     // Catch:{ JSONException -> 0x018c }
            r5.f31616i = r0     // Catch:{ JSONException -> 0x018c }
            java.lang.String r0 = "fallbackUrl"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x018c }
            r5.mo34090b(r0)     // Catch:{ JSONException -> 0x018c }
        L_0x0174:
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            java.lang.String r2 = "trackers"
            boolean r0 = r0.isNull(r2)     // Catch:{ JSONException -> 0x018c }
            if (r0 != 0) goto L_0x0187
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x018c }
            java.util.List r0 = m34083b(r0)     // Catch:{ JSONException -> 0x018c }
            r5.mo34088a(r0)     // Catch:{ JSONException -> 0x018c }
        L_0x0187:
            com.inmobi.ads.ao$a r0 = r1.f31659i     // Catch:{ JSONException -> 0x018c }
            r0.f31672c = r5     // Catch:{ JSONException -> 0x018c }
            goto L_0x0199
        L_0x018c:
            r0 = move-exception
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()     // Catch:{ JSONException -> 0x02a7 }
            com.inmobi.commons.core.e.a r3 = new com.inmobi.commons.core.e.a     // Catch:{ JSONException -> 0x02a7 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x02a7 }
            r2.mo34423a(r3)     // Catch:{ JSONException -> 0x02a7 }
        L_0x0199:
            r1.f31653c = r12     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            boolean r0 = r0.has(r8)     // Catch:{ JSONException -> 0x02a7 }
            if (r0 == 0) goto L_0x01aa
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ JSONException -> 0x02a7 }
            r0.<init>()     // Catch:{ JSONException -> 0x02a7 }
            r1.f31657g = r0     // Catch:{ JSONException -> 0x02a7 }
        L_0x01aa:
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            boolean r0 = r0.isNull(r8)     // Catch:{ JSONException -> 0x02a7 }
            if (r0 != 0) goto L_0x01d4
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            org.json.JSONObject r0 = r0.getJSONObject(r8)     // Catch:{ JSONException -> 0x02a7 }
            if (r0 == 0) goto L_0x01d4
            java.util.Iterator r2 = r0.keys()     // Catch:{ JSONException -> 0x02a7 }
        L_0x01be:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x02a7 }
            if (r3 == 0) goto L_0x01d4
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r4 = r0.getString(r3)     // Catch:{ JSONException -> 0x02a7 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f31657g     // Catch:{ JSONException -> 0x02a7 }
            r5.put(r3, r4)     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x01be
        L_0x01d4:
            r16.m34088d()     // Catch:{ JSONException -> 0x02a7 }
            r16.m34091e()     // Catch:{ JSONException -> 0x02a7 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.f31665p     // Catch:{ JSONException -> 0x02a7 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ JSONException -> 0x02a7 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ JSONException -> 0x02a7 }
        L_0x01e4:
            boolean r0 = r2.hasNext()     // Catch:{ JSONException -> 0x02a7 }
            if (r0 == 0) goto L_0x028a
            java.lang.Object r0 = r2.next()     // Catch:{ JSONException -> 0x02a7 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ JSONException -> 0x02a7 }
            java.lang.Object r3 = r0.getValue()     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x02a7 }
            java.util.Map<java.lang.String, com.inmobi.ads.ak> r4 = r1.f31664o     // Catch:{ JSONException -> 0x02a7 }
            java.lang.Object r0 = r0.getKey()     // Catch:{ JSONException -> 0x02a7 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ JSONException -> 0x02a7 }
            r4 = r0
            com.inmobi.ads.ak r4 = (com.inmobi.ads.C10400ak) r4     // Catch:{ JSONException -> 0x02a7 }
            int r0 = r4.f31621n     // Catch:{ JSONException -> 0x02a7 }
            r5 = 4
            if (r5 != r0) goto L_0x0286
            java.util.Map<java.lang.String, com.inmobi.ads.ak> r0 = r1.f31664o     // Catch:{ JSONException -> 0x02a7 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ JSONException -> 0x02a7 }
            r3 = r0
            com.inmobi.ads.ak r3 = (com.inmobi.ads.C10400ak) r3     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r0 = "VIDEO"
            java.lang.String r6 = r3.f31609b     // Catch:{ JSONException -> 0x02a7 }
            boolean r0 = r0.equals(r6)     // Catch:{ JSONException -> 0x02a7 }
            if (r0 == 0) goto L_0x0283
            r0 = r3
            com.inmobi.ads.be r0 = (com.inmobi.ads.C10449be) r0     // Catch:{ JSONException -> 0x02a7 }
            com.inmobi.ads.by r0 = r0.mo34158b()     // Catch:{ JSONException -> 0x02a7 }
            com.inmobi.ads.bx r0 = (com.inmobi.ads.C10475bx) r0     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r0 = r0.f31873b     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r6 = ":"
            java.lang.String[] r0 = r0.split(r6)     // Catch:{ JSONException -> 0x02a7 }
            r6 = 1
            r7 = r0[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0241 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0241 }
            int r7 = r7 * 60
            r8 = 2
            r0 = r0[r8]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x023f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x023f }
            int r0 = r0 + r7
            goto L_0x0251
        L_0x023f:
            r0 = move-exception
            goto L_0x0243
        L_0x0241:
            r0 = move-exception
            r8 = 2
        L_0x0243:
            com.inmobi.commons.core.a.a r7 = com.inmobi.commons.core.p218a.C10621a.m34854a()     // Catch:{ JSONException -> 0x02a7 }
            com.inmobi.commons.core.e.a r9 = new com.inmobi.commons.core.e.a     // Catch:{ JSONException -> 0x02a7 }
            r9.<init>(r0)     // Catch:{ JSONException -> 0x02a7 }
            r7.mo34423a(r9)     // Catch:{ JSONException -> 0x02a7 }
            r0 = 0
        L_0x0251:
            if (r0 != 0) goto L_0x0258
            int r0 = r0 / 4
            r4.f31622o = r0     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x027b
        L_0x0258:
            int r7 = r4.f31622o     // Catch:{ JSONException -> 0x02a7 }
            r9 = 50
            if (r7 == r9) goto L_0x0276
            r9 = 75
            if (r7 == r9) goto L_0x0270
            r5 = 100
            if (r7 == r5) goto L_0x026c
            int r0 = r0 / 4
            r4.f31622o = r0     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x027b
        L_0x026c:
            r4.f31622o = r0     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x027b
        L_0x0270:
            int r0 = r0 * 3
            int r0 = r0 / r5
            r4.f31622o = r0     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x027b
        L_0x0276:
            int r0 = r0 / 2
            r4.f31622o = r0     // Catch:{ JSONException -> 0x02a7 }
        L_0x027b:
            com.inmobi.ads.be r3 = (com.inmobi.ads.C10449be) r3     // Catch:{ JSONException -> 0x02a7 }
            java.util.List<com.inmobi.ads.ak> r0 = r3.f31792z     // Catch:{ JSONException -> 0x02a7 }
            r0.add(r4)     // Catch:{ JSONException -> 0x02a7 }
            goto L_0x0288
        L_0x0283:
            r6 = 1
            r8 = 2
            goto L_0x0288
        L_0x0286:
            r6 = 1
            r8 = 2
        L_0x0288:
            goto L_0x01e4
        L_0x028a:
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r2 = "pages"
            boolean r0 = r0.isNull(r2)     // Catch:{ JSONException -> 0x02a7 }
            if (r0 == 0) goto L_0x029c
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x02a7 }
            r0.<init>()     // Catch:{ JSONException -> 0x02a7 }
            r1.f31655e = r0     // Catch:{ JSONException -> 0x02a7 }
            return
        L_0x029c:
            org.json.JSONObject r0 = r1.f31662m     // Catch:{ JSONException -> 0x02a7 }
            java.lang.String r2 = "pages"
            org.json.JSONArray r0 = r0.getJSONArray(r2)     // Catch:{ JSONException -> 0x02a7 }
            r1.f31655e = r0     // Catch:{ JSONException -> 0x02a7 }
            return
        L_0x02a7:
            r0 = move-exception
            com.inmobi.commons.core.a.a r2 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r3 = new com.inmobi.commons.core.e.a
            r3.<init>(r0)
            r2.mo34423a(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34094f():void");
    }

    /* renamed from: a */
    private static C10400ak m34067a(C10406ao aoVar, C10400ak akVar) {
        while (true) {
            String str = (String) akVar.f31612e;
            if (str == null || str.length() == 0) {
                return null;
            }
            String[] split = str.split("\\|");
            C10400ak b = aoVar.mo34106b(split[0]);
            if (b == null) {
                aoVar = aoVar.f31656f;
            } else if (b.equals(akVar)) {
                return null;
            } else {
                if (1 == split.length) {
                    b.f31620m = 1;
                    return b;
                }
                b.f31620m = m34063a(split[1]);
                StringBuilder sb = new StringBuilder("Referenced asset (");
                sb.append(b.f31611d);
                sb.append(")");
                return b;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int m34063a(java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = -1412832500(0xffffffffabc9e30c, float:-1.4344927E-12)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x0032
            if (r0 == 0) goto L_0x0028
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x001e
        L_0x001d:
            goto L_0x003c
        L_0x001e:
            java.lang.String r0 = "video"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x001d
            r5 = 2
            goto L_0x003d
        L_0x0028:
            java.lang.String r0 = ""
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x001d
            r5 = 1
            goto L_0x003d
        L_0x0032:
            java.lang.String r0 = "companion"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x001d
            r5 = 3
            goto L_0x003d
        L_0x003c:
            r5 = -1
        L_0x003d:
            if (r5 == r4) goto L_0x0046
            if (r5 == r3) goto L_0x0046
            if (r5 == r2) goto L_0x0045
            r5 = 0
            return r5
        L_0x0045:
            return r3
        L_0x0046:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34063a(java.lang.String):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final boolean mo34108c() {
        C10402am amVar;
        C10402am amVar2 = this.f31654d;
        if (amVar2 == null) {
            return false;
        }
        Iterator it = amVar2.iterator();
        while (true) {
            if (!it.hasNext()) {
                amVar = null;
                break;
            }
            C10400ak akVar = (C10400ak) it.next();
            if (akVar.f31611d.equalsIgnoreCase("card_scrollable")) {
                amVar = (C10402am) akVar;
                break;
            }
        }
        if (amVar == null) {
            return m34097g();
        }
        if (mo34105b() <= 0) {
            return false;
        }
        return m34097g();
    }

    /* renamed from: g */
    private boolean m34097g() {
        List<C10400ak> c = mo34107c("VIDEO");
        if (c == null || c.size() <= 0) {
            return true;
        }
        for (C10400ak akVar : c) {
            akVar.f31608a.length();
            C10449be beVar = (C10449be) akVar;
            if (beVar.mo34158b() == null) {
                return false;
            }
            List c2 = beVar.mo34158b().mo34199c();
            if (c2 == null || c2.size() == 0) {
                return false;
            }
            String b = beVar.mo34158b().mo34198b();
            if (b != null) {
                if (b.length() == 0) {
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("[ERRORCODE]", "403");
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_ERROR, (Map<String, String>) hashMap);
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r21v0 */
    /* JADX WARNING: type inference failed for: r13v1, types: [int] */
    /* JADX WARNING: type inference failed for: r23v0 */
    /* JADX WARNING: type inference failed for: r27v0 */
    /* JADX WARNING: type inference failed for: r23v1 */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.inmobi.ads.ak, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r23v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: type inference failed for: r23v3 */
    /* JADX WARNING: type inference failed for: r27v3 */
    /* JADX WARNING: type inference failed for: r14v1, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v4 */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r27v5 */
    /* JADX WARNING: type inference failed for: r23v5 */
    /* JADX WARNING: type inference failed for: r27v6 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r15v1, types: [com.inmobi.ads.ak, com.inmobi.ads.am] */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r8v30, types: [com.inmobi.ads.am] */
    /* JADX WARNING: type inference failed for: r9v15, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v31, types: [com.inmobi.ads.am] */
    /* JADX WARNING: type inference failed for: r9v16, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r15v4 */
    /* JADX WARNING: type inference failed for: r27v7 */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: type inference failed for: r23v7 */
    /* JADX WARNING: type inference failed for: r27v8 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r14v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v9 */
    /* JADX WARNING: type inference failed for: r2v23, types: [com.inmobi.ads.az, com.inmobi.ads.ak] */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r23v8 */
    /* JADX WARNING: type inference failed for: r14v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v10 */
    /* JADX WARNING: type inference failed for: r1v17, types: [com.inmobi.ads.ak, com.inmobi.ads.ar] */
    /* JADX WARNING: type inference failed for: r23v9 */
    /* JADX WARNING: type inference failed for: r27v11 */
    /* JADX WARNING: type inference failed for: r23v10 */
    /* JADX WARNING: type inference failed for: r27v12 */
    /* JADX WARNING: type inference failed for: r23v11 */
    /* JADX WARNING: type inference failed for: r1v22, types: [com.inmobi.ads.ak, com.inmobi.ads.bb] */
    /* JADX WARNING: type inference failed for: r14v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r23v12 */
    /* JADX WARNING: type inference failed for: r27v13 */
    /* JADX WARNING: type inference failed for: r23v13 */
    /* JADX WARNING: type inference failed for: r3v37, types: [com.inmobi.ads.ak] */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r8v33, types: [com.inmobi.ads.aq] */
    /* JADX WARNING: type inference failed for: r9v17, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v34, types: [com.inmobi.ads.as] */
    /* JADX WARNING: type inference failed for: r9v18, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v35, types: [com.inmobi.ads.aq] */
    /* JADX WARNING: type inference failed for: r9v19, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v36, types: [com.inmobi.ads.as] */
    /* JADX WARNING: type inference failed for: r9v20, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v14 */
    /* JADX WARNING: type inference failed for: r23v14 */
    /* JADX WARNING: type inference failed for: r1v33, types: [com.inmobi.ads.bf] */
    /* JADX WARNING: type inference failed for: r2v50, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r14v14 */
    /* JADX WARNING: type inference failed for: r27v15 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r23v15 */
    /* JADX WARNING: type inference failed for: r19v2 */
    /* JADX WARNING: type inference failed for: r8v44, types: [com.inmobi.ads.be] */
    /* JADX WARNING: type inference failed for: r9v24, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r23v16 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r19v4 */
    /* JADX WARNING: type inference failed for: r19v5 */
    /* JADX WARNING: type inference failed for: r23v17 */
    /* JADX WARNING: type inference failed for: r19v6 */
    /* JADX WARNING: type inference failed for: r19v7 */
    /* JADX WARNING: type inference failed for: r19v8 */
    /* JADX WARNING: type inference failed for: r23v18 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r27v16 */
    /* JADX WARNING: type inference failed for: r23v19 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r27v17 */
    /* JADX WARNING: type inference failed for: r23v20 */
    /* JADX WARNING: type inference failed for: r27v18 */
    /* JADX WARNING: type inference failed for: r23v21 */
    /* JADX WARNING: type inference failed for: r27v19 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r0v81, types: [com.inmobi.ads.ak] */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r23v22 */
    /* JADX WARNING: type inference failed for: r27v20 */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r8v59, types: [com.inmobi.ads.an] */
    /* JADX WARNING: type inference failed for: r9v34, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v82 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r27v21 */
    /* JADX WARNING: type inference failed for: r8v60, types: [com.inmobi.ads.an] */
    /* JADX WARNING: type inference failed for: r9v35, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* JADX WARNING: type inference failed for: r27v22 */
    /* JADX WARNING: type inference failed for: r23v23 */
    /* JADX WARNING: type inference failed for: r0v84 */
    /* JADX WARNING: type inference failed for: r6v34 */
    /* JADX WARNING: type inference failed for: r27v23 */
    /* JADX WARNING: type inference failed for: r27v24 */
    /* JADX WARNING: type inference failed for: r23v24 */
    /* JADX WARNING: type inference failed for: r27v25 */
    /* JADX WARNING: type inference failed for: r21v5 */
    /* JADX WARNING: type inference failed for: r23v25 */
    /* JADX WARNING: type inference failed for: r23v26 */
    /* JADX WARNING: type inference failed for: r23v27 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r27v26 */
    /* JADX WARNING: type inference failed for: r23v28 */
    /* JADX WARNING: type inference failed for: r27v27 */
    /* JADX WARNING: type inference failed for: r14v24 */
    /* JADX WARNING: type inference failed for: r27v28 */
    /* JADX WARNING: type inference failed for: r23v29 */
    /* JADX WARNING: type inference failed for: r27v29 */
    /* JADX WARNING: type inference failed for: r23v30 */
    /* JADX WARNING: type inference failed for: r27v30 */
    /* JADX WARNING: type inference failed for: r27v31 */
    /* JADX WARNING: type inference failed for: r27v32 */
    /* JADX WARNING: type inference failed for: r23v31 */
    /* JADX WARNING: type inference failed for: r23v32 */
    /* JADX WARNING: type inference failed for: r23v33 */
    /* JADX WARNING: type inference failed for: r8v61, types: [com.inmobi.ads.am] */
    /* JADX WARNING: type inference failed for: r27v33 */
    /* JADX WARNING: type inference failed for: r27v34 */
    /* JADX WARNING: type inference failed for: r14v25 */
    /* JADX WARNING: type inference failed for: r1v78 */
    /* JADX WARNING: type inference failed for: r27v35 */
    /* JADX WARNING: type inference failed for: r23v34 */
    /* JADX WARNING: type inference failed for: r27v36 */
    /* JADX WARNING: type inference failed for: r27v37 */
    /* JADX WARNING: type inference failed for: r1v79 */
    /* JADX WARNING: type inference failed for: r14v26 */
    /* JADX WARNING: type inference failed for: r27v38 */
    /* JADX WARNING: type inference failed for: r27v39 */
    /* JADX WARNING: type inference failed for: r27v40 */
    /* JADX WARNING: type inference failed for: r27v41 */
    /* JADX WARNING: type inference failed for: r27v42 */
    /* JADX WARNING: type inference failed for: r27v43 */
    /* JADX WARNING: type inference failed for: r23v35 */
    /* JADX WARNING: type inference failed for: r23v36 */
    /* JADX WARNING: type inference failed for: r23v37 */
    /* JADX WARNING: type inference failed for: r23v38 */
    /* JADX WARNING: type inference failed for: r23v39 */
    /* JADX WARNING: type inference failed for: r23v40 */
    /* JADX WARNING: type inference failed for: r8v62, types: [com.inmobi.ads.aq] */
    /* JADX WARNING: type inference failed for: r8v63, types: [com.inmobi.ads.as] */
    /* JADX WARNING: type inference failed for: r8v64, types: [com.inmobi.ads.aq] */
    /* JADX WARNING: type inference failed for: r8v65, types: [com.inmobi.ads.as] */
    /* JADX WARNING: type inference failed for: r27v44 */
    /* JADX WARNING: type inference failed for: r27v45 */
    /* JADX WARNING: type inference failed for: r27v46 */
    /* JADX WARNING: type inference failed for: r27v47 */
    /* JADX WARNING: type inference failed for: r27v48 */
    /* JADX WARNING: type inference failed for: r23v41 */
    /* JADX WARNING: type inference failed for: r23v42 */
    /* JADX WARNING: type inference failed for: r23v43 */
    /* JADX WARNING: type inference failed for: r23v44 */
    /* JADX WARNING: type inference failed for: r14v27 */
    /* JADX WARNING: type inference failed for: r27v49 */
    /* JADX WARNING: type inference failed for: r27v50 */
    /* JADX WARNING: type inference failed for: r27v51 */
    /* JADX WARNING: type inference failed for: r27v52 */
    /* JADX WARNING: type inference failed for: r27v53 */
    /* JADX WARNING: type inference failed for: r27v54 */
    /* JADX WARNING: type inference failed for: r27v55 */
    /* JADX WARNING: type inference failed for: r27v56 */
    /* JADX WARNING: type inference failed for: r27v57 */
    /* JADX WARNING: type inference failed for: r19v9 */
    /* JADX WARNING: type inference failed for: r19v10 */
    /* JADX WARNING: type inference failed for: r19v11 */
    /* JADX WARNING: type inference failed for: r23v45 */
    /* JADX WARNING: type inference failed for: r23v46 */
    /* JADX WARNING: type inference failed for: r19v12 */
    /* JADX WARNING: type inference failed for: r19v13 */
    /* JADX WARNING: type inference failed for: r19v14 */
    /* JADX WARNING: type inference failed for: r19v15 */
    /* JADX WARNING: type inference failed for: r27v58 */
    /* JADX WARNING: type inference failed for: r23v47 */
    /* JADX WARNING: type inference failed for: r27v59 */
    /* JADX WARNING: type inference failed for: r27v60 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r27v61 */
    /* JADX WARNING: type inference failed for: r27v62 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019e, code lost:
        r28 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01a1, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r3 = r15.getJSONObject(r8).optString(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ab, code lost:
        if (r18 == null) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01b1, code lost:
        if (r18.size() != 0) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01b3, code lost:
        r4 = r43;
        r6 = r12;
        r28 = r13;
        r27 = r23;
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01bf, code lost:
        r8 = r8;
        r5 = r24;
        r11 = r1;
        r6 = r12;
        r1 = r43;
        r27 = r23;
        r28 = r13;
        r14 = r2;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r8 = new com.inmobi.ads.C10404an
        r15 = r2;
        r0 = r8;
        r4 = r1;
        r6 = r6;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01da, code lost:
        r4 = r43;
        r6 = r12;
        r28 = r13;
        r27 = r23;
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01e3, code lost:
        r8 = new com.inmobi.ads.C10404an
        r0 = r8;
        r27 = r27;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01f2, code lost:
        r0.f31614g = r4;
        m34074a((com.inmobi.ads.C10400ak) r0, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f8, code lost:
        if (r3 == null) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01fa, code lost:
        r0.mo34090b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01fd, code lost:
        r21 = r0;
        r39 = r5;
        r23 = r6;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0205, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0206, code lost:
        r39 = r5;
        r23 = r6;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x020c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x020d, code lost:
        r28 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0210, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0211, code lost:
        r28 = r19;
        r26 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0215, code lost:
        r27 = r23;
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0219, code lost:
        r39 = r24;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x021d, code lost:
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r23 = r12;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x022e, code lost:
        r1 = r43;
        r14 = r12;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r12 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0239, code lost:
        r23 = r23;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r7.f31658h.get(r13);
        r38 = r7.m34109s(r9);
        r8 = r2.x;
        r2 = r2.y;
        r9 = r3.x;
        r3 = r3.y;
        r13 = r4.x;
        r4 = r4.y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0250, code lost:
        r24 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0252, code lost:
        r23 = r23;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        r29 = new com.inmobi.ads.C10449be.C10450a(r8, r2, r9, r3, r13, r4, r5.x, r5.y, r38);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x026b, code lost:
        r8 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x026d, code lost:
        if (r8 == null) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0273, code lost:
        if (m34077a(r8, (com.inmobi.ads.C10401al) r29) != false) goto L_0x0289;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0275, code lost:
        com.inmobi.commons.core.p222e.C10659b.m34983a();
        com.inmobi.commons.core.p222e.C10659b.m34987a("ads", "InvalidVideoGeometry", new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0285, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0286, code lost:
        r23 = r14;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x028b, code lost:
        if (r7.f31666q != null) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        r0 = r7.m34071a(r15, r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r0 = r7.f31666q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0294, code lost:
        r12 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a0, code lost:
        r3 = "showMute";
        r4 = "soundOn";
        r5 = "showProgress";
        r8 = "loop";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02a8, code lost:
        if (com.inmobi.ads.AdContainer.RenderingProperties.PlacementType.PLACEMENT_TYPE_INLINE != r7.f31668s) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02aa, code lost:
        if (r6 == null) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02bb, code lost:
        if (((java.lang.Boolean) r6.f31629v.get("didRequestFullScreen")).booleanValue() != false) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02bf, code lost:
        if (r7.f31669t == false) goto L_0x02c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02c2, code lost:
        r19 = r14;
        r0 = false;
        r2 = com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        r3 = 0;
        r13 = true;
        r14 = true;
        r16 = true;
        r17 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02d1, code lost:
        r0 = r15.optBoolean(r8, false);
        r5 = r15.optBoolean(r5, true);
        r4 = r15.optBoolean(r4, true);
        r3 = r15.optBoolean(r3, true);
        r2 = r15.optBoolean("autoPlay", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02f1, code lost:
        r19 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02f5, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        r17 = r2;
        r14 = r3;
        r13 = r4;
        r16 = r5;
        r2 = ((com.inmobi.ads.C10449be) r6).f31788E;
        r3 = (int) r15.optDouble("pauseAfter", 0.0d);
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0304, code lost:
        r19 = r14;
        r0 = r15.optBoolean(r8, true);
        r5 = r15.optBoolean(r5, false);
        r4 = r15.optBoolean(r4, false);
        r2 = r15.optBoolean(r3, false);
        r9 = r2;
        r14 = r15.optBoolean("autoPlay", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0332, code lost:
        r3 = (int) r15.optDouble("pauseAfter", 0.0d);
        r16 = r5;
        r2 = r15.optInt("completeAfter", com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        r17 = r14;
        r13 = r4;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x033c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x033d, code lost:
        r23 = r19;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0341, code lost:
        r19 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0344, code lost:
        r23 = r23;
        r27 = r27;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r0 = r15.optBoolean(r8, false);
        r2 = r15.optBoolean(r5, true);
        r4 = r15.optBoolean(r4, true);
        r3 = r15.optBoolean(r3, true);
        r5 = r15.optBoolean("autoPlay", true);
        r16 = r2;
        r14 = r3;
        r13 = r4;
        r17 = r5;
        r2 = r15.optInt("completeAfter", com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT);
        r3 = (int) r15.optDouble("pauseAfter", 0.0d);
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0375, code lost:
        r4 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0380, code lost:
        if (r15.isNull("videoViewabilityConfig") != false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0384, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        r5 = r15.getJSONObject("videoViewabilityConfig");
        r8 = r5.keys();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0390, code lost:
        if (r8.hasNext() == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0392, code lost:
        r9 = (java.lang.String) r8.next();
        r20 = r8;
        r4.put(r9, r5.get(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03a1, code lost:
        r8 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03a4, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:?, code lost:
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03ac, code lost:
        r8 = r8;
        r20 = r7.f31667r.f31897i.f31955m;
        r39 = r24;
        r23 = r19;
        r7 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03bc, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
        r8 = new com.inmobi.ads.C10449be
        r8.f31790G = new java.util.HashMap(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03c7, code lost:
        if (r2 > 0) goto L_0x03cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03c9, code lost:
        r2 = com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03cc, code lost:
        r8.f31788E = r2;
        r8.f31614g = r1;
        r8.f31632y = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03d4, code lost:
        if (r6 == null) goto L_0x03d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03d6, code lost:
        r6.f31632y = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03d9, code lost:
        if (r3 == 0) goto L_0x03de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03db, code lost:
        r8.f31789F = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03de, code lost:
        r7 = r40;
        r1 = r8;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03e4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03e5, code lost:
        r39 = r24;
        r7 = r40;
        r23 = r19;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03ed, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x03ee, code lost:
        r39 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x03f1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x03f2, code lost:
        r39 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x03f4, code lost:
        r7 = r40;
        r14 = r14;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x03f8, code lost:
        r1 = r43;
        r7 = r15;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0407, code lost:
        if (r0 != null) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0409, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x040a, code lost:
        r11 = com.inmobi.ads.C10451bf.m34210c(m34098h(r41));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0419, code lost:
        if (com.mopub.common.MoPubBrowser.DESTINATION_URL_KEY.equals(r11) == false) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x041f, code lost:
        if (android.webkit.URLUtil.isValidUrl(r0) != false) goto L_0x0422;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0421, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0422, code lost:
        r15 = r1;
        r1 = new com.inmobi.ads.C10451bf
        r1.f31795z = r11;
        r1.f31614g = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0448, code lost:
        if (r7.optBoolean("preload", false) == false) goto L_0x0454;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x044a, code lost:
        r1.f31793A = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x044d, code lost:
        r7 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x044f, code lost:
        r14 = r14;
        r27 = r27;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:?, code lost:
        r7.f31661k = r1;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0451, code lost:
        r1 = r1;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0454, code lost:
        r7 = r40;
        r21 = r1;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x045a, code lost:
        r0 = r8;
        r13 = r15;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r15 = r43;
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x046c, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        r1 = m34069a(r2, r3, r4, r5, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0475, code lost:
        if (m34106p(r41) == false) goto L_0x0499;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0478, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0480, code lost:
        if (r13.getJSONObject(r0).isNull(r11) != false) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0482, code lost:
        r2 = m34086d(r13.getJSONObject(r0).getString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x048f, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0490, code lost:
        r0 = r13.getJSONObject(r0).optString(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0499, code lost:
        r0 = null;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x049c, code lost:
        if (r18 == null) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04a2, code lost:
        if (r18.size() != 0) goto L_0x04ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04a4, code lost:
        r6 = r42;
        r4 = r13;
        r5 = r15;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04af, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x04b3, code lost:
        if (r25.equals(r42) == false) goto L_0x04ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04b5, code lost:
        r4 = r13;
        r5 = r15;
        r8 = new com.inmobi.ads.C10414as
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04ca, code lost:
        r4 = r13;
        r5 = r15;
        r8 = new com.inmobi.ads.C10412aq
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04df, code lost:
        r6 = r42;
        r4 = r13;
        r5 = r15;
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x04e9, code lost:
        if (r3.equals(r6) == false) goto L_0x04fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x04eb, code lost:
        r8 = new com.inmobi.ads.C10414as
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x04fc, code lost:
        r8 = new com.inmobi.ads.C10412aq
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x050c, code lost:
        r3.f31614g = r5;
        m34074a((com.inmobi.ads.C10400ak) r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0512, code lost:
        if (r0 == null) goto L_0x051a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0514, code lost:
        r3.mo34090b(r0);
        r1 = r3;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x051a, code lost:
        r21 = r3;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x051e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x051f, code lost:
        r6 = r42;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0523, code lost:
        r11 = r43;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r23 = r12;
        r12 = 0;
        r13 = r42;
        r0 = m34069a(r2, r3, r4, r5, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0542, code lost:
        if (r15.has("startOffset") == false) goto L_0x054f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0544, code lost:
        r1 = r7.m34107q(r15.getJSONObject("startOffset"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x054f, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0558, code lost:
        if (r15.has("timerDuration") == false) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x055a, code lost:
        r2 = r7.m34107q(r15.getJSONObject("timerDuration"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0565, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0567, code lost:
        r3 = r15.optBoolean("displayTimer", true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0574, code lost:
        r14 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0576, code lost:
        r27 = r27;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        r1 = new com.inmobi.ads.C10443bb
        r1.f31767z = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0582, code lost:
        if (r15.has("assetOnFinish") == false) goto L_0x05d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0584, code lost:
        r0 = (org.json.JSONObject) r15.get("assetOnFinish");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0592, code lost:
        if (r0.has("action") == false) goto L_0x05d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0594, code lost:
        r0 = r0.getString("action").toUpperCase(java.util.Locale.US).trim();
        r2 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x05ac, code lost:
        if (r2 == 2142494) goto L_0x05be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x05b1, code lost:
        if (r2 == 2402104) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x05ba, code lost:
        if (r0.equals("NONE") == false) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x05bc, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x05c4, code lost:
        if (r0.equals("EXIT") == false) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x05c6, code lost:
        r0 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x05c8, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x05ca, code lost:
        if (r0 == 2) goto L_0x05cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x05cd, code lost:
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x05ce, code lost:
        r1.f31618k = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x05d0, code lost:
        r1.f31614g = r11;
        r23 = r14;
        r27 = r27;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x05d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x05d9, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x05db, code lost:
        r13 = r42;
        r11 = r43;
        r14 = r12;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r1 = new com.inmobi.ads.C10413ar
        r1.f31614g = r11;
        r23 = r14;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0600, code lost:
        r13 = r42;
        r11 = r43;
        r14 = r12;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r2 = new com.inmobi.ads.C10436az
        r2.f31614g = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x061c, code lost:
        r1 = r2;
        r23 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0622, code lost:
        r0 = e;
        r27 = r27;
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0623, code lost:
        r23 = r14;
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0627, code lost:
        r6 = r42;
        r0 = r8;
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r16 = r25;
        r8 = r44;
        r23 = r12;
        r7 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0641, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:?, code lost:
        r1 = m34069a(r2, r3, r4, r5, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0645, code lost:
        if (r8 == null) goto L_0x065c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x064b, code lost:
        if (m34077a(r8, r1) != false) goto L_0x065c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x064d, code lost:
        com.inmobi.commons.core.p222e.C10659b.m34983a();
        com.inmobi.commons.core.p222e.C10659b.m34987a("ads", "InvalidContainerGeometry", new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0662, code lost:
        if (m34106p(r41) == false) goto L_0x0686;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x066d, code lost:
        if (r15.getJSONObject(r0).isNull(r11) != false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x066f, code lost:
        r2 = m34086d(r15.getJSONObject(r0).getString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x067c, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x067d, code lost:
        r0 = r15.getJSONObject(r0).optString(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0686, code lost:
        r0 = null;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0690, code lost:
        if (r9.has("transitionEffect") == false) goto L_0x06c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0692, code lost:
        r3 = r9.getString("transitionEffect").trim();
        r4 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x06a3, code lost:
        if (r4 == 3151468) goto L_0x06b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x06a8, code lost:
        if (r4 == 106426293) goto L_0x06ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x06b1, code lost:
        if (r3.equals("paged") == false) goto L_0x06aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x06b3, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x06bb, code lost:
        if (r3.equals("free") == false) goto L_0x06aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x06bd, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x06bf, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x06c1, code lost:
        if (r3 == 2) goto L_0x06c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x06c3, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x06c5, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x06c7, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x06c9, code lost:
        if (r18 == null) goto L_0x06f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x06cf, code lost:
        if (r18.size() != 0) goto L_0x06da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x06d1, code lost:
        r44 = r13;
        r4 = r15;
        r6 = r16;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x06da, code lost:
        r6 = r16;
        r44 = r13;
        r4 = r15;
        r8 = new com.inmobi.ads.C10402am
        r15 = r8;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x06f6, code lost:
        r44 = r13;
        r4 = r15;
        r6 = r16;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x06fe, code lost:
        r8 = new com.inmobi.ads.C10402am
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x070b, code lost:
        r15.f31614g = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x070e, code lost:
        if (r0 == null) goto L_0x0713;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x0710, code lost:
        r15.mo34090b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x0713, code lost:
        m34074a((com.inmobi.ads.C10400ak) r15, r4);
        r0 = r4.getJSONArray("assetValue");
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0721, code lost:
        if (r2 >= r0.length()) goto L_0x0827;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0723, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append(r7);
        r3.append(".assetValue[");
        r3.append(r2);
        r3.append("]");
        r3 = r3.toString();
        r4 = r0.getJSONObject(r2);
        r8 = m34093f(r4).toLowerCase(java.util.Locale.US).trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0753, code lost:
        switch(r8.hashCode()) {
            case -938102371: goto L_0x07b5;
            case -410956671: goto L_0x07ab;
            case 98832: goto L_0x07a1;
            case 102340: goto L_0x0796;
            case 3226745: goto L_0x078c;
            case 3556653: goto L_0x0782;
            case 100313435: goto L_0x0778;
            case 110364485: goto L_0x076d;
            case 112202875: goto L_0x0763;
            case 1224424441: goto L_0x0758;
            default: goto L_0x0756;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x075e, code lost:
        if (r8.equals("webview") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0760, code lost:
        r8 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0769, code lost:
        if (r8.equals(com.vungle.warren.model.Advertisement.KEY_VIDEO) == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x076b, code lost:
        r8 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0773, code lost:
        if (r8.equals("timer") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0775, code lost:
        r8 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x077e, code lost:
        if (r8.equals("image") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x0780, code lost:
        r8 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0788, code lost:
        if (r8.equals(p005cm.aptoide.p006pt.root.execution.Command.CommandHandler.TEXT) == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x078a, code lost:
        r8 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x0792, code lost:
        if (r8.equals("icon") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0794, code lost:
        r8 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x079c, code lost:
        if (r8.equals("gif") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x079e, code lost:
        r8 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x07a7, code lost:
        if (r8.equals("cta") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x07a9, code lost:
        r8 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x07b1, code lost:
        if (r8.equals("container") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x07b3, code lost:
        r8 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x07bb, code lost:
        if (r8.equals("rating") == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x07bd, code lost:
        r8 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x07bf, code lost:
        r8 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x07c0, code lost:
        switch(r8) {
            case 2: goto L_0x07dd;
            case 3: goto L_0x07db;
            case 4: goto L_0x07d8;
            case 5: goto L_0x07d5;
            case 6: goto L_0x07d2;
            case 7: goto L_0x07cf;
            case 8: goto L_0x07cc;
            case 9: goto L_0x07c9;
            case 10: goto L_0x07c6;
            default: goto L_0x07c3;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x07c3, code lost:
        r13 = "CONTAINER";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x07c6, code lost:
        r13 = "GIF";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x07c9, code lost:
        r13 = "WEBVIEW";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x07cc, code lost:
        r13 = "TIMER";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x07cf, code lost:
        r13 = "RATING";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x07d2, code lost:
        r13 = "CTA";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x07d5, code lost:
        r13 = "TEXT";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x07d8, code lost:
        r13 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x07db, code lost:
        r13 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x07dd, code lost:
        r13 = "ICON";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x07df, code lost:
        r7 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x07e2, code lost:
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:?, code lost:
        r8 = r7.m34068a(r4, r13, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x07e6, code lost:
        if (r8 != null) goto L_0x07f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x07e8, code lost:
        new java.lang.StringBuilder("Cannot build asset from JSON: ").append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x07f3, code lost:
        r8.f31614g = r3;
        r8.f31627t = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x07fe, code lost:
        if (r15.f31646C >= 16) goto L_0x0821;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0805, code lost:
        if (r15.f31646C != r15.f31645B.length) goto L_0x0817;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0807, code lost:
        r3 = new com.inmobi.ads.C10400ak[(r15.f31645B.length * 2)];
        java.lang.System.arraycopy(r15.f31645B, r5, r3, r5, r15.f31646C);
        r15.f31645B = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x0817, code lost:
        r3 = r15.f31645B;
        r4 = r15.f31646C;
        r15.f31646C = r4 + 1;
        r3[r4] = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x0821, code lost:
        r2 = r2 + 1;
        r7 = r43;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0827, code lost:
        r7 = r40;
        r1 = r15;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x082b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x082c, code lost:
        r7 = r40;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x082f, code lost:
        r1 = r21;
        r27 = r27;
        r23 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x084d, code lost:
        r1.f31621n = r39;
        r1.f31622o = r28;
        r1.f31623p = r27;
        r2 = r26;
        r1.f31624q = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x0861, code lost:
        if (r2 == null) goto L_0x0871;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0869, code lost:
        r3 = r23;
        r7.f31665p.put(r3, r2);
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0871, code lost:
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0881, code lost:
        r7.f31664o.put(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0886, code lost:
        r2 = r42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x088e, code lost:
        if (r7.f31658h.containsKey(r2) != false) goto L_0x0890;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0890, code lost:
        ((java.util.List) r7.f31658h.get(r2)).add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x089c, code lost:
        r0 = new java.util.ArrayList();
        r0.add(r1);
        r7.f31658h.put(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015c, code lost:
        r14 = "fallbackUrl";
        r25 = r11;
        r11 = p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys.OPEN_MODE;
        r8 = "assetOnclick";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0164, code lost:
        switch(r1) {
            case 0: goto L_0x0627;
            case 1: goto L_0x0600;
            case 2: goto L_0x05db;
            case 3: goto L_0x0523;
            case 4: goto L_0x045a;
            case 5: goto L_0x045a;
            case 6: goto L_0x03f8;
            case 7: goto L_0x022e;
            case 8: goto L_0x021d;
            case 9: goto L_0x0173;
            default: goto L_0x0167;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0167, code lost:
        r28 = r19;
        r26 = r20;
        r27 = r23;
        r39 = r24;
        r23 = r12;
        r21 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0177, code lost:
        if (m34106p(r41) != false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0179, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x017a, code lost:
        r13 = r19;
        r26 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1 = m34084c(r2, r3, r4, r5, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x018e, code lost:
        if (r15.getJSONObject(r8).isNull(r11) != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r2 = m34086d(r15.getJSONObject(r8).getString(r11));
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r27v1
      assigns: []
      uses: []
      mth insns count: 1020
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x084d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f8 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0100 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010a A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0112 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011c A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0126 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0130 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013b A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0146 A[Catch:{ JSONException -> 0x0150 }] */
    /* JADX WARNING: Unknown variable types count: 82 */
    @android.annotation.TargetApi(15)
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.inmobi.ads.C10400ak m34068a(org.json.JSONObject r41, java.lang.String r42, java.lang.String r43, com.inmobi.ads.C10401al r44) {
        /*
            r40 = this;
            r7 = r40
            r15 = r41
            r14 = r42
            r13 = r43
            r8 = r44
            java.lang.String r12 = m34087d(r41)
            java.lang.String r10 = m34090e(r41)
            org.json.JSONObject r9 = r40.m34099i(r41)
            boolean r0 = m34080a(r9, r14)
            r21 = 0
            if (r0 != 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Asset style JSON: "
            r0.<init>(r1)
            r0.append(r9)
            return r21
        L_0x0029:
            android.graphics.Point r2 = r40.m34100j(r41)
            android.graphics.Point r4 = r7.m34065a(r15, r2)
            android.graphics.Point r3 = r40.m34101k(r41)
            android.graphics.Point r5 = r7.m34081b(r15, r3)
            java.util.List r18 = m34083b(r41)
            int r11 = m34102l(r41)
            r6 = 1
            int r1 = m34064a(r15, r6)
            r6 = 0
            int r13 = m34064a(r15, r6)
            java.lang.String r6 = m34103m(r41)
            java.lang.String r0 = m34096g(r41)
            java.lang.String r0 = r0.trim()
            r19 = r1
            int r1 = r0.hashCode()
            r20 = r6
            r6 = -925155509(0xffffffffc8db3f4b, float:-449018.34)
            r22 = -1
            r23 = r13
            r13 = 2
            if (r1 == r6) goto L_0x007c
            r6 = 1728122231(0x67010d77, float:6.0943366E23)
            if (r1 == r6) goto L_0x0072
        L_0x0071:
            goto L_0x0086
        L_0x0072:
            java.lang.String r1 = "absolute"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0071
            r0 = 1
            goto L_0x0087
        L_0x007c:
            java.lang.String r1 = "reference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0071
            r0 = 2
            goto L_0x0087
        L_0x0086:
            r0 = -1
        L_0x0087:
            if (r0 == r13) goto L_0x008b
            r0 = 0
            goto L_0x008c
        L_0x008b:
            r0 = 1
        L_0x008c:
            org.json.JSONArray r1 = m34105o(r41)
            if (r1 == 0) goto L_0x00db
            int r6 = r1.length()
            if (r6 == 0) goto L_0x00db
            r6 = 0
            java.lang.String r1 = r1.getString(r6)     // Catch:{ JSONException -> 0x00c6 }
            boolean r6 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x00c2 }
            if (r6 == 0) goto L_0x00a5
            return r21
        L_0x00a5:
            r6 = 1
            if (r0 != r6) goto L_0x00bd
            com.inmobi.ads.ak r6 = r7.mo34106b(r1)     // Catch:{ JSONException -> 0x00c2 }
            if (r6 != 0) goto L_0x00bb
            com.inmobi.ads.ao r0 = r7.f31656f     // Catch:{ JSONException -> 0x00b9 }
            if (r0 == 0) goto L_0x00bb
            com.inmobi.ads.ao r0 = r7.f31656f     // Catch:{ JSONException -> 0x00b9 }
            com.inmobi.ads.ak r0 = r0.mo34106b(r1)     // Catch:{ JSONException -> 0x00b9 }
            goto L_0x00bf
        L_0x00b9:
            r0 = move-exception
            goto L_0x00ca
        L_0x00bb:
            r0 = r6
            goto L_0x00bf
        L_0x00bd:
            r0 = r21
        L_0x00bf:
            r6 = r0
            r0 = r1
            goto L_0x00de
        L_0x00c2:
            r0 = move-exception
            r6 = r21
            goto L_0x00ca
        L_0x00c6:
            r0 = move-exception
            r1 = r21
            r6 = r1
        L_0x00ca:
            com.inmobi.commons.core.a.a r13 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            r24 = r1
            com.inmobi.commons.core.e.a r1 = new com.inmobi.commons.core.e.a
            r1.<init>(r0)
            r13.mo34423a(r1)
            r0 = r24
            goto L_0x00de
        L_0x00db:
            r0 = r21
            r6 = r0
        L_0x00de:
            int r1 = r42.hashCode()     // Catch:{ JSONException -> 0x0832 }
            java.lang.String r13 = "VIDEO"
            r24 = r11
            java.lang.String r11 = "IMAGE"
            switch(r1) {
                case -1919329183: goto L_0x0146;
                case -1884772963: goto L_0x013b;
                case 67056: goto L_0x0130;
                case 70564: goto L_0x0126;
                case 2241657: goto L_0x011c;
                case 2571565: goto L_0x0112;
                case 69775675: goto L_0x010a;
                case 79826725: goto L_0x0100;
                case 81665115: goto L_0x00f8;
                case 1942407129: goto L_0x00ed;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            goto L_0x015b
        L_0x00ed:
            java.lang.String r1 = "WEBVIEW"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 6
            goto L_0x015c
        L_0x00f8:
            boolean r1 = r14.equals(r13)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 7
            goto L_0x015c
        L_0x0100:
            java.lang.String r1 = "TIMER"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 3
            goto L_0x015c
        L_0x010a:
            boolean r1 = r14.equals(r11)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 4
            goto L_0x015c
        L_0x0112:
            java.lang.String r1 = "TEXT"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 1
            goto L_0x015c
        L_0x011c:
            java.lang.String r1 = "ICON"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 2
            goto L_0x015c
        L_0x0126:
            java.lang.String r1 = "GIF"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 5
            goto L_0x015c
        L_0x0130:
            java.lang.String r1 = "CTA"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 9
            goto L_0x015c
        L_0x013b:
            java.lang.String r1 = "RATING"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 8
            goto L_0x015c
        L_0x0146:
            java.lang.String r1 = "CONTAINER"
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x0150 }
            if (r1 == 0) goto L_0x00eb
            r1 = 0
            goto L_0x015c
        L_0x0150:
            r0 = move-exception
            r28 = r19
            r26 = r20
        L_0x0155:
            r27 = r23
            r39 = r24
            goto L_0x083b
        L_0x015b:
            r1 = -1
        L_0x015c:
            java.lang.String r14 = "fallbackUrl"
            r25 = r11
            java.lang.String r11 = "openMode"
            java.lang.String r8 = "assetOnclick"
            switch(r1) {
                case 0: goto L_0x0627;
                case 1: goto L_0x0600;
                case 2: goto L_0x05db;
                case 3: goto L_0x0523;
                case 4: goto L_0x045a;
                case 5: goto L_0x045a;
                case 6: goto L_0x03f8;
                case 7: goto L_0x022e;
                case 8: goto L_0x021d;
                case 9: goto L_0x0173;
                default: goto L_0x0167;
            }
        L_0x0167:
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r23 = r12
            goto L_0x082f
        L_0x0173:
            boolean r1 = m34106p(r41)     // Catch:{ JSONException -> 0x0210 }
            if (r1 != 0) goto L_0x017a
            return r21
        L_0x017a:
            r13 = r19
            r1 = r40
            r26 = r20
            r6 = r9
            com.inmobi.ads.az$a r1 = r1.m34084c(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x020c }
            org.json.JSONObject r2 = r15.getJSONObject(r8)     // Catch:{ JSONException -> 0x020c }
            boolean r2 = r2.isNull(r11)     // Catch:{ JSONException -> 0x020c }
            if (r2 != 0) goto L_0x01a1
            org.json.JSONObject r2 = r15.getJSONObject(r8)     // Catch:{ JSONException -> 0x019d }
            java.lang.String r2 = r2.getString(r11)     // Catch:{ JSONException -> 0x019d }
            int r2 = m34086d(r2)     // Catch:{ JSONException -> 0x019d }
            goto L_0x01a2
        L_0x019d:
            r0 = move-exception
            r28 = r13
            goto L_0x0155
        L_0x01a1:
            r2 = 2
        L_0x01a2:
            org.json.JSONObject r3 = r15.getJSONObject(r8)     // Catch:{ JSONException -> 0x020c }
            java.lang.String r3 = r3.optString(r14)     // Catch:{ JSONException -> 0x020c }
            if (r18 == 0) goto L_0x01da
            int r4 = r18.size()     // Catch:{ JSONException -> 0x020c }
            if (r4 != 0) goto L_0x01bd
            r4 = r43
            r6 = r12
            r28 = r13
            r27 = r23
            r5 = r24
            goto L_0x01e3
        L_0x01bd:
            com.inmobi.ads.an r4 = new com.inmobi.ads.an     // Catch:{ JSONException -> 0x020c }
            r8 = r4
            r9 = r12
            r5 = r24
            r11 = r1
            r6 = r12
            r12 = r0
            r1 = r43
            r14 = r13
            r27 = r23
            r13 = r18
            r28 = r14
            r14 = r2
            r2 = r15
            r15 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x0205 }
            r15 = r2
            r0 = r4
            r4 = r1
            goto L_0x01f2
        L_0x01da:
            r4 = r43
            r6 = r12
            r28 = r13
            r27 = r23
            r5 = r24
        L_0x01e3:
            com.inmobi.ads.an r16 = new com.inmobi.ads.an     // Catch:{ JSONException -> 0x0205 }
            r8 = r16
            r9 = r6
            r11 = r1
            r12 = r0
            r13 = r2
            r14 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0205 }
            r0 = r16
        L_0x01f2:
            r0.f31614g = r4     // Catch:{ JSONException -> 0x0205 }
            m34074a(r0, r15)     // Catch:{ JSONException -> 0x0205 }
            if (r3 == 0) goto L_0x01fd
            r0.mo34090b(r3)     // Catch:{ JSONException -> 0x0205 }
        L_0x01fd:
            r21 = r0
            r39 = r5
            r23 = r6
            goto L_0x082f
        L_0x0205:
            r0 = move-exception
            r39 = r5
            r23 = r6
            goto L_0x083d
        L_0x020c:
            r0 = move-exception
            r28 = r13
            goto L_0x0215
        L_0x0210:
            r0 = move-exception
            r28 = r19
            r26 = r20
        L_0x0215:
            r27 = r23
            r23 = r12
        L_0x0219:
            r39 = r24
            goto L_0x083d
        L_0x021d:
            r6 = r12
            r28 = r19
            r26 = r20
            r27 = r23
            r5 = r24
            r39 = r5
            r23 = r6
            r1 = r21
            goto L_0x084b
        L_0x022e:
            r1 = r43
            r14 = r12
            r28 = r19
            r26 = r20
            r27 = r23
            r12 = r24
            java.util.Map<java.lang.String, java.util.List<com.inmobi.ads.ak>> r8 = r7.f31658h     // Catch:{ JSONException -> 0x03f1 }
            r8.get(r13)     // Catch:{ JSONException -> 0x03f1 }
            com.inmobi.ads.ba r38 = r7.m34109s(r9)     // Catch:{ JSONException -> 0x03f1 }
            com.inmobi.ads.be$a r11 = new com.inmobi.ads.be$a     // Catch:{ JSONException -> 0x03f1 }
            int r8 = r2.x     // Catch:{ JSONException -> 0x03f1 }
            int r2 = r2.y     // Catch:{ JSONException -> 0x03f1 }
            int r9 = r3.x     // Catch:{ JSONException -> 0x03f1 }
            int r3 = r3.y     // Catch:{ JSONException -> 0x03f1 }
            int r13 = r4.x     // Catch:{ JSONException -> 0x03f1 }
            int r4 = r4.y     // Catch:{ JSONException -> 0x03f1 }
            r24 = r12
            int r12 = r5.x     // Catch:{ JSONException -> 0x03ed }
            int r5 = r5.y     // Catch:{ JSONException -> 0x03ed }
            r29 = r11
            r30 = r8
            r31 = r2
            r32 = r9
            r33 = r3
            r34 = r13
            r35 = r4
            r36 = r12
            r37 = r5
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ JSONException -> 0x03ed }
            r8 = r44
            if (r8 == 0) goto L_0x0289
            boolean r2 = m34077a(r8, r11)     // Catch:{ JSONException -> 0x0285 }
            if (r2 != 0) goto L_0x0289
            com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ JSONException -> 0x0285 }
            java.lang.String r2 = "ads"
            java.lang.String r3 = "InvalidVideoGeometry"
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ JSONException -> 0x0285 }
            r4.<init>()     // Catch:{ JSONException -> 0x0285 }
            com.inmobi.commons.core.p222e.C10659b.m34987a(r2, r3, r4)     // Catch:{ JSONException -> 0x0285 }
            goto L_0x0289
        L_0x0285:
            r0 = move-exception
            r23 = r14
            goto L_0x0219
        L_0x0289:
            com.inmobi.ads.bx r2 = r7.f31666q     // Catch:{ JSONException -> 0x03ed }
            if (r2 != 0) goto L_0x0292
            com.inmobi.ads.by r0 = r7.m34071a(r15, r0, r6)     // Catch:{ JSONException -> 0x0285 }
            goto L_0x0294
        L_0x0292:
            com.inmobi.ads.bx r0 = r7.f31666q     // Catch:{ JSONException -> 0x03ed }
        L_0x0294:
            r12 = r0
            com.inmobi.ads.AdContainer$RenderingProperties$PlacementType r0 = com.inmobi.ads.AdContainer.RenderingProperties.PlacementType.PLACEMENT_TYPE_INLINE     // Catch:{ JSONException -> 0x03ed }
            com.inmobi.ads.AdContainer$RenderingProperties$PlacementType r2 = r7.f31668s     // Catch:{ JSONException -> 0x03ed }
            java.lang.String r3 = "showMute"
            java.lang.String r4 = "soundOn"
            java.lang.String r5 = "showProgress"
            java.lang.String r8 = "loop"
            if (r0 != r2) goto L_0x0341
            if (r6 == 0) goto L_0x0304
            java.util.Map<java.lang.String, java.lang.Object> r0 = r6.f31629v     // Catch:{ JSONException -> 0x0285 }
            java.lang.String r2 = "didRequestFullScreen"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ JSONException -> 0x0285 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x0285 }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x0285 }
            if (r0 != 0) goto L_0x02d1
            boolean r0 = r7.f31669t     // Catch:{ JSONException -> 0x0285 }
            if (r0 == 0) goto L_0x02c2
            goto L_0x02d1
        L_0x02c2:
            r19 = r14
            r0 = 0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r13 = 1
            r14 = 1
            r16 = 1
            r17 = 1
            goto L_0x0375
        L_0x02d1:
            r2 = 0
            boolean r0 = r15.optBoolean(r8, r2)     // Catch:{ JSONException -> 0x0285 }
            r2 = 1
            boolean r5 = r15.optBoolean(r5, r2)     // Catch:{ JSONException -> 0x0285 }
            boolean r4 = r15.optBoolean(r4, r2)     // Catch:{ JSONException -> 0x0285 }
            boolean r3 = r15.optBoolean(r3, r2)     // Catch:{ JSONException -> 0x0285 }
            java.lang.String r8 = "autoPlay"
            boolean r2 = r15.optBoolean(r8, r2)     // Catch:{ JSONException -> 0x0285 }
            r8 = r6
            com.inmobi.ads.be r8 = (com.inmobi.ads.C10449be) r8     // Catch:{ JSONException -> 0x0285 }
            int r8 = r8.f31788E     // Catch:{ JSONException -> 0x0285 }
            java.lang.String r9 = "pauseAfter"
            r19 = r14
            r13 = 0
            double r13 = r15.optDouble(r9, r13)     // Catch:{ JSONException -> 0x033c }
            int r9 = (int) r13     // Catch:{ JSONException -> 0x033c }
            r17 = r2
            r14 = r3
            r13 = r4
            r16 = r5
            r2 = r8
            r3 = r9
            goto L_0x0375
        L_0x0304:
            r19 = r14
            r2 = 1
            boolean r0 = r15.optBoolean(r8, r2)     // Catch:{ JSONException -> 0x033c }
            r2 = 0
            boolean r5 = r15.optBoolean(r5, r2)     // Catch:{ JSONException -> 0x033c }
            boolean r4 = r15.optBoolean(r4, r2)     // Catch:{ JSONException -> 0x033c }
            boolean r2 = r15.optBoolean(r3, r2)     // Catch:{ JSONException -> 0x033c }
            java.lang.String r3 = "autoPlay"
            r8 = 1
            boolean r3 = r15.optBoolean(r3, r8)     // Catch:{ JSONException -> 0x033c }
            java.lang.String r8 = "completeAfter"
            r9 = 2147483647(0x7fffffff, float:NaN)
            int r13 = r15.optInt(r8, r9)     // Catch:{ JSONException -> 0x033c }
            java.lang.String r8 = "pauseAfter"
            r9 = r2
            r14 = r3
            r2 = 0
            double r2 = r15.optDouble(r8, r2)     // Catch:{ JSONException -> 0x033c }
            int r2 = (int) r2
            r3 = r2
            r16 = r5
            r2 = r13
            r17 = r14
            r13 = r4
            r14 = r9
            goto L_0x0375
        L_0x033c:
            r0 = move-exception
            r23 = r19
            goto L_0x0219
        L_0x0341:
            r19 = r14
            r13 = 0
            boolean r0 = r15.optBoolean(r8, r13)     // Catch:{ JSONException -> 0x03e4 }
            r8 = 1
            boolean r2 = r15.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x03e4 }
            boolean r4 = r15.optBoolean(r4, r8)     // Catch:{ JSONException -> 0x03e4 }
            boolean r3 = r15.optBoolean(r3, r8)     // Catch:{ JSONException -> 0x03e4 }
            java.lang.String r5 = "autoPlay"
            boolean r5 = r15.optBoolean(r5, r8)     // Catch:{ JSONException -> 0x03e4 }
            java.lang.String r8 = "completeAfter"
            r13 = 2147483647(0x7fffffff, float:NaN)
            int r8 = r15.optInt(r8, r13)     // Catch:{ JSONException -> 0x03e4 }
            java.lang.String r9 = "pauseAfter"
            r13 = 0
            double r13 = r15.optDouble(r9, r13)     // Catch:{ JSONException -> 0x03e4 }
            int r9 = (int) r13     // Catch:{ JSONException -> 0x03e4 }
            r16 = r2
            r14 = r3
            r13 = r4
            r17 = r5
            r2 = r8
            r3 = r9
        L_0x0375:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ JSONException -> 0x03e4 }
            r4.<init>()     // Catch:{ JSONException -> 0x03e4 }
            java.lang.String r5 = "videoViewabilityConfig"
            boolean r5 = r15.isNull(r5)     // Catch:{ JSONException -> 0x03e4 }
            if (r5 != 0) goto L_0x03a4
            java.lang.String r5 = "videoViewabilityConfig"
            org.json.JSONObject r5 = r15.getJSONObject(r5)     // Catch:{ JSONException -> 0x033c }
            java.util.Iterator r8 = r5.keys()     // Catch:{ JSONException -> 0x033c }
        L_0x038c:
            boolean r9 = r8.hasNext()     // Catch:{ JSONException -> 0x033c }
            if (r9 == 0) goto L_0x03a4
            java.lang.Object r9 = r8.next()     // Catch:{ JSONException -> 0x033c }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x033c }
            r20 = r8
            java.lang.Object r8 = r5.get(r9)     // Catch:{ JSONException -> 0x033c }
            r4.put(r9, r8)     // Catch:{ JSONException -> 0x033c }
            r8 = r20
            goto L_0x038c
        L_0x03a4:
            com.inmobi.ads.be r5 = new com.inmobi.ads.be     // Catch:{ JSONException -> 0x03e4 }
            com.inmobi.ads.c r8 = r7.f31667r     // Catch:{ JSONException -> 0x03e4 }
            com.inmobi.ads.c$i r8 = r8.f31897i     // Catch:{ JSONException -> 0x03e4 }
            boolean r9 = r8.f31955m     // Catch:{ JSONException -> 0x03e4 }
            r8 = r5
            r20 = r9
            r9 = r19
            r39 = r24
            r22 = 2147483647(0x7fffffff, float:NaN)
            r23 = r19
            r7 = r15
            r15 = r0
            r19 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ JSONException -> 0x082b }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ JSONException -> 0x082b }
            r0.<init>(r4)     // Catch:{ JSONException -> 0x082b }
            r5.f31790G = r0     // Catch:{ JSONException -> 0x082b }
            if (r2 > 0) goto L_0x03cc
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x03cc:
            r5.f31788E = r2     // Catch:{ JSONException -> 0x082b }
            r5.f31614g = r1     // Catch:{ JSONException -> 0x082b }
            r5.f31632y = r6     // Catch:{ JSONException -> 0x082b }
            if (r6 == 0) goto L_0x03d9
            r6.f31632y = r5     // Catch:{ JSONException -> 0x082b }
        L_0x03d9:
            if (r3 == 0) goto L_0x03de
            r5.f31789F = r3     // Catch:{ JSONException -> 0x082b }
        L_0x03de:
            r7 = r40
            r1 = r5
            goto L_0x084b
        L_0x03e4:
            r0 = move-exception
            r39 = r24
            r7 = r40
            r23 = r19
            goto L_0x083d
        L_0x03ed:
            r0 = move-exception
            r39 = r24
            goto L_0x03f4
        L_0x03f1:
            r0 = move-exception
            r39 = r12
        L_0x03f4:
            r7 = r40
            goto L_0x0623
        L_0x03f8:
            r1 = r43
            r7 = r15
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r8 = 1
            r13 = 0
            r23 = r12
            if (r0 != 0) goto L_0x040a
            return r21
        L_0x040a:
            java.lang.String r6 = m34098h(r41)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r11 = com.inmobi.ads.C10451bf.m34210c(r6)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r6 = "URL"
            boolean r6 = r6.equals(r11)     // Catch:{ JSONException -> 0x082b }
            if (r6 == 0) goto L_0x0422
            boolean r6 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ JSONException -> 0x082b }
            if (r6 != 0) goto L_0x0422
            return r21
        L_0x0422:
            r15 = r1
            r1 = r40
            r12 = 0
            r6 = r9
            com.inmobi.ads.al r4 = r1.m34069a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x082b }
            com.inmobi.ads.bf r9 = new com.inmobi.ads.bf     // Catch:{ JSONException -> 0x082b }
            java.lang.String r1 = "isScrollable"
            boolean r6 = r7.optBoolean(r1)     // Catch:{ JSONException -> 0x082b }
            r1 = r9
            r2 = r23
            r3 = r10
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x082b }
            r9.f31795z = r11     // Catch:{ JSONException -> 0x082b }
            r9.f31614g = r15     // Catch:{ JSONException -> 0x082b }
            java.lang.String r0 = "preload"
            boolean r0 = r7.optBoolean(r0, r12)     // Catch:{ JSONException -> 0x082b }
            if (r0 == 0) goto L_0x0454
            r9.f31793A = r8     // Catch:{ JSONException -> 0x082b }
            r7 = r40
            r7.f31661k = r9     // Catch:{ JSONException -> 0x05d8 }
            r1 = r9
            goto L_0x084b
        L_0x0454:
            r7 = r40
            r21 = r9
            goto L_0x082f
        L_0x045a:
            r0 = r8
            r13 = r15
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r15 = r43
            r23 = r12
            r12 = 0
            r1 = r40
            r6 = r9
            com.inmobi.ads.al r1 = r1.m34069a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x051e }
            boolean r2 = m34106p(r41)     // Catch:{ JSONException -> 0x051e }
            if (r2 == 0) goto L_0x0499
            org.json.JSONObject r2 = r13.getJSONObject(r0)     // Catch:{ JSONException -> 0x05d8 }
            boolean r2 = r2.isNull(r11)     // Catch:{ JSONException -> 0x05d8 }
            if (r2 != 0) goto L_0x048f
            org.json.JSONObject r2 = r13.getJSONObject(r0)     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r2 = r2.getString(r11)     // Catch:{ JSONException -> 0x05d8 }
            int r2 = m34086d(r2)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x0490
        L_0x048f:
            r2 = 2
        L_0x0490:
            org.json.JSONObject r0 = r13.getJSONObject(r0)     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r0 = r0.optString(r14)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x049c
        L_0x0499:
            r0 = r21
            r2 = 0
        L_0x049c:
            if (r18 == 0) goto L_0x04df
            int r3 = r18.size()     // Catch:{ JSONException -> 0x051e }
            if (r3 != 0) goto L_0x04ab
            r6 = r42
            r4 = r13
            r5 = r15
            r3 = r25
            goto L_0x04e5
        L_0x04ab:
            r6 = r42
            r3 = r25
            boolean r3 = r3.equals(r6)     // Catch:{ JSONException -> 0x05d8 }
            if (r3 == 0) goto L_0x04ca
            com.inmobi.ads.as r3 = new com.inmobi.ads.as     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r12 = m34085c(r41)     // Catch:{ JSONException -> 0x05d8 }
            r8 = r3
            r9 = r23
            r11 = r1
            r4 = r13
            r13 = r18
            r14 = r2
            r5 = r15
            r15 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x050c
        L_0x04ca:
            r4 = r13
            r5 = r15
            com.inmobi.ads.aq r3 = new com.inmobi.ads.aq     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r12 = m34085c(r41)     // Catch:{ JSONException -> 0x05d8 }
            r8 = r3
            r9 = r23
            r11 = r1
            r13 = r18
            r14 = r2
            r15 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x050c
        L_0x04df:
            r6 = r42
            r4 = r13
            r5 = r15
            r3 = r25
        L_0x04e5:
            boolean r3 = r3.equals(r6)     // Catch:{ JSONException -> 0x05d8 }
            if (r3 == 0) goto L_0x04fc
            com.inmobi.ads.as r3 = new com.inmobi.ads.as     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r12 = m34085c(r41)     // Catch:{ JSONException -> 0x05d8 }
            r8 = r3
            r9 = r23
            r11 = r1
            r13 = r2
            r14 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x050c
        L_0x04fc:
            com.inmobi.ads.aq r3 = new com.inmobi.ads.aq     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r12 = m34085c(r41)     // Catch:{ JSONException -> 0x05d8 }
            r8 = r3
            r9 = r23
            r11 = r1
            r13 = r2
            r14 = r41
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x05d8 }
        L_0x050c:
            r3.f31614g = r5     // Catch:{ JSONException -> 0x05d8 }
            m34074a(r3, r4)     // Catch:{ JSONException -> 0x05d8 }
            if (r0 == 0) goto L_0x051a
            r3.mo34090b(r0)     // Catch:{ JSONException -> 0x05d8 }
            r1 = r3
            goto L_0x084b
        L_0x051a:
            r21 = r3
            goto L_0x082f
        L_0x051e:
            r0 = move-exception
            r6 = r42
            goto L_0x083d
        L_0x0523:
            r6 = r42
            r11 = r43
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r8 = 1
            r23 = r12
            r12 = 0
            r1 = r40
            r13 = r6
            r6 = r9
            com.inmobi.ads.al r0 = r1.m34069a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r1 = "startOffset"
            boolean r1 = r15.has(r1)     // Catch:{ JSONException -> 0x05d8 }
            if (r1 == 0) goto L_0x054f
            java.lang.String r1 = "startOffset"
            org.json.JSONObject r1 = r15.getJSONObject(r1)     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.ba$a r1 = r7.m34107q(r1)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x0551
        L_0x054f:
            r1 = r21
        L_0x0551:
            java.lang.String r2 = "timerDuration"
            boolean r2 = r15.has(r2)     // Catch:{ JSONException -> 0x05d8 }
            if (r2 == 0) goto L_0x0565
            java.lang.String r2 = "timerDuration"
            org.json.JSONObject r2 = r15.getJSONObject(r2)     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.ba$a r2 = r7.m34107q(r2)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x0567
        L_0x0565:
            r2 = r21
        L_0x0567:
            java.lang.String r3 = "displayTimer"
            boolean r3 = r15.optBoolean(r3, r8)     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.ba r4 = new com.inmobi.ads.ba     // Catch:{ JSONException -> 0x05d8 }
            r4.<init>(r1, r2)     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.bb r1 = new com.inmobi.ads.bb     // Catch:{ JSONException -> 0x05d8 }
            r14 = r23
            r1.<init>(r14, r10, r0, r4)     // Catch:{ JSONException -> 0x0622 }
            r1.f31767z = r3     // Catch:{ JSONException -> 0x0622 }
            java.lang.String r0 = "assetOnFinish"
            boolean r0 = r15.has(r0)     // Catch:{ JSONException -> 0x0622 }
            if (r0 == 0) goto L_0x05d0
            java.lang.String r0 = "assetOnFinish"
            java.lang.Object r0 = r15.get(r0)     // Catch:{ JSONException -> 0x0622 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0622 }
            java.lang.String r2 = "action"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x0622 }
            if (r2 == 0) goto L_0x05d0
            java.lang.String r2 = "action"
            java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x0622 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ JSONException -> 0x0622 }
            java.lang.String r0 = r0.toUpperCase(r2)     // Catch:{ JSONException -> 0x0622 }
            java.lang.String r0 = r0.trim()     // Catch:{ JSONException -> 0x0622 }
            int r2 = r0.hashCode()     // Catch:{ JSONException -> 0x0622 }
            r3 = 2142494(0x20b11e, float:3.002274E-39)
            if (r2 == r3) goto L_0x05be
            r3 = 2402104(0x24a738, float:3.366065E-39)
            if (r2 == r3) goto L_0x05b4
        L_0x05b3:
            goto L_0x05c8
        L_0x05b4:
            java.lang.String r2 = "NONE"
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x0622 }
            if (r0 == 0) goto L_0x05b3
            r0 = 1
            goto L_0x05c9
        L_0x05be:
            java.lang.String r2 = "EXIT"
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x0622 }
            if (r0 == 0) goto L_0x05b3
            r0 = 2
            goto L_0x05c9
        L_0x05c8:
            r0 = -1
        L_0x05c9:
            r2 = 2
            if (r0 == r2) goto L_0x05cd
            goto L_0x05ce
        L_0x05cd:
            r12 = 1
        L_0x05ce:
            r1.f31618k = r12     // Catch:{ JSONException -> 0x0622 }
        L_0x05d0:
            r1.f31614g = r11     // Catch:{ JSONException -> 0x0622 }
            r23 = r14
            goto L_0x084b
        L_0x05d8:
            r0 = move-exception
            goto L_0x083d
        L_0x05db:
            r13 = r42
            r11 = r43
            r14 = r12
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r1 = r40
            r6 = r9
            com.inmobi.ads.al r0 = r1.m34069a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0622 }
            com.inmobi.ads.ar r1 = new com.inmobi.ads.ar     // Catch:{ JSONException -> 0x0622 }
            java.lang.String r2 = m34085c(r41)     // Catch:{ JSONException -> 0x0622 }
            r1.<init>(r14, r10, r0, r2)     // Catch:{ JSONException -> 0x0622 }
            r1.f31614g = r11     // Catch:{ JSONException -> 0x0622 }
            r23 = r14
            goto L_0x084b
        L_0x0600:
            r13 = r42
            r11 = r43
            r14 = r12
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r1 = r40
            r6 = r9
            com.inmobi.ads.az$a r1 = r1.m34082b(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0622 }
            com.inmobi.ads.az r2 = new com.inmobi.ads.az     // Catch:{ JSONException -> 0x0622 }
            r2.<init>(r14, r10, r1, r0)     // Catch:{ JSONException -> 0x0622 }
            r2.f31614g = r11     // Catch:{ JSONException -> 0x0622 }
            r1 = r2
            r23 = r14
            goto L_0x084b
        L_0x0622:
            r0 = move-exception
        L_0x0623:
            r23 = r14
            goto L_0x083d
        L_0x0627:
            r6 = r42
            r1 = r43
            r0 = r8
            r28 = r19
            r26 = r20
            r27 = r23
            r39 = r24
            r16 = r25
            r17 = 1
            r8 = r44
            r23 = r12
            r12 = 0
            r7 = r1
            r1 = r40
            r6 = r9
            com.inmobi.ads.al r1 = r1.m34069a(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x065c
            boolean r2 = m34077a(r8, r1)     // Catch:{ JSONException -> 0x082b }
            if (r2 != 0) goto L_0x065c
            com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ JSONException -> 0x082b }
            java.lang.String r2 = "ads"
            java.lang.String r3 = "InvalidContainerGeometry"
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ JSONException -> 0x082b }
            r4.<init>()     // Catch:{ JSONException -> 0x082b }
            com.inmobi.commons.core.p222e.C10659b.m34987a(r2, r3, r4)     // Catch:{ JSONException -> 0x082b }
        L_0x065c:
            boolean r2 = m34106p(r41)     // Catch:{ JSONException -> 0x082b }
            if (r2 == 0) goto L_0x0686
            org.json.JSONObject r2 = r15.getJSONObject(r0)     // Catch:{ JSONException -> 0x082b }
            boolean r2 = r2.isNull(r11)     // Catch:{ JSONException -> 0x082b }
            if (r2 != 0) goto L_0x067c
            org.json.JSONObject r2 = r15.getJSONObject(r0)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r2 = r2.getString(r11)     // Catch:{ JSONException -> 0x082b }
            int r2 = m34086d(r2)     // Catch:{ JSONException -> 0x082b }
            goto L_0x067d
        L_0x067c:
            r2 = 2
        L_0x067d:
            org.json.JSONObject r0 = r15.getJSONObject(r0)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r0 = r0.optString(r14)     // Catch:{ JSONException -> 0x082b }
            goto L_0x0689
        L_0x0686:
            r0 = r21
            r2 = 0
        L_0x0689:
            java.lang.String r3 = "transitionEffect"
            boolean r3 = r9.has(r3)     // Catch:{ JSONException -> 0x082b }
            if (r3 == 0) goto L_0x06c7
            java.lang.String r3 = "transitionEffect"
            java.lang.String r3 = r9.getString(r3)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r3 = r3.trim()     // Catch:{ JSONException -> 0x082b }
            int r4 = r3.hashCode()     // Catch:{ JSONException -> 0x082b }
            r5 = 3151468(0x30166c, float:4.416147E-39)
            if (r4 == r5) goto L_0x06b5
            r5 = 106426293(0x657efb5, float:4.0613115E-35)
            if (r4 == r5) goto L_0x06ab
        L_0x06aa:
            goto L_0x06bf
        L_0x06ab:
            java.lang.String r4 = "paged"
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x082b }
            if (r3 == 0) goto L_0x06aa
            r3 = 1
            goto L_0x06c0
        L_0x06b5:
            java.lang.String r4 = "free"
            boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x082b }
            if (r3 == 0) goto L_0x06aa
            r3 = 2
            goto L_0x06c0
        L_0x06bf:
            r3 = -1
        L_0x06c0:
            r4 = 2
            if (r3 == r4) goto L_0x06c5
            r3 = 0
            goto L_0x06c6
        L_0x06c5:
            r3 = 1
        L_0x06c6:
            goto L_0x06c9
        L_0x06c7:
            r4 = 2
            r3 = 0
        L_0x06c9:
            if (r18 == 0) goto L_0x06f6
            int r5 = r18.size()     // Catch:{ JSONException -> 0x082b }
            if (r5 != 0) goto L_0x06da
            r44 = r13
            r4 = r15
            r6 = r16
            r5 = 0
            r16 = 2
            goto L_0x06fe
        L_0x06da:
            com.inmobi.ads.am r5 = new com.inmobi.ads.am     // Catch:{ JSONException -> 0x082b }
            r8 = r5
            r9 = r23
            r6 = r16
            r11 = r1
            r14 = 0
            r12 = r18
            r4 = r13
            r16 = 2
            r13 = r2
            r2 = 0
            r14 = r41
            r44 = r4
            r4 = r15
            r15 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x082b }
            r15 = r5
            r5 = 0
            goto L_0x070b
        L_0x06f6:
            r44 = r13
            r4 = r15
            r6 = r16
            r5 = 0
            r16 = 2
        L_0x06fe:
            com.inmobi.ads.am r15 = new com.inmobi.ads.am     // Catch:{ JSONException -> 0x082b }
            r8 = r15
            r9 = r23
            r11 = r1
            r12 = r2
            r13 = r41
            r14 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x082b }
        L_0x070b:
            r15.f31614g = r7     // Catch:{ JSONException -> 0x082b }
            if (r0 == 0) goto L_0x0713
            r15.mo34090b(r0)     // Catch:{ JSONException -> 0x082b }
        L_0x0713:
            m34074a(r15, r4)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r0 = "assetValue"
            org.json.JSONArray r0 = r4.getJSONArray(r0)     // Catch:{ JSONException -> 0x082b }
            r2 = 0
        L_0x071d:
            int r3 = r0.length()     // Catch:{ JSONException -> 0x082b }
            if (r2 >= r3) goto L_0x0827
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x082b }
            r3.<init>()     // Catch:{ JSONException -> 0x082b }
            r3.append(r7)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r4 = ".assetValue["
            r3.append(r4)     // Catch:{ JSONException -> 0x082b }
            r3.append(r2)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r4 = "]"
            r3.append(r4)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x082b }
            org.json.JSONObject r4 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r8 = m34093f(r4)     // Catch:{ JSONException -> 0x082b }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x082b }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ JSONException -> 0x082b }
            java.lang.String r8 = r8.trim()     // Catch:{ JSONException -> 0x082b }
            int r9 = r8.hashCode()     // Catch:{ JSONException -> 0x082b }
            switch(r9) {
                case -938102371: goto L_0x07b5;
                case -410956671: goto L_0x07ab;
                case 98832: goto L_0x07a1;
                case 102340: goto L_0x0796;
                case 3226745: goto L_0x078c;
                case 3556653: goto L_0x0782;
                case 100313435: goto L_0x0778;
                case 110364485: goto L_0x076d;
                case 112202875: goto L_0x0763;
                case 1224424441: goto L_0x0758;
                default: goto L_0x0756;
            }     // Catch:{ JSONException -> 0x082b }
        L_0x0756:
            goto L_0x07bf
        L_0x0758:
            java.lang.String r9 = "webview"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 9
            goto L_0x07c0
        L_0x0763:
            java.lang.String r9 = "video"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 4
            goto L_0x07c0
        L_0x076d:
            java.lang.String r9 = "timer"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 8
            goto L_0x07c0
        L_0x0778:
            java.lang.String r9 = "image"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 3
            goto L_0x07c0
        L_0x0782:
            java.lang.String r9 = "text"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 5
            goto L_0x07c0
        L_0x078c:
            java.lang.String r9 = "icon"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 2
            goto L_0x07c0
        L_0x0796:
            java.lang.String r9 = "gif"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 10
            goto L_0x07c0
        L_0x07a1:
            java.lang.String r9 = "cta"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 6
            goto L_0x07c0
        L_0x07ab:
            java.lang.String r9 = "container"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 1
            goto L_0x07c0
        L_0x07b5:
            java.lang.String r9 = "rating"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x082b }
            if (r8 == 0) goto L_0x0756
            r8 = 7
            goto L_0x07c0
        L_0x07bf:
            r8 = -1
        L_0x07c0:
            switch(r8) {
                case 2: goto L_0x07dd;
                case 3: goto L_0x07db;
                case 4: goto L_0x07d8;
                case 5: goto L_0x07d5;
                case 6: goto L_0x07d2;
                case 7: goto L_0x07cf;
                case 8: goto L_0x07cc;
                case 9: goto L_0x07c9;
                case 10: goto L_0x07c6;
                default: goto L_0x07c3;
            }     // Catch:{ JSONException -> 0x082b }
        L_0x07c3:
            java.lang.String r13 = "CONTAINER"
            goto L_0x07df
        L_0x07c6:
            java.lang.String r13 = "GIF"
            goto L_0x07df
        L_0x07c9:
            java.lang.String r13 = "WEBVIEW"
            goto L_0x07df
        L_0x07cc:
            java.lang.String r13 = "TIMER"
            goto L_0x07df
        L_0x07cf:
            java.lang.String r13 = "RATING"
            goto L_0x07df
        L_0x07d2:
            java.lang.String r13 = "CTA"
            goto L_0x07df
        L_0x07d5:
            java.lang.String r13 = "TEXT"
            goto L_0x07df
        L_0x07d8:
            r13 = r44
            goto L_0x07df
        L_0x07db:
            r13 = r6
            goto L_0x07df
        L_0x07dd:
            java.lang.String r13 = "ICON"
        L_0x07df:
            r7 = r40
            com.inmobi.ads.ak r8 = r7.m34068a(r4, r13, r3, r1)     // Catch:{ JSONException -> 0x05d8 }
            if (r8 != 0) goto L_0x07f3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x05d8 }
            java.lang.String r8 = "Cannot build asset from JSON: "
            r3.<init>(r8)     // Catch:{ JSONException -> 0x05d8 }
            r3.append(r4)     // Catch:{ JSONException -> 0x05d8 }
            goto L_0x0821
        L_0x07f3:
            r8.f31614g = r3     // Catch:{ JSONException -> 0x05d8 }
            r8.f31627t = r15     // Catch:{ JSONException -> 0x05d8 }
            int r3 = r15.f31646C     // Catch:{ JSONException -> 0x05d8 }
            r4 = 16
            if (r3 >= r4) goto L_0x0821
            int r3 = r15.f31646C     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.ak[] r4 = r15.f31645B     // Catch:{ JSONException -> 0x05d8 }
            int r4 = r4.length     // Catch:{ JSONException -> 0x05d8 }
            if (r3 != r4) goto L_0x0817
            com.inmobi.ads.ak[] r3 = r15.f31645B     // Catch:{ JSONException -> 0x05d8 }
            int r3 = r3.length     // Catch:{ JSONException -> 0x05d8 }
            int r3 = r3 * 2
            com.inmobi.ads.ak[] r3 = new com.inmobi.ads.C10400ak[r3]     // Catch:{ JSONException -> 0x05d8 }
            com.inmobi.ads.ak[] r4 = r15.f31645B     // Catch:{ JSONException -> 0x05d8 }
            int r9 = r15.f31646C     // Catch:{ JSONException -> 0x05d8 }
            java.lang.System.arraycopy(r4, r5, r3, r5, r9)     // Catch:{ JSONException -> 0x05d8 }
            r15.f31645B = r3     // Catch:{ JSONException -> 0x05d8 }
        L_0x0817:
            com.inmobi.ads.ak[] r3 = r15.f31645B     // Catch:{ JSONException -> 0x05d8 }
            int r4 = r15.f31646C     // Catch:{ JSONException -> 0x05d8 }
            int r9 = r4 + 1
            r15.f31646C = r9     // Catch:{ JSONException -> 0x05d8 }
            r3[r4] = r8     // Catch:{ JSONException -> 0x05d8 }
        L_0x0821:
            int r2 = r2 + 1
            r7 = r43
            goto L_0x071d
        L_0x0827:
            r7 = r40
            r1 = r15
            goto L_0x084b
        L_0x082b:
            r0 = move-exception
            r7 = r40
            goto L_0x083d
        L_0x082f:
            r1 = r21
            goto L_0x084b
        L_0x0832:
            r0 = move-exception
            r39 = r11
            r28 = r19
            r26 = r20
            r27 = r23
        L_0x083b:
            r23 = r12
        L_0x083d:
            com.inmobi.commons.core.a.a r1 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r2 = new com.inmobi.commons.core.e.a
            r2.<init>(r0)
            r1.mo34423a(r2)
            r1 = r21
        L_0x084b:
            if (r1 == 0) goto L_0x08a9
            r2 = r39
            r1.f31621n = r2
            r2 = r28
            r1.f31622o = r2
            r2 = r27
            r1.f31623p = r2
            r2 = r26
            r1.f31624q = r2
            if (r2 == 0) goto L_0x0871
            int r0 = r2.length()
            if (r0 == 0) goto L_0x0871
            java.util.Map<java.lang.String, java.lang.String> r0 = r7.f31665p
            r3 = r23
            r0.put(r3, r2)
            goto L_0x0873
        L_0x0871:
            r3 = r23
        L_0x0873:
            int r0 = r3.length()
            if (r0 == 0) goto L_0x0886
            java.util.Map<java.lang.String, com.inmobi.ads.ak> r0 = r7.f31664o
            boolean r0 = r0.containsKey(r3)
            if (r0 != 0) goto L_0x0886
            java.util.Map<java.lang.String, com.inmobi.ads.ak> r0 = r7.f31664o
            r0.put(r3, r1)
        L_0x0886:
            java.util.Map<java.lang.String, java.util.List<com.inmobi.ads.ak>> r0 = r7.f31658h
            r2 = r42
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x089c
            java.util.Map<java.lang.String, java.util.List<com.inmobi.ads.ak>> r0 = r7.f31658h
            java.lang.Object r0 = r0.get(r2)
            java.util.List r0 = (java.util.List) r0
            r0.add(r1)
            goto L_0x08a9
        L_0x089c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r1)
            java.util.Map<java.lang.String, java.util.List<com.inmobi.ads.ak>> r3 = r7.f31658h
            r3.put(r2, r0)
        L_0x08a9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34068a(org.json.JSONObject, java.lang.String, java.lang.String, com.inmobi.ads.al):com.inmobi.ads.ak");
    }

    /* renamed from: a */
    private static boolean m34077a(C10401al alVar, C10401al alVar2) {
        Point point = alVar.f31633a;
        int i = point.x;
        Point point2 = alVar.f31635c;
        int i2 = i + point2.x;
        Point point3 = alVar2.f31633a;
        int i3 = point3.x;
        Point point4 = alVar2.f31635c;
        if (i2 >= i3 + point4.x && point.y + point2.y >= point3.y + point4.y) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m34074a(C10400ak akVar, JSONObject jSONObject) throws JSONException {
        String str;
        boolean z;
        boolean z2 = true;
        String str2 = "";
        if (m34106p(jSONObject)) {
            String str3 = "assetOnclick";
            String str4 = "itemUrl";
            if (jSONObject.getJSONObject(str3).isNull(str4)) {
                new StringBuilder("Missing itemUrl on asset ").append(jSONObject.toString());
                str = str2;
                z = false;
            } else {
                str = jSONObject.getJSONObject(str3).getString(str4);
                z = true;
            }
            String str5 = "action";
            if (!jSONObject.getJSONObject(str3).isNull(str5)) {
                str2 = jSONObject.getJSONObject(str3).getString(str5);
            } else {
                z2 = z;
            }
        } else {
            str = str2;
            z2 = false;
        }
        akVar.mo34087a(str);
        akVar.f31617j = str2;
        akVar.f31615h = z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final C10400ak mo34106b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (this.f31664o.get(str) != null) {
            return (C10400ak) this.f31664o.get(str);
        }
        C10406ao aoVar = this.f31656f;
        if (aoVar != null) {
            return (C10400ak) aoVar.f31664o.get(str);
        }
        return null;
    }

    /* renamed from: c */
    public final List<C10400ak> mo34107c(String str) {
        if (this.f31658h.containsKey(str)) {
            return (List) this.f31658h.get(str);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m34080a(org.json.JSONObject r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "text"
            java.lang.String r1 = "geometry"
            boolean r2 = r5.isNull(r1)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            org.json.JSONArray r1 = r5.getJSONArray(r1)     // Catch:{ JSONException -> 0x00aa }
            boolean r1 = m34079a(r1)     // Catch:{ JSONException -> 0x00aa }
            if (r1 != 0) goto L_0x0017
            return r3
        L_0x0017:
            r1 = -1
            int r2 = r6.hashCode()     // Catch:{ JSONException -> 0x00aa }
            r4 = 1
            switch(r2) {
                case -1919329183: goto L_0x0073;
                case 67056: goto L_0x0068;
                case 70564: goto L_0x005e;
                case 2241657: goto L_0x0054;
                case 2571565: goto L_0x0049;
                case 69775675: goto L_0x003f;
                case 79826725: goto L_0x0035;
                case 81665115: goto L_0x002b;
                case 1942407129: goto L_0x0021;
                default: goto L_0x0020;
            }     // Catch:{ JSONException -> 0x00aa }
        L_0x0020:
            goto L_0x007c
        L_0x0021:
            java.lang.String r2 = "WEBVIEW"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 6
            goto L_0x007c
        L_0x002b:
            java.lang.String r2 = "VIDEO"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 4
            goto L_0x007c
        L_0x0035:
            java.lang.String r2 = "TIMER"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 5
            goto L_0x007c
        L_0x003f:
            java.lang.String r2 = "IMAGE"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 3
            goto L_0x007c
        L_0x0049:
            java.lang.String r2 = "TEXT"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 8
            goto L_0x007c
        L_0x0054:
            java.lang.String r2 = "ICON"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 2
            goto L_0x007c
        L_0x005e:
            java.lang.String r2 = "GIF"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 7
            goto L_0x007c
        L_0x0068:
            java.lang.String r2 = "CTA"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 9
            goto L_0x007c
        L_0x0073:
            java.lang.String r2 = "CONTAINER"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0020
            r1 = 1
        L_0x007c:
            switch(r1) {
                case 1: goto L_0x00a9;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a9;
                case 4: goto L_0x00a9;
                case 5: goto L_0x00a9;
                case 6: goto L_0x00a9;
                case 7: goto L_0x00a9;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                default: goto L_0x007f;
            }     // Catch:{ JSONException -> 0x00aa }
        L_0x007f:
            return r3
        L_0x0080:
            boolean r6 = r5.isNull(r0)     // Catch:{ JSONException -> 0x00aa }
            if (r6 == 0) goto L_0x0087
            return r3
        L_0x0087:
            org.json.JSONObject r5 = r5.getJSONObject(r0)     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r6 = "size"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ NumberFormatException -> 0x009b }
            double r5 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException -> 0x009b }
            int r5 = (int) r5
            if (r5 <= 0) goto L_0x009a
            return r4
        L_0x009a:
            return r3
        L_0x009b:
            r5 = move-exception
            com.inmobi.commons.core.a.a r6 = com.inmobi.commons.core.p218a.C10621a.m34854a()     // Catch:{ JSONException -> 0x00aa }
            com.inmobi.commons.core.e.a r0 = new com.inmobi.commons.core.e.a     // Catch:{ JSONException -> 0x00aa }
            r0.<init>(r5)     // Catch:{ JSONException -> 0x00aa }
            r6.mo34423a(r0)     // Catch:{ JSONException -> 0x00aa }
            return r3
        L_0x00a9:
            return r4
        L_0x00aa:
            r5 = move-exception
            com.inmobi.commons.core.a.a r6 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r0 = new com.inmobi.commons.core.e.a
            r0.<init>(r5)
            r6.mo34423a(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34080a(org.json.JSONObject, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m34079a(JSONArray jSONArray) {
        try {
            int i = jSONArray.getInt(2);
            int i2 = jSONArray.getInt(3);
            if (i <= 0 || i2 <= 0) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (android.webkit.URLUtil.isValidUrl(r1) == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r1.startsWith(r5) == false) goto L_0x003f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.inmobi.ads.NativeTracker m34066a(int r8, com.inmobi.ads.NativeTracker.TrackerEventType r9, org.json.JSONObject r10) throws org.json.JSONException {
        /*
            java.lang.String r0 = "params"
            java.lang.String r1 = "url"
            boolean r2 = r10.isNull(r1)
            if (r2 == 0) goto L_0x000d
            java.lang.String r1 = ""
            goto L_0x0015
        L_0x000d:
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r1 = r1.trim()
        L_0x0015:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.inmobi.ads.NativeTracker$TrackerEventType r3 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_VIDEO_RENDER
            r4 = 0
            if (r3 != r9) goto L_0x0071
            java.lang.String r3 = "events"
            org.json.JSONArray r3 = r10.optJSONArray(r3)
            int r5 = r1.length()
            if (r5 == 0) goto L_0x003f
            java.lang.String r5 = "http"
            boolean r6 = r1.startsWith(r5)
            if (r6 == 0) goto L_0x0039
            boolean r6 = android.webkit.URLUtil.isValidUrl(r1)
            if (r6 == 0) goto L_0x003f
        L_0x0039:
            boolean r5 = r1.startsWith(r5)
            if (r5 != 0) goto L_0x0042
        L_0x003f:
            if (r3 != 0) goto L_0x0042
            return r4
        L_0x0042:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r3 == 0) goto L_0x006b
            r5 = 0
        L_0x004a:
            int r6 = r3.length()
            if (r5 >= r6) goto L_0x006b
            java.lang.String r6 = r3.getString(r5)
            com.inmobi.ads.NativeTracker$TrackerEventType r6 = com.inmobi.ads.NativeTracker.m33702a(r6)
            com.inmobi.ads.NativeTracker$TrackerEventType r7 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_CREATIVE_VIEW
            if (r6 == r7) goto L_0x0065
            com.inmobi.ads.NativeTracker$TrackerEventType r7 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_PLAY
            if (r6 == r7) goto L_0x0065
            com.inmobi.ads.NativeTracker$TrackerEventType r7 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_RENDER
            if (r6 != r7) goto L_0x0068
        L_0x0065:
            r4.add(r6)
        L_0x0068:
            int r5 = r5 + 1
            goto L_0x004a
        L_0x006b:
            java.lang.String r3 = "referencedEvents"
            r2.put(r3, r4)
            goto L_0x007e
        L_0x0071:
            int r3 = r1.length()
            if (r3 == 0) goto L_0x00c1
            boolean r3 = android.webkit.URLUtil.isValidUrl(r1)
            if (r3 != 0) goto L_0x007e
            goto L_0x00c1
        L_0x007e:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            boolean r4 = r10.isNull(r0)     // Catch:{ JSONException -> 0x00a6 }
            if (r4 != 0) goto L_0x00a5
            org.json.JSONObject r10 = r10.getJSONObject(r0)     // Catch:{ JSONException -> 0x00a6 }
            java.util.Iterator r0 = r10.keys()     // Catch:{ JSONException -> 0x00a6 }
        L_0x0091:
            boolean r4 = r0.hasNext()     // Catch:{ JSONException -> 0x00a6 }
            if (r4 == 0) goto L_0x00a5
            java.lang.Object r4 = r0.next()     // Catch:{ JSONException -> 0x00a6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00a6 }
            java.lang.String r5 = r10.getString(r4)     // Catch:{ JSONException -> 0x00a6 }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x00a6 }
            goto L_0x0091
        L_0x00a5:
            goto L_0x00b3
        L_0x00a6:
            r10 = move-exception
            com.inmobi.commons.core.a.a r0 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r4 = new com.inmobi.commons.core.e.a
            r4.<init>(r10)
            r0.mo34423a(r4)
        L_0x00b3:
            com.inmobi.ads.NativeTracker r10 = new com.inmobi.ads.NativeTracker
            r10.<init>(r1, r8, r9, r3)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>(r2)
            r10.f31380d = r8
            return r10
        L_0x00c1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34066a(int, com.inmobi.ads.NativeTracker$TrackerEventType, org.json.JSONObject):com.inmobi.ads.NativeTracker");
    }

    /* renamed from: a */
    private static List<NativeTracker> m34073a(JSONObject jSONObject) {
        String str = Constants.VIDEO_TRACKING_URLS_KEY;
        String str2 = "macros";
        LinkedList linkedList = new LinkedList();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("passThroughJson");
            HashMap hashMap = new HashMap();
            if (!jSONObject2.isNull(str2)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str2);
                Iterator keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject3.getString(str3));
                }
            }
            if (!jSONObject2.isNull(str)) {
                JSONArray jSONArray = jSONObject2.getJSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    linkedList.add(new NativeTracker(jSONArray.getString(i), 0, TrackerEventType.TRACKER_EVENT_TYPE_IAS, hashMap));
                }
            }
            if (linkedList.isEmpty()) {
                linkedList.add(new NativeTracker("", 0, TrackerEventType.TRACKER_EVENT_TYPE_IAS, hashMap));
            }
        } catch (Exception e) {
            new StringBuilder("Failed to parse IAS tracker : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x018b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008c A[Catch:{ JSONException -> 0x0191 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.inmobi.ads.NativeTracker> m34083b(org.json.JSONObject r16) {
        /*
            r0 = r16
            java.lang.String r1 = "uiEvent"
            java.lang.String r2 = "trackerType"
            java.lang.String r3 = "trackers"
            boolean r4 = r0.isNull(r3)
            if (r4 == 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            org.json.JSONArray r0 = r0.getJSONArray(r3)     // Catch:{ JSONException -> 0x0191 }
            int r3 = r0.length()     // Catch:{ JSONException -> 0x0191 }
            if (r3 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r5 = 0
            r6 = 0
        L_0x0022:
            if (r6 >= r3) goto L_0x0190
            org.json.JSONObject r7 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x0191 }
            boolean r8 = r7.isNull(r2)     // Catch:{ JSONException -> 0x0191 }
            if (r8 != 0) goto L_0x018b
            java.lang.String r8 = r7.getString(r2)     // Catch:{ JSONException -> 0x0191 }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ JSONException -> 0x0191 }
            java.lang.String r8 = r8.toUpperCase(r9)     // Catch:{ JSONException -> 0x0191 }
            java.lang.String r8 = r8.trim()     // Catch:{ JSONException -> 0x0191 }
            int r9 = r8.hashCode()     // Catch:{ JSONException -> 0x0191 }
            r10 = -1430070305(0xffffffffaac2dbdf, float:-3.461389E-13)
            r11 = -1
            r12 = 3
            r13 = 2
            r14 = 1
            if (r9 == r10) goto L_0x0068
            r10 = -158113182(0xfffffffff6936262, float:-1.4946545E33)
            if (r9 == r10) goto L_0x005e
            r10 = 1110926088(0x42376308, float:45.84671)
            if (r9 == r10) goto L_0x0054
        L_0x0053:
            goto L_0x0072
        L_0x0054:
            java.lang.String r9 = "URL_WEBVIEW_PING"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x0191 }
            if (r8 == 0) goto L_0x0053
            r8 = 2
            goto L_0x0073
        L_0x005e:
            java.lang.String r9 = "URL_PING"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x0191 }
            if (r8 == 0) goto L_0x0053
            r8 = 1
            goto L_0x0073
        L_0x0068:
            java.lang.String r9 = "HTML_SCRIPT"
            boolean r8 = r8.equals(r9)     // Catch:{ JSONException -> 0x0191 }
            if (r8 == 0) goto L_0x0053
            r8 = 3
            goto L_0x0073
        L_0x0072:
            r8 = -1
        L_0x0073:
            java.lang.String r9 = "url_ping"
            if (r8 == r14) goto L_0x0084
            if (r8 == r13) goto L_0x0081
            if (r8 == r12) goto L_0x007e
            java.lang.String r8 = "unknown"
            goto L_0x0085
        L_0x007e:
            java.lang.String r8 = "html_script"
            goto L_0x0085
        L_0x0081:
            java.lang.String r8 = "webview_ping"
            goto L_0x0085
        L_0x0084:
            r8 = r9
        L_0x0085:
            boolean r8 = r9.equals(r8)     // Catch:{ JSONException -> 0x0191 }
            if (r8 == 0) goto L_0x018b
            java.lang.String r8 = "eventId"
            int r8 = r7.optInt(r8, r5)     // Catch:{ JSONException -> 0x0191 }
            boolean r9 = r7.isNull(r1)     // Catch:{ JSONException -> 0x0191 }
            if (r9 != 0) goto L_0x018b
            java.lang.String r9 = r7.getString(r1)     // Catch:{ JSONException -> 0x0191 }
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ JSONException -> 0x0191 }
            java.lang.String r10 = r9.toUpperCase(r10)     // Catch:{ JSONException -> 0x0191 }
            java.lang.String r10 = r10.trim()     // Catch:{ JSONException -> 0x0191 }
            int r15 = r10.hashCode()     // Catch:{ JSONException -> 0x0191 }
            r5 = 4
            switch(r15) {
                case -1881262698: goto L_0x00f7;
                case -825499301: goto L_0x00ec;
                case -45894975: goto L_0x00e2;
                case 2342118: goto L_0x00d8;
                case 2634405: goto L_0x00ce;
                case 64212328: goto L_0x00c4;
                case 1963885793: goto L_0x00ba;
                case 2008409463: goto L_0x00b0;
                default: goto L_0x00af;
            }     // Catch:{ JSONException -> 0x0191 }
        L_0x00af:
            goto L_0x0101
        L_0x00b0:
            java.lang.String r15 = "CLIENT_FILL"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 2
            goto L_0x0102
        L_0x00ba:
            java.lang.String r15 = "VIDEO_VIEWABILITY"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 6
            goto L_0x0102
        L_0x00c4:
            java.lang.String r15 = "CLICK"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 5
            goto L_0x0102
        L_0x00ce:
            java.lang.String r15 = "VIEW"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 4
            goto L_0x0102
        L_0x00d8:
            java.lang.String r15 = "LOAD"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 1
            goto L_0x0102
        L_0x00e2:
            java.lang.String r15 = "IAS_VIEWABILITY"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 7
            goto L_0x0102
        L_0x00ec:
            java.lang.String r15 = "FALLBACK_URL_CLICK"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 8
            goto L_0x0102
        L_0x00f7:
            java.lang.String r15 = "RENDER"
            boolean r10 = r10.equals(r15)     // Catch:{ JSONException -> 0x0191 }
            if (r10 == 0) goto L_0x00af
            r10 = 3
            goto L_0x0102
        L_0x0101:
            r10 = -1
        L_0x0102:
            switch(r10) {
                case 1: goto L_0x0121;
                case 2: goto L_0x011e;
                case 3: goto L_0x011b;
                case 4: goto L_0x0118;
                case 5: goto L_0x0115;
                case 6: goto L_0x0111;
                case 7: goto L_0x010d;
                case 8: goto L_0x0109;
                default: goto L_0x0105;
            }     // Catch:{ JSONException -> 0x0191 }
        L_0x0105:
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0124
        L_0x0109:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_FALLBACK_URL     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x010d:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_IAS     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0111:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_VIDEO_RENDER     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0115:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_CLICK     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0118:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_PAGE_VIEW     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x011b:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_RENDER     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x011e:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_CLIENT_FILL     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0121:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_LOAD     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0124:
            java.lang.String r9 = r9.toUpperCase(r10)     // Catch:{ JSONException -> 0x0191 }
            java.lang.String r9 = r9.trim()     // Catch:{ JSONException -> 0x0191 }
            int r10 = r9.hashCode()     // Catch:{ JSONException -> 0x0191 }
            switch(r10) {
                case -1836567951: goto L_0x0152;
                case -1099027408: goto L_0x0148;
                case 1331888222: goto L_0x013e;
                case 1346121898: goto L_0x0134;
                default: goto L_0x0133;
            }     // Catch:{ JSONException -> 0x0191 }
        L_0x0133:
            goto L_0x015b
        L_0x0134:
            java.lang.String r10 = "DOWNLOADER_INITIALIZED"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0191 }
            if (r9 == 0) goto L_0x0133
            r11 = 1
            goto L_0x015b
        L_0x013e:
            java.lang.String r10 = "DOWNLOADER_ERROR"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0191 }
            if (r9 == 0) goto L_0x0133
            r11 = 4
            goto L_0x015b
        L_0x0148:
            java.lang.String r10 = "DOWNLOADER_DOWNLOADING"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0191 }
            if (r9 == 0) goto L_0x0133
            r11 = 2
            goto L_0x015b
        L_0x0152:
            java.lang.String r10 = "DOWNLOADER_DOWNLOADED"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0191 }
            if (r9 == 0) goto L_0x0133
            r11 = 3
        L_0x015b:
            if (r11 == r14) goto L_0x016f
            if (r11 == r13) goto L_0x016c
            if (r11 == r12) goto L_0x0169
            if (r11 == r5) goto L_0x0166
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_UNKNOWN     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0166:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_DOWNLOADER_ERROR     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x0169:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x016c:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING     // Catch:{ JSONException -> 0x0191 }
            goto L_0x0171
        L_0x016f:
            com.inmobi.ads.NativeTracker$TrackerEventType r5 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_DOWNLOADER_INIT     // Catch:{ JSONException -> 0x0191 }
        L_0x0171:
            com.inmobi.ads.NativeTracker$TrackerEventType r9 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_UNKNOWN     // Catch:{ JSONException -> 0x0191 }
            if (r9 == r5) goto L_0x018b
            com.inmobi.ads.NativeTracker$TrackerEventType r9 = com.inmobi.ads.NativeTracker.TrackerEventType.TRACKER_EVENT_TYPE_IAS     // Catch:{ JSONException -> 0x0191 }
            if (r9 == r5) goto L_0x0184
            com.inmobi.ads.NativeTracker r5 = m34066a(r8, r5, r7)     // Catch:{ JSONException -> 0x0191 }
            if (r5 == 0) goto L_0x0183
            r4.add(r5)     // Catch:{ JSONException -> 0x0191 }
        L_0x0183:
            goto L_0x018b
        L_0x0184:
            java.util.List r5 = m34073a(r7)     // Catch:{ JSONException -> 0x0191 }
            r4.addAll(r5)     // Catch:{ JSONException -> 0x0191 }
        L_0x018b:
            int r6 = r6 + 1
            r5 = 0
            goto L_0x0022
        L_0x0190:
            return r4
        L_0x0191:
            r0 = move-exception
            com.inmobi.commons.core.a.a r1 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r2 = new com.inmobi.commons.core.e.a
            r2.<init>(r0)
            r1.mo34423a(r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34083b(org.json.JSONObject):java.util.List");
    }

    /* renamed from: a */
    private C10476by m34071a(JSONObject jSONObject, String str, C10400ak akVar) {
        if (m34093f(jSONObject).equalsIgnoreCase("VIDEO")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        if (akVar == null || !(akVar instanceof C10449be)) {
                            return new C10470bu(this.f31667r.f31901m).mo34190a(str);
                        }
                        return (C10476by) akVar.f31612e;
                    }
                }
                return null;
            } catch (JSONException e) {
                C10621a.m34854a().mo34423a(new C10658a(e));
            }
        }
        return null;
    }

    /* renamed from: c */
    private static String m34085c(JSONObject jSONObject) {
        String str = "assetValue";
        try {
            if ((m34093f(jSONObject).equalsIgnoreCase("ICON") || m34093f(jSONObject).equalsIgnoreCase("IMAGE") || m34093f(jSONObject).equalsIgnoreCase("GIF")) && jSONObject.getJSONArray(str).getString(0).length() != 0) {
                return jSONObject.getJSONArray(str).getString(0);
            }
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
        return "";
    }

    /* renamed from: d */
    private static String m34087d(JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetId");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return Integer.toString(jSONObject.hashCode());
        }
    }

    /* renamed from: e */
    private static String m34090e(JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetName");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }

    /* renamed from: f */
    private static String m34093f(JSONObject jSONObject) {
        try {
            return jSONObject.getString("assetType");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }

    /* renamed from: g */
    private static String m34096g(JSONObject jSONObject) {
        try {
            return jSONObject.getString("valueType");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }

    /* renamed from: h */
    private static String m34098h(JSONObject jSONObject) {
        try {
            return jSONObject.getString("dataType");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return "";
        }
    }

    /* renamed from: i */
    private JSONObject m34099i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str = "assetStyleRef";
        String str2 = "assetStyle";
        try {
            if (jSONObject.isNull(str2)) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONObject.getJSONObject(str2);
            }
            if (jSONObject2 == null) {
                if (jSONObject.isNull(str)) {
                    return new JSONObject();
                }
                String string = jSONObject.getString(str);
                if (this.f31663n == null) {
                    jSONObject2 = new JSONObject();
                } else {
                    jSONObject2 = this.f31663n.getJSONObject(string);
                }
            }
            return jSONObject2;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return new JSONObject();
        }
    }

    /* renamed from: j */
    private Point m34100j(JSONObject jSONObject) {
        String str = "geometry";
        Point point = new Point();
        try {
            JSONObject i = m34099i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            JSONArray jSONArray = i.getJSONArray(str);
            point.x = C10692c.m35103a(jSONArray.getInt(0));
            point.y = C10692c.m35103a(jSONArray.getInt(1));
            return point;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* renamed from: a */
    private Point m34065a(JSONObject jSONObject, Point point) {
        String str = "finalGeometry";
        try {
            JSONObject i = m34099i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            Point point2 = new Point();
            JSONArray jSONArray = i.getJSONArray(str);
            point2.x = C10692c.m35103a(jSONArray.getInt(0));
            point2.y = C10692c.m35103a(jSONArray.getInt(1));
            point = point2;
            return point;
        } catch (JSONException e) {
        }
    }

    /* renamed from: k */
    private Point m34101k(JSONObject jSONObject) {
        String str = "geometry";
        Point point = new Point();
        try {
            JSONObject i = m34099i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            JSONArray jSONArray = i.getJSONArray(str);
            point.x = C10692c.m35103a(jSONArray.getInt(2));
            point.y = C10692c.m35103a(jSONArray.getInt(3));
            return point;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }

    /* renamed from: b */
    private Point m34081b(JSONObject jSONObject, Point point) {
        String str = "finalGeometry";
        try {
            JSONObject i = m34099i(jSONObject);
            if (i.isNull(str)) {
                return point;
            }
            Point point2 = new Point();
            JSONArray jSONArray = i.getJSONArray(str);
            point2.x = C10692c.m35103a(jSONArray.getInt(2));
            point2.y = C10692c.m35103a(jSONArray.getInt(3));
            point = point2;
            return point;
        } catch (JSONException e) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057 A[RETURN] */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m34102l(org.json.JSONObject r6) {
        /*
            java.lang.String r0 = "type"
            r1 = 2
            org.json.JSONObject r6 = m34104n(r6)     // Catch:{ JSONException -> 0x0058 }
            boolean r2 = r6.isNull(r0)     // Catch:{ JSONException -> 0x0058 }
            if (r2 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r6 = r6.getString(r0)     // Catch:{ JSONException -> 0x0058 }
            java.lang.String r6 = r6.trim()     // Catch:{ JSONException -> 0x0058 }
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ JSONException -> 0x0058 }
            java.lang.String r6 = r6.toLowerCase(r0)     // Catch:{ JSONException -> 0x0058 }
            r0 = -1
            int r2 = r6.hashCode()     // Catch:{ JSONException -> 0x0058 }
            r3 = -921832806(0xffffffffc90df29a, float:-581417.6)
            r4 = 1
            r5 = 3
            if (r2 == r3) goto L_0x0047
            r3 = -284840886(0xffffffffef05ac4a, float:-4.136979E28)
            if (r2 == r3) goto L_0x003d
            r3 = 1728122231(0x67010d77, float:6.0943366E23)
            if (r2 == r3) goto L_0x0033
        L_0x0032:
            goto L_0x0050
        L_0x0033:
            java.lang.String r2 = "absolute"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0058 }
            if (r6 == 0) goto L_0x0032
            r0 = 2
            goto L_0x0050
        L_0x003d:
            java.lang.String r2 = "unknown"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0058 }
            if (r6 == 0) goto L_0x0032
            r0 = 1
            goto L_0x0050
        L_0x0047:
            java.lang.String r2 = "percentage"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0058 }
            if (r6 == 0) goto L_0x0032
            r0 = 3
        L_0x0050:
            if (r0 == r1) goto L_0x0057
            if (r0 == r5) goto L_0x0055
            return r4
        L_0x0055:
            r6 = 4
            return r6
        L_0x0057:
            return r5
        L_0x0058:
            r6 = move-exception
            com.inmobi.commons.core.a.a r0 = com.inmobi.commons.core.p218a.C10621a.m34854a()
            com.inmobi.commons.core.e.a r2 = new com.inmobi.commons.core.e.a
            r2.<init>(r6)
            r0.mo34423a(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34102l(org.json.JSONObject):int");
    }

    /* renamed from: a */
    private static int m34064a(JSONObject jSONObject, boolean z) {
        try {
            JSONObject n = m34104n(jSONObject);
            String str = "delay";
            String str2 = "hideAfterDelay";
            if (n.isNull(z ? str : str2)) {
                return -1;
            }
            if (!z) {
                str = str2;
            }
            int i = n.getInt(str);
            if (3 == m34102l(jSONObject)) {
                return i;
            }
            if (4 != m34102l(jSONObject) || i <= 0 || i > 100) {
                return -1;
            }
            int[] iArr = {25, 50, 75, 100};
            double d = Double.MAX_VALUE;
            int i2 = -1;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = i - iArr[i3];
                double d2 = (double) (i4 * i4);
                if (d2 < d) {
                    i2 = i3;
                    d = d2;
                }
            }
            return iArr[i2];
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return -1;
        }
    }

    /* renamed from: m */
    private static String m34103m(JSONObject jSONObject) {
        String str = "";
        String str2 = "reference";
        try {
            JSONObject n = m34104n(jSONObject);
            if (n.isNull(str2)) {
                return str;
            }
            return n.getString(str2);
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return str;
        }
    }

    /* renamed from: n */
    private static JSONObject m34104n(JSONObject jSONObject) {
        String str = "display";
        if (jSONObject.isNull(str)) {
            return new JSONObject();
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return new JSONObject();
        }
    }

    /* renamed from: o */
    private static JSONArray m34105o(JSONObject jSONObject) {
        try {
            return jSONObject.getJSONArray("assetValue");
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return new JSONArray();
        }
    }

    /* renamed from: p */
    private static boolean m34106p(JSONObject jSONObject) {
        return !jSONObject.isNull("assetOnclick");
    }

    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m34086d(java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toUpperCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r0) {
                case -2084521848: goto L_0x0034;
                case -1038134325: goto L_0x002a;
                case 69805756: goto L_0x0020;
                case 1411860198: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x003e
        L_0x0016:
            java.lang.String r0 = "DEEPLINK"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "INAPP"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 2
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "EXTERNAL"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "DOWNLOAD"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 4
            goto L_0x003f
        L_0x003e:
            r5 = -1
        L_0x003f:
            if (r5 == r4) goto L_0x0048
            if (r5 == r3) goto L_0x0047
            if (r5 == r2) goto L_0x0046
            return r4
        L_0x0046:
            return r2
        L_0x0047:
            return r3
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34086d(java.lang.String):int");
    }

    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m34089e(java.lang.String r10) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r10 = r10.toLowerCase(r0)
            java.lang.String r10 = r10.trim()
            int r0 = r10.hashCode()
            java.lang.String r1 = "none"
            java.lang.String r2 = "bold"
            java.lang.String r3 = "strike"
            java.lang.String r4 = "underline"
            java.lang.String r5 = "italic"
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 2
            switch(r0) {
                case -1178781136: goto L_0x0040;
                case -1026963764: goto L_0x0038;
                case -891985998: goto L_0x0030;
                case 3029637: goto L_0x0028;
                case 3387192: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0048
        L_0x0020:
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x001f
            r10 = 1
            goto L_0x0049
        L_0x0028:
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x001f
            r10 = 2
            goto L_0x0049
        L_0x0030:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x001f
            r10 = 4
            goto L_0x0049
        L_0x0038:
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x001f
            r10 = 5
            goto L_0x0049
        L_0x0040:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x001f
            r10 = 3
            goto L_0x0049
        L_0x0048:
            r10 = -1
        L_0x0049:
            if (r10 == r9) goto L_0x0055
            if (r10 == r8) goto L_0x0054
            if (r10 == r7) goto L_0x0053
            if (r10 == r6) goto L_0x0052
            return r1
        L_0x0052:
            return r4
        L_0x0053:
            return r3
        L_0x0054:
            return r5
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34089e(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[RETURN] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m34092f(java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = 3321844(0x32aff4, float:4.654895E-39)
            java.lang.String r2 = "none"
            java.lang.String r3 = "line"
            r4 = 2
            if (r0 == r1) goto L_0x0026
            r1 = 3387192(0x33af38, float:4.746467E-39)
            if (r0 == r1) goto L_0x001e
        L_0x001d:
            goto L_0x002e
        L_0x001e:
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x001d
            r5 = 1
            goto L_0x002f
        L_0x0026:
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x001d
            r5 = 2
            goto L_0x002f
        L_0x002e:
            r5 = -1
        L_0x002f:
            if (r5 == r4) goto L_0x0032
            return r2
        L_0x0032:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34092f(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[RETURN] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m34095g(java.lang.String r5) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r5 = r5.trim()
            int r0 = r5.hashCode()
            r1 = -1349116587(0xffffffffaf961d55, float:-2.7305683E-10)
            java.lang.String r2 = "straight"
            java.lang.String r3 = "curved"
            r4 = 2
            if (r0 == r1) goto L_0x0026
            r1 = 1787472634(0x6a8aaafa, float:8.381959E25)
            if (r0 == r1) goto L_0x001e
        L_0x001d:
            goto L_0x002e
        L_0x001e:
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x001d
            r5 = 1
            goto L_0x002f
        L_0x0026:
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x001d
            r5 = 2
            goto L_0x002f
        L_0x002e:
            r5 = -1
        L_0x002f:
            if (r5 == r4) goto L_0x0032
            return r2
        L_0x0032:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10406ao.m34095g(java.lang.String):java.lang.String");
    }

    /* renamed from: q */
    private C10442a m34107q(JSONObject jSONObject) {
        C10442a aVar = new C10442a(jSONObject.optLong("absolute"), jSONObject.optLong("percentage"), jSONObject.optString("reference"), this);
        return aVar;
    }

    /* renamed from: r */
    private C10442a m34108r(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C10442a aVar = new C10442a(jSONObject.optLong("absolute"), jSONObject.optLong("percentage"), jSONObject.optString("reference"), this);
        return aVar;
    }

    /* renamed from: a */
    private C10401al m34069a(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Point point5 = point;
        Point point6 = point2;
        Point point7 = point3;
        Point point8 = point4;
        JSONObject jSONObject2 = jSONObject;
        String str6 = "border";
        String str7 = "none";
        String str8 = "#ff000000";
        String str9 = "straight";
        if (jSONObject2.isNull(str6)) {
            str3 = str7;
            str = str8;
            str2 = str9;
        } else {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str6);
            String str10 = "style";
            if (jSONObject3.isNull(str10)) {
                str3 = str7;
                str = str8;
                str2 = str9;
            } else {
                String f = m34092f(jSONObject3.getString(str10));
                String str11 = "corner";
                if (!jSONObject3.isNull(str11)) {
                    str9 = m34095g(jSONObject3.getString(str11));
                }
                String str12 = "color";
                if (jSONObject3.isNull(str12)) {
                    str3 = f;
                    str = str8;
                    str2 = str9;
                } else {
                    str3 = f;
                    str = jSONObject3.getString(str12).trim();
                    str2 = str9;
                }
            }
        }
        String str13 = "backgroundColor";
        if (jSONObject2.isNull(str13)) {
            str4 = "#00000000";
        } else {
            str4 = jSONObject2.getString(str13).trim();
        }
        String str14 = "contentMode";
        String str15 = "fill";
        if (!jSONObject2.isNull(str14)) {
            String trim = jSONObject2.getString(str14).trim();
            char c = 65535;
            int hashCode = trim.hashCode();
            String str16 = "aspectFit";
            String str17 = BuildConfig.VERSION_NAME;
            switch (hashCode) {
                case -1626174665:
                    if (trim.equals(str17)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1362001767:
                    if (trim.equals(str16)) {
                        c = 4;
                        break;
                    }
                    break;
                case 3143043:
                    if (trim.equals(str15)) {
                        c = 2;
                        break;
                    }
                    break;
                case 727618043:
                    if (trim.equals("aspectFill")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c != 2) {
                if (c == 3) {
                    str15 = "aspectFill";
                } else if (c != 4) {
                    str15 = str17;
                } else {
                    str15 = str16;
                }
            }
            str5 = str15;
        } else {
            str5 = str15;
        }
        C10441ba s = m34109s(jSONObject2);
        C10401al alVar = new C10401al(point5.x, point5.y, point6.x, point6.y, point7.x, point7.y, point8.x, point8.y, str5, str3, str2, str, str4, s);
        return alVar;
    }

    /* renamed from: s */
    private C10441ba m34109s(JSONObject jSONObject) throws JSONException {
        C10442a aVar;
        String str = "startOffset";
        C10442a aVar2 = null;
        if (!jSONObject.isNull(str)) {
            aVar = m34108r(jSONObject.optJSONObject(str));
        } else {
            aVar = null;
        }
        String str2 = "timerDuration";
        if (!jSONObject.isNull(str2)) {
            aVar2 = m34108r(jSONObject.optJSONObject(str2));
        }
        return new C10441ba(aVar, aVar2);
    }

    /* renamed from: b */
    private C10437a m34082b(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String[] strArr;
        int i2;
        Point point5 = point;
        Point point6 = point2;
        Point point7 = point3;
        Point point8 = point4;
        JSONObject jSONObject2 = jSONObject;
        String str6 = "border";
        String str7 = "straight";
        String str8 = "color";
        String str9 = "#ff000000";
        String str10 = "none";
        String str11 = "style";
        if (jSONObject2.isNull(str6)) {
            str2 = str7;
            str = str9;
            str3 = str10;
        } else {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str6);
            if (jSONObject3.isNull(str11)) {
                str2 = str7;
                str = str9;
                str3 = str10;
            } else {
                String f = m34092f(jSONObject3.getString(str11));
                String str12 = "corner";
                if (!jSONObject3.isNull(str12)) {
                    str7 = m34095g(jSONObject3.getString(str12));
                }
                if (jSONObject3.isNull(str8)) {
                    str3 = f;
                    str2 = str7;
                    str = str9;
                } else {
                    str = jSONObject3.getString(str8).trim();
                    str3 = f;
                    str2 = str7;
                }
            }
        }
        String str13 = "backgroundColor";
        if (jSONObject2.isNull(str13)) {
            str4 = "#00000000";
        } else {
            str4 = jSONObject2.getString(str13).trim();
        }
        JSONObject jSONObject4 = jSONObject2.getJSONObject(CommandHandler.TEXT);
        try {
            int parseDouble = (int) Double.parseDouble(jSONObject4.getString("size"));
            String str14 = "length";
            if (jSONObject4.isNull(str14)) {
                i = MoPubClientPositioning.NO_REPEAT;
            } else {
                i = Integer.parseInt(jSONObject4.getString(str14));
            }
            if (jSONObject4.isNull(str8)) {
                str5 = str9;
            } else {
                str5 = jSONObject4.getString(str8).trim();
            }
            if (jSONObject4.isNull(str11)) {
                strArr = new String[]{str10};
            } else {
                int length = jSONObject4.getJSONArray(str11).length();
                if (length == 0) {
                    strArr = new String[]{str10};
                } else {
                    String[] strArr2 = new String[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        strArr2[i3] = m34089e(jSONObject4.getJSONArray(str11).getString(i3));
                    }
                    strArr = strArr2;
                }
            }
            String str15 = "align";
            if (!jSONObject4.isNull(str15)) {
                String trim = jSONObject4.getString(str15).trim();
                char c = 65535;
                int hashCode = trim.hashCode();
                int i4 = 2;
                if (hashCode != -1364013605) {
                    if (hashCode != 3317767) {
                        if (hashCode == 108511772 && trim.equals("right")) {
                            c = 2;
                        }
                    } else if (trim.equals("left")) {
                        c = 1;
                    }
                } else if (trim.equals("centre")) {
                    c = 3;
                }
                if (c == 2) {
                    i4 = 1;
                } else if (c != 3) {
                    i4 = 0;
                }
                i2 = i4;
            } else {
                i2 = 0;
            }
            C10437a aVar = new C10437a(point5.x, point5.y, point6.x, point6.y, point7.x, point7.y, point8.x, point8.y, str3, str2, str, str4, parseDouble, i2, i, str5, strArr, m34109s(jSONObject2));
            return aVar;
        } catch (NumberFormatException e) {
            JSONException jSONException = new JSONException(e.getMessage());
            jSONException.initCause(e);
            C10621a.m34854a().mo34423a(new C10658a(e));
            throw jSONException;
        }
    }

    /* renamed from: c */
    private C10437a m34084c(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String[] strArr;
        Point point5 = point;
        Point point6 = point2;
        Point point7 = point3;
        Point point8 = point4;
        JSONObject jSONObject2 = jSONObject;
        String str6 = "border";
        String str7 = "straight";
        String str8 = "color";
        String str9 = "#ff000000";
        String str10 = "none";
        String str11 = "style";
        if (jSONObject2.isNull(str6)) {
            str2 = str7;
            str = str9;
            str3 = str10;
        } else {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str6);
            if (jSONObject3.isNull(str11)) {
                str2 = str7;
                str = str9;
                str3 = str10;
            } else {
                String f = m34092f(jSONObject3.getString(str11));
                String str12 = "corner";
                if (!jSONObject3.isNull(str12)) {
                    str7 = m34095g(jSONObject3.getString(str12));
                }
                if (jSONObject3.isNull(str8)) {
                    str3 = f;
                    str2 = str7;
                    str = str9;
                } else {
                    str = jSONObject3.getString(str8).trim();
                    str3 = f;
                    str2 = str7;
                }
            }
        }
        String str13 = "backgroundColor";
        if (jSONObject2.isNull(str13)) {
            str4 = "#00000000";
        } else {
            str4 = jSONObject2.getString(str13).trim();
        }
        JSONObject jSONObject4 = jSONObject2.getJSONObject(CommandHandler.TEXT);
        try {
            int parseDouble = (int) Double.parseDouble(jSONObject4.getString("size"));
            if (jSONObject4.isNull(str8)) {
                str5 = str9;
            } else {
                str5 = jSONObject4.getString(str8).trim();
            }
            if (jSONObject4.isNull(str11)) {
                strArr = new String[]{str10};
            } else {
                int length = jSONObject4.getJSONArray(str11).length();
                if (length == 0) {
                    strArr = new String[]{str10};
                } else {
                    String[] strArr2 = new String[length];
                    for (int i = 0; i < length; i++) {
                        strArr2[i] = m34089e(jSONObject4.getJSONArray(str11).getString(i));
                    }
                    strArr = strArr2;
                }
            }
            C10405a aVar = new C10405a(point5.x, point5.y, point6.x, point6.y, point7.x, point7.y, point8.x, point8.y, str3, str2, str, str4, parseDouble, str5, strArr, m34109s(jSONObject2));
            return aVar;
        } catch (NumberFormatException e) {
            JSONException jSONException = new JSONException(e.getMessage());
            jSONException.initCause(e);
            C10621a.m34854a().mo34423a(new C10658a(e));
            throw jSONException;
        }
    }
}
