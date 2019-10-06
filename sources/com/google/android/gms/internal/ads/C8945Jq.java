package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.Jq */
final class C8945Jq implements Callback {

    /* renamed from: a */
    private final Handler f21364a;

    /* renamed from: b */
    private final HandlerThread f21365b;

    /* renamed from: c */
    private final Handler f21366c;

    /* renamed from: d */
    private final C8966Kq f21367d;

    /* renamed from: e */
    private final boolean[] f21368e;

    /* renamed from: f */
    private final long f21369f;

    /* renamed from: g */
    private final long f21370g;

    /* renamed from: h */
    private final List<zzhp> f21371h;

    /* renamed from: i */
    private zzhp[] f21372i;

    /* renamed from: j */
    private zzhp f21373j;

    /* renamed from: k */
    private boolean f21374k;

    /* renamed from: l */
    private boolean f21375l;

    /* renamed from: m */
    private boolean f21376m;

    /* renamed from: n */
    private int f21377n;

    /* renamed from: o */
    private int f21378o = 0;

    /* renamed from: p */
    private int f21379p = 0;

    /* renamed from: q */
    private long f21380q;

    /* renamed from: r */
    private volatile long f21381r;

    /* renamed from: s */
    private volatile long f21382s;

    /* renamed from: t */
    private volatile long f21383t;

    public C8945Jq(Handler handler, boolean z, boolean[] zArr, int i, int i2) {
        this.f21366c = handler;
        this.f21375l = z;
        this.f21368e = new boolean[zArr.length];
        this.f21369f = 2500000;
        this.f21370g = 5000000;
        for (int i3 = 0; i3 < zArr.length; i3++) {
            this.f21368e[i3] = zArr[i3];
        }
        this.f21377n = 1;
        this.f21381r = -1;
        this.f21383t = -1;
        this.f21367d = new C8966Kq();
        this.f21371h = new ArrayList(zArr.length);
        this.f21365b = new zzko(String.valueOf(C8945Jq.class.getSimpleName()).concat(":Handler"), -16);
        this.f21365b.start();
        this.f21364a = new Handler(this.f21365b.getLooper(), this);
    }

    /* renamed from: e */
    public final long mo28397e() {
        return this.f21382s / 1000;
    }

    /* renamed from: a */
    public final long mo28387a() {
        if (this.f21383t == -1) {
            return -1;
        }
        return this.f21383t / 1000;
    }

    /* renamed from: b */
    public final long mo28393b() {
        if (this.f21381r == -1) {
            return -1;
        }
        return this.f21381r / 1000;
    }

    /* renamed from: a */
    public final void mo28392a(zzhp... zzhpArr) {
        this.f21364a.obtainMessage(1, zzhpArr).sendToTarget();
    }

    /* renamed from: a */
    public final void mo28391a(boolean z) {
        this.f21364a.obtainMessage(3, z ? 1 : 0, 0).sendToTarget();
    }

    /* renamed from: a */
    public final void mo28389a(long j) {
        this.f21364a.obtainMessage(6, Long.valueOf(j)).sendToTarget();
    }

