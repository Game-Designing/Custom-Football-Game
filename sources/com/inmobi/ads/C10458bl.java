package com.inmobi.ads;

import android.os.SystemClock;
import com.inmobi.ads.C10478c.C10482d;
import com.inmobi.ads.C10531e.C10532a;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.cache.AssetStore;
import com.inmobi.ads.cache.C10513a;
import com.inmobi.ads.cache.C10515b;
import com.inmobi.ads.cache.C10519f;
import com.inmobi.ads.p210a.C10361a;
import com.inmobi.ads.p212c.C10491a;
import com.inmobi.commons.core.utilities.C10699c;
import com.inmobi.commons.core.utilities.p225b.C10694e;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.bl */
/* compiled from: PrefetchAdStore */
public class C10458bl implements C10532a {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f31813c = C10458bl.class.getSimpleName();

    /* renamed from: a */
    boolean f31814a = false;

    /* renamed from: b */
    C10482d f31815b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C10460a f31816d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C10528d f31817e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C10537f f31818f;

    /* renamed from: g */
    private long f31819g = 0;

    /* renamed from: h */
    private boolean f31820h;

    /* renamed from: i */
    private final C10519f f31821i = new C10519f() {
        /* renamed from: a */
        public final void mo34174a(C10515b bVar) {
            String str;
            C10458bl.f31813c;
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
                    C10458bl.this.f31816d.mo34177a("VideoAssetDownloadFailed", hashMap);
                    for (C10359a aVar2 : C10458bl.this.f31817e.mo34256b(aVar.f32048d, C10458bl.this.f31818f == null ? null : C10458bl.this.f31818f.f32119c)) {
                        if (!arrayList.contains(Long.valueOf(aVar2.f31478d))) {
                            arrayList.add(Long.valueOf(aVar2.f31478d));
                        }
                    }
                }
            }
            if (!arrayList.contains(Long.valueOf(C10458bl.this.f31818f.f32117a))) {
                arrayList.add(Long.valueOf(C10458bl.this.f31818f.f32117a));
            }
            for (Long longValue : arrayList) {
                C10458bl.this.f31816d.mo34178b(longValue.longValue(), new InMobiAdRequestStatus(StatusCode.AD_NO_LONGER_AVAILABLE));
            }
        }

        /* renamed from: b */
        public final void mo34175b(C10515b bVar) {
            String str;
            C10458bl.f31813c;
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
                        C10458bl.this.f31816d.mo34177a("GotCachedVideoAsset", hashMap);
                    } else {
                        C10458bl.this.f31816d.mo34177a("VideoAssetDownloaded", hashMap);
                    }
                    List<C10359a> a = C10458bl.this.f31817e.mo34253a(aVar.f32048d, C10458bl.this.f31818f == null ? null : C10458bl.this.f31818f.f32119c);
                    C10458bl.f31813c;
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
            if (!arrayList.contains(Long.valueOf(C10458bl.this.f31818f.f32117a))) {
                arrayList.add(Long.valueOf(C10458bl.this.f31818f.f32117a));
            }
            for (Long longValue : arrayList) {
                long longValue2 = longValue.longValue();
                C10458bl.f31813c;
                StringBuilder sb3 = new StringBuilder("Notifying ad unit with placement ID (");
                sb3.append(longValue2);
                sb3.append(")");
                C10458bl.this.f31816d.mo34176a(longValue2);
            }
        }
    };

    /* renamed from: com.inmobi.ads.bl$a */
    /* compiled from: PrefetchAdStore */
    public interface C10460a {
        /* renamed from: a */
        void mo34176a(long j);

        /* renamed from: a */
        void mo34177a(String str, Map<String, Object> map);

        /* renamed from: b */
        void mo34178b(long j, InMobiAdRequestStatus inMobiAdRequestStatus);
    }

    public C10458bl(C10460a aVar, C10482d dVar) {
        this.f31816d = aVar;
        this.f31817e = C10528d.m34485a();
        this.f31815b = dVar;
    }

    /* renamed from: a */
    private String m34238a(C10537f fVar) {
        String str = "1";
        if (fVar != null) {
            Map<String, String> map = fVar.f32124h;
            if (map == null) {
                map = new HashMap<>();
            }
            String str2 = "preload-request";
            if (!map.containsKey(str2)) {
                map.put(str2, str);
                fVar.f32124h = map;
            }
        }
        this.f31819g = SystemClock.elapsedRealtime();
        new C10531e(fVar, this).mo34260a();
        HashMap hashMap = new HashMap();
        hashMap.put("isPreloaded", str);
        hashMap.put("clientRequestId", fVar.f32125i);
        hashMap.put("im-accid", C10619a.m34847e());
        this.f31816d.mo34177a("ServerCallInitiated", hashMap);
        return fVar.f32125i;
    }

    /* renamed from: a */
    private boolean m34240a(int i) {
        return SystemClock.elapsedRealtime() - this.f31819g < ((long) (i * 1000));
    }

    /* renamed from: a */
    public final void mo34172a(C10538g gVar) {
        List c = m34243c(gVar);
        if (c == null) {
            new StringBuilder("Could not parse ad response:").append(gVar.f32129a.mo34511b());
            if (!this.f31814a) {
                this.f31816d.mo34178b(this.f31818f.f32117a, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
            }
            return;
        }
        String str = "im-accid";
        String str2 = "1";
        String str3 = "isPreloaded";
        String str4 = "latency";
        if (c.size() == 0) {
            new StringBuilder("Ad response received but no ad available:").append(gVar.f32129a.mo34511b());
            HashMap hashMap = new HashMap();
            hashMap.put(str4, Long.valueOf(SystemClock.elapsedRealtime() - this.f31819g));
            hashMap.put(str3, str2);
            hashMap.put(str, C10619a.m34847e());
            this.f31816d.mo34177a("ServerNoFill", hashMap);
            if (!this.f31814a) {
                this.f31816d.mo34178b(this.f31818f.f32117a, new InMobiAdRequestStatus(StatusCode.NO_FILL));
            }
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("numberOfAdsReturned", Integer.valueOf(c.size()));
        hashMap2.put(str4, Long.valueOf(SystemClock.elapsedRealtime() - this.f31819g));
        hashMap2.put(str3, str2);
        hashMap2.put(str, C10619a.m34847e());
        this.f31816d.mo34177a("ServerFill", hashMap2);
        if ("HTML".equalsIgnoreCase(((C10359a) c.get(0)).mo33954e())) {
            if ("native".equals(this.f31818f.f32121e)) {
                if (!this.f31814a) {
                    this.f31816d.mo34178b(this.f31818f.f32117a, new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                }
                return;
            }
        }
        C10528d dVar = this.f31817e;
        C10537f fVar = this.f31818f;
        dVar.mo34254a(c, fVar.f32117a, this.f31815b.f31923a, fVar.f32121e, fVar.f32126j, C10491a.m34325a(fVar.f32123g), null);
        m34239a(c);
        if (!this.f31814a && !this.f31820h) {
            this.f31816d.mo34176a(this.f31818f.f32117a);
        }
    }

    /* renamed from: b */
    public final void mo34173b(C10538g gVar) {
        if (!this.f31814a) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", String.valueOf(gVar.f32129a.f32591b.f32552a.getValue()));
            hashMap.put("reason", gVar.f32129a.f32591b.f32553b);
            hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f31819g));
            hashMap.put("isPreloaded", "1");
            hashMap.put("im-accid", C10619a.m34847e());
            this.f31816d.mo34177a("ServerError", hashMap);
            this.f31816d.mo34178b(this.f31818f.f32117a, gVar.f32130b);
        }
    }

    /* renamed from: c */
    private List<C10359a> m34243c(C10538g gVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(gVar.f32129a.mo34511b()).getJSONArray("ads");
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
            hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.f31819g));
            hashMap.put("isPreloaded", "1");
            hashMap.put("im-accid", C10619a.m34847e());
            this.f31816d.mo34177a("ServerError", hashMap);
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m34239a(List<C10359a> list) {
        if (list != null && list.size() > 0) {
            C10359a aVar = (C10359a) list.get(0);
            if (aVar != null) {
                Set d = aVar.mo33953d();
                if (d.size() == 0) {
                    this.f31816d.mo34176a(this.f31818f.f32117a);
                    return;
                }
                AssetStore.m34369a().mo34224a(new C10515b(UUID.randomUUID().toString(), aVar.f31482h, d, this.f31820h ? this.f31821i : null));
            }
            for (C10359a aVar2 : list.subList(1, list.size())) {
                if (aVar2 != null && aVar2.mo33954e().equalsIgnoreCase("inmobiJson")) {
                    Set d2 = aVar2.mo33953d();
                    if (d2.size() != 0) {
                        AssetStore.m34369a().mo34224a(new C10515b(UUID.randomUUID().toString(), aVar2.f31482h, d2, (C10519f) null));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final String mo34171a(C10537f fVar, boolean z, int i) throws C10361a {
        String str;
        if (C10694e.m35112b()) {
            C10528d.m34492c();
        }
        this.f31814a = false;
        this.f31818f = fVar;
        this.f31820h = z;
        C10438b.m34171b();
        C10528d dVar = this.f31817e;
        C10537f fVar2 = this.f31818f;
        List c = dVar.mo34257c(fVar2.f32117a, fVar2.f32119c, fVar2.f32126j, C10491a.m34325a(fVar2.f32123g));
        int size = c.size();
        String str2 = "Ignoring request to fetch an ad from the network sooner than the minimum request interval";
        if (size == 0) {
            this.f31814a = false;
            if (!m34240a(i)) {
                return m34238a(this.f31818f);
            }
            throw new C10361a(str2);
        }
        if (size < this.f31815b.f31925c) {
            this.f31814a = true;
            if (!z) {
                this.f31816d.mo34176a(this.f31818f.f32117a);
            }
            m34239a(c);
            if (!m34240a(i)) {
                str = m34238a(this.f31818f);
            } else {
                throw new C10361a(str2);
            }
        } else {
            this.f31814a = true;
            String str3 = ((C10359a) c.get(0)).f31482h;
            if (!z) {
                this.f31816d.mo34176a(this.f31818f.f32117a);
            }
            m34239a(c);
            str = str3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("im-accid", C10619a.m34847e());
        hashMap.put("isPreloaded", "1");
        this.f31816d.mo34177a("AdCacheAdRequested", hashMap);
        return str;
    }
}
