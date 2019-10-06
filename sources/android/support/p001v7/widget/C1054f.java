package android.support.p001v7.widget;

/* renamed from: android.support.v7.widget.f */
/* compiled from: ActionBarOverlayLayout */
class C1054f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActionBarOverlayLayout f3505a;

    C1054f(ActionBarOverlayLayout this$0) {
        this.f3505a = this$0;
    }

    public void run() {
        this.f3505a.mo7041h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3505a;
        actionBarOverlayLayout.f2860y = actionBarOverlayLayout.f2840e.animate().translationY(0.0f).setListener(this.f3505a.f2861z);
    }
}
