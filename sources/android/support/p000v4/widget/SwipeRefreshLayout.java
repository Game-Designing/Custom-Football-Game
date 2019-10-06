package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0636m;
import android.support.p000v4.view.C0637n;
import android.support.p000v4.view.C0639p;
import android.support.p000v4.view.C0640q;
import android.support.p000v4.view.C0646w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.SwipeRefreshLayout */
public class SwipeRefreshLayout extends ViewGroup implements C0639p, C0636m {

    /* renamed from: a */
    private static final String f1940a = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: b */
    private static final int[] f1941b = {16842766};

    /* renamed from: A */
    protected int f1942A;

    /* renamed from: B */
    int f1943B;

    /* renamed from: C */
    C0692f f1944C;

    /* renamed from: D */
    private Animation f1945D;

    /* renamed from: E */
    private Animation f1946E;

    /* renamed from: F */
    private Animation f1947F;

    /* renamed from: G */
    private Animation f1948G;

    /* renamed from: H */
    private Animation f1949H;

    /* renamed from: I */
    boolean f1950I;

    /* renamed from: J */
    private int f1951J;

    /* renamed from: K */
    boolean f1952K;

    /* renamed from: L */
    private C0682a f1953L;

    /* renamed from: M */
    private AnimationListener f1954M;

    /* renamed from: N */
    private final Animation f1955N;

    /* renamed from: O */
    private final Animation f1956O;

    /* renamed from: c */
    private View f1957c;

    /* renamed from: d */
    C0683b f1958d;

    /* renamed from: e */
    boolean f1959e;

    /* renamed from: f */
    private int f1960f;

    /* renamed from: g */
    private float f1961g;

    /* renamed from: h */
    private float f1962h;

    /* renamed from: i */
    private final C0640q f1963i;

    /* renamed from: j */
    private final C0637n f1964j;

    /* renamed from: k */
    private final int[] f1965k;

    /* renamed from: l */
    private final int[] f1966l;

    /* renamed from: m */
    private boolean f1967m;

    /* renamed from: n */
    private int f1968n;

    /* renamed from: o */
    int f1969o;

    /* renamed from: p */
    private float f1970p;

    /* renamed from: q */
    private float f1971q;

    /* renamed from: r */
    private boolean f1972r;

    /* renamed from: s */
    private int f1973s;

    /* renamed from: t */
    boolean f1974t;

    /* renamed from: u */
    private boolean f1975u;

    /* renamed from: v */
    private final DecelerateInterpolator f1976v;

    /* renamed from: w */
    C0688c f1977w;

    /* renamed from: x */
    private int f1978x;

    /* renamed from: y */
    protected int f1979y;

