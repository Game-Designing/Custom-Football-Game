package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import p002b.p003c.p050d.C1169c;
import p002b.p003c.p062h.p066c.p067a.C1285a;

/* renamed from: android.support.design.widget.O */
/* compiled from: ShadowDrawableWrapper */
class C0262O extends C1285a {

    /* renamed from: b */
    static final double f1017b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c */
    final Paint f1018c;

    /* renamed from: d */
    final Paint f1019d;

    /* renamed from: e */
    final RectF f1020e;

    /* renamed from: f */
    float f1021f;

    /* renamed from: g */
    Path f1022g;

    /* renamed from: h */
    float f1023h;

    /* renamed from: i */
    float f1024i;

    /* renamed from: j */
    float f1025j;

    /* renamed from: k */
    float f1026k;

    /* renamed from: l */
    private boolean f1027l = true;

    /* renamed from: m */
    private final int f1028m;

    /* renamed from: n */
    private final int f1029n;

    /* renamed from: o */
    private final int f1030o;

    /* renamed from: p */
    private boolean f1031p = true;

    /* renamed from: q */
    private float f1032q;

    /* renamed from: r */
    private boolean f1033r = false;

    public C0262O(Context context, Drawable content, float radius, float shadowSize, float maxShadowSize) {
        super(content);
        this.f1028m = C0510b.m2564a(context, C1169c.design_fab_shadow_start_color);
        this.f1029n = C0510b.m2564a(context, C1169c.design_fab_shadow_mid_color);
        this.f1030o = C0510b.m2564a(context, C1169c.design_fab_shadow_end_color);
        this.f1018c = new Paint(5);
        this.f1018c.setStyle(Style.FILL);
        this.f1021f = (float) Math.round(radius);
        this.f1020e = new RectF();
        this.f1019d = new Paint(this.f1018c);
        this.f1019d.setAntiAlias(false);
        mo4541a(shadowSize, maxShadowSize);
    }

