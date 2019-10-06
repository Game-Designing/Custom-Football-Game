package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: android.support.transition.ga */
/* compiled from: ViewOverlayApi18 */
class C0367ga implements C0369ha {

    /* renamed from: a */
    private final ViewOverlay f1244a;

    C0367ga(View view) {
        this.f1244a = view.getOverlay();
    }

    /* renamed from: a */
    public void mo4803a(Drawable drawable) {
        this.f1244a.add(drawable);
    }

    /* renamed from: b */
    public void mo4804b(Drawable drawable) {
        this.f1244a.remove(drawable);
    }
}
