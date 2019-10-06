package com.fyber.inneractive.sdk.p166g.p167a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.webkit.MimeTypeMap;
import com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7762a;
import com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7766d;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.realm.internal.Collection;

/* renamed from: com.fyber.inneractive.sdk.g.a.e */
public final class C7771e implements C7784h {

    /* renamed from: a */
    String f15616a;

    /* renamed from: b */
    C7759c f15617b;

    /* renamed from: c */
    C7766d f15618c;

    /* renamed from: d */
    final String f15619d;

    /* renamed from: e */
    C7756a f15620e;

    /* renamed from: f */
    C7781e f15621f;

    /* renamed from: g */
    C7778b f15622g;

    /* renamed from: h */
    public Handler f15623h;

    /* renamed from: i */
    final Object f15624i = new Object();

    /* renamed from: j */
    String f15625j;

    /* renamed from: k */
    boolean f15626k = false;

    /* renamed from: l */
    boolean f15627l = false;

    /* renamed from: m */
    public boolean f15628m = false;

    /* renamed from: n */
    public C7780d f15629n;

    /* renamed from: o */
    private C7757b f15630o;

    /* renamed from: p */
    private HandlerThread f15631p;

    /* renamed from: q */
    private Handler f15632q;

    /* renamed from: r */
    private volatile boolean f15633r = false;

    /* renamed from: s */
    private String f15634s = null;

    /* renamed from: com.fyber.inneractive.sdk.g.a.e$a */
    private static class C7777a extends Exception {
        public C7777a() {
        }

