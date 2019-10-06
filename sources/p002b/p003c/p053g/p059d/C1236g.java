package p002b.p003c.p053g.p059d;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: b.c.g.d.g */
/* compiled from: SelfDestructiveThread */
class C1236g implements Callback {

    /* renamed from: a */
    final /* synthetic */ C1240k f3986a;

    C1236g(C1240k this$0) {
        this.f3986a = this$0;
    }

    public boolean handleMessage(Message msg) {
        int i = msg.what;
        if (i == 0) {
            this.f3986a.m5855a();
            return true;
        } else if (i != 1) {
            return true;
        } else {
            this.f3986a.m5858a((Runnable) msg.obj);
            return true;
        }
    }
}
