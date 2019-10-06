package com.airbnb.lottie.p085a.p087b;

import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import com.airbnb.lottie.p096g.C5834d;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.k */
/* compiled from: ScaleKeyframeAnimation */
public class C5709k extends C5704f<C5834d> {
    public C5709k(List<C5831a<C5834d>> keyframes) {
        super(keyframes);
    }

    /* renamed from: a */
    public C5834d m10143a(C5831a<C5834d> keyframe, float keyframeProgress) {
        T t = keyframe.f10124b;
        if (t != null) {
            T t2 = keyframe.f10125c;
            if (t2 != null) {
                C5834d startTransform = (C5834d) t;
                C5834d endTransform = (C5834d) t2;
                C5833c<A> cVar = this.f9782e;
                if (cVar != null) {
                    C5834d value = (C5834d) cVar.mo18209a(keyframe.f10127e, keyframe.f10128f.floatValue(), startTransform, endTransform, keyframeProgress, mo17953b(), mo17954c());
                    if (value != null) {
                        return value;
                    }
                }
                return new C5834d(C5828e.m10533c(startTransform.mo18212a(), endTransform.mo18212a(), keyframeProgress), C5828e.m10533c(startTransform.mo18213b(), endTransform.mo18213b(), keyframeProgress));
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
