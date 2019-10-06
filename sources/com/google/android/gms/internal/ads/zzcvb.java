package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcvb<T> {

    /* renamed from: a */
    private final Set<zzcva<? extends zzcuz<T>>> f27433a;

    /* renamed from: b */
    private final Executor f27434b;

    public zzcvb(Executor executor, Set<zzcva<? extends zzcuz<T>>> set) {
        this.f27434b = executor;
        this.f27433a = set;
    }

    /* renamed from: a */
    public final zzbbh<T> mo31269a(T t) {
        ArrayList arrayList = new ArrayList(this.f27433a.size());
        for (zzcva zzcva : this.f27433a) {
            zzbbh a = zzcva.mo28586a();
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23970Mb)).booleanValue()) {
                a.mo28811a(new C9087Ql(zzcva, zzk.zzln().mo27934a()), zzbbm.f25065b);
            }
            arrayList.add(a);
        }
        return zzbar.m26388b(arrayList).mo30334a(new C9107Rl(arrayList, t), this.f27434b);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.google.android.gms.internal.ads.zzbbh>, for r1v0, types: [java.util.List<com.google.android.gms.internal.ads.zzbbh>, java.util.List] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ java.lang.Object m28902a(java.util.List<com.google.android.gms.internal.ads.zzbbh> r1, java.lang.Object r2) throws java.lang.Exception {
        /*
            java.util.Iterator r1 = r1.iterator()
        L_0x0004:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r1.next()
            com.google.android.gms.internal.ads.zzbbh r0 = (com.google.android.gms.internal.ads.zzbbh) r0
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
            com.google.android.gms.internal.ads.zzcuz r0 = (com.google.android.gms.internal.ads.zzcuz) r0     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
            if (r0 == 0) goto L_0x001b
            r0.mo28065a(r2)     // Catch:{ InterruptedException -> 0x001e, ExecutionException -> 0x001c }
        L_0x001b:
            goto L_0x0004
        L_0x001c:
            r1 = move-exception
            goto L_0x001f
        L_0x001e:
            r1 = move-exception
        L_0x001f:
            java.lang.String r2 = "Derive quality signals error."
            com.google.android.gms.internal.ads.zzbad.m26356b(r2, r1)
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>(r1)
            throw r2
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcvb.m28902a(java.util.List, java.lang.Object):java.lang.Object");
    }
}
