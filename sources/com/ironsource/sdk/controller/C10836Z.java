package com.ironsource.sdk.controller;

import android.text.TextUtils;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;
import p019d.p273h.p285d.p295h.C13001d;

/* renamed from: com.ironsource.sdk.controller.Z */
/* compiled from: IronSourceWebView */
class C10836Z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33063a;

    /* renamed from: b */
    final /* synthetic */ String f33064b;

    /* renamed from: c */
    final /* synthetic */ int f33065c;

    /* renamed from: d */
    final /* synthetic */ boolean f33066d;

    /* renamed from: e */
    final /* synthetic */ int f33067e;

    /* renamed from: f */
    final /* synthetic */ boolean f33068f;

    /* renamed from: g */
    final /* synthetic */ String f33069g;

    /* renamed from: h */
    final /* synthetic */ String f33070h;

    /* renamed from: i */
    final /* synthetic */ C10880c f33071i;

    C10836Z(C10880c this$1, String str, String str2, int i, boolean z, int i2, boolean z2, String str3, String str4) {
        this.f33071i = this$1;
        this.f33063a = str;
        this.f33064b = str2;
        this.f33065c = i;
        this.f33066d = z;
        this.f33067e = i2;
        this.f33068f = z2;
        this.f33069g = str3;
        this.f33070h = str4;
    }

    public void run() {
        if (this.f33063a.equalsIgnoreCase(C10895h.RewardedVideo.toString())) {
            C10877y.this.f33170N.mo41829a(this.f33064b, this.f33065c);
        } else if (this.f33063a.equalsIgnoreCase(C10895h.OfferWall.toString()) && this.f33066d && C10877y.this.f33173Q.onOWAdCredited(this.f33065c, this.f33067e, this.f33068f) && !TextUtils.isEmpty(this.f33069g)) {
            if (C13001d.m42395g().mo41897a(this.f33069g, C10877y.this.f33195r, C10877y.this.f33196s)) {
                C10877y.this.m35491a(this.f33070h, true, (String) null, (String) null);
            } else {
                C10877y.this.m35491a(this.f33070h, false, "Time Stamp could not be stored", (String) null);
            }
        }
    }
}
