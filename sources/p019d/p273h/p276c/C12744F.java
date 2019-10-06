package p019d.p273h.p276c;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: d.h.c.F */
/* compiled from: IronSourceBannerLayout */
class C12744F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f39083a;

    /* renamed from: b */
    final /* synthetic */ LayoutParams f39084b;

    /* renamed from: c */
    final /* synthetic */ C12745G f39085c;

    C12744F(C12745G this$0, View view, LayoutParams layoutParams) {
        this.f39085c = this$0;
        this.f39083a = view;
        this.f39084b = layoutParams;
    }

    public void run() {
        this.f39085c.removeAllViews();
        this.f39085c.f39086a = this.f39083a;
        this.f39085c.addView(this.f39083a, 0, this.f39084b);
    }
}
