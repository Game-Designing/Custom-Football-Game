package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzawr {
    @VisibleForTesting

    /* renamed from: a */
    private long f24910a = -1;
    @VisibleForTesting

    /* renamed from: b */
    private long f24911b = -1;
    @VisibleForTesting

    /* renamed from: c */
    private int f24912c = -1;
    @VisibleForTesting

    /* renamed from: d */
    int f24913d = -1;
    @VisibleForTesting

    /* renamed from: e */
    private long f24914e = 0;

    /* renamed from: f */
    private final Object f24915f = new Object();
    @VisibleForTesting

    /* renamed from: g */
    private final String f24916g;

    /* renamed from: h */
    private final zzaxb f24917h;
    @VisibleForTesting

    /* renamed from: i */
    private int f24918i = 0;
    @VisibleForTesting

    /* renamed from: j */
    private int f24919j = 0;

    public zzawr(String str, zzaxb zzaxb) {
        this.f24916g = str;
        this.f24917h = zzaxb;
    }

    /* renamed from: b */
    public final void mo30184b() {
        synchronized (this.f24915f) {
            this.f24918i++;
        }
    }

    /* renamed from: a */
    public final void mo30182a() {
        synchronized (this.f24915f) {
            this.f24919j++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30183a(com.google.android.gms.internal.ads.zzxz r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f24915f
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzaxb r1 = r10.f24917h     // Catch:{ all -> 0x007c }
            long r1 = r1.mo30217f()     // Catch:{ all -> 0x007c }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x007c }
            long r3 = r3.mo27935b()     // Catch:{ all -> 0x007c }
            long r5 = r10.f24911b     // Catch:{ all -> 0x007c }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0043
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzacu.f24084eb     // Catch:{ all -> 0x007c }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x007c }
            java.lang.Object r5 = r6.mo29599a(r5)     // Catch:{ all -> 0x007c }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x007c }
            long r5 = r5.longValue()     // Catch:{ all -> 0x007c }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
            r1 = -1
            r10.f24913d = r1     // Catch:{ all -> 0x007c }
            goto L_0x003c
        L_0x0034:
            com.google.android.gms.internal.ads.zzaxb r1 = r10.f24917h     // Catch:{ all -> 0x007c }
            int r1 = r1.mo30216e()     // Catch:{ all -> 0x007c }
            r10.f24913d = r1     // Catch:{ all -> 0x007c }
        L_0x003c:
            r10.f24911b = r12     // Catch:{ all -> 0x007c }
            long r12 = r10.f24911b     // Catch:{ all -> 0x007c }
            r10.f24910a = r12     // Catch:{ all -> 0x007c }
            goto L_0x0045
        L_0x0043:
            r10.f24910a = r12     // Catch:{ all -> 0x007c }
        L_0x0045:
            r12 = 1
            if (r11 == 0) goto L_0x0059
            android.os.Bundle r13 = r11.f29725c     // Catch:{ all -> 0x007c }
            if (r13 == 0) goto L_0x0059
            android.os.Bundle r11 = r11.f29725c     // Catch:{ all -> 0x007c }
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x007c }
            if (r11 != r12) goto L_0x0059
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            return
        L_0x0059:
            int r11 = r10.f24912c     // Catch:{ all -> 0x007c }
            int r11 = r11 + r12
            r10.f24912c = r11     // Catch:{ all -> 0x007c }
            int r11 = r10.f24913d     // Catch:{ all -> 0x007c }
            int r11 = r11 + r12
            r10.f24913d = r11     // Catch:{ all -> 0x007c }
            int r11 = r10.f24913d     // Catch:{ all -> 0x007c }
            if (r11 != 0) goto L_0x0071
            r11 = 0
            r10.f24914e = r11     // Catch:{ all -> 0x007c }
            com.google.android.gms.internal.ads.zzaxb r11 = r10.f24917h     // Catch:{ all -> 0x007c }
            r11.mo30208b(r3)     // Catch:{ all -> 0x007c }
            goto L_0x007a
        L_0x0071:
            com.google.android.gms.internal.ads.zzaxb r11 = r10.f24917h     // Catch:{ all -> 0x007c }
            long r11 = r11.mo30214d()     // Catch:{ all -> 0x007c }
            long r3 = r3 - r11
            r10.f24914e = r3     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            return
        L_0x007c:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawr.mo30183a(com.google.android.gms.internal.ads.zzxz, long):void");
    }

    /* renamed from: a */
    public final Bundle mo30181a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f24915f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f24916g);
            bundle.putLong("basets", this.f24911b);
            bundle.putLong("currts", this.f24910a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f24912c);
            bundle.putInt("preqs_in_session", this.f24913d);
            bundle.putLong("time_in_session", this.f24914e);
            bundle.putInt("pclick", this.f24918i);
            bundle.putInt("pimp", this.f24919j);
            bundle.putBoolean("support_transparent_background", m25981a(context));
        }
        return bundle;
    }

    /* renamed from: a */
    private static boolean m25981a(Context context) {
        Context b = zzasq.m25744b(context);
        int identifier = b.getResources().getIdentifier("Theme.Translucent", "style", "android");
        String str = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";
        if (identifier == 0) {
            zzbad.m26357c(str);
            return false;
        }
        try {
            if (identifier == b.getPackageManager().getActivityInfo(new ComponentName(b.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzbad.m26357c(str);
            return false;
        } catch (NameNotFoundException e) {
            zzbad.m26359d("Fail to fetch AdActivity theme");
            zzbad.m26357c(str);
            return false;
        }
    }
}
