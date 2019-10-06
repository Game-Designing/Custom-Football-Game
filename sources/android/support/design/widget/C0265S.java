package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: android.support.design.widget.S */
/* compiled from: SnackbarManager */
class C0265S implements Callback {

    /* renamed from: a */
    final /* synthetic */ C0269T f1036a;

    C0265S(C0269T this$0) {
        this.f1036a = this$0;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f1036a.mo4571a((C0271b) message.obj);
        return true;
    }
}
