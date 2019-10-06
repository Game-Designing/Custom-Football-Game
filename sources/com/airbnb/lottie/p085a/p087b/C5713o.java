package com.airbnb.lottie.p085a.p087b;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.p090a.C5731l;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p096g.C5833c;
import com.airbnb.lottie.p096g.C5834d;

/* renamed from: com.airbnb.lottie.a.b.o */
/* compiled from: TransformKeyframeAnimation */
public class C5713o {

    /* renamed from: a */
    private final Matrix f9799a = new Matrix();

    /* renamed from: b */
    private final C5698a<PointF, PointF> f9800b;

    /* renamed from: c */
    private final C5698a<?, PointF> f9801c;

    /* renamed from: d */
    private final C5698a<C5834d, C5834d> f9802d;

    /* renamed from: e */
    private final C5698a<Float, Float> f9803e;

    /* renamed from: f */
    private final C5698a<Integer, Integer> f9804f;

    /* renamed from: g */
    private final C5698a<?, Float> f9805g;

    /* renamed from: h */
    private final C5698a<?, Float> f9806h;

    public C5713o(C5731l animatableTransform) {
        this.f9800b = animatableTransform.mo17988b().mo17984a();
        this.f9801c = animatableTransform.mo17991e().mo17984a();
        this.f9802d = animatableTransform.mo17993g().mo17984a();
        this.f9803e = animatableTransform.mo17992f().mo17984a();
        this.f9804f = animatableTransform.mo17990d().mo17984a();
        if (animatableTransform.mo17994h() != null) {
            this.f9805g = animatableTransform.mo17994h().mo17984a();
        } else {
            this.f9805g = null;
        }
        if (animatableTransform.mo17989c() != null) {
            this.f9806h = animatableTransform.mo17989c().mo17984a();
        } else {
            this.f9806h = null;
        }
    }

    /* renamed from: a */
    public void mo17965a(C5762c layer) {
        layer.mo18084a(this.f9800b);
        layer.mo18084a(this.f9801c);
        layer.mo18084a(this.f9802d);
        layer.mo18084a(this.f9803e);
        layer.mo18084a(this.f9804f);
        C5698a<?, Float> aVar = this.f9805g;
        if (aVar != null) {
            layer.mo18084a(aVar);
        }
        C5698a<?, Float> aVar2 = this.f9806h;
        if (aVar2 != null) {
            layer.mo18084a(aVar2);
        }
    }

    /* renamed from: a */
    public void mo17964a(C5699a listener) {
        this.f9800b.mo17951a(listener);
        this.f9801c.mo17951a(listener);
        this.f9802d.mo17951a(listener);
        this.f9803e.mo17951a(listener);
        this.f9804f.mo17951a(listener);
        C5698a<?, Float> aVar = this.f9805g;
        if (aVar != null) {
            aVar.mo17951a(listener);
        }
        C5698a<?, Float> aVar2 = this.f9806h;
        if (aVar2 != null) {
            aVar2.mo17951a(listener);
        }
    }

    /* renamed from: b */
    public void mo17968b(float progress) {
        this.f9800b.mo17950a(progress);
        this.f9801c.mo17950a(progress);
        this.f9802d.mo17950a(progress);
        this.f9803e.mo17950a(progress);
        this.f9804f.mo17950a(progress);
        C5698a<?, Float> aVar = this.f9805g;
        if (aVar != null) {
            aVar.mo17950a(progress);
        }
        C5698a<?, Float> aVar2 = this.f9806h;
        if (aVar2 != null) {
            aVar2.mo17950a(progress);
        }
    }

    /* renamed from: c */
    public C5698a<?, Integer> mo17969c() {
        return this.f9804f;
    }

    /* renamed from: d */
    public C5698a<?, Float> mo17970d() {
        return this.f9805g;
    }

    /* renamed from: a */
    public C5698a<?, Float> mo17963a() {
        return this.f9806h;
    }

    /* renamed from: b */
    public Matrix mo17967b() {
        this.f9799a.reset();
        PointF position = (PointF) this.f9801c.mo17955d();
        if (!(position.x == 0.0f && position.y == 0.0f)) {
            this.f9799a.preTranslate(position.x, position.y);
        }
        float rotation = ((Float) this.f9803e.mo17955d()).floatValue();
        if (rotation != 0.0f) {
            this.f9799a.preRotate(rotation);
        }
        C5834d scaleTransform = (C5834d) this.f9802d.mo17955d();
        if (!(scaleTransform.mo18212a() == 1.0f && scaleTransform.mo18213b() == 1.0f)) {
            this.f9799a.preScale(scaleTransform.mo18212a(), scaleTransform.mo18213b());
        }
        PointF anchorPoint = (PointF) this.f9800b.mo17955d();
        if (!(anchorPoint.x == 0.0f && anchorPoint.y == 0.0f)) {
            this.f9799a.preTranslate(-anchorPoint.x, -anchorPoint.y);
        }
        return this.f9799a;
    }

    /* renamed from: a */
    public Matrix mo17962a(float amount) {
        PointF position = (PointF) this.f9801c.mo17955d();
        PointF anchorPoint = (PointF) this.f9800b.mo17955d();
        C5834d scale = (C5834d) this.f9802d.mo17955d();
        float rotation = ((Float) this.f9803e.mo17955d()).floatValue();
        this.f9799a.reset();
        this.f9799a.preTranslate(position.x * amount, position.y * amount);
        this.f9799a.preScale((float) Math.pow((double) scale.mo18212a(), (double) amount), (float) Math.pow((double) scale.mo18213b(), (double) amount));
        this.f9799a.preRotate(rotation * amount, anchorPoint.x, anchorPoint.y);
        return this.f9799a;
    }

    /* renamed from: a */
    public <T> boolean mo17966a(T property, C5833c<T> callback) {
        if (property == C5663B.f9599e) {
            this.f9800b.mo17952a(callback);
        } else if (property == C5663B.f9600f) {
            this.f9801c.mo17952a(callback);
        } else if (property == C5663B.f9603i) {
            this.f9802d.mo17952a(callback);
        } else if (property == C5663B.f9604j) {
            this.f9803e.mo17952a(callback);
        } else if (property == C5663B.f9597c) {
            this.f9804f.mo17952a(callback);
        } else {
            if (property == C5663B.f9615u) {
                C5698a<?, Float> aVar = this.f9805g;
                if (aVar != null) {
                    aVar.mo17952a(callback);
                }
            }
            if (property == C5663B.f9616v) {
                C5698a<?, Float> aVar2 = this.f9806h;
                if (aVar2 != null) {
                    aVar2.mo17952a(callback);
                }
            }
            return false;
        }
        return true;
    }
}
