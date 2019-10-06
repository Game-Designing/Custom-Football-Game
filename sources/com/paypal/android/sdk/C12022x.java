package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.paypal.android.sdk.x */
final class C12022x extends Handler {

    /* renamed from: a */
    private final WeakReference f37809a;

    public C12022x(C12010u uVar) {
        this.f37809a = new WeakReference(uVar);
    }

    public final void handleMessage(Message message) {
        C12010u uVar = (C12010u) this.f37809a.get();
        if (uVar != null) {
            uVar.mo39193a(message);
        }
    }
}
