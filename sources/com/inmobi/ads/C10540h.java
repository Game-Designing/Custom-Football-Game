package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.inmobi.ads.C10455bi;
import com.inmobi.ads.C10458bl.C10460a;
import com.inmobi.ads.C10478c.C10482d;
import com.inmobi.ads.C10531e.C10532a;
import com.inmobi.ads.C10537f;
import com.inmobi.ads.C10545i;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.C10591p;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.cache.AssetStore;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10515b;
import com.inmobi.ads.cache.C10519f;
import com.inmobi.ads.p210a.C10361a;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10699c;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.h */
/* compiled from: AdStore */
public class C10540h implements C10532a {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f32133f = C10540h.class.getSimpleName();
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public final C10544a f32134a;

    /* renamed from: b */
    public final C10528d f32135b;
    /* access modifiers changed from: 0000 */

    /* renamed from: c */
    public C10537f f32136c;

    /* renamed from: d */
    public C10482d f32137d;

    /* renamed from: e */
    long f32138e = 0;

    /* renamed from: g */
    private final C10519f f32139g = new C10519f() {
        /* renamed from: a */
        public final void mo34174a(C10515b bVar) {
            String str;
            C10540h.f32133f;
            StringBuilder sb = new StringBuilder("onAssetsFetchFailure of batch ");
            if (bVar == null) {
                str = null;
            } else {
                str = bVar.toString();
            }
            sb.append(str);
            ArrayList<Long> arrayList = new ArrayList<>();
            if (bVar != null) {
                for (C10513a aVar : bVar.f32065a) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", aVar.f32048d);
                    hashMap.put("latency", Long.valueOf(aVar.f32045a));
                    hashMap.put("size", Long.valueOf(C10699c.m35139a(aVar.f32049e)));
                    C10540h.this.f32134a.mo34276a("VideoAssetDownloadFailed", (Map<String, Object>) hashMap);
                    for (C10359a aVar2 : C10540h.this.f32135b.mo34256b(aVar.f32048d, C10540h.this.f32136c.f32119c)) {
                        if (!arrayList.contains(Long.valueOf(aVar2.f31478d))) {
                            arrayList.add(Long.valueOf(aVar2.f31478d));
                        }
                    }
                }
            }
            if (!arrayList.contains(Long.valueOf(C10540h.this.f32136c.f32117a))) {
                arrayList.add(Long.valueOf(C10540h.this.f32136c.f32117a));
            }
            for (Long longValue : arrayList) {
                C10540h.this.f32134a.mo34275a(longValue.longValue(), false);
            }
        }

