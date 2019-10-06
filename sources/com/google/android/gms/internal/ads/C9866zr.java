package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.zr */
final class C9866zr implements Callback, zzqk, zzqm, zzrq {

    /* renamed from: A */
    private int f23758A;

    /* renamed from: B */
    private C8778Br f23759B;

    /* renamed from: C */
    private long f23760C;

    /* renamed from: D */
    private C8757Ar f23761D;

    /* renamed from: E */
    private C8757Ar f23762E;

    /* renamed from: F */
    private C8757Ar f23763F;

    /* renamed from: G */
    private zzlr f23764G;

    /* renamed from: a */
    private final zzlo[] f23765a;

    /* renamed from: b */
    private final zzlp[] f23766b;

    /* renamed from: c */
    private final zzrp f23767c;

    /* renamed from: d */
    private final zzll f23768d;

    /* renamed from: e */
    private final zzsw f23769e;

    /* renamed from: f */
    private final Handler f23770f;

    /* renamed from: g */
    private final HandlerThread f23771g;

    /* renamed from: h */
    private final Handler f23772h;

    /* renamed from: i */
    private final zzkv f23773i;

    /* renamed from: j */
    private final zzlu f23774j;

    /* renamed from: k */
    private final zzlt f23775k;

    /* renamed from: l */
    private zzle f23776l;

    /* renamed from: m */
    private zzln f23777m;

    /* renamed from: n */
    private zzlo f23778n;

    /* renamed from: o */
    private zzso f23779o;

    /* renamed from: p */
    private zzql f23780p;

    /* renamed from: q */
    private zzlo[] f23781q;

    /* renamed from: r */
    private boolean f23782r;

    /* renamed from: s */
    private boolean f23783s;

    /* renamed from: t */
    private boolean f23784t;

    /* renamed from: u */
    private boolean f23785u;

    /* renamed from: v */
    private int f23786v;

    /* renamed from: w */
    private int f23787w = 0;

    /* renamed from: x */
    private int f23788x;

    /* renamed from: y */
    private int f23789y;

    /* renamed from: z */
    private long f23790z;

    public C9866zr(zzlo[] zzloArr, zzrp zzrp, zzll zzll, boolean z, int i, Handler handler, zzle zzle, zzkv zzkv) {
        this.f23765a = zzloArr;
        this.f23767c = zzrp;
        this.f23768d = zzll;
        this.f23783s = z;
        this.f23772h = handler;
        this.f23786v = 1;
        this.f23776l = zzle;
        this.f23773i = zzkv;
        this.f23766b = new zzlp[zzloArr.length];
        for (int i2 = 0; i2 < zzloArr.length; i2++) {
            zzloArr[i2].setIndex(i2);
            this.f23766b[i2] = zzloArr[i2].mo31915e();
        }
        this.f23769e = new zzsw();
        this.f23781q = new zzlo[0];
        this.f23774j = new zzlu();
        this.f23775k = new zzlt();
        zzrp.mo32167a((zzrq) this);
        this.f23777m = zzln.f28809a;
        this.f23771g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f23771g.start();
        this.f23770f = new Handler(this.f23771g.getLooper(), this);
    }

    /* renamed from: a */
    public final void mo29336a(zzql zzql, boolean z) {
        this.f23770f.obtainMessage(0, 1, 0, zzql).sendToTarget();
    }

