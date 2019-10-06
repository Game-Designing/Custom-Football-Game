package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p001v7.widget.C1101pa;
import android.util.AttributeSet;
import android.view.Gravity;
import p002b.p003c.p050d.C1177k;

/* renamed from: android.support.design.internal.f */
/* compiled from: ForegroundLinearLayout */
public class C0220f extends C1101pa {

    /* renamed from: a */
    private Drawable f759a;

    /* renamed from: b */
    private final Rect f760b;

    /* renamed from: c */
    private final Rect f761c;

    /* renamed from: d */
    private int f762d;

    /* renamed from: e */
    protected boolean f763e;

    /* renamed from: f */
    boolean f764f;

    public C0220f(Context context) {
        this(context, null);
    }

    public C0220f(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C0220f(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f760b = new Rect();
        this.f761c = new Rect();
        this.f762d = 119;
        this.f763e = true;
        this.f764f = false;
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.ForegroundLinearLayout, defStyle, 0);
        this.f762d = a.getInt(C1177k.ForegroundLinearLayout_android_foregroundGravity, this.f762d);
        Drawable d = a.getDrawable(C1177k.ForegroundLinearLayout_android_foreground);
        if (d != null) {
            setForeground(d);
        }
        this.f763e = a.getBoolean(C1177k.ForegroundLinearLayout_foregroundInsidePadding, true);
        a.recycle();
    }

    public int getForegroundGravity() {
        return this.f762d;
    }

    public void setForegroundGravity(int foregroundGravity) {
        if (this.f762d != foregroundGravity) {
            if ((8388615 & foregroundGravity) == 0) {
                foregroundGravity |= 8388611;
            }
            if ((foregroundGravity & 112) == 0) {
                foregroundGravity |= 48;
            }
            this.f762d = foregroundGravity;
            if (this.f762d == 119 && this.f759a != null) {
                this.f759a.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f759a;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f759a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f759a;
        if (drawable != null && drawable.isStateful()) {
            this.f759a.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f759a;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f759a);
            }
            this.f759a = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f762d == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f759a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.f764f |= changed;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f764f = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f759a != null) {
            Drawable foreground = this.f759a;
            if (this.f764f) {
                this.f764f = false;
                Rect selfBounds = this.f760b;
                Rect overlayBounds = this.f761c;
                int w = getRight() - getLeft();
                int h = getBottom() - getTop();
                if (this.f763e) {
                    selfBounds.set(0, 0, w, h);
                } else {
                    selfBounds.set(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom());
                }
                Gravity.apply(this.f762d, foreground.getIntrinsicWidth(), foreground.getIntrinsicHeight(), selfBounds, overlayBounds);
                foreground.setBounds(overlayBounds);
            }
            foreground.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        Drawable drawable = this.f759a;
        if (drawable != null) {
            drawable.setHotspot(x, y);
        }
    }
}