    /* renamed from: z */
    float f1980z;

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$a */
    public interface C0682a {
        /* renamed from: a */
        boolean mo5893a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SwipeRefreshLayout$b */
    public interface C0683b {
        /* renamed from: a */
        void mo5894a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo5860c() {
        this.f1977w.clearAnimation();
        this.f1944C.stop();
        this.f1977w.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f1974t) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f1942A - this.f1969o);
        }
        this.f1969o = this.f1977w.getTop();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!enabled) {
            mo5860c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo5860c();
    }

    private void setColorViewAlpha(int targetAlpha) {
        this.f1977w.getBackground().setAlpha(targetAlpha);
        this.f1944C.setAlpha(targetAlpha);
    }

    public int getProgressViewStartOffset() {
        return this.f1942A;
    }

    public int getProgressViewEndOffset() {
        return this.f1943B;
    }

    public void setSize(int size) {
        if (size == 0 || size == 1) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            if (size == 0) {
                this.f1951J = (int) (metrics.density * 56.0f);
            } else {
                this.f1951J = (int) (metrics.density * 40.0f);
            }
            this.f1977w.setImageDrawable(null);
            this.f1944C.mo5937a(size);
            this.f1977w.setImageDrawable(this.f1944C);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1959e = false;
        this.f1961g = -1.0f;
        this.f1965k = new int[2];
        this.f1966l = new int[2];
        this.f1973s = -1;
        this.f1978x = -1;
        this.f1954M = new C0723u(this);
        this.f1955N = new C0728z(this);
        this.f1956O = new C0663A(this);
        this.f1960f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1968n = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1976v = new DecelerateInterpolator(2.0f);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        this.f1951J = (int) (metrics.density * 40.0f);
        m3213d();
        setChildrenDrawingOrderEnabled(true);
        this.f1943B = (int) (metrics.density * 64.0f);
        this.f1961g = (float) this.f1943B;
        this.f1963i = new C0640q(this);
        this.f1964j = new C0637n(this);
        setNestedScrollingEnabled(true);
        int i = -this.f1951J;
        this.f1969o = i;
        this.f1942A = i;
        mo5856a(1.0f);
        TypedArray a = context.obtainStyledAttributes(attrs, f1941b);
        setEnabled(a.getBoolean(0, true));
        a.recycle();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int childCount, int i) {
        int i2 = this.f1978x;
        if (i2 < 0) {
            return i;
        }
        if (i == childCount - 1) {
            return i2;
        }
        if (i >= i2) {
            return i + 1;
        }
        return i;
    }

    /* renamed from: d */
    private void m3213d() {
        this.f1977w = new C0688c(getContext(), -328966);
        this.f1944C = new C0692f(getContext());
        this.f1944C.mo5937a(1);
        this.f1977w.setImageDrawable(this.f1944C);
        this.f1977w.setVisibility(8);
        addView(this.f1977w);
    }

    public void setOnRefreshListener(C0683b listener) {
        this.f1958d = listener;
    }

    public void setRefreshing(boolean refreshing) {
        int endTarget;
        if (!refreshing || this.f1959e == refreshing) {
            m3206a(refreshing, false);
            return;
        }
        this.f1959e = refreshing;
        if (!this.f1952K) {
            endTarget = this.f1943B + this.f1942A;
        } else {
            endTarget = this.f1943B;
        }
        setTargetOffsetTopAndBottom(endTarget - this.f1969o);
        this.f1950I = false;
        m3210b(this.f1954M);
    }

    /* renamed from: b */
    private void m3210b(AnimationListener listener) {
        this.f1977w.setVisibility(0);
        this.f1944C.setAlpha(255);
        this.f1945D = new C0724v(this);
        this.f1945D.setDuration((long) this.f1968n);
        if (listener != null) {
            this.f1977w.mo5923a(listener);
        }
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(this.f1945D);
    }

    /* access modifiers changed from: 0000 */
    public void setAnimationProgress(float progress) {
        this.f1977w.setScaleX(progress);
        this.f1977w.setScaleY(progress);
    }

    /* renamed from: a */
    private void m3206a(boolean refreshing, boolean notify) {
        if (this.f1959e != refreshing) {
            this.f1950I = notify;
            m3215e();
            this.f1959e = refreshing;
            if (this.f1959e) {
                m3204a(this.f1969o, this.f1954M);
            } else {
                mo5857a(this.f1954M);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5857a(AnimationListener listener) {
        this.f1946E = new C0725w(this);
        this.f1946E.setDuration(150);
        this.f1977w.mo5923a(listener);
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(this.f1946E);
    }

    /* renamed from: g */
    private void m3217g() {
        this.f1947F = m3203a(this.f1944C.getAlpha(), 76);
    }

    /* renamed from: f */
    private void m3216f() {
        this.f1948G = m3203a(this.f1944C.getAlpha(), 255);
    }

    /* renamed from: a */
    private Animation m3203a(int startingAlpha, int endingAlpha) {
        Animation alpha = new C0726x(this, startingAlpha, endingAlpha);
        alpha.setDuration(300);
        this.f1977w.mo5923a(null);
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(alpha);
        return alpha;
    }

    @Deprecated
    public void setProgressBackgroundColor(int colorRes) {
        setProgressBackgroundColorSchemeResource(colorRes);
    }

    public void setProgressBackgroundColorSchemeResource(int colorRes) {
        setProgressBackgroundColorSchemeColor(C0510b.m2564a(getContext(), colorRes));
    }

    public void setProgressBackgroundColorSchemeColor(int color) {
        this.f1977w.setBackgroundColor(color);
    }

    @Deprecated
    public void setColorScheme(int... colors) {
        setColorSchemeResources(colors);
    }

    public void setColorSchemeResources(int... colorResIds) {
        Context context = getContext();
        int[] colorRes = new int[colorResIds.length];
        for (int i = 0; i < colorResIds.length; i++) {
            colorRes[i] = C0510b.m2564a(context, colorResIds[i]);
        }
        setColorSchemeColors(colorRes);
    }

    public void setColorSchemeColors(int... colors) {
        m3215e();
        this.f1944C.mo5939a(colors);
    }

    /* renamed from: b */
    public boolean mo5859b() {
        return this.f1959e;
    }

    /* renamed from: e */
    private void m3215e() {
        if (this.f1957c == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (!child.equals(this.f1977w)) {
                    this.f1957c = child;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int distance) {
        this.f1961g = (float) distance;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1957c == null) {
                m3215e();
            }
            if (this.f1957c != null) {
                View child = this.f1957c;
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, childLeft + ((width - getPaddingLeft()) - getPaddingRight()), childTop + ((height - getPaddingTop()) - getPaddingBottom()));
                int circleWidth = this.f1977w.getMeasuredWidth();
                int circleHeight = this.f1977w.getMeasuredHeight();
                C0688c cVar = this.f1977w;
                int i = (width / 2) - (circleWidth / 2);
                int i2 = this.f1969o;
                cVar.layout(i, i2, (width / 2) + (circleWidth / 2), i2 + circleHeight);
            }
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f1957c == null) {
            m3215e();
        }
        View view = this.f1957c;
        if (view != null) {
            view.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1977w.measure(MeasureSpec.makeMeasureSpec(this.f1951J, 1073741824), MeasureSpec.makeMeasureSpec(this.f1951J, 1073741824));
            this.f1978x = -1;
            int index = 0;
            while (true) {
                if (index >= getChildCount()) {
                    break;
                } else if (getChildAt(index) == this.f1977w) {
                    this.f1978x = index;
                    break;
                } else {
                    index++;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f1951J;
    }

    /* renamed from: a */
    public boolean mo5858a() {
        C0682a aVar = this.f1953L;
        if (aVar != null) {
            return aVar.mo5893a(this, this.f1957c);
        }
        View view = this.f1957c;
        if (view instanceof ListView) {
            return C0714p.m3352a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(C0682a callback) {
        this.f1953L = callback;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        m3215e();
        int action = ev.getActionMasked();
        if (this.f1975u && action == 0) {
            this.f1975u = false;
        }
        if (!isEnabled() || this.f1975u || mo5858a() || this.f1959e || this.f1967m) {
            return false;
        }
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i = this.f1973s;
                    if (i == -1) {
                        Log.e(f1940a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int pointerIndex = ev.findPointerIndex(i);
                    if (pointerIndex < 0) {
                        return false;
                    }
                    m3214d(ev.getY(pointerIndex));
                } else if (action != 3) {
                    if (action == 6) {
                        m3205a(ev);
                    }
                }
            }
            this.f1972r = false;
            this.f1973s = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f1942A - this.f1977w.getTop());
            this.f1973s = ev.getPointerId(0);
            this.f1972r = false;
            int pointerIndex2 = ev.findPointerIndex(this.f1973s);
            if (pointerIndex2 < 0) {
                return false;
            }
            this.f1971q = ev.getY(pointerIndex2);
        }
        return this.f1972r;
    }

    public void requestDisallowInterceptTouchEvent(boolean b) {
        if (VERSION.SDK_INT >= 21 || !(this.f1957c instanceof AbsListView)) {
            View view = this.f1957c;
            if (view == null || C0646w.m2988v(view)) {
                super.requestDisallowInterceptTouchEvent(b);
            }
        }
    }

    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return isEnabled() && !this.f1975u && !this.f1959e && (nestedScrollAxes & 2) != 0;
    }

    public void onNestedScrollAccepted(View child, View target, int axes) {
        this.f1963i.mo5686a(child, target, axes);
        startNestedScroll(axes & 2);
        this.f1962h = 0.0f;
        this.f1967m = true;
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        if (dy > 0) {
            float f = this.f1962h;
            if (f > 0.0f) {
                if (((float) dy) > f) {
                    consumed[1] = dy - ((int) f);
                    this.f1962h = 0.0f;
                } else {
                    this.f1962h = f - ((float) dy);
                    consumed[1] = dy;
                }
                m3211c(this.f1962h);
            }
        }
        if (this.f1952K && dy > 0 && this.f1962h == 0.0f && Math.abs(dy - consumed[1]) > 0) {
            this.f1977w.setVisibility(8);
        }
        int[] parentConsumed = this.f1965k;
        if (dispatchNestedPreScroll(dx - consumed[0], dy - consumed[1], parentConsumed, null)) {
            consumed[0] = consumed[0] + parentConsumed[0];
            consumed[1] = consumed[1] + parentConsumed[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f1963i.mo5683a();
    }

    public void onStopNestedScroll(View target) {
        this.f1963i.mo5684a(target);
        this.f1967m = false;
        float f = this.f1962h;
        if (f > 0.0f) {
            m3208b(f);
            this.f1962h = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, this.f1966l);
        int dy = this.f1966l[1] + dyUnconsumed;
        if (dy < 0 && !mo5858a()) {
            this.f1962h += (float) Math.abs(dy);
            m3211c(this.f1962h);
        }
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        this.f1964j.mo5669a(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1964j.mo5679b();
    }

    public boolean startNestedScroll(int axes) {
        return this.f1964j.mo5680b(axes);
    }

    public void stopNestedScroll() {
        this.f1964j.mo5681c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1964j.mo5670a();
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.f1964j.mo5675a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.f1964j.mo5677a(dx, dy, consumed, offsetInWindow);
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY);
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.f1964j.mo5672a(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.f1964j.mo5671a(velocityX, velocityY);
    }

    /* renamed from: a */
    private boolean m3207a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* renamed from: c */
    private void m3211c(float overscrollTop) {
        this.f1944C.mo5938a(true);
        float dragPercent = Math.min(1.0f, Math.abs(overscrollTop / this.f1961g));
        double d = (double) dragPercent;
        Double.isNaN(d);
        float adjustedPercent = (((float) Math.max(d - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float slingshotDist = (float) (this.f1952K ? this.f1943B - this.f1942A : this.f1943B);
        float tensionSlingshotPercent = Math.max(0.0f, Math.min(Math.abs(overscrollTop) - this.f1961g, slingshotDist * 2.0f) / slingshotDist);
        double d2 = (double) (tensionSlingshotPercent / 4.0f);
        double pow = Math.pow((double) (tensionSlingshotPercent / 4.0f), 2.0d);
        Double.isNaN(d2);
        float tensionPercent = ((float) (d2 - pow)) * 2.0f;
        int targetY = this.f1942A + ((int) ((slingshotDist * dragPercent) + (slingshotDist * tensionPercent * 2.0f)));
        if (this.f1977w.getVisibility() != 0) {
            this.f1977w.setVisibility(0);
        }
        if (!this.f1974t) {
            this.f1977w.setScaleX(1.0f);
            this.f1977w.setScaleY(1.0f);
        }
        if (this.f1974t) {
            setAnimationProgress(Math.min(1.0f, overscrollTop / this.f1961g));
        }
        if (overscrollTop < this.f1961g) {
            if (this.f1944C.getAlpha() > 76 && !m3207a(this.f1947F)) {
                m3217g();
            }
        } else if (this.f1944C.getAlpha() < 255 && !m3207a(this.f1948G)) {
            m3216f();
        }
        this.f1944C.mo5936a(0.0f, Math.min(0.8f, adjustedPercent * 0.8f));
        this.f1944C.mo5935a(Math.min(1.0f, adjustedPercent));
        this.f1944C.mo5940b((((0.4f * adjustedPercent) - 16.0f) + (2.0f * tensionPercent)) * 0.5f);
        setTargetOffsetTopAndBottom(targetY - this.f1969o);
    }

    /* renamed from: b */
    private void m3208b(float overscrollTop) {
        if (overscrollTop > this.f1961g) {
            m3206a(true, true);
            return;
        }
        this.f1959e = false;
        this.f1944C.mo5936a(0.0f, 0.0f);
        AnimationListener listener = null;
        if (!this.f1974t) {
            listener = new C0727y(this);
        }
        m3209b(this.f1969o, listener);
        this.f1944C.mo5938a(false);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (this.f1975u && action == 0) {
            this.f1975u = false;
        }
        if (!isEnabled() || this.f1975u || mo5858a() || this.f1959e || this.f1967m) {
            return false;
        }
        if (action == 0) {
            this.f1973s = ev.getPointerId(0);
            this.f1972r = false;
        } else if (action == 1) {
            int pointerIndex = ev.findPointerIndex(this.f1973s);
            if (pointerIndex < 0) {
                Log.e(f1940a, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f1972r) {
                float overscrollTop = (ev.getY(pointerIndex) - this.f1970p) * 0.5f;
                this.f1972r = false;
                m3208b(overscrollTop);
            }
            this.f1973s = -1;
            return false;
        } else if (action == 2) {
            int pointerIndex2 = ev.findPointerIndex(this.f1973s);
            if (pointerIndex2 < 0) {
                Log.e(f1940a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = ev.getY(pointerIndex2);
            m3214d(y);
            if (this.f1972r) {
                float overscrollTop2 = (y - this.f1970p) * 0.5f;
                if (overscrollTop2 <= 0.0f) {
                    return false;
                }
                m3211c(overscrollTop2);
            }
        } else if (action == 3) {
            return false;
        } else {
            if (action == 5) {
                int pointerIndex3 = ev.getActionIndex();
                if (pointerIndex3 < 0) {
                    Log.e(f1940a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f1973s = ev.getPointerId(pointerIndex3);
            } else if (action == 6) {
                m3205a(ev);
            }
        }
        return true;
    }

    /* renamed from: d */
    private void m3214d(float y) {
        float f = this.f1971q;
        float yDiff = y - f;
        int i = this.f1960f;
        if (yDiff > ((float) i) && !this.f1972r) {
            this.f1970p = f + ((float) i);
            this.f1972r = true;
            this.f1944C.setAlpha(76);
        }
    }

    /* renamed from: a */
    private void m3204a(int from, AnimationListener listener) {
        this.f1979y = from;
        this.f1955N.reset();
        this.f1955N.setDuration(200);
        this.f1955N.setInterpolator(this.f1976v);
        if (listener != null) {
            this.f1977w.mo5923a(listener);
        }
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(this.f1955N);
    }

    /* renamed from: b */
    private void m3209b(int from, AnimationListener listener) {
        if (this.f1974t) {
            m3212c(from, listener);
            return;
        }
        this.f1979y = from;
        this.f1956O.reset();
        this.f1956O.setDuration(200);
        this.f1956O.setInterpolator(this.f1976v);
        if (listener != null) {
            this.f1977w.mo5923a(listener);
        }
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(this.f1956O);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5856a(float interpolatedTime) {
        int i = this.f1979y;
        setTargetOffsetTopAndBottom((i + ((int) (((float) (this.f1942A - i)) * interpolatedTime))) - this.f1977w.getTop());
    }

    /* renamed from: c */
    private void m3212c(int from, AnimationListener listener) {
        this.f1979y = from;
        this.f1980z = this.f1977w.getScaleX();
        this.f1949H = new C0664B(this);
        this.f1949H.setDuration(150);
        if (listener != null) {
            this.f1977w.mo5923a(listener);
        }
        this.f1977w.clearAnimation();
        this.f1977w.startAnimation(this.f1949H);
    }

    /* access modifiers changed from: 0000 */
    public void setTargetOffsetTopAndBottom(int offset) {
        this.f1977w.bringToFront();
        C0646w.m2965b((View) this.f1977w, offset);
        this.f1969o = this.f1977w.getTop();
    }

    /* renamed from: a */
    private void m3205a(MotionEvent ev) {
        int pointerIndex = ev.getActionIndex();
        if (ev.getPointerId(pointerIndex) == this.f1973s) {
            this.f1973s = ev.getPointerId(pointerIndex == 0 ? 1 : 0);
        }
    }
}
