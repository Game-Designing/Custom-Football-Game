package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcbd {

    /* renamed from: a */
    private final Executor f26305a;

    /* renamed from: b */
    private final zzcau f26306b;

    public zzcbd(Executor executor, zzcau zzcau) {
        this.f26305a = executor;
        this.f26306b = zzcau;
    }

    /* renamed from: a */
    public final zzbbh<List<zzcbg>> mo31095a(JSONObject jSONObject, String str) {
        Object obj;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzbar.m26376a(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("name");
                if (optString != null) {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        c = 1;
                    } else if ("image".equals(optString2)) {
                        c = 2;
                    } else {
                        c = 0;
                    }
                    if (c == 1) {
                        obj = zzbar.m26376a(new zzcbg(optString, optJSONObject.optString("string_value")));
                    } else if (c == 2) {
                        obj = zzbar.m26380a(this.f26306b.mo31091a(optJSONObject, "image_value"), (zzbam<A, B>) new C9083Qh<A,B>(optString), this.f26305a);
                    }
                    arrayList.add(obj);
                }
            }
            obj = zzbar.m26376a(null);
            arrayList.add(obj);
        }
        return zzbar.m26380a(zzbar.m26382a((Iterable<? extends zzbbh<? extends V>>) arrayList), C9062Ph.f21584a, this.f26305a);
    }
}
