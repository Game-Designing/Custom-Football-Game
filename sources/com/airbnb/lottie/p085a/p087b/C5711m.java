package com.airbnb.lottie.p085a.p087b;

import android.graphics.PointF;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p096g.C5831a;
import java.util.Collections;

/* renamed from: com.airbnb.lottie.a.b.m */
/* compiled from: SplitDimensionPathKeyframeAnimation */
public class C5711m extends C5698a<PointF, PointF> {

    /* renamed from: g */
    private final PointF f9796g = new PointF();

    /* renamed from: h */
    private final C5698a<Float, Float> f9797h;

    /* renamed from: i */
    private final C5698a<Float, Float> f9798i;

    public C5711m(C5698a<Float, Float> xAnimation, C5698a<Float, Float> yAnimation) {
        super(Collections.emptyList());
        this.f9797h = xAnimation;
        this.f9798i = yAnimation;
        mo17950a(mo17954c());
    }

    /* renamed from: a */
    public void mo17950a(float progress) {
        this.f9797h.mo17950a(progress);
        this.f9798i.mo17950a(progress);
        this.f9796g.set(((Float) this.f9797h.mo17955d()).floatValue(), ((Float) this.f9798i.mo17955d()).floatValue());
        for (int i = 0; i < this.f9778a.size(); i++) {
            ((C5699a) this.f9778a.get(i)).mo17932a();
        }
    }

    /* renamed from: d */
    public PointF m10150d() {
        return m10147a(null, 0.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public PointF m10147a(C5831a<PointF> aVar, float keyframeProgress) {
        return this.f9796g;
    }
}
