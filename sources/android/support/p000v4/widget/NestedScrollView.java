package android.support.p000v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.C0635l;
import android.support.p000v4.view.C0637n;
import android.support.p000v4.view.C0639p;
import android.support.p000v4.view.C0640q;
import android.support.p000v4.view.C0644u;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0608d;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v4.widget.NestedScrollView */
public class NestedScrollView extends FrameLayout implements C0639p, C0635l, C0644u {

    /* renamed from: a */
    private static final C0680a f1911a = new C0680a();

    /* renamed from: b */
    private static final int[] f1912b = {16843130};

    /* renamed from: A */
    private float f1913A;

    /* renamed from: B */
    private C0681b f1914B;

    /* renamed from: c */
    private long f1915c;

    /* renamed from: d */
    private final Rect f1916d;

    /* renamed from: e */
    private OverScroller f1917e;

    /* renamed from: f */
    private EdgeEffect f1918f;

    /* renamed from: g */
    private EdgeEffect f1919g;

    /* renamed from: h */
    private int f1920h;

    /* renamed from: i */
    private boolean f1921i;

    /* renamed from: j */
    private boolean f1922j;

    /* renamed from: k */
    private View f1923k;

    /* renamed from: l */
    private boolean f1924l;

    /* renamed from: m */
    private VelocityTracker f1925m;

    /* renamed from: n */
    private boolean f1926n;

    /* renamed from: o */
    private boolean f1927o;

    /* renamed from: p */
    private int f1928p;

    /* renamed from: q */
    private int f1929q;

    /* renamed from: r */
    private int f1930r;

    /* renamed from: s */
    private int f1931s;

    /* renamed from: t */
    private final int[] f1932t;

    /* renamed from: u */
    private final int[] f1933u;

    /* renamed from: v */
    private int f1934v;

    /* renamed from: w */
    private int f1935w;

    /* renamed from: x */
    private SavedState f1936x;

    /* renamed from: y */
    private final C0640q f1937y;

    /* renamed from: z */
    private final C0637n f1938z;

    /* renamed from: android.support.v4.widget.NestedScrollView$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0715q();

        /* renamed from: a */
        public int f1939a;

        SavedState(Parcelable superState) {
            super(superState);
        }

