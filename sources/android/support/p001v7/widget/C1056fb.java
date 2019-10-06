package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0988n;

/* renamed from: android.support.v7.widget.fb */
/* compiled from: SnapHelper */
class C1056fb extends C0988n {

    /* renamed from: a */
    boolean f3506a = false;

    /* renamed from: b */
    final /* synthetic */ C1064hb f3507b;

    C1056fb(C1064hb this$0) {
        this.f3507b = this$0;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState == 0 && this.f3506a) {
            this.f3506a = false;
            this.f3507b.snapToTargetExistingView();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dx != 0 || dy != 0) {
            this.f3506a = true;
        }
    }
}
