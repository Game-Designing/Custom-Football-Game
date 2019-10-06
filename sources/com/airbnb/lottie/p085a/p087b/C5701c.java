package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.c */
/* compiled from: FloatKeyframeAnimation */
public class C5701c extends C5704f<Float> {
    public C5701c(List<C5831a<Float>> keyframes) {
        super(keyframes);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Float m10129a(C5831a<Float> keyframe, float keyframeProgress) {
        if (keyframe.f10124b == null || keyframe.f10125c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C5833c<A> cVar = this.f9782e;
        if (cVar != null) {
            Float value = (Float) cVar.mo18209a(keyframe.f10127e, keyframe.f10128f.floatValue(), keyframe.f10124b, keyframe.f10125c, keyframeProgress, mo17953b(), mo17954c());
            if (value != null) {
                return value;
            }
        }
        return Float.valueOf(C5828e.m10533c(keyframe.f10124b.floatValue(), ((Float) keyframe.f10125c).floatValue(), keyframeProgress));
    }
}
