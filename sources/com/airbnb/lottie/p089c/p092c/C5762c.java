package com.airbnb.lottie.p089c.p092c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.p085a.p086a.C5678c;
import com.airbnb.lottie.p085a.p086a.C5680e;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5701c;
import com.airbnb.lottie.p085a.p087b.C5705g;
import com.airbnb.lottie.p085a.p087b.C5713o;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.C5777f;
import com.airbnb.lottie.p089c.p091b.C5741g;
import com.airbnb.lottie.p089c.p091b.C5741g.C5742a;
import com.airbnb.lottie.p089c.p092c.C5766g.C5768b;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.c.c */
/* compiled from: BaseLayer */
public abstract class C5762c implements C5680e, C5699a, C5777f {

    /* renamed from: a */
    private final Path f9969a = new Path();

    /* renamed from: b */
    private final Matrix f9970b = new Matrix();

    /* renamed from: c */
    private final Paint f9971c = new Paint(1);

    /* renamed from: d */
    private final Paint f9972d = new Paint(1);

    /* renamed from: e */
    private final Paint f9973e = new Paint(1);

    /* renamed from: f */
    private final Paint f9974f = new Paint(1);

    /* renamed from: g */
    private final Paint f9975g = new Paint();

    /* renamed from: h */
    private final RectF f9976h = new RectF();

    /* renamed from: i */
    private final RectF f9977i = new RectF();

    /* renamed from: j */
    private final RectF f9978j = new RectF();

    /* renamed from: k */
    private final RectF f9979k = new RectF();

    /* renamed from: l */
    private final String f9980l;

    /* renamed from: m */
    final Matrix f9981m = new Matrix();

    /* renamed from: n */
    final C5851x f9982n;

    /* renamed from: o */
    final C5766g f9983o;

    /* renamed from: p */
    private C5705g f9984p;

    /* renamed from: q */
    private C5762c f9985q;

    /* renamed from: r */
    private C5762c f9986r;

    /* renamed from: s */
    private List<C5762c> f9987s;

    /* renamed from: t */
    private final List<C5698a<?, ?>> f9988t = new ArrayList();

    /* renamed from: u */
    final C5713o f9989u;

    /* renamed from: v */
    private boolean f9990v = true;

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract void mo18087b(Canvas canvas, Matrix matrix, int i);

    /* renamed from: a */
    static C5762c m10305a(C5766g layerModel, C5851x drawable, C5830g composition) {
        switch (C5761b.f9967a[layerModel.mo18096d().ordinal()]) {
            case 1:
                return new C5770i(drawable, layerModel);
            case 2:
                return new C5764e(drawable, layerModel, composition.mo18192b(layerModel.mo18103k()), composition);
            case 3:
                return new C5771j(drawable, layerModel);
            case 4:
                return new C5765f(drawable, layerModel);
            case 5:
                return new C5769h(drawable, layerModel);
            case 6:
                return new C5774m(drawable, layerModel);
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown layer type ");
                sb.append(layerModel.mo18096d());
                C5718c.m10179d(sb.toString());
                return null;
        }
    }

