package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.ads.C10478c.C10489k;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.vungle.warren.model.Advertisement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.a */
/* compiled from: Ad */
public class C10359a {
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final String f31474l = C10359a.class.getSimpleName();

    /* renamed from: a */
    final int f31475a;

    /* renamed from: b */
    final String f31476b;

    /* renamed from: c */
    final String f31477c;

    /* renamed from: d */
    final long f31478d;

    /* renamed from: e */
    long f31479e;

    /* renamed from: f */
    long f31480f;

    /* renamed from: g */
    public final String f31481g;

    /* renamed from: h */
    String f31482h;

    /* renamed from: i */
    String f31483i;

    /* renamed from: j */
    boolean f31484j;

    /* renamed from: k */
    public final float f31485k;

    /* renamed from: m */
    private final String f31486m;

    /* renamed from: n */
    private String f31487n;

    /* renamed from: o */
    private MonetizationContext f31488o;

    /* renamed from: p */
    private final String f31489p;

    /* renamed from: com.inmobi.ads.a$a */
    /* compiled from: Ad */
    static final class C10360a {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0067 A[Catch:{ Exception -> 0x02be }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0077 A[Catch:{ Exception -> 0x02be }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0082 A[Catch:{ Exception -> 0x02be }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x029f A[Catch:{ Exception -> 0x02bc }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.inmobi.ads.C10359a m33813a(org.json.JSONObject r23, long r24, java.lang.String r26, java.lang.String r27, java.lang.String r28, com.inmobi.ads.InMobiAdRequest.MonetizationContext r29, com.inmobi.ads.C10595r r30) {
            /*
                r0 = r23
                r1 = r30
                java.lang.String r2 = "pages"
                java.lang.String r3 = "rootContainer"
                r15 = 0
                java.lang.String r4 = "markupType"
                java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x02be }
                java.lang.String r5 = "expiry"
                r6 = -1
                long r8 = r0.optLong(r5, r6)     // Catch:{ Exception -> 0x02be }
                int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r5 == 0) goto L_0x002c
                r10 = 0
                int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r5 > 0) goto L_0x0023
                goto L_0x002c
            L_0x0023:
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x02be }
                long r5 = r5.toMillis(r8)     // Catch:{ Exception -> 0x02be }
                r17 = r5
                goto L_0x002e
            L_0x002c:
                r17 = r6
            L_0x002e:
                java.lang.String r5 = "impressionId"
                java.lang.String r8 = r0.getString(r5)     // Catch:{ Exception -> 0x02be }
                java.lang.String r5 = "bid"
                java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x02be }
                r6 = 0
                byte[] r5 = android.util.Base64.decode(r5, r6)     // Catch:{ Exception -> 0x02be }
                byte[] r7 = r1.f32277b     // Catch:{ Exception -> 0x02be }
                byte[] r9 = r1.f32276a     // Catch:{ Exception -> 0x02be }
                byte[] r5 = com.inmobi.commons.core.utilities.p224a.C10687b.m35084a(r5, r7, r9)     // Catch:{ Exception -> 0x02be }
                java.lang.String r5 = com.inmobi.commons.core.network.C10677d.m35056a(r5)     // Catch:{ Exception -> 0x02be }
                float r19 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x02be }
                java.lang.String r5 = "bidInfoEncrypted"
                java.lang.String r5 = r0.optString(r5, r15)     // Catch:{ Exception -> 0x02be }
                java.lang.String r20 = r1.mo34404a(r5)     // Catch:{ Exception -> 0x02be }
                r1 = -1
                int r5 = r4.hashCode()     // Catch:{ Exception -> 0x02be }
                r7 = -1084172778(0xffffffffbf60d616, float:-0.8782667)
                r9 = 2
                r10 = 1
                if (r5 == r7) goto L_0x0077
                r7 = 3213227(0x3107ab, float:4.50269E-39)
                if (r5 == r7) goto L_0x006d
            L_0x006c:
                goto L_0x0080
            L_0x006d:
                java.lang.String r5 = "html"
                boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x02be }
                if (r4 == 0) goto L_0x006c
                r1 = 1
                goto L_0x0080
            L_0x0077:
                java.lang.String r5 = "inmobiJson"
                boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x02be }
                if (r4 == 0) goto L_0x006c
                r1 = 2
            L_0x0080:
                if (r1 == r10) goto L_0x029f
                if (r1 == r9) goto L_0x0085
                return r15
            L_0x0085:
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x02be }
                java.lang.String r4 = "pubContent"
                java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x02be }
                r1.<init>(r4)     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02be }
                r1.toString()     // Catch:{ Exception -> 0x02be }
                boolean r4 = r1.isNull(r3)     // Catch:{ Exception -> 0x02be }
                java.lang.String r5 = "ServerError"
                java.lang.String r7 = "reason"
                java.lang.String r11 = "errorCode"
                java.lang.String r12 = "ads"
                if (r4 == 0) goto L_0x00d5
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02be }
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00bd }
                r0.<init>()     // Catch:{ Exception -> 0x00bd }
                java.lang.String r1 = "MISSING rootContainer"
                r0.put(r11, r1)     // Catch:{ Exception -> 0x00bd }
                java.lang.String r1 = "Missing rootContainer ad markup"
                r0.put(r7, r1)     // Catch:{ Exception -> 0x00bd }
                com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ Exception -> 0x00bd }
                com.inmobi.commons.core.p222e.C10659b.m34987a(r12, r5, r0)     // Catch:{ Exception -> 0x00bd }
                goto L_0x00d4
            L_0x00bd:
                r0 = move-exception
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02be }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
                java.lang.String r2 = "Error in submitting telemetry event : ("
                r1.<init>(r2)     // Catch:{ Exception -> 0x02be }
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x02be }
                r1.append(r0)     // Catch:{ Exception -> 0x02be }
                java.lang.String r0 = ")"
                r1.append(r0)     // Catch:{ Exception -> 0x02be }
            L_0x00d4:
                return r15
            L_0x00d5:
                org.json.JSONObject r3 = r1.getJSONObject(r3)     // Catch:{ Exception -> 0x02be }
                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x02be }
                r4.<init>()     // Catch:{ Exception -> 0x02be }
                java.util.List r13 = m33819c(r3)     // Catch:{ Exception -> 0x02be }
                java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x02be }
            L_0x00e6:
                boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x02be }
                if (r14 == 0) goto L_0x00f6
                java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x02be }
                java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.C10359a.m33803a(r4, r14, r9)     // Catch:{ Exception -> 0x02be }
                goto L_0x00e6
            L_0x00f6:
                java.util.List r13 = m33820d(r3)     // Catch:{ Exception -> 0x02be }
                java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x02be }
            L_0x00fe:
                boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x02be }
                if (r14 == 0) goto L_0x010e
                java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x02be }
                java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.C10359a.m33803a(r4, r14, r10)     // Catch:{ Exception -> 0x02be }
                goto L_0x00fe
            L_0x010e:
                java.lang.String r13 = m33814a(r3)     // Catch:{ Exception -> 0x02be }
                boolean r16 = m33818b(r3)     // Catch:{ Exception -> 0x02be }
                java.lang.String r3 = r13.trim()     // Catch:{ Exception -> 0x02be }
                int r3 = r3.length()     // Catch:{ Exception -> 0x02be }
                if (r3 != 0) goto L_0x0143
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.a r21 = new com.inmobi.ads.a     // Catch:{ Exception -> 0x02be }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x02be }
                r1 = r21
                r2 = r23
                r4 = r24
                r6 = r26
                r7 = r27
                r9 = r28
                r10 = r29
                r11 = r16
                r12 = r17
                r14 = r19
                r15 = r20
                r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r14, r15)     // Catch:{ Exception -> 0x029b }
                return r21
            L_0x0143:
                com.inmobi.ads.c r3 = new com.inmobi.ads.c     // Catch:{ Exception -> 0x029b }
                r3.<init>()     // Catch:{ Exception -> 0x029b }
                com.inmobi.commons.core.configs.b r14 = com.inmobi.commons.core.configs.C10641b.m34915a()     // Catch:{ Exception -> 0x029b }
                r15 = 0
                r14.mo34452a(r3, r15)     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.bu r14 = new com.inmobi.ads.bu     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.c$k r10 = r3.f31901m     // Catch:{ Exception -> 0x02be }
                r14.<init>(r10)     // Catch:{ Exception -> 0x02be }
                com.inmobi.ads.bx r10 = r14.mo34190a(r13)     // Catch:{ Exception -> 0x02be }
                int r13 = r10.f31877f     // Catch:{ Exception -> 0x02be }
                if (r13 == 0) goto L_0x0187
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02be }
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02be }
                r0.<init>()     // Catch:{ Exception -> 0x02be }
                int r1 = r10.f31877f     // Catch:{ Exception -> 0x02be }
                java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x02be }
                r0.put(r11, r1)     // Catch:{ Exception -> 0x02be }
                java.lang.String r1 = "Processing VAST XML to build a video descriptor failed"
                r0.put(r7, r1)     // Catch:{ Exception -> 0x02be }
                java.lang.String r1 = "latency"
                java.lang.String r2 = "0"
                r0.put(r1, r2)     // Catch:{ Exception -> 0x02be }
                com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ Exception -> 0x02be }
                java.lang.String r1 = "VastProcessingError"
                com.inmobi.commons.core.p222e.C10659b.m34987a(r12, r1, r0)     // Catch:{ Exception -> 0x02be }
                return r15
            L_0x0187:
                java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x02be }
                r13.<init>()     // Catch:{ Exception -> 0x02be }
                java.lang.String r14 = "message"
                java.lang.String r15 = "VAST PROCESSING SUCCESS"
                r13.put(r14, r15)     // Catch:{ Exception -> 0x029b }
                com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ Exception -> 0x029b }
                java.lang.String r14 = "VastProcessingSuccess"
                com.inmobi.commons.core.p222e.C10659b.m34987a(r12, r14, r13)     // Catch:{ Exception -> 0x029b }
                java.util.List<com.inmobi.ads.NativeTracker> r13 = r10.f31875d     // Catch:{ Exception -> 0x029b }
                org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x029b }
                r14.<init>()     // Catch:{ Exception -> 0x029b }
                java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x029b }
            L_0x01a8:
                boolean r15 = r13.hasNext()     // Catch:{ Exception -> 0x029b }
                if (r15 == 0) goto L_0x01bc
                java.lang.Object r15 = r13.next()     // Catch:{ Exception -> 0x029b }
                com.inmobi.ads.NativeTracker r15 = (com.inmobi.ads.NativeTracker) r15     // Catch:{ Exception -> 0x029b }
                java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x029b }
                r14.put(r15)     // Catch:{ Exception -> 0x029b }
                goto L_0x01a8
            L_0x01bc:
                java.util.List<com.inmobi.ads.bt> r13 = r10.f31876e     // Catch:{ Exception -> 0x029b }
                org.json.JSONArray r15 = new org.json.JSONArray     // Catch:{ Exception -> 0x029b }
                r15.<init>()     // Catch:{ Exception -> 0x029b }
                java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x029b }
            L_0x01c9:
                boolean r21 = r13.hasNext()     // Catch:{ Exception -> 0x029b }
                if (r21 == 0) goto L_0x01de
                java.lang.Object r21 = r13.next()     // Catch:{ Exception -> 0x029b }
                com.inmobi.ads.bt r21 = (com.inmobi.ads.C10468bt) r21     // Catch:{ Exception -> 0x029b }
                java.lang.String r9 = r21.toString()     // Catch:{ Exception -> 0x029b }
                r15.put(r9)     // Catch:{ Exception -> 0x029b }
                r9 = 2
                goto L_0x01c9
            L_0x01de:
                java.lang.String r9 = r10.mo34198b()     // Catch:{ Exception -> 0x029b }
                if (r9 == 0) goto L_0x0280
                boolean r13 = r9.isEmpty()     // Catch:{ Exception -> 0x029b }
                if (r13 == 0) goto L_0x01ee
                r22 = 0
                goto L_0x0282
            L_0x01ee:
                com.inmobi.ads.C10359a.m33803a(r4, r9, r6)     // Catch:{ Exception -> 0x029b }
                com.inmobi.ads.c$k r3 = r3.f31901m     // Catch:{ Exception -> 0x029b }
                java.util.List r3 = m33815a(r1, r3)     // Catch:{ Exception -> 0x029b }
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x029b }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x029b }
                java.lang.String r7 = "Media size for pages"
                r5.<init>(r7)     // Catch:{ Exception -> 0x029b }
                int r7 = r3.size()     // Catch:{ Exception -> 0x029b }
                r5.append(r7)     // Catch:{ Exception -> 0x029b }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x029b }
            L_0x020d:
                boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x029b }
                if (r5 == 0) goto L_0x021d
                java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x029b }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x029b }
                com.inmobi.ads.C10359a.m33803a(r4, r5, r6)     // Catch:{ Exception -> 0x029b }
                goto L_0x020d
            L_0x021d:
                java.util.List r3 = m33816a(r1, r2)     // Catch:{ Exception -> 0x029b }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x029b }
            L_0x0225:
                boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x029b }
                if (r5 == 0) goto L_0x0236
                java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x029b }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x029b }
                r6 = 2
                com.inmobi.ads.C10359a.m33803a(r4, r5, r6)     // Catch:{ Exception -> 0x029b }
                goto L_0x0225
            L_0x0236:
                java.util.List r1 = m33817b(r1, r2)     // Catch:{ Exception -> 0x029b }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x029b }
            L_0x023e:
                boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x029b }
                if (r2 == 0) goto L_0x024f
                java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x029b }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x029b }
                r3 = 1
                com.inmobi.ads.C10359a.m33803a(r4, r2, r3)     // Catch:{ Exception -> 0x029b }
                goto L_0x023e
            L_0x024f:
                com.inmobi.ads.bc r21 = new com.inmobi.ads.bc     // Catch:{ Exception -> 0x029b }
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x029b }
                java.lang.String r11 = r10.mo34198b()     // Catch:{ Exception -> 0x029b }
                java.lang.String r12 = r10.f31873b     // Catch:{ Exception -> 0x029b }
                java.lang.String r13 = r10.f31874c     // Catch:{ Exception -> 0x029b }
                java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x029b }
                java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x029b }
                r1 = r21
                r2 = r23
                r4 = r24
                r6 = r26
                r7 = r27
                r9 = r28
                r10 = r11
                r11 = r12
                r12 = r13
                r13 = r14
                r14 = r15
                r22 = 0
                r15 = r29
                r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20)     // Catch:{ Exception -> 0x02bc }
                return r21
            L_0x0280:
                r22 = 0
            L_0x0282:
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02bc }
                r0.<init>()     // Catch:{ Exception -> 0x02bc }
                java.lang.String r1 = "ZERO LENGTH ASSET"
                r0.put(r11, r1)     // Catch:{ Exception -> 0x02bc }
                java.lang.String r1 = "Asset length is 0"
                r0.put(r7, r1)     // Catch:{ Exception -> 0x02bc }
                com.inmobi.commons.core.p222e.C10659b.m34983a()     // Catch:{ Exception -> 0x02bc }
                com.inmobi.commons.core.p222e.C10659b.m34987a(r12, r5, r0)     // Catch:{ Exception -> 0x02bc }
                com.inmobi.ads.C10359a.f31474l     // Catch:{ Exception -> 0x02bc }
                return r22
            L_0x029b:
                r0 = move-exception
                r22 = 0
                goto L_0x02c1
            L_0x029f:
                r22 = r15
                com.inmobi.ads.a r15 = new com.inmobi.ads.a     // Catch:{ Exception -> 0x02bc }
                r14 = 0
                r1 = r15
                r2 = r23
                r3 = r24
                r5 = r26
                r6 = r27
                r7 = r8
                r8 = r28
                r9 = r29
                r10 = r17
                r12 = r19
                r13 = r20
                r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ Exception -> 0x02bc }
                return r15
            L_0x02bc:
                r0 = move-exception
                goto L_0x02c1
            L_0x02be:
                r0 = move-exception
                r22 = r15
            L_0x02c1:
                com.inmobi.ads.C10359a.f31474l
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Error parsing ad markup; "
                r1.<init>(r2)
                java.lang.String r2 = r0.getMessage()
                r1.append(r2)
                com.inmobi.commons.core.a.a r1 = com.inmobi.commons.core.p218a.C10621a.m34854a()
                com.inmobi.commons.core.e.a r2 = new com.inmobi.commons.core.e.a
                r2.<init>(r0)
                r1.mo34423a(r2)
                return r22
            */
            throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10359a.C10360a.m33813a(org.json.JSONObject, long, java.lang.String, java.lang.String, java.lang.String, com.inmobi.ads.InMobiAdRequest$MonetizationContext, com.inmobi.ads.r):com.inmobi.ads.a");
        }

        /* renamed from: a */
        private static List<String> m33815a(JSONObject jSONObject, C10489k kVar) {
            String str = "rootContainer";
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("pages");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!jSONArray.getJSONObject(i).isNull(str)) {
                        String a = m33814a(jSONArray.getJSONObject(i).getJSONObject(str));
                        if (a.trim().length() == 0) {
                            C10359a.f31474l;
                        } else {
                            C10475bx a2 = new C10470bu(kVar).mo34190a(a);
                            if (a2 != null) {
                                if (a2.f31877f == 0) {
                                    String b = a2.mo34198b();
                                    if (b != null && !b.isEmpty()) {
                                        arrayList.add(b);
                                    }
                                }
                            }
                            C10359a.f31474l;
                        }
                    }
                }
            } catch (JSONException e) {
                C10359a.f31474l;
            }
            return arrayList;
        }

        /* renamed from: a */
        private static List<String> m33816a(JSONObject jSONObject, String str) {
            String str2 = "rootContainer";
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!jSONArray.getJSONObject(i).isNull(str2)) {
                        arrayList.addAll(m33819c(jSONArray.getJSONObject(i).getJSONObject(str2)));
                    }
                }
            } catch (JSONException e) {
                C10359a.f31474l;
            }
            return arrayList;
        }

        /* renamed from: b */
        private static List<String> m33817b(JSONObject jSONObject, String str) {
            String str2 = "rootContainer";
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (!jSONArray.getJSONObject(i).isNull(str2)) {
                        arrayList.addAll(m33820d(jSONArray.getJSONObject(i).getJSONObject(str2)));
                    }
                }
            } catch (JSONException e) {
                C10359a.f31474l;
            }
            return arrayList;
        }

        /* renamed from: a */
        static C10359a m33812a(ContentValues contentValues) {
            String str = "video_url";
            if (!contentValues.containsKey(str) || contentValues.getAsString(str) == null || contentValues.getAsString(str).isEmpty()) {
                return new C10359a(contentValues);
            }
            return new C10444bc(contentValues);
        }

        /* renamed from: a */
        private static String m33814a(JSONObject jSONObject) {
            String str = "";
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray.length() == 0) {
                    return str;
                }
                String string = jSONObject.getString("assetType");
                if (string.equalsIgnoreCase(Advertisement.KEY_VIDEO)) {
                    return jSONArray.getString(0);
                }
                if (!string.equalsIgnoreCase("container")) {
                    return str;
                }
                String str2 = str;
                for (int i = 0; i < jSONArray.length(); i++) {
                    str2 = m33814a(jSONArray.getJSONObject(i));
                    if (str2.trim().length() != 0) {
                        break;
                    }
                }
                return str2;
            } catch (JSONException e) {
                C10359a.f31474l;
                StringBuilder sb = new StringBuilder("Error getting VAST video XML (");
                sb.append(e.getMessage());
                sb.append(")");
                C10621a.m34854a().mo34423a(new C10658a(e));
                return str;
            }
        }

        /* renamed from: b */
        private static boolean m33818b(JSONObject jSONObject) {
            String str = "preload";
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray.length() == 0) {
                    return false;
                }
                String string = jSONObject.getString("assetType");
                if (string.equalsIgnoreCase("webview")) {
                    if (jSONObject.isNull(str) || !jSONObject.getBoolean(str)) {
                        return false;
                    }
                    return true;
                } else if (!string.equalsIgnoreCase("container")) {
                    return false;
                } else {
                    boolean z = false;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        z = m33818b(jSONArray.getJSONObject(i));
                        if (z) {
                            break;
                        }
                    }
                    return z;
                }
            } catch (JSONException e) {
                C10359a.f31474l;
                StringBuilder sb = new StringBuilder("Error getting preload webview flag (");
                sb.append(e.getMessage());
                sb.append(")");
                C10621a.m34854a().mo34423a(new C10658a(e));
                return false;
            }
        }

        /* renamed from: c */
        private static List<String> m33819c(JSONObject jSONObject) {
            String str = "preload";
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray.length() == 0) {
                    return arrayList;
                }
                String string = jSONObject.getString("assetType");
                if (string.equalsIgnoreCase("image")) {
                    if (!jSONObject.isNull(str) && jSONObject.getBoolean(str)) {
                        arrayList.add(jSONArray.getString(0));
                    }
                    return arrayList;
                } else if (!string.equalsIgnoreCase("container")) {
                    return arrayList;
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.addAll(m33819c(jSONArray.getJSONObject(i)));
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                C10359a.f31474l;
                StringBuilder sb = new StringBuilder("Error getting getImageAssetUrls (");
                sb.append(e.getMessage());
                sb.append(")");
                return arrayList;
            }
        }

        /* renamed from: d */
        private static List<String> m33820d(JSONObject jSONObject) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
                if (jSONArray.length() == 0) {
                    return arrayList;
                }
                String string = jSONObject.getString("assetType");
                if (string.equalsIgnoreCase("gif")) {
                    arrayList.add(jSONArray.getString(0));
                    return arrayList;
                } else if (!string.equalsIgnoreCase("container")) {
                    return arrayList;
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.addAll(m33820d(jSONArray.getJSONObject(i)));
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                C10359a.f31474l;
                StringBuilder sb = new StringBuilder("Error getting getGifAssetUrls (");
                sb.append(e.getMessage());
                sb.append(")");
                return arrayList;
            }
        }
    }

    /* synthetic */ C10359a(JSONObject jSONObject, long j, String str, String str2, String str3, String str4, MonetizationContext monetizationContext, long j2, float f, String str5, byte b) {
        this(jSONObject, j, str, str2, str3, str4, monetizationContext, j2, f, str5);
    }

    private C10359a(JSONObject jSONObject, long j, String str, String str2, String str3, String str4, MonetizationContext monetizationContext, long j2, float f, String str5) {
        this(jSONObject, null, j, str, str2, str3, str4, monetizationContext, false, j2, f, str5);
    }

    C10359a(JSONObject jSONObject, String str, long j, String str2, String str3, String str4, String str5, MonetizationContext monetizationContext, boolean z, long j2, float f, String str6) {
        this.f31475a = -1;
        this.f31477c = jSONObject.toString();
        this.f31487n = str;
        this.f31478d = j;
        this.f31476b = str2;
        this.f31486m = str3;
        this.f31479e = System.currentTimeMillis();
        this.f31481g = str4;
        this.f31482h = str5;
        this.f31488o = monetizationContext;
        this.f31483i = "";
        this.f31484j = z;
        this.f31480f = j2;
        this.f31485k = f;
        this.f31489p = str6;
    }

    C10359a(ContentValues contentValues) {
        this.f31475a = contentValues.getAsInteger("id").intValue();
        this.f31476b = contentValues.getAsString("ad_type");
        this.f31486m = contentValues.getAsString("ad_size");
        this.f31487n = contentValues.getAsString("asset_urls");
        this.f31477c = contentValues.getAsString("ad_content");
        this.f31478d = contentValues.getAsLong("placement_id").longValue();
        this.f31479e = contentValues.getAsLong("insertion_ts").longValue();
        this.f31480f = contentValues.getAsLong("expiry_duration").longValue();
        this.f31481g = contentValues.getAsString("imp_id");
        this.f31482h = contentValues.getAsString("client_request_id");
        this.f31488o = MonetizationContext.m33595a(contentValues.getAsString("m10_context"));
        if (this.f31488o == null) {
            this.f31488o = MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY;
        }
        this.f31483i = contentValues.getAsString("web_vast");
        this.f31484j = contentValues.getAsInteger("preload_webView").intValue() != 0;
        this.f31485k = contentValues.getAsFloat("bid").floatValue();
        this.f31489p = contentValues.getAsString("bidInfo");
    }

    /* renamed from: a */
    public ContentValues mo33949a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_type", this.f31476b);
        contentValues.put("ad_size", this.f31486m);
        contentValues.put("asset_urls", this.f31487n);
        contentValues.put("ad_content", this.f31477c);
        contentValues.put("placement_id", Long.valueOf(this.f31478d));
        contentValues.put("insertion_ts", Long.valueOf(this.f31479e));
        contentValues.put("expiry_duration", Long.valueOf(this.f31480f));
        contentValues.put("imp_id", this.f31481g);
        contentValues.put("client_request_id", this.f31482h);
        contentValues.put("m10_context", this.f31488o.f31266a);
        String str = this.f31483i;
        if (str != null) {
            contentValues.put("web_vast", str);
        }
        contentValues.put("preload_webView", Integer.valueOf(this.f31484j ? 1 : 0));
        contentValues.put("bid", Float.valueOf(this.f31485k));
        contentValues.put("bidInfo", this.f31489p);
        return contentValues;
    }

    /* renamed from: b */
    public final JSONObject mo33951b() {
        try {
            return this.f31489p == null ? new JSONObject() : new JSONObject(this.f31489p);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final long mo33952c() {
        long j = this.f31480f;
        if (j == -1) {
            return -1;
        }
        return this.f31479e + j;
    }

    /* renamed from: d */
    public final Set<C10461bm> mo33953d() {
        HashSet hashSet = new HashSet();
        String str = this.f31487n;
        if (str == null || str.length() == 0) {
            return hashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.f31487n);
            if (jSONArray.length() == 0) {
                return hashSet;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = new JSONObject(jSONArray.getString(i));
                int i2 = jSONObject.getInt("type");
                String string = jSONObject.getString("url");
                if (string != null) {
                    hashSet.add(new C10461bm(i2, string));
                }
            }
            return hashSet;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return hashSet;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final String mo33954e() {
        String str = "markupType";
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(this.f31477c);
            if (jSONObject.isNull(str)) {
                return str2;
            }
            return jSONObject.getString(str);
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return str2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo33950a(C10359a aVar) {
        return mo33953d().equals(aVar.mo33953d());
    }

    /* renamed from: f */
    public final JSONObject mo33955f() {
        String str = "cachedAdData";
        try {
            JSONObject jSONObject = new JSONObject(this.f31477c);
            if (jSONObject.has(str)) {
                return jSONObject.getJSONObject(str);
            }
            return null;
        } catch (JSONException e) {
            C10621a.m34854a().mo34423a(new C10658a(e));
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33803a(JSONArray jSONArray, String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", i);
        jSONObject.put("url", str);
        jSONArray.put(jSONObject);
    }
}
