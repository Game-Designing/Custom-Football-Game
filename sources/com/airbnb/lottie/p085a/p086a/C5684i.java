package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.p091b.C5737c;
import com.airbnb.lottie.p089c.p091b.C5739e;
import com.airbnb.lottie.p089c.p091b.C5740f;
import com.airbnb.lottie.p089c.p092c.C5762c;
import p002b.p003c.p053g.p061f.C1259h;

/* renamed from: com.airbnb.lottie.a.a.i */
/* compiled from: GradientStrokeContent */
public class C5684i extends C5676b {

    /* renamed from: o */
    private final String f9714o;

    /* renamed from: p */
    private final C1259h<LinearGradient> f9715p = new C1259h<>();

    /* renamed from: q */
    private final C1259h<RadialGradient> f9716q = new C1259h<>();

    /* renamed from: r */
    private final RectF f9717r = new RectF();

    /* renamed from: s */
    private final C5740f f9718s;

    /* renamed from: t */
    private final int f9719t;

    /* renamed from: u */
    private final C5698a<C5737c, C5737c> f9720u;

    /* renamed from: v */
    private final C5698a<PointF, PointF> f9721v;

    /* renamed from: w */
    private final C5698a<PointF, PointF> f9722w;

    public C5684i(C5851x lottieDrawable, C5762c layer, C5739e stroke) {
        super(lottieDrawable, layer, stroke.mo18011a().mo18072e(), stroke.mo18016f().mo18073e(), stroke.mo18018h(), stroke.mo18020j(), stroke.mo18022l(), stroke.mo18017g(), stroke.mo18012b());
        this.f9714o = stroke.mo18019i();
        this.f9718s = stroke.mo18015e();
        this.f9719t = (int) (lottieDrawable.mo18247e().mo18193c() / 32.0f);
        this.f9720u = stroke.mo18014d().mo17984a();
        this.f9720u.mo17951a((C5699a) this);
        layer.mo18084a(this.f9720u);
        this.f9721v = stroke.mo18021k().mo17984a();
        this.f9721v.mo17951a((C5699a) this);
        layer.mo18084a(this.f9721v);
        this.f9722w = stroke.mo18013c().mo17984a();
        this.f9722w.mo17951a((C5699a) this);
        layer.mo18084a(this.f9722w);
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        mo17934a(this.f9717r, parentMatrix);
        if (this.f9718s == C5740f.Linear) {
            this.f9664i.setShader(m10073c());
        } else {
            this.f9664i.setShader(m10074d());
        }
        super.mo17933a(canvas, parentMatrix, parentAlpha);
    }

    public String getName() {
        return this.f9714o;
    }

    /* renamed from: c */
    private LinearGradient m10073c() {
        int gradientHash = m10072b();
        LinearGradient gradient = (LinearGradient) this.f9715p.mo9058b((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = (PointF) this.f9721v.mo17955d();
        PointF endPoint = (PointF) this.f9722w.mo17955d();
        C5737c gradientColor = (C5737c) this.f9720u.mo17955d();
        int[] colors = gradientColor.mo18001a();
        float[] positions = gradientColor.mo18002b();
        RectF rectF = this.f9717r;
        int x0 = (int) (rectF.left + (rectF.width() / 2.0f) + startPoint.x);
        RectF rectF2 = this.f9717r;
        int y0 = (int) (rectF2.top + (rectF2.height() / 2.0f) + startPoint.y);
        RectF rectF3 = this.f9717r;
        int x1 = (int) (rectF3.left + (rectF3.width() / 2.0f) + endPoint.x);
        RectF rectF4 = this.f9717r;
        int y1 = (int) (rectF4.top + (rectF4.height() / 2.0f) + endPoint.y);
        int i = y1;
        int i2 = x1;
        int i3 = y0;
        int i4 = x0;
        LinearGradient linearGradient = new LinearGradient((float) x0, (float) y0, (float) x1, (float) y1, colors, positions, TileMode.CLAMP);
        LinearGradient gradient2 = linearGradient;
        this.f9715p.mo9063c((long) gradientHash, gradient2);
        return gradient2;
    }

    /* renamed from: d */
    private RadialGradient m10074d() {
        int gradientHash = m10072b();
        RadialGradient gradient = (RadialGradient) this.f9716q.mo9058b((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = (PointF) this.f9721v.mo17955d();
        PointF endPoint = (PointF) this.f9722w.mo17955d();
        C5737c gradientColor = (C5737c) this.f9720u.mo17955d();
        int[] colors = gradientColor.mo18001a();
        float[] positions = gradientColor.mo18002b();
        RectF rectF = this.f9717r;
        int x0 = (int) (rectF.left + (rectF.width() / 2.0f) + startPoint.x);
        RectF rectF2 = this.f9717r;
        int y0 = (int) (rectF2.top + (rectF2.height() / 2.0f) + startPoint.y);
        RectF rectF3 = this.f9717r;
        int x1 = (int) (rectF3.left + (rectF3.width() / 2.0f) + endPoint.x);
        RectF rectF4 = this.f9717r;
        int y1 = (int) (rectF4.top + (rectF4.height() / 2.0f) + endPoint.y);
        float r = (float) Math.hypot((double) (x1 - x0), (double) (y1 - y0));
        float f = r;
        int i = y1;
        int i2 = x1;
        int i3 = y0;
        RadialGradient radialGradient = new RadialGradient((float) x0, (float) y0, r, colors, positions, TileMode.CLAMP);
        RadialGradient gradient2 = radialGradient;
        this.f9716q.mo9063c((long) gradientHash, gradient2);
        return gradient2;
    }

    /* renamed from: b */
    private int m10072b() {
        int startPointProgress = Math.round(this.f9721v.mo17954c() * ((float) this.f9719t));
        int endPointProgress = Math.round(this.f9722w.mo17954c() * ((float) this.f9719t));
        int colorProgress = Math.round(this.f9720u.mo17954c() * ((float) this.f9719t));
        int hash = 17;
        if (startPointProgress != 0) {
            hash = 17 * 31 * startPointProgress;
        }
        if (endPointProgress != 0) {
            hash = hash * 31 * endPointProgress;
        }
        if (colorProgress != 0) {
            return hash * 31 * colorProgress;
        }
        return hash;
    }
}