    C5762c(C5851x lottieDrawable, C5766g layerModel) {
        this.f9982n = lottieDrawable;
        this.f9983o = layerModel;
        StringBuilder sb = new StringBuilder();
        sb.append(layerModel.mo18099g());
        sb.append("#draw");
        this.f9980l = sb.toString();
        this.f9975g.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.f9972d.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f9973e.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        if (layerModel.mo18098f() == C5768b.Invert) {
            this.f9974f.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.f9974f.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.f9989u = layerModel.mo18114u().mo17987a();
        this.f9989u.mo17964a((C5699a) this);
        if (layerModel.mo18097e() != null && !layerModel.mo18097e().isEmpty()) {
            this.f9984p = new C5705g(layerModel.mo18097e());
            for (BaseKeyframeAnimation<?, Path> animation : this.f9984p.mo17958a()) {
                animation.mo17951a((C5699a) this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> animation2 : this.f9984p.mo17960c()) {
                mo18084a((C5698a<?, ?>) animation2);
                animation2.mo17951a((C5699a) this);
            }
        }
        m10317g();
    }

    /* renamed from: a */
    public void mo17932a() {
        m10316f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C5766g mo18086b() {
        return this.f9983o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18085a(C5762c matteLayer) {
        this.f9985q = matteLayer;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo18091d() {
        return this.f9985q != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18088b(C5762c parentLayer) {
        this.f9986r = parentLayer;
    }

    /* renamed from: g */
    private void m10317g() {
        boolean z = true;
        if (!this.f9983o.mo18095c().isEmpty()) {
            C5701c inOutAnimation = new C5701c(this.f9983o.mo18095c());
            inOutAnimation.mo17957f();
            inOutAnimation.mo17951a((C5699a) new C5760a(this, inOutAnimation));
            if (((Float) inOutAnimation.mo17955d()).floatValue() != 1.0f) {
                z = false;
            }
            m10311a(z);
            mo18084a((C5698a<?, ?>) inOutAnimation);
            return;
        }
        m10311a(true);
    }

    /* renamed from: f */
    private void m10316f() {
        this.f9982n.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: a */
    private void m10309a(Canvas canvas, RectF rect, Paint paint, boolean all) {
        if (VERSION.SDK_INT < 23) {
            canvas.saveLayer(rect, paint, all ? 31 : 19);
        } else {
            canvas.saveLayer(rect, paint);
        }
    }

    /* renamed from: a */
    public void mo18084a(C5698a<?, ?> newAnimation) {
        this.f9988t.add(newAnimation);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        this.f9981m.set(parentMatrix);
        this.f9981m.preConcat(this.f9989u.mo17967b());
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        C5718c.m10176a(this.f9980l);
        if (!this.f9990v) {
            C5718c.m10178c(this.f9980l);
            return;
        }
        m10315e();
        String str = "Layer#parentMatrix";
        C5718c.m10176a(str);
        this.f9970b.reset();
        this.f9970b.set(parentMatrix);
        for (int i = this.f9987s.size() - 1; i >= 0; i--) {
            this.f9970b.preConcat(((C5762c) this.f9987s.get(i)).f9989u.mo17967b());
        }
        C5718c.m10178c(str);
        int alpha = (int) ((((((float) parentAlpha) / 255.0f) * ((float) ((Integer) this.f9989u.mo17969c().mo17955d()).intValue())) / 100.0f) * 255.0f);
        String str2 = "Layer#drawLayer";
        if (mo18091d() || mo18090c()) {
            String str3 = "Layer#computeBounds";
            C5718c.m10176a(str3);
            this.f9976h.set(0.0f, 0.0f, 0.0f, 0.0f);
            mo17934a(this.f9976h, this.f9970b);
            m10314c(this.f9976h, this.f9970b);
            this.f9970b.preConcat(this.f9989u.mo17967b());
            m10313b(this.f9976h, this.f9970b);
            this.f9976h.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            C5718c.m10178c(str3);
            String str4 = "Layer#saveLayer";
            C5718c.m10176a(str4);
            m10309a(canvas, this.f9976h, this.f9971c, true);
            C5718c.m10178c(str4);
            m10306a(canvas);
            C5718c.m10176a(str2);
            mo18087b(canvas, this.f9970b, alpha);
            C5718c.m10178c(str2);
            if (mo18090c()) {
                m10307a(canvas, this.f9970b);
            }
            String str5 = "Layer#restoreLayer";
            if (mo18091d()) {
                String str6 = "Layer#drawMatte";
                C5718c.m10176a(str6);
                C5718c.m10176a(str4);
                m10309a(canvas, this.f9976h, this.f9974f, false);
                C5718c.m10178c(str4);
                m10306a(canvas);
                this.f9985q.mo17933a(canvas, parentMatrix, alpha);
                C5718c.m10176a(str5);
                canvas.restore();
                C5718c.m10178c(str5);
                C5718c.m10178c(str6);
            }
            C5718c.m10176a(str5);
            canvas.restore();
            C5718c.m10178c(str5);
            m10312b(C5718c.m10178c(this.f9980l));
            return;
        }
        this.f9970b.preConcat(this.f9989u.mo17967b());
        C5718c.m10176a(str2);
        mo18087b(canvas, this.f9970b, alpha);
        C5718c.m10178c(str2);
        m10312b(C5718c.m10178c(this.f9980l));
    }

    /* renamed from: b */
    private void m10312b(float ms) {
        this.f9982n.mo18247e().mo18200j().mo17878a(this.f9983o.mo18099g(), ms);
    }

    /* renamed from: a */
    private void m10306a(Canvas canvas) {
        String str = "Layer#clearLayer";
        C5718c.m10176a(str);
        RectF rectF = this.f9976h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f9975g);
        C5718c.m10178c(str);
    }

    /* renamed from: b */
    private void m10313b(RectF rect, Matrix matrix) {
        this.f9977i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (mo18090c()) {
            int size = this.f9984p.mo17959b().size();
            int i = 0;
            while (i < size) {
                C5741g mask = (C5741g) this.f9984p.mo17959b().get(i);
                this.f9969a.set((Path) ((C5698a) this.f9984p.mo17958a().get(i)).mo17955d());
                this.f9969a.transform(matrix);
                int i2 = C5761b.f9968b[mask.mo18023a().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    this.f9969a.computeBounds(this.f9979k, false);
                    if (i == 0) {
                        this.f9977i.set(this.f9979k);
                    } else {
                        RectF rectF = this.f9977i;
                        rectF.set(Math.min(rectF.left, this.f9979k.left), Math.min(this.f9977i.top, this.f9979k.top), Math.max(this.f9977i.right, this.f9979k.right), Math.max(this.f9977i.bottom, this.f9979k.bottom));
                    }
                    i++;
                } else {
                    return;
                }
            }
            rect.set(Math.max(rect.left, this.f9977i.left), Math.max(rect.top, this.f9977i.top), Math.min(rect.right, this.f9977i.right), Math.min(rect.bottom, this.f9977i.bottom));
        }
    }

    /* renamed from: c */
    private void m10314c(RectF rect, Matrix matrix) {
        if (mo18091d() && this.f9983o.mo18098f() != C5768b.Invert) {
            this.f9985q.mo17934a(this.f9978j, matrix);
            rect.set(Math.max(rect.left, this.f9978j.left), Math.max(rect.top, this.f9978j.top), Math.min(rect.right, this.f9978j.right), Math.min(rect.bottom, this.f9978j.bottom));
        }
    }

    /* renamed from: a */
    private void m10307a(Canvas canvas, Matrix matrix) {
        m10308a(canvas, matrix, C5742a.MaskModeAdd);
        m10308a(canvas, matrix, C5742a.MaskModeIntersect);
        m10308a(canvas, matrix, C5742a.MaskModeSubtract);
    }

    /* renamed from: a */
    private void m10308a(Canvas canvas, Matrix matrix, C5742a maskMode) {
        Paint paint;
        Canvas canvas2 = canvas;
        C5742a aVar = maskMode;
        if (C5761b.f9968b[maskMode.ordinal()] != 1) {
            paint = this.f9972d;
        } else {
            paint = this.f9973e;
        }
        int size = this.f9984p.mo17959b().size();
        boolean hasMask = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            } else if (((C5741g) this.f9984p.mo17959b().get(i)).mo18023a() == aVar) {
                hasMask = true;
                break;
            } else {
                i++;
            }
        }
        if (hasMask) {
            String str = "Layer#drawMask";
            C5718c.m10176a(str);
            String str2 = "Layer#saveLayer";
            C5718c.m10176a(str2);
            m10309a(canvas2, this.f9976h, paint, false);
            C5718c.m10178c(str2);
            m10306a(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (((C5741g) this.f9984p.mo17959b().get(i2)).mo18023a() != aVar) {
                    Matrix matrix2 = matrix;
                } else {
                    this.f9969a.set((Path) ((C5698a) this.f9984p.mo17958a().get(i2)).mo17955d());
                    this.f9969a.transform(matrix);
                    BaseKeyframeAnimation<Integer, Integer> opacityAnimation = (C5698a) this.f9984p.mo17960c().get(i2);
                    int alpha = this.f9971c.getAlpha();
                    this.f9971c.setAlpha((int) (((float) ((Integer) opacityAnimation.mo17955d()).intValue()) * 2.55f));
                    canvas2.drawPath(this.f9969a, this.f9971c);
                    this.f9971c.setAlpha(alpha);
                }
            }
            Matrix matrix3 = matrix;
            String str3 = "Layer#restoreLayer";
            C5718c.m10176a(str3);
            canvas.restore();
            C5718c.m10178c(str3);
            C5718c.m10178c(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo18090c() {
        C5705g gVar = this.f9984p;
        return gVar != null && !gVar.mo17958a().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10311a(boolean visible) {
        if (visible != this.f9990v) {
            this.f9990v = visible;
            m10316f();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18083a(float progress) {
        this.f9989u.mo17968b(progress);
        if (this.f9984p != null) {
            for (int i = 0; i < this.f9984p.mo17958a().size(); i++) {
                ((C5698a) this.f9984p.mo17958a().get(i)).mo17950a(progress);
            }
        }
        if (this.f9983o.mo18112t() != 0.0f) {
            progress /= this.f9983o.mo18112t();
        }
        C5762c cVar = this.f9985q;
        if (cVar != null) {
            this.f9985q.mo18083a(progress * cVar.f9983o.mo18112t());
        }
        for (int i2 = 0; i2 < this.f9988t.size(); i2++) {
            ((C5698a) this.f9988t.get(i2)).mo17950a(progress);
        }
    }

    /* renamed from: e */
    private void m10315e() {
        if (this.f9987s == null) {
            if (this.f9986r == null) {
                this.f9987s = Collections.emptyList();
                return;
            }
            this.f9987s = new ArrayList();
            for (C5762c layer = this.f9986r; layer != null; layer = layer.f9986r) {
                this.f9987s.add(layer);
            }
        }
    }

    public String getName() {
        return this.f9983o.mo18099g();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> list, List<C5678c> list2) {
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        if (keyPath.mo18123c(getName(), depth)) {
            if (!"__container".equals(getName())) {
                currentPartialKeyPath = currentPartialKeyPath.mo18119a(getName());
                if (keyPath.mo18121a(getName(), depth)) {
                    accumulator.add(currentPartialKeyPath.mo18118a((C5777f) this));
                }
            }
            if (keyPath.mo18124d(getName(), depth)) {
                mo18089b(keyPath, keyPath.mo18122b(getName(), depth) + depth, accumulator, currentPartialKeyPath);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18089b(C5776e keyPath, int depth, List<C5776e> list, C5776e currentPartialKeyPath) {
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        this.f9989u.mo17966a(property, callback);
    }
}
