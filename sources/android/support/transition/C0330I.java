package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.transition.I */
/* compiled from: Scene */
public class C0330I {

    /* renamed from: a */
    private ViewGroup f1154a;

    /* renamed from: b */
    private Runnable f1155b;

    /* renamed from: a */
    public void mo4744a() {
        if (m1762a(this.f1154a) == this) {
            Runnable runnable = this.f1155b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: a */
    static void m1763a(View view, C0330I scene) {
        view.setTag(C0328G.transition_current_scene, scene);
    }

    /* renamed from: a */
    static C0330I m1762a(View view) {
        return (C0330I) view.getTag(C0328G.transition_current_scene);
    }
}
