package com.airbnb.lottie.p085a.p087b;

import android.graphics.Path;
import com.airbnb.lottie.p089c.p091b.C5749l;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5831a;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.b.l */
/* compiled from: ShapeKeyframeAnimation */
public class C5710l extends C5698a<C5749l, Path> {

    /* renamed from: g */
    private final C5749l f9794g = new C5749l();

    /* renamed from: h */
    private final Path f9795h = new Path();

    public C5710l(List<C5831a<C5749l>> keyframes) {
        super(keyframes);
    }

    /* renamed from: a */
    public Path m10145a(C5831a<C5749l> keyframe, float keyframeProgress) {
        this.f9794g.mo18048a((C5749l) keyframe.f10124b, (C5749l) keyframe.f10125c, keyframeProgress);
        C5828e.m10529a(this.f9794g, this.f9795h);
        return this.f9795h;
    }
}
