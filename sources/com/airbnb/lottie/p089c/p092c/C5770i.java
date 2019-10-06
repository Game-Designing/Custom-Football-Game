package com.airbnb.lottie.p089c.p092c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p086a.C5679d;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5751n;
import java.util.Collections;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.c.i */
/* compiled from: ShapeLayer */
public class C5770i extends C5762c {

    /* renamed from: w */
    private final C5679d f10034w;

    C5770i(C5851x lottieDrawable, C5766g layerModel) {
        super(lottieDrawable, layerModel);
        this.f10034w = new C5679d(lottieDrawable, this, new C5751n("__container", layerModel.mo18104l()));
        this.f10034w.mo17937a(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18087b(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        this.f10034w.mo17933a(canvas, parentMatrix, parentAlpha);
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        super.mo17934a(outBounds, parentMatrix);
        this.f10034w.mo17934a(outBounds, this.f9981m);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo18089b(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        this.f10034w.mo17935a(keyPath, depth, accumulator, currentPartialKeyPath);
    }
}
