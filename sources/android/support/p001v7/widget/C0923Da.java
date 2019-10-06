package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0975f;

/* renamed from: android.support.v7.widget.Da */
/* compiled from: RecyclerView */
class C0923Da implements Runnable {

    /* renamed from: a */
    final /* synthetic */ RecyclerView f2950a;

    C0923Da(RecyclerView this$0) {
        this.f2950a = this$0;
    }

    public void run() {
        C0975f fVar = this.f2950a.f3131W;
        if (fVar != null) {
            fVar.mo7740i();
        }
        this.f2950a.f3169xa = false;
    }
}
