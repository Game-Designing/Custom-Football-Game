package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p089c.p091b.C5737c;
import com.airbnb.lottie.p096g.C5831a;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.d */
/* compiled from: GradientColorKeyframeAnimation */
public class C5702d extends C5704f<C5737c> {

    /* renamed from: g */
    private final C5737c f9784g;

    public C5702d(List<C5831a<C5737c>> keyframes) {
        super(keyframes);
        int size = 0;
        C5737c startValue = (C5737c) ((C5831a) keyframes.get(0)).f10124b;
        if (startValue != null) {
            size = startValue.mo18003c();
        }
        this.f9784g = new C5737c(new float[size], new int[size]);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C5737c m10131a(C5831a<C5737c> keyframe, float keyframeProgress) {
        this.f9784g.mo18000a((C5737c) keyframe.f10124b, (C5737c) keyframe.f10125c, keyframeProgress);
        return this.f9784g;
    }
}
