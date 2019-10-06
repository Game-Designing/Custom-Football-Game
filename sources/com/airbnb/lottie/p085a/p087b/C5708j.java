package com.airbnb.lottie.p085a.p087b;

import android.graphics.PointF;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.j */
/* compiled from: PointKeyframeAnimation */
public class C5708j extends C5704f<PointF> {

    /* renamed from: g */
    private final PointF f9793g = new PointF();

    public C5708j(List<C5831a<PointF>> keyframes) {
        super(keyframes);
    }

    /* renamed from: a */
    public PointF m10141a(C5831a<PointF> keyframe, float keyframeProgress) {
        T t = keyframe.f10124b;
        if (t != null) {
            T t2 = keyframe.f10125c;
            if (t2 != null) {
                PointF startPoint = (PointF) t;
                PointF endPoint = (PointF) t2;
                C5833c<A> cVar = this.f9782e;
                if (cVar != null) {
                    PointF value = (PointF) cVar.mo18209a(keyframe.f10127e, keyframe.f10128f.floatValue(), startPoint, endPoint, keyframeProgress, mo17953b(), mo17954c());
                    if (value != null) {
                        return value;
                    }
                }
                PointF value2 = this.f9793g;
                float f = startPoint.x;
                float f2 = f + ((endPoint.x - f) * keyframeProgress);
                float f3 = startPoint.y;
                value2.set(f2, f3 + ((endPoint.y - f3) * keyframeProgress));
                return this.f9793g;
            }
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
