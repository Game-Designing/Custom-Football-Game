package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import p002b.p003c.p062h.p063a.C1277b;
import p002b.p003c.p062h.p063a.C1278c;

/* renamed from: android.support.v7.widget.Oa */
/* compiled from: RoundRectDrawableWithShadow */
class C0963Oa extends Drawable {

    /* renamed from: a */
    private static final double f3063a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b */
    static C0964a f3064b;

    /* renamed from: c */
    private final int f3065c;

    /* renamed from: d */
    private Paint f3066d;

    /* renamed from: e */
    private Paint f3067e;

    /* renamed from: f */
    private Paint f3068f;

    /* renamed from: g */
    private final RectF f3069g;

    /* renamed from: h */
    private float f3070h;

    /* renamed from: i */
    private Path f3071i;

    /* renamed from: j */
    private float f3072j;

    /* renamed from: k */
    private float f3073k;

    /* renamed from: l */
    private float f3074l;

    /* renamed from: m */
    private ColorStateList f3075m;

    /* renamed from: n */
    private boolean f3076n = true;

    /* renamed from: o */
    private final int f3077o;

    /* renamed from: p */
    private final int f3078p;

    /* renamed from: q */
    private boolean f3079q = true;

    /* renamed from: r */
    private boolean f3080r = false;

    /* renamed from: android.support.v7.widget.Oa$a */
    /* compiled from: RoundRectDrawableWithShadow */
    interface C0964a {
        /* renamed from: a */
        void mo7344a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    C0963Oa(Resources resources, ColorStateList backgroundColor, float radius, float shadowSize, float maxShadowSize) {
        this.f3077o = resources.getColor(C1277b.cardview_shadow_start_color);
        this.f3078p = resources.getColor(C1277b.cardview_shadow_end_color);
        this.f3065c = resources.getDimensionPixelSize(C1278c.cardview_compat_inset_shadow);
        this.f3066d = new Paint(5);
        m4650b(backgroundColor);
        this.f3067e = new Paint(5);
        this.f3067e.setStyle(Style.FILL);
        this.f3070h = (float) ((int) (0.5f + radius));
        this.f3069g = new RectF();
        this.f3068f = new Paint(this.f3067e);
        this.f3068f.setAntiAlias(false);
        m4647a(shadowSize, maxShadowSize);
    }

    /* renamed from: b */
    private void m4650b(ColorStateList color) {
        this.f3075m = color == null ? ColorStateList.valueOf(0) : color;
        this.f3066d.setColor(this.f3075m.getColorForState(getState(), this.f3075m.getDefaultColor()));
    }