        /* renamed from: b */
        public final void mo34175b(C10515b bVar) {
            String str;
            C10540h.f32133f;
            StringBuilder sb = new StringBuilder("onAssetsFetchSuccess of batch ");
            if (bVar == null) {
                str = null;
            } else {
                str = bVar.toString();
            }
            sb.append(str);
            ArrayList<Long> arrayList = new ArrayList<>();
            if (bVar != null) {
                for (C10513a aVar : bVar.f32065a) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", aVar.f32048d);
                    hashMap.put("latency", Long.valueOf(aVar.f32045a));
                    hashMap.put("size", Long.valueOf(C10699c.m35139a(aVar.f32049e)));
                    hashMap.put("clientRequestId", bVar.f32070f);
                    if (aVar.f32054j) {
                        C10540h.this.f32134a.mo34276a("GotCachedVideoAsset", (Map<String, Object>) hashMap);
                    } else {
                        C10540h.this.f32134a.mo34276a("VideoAssetDownloaded", (Map<String, Object>) hashMap);
                    }
                    List<C10359a> a = C10540h.this.f32135b.mo34253a(aVar.f32048d, C10540h.this.f32136c.f32119c);
                    C10540h.f32133f;
                    StringBuilder sb2 = new StringBuilder("Found ");
                    sb2.append(a.size());
                    sb2.append(" ads mapping to this asset");
                    for (C10359a aVar2 : a) {
                        if (!arrayList.contains(Long.valueOf(aVar2.f31478d))) {
                            arrayList.add(Long.valueOf(aVar2.f31478d));
                        }
                    }
                }
            }
            if (!arrayList.contains(Long.valueOf(C10540h.this.f32136c.f32117a))) {
                arrayList.add(Long.valueOf(C10540h.this.f32136c.f32117a));
            }
            for (Long longValue : arrayList) {
                long longValue2 = longValue.longValue();
                C10540h.f32133f;
                StringBuilder sb3 = new StringBuilder("Notifying ad unit with placement ID (");
                sb3.append(longValue2);
                sb3.append(")");
                C10540h.this.f32134a.mo34275a(longValue2, true);
            }
        }
    };

    /* renamed from: com.inmobi.ads.h$a */
    /* compiled from: AdStore */
    public interface C10544a {
        /* renamed from: a */
        void mo33970a(long j, InMobiAdRequestStatus inMobiAdRequestStatus);

        /* renamed from: a */
        void mo34274a(long j, C10359a aVar);

        /* renamed from: a */
        void mo34275a(long j, boolean z);

        /* renamed from: a */
        void mo34276a(String str, Map<String, Object> map);

        /* renamed from: b */
        void mo34277b(long j, C10359a aVar);
    }

    public C10540h(C10544a aVar, C10482d dVar, C10537f fVar) {
        this.f32134a = aVar;
        this.f32135b = C10528d.m34485a();
        this.f32137d = dVar;
        this.f32136c = fVar;
    }

    /* renamed from: a */
    public static void m34534a() {
        if (C10694e.m35112b()) {
            C10528d.m34492c();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo34271b() {
        String a = C10491a.m34325a(this.f32136c.f32123g);
        C10438b.m34171b();
        C10537f fVar = this.f32136c;
        C10359a aVar = null;
        if (C10528d.m34482a(fVar.f32117a, fVar.f32119c, fVar.f32126j, a) != 0) {
            C10528d dVar = this.f32135b;
            C10537f fVar2 = this.f32136c;
            C10359a b = dVar.mo34255b(fVar2.f32117a, fVar2.f32119c, fVar2.f32126j, a);
            if (b != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("clientRequestId", b.f31482h);
                hashMap.put("im-accid", C10619a.m34847e());
                hashMap.put("isPreloaded", this.f32136c.mo34265c());
                this.f32134a.mo34276a("AdCacheHit", (Map<String, Object>) hashMap);
                mo34268a(this.f32136c);
                aVar = b;
            }
        }
        if (aVar != null) {
            String str = aVar.f31482h;
            this.f32134a.mo34274a(this.f32136c.f32117a, aVar);
            if (!"INMOBIJSON".equalsIgnoreCase(aVar.mo33954e())) {
                return str;
            }
            mo34270a((List<C10359a>) new ArrayList<C10359a>(Collections.singletonList(aVar)));
            return str;
        } else if (this.f32136c.mo34265c().equals("1")) {
            return mo34266a(this.f32136c, true);
        } else {
            return mo34266a(this.f32136c, false);
        }
    }

    /* renamed from: b */
    private static void m34538b(C10537f fVar, boolean z) {
        if (fVar != null) {
            Map<String, String> map = fVar.f32124h;
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("preload-request", String.valueOf(z ? 1 : 0));
            fVar.f32124h = map;
        }
    }

    /* renamed from: c */
    public static void m34541c() {
        C10438b.m34171b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34267a(final C10359a aVar) {
        new Thread() {
            public final void run() {
                C10540h.this.f32135b;
                C10528d.m34483a(aVar);
            }
        }.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34269a(final String str) {
        new Thread() {
            public final void run() {
                C10540h.this.f32135b;
                C10528d.m34484a(str);
            }
        }.start();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo34266a(C10537f fVar, boolean z) {
        m34538b(fVar, z);
        this.f32138e = SystemClock.elapsedRealtime();
        new C10531e(fVar, this).mo34260a();
        HashMap hashMap = new HashMap();
        hashMap.put("isPreloaded", fVar.mo34265c());
        hashMap.put("clientRequestId", fVar.f32125i);
        hashMap.put("im-accid", C10619a.m34847e());
        this.f32134a.mo34276a("ServerCallInitiated", (Map<String, Object>) hashMap);
        return fVar.f32125i;
    }

    /* renamed from: a */
    private void m34536a(List<C10359a> list, String str, String str2) {
        C10528d dVar = this.f32135b;
        C10537f fVar = this.f32136c;
        dVar.mo34254a(list, fVar.f32117a, this.f32137d.f31923a, fVar.f32121e, fVar.f32126j, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m34535a(java.util.List<com.inmobi.ads.C10359a> r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = 0
            java.lang.Object r1 = r10.get(r0)
            com.inmobi.ads.a r1 = (com.inmobi.ads.C10359a) r1
            java.lang.String r2 = r1.mo33954e()
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r2 = r2.toUpperCase(r3)
            int r3 = r2.hashCode()
            r4 = -598127114(0xffffffffdc594df6, float:-2.44663156E17)
            r5 = 1
            if (r3 == r4) goto L_0x002b
            r4 = 2228139(0x21ffab, float:3.122288E-39)
            if (r3 == r4) goto L_0x0021
        L_0x0020:
            goto L_0x0035
        L_0x0021:
            java.lang.String r3 = "HTML"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0020
            r2 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "INMOBIJSON"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0020
            r2 = 1
            goto L_0x0036
        L_0x0035:
            r2 = -1
        L_0x0036:
            r3 = 0
            java.lang.String r4 = "native"
            if (r2 == 0) goto L_0x0092
            if (r2 == r5) goto L_0x003e
            return
        L_0x003e:
            r9.m34536a(r10, r11, r3)
            com.inmobi.ads.f r2 = r9.f32136c
            java.lang.String r2 = r2.f32121e
            java.lang.String r3 = "int"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0057
            com.inmobi.ads.h$a r11 = r9.f32134a
            com.inmobi.ads.f r0 = r9.f32136c
            long r2 = r0.f32117a
            r11.mo34277b(r2, r1)
            goto L_0x008e
        L_0x0057:
            com.inmobi.ads.f r2 = r9.f32136c
            java.lang.String r2 = r2.f32121e
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x008e
            com.inmobi.ads.d r3 = r9.f32135b
            com.inmobi.ads.f r2 = r9.f32136c
            long r4 = r2.f32117a
            java.lang.String r6 = r2.f32119c
            com.inmobi.ads.InMobiAdRequest$MonetizationContext r7 = r2.f32126j
            r8 = r11
            com.inmobi.ads.a r11 = r3.mo34255b(r4, r6, r7, r8)
            if (r11 == 0) goto L_0x007f
            boolean r1 = r1.mo33950a(r11)
            if (r1 != 0) goto L_0x007e
            r10.add(r0, r11)
        L_0x007e:
            goto L_0x0080
        L_0x007f:
            r11 = r1
        L_0x0080:
            com.inmobi.ads.h$a r0 = r9.f32134a
            com.inmobi.ads.f r1 = r9.f32136c
            long r1 = r1.f32117a
            r0.mo34274a(r1, r11)
            com.inmobi.ads.f r11 = r9.f32136c
            r9.mo34268a(r11)
        L_0x008e:
            r9.mo34270a(r10)
            return
        L_0x0092:
            com.inmobi.ads.f r0 = r9.f32136c
            java.lang.String r0 = r0.f32121e
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x00ad
            com.inmobi.ads.h$a r10 = r9.f32134a
            com.inmobi.ads.f r11 = r9.f32136c
            long r0 = r11.f32117a
            com.inmobi.ads.InMobiAdRequestStatus r11 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r2 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r11.<init>(r2)
            r10.mo33970a(r0, r11)
            return
        L_0x00ad:
            int r0 = r10.size()
            java.util.List r10 = r10.subList(r5, r0)
            r9.m34536a(r10, r11, r3)
            com.inmobi.ads.h$a r10 = r9.f32134a
            com.inmobi.ads.f r11 = r9.f32136c
            long r2 = r11.f32117a
            r10.mo34274a(r2, r1)
            com.inmobi.ads.f r10 = r9.f32136c
            r9.mo34268a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10540h.m34535a(java.util.List, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m34539b(java.util.List<com.inmobi.ads.C10359a> r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            r6.m34536a(r7, r8, r9)
            com.inmobi.ads.f r8 = r6.f32136c
            java.lang.String r8 = r8.f32121e
            com.inmobi.ads.C10438b.m34171b()
            com.inmobi.ads.a r8 = com.inmobi.ads.C10528d.m34491c(r9)
            if (r8 != 0) goto L_0x0023
            com.inmobi.ads.h$a r7 = r6.f32134a
            com.inmobi.ads.f r8 = r6.f32136c
            long r8 = r8.f32117a
            com.inmobi.ads.InMobiAdRequestStatus r0 = new com.inmobi.ads.InMobiAdRequestStatus
            com.inmobi.ads.InMobiAdRequestStatus$StatusCode r1 = com.inmobi.ads.InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR
            r0.<init>(r1)
            r7.mo33970a(r8, r0)
            return
        L_0x0023:
            java.lang.String r0 = r8.mo33954e()
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r1)
            int r1 = r0.hashCode()
            r2 = -598127114(0xffffffffdc594df6, float:-2.44663156E17)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x0049
            r2 = 2228139(0x21ffab, float:3.122288E-39)
            if (r1 == r2) goto L_0x003f
        L_0x003e:
            goto L_0x0053
        L_0x003f:
            java.lang.String r1 = "HTML"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "INMOBIJSON"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = -1
        L_0x0054:
            if (r0 == 0) goto L_0x00c4
            if (r0 == r5) goto L_0x0059
            return
        L_0x0059:
            com.inmobi.ads.f r0 = r6.f32136c
            java.lang.String r0 = r0.f32121e
            int r1 = r0.hashCode()
            r2 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r1 == r2) goto L_0x0076
            r2 = 104431(0x197ef, float:1.46339E-40)
            if (r1 == r2) goto L_0x006c
        L_0x006b:
            goto L_0x007f
        L_0x006c:
            java.lang.String r1 = "int"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r3 = 0
            goto L_0x007f
        L_0x0076:
            java.lang.String r1 = "native"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r3 = 1
        L_0x007f:
            if (r3 == 0) goto L_0x0096
            if (r3 == r5) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            com.inmobi.ads.C10528d.m34484a(r9)
            com.inmobi.ads.h$a r9 = r6.f32134a
            com.inmobi.ads.f r0 = r6.f32136c
            long r0 = r0.f32117a
            r9.mo34274a(r0, r8)
            com.inmobi.ads.f r9 = r6.f32136c
            r6.mo34268a(r9)
            goto L_0x00a0
        L_0x0096:
            com.inmobi.ads.h$a r9 = r6.f32134a
            com.inmobi.ads.f r0 = r6.f32136c
            long r0 = r0.f32117a
            r9.mo34277b(r0, r8)
        L_0x00a0:
            java.util.Iterator r9 = r7.iterator()
        L_0x00a5:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00bb
            java.lang.Object r0 = r9.next()
            com.inmobi.ads.a r0 = (com.inmobi.ads.C10359a) r0
            boolean r0 = r8.mo33950a(r0)
            if (r0 == 0) goto L_0x00ba
            r4 = 1
            goto L_0x00bb
        L_0x00ba:
            goto L_0x00a5
        L_0x00bb:
            if (r4 != 0) goto L_0x00c0
            r7.add(r8)
        L_0x00c0:
            r6.mo34270a(r7)
            return
        L_0x00c4:
            com.inmobi.ads.C10528d.m34484a(r9)
            com.inmobi.ads.h$a r7 = r6.f32134a
            com.inmobi.ads.f r9 = r6.f32136c
            long r0 = r9.f32117a
            r7.mo34274a(r0, r8)
            com.inmobi.ads.f r7 = r6.f32136c
            r6.mo34268a(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10540h.m34539b(java.util.List, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public final void mo34172a(C10538g gVar) {
        StringBuilder sb = new StringBuilder();
        List<C10359a> a = m34533a(gVar, sb);
        String sb2 = sb.toString();
        boolean isEmpty = TextUtils.isEmpty(sb2);
        if (a == null) {
            new StringBuilder("Could not parse ad response:").append(gVar.f32129a.mo34511b());
            this.f32134a.mo33970a(this.f32136c.f32117a, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            return;
        }
        String str = "im-accid";
        String str2 = "isPreloaded";
        String str3 = "latency";
        if (a.size() != 0 || !isEmpty) {
            HashMap hashMap = new HashMap();
            hashMap.put("numberOfAdsReturned", Integer.valueOf(a.size()));
            hashMap.put(str3, Long.valueOf(SystemClock.elapsedRealtime() - this.f32138e));
            hashMap.put(str2, this.f32136c.mo34265c());
            hashMap.put(str, C10619a.m34847e());
            this.f32134a.mo34276a("ServerFill", (Map<String, Object>) hashMap);
            for (C10359a aVar : a) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ts", Long.valueOf(System.currentTimeMillis()));
                hashMap2.put("impId", aVar.f31481g);
                hashMap2.put("plId", Long.valueOf(aVar.f31478d));
                this.f32134a.mo34276a("AdCacheImpressionInserted", (Map<String, Object>) hashMap2);
            }
            String a2 = C10491a.m34325a(this.f32136c.f32123g);
            if (isEmpty) {
                m34535a(a, a2);
            } else {
                m34539b(a, a2, sb2);
            }
        } else {
            new StringBuilder("Ad response received but no ad available:").append(gVar.f32129a.mo34511b());
            HashMap hashMap3 = new HashMap();
            hashMap3.put(str3, Long.valueOf(SystemClock.elapsedRealtime() - this.f32138e));
            hashMap3.put(str2, this.f32136c.mo34265c());
            hashMap3.put(str, C10619a.m34847e());
            this.f32134a.mo34276a("ServerNoFill", (Map<String, Object>) hashMap3);
            this.f32134a.mo33970a(this.f32136c.f32117a, new InMobiAdRequestStatus(StatusCode.NO_FILL));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34270a(List<C10359a> list) {
        if (list != null && list.size() > 0) {
            C10359a aVar = (C10359a) list.get(0);
            if (aVar != null) {
                Set d = aVar.mo33953d();
                if (d.size() == 0) {
                    this.f32134a.mo34275a(this.f32136c.f32117a, true);
                    return;
                } else {
                    AssetStore.m34369a().mo34224a(new C10515b(UUID.randomUUID().toString(), aVar.f31482h, d, this.f32139g));
                }
            }
            for (C10359a aVar2 : list.subList(1, list.size())) {
                if (aVar2 != null) {
                    Set d2 = aVar2.mo33953d();
                    if (d2.size() != 0) {
                        AssetStore.m34369a().mo34224a(new C10515b(UUID.randomUUID().toString(), aVar2.f31482h, d2, (C10519f) null));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private List<C10359a> m34533a(C10538g gVar, StringBuilder sb) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(gVar.f32129a.mo34511b());
            sb.append(jSONObject.optString("winnerImpressionId").trim());
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            if (jSONArray != null) {
                int min = Math.min(gVar.f32131c.f32120d, jSONArray.length());
                for (int i = 0; i < min; i++) {
                    C10359a a = C10360a.m33813a(jSONArray.getJSONObject(i), gVar.f32131c.f32117a, gVar.f32131c.f32121e, gVar.f32131c.f32119c, gVar.f32131c.f32125i, gVar.f32131c.f32126j, gVar.f32131c.f32127k);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (min <= 0 || !arrayList.isEmpty()) {
                    return arrayList;
                }
                return null;
            }
        } catch (JSONException e) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", "ParsingError");
            hashMap.put("reason", e.getLocalizedMessage());
            hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f32138e));
            hashMap.put("im-accid", C10619a.m34847e());
            this.f32134a.mo34276a("ServerError", (Map<String, Object>) hashMap);
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: b */
    public final void mo34173b(C10538g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", String.valueOf(gVar.f32129a.f32591b.f32552a.getValue()));
        hashMap.put("reason", gVar.f32129a.f32591b.f32553b);
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f32138e));
        hashMap.put("im-accid", C10619a.m34847e());
        this.f32134a.mo34276a("ServerError", (Map<String, Object>) hashMap);
        this.f32134a.mo33970a(this.f32136c.f32117a, gVar.f32130b);
    }

    /* renamed from: a */
    public final void mo34268a(C10537f fVar) {
        C10438b.m34171b();
        int a = C10528d.m34482a(fVar.f32117a, fVar.f32119c, fVar.f32126j, C10491a.m34325a(fVar.f32123g));
        boolean equals = "int".equals(fVar.f32121e);
        if (a < this.f32137d.f31925c) {
            new StringBuilder("Cached ad count below threshold, firing ad request for Placement : ").append(fVar.f32117a);
            C10491a a2 = C10491a.m34323a(fVar.f32121e);
            if (equals) {
                m34538b(fVar, true);
                try {
                    new C10458bl(new C10460a(fVar) {

                        /* renamed from: a */
                        final /* synthetic */ C10537f f31991a;

                        {
                            this.f31991a = r2;
                        }

                        /* renamed from: a */
                        public final void mo34176a(long j) {
                            C10491a.f31977d;
                        }

                        /* renamed from: b */
                        public final void mo34178b(long j, InMobiAdRequestStatus inMobiAdRequestStatus) {
                            C10491a.f31977d;
                            new StringBuilder("Interstitial Prefetch failed with the message - ").append(inMobiAdRequestStatus.getMessage());
                        }

                        /* renamed from: a */
                        public final void mo34177a(String str, Map<String, Object> map) {
                            C10491a.m34327a(str, map, this.f31991a);
                        }
                    }, this.f32137d).mo34171a(fVar, true, C10491a.f31976b.f31891c);
                } catch (C10361a e) {
                    e.getMessage();
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(fVar) {

                    /* renamed from: a */
                    final /* synthetic */ C10537f f31988a;

                    /* renamed from: c */
                    private C10578e f31990c;

                    {
                        this.f31988a = r2;
                    }

                    public final void run() {
                        try {
                            Context b = C10619a.m34839b();
                            if (b != null) {
                                C10455bi a = C10455bi.m34229a(this.f31988a.f32117a, this.f31988a.f32123g, this.f31988a.f32121e, this.f31988a.f32122f);
                                a.f31806f = this.f31988a.f32126j;
                                C10491a.f31977d;
                                StringBuilder sb = new StringBuilder("preFetchAdUnit. pid:");
                                sb.append(a.f31801a);
                                sb.append(" tp:");
                                sb.append(a.f31802b);
                                if (a.f31803c == null && a.f31802b != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("tp", a.f31802b);
                                    a.f31803c = hashMap;
                                }
                                this.f31990c = new C10499a(a);
                                C10545i a2 = C10491a.m34328b(C10491a.this.f31984c, b, a);
                                if (a2 != null) {
                                    a2.f32169e = a.f31804d;
                                    a2.f32170f = a.f31803c;
                                    a2.f32178n = true;
                                    a2.f32181q = this.f31990c;
                                    if (C10491a.this.f31984c.equalsIgnoreCase("banner")) {
                                        ((C10591p) a2).f32267A = this.f31988a.f32119c;
                                        ((C10591p) a2).f32270y = true;
                                    }
                                    a2.mo34081a(true);
                                }
                            }
                        } catch (Exception e) {
                            C10491a.f31977d;
                            new StringBuilder("SDK encountered an unexpected error preloading ad units; ").append(e.getMessage());
                            C10621a.m34854a().mo34423a(new C10658a(e));
                        }
                    }
                });
            }
        }
    }
}
