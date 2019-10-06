package android.support.p001v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.Na */
/* compiled from: RoundRectDrawable */
class C0961Na extends Drawable {

    /* renamed from: a */
    private float f3051a;

    /* renamed from: b */
    private final Paint f3052b;

    /* renamed from: c */
    private final RectF f3053c;

    /* renamed from: d */
    private final Rect f3054d;

    /* renamed from: e */
    private float f3055e;

    /* renamed from: f */
    private boolean f3056f = false;

    /* renamed from: g */
    private boolean f3057g = true;

    /* renamed from: h */
    private ColorStateList f3058h;

    /* renamed from: i */
    private PorterDuffColorFilter f3059i;

    /* renamed from: j */
    private ColorStateList f3060j;

    /* renamed from: k */
    private Mode f3061k = Mode.SRC_IN;

    C0961Na(ColorStateList backgroundColor, float radius) {
        this.f3051a = radius;
        this.f3052b = new Paint(5);
        m4621b(backgroundColor);
        this.f3053c = new RectF();
        this.f3054d = new Rect();
    }

    /* renamed from: b */
    private void m4621b(ColorStateList color) {
        this.f3058h = color == null ? ColorStateList.valueOf(0) : color;
        this.f3052b.setColor(this.f3058h.getColorForState(getState(), this.f3058h.getDefaultColor()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7475a(float padding, boolean insetForPadding, boolean insetForRadius) {
        if (padding != this.f3055e || this.f3056f != insetForPadding || this.f3057g != insetForRadius) {
            this.f3055e = padding;
            this.f3056f = insetForPadding;
            this.f3057g = insetForRadius;
            m4620a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public float mo7477b() {
        return this.f3055e;
    }

    public void draw(Canvas canvas) {
        boolean clearColorFilter;
        Paint paint = this.f3052b;
        if (this.f3059i == null || paint.getColorFilter() != null) {
            clearColorFilter = false;
        } else {
            paint.setColorFilter(this.f3059i);
            clearColorFilter = true;
        }
        RectF rectF = this.f3053c;
        float f = this.f3051a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (clearColorFilter) {
            paint.setColorFilter(null);
        }
    }

    /* renamed from: a */
    private void m4620a(Rect bounds) {
        if (bounds == null) {
            bounds = getBounds();
        }
        this.f3053c.set((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom);
        this.f3054d.set(bounds);
        if (this.f3056f) {
            float vInset = C0963Oa.m4649b(this.f3055e, this.f3051a, this.f3057g);
            this.f3054d.inset((int) Math.ceil((double) C0963Oa.m4646a(this.f3055e, this.f3051a, this.f3057g)), (int) Math.ceil((double) vInset));
            this.f3053c.set(this.f3054d);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        m4620a(bounds);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3054d, this.f3051a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7474a(float radius) {
        if (radius != this.f3051a) {
            this.f3051a = radius;
            m4620a((Rect) null);
            invalidateSelf();
        }
    }

    public void setAlpha(int alpha) {
        this.f3052b.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.f3052b.setColorFilter(cf);
    }

    public int getOpacity() {
        return -3;
    }

    /* renamed from: c */
    public float mo7478c() {
        return this.f3051a;
    }

    /* renamed from: a */
    public void mo7476a(ColorStateList color) {
        m4621b(color);
        invalidateSelf();
    }

    /* renamed from: a */
    public ColorStateList mo7473a() {
        return this.f3058h;
    }

    public void setTintList(ColorStateList tint) {
        this.f3060j = tint;
        this.f3059i = m4619a(this.f3060j, this.f3061k);
        invalidateSelf();
    }

    public void setTintMode(Mode tintMode) {
        this.f3061k = tintMode;
        this.f3059i = m4619a(this.f3060j, this.f3061k);
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] stateSet) {
        ColorStateList colorStateList = this.f3058h;
        int newColor = colorStateList.getColorForState(stateSet, colorStateList.getDefaultColor());
        boolean colorChanged = newColor != this.f3052b.getColor();
        if (colorChanged) {
            this.f3052b.setColor(newColor);
        }
        ColorStateList colorStateList2 = this.f3060j;
        if (colorStateList2 != null) {
            Mode mode = this.f3061k;
            if (mode != null) {
                this.f3059i = m4619a(colorStateList2, mode);
                return true;
            }
        }
        return colorChanged;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f3060j;
        if (colorStateList == null || !colorStateList.isStateful()) {
            ColorStateList colorStateList2 = this.f3058h;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && !super.isStateful()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private PorterDuffColorFilter m4619a(ColorStateList tint, Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        return new PorterDuffColorFilter(tint.getColorForState(getState(), 0), tintMode);
    }
}
