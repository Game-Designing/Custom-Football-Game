package com.ironsource.sdk.controller;

import android.location.Location;
import com.ironsource.sdk.controller.C10877y.C10880c;
import p019d.p273h.p274a.C12727e.C12728a;

/* renamed from: com.ironsource.sdk.controller.W */
/* compiled from: IronSourceWebView */
class C10833W implements C12728a {

    /* renamed from: a */
    final /* synthetic */ String f33056a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33057b;

    C10833W(C10880c this$1, String str) {
        this.f33057b = this$1;
        this.f33056a = str;
    }

    public void onLocationChanged(Location location) {
        C10877y.this.m35491a(C10877y.this.m35474a(this.f33056a, location).toString(), true, (String) null, (String) null);
    }
}
