package android.support.p001v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.ta */
/* compiled from: ListPopupWindow */
class C1114ta implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1120va f3698a;

    C1114ta(C1120va this$0) {
        this.f3698a = this$0;
    }

    public void run() {
        View view = this.f3698a.mo8691b();
        if (view != null && view.getWindowToken() != null) {
            this.f3698a.show();
        }
    }
}
