package com.airbnb.lottie.p089c.p092c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.v4.util.LongSparseArray;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.C5830g;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p090a.C5721b;
import com.airbnb.lottie.p096g.C5833c;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p053g.p061f.C1259h;

/* renamed from: com.airbnb.lottie.c.c.e */
/* compiled from: CompositionLayer */
public class C5764e extends C5762c {

    /* renamed from: w */
    private C5698a<Float, Float> f9992w;

    /* renamed from: x */
    private final List<C5762c> f9993x = new ArrayList();

    /* renamed from: y */
    private final RectF f9994y = new RectF();

    /* renamed from: z */
    private final RectF f9995z = new RectF();

    public C5764e(C5851x lottieDrawable, C5766g layerModel, List<C5766g> layerModels, C5830g composition) {
        super(lottieDrawable, layerModel);
        C5721b timeRemapping = layerModel.mo18111s();
        if (timeRemapping != null) {
            this.f9992w = timeRemapping.mo17984a();
            mo18084a(this.f9992w);
            this.f9992w.mo17951a((C5699a) this);
        } else {
            this.f9992w = null;
        }
        LongSparseArray<BaseLayer> layerMap = new C1259h<>(composition.mo18199i().size());
        C5762c mattedLayer = null;
        for (int i = layerModels.size() - 1; i >= 0; i--) {
            C5766g lm = (C5766g) layerModels.get(i);
            C5762c layer = C5762c.m10305a(lm, lottieDrawable, composition);
            if (layer != null) {
                layerMap.mo9063c(layer.mo18086b().mo18094b(), layer);
                if (mattedLayer != null) {
                    mattedLayer.mo18085a(layer);
                    mattedLayer = null;
                } else {
                    this.f9993x.add(0, layer);
                    int i2 = C5763d.f9991a[lm.mo18098f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        mattedLayer = layer;
                    }
                }
            }
        }
        for (int i3 = 0; i3 < layerMap.mo9057b(); i3++) {
            C5762c layerView = (C5762c) layerMap.mo9058b(layerMap.mo9053a(i3));
            if (layerView != null) {
                C5762c parentLayer = (C5762c) layerMap.mo9058b(layerView.mo18086b().mo18100h());
                if (parentLayer != null) {
                    layerView.mo18088b(parentLayer);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18087b(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        String str = "CompositionLayer#draw";
        C5718c.m10176a(str);
        canvas.save();
        this.f9995z.set(0.0f, 0.0f, (float) this.f9983o.mo18102j(), (float) this.f9983o.mo18101i());
        parentMatrix.mapRect(this.f9995z);
        for (int i = this.f9993x.size() - 1; i >= 0; i--) {
            boolean nonEmptyClip = true;
            if (!this.f9995z.isEmpty()) {
                nonEmptyClip = canvas.clipRect(this.f9995z);
            }
            if (nonEmptyClip) {
                ((C5762c) this.f9993x.get(i)).mo17933a(canvas, parentMatrix, parentAlpha);
            }
        }
        canvas.restore();
        C5718c.m10178c(str);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        super.mo17934a(outBounds, parentMatrix);
        this.f9994y.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i = this.f9993x.size() - 1; i >= 0; i--) {
            ((C5762c) this.f9993x.get(i)).mo17934a(this.f9994y, this.f9981m);
            if (outBounds.isEmpty()) {
                outBounds.set(this.f9994y);
            } else {
                outBounds.set(Math.min(outBounds.left, this.f9994y.left), Math.min(outBounds.top, this.f9994y.top), Math.max(outBounds.right, this.f9994y.right), Math.max(outBounds.bottom, this.f9994y.bottom));
            }
        }
    }

    /* renamed from: a */
    public void mo18083a(float progress) {
        super.mo18083a(progress);
        if (this.f9992w != null) {
            progress = ((float) ((long) (((Float) this.f9992w.mo17955d()).floatValue() * 1000.0f))) / this.f9982n.mo18247e().mo18193c();
        }
        if (this.f9983o.mo18112t() != 0.0f) {
            progress /= this.f9983o.mo18112t();
        }
        float progress2 = progress - this.f9983o.mo18108p();
        for (int i = this.f9993x.size() - 1; i >= 0; i--) {
            ((C5762c) this.f9993x.get(i)).mo18083a(progress2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo18089b(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        for (int i = 0; i < this.f9993x.size(); i++) {
            ((C5762c) this.f9993x.get(i)).mo17935a(keyPath, depth, accumulator, currentPartialKeyPath);
        }
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        super.mo17936a(property, callback);
        if (property != C5663B.f9617w) {
            return;
        }
        if (callback == null) {
            this.f9992w = null;
            return;
        }
        this.f9992w = new C5714p(callback);
        mo18084a(this.f9992w);
    }
}
