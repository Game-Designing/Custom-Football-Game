package android.support.design.widget;

import android.view.View;

/* renamed from: android.support.design.widget.m */
/* compiled from: BaseTransientBottomBar */
class C0302m implements C0311d {

    /* renamed from: a */
    final /* synthetic */ C0307r f1108a;

    C0302m(C0307r this$0) {
        this.f1108a = this$0;
    }

    public void onViewAttachedToWindow(View v) {
    }

    public void onViewDetachedFromWindow(View v) {
        if (this.f1108a.mo4687e()) {
            C0307r.f1115a.post(new C0301l(this));
        }
    }
}
