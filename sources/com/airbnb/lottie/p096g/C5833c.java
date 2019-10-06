package com.airbnb.lottie.p096g;

import com.airbnb.lottie.p085a.p087b.C5698a;

/* renamed from: com.airbnb.lottie.g.c */
/* compiled from: LottieValueCallback */
public class C5833c<T> {

    /* renamed from: a */
    private final C5832b<T> f10140a = new C5832b<>();

    /* renamed from: b */
    private C5698a<?, ?> f10141b;

    /* renamed from: c */
    protected T f10142c = null;

    public C5833c(T staticValue) {
        this.f10142c = staticValue;
    }

    /* renamed from: a */
    public T mo18210a(C5832b<T> bVar) {
        return this.f10142c;
    }

    /* renamed from: a */
    public final T mo18209a(float startFrame, float endFrame, T startValue, T endValue, float linearKeyframeProgress, float interpolatedKeyframeProgress, float overallProgress) {
        C5832b<T> bVar = this.f10140a;
        bVar.mo18208a(startFrame, endFrame, startValue, endValue, linearKeyframeProgress, interpolatedKeyframeProgress, overallProgress);
        return mo18210a(bVar);
    }

    /* renamed from: a */
    public final void mo18211a(C5698a<?, ?> animation) {
        this.f10141b = animation;
    }
}
