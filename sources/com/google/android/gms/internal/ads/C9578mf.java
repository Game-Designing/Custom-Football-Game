package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.mf */
final class C9578mf implements zzaho<zzbgz> {

    /* renamed from: a */
    private final /* synthetic */ C9534kf f22760a;

    C9578mf(C9534kf kfVar) {
        this.f22760a = kfVar;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f22760a) {
                        if (this.f22760a.f22645B != parseInt) {
                            this.f22760a.f22645B = parseInt;
                            this.f22760a.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzbad.m26358c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
