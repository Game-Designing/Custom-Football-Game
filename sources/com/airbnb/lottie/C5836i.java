package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: com.airbnb.lottie.i */
/* compiled from: LottieCompositionFactory */
class C5836i implements Callable<C5664C<C5830g>> {

    /* renamed from: a */
    final /* synthetic */ Context f10146a;

    /* renamed from: b */
    final /* synthetic */ String f10147b;

    C5836i(Context context, String str) {
        this.f10146a = context;
        this.f10147b = str;
    }

    public C5664C<C5830g> call() {
        return C5841n.m10583b(this.f10146a, this.f10147b);
    }
}
