package android.support.design.widget;

import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0677H.C0678a;
import android.view.View;
import java.lang.ref.WeakReference;
import p002b.p003c.p053g.p058c.C1226a;

/* renamed from: android.support.design.widget.v */
/* compiled from: BottomSheetBehavior */
class C0317v extends C0678a {

    /* renamed from: a */
    final /* synthetic */ BottomSheetBehavior f1132a;

    C0317v(BottomSheetBehavior this$0) {
        this.f1132a = this$0;
    }

    /* renamed from: b */
    public boolean mo4637b(View child, int pointerId) {
        BottomSheetBehavior bottomSheetBehavior = this.f1132a;
        int i = bottomSheetBehavior.f854i;
        boolean z = true;
        if (i == 1 || bottomSheetBehavior.f866u) {
            return false;
        }
        if (i == 3 && bottomSheetBehavior.f864s == pointerId) {
            View scroll = (View) bottomSheetBehavior.f861p.get();
            if (scroll != null && scroll.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference<V> weakReference = this.f1132a.f860o;
        if (weakReference == null || weakReference.get() != child) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public void mo4635a(View changedView, int left, int top, int dx, int dy) {
        this.f1132a.mo4271a(top);
    }

    /* renamed from: c */
    public void mo4638c(int state) {
        if (state == 1) {
            this.f1132a.mo4286d(1);
        }
    }

    /* renamed from: a */
    public void mo4633a(View releasedChild, float xvel, float yvel) {
        int targetState;
        int top;
        if (yvel < 0.0f) {
            top = this.f1132a.f850e;
            targetState = 3;
        } else {
            BottomSheetBehavior bottomSheetBehavior = this.f1132a;
            if (bottomSheetBehavior.f852g && bottomSheetBehavior.mo4278a(releasedChild, yvel)) {
                top = this.f1132a.f859n;
                targetState = 5;
            } else if (yvel == 0.0f) {
                int currentTop = releasedChild.getTop();
                if (Math.abs(currentTop - this.f1132a.f850e) < Math.abs(currentTop - this.f1132a.f851f)) {
                    top = this.f1132a.f850e;
                    targetState = 3;
                } else {
                    targetState = 4;
                    top = this.f1132a.f851f;
                }
            } else {
                top = this.f1132a.f851f;
                targetState = 4;
            }
        }
        if (this.f1132a.f855j.mo5786c(releasedChild.getLeft(), top)) {
            this.f1132a.mo4286d(2);
            C0646w.m2958a(releasedChild, (Runnable) new C0232b(releasedChild, targetState));
            return;
        }
        this.f1132a.mo4286d(targetState);
    }

    /* renamed from: b */
    public int mo4636b(View child, int top, int dy) {
        BottomSheetBehavior bottomSheetBehavior = this.f1132a;
        return C1226a.m5823a(top, bottomSheetBehavior.f850e, bottomSheetBehavior.f852g ? bottomSheetBehavior.f859n : bottomSheetBehavior.f851f);
    }

    /* renamed from: a */
    public int mo4632a(View child, int left, int dx) {
        return child.getLeft();
    }

    /* renamed from: b */
    public int mo4704b(View child) {
        BottomSheetBehavior bottomSheetBehavior = this.f1132a;
        if (bottomSheetBehavior.f852g) {
            return bottomSheetBehavior.f859n - bottomSheetBehavior.f850e;
        }
        return bottomSheetBehavior.f851f - bottomSheetBehavior.f850e;
    }
}
