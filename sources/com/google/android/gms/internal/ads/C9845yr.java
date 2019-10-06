package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.google.android.gms.internal.ads.yr */
final class C9845yr extends Handler {

    /* renamed from: a */
    private final /* synthetic */ C9824xr f23552a;

    C9845yr(C9824xr xrVar, Looper looper) {
        this.f23552a = xrVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.f23552a.mo29272a(message);
    }
}
