package com.smaato.soma;

/* renamed from: com.smaato.soma.z */
/* compiled from: BannerView */
class C12523z extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ int f38982a;

    /* renamed from: b */
    final /* synthetic */ C12042D f38983b;

    C12523z(C12042D this$0, int i) {
        this.f38983b = this$0;
        this.f38982a = i;
    }

    public Void process() throws Exception {
        int i = this.f38982a;
        if (i < 10 || i > 600) {
            this.f38983b.f37883s = 60;
        } else {
            this.f38983b.f37883s = i;
        }
        this.f38983b.mo39234p();
        return null;
    }
}
