package com.smaato.soma.p239c.p242c;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12322e;
import com.smaato.soma.C12367f;

/* renamed from: com.smaato.soma.c.c.a */
/* compiled from: AdDispatcher */
class C12188a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12322e f38212a;

    /* renamed from: b */
    final /* synthetic */ C12064Na f38213b;

    /* renamed from: c */
    final /* synthetic */ C12189b f38214c;

    C12188a(C12189b this$0, C12322e eVar, C12064Na na) {
        this.f38214c = this$0;
        this.f38212a = eVar;
        this.f38213b = na;
    }

    public void run() {
        synchronized (this.f38214c.f38216b) {
            for (C12367f listener : this.f38214c.f38216b) {
                listener.onReceiveAd(this.f38212a, this.f38213b);
            }
        }
    }
}
