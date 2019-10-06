package android.support.p001v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

/* renamed from: android.support.v7.view.menu.B */
/* compiled from: StandardMenuPopup */
class C0856B implements OnAttachStateChangeListener {

    /* renamed from: a */
    final /* synthetic */ C0857C f2578a;

    C0856B(C0857C this$0) {
        this.f2578a = this$0;
    }

    public void onViewAttachedToWindow(View v) {
    }

    public void onViewDetachedFromWindow(View v) {
        if (this.f2578a.f2593p != null) {
            if (!this.f2578a.f2593p.isAlive()) {
                this.f2578a.f2593p = v.getViewTreeObserver();
            }
            this.f2578a.f2593p.removeGlobalOnLayoutListener(this.f2578a.f2587j);
        }
        v.removeOnAttachStateChangeListener(this);
    }
}
