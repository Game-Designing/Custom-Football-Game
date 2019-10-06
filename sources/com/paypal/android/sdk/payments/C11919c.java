package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.paypal.android.sdk.payments.c */
class C11919c {

    /* renamed from: a */
    private static final String f37516a = C11919c.class.getSimpleName();

    /* renamed from: b */
    private static final Object f37517b = new Object();

    /* renamed from: c */
    private static C11919c f37518c;

    /* renamed from: d */
    private final Context f37519d;

    /* renamed from: e */
    private final HashMap f37520e = new HashMap();

    /* renamed from: f */
    private final HashMap f37521f = new HashMap();

    /* renamed from: g */
    private final ArrayList f37522g = new ArrayList();

    /* renamed from: h */
    private final Handler f37523h;

    private C11919c(Context context) {
        this.f37519d = context;
        this.f37523h = new C11922d(this, context.getMainLooper());
    }

    /* renamed from: a */
    public static C11919c m39521a(Context context) {
        C11919c cVar;
        synchronized (f37517b) {
            if (f37518c == null) {
                f37518c = new C11919c(context.getApplicationContext());
            }
            cVar = f37518c;
        }
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r3 = r1[r2];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r4 >= r3.f37543b.size()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        ((com.paypal.android.sdk.payments.C11930f) r3.f37543b.get(r4)).f37547b.onReceive(r8.f37519d, r3.f37542a);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r2 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m39522a(com.paypal.android.sdk.payments.C11919c r8) {
        /*
        L_0x0000:
            java.util.HashMap r0 = r8.f37520e
            monitor-enter(r0)
            java.util.ArrayList r1 = r8.f37522g     // Catch:{ all -> 0x0041 }
            int r1 = r1.size()     // Catch:{ all -> 0x0041 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x000d:
            com.paypal.android.sdk.payments.e[] r1 = new com.paypal.android.sdk.payments.C11927e[r1]     // Catch:{ all -> 0x0041 }
            java.util.ArrayList r2 = r8.f37522g     // Catch:{ all -> 0x0041 }
            r2.toArray(r1)     // Catch:{ all -> 0x0041 }
            java.util.ArrayList r2 = r8.f37522g     // Catch:{ all -> 0x0041 }
            r2.clear()     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            r0 = 0
            r2 = 0
        L_0x001c:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0000
            r3 = r1[r2]
            r4 = 0
        L_0x0022:
            java.util.ArrayList r5 = r3.f37543b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x003e
            java.util.ArrayList r5 = r3.f37543b
            java.lang.Object r5 = r5.get(r4)
            com.paypal.android.sdk.payments.f r5 = (com.paypal.android.sdk.payments.C11930f) r5
            android.content.BroadcastReceiver r5 = r5.f37547b
            android.content.Context r6 = r8.f37519d
            android.content.Intent r7 = r3.f37542a
            r5.onReceive(r6, r7)
            int r4 = r4 + 1
            goto L_0x0022
        L_0x003e:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0041:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0044:
            throw r8
        L_0x0045:
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.C11919c.m39522a(com.paypal.android.sdk.payments.c):void");
    }

    /* renamed from: a */
    public final void mo39081a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f37520e) {
            ArrayList arrayList = (ArrayList) this.f37520e.remove(broadcastReceiver);
            if (arrayList != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    IntentFilter intentFilter = (IntentFilter) arrayList.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList arrayList2 = (ArrayList) this.f37521f.get(action);
                        if (arrayList2 != null) {
                            int i3 = 0;
                            while (i3 < arrayList2.size()) {
                                if (((C11930f) arrayList2.get(i3)).f37547b == broadcastReceiver) {
                                    arrayList2.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList2.size() <= 0) {
                                this.f37521f.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo39082a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f37520e) {
            C11930f fVar = new C11930f(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f37520e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f37520e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.f37521f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f37521f.put(action, arrayList2);
                }
                arrayList2.add(fVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0130, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0133, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo39083a(android.content.Intent r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.util.HashMap r2 = r1.f37520e
            monitor-enter(r2)
            java.lang.String r10 = r23.getAction()     // Catch:{ all -> 0x0134 }
            android.content.Context r3 = r1.f37519d     // Catch:{ all -> 0x0134 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0134 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0134 }
            android.net.Uri r12 = r23.getData()     // Catch:{ all -> 0x0134 }
            java.lang.String r13 = r23.getScheme()     // Catch:{ all -> 0x0134 }
            java.util.Set r14 = r23.getCategories()     // Catch:{ all -> 0x0134 }
            int r3 = r23.getFlags()     // Catch:{ all -> 0x0134 }
            r3 = r3 & 8
            r9 = 1
            if (r3 == 0) goto L_0x002d
            r16 = 1
            goto L_0x002f
        L_0x002d:
            r16 = 0
        L_0x002f:
            if (r16 == 0) goto L_0x004b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Resolving type "
            r3.<init>(r4)     // Catch:{ all -> 0x0134 }
            r3.append(r11)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = " scheme "
            r3.append(r4)     // Catch:{ all -> 0x0134 }
            r3.append(r13)     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = " of intent "
            r3.append(r4)     // Catch:{ all -> 0x0134 }
            r3.append(r0)     // Catch:{ all -> 0x0134 }
        L_0x004b:
            java.util.HashMap r3 = r1.f37521f     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = r23.getAction()     // Catch:{ all -> 0x0134 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0134 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0134 }
            if (r8 == 0) goto L_0x0131
            if (r16 == 0) goto L_0x0066
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Action list: "
            r3.<init>(r4)     // Catch:{ all -> 0x0134 }
            r3.append(r8)     // Catch:{ all -> 0x0134 }
        L_0x0066:
            r3 = 0
            r6 = r3
            r7 = 0
        L_0x0069:
            int r3 = r8.size()     // Catch:{ all -> 0x0134 }
            if (r7 >= r3) goto L_0x0101
            java.lang.Object r3 = r8.get(r7)     // Catch:{ all -> 0x0134 }
            r5 = r3
            com.paypal.android.sdk.payments.f r5 = (com.paypal.android.sdk.payments.C11930f) r5     // Catch:{ all -> 0x0134 }
            if (r16 == 0) goto L_0x0084
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r4 = "Matching against filter "
            r3.<init>(r4)     // Catch:{ all -> 0x0134 }
            android.content.IntentFilter r4 = r5.f37546a     // Catch:{ all -> 0x0134 }
            r3.append(r4)     // Catch:{ all -> 0x0134 }
        L_0x0084:
            boolean r3 = r5.f37548c     // Catch:{ all -> 0x0134 }
            if (r3 == 0) goto L_0x0094
            r19 = r7
            r20 = r8
            r18 = r10
            r21 = r11
            r11 = 1
            r10 = r6
            goto L_0x00f5
        L_0x0094:
            android.content.IntentFilter r3 = r5.f37546a     // Catch:{ all -> 0x0134 }
            java.lang.String r17 = "ClonedLocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r18 = r10
            r10 = r6
            r6 = r13
            r19 = r7
            r7 = r12
            r20 = r8
            r8 = r14
            r21 = r11
            r11 = 1
            r9 = r17
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0134 }
            if (r3 < 0) goto L_0x00cf
            if (r16 == 0) goto L_0x00c0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "  Filter matched!  match=0x"
            r4.<init>(r5)     // Catch:{ all -> 0x0134 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0134 }
            r4.append(r3)     // Catch:{ all -> 0x0134 }
        L_0x00c0:
            if (r10 != 0) goto L_0x00c8
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0134 }
            r6.<init>()     // Catch:{ all -> 0x0134 }
            goto L_0x00c9
        L_0x00c8:
            r6 = r10
        L_0x00c9:
            r6.add(r15)     // Catch:{ all -> 0x0134 }
            r15.f37548c = r11     // Catch:{ all -> 0x0134 }
            goto L_0x00f6
        L_0x00cf:
            if (r16 == 0) goto L_0x00f5
            r4 = -4
            if (r3 == r4) goto L_0x00e9
            r4 = -3
            if (r3 == r4) goto L_0x00e6
            r4 = -2
            if (r3 == r4) goto L_0x00e3
            r4 = -1
            if (r3 == r4) goto L_0x00e0
            java.lang.String r3 = "unknown reason"
            goto L_0x00eb
        L_0x00e0:
            java.lang.String r3 = "type"
            goto L_0x00eb
        L_0x00e3:
            java.lang.String r3 = "data"
            goto L_0x00eb
        L_0x00e6:
            java.lang.String r3 = "action"
            goto L_0x00eb
        L_0x00e9:
            java.lang.String r3 = "category"
        L_0x00eb:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
            java.lang.String r5 = "  Filter did not match: "
            r4.<init>(r5)     // Catch:{ all -> 0x0134 }
            r4.append(r3)     // Catch:{ all -> 0x0134 }
        L_0x00f5:
            r6 = r10
        L_0x00f6:
            int r7 = r19 + 1
            r10 = r18
            r8 = r20
            r11 = r21
            r9 = 1
            goto L_0x0069
        L_0x0101:
            r10 = r6
            r11 = 1
            if (r10 == 0) goto L_0x0131
            r3 = 0
        L_0x0106:
            int r4 = r10.size()     // Catch:{ all -> 0x0134 }
            if (r3 >= r4) goto L_0x0118
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0134 }
            com.paypal.android.sdk.payments.f r4 = (com.paypal.android.sdk.payments.C11930f) r4     // Catch:{ all -> 0x0134 }
            r5 = 0
            r4.f37548c = r5     // Catch:{ all -> 0x0134 }
            int r3 = r3 + 1
            goto L_0x0106
        L_0x0118:
            java.util.ArrayList r3 = r1.f37522g     // Catch:{ all -> 0x0134 }
            com.paypal.android.sdk.payments.e r4 = new com.paypal.android.sdk.payments.e     // Catch:{ all -> 0x0134 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0134 }
            r3.add(r4)     // Catch:{ all -> 0x0134 }
            android.os.Handler r0 = r1.f37523h     // Catch:{ all -> 0x0134 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0134 }
            if (r0 != 0) goto L_0x012f
            android.os.Handler r0 = r1.f37523h     // Catch:{ all -> 0x0134 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0134 }
        L_0x012f:
            monitor-exit(r2)     // Catch:{ all -> 0x0134 }
            return r11
        L_0x0131:
            monitor-exit(r2)     // Catch:{ all -> 0x0134 }
            r0 = 0
            return r0
        L_0x0134:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0134 }
            goto L_0x0138
        L_0x0137:
            throw r0
        L_0x0138:
            goto L_0x0137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.C11919c.mo39083a(android.content.Intent):boolean");
    }
}
