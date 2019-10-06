package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.tb */
final class C11974tb implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C11950lb f37612a;

    C11974tb(C11950lb lbVar) {
        this.f37612a = lbVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(C11950lb.f37577a);
        sb.append(".onServiceConnected");
        C11950lb lbVar = this.f37612a;
        lbVar.f37579c = ((C11934ga) iBinder).f37551a;
        if (lbVar.f37579c.mo38975a((C11946ka) new C11977ub(this))) {
            C11950lb.m39613d(this.f37612a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37612a.f37579c = null;
    }
}
