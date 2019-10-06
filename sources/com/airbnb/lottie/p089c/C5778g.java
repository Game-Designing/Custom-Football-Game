package com.airbnb.lottie.p089c;

import com.airbnb.lottie.C5830g;
import com.mopub.common.Constants;
import p002b.p003c.p053g.p061f.C1260i;

/* renamed from: com.airbnb.lottie.c.g */
/* compiled from: LottieCompositionCache */
public class C5778g {

    /* renamed from: a */
    private static final C5778g f10064a = new C5778g();

    /* renamed from: b */
    private final C1260i<String, C5830g> f10065b = new C1260i<>(Constants.TEN_MB);

    /* renamed from: a */
    public static C5778g m10395a() {
        return f10064a;
    }

    C5778g() {
    }

    /* renamed from: a */
    public C5830g mo18126a(String cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        return (C5830g) this.f10065b.get(cacheKey);
    }

    /* renamed from: a */
    public void mo18127a(String cacheKey, C5830g composition) {
        if (cacheKey != null) {
            this.f10065b.put(cacheKey, composition);
        }
    }
}
