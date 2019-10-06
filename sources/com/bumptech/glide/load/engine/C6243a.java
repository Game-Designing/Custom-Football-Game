package com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.bumptech.glide.load.engine.a */
/* compiled from: ActiveResources */
class C6243a implements Callback {

    /* renamed from: a */
    final /* synthetic */ C6291c f11049a;

    C6243a(C6291c this$0) {
        this.f11049a = this$0;
    }

    public boolean handleMessage(Message msg) {
        if (msg.what != 1) {
            return false;
        }
        this.f11049a.mo19201a((C6293b) msg.obj);
        return true;
    }
}
