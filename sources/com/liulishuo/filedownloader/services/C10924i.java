package com.liulishuo.filedownloader.services;

import android.database.sqlite.SQLiteFullException;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.model.C10912b;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import p019d.p307j.p308a.C13072E;
import p019d.p307j.p308a.p309a.C13084a;
import p019d.p307j.p308a.p312d.C13105a;
import p019d.p307j.p308a.p313e.C13113c.C13114a;
import p019d.p307j.p308a.p313e.C13113c.C13116c;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13119f;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: com.liulishuo.filedownloader.services.i */
/* compiled from: FileDownloadRunnable */
public class C10924i implements Runnable {

    /* renamed from: a */
    private int f33371a = 0;

    /* renamed from: b */
    private final boolean f33372b;

    /* renamed from: c */
    private boolean f33373c;

    /* renamed from: d */
    private boolean f33374d;

    /* renamed from: e */
    private Throwable f33375e;

    /* renamed from: f */
    private int f33376f;

    /* renamed from: g */
    private C10912b f33377g;

    /* renamed from: h */
    private volatile boolean f33378h = false;

    /* renamed from: i */
    private volatile boolean f33379i = false;

    /* renamed from: j */
    private final C10922g f33380j;

    /* renamed from: k */
    private final int f33381k;

    /* renamed from: l */
    private final FileDownloadHeader f33382l;

    /* renamed from: m */
    private volatile boolean f33383m = false;

    /* renamed from: n */
    private final int f33384n;

    /* renamed from: o */
    private long f33385o;

    /* renamed from: p */
    private final C13072E f33386p;

    /* renamed from: q */
    private final boolean f33387q;

    /* renamed from: r */
    private final int f33388r;

    /* renamed from: s */
    private final C13116c f33389s;

    /* renamed from: t */
    private final C13114a f33390t;

    /* renamed from: u */
    private long f33391u = 0;

    /* renamed from: v */
    private long f33392v = 0;

    /* renamed from: w */
    private long f33393w = 0;

    /* renamed from: x */
    private long f33394x = 0;

    /* renamed from: y */
    private final Object f33395y = new Object();

    public C10924i(C13072E threadPoolMonitor, C13116c outputStreamCreator, C13114a connectionCreator, C10912b model, C10922g helper, int autoRetryTimes, FileDownloadHeader header, int minIntervalMillis, int callbackProgressTimes, boolean isForceReDownload, boolean isWifiRequired) {
        this.f33388r = model.mo35730d();
        this.f33387q = isWifiRequired;
        this.f33379i = true;
        this.f33378h = false;
        this.f33386p = threadPoolMonitor;
        this.f33389s = outputStreamCreator;
        this.f33380j = helper;
        this.f33382l = header;
        int i = 5;
        if (minIntervalMillis >= 5) {
            i = minIntervalMillis;
        }
        this.f33384n = i;
        this.f33371a = callbackProgressTimes;
        this.f33372b = isForceReDownload;
        this.f33373c = false;
        this.f33377g = model;
        this.f33381k = autoRetryTimes;
        this.f33390t = connectionCreator;
    }

    /* renamed from: b */
    public int mo35810b() {
        return this.f33388r;
    }

    /* renamed from: e */
    public boolean mo35813e() {
        return this.f33379i || this.f33378h;
    }

    /* renamed from: f */
    public boolean mo35814f() {
        return this.f33374d;
    }

    /* renamed from: d */
    public Throwable mo35812d() {
        return this.f33375e;
    }

    /* renamed from: c */
    public int mo35811c() {
        return this.f33376f;
    }

