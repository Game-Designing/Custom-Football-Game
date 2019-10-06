package com.fyber.inneractive.sdk.p166g.p167a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fyber.inneractive.sdk.util.C8017o;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.fyber.inneractive.sdk.g.a.g */
final class C7783g extends Handler {

    /* renamed from: a */
    private final WeakReference<C7784h> f15649a;

    C7783g(Looper looper, C7784h hVar) {
        super(looper);
        this.f15649a = new WeakReference<>(hVar);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        C7784h hVar = (C7784h) C8017o.m18094a((Reference<T>) this.f15649a);
        if (hVar != null) {
            hVar.mo24393a(message);
        }
    }
}