    /* renamed from: d */
    public final void mo28396d() {
        this.f21364a.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public final void mo28388a(int i, boolean z) {
        this.f21364a.obtainMessage(8, 0, z ? 1 : 0).sendToTarget();
    }

    /* renamed from: a */
    public final void mo28390a(zzgf zzgf, int i, Object obj) {
        this.f21378o++;
        this.f21364a.obtainMessage(9, 1, 0, Pair.create(zzgf, obj)).sendToTarget();
    }

    /* renamed from: b */
    public final synchronized void mo28394b(zzgf zzgf, int i, Object obj) {
        if (this.f21374k) {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Sent message(1");
            sb.append(") after release. Message ignored.");
            Log.w("ExoPlayerImplInternal", sb.toString());
            return;
        }
        int i2 = this.f21378o;
        this.f21378o = i2 + 1;
        this.f21364a.obtainMessage(9, 1, 0, Pair.create(zzgf, obj)).sendToTarget();
        while (this.f21379p <= i2) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: c */
    public final synchronized void mo28395c() {
        if (!this.f21374k) {
            this.f21364a.sendEmptyMessage(5);
            while (!this.f21374k) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.f21365b.quit();
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0048=Splitter:B:31:0x0048, B:165:0x022a=Splitter:B:165:0x022a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r22) {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r8 = 3
            r9 = 1
            int r1 = r0.what     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r4 = 5
            r5 = 7
            r6 = 4
            r10 = 2
            r11 = -1
            switch(r1) {
                case 1: goto L_0x02fc;
                case 2: goto L_0x0241;
                case 3: goto L_0x01fc;
                case 4: goto L_0x01f7;
                case 5: goto L_0x01e4;
                case 6: goto L_0x0194;
                case 7: goto L_0x00b2;
                case 8: goto L_0x004c;
                case 9: goto L_0x0013;
                default: goto L_0x0011;
            }     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0011:
            r0 = 0
            return r0
        L_0x0013:
            int r1 = r0.arg1     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x003d }
            java.lang.Object r2 = r0.first     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzgf r2 = (com.google.android.gms.internal.ads.zzgf) r2     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x003d }
            r2.mo31767a(r1, r0)     // Catch:{ all -> 0x003d }
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r0 = r7.f21379p     // Catch:{ all -> 0x003a }
            int r0 = r0 + r9
            r7.f21379p = r0     // Catch:{ all -> 0x003a }
            r21.notifyAll()     // Catch:{ all -> 0x003a }
            monitor-exit(r21)     // Catch:{ all -> 0x003a }
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == r9) goto L_0x0039
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == r10) goto L_0x0039
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.sendEmptyMessage(r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0039:
            return r9
        L_0x003a:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x003a }
            throw r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x003d:
            r0 = move-exception
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r1 = r7.f21379p     // Catch:{ all -> 0x0049 }
            int r1 = r1 + r9
            r7.f21379p = r1     // Catch:{ all -> 0x0049 }
            r21.notifyAll()     // Catch:{ all -> 0x0049 }
            monitor-exit(r21)     // Catch:{ all -> 0x0049 }
        L_0x0048:
            throw r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0049:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x0049 }
            goto L_0x0048
        L_0x004c:
            int r1 = r0.arg1     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r0 = r0.arg2     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x0054
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean[] r2 = r7.f21368e     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r2 = r2[r1]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 == r0) goto L_0x00b1
            boolean[] r2 = r7.f21368e     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2[r1] = r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r2 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 == r9) goto L_0x00b1
            int r2 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 != r10) goto L_0x0068
            goto L_0x00b1
        L_0x0068:
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = r2[r1]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r2 = r1.mo31814c()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 == r9) goto L_0x0076
            if (r2 == r10) goto L_0x0076
            if (r2 != r8) goto L_0x00b1
        L_0x0076:
            if (r0 == 0) goto L_0x0098
            boolean r0 = r7.f21375l     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x0082
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 != r6) goto L_0x0082
            r13 = 1
            goto L_0x0083
        L_0x0082:
            r13 = 0
        L_0x0083:
            long r2 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1.mo31813b(r2, r13)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.add(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r13 == 0) goto L_0x0092
            r1.mo31817h()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0092:
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.sendEmptyMessage(r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x00b1
        L_0x0098:
            com.google.android.gms.internal.ads.zzhp r0 = r7.f21373j     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r1 != r0) goto L_0x00a5
            com.google.android.gms.internal.ads.Kq r0 = r7.f21367d     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r2 = r1.mo31790m()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.mo28410a(r2)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x00a5:
            m22734b(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.remove(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1.mo31812a()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x00b1:
            return r9
        L_0x00b2:
            java.lang.String r0 = "doSomeWork"
            com.google.android.gms.internal.ads.zzkp.m30562a(r0)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r0 = r7.f21381r     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r10 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x00c5
            long r0 = r7.f21381r     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x00ca
        L_0x00c5:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00ca:
            r21.m22737h()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r9 = r0
            r0 = 0
            r1 = 1
            r16 = 1
        L_0x00d4:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r13 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r13 = r13.size()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 >= r13) goto L_0x0133
            java.util.List<com.google.android.gms.internal.ads.zzhp> r13 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.lang.Object r13 = r13.get(r0)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            com.google.android.gms.internal.ads.zzhp r13 = (com.google.android.gms.internal.ads.zzhp) r13     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r5 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r2 = r7.f21380q     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r13.mo31792a(r5, r2)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r1 == 0) goto L_0x00f5
            boolean r1 = r13.mo31789l()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r1 == 0) goto L_0x00f5
            r1 = 1
            goto L_0x00f6
        L_0x00f5:
            r1 = 0
        L_0x00f6:
            if (r16 == 0) goto L_0x0101
            boolean r2 = r7.m22733a(r13)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 == 0) goto L_0x0101
            r16 = 1
            goto L_0x0103
        L_0x0101:
            r16 = 0
        L_0x0103:
            int r2 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x012e
            long r2 = r13.mo31796b()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r5 = r13.mo31797j()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0115
            r9 = r11
            goto L_0x012e
        L_0x0115:
            r19 = -3
            int r13 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r13 == 0) goto L_0x012e
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0129
            r17 = -2
            int r13 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r13 == 0) goto L_0x0129
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 >= 0) goto L_0x012e
        L_0x0129:
            long r2 = java.lang.Math.min(r9, r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r9 = r2
        L_0x012e:
            int r0 = r0 + 1
            r5 = 7
            r6 = 4
            goto L_0x00d4
        L_0x0133:
            r7.f21383t = r9     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r1 == 0) goto L_0x013e
            r7.m22731a(r4)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r21.m22736g()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x0161
        L_0x013e:
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 != r8) goto L_0x0150
            if (r16 == 0) goto L_0x0150
            r0 = 4
            r7.m22731a(r0)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r0 = r7.f21375l     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x0161
            r21.m22735f()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x0161
        L_0x0150:
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 4
            if (r0 != r1) goto L_0x0161
            if (r16 != 0) goto L_0x0161
            boolean r0 = r7.f21375l     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r7.f21376m = r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r7.m22731a(r8)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r21.m22736g()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0161:
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 7
            r0.removeMessages(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r0 = r7.f21375l     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x0170
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 4
            if (r0 == r1) goto L_0x0174
        L_0x0170:
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 != r8) goto L_0x017e
        L_0x0174:
            r2 = 7
            r5 = 10
            r1 = r21
            r3 = r14
            r1.m22732a(r2, r3, r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x018f
        L_0x017e:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r0 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r0 = r0.isEmpty()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 != 0) goto L_0x018f
            r2 = 7
            r5 = 1000(0x3e8, double:4.94E-321)
            r1 = r21
            r3 = r14
            r1.m22732a(r2, r3, r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x018f:
            com.google.android.gms.internal.ads.zzkp.m30561a()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            return r1
        L_0x0194:
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r0 = r0.longValue()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2 = 0
            r7.f21376m = r2     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            r7.f21382s = r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            com.google.android.gms.internal.ads.Kq r0 = r7.f21367d     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.mo28411b()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            com.google.android.gms.internal.ads.Kq r0 = r7.f21367d     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r1 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.mo28410a(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            if (r0 == r1) goto L_0x01e1
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 != r10) goto L_0x01bb
            goto L_0x01e1
        L_0x01bb:
            r0 = 0
        L_0x01bc:
            java.util.List<com.google.android.gms.internal.ads.zzhp> r1 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r1 = r1.size()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 >= r1) goto L_0x01d7
            java.util.List<com.google.android.gms.internal.ads.zzhp> r1 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            com.google.android.gms.internal.ads.zzhp r1 = (com.google.android.gms.internal.ads.zzhp) r1     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            m22734b(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r2 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1.mo31779a(r2)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r0 = r0 + 1
            goto L_0x01bc
        L_0x01d7:
            r7.m22731a(r8)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x01e2
        L_0x01e1:
        L_0x01e2:
            r1 = 1
            return r1
        L_0x01e4:
            r21.m22739j()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            r7.m22731a(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            monitor-enter(r21)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r7.f21374k = r1     // Catch:{ all -> 0x01f4 }
            r21.notifyAll()     // Catch:{ all -> 0x01f4 }
            monitor-exit(r21)     // Catch:{ all -> 0x01f4 }
            return r1
        L_0x01f4:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x01f4 }
            throw r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x01f7:
            r21.m22738i()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            return r1
        L_0x01fc:
            int r0 = r0.arg1     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x0202
            r0 = 1
            goto L_0x0203
        L_0x0202:
            r0 = 0
        L_0x0203:
            r1 = 0
            r7.f21376m = r1     // Catch:{ all -> 0x0236 }
            r7.f21375l = r0     // Catch:{ all -> 0x0236 }
            if (r0 != 0) goto L_0x0211
            r21.m22736g()     // Catch:{ all -> 0x0236 }
            r21.m22737h()     // Catch:{ all -> 0x0236 }
            goto L_0x022a
        L_0x0211:
            int r0 = r7.f21377n     // Catch:{ all -> 0x0236 }
            r1 = 4
            if (r0 != r1) goto L_0x0220
            r21.m22735f()     // Catch:{ all -> 0x0236 }
            android.os.Handler r0 = r7.f21364a     // Catch:{ all -> 0x0236 }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0236 }
            goto L_0x022a
        L_0x0220:
            int r0 = r7.f21377n     // Catch:{ all -> 0x0236 }
            if (r0 != r8) goto L_0x022a
            android.os.Handler r0 = r7.f21364a     // Catch:{ all -> 0x0236 }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0236 }
        L_0x022a:
            android.os.Handler r0 = r7.f21366c     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            android.os.Message r0 = r0.obtainMessage(r10)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.sendToTarget()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            return r1
        L_0x0236:
            r0 = move-exception
            android.os.Handler r1 = r7.f21366c     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            android.os.Message r1 = r1.obtainMessage(r10)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1.sendToTarget()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            throw r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x0241:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0 = 0
            r1 = 1
        L_0x0249:
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r2 = r2.length     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 >= r2) goto L_0x0268
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2 = r2[r0]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r2 = r2.mo31814c()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 != 0) goto L_0x0265
            com.google.android.gms.internal.ads.zzhp[] r2 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2 = r2[r0]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            long r9 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r2 = r2.mo31815c(r9)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 != 0) goto L_0x0265
            r1 = 0
        L_0x0265:
            int r0 = r0 + 1
            goto L_0x0249
        L_0x0268:
            if (r1 != 0) goto L_0x0276
            r2 = 2
            r9 = 10
            r1 = r21
            r3 = r5
            r5 = r9
            r1.m22732a(r2, r3, r5)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x02fa
        L_0x0276:
            r0 = 0
            r1 = r0
            r0 = 0
            r3 = 1
            r5 = 1
        L_0x027e:
            com.google.android.gms.internal.ads.zzhp[] r6 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r6 = r6.length     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 >= r6) goto L_0x02d8
            com.google.android.gms.internal.ads.zzhp[] r6 = r7.f21372i     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r6 = r6[r0]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean[] r9 = r7.f21368e     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r9 = r9[r0]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r9 == 0) goto L_0x02d3
            int r9 = r6.mo31814c()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r10 = 1
            if (r9 != r10) goto L_0x02d3
            long r9 = r7.f21382s     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r13 = 0
            r6.mo31813b(r9, r13)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            java.util.List<com.google.android.gms.internal.ads.zzhp> r9 = r7.f21371h     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r9.add(r6)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r3 == 0) goto L_0x02a9
            boolean r3 = r6.mo31789l()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r3 == 0) goto L_0x02a9
            r3 = 1
            goto L_0x02aa
        L_0x02a9:
            r3 = 0
        L_0x02aa:
            if (r5 == 0) goto L_0x02b4
            boolean r5 = r7.m22733a(r6)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r5 == 0) goto L_0x02b4
            r5 = 1
            goto L_0x02b5
        L_0x02b4:
            r5 = 0
        L_0x02b5:
            int r9 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x02d0
            long r9 = r6.mo31796b()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x02c5
            r1 = r11
            r13 = -2
            goto L_0x02d5
        L_0x02c5:
            r13 = -2
            int r6 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x02d5
            long r1 = java.lang.Math.max(r1, r9)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x02d5
        L_0x02d0:
            r13 = -2
            goto L_0x02d5
        L_0x02d3:
            r13 = -2
        L_0x02d5:
            int r0 = r0 + 1
            goto L_0x027e
        L_0x02d8:
            r7.f21381r = r1     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r3 == 0) goto L_0x02e0
            r7.m22731a(r4)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            goto L_0x02f4
        L_0x02e0:
            if (r5 == 0) goto L_0x02e4
            r0 = 4
            goto L_0x02e5
        L_0x02e4:
            r0 = 3
        L_0x02e5:
            r7.m22731a(r0)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r0 = r7.f21375l     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r0 == 0) goto L_0x02f4
            int r0 = r7.f21377n     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 4
            if (r0 != r1) goto L_0x02f4
            r21.m22735f()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x02f4:
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x02fa:
            r1 = 1
            return r1
        L_0x02fc:
            java.lang.Object r0 = r0.obj     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            com.google.android.gms.internal.ads.zzhp[] r0 = (com.google.android.gms.internal.ads.zzhp[]) r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r21.m22739j()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r7.f21372i = r0     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 0
        L_0x0306:
            int r2 = r0.length     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r1 >= r2) goto L_0x0322
            r2 = r0[r1]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            boolean r2 = r2.mo31788k()     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 == 0) goto L_0x031f
            com.google.android.gms.internal.ads.zzhp r2 = r7.f21373j     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            if (r2 != 0) goto L_0x0317
            r2 = 1
            goto L_0x0318
        L_0x0317:
            r2 = 0
        L_0x0318:
            com.google.android.gms.internal.ads.zzkh.m30537b(r2)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r2 = r0[r1]     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r7.f21373j = r2     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
        L_0x031f:
            int r1 = r1 + 1
            goto L_0x0306
        L_0x0322:
            r7.m22731a(r10)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            android.os.Handler r0 = r7.f21364a     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r0.sendEmptyMessage(r10)     // Catch:{ zzgd -> 0x0347, RuntimeException -> 0x032c }
            r1 = 1
            return r1
        L_0x032c:
            r0 = move-exception
            java.lang.String r1 = "ExoPlayerImplInternal"
            java.lang.String r2 = "Internal runtime error."
            android.util.Log.e(r1, r2, r0)
            android.os.Handler r1 = r7.f21366c
            com.google.android.gms.internal.ads.zzgd r2 = new com.google.android.gms.internal.ads.zzgd
            r3 = 1
            r2.<init>(r0, r3)
            android.os.Message r0 = r1.obtainMessage(r8, r2)
            r0.sendToTarget()
            r21.m22738i()
            return r3
        L_0x0347:
            r0 = move-exception
            java.lang.String r1 = "ExoPlayerImplInternal"
            java.lang.String r2 = "Internal track renderer error."
            android.util.Log.e(r1, r2, r0)
            android.os.Handler r1 = r7.f21366c
            android.os.Message r0 = r1.obtainMessage(r8, r0)
            r0.sendToTarget()
            r21.m22738i()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C8945Jq.handleMessage(android.os.Message):boolean");
    }

    /* renamed from: a */
    private final void m22731a(int i) {
        if (this.f21377n != i) {
            this.f21377n = i;
            this.f21366c.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    /* renamed from: a */
    private final boolean m22733a(zzhp zzhp) {
        if (zzhp.mo31789l()) {
            return true;
        }
        if (!zzhp.mo31785d()) {
            return false;
        }
        if (this.f21377n == 4) {
            return true;
        }
        long b = zzhp.mo31796b();
        long j = zzhp.mo31797j();
        long j2 = this.f21376m ? this.f21370g : this.f21369f;
        if (j2 <= 0 || j == -1 || j == -3 || j >= this.f21382s + j2 || (b != -1 && b != -2 && j >= b)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private final void m22735f() throws zzgd {
        this.f21376m = false;
        this.f21367d.mo28409a();
        for (int i = 0; i < this.f21371h.size(); i++) {
            ((zzhp) this.f21371h.get(i)).mo31817h();
        }
    }

    /* renamed from: g */
    private final void m22736g() throws zzgd {
        this.f21367d.mo28411b();
        for (int i = 0; i < this.f21371h.size(); i++) {
            m22734b((zzhp) this.f21371h.get(i));
        }
    }

    /* renamed from: h */
    private final void m22737h() {
        zzhp zzhp = this.f21373j;
        if (zzhp == null || !this.f21371h.contains(zzhp) || this.f21373j.mo31789l()) {
            this.f21382s = this.f21367d.mo28412c();
        } else {
            this.f21382s = this.f21373j.mo31790m();
            this.f21367d.mo28410a(this.f21382s);
        }
        this.f21380q = SystemClock.elapsedRealtime() * 1000;
    }

    /* renamed from: a */
    private final void m22732a(int i, long j, long j2) {
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f21364a.sendEmptyMessage(i);
        } else {
            this.f21364a.sendEmptyMessageDelayed(i, elapsedRealtime);
        }
    }

    /* renamed from: i */
    private final void m22738i() {
        m22739j();
        m22731a(1);
    }

    /* renamed from: j */
    private final void m22739j() {
        String str = "Release failed.";
        String str2 = "Stop failed.";
        String str3 = "ExoPlayerImplInternal";
        this.f21364a.removeMessages(7);
        this.f21364a.removeMessages(2);
        int i = 0;
        this.f21376m = false;
        this.f21367d.mo28411b();
        if (this.f21372i != null) {
            while (true) {
                zzhp[] zzhpArr = this.f21372i;
                if (i < zzhpArr.length) {
                    zzhp zzhp = zzhpArr[i];
                    try {
                        m22734b(zzhp);
                        if (zzhp.mo31814c() == 2) {
                            zzhp.mo31812a();
                        }
                    } catch (zzgd e) {
                        Log.e(str3, str2, e);
                    } catch (RuntimeException e2) {
                        Log.e(str3, str2, e2);
                    }
                    try {
                        zzhp.mo31816g();
                    } catch (zzgd e3) {
                        Log.e(str3, str, e3);
                    } catch (RuntimeException e4) {
                        Log.e(str3, str, e4);
                    }
                    i++;
                } else {
                    this.f21372i = null;
                    this.f21373j = null;
                    this.f21371h.clear();
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private static void m22734b(zzhp zzhp) throws zzgd {
        if (zzhp.mo31814c() == 3) {
            zzhp.mo31818i();
        }
    }
}
