package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5713o;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5748k;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.airbnb.lottie.a.a.s */
/* compiled from: RepeaterContent */
public class C5694s implements C5680e, C5690o, C5685j, C5699a, C5686k {

    /* renamed from: a */
    private final Matrix f9753a = new Matrix();

    /* renamed from: b */
    private final Path f9754b = new Path();

    /* renamed from: c */
    private final C5851x f9755c;

    /* renamed from: d */
    private final C5762c f9756d;

    /* renamed from: e */
    private final String f9757e;

    /* renamed from: f */
    private final C5698a<Float, Float> f9758f;

    /* renamed from: g */
    private final C5698a<Float, Float> f9759g;

    /* renamed from: h */
    private final C5713o f9760h;

    /* renamed from: i */
    private C5679d f9761i;

    public C5694s(C5851x lottieDrawable, C5762c layer, C5748k repeater) {
        this.f9755c = lottieDrawable;
        this.f9756d = layer;
        this.f9757e = repeater.mo18044b();
        this.f9758f = repeater.mo18043a().mo17984a();
        layer.mo18084a(this.f9758f);
        this.f9758f.mo17951a((C5699a) this);
        this.f9759g = repeater.mo18045c().mo17984a();
        layer.mo18084a(this.f9759g);
        this.f9759g.mo17951a((C5699a) this);
        this.f9760h = repeater.mo18046d().mo17987a();
        this.f9760h.mo17965a(layer);
        this.f9760h.mo17964a((C5699a) this);
    }

    /* renamed from: a */
    public void mo17942a(ListIterator<C5678c> contentsIter) {
        if (this.f9761i == null) {
            while (contentsIter.hasPrevious()) {
                if (contentsIter.previous() == this) {
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            while (contentsIter.hasPrevious()) {
                arrayList.add(contentsIter.previous());
                contentsIter.remove();
            }
            Collections.reverse(arrayList);
            C5679d dVar = new C5679d(this.f9755c, this.f9756d, "Repeater", arrayList, null);
            this.f9761i = dVar;
        }
    }

    public String getName() {
        return this.f9757e;
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> contentsAfter) {
        this.f9761i.mo17937a(contentsBefore, contentsAfter);
    }

    public Path getPath() {
        Path contentPath = this.f9761i.getPath();
        this.f9754b.reset();
        float copies = ((Float) this.f9758f.mo17955d()).floatValue();
        float offset = ((Float) this.f9759g.mo17955d()).floatValue();
        for (int i = ((int) copies) - 1; i >= 0; i--) {
            this.f9753a.set(this.f9760h.mo17962a(((float) i) + offset));
            this.f9754b.addPath(contentPath, this.f9753a);
        }
        return this.f9754b;
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int alpha) {
        float copies = ((Float) this.f9758f.mo17955d()).floatValue();
        float offset = ((Float) this.f9759g.mo17955d()).floatValue();
        float startOpacity = ((Float) this.f9760h.mo17970d().mo17955d()).floatValue() / 100.0f;
        float endOpacity = ((Float) this.f9760h.mo17963a().mo17955d()).floatValue() / 100.0f;
        for (int i = ((int) copies) - 1; i >= 0; i--) {
            this.f9753a.set(parentMatrix);
            this.f9753a.preConcat(this.f9760h.mo17962a(((float) i) + offset));
            this.f9761i.mo17933a(canvas, this.f9753a, (int) (((float) alpha) * C5828e.m10533c(startOpacity, endOpacity, ((float) i) / copies)));
        }
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        this.f9761i.mo17934a(outBounds, parentMatrix);
    }

    /* renamed from: a */
    public void mo17932a() {
        this.f9755c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (!this.f9760h.mo17966a(property, callback)) {
            if (property == C5663B.f9607m) {
                this.f9758f.mo17952a(callback);
            } else if (property == C5663B.f9608n) {
                this.f9759g.mo17952a(callback);
            }
        }
    }
}
