package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.widget.ActionBarContainer */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    private boolean f2812a;

    /* renamed from: b */
    private View f2813b;

    /* renamed from: c */
    private View f2814c;

    /* renamed from: d */
    private View f2815d;

    /* renamed from: e */
    Drawable f2816e;

    /* renamed from: f */
    Drawable f2817f;

    /* renamed from: g */
    Drawable f2818g;

    /* renamed from: h */
    boolean f2819h;

    /* renamed from: i */
    boolean f2820i;

    /* renamed from: j */
    private int f2821j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        C0646w.m2954a((View) this, VERSION.SDK_INT >= 21 ? new C1043c(this) : new C1040b(this));
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.ActionBar);
        this.f2816e = a.getDrawable(C0793R.styleable.ActionBar_background);
        this.f2817f = a.getDrawable(C0793R.styleable.ActionBar_backgroundStacked);
        this.f2821j = a.getDimensionPixelSize(C0793R.styleable.ActionBar_height, -1);
        if (getId() == C0793R.C0794id.split_action_bar) {
            this.f2819h = true;
            this.f2818g = a.getDrawable(C0793R.styleable.ActionBar_backgroundSplit);
        }
        a.recycle();
        boolean z = false;
        if (!this.f2819h ? this.f2816e == null && this.f2817f == null : this.f2818g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2814c = findViewById(C0793R.C0794id.action_bar);
        this.f2815d = findViewById(C0793R.C0794id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable bg) {
        Drawable drawable = this.f2816e;
        if (drawable != null) {
            drawable.setCallback(null);
            unscheduleDrawable(this.f2816e);
        }
        this.f2816e = bg;
        if (bg != null) {
            bg.setCallback(this);
            View view = this.f2814c;
            if (view != null) {
                this.f2816e.setBounds(view.getLeft(), this.f2814c.getTop(), this.f2814c.getRight(), this.f2814c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f2819h ? !(this.f2816e == null && this.f2817f == null) : this.f2818g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable bg) {
        Drawable drawable = this.f2817f;
        if (drawable != null) {
            drawable.setCallback(null);
            unscheduleDrawable(this.f2817f);
        }
        this.f2817f = bg;
        if (bg != null) {
            bg.setCallback(this);
            if (this.f2820i) {
                Drawable drawable2 = this.f2817f;
                if (drawable2 != null) {
                    drawable2.setBounds(this.f2813b.getLeft(), this.f2813b.getTop(), this.f2813b.getRight(), this.f2813b.getBottom());
                }
            }
        }
        boolean z = true;
        if (!this.f2819h ? !(this.f2816e == null && this.f2817f == null) : this.f2818g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable bg) {
        Drawable drawable = this.f2818g;
        if (drawable != null) {
            drawable.setCallback(null);
            unscheduleDrawable(this.f2818g);
        }
        this.f2818g = bg;
        boolean z = false;
        if (bg != null) {
            bg.setCallback(this);
            if (this.f2819h) {
                Drawable drawable2 = this.f2818g;
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
        if (!this.f2819h ? this.f2816e == null && this.f2817f == null : this.f2818g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean isVisible = visibility == 0;
        Drawable drawable = this.f2816e;
        if (drawable != null) {
            drawable.setVisible(isVisible, false);
        }
        Drawable drawable2 = this.f2817f;
        if (drawable2 != null) {
            drawable2.setVisible(isVisible, false);
        }
        Drawable drawable3 = this.f2818g;
        if (drawable3 != null) {
            drawable3.setVisible(isVisible, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return (who == this.f2816e && !this.f2819h) || (who == this.f2817f && this.f2820i) || ((who == this.f2818g && this.f2819h) || super.verifyDrawable(who));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2816e;
        if (drawable != null && drawable.isStateful()) {
            this.f2816e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2817f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2817f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2818g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f2818g.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2816e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2817f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2818g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean isTransitioning) {
        this.f2812a = isTransitioning;
        setDescendantFocusability(isTransitioning ? 393216 : Opcodes.ASM4);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f2812a || super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        return true;
    }

    public boolean onHoverEvent(MotionEvent ev) {
        super.onHoverEvent(ev);
        return true;
    }

    public void setTabContainer(C1004Sa tabView) {
        View view = this.f2813b;
        if (view != null) {
            removeView(view);
        }
        this.f2813b = tabView;
        if (tabView != null) {
            addView(tabView);
            LayoutParams lp = tabView.getLayoutParams();
            lp.width = -1;
            lp.height = -2;
            tabView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f2813b;
    }

    public ActionMode startActionModeForChild(View child, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View child, Callback callback, int type) {
        if (type != 0) {
            return super.startActionModeForChild(child, callback, type);
        }
        return null;
    }

    /* renamed from: b */
    private boolean m4309b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: a */
    private int m4308a(View view) {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int topMarginForTabs;
        if (this.f2814c == null && MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
            int i = this.f2821j;
            if (i >= 0) {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(i, MeasureSpec.getSize(heightMeasureSpec)), LinearLayoutManager.INVALID_OFFSET);
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f2814c != null) {
            int mode = MeasureSpec.getMode(heightMeasureSpec);
            View view = this.f2813b;
            if (!(view == null || view.getVisibility() == 8 || mode == 1073741824)) {
                if (!m4309b(this.f2814c)) {
                    topMarginForTabs = m4308a(this.f2814c);
                } else if (!m4309b(this.f2815d)) {
                    topMarginForTabs = m4308a(this.f2815d);
                } else {
                    topMarginForTabs = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(m4308a(this.f2813b) + topMarginForTabs, mode == Integer.MIN_VALUE ? MeasureSpec.getSize(heightMeasureSpec) : MoPubClientPositioning.NO_REPEAT));
            }
        }
    }

    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        View tabContainer = this.f2813b;
        boolean hasTabs = (tabContainer == null || tabContainer.getVisibility() == 8) ? false : true;
        if (!(tabContainer == null || tabContainer.getVisibility() == 8)) {
            int containerHeight = getMeasuredHeight();
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) tabContainer.getLayoutParams();
            tabContainer.layout(l, (containerHeight - tabContainer.getMeasuredHeight()) - lp.bottomMargin, r, containerHeight - lp.bottomMargin);
        }
        boolean needsInvalidate = false;
        if (this.f2819h) {
            Drawable drawable = this.f2818g;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                needsInvalidate = true;
            }
        } else {
            if (this.f2816e != null) {
                if (this.f2814c.getVisibility() == 0) {
                    this.f2816e.setBounds(this.f2814c.getLeft(), this.f2814c.getTop(), this.f2814c.getRight(), this.f2814c.getBottom());
                } else {
                    View view = this.f2815d;
                    if (view == null || view.getVisibility() != 0) {
                        this.f2816e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f2816e.setBounds(this.f2815d.getLeft(), this.f2815d.getTop(), this.f2815d.getRight(), this.f2815d.getBottom());
                    }
                }
                needsInvalidate = true;
            }
            this.f2820i = hasTabs;
            if (hasTabs) {
                Drawable drawable2 = this.f2817f;
                if (drawable2 != null) {
                    drawable2.setBounds(tabContainer.getLeft(), tabContainer.getTop(), tabContainer.getRight(), tabContainer.getBottom());
                    needsInvalidate = true;
                }
            }
        }
        if (needsInvalidate) {
            invalidate();
        }
    }
}
