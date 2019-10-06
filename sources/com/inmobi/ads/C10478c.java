package com.inmobi.ads;

import android.graphics.Color;
import com.inmobi.commons.core.configs.C10639a;
import com.mopub.common.AdType;
import com.mopub.common.Constants;
import com.vungle.warren.model.Advertisement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.c */
/* compiled from: AdConfig */
public final class C10478c extends C10639a {

    /* renamed from: q */
    private static boolean f31882q = true;

    /* renamed from: r */
    private static boolean f31883r = false;

    /* renamed from: s */
    private static boolean f31884s = true;

    /* renamed from: t */
    private static boolean f31885t = true;

    /* renamed from: u */
    private static final String f31886u = C10478c.class.getSimpleName();

    /* renamed from: v */
    private static final Object f31887v = new Object();

    /* renamed from: A */
    private C10486h f31888A = new C10486h();

    /* renamed from: a */
    String f31889a = "https://i.w.inmobi.com/showad.asm";

    /* renamed from: b */
    public String f31890b = "https://sdktm.w.inmobi.com/sdkpubreq/v2";

    /* renamed from: c */
    public int f31891c = 20;

    /* renamed from: d */
    int f31892d = 60;

    /* renamed from: e */
    int f31893e = 60;

    /* renamed from: f */
    C10479a f31894f;

    /* renamed from: g */
    Map<String, C10479a> f31895g;

    /* renamed from: h */
    public C10483e f31896h = new C10483e();

    /* renamed from: i */
    public C10487i f31897i = new C10487i();

    /* renamed from: j */
    public C10485g f31898j = new C10485g();

    /* renamed from: k */
    public C10490l f31899k = new C10490l();

    /* renamed from: l */
    public JSONObject f31900l;

    /* renamed from: m */
    public C10489k f31901m = new C10489k();

    /* renamed from: n */
    public C10480b f31902n = new C10480b();

    /* renamed from: o */
    boolean f31903o = false;

    /* renamed from: w */
    private List<String> f31904w = new LinkedList();

    /* renamed from: x */
    private C10482d f31905x;

    /* renamed from: y */
    private Map<String, C10482d> f31906y;

    /* renamed from: z */
    private Map<String, C10486h> f31907z = new HashMap();

    /* renamed from: com.inmobi.ads.c$a */
    /* compiled from: AdConfig */
    public static final class C10479a {

        /* renamed from: a */
        public int f31908a;

        /* renamed from: b */
        public long f31909b;

        /* renamed from: c */
        public int f31910c;

        /* renamed from: d */
        public long f31911d;

        /* renamed from: e */
        public long f31912e;

        /* renamed from: f */
        public C10488j f31913f;

        /* renamed from: g */
        public C10488j f31914g;

        /* renamed from: h */
        public boolean f31915h;