    /* renamed from: d */
    private int m4652d(float value) {
        int i = (int) (0.5f + value);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7494a(boolean addPaddingForCorners) {
        this.f3079q = addPaddingForCorners;
        invalidateSelf();
    }

    public void setAlpha(int alpha) {
        this.f3066d.setAlpha(alpha);
        this.f3067e.setAlpha(alpha);
        this.f3068f.setAlpha(alpha);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        this.f3076n = true;
    }

    /* renamed from: a */
    private void m4647a(float shadowSize, float maxShadowSize) {
        String str = ". Must be >= 0";
        if (shadowSize < 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid shadow size ");
            sb.append(shadowSize);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (maxShadowSize >= 0.0f) {
            float shadowSize2 = (float) m4652d(shadowSize);
            float maxShadowSize2 = (float) m4652d(maxShadowSize);
            if (shadowSize2 > maxShadowSize2) {
                shadowSize2 = maxShadowSize2;
                if (!this.f3080r) {
                    this.f3080r = true;
                }
            }
            if (this.f3074l != shadowSize2 || this.f3072j != maxShadowSize2) {
                this.f3074l = shadowSize2;
                this.f3072j = maxShadowSize2;
                this.f3073k = (float) ((int) ((1.5f * shadowSize2) + ((float) this.f3065c) + 0.5f));
                this.f3076n = true;
                invalidateSelf();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid max shadow size ");
            sb2.append(maxShadowSize);
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public boolean getPadding(Rect padding) {
        int vOffset = (int) Math.ceil((double) m4649b(this.f3072j, this.f3070h, this.f3079q));
        int hOffset = (int) Math.ceil((double) m4646a(this.f3072j, this.f3070h, this.f3079q));
        padding.set(hOffset, vOffset, hOffset, vOffset);
        return true;
    }

    /* renamed from: b */
    static float m4649b(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (!addPaddingForCorners) {
            return 1.5f * maxShadowSize;
        }
        double d = (double) (1.5f * maxShadowSize);
        double d2 = 1.0d - f3063a;
        double d3 = (double) cornerRadius;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        Double.isNaN(d);
        return (float) (d + d4);
    }

    /* renamed from: a */
    static float m4646a(float maxShadowSize, float cornerRadius, boolean addPaddingForCorners) {
        if (!addPaddingForCorners) {
            return maxShadowSize;
        }
        double d = (double) maxShadowSize;
        double d2 = 1.0d - f3063a;
        double d3 = (double) cornerRadius;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        Double.isNaN(d);
        return (float) (d + d4);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        ColorStateList colorStateList = this.f3075m;
        int newColor = colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        if (this.f3066d.getColor() == newColor) {
            return false;
        }
        this.f3066d.setColor(newColor);
        this.f3076n = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f3075m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter cf) {
        this.f3066d.setColorFilter(cf);
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7491a(float radius) {
        if (radius >= 0.0f) {
            float radius2 = (float) ((int) (0.5f + radius));
            if (this.f3070h != radius2) {
                this.f3070h = radius2;
                this.f3076n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid radius ");
        sb.append(radius);
        sb.append(". Must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    public void draw(Canvas canvas) {
        if (this.f3076n) {
            m4651b(getBounds());
            this.f3076n = false;
        }
        canvas.translate(0.0f, this.f3074l / 2.0f);
        m4648a(canvas);
        canvas.translate(0.0f, (-this.f3074l) / 2.0f);
        f3064b.mo7344a(canvas, this.f3069g, this.f3070h, this.f3066d);
    }

    /* renamed from: a */
    private void m4648a(Canvas canvas) {
        float f = this.f3070h;
        float edgeShadowTop = (-f) - this.f3073k;
        float inset = f + ((float) this.f3065c) + (this.f3074l / 2.0f);
        boolean z = true;
        boolean drawHorizontalEdges = this.f3069g.width() - (inset * 2.0f) > 0.0f;
        if (this.f3069g.height() - (inset * 2.0f) <= 0.0f) {
            z = false;
        }
        boolean drawVerticalEdges = z;
        int saved = canvas.save();
        RectF rectF = this.f3069g;
        canvas.translate(rectF.left + inset, rectF.top + inset);
        canvas.drawPath(this.f3071i, this.f3067e);
        if (drawHorizontalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.f3069g.width() - (inset * 2.0f), -this.f3070h, this.f3068f);
        }
        canvas.restoreToCount(saved);
        int saved2 = canvas.save();
        RectF rectF2 = this.f3069g;
        canvas.translate(rectF2.right - inset, rectF2.bottom - inset);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f3071i, this.f3067e);
        if (drawHorizontalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.f3069g.width() - (inset * 2.0f), (-this.f3070h) + this.f3073k, this.f3068f);
        }
        canvas.restoreToCount(saved2);
        int saved3 = canvas.save();
        RectF rectF3 = this.f3069g;
        canvas.translate(rectF3.left + inset, rectF3.bottom - inset);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f3071i, this.f3067e);
        if (drawVerticalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.f3069g.height() - (inset * 2.0f), -this.f3070h, this.f3068f);
        }
        canvas.restoreToCount(saved3);
        int saved4 = canvas.save();
        RectF rectF4 = this.f3069g;
        canvas.translate(rectF4.right - inset, rectF4.top + inset);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f3071i, this.f3067e);
        if (drawVerticalEdges) {
            canvas.drawRect(0.0f, edgeShadowTop, this.f3069g.height() - (2.0f * inset), -this.f3070h, this.f3068f);
        }
        canvas.restoreToCount(saved4);
    }

    /* renamed from: g */
    private void m4653g() {
        float f = this.f3070h;
        RectF innerBounds = new RectF(-f, -f, f, f);
        RectF outerBounds = new RectF(innerBounds);
        float f2 = this.f3073k;
        outerBounds.inset(-f2, -f2);
        Path path = this.f3071i;
        if (path == null) {
            this.f3071i = new Path();
        } else {
            path.reset();
        }
        this.f3071i.setFillType(FillType.EVEN_ODD);
        this.f3071i.moveTo(-this.f3070h, 0.0f);
        this.f3071i.rLineTo(-this.f3073k, 0.0f);
        this.f3071i.arcTo(outerBounds, 180.0f, 90.0f, false);
        this.f3071i.arcTo(innerBounds, 270.0f, -90.0f, false);
        this.f3071i.close();
        float f3 = this.f3070h;
        float f4 = this.f3073k;
        float startRatio = f3 / (f3 + f4);
        Paint paint = this.f3067e;
        float f5 = f3 + f4;
        int i = this.f3077o;
        RadialGradient radialGradient = r9;
        RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f3078p}, new float[]{0.0f, startRatio, 1.0f}, TileMode.CLAMP);
        paint.setShader(radialGradient);
        Paint paint2 = this.f3068f;
        float f6 = this.f3070h;
        float f7 = -f6;
        float f8 = this.f3073k;
        float f9 = f7 + f8;
        float f10 = (-f6) - f8;
        int i2 = this.f3077o;
        LinearGradient linearGradient = new LinearGradient(0.0f, f9, 0.0f, f10, new int[]{i2, i2, this.f3078p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
        paint2.setShader(linearGradient);
        this.f3068f.setAntiAlias(false);
    }

    /* renamed from: b */
    private void m4651b(Rect bounds) {
        float f = this.f3072j;
        float verticalOffset = 1.5f * f;
        this.f3069g.set(((float) bounds.left) + f, ((float) bounds.top) + verticalOffset, ((float) bounds.right) - f, ((float) bounds.bottom) - verticalOffset);
        m4653g();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo7495b() {
        return this.f3070h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7493a(Rect into) {
        getPadding(into);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7498c(float size) {
        m4647a(size, this.f3072j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7496b(float size) {
        m4647a(this.f3074l, size);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public float mo7502f() {
        return this.f3074l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo7497c() {
        return this.f3072j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public float mo7501e() {
        float f = this.f3072j;
        return ((this.f3072j + ((float) this.f3065c)) * 2.0f) + (Math.max(f, this.f3070h + ((float) this.f3065c) + (f / 2.0f)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public float mo7499d() {
        float f = this.f3072j;
        return (((this.f3072j * 1.5f) + ((float) this.f3065c)) * 2.0f) + (Math.max(f, this.f3070h + ((float) this.f3065c) + ((f * 1.5f) / 2.0f)) * 2.0f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7492a(ColorStateList color) {
        m4650b(color);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ColorStateList mo7490a() {
        return this.f3075m;
    }
}
