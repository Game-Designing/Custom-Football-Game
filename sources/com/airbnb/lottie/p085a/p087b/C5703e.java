package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.e */
/* compiled from: IntegerKeyframeAnimation */
public class C5703e extends C5704f<Integer> {
    public C5703e(List<C5831a<Integer>> keyframes) {
        super(keyframes);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Integer m10133a(C5831a<Integer> keyframe, float keyframeProgress) {
        if (keyframe.f10124b == null || keyframe.f10125c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C5833c<A> cVar = this.f9782e;
        if (cVar != null) {
            Integer value = (Integer) cVar.mo18209a(keyframe.f10127e, keyframe.f10128f.floatValue(), keyframe.f10124b, keyframe.f10125c, keyframeProgress, mo17953b(), mo17954c());
            if (value != null) {
                return value;
            }
        }
        return Integer.valueOf(C5828e.m10526a(keyframe.f10124b.intValue(), ((Integer) keyframe.f10125c).intValue(), keyframeProgress));
    }
}
