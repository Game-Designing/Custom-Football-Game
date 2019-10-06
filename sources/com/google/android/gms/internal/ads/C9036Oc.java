package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Oc */
final /* synthetic */ class C9036Oc implements Runnable {

    /* renamed from: a */
    private final zzbbr f21531a;

    /* renamed from: b */
    private final zzbam f21532b;

    /* renamed from: c */
    private final zzbbh f21533c;

    C9036Oc(zzbbr zzbbr, zzbam zzbam, zzbbh zzbbh) {
        this.f21531a = zzbbr;
        this.f21532b = zzbam;
        this.f21533c = zzbbh;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbbr r0 = r3.f21531a
            com.google.android.gms.internal.ads.zzbam r1 = r3.f21532b
            com.google.android.gms.internal.ads.zzbbh r2 = r3.f21533c
            java.lang.Object r2 = r2.get()     // Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
            java.lang.Object r1 = r1.apply(r2)     // Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
            r0.mo30338b(r1)     // Catch:{ CancellationException -> 0x0030, ExecutionException -> 0x0023, InterruptedException -> 0x0017, Exception -> 0x0012 }
            return
        L_0x0012:
            r1 = move-exception
            r0.mo30337a(r1)
            return
        L_0x0017:
            r1 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            r0.mo30337a(r1)
            return
        L_0x0023:
            r1 = move-exception
            java.lang.Throwable r2 = r1.getCause()
            if (r2 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            r0.mo30337a(r1)
            return
        L_0x0030:
            r1 = move-exception
            r1 = 1
            r0.cancel(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9036Oc.run():void");
    }
}