    /* renamed from: c */
    private static int m1612c(float value) {
        int i = Math.round(value);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* renamed from: a */
    public void mo4542a(boolean addPaddingForCorners) {
        this.f1031p = addPaddingForCorners;
        invalidateSelf();
    }

    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        this.f1018c.setAlpha(alpha);
        this.f1019d.setAlpha(alpha);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1027l = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4541a(float shadowSize, float maxShadowSize) {
        if (shadowSize < 0.0f || maxShadowSize < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float shadowSize2 = (float) m1612c(shadowSize);
        float maxShadowSize2 = (float) m1612c(maxShadowSize);
        if (shadowSize2 > maxShadowSize2) {
            shadowSize2 = maxShadowSize2;
            if (!this.f1033r) {
                this.f1033r = true;
            }
        }
        if (this.f1026k != shadowSize2 || this.f1024i != maxShadowSize2) {
            this.f1026k = shadowSize2;
            this.f1024i = maxShadowSize2;
            this.f1025j = (float) Math.round(1.5f * shadowSize2);
            this.f1023h = maxShadowSize2;
            this.f1027l = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect padding) {
        int vOffset = (int) Math.ceil((double) m1611b(this.f1024i, this.f1021f, this.f1031p));
        int hOffset = (int) Math.ceil((double) m1608a(this.f1024i, this.f1021f, this.f1031p));
        padding.set(hOffset, vOffset, hOffset, vOffset);
        return true;
    }

    /* renamed from: b */
    public static float m1611b(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (!addPaddingForCorners) {
            return 1.5f * maxShadowSize;
        }
        double d = (double) (1.5f * maxShadowSize);
        double d2 = 1.0d - f1017b;
        double d3 = (double) cornerRadius;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        Double.isNaN(d);
        return (float) (d + d4);
    }

    /* renamed from: a */
    public static float m1608a(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (!addPaddingForCorners) {
            return maxShadowSize;
        }
        double d = (double) maxShadowSize;
        double d2 = 1.0d - f1017b;
        double d3 = (double) cornerRadius;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        Double.isNaN(d);
        return (float) (d + d4);
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.f1027l) {
            m1610a(getBounds());
            this.f1027l = false;
        }
        m1609a(canvas);
        super.draw(canvas);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4540a(float rotation) {
        if (this.f1032q != rotation) {
            this.f1032q = rotation;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private void m1609a(Canvas canvas) {
        float shadowScaleHorizontal;
        float shadowScaleTop;
        float shadowOffsetHorizontal;
        int saved;
        float shadowScaleBottom;
        float shadowScaleHorizontal2;
        Canvas canvas2 = canvas;
        int rotateSaved = canvas.save();
        canvas2.rotate(this.f1032q, this.f1020e.centerX(), this.f1020e.centerY());
        float edgeShadowTop = (-this.f1021f) - this.f1025j;
        float shadowOffset = this.f1021f;
        boolean z = true;
        boolean drawHorizontalEdges = this.f1020e.width() - (shadowOffset * 2.0f) > 0.0f;
        if (this.f1020e.height() - (shadowOffset * 2.0f) <= 0.0f) {
            z = false;
        }
        boolean drawVerticalEdges = z;
        float f = this.f1026k;
        float shadowOffsetTop = f - (0.25f * f);
        float shadowOffsetHorizontal2 = f - (0.5f * f);
        float shadowScaleHorizontal3 = shadowOffset / (shadowOffset + shadowOffsetHorizontal2);
        float shadowScaleTop2 = shadowOffset / (shadowOffset + shadowOffsetTop);
        float shadowScaleBottom2 = shadowOffset / (shadowOffset + (f - (f * 1.0f)));
        int saved2 = canvas.save();
        RectF rectF = this.f1020e;
        canvas2.translate(rectF.left + shadowOffset, rectF.top + shadowOffset);
        canvas2.scale(shadowScaleHorizontal3, shadowScaleTop2);
        canvas2.drawPath(this.f1022g, this.f1018c);
        if (drawHorizontalEdges) {
            canvas2.scale(1.0f / shadowScaleHorizontal3, 1.0f);
            float f2 = shadowOffsetTop;
            saved = saved2;
            shadowScaleBottom = shadowScaleBottom2;
            shadowScaleTop = shadowScaleTop2;
            shadowScaleHorizontal = shadowScaleHorizontal3;
            float f3 = shadowOffsetHorizontal2;
            shadowOffsetHorizontal = 1.0f;
            canvas.drawRect(0.0f, edgeShadowTop, this.f1020e.width() - (shadowOffset * 2.0f), -this.f1021f, this.f1019d);
        } else {
            shadowScaleBottom = shadowScaleBottom2;
            shadowScaleTop = shadowScaleTop2;
            shadowScaleHorizontal = shadowScaleHorizontal3;
            float f4 = shadowOffsetTop;
            float f5 = shadowOffsetHorizontal2;
            shadowOffsetHorizontal = 1.0f;
            saved = saved2;
        }
        canvas2.restoreToCount(saved);
        int saved3 = canvas.save();
        RectF rectF2 = this.f1020e;
        canvas2.translate(rectF2.right - shadowOffset, rectF2.bottom - shadowOffset);
        float shadowScaleHorizontal4 = shadowScaleHorizontal;
        canvas2.scale(shadowScaleHorizontal4, shadowScaleBottom);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.f1022g, this.f1018c);
        if (drawHorizontalEdges) {
            canvas2.scale(shadowOffsetHorizontal / shadowScaleHorizontal4, shadowOffsetHorizontal);
            shadowScaleHorizontal2 = shadowScaleHorizontal4;
            canvas.drawRect(0.0f, edgeShadowTop, this.f1020e.width() - (shadowOffset * 2.0f), (-this.f1021f) + this.f1025j, this.f1019d);
        } else {
            shadowScaleHorizontal2 = shadowScaleHorizontal4;
        }
        canvas2.restoreToCount(saved3);
        int saved4 = canvas.save();
        RectF rectF3 = this.f1020e;
        canvas2.translate(rectF3.left + shadowOffset, rectF3.bottom - shadowOffset);
        canvas2.scale(shadowScaleHorizontal2, shadowScaleBottom);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.f1022g, this.f1018c);
        if (drawVerticalEdges) {
            canvas2.scale(1.0f / shadowScaleBottom, 1.0f);
            canvas.drawRect(0.0f, edgeShadowTop, this.f1020e.height() - (shadowOffset * 2.0f), -this.f1021f, this.f1019d);
        }
        canvas2.restoreToCount(saved4);
        int saved5 = canvas.save();
        RectF rectF4 = this.f1020e;
        canvas2.translate(rectF4.right - shadowOffset, rectF4.top + shadowOffset);
        float shadowScaleTop3 = shadowScaleTop;
        canvas2.scale(shadowScaleHorizontal2, shadowScaleTop3);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.f1022g, this.f1018c);
        if (drawVerticalEdges) {
            canvas2.scale(1.0f / shadowScaleTop3, 1.0f);
            float f6 = shadowScaleTop3;
            canvas.drawRect(0.0f, edgeShadowTop, this.f1020e.height() - (2.0f * shadowOffset), -this.f1021f, this.f1019d);
        }
        canvas2.restoreToCount(saved5);
        canvas2.restoreToCount(rotateSaved);
    }

    /* renamed from: c */
    private void m1613c() {
        float f = this.f1021f;
        RectF innerBounds = new RectF(-f, -f, f, f);
        RectF outerBounds = new RectF(innerBounds);
        float f2 = this.f1025j;
        outerBounds.inset(-f2, -f2);
        Path path = this.f1022g;
        if (path == null) {
            this.f1022g = new Path();
        } else {
            path.reset();
        }
        this.f1022g.setFillType(FillType.EVEN_ODD);
        this.f1022g.moveTo(-this.f1021f, 0.0f);
        this.f1022g.rLineTo(-this.f1025j, 0.0f);
        this.f1022g.arcTo(outerBounds, 180.0f, 90.0f, false);
        this.f1022g.arcTo(innerBounds, 270.0f, -90.0f, false);
        this.f1022g.close();
        float shadowRadius = -outerBounds.top;
        if (shadowRadius > 0.0f) {
            float startRatio = this.f1021f / shadowRadius;
            float midRatio = startRatio + ((1.0f - startRatio) / 2.0f);
            RadialGradient radialGradient = r8;
            Paint paint = this.f1018c;
            RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, shadowRadius, new int[]{0, this.f1028m, this.f1029n, this.f1030o}, new float[]{0.0f, startRatio, midRatio, 1.0f}, TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        Paint paint2 = this.f1019d;
        float f3 = innerBounds.top;
        LinearGradient linearGradient = new LinearGradient(0.0f, f3, 0.0f, outerBounds.top, new int[]{this.f1028m, this.f1029n, this.f1030o}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f1019d.setAntiAlias(false);
    }

    /* renamed from: a */
    private void m1610a(Rect bounds) {
        float f = this.f1024i;
        float verticalOffset = 1.5f * f;
        this.f1020e.set(((float) bounds.left) + f, ((float) bounds.top) + verticalOffset, ((float) bounds.right) - f, ((float) bounds.bottom) - verticalOffset);
        Drawable a = mo9184a();
        RectF rectF = this.f1020e;
        a.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        m1613c();
    }

    /* renamed from: b */
    public void mo4544b(float size) {
        mo4541a(size, this.f1024i);
    }

    /* renamed from: b */
    public float mo4543b() {
        return this.f1026k;
    }
}
