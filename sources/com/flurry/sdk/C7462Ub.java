package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.sdk.Ub */
public final class C7462Ub {

    /* renamed from: a */
    private static C7462Ub f14706a = null;

    /* renamed from: b */
    private final C7426Nb<String, C7584qc<C7452Sb<?>>> f14707b = new C7426Nb<>();

    /* renamed from: c */
    private final C7426Nb<C7584qc<C7452Sb<?>>, String> f14708c = new C7426Nb<>();

    private C7462Ub() {
    }

    /* renamed from: a */
    public static synchronized C7462Ub m16528a() {
        C7462Ub ub;
        synchronized (C7462Ub.class) {
            if (f14706a == null) {
                f14706a = new C7462Ub();
            }
            ub = f14706a;
        }
        return ub;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo23910a(java.lang.String r3, com.flurry.sdk.C7452Sb<?> r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x002e
            if (r4 != 0) goto L_0x000a
            goto L_0x002e
        L_0x000a:
            com.flurry.sdk.qc r0 = new com.flurry.sdk.qc     // Catch:{ all -> 0x0030 }
            r0.<init>(r4)     // Catch:{ all -> 0x0030 }
            com.flurry.sdk.Nb<java.lang.String, com.flurry.sdk.qc<com.flurry.sdk.Sb<?>>> r4 = r2.f14707b     // Catch:{ all -> 0x0030 }
            r1 = 0
            java.util.List r4 = r4.mo23864a(r3, r1)     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x001d
            boolean r1 = r4.contains(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x001e
        L_0x001d:
        L_0x001e:
            if (r1 == 0) goto L_0x0022
            monitor-exit(r2)
            return
        L_0x0022:
            com.flurry.sdk.Nb<java.lang.String, com.flurry.sdk.qc<com.flurry.sdk.Sb<?>>> r4 = r2.f14707b     // Catch:{ all -> 0x0030 }
            r4.mo23866a(r3, r0)     // Catch:{ all -> 0x0030 }
            com.flurry.sdk.Nb<com.flurry.sdk.qc<com.flurry.sdk.Sb<?>>, java.lang.String> r4 = r2.f14708c     // Catch:{ all -> 0x0030 }
            r4.mo23866a(r0, r3)     // Catch:{ all -> 0x0030 }
            monitor-exit(r2)
            return
        L_0x002e:
            monitor-exit(r2)
            return
        L_0x0030:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7462Ub.mo23910a(java.lang.String, com.flurry.sdk.Sb):void");
    }

    /* renamed from: b */
    public final synchronized void mo23911b(String str, C7452Sb<?> sb) {
        if (!TextUtils.isEmpty(str)) {
            C7584qc qcVar = new C7584qc(sb);
            this.f14707b.mo23869b(str, qcVar);
            this.f14708c.mo23869b(qcVar, str);
        }
    }

    /* renamed from: a */
    public final synchronized void mo23909a(C7452Sb<?> sb) {
        if (sb != null) {
            C7584qc qcVar = new C7584qc(sb);
            for (String b : this.f14708c.mo23863a(qcVar)) {
                this.f14707b.mo23869b(b, qcVar);
            }
            this.f14708c.mo23868b(qcVar);
        }
    }

    /* renamed from: a */
    public final void mo23908a(C7447Rb rb) {
        for (C7452Sb tb : m16529a(rb.mo23884a())) {
            C7379Fb.m16300a().mo23817b(new C7457Tb(this, tb, rb));
        }
    }

    /* renamed from: a */
    private synchronized List<C7452Sb<?>> m16529a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f14707b.mo23863a(str).iterator();
        while (it.hasNext()) {
            C7452Sb sb = (C7452Sb) ((C7584qc) it.next()).get();
            if (sb == null) {
                it.remove();
            } else {
                arrayList.add(sb);
            }
        }
        return arrayList;
    }
}
