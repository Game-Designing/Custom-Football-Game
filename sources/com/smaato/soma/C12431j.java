package com.smaato.soma;

import com.mopub.common.AdType;
import com.vungle.warren.model.Advertisement;

/* renamed from: com.smaato.soma.j */
/* compiled from: AdType */
public enum C12431j {
    DISPLAY("display"),
    IMAGE("img"),
    RICH_MEDIA("richmedia"),
    VIDEO(Advertisement.KEY_VIDEO),
    MULTI_AD_FORMAT_INTERSTITIAL(AdType.INTERSTITIAL),
    NATIVE("native"),
    REWARDED("rewarded"),
    f38814h(r9);
    

    /* renamed from: j */
    private final String f38816j;

    private C12431j(String type) {
        this.f38816j = type;
    }

    /* renamed from: f */
    public String mo39934f() {
        return this.f38816j;
    }

    /* renamed from: e */
    public String mo39933e() {
        if (this == RICH_MEDIA || this == IMAGE) {
            return DISPLAY.f38816j;
        }
        return this.f38816j;
    }

    /* renamed from: g */
    public boolean mo39935g() {
        return this == VIDEO || this == REWARDED || this == f38814h;
    }
}
