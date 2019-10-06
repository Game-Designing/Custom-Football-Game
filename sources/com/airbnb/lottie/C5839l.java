package com.airbnb.lottie;

import android.util.Log;
import java.util.concurrent.Callable;

/* renamed from: com.airbnb.lottie.l */
/* compiled from: LottieCompositionFactory */
class C5839l implements Callable<C5664C<C5830g>> {

    /* renamed from: a */
    final /* synthetic */ C5830g f10152a;

    C5839l(C5830g gVar) {
        this.f10152a = gVar;
    }

    public C5664C<C5830g> call() {
        Log.d("Gabe", "call\treturning from cache");
        return new C5664C<>(this.f10152a);
    }
}
