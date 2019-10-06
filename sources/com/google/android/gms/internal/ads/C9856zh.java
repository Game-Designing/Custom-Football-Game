package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.zh */
final /* synthetic */ class C9856zh implements zzaho {

    /* renamed from: a */
    private final zzbzt f23739a;

    C9856zh(zzbzt zzbzt) {
        this.f23739a = zzbzt;
    }

    /* renamed from: a */
    public final void mo27996a(Object obj, Map map) {
        zzbgz zzbgz = (zzbgz) obj;
        zzbgz.mo28714a().mo30597a((zzbij) new C8789Ch(this.f23739a, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbgz.loadData(str, "text/html", "UTF-8");
        } else {
            zzbgz.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
