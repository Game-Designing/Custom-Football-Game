package android.support.p001v7.widget;

import android.os.SystemClock;
import android.support.p001v7.view.menu.C0896z;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* renamed from: android.support.v7.widget.la */
/* compiled from: ForwardingListener */
public abstract class C1080la implements OnTouchListener, OnAttachStateChangeListener {

    /* renamed from: a */
    private final float f3586a;

    /* renamed from: b */
    private final int f3587b;

    /* renamed from: c */
    private final int f3588c;

    /* renamed from: d */
    final View f3589d;

    /* renamed from: e */
    private Runnable f3590e;

    /* renamed from: f */
    private Runnable f3591f;

    /* renamed from: g */
    private boolean f3592g;

    /* renamed from: h */
    private int f3593h;

    /* renamed from: i */
    private final int[] f3594i = new int[2];

    /* renamed from: android.support.v7.widget.la$a */
    /* compiled from: ForwardingListener */
    private class C1081a implements Runnable {
        C1081a() {
        }

        public void run() {
            ViewParent parent = C1080la.this.f3589d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: android.support.v7.widget.la$b */
    /* compiled from: ForwardingListener */
    private class C1082b implements Runnable {
        C1082b() {
        }

        public void run() {
            C1080la.this.mo8515k();
        }
    }

    /* renamed from: h */
    public abstract C0896z mo6541h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public abstract boolean mo6542i();

    public C1080la(View src) {
        this.f3589d = src;
        src.setLongClickable(true);
        src.addOnAttachStateChangeListener(this);
        this.f3586a = (float) ViewConfiguration.get(src.getContext()).getScaledTouchSlop();
        this.f3587b = ViewConfiguration.getTapTimeout();
        this.f3588c = (this.f3587b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View v, MotionEvent event) {
        boolean forwarding;
        MotionEvent motionEvent = event;
        boolean wasForwarding = this.f3592g;
        if (wasForwarding) {
            forwarding = m5352a(motionEvent) || !mo8453j();
        } else {
            forwarding = m5355b(motionEvent) && mo6542i();
            if (forwarding) {
                long now = SystemClock.uptimeMillis();
                MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
                this.f3589d.onTouchEvent(e);
                e.recycle();
            }
        }
        this.f3592g = forwarding;
        if (forwarding || wasForwarding) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View v) {
    }

    public void onViewDetachedFromWindow(View v) {
        this.f3592g = false;
        this.f3593h = -1;
        Runnable runnable = this.f3590e;
        if (runnable != null) {
            this.f3589d.removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo8453j() {
        C0896z popup = mo6541h();
        if (popup != null && popup.mo6555c()) {
            popup.dismiss();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006f;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5355b(android.view.MotionEvent r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.f3589d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r9.getActionMasked()
            if (r1 == 0) goto L_0x0042
            r3 = 1
            if (r1 == r3) goto L_0x003e
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r3 = 3
            if (r1 == r3) goto L_0x003e
            goto L_0x006f
        L_0x001a:
            int r4 = r8.f3593h
            int r4 = r9.findPointerIndex(r4)
            if (r4 < 0) goto L_0x006f
            float r5 = r9.getX(r4)
            float r6 = r9.getY(r4)
            float r7 = r8.f3586a
            boolean r7 = m5353a(r0, r5, r6, r7)
            if (r7 != 0) goto L_0x003d
            r8.m5357l()
            android.view.ViewParent r2 = r0.getParent()
            r2.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            goto L_0x006f
        L_0x003e:
            r8.m5357l()
            goto L_0x006f
        L_0x0042:
            int r3 = r9.getPointerId(r2)
            r8.f3593h = r3
            java.lang.Runnable r3 = r8.f3590e
            if (r3 != 0) goto L_0x0053
            android.support.v7.widget.la$a r3 = new android.support.v7.widget.la$a
            r3.<init>()
            r8.f3590e = r3
        L_0x0053:
            java.lang.Runnable r3 = r8.f3590e
            int r4 = r8.f3587b
            long r4 = (long) r4
            r0.postDelayed(r3, r4)
            java.lang.Runnable r3 = r8.f3591f
            if (r3 != 0) goto L_0x0066
            android.support.v7.widget.la$b r3 = new android.support.v7.widget.la$b
            r3.<init>()
            r8.f3591f = r3
        L_0x0066:
            java.lang.Runnable r3 = r8.f3591f
            int r4 = r8.f3588c
            long r4 = (long) r4
            r0.postDelayed(r3, r4)
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C1080la.m5355b(android.view.MotionEvent):boolean");
    }

    /* renamed from: l */
    private void m5357l() {
        Runnable runnable = this.f3591f;
        if (runnable != null) {
            this.f3589d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f3590e;
        if (runnable2 != null) {
            this.f3589d.removeCallbacks(runnable2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public void mo8515k() {
        m5357l();
        View src = this.f3589d;
        if (src.isEnabled() && !src.isLongClickable() && mo6542i()) {
            src.getParent().requestDisallowInterceptTouchEvent(true);
            long now = SystemClock.uptimeMillis();
            MotionEvent e = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
            src.onTouchEvent(e);
            e.recycle();
            this.f3592g = true;
        }
    }

    /* renamed from: a */
    private boolean m5352a(MotionEvent srcEvent) {
        View src = this.f3589d;
        C0896z popup = mo6541h();
        boolean z = false;
        if (popup == null || !popup.mo6555c()) {
            return false;
        }
        C1058ga dst = (C1058ga) popup.mo6556d();
        if (dst == null || !dst.isShown()) {
            return false;
        }
        MotionEvent dstEvent = MotionEvent.obtainNoHistory(srcEvent);
        m5354a(src, dstEvent);
        m5356b(dst, dstEvent);
        boolean handled = dst.mo8432a(dstEvent, this.f3593h);
        dstEvent.recycle();
        int action = srcEvent.getActionMasked();
        boolean keepForwarding = (action == 1 || action == 3) ? false : true;
        if (handled && keepForwarding) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m5353a(View view, float localX, float localY, float slop) {
        return localX >= (-slop) && localY >= (-slop) && localX < ((float) (view.getRight() - view.getLeft())) + slop && localY < ((float) (view.getBottom() - view.getTop())) + slop;
    }

    /* renamed from: b */
    private boolean m5356b(View view, MotionEvent event) {
        int[] loc = this.f3594i;
        view.getLocationOnScreen(loc);
        event.offsetLocation((float) (-loc[0]), (float) (-loc[1]));
        return true;
    }

    /* renamed from: a */
    private boolean m5354a(View view, MotionEvent event) {
        int[] loc = this.f3594i;
        view.getLocationOnScreen(loc);
        event.offsetLocation((float) loc[0], (float) loc[1]);
        return true;
    }
}
