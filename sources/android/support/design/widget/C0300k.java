package android.support.design.widget;

import android.support.design.widget.SwipeDismissBehavior.C0267a;
import android.view.View;

/* renamed from: android.support.design.widget.k */
/* compiled from: BaseTransientBottomBar */
class C0300k implements C0267a {

    /* renamed from: a */
    final /* synthetic */ C0307r f1106a;

    C0300k(C0307r this$0) {
        this.f1106a = this$0;
    }

    /* renamed from: a */
    public void mo4567a(View view) {
        view.setVisibility(8);
        this.f1106a.mo4679a(0);
    }

    /* renamed from: a */
    public void mo4566a(int state) {
        if (state == 0) {
            C0269T.m1643a().mo4576e(this.f1106a.f1124j);
        } else if (state == 1 || state == 2) {
            C0269T.m1643a().mo4575d(this.f1106a.f1124j);
        }
    }
}
