package com.airbnb.lottie;

import android.util.JsonReader;
import java.util.concurrent.Callable;

/* renamed from: com.airbnb.lottie.k */
/* compiled from: LottieCompositionFactory */
class C5838k implements Callable<C5664C<C5830g>> {

    /* renamed from: a */
    final /* synthetic */ JsonReader f10150a;

    /* renamed from: b */
    final /* synthetic */ String f10151b;

    C5838k(JsonReader jsonReader, String str) {
        this.f10150a = jsonReader;
        this.f10151b = str;
    }

    public C5664C<C5830g> call() {
        return C5841n.m10584b(this.f10150a, this.f10151b);
    }
}
