package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: com.airbnb.lottie.j */
/* compiled from: LottieCompositionFactory */
class C5837j implements Callable<C5664C<C5830g>> {

    /* renamed from: a */
    final /* synthetic */ Context f10148a;

    /* renamed from: b */
    final /* synthetic */ int f10149b;

    C5837j(Context context, int i) {
        this.f10148a = context;
        this.f10149b = i;
    }

    public C5664C<C5830g> call() {
        return C5841n.m10582b(this.f10148a, this.f10149b);
    }
}
