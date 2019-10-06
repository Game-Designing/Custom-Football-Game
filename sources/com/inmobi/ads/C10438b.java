package com.inmobi.ads;

import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p222e.C10659b;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.b */
/* compiled from: AdCacheStateReporter */
public class C10438b {
    /* renamed from: a */
    public static void m34168a() {
        C10478c cVar = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) null);
        m34169a(cVar);
        JSONArray jSONArray = new JSONArray();
        C10528d.m34485a();
        m34170a(cVar, jSONArray, C10528d.m34489b());
        if (jSONArray.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("adsArray", jSONArray.toString());
            String str = "ads";
            C10659b.m34983a().mo34486a(str, cVar.f31900l);
            C10659b.m34983a();
            C10659b.m34987a(str, "AdCacheCachedAds", hashMap);
            return;
        }
        C10438b.class.getName();
    }

    /* renamed from: b */
    public static void m34171b() {
        C10478c cVar = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) null);
        m34169a(cVar);
    }

    /* renamed from: a */
    private static void m34169a(C10478c cVar) {
        String[] strArr = {"banner", "int", "native"};
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            C10528d.m34485a();
            m34170a(cVar, jSONArray, C10528d.m34487a(str, cVar.mo34203a(str).f31926d));
        }
        if (jSONArray.length() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("adsArray", jSONArray.toString());
            String str2 = "ads";
            C10659b.m34983a().mo34486a(str2, cVar.f31900l);
            C10659b.m34983a();
            C10659b.m34987a(str2, "AdCacheAdExpired", hashMap);
            return;
        }
        C10438b.class.getName();
    }

    /* renamed from: a */
    private static void m34170a(C10478c cVar, JSONArray jSONArray, List<C10359a> list) {
        for (C10359a aVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("impId", aVar.f31481g);
                jSONObject.put("plId", aVar.f31478d);
                jSONObject.put("insTs", aVar.f31479e);
                jSONObject.put("expTs", aVar.mo33952c());
                jSONObject.put("expiryDuration", aVar.f31480f);
                jSONObject.put("configTTL", TimeUnit.SECONDS.toMillis(cVar.mo34203a(aVar.f31476b).f31926d));
                jSONObject.put("adType", aVar.f31476b);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                C10438b.class.getName();
            }
        }
    }

    /* renamed from: c */
    public static void m34172c() {
        C10478c cVar = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) null);
        if (cVar.f31903o) {
            C10528d.m34485a();
            C10528d.m34492c();
        }
    }
}
