package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads._e */
final class C9292_e implements zzaho<zzbgz> {

    /* renamed from: a */
    private final /* synthetic */ C9251Ye f22043a;

    C9292_e(C9251Ye ye) {
        this.f22043a = ye;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f22043a) {
                        if (this.f22043a.f21946D != parseInt) {
                            this.f22043a.f21946D = parseInt;
                            this.f22043a.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzbad.m26358c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
