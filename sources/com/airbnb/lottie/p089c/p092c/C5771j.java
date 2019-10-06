package com.airbnb.lottie.p089c.p092c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p096g.C5833c;

/* renamed from: com.airbnb.lottie.c.c.j */
/* compiled from: SolidLayer */
public class C5771j extends C5762c {

    /* renamed from: A */
    private final C5766g f10035A;

    /* renamed from: B */
    private C5698a<ColorFilter, ColorFilter> f10036B;

    /* renamed from: w */
    private final RectF f10037w = new RectF();

    /* renamed from: x */
    private final Paint f10038x = new Paint();

    /* renamed from: y */
    private final float[] f10039y = new float[8];

    /* renamed from: z */
    private final Path f10040z = new Path();

    C5771j(C5851x lottieDrawable, C5766g layerModel) {
        super(lottieDrawable, layerModel);
        this.f10035A = layerModel;
        this.f10038x.setAlpha(0);
        this.f10038x.setStyle(Style.FILL);
        this.f10038x.setColor(layerModel.mo18105m());
    }

    /* renamed from: b */
    public void mo18087b(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        int backgroundAlpha = Color.alpha(this.f10035A.mo18105m());
        if (backgroundAlpha != 0) {
            int alpha = (int) ((((float) parentAlpha) / 255.0f) * (((((float) backgroundAlpha) / 255.0f) * ((float) ((Integer) this.f9989u.mo17969c().mo17955d()).intValue())) / 100.0f) * 255.0f);
            this.f10038x.setAlpha(alpha);
            C5698a<ColorFilter, ColorFilter> aVar = this.f10036B;
            if (aVar != null) {
                this.f10038x.setColorFilter((ColorFilter) aVar.mo17955d());
            }
            if (alpha > 0) {
                float[] fArr = this.f10039y;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.f10035A.mo18107o();
                float[] fArr2 = this.f10039y;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.f10035A.mo18107o();
                this.f10039y[5] = (float) this.f10035A.mo18106n();
                float[] fArr3 = this.f10039y;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.f10035A.mo18106n();
                parentMatrix.mapPoints(this.f10039y);
                this.f10040z.reset();
                Path path = this.f10040z;
                float[] fArr4 = this.f10039y;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.f10040z;
                float[] fArr5 = this.f10039y;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.f10040z;
                float[] fArr6 = this.f10039y;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.f10040z;
                float[] fArr7 = this.f10039y;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.f10040z;
                float[] fArr8 = this.f10039y;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.f10040z.close();
                canvas.drawPath(this.f10040z, this.f10038x);
            } else {
                Canvas canvas2 = canvas;
                Matrix matrix = parentMatrix;
            }
        }
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        super.mo17934a(outBounds, parentMatrix);
        this.f10037w.set(0.0f, 0.0f, (float) this.f10035A.mo18107o(), (float) this.f10035A.mo18106n());
        this.f9981m.mapRect(this.f10037w);
        outBounds.set(this.f10037w);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        super.mo17936a(property, callback);
        if (property != C5663B.f9618x) {
            return;
        }
        if (callback == null) {
            this.f10036B = null;
        } else {
            this.f10036B = new C5714p(callback);
        }
    }
}
