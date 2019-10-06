package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.CoordinatorLayout.C0237b;
import android.support.design.widget.CoordinatorLayout.C0239e;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0677H;
import android.support.p000v4.widget.C0677H.C0678a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import p002b.p003c.p050d.C1170d;
import p002b.p003c.p050d.C1177k;

public class BottomSheetBehavior<V extends View> extends C0237b<V> {

    /* renamed from: a */
    private float f846a;

    /* renamed from: b */
    private int f847b;

    /* renamed from: c */
    private boolean f848c;

    /* renamed from: d */
    private int f849d;

    /* renamed from: e */
    int f850e;

    /* renamed from: f */
    int f851f;

    /* renamed from: g */
    boolean f852g;

    /* renamed from: h */
    private boolean f853h;

    /* renamed from: i */
    int f854i = 4;

    /* renamed from: j */
    C0677H f855j;

    /* renamed from: k */
    private boolean f856k;

    /* renamed from: l */
    private int f857l;

    /* renamed from: m */
    private boolean f858m;

    /* renamed from: n */
    int f859n;

    /* renamed from: o */
    WeakReference<V> f860o;

    /* renamed from: p */
    WeakReference<View> f861p;

    /* renamed from: q */
    private C0231a f862q;

    /* renamed from: r */
    private VelocityTracker f863r;

    /* renamed from: s */
    int f864s;

    /* renamed from: t */
    private int f865t;

    /* renamed from: u */
    boolean f866u;

    /* renamed from: v */
    private final C0678a f867v = new C0317v(this);

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C0318w();