        /* renamed from: a */
        public final boolean mo34206a() {
            long j = this.f31912e;
            long j2 = this.f31911d;
            if (j >= j2) {
                long j3 = this.f31909b;
                if (j > j3 || j3 < j2 || !this.f31913f.mo34209a() || !this.f31914g.mo34209a()) {
                    return false;
                }
                int i = this.f31908a;
                if (i >= 0 && i <= 3) {
                    long j4 = this.f31909b;
                    if (j4 > 0 && j4 <= 86400) {
                        int i2 = this.f31910c;
                        if (i2 > 0 && i2 <= 1000) {
                            long j5 = this.f31912e;
                            if (j5 > 0 && j5 <= 180) {
                                long j6 = this.f31911d;
                                if (j6 > 0 && j6 <= 60) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* renamed from: com.inmobi.ads.c$b */
    /* compiled from: AdConfig */
    public static final class C10480b {

        /* renamed from: a */
        public int f31916a = 3;

        /* renamed from: b */
        public int f31917b = 1;

        /* renamed from: c */
        int f31918c = 10;

        /* renamed from: d */
        public long f31919d = 104857600;

        /* renamed from: e */
        public long f31920e = 259200;
    }

    /* renamed from: com.inmobi.ads.c$c */
    /* compiled from: AdConfig */
    public static final class C10481c {

        /* renamed from: a */
        boolean f31921a = false;

        /* renamed from: b */
        int f31922b = 2000;
    }

    /* renamed from: com.inmobi.ads.c$d */
    /* compiled from: AdConfig */
    public static final class C10482d {

        /* renamed from: a */
        int f31923a = 1;

        /* renamed from: b */
        int f31924b;

        /* renamed from: c */
        int f31925c;

        /* renamed from: d */
        long f31926d;

        /* renamed from: e */
        public boolean f31927e;

        /* renamed from: a */
        public final boolean mo34207a() {
            return this.f31924b > 0 && this.f31923a >= 0 && this.f31925c >= 0 && this.f31926d >= 0;
        }
    }

    /* renamed from: com.inmobi.ads.c$e */
    /* compiled from: AdConfig */
    public static final class C10483e {

        /* renamed from: a */
        public int f31928a = 3;

        /* renamed from: b */
        public int f31929b = 60;

        /* renamed from: c */
        public int f31930c = Opcodes.ISHL;

        /* renamed from: d */
        public int f31931d = 500;

        /* renamed from: e */
        public int f31932e = 10;

        /* renamed from: f */
        public long f31933f = 10800;
    }

    /* renamed from: com.inmobi.ads.c$f */
    /* compiled from: AdConfig */
    public static final class C10484f {

        /* renamed from: a */
        boolean f31934a;

        /* renamed from: b */
        String f31935b;

        public C10484f(boolean z, String str) {
            this.f31934a = z;
            this.f31935b = str;
        }
    }

    /* renamed from: com.inmobi.ads.c$g */
    /* compiled from: AdConfig */
    public static final class C10485g {

        /* renamed from: a */
        public long f31936a = 432000;

        /* renamed from: b */
        public int f31937b = 3;

        /* renamed from: c */
        public int f31938c = 60;

        /* renamed from: d */
        public String f31939d = "https://i.l.inmobicdn.net/sdk/sdk/500/android/mraid.js";
    }

    /* renamed from: com.inmobi.ads.c$h */
    /* compiled from: AdConfig */
    public static final class C10486h {

        /* renamed from: a */
        public boolean f31940a = false;

        /* renamed from: b */
        public long f31941b = 259200;

        /* renamed from: c */
        public int f31942c = 5;

        /* renamed from: a */
        public final boolean mo34208a() {
            return this.f31941b >= 0 && this.f31942c > 0;
        }
    }

    /* renamed from: com.inmobi.ads.c$i */
    /* compiled from: AdConfig */
    public static final class C10487i {

        /* renamed from: a */
        int f31943a = 60;

        /* renamed from: b */
        int f31944b = 320;

        /* renamed from: c */
        int f31945c = 480;

        /* renamed from: d */
        int f31946d = 100;

        /* renamed from: e */
        String f31947e;

        /* renamed from: f */
        public int f31948f;

        /* renamed from: g */
        public boolean f31949g;

        /* renamed from: h */
        int f31950h;

        /* renamed from: i */
        int f31951i;

        /* renamed from: j */
        long f31952j;

        /* renamed from: k */
        ArrayList<String> f31953k;

        /* renamed from: l */
        public boolean f31954l;

        /* renamed from: m */
        public boolean f31955m;

        public C10487i() {
            String str = "#00000000";
            this.f31947e = str;
            this.f31948f = Color.parseColor(str);
            this.f31949g = true;
            this.f31950h = 5;
            this.f31951i = 20;
            this.f31952j = 5242880;
            this.f31953k = new ArrayList<>(Arrays.asList(new String[]{"video/mp4"}));
            this.f31954l = false;
            this.f31955m = false;
        }
    }

    /* renamed from: com.inmobi.ads.c$j */
    /* compiled from: AdConfig */
    public static final class C10488j {

        /* renamed from: a */
        public long f31956a;

        /* renamed from: b */
        public int f31957b;

        /* renamed from: c */
        public int f31958c;

        /* renamed from: a */
        public final boolean mo34209a() {
            long j = this.f31956a;
            if (j > 0 && j <= 60) {
                int i = this.f31957b;
                if (i > 0) {
                    int i2 = this.f31958c;
                    if (i <= i2 && i2 > 0 && i2 <= 97) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: com.inmobi.ads.c$k */
    /* compiled from: AdConfig */
    public static final class C10489k {

        /* renamed from: a */
        int f31959a = 3;

        /* renamed from: b */
        long f31960b = 3145728;

        /* renamed from: c */
        public long f31961c = 31457280;

        /* renamed from: d */
        C10481c f31962d = new C10481c();

        /* renamed from: e */
        public ArrayList<String> f31963e = new ArrayList<>(Arrays.asList(new String[]{"video/mp4", "image/jpeg", "image/jpg", "image/gif", "image/png"}));
    }

    /* renamed from: com.inmobi.ads.c$l */
    /* compiled from: AdConfig */
    public static final class C10490l {

        /* renamed from: a */
        int f31964a = 50;

        /* renamed from: b */
        int f31965b = 1000;

        /* renamed from: c */
        int f31966c = 100;

        /* renamed from: d */
        int f31967d = 250;

        /* renamed from: e */
        int f31968e = 67;

        /* renamed from: f */
        int f31969f = 50;

        /* renamed from: g */
        public int f31970g = 2000;

        /* renamed from: h */
        int f31971h = 50;

        /* renamed from: i */
        boolean f31972i = true;

        /* renamed from: j */
        boolean f31973j = true;

        /* renamed from: k */
        C10484f f31974k = new C10484f(true, "https://i.l.inmobicdn.cn/sdk/sdk/MMA/im_sdkconfig.xml");
    }

    /* renamed from: e */
    private static JSONObject m34308e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "retryInterval";
        jSONObject2.put(str, 3);
        String str2 = "minBatchSize";
        jSONObject2.put(str2, 2);
        String str3 = "maxBatchSize";
        jSONObject2.put(str3, 85);
        jSONObject.put("wifi", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(str, 3);
        jSONObject3.put(str2, 2);
        jSONObject3.put(str3, 85);
        jSONObject.put("others", jSONObject3);
        return jSONObject;
    }

    public C10478c() {
        String str = "txLatency";
        String str2 = "maxEventsToPersist";
        String str3 = "eventTTL";
        String str4 = "maxRetryCount";
        String str5 = "timeToLive";
        String str6 = "minThreshold";
        String str7 = "fetchLimit";
        String str8 = "maxCacheSize";
        String str9 = "enabled";
        this.f31904w.add("bannerDict");
        this.f31904w.add("intDict");
        this.f31904w.add("nativeDict");
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str8, 1);
            jSONObject2.put(str7, 1);
            jSONObject2.put(str6, 0);
            jSONObject2.put(str5, 3300);
            jSONObject2.put("sortByBid", false);
            jSONObject.put("base", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(str8, 1);
            jSONObject3.put(str7, 1);
            jSONObject3.put(str6, 1);
            jSONObject3.put(str5, 3300);
            jSONObject.put("banner", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(str8, 1);
            jSONObject4.put(str7, 1);
            jSONObject4.put(str6, 1);
            jSONObject4.put(str5, 3300);
            jSONObject.put("int", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(str8, 100);
            jSONObject5.put(str7, 1);
            jSONObject5.put(str6, 1);
            jSONObject5.put(str5, 3300);
            jSONObject.put("native", jSONObject5);
            m34307c(jSONObject);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(str9, true);
            jSONObject6.put("samplingFactor", 0);
            this.f31900l = jSONObject6;
            JSONObject jSONObject7 = new JSONObject();
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(str9, f31882q);
            jSONObject8.put(str4, 0);
            jSONObject8.put(str3, 86400);
            jSONObject8.put(str2, 1000);
            jSONObject8.put(str, 50);
            jSONObject8.put("processingInterval", 20);
            jSONObject8.put("networkType", m34308e());
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put(str9, f31883r);
            jSONObject9.put(str4, 0);
            jSONObject9.put(str3, 86400);
            jSONObject9.put(str2, 1000);
            jSONObject9.put(str, 50);
            jSONObject9.put("processingInterval", 20);
            jSONObject9.put("networkType", m34308e());
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put(str9, f31884s);
            jSONObject10.put(str4, 0);
            jSONObject10.put(str3, 86400);
            jSONObject10.put(str2, 1000);
            jSONObject10.put(str, 50);
            jSONObject10.put("processingInterval", 20);
            jSONObject10.put("networkType", m34308e());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put(str9, f31885t);
            jSONObject11.put(str4, 0);
            jSONObject11.put(str3, 86400);
            jSONObject11.put(str2, 1000);
            jSONObject11.put(str, 50);
            jSONObject11.put("processingInterval", 20);
            jSONObject11.put("networkType", m34308e());
            jSONObject7.put("baseDict", jSONObject8);
            jSONObject7.put("bannerDict", jSONObject9);
            jSONObject7.put("intDict", jSONObject10);
            jSONObject7.put("nativeDict", jSONObject11);
            m34306b(jSONObject7);
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public final String mo33671a() {
        return "ads";
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        C10484f fVar;
        super.mo33672a(jSONObject);
        if (jSONObject.has("url")) {
            this.f31889a = jSONObject.getString("url");
        }
        if (jSONObject.has("trueRequestUrl")) {
            this.f31890b = jSONObject.getString("trueRequestUrl");
        }
        this.f31891c = jSONObject.getInt("minimumRefreshInterval");
        this.f31892d = jSONObject.getInt("defaultRefreshInterval");
        this.f31893e = jSONObject.getInt("fetchTimeout");
        this.f31903o = jSONObject.getBoolean("flushCacheOnStart");
        m34307c(jSONObject.getJSONObject("cache"));
        m34306b(jSONObject.getJSONObject("trcFlagDict"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("preload");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("base");
        this.f31888A = new C10486h();
        this.f31888A.f31940a = jSONObject3.getBoolean("enabled");
        this.f31888A.f31941b = jSONObject3.getLong("placementExpiry");
        this.f31888A.f31942c = jSONObject3.getInt("maxPreloadedAds");
        jSONObject2.remove("base");
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject4 = jSONObject2.getJSONObject(str);
            C10486h hVar = new C10486h();
            hVar.f31940a = jSONObject4.optBoolean("enabled", this.f31888A.f31940a);
            hVar.f31941b = jSONObject4.optLong("placementExpiry", this.f31888A.f31941b);
            hVar.f31942c = jSONObject4.optInt("maxPreloadedAds", this.f31888A.f31942c);
            this.f31907z.put(str, hVar);
        }
        JSONObject jSONObject5 = jSONObject.getJSONObject("imai");
        this.f31896h.f31928a = jSONObject5.getInt("maxRetries");
        this.f31896h.f31929b = jSONObject5.getInt("pingInterval");
        this.f31896h.f31930c = jSONObject5.getInt("pingTimeout");
        this.f31896h.f31931d = jSONObject5.getInt("maxDbEvents");
        this.f31896h.f31932e = jSONObject5.getInt("maxEventBatch");
        this.f31896h.f31933f = jSONObject5.getLong("pingCacheExpiry");
        JSONObject jSONObject6 = jSONObject.getJSONObject("rendering");
        this.f31897i.f31943a = jSONObject6.getInt("renderTimeout");
        this.f31897i.f31945c = jSONObject6.getInt("picHeight");
        this.f31897i.f31944b = jSONObject6.getInt("picWidth");
        this.f31897i.f31946d = jSONObject6.getInt("picQuality");
        this.f31897i.f31947e = jSONObject6.getString("webviewBackground");
        this.f31897i.f31949g = jSONObject6.getBoolean("autoRedirectionEnforcement");
        this.f31897i.f31950h = jSONObject6.getInt("maxVibrationDuration");
        this.f31897i.f31951i = jSONObject6.getInt("maxVibrationPatternLength");
        this.f31897i.f31955m = jSONObject6.optBoolean("enablePubMuteControl", false);
        this.f31897i.f31952j = (long) jSONObject6.getJSONObject("savecontent").getInt("maxSaveSize");
        synchronized (f31887v) {
            this.f31897i.f31953k.clear();
            JSONArray jSONArray = jSONObject6.getJSONObject("savecontent").getJSONArray("allowedContentType");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f31897i.f31953k.add(jSONArray.getString(i));
            }
        }
        this.f31897i.f31954l = jSONObject6.getBoolean("shouldRenderPopup");
        JSONObject jSONObject7 = jSONObject.getJSONObject(AdType.MRAID);
        this.f31898j.f31936a = jSONObject7.getLong("expiry");
        this.f31898j.f31937b = jSONObject7.getInt("maxRetries");
        this.f31898j.f31938c = jSONObject7.getInt("retryInterval");
        this.f31898j.f31939d = jSONObject7.getString("url");
        if (jSONObject.has("telemetry")) {
            this.f31900l = jSONObject.getJSONObject("telemetry");
        }
        JSONObject jSONObject8 = jSONObject.getJSONObject("viewability");
        this.f31899k.f31964a = jSONObject8.getInt("impressionMinPercentageViewed");
        this.f31899k.f31965b = jSONObject8.getInt("impressionMinTimeViewed");
        this.f31899k.f31968e = jSONObject8.optInt("displayMinPercentageAnimate", 67);
        this.f31899k.f31966c = jSONObject8.optInt("visibilityThrottleMillis", 100);
        this.f31899k.f31967d = jSONObject8.optInt("impressionPollIntervalMillis", 250);
        this.f31899k.f31972i = jSONObject8.optBoolean("moatEnabled", false);
        this.f31899k.f31973j = jSONObject8.optBoolean("iasEnabled", false);
        C10490l lVar = this.f31899k;
        JSONObject optJSONObject = jSONObject8.optJSONObject("mmaConfig");
        if (optJSONObject != null) {
            fVar = new C10484f(optJSONObject.optBoolean("enabled", false), optJSONObject.optString("xmlConfigUrl", ""));
        } else {
            fVar = new C10484f(true, "https://i.l.inmobicdn.cn/sdk/sdk/MMA/im_sdkconfig.xml");
        }
        lVar.f31974k = fVar;
        JSONObject jSONObject9 = jSONObject8.getJSONObject(Advertisement.KEY_VIDEO);
        this.f31899k.f31969f = jSONObject9.getInt("impressionMinPercentageViewed");
        this.f31899k.f31970g = jSONObject9.getInt("impressionMinTimeViewed");
        this.f31899k.f31971h = jSONObject9.optInt("videoMinPercentagePlay", 50);
        JSONObject jSONObject10 = jSONObject.getJSONObject("vastVideo");
        this.f31901m.f31959a = jSONObject10.getInt("maxWrapperLimit");
        this.f31901m.f31960b = jSONObject10.getLong("optimalVastVideoSize");
        this.f31901m.f31961c = jSONObject10.getLong("vastMaxAssetSize");
        synchronized (f31887v) {
            this.f31901m.f31963e.clear();
            JSONArray jSONArray2 = jSONObject10.getJSONArray("allowedContentType");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.f31901m.f31963e.add(jSONArray2.getString(i2));
            }
        }
        C10481c cVar = this.f31901m.f31962d;
        JSONObject jSONObject11 = jSONObject10.getJSONObject("bitRate");
        cVar.f31921a = jSONObject11.getBoolean("bitrate_mandatory");
        cVar.f31922b = jSONObject11.getInt("headerTimeout");
        JSONObject jSONObject12 = jSONObject.getJSONObject("assetCache");
        this.f31902n.f31917b = jSONObject12.getInt("retryInterval");
        this.f31902n.f31916a = jSONObject12.getInt("maxRetries");
        this.f31902n.f31918c = jSONObject12.getInt("maxCachedAssets");
        this.f31902n.f31919d = (long) jSONObject12.getInt("maxCacheSize");
        this.f31902n.f31920e = jSONObject12.getLong("timeToLive");
    }

    /* renamed from: b */
    private void m34306b(JSONObject jSONObject) throws JSONException {
        String str = "baseDict";
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        this.f31894f = new C10479a();
        String str2 = "enabled";
        this.f31894f.f31915h = jSONObject2.getBoolean(str2);
        String str3 = "maxRetryCount";
        this.f31894f.f31908a = jSONObject2.getInt(str3);
        String str4 = "eventTTL";
        this.f31894f.f31909b = jSONObject2.getLong(str4);
        String str5 = "maxEventsToPersist";
        this.f31894f.f31910c = jSONObject2.getInt(str5);
        String str6 = "processingInterval";
        this.f31894f.f31911d = jSONObject2.getLong(str6);
        String str7 = "txLatency";
        this.f31894f.f31912e = jSONObject2.getLong(str7);
        String str8 = "networkType";
        m34305a(jSONObject2.getJSONObject(str8), this.f31894f);
        jSONObject.remove(str);
        this.f31895g = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str9 = (String) keys.next();
            if (str9 != null) {
                List<String> list = this.f31904w;
                if (list != null && list.contains(str9)) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(str9);
                    C10479a aVar = new C10479a();
                    aVar.f31915h = jSONObject3.optBoolean(str2, this.f31894f.f31915h);
                    aVar.f31908a = jSONObject3.optInt(str3, this.f31894f.f31908a);
                    aVar.f31909b = jSONObject3.optLong(str4, this.f31894f.f31909b);
                    aVar.f31910c = jSONObject3.optInt(str5, this.f31894f.f31910c);
                    aVar.f31911d = jSONObject3.optLong(str6, this.f31894f.f31911d);
                    aVar.f31912e = jSONObject3.optLong(str7, this.f31894f.f31912e);
                    m34305a(jSONObject3.getJSONObject(str8), aVar);
                    this.f31895g.put(str9, aVar);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m34305a(JSONObject jSONObject, C10479a aVar) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            C10488j jVar = new C10488j();
            jVar.f31956a = jSONObject2.getLong("retryInterval");
            jVar.f31957b = jSONObject2.getInt("minBatchSize");
            jVar.f31958c = jSONObject2.getInt("maxBatchSize");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1068855134) {
                if (hashCode != -1006804125) {
                    if (hashCode == 3649301 && str.equals("wifi")) {
                        c = 0;
                    }
                } else if (str.equals("others")) {
                    c = 2;
                }
            } else if (str.equals("mobile")) {
                c = 1;
            }
            if (c != 0) {
                aVar.f31913f = jVar;
            } else {
                aVar.f31914g = jVar;
            }
        }
    }

    /* renamed from: c */
    private void m34307c(JSONObject jSONObject) throws JSONException {
        String str = "base";
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        this.f31905x = new C10482d();
        String str2 = "maxCacheSize";
        this.f31905x.f31923a = jSONObject2.getInt(str2);
        String str3 = "fetchLimit";
        this.f31905x.f31924b = jSONObject2.getInt(str3);
        String str4 = "minThreshold";
        this.f31905x.f31925c = jSONObject2.getInt(str4);
        String str5 = "timeToLive";
        this.f31905x.f31926d = jSONObject2.getLong(str5);
        String str6 = "sortByBid";
        this.f31905x.f31927e = jSONObject2.getBoolean(str6);
        jSONObject.remove(str);
        this.f31906y = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str7 = (String) keys.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(str7);
            C10482d dVar = new C10482d();
            dVar.f31923a = jSONObject3.optInt(str2, this.f31905x.f31923a);
            dVar.f31924b = jSONObject3.optInt(str3, this.f31905x.f31924b);
            dVar.f31925c = jSONObject3.optInt(str4, this.f31905x.f31925c);
            dVar.f31926d = jSONObject3.optLong(str5, this.f31905x.f31926d);
            dVar.f31927e = jSONObject3.optBoolean(str6, this.f31905x.f31927e);
            this.f31906y.put(str7, dVar);
        }
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        JSONObject b = super.mo33673b();
        String str = "url";
        b.put(str, this.f31889a);
        b.put("trueRequestUrl", this.f31890b);
        b.put("minimumRefreshInterval", this.f31891c);
        b.put("defaultRefreshInterval", this.f31892d);
        b.put("fetchTimeout", this.f31893e);
        b.put("flushCacheOnStart", this.f31903o);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str2 = "maxCacheSize";
        jSONObject2.put(str2, this.f31905x.f31923a);
        String str3 = "fetchLimit";
        jSONObject2.put(str3, this.f31905x.f31924b);
        String str4 = "minThreshold";
        jSONObject2.put(str4, this.f31905x.f31925c);
        String str5 = "timeToLive";
        jSONObject2.put(str5, this.f31905x.f31926d);
        jSONObject.put("base", jSONObject2);
        for (Entry entry : this.f31906y.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            C10482d dVar = (C10482d) entry.getValue();
            jSONObject3.put(str2, dVar.f31923a);
            jSONObject3.put(str3, dVar.f31924b);
            jSONObject3.put(str4, dVar.f31925c);
            jSONObject3.put(str5, dVar.f31926d);
            jSONObject.put((String) entry.getKey(), jSONObject3);
        }
        b.put("cache", jSONObject);
        b.put("trcFlagDict", m34310g());
        JSONObject jSONObject4 = new JSONObject();
        String str6 = "maxRetries";
        jSONObject4.put(str6, this.f31896h.f31928a);
        jSONObject4.put("pingInterval", this.f31896h.f31929b);
        jSONObject4.put("pingTimeout", this.f31896h.f31930c);
        jSONObject4.put("maxDbEvents", this.f31896h.f31931d);
        jSONObject4.put("maxEventBatch", this.f31896h.f31932e);
        jSONObject4.put("pingCacheExpiry", this.f31896h.f31933f);
        b.put("imai", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("renderTimeout", this.f31897i.f31943a);
        jSONObject5.put("picWidth", this.f31897i.f31944b);
        jSONObject5.put("picHeight", this.f31897i.f31945c);
        jSONObject5.put("picQuality", this.f31897i.f31946d);
        jSONObject5.put("webviewBackground", this.f31897i.f31947e);
        jSONObject5.put("autoRedirectionEnforcement", this.f31897i.f31949g);
        jSONObject5.put("maxVibrationDuration", this.f31897i.f31950h);
        jSONObject5.put("maxVibrationPatternLength", this.f31897i.f31951i);
        jSONObject5.put("enablePubMuteControl", this.f31897i.f31955m);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("maxSaveSize", this.f31897i.f31952j);
        String str7 = "allowedContentType";
        jSONObject6.put(str7, new JSONArray(this.f31897i.f31953k));
        jSONObject5.put("savecontent", jSONObject6);
        jSONObject5.put("shouldRenderPopup", this.f31897i.f31954l);
        b.put("rendering", jSONObject5);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("expiry", this.f31898j.f31936a);
        jSONObject7.put(str6, this.f31898j.f31937b);
        String str8 = "retryInterval";
        jSONObject7.put(str8, this.f31898j.f31938c);
        jSONObject7.put(str, this.f31898j.f31939d);
        b.put(AdType.MRAID, jSONObject7);
        JSONObject jSONObject8 = new JSONObject();
        String str9 = "impressionMinPercentageViewed";
        jSONObject8.put(str9, this.f31899k.f31964a);
        String str10 = "impressionMinTimeViewed";
        jSONObject8.put(str10, this.f31899k.f31965b);
        jSONObject8.put("displayMinPercentageAnimate", this.f31899k.f31968e);
        jSONObject8.put("visibilityThrottleMillis", this.f31899k.f31966c);
        jSONObject8.put("impressionPollIntervalMillis", this.f31899k.f31967d);
        jSONObject8.put("moatEnabled", this.f31899k.f31972i);
        jSONObject8.put("iasEnabled", this.f31899k.f31973j);
        C10484f fVar = this.f31899k.f31974k;
        JSONObject jSONObject9 = new JSONObject();
        jSONObject9.put("enabled", fVar.f31934a);
        jSONObject9.put("xmlConfigUrl", fVar.f31935b);
        jSONObject8.put("mmaConfig", jSONObject9);
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.put(str9, this.f31899k.f31969f);
        jSONObject10.put(str10, this.f31899k.f31970g);
        jSONObject10.put("videoMinPercentagePlay", this.f31899k.f31971h);
        jSONObject8.put(Advertisement.KEY_VIDEO, jSONObject10);
        b.put("viewability", jSONObject8);
        b.put("preload", m34309f());
        JSONObject jSONObject11 = new JSONObject();
        jSONObject11.put("maxWrapperLimit", this.f31901m.f31959a);
        jSONObject11.put("optimalVastVideoSize", this.f31901m.f31960b);
        jSONObject11.put("vastMaxAssetSize", this.f31901m.f31961c);
        jSONObject11.put(str7, new JSONArray(this.f31901m.f31963e));
        C10481c cVar = this.f31901m.f31962d;
        JSONObject jSONObject12 = new JSONObject();
        jSONObject12.put("headerTimeout", cVar.f31922b);
        jSONObject12.put("bitrate_mandatory", cVar.f31921a);
        jSONObject11.put("bitRate", jSONObject12);
        b.put("vastVideo", jSONObject11);
        JSONObject jSONObject13 = new JSONObject();
        jSONObject13.put(str8, this.f31902n.f31917b);
        jSONObject13.put(str6, this.f31902n.f31916a);
        jSONObject13.put("maxCachedAssets", this.f31902n.f31918c);
        jSONObject13.put(str2, this.f31902n.f31919d);
        jSONObject13.put(str5, this.f31902n.f31920e);
        b.put("assetCache", jSONObject13);
        JSONObject jSONObject14 = this.f31900l;
        if (jSONObject14 != null) {
            b.put("telemetry", jSONObject14);
        }
        return b;
    }

    /* renamed from: f */
    private JSONObject m34309f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "enabled";
        jSONObject2.put(str, this.f31888A.f31940a);
        String str2 = "placementExpiry";
        jSONObject2.put(str2, this.f31888A.f31941b);
        String str3 = "maxPreloadedAds";
        jSONObject2.put(str3, this.f31888A.f31942c);
        jSONObject.put("base", jSONObject2);
        for (Entry entry : this.f31907z.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            C10486h hVar = (C10486h) entry.getValue();
            jSONObject3.put(str, hVar.f31940a);
            jSONObject3.put(str2, hVar.f31941b);
            jSONObject3.put(str3, hVar.f31942c);
            jSONObject.put((String) entry.getKey(), jSONObject3);
        }
        return jSONObject;
    }

    /* renamed from: g */
    private JSONObject m34310g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        String str = "enabled";
        jSONObject2.put(str, this.f31894f.f31915h);
        String str2 = "maxRetryCount";
        jSONObject2.put(str2, this.f31894f.f31908a);
        String str3 = "eventTTL";
        jSONObject2.put(str3, this.f31894f.f31909b);
        String str4 = "maxEventsToPersist";
        jSONObject2.put(str4, this.f31894f.f31910c);
        String str5 = "processingInterval";
        jSONObject2.put(str5, this.f31894f.f31911d);
        String str6 = "txLatency";
        jSONObject2.put(str6, this.f31894f.f31912e);
        String str7 = "networkType";
        jSONObject2.put(str7, m34304a(this.f31894f));
        jSONObject.put("baseDict", jSONObject2);
        for (Entry entry : this.f31895g.entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            C10479a aVar = (C10479a) entry.getValue();
            jSONObject3.put(str, aVar.f31915h);
            jSONObject3.put(str2, aVar.f31908a);
            jSONObject3.put(str3, aVar.f31909b);
            jSONObject3.put(str4, aVar.f31910c);
            jSONObject3.put(str5, aVar.f31911d);
            jSONObject3.put(str6, aVar.f31912e);
            jSONObject3.put(str7, m34304a(aVar));
            jSONObject.put((String) entry.getKey(), jSONObject3);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m34304a(C10479a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        C10488j jVar = aVar.f31914g;
        JSONObject jSONObject2 = new JSONObject();
        String str = "retryInterval";
        jSONObject2.put(str, jVar.f31956a);
        String str2 = "minBatchSize";
        jSONObject2.put(str2, jVar.f31957b);
        String str3 = "maxBatchSize";
        jSONObject2.put(str3, jVar.f31958c);
        jSONObject.put("wifi", jSONObject2);
        C10488j jVar2 = aVar.f31913f;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(str, jVar2.f31956a);
        jSONObject3.put(str2, jVar2.f31957b);
        jSONObject3.put(str3, jVar2.f31958c);
        jSONObject.put("others", jSONObject3);
        return jSONObject;
    }

    /* renamed from: c */
    public final boolean mo33674c() {
        boolean z;
        String str = "http://";
        String str2 = "https://";
        if ((this.f31889a.startsWith(str) || this.f31889a.startsWith(str2)) && (this.f31890b.startsWith(str) || this.f31890b.startsWith(str2))) {
            int i = this.f31891c;
            if (i >= 0) {
                int i2 = this.f31892d;
                if (i2 >= 0 && i <= i2 && this.f31893e > 0) {
                    C10482d dVar = this.f31905x;
                    if (dVar == null || !dVar.mo34207a()) {
                        return false;
                    }
                    for (Entry value : this.f31906y.entrySet()) {
                        if (!((C10482d) value.getValue()).mo34207a()) {
                            return false;
                        }
                    }
                    C10479a aVar = this.f31894f;
                    if (aVar == null || !aVar.mo34206a()) {
                        return false;
                    }
                    for (Entry value2 : this.f31895g.entrySet()) {
                        if (!((C10479a) value2.getValue()).mo34206a()) {
                            return false;
                        }
                    }
                    C10483e eVar = this.f31896h;
                    if (eVar.f31931d < 0 || eVar.f31932e < 0 || eVar.f31928a < 0 || eVar.f31929b < 0 || eVar.f31930c <= 0 || eVar.f31933f <= 0) {
                        return false;
                    }
                    C10485g gVar = this.f31898j;
                    if (gVar.f31936a < 0 || gVar.f31938c < 0 || gVar.f31937b < 0 || (!gVar.f31939d.startsWith(str) && !this.f31898j.f31939d.startsWith(str2))) {
                        return false;
                    }
                    C10487i iVar = this.f31897i;
                    if (iVar.f31943a >= 0 && iVar.f31945c >= 0 && iVar.f31944b >= 0 && iVar.f31946d >= 0 && iVar.f31950h >= 0 && iVar.f31951i >= 0 && iVar.f31952j >= 0) {
                        String str3 = iVar.f31947e;
                        if (!(str3 == null || str3.trim().length() == 0)) {
                            try {
                                this.f31897i.f31948f = Color.parseColor(this.f31897i.f31947e);
                                C10485g gVar2 = this.f31898j;
                                if (gVar2.f31937b >= 0 && gVar2.f31938c >= 0) {
                                    String str4 = gVar2.f31939d;
                                    if (!(str4 == null || str4.trim().length() == 0)) {
                                        C10490l lVar = this.f31899k;
                                        int i3 = lVar.f31964a;
                                        if (i3 > 0 && i3 <= 100) {
                                            int i4 = lVar.f31965b;
                                            if (i4 >= 0) {
                                                int i5 = lVar.f31968e;
                                                if (i5 > 0 && i5 <= 100) {
                                                    int i6 = lVar.f31969f;
                                                    if (i6 > 0 && i6 <= 100 && lVar.f31970g >= 0) {
                                                        int i7 = lVar.f31971h;
                                                        if (i7 > 0 && i7 <= 100) {
                                                            int i8 = lVar.f31966c;
                                                            if (i8 >= 50 && i8 * 5 <= i4) {
                                                                int i9 = lVar.f31967d;
                                                                if (i9 >= 50 && i9 * 4 <= i4) {
                                                                    C10484f fVar = lVar.f31974k;
                                                                    if (fVar.f31935b.startsWith(Constants.HTTP) || fVar.f31935b.startsWith("https")) {
                                                                        z = true;
                                                                    } else {
                                                                        z = false;
                                                                    }
                                                                    if (z) {
                                                                        C10486h hVar = this.f31888A;
                                                                        if (hVar == null || !hVar.mo34208a()) {
                                                                            return false;
                                                                        }
                                                                        for (Entry value3 : this.f31907z.entrySet()) {
                                                                            if (!((C10486h) value3.getValue()).mo34208a()) {
                                                                                return false;
                                                                            }
                                                                        }
                                                                        C10489k kVar = this.f31901m;
                                                                        long j = kVar.f31960b;
                                                                        if (j <= 31457280 && j > 0 && kVar.f31959a >= 0) {
                                                                            long j2 = kVar.f31961c;
                                                                            if (j2 > 0 && j2 <= 31457280) {
                                                                                C10480b bVar = this.f31902n;
                                                                                if (bVar.f31917b >= 0) {
                                                                                    int i10 = bVar.f31918c;
                                                                                    if (i10 > 20 || i10 < 0 || bVar.f31920e < 0 || bVar.f31919d < 0 || bVar.f31916a < 0) {
                                                                                        return false;
                                                                                    }
                                                                                    return true;
                                                                                }
                                                                                return false;
                                                                            }
                                                                        }
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        return false;
                                    }
                                }
                                return false;
                            } catch (IllegalArgumentException e) {
                                return false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10478c();
    }

    /* renamed from: a */
    public final C10482d mo34203a(String str) {
        C10482d dVar = (C10482d) this.f31906y.get(str);
        if (dVar == null) {
            return this.f31905x;
        }
        return dVar;
    }

    /* renamed from: b */
    public final C10479a mo34204b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("Dict");
        C10479a aVar = (C10479a) this.f31895g.get(sb.toString());
        if (aVar == null) {
            return this.f31894f;
        }
        return aVar;
    }

    /* renamed from: c */
    public final C10486h mo34205c(String str) {
        C10486h hVar = (C10486h) this.f31907z.get(str);
        if (hVar == null) {
            return this.f31888A;
        }
        return hVar;
    }
}
