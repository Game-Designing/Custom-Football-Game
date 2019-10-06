package com.mopub.mobileads;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;

public class AdAlertGestureListener extends SimpleOnGestureListener {

    /* renamed from: a */
    private final AdReport f34626a;

    /* renamed from: b */
    private float f34627b = 100.0f;

    /* renamed from: c */
    private float f34628c;

    /* renamed from: d */
    private boolean f34629d;

    /* renamed from: e */
    private boolean f34630e;

    /* renamed from: f */
    private AdAlertReporter f34631f;

    /* renamed from: g */
    private int f34632g;

    /* renamed from: h */
    private float f34633h;

    /* renamed from: i */
    private C11298a f34634i = C11298a.UNSET;

    /* renamed from: j */
    private View f34635j;

    /* renamed from: k */
    boolean f34636k;

    /* renamed from: com.mopub.mobileads.AdAlertGestureListener$a */
    enum C11298a {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    AdAlertGestureListener(View view, AdReport adReport) {
        if (view != null && view.getWidth() > 0) {
            this.f34627b = Math.min(100.0f, ((float) view.getWidth()) / 3.0f);
        }
        this.f34636k = false;
        this.f34635j = view;
        this.f34626a = adReport;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (this.f34634i == C11298a.FINISHED) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        if (m37216a(e1, e2)) {
            this.f34634i = C11298a.FAILED;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        int i = C11378a.f35191a[this.f34634i.ordinal()];
        if (i == 1) {
            this.f34633h = e1.getX();
            m37221e(e2.getX());
        } else if (i == 2) {
            m37223g(e2.getX());
        } else if (i == 3) {
            m37222f(e2.getX());
        } else if (i != 4) {
        }
        this.f34628c = e2.getX();
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36847a() {
        if (this.f34634i == C11298a.FINISHED) {
            this.f34631f = new AdAlertReporter(this.f34635j.getContext(), this.f34635j, this.f34626a);
            this.f34631f.send();
        }
        mo36850d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo36850d() {
        this.f34632g = 0;
        this.f34634i = C11298a.UNSET;
    }

    /* renamed from: a */
    private boolean m37216a(MotionEvent e1, MotionEvent e2) {
        boolean z = false;
        if (e1 == null || e2 == null) {
            return false;
        }
        if (Math.abs(e2.getY() - e1.getY()) > 100.0f) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    private void m37221e(float currentPositionX) {
        if (currentPositionX > this.f34633h) {
            this.f34634i = C11298a.GOING_RIGHT;
        }
    }

    /* renamed from: g */
    private void m37223g(float currentPositionX) {
        if (m37219d(currentPositionX) && m37215a(currentPositionX)) {
            this.f34634i = C11298a.GOING_LEFT;
            this.f34633h = currentPositionX;
        }
    }

    /* renamed from: f */
    private void m37222f(float currentPositionX) {
        if (m37218c(currentPositionX) && m37217b(currentPositionX)) {
            this.f34634i = C11298a.GOING_RIGHT;
            this.f34633h = currentPositionX;
        }
    }

    /* renamed from: e */
    private void m37220e() {
        this.f34632g++;
        if (this.f34632g >= 4) {
            this.f34634i = C11298a.FINISHED;
        }
    }

    /* renamed from: d */
    private boolean m37219d(float currentPosition) {
        if (this.f34630e) {
            return true;
        }
        if (currentPosition < this.f34633h + this.f34627b) {
            return false;
        }
        this.f34629d = false;
        this.f34630e = true;
        return true;
    }

    /* renamed from: c */
    private boolean m37218c(float currentPosition) {
        if (this.f34629d) {
            return true;
        }
        if (currentPosition > this.f34633h - this.f34627b) {
            return false;
        }
        this.f34630e = false;
        this.f34629d = true;
        m37220e();
        return true;
    }

    /* renamed from: b */
    private boolean m37217b(float currentPositionX) {
        return currentPositionX > this.f34628c;
    }

    /* renamed from: a */
    private boolean m37215a(float currentPositionX) {
        return currentPositionX < this.f34628c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36849c() {
        this.f34636k = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36848b() {
        return this.f34636k;
    }

    public boolean onSingleTapUp(MotionEvent e) {
        this.f34636k = true;
        return super.onSingleTapUp(e);
    }
}
