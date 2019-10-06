package com.paypal.android.sdk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.paypal.android.sdk.wa */
public class C12019wa extends Thread {

    /* renamed from: a */
    private static final String f37797a = C12019wa.class.getSimpleName();

    /* renamed from: b */
    private final C11707Ba f37798b;

    /* renamed from: c */
    private final List f37799c = Collections.synchronizedList(new LinkedList());

    /* renamed from: d */
    private boolean f37800d;

    /* renamed from: e */
    private final C12023xa f37801e;

    public C12019wa(C11707Ba ba, C12023xa xaVar) {
        this.f37798b = ba;
        this.f37801e = xaVar;
        start();
    }

    /* renamed from: a */
    public final void mo39206a() {
        if (!this.f37800d) {
            this.f37801e.mo38828a();
            this.f37800d = true;
            synchronized (this.f37799c) {
                this.f37799c.notifyAll();
            }
            interrupt();
            while (isAlive()) {
                try {
                    Thread.sleep(10);
                    StringBuilder sb = new StringBuilder("Waiting for ");
                    sb.append(getClass().getSimpleName());
                    sb.append(" to die");
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo39207a(C11703Aa aa) {
        synchronized (this.f37799c) {
            this.f37799c.add(aa);
            new StringBuilder("Queued ").append(aa.mo38516n());
            this.f37799c.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0010 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Starting "
            r0.<init>(r1)
            java.lang.Class<com.paypal.android.sdk.wa> r1 = com.paypal.android.sdk.C12019wa.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
        L_0x0010:
            boolean r0 = r5.f37800d
            if (r0 != 0) goto L_0x0083
            r0 = 0
            java.util.List r1 = r5.f37799c
            monitor-enter(r1)
            java.util.List r2 = r5.f37799c     // Catch:{ all -> 0x0080 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x0028
            java.util.List r2 = r5.f37799c     // Catch:{ InterruptedException -> 0x0026 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0031
        L_0x0026:
            r2 = move-exception
            goto L_0x0031
        L_0x0028:
            java.util.List r0 = r5.f37799c     // Catch:{ all -> 0x0080 }
            r2 = 0
            java.lang.Object r0 = r0.remove(r2)     // Catch:{ all -> 0x0080 }
            com.paypal.android.sdk.Aa r0 = (com.paypal.android.sdk.C11703Aa) r0     // Catch:{ all -> 0x0080 }
        L_0x0031:
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0010
            java.lang.String r1 = r0.mo38503b()     // Catch:{ JSONException -> 0x0056, UnsupportedEncodingException -> 0x003c }
            r0.mo38499a(r1)     // Catch:{ JSONException -> 0x0056, UnsupportedEncodingException -> 0x003c }
            goto L_0x0072
        L_0x003c:
            r1 = move-exception
            java.lang.String r2 = "paypal.sdk"
            java.lang.String r3 = "Exception computing request"
            android.util.Log.e(r2, r3, r1)
            com.paypal.android.sdk.ca r2 = new com.paypal.android.sdk.ca
            com.paypal.android.sdk.ba r3 = com.paypal.android.sdk.C11793ba.PARSE_RESPONSE_ERROR
            java.lang.String r3 = r3.toString()
            java.lang.String r1 = r1.getMessage()
            java.lang.String r4 = "Unsupported encoding"
            r2.<init>(r3, r4, r1)
            goto L_0x006f
        L_0x0056:
            r1 = move-exception
            java.lang.String r2 = "paypal.sdk"
            java.lang.String r3 = "Exception computing request"
            android.util.Log.e(r2, r3, r1)
            com.paypal.android.sdk.ca r2 = new com.paypal.android.sdk.ca
            com.paypal.android.sdk.ba r3 = com.paypal.android.sdk.C11793ba.PARSE_RESPONSE_ERROR
            java.lang.String r3 = r3.toString()
            java.lang.String r1 = r1.getMessage()
            java.lang.String r4 = "JSON Exception in computeRequest"
            r2.<init>(r3, r4, r1)
        L_0x006f:
            r0.mo38497a(r2)
        L_0x0072:
            com.paypal.android.sdk.xa r1 = r5.f37801e
            boolean r1 = r1.mo38829a(r0)
            if (r1 != 0) goto L_0x0010
            com.paypal.android.sdk.Ba r1 = r5.f37798b
            r1.mo38529a(r0)
            goto L_0x0010
        L_0x0080:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0080 }
            throw r0
        L_0x0083:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.paypal.android.sdk.wa> r1 = com.paypal.android.sdk.C12019wa.class
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " exiting"
            r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.C12019wa.run():void");
    }
}
