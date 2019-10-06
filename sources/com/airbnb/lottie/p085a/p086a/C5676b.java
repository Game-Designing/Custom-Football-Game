package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p089c.p090a.C5723d;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.b */
/* compiled from: BaseStrokeContent */
public abstract class C5676b implements C5699a, C5686k, C5680e {

    /* renamed from: a */
    private final PathMeasure f9656a = new PathMeasure();

    /* renamed from: b */
    private final Path f9657b = new Path();

    /* renamed from: c */
    private final Path f9658c = new Path();

    /* renamed from: d */
    private final RectF f9659d = new RectF();

    /* renamed from: e */
    private final C5851x f9660e;

    /* renamed from: f */
    private final C5762c f9661f;

    /* renamed from: g */
    private final List<C5677a> f9662g = new ArrayList();

    /* renamed from: h */
    private final float[] f9663h;

    /* renamed from: i */
    final Paint f9664i = new Paint(1);

    /* renamed from: j */
    private final C5698a<?, Float> f9665j;

    /* renamed from: k */
    private final C5698a<?, Integer> f9666k;

    /* renamed from: l */
    private final List<C5698a<?, Float>> f9667l;

    /* renamed from: m */
    private final C5698a<?, Float> f9668m;

    /* renamed from: n */
    private C5698a<ColorFilter, ColorFilter> f9669n;

    /* renamed from: com.airbnb.lottie.a.a.b$a */
    /* compiled from: BaseStrokeContent */
    private static final class C5677a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<C5690o> f9670a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C5697v f9671b;

