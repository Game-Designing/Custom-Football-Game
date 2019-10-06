package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* renamed from: com.google.android.gms.common.api.internal.u */
final class C8681u extends zap {

    /* renamed from: b */
    private final /* synthetic */ zaaw f19778b;

    C8681u(zaaw zaaw, Looper looper) {
        this.f19778b = zaaw;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f19778b.m21493q();
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            this.f19778b.m21491o();
        }
    }
}
