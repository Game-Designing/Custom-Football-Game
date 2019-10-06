package com.airbnb.lottie;

import java.util.concurrent.ExecutionException;

/* renamed from: com.airbnb.lottie.E */
/* compiled from: LottieTask */
class C5666E extends Thread {

    /* renamed from: a */
    private boolean f9622a = false;

    /* renamed from: b */
    final /* synthetic */ C5667F f9623b;

    C5666E(C5667F this$0, String x0) {
        this.f9623b = this$0;
        super(x0);
    }

    public void run() {
        while (!isInterrupted() && !this.f9622a) {
            if (this.f9623b.f9629f.isDone()) {
                try {
                    this.f9623b.m9992a((C5664C) this.f9623b.f9629f.get());
                } catch (InterruptedException | ExecutionException e) {
                    this.f9623b.m9992a(new C5664C<>((Throwable) e));
                }
                this.f9622a = true;
                this.f9623b.m10000c();
            }
        }
    }
}
