package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: android.support.transition.Y */
/* compiled from: ViewGroupOverlayApi18 */
class C0350Y implements C0351Z {

    /* renamed from: a */
    private final ViewGroupOverlay f1221a;

    C0350Y(ViewGroup group) {
        this.f1221a = group.getOverlay();
    }

    /* renamed from: a */
    public void mo4803a(Drawable drawable) {
        this.f1221a.add(drawable);
    }

    /* renamed from: b */
    public void mo4804b(Drawable drawable) {
        this.f1221a.remove(drawable);
    }

    /* renamed from: a */
    public void mo4801a(View view) {
        this.f1221a.add(view);
    }

    /* renamed from: b */
    public void mo4802b(View view) {
        this.f1221a.remove(view);
    }
}
