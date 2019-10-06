package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzakh {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Object f24384a;

    /* renamed from: b */
    private final Context f24385b;

    /* renamed from: c */
    private final String f24386c;

    /* renamed from: d */
    private final zzbai f24387d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzayp<zzajw> f24388e;

    /* renamed from: f */
    private zzayp<zzajw> f24389f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public zzala f24390g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f24391h;

    public zzakh(Context context, zzbai zzbai, String str) {
        this.f24384a = new Object();
        this.f24391h = 1;
        this.f24386c = str;
        this.f24385b = context.getApplicationContext();
        this.f24387d = zzbai;
        this.f24388e = new zzakv();
        this.f24389f = new zzakv();
    }

    public zzakh(Context context, zzbai zzbai, String str, zzayp<zzajw> zzayp, zzayp<zzajw> zzayp2) {
        this(context, zzbai, str);
        this.f24388e = zzayp;
        this.f24389f = zzayp2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzala mo29793a(zzdh zzdh) {
        zzala zzala = new zzala(this.f24389f);
        zzbbm.f25064a.execute(new C9507ja(this, zzdh, zzala));
        zzala.mo30344a(new C9723ta(this, zzala), new C9744ua(this, zzala));
        return zzala;
    }

    /* renamed from: b */
    public final zzakw mo29797b(zzdh zzdh) {
        synchronized (this.f24384a) {
            synchronized (this.f24384a) {
                if (this.f24390g != null && this.f24391h == 0) {
                    if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24106i)).booleanValue()) {
                        this.f24390g.mo30344a(new C9529ka(this), C9551la.f22708a);
                    }
                }
            }
            if (this.f24390g != null) {
                if (this.f24390g.mo30343a() != -1) {
                    if (this.f24391h == 0) {
                        zzakw c = this.f24390g.mo29801c();
                        return c;
                    } else if (this.f24391h == 1) {
                        this.f24391h = 2;
                        mo29793a((zzdh) null);
                        zzakw c2 = this.f24390g.mo29801c();
                        return c2;
                    } else if (this.f24391h == 2) {
                        zzakw c3 = this.f24390g.mo29801c();
                        return c3;
                    } else {
                        zzakw c4 = this.f24390g.mo29801c();
                        return c4;
                    }
                }
            }
            this.f24391h = 2;
            this.f24390g = mo29793a((zzdh) null);
            zzakw c5 = this.f24390g.mo29801c();
            return c5;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo29794a(zzajw zzajw) {
        if (zzajw.isDestroyed()) {
            this.f24391h = 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo29796a(zzdh zzdh, zzala zzala) {
        zzajw zzajw;
        try {
            Context context = this.f24385b;
            zzbai zzbai = this.f24387d;
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23993Qa)).booleanValue()) {
                zzajw = new zzajj(context, zzbai);
            } else {
                zzajw = new zzajy(context, zzbai, zzdh, null);
            }
            zzajw.mo29772a(new C9573ma(this, zzala, zzajw));
            zzajw.mo29790a("/jsLoaded", new C9639pa(this, zzala, zzajw));
            zzazk zzazk = new zzazk();
            C9660qa qaVar = new C9660qa(this, zzdh, zzajw, zzazk);
            zzazk.mo30303a(qaVar);
            zzajw.mo29790a("/requestReload", qaVar);
            if (this.f24386c.endsWith(".js")) {
                zzajw.mo29774d(this.f24386c);
            } else if (this.f24386c.startsWith("<html>")) {
                zzajw.mo29776e(this.f24386c);
            } else {
                zzajw.mo29773c(this.f24386c);
            }
            zzaxi.f24961a.postDelayed(new C9681ra(this, zzala, zzajw), (long) C9765va.f23252a);
        } catch (Throwable th) {
            zzbad.m26356b("Error creating webview.", th);
            zzk.zzlk().mo30168a(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzala.mo30346b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void mo29795a(com.google.android.gms.internal.ads.zzala r4, com.google.android.gms.internal.ads.zzajw r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f24384a
            monitor-enter(r0)
            int r1 = r4.mo30343a()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.mo30343a()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.mo30346b()     // Catch:{ all -> 0x002a }
            java.util.concurrent.Executor r4 = com.google.android.gms.internal.ads.zzbbm.f25064a     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.C9617oa.m23992a(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzawz.m26003f(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.mo29795a(com.google.android.gms.internal.ads.zzala, com.google.android.gms.internal.ads.zzajw):void");
    }
}
