package com.inmobi.ads;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.as */
/* compiled from: NativeImageAsset */
public final class C10414as extends C10400ak {
    C10414as(String str, String str2, C10401al alVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, alVar, str3, new LinkedList(), i, jSONObject);
    }

    C10414as(String str, String str2, C10401al alVar, String str3, List<NativeTracker> list, int i, JSONObject jSONObject) {
        super(str, str2, "IMAGE", alVar, list);
        this.f31612e = str3;
        if (jSONObject != null) {
            this.f31616i = i;
            this.f31613f = jSONObject;
        }
    }
}
