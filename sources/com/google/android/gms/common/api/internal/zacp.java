package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp {

    /* renamed from: a */
    public static final Status f19880a = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: b */
    private static final BasePendingResult<?>[] f19881b = new BasePendingResult[0];
    @VisibleForTesting

    /* renamed from: c */
    final Set<BasePendingResult<?>> f19882c = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: d */
    private final C8646L f19883d = new C8644J(this);

    /* renamed from: e */
    private final Map<AnyClientKey<?>, Client> f19884e;

    public zacp(Map<AnyClientKey<?>, Client> map) {
        this.f19884e = map;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo27621a(BasePendingResult<? extends Result> basePendingResult) {
        this.f19882c.add(basePendingResult);
        basePendingResult.mo27452a(this.f19883d);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.internal.L, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.J] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.internal.L, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.J]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [com.google.android.gms.common.api.internal.L, com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.J]
      mth insns count: 48
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27620a() {
        /*
            r8 = this;
            java.util.Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> r0 = r8.f19882c
            com.google.android.gms.common.api.internal.BasePendingResult<?>[] r1 = f19881b
            java.lang.Object[] r0 = r0.toArray(r1)
            com.google.android.gms.common.api.internal.BasePendingResult[] r0 = (com.google.android.gms.common.api.internal.BasePendingResult[]) r0
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000d:
            if (r3 >= r1) goto L_0x008b
            r4 = r0[r3]
            r5 = 0
            r4.mo27452a(r5)
            java.lang.Integer r6 = r4.mo27456d()
            if (r6 != 0) goto L_0x0027
            boolean r5 = r4.mo27457e()
            if (r5 == 0) goto L_0x0088
            java.util.Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> r5 = r8.f19882c
            r5.remove(r4)
            goto L_0x0088
        L_0x0027:
            r4.mo27402a(r5)
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.api.Api$Client> r6 = r8.f19884e
            r7 = r4
            com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl r7 = (com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl) r7
            com.google.android.gms.common.api.Api$AnyClientKey r7 = r7.mo27450h()
            java.lang.Object r6 = r6.get(r7)
            com.google.android.gms.common.api.Api$Client r6 = (com.google.android.gms.common.api.Api.Client) r6
            android.os.IBinder r6 = r6.getServiceBrokerBinder()
            boolean r7 = r4.mo27455c()
            if (r7 == 0) goto L_0x004e
            com.google.android.gms.common.api.internal.K r7 = new com.google.android.gms.common.api.internal.K
            r7.<init>(r4, r5, r6, r5)
            r4.mo27452a(r7)
            goto L_0x0083
        L_0x004e:
            if (r6 == 0) goto L_0x0072
            boolean r7 = r6.isBinderAlive()
            if (r7 == 0) goto L_0x0072
            com.google.android.gms.common.api.internal.K r7 = new com.google.android.gms.common.api.internal.K
            r7.<init>(r4, r5, r6, r5)
            r4.mo27452a(r7)
            r6.linkToDeath(r7, r2)     // Catch:{ RemoteException -> 0x0062 }
            goto L_0x0083
        L_0x0062:
            r6 = move-exception
            r4.mo27350a()
            java.lang.Integer r6 = r4.mo27456d()
            int r6 = r6.intValue()
            r5.mo27646a(r6)
            goto L_0x0083
        L_0x0072:
            r4.mo27452a(r5)
            r4.mo27350a()
            java.lang.Integer r6 = r4.mo27456d()
            int r6 = r6.intValue()
            r5.mo27646a(r6)
        L_0x0083:
            java.util.Set<com.google.android.gms.common.api.internal.BasePendingResult<?>> r5 = r8.f19882c
            r5.remove(r4)
        L_0x0088:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacp.mo27620a():void");
    }

    /* renamed from: b */
    public final void mo27622b() {
        for (BasePendingResult b : (BasePendingResult[]) this.f19882c.toArray(f19881b)) {
            b.mo27453b(f19880a);
        }
    }
}
