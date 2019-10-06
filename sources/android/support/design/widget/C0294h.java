package android.support.design.widget;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: android.support.design.widget.h */
/* compiled from: BaseTransientBottomBar */
class C0294h implements Callback {
    C0294h() {
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            ((C0307r) message.obj).mo4691i();
            return true;
        } else if (i != 1) {
            return false;
        } else {
            ((C0307r) message.obj).mo4682b(message.arg1);
            return true;
        }
    }
}
