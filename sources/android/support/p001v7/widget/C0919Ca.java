package android.support.p001v7.widget;

/* renamed from: android.support.v7.widget.Ca */
/* compiled from: RecyclerView */
class C0919Ca implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RecyclerView f2929a;

    C0919Ca(RecyclerView this$0) {
        this.f2929a = this$0;
    }

    public void run() {
        RecyclerView recyclerView = this.f2929a;
        if (recyclerView.f3109E && !recyclerView.isLayoutRequested()) {
            RecyclerView recyclerView2 = this.f2929a;
            if (!recyclerView2.f3103B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f3115H) {
                recyclerView2.f3113G = true;
            } else {
                recyclerView2.mo7569d();
            }
        }
    }
}
