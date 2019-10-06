package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0988n;

/* renamed from: android.support.v7.widget.ia */
/* compiled from: FastScroller */
class C1066ia extends C0988n {

    /* renamed from: a */
    final /* synthetic */ C1071ja f3529a;

    C1066ia(C1071ja this$0) {
        this.f3529a = this$0;
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        this.f3529a.mo8490a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
