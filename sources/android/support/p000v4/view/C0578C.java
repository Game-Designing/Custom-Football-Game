package android.support.p000v4.view;

/* renamed from: android.support.v4.view.C */
/* compiled from: ViewPager */
class C0578C implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ViewPager f1793a;

    C0578C(ViewPager this$0) {
        this.f1793a = this$0;
    }

    public void run() {
        this.f1793a.setScrollState(0);
        this.f1793a.populate();
    }
}
