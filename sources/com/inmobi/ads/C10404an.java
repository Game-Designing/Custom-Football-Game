package com.inmobi.ads;

import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.inmobi.ads.an */
/* compiled from: NativeCtaAsset */
public final class C10404an extends C10436az {

    /* renamed from: com.inmobi.ads.an$a */
    /* compiled from: NativeCtaAsset */
    static class C10405a extends C10437a {
        public C10405a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, int i9, String str5, String[] strArr, C10441ba baVar) {
            String[] strArr2 = strArr;
            super(i, i2, i3, i4, i5, i6, i7, i8, str, str2, str3, str4, baVar);
            this.f31749l = i9;
            this.f31750m = str5.length() == 0 ? "#ff000000" : str5;
            int min = Math.min(strArr2.length, 1);
            this.f31752o = new String[min];
            System.arraycopy(strArr2, 0, this.f31752o, 0, min);
        }
    }

    public C10404an(String str, String str2, C10401al alVar, String str3, int i, JSONObject jSONObject) {
        this(str, str2, alVar, str3, new LinkedList(), i, jSONObject);
    }

    public C10404an(String str, String str2, C10401al alVar, String str3, List<NativeTracker> list, int i, JSONObject jSONObject) {
        super(str, str2, "CTA", alVar, str3);
        mo34088a(list);
        if (jSONObject != null) {
            this.f31616i = i;
            this.f31613f = jSONObject;
        }
    }
}
