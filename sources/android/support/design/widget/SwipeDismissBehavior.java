package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout.C0237b;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0677H;
import android.support.p000v4.widget.C0677H.C0678a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SwipeDismissBehavior<V extends View> extends C0237b<V> {

    /* renamed from: a */
    C0677H f1038a;

    /* renamed from: b */
    C0267a f1039b;

    /* renamed from: c */
    private boolean f1040c;

    /* renamed from: d */
    private float f1041d = 0.0f;

    /* renamed from: e */
    private boolean f1042e;

    /* renamed from: f */
    int f1043f = 2;

    /* renamed from: g */
    float f1044g = 0.5f;

    /* renamed from: h */
    float f1045h = 0.0f;

    /* renamed from: i */
    float f1046i = 0.5f;

    /* renamed from: j */
    private final C0678a f1047j = new C0276W(this);

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$a */
    public interface C0267a {
        /* renamed from: a */
        void mo4566a(int i);

        /* renamed from: a */
        void mo4567a(View view);
    }

    /* renamed from: android.support.design.widget.SwipeDismissBehavior$b */
    private class C0268b implements Runnable {

        /* renamed from: a */
        private final View f1048a;

        /* renamed from: b */
        private final boolean f1049b;

        C0268b(View view, boolean dismiss) {
            this.f1048a = view;
            this.f1049b = dismiss;
        }

        public void run() {
            C0677H h = SwipeDismissBehavior.this.f1038a;
            if (h != null && h.mo5779a(true)) {
                C0646w.m2958a(this.f1048a, (Runnable) this);
            } else if (this.f1049b) {
                C0267a aVar = SwipeDismissBehavior.this.f1039b;
                if (aVar != null) {
                    aVar.mo4567a(this.f1048a);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4563a(C0267a listener) {
        this.f1039b = listener;
    }

    /* renamed from: a */
    public void mo4562a(int direction) {
        this.f1043f = direction;
    }

    /* renamed from: b */
    public void mo4565b(float fraction) {
        this.f1045h = m1630a(0.0f, fraction, 1.0f);
    }

    /* renamed from: a */
    public void mo4561a(float fraction) {
        this.f1046i = m1630a(0.0f, fraction, 1.0f);
    }

    /* renamed from: a */
    public boolean mo4276a(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean dispatchEventToHelper = this.f1040c;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.f1040c = parent.mo4367a((View) child, (int) event.getX(), (int) event.getY());
            dispatchEventToHelper = this.f1040c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1040c = false;
        }
        if (!dispatchEventToHelper) {
            return false;
        }
        m1632a((ViewGroup) parent);
        return this.f1038a.mo5783b(event);
    }

    /* renamed from: b */
    public boolean mo4282b(CoordinatorLayout parent, V v, MotionEvent event) {
        C0677H h = this.f1038a;
        if (h == null) {
            return false;
        }
        h.mo5775a(event);
        return true;
    }

    /* renamed from: a */
    public boolean mo4564a(View view) {
        return true;
    }

    /* renamed from: a */
    private void m1632a(ViewGroup parent) {
        C0677H h;
        if (this.f1038a == null) {
            if (this.f1042e) {
                h = C0677H.m3119a(parent, this.f1041d, this.f1047j);
            } else {
                h = C0677H.m3120a(parent, this.f1047j);
            }
            this.f1038a = h;
        }
    }

    /* renamed from: a */
    static float m1630a(float min, float value, float max) {
        return Math.min(Math.max(min, value), max);
    }

    /* renamed from: a */
    static int m1631a(int min, int value, int max) {
        return Math.min(Math.max(min, value), max);
    }

    /* renamed from: b */
    static float m1633b(float startValue, float endValue, float value) {
        return (value - startValue) / (endValue - startValue);
    }
}