    public void run() {
        String str = "android.permission.ACCESS_NETWORK_STATE";
        Process.setThreadPriority(10);
        this.f33379i = false;
        this.f33378h = true;
        if (this.f33377g == null) {
            C13117d.m42780b(this, "start runnable but model == null?? %s", Integer.valueOf(this.f33388r));
            this.f33377g = this.f33380j.mo35757a(this.f33388r);
            if (this.f33377g == null) {
                C13117d.m42780b(this, "start runnable but downloadMode == null?? %s", Integer.valueOf(this.f33388r));
                this.f33378h = false;
                return;
            }
        }
        try {
            if (this.f33377g.mo35734g() != 1) {
                if (this.f33377g.mo35734g() != -2) {
                    m35908b((Throwable) new RuntimeException(C13121g.m42792a("Task[%d] can't start the download runnable, because its status is %d not %d", Integer.valueOf(this.f33388r), Byte.valueOf(this.f33377g.mo35734g()), Byte.valueOf(1))));
                } else if (C13117d.f40139a) {
                    C13117d.m42778a(this, "High concurrent cause, start runnable but already paused %d", Integer.valueOf(this.f33388r));
                }
            } else if (!this.f33387q || C13121g.m42795a(str)) {
                m35916n();
                m35902a(this.f33377g);
                this.f33378h = false;
            } else {
                m35908b((Throwable) new FileDownloadGiveUpRetryException(C13121g.m42792a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f33388r), str)));
                this.f33378h = false;
            }
        } finally {
            this.f33378h = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x024e A[SYNTHETIC, Splitter:B:134:0x024e] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0223 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0127 A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0134 A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013a A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017a A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0180 A[Catch:{ Throwable -> 0x0241, all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a3 A[Catch:{ Throwable -> 0x023a, all -> 0x0236 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m35902a(com.liulishuo.filedownloader.model.C10912b r25) {
        /*
            r24 = this;
            r8 = r24
            r9 = r25
            r0 = 0
            r1 = 0
            r2 = 0
            r11 = r0
            r10 = r1
        L_0x0009:
            r3 = 0
            int r12 = r8.f33388r
            boolean r0 = r24.m35911i()     // Catch:{ Throwable -> 0x0247 }
            r1 = 2
            r7 = 0
            r5 = 1
            if (r0 == 0) goto L_0x003b
            boolean r0 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ Throwable -> 0x0247 }
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = "already canceled %d %d"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0247 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x0247 }
            r1[r7] = r6     // Catch:{ Throwable -> 0x0247 }
            byte r6 = r25.mo35734g()     // Catch:{ Throwable -> 0x0247 }
            java.lang.Byte r6 = java.lang.Byte.valueOf(r6)     // Catch:{ Throwable -> 0x0247 }
            r1[r5] = r6     // Catch:{ Throwable -> 0x0247 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r8, r0, r1)     // Catch:{ Throwable -> 0x0247 }
        L_0x0031:
            r24.m35915m()     // Catch:{ Throwable -> 0x0247 }
            if (r2 == 0) goto L_0x0266
            r2.mo9292a()
            goto L_0x0266
        L_0x003b:
            boolean r0 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ Throwable -> 0x0247 }
            if (r0 == 0) goto L_0x0054
            java.lang.Class<com.liulishuo.filedownloader.services.i> r0 = com.liulishuo.filedownloader.services.C10924i.class
            java.lang.String r6 = "start download %s %s"
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0247 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x0247 }
            r13[r7] = r14     // Catch:{ Throwable -> 0x0247 }
            java.lang.String r14 = r25.mo35738k()     // Catch:{ Throwable -> 0x0247 }
            r13[r5] = r14     // Catch:{ Throwable -> 0x0247 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r0, r6, r13)     // Catch:{ Throwable -> 0x0247 }
        L_0x0054:
            r24.m35910h()     // Catch:{ Throwable -> 0x0247 }
            d.j.a.e.c$a r0 = r8.f33390t     // Catch:{ Throwable -> 0x0247 }
            java.lang.String r6 = r25.mo35738k()     // Catch:{ Throwable -> 0x0247 }
            d.j.a.a.a r0 = r0.create(r6)     // Catch:{ Throwable -> 0x0247 }
            r13 = r0
            r8.m35903a(r13)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.util.Map r0 = r13.mo9295b()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            boolean r2 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r2 == 0) goto L_0x007c
            java.lang.String r2 = "%s request header %s"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r6[r7] = r14     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r6[r5] = r0     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r8, r2, r6)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
        L_0x007c:
            r13.execute()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            int r2 = r13.mo9298e()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r14 = r2
            r2 = 200(0xc8, float:2.8E-43)
            if (r14 == r2) goto L_0x008d
            if (r14 != 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r2 = 0
            goto L_0x008e
        L_0x008d:
            r2 = 1
        L_0x008e:
            r15 = r2
            r2 = 206(0xce, float:2.89E-43)
            if (r14 == r2) goto L_0x0095
            if (r14 != r5) goto L_0x009b
        L_0x0095:
            boolean r2 = r8.f33373c     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r2 == 0) goto L_0x009b
            r2 = 1
            goto L_0x009c
        L_0x009b:
            r2 = 0
        L_0x009c:
            r16 = r2
            boolean r2 = r8.f33373c     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r2 == 0) goto L_0x00bb
            if (r16 != 0) goto L_0x00bb
            java.lang.String r2 = "tried to resume from the break point[%d], but the response code is %d, not 206(PARTIAL)."
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            long r17 = r25.mo35733f()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r6[r7] = r17     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r14)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r6[r5] = r17     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            p019d.p307j.p308a.p313e.C13117d.m42783e(r8, r2, r6)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
        L_0x00bb:
            if (r15 != 0) goto L_0x0112
            if (r16 == 0) goto L_0x00c0
            goto L_0x0112
        L_0x00c0:
            com.liulishuo.filedownloader.exception.FileDownloadHttpException r2 = new com.liulishuo.filedownloader.exception.FileDownloadHttpException     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.util.Map r6 = r13.mo9297d()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r2.<init>(r14, r0, r6)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r10 != 0) goto L_0x0110
            r10 = 1
            r6 = 416(0x1a0, float:5.83E-43)
            if (r14 != r6) goto L_0x010e
            r24.m35913k()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Class<com.liulishuo.filedownloader.services.i> r6 = com.liulishuo.filedownloader.services.C10924i.class
            java.lang.String r1 = "%d response code %d, range[%d] isn't make sense, so delete the dirty file[%s], and try to redownload it from byte-0."
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Integer r19 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r5[r7] = r19     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r18 = 1
            r5[r18] = r7     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            long r18 = r25.mo35733f()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Long r7 = java.lang.Long.valueOf(r18)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r17 = 2
            r5[r17] = r7     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r7 = 3
            java.lang.String r17 = r25.mo35736i()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r5[r7] = r17     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            p019d.p307j.p308a.p313e.C13117d.m42783e(r6, r1, r5)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            int r1 = r11 + 1
            r8.m35904a(r2, r11)     // Catch:{ Throwable -> 0x0109, all -> 0x0105 }
            goto L_0x022d
        L_0x0105:
            r0 = move-exception
            r11 = r1
            goto L_0x026a
        L_0x0109:
            r0 = move-exception
            r11 = r1
            r2 = r13
            goto L_0x0248
        L_0x010e:
            throw r2     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
        L_0x0110:
            throw r2     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
        L_0x0112:
            long r1 = r25.mo35737j()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.String r5 = "Transfer-Encoding"
            java.lang.String r5 = r13.mo9291a(r5)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r6 = r5
            r19 = 0
            if (r15 != 0) goto L_0x0125
            int r5 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r5 > 0) goto L_0x0136
        L_0x0125:
            if (r6 != 0) goto L_0x0134
            java.lang.String r5 = "Content-Length"
            java.lang.String r5 = r13.mo9291a(r5)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            long r21 = p019d.p307j.p308a.p313e.C13121g.m42798b(r5)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r1 = r21
            goto L_0x0136
        L_0x0134:
            r1 = -1
        L_0x0136:
            int r5 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r5 >= 0) goto L_0x017a
            if (r6 == 0) goto L_0x0146
            java.lang.String r5 = "chunked"
            boolean r5 = r6.equals(r5)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r5 == 0) goto L_0x0146
            r5 = 1
            goto L_0x0147
        L_0x0146:
            r5 = 0
        L_0x0147:
            if (r5 != 0) goto L_0x0177
            d.j.a.e.f r7 = p019d.p307j.p308a.p313e.C13119f.m42785a()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            boolean r7 = r7.f40142c     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r7 == 0) goto L_0x016d
            r1 = -1
            boolean r7 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            if (r7 == 0) goto L_0x016a
            java.lang.String r7 = "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk"
            r19 = r0
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r17 = 0
            r0[r17] = r18     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r8, r7, r0)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            goto L_0x017c
        L_0x016a:
            r19 = r0
            goto L_0x017c
        L_0x016d:
            r19 = r0
            com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException r0 = new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            java.lang.String r7 = "can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties"
            r0.<init>(r7)     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            throw r0     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
        L_0x0177:
            r19 = r0
            goto L_0x017c
        L_0x017a:
            r19 = r0
        L_0x017c:
            r20 = r1
            if (r16 == 0) goto L_0x0187
            long r0 = r25.mo35733f()     // Catch:{ Throwable -> 0x0241, all -> 0x023f }
            r22 = r0
            goto L_0x0189
        L_0x0187:
            r22 = r3
        L_0x0189:
            java.lang.String r5 = r8.m35907b(r13)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            java.lang.String r0 = r8.m35909c(r13)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r1 = r24
            r2 = r16
            r3 = r20
            r18 = r6
            r6 = r0
            r1.m35905a(r2, r3, r5, r6)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            boolean r0 = r25.mo35740m()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r0 == 0) goto L_0x0214
            java.lang.String r0 = r25.mo35738k()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            java.lang.String r1 = r25.mo35735h()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            int r0 = p019d.p307j.p308a.p313e.C13121g.m42797b(r0, r1)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            java.lang.String r1 = r25.mo35735h()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            boolean r2 = r8.f33372b     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r3 = 0
            boolean r1 = p019d.p307j.p308a.p313e.C13113c.m42771a(r12, r1, r2, r3)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r1 == 0) goto L_0x01c8
            com.liulishuo.filedownloader.services.g r1 = r8.f33380j     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r1.remove(r12)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r13 == 0) goto L_0x0228
            r13.mo9292a()
            goto L_0x0228
        L_0x01c8:
            com.liulishuo.filedownloader.services.g r1 = r8.f33380j     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            com.liulishuo.filedownloader.model.b r1 = r1.mo35757a(r0)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r1 == 0) goto L_0x0214
            d.j.a.E r2 = r8.f33386p     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r3 = 0
            boolean r2 = p019d.p307j.p308a.p313e.C13113c.m42770a(r12, r1, r2, r3)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r2 == 0) goto L_0x01e4
            com.liulishuo.filedownloader.services.g r2 = r8.f33380j     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r2.remove(r12)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r13 == 0) goto L_0x0228
            r13.mo9292a()
            goto L_0x0228
        L_0x01e4:
            com.liulishuo.filedownloader.services.g r2 = r8.f33380j     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r2.remove(r0)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r24.m35912j()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            boolean r2 = com.liulishuo.filedownloader.services.C10923h.m35879a(r0, r1)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r2 == 0) goto L_0x0214
            long r2 = r1.mo35733f()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r9.mo35722a(r2)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            long r2 = r1.mo35737j()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r9.mo35726b(r2)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            java.lang.String r2 = r1.mo35719a()     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r9.mo35723a(r2)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            com.liulishuo.filedownloader.services.g r2 = r8.f33380j     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            r2.mo35758a(r9)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r13 == 0) goto L_0x0211
            r13.mo9292a()
        L_0x0211:
            r2 = r13
            goto L_0x0009
        L_0x0214:
            r1 = r24
            r2 = r13
            r3 = r16
            r4 = r22
            r6 = r20
            boolean r0 = r1.m35906a(r2, r3, r4, r6)     // Catch:{ Throwable -> 0x023a, all -> 0x0236 }
            if (r0 == 0) goto L_0x022a
            if (r13 == 0) goto L_0x0228
            r13.mo9292a()
        L_0x0228:
            r2 = r13
            goto L_0x0266
        L_0x022a:
            r1 = r11
            r3 = r22
        L_0x022d:
            if (r13 == 0) goto L_0x0232
            r13.mo9292a()
        L_0x0232:
            r11 = r1
            r2 = r13
            goto L_0x0009
        L_0x0236:
            r0 = move-exception
            r3 = r22
            goto L_0x026a
        L_0x023a:
            r0 = move-exception
            r2 = r13
            r3 = r22
            goto L_0x0248
        L_0x023f:
            r0 = move-exception
            goto L_0x026a
        L_0x0241:
            r0 = move-exception
            r2 = r13
            goto L_0x0248
        L_0x0244:
            r0 = move-exception
            r13 = r2
            goto L_0x026a
        L_0x0247:
            r0 = move-exception
        L_0x0248:
            int r1 = r8.f33381k     // Catch:{ all -> 0x0244 }
            int r5 = r11 + 1
            if (r1 <= r11) goto L_0x025d
            boolean r1 = r0 instanceof com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException     // Catch:{ all -> 0x0267 }
            if (r1 != 0) goto L_0x025d
            r8.m35904a(r0, r5)     // Catch:{ all -> 0x0267 }
            if (r2 == 0) goto L_0x025a
            r2.mo9292a()
        L_0x025a:
            r11 = r5
            goto L_0x0009
        L_0x025d:
            r8.m35908b(r0)     // Catch:{ all -> 0x0267 }
            if (r2 == 0) goto L_0x0265
            r2.mo9292a()
        L_0x0265:
            r11 = r5
        L_0x0266:
            return
        L_0x0267:
            r0 = move-exception
            r13 = r2
            r11 = r5
        L_0x026a:
            if (r13 == 0) goto L_0x026f
            r13.mo9292a()
        L_0x026f:
            goto L_0x0271
        L_0x0270:
            throw r0
        L_0x0271:
            goto L_0x0270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.C10924i.m35902a(com.liulishuo.filedownloader.model.b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (r8 != -1) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r1 != r4) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        m35917o();
        r7.f33380j.remove(r7.f33388r);
        m35899a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r12 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r11 == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r11.mo42085a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r11 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        if (r11 == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        throw new java.lang.RuntimeException(p019d.p307j.p308a.p313e.C13121g.m42792a("sofar[%d] not equal total[%d]", java.lang.Long.valueOf(r1), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc A[SYNTHETIC, Splitter:B:68:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00da  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m35906a(p019d.p307j.p308a.p309a.C13084a r19, boolean r20, long r21, long r23) throws java.lang.Throwable {
        /*
            r18 = this;
            r7 = r18
            r8 = r23
            r1 = 0
            r10 = r20
            d.j.a.d.a r11 = r7.m35896a(r10, r8)
            java.io.InputStream r0 = r19.mo9296c()     // Catch:{ all -> 0x00c0 }
            r12 = r0
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00bb }
            r13 = r0
            int r0 = r7.f33371a     // Catch:{ all -> 0x00bb }
            long r0 = (long) r0     // Catch:{ all -> 0x00bb }
            long r0 = r7.m35895a(r8, r0)     // Catch:{ all -> 0x00bb }
            r7.f33385o = r0     // Catch:{ all -> 0x00bb }
            r1 = r21
        L_0x0020:
            int r0 = r12.read(r13)     // Catch:{ all -> 0x00b8 }
            r14 = r0
            r0 = -1
            r3 = 0
            r15 = 1
            if (r14 != r0) goto L_0x007c
            r4 = -1
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0033
            r4 = r1
            goto L_0x0034
        L_0x0033:
            r4 = r8
        L_0x0034:
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x005f
            r18.m35917o()     // Catch:{ all -> 0x007a }
            com.liulishuo.filedownloader.services.g r0 = r7.f33380j     // Catch:{ all -> 0x007a }
            int r3 = r7.f33388r     // Catch:{ all -> 0x007a }
            r0.remove(r3)     // Catch:{ all -> 0x007a }
            r7.m35899a(r4)     // Catch:{ all -> 0x007a }
            if (r12 == 0) goto L_0x004b
            r12.close()
        L_0x004b:
            if (r11 == 0) goto L_0x0059
            r11.mo42085a()     // Catch:{ all -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r0 = move-exception
            r3 = r0
            if (r11 == 0) goto L_0x0058
            r11.close()
        L_0x0058:
            throw r3
        L_0x0059:
            if (r11 == 0) goto L_0x005e
            r11.close()
        L_0x005e:
            return r15
        L_0x005f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x007a }
            java.lang.String r6 = "sofar[%d] not equal total[%d]"
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x007a }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x007a }
            r8[r3] = r9     // Catch:{ all -> 0x007a }
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x007a }
            r8[r15] = r3     // Catch:{ all -> 0x007a }
            java.lang.String r3 = p019d.p307j.p308a.p313e.C13121g.m42792a(r6, r8)     // Catch:{ all -> 0x007a }
            r0.<init>(r3)     // Catch:{ all -> 0x007a }
            throw r0     // Catch:{ all -> 0x007a }
        L_0x007a:
            r0 = move-exception
            goto L_0x00c5
        L_0x007c:
            r11.write(r13, r3, r14)     // Catch:{ all -> 0x00b8 }
            long r3 = (long) r14
            long r16 = r1 + r3
            r1 = r18
            r2 = r16
            r4 = r23
            r6 = r11
            r1.m35900a(r2, r4, r6)     // Catch:{ all -> 0x00b3 }
            boolean r0 = r18.m35911i()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x00af
            r18.m35915m()     // Catch:{ all -> 0x00b3 }
            if (r12 == 0) goto L_0x009b
            r12.close()
        L_0x009b:
            if (r11 == 0) goto L_0x00a9
            r11.mo42085a()     // Catch:{ all -> 0x00a1 }
            goto L_0x00a9
        L_0x00a1:
            r0 = move-exception
            r1 = r0
            if (r11 == 0) goto L_0x00a8
            r11.close()
        L_0x00a8:
            throw r1
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            r11.close()
        L_0x00ae:
            return r15
        L_0x00af:
            r1 = r16
            goto L_0x0020
        L_0x00b3:
            r0 = move-exception
            r4 = r8
            r1 = r16
            goto L_0x00c5
        L_0x00b8:
            r0 = move-exception
            r4 = r8
            goto L_0x00c5
        L_0x00bb:
            r0 = move-exception
            r1 = r21
            r4 = r8
            goto L_0x00c5
        L_0x00c0:
            r0 = move-exception
            r12 = r1
            r4 = r8
            r1 = r21
        L_0x00c5:
            if (r12 == 0) goto L_0x00ca
            r12.close()
        L_0x00ca:
            if (r11 == 0) goto L_0x00d8
            r11.mo42085a()     // Catch:{ all -> 0x00d0 }
            goto L_0x00d8
        L_0x00d0:
            r0 = move-exception
            r3 = r0
            if (r11 == 0) goto L_0x00d7
            r11.close()
        L_0x00d7:
            throw r3
        L_0x00d8:
            if (r11 == 0) goto L_0x00dd
            r11.close()
        L_0x00dd:
            goto L_0x00df
        L_0x00de:
            throw r0
        L_0x00df:
            goto L_0x00de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.C10924i.m35906a(d.j.a.a.a, boolean, long, long):boolean");
    }

    /* renamed from: o */
    private void m35917o() {
        String str = "delete the temp file(%s) failed, on completed downloading.";
        String tempPath = this.f33377g.mo35736i();
        String targetPath = this.f33377g.mo35735h();
        File tempFile = new File(tempPath);
        try {
            File targetFile = new File(targetPath);
            if (targetFile.exists()) {
                long oldTargetFileLength = targetFile.length();
                if (targetFile.delete()) {
                    C13117d.m42783e(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetPath, Long.valueOf(oldTargetFileLength), Long.valueOf(tempFile.length()));
                } else {
                    throw new IllegalStateException(C13121g.m42792a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetPath, Long.valueOf(oldTargetFileLength)));
                }
            }
            if (!tempFile.renameTo(targetFile)) {
                throw new IllegalStateException(C13121g.m42792a("Can't rename the  temp downloaded file(%s) to the target file(%s)", tempPath, targetPath));
            }
        } finally {
            if (tempFile.exists() && !tempFile.delete()) {
                C13117d.m42783e(this, str, tempPath);
            }
        }
    }

    /* renamed from: a */
    private long m35895a(long total, long maxProgressCount) {
        if (maxProgressCount <= 0) {
            return -1;
        }
        long j = 1;
        if (total == -1) {
            return 1;
        }
        long minIntervalBytes = total / (maxProgressCount + 1);
        if (minIntervalBytes > 0) {
            j = minIntervalBytes;
        }
        return j;
    }

    /* renamed from: a */
    private void m35903a(C13084a connection) {
        FileDownloadHeader fileDownloadHeader = this.f33382l;
        if (fileDownloadHeader != null) {
            HashMap<String, List<String>> additionHeaders = fileDownloadHeader.mo35712a();
            if (additionHeaders != null) {
                if (C13117d.f40139a) {
                    C13117d.m42782d(this, "%d add outside header: %s", Integer.valueOf(this.f33388r), additionHeaders);
                }
                for (Entry<String, List<String>> e : additionHeaders.entrySet()) {
                    String name = (String) e.getKey();
                    List<String> list = (List) e.getValue();
                    if (list != null) {
                        for (String value : list) {
                            connection.addHeader(name, value);
                        }
                    }
                }
            }
        }
        String etag = this.f33377g.mo35719a();
        long offset = this.f33377g.mo35733f();
        if (this.f33373c && !connection.mo9293a(etag, offset)) {
            if (!TextUtils.isEmpty(etag)) {
                connection.addHeader("If-Match", etag);
            }
            connection.addHeader("Range", C13121g.m42792a("bytes=%d-", Long.valueOf(offset)));
        }
    }

    /* renamed from: b */
    private String m35907b(C13084a connection) {
        if (connection != null) {
            String newEtag = connection.mo9291a("Etag");
            if (C13117d.f40139a) {
                C13117d.m42778a(this, "etag find by header %d %s", Integer.valueOf(this.f33388r), newEtag);
            }
            return newEtag;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    /* renamed from: c */
    private String m35909c(C13084a connection) {
        if (!this.f33377g.mo35740m() || this.f33377g.mo35728c() != null) {
            return null;
        }
        String filename = C13121g.m42811j(connection.mo9291a("Content-Disposition"));
        if (TextUtils.isEmpty(filename)) {
            return C13121g.m42801c(this.f33377g.mo35738k());
        }
        return filename;
    }

    /* renamed from: a */
    public void mo35809a() {
        this.f33383m = true;
        m35915m();
    }

    /* renamed from: a */
    private void m35905a(boolean resuming, long total, String etag, String filename) {
        this.f33380j.mo35760a(this.f33377g, total, etag, filename);
        this.f33374d = resuming;
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: a */
    private void m35900a(long soFar, long total, C13105a outputStream) {
        long j = soFar;
        if (j != total) {
            long now = SystemClock.elapsedRealtime();
            long timeDelta = now - this.f33394x;
            if (j - this.f33393w <= ((long) C13121g.m42796b()) || timeDelta <= C13121g.m42800c()) {
                if (this.f33377g.mo35734g() != 3) {
                    this.f33377g.mo35720a(3);
                }
                this.f33377g.mo35722a(j);
            } else {
                try {
                    outputStream.mo42085a();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.f33380j.mo35764b(this.f33377g, j);
                this.f33393w = j;
                this.f33394x = now;
            }
            long callbackBytesDelta = j - this.f33391u;
            long callbackTimeDelta = now - this.f33392v;
            long j2 = this.f33385o;
            if (j2 != -1 && callbackBytesDelta >= j2 && callbackTimeDelta >= ((long) this.f33384n)) {
                this.f33392v = now;
                this.f33391u = j;
                if (C13117d.f40139a) {
                    C13117d.m42778a(this, "On progress %d %d %d", Integer.valueOf(this.f33388r), Long.valueOf(soFar), Long.valueOf(total));
                }
                m35898a(this.f33377g.mo35734g());
            }
        }
    }

    /* renamed from: a */
    private void m35904a(Throwable ex, int retryTimes) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "On retry %d %s %d %d", Integer.valueOf(this.f33388r), ex, Integer.valueOf(retryTimes), Integer.valueOf(this.f33381k));
        }
        Throwable ex2 = m35897a(ex);
        this.f33380j.mo35761a(this.f33377g, ex2);
        this.f33375e = ex2;
        this.f33376f = retryTimes;
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: b */
    private void m35908b(Throwable originError) {
        Throwable processError;
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "On error %d %s", Integer.valueOf(this.f33388r), originError);
        }
        Throwable processError2 = m35897a(originError);
        if (processError2 instanceof SQLiteFullException) {
            m35901a((SQLiteFullException) processError2);
            processError = processError2;
        } else {
            try {
                this.f33380j.mo35762a(this.f33377g, processError2, this.f33377g.mo35733f());
                processError = originError;
            } catch (SQLiteFullException fullException) {
                SQLiteFullException sQLiteFullException = fullException;
                m35901a(sQLiteFullException);
                processError = sQLiteFullException;
            }
        }
        this.f33375e = processError;
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: a */
    private void m35901a(SQLiteFullException sqLiteFullException) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(this.f33388r), sqLiteFullException.toString());
        }
        this.f33377g.mo35727b(sqLiteFullException.toString());
        this.f33377g.mo35720a(-1);
        this.f33380j.remove(this.f33388r);
    }

    /* renamed from: a */
    private void m35899a(long total) {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "On completed %d %d %B", Integer.valueOf(this.f33388r), Long.valueOf(total), Boolean.valueOf(this.f33383m));
        }
        this.f33380j.mo35759a(this.f33377g, total);
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: m */
    private void m35915m() {
        this.f33378h = false;
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "On paused %d %d %d", Integer.valueOf(this.f33388r), Long.valueOf(this.f33377g.mo35733f()), Long.valueOf(this.f33377g.mo35737j()));
        }
        C10922g gVar = this.f33380j;
        C10912b bVar = this.f33377g;
        gVar.mo35766c(bVar, bVar.mo35733f());
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: n */
    private void m35916n() {
        this.f33377g.mo35720a(6);
        m35898a(this.f33377g.mo35734g());
    }

    /* renamed from: g */
    public void mo35815g() {
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "On resume %d", Integer.valueOf(this.f33388r));
        }
        this.f33379i = true;
        this.f33380j.mo35763b(this.f33377g);
        m35898a(this.f33377g.mo35734g());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m35898a(byte r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f33395y
            monitor-enter(r0)
            com.liulishuo.filedownloader.model.b r1 = r5.f33377g     // Catch:{ all -> 0x0032 }
            byte r1 = r1.mo35734g()     // Catch:{ all -> 0x0032 }
            r2 = -2
            if (r1 != r2) goto L_0x0023
            boolean r1 = p019d.p307j.p308a.p313e.C13117d.f40139a     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0032 }
            r3 = 0
            int r4 = r5.f33388r     // Catch:{ all -> 0x0032 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0032 }
            r2[r3] = r4     // Catch:{ all -> 0x0032 }
            p019d.p307j.p308a.p313e.C13117d.m42778a(r5, r1, r2)     // Catch:{ all -> 0x0032 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0023:
            com.liulishuo.filedownloader.message.d r1 = com.liulishuo.filedownloader.message.C10904d.m35756a()     // Catch:{ all -> 0x0032 }
            com.liulishuo.filedownloader.model.b r2 = r5.f33377g     // Catch:{ all -> 0x0032 }
            com.liulishuo.filedownloader.message.MessageSnapshot r2 = com.liulishuo.filedownloader.message.C10907e.m35761a(r6, r2, r5)     // Catch:{ all -> 0x0032 }
            r1.mo35705a(r2)     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.C10924i.m35898a(byte):void");
    }

    /* renamed from: i */
    private boolean m35911i() {
        if (this.f33383m) {
            return true;
        }
        if (!this.f33387q || C13121g.m42805d()) {
            return false;
        }
        throw new FileDownloadNetworkPolicyException();
    }

    /* renamed from: a */
    private C13105a m35896a(boolean append, long totalBytes) throws IOException, IllegalAccessException {
        long j = totalBytes;
        String tempPath = this.f33377g.mo35736i();
        if (TextUtils.isEmpty(tempPath)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        } else if (C13121g.m42810i(tempPath)) {
            File file = new File(tempPath);
            if (file.exists() && file.isDirectory()) {
                throw new RuntimeException(C13121g.m42792a("found invalid internal destination path[%s], & path is directory[%B]", tempPath, Boolean.valueOf(file.isDirectory())));
            } else if (file.exists() || file.createNewFile()) {
                C13105a outputStream = this.f33389s.mo42090a(file);
                if (j > 0) {
                    long breakpointBytes = file.length();
                    long requiredSpaceBytes = j - breakpointBytes;
                    long freeSpaceBytes = C13121g.m42806e(tempPath);
                    if (freeSpaceBytes < requiredSpaceBytes) {
                        outputStream.close();
                        FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException = new FileDownloadOutOfSpaceException(freeSpaceBytes, requiredSpaceBytes, breakpointBytes);
                        throw fileDownloadOutOfSpaceException;
                    } else if (!C13119f.m42785a().f40145f) {
                        outputStream.mo42086a(j);
                    }
                }
                if (append && this.f33389s.mo42091a()) {
                    outputStream.mo42087b(this.f33377g.mo35733f());
                }
                return outputStream;
            } else {
                throw new IOException(C13121g.m42792a("create new file error  %s", file.getAbsolutePath()));
            }
        } else {
            throw new RuntimeException(C13121g.m42792a("found invalid internal destination filename %s", tempPath));
        }
    }

    /* renamed from: h */
    private void m35910h() {
        boolean outputStreamSupportSeek = this.f33389s.mo42091a();
        if (C10923h.m35880a(this.f33388r, this.f33377g, Boolean.valueOf(outputStreamSupportSeek))) {
            this.f33373c = true;
            if (!outputStreamSupportSeek) {
                C10912b bVar = this.f33377g;
                bVar.mo35722a(new File(bVar.mo35736i()).length());
                return;
            }
            return;
        }
        this.f33373c = false;
        m35913k();
    }

    /* renamed from: k */
    private void m35913k() {
        m35914l();
        m35912j();
    }

    /* renamed from: l */
    private void m35914l() {
        String tempFilePath = this.f33377g.mo35736i();
        if (tempFilePath != null) {
            File tempFile = new File(tempFilePath);
            if (tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

    /* renamed from: j */
    private void m35912j() {
        String targetFilePath = this.f33377g.mo35735h();
        if (targetFilePath != null) {
            File targetFile = new File(targetFilePath);
            if (targetFile.exists()) {
                targetFile.delete();
            }
        }
    }

    /* renamed from: a */
    private Throwable m35897a(Throwable ex) {
        long downloadedSize;
        Throwable th = ex;
        String tempPath = this.f33377g.mo35736i();
        if ((this.f33377g.mo35737j() == -1 || C13119f.m42785a().f40145f) && (th instanceof IOException) && new File(tempPath).exists()) {
            long freeSpaceBytes = C13121g.m42806e(tempPath);
            if (freeSpaceBytes <= 4096) {
                File file = new File(tempPath);
                if (!file.exists()) {
                    C13117d.m42779a((Object) C10924i.class, th, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
                    downloadedSize = 0;
                } else {
                    downloadedSize = file.length();
                }
                if (VERSION.SDK_INT >= 9) {
                    FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException = new FileDownloadOutOfSpaceException(freeSpaceBytes, 4096, downloadedSize, ex);
                    return fileDownloadOutOfSpaceException;
                }
                FileDownloadOutOfSpaceException fileDownloadOutOfSpaceException2 = new FileDownloadOutOfSpaceException(freeSpaceBytes, 4096, downloadedSize);
                return fileDownloadOutOfSpaceException2;
            }
        }
        return th;
    }
}
