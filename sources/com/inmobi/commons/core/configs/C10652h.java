package com.inmobi.commons.core.configs;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.h */
/* compiled from: RootConfig */
public final class C10652h extends C10639a {

    /* renamed from: i */
    private static final Object f32470i = new Object();

    /* renamed from: a */
    int f32471a = 3;

    /* renamed from: b */
    int f32472b = 60;

    /* renamed from: c */
    int f32473c = 3;

    /* renamed from: d */
    public int f32474d = -1;

    /* renamed from: e */
    C10654b f32475e = new C10654b();

    /* renamed from: f */
    JSONObject f32476f = new JSONObject();

    /* renamed from: g */
    public boolean f32477g = false;

    /* renamed from: h */
    private List<C10653a> f32478h = new ArrayList();

    /* renamed from: com.inmobi.commons.core.configs.h$a */
    /* compiled from: RootConfig */
    static final class C10653a {

        /* renamed from: a */
        String f32479a;

        /* renamed from: b */
        long f32480b;

        /* renamed from: c */
        String f32481c;

        /* renamed from: d */
        String f32482d;

        /* renamed from: e */
        String f32483e = "https://config.inmobi.cn/config-server/v1/config/secure.cfg";

        C10653a() {
        }
    }

    /* renamed from: com.inmobi.commons.core.configs.h$b */
    /* compiled from: RootConfig */
    public static final class C10654b {

        /* renamed from: a */
        String f32484a = "7.2.7";

        /* renamed from: b */
        String f32485b = "https://www.inmobi.com/products/sdk/#downloads";
    }

