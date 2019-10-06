package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5750m;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.g */
/* compiled from: FillContent */
public class C5682g implements C5680e, C5699a, C5686k {

    /* renamed from: a */
    private final Path f9688a = new Path();

    /* renamed from: b */
    private final Paint f9689b = new Paint(1);

    /* renamed from: c */
    private final C5762c f9690c;

    /* renamed from: d */
    private final String f9691d;

    /* renamed from: e */
    private final List<C5690o> f9692e = new ArrayList();

    /* renamed from: f */
    private final C5698a<Integer, Integer> f9693f;

    /* renamed from: g */
    private final C5698a<Integer, Integer> f9694g;

    /* renamed from: h */
    private C5698a<ColorFilter, ColorFilter> f9695h;

    /* renamed from: i */
    private final C5851x f9696i;

    public C5682g(C5851x lottieDrawable, C5762c layer, C5750m fill) {
        this.f9690c = layer;
        this.f9691d = fill.mo18054c();
        this.f9696i = lottieDrawable;
        if (fill.mo18052a() == null || fill.mo18055d() == null) {
            this.f9693f = null;
            this.f9694g = null;
            return;
        }
        this.f9688a.setFillType(fill.mo18053b());
        this.f9693f = fill.mo18052a().mo17984a();
        this.f9693f.mo17951a((C5699a) this);
        layer.mo18084a(this.f9693f);
        this.f9694g = fill.mo18055d().mo17984a();
        this.f9694g.mo17951a((C5699a) this);
        layer.mo18084a(this.f9694g);
    }

    /* renamed from: a */
    public void mo17932a() {
        this.f9696i.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> list, List<C5678c> contentsAfter) {
        for (int i = 0; i < contentsAfter.size(); i++) {
            C5678c content = (C5678c) contentsAfter.get(i);
            if (content instanceof C5690o) {
                this.f9692e.add((C5690o) content);
            }
        }
    }

    public String getName() {
        return this.f9691d;
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        String str = "FillContent#draw";
        C5718c.m10176a(str);
        this.f9689b.setColor(((Integer) this.f9693f.mo17955d()).intValue());
        this.f9689b.setAlpha(C5828e.m10527a((int) ((((((float) parentAlpha) / 255.0f) * ((float) ((Integer) this.f9694g.mo17955d()).intValue())) / 100.0f) * 255.0f), 0, 255));
        C5698a<ColorFilter, ColorFilter> aVar = this.f9695h;
        if (aVar != null) {
            this.f9689b.setColorFilter((ColorFilter) aVar.mo17955d());
        }
        this.f9688a.reset();
        for (int i = 0; i < this.f9692e.size(); i++) {
            this.f9688a.addPath(((C5690o) this.f9692e.get(i)).getPath(), parentMatrix);
        }
        canvas.drawPath(this.f9688a, this.f9689b);
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        this.f9688a.reset();
        for (int i = 0; i < this.f9692e.size(); i++) {
            this.f9688a.addPath(((C5690o) this.f9692e.get(i)).getPath(), parentMatrix);
        }
        this.f9688a.computeBounds(outBounds, false);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (property == C5663B.f9595a) {
            this.f9693f.mo17952a(callback);
        } else if (property == C5663B.f9598d) {
            this.f9694g.mo17952a(callback);
        } else if (property != C5663B.f9618x) {
        } else {
            if (callback == null) {
                this.f9695h = null;
                return;
            }
            this.f9695h = new C5714p(callback);
            this.f9695h.mo17951a((C5699a) this);
            this.f9690c.mo18084a(this.f9695h);
        }
    }
}
