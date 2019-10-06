package android.support.p000v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: android.support.v4.content.d */
/* compiled from: LocalBroadcastManager */
class C0514d extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0515e f1671a;

    C0514d(C0515e this$0, Looper x0) {
        this.f1671a = this$0;
        super(x0);
    }

    public void handleMessage(Message msg) {
        if (msg.what != 1) {
            super.handleMessage(msg);
        } else {
            this.f1671a.m2598a();
        }
    }
}
