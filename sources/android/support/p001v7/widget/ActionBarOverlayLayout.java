package android.support.p001v7.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0639p;
import android.support.p000v4.view.C0640q;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements C1016T, C0639p {

    /* renamed from: a */
    static final int[] f2833a = {C0793R.attr.actionBarSize, 16842841};

    /* renamed from: A */
    private final Runnable f2834A;

    /* renamed from: B */
    private final Runnable f2835B;

    /* renamed from: C */
    private final C0640q f2836C;

    /* renamed from: b */
    private int f2837b;

    /* renamed from: c */
    private int f2838c;

    /* renamed from: d */
    private ContentFrameLayout f2839d;

    /* renamed from: e */
    ActionBarContainer f2840e;

    /* renamed from: f */
    private C1021U f2841f;

    /* renamed from: g */
    private Drawable f2842g;

    /* renamed from: h */
    private boolean f2843h;

    /* renamed from: i */
    private boolean f2844i;

    /* renamed from: j */
    private boolean f2845j;

    /* renamed from: k */
    private boolean f2846k;

    /* renamed from: l */
    boolean f2847l;

    /* renamed from: m */
    private int f2848m;

    /* renamed from: n */
    private int f2849n;

    /* renamed from: o */
    private final Rect f2850o;

    /* renamed from: p */
    private final Rect f2851p;

    /* renamed from: q */
    private final Rect f2852q;

    /* renamed from: r */
    private final Rect f2853r;

    /* renamed from: s */
    private final Rect f2854s;

    /* renamed from: t */
    private final Rect f2855t;

    /* renamed from: u */
    private final Rect f2856u;

    /* renamed from: v */
    private C0902a f2857v;

    /* renamed from: w */
    private final int f2858w;

    /* renamed from: x */
    private OverScroller f2859x;

    /* renamed from: y */
    ViewPropertyAnimator f2860y;

    /* renamed from: z */
    final AnimatorListenerAdapter f2861z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    public interface C0902a {
        /* renamed from: a */
        void mo6171a();

        /* renamed from: a */
        void mo6174a(boolean z);

        /* renamed from: b */
        void mo6175b();

        /* renamed from: c */
        void mo6176c();

        /* renamed from: d */
        void mo6177d();

        void onWindowVisibilityChanged(int i);
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$b */
    public static class C0903b extends MarginLayoutParams {
        public C0903b(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C0903b(int width, int height) {
            super(width, height);
        }

        public C0903b(LayoutParams source) {
            super(source);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2838c = 0;
        this.f2850o = new Rect();
        this.f2851p = new Rect();
        this.f2852q = new Rect();
        this.f2853r = new Rect();
        this.f2854s = new Rect();
        this.f2855t = new Rect();
        this.f2856u = new Rect();
        this.f2858w = 600;
        this.f2861z = new C1051e(this);
        this.f2834A = new C1054f(this);
        this.f2835B = new C1057g(this);
        m4318a(context);
        this.f2836C = new C0640q(this);
    }

    /* renamed from: a */
    private void m4318a(Context context) {
        TypedArray ta = getContext().getTheme().obtainStyledAttributes(f2833a);
        boolean z = false;
        this.f2837b = ta.getDimensionPixelSize(0, 0);
        this.f2842g = ta.getDrawable(1);
        setWillNotDraw(this.f2842g == null);
        ta.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f2843h = z;
        this.f2859x = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo7041h();
    }

    public void setActionBarVisibilityCallback(C0902a cb) {
        this.f2857v = cb;
        if (getWindowToken() != null) {
            this.f2857v.onWindowVisibilityChanged(this.f2838c);
            if (this.f2849n != 0) {
                onWindowSystemUiVisibilityChanged(this.f2849n);
                C0646w.m2991y(this);
            }
        }
    }

    public void setOverlayMode(boolean overlayMode) {
        this.f2844i = overlayMode;
        this.f2843h = overlayMode && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* renamed from: i */
    public boolean mo7042i() {
        return this.f2844i;
    }

    public void setHasNonEmbeddedTabs(boolean hasNonEmbeddedTabs) {
        this.f2845j = hasNonEmbeddedTabs;
    }

    public void setShowingForActionMode(boolean showing) {
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        m4318a(getContext());
        C0646w.m2991y(this);
    }

    public void onWindowSystemUiVisibilityChanged(int visible) {
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(visible);
        }
        mo7043j();
        int diff = this.f2849n ^ visible;
        this.f2849n = visible;
        boolean z = true;
        boolean barVisible = (visible & 4) == 0;
        boolean stable = (visible & Opcodes.ACC_NATIVE) != 0;
        C0902a aVar = this.f2857v;
        if (aVar != null) {
            if (stable) {
                z = false;
            }
            aVar.mo6174a(z);
            if (barVisible || !stable) {
                this.f2857v.mo6171a();
            } else {
                this.f2857v.mo6176c();
            }
        }
        if ((diff & Opcodes.ACC_NATIVE) != 0 && this.f2857v != null) {
            C0646w.m2991y(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.f2838c = visibility;
        C0902a aVar = this.f2857v;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(visibility);
        }
    }

    /* renamed from: a */
    private boolean m4320a(View view, Rect insets, boolean left, boolean top, boolean bottom, boolean right) {
        boolean changed = false;
        C0903b lp = (C0903b) view.getLayoutParams();
        if (left) {
            int i = lp.leftMargin;
            int i2 = insets.left;
            if (i != i2) {
                changed = true;
                lp.leftMargin = i2;
            }
        }
        if (top) {
            int i3 = lp.topMargin;
            int i4 = insets.top;
            if (i3 != i4) {
                changed = true;
                lp.topMargin = i4;
            }
        }
        if (right) {
            int i5 = lp.rightMargin;
            int i6 = insets.right;
            if (i5 != i6) {
                changed = true;
                lp.rightMargin = i6;
            }
        }
        if (!bottom) {
            return changed;
        }
        int i7 = lp.bottomMargin;
        int i8 = insets.bottom;
        if (i7 == i8) {
            return changed;
        }
        lp.bottomMargin = i8;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect insets) {
        mo7043j();
        if ((C0646w.m2980n(this) & Opcodes.ACC_NATIVE) != 0) {
        }
        Rect systemInsets = insets;
        boolean changed = m4320a(this.f2840e, systemInsets, true, true, false, true);
        this.f2853r.set(systemInsets);
        C0946Ib.m4564a(this, this.f2853r, this.f2850o);
        if (!this.f2854s.equals(this.f2853r)) {
            changed = true;
            this.f2854s.set(this.f2853r);
        }
        if (!this.f2851p.equals(this.f2850o)) {
            changed = true;
            this.f2851p.set(this.f2850o);
        }
        if (changed) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public C0903b generateDefaultLayoutParams() {
        return new C0903b(-1, -1);
    }

    public C0903b generateLayoutParams(AttributeSet attrs) {
        return new C0903b(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(LayoutParams p) {
        return new C0903b(p);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return p instanceof C0903b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mo7043j();
        int topInset = 0;
        measureChildWithMargins(this.f2840e, widthMeasureSpec, 0, heightMeasureSpec, 0);
        C0903b lp = (C0903b) this.f2840e.getLayoutParams();
        int maxWidth = Math.max(0, this.f2840e.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
        int maxHeight = Math.max(0, this.f2840e.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
        int childState = View.combineMeasuredStates(0, this.f2840e.getMeasuredState());
        boolean stable = (C0646w.m2980n(this) & Opcodes.ACC_NATIVE) != 0;
        if (stable) {
            topInset = this.f2837b;
            if (this.f2845j && this.f2840e.getTabContainer() != null) {
                topInset += this.f2837b;
            }
        } else if (this.f2840e.getVisibility() != 8) {
            topInset = this.f2840e.getMeasuredHeight();
        }
        this.f2852q.set(this.f2850o);
        this.f2855t.set(this.f2853r);
        if (this.f2844i || stable) {
            Rect rect = this.f2855t;
            rect.top += topInset;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f2852q;
            rect2.top += topInset;
            rect2.bottom += 0;
        }
        m4320a(this.f2839d, this.f2852q, true, true, true, true);
        if (!this.f2856u.equals(this.f2855t)) {
            this.f2856u.set(this.f2855t);
            this.f2839d.mo7174a(this.f2855t);
        }
        measureChildWithMargins(this.f2839d, widthMeasureSpec, 0, heightMeasureSpec, 0);
        C0903b lp2 = (C0903b) this.f2839d.getLayoutParams();
        int maxWidth2 = Math.max(maxWidth, this.f2839d.getMeasuredWidth() + lp2.leftMargin + lp2.rightMargin);
        int maxHeight2 = Math.max(maxHeight, this.f2839d.getMeasuredHeight() + lp2.topMargin + lp2.bottomMargin);
        int childState2 = View.combineMeasuredStates(childState, this.f2839d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(maxWidth2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, childState2), View.resolveSizeAndState(Math.max(maxHeight2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int parentLeft = getPaddingLeft();
        int paddingRight = (right - left) - getPaddingRight();
        int parentTop = getPaddingTop();
        int paddingBottom = (bottom - top) - getPaddingBottom();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                C0903b lp = (C0903b) child.getLayoutParams();
                int childLeft = lp.leftMargin + parentLeft;
                int childTop = lp.topMargin + parentTop;
                child.layout(childLeft, childTop, childLeft + child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
            }
        }
    }

    public void draw(Canvas c) {
        super.draw(c);
        if (this.f2842g != null && !this.f2843h) {
            int top = this.f2840e.getVisibility() == 0 ? (int) (((float) this.f2840e.getBottom()) + this.f2840e.getTranslationY() + 0.5f) : 0;
            this.f2842g.setBounds(0, top, getWidth(), this.f2842g.getIntrinsicHeight() + top);
            this.f2842g.draw(c);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View child, View target, int axes) {
        if ((axes & 2) == 0 || this.f2840e.getVisibility() != 0) {
            return false;
        }
        return this.f2846k;
    }

    public void onNestedScrollAccepted(View child, View target, int axes) {
        this.f2836C.mo5686a(child, target, axes);
        this.f2848m = getActionBarHideOffset();
        mo7041h();
        C0902a aVar = this.f2857v;
        if (aVar != null) {
            aVar.mo6177d();
        }
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        this.f2848m += dyConsumed;
        setActionBarHideOffset(this.f2848m);
    }

    public void onStopNestedScroll(View target) {
        if (this.f2846k && !this.f2847l) {
            if (this.f2848m <= this.f2840e.getHeight()) {
                m4323m();
            } else {
                m4322l();
            }
        }
        C0902a aVar = this.f2857v;
        if (aVar != null) {
            aVar.mo6175b();
        }
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (!this.f2846k || !consumed) {
            return false;
        }
        if (m4319a(velocityX, velocityY)) {
            m4321k();
        } else {
            m4324n();
        }
        this.f2847l = true;
        return true;
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f2836C.mo5683a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo7043j() {
        if (this.f2839d == null) {
            this.f2839d = (ContentFrameLayout) findViewById(C0793R.C0794id.action_bar_activity_content);
            this.f2840e = (ActionBarContainer) findViewById(C0793R.C0794id.action_bar_container);
            this.f2841f = m4317a(findViewById(C0793R.C0794id.action_bar));
        }
    }

    /* renamed from: a */
    private C1021U m4317a(View view) {
        if (view instanceof C1021U) {
            return (C1021U) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view.getClass().getSimpleName());
        throw new IllegalStateException(sb.toString());
    }

    public void setHideOnContentScrollEnabled(boolean hideOnContentScroll) {
        if (hideOnContentScroll != this.f2846k) {
            this.f2846k = hideOnContentScroll;
            if (!hideOnContentScroll) {
                mo7041h();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2840e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int offset) {
        mo7041h();
        this.f2840e.setTranslationY((float) (-Math.max(0, Math.min(offset, this.f2840e.getHeight()))));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public void mo7041h() {
        removeCallbacks(this.f2834A);
        removeCallbacks(this.f2835B);
        ViewPropertyAnimator viewPropertyAnimator = this.f2860y;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: m */
    private void m4323m() {
        mo7041h();
        postDelayed(this.f2834A, 600);
    }

    /* renamed from: l */
    private void m4322l() {
        mo7041h();
        postDelayed(this.f2835B, 600);
    }

    /* renamed from: n */
    private void m4324n() {
        mo7041h();
        this.f2834A.run();
    }

    /* renamed from: k */
    private void m4321k() {
        mo7041h();
        this.f2835B.run();
    }

    /* renamed from: a */
    private boolean m4319a(float velocityX, float velocityY) {
        this.f2859x.fling(0, 0, 0, (int) velocityY, 0, 0, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT);
        return this.f2859x.getFinalY() > this.f2840e.getHeight();
    }

    public void setWindowCallback(Callback cb) {
        mo7043j();
        this.f2841f.setWindowCallback(cb);
    }

    public void setWindowTitle(CharSequence title) {
        mo7043j();
        this.f2841f.setWindowTitle(title);
    }

    public CharSequence getTitle() {
        mo7043j();
        return this.f2841f.getTitle();
    }

    /* renamed from: a */
    public void mo7023a(int windowFeature) {
        mo7043j();
        if (windowFeature == 2) {
            this.f2841f.mo8339k();
        } else if (windowFeature == 5) {
            this.f2841f.mo8342n();
        } else if (windowFeature == 109) {
            setOverlayMode(true);
        }
    }

    public void setUiOptions(int uiOptions) {
    }

    public void setIcon(int resId) {
        mo7043j();
        this.f2841f.setIcon(resId);
    }

    public void setIcon(Drawable d) {
        mo7043j();
        this.f2841f.setIcon(d);
    }

    public void setLogo(int resId) {
        mo7043j();
        this.f2841f.mo8324b(resId);
    }

    /* renamed from: a */
    public boolean mo7025a() {
        mo7043j();
        return this.f2841f.mo8323a();
    }

    /* renamed from: d */
    public boolean mo7029d() {
        mo7043j();
        return this.f2841f.mo8330d();
    }

    /* renamed from: f */
    public boolean mo7032f() {
        mo7043j();
        return this.f2841f.mo8332f();
    }

    /* renamed from: c */
    public boolean mo7027c() {
        mo7043j();
        return this.f2841f.mo8328c();
    }

    /* renamed from: b */
    public boolean mo7026b() {
        mo7043j();
        return this.f2841f.mo8326b();
    }

    /* renamed from: e */
    public void mo7031e() {
        mo7043j();
        this.f2841f.mo8331e();
    }

    /* renamed from: a */
    public void mo7024a(Menu menu, C0891a cb) {
        mo7043j();
        this.f2841f.mo8321a(menu, cb);
    }

    /* renamed from: g */
    public void mo7034g() {
        mo7043j();
        this.f2841f.mo8340l();
    }
}
