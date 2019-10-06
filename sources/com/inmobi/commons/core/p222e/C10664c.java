package com.inmobi.commons.core.p222e;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.e.c */
/* compiled from: TelemetryComponentConfig */
public final class C10664c {

    /* renamed from: a */
    int f32512a = 0;

    /* renamed from: b */
    boolean f32513b = false;

    /* renamed from: c */
    private String f32514c = "telemetry";

    /* renamed from: d */
    private Map<String, C10665a> f32515d = new HashMap();

    /* renamed from: com.inmobi.commons.core.e.c$a */
    /* compiled from: TelemetryComponentConfig */
    static final class C10665a {

        /* renamed from: a */
        String f32516a;

        /* renamed from: b */
        int f32517b;
    }

    public C10664c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[Catch:{ JSONException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b A[Catch:{ JSONException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A[Catch:{ JSONException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[Catch:{ JSONException -> 0x0097 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C10664c(java.lang.String r6, org.json.JSONObject r7, com.inmobi.commons.core.p222e.C10664c r8) {
        /*
            r5 = this;
            java.lang.String r0 = "events"
            java.lang.String r1 = "enabled"
            java.lang.String r2 = "samplingFactor"
            r5.<init>()
            r3 = 0
            r5.f32512a = r3
            java.lang.String r4 = "telemetry"
            r5.f32514c = r4
            r5.f32513b = r3
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5.f32515d = r4
            if (r7 != 0) goto L_0x001f
            r5.m34999a(r6)
            return
        L_0x001f:
            if (r6 == 0) goto L_0x002e
            java.lang.String r4 = r6.trim()     // Catch:{ JSONException -> 0x0097 }
            int r4 = r4.length()     // Catch:{ JSONException -> 0x0097 }
            if (r4 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r4 = r6
            goto L_0x0031
        L_0x002e:
            java.lang.String r4 = r8.f32514c     // Catch:{ JSONException -> 0x0097 }
        L_0x0031:
            r5.f32514c = r4     // Catch:{ JSONException -> 0x0097 }
            boolean r4 = r7.has(r1)     // Catch:{ JSONException -> 0x0097 }
            if (r4 == 0) goto L_0x0042
            boolean r1 = r7.getBoolean(r1)     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r1 = 0
            goto L_0x0043
        L_0x0042:
            r1 = 1
        L_0x0043:
            r5.f32513b = r1     // Catch:{ JSONException -> 0x0097 }
            boolean r1 = r7.has(r2)     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x0050
            int r8 = r7.getInt(r2)     // Catch:{ JSONException -> 0x0097 }
            goto L_0x0052
        L_0x0050:
            int r8 = r8.f32512a     // Catch:{ JSONException -> 0x0097 }
        L_0x0052:
            r5.f32512a = r8     // Catch:{ JSONException -> 0x0097 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ JSONException -> 0x0097 }
            r8.<init>()     // Catch:{ JSONException -> 0x0097 }
            r5.f32515d = r8     // Catch:{ JSONException -> 0x0097 }
            boolean r8 = r7.has(r0)     // Catch:{ JSONException -> 0x0097 }
            if (r8 == 0) goto L_0x0096
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch:{ JSONException -> 0x0097 }
        L_0x0066:
            int r8 = r7.length()     // Catch:{ JSONException -> 0x0097 }
            if (r3 >= r8) goto L_0x0096
            com.inmobi.commons.core.e.c$a r8 = new com.inmobi.commons.core.e.c$a     // Catch:{ JSONException -> 0x0097 }
            r8.<init>()     // Catch:{ JSONException -> 0x0097 }
            org.json.JSONObject r0 = r7.getJSONObject(r3)     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x0097 }
            r8.f32516a = r1     // Catch:{ JSONException -> 0x0097 }
            boolean r1 = r0.has(r2)     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x0088
            int r0 = r0.getInt(r2)     // Catch:{ JSONException -> 0x0097 }
            goto L_0x008a
        L_0x0088:
            int r0 = r5.f32512a     // Catch:{ JSONException -> 0x0097 }
        L_0x008a:
            r8.f32517b = r0     // Catch:{ JSONException -> 0x0097 }
            java.util.Map<java.lang.String, com.inmobi.commons.core.e.c$a> r0 = r5.f32515d     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r8.f32516a     // Catch:{ JSONException -> 0x0097 }
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0097 }
            int r3 = r3 + 1
            goto L_0x0066
        L_0x0096:
            return
        L_0x0097:
            r7 = move-exception
            r5.m34999a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.commons.core.p222e.C10664c.<init>(java.lang.String, org.json.JSONObject, com.inmobi.commons.core.e.c):void");
    }

    /* renamed from: a */
    private void m34999a(String str) {
        this.f32513b = true;
        this.f32514c = str;
    }
}
