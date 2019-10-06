package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.d */
final class C10046d<TResult> implements C10048f<TResult> {

    /* renamed from: a */
    private final Executor f30624a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f30625b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnSuccessListener<? super TResult> f30626c;

    public C10046d(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f30624a = executor;
        this.f30626c = onSuccessListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r2.f30624a.execute(new com.google.android.gms.tasks.C10047e(r2, r3));
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo33186a(com.google.android.gms.tasks.Task<TResult> r3) {
        /*
            r2 = this;
            boolean r0 = r3.mo33179d()
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = r2.f30625b
            monitor-enter(r0)
            com.google.android.gms.tasks.OnSuccessListener<? super TResult> r1 = r2.f30626c     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            java.util.concurrent.Executor r0 = r2.f30624a
            com.google.android.gms.tasks.e r1 = new com.google.android.gms.tasks.e
            r1.<init>(r2, r3)
            r0.execute(r1)
            goto L_0x001e
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r3
        L_0x001e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.C10046d.mo33186a(com.google.android.gms.tasks.Task):void");
    }
}
