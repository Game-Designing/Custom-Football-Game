package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
public final class zztl {

    /* renamed from: a */
    private final C9372ct f29407a;

    /* renamed from: b */
    private final boolean f29408b;

    /* renamed from: c */
    private final long f29409c;

    /* renamed from: d */
    private final long f29410d;

    /* renamed from: e */
    private long f29411e;

    /* renamed from: f */
    private long f29412f;

    /* renamed from: g */
    private long f29413g;

    /* renamed from: h */
    private boolean f29414h;

    /* renamed from: i */
    private long f29415i;

    /* renamed from: j */
    private long f29416j;

    /* renamed from: k */
    private long f29417k;

    public zztl() {
        this(-1.0d);
    }

    public zztl(Context context) {
        double d;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            d = (double) windowManager.getDefaultDisplay().getRefreshRate();
        } else {
            d = -1.0d;
        }
        this(d);
    }

    private zztl(double d) {
        this.f29408b = d != -1.0d;
        if (this.f29408b) {
            this.f29407a = C9372ct.m23514a();
            this.f29409c = (long) (1.0E9d / d);
            this.f29410d = (this.f29409c * 80) / 100;
            return;
        }
        this.f29407a = null;
        this.f29409c = -1;
        this.f29410d = -1;
    }

    /* renamed from: b */
    public final void mo32235b() {
        this.f29414h = false;
        if (this.f29408b) {
            this.f29407a.mo28903b();
        }
    }

    /* renamed from: a */
    public final void mo32234a() {
        if (this.f29408b) {
            this.f29407a.mo28904c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long mo32233a(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.f29414h
            if (r2 == 0) goto L_0x0045
            long r2 = r11.f29411e
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x001b
            long r2 = r11.f29417k
            r4 = 1
            long r2 = r2 + r4
            r11.f29417k = r2
            long r2 = r11.f29413g
            r11.f29412f = r2
        L_0x001b:
            long r2 = r11.f29417k
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003d
            long r4 = r11.f29416j
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.f29412f
            long r2 = r2 + r4
            boolean r4 = r11.m31199b(r2, r14)
            if (r4 == 0) goto L_0x0035
            r11.f29414h = r6
            goto L_0x0045
        L_0x0035:
            long r4 = r11.f29415i
            long r4 = r4 + r2
            long r6 = r11.f29416j
            long r4 = r4 - r6
            goto L_0x0047
        L_0x003d:
            boolean r2 = r11.m31199b(r0, r14)
            if (r2 == 0) goto L_0x0045
            r11.f29414h = r6
        L_0x0045:
            r4 = r14
            r2 = r0
        L_0x0047:
            boolean r6 = r11.f29414h
            r7 = 0
            if (r6 != 0) goto L_0x0056
            r11.f29416j = r0
            r11.f29415i = r14
            r11.f29417k = r7
            r14 = 1
            r11.f29414h = r14
        L_0x0056:
            r11.f29411e = r12
            r11.f29413g = r2
            com.google.android.gms.internal.ads.ct r12 = r11.f29407a
            if (r12 == 0) goto L_0x008a
            long r12 = r12.f22168b
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L_0x0065
            goto L_0x008a
        L_0x0065:
            com.google.android.gms.internal.ads.ct r12 = r11.f29407a
            long r12 = r12.f22168b
            long r14 = r11.f29409c
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x0078
            long r14 = r12 - r14
            goto L_0x007d
        L_0x0078:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L_0x007d:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r12 = r14
        L_0x0086:
            long r14 = r11.f29410d
            long r12 = r12 - r14
            return r12
        L_0x008a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztl.mo32233a(long, long):long");
    }

    /* renamed from: b */
    private final boolean m31199b(long j, long j2) {
        return Math.abs((j2 - this.f29415i) - (j - this.f29416j)) > 20000000;
    }
}
