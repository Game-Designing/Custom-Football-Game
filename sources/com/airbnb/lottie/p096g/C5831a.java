package com.airbnb.lottie.p096g;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.C5830g;

/* renamed from: com.airbnb.lottie.g.a */
/* compiled from: Keyframe */
public class C5831a<T> {

    /* renamed from: a */
    private final C5830g f10123a;

    /* renamed from: b */
    public final T f10124b;

    /* renamed from: c */
    public final T f10125c;

    /* renamed from: d */
    public final Interpolator f10126d;

    /* renamed from: e */
    public final float f10127e;

    /* renamed from: f */
    public Float f10128f;

    /* renamed from: g */
    private float f10129g;

    /* renamed from: h */
    private float f10130h;

    /* renamed from: i */
    public PointF f10131i;

    /* renamed from: j */
    public PointF f10132j;

    public C5831a(C5830g composition, T startValue, T endValue, Interpolator interpolator, float startFrame, Float endFrame) {
        this.f10129g = Float.MIN_VALUE;
        this.f10130h = Float.MIN_VALUE;
        this.f10131i = null;
        this.f10132j = null;
        this.f10123a = composition;
        this.f10124b = startValue;
        this.f10125c = endValue;
        this.f10126d = interpolator;
        this.f10127e = startFrame;
        this.f10128f = endFrame;
    }

    public C5831a(T value) {
        this.f10129g = Float.MIN_VALUE;
        this.f10130h = Float.MIN_VALUE;
        this.f10131i = null;
        this.f10132j = null;
        this.f10123a = null;
        this.f10124b = value;
        this.f10125c = value;
        this.f10126d = null;
        this.f10127e = Float.MIN_VALUE;
        this.f10128f = Float.valueOf(Float.MAX_VALUE);
    }

    /* renamed from: b */
    public float mo18205b() {
        C5830g gVar = this.f10123a;
        if (gVar == null) {
            return 0.0f;
        }
        if (this.f10129g == Float.MIN_VALUE) {
            this.f10129g = (this.f10127e - gVar.mo18201k()) / this.f10123a.mo18194d();
        }
        return this.f10129g;
    }

    /* renamed from: a */
    public float mo18203a() {
        if (this.f10123a == null) {
            return 1.0f;
        }
        if (this.f10130h == Float.MIN_VALUE) {
            if (this.f10128f == null) {
                this.f10130h = 1.0f;
            } else {
                this.f10130h = mo18205b() + ((this.f10128f.floatValue() - this.f10127e) / this.f10123a.mo18194d());
            }
        }
        return this.f10130h;
    }

    /* renamed from: c */
    public boolean mo18206c() {
        return this.f10126d == null;
    }

    /* renamed from: a */
    public boolean mo18204a(float progress) {
        return progress >= mo18205b() && progress < mo18203a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Keyframe{startValue=");
        sb.append(this.f10124b);
        sb.append(", endValue=");
        sb.append(this.f10125c);
        sb.append(", startFrame=");
        sb.append(this.f10127e);
        sb.append(", endFrame=");
        sb.append(this.f10128f);
        sb.append(", interpolator=");
        sb.append(this.f10126d);
        sb.append('}');
        return sb.toString();
    }
}
