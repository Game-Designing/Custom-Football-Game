package android.support.p001v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: android.support.v7.view.menu.e */
/* compiled from: CascadingMenuPopup */
class C0864e implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0868i f2655a;

    C0864e(C0868i this$0) {
        this.f2655a = this$0;
    }

    public void onGlobalLayout() {
        if (this.f2655a.mo6555c() && this.f2655a.f2670i.size() > 0 && !((C0869a) this.f2655a.f2670i.get(0)).f2688a.mo8706j()) {
            View anchor = this.f2655a.f2677p;
            if (anchor == null || !anchor.isShown()) {
                this.f2655a.dismiss();
                return;
            }
            for (C0869a info : this.f2655a.f2670i) {
                info.f2688a.show();
            }
        }
    }
}
