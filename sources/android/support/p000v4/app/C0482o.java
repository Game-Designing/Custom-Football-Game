package android.support.p000v4.app;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.v4.app.o */
/* compiled from: FragmentActivity */
class C0482o extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0014p f1612a;

    C0482o(C0014p this$0) {
        this.f1612a = this$0;
    }

    public void handleMessage(Message msg) {
        int i = msg.what;
        if (i == 1) {
            C0014p pVar = this.f1612a;
            if (pVar.mStopped) {
                pVar.doReallyStop(false);
            }
        } else if (i != 2) {
            super.handleMessage(msg);
        } else {
            this.f1612a.onResumeFragments();
            this.f1612a.mFragments.mo5221j();
        }
    }
}