    /* renamed from: a */
    public final void mo29337a(boolean z) {
        this.f23770f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    /* renamed from: a */
    public final void mo29335a(zzlr zzlr, int i, long j) {
        this.f23770f.obtainMessage(3, new C8778Br(zzlr, i, j)).sendToTarget();
    }

    /* renamed from: c */
    public final void mo29341c() {
        this.f23770f.sendEmptyMessage(5);
    }

    /* renamed from: a */
    public final void mo29338a(zzky... zzkyArr) {
        if (this.f23782r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f23788x++;
        this.f23770f.obtainMessage(11, zzkyArr).sendToTarget();
    }

    /* renamed from: b */
    public final synchronized void mo29340b(zzky... zzkyArr) {
        if (this.f23782r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.f23788x;
        this.f23788x = i + 1;
        this.f23770f.obtainMessage(11, zzkyArr).sendToTarget();
        while (this.f23789y <= i) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo29339b() {
        if (!this.f23782r) {
            this.f23770f.sendEmptyMessage(6);
            while (!this.f23782r) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.f23771g.quit();
        }
    }

    /* renamed from: a */
    public final void mo28528a(zzlr zzlr, Object obj) {
        this.f23770f.obtainMessage(7, Pair.create(zzlr, obj)).sendToTarget();
    }

    /* renamed from: a */
    public final void mo28511a(zzqj zzqj) {
        this.f23770f.obtainMessage(8, zzqj).sendToTarget();
    }

    /* renamed from: a */
    public final void mo29334a() {
        this.f23770f.sendEmptyMessage(10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0298 A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x029b A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x029f A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0365 A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0379 A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x05cd A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x05e9 A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }, LOOP:8: B:328:0x05e9->B:332:0x05fb, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0750 A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x080b A[Catch:{ all -> 0x0464, all -> 0x039a, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x00d8=Splitter:B:72:0x00d8, B:55:0x00bd=Splitter:B:55:0x00bd} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x08a3;
                case 1: goto L_0x0876;
                case 2: goto L_0x047e;
                case 3: goto L_0x03c3;
                case 4: goto L_0x03a2;
                case 5: goto L_0x039e;
                case 6: goto L_0x0386;
                case 7: goto L_0x0223;
                case 8: goto L_0x01eb;
                case 9: goto L_0x01d6;
                case 10: goto L_0x00dd;
                case 11: goto L_0x009f;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23787w = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0026:
            if (r2 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.Ar r4 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != r4) goto L_0x0037
            r4 = r3
            r3 = r2
            r2 = 1
            goto L_0x003a
        L_0x0037:
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x003a:
            com.google.android.gms.internal.ads.zzlr r11 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r12 = r3.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r13 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlu r14 = r8.f23774j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r11 = r11.mo31958a(r12, r13, r14, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r12 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == 0) goto L_0x0065
            if (r11 == r5) goto L_0x0065
            com.google.android.gms.internal.ads.Ar r12 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r12 = r12.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 != r11) goto L_0x0065
            com.google.android.gms.internal.ads.Ar r3 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r11 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != r11) goto L_0x005a
            r11 = 1
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            r4 = r4 | r11
            com.google.android.gms.internal.ads.Ar r11 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != r11) goto L_0x0062
            r11 = 1
            goto L_0x0063
        L_0x0062:
            r11 = 0
        L_0x0063:
            r2 = r2 | r11
            goto L_0x003a
        L_0x0065:
            com.google.android.gms.internal.ads.Ar r5 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r5 == 0) goto L_0x0070
            com.google.android.gms.internal.ads.Ar r5 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            m24447a(r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.f20483l = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0070:
            int r5 = r3.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r5 = r8.m24456b(r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.f20480i = r5     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x007c
            r8.f23761D = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x007c:
            if (r4 != 0) goto L_0x0095
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r8.m24441a(r2, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r5 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5.<init>(r2, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r5     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0095:
            int r2 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != r15) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            r8.m24444a(r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x009e:
            return r10
        L_0x009f:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzky[] r1 = (com.google.android.gms.internal.ads.zzky[]) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r1.length     // Catch:{ all -> 0x00cc }
        L_0x00a4:
            if (r9 >= r2) goto L_0x00b4
            r3 = r1[r9]     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzkx r4 = r3.f28765a     // Catch:{ all -> 0x00cc }
            int r5 = r3.f28766b     // Catch:{ all -> 0x00cc }
            java.lang.Object r3 = r3.f28767c     // Catch:{ all -> 0x00cc }
            r4.mo31905a(r5, r3)     // Catch:{ all -> 0x00cc }
            int r9 = r9 + 1
            goto L_0x00a4
        L_0x00b4:
            com.google.android.gms.internal.ads.zzql r1 = r8.f23780p     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00bd
            android.os.Handler r1 = r8.f23770f     // Catch:{ all -> 0x00cc }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00cc }
        L_0x00bd:
            monitor-enter(r34)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r8.f23789y     // Catch:{ all -> 0x00c8 }
            int r1 = r1 + r10
            r8.f23789y = r1     // Catch:{ all -> 0x00c8 }
            r34.notifyAll()     // Catch:{ all -> 0x00c8 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            return r10
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            throw r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x00cc:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r8.f23789y     // Catch:{ all -> 0x00d9 }
            int r2 = r2 + r10
            r8.f23789y = r2     // Catch:{ all -> 0x00d9 }
            r34.notifyAll()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
        L_0x00d8:
            throw r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            goto L_0x00d8
        L_0x00dd:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x01d5
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = 1
        L_0x00e5:
            if (r1 == 0) goto L_0x01d5
            boolean r3 = r1.f20481j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != 0) goto L_0x00ed
            goto L_0x01d5
        L_0x00ed:
            boolean r3 = r1.mo28050d()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != 0) goto L_0x00fb
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != r3) goto L_0x00f8
            r2 = 0
        L_0x00f8:
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x00e5
        L_0x00fb:
            if (r2 == 0) goto L_0x019a
            com.google.android.gms.internal.ads.Ar r2 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == r3) goto L_0x0105
            r2 = 1
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            m24447a(r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.f20483l = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23761D = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23762E = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r3 = r3.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r4 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r5 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r5.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r4 = r4.mo28045a(r11, r2, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r2.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0137
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.f28772c = r4     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24445a(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0137:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r4 = 0
            r5 = 0
        L_0x013f:
            com.google.android.gms.internal.ads.zzlo[] r11 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r11 = r11.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r4 >= r11) goto L_0x018b
            com.google.android.gms.internal.ads.zzlo[] r11 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11 = r11[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r12 = r11.getState()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == 0) goto L_0x0150
            r12 = 1
            goto L_0x0151
        L_0x0150:
            r12 = 0
        L_0x0151:
            r2[r4] = r12     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r12 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqw[] r12 = r12.f20475d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r12 = r12[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == 0) goto L_0x015d
            int r5 = r5 + 1
        L_0x015d:
            boolean r13 = r2[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r13 == 0) goto L_0x0188
            com.google.android.gms.internal.ads.zzqw r13 = r11.mo31920j()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == r13) goto L_0x017f
            com.google.android.gms.internal.ads.zzlo r13 = r8.f23778n     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r11 != r13) goto L_0x0178
            if (r12 != 0) goto L_0x0174
            com.google.android.gms.internal.ads.zzsw r12 = r8.f23769e     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzso r13 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r12.mo32223a(r13)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0174:
            r8.f23779o = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23778n = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0178:
            m24448a(r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11.mo31913c()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0188
        L_0x017f:
            boolean r12 = r3[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == 0) goto L_0x0188
            long r12 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11.mo31906a(r12)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0188:
            int r4 = r4 + 1
            goto L_0x013f
        L_0x018b:
            android.os.Handler r3 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrr r1 = r1.f20484m     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24450a(r2, r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x01c9
        L_0x019a:
            r8.f23761D = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x01a0:
            if (r1 == 0) goto L_0x01a8
            r1.mo28046a()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x01a0
        L_0x01a8:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.f20483l = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r1 = r1.f20481j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x01c9
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1.f20479h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r4 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r3.mo28048b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.mo28044a(r1, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x01c9:
            r34.m24464i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24462g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r1 = r8.f23770f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendEmptyMessage(r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x01d5:
            return r10
        L_0x01d6:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r1 = (com.google.android.gms.internal.ads.zzqj) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x01e9
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r2 = r2.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == r1) goto L_0x01e5
            goto L_0x01e9
        L_0x01e5:
            r34.m24464i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x01ea
        L_0x01e9:
        L_0x01ea:
            return r10
        L_0x01eb:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r1 = (com.google.android.gms.internal.ads.zzqj) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x0221
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r2 = r2.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == r1) goto L_0x01fa
            goto L_0x0221
        L_0x01fa:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.f20481j = r10     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo28050d()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r1.f20479h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r1.mo28044a(r2, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.f20479h = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != 0) goto L_0x021d
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23762E = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1.f20479h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24445a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24453b(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x021d:
            r34.m24464i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0222
        L_0x0221:
        L_0x0222:
            return r10
        L_0x0223:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r3 = r1.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r3 = (com.google.android.gms.internal.ads.zzlr) r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23764G = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r1 = r1.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x0293
            int r3 = r8.f23758A     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 <= 0) goto L_0x0263
            com.google.android.gms.internal.ads.Br r3 = r8.f23759B     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.util.Pair r3 = r8.m24442a(r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r4 = r8.f23758A     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23758A = r9     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23759B = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != 0) goto L_0x024b
            r8.m24449a(r1, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0385
        L_0x024b:
            com.google.android.gms.internal.ads.zzle r7 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r11 = r3.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r11 = r11.intValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r3 = r3.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r14 = r3.longValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r7.<init>(r11, r14)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r7     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0294
        L_0x0263:
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.f28771b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0293
            com.google.android.gms.internal.ads.zzlr r3 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r3 = r3.mo31960a()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 == 0) goto L_0x0278
            r8.m24449a(r1, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0385
        L_0x0278:
            android.util.Pair r3 = r8.m24451b(r9, r12)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r4 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r7 = r3.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = r7.intValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r3 = r3.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r14 = r3.longValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r4.<init>(r7, r14)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r4     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0293:
            r4 = 0
        L_0x0294:
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 == 0) goto L_0x029b
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x029d
        L_0x029b:
            com.google.android.gms.internal.ads.Ar r3 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x029d:
            if (r3 == 0) goto L_0x0382
            com.google.android.gms.internal.ads.zzlr r7 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r11 = r3.f20473b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = r7.mo28169a(r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 != r5) goto L_0x0303
            int r6 = r3.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r7 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r8.m24440a(r6, r2, r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != r5) goto L_0x02b8
            r8.m24449a(r1, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0385
        L_0x02b8:
            com.google.android.gms.internal.ads.zzlr r6 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r6.mo28170a(r2, r7, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.util.Pair r2 = r8.m24451b(r9, r12)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r6 = r2.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r6 = r6.intValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r2 = r2.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r2.longValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo28170a(r6, r7, r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r2 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r2 = r2.f28817b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.f20478g = r5     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x02e2:
            com.google.android.gms.internal.ads.Ar r7 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == 0) goto L_0x02f6
            com.google.android.gms.internal.ads.Ar r3 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r7 = r3.f20473b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r7 = r7.equals(r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == 0) goto L_0x02f2
            r7 = r6
            goto L_0x02f3
        L_0x02f2:
            r7 = -1
        L_0x02f3:
            r3.f20478g = r7     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x02e2
        L_0x02f6:
            long r2 = r8.m24441a(r6, r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r5 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5.<init>(r6, r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r5     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0382
        L_0x0303:
            boolean r2 = r8.m24456b(r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.mo28047a(r7, r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 != r2) goto L_0x0310
            r2 = 1
            goto L_0x0311
        L_0x0310:
            r2 = 0
        L_0x0311:
            com.google.android.gms.internal.ads.zzle r11 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r11 = r11.f28770a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == r11) goto L_0x032b
            com.google.android.gms.internal.ads.zzle r11 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r12 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r13 = r11.f28771b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r12.<init>(r7, r13)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r13 = r11.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r12.f28772c = r13     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r13 = r11.f28773d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r12.f28773d = r13     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r12     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x032b:
            com.google.android.gms.internal.ads.Ar r11 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r11 == 0) goto L_0x0382
            com.google.android.gms.internal.ads.Ar r11 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r12 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r13 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlu r14 = r8.f23774j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r15 = r8.f23787w     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = r12.mo31958a(r7, r13, r14, r15)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == r5) goto L_0x0363
            java.lang.Object r12 = r11.f20473b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r13 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r14 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r13 = r13.mo28170a(r7, r14, r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r13 = r13.f28817b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r12 = r12.equals(r13)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r12 == 0) goto L_0x0363
            boolean r3 = r8.m24456b(r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11.mo28047a(r7, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r11 != r3) goto L_0x035f
            r3 = 1
            goto L_0x0360
        L_0x035f:
            r3 = 0
        L_0x0360:
            r2 = r2 | r3
            r3 = r11
            goto L_0x032b
        L_0x0363:
            if (r2 != 0) goto L_0x0379
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r5 = r3.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r5 = r8.m24441a(r2, r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r3 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.<init>(r2, r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0382
        L_0x0379:
            r8.f23761D = r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.f20483l = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            m24447a(r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0382:
            r8.m24454b(r1, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0385:
            return r10
        L_0x0386:
            r8.m24458c(r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzll r1 = r8.f23768d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo30494b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24444a(r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            monitor-enter(r34)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23782r = r10     // Catch:{ all -> 0x039a }
            r34.notifyAll()     // Catch:{ all -> 0x039a }
            monitor-exit(r34)     // Catch:{ all -> 0x039a }
            return r10
        L_0x039a:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x039a }
            throw r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x039e:
            r34.m24461f()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            return r10
        L_0x03a2:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzln r1 = (com.google.android.gms.internal.ads.zzln) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzso r2 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x03b1
            com.google.android.gms.internal.ads.zzso r2 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzln r1 = r2.mo31999a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x03b7
        L_0x03b1:
            com.google.android.gms.internal.ads.zzsw r2 = r8.f23769e     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzln r1 = r2.mo31999a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x03b7:
            r8.f23777m = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r2 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            return r10
        L_0x03c3:
            java.lang.Object r1 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Br r1 = (com.google.android.gms.internal.ads.C8778Br) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x03d4
            int r2 = r8.f23758A     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2 + r10
            r8.f23758A = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23759B = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0463
        L_0x03d4:
            android.util.Pair r2 = r8.m24442a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x03fa
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.<init>(r9, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r1 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r1.obtainMessage(r15, r10, r9, r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.<init>(r9, r12)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24444a(r15)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24458c(r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0463
        L_0x03fa:
            long r3 = r1.f20525c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x0402
            r1 = 1
            goto L_0x0403
        L_0x0402:
            r1 = 0
        L_0x0403:
            java.lang.Object r3 = r2.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r3 = r3.intValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r2 = r2.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r4 = r2.longValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ all -> 0x0464 }
            int r2 = r2.f28770a     // Catch:{ all -> 0x0464 }
            if (r3 != r2) goto L_0x043e
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ all -> 0x0464 }
            long r13 = r2.f28772c     // Catch:{ all -> 0x0464 }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x043e
            com.google.android.gms.internal.ads.zzle r2 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.<init>(r3, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r2 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0433
            r1 = 1
            goto L_0x0434
        L_0x0433:
            r1 = 0
        L_0x0434:
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0463
        L_0x043e:
            long r6 = r8.m24441a(r3, r4)     // Catch:{ all -> 0x0464 }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0448
            r2 = 1
            goto L_0x0449
        L_0x0448:
            r2 = 0
        L_0x0449:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzle r2 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.<init>(r3, r6)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r2 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0458
            r1 = 1
            goto L_0x0459
        L_0x0458:
            r1 = 0
        L_0x0459:
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0463:
            return r10
        L_0x0464:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzle r6 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r6.<init>(r3, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r6     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r3 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0473
            r1 = 1
            goto L_0x0474
        L_0x0473:
            r1 = 0
        L_0x0474:
            com.google.android.gms.internal.ads.zzle r4 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            throw r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x047e:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r1 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != 0) goto L_0x0490
            com.google.android.gms.internal.ads.zzql r1 = r8.f23780p     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo32108b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r14 = r5
            goto L_0x06ff
        L_0x0490:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != 0) goto L_0x049a
            com.google.android.gms.internal.ads.zzle r1 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r1.f28770a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x04df
        L_0x049a:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r1.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r2 = r2.f20480i     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x05c7
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r2 = r2.mo28049c()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x05c7
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r2 = r2.mo28170a(r1, r7, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r14 = r2.f28819d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x04be
            r14 = r5
            goto L_0x05c8
        L_0x04be:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x04d3
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20474c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r7 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = r7.f20474c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04d0
            goto L_0x04d3
        L_0x04d0:
            r14 = r5
            goto L_0x05c9
        L_0x04d3:
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlu r14 = r8.f23774j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r15 = r8.f23787w     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r2.mo31958a(r1, r7, r14, r15)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x04df:
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.mo28173c()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 < r2) goto L_0x04ef
            com.google.android.gms.internal.ads.zzql r1 = r8.f23780p     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo32108b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r14 = r5
            goto L_0x05c9
        L_0x04ef:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x04f9
            com.google.android.gms.internal.ads.zzle r2 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r2.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r14 = r5
            goto L_0x0551
        L_0x04f9:
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo28170a(r1, r7, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlu r7 = r8.f23774j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo31959a(r9, r7, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x050c
            r14 = r5
            goto L_0x0551
        L_0x050c:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1.mo28048b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r7 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r14 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r14 = r14.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r15 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r7 = r7.mo28170a(r14, r15, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r14 = r7.f28819d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1 + r14
            long r14 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzlr r7 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.m24443a(r2, r3, r4, r6)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x05c9
            java.lang.Object r2 = r1.first     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.intValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r1 = r1.second     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r1.longValue()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1 = r2
        L_0x0551:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x055c
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
            r23 = r5
            goto L_0x0574
        L_0x055c:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r5 = r2.mo28048b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r7 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r7 = r7.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r11 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r2 = r2.mo28170a(r7, r11, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r12 = r2.f28819d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r5 = r5 + r12
            r23 = r5
        L_0x0574:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x057b
            r29 = 0
            goto L_0x0582
        L_0x057b:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20474c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2 + r10
            r29 = r2
        L_0x0582:
            boolean r31 = r8.m24456b(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r5 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo28170a(r1, r5, r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = new com.google.android.gms.internal.ads.Ar     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlp[] r6 = r8.f23766b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrp r7 = r8.f23767c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzll r11 = r8.f23768d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzql r12 = r8.f23780p     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r13 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            java.lang.Object r13 = r13.f28817b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x05ba
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.f20483l = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x05ba:
            r8.f23761D = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r1 = r1.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo28290a(r8, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24455b(r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x05c9
        L_0x05c7:
            r14 = r5
        L_0x05c8:
        L_0x05c9:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x05e2
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r1 = r1.mo28049c()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x05d6
            goto L_0x05e2
        L_0x05d6:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x05e5
            boolean r1 = r8.f23785u     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != 0) goto L_0x05e5
            r34.m24464i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x05e5
        L_0x05e2:
            r8.m24455b(r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x05e5:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x06ff
        L_0x05e9:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == r2) goto L_0x0626
            long r1 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r3.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.f20477f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0626
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo28046a()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24453b(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.f20479h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.<init>(r2, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24462g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r1 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = 5
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x05e9
        L_0x0626:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r1 = r1.f20480i     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0652
            r1 = 0
        L_0x062d:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 >= r2) goto L_0x0650
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = r2[r1]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqw[] r3 = r3.f20475d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3 = r3[r1]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 == 0) goto L_0x064d
            com.google.android.gms.internal.ads.zzqw r4 = r2.mo31920j()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r4 != r3) goto L_0x064d
            boolean r3 = r2.mo31921k()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 == 0) goto L_0x064d
            r2.mo31917g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x064d:
            int r1 = r1 + 1
            goto L_0x062d
        L_0x0650:
            goto L_0x06ff
        L_0x0652:
            r1 = 0
        L_0x0653:
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 >= r2) goto L_0x0676
            com.google.android.gms.internal.ads.zzlo[] r2 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = r2[r1]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqw[] r3 = r3.f20475d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3 = r3[r1]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqw r4 = r2.mo31920j()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r4 != r3) goto L_0x0674
            if (r3 == 0) goto L_0x0671
            boolean r2 = r2.mo31921k()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x0671
            goto L_0x0674
        L_0x0671:
            int r1 = r1 + 1
            goto L_0x0653
        L_0x0674:
            goto L_0x06ff
        L_0x0676:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x06ff
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r1.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r1 = r1.f20481j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x06ff
            com.google.android.gms.internal.ads.Ar r1 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrr r1 = r1.f20484m     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r2.f20483l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23762E = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrr r2 = r2.f20484m     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r3 = r3.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.mo28284a()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x06a5
            r3 = 1
            goto L_0x06a6
        L_0x06a5:
            r3 = 0
        L_0x06a6:
            r4 = 0
        L_0x06a7:
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r5 = r5.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r4 >= r5) goto L_0x06ff
            com.google.android.gms.internal.ads.zzlo[] r5 = r8.f23765a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5 = r5[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzro r6 = r1.f29258b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrm r6 = r6.mo32162a(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r6 == 0) goto L_0x06fc
            if (r3 != 0) goto L_0x06f9
            boolean r6 = r5.mo31919h()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r6 != 0) goto L_0x06fc
            com.google.android.gms.internal.ads.zzro r6 = r2.f29258b     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzrm r6 = r6.mo32162a(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlq[] r7 = r1.f29260d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r7 = r7[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlq[] r11 = r2.f29260d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11 = r11[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r6 == 0) goto L_0x06f9
            boolean r7 = r11.equals(r7)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == 0) goto L_0x06f9
            int r7 = r6.length()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlh[] r7 = new com.google.android.gms.internal.ads.zzlh[r7]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11 = 0
        L_0x06dd:
            int r12 = r7.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r11 >= r12) goto L_0x06e9
            com.google.android.gms.internal.ads.zzlh r12 = r6.mo32152b(r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r7[r11] = r12     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r11 = r11 + 1
            goto L_0x06dd
        L_0x06e9:
            com.google.android.gms.internal.ads.Ar r6 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqw[] r6 = r6.f20475d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r6 = r6[r4]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r11 = r8.f23762E     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r11.mo28048b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5.mo31911a(r7, r6, r11)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x06fc
        L_0x06f9:
            r5.mo31917g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x06fc:
            int r4 = r4 + 1
            goto L_0x06a7
        L_0x06ff:
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = 10
            if (r1 != 0) goto L_0x070d
            r34.m24463h()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24446a(r14, r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0875
        L_0x070d:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzsx.m31142a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24462g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r1 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r1 = r1.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzle r4 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r4 = r4.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.mo28298c(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.f23781q     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r4 = r1.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x0728:
            if (r5 >= r4) goto L_0x075f
            r11 = r1[r5]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r12 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r8.f23790z     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r11.mo31952a(r12, r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == 0) goto L_0x073d
            boolean r2 = r11.mo31953b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x073d
            r7 = 1
            goto L_0x073e
        L_0x073d:
            r7 = 0
        L_0x073e:
            boolean r2 = r11.isReady()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x074d
            boolean r2 = r11.mo31953b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x074b
            goto L_0x074d
        L_0x074b:
            r2 = 0
            goto L_0x074e
        L_0x074d:
            r2 = 1
        L_0x074e:
            if (r2 != 0) goto L_0x0753
            r11.mo31922l()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0753:
            if (r6 == 0) goto L_0x0759
            if (r2 == 0) goto L_0x0759
            r6 = 1
            goto L_0x075a
        L_0x0759:
            r6 = 0
        L_0x075a:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x0728
        L_0x075f:
            if (r6 != 0) goto L_0x0764
            r34.m24463h()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0764:
            com.google.android.gms.internal.ads.zzso r1 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0789
            com.google.android.gms.internal.ads.zzso r1 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzln r1 = r1.mo32006i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzln r2 = r8.f23777m     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r2 = r1.equals(r2)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x0789
            r8.f23777m = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzsw r2 = r8.f23769e     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzso r3 = r8.f23779o     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo32223a(r3)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r2 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendToTarget()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0789:
            com.google.android.gms.internal.ads.zzlr r1 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r2.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r3 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r1 = r1.mo28170a(r2, r3, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r1 = r1.f28819d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r7 == 0) goto L_0x07bb
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x07ab
            com.google.android.gms.internal.ads.zzle r3 = r8.f23776l     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r3 = r3.f28772c     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x07bb
        L_0x07ab:
            com.google.android.gms.internal.ads.Ar r3 = r8.f23763F     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r3 = r3.f20480i     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 == 0) goto L_0x07bb
            r1 = 4
            r8.m24444a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24460e()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r4 = 2
            goto L_0x083e
        L_0x07bb:
            int r3 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r4 = 2
            if (r3 != r4) goto L_0x0821
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.f23781q     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r3 = r3.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 <= 0) goto L_0x080f
            if (r6 == 0) goto L_0x080d
            boolean r1 = r8.f23784t     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r2 = r2.f20481j     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 != 0) goto L_0x07d4
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r2.f20479h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x07dc
        L_0x07d4:
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzqj r2 = r2.f20472a     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r2.mo28294b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x07dc:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07f8
            com.google.android.gms.internal.ads.Ar r2 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r2 = r2.f20480i     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r2 == 0) goto L_0x07ea
            r1 = 1
            goto L_0x0809
        L_0x07ea:
            com.google.android.gms.internal.ads.zzlr r2 = r8.f23764G     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r3 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r3 = r3.f20478g     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r5 = r8.f23775k     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzlt r2 = r2.mo28170a(r3, r5, r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r2 = r2.f28819d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x07f8:
            com.google.android.gms.internal.ads.zzll r5 = r8.f23768d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.Ar r6 = r8.f23761D     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r8.f23760C     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r6 = r6.mo28048b()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.mo30493a(r2, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0809:
            if (r1 == 0) goto L_0x080d
            r1 = 1
            goto L_0x0813
        L_0x080d:
            r1 = 0
            goto L_0x0813
        L_0x080f:
            boolean r1 = r8.m24457b(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0813:
            if (r1 == 0) goto L_0x083d
            r1 = 3
            r8.m24444a(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            boolean r1 = r8.f23783s     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x083d
            r34.m24459d()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x083d
        L_0x0821:
            int r3 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5 = 3
            if (r3 != r5) goto L_0x083d
            com.google.android.gms.internal.ads.zzlo[] r3 = r8.f23781q     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r3 = r3.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r3 <= 0) goto L_0x082c
            goto L_0x0830
        L_0x082c:
            boolean r6 = r8.m24457b(r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0830:
            if (r6 != 0) goto L_0x083e
            boolean r1 = r8.f23783s     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23784t = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24444a(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24460e()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x083e
        L_0x083d:
        L_0x083e:
            int r1 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != r4) goto L_0x084f
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.f23781q     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r2 = r1.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0845:
            if (r9 >= r2) goto L_0x084f
            r3 = r1[r9]     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.mo31922l()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r9 = r9 + 1
            goto L_0x0845
        L_0x084f:
            boolean r1 = r8.f23783s     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x0858
            int r1 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = 3
            if (r1 == r2) goto L_0x085c
        L_0x0858:
            int r1 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != r4) goto L_0x0862
        L_0x085c:
            r1 = 10
            r8.m24446a(r14, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0872
        L_0x0862:
            com.google.android.gms.internal.ads.zzlo[] r1 = r8.f23781q     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r1.length     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x086d
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.m24446a(r14, r1)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x0872
        L_0x086d:
            android.os.Handler r1 = r8.f23770f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.removeMessages(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0872:
            com.google.android.gms.internal.ads.zzsx.m31141a()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x0875:
            return r10
        L_0x0876:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x087d
            r1 = 1
            goto L_0x087e
        L_0x087d:
            r1 = 0
        L_0x087e:
            r8.f23784t = r9     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23783s = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != 0) goto L_0x088b
            r34.m24460e()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r34.m24462g()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x08a2
        L_0x088b:
            int r1 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2 = 3
            if (r1 != r2) goto L_0x0899
            r34.m24459d()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r1 = r8.f23770f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            goto L_0x08a2
        L_0x0899:
            int r1 = r8.f23786v     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 != r4) goto L_0x08a2
            android.os.Handler r1 = r8.f23770f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x08a2:
            return r10
        L_0x08a3:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzql r2 = (com.google.android.gms.internal.ads.zzql) r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            int r1 = r1.arg1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x08ae
            r1 = 1
            goto L_0x08af
        L_0x08ae:
            r1 = 0
        L_0x08af:
            android.os.Handler r3 = r8.f23772h     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.sendEmptyMessage(r9)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24458c(r10)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzll r3 = r8.f23768d     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r3.mo30499i()     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            if (r1 == 0) goto L_0x08ca
            com.google.android.gms.internal.ads.zzle r1 = new com.google.android.gms.internal.ads.zzle     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.f23776l = r1     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
        L_0x08ca:
            r8.f23780p = r2     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            com.google.android.gms.internal.ads.zzkv r1 = r8.f23773i     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r2.mo32106a(r1, r10, r8)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r8.m24444a(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            android.os.Handler r1 = r8.f23770f     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            r1.sendEmptyMessage(r4)     // Catch:{ zzku -> 0x0912, IOException -> 0x08f6, RuntimeException -> 0x08da }
            return r10
        L_0x08da:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.f23772h
            com.google.android.gms.internal.ads.zzku r1 = com.google.android.gms.internal.ads.zzku.m30600a(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m24461f()
            return r10
        L_0x08f6:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Source error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.f23772h
            com.google.android.gms.internal.ads.zzku r1 = com.google.android.gms.internal.ads.zzku.m30598a(r1)
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m24461f()
            return r10
        L_0x0912:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Renderer error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.f23772h
            r3 = 8
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.m24461f()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9866zr.handleMessage(android.os.Message):boolean");
    }

    /* renamed from: a */
    private final void m24444a(int i) {
        if (this.f23786v != i) {
            this.f23786v = i;
            this.f23772h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    /* renamed from: b */
    private final void m24455b(boolean z) {
        if (this.f23785u != z) {
            this.f23785u = z;
            this.f23772h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    /* renamed from: d */
    private final void m24459d() throws zzku {
        this.f23784t = false;
        this.f23769e.mo32224b();
        for (zzlo start : this.f23781q) {
            start.start();
        }
    }

    /* renamed from: e */
    private final void m24460e() throws zzku {
        this.f23769e.mo32225c();
        for (zzlo a : this.f23781q) {
            m24448a(a);
        }
    }

    /* renamed from: g */
    private final void m24462g() throws zzku {
        long j;
        C8757Ar ar = this.f23763F;
        if (ar != null) {
            long a = ar.f20472a.mo28284a();
            if (a != -9223372036854775807L) {
                m24445a(a);
            } else {
                zzlo zzlo = this.f23778n;
                if (zzlo == null || zzlo.mo31953b()) {
                    this.f23760C = this.f23769e.mo31998a();
                } else {
                    this.f23760C = this.f23779o.mo31998a();
                    this.f23769e.mo32222a(this.f23760C);
                }
                a = this.f23760C - this.f23763F.mo28048b();
            }
            this.f23776l.f28772c = a;
            this.f23790z = SystemClock.elapsedRealtime() * 1000;
            if (this.f23781q.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f23763F.f20472a.mo28294b();
            }
            zzle zzle = this.f23776l;
            if (j == Long.MIN_VALUE) {
                j = this.f23764G.mo28170a(this.f23763F.f20478g, this.f23775k, false).f28819d;
            }
            zzle.f28773d = j;
        }
    }

    /* renamed from: a */
    private final void m24446a(long j, long j2) {
        this.f23770f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f23770f.sendEmptyMessage(2);
        } else {
            this.f23770f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    /* renamed from: a */
    private final long m24441a(int i, long j) throws zzku {
        C8757Ar ar;
        m24460e();
        this.f23784t = false;
        m24444a(2);
        C8757Ar ar2 = this.f23763F;
        if (ar2 == null) {
            C8757Ar ar3 = this.f23761D;
            if (ar3 != null) {
                ar3.mo28046a();
            }
            ar = null;
        } else {
            ar = null;
            while (ar2 != null) {
                if (ar2.f20478g != i || !ar2.f20481j) {
                    ar2.mo28046a();
                } else {
                    ar = ar2;
                }
                ar2 = ar2.f20483l;
            }
        }
        C8757Ar ar4 = this.f23763F;
        if (!(ar4 == ar && ar4 == this.f23762E)) {
            for (zzlo c : this.f23781q) {
                c.mo31913c();
            }
            this.f23781q = new zzlo[0];
            this.f23779o = null;
            this.f23778n = null;
            this.f23763F = null;
        }
        if (ar != null) {
            ar.f20483l = null;
            this.f23761D = ar;
            this.f23762E = ar;
            m24453b(ar);
            C8757Ar ar5 = this.f23763F;
            if (ar5.f20482k) {
                j = ar5.f20472a.mo28285a(j);
            }
            m24445a(j);
            m24464i();
        } else {
            this.f23761D = null;
            this.f23762E = null;
            this.f23763F = null;
            m24445a(j);
        }
        this.f23770f.sendEmptyMessage(2);
        return j;
    }

    /* renamed from: a */
    private final void m24445a(long j) throws zzku {
        long j2;
        C8757Ar ar = this.f23763F;
        if (ar == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + ar.mo28048b();
        }
        this.f23760C = j2;
        this.f23769e.mo32222a(this.f23760C);
        for (zzlo a : this.f23781q) {
            a.mo31906a(this.f23760C);
        }
    }

    /* renamed from: f */
    private final void m24461f() {
        m24458c(true);
        this.f23768d.mo30489a();
        m24444a(1);
    }

    /* renamed from: c */
    private final void m24458c(boolean z) {
        zzlo[] zzloArr;
        this.f23770f.removeMessages(2);
        this.f23784t = false;
        this.f23769e.mo32225c();
        this.f23779o = null;
        this.f23778n = null;
        this.f23760C = 60000000;
        for (zzlo zzlo : this.f23781q) {
            try {
                m24448a(zzlo);
                zzlo.mo31913c();
            } catch (zzku | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.f23781q = new zzlo[0];
        C8757Ar ar = this.f23763F;
        if (ar == null) {
            ar = this.f23761D;
        }
        m24447a(ar);
        this.f23761D = null;
        this.f23762E = null;
        this.f23763F = null;
        m24455b(false);
        if (z) {
            zzql zzql = this.f23780p;
            if (zzql != null) {
                zzql.mo32105a();
                this.f23780p = null;
            }
            this.f23764G = null;
        }
    }

    /* renamed from: a */
    private static void m24448a(zzlo zzlo) throws zzku {
        if (zzlo.getState() == 2) {
            zzlo.stop();
        }
    }

    /* renamed from: b */
    private final boolean m24457b(long j) {
        if (j != -9223372036854775807L && this.f23776l.f28772c >= j) {
            C8757Ar ar = this.f23763F.f20483l;
            if (ar == null || !ar.f20481j) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    private final void m24463h() throws IOException {
        C8757Ar ar = this.f23761D;
        if (ar != null && !ar.f20481j) {
            C8757Ar ar2 = this.f23762E;
            if (ar2 == null || ar2.f20483l == ar) {
                zzlo[] zzloArr = this.f23781q;
                int length = zzloArr.length;
                int i = 0;
                while (i < length) {
                    if (zzloArr[i].mo31921k()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f23761D.f20472a.mo28299d();
            }
        }
    }

    /* renamed from: a */
    private final void m24449a(Object obj, int i) {
        this.f23776l = new zzle(0, 0);
        m24454b(obj, i);
        this.f23776l = new zzle(0, -9223372036854775807L);
        m24444a(4);
        m24458c(false);
    }

    /* renamed from: b */
    private final void m24454b(Object obj, int i) {
        this.f23772h.obtainMessage(6, new zzlg(this.f23764G, obj, this.f23776l, i)).sendToTarget();
    }

    /* renamed from: a */
    private final int m24440a(int i, zzlr zzlr, zzlr zzlr2) {
        int c = zzlr.mo28173c();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < c && i3 == -1; i4++) {
            i2 = zzlr.mo31958a(i2, this.f23775k, this.f23774j, this.f23787w);
            i3 = zzlr2.mo28169a(zzlr.mo28170a(i2, this.f23775k, true).f28817b);
        }
        return i3;
    }

    /* renamed from: b */
    private final boolean m24456b(int i) {
        this.f23764G.mo28170a(i, this.f23775k, false);
        if (this.f23764G.mo31959a(0, this.f23774j, false).f28826e || this.f23764G.mo31958a(i, this.f23775k, this.f23774j, this.f23787w) != -1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final Pair<Integer, Long> m24442a(C8778Br br) {
        zzlr zzlr = br.f20523a;
        if (zzlr.mo31960a()) {
            zzlr = this.f23764G;
        }
        try {
            Pair<Integer, Long> b = m24452b(zzlr, br.f20524b, br.f20525c);
            zzlr zzlr2 = this.f23764G;
            if (zzlr2 == zzlr) {
                return b;
            }
            int a = zzlr2.mo28169a(zzlr.mo28170a(((Integer) b.first).intValue(), this.f23775k, true).f28817b);
            if (a != -1) {
                return Pair.create(Integer.valueOf(a), (Long) b.second);
            }
            int a2 = m24440a(((Integer) b.first).intValue(), zzlr, this.f23764G);
            if (a2 == -1) {
                return null;
            }
            this.f23764G.mo28170a(a2, this.f23775k, false);
            return m24451b(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException e) {
            throw new zzlk(this.f23764G, br.f20524b, br.f20525c);
        }
    }

    /* renamed from: b */
    private final Pair<Integer, Long> m24451b(int i, long j) {
        return m24452b(this.f23764G, i, -9223372036854775807L);
    }

    /* renamed from: b */
    private final Pair<Integer, Long> m24452b(zzlr zzlr, int i, long j) {
        return m24443a(zzlr, i, j, 0);
    }

    /* renamed from: a */
    private final Pair<Integer, Long> m24443a(zzlr zzlr, int i, long j, long j2) {
        zzsk.m31077a(i, 0, zzlr.mo28172b());
        zzlr.mo28171a(i, this.f23774j, false, j2);
        if (j == -9223372036854775807L) {
            j = this.f23774j.f28829h;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.f23774j.f28831j + j;
        zzlr.mo28170a(0, this.f23775k, false);
        return Pair.create(Integer.valueOf(0), Long.valueOf(j3));
    }

    /* renamed from: i */
    private final void m24464i() {
        long j;
        C8757Ar ar = this.f23761D;
        if (!ar.f20481j) {
            j = 0;
        } else {
            j = ar.f20472a.mo28297c();
        }
        if (j == Long.MIN_VALUE) {
            m24455b(false);
            return;
        }
        long b = this.f23760C - this.f23761D.mo28048b();
        boolean a = this.f23768d.mo30492a(j - b);
        m24455b(a);
        if (a) {
            this.f23761D.f20472a.mo28296b(b);
        }
    }

    /* renamed from: a */
    private static void m24447a(C8757Ar ar) {
        while (ar != null) {
            ar.mo28046a();
            ar = ar.f20483l;
        }
    }

    /* renamed from: b */
    private final void m24453b(C8757Ar ar) throws zzku {
        if (this.f23763F != ar) {
            boolean[] zArr = new boolean[this.f23765a.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzlo[] zzloArr = this.f23765a;
                if (i < zzloArr.length) {
                    zzlo zzlo = zzloArr[i];
                    zArr[i] = zzlo.getState() != 0;
                    zzrm a = ar.f20484m.f29258b.mo32162a(i);
                    if (a != null) {
                        i2++;
                    }
                    if (zArr[i] && (a == null || (zzlo.mo31919h() && zzlo.mo31920j() == this.f23763F.f20475d[i]))) {
                        if (zzlo == this.f23778n) {
                            this.f23769e.mo32223a(this.f23779o);
                            this.f23779o = null;
                            this.f23778n = null;
                        }
                        m24448a(zzlo);
                        zzlo.mo31913c();
                    }
                    i++;
                } else {
                    this.f23763F = ar;
                    this.f23772h.obtainMessage(3, ar.f20484m).sendToTarget();
                    m24450a(zArr, i2);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m24450a(boolean[] zArr, int i) throws zzku {
        this.f23781q = new zzlo[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzlo[] zzloArr = this.f23765a;
            if (i2 < zzloArr.length) {
                zzlo zzlo = zzloArr[i2];
                zzrm a = this.f23763F.f20484m.f29258b.mo32162a(i2);
                if (a != null) {
                    int i4 = i3 + 1;
                    this.f23781q[i3] = zzlo;
                    if (zzlo.getState() == 0) {
                        zzlq zzlq = this.f23763F.f20484m.f29260d[i2];
                        boolean z = this.f23783s && this.f23786v == 3;
                        boolean z2 = !zArr[i2] && z;
                        zzlh[] zzlhArr = new zzlh[a.length()];
                        for (int i5 = 0; i5 < zzlhArr.length; i5++) {
                            zzlhArr[i5] = a.mo32152b(i5);
                        }
                        C8757Ar ar = this.f23763F;
                        zzlo.mo31908a(zzlq, zzlhArr, ar.f20475d[i2], this.f23760C, z2, ar.mo28048b());
                        zzso f = zzlo.mo31916f();
                        if (f != null) {
                            if (this.f23779o == null) {
                                this.f23779o = f;
                                this.f23778n = zzlo;
                                this.f23779o.mo31999a(this.f23777m);
                            } else {
                                throw zzku.m30600a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzlo.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28512a(zzqx zzqx) {
        this.f23770f.obtainMessage(9, (zzqj) zzqx).sendToTarget();
    }
}
