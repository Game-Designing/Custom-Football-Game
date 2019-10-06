package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.C0004c;
import android.support.design.widget.CoordinatorLayout.C0237b;
import android.support.design.widget.CoordinatorLayout.C0239e;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0592M;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p050d.C1168b;
import p002b.p003c.p050d.C1176j;
import p002b.p003c.p050d.C1177k;
import p002b.p003c.p053g.p058c.C1226a;
import p002b.p003c.p053g.p061f.C1267k;

@C0004c(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    private int f814a;

    /* renamed from: b */
    private int f815b;

    /* renamed from: c */
    private int f816c;

    /* renamed from: d */
    private boolean f817d;

    /* renamed from: e */
    private int f818e;

    /* renamed from: f */
    private C0592M f819f;

    /* renamed from: g */
    private List<C0227b> f820g;

    /* renamed from: h */
    private boolean f821h;

    /* renamed from: i */
    private boolean f822i;

    /* renamed from: j */
    private int[] f823j;

    public static class Behavior extends C0259M<AppBarLayout> {
        /* access modifiers changed from: private */

        /* renamed from: k */
        public int f824k;

        /* renamed from: l */
        private ValueAnimator f825l;

        /* renamed from: m */
        private int f826m = -1;

        /* renamed from: n */
        private boolean f827n;

        /* renamed from: o */
        private float f828o;

        /* renamed from: p */
        private WeakReference<View> f829p;

        /* renamed from: q */
        private C0225a f830q;

        protected static class SavedState extends AbsSavedState {
            public static final Creator<SavedState> CREATOR = new C0286d();

            /* renamed from: c */
            int f831c;

            /* renamed from: d */
            float f832d;

            /* renamed from: e */
            boolean f833e;

            public SavedState(Parcel source, ClassLoader loader) {
                super(source, loader);
                this.f831c = source.readInt();
                this.f832d = source.readFloat();
                this.f833e = source.readByte() != 0;
            }

            public SavedState(Parcelable superState) {
                super(superState);
            }

            public void writeToParcel(Parcel dest, int flags) {
                super.writeToParcel(dest, flags);
                dest.writeInt(this.f831c);
                dest.writeFloat(this.f832d);
                dest.writeByte(this.f833e ? (byte) 1 : 0);
            }
        }

        /* renamed from: android.support.design.widget.AppBarLayout$Behavior$a */
        public static abstract class C0225a {
            /* renamed from: a */
            public abstract boolean mo4241a(AppBarLayout appBarLayout);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo4221a(int i) {
            return super.mo4221a(i);
        }

        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo4229b() {
            return super.mo4229b();
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* renamed from: a */
        public boolean mo4234b(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes, int type) {
            boolean started = (nestedScrollAxes & 2) != 0 && child.mo4191b() && parent.getHeight() - directTargetChild.getHeight() <= child.getHeight();
            if (started) {
                ValueAnimator valueAnimator = this.f825l;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
            }
            this.f829p = null;
            return started;
        }

        /* renamed from: a */
        public void mo4220a(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed, int type) {
            int max;
            int min;
            if (dy != 0) {
                if (dy < 0) {
                    int min2 = -child.getTotalScrollRange();
                    min = min2;
                    max = child.getDownNestedPreScrollRange() + min2;
                } else {
                    min = -child.getUpNestedPreScrollRange();
                    max = 0;
                }
                if (min != max) {
                    consumed[1] = mo4531a(coordinatorLayout, child, dy, min, max);
                }
            }
        }

        /* renamed from: a */
        public void mo4219a(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
            if (dyUnconsumed < 0) {
                mo4531a(coordinatorLayout, child, dyUnconsumed, -child.getDownNestedScrollRange(), 0);
            }
        }

        /* renamed from: a */
        public void mo4218a(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target, int type) {
            if (type == 0) {
                m1319d(coordinatorLayout, abl);
            }
            this.f829p = new WeakReference<>(target);
        }

        /* renamed from: a */
        private void m1312a(CoordinatorLayout coordinatorLayout, AppBarLayout child, int offset, float velocity) {
            int duration;
            int distance = Math.abs(mo4235c() - offset);
            float velocity2 = Math.abs(velocity);
            if (velocity2 > 0.0f) {
                duration = Math.round((((float) distance) / velocity2) * 1000.0f) * 3;
            } else {
                duration = (int) ((1.0f + (((float) distance) / ((float) child.getHeight()))) * 150.0f);
            }
            m1313a(coordinatorLayout, child, offset, duration);
        }

        /* renamed from: a */
        private void m1313a(CoordinatorLayout coordinatorLayout, AppBarLayout child, int offset, int duration) {
            int currentOffset = mo4235c();
            if (currentOffset == offset) {
                ValueAnimator valueAnimator = this.f825l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f825l.cancel();
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f825l;
            if (valueAnimator2 == null) {
                this.f825l = new ValueAnimator();
                this.f825l.setInterpolator(C0280a.f1078e);
                this.f825l.addUpdateListener(new C0284c(this, coordinatorLayout, child));
            } else {
                valueAnimator2.cancel();
            }
            this.f825l.setDuration((long) Math.min(duration, 600));
            this.f825l.setIntValues(new int[]{currentOffset, offset});
            this.f825l.start();
        }

        /* renamed from: b */
        private int m1316b(AppBarLayout abl, int offset) {
            int count = abl.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = abl.getChildAt(i);
                if (child.getTop() <= (-offset) && child.getBottom() >= (-offset)) {
                    return i;
                }
            }
            return -1;
        }

        /* renamed from: d */
        private void m1319d(CoordinatorLayout coordinatorLayout, AppBarLayout abl) {
            int offset = mo4235c();
            int offsetChildIndex = m1316b(abl, offset);
            if (offsetChildIndex >= 0) {
                View offsetChild = abl.getChildAt(offsetChildIndex);
                int flags = ((C0226a) offsetChild.getLayoutParams()).mo4248a();
                if ((flags & 17) == 17) {
                    int snapTop = -offsetChild.getTop();
                    int snapBottom = -offsetChild.getBottom();
                    if (offsetChildIndex == abl.getChildCount() - 1) {
                        snapBottom += abl.getTopInset();
                    }
                    if (m1315a(flags, 2)) {
                        snapBottom += C0646w.m2975i(offsetChild);
                    } else if (m1315a(flags, 5)) {
                        int seam = C0646w.m2975i(offsetChild) + snapBottom;
                        if (offset < seam) {
                            snapTop = seam;
                        } else {
                            snapBottom = seam;
                        }
                    }
                    m1312a(coordinatorLayout, abl, C1226a.m5823a(offset < (snapBottom + snapTop) / 2 ? snapBottom : snapTop, -abl.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* renamed from: a */
        private static boolean m1315a(int flags, int check) {
            return (flags & check) == check;
        }

        /* renamed from: a */
        public boolean mo4227a(CoordinatorLayout parent, AppBarLayout child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            if (((C0239e) child.getLayoutParams()).height != -2) {
                return super.mo4227a(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
            }
            parent.mo4360a((View) child, parentWidthMeasureSpec, widthUsed, MeasureSpec.makeMeasureSpec(0, 0), heightUsed);
            return true;
        }

        /* renamed from: a */
        public boolean mo4226a(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
            int offset;
            boolean handled = super.mo4226a(parent, abl, layoutDirection);
            int pendingAction = abl.getPendingAction();
            int i = this.f826m;
            if (i >= 0 && (pendingAction & 8) == 0) {
                View child = abl.getChildAt(i);
                int offset2 = -child.getBottom();
                if (this.f827n) {
                    offset = offset2 + C0646w.m2975i(child) + abl.getTopInset();
                } else {
                    offset = offset2 + Math.round(((float) child.getHeight()) * this.f828o);
                }
                mo4533c(parent, abl, offset);
            } else if (pendingAction != 0) {
                boolean animate = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int offset3 = -abl.getUpNestedPreScrollRange();
                    if (animate) {
                        m1312a(parent, abl, offset3, 0.0f);
                    } else {
                        mo4533c(parent, abl, offset3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (animate) {
                        m1312a(parent, abl, 0, 0.0f);
                    } else {
                        mo4533c(parent, abl, 0);
                    }
                }
            }
            abl.mo4192c();
            this.f826m = -1;
            mo4221a(C1226a.m5823a(mo4229b(), -abl.getTotalScrollRange(), 0));
            m1314a(parent, abl, mo4229b(), 0, true);
            abl.mo4185a(mo4229b());
            return handled;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo4228a(AppBarLayout view) {
            C0225a aVar = this.f830q;
            if (aVar != null) {
                return aVar.mo4241a(view);
            }
            WeakReference<View> weakReference = this.f829p;
            boolean z = true;
            if (weakReference == null) {
                return true;
            }
            View scrollingView = (View) weakReference.get();
            if (scrollingView == null || !scrollingView.isShown() || scrollingView.canScrollVertically(-1)) {
                z = false;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo4239e(CoordinatorLayout parent, AppBarLayout layout) {
            m1319d(parent, layout);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo4232b(AppBarLayout view) {
            return -view.getDownNestedScrollRange();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public int mo4237c(AppBarLayout view) {
            return view.getTotalScrollRange();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo4231b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int newOffset, int minOffset, int maxOffset) {
            int curOffset = mo4235c();
            int consumed = 0;
            if (minOffset == 0 || curOffset < minOffset || curOffset > maxOffset) {
                this.f824k = 0;
            } else {
                int newOffset2 = C1226a.m5823a(newOffset, minOffset, maxOffset);
                if (curOffset != newOffset2) {
                    int interpolatedOffset = appBarLayout.mo4188a() ? m1317c(appBarLayout, newOffset2) : newOffset2;
                    boolean offsetChanged = mo4221a(interpolatedOffset);
                    consumed = curOffset - newOffset2;
                    this.f824k = newOffset2 - interpolatedOffset;
                    if (!offsetChanged && appBarLayout.mo4188a()) {
                        coordinatorLayout.mo4358a((View) appBarLayout);
                    }
                    appBarLayout.mo4185a(mo4229b());
                    m1314a(coordinatorLayout, appBarLayout, newOffset2, newOffset2 < curOffset ? -1 : 1, false);
                }
            }
            return consumed;
        }

        /* renamed from: c */
        private int m1317c(AppBarLayout layout, int offset) {
            int absOffset = Math.abs(offset);
            int i = 0;
            int z = layout.getChildCount();
            while (true) {
                if (i >= z) {
                    break;
                }
                View child = layout.getChildAt(i);
                C0226a childLp = (C0226a) child.getLayoutParams();
                Interpolator interpolator = childLp.mo4249b();
                if (absOffset < child.getTop() || absOffset > child.getBottom()) {
                    i++;
                } else if (interpolator != null) {
                    int childScrollableHeight = 0;
                    int flags = childLp.mo4248a();
                    if ((flags & 1) != 0) {
                        childScrollableHeight = 0 + child.getHeight() + childLp.topMargin + childLp.bottomMargin;
                        if ((flags & 2) != 0) {
                            childScrollableHeight -= C0646w.m2975i(child);
                        }
                    }
                    if (C0646w.m2972f(child)) {
                        childScrollableHeight -= layout.getTopInset();
                    }
                    if (childScrollableHeight > 0) {
                        return Integer.signum(offset) * (child.getTop() + Math.round(((float) childScrollableHeight) * interpolator.getInterpolation(((float) (absOffset - child.getTop())) / ((float) childScrollableHeight))));
                    }
                }
            }
            return offset;
        }

        /* renamed from: a */
        private void m1314a(CoordinatorLayout parent, AppBarLayout layout, int offset, int direction, boolean forceJump) {
            View child = m1311a(layout, offset);
            if (child != null) {
                int flags = ((C0226a) child.getLayoutParams()).mo4248a();
                boolean collapsed = false;
                if ((flags & 1) != 0) {
                    int minHeight = C0646w.m2975i(child);
                    boolean z = false;
                    if (direction > 0 && (flags & 12) != 0) {
                        if ((-offset) >= (child.getBottom() - minHeight) - layout.getTopInset()) {
                            z = true;
                        }
                        collapsed = z;
                    } else if ((flags & 2) != 0) {
                        if ((-offset) >= (child.getBottom() - minHeight) - layout.getTopInset()) {
                            z = true;
                        }
                        collapsed = z;
                    }
                }
                boolean changed = layout.mo4189a(collapsed);
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if (forceJump || (changed && m1318c(parent, layout))) {
                    layout.jumpDrawablesToCurrentState();
                }
            }
        }

        /* renamed from: c */
        private boolean m1318c(CoordinatorLayout parent, AppBarLayout layout) {
            List<View> dependencies = parent.mo4373c((View) layout);
            int i = 0;
            int size = dependencies.size();
            while (true) {
                boolean z = false;
                if (i >= size) {
                    return false;
                }
                C0237b behavior = ((C0239e) ((View) dependencies.get(i)).getLayoutParams()).mo4442d();
                if (behavior instanceof ScrollingViewBehavior) {
                    if (((ScrollingViewBehavior) behavior).mo4538c() != 0) {
                        z = true;
                    }
                    return z;
                }
                i++;
            }
        }

        /* renamed from: a */
        private static View m1311a(AppBarLayout layout, int offset) {
            int absOffset = Math.abs(offset);
            int z = layout.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = layout.getChildAt(i);
                if (absOffset >= child.getTop() && absOffset <= child.getBottom()) {
                    return child;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public int mo4235c() {
            return mo4229b() + this.f824k;
        }

        /* renamed from: b */
        public Parcelable mo4238d(CoordinatorLayout parent, AppBarLayout abl) {
            Parcelable superState = super.mo4238d(parent, abl);
            int offset = mo4229b();
            int i = 0;
            int count = abl.getChildCount();
            while (i < count) {
                View child = abl.getChildAt(i);
                int visBottom = child.getBottom() + offset;
                if (child.getTop() + offset > 0 || visBottom < 0) {
                    i++;
                } else {
                    SavedState ss = new SavedState(superState);
                    ss.f831c = i;
                    ss.f833e = visBottom == C0646w.m2975i(child) + abl.getTopInset();
                    ss.f832d = ((float) visBottom) / ((float) child.getHeight());
                    return ss;
                }
            }
            return superState;
        }

        /* renamed from: a */
        public void mo4217a(CoordinatorLayout parent, AppBarLayout appBarLayout, Parcelable state) {
            if (state instanceof SavedState) {
                SavedState ss = (SavedState) state;
                super.mo4217a(parent, appBarLayout, ss.mo5452a());
                this.f826m = ss.f831c;
                this.f828o = ss.f832d;
                this.f827n = ss.f833e;
                return;
            }
            super.mo4217a(parent, appBarLayout, state);
            this.f826m = -1;
        }
    }

    public static class ScrollingViewBehavior extends C0261N {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo4226a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo4226a(coordinatorLayout, view, i);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo4227a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo4227a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, C1177k.ScrollingViewBehavior_Layout);
            mo4536b(a.getDimensionPixelSize(C1177k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            a.recycle();
        }

        /* renamed from: a */
        public boolean mo4244a(CoordinatorLayout parent, View child, View dependency) {
            return dependency instanceof AppBarLayout;
        }

        /* renamed from: b */
        public boolean mo4246b(CoordinatorLayout parent, View child, View dependency) {
            m1351e(parent, child, dependency);
            return false;
        }

        /* renamed from: a */
        public boolean mo4243a(CoordinatorLayout parent, View child, Rect rectangle, boolean immediate) {
            AppBarLayout header = m1353a(parent.mo4368b(child));
            if (header != null) {
                rectangle.offset(child.getLeft(), child.getTop());
                Rect parentRect = this.f1013d;
                parentRect.set(0, 0, parent.getWidth(), parent.getHeight());
                if (!parentRect.contains(rectangle)) {
                    header.mo4187a(false, !immediate);
                    return true;
                }
            }
            return false;
        }

        /* renamed from: e */
        private void m1351e(CoordinatorLayout parent, View child, View dependency) {
            C0237b behavior = ((C0239e) dependency.getLayoutParams()).mo4442d();
            if (behavior instanceof Behavior) {
                C0646w.m2965b(child, (((dependency.getBottom() - child.getTop()) + ((Behavior) behavior).f824k) + mo4539d()) - mo4535a(dependency));
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public float mo4245b(View header) {
            if (header instanceof AppBarLayout) {
                AppBarLayout abl = (AppBarLayout) header;
                int totalScrollRange = abl.getTotalScrollRange();
                int preScrollDown = abl.getDownNestedPreScrollRange();
                int offset = m1350a(abl);
                if (preScrollDown != 0 && totalScrollRange + offset <= preScrollDown) {
                    return 0.0f;
                }
                int availScrollRange = totalScrollRange - preScrollDown;
                if (availScrollRange != 0) {
                    return (((float) offset) / ((float) availScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* renamed from: a */
        private static int m1350a(AppBarLayout abl) {
            C0237b behavior = ((C0239e) abl.getLayoutParams()).mo4442d();
            if (behavior instanceof Behavior) {
                return ((Behavior) behavior).mo4235c();
            }
            return 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public AppBarLayout m1353a(List<View> views) {
            int z = views.size();
            for (int i = 0; i < z; i++) {
                View view = (View) views.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public int mo4247c(View v) {
            if (v instanceof AppBarLayout) {
                return ((AppBarLayout) v).getTotalScrollRange();
            }
            return super.mo4247c(v);
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$a */
    public static class C0226a extends LayoutParams {

        /* renamed from: a */
        int f834a = 1;

        /* renamed from: b */
        Interpolator f835b;

        public C0226a(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, C1177k.AppBarLayout_Layout);
            this.f834a = a.getInt(C1177k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (a.hasValue(C1177k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f835b = AnimationUtils.loadInterpolator(c, a.getResourceId(C1177k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            a.recycle();
        }

        public C0226a(int width, int height) {
            super(width, height);
        }

        public C0226a(ViewGroup.LayoutParams p) {
            super(p);
        }

        public C0226a(MarginLayoutParams source) {
            super(source);
        }

        public C0226a(LayoutParams source) {
            super(source);
        }

        /* renamed from: a */
        public int mo4248a() {
            return this.f834a;
        }

        /* renamed from: b */
        public Interpolator mo4249b() {
            return this.f835b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public boolean mo4250c() {
            int i = this.f834a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$b */
    public interface C0227b {
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f814a = -1;
        this.f815b = -1;
        this.f816c = -1;
        this.f818e = 0;
        setOrientation(1);
        C0289ea.m1678a(context);
        if (VERSION.SDK_INT >= 21) {
            C0297ia.m1691a(this);
            C0297ia.m1693a(this, attrs, 0, C1176j.Widget_Design_AppBarLayout);
        }
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.AppBarLayout, 0, C1176j.Widget_Design_AppBarLayout);
        C0646w.m2954a((View) this, a.getDrawable(C1177k.AppBarLayout_android_background));
        if (a.hasValue(C1177k.AppBarLayout_expanded)) {
            m1297a(a.getBoolean(C1177k.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && a.hasValue(C1177k.AppBarLayout_elevation)) {
            C0297ia.m1692a(this, (float) a.getDimensionPixelSize(C1177k.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (a.hasValue(C1177k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a.getBoolean(C1177k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a.hasValue(C1177k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a.getBoolean(C1177k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        a.recycle();
        C0646w.m2956a((View) this, (C0641r) new C0282b(this));
    }

    /* renamed from: a */
    public void mo4186a(C0227b listener) {
        if (this.f820g == null) {
            this.f820g = new ArrayList();
        }
        if (listener != null && !this.f820g.contains(listener)) {
            this.f820g.add(listener);
        }
    }

    /* renamed from: b */
    public void mo4190b(C0227b listener) {
        List<C0227b> list = this.f820g;
        if (list != null && listener != null) {
            list.remove(listener);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        m1299d();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        m1299d();
        this.f817d = false;
        int i = 0;
        int z = getChildCount();
        while (true) {
            if (i >= z) {
                break;
            } else if (((C0226a) getChildAt(i).getLayoutParams()).mo4249b() != null) {
                this.f817d = true;
                break;
            } else {
                i++;
            }
        }
        m1300e();
    }

    /* renamed from: e */
    private void m1300e() {
        boolean haveCollapsibleChild = false;
        int i = 0;
        int z = getChildCount();
        while (true) {
            if (i >= z) {
                break;
            } else if (((C0226a) getChildAt(i).getLayoutParams()).mo4250c()) {
                haveCollapsibleChild = true;
                break;
            } else {
                i++;
            }
        }
        m1298b(haveCollapsibleChild);
    }

    /* renamed from: d */
    private void m1299d() {
        this.f814a = -1;
        this.f815b = -1;
        this.f816c = -1;
    }

    public void setOrientation(int orientation) {
        if (orientation == 1) {
            super.setOrientation(orientation);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setExpanded(boolean expanded) {
        mo4187a(expanded, C0646w.m2987u(this));
    }

    /* renamed from: a */
    public void mo4187a(boolean expanded, boolean animate) {
        m1297a(expanded, animate, true);
    }

    /* renamed from: a */
    private void m1297a(boolean expanded, boolean animate, boolean force) {
        int i = 0;
        int i2 = (expanded ? 1 : 2) | (animate ? 4 : 0);
        if (force) {
            i = 8;
        }
        this.f818e = i2 | i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof C0226a;
    }

    /* access modifiers changed from: protected */
    public C0226a generateDefaultLayoutParams() {
        return new C0226a(-1, -2);
    }

    public C0226a generateLayoutParams(AttributeSet attrs) {
        return new C0226a(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C0226a generateLayoutParams(ViewGroup.LayoutParams p) {
        if (VERSION.SDK_INT >= 19 && (p instanceof LayoutParams)) {
            return new C0226a((LayoutParams) p);
        }
        if (p instanceof MarginLayoutParams) {
            return new C0226a((MarginLayoutParams) p);
        }
        return new C0226a(p);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4188a() {
        return this.f817d;
    }

    public final int getTotalScrollRange() {
        int i = this.f814a;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            C0226a lp = (C0226a) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight();
            int flags = lp.f834a;
            if ((flags & 1) == 0) {
                break;
            }
            range += lp.topMargin + childHeight + lp.bottomMargin;
            if ((flags & 2) != 0) {
                range -= C0646w.m2975i(child);
                break;
            }
            i2++;
        }
        int max = Math.max(0, range - getTopInset());
        this.f814a = max;
        return max;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo4191b() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: 0000 */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: 0000 */
    public int getDownNestedPreScrollRange() {
        int i = this.f815b;
        if (i != -1) {
            return i;
        }
        int range = 0;
        for (int i2 = getChildCount() - 1; i2 >= 0; i2--) {
            View child = getChildAt(i2);
            C0226a lp = (C0226a) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight();
            int flags = lp.f834a;
            if ((flags & 5) == 5) {
                int range2 = range + lp.topMargin + lp.bottomMargin;
                if ((flags & 8) != 0) {
                    range = range2 + C0646w.m2975i(child);
                } else if ((flags & 2) != 0) {
                    range = range2 + (childHeight - C0646w.m2975i(child));
                } else {
                    range = range2 + (childHeight - getTopInset());
                }
            } else if (range > 0) {
                break;
            }
        }
        int max = Math.max(0, range);
        this.f815b = max;
        return max;
    }

    /* access modifiers changed from: 0000 */
    public int getDownNestedScrollRange() {
        int i = this.f816c;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            C0226a lp = (C0226a) child.getLayoutParams();
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            int flags = lp.f834a;
            if ((flags & 1) == 0) {
                break;
            }
            range += childHeight;
            if ((flags & 2) != 0) {
                range -= C0646w.m2975i(child) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, range);
        this.f816c = max;
        return max;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4185a(int offset) {
        List<C0227b> list = this.f820g;
        if (list != null) {
            int z = list.size();
            for (int i = 0; i < z; i++) {
                C0227b listener = (C0227b) this.f820g.get(i);
                if (listener != null) {
                    listener.onOffsetChanged(this, offset);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minHeight = C0646w.m2975i(this);
        if (minHeight != 0) {
            return (minHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int lastChildMinHeight = childCount >= 1 ? C0646w.m2975i(getChildAt(childCount - 1)) : 0;
        if (lastChildMinHeight != 0) {
            return (lastChildMinHeight * 2) + topInset;
        }
        return getHeight() / 3;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        if (this.f823j == null) {
            this.f823j = new int[2];
        }
        int[] extraStates = this.f823j;
        int[] states = super.onCreateDrawableState(extraStates.length + extraSpace);
        extraStates[0] = this.f821h ? C1168b.state_collapsible : -C1168b.state_collapsible;
        extraStates[1] = (!this.f821h || !this.f822i) ? -C1168b.state_collapsed : C1168b.state_collapsed;
        return LinearLayout.mergeDrawableStates(states, extraStates);
    }

    /* renamed from: b */
    private boolean m1298b(boolean collapsible) {
        if (this.f821h == collapsible) {
            return false;
        }
        this.f821h = collapsible;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4189a(boolean collapsed) {
        if (this.f822i == collapsed) {
            return false;
        }
        this.f822i = collapsed;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float elevation) {
        if (VERSION.SDK_INT >= 21) {
            C0297ia.m1692a(this, elevation);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: 0000 */
    public int getPendingAction() {
        return this.f818e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo4192c() {
        this.f818e = 0;
    }

    /* access modifiers changed from: 0000 */
    public final int getTopInset() {
        C0592M m = this.f819f;
        if (m != null) {
            return m.mo5489e();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0592M mo4184a(C0592M insets) {
        C0592M newInsets = null;
        if (C0646w.m2972f(this)) {
            newInsets = insets;
        }
        if (!C1267k.m5950a(this.f819f, newInsets)) {
            this.f819f = newInsets;
            m1299d();
        }
        return insets;
    }
}
