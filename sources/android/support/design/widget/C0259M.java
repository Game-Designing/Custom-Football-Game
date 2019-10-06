package android.support.design.widget;

import android.content.Context;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: android.support.design.widget.M */
/* compiled from: HeaderBehavior */
abstract class C0259M<V extends View> extends C0291fa<V> {

    /* renamed from: d */
    private Runnable f1003d;

    /* renamed from: e */
    OverScroller f1004e;

    /* renamed from: f */
    private boolean f1005f;

    /* renamed from: g */
    private int f1006g = -1;

    /* renamed from: h */
    private int f1007h;

    /* renamed from: i */
    private int f1008i = -1;

    /* renamed from: j */
    private VelocityTracker f1009j;

    /* renamed from: android.support.design.widget.M$a */
    /* compiled from: HeaderBehavior */
    private class C0260a implements Runnable {

        /* renamed from: a */
        private final CoordinatorLayout f1010a;

        /* renamed from: b */
        private final V f1011b;

        C0260a(CoordinatorLayout parent, V layout) {
            this.f1010a = parent;
            this.f1011b = layout;
        }

        public void run() {
            if (this.f1011b != null) {
                OverScroller overScroller = C0259M.this.f1004e;
                if (overScroller == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    C0259M m = C0259M.this;
                    m.mo4533c(this.f1010a, this.f1011b, m.f1004e.getCurrY());
                    C0646w.m2958a((View) this.f1011b, (Runnable) this);
                    return;
                }
                C0259M.this.mo4239e(this.f1010a, this.f1011b);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract boolean mo4228a(V v);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract int mo4231b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract int mo4232b(V v);

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract int mo4235c();

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract int mo4237c(V v);

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public abstract void mo4239e(CoordinatorLayout coordinatorLayout, V v);

    public C0259M() {
    }

    public C0259M(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r3 != 3) goto L_0x0083;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4276a(android.support.design.widget.CoordinatorLayout r8, V r9, android.view.MotionEvent r10) {
        /*
            r7 = this;
            int r0 = r7.f1008i
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r8.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r7.f1008i = r0
        L_0x0012:
            int r0 = r10.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x001f
            boolean r3 = r7.f1005f
            if (r3 == 0) goto L_0x001f
            return r2
        L_0x001f:
            int r3 = r10.getActionMasked()
            r4 = 0
            if (r3 == 0) goto L_0x0060
            r5 = -1
            if (r3 == r2) goto L_0x0051
            if (r3 == r1) goto L_0x002f
            r1 = 3
            if (r3 == r1) goto L_0x0051
            goto L_0x0083
        L_0x002f:
            int r1 = r7.f1006g
            if (r1 != r5) goto L_0x0034
            goto L_0x0083
        L_0x0034:
            int r3 = r10.findPointerIndex(r1)
            if (r3 != r5) goto L_0x003b
            goto L_0x0083
        L_0x003b:
            float r4 = r10.getY(r3)
            int r4 = (int) r4
            int r5 = r7.f1007h
            int r5 = r4 - r5
            int r5 = java.lang.Math.abs(r5)
            int r6 = r7.f1008i
            if (r5 <= r6) goto L_0x0083
            r7.f1005f = r2
            r7.f1007h = r4
            goto L_0x0083
        L_0x0051:
            r7.f1005f = r4
            r7.f1006g = r5
            android.view.VelocityTracker r1 = r7.f1009j
            if (r1 == 0) goto L_0x0083
            r1.recycle()
            r1 = 0
            r7.f1009j = r1
            goto L_0x0083
        L_0x0060:
            r7.f1005f = r4
            float r1 = r10.getX()
            int r1 = (int) r1
            float r2 = r10.getY()
            int r2 = (int) r2
            boolean r3 = r7.mo4228a(r9)
            if (r3 == 0) goto L_0x0083
            boolean r3 = r8.mo4367a(r9, r1, r2)
            if (r3 == 0) goto L_0x0083
            r7.f1007h = r2
            int r3 = r10.getPointerId(r4)
            r7.f1006g = r3
            r7.m1586d()
        L_0x0083:
            android.view.VelocityTracker r1 = r7.f1009j
            if (r1 == 0) goto L_0x008a
            r1.addMovement(r10)
        L_0x008a:
            boolean r1 = r7.f1005f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.C0259M.mo4276a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0 != 3) goto L_0x00af;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4282b(android.support.design.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f1008i
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f1008i = r0
        L_0x0012:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008e
            r3 = -1
            if (r0 == r1) goto L_0x005c
            r4 = 2
            if (r0 == r4) goto L_0x0025
            r4 = 3
            if (r0 == r4) goto L_0x007f
            goto L_0x00af
        L_0x0025:
            int r0 = r11.f1006g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L_0x002e
            return r2
        L_0x002e:
            float r2 = r14.getY(r0)
            int r2 = (int) r2
            int r3 = r11.f1007h
            int r3 = r3 - r2
            boolean r4 = r11.f1005f
            if (r4 != 0) goto L_0x0049
            int r4 = java.lang.Math.abs(r3)
            int r5 = r11.f1008i
            if (r4 <= r5) goto L_0x0049
            r11.f1005f = r1
            if (r3 <= 0) goto L_0x0048
            int r3 = r3 - r5
            goto L_0x0049
        L_0x0048:
            int r3 = r3 + r5
        L_0x0049:
            boolean r4 = r11.f1005f
            if (r4 == 0) goto L_0x00af
            r11.f1007h = r2
            int r8 = r11.mo4232b(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r3
            r4.mo4531a(r5, (V) r6, r7, r8, r9)
            goto L_0x00af
        L_0x005c:
            android.view.VelocityTracker r0 = r11.f1009j
            if (r0 == 0) goto L_0x007f
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f1009j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f1009j
            int r4 = r11.f1006g
            float r0 = r0.getYVelocity(r4)
            int r4 = r11.mo4237c(r13)
            int r8 = -r4
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r10 = r0
            r5.mo4532a(r6, (V) r7, r8, r9, r10)
        L_0x007f:
            r11.f1005f = r2
            r11.f1006g = r3
            android.view.VelocityTracker r0 = r11.f1009j
            if (r0 == 0) goto L_0x00af
            r0.recycle()
            r0 = 0
            r11.f1009j = r0
            goto L_0x00af
        L_0x008e:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r4 = r12.mo4367a(r13, r0, r3)
            if (r4 == 0) goto L_0x00b7
            boolean r4 = r11.mo4228a(r13)
            if (r4 == 0) goto L_0x00b7
            r11.f1007h = r3
            int r2 = r14.getPointerId(r2)
            r11.f1006g = r2
            r11.m1586d()
        L_0x00af:
            android.view.VelocityTracker r0 = r11.f1009j
            if (r0 == 0) goto L_0x00b6
            r0.addMovement(r14)
        L_0x00b6:
            return r1
        L_0x00b7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.C0259M.mo4282b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo4533c(CoordinatorLayout parent, V header, int newOffset) {
        return mo4231b(parent, header, newOffset, LinearLayoutManager.INVALID_OFFSET, MoPubClientPositioning.NO_REPEAT);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo4531a(CoordinatorLayout coordinatorLayout, V header, int dy, int minOffset, int maxOffset) {
        return mo4231b(coordinatorLayout, header, mo4235c() - dy, minOffset, maxOffset);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo4532a(CoordinatorLayout coordinatorLayout, V layout, int minOffset, int maxOffset, float velocityY) {
        V v = layout;
        Runnable runnable = this.f1003d;
        if (runnable != null) {
            layout.removeCallbacks(runnable);
            this.f1003d = null;
        }
        if (this.f1004e == null) {
            this.f1004e = new OverScroller(layout.getContext());
        }
        this.f1004e.fling(0, mo4229b(), 0, Math.round(velocityY), 0, 0, minOffset, maxOffset);
        if (this.f1004e.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            this.f1003d = new C0260a(coordinatorLayout, layout);
            C0646w.m2958a((View) layout, this.f1003d);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        mo4239e(coordinatorLayout, layout);
        return false;
    }

    /* renamed from: d */
    private void m1586d() {
        if (this.f1009j == null) {
            this.f1009j = VelocityTracker.obtain();
        }
    }
}
