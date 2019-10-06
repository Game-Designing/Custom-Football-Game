package android.support.p001v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.Ra */
/* compiled from: ScrollingTabContainerView */
class C0969Ra implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f3089a;

    /* renamed from: b */
    final /* synthetic */ C1004Sa f3090b;

    C0969Ra(C1004Sa this$0, View view) {
        this.f3090b = this$0;
        this.f3089a = view;
    }

    public void run() {
        this.f3090b.smoothScrollTo(this.f3089a.getLeft() - ((this.f3090b.getWidth() - this.f3089a.getWidth()) / 2), 0);
        this.f3090b.f3247b = null;
    }
}
