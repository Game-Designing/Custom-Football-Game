package com.airbnb.lottie.p085a.p087b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5831a;

/* renamed from: com.airbnb.lottie.a.b.h */
/* compiled from: PathKeyframe */
public class C5706h extends C5831a<PointF> {

    /* renamed from: k */
    private Path f9788k;

    public C5706h(C5830g composition, C5831a<PointF> keyframe) {
        boolean equals;
        T t;
        super(composition, keyframe.f10124b, keyframe.f10125c, keyframe.f10126d, keyframe.f10127e, keyframe.f10128f);
        T t2 = this.f10125c;
        if (t2 != null) {
            T t3 = this.f10124b;
            if (t3 != null && ((PointF) t3).equals(((PointF) t2).x, ((PointF) t2).y)) {
                equals = true;
                t = this.f10125c;
                if (t != null && !equals) {
                    this.f9788k = C5829f.m10537a((PointF) this.f10124b, (PointF) t, keyframe.f10131i, keyframe.f10132j);
                    return;
                }
            }
        }
        equals = false;
        t = this.f10125c;
        if (t != null) {
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Path mo17961d() {
        return this.f9788k;
    }
}
