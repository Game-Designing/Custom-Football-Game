package com.airbnb.lottie;

/* renamed from: com.airbnb.lottie.D */
/* compiled from: LottieTask */
class C5665D implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5667F f9621a;

    C5665D(C5667F this$0) {
        this.f9621a = this$0;
    }

    public void run() {
        if (this.f9621a.f9630g != null && !this.f9621a.f9629f.isCancelled()) {
            LottieResult<T> result = this.f9621a.f9630g;
            if (result.mo17867b() != null) {
                this.f9621a.m9996a(result.mo17867b());
            } else {
                this.f9621a.m9997a(result.mo17866a());
            }
        }
    }
}
