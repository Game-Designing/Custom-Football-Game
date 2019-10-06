package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import p002b.p003c.p053g.p054a.C1199a;

/* renamed from: android.support.design.widget.y */
/* compiled from: CircularBorderDrawable */
class C0320y extends Drawable {

    /* renamed from: a */
    final Paint f1134a = new Paint(1);

    /* renamed from: b */
    final Rect f1135b = new Rect();

    /* renamed from: c */
    final RectF f1136c = new RectF();

    /* renamed from: d */
    float f1137d;

    /* renamed from: e */
    private int f1138e;

    /* renamed from: f */
    private int f1139f;

    /* renamed from: g */
    private int f1140g;

    /* renamed from: h */
    private int f1141h;

    /* renamed from: i */
    private ColorStateList f1142i;

    /* renamed from: j */
    private int f1143j;

    /* renamed from: k */
    private boolean f1144k = true;

    /* renamed from: l */
    private float f1145l;

    public C0320y() {
        this.f1134a.setStyle(Style.STROKE);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4709a(int topOuterStrokeColor, int topInnerStrokeColor, int bottomOuterStrokeColor, int bottomInnerStrokeColor) {
        this.f1138e = topOuterStrokeColor;
        this.f1139f = topInnerStrokeColor;
        this.f1140g = bottomOuterStrokeColor;
        this.f1141h = bottomInnerStrokeColor;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4708a(float width) {
        if (this.f1137d != width) {
            this.f1137d = width;
            this.f1134a.setStrokeWidth(1.3333f * width);
            this.f1144k = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f1144k) {
            this.f1134a.setShader(m1733a());
            this.f1144k = false;
        }
        float halfBorderWidth = this.f1134a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f1136c;
        copyBounds(this.f1135b);
        rectF.set(this.f1135b);
        rectF.left += halfBorderWidth;
        rectF.top += halfBorderWidth;
        rectF.right -= halfBorderWidth;
        rectF.bottom -= halfBorderWidth;
        canvas.save();
        canvas.rotate(this.f1145l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f1134a);
        canvas.restore();
    }

    public boolean getPadding(Rect padding) {
        int borderWidth = Math.round(this.f1137d);
        padding.set(borderWidth, borderWidth, borderWidth, borderWidth);
        return true;
    }

    public void setAlpha(int alpha) {
        this.f1134a.setAlpha(alpha);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4710a(ColorStateList tint) {
        if (tint != null) {
            this.f1143j = tint.getColorForState(getState(), this.f1143j);
        }
        this.f1142i = tint;
        this.f1144k = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1134a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f1137d > 0.0f ? -3 : -2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo4711b(float rotation) {
        if (rotation != this.f1145l) {
            this.f1145l = rotation;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1144k = true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1142i;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] state) {
        ColorStateList colorStateList = this.f1142i;
        if (colorStateList != null) {
            int newColor = colorStateList.getColorForState(state, this.f1143j);
            if (newColor != this.f1143j) {
                this.f1144k = true;
                this.f1143j = newColor;
            }
        }
        if (this.f1144k != 0) {
            invalidateSelf();
        }
        return this.f1144k;
    }

    /* renamed from: a */
    private Shader m1733a() {
        Rect rect = this.f1135b;
        copyBounds(rect);
        float borderRatio = this.f1137d / ((float) rect.height());
        LinearGradient linearGradient = new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C1199a.m5718a(this.f1138e, this.f1143j), C1199a.m5718a(this.f1139f, this.f1143j), C1199a.m5718a(C1199a.m5722b(this.f1139f, 0), this.f1143j), C1199a.m5718a(C1199a.m5722b(this.f1141h, 0), this.f1143j), C1199a.m5718a(this.f1141h, this.f1143j), C1199a.m5718a(this.f1140g, this.f1143j)}, new float[]{0.0f, borderRatio, 0.5f, 0.5f, 1.0f - borderRatio, 1.0f}, TileMode.CLAMP);
        return linearGradient;
    }
}
