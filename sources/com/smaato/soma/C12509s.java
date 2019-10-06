package com.smaato.soma;

/* renamed from: com.smaato.soma.s */
/* compiled from: BannerView */
class C12509s extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12513u f38967a;

    C12509s(C12513u this$1) {
        this.f38967a = this$1;
    }

    public Void process() throws Exception {
        this.f38967a.f38972a.getBannerAnimatorHandler().removeCallbacks(this.f38967a.f38972a.f37886v);
        if (this.f38967a.f38972a.mo39230o()) {
            this.f38967a.f38972a.mo39256a();
            C12042D d = this.f38967a.f38972a;
            d.postDelayed(d.f37886v, (long) (this.f38967a.f38972a.f37883s * 1000));
        }
        return null;
    }
}