        /* renamed from: c */
        final int f868c;

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.f868c = source.readInt();
        }

        public SavedState(Parcelable superState, int state) {
            super(superState);
            this.f868c = state;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f868c);
        }
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$a */
    public static abstract class C0231a {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    /* renamed from: android.support.design.widget.BottomSheetBehavior$b */
    private class C0232b implements Runnable {

        /* renamed from: a */
        private final View f869a;

        /* renamed from: b */
        private final int f870b;

        C0232b(View view, int targetState) {
            this.f869a = view;
            this.f870b = targetState;
        }

        public void run() {
            C0677H h = BottomSheetBehavior.this.f855j;
            if (h == null || !h.mo5779a(true)) {
                BottomSheetBehavior.this.mo4286d(this.f870b);
            } else {
                C0646w.m2958a(this.f869a, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C1177k.BottomSheetBehavior_Layout);
        TypedValue value = a.peekValue(C1177k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (value != null) {
            int i = value.data;
            if (i == -1) {
                mo4280b(i);
                mo4275a(a.getBoolean(C1177k.BottomSheetBehavior_Layout_behavior_hideable, false));
                mo4281b(a.getBoolean(C1177k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
                a.recycle();
                this.f846a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            }
        }
        mo4280b(a.getDimensionPixelSize(C1177k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        mo4275a(a.getBoolean(C1177k.BottomSheetBehavior_Layout_behavior_hideable, false));
        mo4281b(a.getBoolean(C1177k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        a.recycle();
        this.f846a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* renamed from: d */
    public Parcelable mo4238d(CoordinatorLayout parent, V child) {
        return new SavedState(super.mo4238d(parent, child), this.f854i);
    }

    /* renamed from: a */
    public void mo4217a(CoordinatorLayout parent, V child, Parcelable state) {
        SavedState ss = (SavedState) state;
        super.mo4217a(parent, child, ss.mo5452a());
        int i = ss.f868c;
        if (i == 1 || i == 2) {
            this.f854i = 4;
        } else {
            this.f854i = i;
        }
    }

    /* renamed from: a */
    public boolean mo4226a(CoordinatorLayout parent, V child, int layoutDirection) {
        int peekHeight;
        if (C0646w.m2972f(parent) && !C0646w.m2972f(child)) {
            C0646w.m2961a((View) child, true);
        }
        int savedTop = child.getTop();
        parent.mo4375c((View) child, layoutDirection);
        this.f859n = parent.getHeight();
        if (this.f848c) {
            if (this.f849d == 0) {
                this.f849d = parent.getResources().getDimensionPixelSize(C1170d.design_bottom_sheet_peek_height_min);
            }
            peekHeight = Math.max(this.f849d, this.f859n - ((parent.getWidth() * 9) / 16));
        } else {
            peekHeight = this.f847b;
        }
        this.f850e = Math.max(0, this.f859n - child.getHeight());
        this.f851f = Math.max(this.f859n - peekHeight, this.f850e);
        int i = this.f854i;
        if (i == 3) {
            C0646w.m2965b((View) child, this.f850e);
        } else if (!this.f852g || i != 5) {
            int i2 = this.f854i;
            if (i2 == 4) {
                C0646w.m2965b((View) child, this.f851f);
            } else if (i2 == 1 || i2 == 2) {
                C0646w.m2965b((View) child, savedTop - child.getTop());
            }
        } else {
            C0646w.m2965b((View) child, this.f859n);
        }
        if (this.f855j == null) {
            this.f855j = C0677H.m3120a((ViewGroup) parent, this.f867v);
        }
        this.f860o = new WeakReference<>(child);
        this.f861p = new WeakReference<>(mo4270a((View) child));
        return true;
    }

    /* renamed from: a */
    public boolean mo4276a(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean z = false;
        if (!child.isShown()) {
            this.f856k = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            m1375e();
        }
        if (this.f863r == null) {
            this.f863r = VelocityTracker.obtain();
        }
        this.f863r.addMovement(event);
        if (action == 0) {
            int initialX = (int) event.getX();
            this.f865t = (int) event.getY();
            WeakReference<View> weakReference = this.f861p;
            View scroll = weakReference != null ? (View) weakReference.get() : null;
            if (scroll != null && parent.mo4367a(scroll, initialX, this.f865t)) {
                this.f864s = event.getPointerId(event.getActionIndex());
                this.f866u = true;
            }
            this.f856k = this.f864s == -1 && !parent.mo4367a((View) child, initialX, this.f865t);
        } else if (action == 1 || action == 3) {
            this.f866u = false;
            this.f864s = -1;
            if (this.f856k) {
                this.f856k = false;
                return false;
            }
        }
        if (!this.f856k && this.f855j.mo5783b(event)) {
            return true;
        }
        View scroll2 = (View) this.f861p.get();
        if (action == 2 && scroll2 != null && !this.f856k && this.f854i != 1 && !parent.mo4367a(scroll2, (int) event.getX(), (int) event.getY()) && Math.abs(((float) this.f865t) - event.getY()) > ((float) this.f855j.mo5780b())) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo4282b(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.f854i == 1 && action == 0) {
            return true;
        }
        C0677H h = this.f855j;
        if (h != null) {
            h.mo5775a(event);
        }
        if (action == 0) {
            m1375e();
        }
        if (this.f863r == null) {
            this.f863r = VelocityTracker.obtain();
        }
        this.f863r.addMovement(event);
        if (action == 2 && !this.f856k && Math.abs(((float) this.f865t) - event.getY()) > ((float) this.f855j.mo5780b())) {
            this.f855j.mo5776a((View) child, event.getPointerId(event.getActionIndex()));
        }
        return !this.f856k;
    }

    /* renamed from: b */
    public boolean mo4283b(CoordinatorLayout coordinatorLayout, V v, View directTargetChild, View target, int nestedScrollAxes) {
        this.f857l = 0;
        this.f858m = false;
        if ((nestedScrollAxes & 2) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo4273a(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed) {
        if (target == ((View) this.f861p.get())) {
            int currentTop = child.getTop();
            int newTop = currentTop - dy;
            if (dy > 0) {
                int i = this.f850e;
                if (newTop < i) {
                    consumed[1] = currentTop - i;
                    C0646w.m2965b((View) child, -consumed[1]);
                    mo4286d(3);
                } else {
                    consumed[1] = dy;
                    C0646w.m2965b((View) child, -dy);
                    mo4286d(1);
                }
            } else if (dy < 0 && !target.canScrollVertically(-1)) {
                int i2 = this.f851f;
                if (newTop <= i2 || this.f852g) {
                    consumed[1] = dy;
                    C0646w.m2965b((View) child, -dy);
                    mo4286d(1);
                } else {
                    consumed[1] = currentTop - i2;
                    C0646w.m2965b((View) child, -consumed[1]);
                    mo4286d(4);
                }
            }
            mo4271a(child.getTop());
            this.f857l = dy;
            this.f858m = true;
        }
    }

    /* renamed from: d */
    public void mo4287d(CoordinatorLayout coordinatorLayout, V child, View target) {
        int targetState;
        int top;
        if (child.getTop() == this.f850e) {
            mo4286d(3);
            return;
        }
        WeakReference<View> weakReference = this.f861p;
        if (weakReference != null && target == weakReference.get() && this.f858m) {
            if (this.f857l > 0) {
                top = this.f850e;
                targetState = 3;
            } else if (this.f852g != 0 && mo4278a((View) child, m1374d())) {
                top = this.f859n;
                targetState = 5;
            } else if (this.f857l == 0) {
                int currentTop = child.getTop();
                if (Math.abs(currentTop - this.f850e) < Math.abs(currentTop - this.f851f)) {
                    top = this.f850e;
                    targetState = 3;
                } else {
                    targetState = 4;
                    top = this.f851f;
                }
            } else {
                top = this.f851f;
                targetState = 4;
            }
            if (this.f855j.mo5785b((View) child, child.getLeft(), top)) {
                mo4286d(2);
                C0646w.m2958a((View) child, (Runnable) new C0232b(child, targetState));
            } else {
                mo4286d(targetState);
            }
            this.f858m = false;
        }
    }

    /* renamed from: a */
    public boolean mo4277a(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        return target == this.f861p.get() && (this.f854i != 3 || super.mo4277a(coordinatorLayout, child, target, velocityX, velocityY));
    }

    /* renamed from: b */
    public final void mo4280b(int peekHeight) {
        boolean layout = false;
        if (peekHeight == -1) {
            if (!this.f848c) {
                this.f848c = true;
                layout = true;
            }
        } else if (this.f848c || this.f847b != peekHeight) {
            this.f848c = false;
            this.f847b = Math.max(0, peekHeight);
            this.f851f = this.f859n - peekHeight;
            layout = true;
        }
        if (layout && this.f854i == 4) {
            WeakReference<V> weakReference = this.f860o;
            if (weakReference != null) {
                V view = (View) weakReference.get();
                if (view != null) {
                    view.requestLayout();
                }
            }
        }
    }

    /* renamed from: b */
    public final int mo4279b() {
        if (this.f848c) {
            return -1;
        }
        return this.f847b;
    }

    /* renamed from: a */
    public void mo4275a(boolean hideable) {
        this.f852g = hideable;
    }

    /* renamed from: b */
    public void mo4281b(boolean skipCollapsed) {
        this.f853h = skipCollapsed;
    }

    /* renamed from: a */
    public void mo4272a(C0231a callback) {
        this.f862q = callback;
    }

    /* renamed from: c */
    public final void mo4285c(int state) {
        if (state != this.f854i) {
            WeakReference<V> weakReference = this.f860o;
            if (weakReference == null) {
                if (state == 4 || state == 3 || (this.f852g && state == 5)) {
                    this.f854i = state;
                }
                return;
            }
            V child = (View) weakReference.get();
            if (child != null) {
                ViewParent parent = child.getParent();
                if (parent == null || !parent.isLayoutRequested() || !C0646w.m2986t(child)) {
                    mo4274a((View) child, state);
                } else {
                    child.post(new C0316u(this, child, state));
                }
            }
        }
    }

    /* renamed from: c */
    public final int mo4284c() {
        return this.f854i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4286d(int state) {
        if (this.f854i != state) {
            this.f854i = state;
            View bottomSheet = (View) this.f860o.get();
            if (bottomSheet != null) {
                C0231a aVar = this.f862q;
                if (aVar != null) {
                    aVar.onStateChanged(bottomSheet, state);
                }
            }
        }
    }

    /* renamed from: e */
    private void m1375e() {
        this.f864s = -1;
        VelocityTracker velocityTracker = this.f863r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f863r = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo4278a(View child, float yvel) {
        boolean z = true;
        if (this.f853h) {
            return true;
        }
        if (child.getTop() < this.f851f) {
            return false;
        }
        if (Math.abs((((float) child.getTop()) + (0.1f * yvel)) - ((float) this.f851f)) / ((float) this.f847b) <= 0.5f) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo4270a(View view) {
        if (C0646w.m2988v(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                View scrollingChild = mo4270a(group.getChildAt(i));
                if (scrollingChild != null) {
                    return scrollingChild;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    private float m1374d() {
        this.f863r.computeCurrentVelocity(1000, this.f846a);
        return this.f863r.getYVelocity(this.f864s);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4274a(View child, int state) {
        int top;
        if (state == 4) {
            top = this.f851f;
        } else if (state == 3) {
            top = this.f850e;
        } else if (this.f852g == 0 || state != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal state argument: ");
            sb.append(state);
            throw new IllegalArgumentException(sb.toString());
        } else {
            top = this.f859n;
        }
        if (this.f855j.mo5785b(child, child.getLeft(), top)) {
            mo4286d(2);
            C0646w.m2958a(child, (Runnable) new C0232b(child, state));
            return;
        }
        mo4286d(state);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4271a(int top) {
        View bottomSheet = (View) this.f860o.get();
        if (bottomSheet != null) {
            C0231a aVar = this.f862q;
            if (aVar != null) {
                int i = this.f851f;
                if (top > i) {
                    aVar.onSlide(bottomSheet, ((float) (i - top)) / ((float) (this.f859n - i)));
                } else {
                    aVar.onSlide(bottomSheet, ((float) (i - top)) / ((float) (i - this.f850e)));
                }
            }
        }
    }

    /* renamed from: b */
    public static <V extends View> BottomSheetBehavior<V> m1373b(V view) {
        LayoutParams params = view.getLayoutParams();
        if (params instanceof C0239e) {
            C0237b behavior = ((C0239e) params).mo4442d();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
