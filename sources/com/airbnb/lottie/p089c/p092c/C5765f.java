package com.airbnb.lottie.p089c.p092c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5714p;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;

/* renamed from: com.airbnb.lottie.c.c.f */
/* compiled from: ImageLayer */
public class C5765f extends C5762c {

    /* renamed from: w */
    private final Paint f9996w = new Paint(3);

    /* renamed from: x */
    private final Rect f9997x = new Rect();

    /* renamed from: y */
    private final Rect f9998y = new Rect();

    /* renamed from: z */
    private C5698a<ColorFilter, ColorFilter> f9999z;

    C5765f(C5851x lottieDrawable, C5766g layerModel) {
        super(lottieDrawable, layerModel);
    }

    /* renamed from: b */
    public void mo18087b(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        Bitmap bitmap = m10338h();
        if (bitmap != null && !bitmap.isRecycled()) {
            float density = C5829f.m10534a();
            this.f9996w.setAlpha(parentAlpha);
            C5698a<ColorFilter, ColorFilter> aVar = this.f9999z;
            if (aVar != null) {
                this.f9996w.setColorFilter((ColorFilter) aVar.mo17955d());
            }
            canvas.save();
            canvas.concat(parentMatrix);
            this.f9997x.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.f9998y.set(0, 0, (int) (((float) bitmap.getWidth()) * density), (int) (((float) bitmap.getHeight()) * density));
            canvas.drawBitmap(bitmap, this.f9997x, this.f9998y, this.f9996w);
            canvas.restore();
        }
    }

    /* renamed from: a */
    public void mo17934a(RectF outBounds, Matrix parentMatrix) {
        super.mo17934a(outBounds, parentMatrix);
        Bitmap bitmap = m10338h();
        if (bitmap != null) {
            outBounds.set(outBounds.left, outBounds.top, Math.min(outBounds.right, (float) bitmap.getWidth()), Math.min(outBounds.bottom, (float) bitmap.getHeight()));
            this.f9981m.mapRect(outBounds);
        }
    }

    /* renamed from: h */
    private Bitmap m10338h() {
        return this.f9982n.mo18223a(this.f9983o.mo18103k());
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        super.mo17936a(property, callback);
        if (property != C5663B.f9618x) {
            return;
        }
        if (callback == null) {
            this.f9999z = null;
        } else {
            this.f9999z = new C5714p(callback);
        }
    }
}
