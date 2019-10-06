package com.fyber.inneractive.sdk.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.fyber.inneractive.sdk.util.h */
public final class C8003h<T> {

    /* renamed from: a */
    private final Queue<T> f16332a = new ConcurrentLinkedQueue();

    /* renamed from: b */
    private C8004a<T> f16333b;

    /* renamed from: com.fyber.inneractive.sdk.util.h$a */
    public interface C8004a<TT> {
        /* renamed from: a */
        TT mo24843a();
    }

    public C8003h(C8004a<T> aVar) {
        for (int i = 0; i < 16; i++) {
            this.f16332a.offer(aVar.mo24843a());
        }
        this.f16333b = aVar;
    }

    /* renamed from: a */
    public final T mo24841a() {
        T poll = this.f16332a.poll();
        return poll == null ? this.f16333b.mo24843a() : poll;
    }

    /* renamed from: a */
    public final void mo24842a(T t) {
        this.f16332a.offer(t);
    }
}
