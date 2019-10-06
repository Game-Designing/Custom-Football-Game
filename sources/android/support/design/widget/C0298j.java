package android.support.design.widget;

import android.os.Handler;

/* renamed from: android.support.design.widget.j */
/* compiled from: BaseTransientBottomBar */
class C0298j implements C0270a {

    /* renamed from: a */
    final /* synthetic */ C0307r f1104a;

    C0298j(C0307r this$0) {
        this.f1104a = this$0;
    }

    public void show() {
        Handler handler = C0307r.f1115a;
        handler.sendMessage(handler.obtainMessage(0, this.f1104a));
    }

    /* renamed from: a */
    public void mo4577a(int event) {
        Handler handler = C0307r.f1115a;
        handler.sendMessage(handler.obtainMessage(1, event, 0, this.f1104a));
    }
}