        public C7777a(String str) {
            super(str);
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.e$b */
    private class C7778b extends Thread {

        /* renamed from: a */
        AtomicBoolean f15641a = new AtomicBoolean(false);

        /* renamed from: c */
        private InputStream f15643c;

        /* renamed from: d */
        private boolean f15644d = false;

        /* renamed from: e */
        private boolean f15645e = false;

        /* renamed from: f */
        private long f15646f = -1;

        /* renamed from: g */
        private long f15647g = 0;

        /* renamed from: h */
        private C7762a f15648h;

        C7778b(String str) {
            super(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x0238 A[SYNTHETIC, Splitter:B:105:0x0238] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r18 = this;
                r7 = r18
                r8 = 2
                java.lang.Object[] r0 = new java.lang.Object[r8]
                com.fyber.inneractive.sdk.g.a.e r1 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r2 = r1.f15616a
                r9 = 0
                r0[r9] = r2
                java.lang.String r1 = r1.mo24397d()
                r10 = 1
                r0[r10] = r1
                java.lang.String r1 = "%s | Starting a fresh download for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)
                com.fyber.inneractive.sdk.util.c r0 = com.fyber.inneractive.sdk.util.C7996c.m18038a()
                java.nio.ByteBuffer r11 = r0.mo24838b()
                r1 = 0
                java.net.URL r12 = new java.net.URL     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r0 = r0.f15619d     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                r12.<init>(r0)     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r0 = "%s | opening an editor for %s"
                java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r3 = r3.f15616a     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                r2[r9] = r3     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r3 = r3.mo24397d()     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                r2[r10] = r3     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.c r0 = r0.f15617b     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.lang.String r2 = r2.mo24397d()     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.c$a r0 = r0.mo24368c(r2)     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                r7.f15648h = r0     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                com.fyber.inneractive.sdk.g.a.c$a r0 = r7.f15648h     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                java.io.OutputStream r13 = r0.mo24375a()     // Catch:{ Throwable -> 0x01f4, all -> 0x01ef }
                r0 = 9
                r14 = r1
                r1 = 9
            L_0x0064:
                if (r1 <= 0) goto L_0x00de
                java.util.concurrent.atomic.AtomicBoolean r0 = r7.f15641a     // Catch:{ Throwable -> 0x01ed }
                boolean r0 = r0.compareAndSet(r9, r9)     // Catch:{ Throwable -> 0x01ed }
                if (r0 == 0) goto L_0x00de
                if (r14 == 0) goto L_0x0076
                r14.disconnect()     // Catch:{ Throwable -> 0x0074 }
            L_0x0073:
                goto L_0x0076
            L_0x0074:
                r0 = move-exception
                goto L_0x0073
            L_0x0076:
                int r15 = r1 + -1
                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01ed }
                long r5 = r7.f15646f     // Catch:{ c -> 0x00dc, Throwable -> 0x0089 }
                r1 = r18
                r2 = r13
                r3 = r12
                r4 = r11
                java.net.HttpURLConnection r0 = r1.m17277a(r2, r3, r4, r5)     // Catch:{ c -> 0x00dc, Throwable -> 0x0089 }
                r14 = r0
                goto L_0x008a
            L_0x0089:
                r0 = move-exception
            L_0x008a:
                java.io.InputStream r0 = r7.f15643c     // Catch:{ Throwable -> 0x01ed }
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r0)     // Catch:{ Throwable -> 0x01ed }
                java.lang.String r0 = "%s Downloaded %d out of %d for key %s"
                r1 = 4
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x01ed }
                com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                java.lang.String r2 = r2.f15616a     // Catch:{ Throwable -> 0x01ed }
                r1[r9] = r2     // Catch:{ Throwable -> 0x01ed }
                long r2 = r7.f15646f     // Catch:{ Throwable -> 0x01ed }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x01ed }
                r1[r10] = r2     // Catch:{ Throwable -> 0x01ed }
                long r2 = r7.f15647g     // Catch:{ Throwable -> 0x01ed }
                java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Throwable -> 0x01ed }
                r1[r8] = r2     // Catch:{ Throwable -> 0x01ed }
                r2 = 3
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                java.lang.String r3 = r3.mo24397d()     // Catch:{ Throwable -> 0x01ed }
                r1[r2] = r3     // Catch:{ Throwable -> 0x01ed }
                java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ Throwable -> 0x01ed }
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)     // Catch:{ Throwable -> 0x01ed }
                long r0 = r7.f15646f     // Catch:{ Throwable -> 0x01ed }
                long r2 = r7.f15647g     // Catch:{ Throwable -> 0x01ed }
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L_0x00c4
                r1 = 0
                goto L_0x0064
            L_0x00c4:
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01ed }
                long r0 = r0 - r16
                r2 = 500(0x1f4, double:2.47E-321)
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x00da
                long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x01ed }
                long r0 = r0 - r16
                long r2 = r2 - r0
                java.lang.Thread.sleep(r2)     // Catch:{ Throwable -> 0x01ed }
            L_0x00da:
                r1 = r15
                goto L_0x0064
            L_0x00dc:
                r0 = move-exception
                throw r0     // Catch:{ Throwable -> 0x01ed }
            L_0x00de:
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                java.lang.Object r1 = r0.f15624i     // Catch:{ Throwable -> 0x01ed }
                monitor-enter(r1)     // Catch:{ Throwable -> 0x01ed }
                long r2 = r7.f15647g     // Catch:{ all -> 0x01ea }
                long r4 = r7.f15646f     // Catch:{ all -> 0x01ea }
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x0185
                java.util.concurrent.atomic.AtomicBoolean r0 = r7.f15641a     // Catch:{ all -> 0x01ea }
                boolean r0 = r0.compareAndSet(r10, r10)     // Catch:{ all -> 0x01ea }
                if (r0 == 0) goto L_0x00f5
                goto L_0x0185
            L_0x00f5:
                java.lang.String r0 = "%s | committing to cache - %s"
                java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r3 = r3.f15616a     // Catch:{ all -> 0x01ea }
                r2[r9] = r3     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r3 = r3.mo24397d()     // Catch:{ all -> 0x01ea }
                r2[r10] = r3     // Catch:{ all -> 0x01ea }
                java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r13)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.a r0 = r0.f15620e     // Catch:{ all -> 0x01ea }
                if (r0 == 0) goto L_0x0160
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.a r0 = r0.f15620e     // Catch:{ all -> 0x01ea }
                java.lang.Object r2 = r0.f15556e     // Catch:{ all -> 0x01ea }
                monitor-enter(r2)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.c$a r0 = r7.f15648h     // Catch:{ all -> 0x015d }
                boolean r3 = r0.f15585c     // Catch:{ all -> 0x015d }
                if (r3 == 0) goto L_0x0133
                com.fyber.inneractive.sdk.g.a.c r3 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x015d }
                r3.m17226a(r0, r9)     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.c r3 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.c$b r4 = r0.f15583a     // Catch:{ all -> 0x015d }
                java.lang.String r4 = r4.f15589a     // Catch:{ all -> 0x015d }
                r3.mo24372d(r4)     // Catch:{ all -> 0x015d }
                goto L_0x0138
            L_0x0133:
                com.fyber.inneractive.sdk.g.a.c r3 = com.fyber.inneractive.sdk.p166g.p167a.C7759c.this     // Catch:{ all -> 0x015d }
                r3.m17226a(r0, r10)     // Catch:{ all -> 0x015d }
            L_0x0138:
                r0.f15586d = r10     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.c r0 = r0.f15617b     // Catch:{ all -> 0x015d }
                r0.mo24369c()     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.a r0 = r0.f15620e     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.c r3 = r3.f15617b     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.e r4 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x015d }
                java.lang.String r4 = r4.mo24397d()     // Catch:{ all -> 0x015d }
                java.io.File r3 = r3.mo24366b(r4)     // Catch:{ all -> 0x015d }
                r0.f15552a = r3     // Catch:{ all -> 0x015d }
                monitor-exit(r2)     // Catch:{ all -> 0x015d }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.a r0 = r0.f15620e     // Catch:{ all -> 0x01ea }
                r0.f15554c = r9     // Catch:{ all -> 0x01ea }
                goto L_0x01b0
            L_0x015d:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x015d }
                throw r0     // Catch:{ all -> 0x01ea }
            L_0x0160:
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r2 = r2.mo24397d()     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r3 = r3.f15619d     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r4 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.c r4 = r4.f15617b     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r5 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r5 = r5.mo24397d()     // Catch:{ all -> 0x01ea }
                java.io.File r4 = r4.mo24366b(r5)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r5 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r5 = r5.f15625j     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.a r2 = com.fyber.inneractive.sdk.p166g.p167a.C7756a.m17218a(r2, r3, r4, r10, r5)     // Catch:{ all -> 0x01ea }
                r0.f15620e = r2     // Catch:{ all -> 0x01ea }
                goto L_0x01b0
            L_0x0185:
                com.fyber.inneractive.sdk.g.a.c$a r0 = r7.f15648h     // Catch:{ all -> 0x01ea }
                r0.mo24376b()     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.c r0 = r0.f15617b     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r2 = r2.mo24397d()     // Catch:{ all -> 0x01ea }
                r0.mo24372d(r2)     // Catch:{ all -> 0x01ea }
                java.lang.String r0 = "%s | aborting cache - %s"
                java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r3 = r3.f15616a     // Catch:{ all -> 0x01ea }
                r2[r9] = r3     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x01ea }
                java.lang.String r3 = r3.mo24397d()     // Catch:{ all -> 0x01ea }
                r2[r10] = r3     // Catch:{ all -> 0x01ea }
                java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r0)     // Catch:{ all -> 0x01ea }
            L_0x01b0:
                monitor-exit(r1)     // Catch:{ all -> 0x01ea }
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                r0.f15628m = r9     // Catch:{ Throwable -> 0x01ed }
                if (r14 == 0) goto L_0x01ba
                r14.disconnect()     // Catch:{ Throwable -> 0x01ed }
            L_0x01ba:
                java.util.concurrent.atomic.AtomicBoolean r0 = r7.f15641a     // Catch:{ Throwable -> 0x01ed }
                boolean r0 = r0.compareAndSet(r9, r9)     // Catch:{ Throwable -> 0x01ed }
                if (r0 == 0) goto L_0x01d7
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                android.os.Handler r0 = r0.f15623h     // Catch:{ Throwable -> 0x01ed }
                if (r0 == 0) goto L_0x01d7
                long r0 = r7.f15646f     // Catch:{ Throwable -> 0x01ed }
                long r2 = r7.f15647g     // Catch:{ Throwable -> 0x01ed }
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L_0x01d7
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ Throwable -> 0x01ed }
                android.os.Handler r0 = r0.f15623h     // Catch:{ Throwable -> 0x01ed }
                r0.sendEmptyMessage(r8)     // Catch:{ Throwable -> 0x01ed }
            L_0x01d7:
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r13)
                if (r14 == 0) goto L_0x01e2
                r14.disconnect()     // Catch:{ Throwable -> 0x01e0 }
            L_0x01df:
                goto L_0x01e2
            L_0x01e0:
                r0 = move-exception
                goto L_0x01df
            L_0x01e2:
                com.fyber.inneractive.sdk.util.c r0 = com.fyber.inneractive.sdk.util.C7996c.m18038a()
                r0.mo24837a(r11)
                return
            L_0x01ea:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01ea }
                throw r0     // Catch:{ Throwable -> 0x01ed }
            L_0x01ed:
                r0 = move-exception
                goto L_0x01f7
            L_0x01ef:
                r0 = move-exception
                r13 = r1
                r14 = r13
            L_0x01f2:
                r1 = r0
                goto L_0x0233
            L_0x01f4:
                r0 = move-exception
                r13 = r1
                r14 = r13
            L_0x01f7:
                r1 = r0
                java.lang.String r0 = "%s | mDownloadRunnable exception raised during download"
                java.lang.Object[] r2 = new java.lang.Object[r10]     // Catch:{ all -> 0x0231 }
                com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x0231 }
                java.lang.String r3 = r3.f15616a     // Catch:{ all -> 0x0231 }
                r2[r9] = r3     // Catch:{ all -> 0x0231 }
                java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x0231 }
                com.fyber.inneractive.sdk.util.IAlog.m18020a(r0, r1)     // Catch:{ all -> 0x0231 }
                com.fyber.inneractive.sdk.g.a.c$a r0 = r7.f15648h     // Catch:{ Exception -> 0x020f }
                r0.mo24376b()     // Catch:{ Exception -> 0x020f }
                goto L_0x0210
            L_0x020f:
                r0 = move-exception
            L_0x0210:
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x0231 }
                android.os.Handler r0 = r0.f15623h     // Catch:{ all -> 0x0231 }
                if (r0 == 0) goto L_0x0226
                com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x0231 }
                android.os.Handler r0 = r0.f15623h     // Catch:{ all -> 0x0231 }
                com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ all -> 0x0231 }
                android.os.Handler r2 = r2.f15623h     // Catch:{ all -> 0x0231 }
                android.os.Message r1 = r2.obtainMessage(r10, r1)     // Catch:{ all -> 0x0231 }
                r0.sendMessage(r1)     // Catch:{ all -> 0x0231 }
            L_0x0226:
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r13)
                if (r14 == 0) goto L_0x01e2
                r14.disconnect()     // Catch:{ Throwable -> 0x022f }
                goto L_0x01df
            L_0x022f:
                r0 = move-exception
                goto L_0x01df
            L_0x0231:
                r0 = move-exception
                goto L_0x01f2
            L_0x0233:
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r13)
                if (r14 == 0) goto L_0x023e
                r14.disconnect()     // Catch:{ Throwable -> 0x023c }
            L_0x023b:
                goto L_0x023e
            L_0x023c:
                r0 = move-exception
                goto L_0x023b
            L_0x023e:
                com.fyber.inneractive.sdk.util.c r0 = com.fyber.inneractive.sdk.util.C7996c.m18038a()
                r0.mo24837a(r11)
                goto L_0x0247
            L_0x0246:
                throw r1
            L_0x0247:
                goto L_0x0246
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7778b.run():void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01a6 A[EDGE_INSN: B:67:0x01a6->B:64:0x01a6 ?: BREAK  
        EDGE_INSN: B:67:0x01a6->B:64:0x01a6 ?: BREAK  , SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.net.HttpURLConnection m17277a(java.io.OutputStream r20, java.net.URL r21, java.nio.ByteBuffer r22, long r23) throws java.io.IOException, com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7777a {
            /*
                r19 = this;
                r0 = r19
                java.net.URLConnection r1 = r21.openConnection()
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
                r2 = 0
                r3 = 1
                r4 = 0
                int r6 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x0023
                java.lang.Object[] r6 = new java.lang.Object[r3]
                java.lang.Long r7 = java.lang.Long.valueOf(r23)
                r6[r2] = r7
                java.lang.String r7 = "bytes=%d-"
                java.lang.String r6 = java.lang.String.format(r7, r6)
                java.lang.String r7 = "Range"
                r1.addRequestProperty(r7, r6)
            L_0x0023:
                r1.connect()
                int r6 = r1.getResponseCode()
                r7 = 3
                java.lang.Object[] r7 = new java.lang.Object[r7]
                com.fyber.inneractive.sdk.g.a.e r8 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r9 = r8.f15616a
                r7[r2] = r9
                java.lang.String r8 = r8.mo24397d()
                r7[r3] = r8
                java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
                r9 = 2
                r7[r9] = r8
                java.lang.String r8 = "%s http response code for %s is %d"
                java.lang.String r7 = java.lang.String.format(r8, r7)
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r7)
                r7 = 200(0xc8, float:2.8E-43)
                if (r6 == r7) goto L_0x0061
                r8 = 206(0xce, float:2.89E-43)
                if (r6 == r8) goto L_0x0061
                int r8 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
                if (r8 > 0) goto L_0x0056
                goto L_0x0061
            L_0x0056:
                r1.disconnect()
                com.fyber.inneractive.sdk.g.a.e$a r1 = new com.fyber.inneractive.sdk.g.a.e$a
                java.lang.String r2 = "HTTP status code != 200"
                r1.<init>(r2)
                throw r1
            L_0x0061:
                int r8 = r1.getContentLength()
                long r10 = (long) r8
                r12 = 31457280(0x1e00000, double:1.55419614E-316)
                int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r8 > 0) goto L_0x01a7
                int r8 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
                if (r8 > 0) goto L_0x0073
                r0.f15647g = r10
            L_0x0073:
                java.io.InputStream r8 = r1.getInputStream()
                r0.f15643c = r8
                r12 = 716800(0xaf000, double:3.541463E-318)
                int r8 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r8 > 0) goto L_0x0082
                r14 = r12
                goto L_0x0086
            L_0x0082:
                r14 = 10
                long r14 = r10 / r14
            L_0x0086:
                int r8 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r8 > 0) goto L_0x008b
                goto L_0x008f
            L_0x008b:
                r12 = 2
                long r12 = r10 / r12
            L_0x008f:
                com.fyber.inneractive.sdk.util.C7996c.m18038a()
                byte[] r8 = com.fyber.inneractive.sdk.util.C7996c.m18039b(r22)
                long r10 = r0.f15647g
                int r16 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r16 <= 0) goto L_0x00a7
                long r10 = r0.f15646f
                r16 = -1
                int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
                if (r18 != 0) goto L_0x00a7
                r0.f15646f = r4
                goto L_0x00ed
            L_0x00a7:
                int r10 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
                if (r10 <= 0) goto L_0x00ed
                if (r6 != r7) goto L_0x00ed
                r0.f15646f = r4
                java.lang.Object[] r6 = new java.lang.Object[r9]
                com.fyber.inneractive.sdk.g.a.e r7 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r10 = r7.f15616a
                r6[r2] = r10
                java.lang.String r7 = r7.mo24397d()
                r6[r3] = r7
                java.lang.String r7 = "%s | Server rejected Range header for %s | restarting"
                java.lang.String r6 = java.lang.String.format(r7, r6)
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r6)
                com.fyber.inneractive.sdk.p166g.p167a.C7789k.m17288a(r20)
                com.fyber.inneractive.sdk.g.a.c$a r6 = r0.f15648h
                r6.mo24376b()
                com.fyber.inneractive.sdk.g.a.e r6 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                com.fyber.inneractive.sdk.g.a.c r7 = r6.f15617b
                java.lang.String r6 = r6.mo24397d()
                r7.mo24372d(r6)
                com.fyber.inneractive.sdk.g.a.e r6 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                com.fyber.inneractive.sdk.g.a.c r7 = r6.f15617b
                java.lang.String r6 = r6.mo24397d()
                com.fyber.inneractive.sdk.g.a.c$a r6 = r7.mo24368c(r6)
                java.io.OutputStream r7 = r6.mo24375a()
                r0.f15648h = r6
                goto L_0x00ef
            L_0x00ed:
                r7 = r20
            L_0x00ef:
                java.io.InputStream r6 = r0.f15643c
                int r6 = r6.read(r8)
                r10 = -1
                if (r6 == r10) goto L_0x01a6
                java.util.concurrent.atomic.AtomicBoolean r10 = r0.f15641a
                boolean r10 = r10.compareAndSet(r3, r3)
                if (r10 == 0) goto L_0x0119
                java.lang.Object[] r4 = new java.lang.Object[r9]
                com.fyber.inneractive.sdk.g.a.e r5 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r6 = r5.f15616a
                r4[r2] = r6
                java.lang.String r2 = r5.mo24397d()
                r4[r3] = r2
                java.lang.String r2 = "%s | aborting download for cache %s"
                java.lang.String r2 = java.lang.String.format(r2, r4)
                com.fyber.inneractive.sdk.util.IAlog.m18019a(r2)
                goto L_0x01a6
            L_0x0119:
                r7.write(r8, r2, r6)
                long r10 = r0.f15646f
                long r4 = (long) r6
                long r10 = r10 + r4
                r0.f15646f = r10
                boolean r4 = r0.f15644d
                if (r4 != 0) goto L_0x012c
                long r4 = r0.f15646f
                int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r6 >= 0) goto L_0x0136
            L_0x012c:
                boolean r4 = r0.f15645e
                if (r4 != 0) goto L_0x01a1
                long r4 = r0.f15646f
                int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
                if (r6 < 0) goto L_0x01a1
            L_0x0136:
                r0.f15644d = r3
                long r4 = r0.f15646f
                int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
                if (r6 < 0) goto L_0x0140
                r0.f15645e = r3
            L_0x0140:
                com.fyber.inneractive.sdk.g.a.e r4 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                com.fyber.inneractive.sdk.g.a.a r5 = r4.f15620e
                if (r5 != 0) goto L_0x018d
                java.lang.String r5 = r4.mo24397d()
                com.fyber.inneractive.sdk.g.a.e r6 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r10 = r6.f15619d
                com.fyber.inneractive.sdk.g.a.c r11 = r6.f15617b
                java.lang.String r6 = r6.mo24397d()
                r11.mo24367b()
                com.fyber.inneractive.sdk.p166g.p167a.C7759c.m17235e(r6)
                java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.g.a.c$b> r11 = r11.f15567b
                java.lang.Object r6 = r11.get(r6)
                com.fyber.inneractive.sdk.g.a.c$b r6 = (com.fyber.inneractive.sdk.p166g.p167a.C7759c.C7764b) r6
                if (r6 != 0) goto L_0x0167
                r6 = 0
                goto L_0x016b
            L_0x0167:
                java.io.File r6 = r6.mo24384b(r2)
            L_0x016b:
                com.fyber.inneractive.sdk.g.a.e r11 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                java.lang.String r11 = r11.f15625j
                com.fyber.inneractive.sdk.g.a.a r5 = com.fyber.inneractive.sdk.p166g.p167a.C7756a.m17218a(r5, r10, r6, r3, r11)
                r4.f15620e = r5
                long r4 = r0.f15647g
                r10 = 0
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 <= 0) goto L_0x018f
                com.fyber.inneractive.sdk.g.a.e r6 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                com.fyber.inneractive.sdk.g.a.a r6 = r6.f15620e
                java.lang.String r4 = java.lang.String.valueOf(r4)
                java.util.Map<java.lang.String, java.lang.String> r5 = r6.f15557f
                java.lang.String r6 = "http.file.length"
                r5.put(r6, r4)
                goto L_0x018f
            L_0x018d:
                r10 = 0
            L_0x018f:
                com.fyber.inneractive.sdk.g.a.e r4 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                android.os.Handler r4 = r4.f15623h
                if (r4 == 0) goto L_0x01a3
                r7.flush()
                com.fyber.inneractive.sdk.g.a.e r4 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                android.os.Handler r4 = r4.f15623h
                r5 = 4
                r4.sendEmptyMessage(r5)
                goto L_0x01a3
            L_0x01a1:
                r10 = 0
            L_0x01a3:
                r4 = r10
                goto L_0x00ef
            L_0x01a6:
                return r1
            L_0x01a7:
                com.fyber.inneractive.sdk.g.a.e$c r1 = new com.fyber.inneractive.sdk.g.a.e$c
                java.lang.Object[] r4 = new java.lang.Object[r9]
                java.text.NumberFormat r5 = java.text.NumberFormat.getInstance()
                java.lang.String r5 = r5.format(r12)
                r4[r2] = r5
                java.text.NumberFormat r2 = java.text.NumberFormat.getInstance()
                java.lang.String r2 = r2.format(r10)
                r4[r3] = r2
                java.lang.String r2 = "File size to big for cache (max=%s current=%s)"
                java.lang.String r2 = java.lang.String.format(r2, r4)
                r1.<init>(r2)
                goto L_0x01ca
            L_0x01c9:
                throw r1
            L_0x01ca:
                goto L_0x01c9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7771e.C7778b.m17277a(java.io.OutputStream, java.net.URL, java.nio.ByteBuffer, long):java.net.HttpURLConnection");
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.e$c */
    public static class C7779c extends C7777a {
        public C7779c() {
        }

        public C7779c(String str) {
            super(str);
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.e$d */
    public interface C7780d {
        /* renamed from: a */
        void mo24404a(File file);

        /* renamed from: b */
        boolean mo24405b(File file);
    }

    /* renamed from: com.fyber.inneractive.sdk.g.a.e$e */
    public interface C7781e {
        /* renamed from: a */
        void mo24352a(C7756a aVar, Exception exc);
    }

    private C7771e(C7759c cVar, String str, C7757b bVar) {
        StringBuilder sb = new StringBuilder("MediaDownloader-");
        sb.append(hashCode());
        this.f15616a = sb.toString();
        this.f15617b = cVar;
        this.f15619d = str;
        this.f15625j = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(this.f15619d).toLowerCase(Locale.US));
        this.f15630o = bVar;
        String str2 = "MediaDownloader-%s-A";
        this.f15622g = new C7778b(String.format(str2, new Object[]{mo24397d()}));
        this.f15631p = new HandlerThread(String.format(str2, new Object[]{mo24397d()}));
        this.f15631p.start();
        this.f15623h = new C7783g(this.f15631p.getLooper(), this);
        this.f15632q = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public static C7771e m17266a(C7759c cVar, String str, C7781e eVar) {
        C7771e eVar2 = new C7771e(cVar, str, new C7782f());
        eVar2.f15621f = eVar;
        return eVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24392a() {
        this.f15632q.post(new Runnable() {
            public final void run() {
                C7771e eVar = C7771e.this;
                C7781e eVar2 = eVar.f15621f;
                if (eVar2 != null) {
                    eVar2.mo24352a(eVar.f15620e, null);
                }
            }
        });
    }

    /* renamed from: a */
    private void m17269a(final Exception exc) {
        this.f15632q.post(new Runnable() {
            public final void run() {
                C7771e eVar = C7771e.this;
                C7781e eVar2 = eVar.f15621f;
                if (eVar2 != null) {
                    eVar2.mo24352a(eVar.f15620e, exc);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo24395b() {
        C7778b bVar = this.f15622g;
        if (bVar != null) {
            bVar.f15641a.compareAndSet(false, true);
            this.f15622g = null;
        }
        HandlerThread handlerThread = this.f15631p;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f15623h = null;
    }

    /* renamed from: c */
    public final void mo24396c() {
        if (this.f15628m) {
            mo24395b();
        }
    }

    /* renamed from: d */
    public final String mo24397d() {
        if (this.f15634s == null) {
            this.f15634s = m17267a(this.f15619d);
        }
        return this.f15634s;
    }

    /* renamed from: a */
    private static String m17267a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & 255) | Collection.MODE_EMPTY).substring(1));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return m17270b(str);
        } catch (NullPointerException e2) {
            return "";
        }
    }

    /* renamed from: b */
    private static String m17270b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & 255) | Collection.MODE_EMPTY).substring(1));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return str.replaceAll("\\W+", "");
        }
    }

    /* renamed from: a */
    public final void mo24393a(Message message) {
        if (message.what != 4 || this.f15620e.f15559h) {
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                if (obj instanceof Exception) {
                    m17269a((Exception) obj);
                } else {
                    m17269a((Exception) new C7777a("download failed"));
                }
                mo24395b();
                return;
            }
            if (i == 2) {
                if (this.f15633r) {
                    synchronized (this.f15624i) {
                        IAlog.m18019a(String.format("%s | reading from cache 2 - %s", new Object[]{this.f15616a, mo24397d()}));
                        if (this.f15630o.mo24362a(this.f15620e) == C7758a.f15563c) {
                            m17269a((Exception) new C7777a("Failed cache validation after downloading complete file"));
                            mo24395b();
                        } else {
                            mo24394a(this.f15620e);
                            this.f15620e.mo24361a(this.f15630o.f15560a);
                            mo24392a();
                        }
                    }
                } else {
                    this.f15632q.post(new Runnable() {
                        public final void run() {
                            C7771e.this.mo24395b();
                        }
                    });
                }
                IAlog.m18019a(String.format("%s | Download success for cache key %s", new Object[]{this.f15616a, mo24397d()}));
            }
            return;
        }
        synchronized (this.f15624i) {
            IAlog.m18019a(String.format("%s | reading from cache 1 - %s", new Object[]{this.f15616a, mo24397d()}));
            int a = this.f15630o.mo24362a(this.f15620e);
            if (a == C7758a.f15563c) {
                m17269a((Exception) new C7777a("Failed cache validation"));
                mo24395b();
            } else if (a == C7758a.f15562b) {
                this.f15633r = true;
            } else {
                this.f15620e.f15559h = true;
                mo24394a(this.f15620e);
                this.f15620e.mo24361a(this.f15630o.f15560a);
                mo24392a();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo24394a(C7756a aVar) {
        if (aVar != null) {
            C7780d dVar = this.f15629n;
            if (dVar != null && !dVar.mo24405b(aVar.mo24359a())) {
                this.f15629n.mo24404a(aVar.mo24359a());
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m17268a(C7771e eVar, boolean z) {
        C77732 r0 = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r7 = this;
                    r0 = 1
                    r1 = 0
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c$d r2 = r2.f15618c     // Catch:{ IOException -> 0x004b }
                    if (r2 != 0) goto L_0x001b
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c r2 = r2.f15617b     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    java.lang.String r3 = r3.mo24397d()     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c$d r2 = r2.mo24365a(r3)     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    r3.f15618c = r2     // Catch:{ IOException -> 0x004b }
                L_0x001b:
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c$d r2 = r2.f15618c     // Catch:{ IOException -> 0x004b }
                    if (r2 != 0) goto L_0x0049
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c r2 = r2.f15617b     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x004b }
                    java.lang.String r3 = r3.mo24397d()     // Catch:{ IOException -> 0x004b }
                    com.fyber.inneractive.sdk.g.a.c$a r2 = r2.mo24368c(r3)     // Catch:{ IOException -> 0x004b }
                    if (r2 != 0) goto L_0x0033
                    r3 = 1
                    goto L_0x0034
                L_0x0033:
                    r3 = 0
                L_0x0034:
                    if (r2 == 0) goto L_0x004a
                    r2.mo24376b()     // Catch:{ IOException -> 0x0047 }
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x0047 }
                    com.fyber.inneractive.sdk.g.a.c$d r2 = r2.f15618c     // Catch:{ IOException -> 0x0047 }
                    if (r2 != 0) goto L_0x004a
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this     // Catch:{ IOException -> 0x0047 }
                    com.fyber.inneractive.sdk.g.a.e$b r2 = r2.f15622g     // Catch:{ IOException -> 0x0047 }
                    r2.start()     // Catch:{ IOException -> 0x0047 }
                    return
                L_0x0047:
                    r2 = move-exception
                    goto L_0x004d
                L_0x0049:
                    r3 = 0
                L_0x004a:
                    goto L_0x0065
                L_0x004b:
                    r2 = move-exception
                    r3 = 0
                L_0x004d:
                    r4 = 2
                    java.lang.Object[] r4 = new java.lang.Object[r4]
                    com.fyber.inneractive.sdk.g.a.e r5 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    java.lang.String r6 = r5.f15616a
                    r4[r1] = r6
                    java.lang.String r5 = r5.mo24397d()
                    r4[r0] = r5
                    java.lang.String r5 = "%s | Exception raised waiting on availbility for %s"
                    java.lang.String r4 = java.lang.String.format(r5, r4)
                    com.fyber.inneractive.sdk.util.IAlog.m18020a(r4, r2)
                L_0x0065:
                    if (r3 == 0) goto L_0x006d
                    com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    com.fyber.inneractive.sdk.p166g.p167a.C7771e.m17268a(r0, r1)
                    return
                L_0x006d:
                    com.fyber.inneractive.sdk.g.a.e r2 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    r2.f15627l = r0
                    r2.f15628m = r1
                    java.lang.String r0 = r2.mo24397d()
                    com.fyber.inneractive.sdk.g.a.e r3 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    java.lang.String r4 = r3.f15619d
                    com.fyber.inneractive.sdk.g.a.c r5 = r3.f15617b
                    java.lang.String r3 = r3.mo24397d()
                    java.io.File r3 = r5.mo24366b(r3)
                    com.fyber.inneractive.sdk.g.a.e r5 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    java.lang.String r5 = r5.f15625j
                    com.fyber.inneractive.sdk.g.a.a r0 = com.fyber.inneractive.sdk.p166g.p167a.C7756a.m17218a(r0, r4, r3, r1, r5)
                    r2.f15620e = r0
                    com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    com.fyber.inneractive.sdk.g.a.a r1 = r0.f15620e
                    r0.mo24394a(r1)
                    com.fyber.inneractive.sdk.g.a.e r0 = com.fyber.inneractive.sdk.p166g.p167a.C7771e.this
                    r0.mo24392a()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.p166g.p167a.C7771e.C77732.run():void");
            }
        };
        Handler handler = eVar.f15623h;
        if (handler != null) {
            if (z) {
                handler.postAtFrontOfQueue(r0);
                return;
            }
            handler.postDelayed(r0, 4);
        }
    }
}
