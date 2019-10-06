package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.a */
/* compiled from: AbsActionBarView */
abstract class C1035a extends ViewGroup {

    /* renamed from: a */
    protected final C1036a f3447a;

    /* renamed from: b */
    protected final Context f3448b;

    /* renamed from: c */
    protected ActionMenuView f3449c;

    /* renamed from: d */
    protected ActionMenuPresenter f3450d;

    /* renamed from: e */
    protected int f3451e;

    /* renamed from: f */
    protected C0587I f3452f;

    /* renamed from: g */
    private boolean f3453g;

    /* renamed from: h */
    private boolean f3454h;

    /* renamed from: android.support.v7.widget.a$a */
    /* compiled from: AbsActionBarView */
    protected class C1036a implements C0589J {

        /* renamed from: a */
        private boolean f3455a = false;

        /* renamed from: b */
        int f3456b;

        protected C1036a() {
        }

        /* renamed from: a */
        public C1036a mo8379a(C0587I animation, int visibility) {
            C1035a.this.f3452f = animation;
            this.f3456b = visibility;
            return this;
        }

        public void onAnimationStart(View view) {
            C1035a.super.setVisibility(0);
            this.f3455a = false;
        }

        public void onAnimationEnd(View view) {
            if (!this.f3455a) {
                C1035a aVar = C1035a.this;
                aVar.f3452f = null;
                C1035a.super.setVisibility(this.f3456b);
            }
        }

        public void onAnimationCancel(View view) {
            this.f3455a = true;
        }
    }

    public abstract void setContentHeight(int i);

    C1035a(Context context) {
        this(context, null);
    }

    C1035a(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    C1035a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3447a = new C1036a();
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(C0793R.attr.actionBarPopupTheme, tv, true)) {
            int i = tv.resourceId;
            if (i != 0) {
                this.f3448b = new ContextThemeWrapper(context, i);
                return;
            }
        }
        this.f3448b = context;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        TypedArray a = getContext().obtainStyledAttributes(null, C0793R.styleable.ActionBar, C0793R.attr.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(C0793R.styleable.ActionBar_height, 0));
        a.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f3450d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.mo7063a(newConfig);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            this.f3453g = false;
        }
        if (!this.f3453g) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.f3453g = true;
            }
        }
        if (action == 1 || action == 3) {
            this.f3453g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 9) {
            this.f3454h = false;
        }
        if (!this.f3454h) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.f3454h = true;
            }
        }
        if (action == 10 || action == 3) {
            this.f3454h = false;
        }
        return true;
    }

    public int getContentHeight() {
        return this.f3451e;
    }

    public int getAnimatedVisibility() {
        if (this.f3452f != null) {
            return this.f3447a.f3456b;
        }
        return getVisibility();
    }

    /* renamed from: a */
    public C0587I mo6998a(int visibility, long duration) {
        C0587I i = this.f3452f;
        if (i != null) {
            i.mo5475a();
        }
        if (visibility == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0587I anim = C0646w.m2945a(this).mo5470a(1.0f);
            anim.mo5471a(duration);
            C1036a aVar = this.f3447a;
            aVar.mo8379a(anim, visibility);
            anim.mo5472a((C0589J) aVar);
            return anim;
        }
        C0587I anim2 = C0646w.m2945a(this).mo5470a(0.0f);
        anim2.mo5471a(duration);
        C1036a aVar2 = this.f3447a;
        aVar2.mo8379a(anim2, visibility);
        anim2.mo5472a((C0589J) aVar2);
        return anim2;
    }

    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            C0587I i = this.f3452f;
            if (i != null) {
                i.mo5475a();
            }
            super.setVisibility(visibility);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8376a(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, LinearLayoutManager.INVALID_OFFSET), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    /* renamed from: a */
    protected static int m5201a(int x, int val, boolean isRtl) {
        return isRtl ? x - val : x + val;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo8377a(View child, int x, int y, int contentHeight, boolean reverse) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = ((contentHeight - childHeight) / 2) + y;
        if (reverse) {
            child.layout(x - childWidth, childTop, x, childTop + childHeight);
        } else {
            child.layout(x, childTop, x + childWidth, childTop + childHeight);
        }
        return reverse ? -childWidth : childWidth;
    }
}
