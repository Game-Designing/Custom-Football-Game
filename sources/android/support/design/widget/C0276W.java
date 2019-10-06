package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior.C0267a;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0677H.C0678a;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.W */
/* compiled from: SwipeDismissBehavior */
class C0276W extends C0678a {

    /* renamed from: a */
    private int f1069a;

    /* renamed from: b */
    private int f1070b = -1;

    /* renamed from: c */
    final /* synthetic */ SwipeDismissBehavior f1071c;

    C0276W(SwipeDismissBehavior this$0) {
        this.f1071c = this$0;
    }

    /* renamed from: b */
    public boolean mo4637b(View child, int pointerId) {
        return this.f1070b == -1 && this.f1071c.mo4564a(child);
    }

    /* renamed from: a */
    public void mo4634a(View capturedChild, int activePointerId) {
        this.f1070b = activePointerId;
        this.f1069a = capturedChild.getLeft();
        ViewParent parent = capturedChild.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    /* renamed from: c */
    public void mo4638c(int state) {
        C0267a aVar = this.f1071c.f1039b;
        if (aVar != null) {
            aVar.mo4566a(state);
        }
    }

    /* renamed from: a */
    public void mo4633a(View child, float xvel, float yvel) {
        int targetLeft;
        this.f1070b = -1;
        int childWidth = child.getWidth();
        boolean dismiss = false;
        if (m1667a(child, xvel)) {
            int left = child.getLeft();
            int i = this.f1069a;
            targetLeft = left < i ? i - childWidth : i + childWidth;
            dismiss = true;
        } else {
            targetLeft = this.f1069a;
        }
        if (this.f1071c.f1038a.mo5786c(targetLeft, child.getTop())) {
            C0646w.m2958a(child, (Runnable) new C0268b(child, dismiss));
        } else if (dismiss) {
            C0267a aVar = this.f1071c.f1039b;
            if (aVar != null) {
                aVar.mo4567a(child);
            }
        }
    }

    /* renamed from: a */
    private boolean m1667a(View child, float xvel) {
        boolean z = false;
        if (xvel != 0.0f) {
            boolean isRtl = C0646w.m2974h(child) == 1;
            int i = this.f1071c.f1043f;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                return isRtl ? z : z;
                z = true;
            } else if (i != 1) {
                return false;
            } else {
                if (!isRtl ? xvel < 0.0f : xvel > 0.0f) {
                    z = true;
                }
                return z;
            }
        } else {
            if (Math.abs(child.getLeft() - this.f1069a) >= Math.round(((float) child.getWidth()) * this.f1071c.f1044g)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: a */
    public int mo4631a(View child) {
        return child.getWidth();
    }

    /* renamed from: a */
    public int mo4632a(View child, int left, int dx) {
        int max;
        int min;
        boolean isRtl = C0646w.m2974h(child) == 1;
        int max2 = this.f1071c.f1043f;
        if (max2 == 0) {
            if (isRtl) {
                min = this.f1069a - child.getWidth();
                max = this.f1069a;
            } else {
                min = this.f1069a;
                max = this.f1069a + child.getWidth();
            }
        } else if (max2 != 1) {
            min = this.f1069a - child.getWidth();
            max = this.f1069a + child.getWidth();
        } else if (isRtl) {
            min = this.f1069a;
            max = this.f1069a + child.getWidth();
        } else {
            min = this.f1069a - child.getWidth();
            max = this.f1069a;
        }
        return SwipeDismissBehavior.m1631a(min, left, max);
    }

    /* renamed from: b */
    public int mo4636b(View child, int top, int dy) {
        return child.getTop();
    }

    /* renamed from: a */
    public void mo4635a(View child, int left, int top, int dx, int dy) {
        float startAlphaDistance = ((float) this.f1069a) + (((float) child.getWidth()) * this.f1071c.f1045h);
        float endAlphaDistance = ((float) this.f1069a) + (((float) child.getWidth()) * this.f1071c.f1046i);
        if (((float) left) <= startAlphaDistance) {
            child.setAlpha(1.0f);
        } else if (((float) left) >= endAlphaDistance) {
            child.setAlpha(0.0f);
        } else {
            child.setAlpha(SwipeDismissBehavior.m1630a(0.0f, 1.0f - SwipeDismissBehavior.m1633b(startAlphaDistance, endAlphaDistance, (float) left), 1.0f));
        }
    }
}
