package com.airbnb.lottie.p085a.p087b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.p096g.C5831a;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.i */
/* compiled from: PathKeyframeAnimation */
public class C5707i extends C5704f<PointF> {

    /* renamed from: g */
    private final PointF f9789g = new PointF();

    /* renamed from: h */
    private final float[] f9790h = new float[2];

    /* renamed from: i */
    private C5706h f9791i;

    /* renamed from: j */
    private PathMeasure f9792j;

    public C5707i(List<? extends C5831a<PointF>> keyframes) {
        super(keyframes);
    }

    /* renamed from: a */
    public PointF m10139a(C5831a<PointF> keyframe, float keyframeProgress) {
        C5706h pathKeyframe = (C5706h) keyframe;
        Path path = pathKeyframe.mo17961d();
        if (path == null) {
            return (PointF) keyframe.f10124b;
        }
        C5833c<A> cVar = this.f9782e;
        if (cVar != null) {
            PointF value = (PointF) cVar.mo18209a(pathKeyframe.f10127e, pathKeyframe.f10128f.floatValue(), pathKeyframe.f10124b, pathKeyframe.f10125c, mo17953b(), keyframeProgress, mo17954c());
            if (value != null) {
                return value;
            }
        }
        if (this.f9791i != pathKeyframe) {
            this.f9792j = new PathMeasure(path, false);
            this.f9791i = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f9792j;
        pathMeasure.getPosTan(pathMeasure.getLength() * keyframeProgress, this.f9790h, null);
        PointF pointF = this.f9789g;
        float[] fArr = this.f9790h;
        pointF.set(fArr[0], fArr[1]);
        return this.f9789g;
    }
}
