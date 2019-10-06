package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p089c.p091b.C5754q;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p096g.C5833c;

/* renamed from: com.airbnb.lottie.a.a.u */
/* compiled from: StrokeContent */
public class C5696u extends C5676b {

    /* renamed from: o */
    private final C5762c f9768o;

    /* renamed from: p */
    private final String f9769p;

    /* renamed from: q */
    private final C5698a<Integer, Integer> f9770q;

    /* renamed from: r */
    private C5698a<ColorFilter, ColorFilter> f9771r;

    public C5696u(C5851x lottieDrawable, C5762c layer, C5754q stroke) {
        super(lottieDrawable, layer, stroke.mo18063a().mo18072e(), stroke.mo18066d().mo18073e(), stroke.mo18068f(), stroke.mo18070h(), stroke.mo18071i(), stroke.mo18067e(), stroke.mo18065c());
        this.f9768o = layer;
        this.f9769p = stroke.mo18069g();
        this.f9770q = stroke.mo18064b().mo17984a();
        this.f9770q.mo17951a((C5699a) this);
        layer.mo18084a(this.f9770q);
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        this.f9664i.setColor(((Integer) this.f9770q.mo17955d()).intValue());
        C5698a<ColorFilter, ColorFilter> aVar = this.f9771r;
        if (aVar != null) {
            this.f9664i.setColorFilter((ColorFilter) aVar.mo17955d());
        }
        super.mo17933a(canvas, parentMatrix, parentAlpha);
    }

    public String getName() {
        return this.f9769p;
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        super.mo17936a(property, callback);
        if (property == C5663B.f9596b) {
            this.f9770q.mo17952a(callback);
        } else if (property != C5663B.f9618x) {
        } else {
            if (callback == null) {
                this.f9771r = null;
                return;
            }
            this.f9771r = new C5714p(callback);
            this.f9771r.mo17951a((C5699a) this);
            this.f9768o.mo18084a(this.f9770q);
        }
    }
}
