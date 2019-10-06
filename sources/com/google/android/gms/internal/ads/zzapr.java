package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzapr extends zzaqb {

    /* renamed from: c */
    private static final Set<String> f24534c = CollectionUtils.m22083a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");

    /* renamed from: d */
    private String f24535d = "top-right";

    /* renamed from: e */
    private boolean f24536e = true;

    /* renamed from: f */
    private int f24537f = 0;

    /* renamed from: g */
    private int f24538g = 0;

    /* renamed from: h */
    private int f24539h = -1;

    /* renamed from: i */
    private int f24540i = 0;

    /* renamed from: j */
    private int f24541j = 0;

    /* renamed from: k */
    private int f24542k = -1;

    /* renamed from: l */
    private final Object f24543l = new Object();

    /* renamed from: m */
    private final zzbgz f24544m;

    /* renamed from: n */
    private final Activity f24545n;

    /* renamed from: o */
    private zzbin f24546o;

    /* renamed from: p */
    private ImageView f24547p;

    /* renamed from: q */
    private LinearLayout f24548q;

    /* renamed from: r */
    private zzaqc f24549r;

    /* renamed from: s */
    private PopupWindow f24550s;

    /* renamed from: t */
    private RelativeLayout f24551t;

    /* renamed from: u */
    private ViewGroup f24552u;

    public zzapr(zzbgz zzbgz, zzaqc zzaqc) {
        super(zzbgz, "resize");
        this.f24544m = zzbgz;
        this.f24545n = zzbgz.mo28780q();
        this.f24549r = zzaqc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0249 A[Catch:{ RuntimeException -> 0x047e }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x024b A[Catch:{ RuntimeException -> 0x047e }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ac A[Catch:{ RuntimeException -> 0x047e }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b3 A[Catch:{ RuntimeException -> 0x047e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29977a(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.f24543l
            monitor-enter(r2)
            android.app.Activity r3 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbin r3 = r3.mo28766m()     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbin r3 = r3.mo28766m()     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.mo30650e()     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbgz r3 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            boolean r3 = r3.mo28791x()     // Catch:{ all -> 0x04d4 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x0063
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04d4 }
            int r3 = com.google.android.gms.internal.ads.zzaxi.m26098a(r3)     // Catch:{ all -> 0x04d4 }
            r1.f24542k = r3     // Catch:{ all -> 0x04d4 }
        L_0x0063:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x0082
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04d4 }
            int r3 = com.google.android.gms.internal.ads.zzaxi.m26098a(r3)     // Catch:{ all -> 0x04d4 }
            r1.f24539h = r3     // Catch:{ all -> 0x04d4 }
        L_0x0082:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04d4 }
            int r3 = com.google.android.gms.internal.ads.zzaxi.m26098a(r3)     // Catch:{ all -> 0x04d4 }
            r1.f24540i = r3     // Catch:{ all -> 0x04d4 }
        L_0x00a1:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x00c0
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04d4 }
            int r3 = com.google.android.gms.internal.ads.zzaxi.m26098a(r3)     // Catch:{ all -> 0x04d4 }
            r1.f24541j = r3     // Catch:{ all -> 0x04d4 }
        L_0x00c0:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x00dc
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04d4 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x04d4 }
            r1.f24536e = r3     // Catch:{ all -> 0x04d4 }
        L_0x00dc:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x04d4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x04d4 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x04d4 }
            if (r3 != 0) goto L_0x00ec
            r1.f24535d = r0     // Catch:{ all -> 0x04d4 }
        L_0x00ec:
            int r0 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f9
            int r0 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            if (r0 < 0) goto L_0x00f9
            r0 = 1
            goto L_0x00fa
        L_0x00f9:
            r0 = 0
        L_0x00fa:
            if (r0 != 0) goto L_0x0103
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x0103:
            android.app.Activity r0 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x04d4 }
            if (r0 == 0) goto L_0x04cd
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x04d4 }
            if (r5 != 0) goto L_0x0113
            goto L_0x04cd
        L_0x0113:
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r6 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int[] r5 = r5.mo30239b(r6)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzaxi r6 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r7 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int[] r6 = r6.mo30241c(r7)     // Catch:{ all -> 0x04d4 }
            r7 = r5[r4]     // Catch:{ all -> 0x04d4 }
            r5 = r5[r3]     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x0241
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            if (r8 <= r7) goto L_0x013e
            goto L_0x0241
        L_0x013e:
            int r8 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            if (r8 < r14) goto L_0x023a
            int r8 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            if (r8 <= r5) goto L_0x0148
            goto L_0x023a
        L_0x0148:
            int r8 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            if (r8 != r5) goto L_0x0158
            int r5 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            if (r5 != r7) goto L_0x0158
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            com.google.android.gms.internal.ads.zzbad.m26359d(r5)     // Catch:{ all -> 0x04d4 }
            r5 = 0
            goto L_0x0247
        L_0x0158:
            boolean r5 = r1.f24536e     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0238
            java.lang.String r5 = r1.f24535d     // Catch:{ all -> 0x04d4 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x04d4 }
            switch(r8) {
                case -1364013995: goto L_0x0198;
                case -1012429441: goto L_0x018e;
                case -655373719: goto L_0x0184;
                case 1163912186: goto L_0x017a;
                case 1288627767: goto L_0x0170;
                case 1755462605: goto L_0x0166;
                default: goto L_0x0165;
            }     // Catch:{ all -> 0x04d4 }
        L_0x0165:
            goto L_0x01a2
        L_0x0166:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 1
            goto L_0x01a3
        L_0x0170:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 4
            goto L_0x01a3
        L_0x017a:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 5
            goto L_0x01a3
        L_0x0184:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 3
            goto L_0x01a3
        L_0x018e:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 0
            goto L_0x01a3
        L_0x0198:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0165
            r5 = 2
            goto L_0x01a3
        L_0x01a2:
            r5 = -1
        L_0x01a3:
            if (r5 == 0) goto L_0x021d
            if (r5 == r3) goto L_0x020c
            if (r5 == r13) goto L_0x01f5
            if (r5 == r11) goto L_0x01e6
            if (r5 == r10) goto L_0x01d1
            if (r5 == r9) goto L_0x01be
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            goto L_0x0228
        L_0x01be:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r15 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0228
        L_0x01d1:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r15 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0228
        L_0x01e6:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r15 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0228
        L_0x01f5:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            int r15 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x0228
        L_0x020c:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            goto L_0x0228
        L_0x021d:
            int r5 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r5 = r5 + r8
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
        L_0x0228:
            if (r5 < 0) goto L_0x0236
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x0236
            r5 = r6[r4]     // Catch:{ all -> 0x04d4 }
            if (r8 < r5) goto L_0x0236
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x04d4 }
            if (r8 <= r5) goto L_0x0238
        L_0x0236:
            r5 = 0
            goto L_0x0247
        L_0x0238:
            r5 = 1
            goto L_0x0247
        L_0x023a:
            java.lang.String r5 = "Height is too small or too large."
            com.google.android.gms.internal.ads.zzbad.m26359d(r5)     // Catch:{ all -> 0x04d4 }
            r5 = 0
            goto L_0x0247
        L_0x0241:
            java.lang.String r5 = "Width is too small or too large."
            com.google.android.gms.internal.ads.zzbad.m26359d(r5)     // Catch:{ all -> 0x04d4 }
            r5 = 0
        L_0x0247:
            if (r5 != 0) goto L_0x024b
            r5 = 0
            goto L_0x02a9
        L_0x024b:
            boolean r5 = r1.f24536e     // Catch:{ all -> 0x04d4 }
            if (r5 == 0) goto L_0x0260
            int[] r5 = new int[r13]     // Catch:{ all -> 0x04d4 }
            int r6 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r7 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x04d4 }
            int r6 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r7 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x04d4 }
            goto L_0x02a9
        L_0x0260:
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r6 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int[] r5 = r5.mo30239b(r6)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzaxi r6 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r7 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int[] r6 = r6.mo30241c(r7)     // Catch:{ all -> 0x04d4 }
            r5 = r5[r4]     // Catch:{ all -> 0x04d4 }
            int r7 = r1.f24537f     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24540i     // Catch:{ all -> 0x04d4 }
            int r7 = r7 + r8
            int r8 = r1.f24538g     // Catch:{ all -> 0x04d4 }
            int r15 = r1.f24541j     // Catch:{ all -> 0x04d4 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x0284
            r5 = 0
            goto L_0x028e
        L_0x0284:
            int r15 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x028d
            int r7 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r5 = r5 - r7
            goto L_0x028e
        L_0x028d:
            r5 = r7
        L_0x028e:
            r7 = r6[r4]     // Catch:{ all -> 0x04d4 }
            if (r8 >= r7) goto L_0x0295
            r8 = r6[r4]     // Catch:{ all -> 0x04d4 }
            goto L_0x02a2
        L_0x0295:
            int r7 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r7 = r7 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x04d4 }
            if (r7 <= r15) goto L_0x02a2
            r6 = r6[r3]     // Catch:{ all -> 0x04d4 }
            int r7 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r8 = r6 - r7
        L_0x02a2:
            int[] r6 = new int[r13]     // Catch:{ all -> 0x04d4 }
            r6[r4] = r5     // Catch:{ all -> 0x04d4 }
            r6[r3] = r8     // Catch:{ all -> 0x04d4 }
            r5 = r6
        L_0x02a9:
            if (r5 != 0) goto L_0x02b3
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x02b3:
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r6 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int r7 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r6 = com.google.android.gms.internal.ads.zzazt.m26302a(r6, r7)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r7 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int r8 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            int r7 = com.google.android.gms.internal.ads.zzazt.m26302a(r7, r8)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04d4 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x04d4 }
            if (r8 == 0) goto L_0x04c6
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x04d4 }
            if (r15 == 0) goto L_0x04c6
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r9 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04d4 }
            r15.removeView(r9)     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r9 = r1.f24550s     // Catch:{ all -> 0x04d4 }
            if (r9 != 0) goto L_0x0318
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x04d4 }
            r1.f24552u = r8     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x04d4 }
            android.graphics.Bitmap r8 = com.google.android.gms.internal.ads.zzaxi.m26099a(r8)     // Catch:{ all -> 0x04d4 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x04d4 }
            android.app.Activity r15 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            r9.<init>(r15)     // Catch:{ all -> 0x04d4 }
            r1.f24547p = r9     // Catch:{ all -> 0x04d4 }
            android.widget.ImageView r9 = r1.f24547p     // Catch:{ all -> 0x04d4 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r8 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbin r8 = r8.mo28766m()     // Catch:{ all -> 0x04d4 }
            r1.f24546o = r8     // Catch:{ all -> 0x04d4 }
            android.view.ViewGroup r8 = r1.f24552u     // Catch:{ all -> 0x04d4 }
            android.widget.ImageView r9 = r1.f24547p     // Catch:{ all -> 0x04d4 }
            r8.addView(r9)     // Catch:{ all -> 0x04d4 }
            goto L_0x031d
        L_0x0318:
            android.widget.PopupWindow r8 = r1.f24550s     // Catch:{ all -> 0x04d4 }
            r8.dismiss()     // Catch:{ all -> 0x04d4 }
        L_0x031d:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x04d4 }
            android.app.Activity r9 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            r8.<init>(r9)     // Catch:{ all -> 0x04d4 }
            r1.f24551t = r8     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r8 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r8 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x04d4 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x04d4 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r8 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r8 = com.google.android.gms.internal.ads.zzaxi.m26102a(r8, r6, r7, r4)     // Catch:{ all -> 0x04d4 }
            r1.f24550s = r8     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r8 = r1.f24550s     // Catch:{ all -> 0x04d4 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r8 = r1.f24550s     // Catch:{ all -> 0x04d4 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r8 = r1.f24550s     // Catch:{ all -> 0x04d4 }
            boolean r9 = r1.f24536e     // Catch:{ all -> 0x04d4 }
            if (r9 != 0) goto L_0x0352
            r9 = 1
            goto L_0x0353
        L_0x0352:
            r9 = 0
        L_0x0353:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r8 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r9 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x04d4 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x04d4 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x04d4 }
            android.app.Activity r9 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            r8.<init>(r9)     // Catch:{ all -> 0x04d4 }
            r1.f24548q = r8     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r9 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int r9 = com.google.android.gms.internal.ads.zzazt.m26302a(r9, r14)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r15 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int r14 = com.google.android.gms.internal.ads.zzazt.m26302a(r15, r14)     // Catch:{ all -> 0x04d4 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x04d4 }
            java.lang.String r9 = r1.f24535d     // Catch:{ all -> 0x04d4 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x04d4 }
            switch(r14) {
                case -1364013995: goto L_0x03bd;
                case -1012429441: goto L_0x03b3;
                case -655373719: goto L_0x03a9;
                case 1163912186: goto L_0x039f;
                case 1288627767: goto L_0x0395;
                case 1755462605: goto L_0x038b;
                default: goto L_0x038a;
            }     // Catch:{ all -> 0x04d4 }
        L_0x038a:
            goto L_0x03c6
        L_0x038b:
            java.lang.String r14 = "top-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 1
            goto L_0x03c6
        L_0x0395:
            java.lang.String r14 = "bottom-center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 4
            goto L_0x03c6
        L_0x039f:
            java.lang.String r14 = "bottom-right"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 5
            goto L_0x03c6
        L_0x03a9:
            java.lang.String r14 = "bottom-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 3
            goto L_0x03c6
        L_0x03b3:
            java.lang.String r14 = "top-left"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 0
            goto L_0x03c6
        L_0x03bd:
            java.lang.String r14 = "center"
            boolean r9 = r9.equals(r14)     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x038a
            r12 = 2
        L_0x03c6:
            r9 = 9
            r14 = 10
            if (r12 == 0) goto L_0x0406
            r15 = 14
            if (r12 == r3) goto L_0x03ff
            if (r12 == r13) goto L_0x03f9
            r13 = 12
            if (r12 == r11) goto L_0x03f2
            if (r12 == r10) goto L_0x03eb
            r9 = 11
            r10 = 5
            if (r12 == r10) goto L_0x03e4
            r8.addRule(r14)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r9)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x03e4:
            r8.addRule(r13)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r9)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x03eb:
            r8.addRule(r13)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r15)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x03f2:
            r8.addRule(r13)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r9)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x03f9:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x03ff:
            r8.addRule(r14)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r15)     // Catch:{ all -> 0x04d4 }
            goto L_0x040d
        L_0x0406:
            r8.addRule(r14)     // Catch:{ all -> 0x04d4 }
            r8.addRule(r9)     // Catch:{ all -> 0x04d4 }
        L_0x040d:
            android.widget.LinearLayout r9 = r1.f24548q     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.jb r10 = new com.google.android.gms.internal.ads.jb     // Catch:{ all -> 0x04d4 }
            r10.<init>(r1)     // Catch:{ all -> 0x04d4 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x04d4 }
            android.widget.LinearLayout r9 = r1.f24548q     // Catch:{ all -> 0x04d4 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r9 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            android.widget.LinearLayout r10 = r1.f24548q     // Catch:{ all -> 0x04d4 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x04d4 }
            android.widget.PopupWindow r8 = r1.f24550s     // Catch:{ RuntimeException -> 0x047e }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x047e }
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ RuntimeException -> 0x047e }
            android.app.Activity r9 = r1.f24545n     // Catch:{ RuntimeException -> 0x047e }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x047e }
            int r9 = com.google.android.gms.internal.ads.zzazt.m26302a(r9, r10)     // Catch:{ RuntimeException -> 0x047e }
            com.google.android.gms.internal.ads.zzyt.m31532a()     // Catch:{ RuntimeException -> 0x047e }
            android.app.Activity r10 = r1.f24545n     // Catch:{ RuntimeException -> 0x047e }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x047e }
            int r10 = com.google.android.gms.internal.ads.zzazt.m26302a(r10, r11)     // Catch:{ RuntimeException -> 0x047e }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x047e }
            r0 = r5[r4]     // Catch:{ all -> 0x04d4 }
            r8 = r5[r3]     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzaqc r9 = r1.f24549r     // Catch:{ all -> 0x04d4 }
            if (r9 == 0) goto L_0x0456
            com.google.android.gms.internal.ads.zzaqc r9 = r1.f24549r     // Catch:{ all -> 0x04d4 }
            int r10 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r11 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            r9.mo29249a(r0, r8, r10, r11)     // Catch:{ all -> 0x04d4 }
        L_0x0456:
            com.google.android.gms.internal.ads.zzbgz r0 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbin r6 = com.google.android.gms.internal.ads.zzbin.m27013a(r6, r7)     // Catch:{ all -> 0x04d4 }
            r0.mo28723a(r6)     // Catch:{ all -> 0x04d4 }
            r0 = r5[r4]     // Catch:{ all -> 0x04d4 }
            r3 = r5[r3]     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzaxi r5 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x04d4 }
            android.app.Activity r6 = r1.f24545n     // Catch:{ all -> 0x04d4 }
            int[] r5 = r5.mo30241c(r6)     // Catch:{ all -> 0x04d4 }
            r4 = r5[r4]     // Catch:{ all -> 0x04d4 }
            int r3 = r3 - r4
            int r4 = r1.f24542k     // Catch:{ all -> 0x04d4 }
            int r5 = r1.f24539h     // Catch:{ all -> 0x04d4 }
            r1.mo29989a(r0, r3, r4, r5)     // Catch:{ all -> 0x04d4 }
            java.lang.String r0 = "resized"
            r1.mo29994c(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x047e:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x04d4 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x04d4 }
            int r4 = r0.length()     // Catch:{ all -> 0x04d4 }
            if (r4 == 0) goto L_0x0494
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x04d4 }
            goto L_0x0499
        L_0x0494:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x04d4 }
            r0.<init>(r3)     // Catch:{ all -> 0x04d4 }
        L_0x0499:
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            android.widget.RelativeLayout r0 = r1.f24551t     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r3 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04d4 }
            r0.removeView(r3)     // Catch:{ all -> 0x04d4 }
            android.view.ViewGroup r0 = r1.f24552u     // Catch:{ all -> 0x04d4 }
            if (r0 == 0) goto L_0x04c4
            android.view.ViewGroup r0 = r1.f24552u     // Catch:{ all -> 0x04d4 }
            android.widget.ImageView r3 = r1.f24547p     // Catch:{ all -> 0x04d4 }
            r0.removeView(r3)     // Catch:{ all -> 0x04d4 }
            android.view.ViewGroup r0 = r1.f24552u     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r3 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x04d4 }
            r0.addView(r3)     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbgz r0 = r1.f24544m     // Catch:{ all -> 0x04d4 }
            com.google.android.gms.internal.ads.zzbin r3 = r1.f24546o     // Catch:{ all -> 0x04d4 }
            r0.mo28723a(r3)     // Catch:{ all -> 0x04d4 }
        L_0x04c4:
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x04c6:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x04cd:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.mo29991a(r0)     // Catch:{ all -> 0x04d4 }
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            return
        L_0x04d4:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x04d4 }
            goto L_0x04d8
        L_0x04d7:
            throw r0
        L_0x04d8:
            goto L_0x04d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapr.mo29977a(java.util.Map):void");
    }

    /* renamed from: a */
    public final void mo29978a(boolean z) {
        synchronized (this.f24543l) {
            if (this.f24550s != null) {
                this.f24550s.dismiss();
                this.f24551t.removeView(this.f24544m.getView());
                if (this.f24552u != null) {
                    this.f24552u.removeView(this.f24547p);
                    this.f24552u.addView(this.f24544m.getView());
                    this.f24544m.mo28723a(this.f24546o);
                }
                if (z) {
                    mo29994c(BuildConfig.APTOIDE_THEME);
                    if (this.f24549r != null) {
                        this.f24549r.mo29248a();
                    }
                }
                this.f24550s = null;
                this.f24551t = null;
                this.f24552u = null;
                this.f24548q = null;
            }
        }
    }

    /* renamed from: a */
    public final void mo29976a(int i, int i2, boolean z) {
        synchronized (this.f24543l) {
            this.f24537f = i;
            this.f24538g = i2;
        }
    }

    /* renamed from: a */
    public final boolean mo29979a() {
        boolean z;
        synchronized (this.f24543l) {
            z = this.f24550s != null;
        }
        return z;
    }

    /* renamed from: a */
    public final void mo29975a(int i, int i2) {
        this.f24537f = i;
        this.f24538g = i2;
    }
}
