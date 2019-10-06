package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout.C0227b;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0592M;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0679I;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import p002b.p003c.p050d.C1172f;
import p002b.p003c.p050d.C1176j;
import p002b.p003c.p050d.C1177k;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p058c.C1226a;
import p002b.p003c.p053g.p061f.C1267k;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a */
    private boolean f875a;

    /* renamed from: b */
    private int f876b;

    /* renamed from: c */
    private Toolbar f877c;

    /* renamed from: d */
    private View f878d;

    /* renamed from: e */
    private View f879e;

    /* renamed from: f */
    private int f880f;

    /* renamed from: g */
    private int f881g;

    /* renamed from: h */
    private int f882h;

    /* renamed from: i */
    private int f883i;

    /* renamed from: j */
    private final Rect f884j;

    /* renamed from: k */
    final C0224A f885k;

    /* renamed from: l */
    private boolean f886l;

    /* renamed from: m */
    private boolean f887m;

    /* renamed from: n */
    private Drawable f888n;

    /* renamed from: o */
    Drawable f889o;

    /* renamed from: p */
    private int f890p;

    /* renamed from: q */
    private boolean f891q;

    /* renamed from: r */
    private ValueAnimator f892r;

    /* renamed from: s */
    private long f893s;

    /* renamed from: t */
    private int f894t;

    /* renamed from: u */
    private C0227b f895u;

    /* renamed from: v */
    int f896v;

    /* renamed from: w */
    C0592M f897w;

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$a */
    public static class C0234a extends LayoutParams {

        /* renamed from: a */
        int f898a = 0;

        /* renamed from: b */
        float f899b = 0.5f;

        public C0234a(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, C1177k.CollapsingToolbarLayout_Layout);
            this.f898a = a.getInt(C1177k.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            mo4354a(a.getFloat(C1177k.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            a.recycle();
        }

        public C0234a(int width, int height) {
            super(width, height);
        }

        public C0234a(ViewGroup.LayoutParams p) {
            super(p);
        }

        /* renamed from: a */
        public void mo4354a(float multiplier) {
            this.f899b = multiplier;
        }
    }

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$b */
    private class C0235b implements C0227b {
        C0235b() {
        }

        public void onOffsetChanged(AppBarLayout layout, int verticalOffset) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f896v = verticalOffset;
            C0592M m = collapsingToolbarLayout.f897w;
            int insetTop = m != null ? m.mo5489e() : 0;
            int z = CollapsingToolbarLayout.this.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = CollapsingToolbarLayout.this.getChildAt(i);
                C0234a lp = (C0234a) child.getLayoutParams();
                C0293ga offsetHelper = CollapsingToolbarLayout.m1398b(child);
                int i2 = lp.f898a;
                if (i2 == 1) {
                    offsetHelper.mo4663b(C1226a.m5823a(-verticalOffset, 0, CollapsingToolbarLayout.this.mo4296a(child)));
                } else if (i2 == 2) {
                    offsetHelper.mo4663b(Math.round(((float) (-verticalOffset)) * lp.f899b));
                }
            }
            CollapsingToolbarLayout.this.mo4298a();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f889o != null && insetTop > 0) {
                C0646w.m2990x(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.f885k.mo4166b(((float) Math.abs(verticalOffset)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - C0646w.m2975i(CollapsingToolbarLayout.this)) - insetTop)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f875a = true;
        this.f884j = new Rect();
        this.f894t = -1;
        C0289ea.m1678a(context);
        this.f885k = new C0224A(this);
        this.f885k.mo4171b(C0280a.f1078e);
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.CollapsingToolbarLayout, defStyleAttr, C1176j.Widget_Design_CollapsingToolbar);
        this.f885k.mo4176d(a.getInt(C1177k.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f885k.mo4167b(a.getInt(C1177k.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f883i = dimensionPixelSize;
        this.f882h = dimensionPixelSize;
        this.f881g = dimensionPixelSize;
        this.f880f = dimensionPixelSize;
        if (a.hasValue(C1177k.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f880f = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a.hasValue(C1177k.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f882h = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a.hasValue(C1177k.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f881g = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a.hasValue(C1177k.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f883i = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f886l = a.getBoolean(C1177k.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a.getText(C1177k.CollapsingToolbarLayout_title));
        this.f885k.mo4173c(C1176j.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f885k.mo4157a(C0793R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a.hasValue(C1177k.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f885k.mo4173c(a.getResourceId(C1177k.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a.hasValue(C1177k.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f885k.mo4157a(a.getResourceId(C1177k.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.f894t = a.getDimensionPixelSize(C1177k.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.f893s = (long) a.getInt(C1177k.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(a.getDrawable(C1177k.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a.getDrawable(C1177k.CollapsingToolbarLayout_statusBarScrim));
        this.f876b = a.getResourceId(C1177k.CollapsingToolbarLayout_toolbarId, -1);
        a.recycle();
        setWillNotDraw(false);
        C0646w.m2956a((View) this, (C0641r) new C0228B(this));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            C0646w.m2961a((View) this, C0646w.m2972f((View) parent));
            if (this.f895u == null) {
                this.f895u = new C0235b();
            }
            ((AppBarLayout) parent).mo4186a(this.f895u);
            C0646w.m2991y(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        C0227b bVar = this.f895u;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).mo4190b(bVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0592M mo4297a(C0592M insets) {
        C0592M newInsets = null;
        if (C0646w.m2972f(this)) {
            newInsets = insets;
        }
        if (!C1267k.m5950a(this.f897w, newInsets)) {
            this.f897w = newInsets;
            requestLayout();
        }
        return insets.mo5484a();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m1399b();
        if (this.f877c == null) {
            Drawable drawable = this.f888n;
            if (drawable != null && this.f890p > 0) {
                drawable.mutate().setAlpha(this.f890p);
                this.f888n.draw(canvas);
            }
        }
        if (this.f886l && this.f887m) {
            this.f885k.mo4160a(canvas);
        }
        if (this.f889o != null && this.f890p > 0) {
            C0592M m = this.f897w;
            int topInset = m != null ? m.mo5489e() : 0;
            if (topInset > 0) {
                this.f889o.setBounds(0, -this.f896v, getWidth(), topInset - this.f896v);
                this.f889o.mutate().setAlpha(this.f890p);
                this.f889o.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean invalidated = false;
        if (this.f888n != null && this.f890p > 0 && m1403e(child)) {
            this.f888n.mutate().setAlpha(this.f890p);
            this.f888n.draw(canvas);
            invalidated = true;
        }
        return super.drawChild(canvas, child, drawingTime) || invalidated;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Drawable drawable = this.f888n;
        if (drawable != null) {
            drawable.setBounds(0, 0, w, h);
        }
    }

    /* renamed from: b */
    private void m1399b() {
        if (this.f875a) {
            this.f877c = null;
            this.f878d = null;
            int i = this.f876b;
            if (i != -1) {
                this.f877c = (Toolbar) findViewById(i);
                Toolbar toolbar = this.f877c;
                if (toolbar != null) {
                    this.f878d = m1400c(toolbar);
                }
            }
            if (this.f877c == null) {
                Toolbar toolbar2 = null;
                int i2 = 0;
                int count = getChildCount();
                while (true) {
                    if (i2 >= count) {
                        break;
                    }
                    View child = getChildAt(i2);
                    if (child instanceof Toolbar) {
                        toolbar2 = (Toolbar) child;
                        break;
                    }
                    i2++;
                }
                this.f877c = toolbar2;
            }
            m1401c();
            this.f875a = false;
        }
    }

    /* renamed from: e */
    private boolean m1403e(View child) {
        View view = this.f878d;
        if (view == null || view == this) {
            if (child == this.f877c) {
                return true;
            }
        } else if (child == view) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private View m1400c(View descendant) {
        View directChild = descendant;
        ViewParent p = descendant.getParent();
        while (p != this && p != null) {
            if (p instanceof View) {
                directChild = (View) p;
            }
            p = p.getParent();
        }
        return directChild;
    }

    /* renamed from: c */
    private void m1401c() {
        if (!this.f886l) {
            View view = this.f879e;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f879e);
                }
            }
        }
        if (this.f886l && this.f877c != null) {
            if (this.f879e == null) {
                this.f879e = new View(getContext());
            }
            if (this.f879e.getParent() == null) {
                this.f877c.addView(this.f879e, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        m1399b();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        C0592M m = this.f897w;
        int topInset = m != null ? m.mo5489e() : 0;
        if (mode == 0 && topInset > 0) {
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(getMeasuredHeight() + topInset, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int i2;
        super.onLayout(changed, left, top, right, bottom);
        C0592M m = this.f897w;
        if (m != null) {
            int insetTop = m.mo5489e();
            int z = getChildCount();
            for (int i3 = 0; i3 < z; i3++) {
                View child = getChildAt(i3);
                if (!C0646w.m2972f(child) && child.getTop() < insetTop) {
                    C0646w.m2965b(child, insetTop);
                }
            }
        }
        if (this.f886l != 0) {
            View view = this.f879e;
            if (view != null) {
                boolean z2 = false;
                this.f887m = C0646w.m2986t(view) && this.f879e.getVisibility() == 0;
                if (this.f887m) {
                    if (C0646w.m2974h(this) == 1) {
                        z2 = true;
                    }
                    boolean isRtl = z2;
                    View view2 = this.f878d;
                    if (view2 == null) {
                        view2 = this.f877c;
                    }
                    int maxOffset = mo4296a(view2);
                    C0679I.m3163a((ViewGroup) this, this.f879e, this.f884j);
                    C0224A a = this.f885k;
                    int i4 = this.f884j.left;
                    if (isRtl) {
                        i = this.f877c.getTitleMarginEnd();
                    } else {
                        i = this.f877c.getTitleMarginStart();
                    }
                    int i5 = i4 + i;
                    int titleMarginTop = this.f884j.top + maxOffset + this.f877c.getTitleMarginTop();
                    int i6 = this.f884j.right;
                    if (isRtl) {
                        i2 = this.f877c.getTitleMarginStart();
                    } else {
                        i2 = this.f877c.getTitleMarginEnd();
                    }
                    a.mo4158a(i5, titleMarginTop, i6 + i2, (this.f884j.bottom + maxOffset) - this.f877c.getTitleMarginBottom());
                    this.f885k.mo4168b(isRtl ? this.f882h : this.f880f, this.f884j.top + this.f881g, (right - left) - (isRtl ? this.f880f : this.f882h), (bottom - top) - this.f883i);
                    this.f885k.mo4183k();
                }
            }
        }
        int z3 = getChildCount();
        for (int i7 = 0; i7 < z3; i7++) {
            m1398b(getChildAt(i7)).mo4664c();
        }
        if (this.f877c != null) {
            if (this.f886l && TextUtils.isEmpty(this.f885k.mo4180h())) {
                this.f885k.mo4163a(this.f877c.getTitle());
            }
            View view3 = this.f878d;
            if (view3 == null || view3 == this) {
                setMinimumHeight(m1402d(this.f877c));
            } else {
                setMinimumHeight(m1402d(view3));
            }
        }
        mo4298a();
    }

    /* renamed from: d */
    private static int m1402d(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (!(lp instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams mlp = (MarginLayoutParams) lp;
        return view.getHeight() + mlp.topMargin + mlp.bottomMargin;
    }

    /* renamed from: b */
    static C0293ga m1398b(View view) {
        C0293ga offsetHelper = (C0293ga) view.getTag(C1172f.view_offset_helper);
        if (offsetHelper != null) {
            return offsetHelper;
        }
        C0293ga offsetHelper2 = new C0293ga(view);
        view.setTag(C1172f.view_offset_helper, offsetHelper2);
        return offsetHelper2;
    }

    public void setTitle(CharSequence title) {
        this.f885k.mo4163a(title);
    }

    public CharSequence getTitle() {
        if (this.f886l) {
            return this.f885k.mo4180h();
        }
        return null;
    }

    public void setTitleEnabled(boolean enabled) {
        if (enabled != this.f886l) {
            this.f886l = enabled;
            m1401c();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean shown) {
        mo4299a(shown, C0646w.m2987u(this) && !isInEditMode());
    }

    /* renamed from: a */
    public void mo4299a(boolean shown, boolean animate) {
        if (this.f891q != shown) {
            int i = 255;
            if (animate) {
                if (!shown) {
                    i = 0;
                }
                m1397a(i);
            } else {
                if (!shown) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f891q = shown;
        }
    }

    /* renamed from: a */
    private void m1397a(int targetAlpha) {
        m1399b();
        ValueAnimator valueAnimator = this.f892r;
        if (valueAnimator == null) {
            this.f892r = new ValueAnimator();
            this.f892r.setDuration(this.f893s);
            this.f892r.setInterpolator(targetAlpha > this.f890p ? C0280a.f1076c : C0280a.f1077d);
            this.f892r.addUpdateListener(new C0233C(this));
        } else if (valueAnimator.isRunning()) {
            this.f892r.cancel();
        }
        this.f892r.setIntValues(new int[]{this.f890p, targetAlpha});
        this.f892r.start();
    }

    /* access modifiers changed from: 0000 */
    public void setScrimAlpha(int alpha) {
        if (alpha != this.f890p) {
            if (this.f888n != null) {
                Toolbar toolbar = this.f877c;
                if (toolbar != null) {
                    C0646w.m2990x(toolbar);
                }
            }
            this.f890p = alpha;
            C0646w.m2990x(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public int getScrimAlpha() {
        return this.f890p;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f888n;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f888n = drawable3;
            Drawable drawable4 = this.f888n;
            if (drawable4 != null) {
                drawable4.setBounds(0, 0, getWidth(), getHeight());
                this.f888n.setCallback(this);
                this.f888n.setAlpha(this.f890p);
            }
            C0646w.m2990x(this);
        }
    }

    public void setContentScrimColor(int color) {
        setContentScrim(new ColorDrawable(color));
    }

    public void setContentScrimResource(int resId) {
        setContentScrim(C0510b.m2572c(getContext(), resId));
    }

    public Drawable getContentScrim() {
        return this.f888n;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f889o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f889o = drawable3;
            Drawable drawable4 = this.f889o;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f889o.setState(getDrawableState());
                }
                C1200a.m5732a(this.f889o, C0646w.m2974h(this));
                this.f889o.setVisible(getVisibility() == 0, false);
                this.f889o.setCallback(this);
                this.f889o.setAlpha(this.f890p);
            }
            C0646w.m2990x(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable d = this.f889o;
        if (d != null && d.isStateful()) {
            changed = false | d.setState(state);
        }
        Drawable d2 = this.f888n;
        if (d2 != null && d2.isStateful()) {
            changed |= d2.setState(state);
        }
        C0224A a = this.f885k;
        if (a != null) {
            changed |= a.mo4164a(state);
        }
        if (changed) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f888n || who == this.f889o;
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.f889o;
        if (!(drawable == null || drawable.isVisible() == visible)) {
            this.f889o.setVisible(visible, false);
        }
        Drawable drawable2 = this.f888n;
        if (drawable2 != null && drawable2.isVisible() != visible) {
            this.f888n.setVisible(visible, false);
        }
    }

    public void setStatusBarScrimColor(int color) {
        setStatusBarScrim(new ColorDrawable(color));
    }

    public void setStatusBarScrimResource(int resId) {
        setStatusBarScrim(C0510b.m2572c(getContext(), resId));
    }

    public Drawable getStatusBarScrim() {
        return this.f889o;
    }

    public void setCollapsedTitleTextAppearance(int resId) {
        this.f885k.mo4157a(resId);
    }

    public void setCollapsedTitleTextColor(int color) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(color));
    }

    public void setCollapsedTitleTextColor(ColorStateList colors) {
        this.f885k.mo4159a(colors);
    }

    public void setCollapsedTitleGravity(int gravity) {
        this.f885k.mo4167b(gravity);
    }

    public int getCollapsedTitleGravity() {
        return this.f885k.mo4165b();
    }

    public void setExpandedTitleTextAppearance(int resId) {
        this.f885k.mo4173c(resId);
    }

    public void setExpandedTitleColor(int color) {
        setExpandedTitleTextColor(ColorStateList.valueOf(color));
    }

    public void setExpandedTitleTextColor(ColorStateList colors) {
        this.f885k.mo4169b(colors);
    }

    public void setExpandedTitleGravity(int gravity) {
        this.f885k.mo4176d(gravity);
    }

    public int getExpandedTitleGravity() {
        return this.f885k.mo4177e();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f885k.mo4161a(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f885k.mo4175d();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f885k.mo4170b(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f885k.mo4178f();
    }

    public int getExpandedTitleMarginStart() {
        return this.f880f;
    }

    public void setExpandedTitleMarginStart(int margin) {
        this.f880f = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f881g;
    }

    public void setExpandedTitleMarginTop(int margin) {
        this.f881g = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f882h;
    }

    public void setExpandedTitleMarginEnd(int margin) {
        this.f882h = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f883i;
    }

    public void setExpandedTitleMarginBottom(int margin) {
        this.f883i = margin;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int height) {
        if (this.f894t != height) {
            this.f894t = height;
            mo4298a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.f894t;
        if (i >= 0) {
            return i;
        }
        C0592M m = this.f897w;
        int insetTop = m != null ? m.mo5489e() : 0;
        int minHeight = C0646w.m2975i(this);
        if (minHeight > 0) {
            return Math.min((minHeight * 2) + insetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long duration) {
        this.f893s = duration;
    }

    public long getScrimAnimationDuration() {
        return this.f893s;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof C0234a;
    }

    /* access modifiers changed from: protected */
    public C0234a generateDefaultLayoutParams() {
        return new C0234a(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new C0234a(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new C0234a(p);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4298a() {
        if (this.f888n != null || this.f889o != null) {
            setScrimsShown(getHeight() + this.f896v < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo4296a(View child) {
        return ((getHeight() - m1398b(child).mo4660a()) - child.getHeight()) - ((C0234a) child.getLayoutParams()).bottomMargin;
    }
}
