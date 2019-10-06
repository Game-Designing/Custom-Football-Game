package android.support.p001v7.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

/* renamed from: android.support.v7.view.menu.f */
/* compiled from: CascadingMenuPopup */
class C0865f implements OnAttachStateChangeListener {

    /* renamed from: a */
    final /* synthetic */ C0868i f2656a;

    C0865f(C0868i this$0) {
        this.f2656a = this$0;
    }

    public void onViewAttachedToWindow(View v) {
    }

    public void onViewDetachedFromWindow(View v) {
        if (this.f2656a.f2686y != null) {
            if (!this.f2656a.f2686y.isAlive()) {
                this.f2656a.f2686y = v.getViewTreeObserver();
            }
            this.f2656a.f2686y.removeGlobalOnLayoutListener(this.f2656a.f2671j);
        }
        v.removeOnAttachStateChangeListener(this);
    }
}
