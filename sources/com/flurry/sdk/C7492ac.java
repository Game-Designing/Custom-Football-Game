package com.flurry.sdk;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

/* renamed from: com.flurry.sdk.ac */
class C7492ac extends DiscardPolicy {

    /* renamed from: a */
    final /* synthetic */ C7502cc f14749a;

    C7492ac(C7502cc ccVar) {
        this.f14749a = ccVar;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        super.rejectedExecution(runnable, threadPoolExecutor);
        C7376Ed a = C7502cc.m16604a(runnable);
        if (a != null) {
            synchronized (this.f14749a.f14777d) {
                this.f14749a.f14777d.remove(a);
            }
            this.f14749a.m16606a(a);
            new C7487_b(this, a).run();
        }
    }
}
