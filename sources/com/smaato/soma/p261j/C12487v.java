package com.smaato.soma.p261j;

import com.smaato.soma.C12398ha;
import com.smaato.soma.p239c.p253j.C12285d;

/* renamed from: com.smaato.soma.j.v */
/* compiled from: VASTView */
class C12487v extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12285d f38937a;

    /* renamed from: b */
    final /* synthetic */ int f38938b;

    /* renamed from: c */
    final /* synthetic */ boolean f38939c;

    /* renamed from: d */
    final /* synthetic */ boolean f38940d;

    /* renamed from: e */
    final /* synthetic */ int f38941e;

    /* renamed from: f */
    final /* synthetic */ C12486u f38942f;

    /* renamed from: g */
    final /* synthetic */ C12435D f38943g;

    C12487v(C12435D this$0, C12285d dVar, int i, boolean z, boolean z2, int i2, C12486u uVar) {
        this.f38943g = this$0;
        this.f38937a = dVar;
        this.f38938b = i;
        this.f38939c = z;
        this.f38940d = z2;
        this.f38941e = i2;
        this.f38942f = uVar;
    }

    public Void process() throws Exception {
        this.f38943g.f38820a = this.f38937a;
        this.f38943g.setAutoCloseDuration(this.f38938b);
        this.f38943g.setIsRewardedVideo(this.f38939c);
        this.f38943g.mo39936a(this.f38940d);
        if (!this.f38939c) {
            this.f38943g.f38835p = this.f38941e;
        }
        this.f38943g.setVastAdListener(this.f38942f);
        this.f38943g.m40884m();
        return null;
    }
}