    /* renamed from: a */
    public final String mo33671a() {
        return "root";
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        boolean z;
        JSONObject b = super.mo33673b();
        JSONArray jSONArray = new JSONArray();
        b.put("maxRetries", this.f32471a);
        b.put("retryInterval", this.f32472b);
        b.put("waitTime", this.f32473c);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MediationMetaData.KEY_VERSION, this.f32475e.f32484a);
        jSONObject.put("url", this.f32475e.f32485b);
        b.put("latestSdkInfo", jSONObject);
        synchronized (f32470i) {
            z = false;
            for (int i = 0; i < this.f32478h.size(); i++) {
                C10653a aVar = (C10653a) this.f32478h.get(i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", aVar.f32479a);
                jSONObject2.put("expiry", aVar.f32480b);
                jSONObject2.put("protocol", aVar.f32481c);
                jSONObject2.put("url", aVar.f32482d);
                if ("root".equals(aVar.f32479a)) {
                    jSONObject2.put("fallbackUrl", aVar.f32483e);
                }
                jSONArray.put(jSONObject2);
            }
        }
        b.put("components", jSONArray);
        b.put("monetizationDisabled", this.f32477g);
        JSONObject jSONObject3 = new JSONObject();
        if (this.f32474d == 1) {
            z = true;
        }
        jSONObject3.put("transmitRequest", z);
        b.put("gdpr", jSONObject3);
        return b;
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        super.mo33672a(jSONObject);
        this.f32471a = jSONObject.getInt("maxRetries");
        this.f32472b = jSONObject.getInt("retryInterval");
        this.f32473c = jSONObject.getInt("waitTime");
        JSONObject jSONObject2 = jSONObject.getJSONObject("latestSdkInfo");
        this.f32475e.f32484a = jSONObject2.getString(MediationMetaData.KEY_VERSION);
        this.f32475e.f32485b = jSONObject2.getString("url");
        JSONArray jSONArray = jSONObject.getJSONArray("components");
        synchronized (f32470i) {
            this.f32478h.clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                C10653a aVar = new C10653a();
                aVar.f32479a = jSONObject3.getString("type");
                aVar.f32480b = jSONObject3.getLong("expiry");
                aVar.f32481c = jSONObject3.getString("protocol");
                aVar.f32482d = jSONObject3.getString("url");
                if ("root".equals(aVar.f32479a)) {
                    aVar.f32483e = jSONObject3.getString("fallbackUrl");
                }
                this.f32478h.add(aVar);
            }
        }
        this.f32477g = jSONObject.getBoolean("monetizationDisabled");
        this.f32474d = jSONObject.getJSONObject("gdpr").getBoolean("transmitRequest") ? 1 : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
        if (r9.f32474d == -1) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bc, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bd, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo33674c() {
        /*
            r9 = this;
            java.util.List<com.inmobi.commons.core.configs.h$a> r0 = r9.f32478h
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.f32471a
            if (r0 < 0) goto L_0x00c2
            int r0 = r9.f32472b
            if (r0 < 0) goto L_0x00c2
            int r0 = r9.f32473c
            if (r0 >= 0) goto L_0x0014
            goto L_0x00c2
        L_0x0014:
            com.inmobi.commons.core.configs.h$b r0 = r9.f32475e
            java.lang.String r0 = r0.f32484a
            java.lang.String r0 = r0.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x00c1
            com.inmobi.commons.core.configs.h$b r0 = r9.f32475e
            java.lang.String r0 = r0.f32485b
            java.lang.String r2 = "http://"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x003c
            com.inmobi.commons.core.configs.h$b r0 = r9.f32475e
            java.lang.String r0 = r0.f32485b
            java.lang.String r2 = "https://"
            boolean r0 = r0.startsWith(r2)
            if (r0 != 0) goto L_0x003c
            goto L_0x00c1
        L_0x003c:
            java.lang.Object r0 = f32470i
            monitor-enter(r0)
            r2 = 0
        L_0x0040:
            java.util.List<com.inmobi.commons.core.configs.h$a> r3 = r9.f32478h     // Catch:{ all -> 0x00be }
            int r3 = r3.size()     // Catch:{ all -> 0x00be }
            if (r2 >= r3) goto L_0x00b5
            java.util.List<com.inmobi.commons.core.configs.h$a> r3 = r9.f32478h     // Catch:{ all -> 0x00be }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x00be }
            com.inmobi.commons.core.configs.h$a r3 = (com.inmobi.commons.core.configs.C10652h.C10653a) r3     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r3.f32479a     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00be }
            int r4 = r4.length()     // Catch:{ all -> 0x00be }
            if (r4 != 0) goto L_0x005f
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return r1
        L_0x005f:
            long r4 = r3.f32480b     // Catch:{ all -> 0x00be }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00be }
            long r4 = r4.longValue()     // Catch:{ all -> 0x00be }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x00b3
            long r4 = r3.f32480b     // Catch:{ all -> 0x00be }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00be }
            long r4 = r4.longValue()     // Catch:{ all -> 0x00be }
            r6 = 864000(0xd2f00, double:4.268727E-318)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0082
            goto L_0x00b3
        L_0x0082:
            java.lang.String r4 = r3.f32481c     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r4.trim()     // Catch:{ all -> 0x00be }
            int r4 = r4.length()     // Catch:{ all -> 0x00be }
            if (r4 != 0) goto L_0x0091
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return r1
        L_0x0091:
            java.lang.String r4 = r3.f32482d     // Catch:{ all -> 0x00be }
            boolean r4 = m34953c(r4)     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x009c
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return r1
        L_0x009c:
            java.lang.String r4 = "root"
            java.lang.String r5 = r3.f32479a     // Catch:{ all -> 0x00be }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x00b0
            java.lang.String r3 = r3.f32483e     // Catch:{ all -> 0x00be }
            boolean r3 = m34953c(r3)     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x00b0
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return r1
        L_0x00b0:
            int r2 = r2 + 1
            goto L_0x0040
        L_0x00b3:
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            return r1
        L_0x00b5:
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            int r0 = r9.f32474d
            r2 = -1
            if (r0 == r2) goto L_0x00bd
            r0 = 1
            return r0
        L_0x00bd:
            return r1
        L_0x00be:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00be }
            throw r1
        L_0x00c1:
            return r1
        L_0x00c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.commons.core.configs.C10652h.mo33674c():boolean");
    }

    /* renamed from: c */
    private static boolean m34953c(String str) {
        return str == null || str.trim().length() == 0 || (!str.startsWith("http://") && !str.startsWith("https://"));
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10652h();
    }

    /* renamed from: a */
    public final long mo34463a(String str) {
        synchronized (f32470i) {
            for (int i = 0; i < this.f32478h.size(); i++) {
                C10653a aVar = (C10653a) this.f32478h.get(i);
                if (str.equals(aVar.f32479a)) {
                    long j = aVar.f32480b;
                    return j;
                }
            }
            return 86400;
        }
    }

    /* renamed from: b */
    public final String mo34464b(String str) {
        synchronized (f32470i) {
            for (int i = 0; i < this.f32478h.size(); i++) {
                C10653a aVar = (C10653a) this.f32478h.get(i);
                if (str.equals(aVar.f32479a)) {
                    String str2 = aVar.f32482d;
                    return str2;
                }
            }
            String str3 = "";
            return str3;
        }
    }

    /* renamed from: e */
    public final String mo34465e() {
        synchronized (f32470i) {
            for (C10653a aVar : this.f32478h) {
                if ("root".equals(aVar.f32479a)) {
                    String str = aVar.f32483e;
                    return str;
                }
            }
            String str2 = "https://config.inmobi.cn/config-server/v1/config/secure.cfg";
            return str2;
        }
    }
}
