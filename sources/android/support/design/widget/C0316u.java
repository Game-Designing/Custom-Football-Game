package android.support.design.widget;

import android.view.View;

/* renamed from: android.support.design.widget.u */
/* compiled from: BottomSheetBehavior */
class C0316u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f1129a;

    /* renamed from: b */
    final /* synthetic */ int f1130b;

    /* renamed from: c */
    final /* synthetic */ BottomSheetBehavior f1131c;

    C0316u(BottomSheetBehavior this$0, View view, int i) {
        this.f1131c = this$0;
        this.f1129a = view;
        this.f1130b = i;
    }

    public void run() {
        this.f1131c.mo4274a(this.f1129a, this.f1130b);
    }
}
