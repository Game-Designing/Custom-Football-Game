package com.mopub.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.mopub.volley.b */
/* compiled from: ExecutorDelivery */
class C11687b implements Executor {

    /* renamed from: a */
    final /* synthetic */ Handler f36466a;

    /* renamed from: b */
    final /* synthetic */ ExecutorDelivery f36467b;

    C11687b(ExecutorDelivery this$0, Handler handler) {
        this.f36467b = this$0;
        this.f36466a = handler;
    }

    public void execute(Runnable command) {
        this.f36466a.post(command);
    }
}
