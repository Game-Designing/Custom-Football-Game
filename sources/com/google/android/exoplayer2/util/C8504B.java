package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.google.android.exoplayer2.util.B */
/* compiled from: SystemHandlerWrapper */
final class C8504B implements C8525m {

    /* renamed from: a */
    private final Handler f18777a;

    public C8504B(Handler handler) {
        this.f18777a = handler;
    }

    /* renamed from: a */
    public Looper mo26039a() {
        return this.f18777a.getLooper();
    }

    /* renamed from: a */
    public Message mo26042a(int what, Object obj) {
        return this.f18777a.obtainMessage(what, obj);
    }

    /* renamed from: a */
    public Message mo26040a(int what, int arg1, int arg2) {
        return this.f18777a.obtainMessage(what, arg1, arg2);
    }

    /* renamed from: a */
    public Message mo26041a(int what, int arg1, int arg2, Object obj) {
        return this.f18777a.obtainMessage(what, arg1, arg2, obj);
    }

    /* renamed from: a */
    public boolean mo26043a(int what) {
        return this.f18777a.sendEmptyMessage(what);
    }

    /* renamed from: a */
    public boolean mo26044a(int what, long uptimeMs) {
        return this.f18777a.sendEmptyMessageAtTime(what, uptimeMs);
    }

    /* renamed from: b */
    public void mo26045b(int what) {
        this.f18777a.removeMessages(what);
    }
}
