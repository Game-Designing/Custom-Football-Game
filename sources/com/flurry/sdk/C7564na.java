package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.na */
public class C7564na implements C7493ad<C7510e> {

    /* renamed from: a */
    private static final String f14961a = C7564na.class.getSimpleName();

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a6 A[SYNTHETIC, Splitter:B:15:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00aa A[Catch:{ JSONException -> 0x017d, all -> 0x017b }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c0 A[Catch:{ JSONException -> 0x017d, all -> 0x017b }, LOOP:0: B:19:0x00ba->B:21:0x00c0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x012b A[SYNTHETIC, Splitter:B:29:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012f A[Catch:{ JSONException -> 0x017d, all -> 0x017b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014c A[Catch:{ JSONException -> 0x017d, all -> 0x017b }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo23856a(java.io.OutputStream r10, java.lang.Object r11) throws java.io.IOException {
        /*
            r9 = this;
            com.flurry.sdk.e r11 = (com.flurry.sdk.C7510e) r11
            if (r10 == 0) goto L_0x018a
            if (r11 != 0) goto L_0x0008
            goto L_0x018a
        L_0x0008:
            com.flurry.sdk.ma r0 = new com.flurry.sdk.ma
            r0.<init>(r9, r10)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r1 = "project_key"
            java.lang.String r2 = r11.f14801a     // Catch:{ JSONException -> 0x017d }
            m16744a(r10, r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "bundle_id"
            java.lang.String r2 = r11.f14802b     // Catch:{ JSONException -> 0x017d }
            m16744a(r10, r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "app_version"
            java.lang.String r2 = r11.f14803c     // Catch:{ JSONException -> 0x017d }
            m16744a(r10, r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "sdk_version"
            int r2 = r11.f14804d     // Catch:{ JSONException -> 0x017d }
            r10.put(r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "platform"
            int r2 = r11.f14805e     // Catch:{ JSONException -> 0x017d }
            r10.put(r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "platform_version"
            java.lang.String r2 = r11.f14806f     // Catch:{ JSONException -> 0x017d }
            m16744a(r10, r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r1 = "limit_ad_tracking"
            boolean r2 = r11.f14807g     // Catch:{ JSONException -> 0x017d }
            r10.put(r1, r2)     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.h r1 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = "id"
            r3 = 0
            if (r1 == 0) goto L_0x00a1
            com.flurry.sdk.h r1 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r1 = r1.f14863a     // Catch:{ JSONException -> 0x017d }
            if (r1 == 0) goto L_0x00a1
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r1.<init>()     // Catch:{ JSONException -> 0x017d }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r4.<init>()     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "model"
            com.flurry.sdk.h r6 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r6 = r6.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r6 = r6.f14750a     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r5, r6)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "brand"
            com.flurry.sdk.h r6 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r6 = r6.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r6 = r6.f14751b     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r5, r6)     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.h r5 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r5 = r5.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = r5.f14752c     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r2, r5)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "device"
            com.flurry.sdk.h r6 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r6 = r6.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r6 = r6.f14753d     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r5, r6)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "product"
            com.flurry.sdk.h r6 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r6 = r6.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r6 = r6.f14754e     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r5, r6)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "version_release"
            com.flurry.sdk.h r6 = r11.f14808h     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.b r6 = r6.f14863a     // Catch:{ JSONException -> 0x017d }
            java.lang.String r6 = r6.f14755f     // Catch:{ JSONException -> 0x017d }
            m16744a(r4, r5, r6)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = "com.flurry.proton.generated.avro.v2.AndroidTags"
            r1.put(r5, r4)     // Catch:{ JSONException -> 0x017d }
            goto L_0x00a2
        L_0x00a1:
            r1 = r3
        L_0x00a2:
            java.lang.String r4 = "device_tags"
            if (r1 == 0) goto L_0x00aa
            r10.put(r4, r1)     // Catch:{ JSONException -> 0x017d }
            goto L_0x00af
        L_0x00aa:
            java.lang.Object r1 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x017d }
            r10.put(r4, r1)     // Catch:{ JSONException -> 0x017d }
        L_0x00af:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x017d }
            r1.<init>()     // Catch:{ JSONException -> 0x017d }
            java.util.List<com.flurry.sdk.g> r4 = r11.f14809i     // Catch:{ JSONException -> 0x017d }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ JSONException -> 0x017d }
        L_0x00ba:
            boolean r5 = r4.hasNext()     // Catch:{ JSONException -> 0x017d }
            if (r5 == 0) goto L_0x00db
            java.lang.Object r5 = r4.next()     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.g r5 = (com.flurry.sdk.C7522g) r5     // Catch:{ JSONException -> 0x017d }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r6.<init>()     // Catch:{ JSONException -> 0x017d }
            java.lang.String r7 = "type"
            int r8 = r5.f14849a     // Catch:{ JSONException -> 0x017d }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r5 = r5.f14850b     // Catch:{ JSONException -> 0x017d }
            m16744a(r6, r2, r5)     // Catch:{ JSONException -> 0x017d }
            r1.put(r6)     // Catch:{ JSONException -> 0x017d }
            goto L_0x00ba
        L_0x00db:
            java.lang.String r2 = "device_ids"
            r10.put(r2, r1)     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.l r1 = r11.f14810j     // Catch:{ JSONException -> 0x017d }
            if (r1 == 0) goto L_0x0127
            com.flurry.sdk.l r1 = r11.f14810j     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.k r1 = r1.f14925a     // Catch:{ JSONException -> 0x017d }
            if (r1 == 0) goto L_0x0127
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r3.<init>()     // Catch:{ JSONException -> 0x017d }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r1.<init>()     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = "latitude"
            com.flurry.sdk.l r4 = r11.f14810j     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.k r4 = r4.f14925a     // Catch:{ JSONException -> 0x017d }
            double r4 = r4.f14899a     // Catch:{ JSONException -> 0x017d }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ JSONException -> 0x017d }
            r1.putOpt(r2, r4)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = "longitude"
            com.flurry.sdk.l r4 = r11.f14810j     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.k r4 = r4.f14925a     // Catch:{ JSONException -> 0x017d }
            double r4 = r4.f14900b     // Catch:{ JSONException -> 0x017d }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ JSONException -> 0x017d }
            r1.putOpt(r2, r4)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = "accuracy"
            com.flurry.sdk.l r4 = r11.f14810j     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.k r4 = r4.f14925a     // Catch:{ JSONException -> 0x017d }
            float r4 = r4.f14901c     // Catch:{ JSONException -> 0x017d }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ JSONException -> 0x017d }
            r1.putOpt(r2, r4)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = "com.flurry.proton.generated.avro.v2.Geolocation"
            r3.put(r2, r1)     // Catch:{ JSONException -> 0x017d }
        L_0x0127:
            java.lang.String r1 = "geo"
            if (r3 == 0) goto L_0x012f
            r10.put(r1, r3)     // Catch:{ JSONException -> 0x017d }
            goto L_0x0134
        L_0x012f:
            java.lang.Object r2 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x017d }
            r10.put(r1, r2)     // Catch:{ JSONException -> 0x017d }
        L_0x0134:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x017d }
            r1.<init>()     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.o r2 = r11.f14811k     // Catch:{ JSONException -> 0x017d }
            java.lang.String r3 = "publisher_user_id"
            if (r2 == 0) goto L_0x014c
            java.lang.String r2 = "string"
            com.flurry.sdk.o r11 = r11.f14811k     // Catch:{ JSONException -> 0x017d }
            java.lang.String r11 = r11.f14966a     // Catch:{ JSONException -> 0x017d }
            m16744a(r1, r2, r11)     // Catch:{ JSONException -> 0x017d }
            r10.put(r3, r1)     // Catch:{ JSONException -> 0x017d }
            goto L_0x0151
        L_0x014c:
            java.lang.Object r11 = org.json.JSONObject.NULL     // Catch:{ JSONException -> 0x017d }
            r10.put(r3, r11)     // Catch:{ JSONException -> 0x017d }
        L_0x0151:
            r11 = 5
            java.lang.String r1 = f14961a     // Catch:{ JSONException -> 0x017d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x017d }
            java.lang.String r3 = "Proton Request String: "
            r2.<init>(r3)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r3 = r10.toString()     // Catch:{ JSONException -> 0x017d }
            r2.append(r3)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x017d }
            com.flurry.sdk.C7513ec.m16639a(r11, r1, r2)     // Catch:{ JSONException -> 0x017d }
            java.lang.String r10 = r10.toString()     // Catch:{ JSONException -> 0x017d }
            byte[] r10 = r10.getBytes()     // Catch:{ JSONException -> 0x017d }
            r0.write(r10)     // Catch:{ JSONException -> 0x017d }
            r0.flush()     // Catch:{ JSONException -> 0x017d }
            r0.close()
            return
        L_0x017b:
            r10 = move-exception
            goto L_0x0186
        L_0x017d:
            r10 = move-exception
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x017b }
            java.lang.String r1 = "Invalid Json"
            r11.<init>(r1, r10)     // Catch:{ all -> 0x017b }
            throw r11     // Catch:{ all -> 0x017b }
        L_0x0186:
            r0.close()
            throw r10
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7564na.mo23856a(java.io.OutputStream, java.lang.Object):void");
    }

    /* renamed from: a */
    private static void m16744a(JSONObject jSONObject, String str, String str2) throws IOException, JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
        throw new IOException("Deserialize not supported for request");
    }
}
