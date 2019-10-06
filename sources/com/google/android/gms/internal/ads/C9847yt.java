package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* renamed from: com.google.android.gms.internal.ads.yt */
final class C9847yt implements ValueCallback<String> {

    /* renamed from: a */
    private final /* synthetic */ C9826xt f23553a;

    C9847yt(C9826xt xtVar) {
        this.f23553a = xtVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        C9826xt xtVar = this.f23553a;
        xtVar.f23509e.mo32290a(xtVar.f23506b, xtVar.f23507c, str, xtVar.f23508d);
    }
}
