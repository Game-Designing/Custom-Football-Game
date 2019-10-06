package android.support.p001v7.widget;

/* renamed from: android.support.v7.widget.g */
/* compiled from: ActionBarOverlayLayout */
class C1057g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ActionBarOverlayLayout f3508a;

    C1057g(ActionBarOverlayLayout this$0) {
        this.f3508a = this$0;
    }

    public void run() {
        this.f3508a.mo7041h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3508a;
        actionBarOverlayLayout.f2860y = actionBarOverlayLayout.f2840e.animate().translationY((float) (-this.f3508a.f2840e.getHeight())).setListener(this.f3508a.f2861z);
    }
}