        SavedState(Parcel source) {
            super(source);
            this.f1939a = source.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f1939a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            sb.append(this.f1939a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$a */
    static class C0680a extends C0616c {
        C0680a() {
        }

        /* renamed from: a */
        public boolean mo5565a(View host, int action, Bundle arguments) {
            if (super.mo5565a(host, action, arguments)) {
                return true;
            }
            NestedScrollView nsvHost = (NestedScrollView) host;
            if (!nsvHost.isEnabled()) {
                return false;
            }
            if (action == 4096) {
                int targetScrollY = Math.min(nsvHost.getScrollY() + ((nsvHost.getHeight() - nsvHost.getPaddingBottom()) - nsvHost.getPaddingTop()), nsvHost.getScrollRange());
                if (targetScrollY == nsvHost.getScrollY()) {
                    return false;
                }
                nsvHost.mo5803b(0, targetScrollY);
                return true;
            } else if (action != 8192) {
                return false;
            } else {
                int targetScrollY2 = Math.max(nsvHost.getScrollY() - ((nsvHost.getHeight() - nsvHost.getPaddingBottom()) - nsvHost.getPaddingTop()), 0);
                if (targetScrollY2 == nsvHost.getScrollY()) {
                    return false;
                }
                nsvHost.mo5803b(0, targetScrollY2);
                return true;
            }
        }

        /* renamed from: a */
        public void mo4150a(View host, C0604b info) {
            super.mo4150a(host, info);
            NestedScrollView nsvHost = (NestedScrollView) host;
            info.mo5582a((CharSequence) ScrollView.class.getName());
            if (nsvHost.isEnabled()) {
                int scrollRange = nsvHost.getScrollRange();
                if (scrollRange > 0) {
                    info.mo5594d(true);
                    if (nsvHost.getScrollY() > 0) {
                        info.mo5579a((int) Opcodes.ACC_ANNOTATION);
                    }
                    if (nsvHost.getScrollY() < scrollRange) {
                        info.mo5579a((int) Opcodes.ACC_SYNTHETIC);
                    }
                }
            }
        }

        /* renamed from: b */
        public void mo4625b(View host, AccessibilityEvent event) {
            super.mo4625b(host, event);
            NestedScrollView nsvHost = (NestedScrollView) host;
            event.setClassName(ScrollView.class.getName());
            event.setScrollable(nsvHost.getScrollRange() > 0);
            event.setScrollX(nsvHost.getScrollX());
            event.setScrollY(nsvHost.getScrollY());
            C0608d.m2851a(event, nsvHost.getScrollX());
            C0608d.m2852b(event, nsvHost.getScrollRange());
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$b */
    public interface C0681b {
        /* renamed from: a */
        void mo5855a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f1916d = new Rect();
        this.f1921i = true;
        this.f1922j = false;
        this.f1923k = null;
        this.f1924l = false;
        this.f1927o = true;
        this.f1931s = -1;
        this.f1932t = new int[2];
        this.f1933u = new int[2];
        m3180e();
        TypedArray a = context.obtainStyledAttributes(attrs, f1912b, defStyleAttr, 0);
        setFillViewport(a.getBoolean(0, false));
        a.recycle();
        this.f1937y = new C0640q(this);
        this.f1938z = new C0637n(this);
        setNestedScrollingEnabled(true);
        C0646w.m2955a((View) this, (C0616c) f1911a);
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        this.f1938z.mo5669a(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1938z.mo5679b();
    }

    public boolean startNestedScroll(int axes) {
        return this.f1938z.mo5680b(axes);
    }

    /* renamed from: c */
    public boolean mo5805c(int axes, int type) {
        return this.f1938z.mo5674a(axes, type);
    }

    public void stopNestedScroll() {
        this.f1938z.mo5681c();
    }

    /* renamed from: f */
    public void mo5821f(int type) {
        this.f1938z.mo5682c(type);
    }

    public boolean hasNestedScrollingParent() {
        return this.f1938z.mo5670a();
    }

    /* renamed from: d */
    public boolean mo5813d(int type) {
        return this.f1938z.mo5673a(type);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.f1938z.mo5675a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /* renamed from: a */
    public boolean mo5795a(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.f1938z.mo5676a(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.f1938z.mo5677a(dx, dy, consumed, offsetInWindow);
    }

    /* renamed from: a */
    public boolean mo5796a(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.f1938z.mo5678a(dx, dy, consumed, offsetInWindow, type);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.f1938z.mo5672a(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.f1938z.mo5671a(velocityX, velocityY);
    }

    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & 2) != 0;
    }

    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        this.f1937y.mo5686a(child, target, nestedScrollAxes);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View target) {
        this.f1937y.mo5684a(target);
        stopNestedScroll();
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int oldScrollY = getScrollY();
        scrollBy(0, dyUnconsumed);
        int myConsumed = getScrollY() - oldScrollY;
        dispatchNestedScroll(0, myConsumed, 0, dyUnconsumed - myConsumed, null);
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        dispatchNestedPreScroll(dx, dy, consumed, null);
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        if (consumed) {
            return false;
        }
        m3184h((int) velocityY);
        return true;
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY);
    }

    public int getNestedScrollAxes() {
        return this.f1937y.mo5683a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int length = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < length) {
            return ((float) scrollY) / ((float) length);
        }
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int length = getVerticalFadingEdgeLength();
        int span = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (span < length) {
            return ((float) span) / ((float) length);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    /* renamed from: e */
    private void m3180e() {
        this.f1917e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(Opcodes.ASM4);
        setWillNotDraw(false);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        this.f1928p = configuration.getScaledTouchSlop();
        this.f1929q = configuration.getScaledMinimumFlingVelocity();
        this.f1930r = configuration.getScaledMaximumFlingVelocity();
    }

    public void addView(View child) {
        if (getChildCount() <= 0) {
            super.addView(child);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View child, int index) {
        if (getChildCount() <= 0) {
            super.addView(child, index);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View child, LayoutParams params) {
        if (getChildCount() <= 0) {
            super.addView(child, params);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View child, int index, LayoutParams params) {
        if (getChildCount() <= 0) {
            super.addView(child, index, params);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(C0681b l) {
        this.f1914B = l;
    }

    /* renamed from: a */
    private boolean m3169a() {
        boolean z = false;
        View child = getChildAt(0);
        if (child == null) {
            return false;
        }
        if (getHeight() < getPaddingTop() + child.getHeight() + getPaddingBottom()) {
            z = true;
        }
        return z;
    }

    public void setFillViewport(boolean fillViewport) {
        if (fillViewport != this.f1926n) {
            this.f1926n = fillViewport;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        this.f1927o = smoothScrollingEnabled;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        C0681b bVar = this.f1914B;
        if (bVar != null) {
            bVar.mo5855a(this, l, t, oldl, oldt);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f1926n && MeasureSpec.getMode(heightMeasureSpec) != 0 && getChildCount() > 0) {
            View child = getChildAt(0);
            int height = getMeasuredHeight();
            if (child.getMeasuredHeight() < height) {
                child.measure(FrameLayout.getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) child.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((height - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event) || mo5797a(event);
    }

    /* renamed from: a */
    public boolean mo5797a(KeyEvent event) {
        this.f1916d.setEmpty();
        boolean a = m3169a();
        int i = Opcodes.IXOR;
        if (!a) {
            boolean z = false;
            if (!isFocused() || event.getKeyCode() == 4) {
                return false;
            }
            View currentFocused = findFocus();
            if (currentFocused == this) {
                currentFocused = null;
            }
            View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, Opcodes.IXOR);
            if (!(nextFocused == null || nextFocused == this || !nextFocused.requestFocus(Opcodes.IXOR))) {
                z = true;
            }
            return z;
        }
        boolean handled = false;
        if (event.getAction() == 0) {
            int keyCode = event.getKeyCode();
            if (keyCode == 19) {
                handled = !event.isAltPressed() ? mo5793a(33) : mo5804c(33);
            } else if (keyCode == 20) {
                handled = !event.isAltPressed() ? mo5793a((int) Opcodes.IXOR) : mo5804c(Opcodes.IXOR);
            } else if (keyCode == 62) {
                if (event.isShiftPressed()) {
                    i = 33;
                }
                mo5820e(i);
            }
        }
        return handled;
    }

    /* renamed from: d */
    private boolean m3179d(int x, int y) {
        boolean z = false;
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View child = getChildAt(0);
        if (y >= child.getTop() - scrollY && y < child.getBottom() - scrollY && x >= child.getLeft() && x < child.getRight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    private void m3178d() {
        VelocityTracker velocityTracker = this.f1925m;
        if (velocityTracker == null) {
            this.f1925m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: f */
    private void m3181f() {
        if (this.f1925m == null) {
            this.f1925m = VelocityTracker.obtain();
        }
    }

    /* renamed from: g */
    private void m3182g() {
        VelocityTracker velocityTracker = this.f1925m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1925m = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            m3182g();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        MotionEvent motionEvent = ev;
        int action = ev.getAction();
        if (action == 2 && this.f1924l) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int activePointerId = this.f1931s;
                    if (activePointerId != -1) {
                        int pointerIndex = motionEvent.findPointerIndex(activePointerId);
                        if (pointerIndex == -1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid pointerId=");
                            sb.append(activePointerId);
                            sb.append(" in onInterceptTouchEvent");
                            Log.e("NestedScrollView", sb.toString());
                        } else {
                            int y = (int) motionEvent.getY(pointerIndex);
                            if (Math.abs(y - this.f1920h) > this.f1928p && (2 & getNestedScrollAxes()) == 0) {
                                this.f1924l = true;
                                this.f1920h = y;
                                m3181f();
                                this.f1925m.addMovement(motionEvent);
                                this.f1934v = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        m3168a(ev);
                    }
                }
            }
            this.f1924l = false;
            this.f1931s = -1;
            m3182g();
            if (this.f1917e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                C0646w.m2990x(this);
            }
            mo5821f(0);
        } else {
            int y2 = (int) ev.getY();
            if (!m3179d((int) ev.getX(), y2)) {
                this.f1924l = false;
                m3182g();
            } else {
                this.f1920h = y2;
                this.f1931s = motionEvent.getPointerId(0);
                m3178d();
                this.f1925m.addMovement(motionEvent);
                this.f1917e.computeScrollOffset();
                this.f1924l = true ^ this.f1917e.isFinished();
                mo5805c(2, 0);
            }
        }
        return this.f1924l;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        boolean z;
        MotionEvent motionEvent = ev;
        m3181f();
        MotionEvent vtev = MotionEvent.obtain(ev);
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.f1934v = 0;
        }
        vtev.offsetLocation(0.0f, (float) this.f1934v);
        if (actionMasked == 0) {
            z = true;
            if (getChildCount() == 0) {
                return false;
            }
            boolean z2 = !this.f1917e.isFinished();
            this.f1924l = z2;
            if (z2) {
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            if (!this.f1917e.isFinished()) {
                this.f1917e.abortAnimation();
            }
            this.f1920h = (int) ev.getY();
            this.f1931s = motionEvent.getPointerId(0);
            mo5805c(2, 0);
        } else if (actionMasked == 1) {
            z = true;
            VelocityTracker velocityTracker = this.f1925m;
            velocityTracker.computeCurrentVelocity(1000, (float) this.f1930r);
            int initialVelocity = (int) velocityTracker.getYVelocity(this.f1931s);
            if (Math.abs(initialVelocity) > this.f1929q) {
                m3184h(-initialVelocity);
            } else if (this.f1917e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                C0646w.m2990x(this);
            }
            this.f1931s = -1;
            m3174b();
        } else if (actionMasked == 2) {
            int activePointerIndex = motionEvent.findPointerIndex(this.f1931s);
            if (activePointerIndex == -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid pointerId=");
                sb.append(this.f1931s);
                sb.append(" in onTouchEvent");
                Log.e("NestedScrollView", sb.toString());
                z = true;
            } else {
                int y = (int) motionEvent.getY(activePointerIndex);
                int deltaY = this.f1920h - y;
                if (mo5796a(0, deltaY, this.f1933u, this.f1932t, 0)) {
                    deltaY -= this.f1933u[1];
                    vtev.offsetLocation(0.0f, (float) this.f1932t[1]);
                    this.f1934v += this.f1932t[1];
                }
                if (!this.f1924l && Math.abs(deltaY) > this.f1928p) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f1924l = true;
                    if (deltaY > 0) {
                        deltaY -= this.f1928p;
                    } else {
                        deltaY += this.f1928p;
                    }
                }
                if (this.f1924l) {
                    this.f1920h = y - this.f1932t[1];
                    int oldY = getScrollY();
                    int range = getScrollRange();
                    int overscrollMode = getOverScrollMode();
                    boolean canOverscroll = overscrollMode == 0 || (overscrollMode == 1 && range > 0);
                    int i = overscrollMode;
                    int range2 = range;
                    int deltaY2 = deltaY;
                    int i2 = y;
                    int activePointerIndex2 = activePointerIndex;
                    if (mo5794a(0, deltaY, 0, getScrollY(), 0, range2, 0, 0, true) && !mo5813d(0)) {
                        this.f1925m.clear();
                    }
                    int scrolledDeltaY = getScrollY() - oldY;
                    if (mo5795a(0, scrolledDeltaY, 0, deltaY2 - scrolledDeltaY, this.f1932t, 0)) {
                        int i3 = this.f1920h;
                        int[] iArr = this.f1932t;
                        z = true;
                        this.f1920h = i3 - iArr[1];
                        vtev.offsetLocation(0.0f, (float) iArr[1]);
                        this.f1934v += this.f1932t[1];
                        int i4 = activePointerIndex2;
                    } else {
                        z = true;
                        if (canOverscroll) {
                            m3177c();
                            int pulledToY = oldY + deltaY2;
                            if (pulledToY < 0) {
                                C0706m.m3330a(this.f1918f, ((float) deltaY2) / ((float) getHeight()), motionEvent.getX(activePointerIndex2) / ((float) getWidth()));
                                if (!this.f1919g.isFinished()) {
                                    this.f1919g.onRelease();
                                    int i5 = range2;
                                } else {
                                    int i6 = range2;
                                }
                            } else {
                                int activePointerIndex3 = activePointerIndex2;
                                if (pulledToY > range2) {
                                    C0706m.m3330a(this.f1919g, ((float) deltaY2) / ((float) getHeight()), 1.0f - (motionEvent.getX(activePointerIndex3) / ((float) getWidth())));
                                    if (!this.f1918f.isFinished()) {
                                        this.f1918f.onRelease();
                                    }
                                }
                            }
                            EdgeEffect edgeEffect = this.f1918f;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f1919g.isFinished())) {
                                C0646w.m2990x(this);
                            }
                        } else {
                            int i7 = activePointerIndex2;
                        }
                    }
                } else {
                    int i8 = y;
                    int i9 = activePointerIndex;
                    z = true;
                }
            }
        } else if (actionMasked == 3) {
            if (this.f1924l != 0 && getChildCount() > 0 && this.f1917e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                C0646w.m2990x(this);
            }
            this.f1931s = -1;
            m3174b();
            z = true;
        } else if (actionMasked == 5) {
            int index = ev.getActionIndex();
            this.f1920h = (int) motionEvent.getY(index);
            this.f1931s = motionEvent.getPointerId(index);
            z = true;
        } else if (actionMasked != 6) {
            z = true;
        } else {
            m3168a(ev);
            this.f1920h = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1931s));
            z = true;
        }
        VelocityTracker velocityTracker2 = this.f1925m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(vtev);
        }
        vtev.recycle();
        return z;
    }

    /* renamed from: a */
    private void m3168a(MotionEvent ev) {
        int pointerIndex = ev.getActionIndex();
        if (ev.getPointerId(pointerIndex) == this.f1931s) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.f1920h = (int) ev.getY(newPointerIndex);
            this.f1931s = ev.getPointerId(newPointerIndex);
            VelocityTracker velocityTracker = this.f1925m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        if ((event.getSource() & 2) != 0 && event.getAction() == 8 && !this.f1924l) {
            float vscroll = event.getAxisValue(9);
            if (vscroll != 0.0f) {
                int delta = (int) (getVerticalScrollFactorCompat() * vscroll);
                int range = getScrollRange();
                int oldScrollY = getScrollY();
                int newScrollY = oldScrollY - delta;
                if (newScrollY < 0) {
                    newScrollY = 0;
                } else if (newScrollY > range) {
                    newScrollY = range;
                }
                if (newScrollY != oldScrollY) {
                    super.scrollTo(getScrollX(), newScrollY);
                    return true;
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1913A == 0.0f) {
            TypedValue outValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, outValue, true)) {
                this.f1913A = outValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1913A;
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.scrollTo(scrollX, scrollY);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo5794a(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        int maxOverScrollX2;
        int maxOverScrollY2;
        boolean clampedX;
        int newScrollY;
        boolean clampedY;
        int overScrollMode = getOverScrollMode();
        boolean canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean overScrollHorizontal = overScrollMode == 0 || (overScrollMode == 1 && canScrollHorizontal);
        boolean overScrollVertical = overScrollMode == 0 || (overScrollMode == 1 && canScrollVertical);
        int newScrollX = scrollX + deltaX;
        if (!overScrollHorizontal) {
            maxOverScrollX2 = 0;
        } else {
            maxOverScrollX2 = maxOverScrollX;
        }
        int newScrollY2 = scrollY + deltaY;
        if (!overScrollVertical) {
            maxOverScrollY2 = 0;
        } else {
            maxOverScrollY2 = maxOverScrollY;
        }
        int left = -maxOverScrollX2;
        int right = maxOverScrollX2 + scrollRangeX;
        int top = -maxOverScrollY2;
        int bottom = maxOverScrollY2 + scrollRangeY;
        if (newScrollX > right) {
            newScrollX = right;
            clampedX = true;
        } else if (newScrollX < left) {
            newScrollX = left;
            clampedX = true;
        } else {
            clampedX = false;
        }
        if (newScrollY2 > bottom) {
            newScrollY = bottom;
            clampedY = true;
        } else if (newScrollY2 < top) {
            newScrollY = top;
            clampedY = true;
        } else {
            newScrollY = newScrollY2;
            clampedY = false;
        }
        if (clampedY && !mo5813d(1)) {
            this.f1917e.springBack(newScrollX, newScrollY, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(newScrollX, newScrollY, clampedX, clampedY);
        return clampedX || clampedY;
    }

    /* access modifiers changed from: 0000 */
    public int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    /* renamed from: a */
    private View m3167a(boolean topFocus, int top, int bottom) {
        List<View> focusables = getFocusables(2);
        View focusCandidate = null;
        boolean foundFullyContainedFocusable = false;
        int count = focusables.size();
        for (int i = 0; i < count; i++) {
            View view = (View) focusables.get(i);
            int viewTop = view.getTop();
            int viewBottom = view.getBottom();
            if (top < viewBottom && viewTop < bottom) {
                boolean viewIsCloserToBoundary = false;
                boolean viewIsFullyContained = top < viewTop && viewBottom < bottom;
                if (focusCandidate == null) {
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } else {
                    if ((topFocus && viewTop < focusCandidate.getTop()) || (!topFocus && viewBottom > focusCandidate.getBottom())) {
                        viewIsCloserToBoundary = true;
                    }
                    if (foundFullyContainedFocusable) {
                        if (viewIsFullyContained && viewIsCloserToBoundary) {
                            focusCandidate = view;
                        }
                    } else if (viewIsFullyContained) {
                        focusCandidate = view;
                        foundFullyContainedFocusable = true;
                    } else if (viewIsCloserToBoundary) {
                        focusCandidate = view;
                    }
                }
            }
        }
        return focusCandidate;
    }

    /* renamed from: e */
    public boolean mo5820e(int direction) {
        boolean down = direction == 130;
        int height = getHeight();
        if (down) {
            this.f1916d.top = getScrollY() + height;
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(count - 1);
                if (this.f1916d.top + height > view.getBottom()) {
                    this.f1916d.top = view.getBottom() - height;
                }
            }
        } else {
            this.f1916d.top = getScrollY() - height;
            Rect rect = this.f1916d;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.f1916d;
        int i = rect2.top;
        rect2.bottom = i + height;
        return m3176b(direction, i, rect2.bottom);
    }

    /* renamed from: c */
    public boolean mo5804c(int direction) {
        boolean down = direction == 130;
        int height = getHeight();
        Rect rect = this.f1916d;
        rect.top = 0;
        rect.bottom = height;
        if (down) {
            int count = getChildCount();
            if (count > 0) {
                this.f1916d.bottom = getChildAt(count - 1).getBottom() + getPaddingBottom();
                Rect rect2 = this.f1916d;
                rect2.top = rect2.bottom - height;
            }
        }
        Rect rect3 = this.f1916d;
        return m3176b(direction, rect3.top, rect3.bottom);
    }

    /* renamed from: b */
    private boolean m3176b(int direction, int top, int bottom) {
        boolean handled = true;
        int height = getHeight();
        int containerTop = getScrollY();
        int containerBottom = containerTop + height;
        boolean up = direction == 33;
        View newFocused = m3167a(up, top, bottom);
        if (newFocused == null) {
            newFocused = this;
        }
        if (top < containerTop || bottom > containerBottom) {
            m3183g(up ? top - containerTop : bottom - containerBottom);
        } else {
            handled = false;
        }
        if (newFocused != findFocus()) {
            newFocused.requestFocus(direction);
        }
        return handled;
    }

    /* renamed from: a */
    public boolean mo5793a(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        }
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        int maxJump = getMaxScrollAmount();
        if (nextFocused == null || !m3172a(nextFocused, maxJump, getHeight())) {
            int scrollDelta = maxJump;
            if (direction == 33 && getScrollY() < scrollDelta) {
                scrollDelta = getScrollY();
            } else if (direction == 130 && getChildCount() > 0) {
                int daBottom = getChildAt(0).getBottom();
                int screenBottom = (getScrollY() + getHeight()) - getPaddingBottom();
                if (daBottom - screenBottom < maxJump) {
                    scrollDelta = daBottom - screenBottom;
                }
            }
            if (scrollDelta == 0) {
                return false;
            }
            m3183g(direction == 130 ? scrollDelta : -scrollDelta);
        } else {
            nextFocused.getDrawingRect(this.f1916d);
            offsetDescendantRectToMyCoords(nextFocused, this.f1916d);
            m3183g(mo5791a(this.f1916d));
            nextFocused.requestFocus(direction);
        }
        if (currentFocused != null && currentFocused.isFocused() && m3171a(currentFocused)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(Opcodes.ACC_DEPRECATED);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m3171a(View descendant) {
        return !m3172a(descendant, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m3172a(View descendant, int delta, int height) {
        descendant.getDrawingRect(this.f1916d);
        offsetDescendantRectToMyCoords(descendant, this.f1916d);
        return this.f1916d.bottom + delta >= getScrollY() && this.f1916d.top - delta <= getScrollY() + height;
    }

    /* renamed from: g */
    private void m3183g(int delta) {
        if (delta == 0) {
            return;
        }
        if (this.f1927o) {
            mo5792a(0, delta);
        } else {
            scrollBy(0, delta);
        }
    }

    /* renamed from: a */
    public final void mo5792a(int dx, int dy) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1915c > 250) {
                int maxY = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1917e.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY);
                C0646w.m2990x(this);
            } else {
                if (!this.f1917e.isFinished()) {
                    this.f1917e.abortAnimation();
                }
                scrollBy(dx, dy);
            }
            this.f1915c = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: b */
    public final void mo5803b(int x, int y) {
        mo5792a(x - getScrollX(), y - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int contentHeight = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return contentHeight;
        }
        int scrollRange = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int overscrollBottom = Math.max(0, scrollRange - contentHeight);
        if (scrollY < 0) {
            scrollRange -= scrollY;
        } else if (scrollY > overscrollBottom) {
            scrollRange += scrollY - overscrollBottom;
        }
        return scrollRange;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        child.measure(FrameLayout.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight(), child.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        child.measure(FrameLayout.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width), MeasureSpec.makeMeasureSpec(lp.topMargin + lp.bottomMargin, 0));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0074, code lost:
        if (r1 > 0) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeScroll() {
        /*
            r20 = this;
            r10 = r20
            android.widget.OverScroller r0 = r10.f1917e
            boolean r0 = r0.computeScrollOffset()
            r12 = 1
            if (r0 == 0) goto L_0x00b1
            android.widget.OverScroller r0 = r10.f1917e
            int r13 = r0.getCurrX()
            android.widget.OverScroller r0 = r10.f1917e
            int r14 = r0.getCurrY()
            int r0 = r10.f1935w
            int r6 = r14 - r0
            r1 = 0
            int[] r3 = r10.f1933u
            r4 = 0
            r5 = 1
            r0 = r20
            r2 = r6
            boolean r0 = r0.mo5796a(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0030
            int[] r0 = r10.f1933u
            r0 = r0[r12]
            int r6 = r6 - r0
            r15 = r6
            goto L_0x0031
        L_0x0030:
            r15 = r6
        L_0x0031:
            if (r15 == 0) goto L_0x00ab
            int r9 = r20.getScrollRange()
            int r8 = r20.getScrollY()
            r1 = 0
            int r3 = r20.getScrollX()
            r5 = 0
            r7 = 0
            r16 = 0
            r17 = 0
            r0 = r20
            r2 = r15
            r4 = r8
            r6 = r9
            r11 = r8
            r8 = r16
            r19 = r9
            r9 = r17
            r0.mo5794a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            int r0 = r20.getScrollY()
            int r7 = r0 - r11
            int r8 = r15 - r7
            r3 = 0
            r5 = 0
            r6 = 1
            r0 = r20
            r2 = r7
            r4 = r8
            boolean r0 = r0.mo5795a(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x00a9
            int r0 = r20.getOverScrollMode()
            if (r0 == 0) goto L_0x007c
            if (r0 != r12) goto L_0x0077
            r1 = r19
            if (r1 <= 0) goto L_0x0079
            goto L_0x007e
        L_0x0077:
            r1 = r19
        L_0x0079:
            r18 = 0
            goto L_0x0080
        L_0x007c:
            r1 = r19
        L_0x007e:
            r18 = 1
        L_0x0080:
            r2 = r18
            if (r2 == 0) goto L_0x00ab
            r20.m3177c()
            if (r14 > 0) goto L_0x0098
            if (r11 <= 0) goto L_0x0098
            android.widget.EdgeEffect r3 = r10.f1918f
            android.widget.OverScroller r4 = r10.f1917e
            float r4 = r4.getCurrVelocity()
            int r4 = (int) r4
            r3.onAbsorb(r4)
            goto L_0x00ab
        L_0x0098:
            if (r14 < r1) goto L_0x00ab
            if (r11 >= r1) goto L_0x00ab
            android.widget.EdgeEffect r3 = r10.f1919g
            android.widget.OverScroller r4 = r10.f1917e
            float r4 = r4.getCurrVelocity()
            int r4 = (int) r4
            r3.onAbsorb(r4)
            goto L_0x00ab
        L_0x00a9:
            r1 = r19
        L_0x00ab:
            r10.f1935w = r14
            android.support.p000v4.view.C0646w.m2990x(r20)
            goto L_0x00bd
        L_0x00b1:
            boolean r0 = r10.mo5813d(r12)
            if (r0 == 0) goto L_0x00ba
            r10.mo5821f(r12)
        L_0x00ba:
            r0 = 0
            r10.f1935w = r0
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.NestedScrollView.computeScroll():void");
    }

    /* renamed from: b */
    private void m3175b(View child) {
        child.getDrawingRect(this.f1916d);
        offsetDescendantRectToMyCoords(child, this.f1916d);
        int scrollDelta = mo5791a(this.f1916d);
        if (scrollDelta != 0) {
            scrollBy(0, scrollDelta);
        }
    }

    /* renamed from: a */
    private boolean m3170a(Rect rect, boolean immediate) {
        int delta = mo5791a(rect);
        boolean scroll = delta != 0;
        if (scroll) {
            if (immediate) {
                scrollBy(0, delta);
            } else {
                mo5792a(0, delta);
            }
        }
        return scroll;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo5791a(Rect rect) {
        int scrollYDelta;
        int scrollYDelta2;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int screenTop = getScrollY();
        int screenBottom = screenTop + height;
        int fadingEdge = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            screenTop += fadingEdge;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            screenBottom -= fadingEdge;
        }
        int scrollYDelta3 = 0;
        if (rect.bottom > screenBottom && rect.top > screenTop) {
            if (rect.height() > height) {
                scrollYDelta2 = 0 + (rect.top - screenTop);
            } else {
                scrollYDelta2 = 0 + (rect.bottom - screenBottom);
            }
            scrollYDelta3 = Math.min(scrollYDelta2, getChildAt(0).getBottom() - screenBottom);
        } else if (rect.top < screenTop && rect.bottom < screenBottom) {
            if (rect.height() > height) {
                scrollYDelta = 0 - (screenBottom - rect.bottom);
            } else {
                scrollYDelta = 0 - (screenTop - rect.top);
            }
            scrollYDelta3 = Math.max(scrollYDelta, -getScrollY());
        }
        return scrollYDelta3;
    }

    public void requestChildFocus(View child, View focused) {
        if (!this.f1921i) {
            m3175b(focused);
        } else {
            this.f1923k = focused;
        }
        super.requestChildFocus(child, focused);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        View nextFocus;
        if (direction == 2) {
            direction = Opcodes.IXOR;
        } else if (direction == 1) {
            direction = 33;
        }
        if (previouslyFocusedRect == null) {
            nextFocus = FocusFinder.getInstance().findNextFocus(this, null, direction);
        } else {
            nextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, previouslyFocusedRect, direction);
        }
        if (nextFocus != null && !m3171a(nextFocus)) {
            return nextFocus.requestFocus(direction, previouslyFocusedRect);
        }
        return false;
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
        return m3170a(rectangle, immediate);
    }

    public void requestLayout() {
        this.f1921i = true;
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.f1921i = false;
        View view = this.f1923k;
        if (view != null && m3173a(view, (View) this)) {
            m3175b(this.f1923k);
        }
        this.f1923k = null;
        if (!this.f1922j) {
            if (this.f1936x != null) {
                scrollTo(getScrollX(), this.f1936x.f1939a);
                this.f1936x = null;
            }
            int scrollRange = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((b - t) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > scrollRange) {
                scrollTo(getScrollX(), scrollRange);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1922j = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1922j = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        View currentFocused = findFocus();
        if (!(currentFocused == null || this == currentFocused || !m3172a(currentFocused, 0, oldh))) {
            currentFocused.getDrawingRect(this.f1916d);
            offsetDescendantRectToMyCoords(currentFocused, this.f1916d);
            m3183g(mo5791a(this.f1916d));
        }
    }

    /* renamed from: a */
    private static boolean m3173a(View child, View parent) {
        boolean z = true;
        if (child == parent) {
            return true;
        }
        ViewParent theParent = child.getParent();
        if (!(theParent instanceof ViewGroup) || !m3173a((View) theParent, parent)) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public void mo5802b(int velocityY) {
        if (getChildCount() > 0) {
            mo5805c(2, 1);
            this.f1917e.fling(getScrollX(), getScrollY(), 0, velocityY, 0, 0, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT, 0, 0);
            this.f1935w = getScrollY();
            C0646w.m2990x(this);
        }
    }

    /* renamed from: h */
    private void m3184h(int velocityY) {
        int scrollY = getScrollY();
        boolean canFling = (scrollY > 0 || velocityY > 0) && (scrollY < getScrollRange() || velocityY < 0);
        if (!dispatchNestedPreFling(0.0f, (float) velocityY)) {
            dispatchNestedFling(0.0f, (float) velocityY, canFling);
            mo5802b(velocityY);
        }
    }

    /* renamed from: b */
    private void m3174b() {
        this.f1924l = false;
        m3182g();
        mo5821f(0);
        EdgeEffect edgeEffect = this.f1918f;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1919g.onRelease();
        }
    }

    public void scrollTo(int x, int y) {
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            int x2 = m3166a(x, (getWidth() - getPaddingRight()) - getPaddingLeft(), child.getWidth());
            int y2 = m3166a(y, (getHeight() - getPaddingBottom()) - getPaddingTop(), child.getHeight());
            if (x2 != getScrollX() || y2 != getScrollY()) {
                super.scrollTo(x2, y2);
            }
        }
    }

    /* renamed from: c */
    private void m3177c() {
        if (getOverScrollMode() == 2) {
            this.f1918f = null;
            this.f1919g = null;
        } else if (this.f1918f == null) {
            Context context = getContext();
            this.f1918f = new EdgeEffect(context);
            this.f1919g = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1918f != null) {
            int scrollY = getScrollY();
            if (!this.f1918f.isFinished()) {
                int restoreCount = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int xTranslation = 0;
                int yTranslation = Math.min(0, scrollY);
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    xTranslation = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    yTranslation += getPaddingTop();
                }
                canvas.translate((float) xTranslation, (float) yTranslation);
                this.f1918f.setSize(width, height);
                if (this.f1918f.draw(canvas)) {
                    C0646w.m2990x(this);
                }
                canvas.restoreToCount(restoreCount);
            }
            if (!this.f1919g.isFinished()) {
                int restoreCount2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int xTranslation2 = 0;
                int yTranslation2 = Math.max(getScrollRange(), scrollY) + height2;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    xTranslation2 = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    yTranslation2 -= getPaddingBottom();
                }
                canvas.translate((float) (xTranslation2 - width2), (float) yTranslation2);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.f1919g.setSize(width2, height2);
                if (this.f1919g.draw(canvas)) {
                    C0646w.m2990x(this);
                }
                canvas.restoreToCount(restoreCount2);
            }
        }
    }

    /* renamed from: a */
    private static int m3166a(int n, int my, int child) {
        if (my >= child || n < 0) {
            return 0;
        }
        if (my + n > child) {
            return child - my;
        }
        return n;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.f1936x = ss;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f1939a = getScrollY();
        return ss;
    }
}
