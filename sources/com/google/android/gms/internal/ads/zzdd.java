package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbk.zza;
import com.google.android.gms.internal.ads.zzbp.zza.C15005zza;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzdd implements zzdc {

    /* renamed from: a */
    protected static volatile zzdy f27794a = null;

    /* renamed from: b */
    protected MotionEvent f27795b;

    /* renamed from: c */
    protected LinkedList<MotionEvent> f27796c = new LinkedList<>();

    /* renamed from: d */
    protected long f27797d = 0;

    /* renamed from: e */
    protected long f27798e = 0;

    /* renamed from: f */
    protected long f27799f = 0;

    /* renamed from: g */
    protected long f27800g = 0;

    /* renamed from: h */
    protected long f27801h = 0;

    /* renamed from: i */
    protected long f27802i = 0;

    /* renamed from: j */
    protected long f27803j = 0;

    /* renamed from: k */
    protected double f27804k;

    /* renamed from: l */
    private double f27805l;

    /* renamed from: m */
    private double f27806m;

    /* renamed from: n */
    protected float f27807n;

    /* renamed from: o */
    protected float f27808o;

    /* renamed from: p */
    protected float f27809p;

    /* renamed from: q */
    protected float f27810q;

    /* renamed from: r */
    private boolean f27811r = false;

    /* renamed from: s */
    protected boolean f27812s = false;

    /* renamed from: t */
    protected DisplayMetrics f27813t;

    protected zzdd(Context context) {
        try {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24163rc)).booleanValue()) {
                C9318aj.m23433a();
            } else {
                C8777Bq.m22322a(f27794a);
            }
            this.f27813t = context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract long mo31391a(StackTraceElement[] stackTraceElementArr) throws zzdv;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C15005zza mo31392a(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C15005zza mo31393a(Context context, zza zza);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzee mo31394a(MotionEvent motionEvent) throws zzdv;

    public final String zza(Context context) {
        if (zzef.m30168a()) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24175tc)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return m29199a(context, null, false, null, null, null);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return m29199a(context, str, true, view, activity, null);
    }

    public void zzb(View view) {
    }

    public final void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f27811r) {
            this.f27800g = 0;
            this.f27799f = 0;
            this.f27798e = 0;
            this.f27797d = 0;
            this.f27801h = 0;
            this.f27803j = 0;
            this.f27802i = 0;
            Iterator it = this.f27796c.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.f27796c.clear();
            this.f27795b = null;
            this.f27811r = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f27804k = 0.0d;
            this.f27805l = (double) motionEvent.getRawX();
            this.f27806m = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.f27805l;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.f27806m;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.f27804k += Math.sqrt((d2 * d2) + (d4 * d4));
            this.f27805l = rawX;
            this.f27806m = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.f27807n = motionEvent.getX();
            this.f27808o = motionEvent.getY();
            this.f27809p = motionEvent.getRawX();
            this.f27810q = motionEvent.getRawY();
            this.f27797d++;
        } else if (action2 == 1) {
            this.f27795b = MotionEvent.obtain(motionEvent);
            this.f27796c.add(this.f27795b);
            if (this.f27796c.size() > 6) {
                ((MotionEvent) this.f27796c.remove()).recycle();
            }
            this.f27799f++;
            try {
                this.f27801h = mo31391a(new Throwable().getStackTrace());
            } catch (zzdv e) {
            }
        } else if (action2 == 2) {
            this.f27798e += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzee a = mo31394a(motionEvent);
                if ((a == null || a.f28346e == null || a.f28349h == null) ? false : true) {
                    this.f27802i += a.f28346e.longValue() + a.f28349h.longValue();
                }
                if (!(this.f27813t == null || a == null || a.f28347f == null || a.f28350i == null)) {
                    z = true;
                }
                if (z) {
                    this.f27803j += a.f28347f.longValue() + a.f28350i.longValue();
                }
            } catch (zzdv e2) {
            }
        } else if (action2 == 3) {
            this.f27800g++;
        }
        this.f27812s = true;
    }

    public final void zza(int i, int i2, int i3) {
        MotionEvent motionEvent = this.f27795b;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        DisplayMetrics displayMetrics = this.f27813t;
        if (displayMetrics != null) {
            long j = (long) i3;
            float f = (float) i;
            float f2 = displayMetrics.density;
            this.f27795b = MotionEvent.obtain(0, j, 1, f * f2, ((float) i2) * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f27795b = null;
        }
        this.f27812s = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[SYNTHETIC, Splitter:B:16:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048 A[Catch:{ Exception -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[SYNTHETIC, Splitter:B:33:0x0075] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m29199a(android.content.Context r10, java.lang.String r11, boolean r12, android.view.View r13, android.app.Activity r14, byte[] r15) {
        /*
            r9 = this;
            r0 = 0
            if (r15 == 0) goto L_0x0012
            int r1 = r15.length
            if (r1 <= 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzdno r1 = com.google.android.gms.internal.ads.zzdno.m29867c()     // Catch:{ zzdok -> 0x0011 }
            com.google.android.gms.internal.ads.zzbk$zza r15 = com.google.android.gms.internal.ads.zzbk.zza.m27125a(r15, r1)     // Catch:{ zzdok -> 0x0011 }
            goto L_0x0013
        L_0x0011:
            r15 = move-exception
        L_0x0012:
            r15 = r0
        L_0x0013:
            com.google.android.gms.internal.ads.zzdy r1 = f27794a
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzacu.f24103hc
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r1 = r2.mo29599a(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzdy r1 = f27794a
            com.google.android.gms.internal.ads.zzda r1 = r1.mo31721i()
            goto L_0x0032
        L_0x0031:
            r1 = r0
        L_0x0032:
            long r2 = java.lang.System.currentTimeMillis()
            r8 = -1
            if (r12 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r9.mo31392a(r10, r13, r14)     // Catch:{ Exception -> 0x0058 }
            r10 = 1
            r9.f27811r = r10     // Catch:{ Exception -> 0x0058 }
            goto L_0x0046
        L_0x0041:
            com.google.android.gms.internal.ads.zzbp$zza$zza r10 = r9.mo31393a(r10, r15)     // Catch:{ Exception -> 0x0058 }
            r0 = r10
        L_0x0046:
            if (r1 == 0) goto L_0x0057
            if (r12 == 0) goto L_0x004d
            r10 = 1002(0x3ea, float:1.404E-42)
            goto L_0x004f
        L_0x004d:
            r10 = 1000(0x3e8, float:1.401E-42)
        L_0x004f:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0058 }
            long r13 = r13 - r2
            r1.mo31337a(r10, r8, r13)     // Catch:{ Exception -> 0x0058 }
        L_0x0057:
            goto L_0x006f
        L_0x0058:
            r10 = move-exception
            r7 = r10
            if (r1 == 0) goto L_0x006f
            if (r12 == 0) goto L_0x0061
            r10 = 1003(0x3eb, float:1.406E-42)
            goto L_0x0063
        L_0x0061:
            r10 = 1001(0x3e9, float:1.403E-42)
        L_0x0063:
            r4 = -1
            long r13 = java.lang.System.currentTimeMillis()
            long r5 = r13 - r2
            r2 = r1
            r3 = r10
            r2.mo31338a(r3, r4, r5, r7)
        L_0x006f:
            long r13 = java.lang.System.currentTimeMillis()
            if (r0 == 0) goto L_0x00a3
            com.google.android.gms.internal.ads.zzdpk r10 = r0.mo31612g()     // Catch:{ Exception -> 0x00a9 }
            com.google.android.gms.internal.ads.zzdob r10 = (com.google.android.gms.internal.ads.zzdob) r10     // Catch:{ Exception -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbp$zza r10 = (com.google.android.gms.internal.ads.zzbp.zza) r10     // Catch:{ Exception -> 0x00a9 }
            int r10 = r10.mo31603c()     // Catch:{ Exception -> 0x00a9 }
            if (r10 != 0) goto L_0x0084
            goto L_0x00a3
        L_0x0084:
            com.google.android.gms.internal.ads.zzdpk r10 = r0.mo31612g()     // Catch:{ Exception -> 0x00a9 }
            com.google.android.gms.internal.ads.zzdob r10 = (com.google.android.gms.internal.ads.zzdob) r10     // Catch:{ Exception -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbp$zza r10 = (com.google.android.gms.internal.ads.zzbp.zza) r10     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r10 = com.google.android.gms.internal.ads.C9318aj.m23430a(r10, r11)     // Catch:{ Exception -> 0x00a9 }
            if (r1 == 0) goto L_0x00a2
            if (r12 == 0) goto L_0x0098
            r11 = 1006(0x3ee, float:1.41E-42)
            goto L_0x009a
        L_0x0098:
            r11 = 1004(0x3ec, float:1.407E-42)
        L_0x009a:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a9 }
            long r2 = r2 - r13
            r1.mo31337a(r11, r8, r2)     // Catch:{ Exception -> 0x00a9 }
        L_0x00a2:
            goto L_0x00c8
        L_0x00a3:
            r10 = 5
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00c8
        L_0x00a9:
            r10 = move-exception
            r7 = r10
            r10 = 7
            java.lang.String r10 = java.lang.Integer.toString(r10)
            if (r1 == 0) goto L_0x00c8
            if (r12 == 0) goto L_0x00b9
            r11 = 1007(0x3ef, float:1.411E-42)
            r3 = 1007(0x3ef, float:1.411E-42)
            goto L_0x00bd
        L_0x00b9:
            r11 = 1005(0x3ed, float:1.408E-42)
            r3 = 1005(0x3ed, float:1.408E-42)
        L_0x00bd:
            r4 = -1
            long r11 = java.lang.System.currentTimeMillis()
            long r5 = r11 - r13
            r2 = r1
            r2.mo31338a(r3, r4, r5, r7)
        L_0x00c8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.m29199a(android.content.Context, java.lang.String, boolean, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }
}