        private C5677a(C5697v trimPath) {
            this.f9670a = new ArrayList();
            this.f9671b = trimPath;
        }
    }

    C5676b(C5851x lottieDrawable, C5762c layer, Cap cap, Join join, float miterLimit, C5723d opacity, C5721b width, List<C5721b> dashPattern, C5721b offset) {
        this.f9660e = lottieDrawable;
        this.f9661f = layer;
        this.f9664i.setStyle(Style.STROKE);
        this.f9664i.setStrokeCap(cap);
        this.f9664i.setStrokeJoin(join);
        this.f9664i.setStrokeMiter(miterLimit);
        this.f9666k = opacity.mo17984a();
        this.f9665j = width.mo17984a();
        if (offset == null) {
            this.f9668m = null;
        } else {
            this.f9668m = offset.mo17984a();
        }
        this.f9667l = new ArrayList(dashPattern.size());
        this.f9663h = new float[dashPattern.size()];
        for (int i = 0; i < dashPattern.size(); i++) {
            this.f9667l.add(((C5721b) dashPattern.get(i)).mo17984a());
        }
        layer.mo18084a(this.f9666k);
        layer.mo18084a(this.f9665j);
        for (int i2 = 0; i2 < this.f9667l.size(); i2++) {
            layer.mo18084a((C5698a) this.f9667l.get(i2));
        }
        C5698a<?, Float> aVar = this.f9668m;
        if (aVar != null) {
            layer.mo18084a(aVar);
        }
        this.f9666k.mo17951a((C5699a) this);
        this.f9665j.mo17951a((C5699a) this);
        for (int i3 = 0; i3 < dashPattern.size(); i3++) {
            ((C5698a) this.f9667l.get(i3)).mo17951a((C5699a) this);
        }
        C5698a<?, Float> aVar2 = this.f9668m;
        if (aVar2 != null) {
            aVar2.mo17951a((C5699a) this);
        }
    }

    /* renamed from: a */
    public void mo17932a() {
        this.f9660e.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> contentsAfter) {
        C5697v trimPathContentBefore = null;
        for (int i = contentsBefore.size() - 1; i >= 0; i--) {
            C5678c content = (C5678c) contentsBefore.get(i);
            if ((content instanceof C5697v) && ((C5697v) content).mo17947e() == C5758a.Individually) {
                trimPathContentBefore = (C5697v) content;
            }
        }
        if (trimPathContentBefore != null) {
            trimPathContentBefore.mo17943a(this);
        }
        C5677a currentPathGroup = null;
        for (int i2 = contentsAfter.size() - 1; i2 >= 0; i2--) {
            C5678c content2 = (C5678c) contentsAfter.get(i2);
            if ((content2 instanceof C5697v) && ((C5697v) content2).mo17947e() == C5758a.Individually) {
                if (currentPathGroup != null) {
                    this.f9662g.add(currentPathGroup);
                }
                currentPathGroup = new C5677a((C5697v) content2);
                ((C5697v) content2).mo17943a(this);
            } else if (content2 instanceof C5690o) {
                if (currentPathGroup == null) {
                    currentPathGroup = new C5677a(trimPathContentBefore);
                }
                currentPathGroup.f9670a.add((C5690o) content2);
            }
        }
        if (currentPathGroup != null) {
            this.f9662g.add(currentPathGroup);
        }
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        String str = "StrokeContent#draw";
        C5718c.m10176a(str);
        this.f9664i.setAlpha(C5828e.m10527a((int) ((((((float) parentAlpha) / 255.0f) * ((float) ((Integer) this.f9666k.mo17955d()).intValue())) / 100.0f) * 255.0f), 0, 255));
        this.f9664i.setStrokeWidth(((Float) this.f9665j.mo17955d()).floatValue() * C5829f.m10535a(parentMatrix));
        if (this.f9664i.getStrokeWidth() <= 0.0f) {
            C5718c.m10178c(str);
            return;
        }
        m10030a(parentMatrix);
        C5698a<ColorFilter, ColorFilter> aVar = this.f9669n;
        if (aVar != null) {
            this.f9664i.setColorFilter((ColorFilter) aVar.mo17955d());
        }
        for (int i = 0; i < this.f9662g.size(); i++) {
            C5677a pathGroup = (C5677a) this.f9662g.get(i);
            if (pathGroup.f9671b != null) {
                m10029a(canvas, pathGroup, parentMatrix);
            } else {
                String str2 = "StrokeContent#buildPath";
                C5718c.m10176a(str2);
                this.f9657b.reset();
                for (int j = pathGroup.f9670a.size() - 1; j >= 0; j--) {
                    this.f9657b.addPath(((C5690o) pathGroup.f9670a.get(j)).getPath(), parentMatrix);
                }
                C5718c.m10178c(str2);
                String str3 = "StrokeContent#drawPath";
                C5718c.m10176a(str3);
                canvas.drawPath(this.f9657b, this.f9664i);
                C5718c.m10178c(str3);
            }
        }
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    private void m10029a(Canvas canvas, C5677a pathGroup, Matrix parentMatrix) {
        float startValue;
        float endValue;
        float startValue2;
        Canvas canvas2 = canvas;
        Matrix matrix = parentMatrix;
        String str = "StrokeContent#applyTrimPath";
        C5718c.m10176a(str);
        if (pathGroup.f9671b == null) {
            C5718c.m10178c(str);
            return;
        }
        this.f9657b.reset();
        for (int j = pathGroup.f9670a.size() - 1; j >= 0; j--) {
            this.f9657b.addPath(((C5690o) pathGroup.f9670a.get(j)).getPath(), matrix);
        }
        this.f9656a.setPath(this.f9657b, false);
        float totalLength = this.f9656a.getLength();
        while (this.f9656a.nextContour()) {
            totalLength += this.f9656a.getLength();
        }
        float offsetLength = (((Float) pathGroup.f9671b.mo17945c().mo17955d()).floatValue() * totalLength) / 360.0f;
        float startLength = ((((Float) pathGroup.f9671b.mo17946d().mo17955d()).floatValue() * totalLength) / 100.0f) + offsetLength;
        float endLength = ((((Float) pathGroup.f9671b.mo17944b().mo17955d()).floatValue() * totalLength) / 100.0f) + offsetLength;
        float currentLength = 0.0f;
        for (int j2 = pathGroup.f9670a.size() - 1; j2 >= 0; j2--) {
            this.f9658c.set(((C5690o) pathGroup.f9670a.get(j2)).getPath());
            this.f9658c.transform(matrix);
            this.f9656a.setPath(this.f9658c, false);
            float length = this.f9656a.getLength();
            if (endLength > totalLength && endLength - totalLength < currentLength + length && currentLength < endLength - totalLength) {
                if (startLength > totalLength) {
                    startValue2 = (startLength - totalLength) / length;
                } else {
                    startValue2 = 0.0f;
                }
                C5829f.m10538a(this.f9658c, startValue2, Math.min((endLength - totalLength) / length, 1.0f), 0.0f);
                canvas2.drawPath(this.f9658c, this.f9664i);
            } else if (currentLength + length >= startLength && currentLength <= endLength) {
                if (currentLength + length > endLength || startLength >= currentLength) {
                    if (startLength < currentLength) {
                        startValue = 0.0f;
                    } else {
                        startValue = (startLength - currentLength) / length;
                    }
                    if (endLength > currentLength + length) {
                        endValue = 1.0f;
                    } else {
                        endValue = (endLength - currentLength) / length;
                    }
                    C5829f.m10538a(this.f9658c, startValue, endValue, 0.0f);
                    canvas2.drawPath(this.f9658c, this.f9664i);
                } else {
                    canvas2.drawPath(this.f9658c, this.f9664i);
                }
            }
            currentLength += length;
        }
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        String str = "StrokeContent#getBounds";
        C5718c.m10176a(str);
        this.f9657b.reset();
        for (int i = 0; i < this.f9662g.size(); i++) {
            C5677a pathGroup = (C5677a) this.f9662g.get(i);
            for (int j = 0; j < pathGroup.f9670a.size(); j++) {
                this.f9657b.addPath(((C5690o) pathGroup.f9670a.get(j)).getPath(), parentMatrix);
            }
        }
        this.f9657b.computeBounds(this.f9659d, false);
        float width = ((Float) this.f9665j.mo17955d()).floatValue();
        RectF rectF = this.f9659d;
        rectF.set(rectF.left - (width / 2.0f), rectF.top - (width / 2.0f), rectF.right + (width / 2.0f), rectF.bottom + (width / 2.0f));
        outBounds.set(this.f9659d);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    private void m10030a(Matrix parentMatrix) {
        String str = "StrokeContent#applyDashPattern";
        C5718c.m10176a(str);
        if (this.f9667l.isEmpty()) {
            C5718c.m10178c(str);
            return;
        }
        float scale = C5829f.m10535a(parentMatrix);
        for (int i = 0; i < this.f9667l.size(); i++) {
            this.f9663h[i] = ((Float) ((C5698a) this.f9667l.get(i)).mo17955d()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f9663h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f9663h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f9663h;
            fArr3[i] = fArr3[i] * scale;
        }
        C5698a<?, Float> aVar = this.f9668m;
        this.f9664i.setPathEffect(new DashPathEffect(this.f9663h, aVar == null ? 0.0f : ((Float) aVar.mo17955d()).floatValue()));
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (property == C5663B.f9598d) {
            this.f9666k.mo17952a(callback);
        } else if (property == C5663B.f9605k) {
            this.f9665j.mo17952a(callback);
        } else if (property != C5663B.f9618x) {
        } else {
            if (callback == null) {
                this.f9669n = null;
                return;
            }
            this.f9669n = new C5714p(callback);
            this.f9669n.mo17951a((C5699a) this);
            this.f9661f.mo18084a(this.f9669n);
        }
    }
}
