package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.load.engine.H */
/* compiled from: ResourceRecycler */
class C6240H {

    /* renamed from: a */
    private boolean f11040a;

    /* renamed from: b */
    private final Handler f11041b = new Handler(Looper.getMainLooper(), new C6241a());

    /* renamed from: com.bumptech.glide.load.engine.H$a */
    /* compiled from: ResourceRecycler */
    private static final class C6241a implements Callback {
        C6241a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((C6236E) message.obj).mo18969b();
            return true;
        }
    }

    C6240H() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19117a(C6236E<?> resource) {
        C6026k.m11283b();
        if (this.f11040a) {
            this.f11041b.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.f11040a = true;
        resource.mo18969b();
        this.f11040a = false;
    }
}
