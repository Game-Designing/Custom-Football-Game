package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p095f.C5825b;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.b */
/* compiled from: ColorKeyframeAnimation */
public class C5700b extends C5704f<Integer> {
    public C5700b(List<C5831a<Integer>> keyframes) {
        super(keyframes);
    }

    /* renamed from: a */
    public Integer m10127a(C5831a<Integer> keyframe, float keyframeProgress) {
        T t = keyframe.f10124b;
        if (t == null || keyframe.f10125c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int startColor = ((Integer) t).intValue();
        int endColor = ((Integer) keyframe.f10125c).intValue();
        C5833c<A> cVar = this.f9782e;
        if (cVar != null) {
            Integer value = (Integer) cVar.mo18209a(keyframe.f10127e, keyframe.f10128f.floatValue(), Integer.valueOf(startColor), Integer.valueOf(endColor), keyframeProgress, mo17953b(), mo17954c());
            if (value != null) {
                return value;
            }
        }
        return Integer.valueOf(C5825b.m10498a(keyframeProgress, startColor, endColor));
    }
}
