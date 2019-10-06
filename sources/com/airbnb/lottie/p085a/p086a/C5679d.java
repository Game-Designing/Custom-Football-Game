package com.airbnb.lottie.p085a.p086a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GreedyContent;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5713o;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.C5777f;
import com.airbnb.lottie.p089c.p090a.C5731l;
import com.airbnb.lottie.p089c.p091b.C5736b;
import com.airbnb.lottie.p089c.p091b.C5751n;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.d */
/* compiled from: ContentGroup */
public class C5679d implements C5680e, C5690o, C5699a, C5777f {

    /* renamed from: a */
    private final Matrix f9672a;

    /* renamed from: b */
    private final Path f9673b;

    /* renamed from: c */
    private final RectF f9674c;

    /* renamed from: d */
    private final String f9675d;

    /* renamed from: e */
    private final List<C5678c> f9676e;

    /* renamed from: f */
    private final C5851x f9677f;

    /* renamed from: g */
    private List<C5690o> f9678g;

    /* renamed from: h */
    private C5713o f9679h;

    /* renamed from: a */
    private static List<C5678c> m10041a(C5851x drawable, C5762c layer, List<C5736b> contentModels) {
        List<Content> contents = new ArrayList<>(contentModels.size());
        for (int i = 0; i < contentModels.size(); i++) {
            C5678c content = ((C5736b) contentModels.get(i)).mo17986a(drawable, layer);
            if (content != null) {
                contents.add(content);
            }
        }
        return contents;
    }

    /* renamed from: a */
    static C5731l m10040a(List<C5736b> contentModels) {
        for (int i = 0; i < contentModels.size(); i++) {
            C5736b contentModel = (C5736b) contentModels.get(i);
            if (contentModel instanceof C5731l) {
                return (C5731l) contentModel;
            }
        }
        return null;
    }

    public C5679d(C5851x lottieDrawable, C5762c layer, C5751n shapeGroup) {
        this(lottieDrawable, layer, shapeGroup.mo18058b(), m10041a(lottieDrawable, layer, shapeGroup.mo18057a()), m10040a(shapeGroup.mo18057a()));
    }

    C5679d(C5851x lottieDrawable, C5762c layer, String name, List<C5678c> contents, C5731l transform) {
        this.f9672a = new Matrix();
        this.f9673b = new Path();
        this.f9674c = new RectF();
        this.f9675d = name;
        this.f9677f = lottieDrawable;
        this.f9676e = contents;
        if (transform != null) {
            this.f9679h = transform.mo17987a();
            this.f9679h.mo17965a(layer);
            this.f9679h.mo17964a((C5699a) this);
        }
        List<GreedyContent> greedyContents = new ArrayList<>();
        for (int i = contents.size() - 1; i >= 0; i--) {
            C5678c content = (C5678c) contents.get(i);
            if (content instanceof C5685j) {
                greedyContents.add((C5685j) content);
            }
        }
        for (int i2 = greedyContents.size() - 1; i2 >= 0; i2--) {
            ((C5685j) greedyContents.get(i2)).mo17942a(contents.listIterator(contents.size()));
        }
    }

    /* renamed from: a */
    public void mo17932a() {
        this.f9677f.invalidateSelf();
    }

    public String getName() {
        return this.f9675d;
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> list) {
        List<Content> myContentsBefore = new ArrayList<>(contentsBefore.size() + this.f9676e.size());
        myContentsBefore.addAll(contentsBefore);
        for (int i = this.f9676e.size() - 1; i >= 0; i--) {
            C5678c content = (C5678c) this.f9676e.get(i);
            content.mo17937a(myContentsBefore, this.f9676e.subList(0, i));
            myContentsBefore.add(content);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public List<C5690o> mo17939b() {
        if (this.f9678g == null) {
            this.f9678g = new ArrayList();
            for (int i = 0; i < this.f9676e.size(); i++) {
                C5678c content = (C5678c) this.f9676e.get(i);
                if (content instanceof C5690o) {
                    this.f9678g.add((C5690o) content);
                }
            }
        }
        return this.f9678g;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Matrix mo17940c() {
        C5713o oVar = this.f9679h;
        if (oVar != null) {
            return oVar.mo17967b();
        }
        this.f9672a.reset();
        return this.f9672a;
    }

    public Path getPath() {
        this.f9672a.reset();
        C5713o oVar = this.f9679h;
        if (oVar != null) {
            this.f9672a.set(oVar.mo17967b());
        }
        this.f9673b.reset();
        for (int i = this.f9676e.size() - 1; i >= 0; i--) {
            C5678c content = (C5678c) this.f9676e.get(i);
            if (content instanceof C5690o) {
                this.f9673b.addPath(((C5690o) content).getPath(), this.f9672a);
            }
        }
        return this.f9673b;
    }

    /* renamed from: a */
    public void mo17933a(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        int alpha;
        this.f9672a.set(parentMatrix);
        C5713o oVar = this.f9679h;
        if (oVar != null) {
            this.f9672a.preConcat(oVar.mo17967b());
            alpha = (int) ((((((float) ((Integer) this.f9679h.mo17969c().mo17955d()).intValue()) / 100.0f) * ((float) parentAlpha)) / 255.0f) * 255.0f);
        } else {
            alpha = parentAlpha;
        }
        for (int i = this.f9676e.size() - 1; i >= 0; i--) {
            Object content = this.f9676e.get(i);
            if (content instanceof C5680e) {
                ((C5680e) content).mo17933a(canvas, this.f9672a, alpha);
            }
        }
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        this.f9672a.set(parentMatrix);
        C5713o oVar = this.f9679h;
        if (oVar != null) {
            this.f9672a.preConcat(oVar.mo17967b());
        }
        this.f9674c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i = this.f9676e.size() - 1; i >= 0; i--) {
            C5678c content = (C5678c) this.f9676e.get(i);
            if (content instanceof C5680e) {
                ((C5680e) content).mo17934a(this.f9674c, this.f9672a);
                if (outBounds.isEmpty()) {
                    outBounds.set(this.f9674c);
                } else {
                    outBounds.set(Math.min(outBounds.left, this.f9674c.left), Math.min(outBounds.top, this.f9674c.top), Math.max(outBounds.right, this.f9674c.right), Math.max(outBounds.bottom, this.f9674c.bottom));
                }
            }
        }
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
                int newDepth = keyPath.mo18122b(getName(), depth) + depth;
                for (int i = 0; i < this.f9676e.size(); i++) {
                    C5678c content = (C5678c) this.f9676e.get(i);
                    if (content instanceof C5777f) {
                        ((C5777f) content).mo17935a(keyPath, newDepth, accumulator, currentPartialKeyPath);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        C5713o oVar = this.f9679h;
        if (oVar != null) {
            oVar.mo17966a(property, callback);
        }
    }
}
