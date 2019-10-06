package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5737c;
import com.airbnb.lottie.p089c.p091b.C5738d;
import com.airbnb.lottie.p089c.p091b.C5740f;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p061f.C1259h;

/* renamed from: com.airbnb.lottie.a.a.h */
/* compiled from: GradientFillContent */
public class C5683h implements C5680e, C5699a, C5686k {

    /* renamed from: a */
    private final String f9697a;

    /* renamed from: b */
    private final C5762c f9698b;

    /* renamed from: c */
    private final C1259h<LinearGradient> f9699c = new C1259h<>();

    /* renamed from: d */
    private final C1259h<RadialGradient> f9700d = new C1259h<>();

    /* renamed from: e */
    private final Matrix f9701e = new Matrix();

    /* renamed from: f */
    private final Path f9702f = new Path();

    /* renamed from: g */
    private final Paint f9703g = new Paint(1);

    /* renamed from: h */
    private final RectF f9704h = new RectF();

    /* renamed from: i */
    private final List<C5690o> f9705i = new ArrayList();

    /* renamed from: j */
    private final C5740f f9706j;

    /* renamed from: k */
    private final C5698a<C5737c, C5737c> f9707k;

    /* renamed from: l */
    private final C5698a<Integer, Integer> f9708l;

    /* renamed from: m */
    private final C5698a<PointF, PointF> f9709m;

    /* renamed from: n */
    private final C5698a<PointF, PointF> f9710n;

    /* renamed from: o */
    private C5698a<ColorFilter, ColorFilter> f9711o;

    /* renamed from: p */
    private final C5851x f9712p;

    /* renamed from: q */
    private final int f9713q;

    public C5683h(C5851x lottieDrawable, C5762c layer, C5738d fill) {
        this.f9698b = layer;
        this.f9697a = fill.mo18008e();
        this.f9712p = lottieDrawable;
        this.f9706j = fill.mo18007d();
        this.f9702f.setFillType(fill.mo18005b());
        this.f9713q = (int) (lottieDrawable.mo18247e().mo18193c() / 32.0f);
        this.f9707k = fill.mo18006c().mo17984a();
        this.f9707k.mo17951a((C5699a) this);
        layer.mo18084a(this.f9707k);
        this.f9708l = fill.mo18009f().mo17984a();
        this.f9708l.mo17951a((C5699a) this);
        layer.mo18084a(this.f9708l);
        this.f9709m = fill.mo18010g().mo17984a();
        this.f9709m.mo17951a((C5699a) this);
        layer.mo18084a(this.f9709m);
        this.f9710n = fill.mo18004a().mo17984a();
        this.f9710n.mo17951a((C5699a) this);
        layer.mo18084a(this.f9710n);
    }

    /* renamed from: a */
    public void mo17932a() {
        this.f9712p.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> list, List<C5678c> contentsAfter) {
        for (int i = 0; i < contentsAfter.size(); i++) {
            C5678c content = (C5678c) contentsAfter.get(i);
            if (content instanceof C5690o) {
                this.f9705i.add((C5690o) content);
            }
        }
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        Shader shader;
        String str = "GradientFillContent#draw";
        C5718c.m10176a(str);
        this.f9702f.reset();
        for (int i = 0; i < this.f9705i.size(); i++) {
            this.f9702f.addPath(((C5690o) this.f9705i.get(i)).getPath(), parentMatrix);
        }
        this.f9702f.computeBounds(this.f9704h, false);
        if (this.f9706j == C5740f.Linear) {
            shader = m10064c();
        } else {
            shader = m10065d();
        }
        this.f9701e.set(parentMatrix);
        shader.setLocalMatrix(this.f9701e);
        this.f9703g.setShader(shader);
        C5698a<ColorFilter, ColorFilter> aVar = this.f9711o;
        if (aVar != null) {
            this.f9703g.setColorFilter((ColorFilter) aVar.mo17955d());
        }
        this.f9703g.setAlpha(C5828e.m10527a((int) ((((((float) parentAlpha) / 255.0f) * ((float) ((Integer) this.f9708l.mo17955d()).intValue())) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f9702f, this.f9703g);
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        this.f9702f.reset();
        for (int i = 0; i < this.f9705i.size(); i++) {
            this.f9702f.addPath(((C5690o) this.f9705i.get(i)).getPath(), parentMatrix);
        }
        this.f9702f.computeBounds(outBounds, false);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
    }

    public String getName() {
        return this.f9697a;
    }

    /* renamed from: c */
    private LinearGradient m10064c() {
        int gradientHash = m10063b();
        LinearGradient gradient = (LinearGradient) this.f9699c.mo9058b((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = (PointF) this.f9709m.mo17955d();
        PointF endPoint = (PointF) this.f9710n.mo17955d();
        C5737c gradientColor = (C5737c) this.f9707k.mo17955d();
        int[] colors = gradientColor.mo18001a();
        LinearGradient linearGradient = new LinearGradient(startPoint.x, startPoint.y, endPoint.x, endPoint.y, colors, gradientColor.mo18002b(), TileMode.CLAMP);
        LinearGradient gradient2 = linearGradient;
        this.f9699c.mo9063c((long) gradientHash, gradient2);
        return gradient2;
    }

    /* renamed from: d */
    private RadialGradient m10065d() {
        int gradientHash = m10063b();
        RadialGradient gradient = (RadialGradient) this.f9700d.mo9058b((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = (PointF) this.f9709m.mo17955d();
        PointF endPoint = (PointF) this.f9710n.mo17955d();
        C5737c gradientColor = (C5737c) this.f9707k.mo17955d();
        int[] colors = gradientColor.mo18001a();
        float[] positions = gradientColor.mo18002b();
        float x0 = startPoint.x;
        float y0 = startPoint.y;
        float x1 = endPoint.x;
        float y1 = endPoint.y;
        float r = (float) Math.hypot((double) (x1 - x0), (double) (y1 - y0));
        float f = r;
        float f2 = y1;
        float f3 = x1;
        float f4 = y0;
        RadialGradient radialGradient = new RadialGradient(x0, y0, r, colors, positions, TileMode.CLAMP);
        RadialGradient gradient2 = radialGradient;
        this.f9700d.mo9063c((long) gradientHash, gradient2);
        return gradient2;
    }

    /* renamed from: b */
    private int m10063b() {
        int startPointProgress = Math.round(this.f9709m.mo17954c() * ((float) this.f9713q));
        int endPointProgress = Math.round(this.f9710n.mo17954c() * ((float) this.f9713q));
        int colorProgress = Math.round(this.f9707k.mo17954c() * ((float) this.f9713q));
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

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (property != C5663B.f9618x) {
            return;
        }
        if (callback == null) {
            this.f9711o = null;
            return;
        }
        this.f9711o = new C5714p(callback);
        this.f9711o.mo17951a((C5699a) this);
        this.f9698b.mo18084a(this.f9711o);
    }
}
