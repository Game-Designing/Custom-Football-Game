package android.support.p001v7.app;

import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.support.p000v4.view.C0646w;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v7.app.E */
/* compiled from: AppCompatDelegateImplV9 */
class C0743E extends C0590K {

    /* renamed from: a */
    final /* synthetic */ C0739b f2233a;

    C0743E(C0739b this$1) {
        this.f2233a = this$1;
    }

    public void onAnimationEnd(View view) {
        C0737D.this.f2208z.setVisibility(8);
        C0737D d = C0737D.this;
        PopupWindow popupWindow = d.f2184A;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (d.f2208z.getParent() instanceof View) {
            C0646w.m2991y((View) C0737D.this.f2208z.getParent());
        }
        C0737D.this.f2208z.removeAllViews();
        C0737D.this.f2186C.mo5472a((C0589J) null);
        C0737D.this.f2186C = null;
    }
}
