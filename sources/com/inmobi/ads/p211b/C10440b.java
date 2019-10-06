package com.inmobi.ads.p211b;

import com.inmobi.ads.C10359a;
import com.inmobi.ads.C10537f;
import com.inmobi.ads.C10595r;
import com.inmobi.ads.p210a.C10362b;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10651g;
import com.inmobi.commons.core.utilities.p224a.C10687b;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.b.b */
/* compiled from: GMARequest */
public final class C10440b {

    /* renamed from: a */
    public C10537f f31758a;

    /* renamed from: b */
    private List<C10359a> f31759b;

    C10440b(C10537f fVar, List<C10359a> list) {
        this.f31758a = fVar;
        this.f31759b = list;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final byte[] mo34143a() throws C10362b, JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("h-user-agent", C10619a.m34848f());
        JSONArray jSONArray = new JSONArray();
        if (this.f31759b != null) {
            C10651g gVar = new C10651g();
            C10641b.m34915a().mo34452a((C10639a) gVar, (C10644c) null);
            for (C10359a aVar : this.f31759b) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("impressionId", aVar.f31481g);
                C10595r rVar = this.f31758a.f32127k;
                float f = aVar.f31485k;
                String a = C10687b.m35078a(String.valueOf(f), rVar.f32277b, rVar.f32276a, rVar.f32278c, gVar.f32467b, gVar.f32466a);
                if (a == null) {
                    a = "";
                }
                jSONObject.put("bid", a);
                JSONObject f2 = aVar.mo33955f();
                if (f2 == null) {
                    f2 = new JSONObject();
                }
                jSONObject.put("cachedAdData", f2);
                jSONArray.put(jSONObject);
            }
        }
        hashMap.put("cachedAdInfos", jSONArray.toString());
        this.f31758a.mo34505c(hashMap);
        this.f31758a.mo34263a();
        C10537f fVar = this.f31758a;
        if (fVar.f32586x == 1) {
            return fVar.mo34508f().getBytes();
        }
        throw new C10362b();
    }
}
