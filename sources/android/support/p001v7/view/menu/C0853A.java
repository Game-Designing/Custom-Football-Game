package android.support.p001v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: android.support.v7.view.menu.A */
/* compiled from: StandardMenuPopup */
class C0853A implements OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0857C f2565a;

    C0853A(C0857C this$0) {
        this.f2565a = this$0;
    }

    public void onGlobalLayout() {
        if (this.f2565a.mo6555c() && !this.f2565a.f2586i.mo8706j()) {
            View anchor = this.f2565a.f2591n;
            if (anchor == null || !anchor.isShown()) {
                this.f2565a.dismiss();
            } else {
                this.f2565a.f2586i.show();
            }
        }
    }
}
