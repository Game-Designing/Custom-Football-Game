package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.r */
final class C11966r implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f37605a;

    C11966r(LoginActivity loginActivity) {
        this.f37605a = loginActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(LoginActivity.class.getSimpleName());
        sb.append(".onServiceConnected");
        this.f37605a.f37338r = ((C11934ga) iBinder).f37551a;
        if (this.f37605a.f37338r.mo38975a((C11946ka) new C11969s(this))) {
            this.f37605a.mo38866a();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37605a.f37338r = null;
    }
}
