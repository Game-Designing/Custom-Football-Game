package com.adyen.p081ui.views.loadinganimation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import android.util.AttributeSet;
import android.view.View;
import com.adyen.p081ui.C5572a;
import com.adyen.p081ui.C5633f;
import com.adyen.p081ui.C5634g;

/* renamed from: com.adyen.ui.views.loadinganimation.ThreeDotsLoadingView */
public class ThreeDotsLoadingView extends View {

    /* renamed from: a */
    int f9573a = 48;

    /* renamed from: b */
    int f9574b = 48;

    /* renamed from: c */
    int f9575c = 48;

    /* renamed from: d */
    int f9576d = 48;

    /* renamed from: e */
    private C5652a f9577e;

    /* renamed from: f */
    private int f9578f;

    /* renamed from: g */
    private boolean f9579g;

    public ThreeDotsLoadingView(Context context) {
        super(context);
        m9969a(context, null, 0, 0);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9969a(context, attrs, 0, C5633f.LoadingAnimationView);
    }

    public ThreeDotsLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m9969a(context, attrs, defStyleAttr, C5633f.LoadingAnimationView);
    }

    @TargetApi(21)
    public ThreeDotsLoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m9969a(context, attrs, defStyleAttr, C5633f.LoadingAnimationView);
    }

    /* renamed from: a */
    private void m9969a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.obtainStyledAttributes(attrs, C5634g.ThreeDotsLoadingView, defStyleAttr, defStyleRes);
        this.f9573a = a.getDimensionPixelSize(C5634g.ThreeDotsLoadingView_minWidth, this.f9573a);
        this.f9574b = a.getDimensionPixelSize(C5634g.ThreeDotsLoadingView_maxWidth, this.f9574b);
        this.f9575c = a.getDimensionPixelSize(C5634g.ThreeDotsLoadingView_minHeight, this.f9575c);
        this.f9576d = a.getDimensionPixelSize(C5634g.ThreeDotsLoadingView_maxHeight, this.f9576d);
        this.f9578f = a.getColor(C5634g.ThreeDotsLoadingView_indicatorColor, C0510b.m2564a(getContext(), C5572a.light_green));
        setLoadingAnimation(new C5654c());
        a.recycle();
    }

    public void setLoadingAnimation(C5654c d) {
        C5652a aVar = this.f9577e;
        if (aVar != d) {
            if (aVar != null) {
                aVar.setCallback(null);
                unscheduleDrawable(this.f9577e);
            }
            this.f9577e = d;
            setColor(this.f9578f);
            if (d != null) {
                d.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setColor(int color) {
        this.f9578f = color;
        this.f9577e.mo17844a(color);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawableToVerify) {
        return drawableToVerify == this.f9577e || super.verifyDrawable(drawableToVerify);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17827a() {
        if (getVisibility() == 0) {
            this.f9579g = true;
            postInvalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo17829b() {
        C5652a aVar = this.f9577e;
        if (aVar != null) {
            aVar.stop();
        }
        this.f9579g = false;
        postInvalidate();
    }

    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);
            if (v == 8 || v == 4) {
                mo17829b();
            } else {
                mo17827a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 8 || visibility == 4) {
            mo17829b();
        } else {
            mo17827a();
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect dirty = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        m9968a(width, height);
    }

    /* renamed from: a */
    private void m9968a(int w, int h) {
        int w2 = w - (getPaddingRight() + getPaddingLeft());
        int h2 = h - (getPaddingTop() + getPaddingBottom());
        int right = w2;
        int bottom = h2;
        int top = 0;
        int left = 0;
        C5652a aVar = this.f9577e;
        if (aVar != null) {
            float intrinsicAspect = ((float) aVar.getIntrinsicWidth()) / ((float) this.f9577e.getIntrinsicHeight());
            float boundAspect = ((float) w2) / ((float) h2);
            if (((double) Math.abs(intrinsicAspect - boundAspect)) > 1.0E-7d) {
                if (boundAspect > intrinsicAspect) {
                    int width = (int) (((float) h2) * intrinsicAspect);
                    int left2 = (w2 - width) / 2;
                    right = width + left2;
                    left = left2;
                } else {
                    int height = (int) (((float) w2) * (1.0f / intrinsicAspect));
                    int top2 = (h2 - height) / 2;
                    bottom = top2 + height;
                    top = top2;
                }
            }
            this.f9577e.setBounds(left, top, right, bottom);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mo17828a(canvas);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17828a(Canvas canvas) {
        if (this.f9577e != null) {
            int saveCount = canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            this.f9577e.draw(canvas);
            canvas.restoreToCount(saveCount);
            if (this.f9579g) {
                this.f9577e.start();
                this.f9579g = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int dw = 0;
        int dh = 0;
        Drawable d = this.f9577e;
        if (d != null) {
            dw = Math.max(this.f9573a, Math.min(this.f9574b, d.getIntrinsicWidth()));
            dh = Math.max(this.f9575c, Math.min(this.f9576d, d.getIntrinsicHeight()));
        }
        m9970c();
        setMeasuredDimension(View.resolveSizeAndState(dw + getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0), View.resolveSizeAndState(dh + getPaddingTop() + getPaddingBottom(), heightMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m9970c();
    }

    /* renamed from: c */
    private void m9970c() {
        int[] state = getDrawableState();
        C5652a aVar = this.f9577e;
        if (aVar != null && aVar.isStateful()) {
            this.f9577e.setState(state);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float x, float y) {
        super.drawableHotspotChanged(x, y);
        C5652a aVar = this.f9577e;
        if (aVar != null) {
            aVar.setHotspot(x, y);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mo17827a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo17829b();
        super.onDetachedFromWindow();
    }
}
