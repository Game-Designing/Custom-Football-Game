package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.paypal.android.sdk.U */
final class C11768U extends Handler {

    /* renamed from: a */
    private WeakReference f37037a;

    public C11768U(C11765T t) {
        this.f37037a = new WeakReference(t);
    }

    public final void handleMessage(Message message) {
        if (message.what == 2) {
            C11765T t = (C11765T) this.f37037a.get();
            if (t != null) {
                t.f37030d.mo38648a((C11703Aa) message.obj, 0);
            }
        }
    }
}
