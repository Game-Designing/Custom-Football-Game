package com.airbnb.lottie.p089c.p090a;

import android.graphics.PointF;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5707i;
import com.airbnb.lottie.p085a.p087b.C5708j;
import com.airbnb.lottie.p096g.C5831a;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.a.e */
/* compiled from: AnimatablePathValue */
public class C5724e implements C5732m<PointF, PointF> {

    /* renamed from: a */
    private final List<C5831a<PointF>> f9829a;

    public C5724e() {
        this.f9829a = Collections.singletonList(new C5831a(new PointF(0.0f, 0.0f)));
    }

    public C5724e(List<C5831a<PointF>> keyframes) {
        this.f9829a = keyframes;
    }

    /* renamed from: a */
    public C5698a<PointF, PointF> mo17984a() {
        if (((C5831a) this.f9829a.get(0)).mo18206c()) {
            return new C5708j(this.f9829a);
        }
        return new C5707i(this.f9829a);
    }
}
