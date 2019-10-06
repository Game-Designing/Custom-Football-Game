package p019d.p273h.p276c;

import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p019d.p273h.p274a.C12729f.C12730a;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p282f.C12874h;
import p019d.p273h.p276c.p282f.C12877ia;
import p019d.p273h.p276c.p282f.C12879ja;
import p019d.p273h.p276c.p282f.C12881ka;
import p019d.p273h.p276c.p284h.C12910d;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.na */
/* compiled from: RewardedVideoManager */
class C12934na extends C12771a implements C12877ia, C12881ka, C12730a, C12910d {

    /* renamed from: A */
    private C12874h f39811A;

    /* renamed from: B */
    private boolean f39812B = false;

    /* renamed from: C */
    private boolean f39813C = false;

    /* renamed from: D */
    private C12820l f39814D;

    /* renamed from: E */
    private Timer f39815E = null;

    /* renamed from: F */
    private int f39816F;

    /* renamed from: G */
    private List<C12792a> f39817G = Arrays.asList(new C12792a[]{C12792a.INIT_FAILED, C12792a.CAPPED_PER_SESSION, C12792a.EXHAUSTED, C12792a.CAPPED_PER_DAY});

    /* renamed from: w */
    private final String f39818w = getClass().getSimpleName();

    /* renamed from: x */
    private final int f39819x = 2;

    /* renamed from: y */
    private final int f39820y = 6;

    /* renamed from: z */
    private C12879ja f39821z;

    C12934na() {
    }

    /* renamed from: a */
    public void mo41739a(C12879ja listener) {
        this.f39821z = listener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0129, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41736a(android.app.Activity r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            d.h.c.d.d r0 = r9.f39269o     // Catch:{ all -> 0x012a }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r2.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r3 = r9.f39818w     // Catch:{ all -> 0x012a }
            r2.append(r3)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = ":initRewardedVideo(appKey: "
            r2.append(r3)     // Catch:{ all -> 0x012a }
            r2.append(r11)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = ", userId: "
            r2.append(r3)     // Catch:{ all -> 0x012a }
            r2.append(r12)     // Catch:{ all -> 0x012a }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x012a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x012a }
            r3 = 1
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x012a }
            r9.f39268n = r11     // Catch:{ all -> 0x012a }
            r9.f39267m = r12     // Catch:{ all -> 0x012a }
            r9.f39266l = r10     // Catch:{ all -> 0x012a }
            boolean r0 = r9.f39276v     // Catch:{ all -> 0x012a }
            r1 = 0
            if (r0 == 0) goto L_0x00bc
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r0 = r9.f39263i     // Catch:{ all -> 0x012a }
            int r0 = r0.size()     // Catch:{ all -> 0x012a }
            r9.f39262h = r0     // Catch:{ all -> 0x012a }
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x012a }
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r2 = r9.f39263i     // Catch:{ all -> 0x012a }
            r0.<init>(r2)     // Catch:{ all -> 0x012a }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x012a }
        L_0x004a:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x012a }
            if (r4 == 0) goto L_0x00bb
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x012a }
            d.h.c.c r4 = (p019d.p273h.p276c.C12791c) r4     // Catch:{ all -> 0x012a }
            d.h.c.d.d r5 = r9.f39269o     // Catch:{ all -> 0x012a }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r7.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r8 = "initRewardedVideo, iterating on: "
            r7.append(r8)     // Catch:{ all -> 0x012a }
            java.lang.String r8 = r4.mo41398o()     // Catch:{ all -> 0x012a }
            r7.append(r8)     // Catch:{ all -> 0x012a }
            java.lang.String r8 = ", Status: "
            r7.append(r8)     // Catch:{ all -> 0x012a }
            d.h.c.c$a r8 = r4.mo41402s()     // Catch:{ all -> 0x012a }
            r7.append(r8)     // Catch:{ all -> 0x012a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x012a }
            r5.mo41427b(r6, r7, r1)     // Catch:{ all -> 0x012a }
            java.lang.String r5 = r4.mo41404u()     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "SupersonicAds"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x012a }
            if (r5 != 0) goto L_0x00ac
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r5 = r9.f39263i     // Catch:{ all -> 0x012a }
            r5.remove(r4)     // Catch:{ all -> 0x012a }
            d.h.c.d.d r5 = r9.f39269o     // Catch:{ all -> 0x012a }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r7.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r8 = r4.mo41396l()     // Catch:{ all -> 0x012a }
            r7.append(r8)     // Catch:{ all -> 0x012a }
            java.lang.String r8 = " has been removed from the RV waterfall due to demand only mode"
            r7.append(r8)     // Catch:{ all -> 0x012a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x012a }
            r5.mo41427b(r6, r7, r3)     // Catch:{ all -> 0x012a }
            goto L_0x00ba
        L_0x00ac:
            r5 = r4
            d.h.c.pa r5 = (p019d.p273h.p276c.C12938pa) r5     // Catch:{ all -> 0x012a }
            d.h.c.b r5 = r9.m42094f(r5)     // Catch:{ all -> 0x012a }
            if (r5 != 0) goto L_0x00ba
            d.h.c.c$a r5 = p019d.p273h.p276c.C12791c.C12792a.INIT_FAILED     // Catch:{ all -> 0x012a }
            r4.mo41388a(r5)     // Catch:{ all -> 0x012a }
        L_0x00ba:
            goto L_0x004a
        L_0x00bb:
            goto L_0x0128
        L_0x00bc:
            d.h.c.h.f r0 = r9.f39261g     // Catch:{ all -> 0x012a }
            android.app.Activity r2 = r9.f39266l     // Catch:{ all -> 0x012a }
            r0.mo41686a(r2)     // Catch:{ all -> 0x012a }
            r0 = 0
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r2 = r9.f39263i     // Catch:{ all -> 0x012a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x012a }
        L_0x00ca:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x012a }
            if (r4 == 0) goto L_0x0102
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x012a }
            d.h.c.c r4 = (p019d.p273h.p276c.C12791c) r4     // Catch:{ all -> 0x012a }
            d.h.c.h.f r5 = r9.f39261g     // Catch:{ all -> 0x012a }
            boolean r5 = r5.mo41690d(r4)     // Catch:{ all -> 0x012a }
            if (r5 == 0) goto L_0x00f2
            r5 = 150(0x96, float:2.1E-43)
            java.lang.Object[][] r6 = new java.lang.Object[r3][]     // Catch:{ all -> 0x012a }
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x012a }
            java.lang.String r8 = "status"
            r7[r1] = r8     // Catch:{ all -> 0x012a }
            java.lang.String r8 = "false"
            r7[r3] = r8     // Catch:{ all -> 0x012a }
            r6[r1] = r7     // Catch:{ all -> 0x012a }
            r9.m42084a(r5, r4, r6)     // Catch:{ all -> 0x012a }
        L_0x00f2:
            d.h.c.h.f r5 = r9.f39261g     // Catch:{ all -> 0x012a }
            boolean r5 = r5.mo41689c(r4)     // Catch:{ all -> 0x012a }
            if (r5 == 0) goto L_0x0101
            d.h.c.c$a r5 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_DAY     // Catch:{ all -> 0x012a }
            r4.mo41388a(r5)     // Catch:{ all -> 0x012a }
            int r0 = r0 + 1
        L_0x0101:
            goto L_0x00ca
        L_0x0102:
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r2 = r9.f39263i     // Catch:{ all -> 0x012a }
            int r2 = r2.size()     // Catch:{ all -> 0x012a }
            if (r0 != r2) goto L_0x0111
            d.h.c.f.ja r2 = r9.f39821z     // Catch:{ all -> 0x012a }
            r2.mo41616a(r1)     // Catch:{ all -> 0x012a }
            monitor-exit(r9)
            return
        L_0x0111:
        L_0x0112:
            int r2 = r9.f39262h     // Catch:{ all -> 0x012a }
            if (r1 >= r2) goto L_0x0128
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r2 = r9.f39263i     // Catch:{ all -> 0x012a }
            int r2 = r2.size()     // Catch:{ all -> 0x012a }
            if (r1 >= r2) goto L_0x0128
            d.h.c.b r2 = r9.m42100l()     // Catch:{ all -> 0x012a }
            if (r2 != 0) goto L_0x0125
            goto L_0x0128
        L_0x0125:
            int r1 = r1 + 1
            goto L_0x0112
        L_0x0128:
            monitor-exit(r9)
            return
        L_0x012a:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x012e
        L_0x012d:
            throw r10
        L_0x012e:
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12934na.mo41736a(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public void mo41738a(C12874h listener) {
        this.f39811A = listener;
    }

    /* JADX INFO: used method not loaded: d.h.c.h.f.c(d.h.c.c):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0068, code lost:
        if (r4.mo41402s() != p019d.p273h.p276c.C12791c.C12792a.AVAILABLE) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        if (((p019d.p273h.p276c.C12938pa) r4).mo41753F() == false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        p019d.p273h.p276c.p284h.C12908c.m41896b((android.content.Context) r10.f39266l, r10.f39814D);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007d, code lost:
        if (r10.f39814D == null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007f, code lost:
        m42084a(2, r4, new java.lang.Object[][]{new java.lang.Object[]{com.vungle.warren.p267ui.VungleActivity.PLACEMENT_EXTRA, r10.f39814D.mo41504c()}});
        m42086a(r4, r2, r10.f39814D.mo41504c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        r10.f39269o.mo41427b(p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL, "mCurrentPlacement is null", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        ((p019d.p273h.p276c.C12938pa) r4).mo41754G();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b2, code lost:
        if (r4.mo41408y() == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b4, code lost:
        m42084a(7, r4, new java.lang.Object[][]{new java.lang.Object[]{"status", p005cm.aptoide.p006pt.account.AdultContentAnalytics.UNLOCK}, new java.lang.Object[]{"reason", java.lang.Integer.valueOf(2)}});
        mo41647a(false, (p019d.p273h.p276c.C12938pa) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e1, code lost:
        if (r10.f39261g.mo41689c(r4) == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e3, code lost:
        r4.mo41388a(p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_DAY);
        m42084a(150, r4, new java.lang.Object[][]{new java.lang.Object[]{"status", "true"}});
        mo41647a(false, (p019d.p273h.p276c.C12938pa) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0102, code lost:
        mo41647a(false, (p019d.p273h.p276c.C12938pa) r4);
        r1 = new java.lang.Exception("FailedToShowVideoException");
        r3 = r10.f39269o;
        r5 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL;
        r6 = new java.lang.StringBuilder();
        r6.append(r4.mo41398o());
        r6.append(" Failed to show video");
        r3.mo41426a(r5, r6.toString(), (java.lang.Throwable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x012c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0133, code lost:
        if (r4.mo41402s() != p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_SESSION) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0135, code lost:
        r10.f39821z.mo41621c(new p019d.p273h.p276c.p280d.C12799b(526, "Instance has reached its cap per session"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0144, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0163, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41740a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            d.h.c.d.d r0 = r10.f39269o     // Catch:{ all -> 0x0164 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0164 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
            r2.<init>()     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = r10.f39818w     // Catch:{ all -> 0x0164 }
            r2.append(r3)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = ":showRewardedVideo(instanceId: "
            r2.append(r3)     // Catch:{ all -> 0x0164 }
            r2.append(r11)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = ", placementName: "
            r2.append(r3)     // Catch:{ all -> 0x0164 }
            r2.append(r12)     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0164 }
            r3 = 1
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x0164 }
            android.app.Activity r0 = r10.f39266l     // Catch:{ all -> 0x0164 }
            boolean r0 = p019d.p273h.p276c.p284h.C12916j.m41982c(r0)     // Catch:{ all -> 0x0164 }
            if (r0 != 0) goto L_0x0041
            d.h.c.f.h r0 = r10.f39811A     // Catch:{ all -> 0x0164 }
            java.lang.String r1 = "Rewarded Video"
            d.h.c.d.b r1 = p019d.p273h.p276c.p284h.C12913g.m41926d(r1)     // Catch:{ all -> 0x0164 }
            r0.onRewardedVideoAdShowFailed(r11, r1)     // Catch:{ all -> 0x0164 }
            monitor-exit(r10)
            return
        L_0x0041:
            r10.m42091c(r12)     // Catch:{ all -> 0x0164 }
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0047:
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r4 = r10.f39263i     // Catch:{ all -> 0x0164 }
            int r4 = r4.size()     // Catch:{ all -> 0x0164 }
            if (r2 >= r4) goto L_0x0149
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r4 = r10.f39263i     // Catch:{ all -> 0x0164 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0164 }
            d.h.c.c r4 = (p019d.p273h.p276c.C12791c) r4     // Catch:{ all -> 0x0164 }
            java.lang.String r5 = r4.mo41406w()     // Catch:{ all -> 0x0164 }
            boolean r5 = r5.equals(r11)     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x0145
            r0 = 1
            d.h.c.c$a r5 = r4.mo41402s()     // Catch:{ all -> 0x0164 }
            d.h.c.c$a r6 = p019d.p273h.p276c.C12791c.C12792a.AVAILABLE     // Catch:{ all -> 0x0164 }
            if (r5 != r6) goto L_0x012d
            r5 = r4
            d.h.c.pa r5 = (p019d.p273h.p276c.C12938pa) r5     // Catch:{ all -> 0x0164 }
            boolean r5 = r5.mo41753F()     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x0102
            android.app.Activity r5 = r10.f39266l     // Catch:{ all -> 0x0164 }
            d.h.c.e.l r6 = r10.f39814D     // Catch:{ all -> 0x0164 }
            p019d.p273h.p276c.p284h.C12908c.m41896b(r5, r6)     // Catch:{ all -> 0x0164 }
            d.h.c.e.l r5 = r10.f39814D     // Catch:{ all -> 0x0164 }
            r6 = 2
            if (r5 == 0) goto L_0x009e
            java.lang.Object[][] r5 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0164 }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = "placement"
            r7[r1] = r8     // Catch:{ all -> 0x0164 }
            d.h.c.e.l r8 = r10.f39814D     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = r8.mo41504c()     // Catch:{ all -> 0x0164 }
            r7[r3] = r8     // Catch:{ all -> 0x0164 }
            r5[r1] = r7     // Catch:{ all -> 0x0164 }
            r10.m42084a(r6, r4, r5)     // Catch:{ all -> 0x0164 }
            d.h.c.e.l r5 = r10.f39814D     // Catch:{ all -> 0x0164 }
            java.lang.String r5 = r5.mo41504c()     // Catch:{ all -> 0x0164 }
            r10.m42086a(r4, r2, r5)     // Catch:{ all -> 0x0164 }
            goto L_0x00a8
        L_0x009e:
            d.h.c.d.d r5 = r10.f39269o     // Catch:{ all -> 0x0164 }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = "mCurrentPlacement is null"
            r9 = 3
            r5.mo41427b(r7, r8, r9)     // Catch:{ all -> 0x0164 }
        L_0x00a8:
            r5 = r4
            d.h.c.pa r5 = (p019d.p273h.p276c.C12938pa) r5     // Catch:{ all -> 0x0164 }
            r5.mo41754G()     // Catch:{ all -> 0x0164 }
            boolean r5 = r4.mo41408y()     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x00db
            r5 = 7
            java.lang.Object[][] r7 = new java.lang.Object[r6][]     // Catch:{ all -> 0x0164 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x0164 }
            java.lang.String r9 = "status"
            r8[r1] = r9     // Catch:{ all -> 0x0164 }
            java.lang.String r9 = "false"
            r8[r3] = r9     // Catch:{ all -> 0x0164 }
            r7[r1] = r8     // Catch:{ all -> 0x0164 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x0164 }
            java.lang.String r9 = "reason"
            r8[r1] = r9     // Catch:{ all -> 0x0164 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0164 }
            r8[r3] = r6     // Catch:{ all -> 0x0164 }
            r7[r3] = r8     // Catch:{ all -> 0x0164 }
            r10.m42084a(r5, r4, r7)     // Catch:{ all -> 0x0164 }
            r3 = r4
            d.h.c.pa r3 = (p019d.p273h.p276c.C12938pa) r3     // Catch:{ all -> 0x0164 }
            r10.mo41647a(r1, r3)     // Catch:{ all -> 0x0164 }
            goto L_0x012b
        L_0x00db:
            d.h.c.h.f r5 = r10.f39261g     // Catch:{ all -> 0x0164 }
            boolean r5 = r5.mo41689c(r4)     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x012b
            d.h.c.c$a r5 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_DAY     // Catch:{ all -> 0x0164 }
            r4.mo41388a(r5)     // Catch:{ all -> 0x0164 }
            r5 = 150(0x96, float:2.1E-43)
            java.lang.Object[][] r7 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0164 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = "status"
            r6[r1] = r8     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = "true"
            r6[r3] = r8     // Catch:{ all -> 0x0164 }
            r7[r1] = r6     // Catch:{ all -> 0x0164 }
            r10.m42084a(r5, r4, r7)     // Catch:{ all -> 0x0164 }
            r3 = r4
            d.h.c.pa r3 = (p019d.p273h.p276c.C12938pa) r3     // Catch:{ all -> 0x0164 }
            r10.mo41647a(r1, r3)     // Catch:{ all -> 0x0164 }
            goto L_0x012b
        L_0x0102:
            r3 = r4
            d.h.c.pa r3 = (p019d.p273h.p276c.C12938pa) r3     // Catch:{ all -> 0x0164 }
            r10.mo41647a(r1, r3)     // Catch:{ all -> 0x0164 }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x0164 }
            java.lang.String r3 = "FailedToShowVideoException"
            r1.<init>(r3)     // Catch:{ all -> 0x0164 }
            d.h.c.d.d r3 = r10.f39269o     // Catch:{ all -> 0x0164 }
            d.h.c.d.c$a r5 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x0164 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
            r6.<init>()     // Catch:{ all -> 0x0164 }
            java.lang.String r7 = r4.mo41398o()     // Catch:{ all -> 0x0164 }
            r6.append(r7)     // Catch:{ all -> 0x0164 }
            java.lang.String r7 = " Failed to show video"
            r6.append(r7)     // Catch:{ all -> 0x0164 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0164 }
            r3.mo41426a(r5, r6, r1)     // Catch:{ all -> 0x0164 }
        L_0x012b:
            monitor-exit(r10)
            return
        L_0x012d:
            d.h.c.c$a r1 = r4.mo41402s()     // Catch:{ all -> 0x0164 }
            d.h.c.c$a r3 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_SESSION     // Catch:{ all -> 0x0164 }
            if (r1 != r3) goto L_0x0149
            d.h.c.f.ja r1 = r10.f39821z     // Catch:{ all -> 0x0164 }
            d.h.c.d.b r3 = new d.h.c.d.b     // Catch:{ all -> 0x0164 }
            r5 = 526(0x20e, float:7.37E-43)
            java.lang.String r6 = "Instance has reached its cap per session"
            r3.<init>(r5, r6)     // Catch:{ all -> 0x0164 }
            r1.mo41621c(r3)     // Catch:{ all -> 0x0164 }
            monitor-exit(r10)
            return
        L_0x0145:
            int r2 = r2 + 1
            goto L_0x0047
        L_0x0149:
            if (r0 != 0) goto L_0x0157
            d.h.c.f.h r1 = r10.f39811A     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = "Rewarded Video"
            d.h.c.d.b r2 = p019d.p273h.p276c.p284h.C12913g.m41928e(r2)     // Catch:{ all -> 0x0164 }
            r1.onRewardedVideoAdShowFailed(r11, r2)     // Catch:{ all -> 0x0164 }
            goto L_0x0162
        L_0x0157:
            d.h.c.f.h r1 = r10.f39811A     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = "Rewarded Video"
            d.h.c.d.b r2 = p019d.p273h.p276c.p284h.C12913g.m41924c(r2)     // Catch:{ all -> 0x0164 }
            r1.onRewardedVideoAdShowFailed(r11, r2)     // Catch:{ all -> 0x0164 }
        L_0x0162:
            monitor-exit(r10)
            return
        L_0x0164:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0168
        L_0x0167:
            throw r11
        L_0x0168:
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12934na.mo41740a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    public synchronized boolean mo41742b(String instanceId) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.API;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39818w);
        sb.append(":isRewardedVideoAvailable(instanceId: ");
        sb.append(instanceId);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (this.f39812B) {
            return false;
        }
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41406w().equals(instanceId)) {
                return ((C12938pa) smash).mo41753F();
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo41645a(C12799b error, C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdShowFailed(");
        sb.append(error);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (this.f39276v) {
            this.f39811A.onRewardedVideoAdShowFailed(smash.mo41406w(), error);
        } else {
            this.f39821z.mo41621c(error);
        }
    }

    /* renamed from: c */
    public void mo41649c(C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdOpened()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42084a(5, (C12791c) smash, (Object[][]) null);
        if (this.f39276v) {
            this.f39811A.onRewardedVideoAdOpened(smash.mo41406w());
        } else {
            this.f39821z.onRewardedVideoAdOpened();
        }
    }

    /* renamed from: e */
    public void mo41651e(C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdClosed()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        mo41309f();
        m42084a(6, (C12791c) smash, (Object[][]) null);
        m42103o();
        if (this.f39276v) {
            this.f39811A.onRewardedVideoAdClosed(smash.mo41406w());
            return;
        }
        this.f39821z.onRewardedVideoAdClosed();
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c asmash = (C12791c) it.next();
            C12802d dVar2 = this.f39269o;
            C12801a aVar2 = C12801a.INTERNAL;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Fetch on ad closed, iterating on: ");
            sb2.append(asmash.mo41398o());
            sb2.append(", Status: ");
            sb2.append(asmash.mo41402s());
            dVar2.mo41427b(aVar2, sb2.toString(), 0);
            if (asmash.mo41402s() == C12792a.NOT_AVAILABLE) {
                try {
                    if (!asmash.mo41398o().equals(smash.mo41398o())) {
                        C12802d dVar3 = this.f39269o;
                        C12801a aVar3 = C12801a.INTERNAL;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(asmash.mo41398o());
                        sb3.append(":reload smash");
                        dVar3.mo41427b(aVar3, sb3.toString(), 1);
                        ((C12938pa) asmash).mo41752E();
                    }
                } catch (Throwable t) {
                    C12802d dVar4 = this.f39269o;
                    C12801a aVar4 = C12801a.NATIVE;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(asmash.mo41398o());
                    sb4.append(" Failed to call fetchVideo(), ");
                    sb4.append(t.getLocalizedMessage());
                    dVar4.mo41427b(aVar4, sb4.toString(), 1);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0084, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cf, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41647a(boolean r7, p019d.p273h.p276c.C12938pa r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f39812B     // Catch:{ all -> 0x0133 }
            if (r0 != 0) goto L_0x0131
            d.h.c.d.d r0 = r6.f39269o     // Catch:{ Throwable -> 0x0102 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.ADAPTER_CALLBACK     // Catch:{ Throwable -> 0x0102 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0102 }
            r2.<init>()     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r3 = r8.mo41398o()     // Catch:{ Throwable -> 0x0102 }
            r2.append(r3)     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r3 = ":onRewardedVideoAvailabilityChanged(available:"
            r2.append(r3)     // Catch:{ Throwable -> 0x0102 }
            r2.append(r7)     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0102 }
            r3 = 1
            r0.mo41427b(r1, r2, r3)     // Catch:{ Throwable -> 0x0102 }
            java.lang.Object[][] r0 = new java.lang.Object[r3][]     // Catch:{ Throwable -> 0x0102 }
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = "status"
            r5 = 0
            r2[r5] = r4     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x0102 }
            r2[r3] = r4     // Catch:{ Throwable -> 0x0102 }
            r0[r5] = r2     // Catch:{ Throwable -> 0x0102 }
            r2 = 7
            r6.m42084a(r2, r8, r0)     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r6.f39276v     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0068
            d.h.c.f.h r0 = r6.f39811A     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = r8.mo41406w()     // Catch:{ Throwable -> 0x0102 }
            r0.onRewardedVideoAvailabilityChanged(r4, r7)     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r6.m42092d(r7)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0101
            java.lang.Object[][] r0 = new java.lang.Object[r3][]     // Catch:{ Throwable -> 0x0102 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = "status"
            r1[r5] = r4     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x0102 }
            r1[r3] = r4     // Catch:{ Throwable -> 0x0102 }
            r0[r5] = r1     // Catch:{ Throwable -> 0x0102 }
            r6.m42085a(r2, r0)     // Catch:{ Throwable -> 0x0102 }
            goto L_0x0101
        L_0x0068:
            d.h.c.c r0 = r6.mo41305d()     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r8.equals(r0)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0085
            boolean r0 = r6.m42092d(r7)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0083
            d.h.c.f.ja r0 = r6.f39821z     // Catch:{ Throwable -> 0x0102 }
            java.lang.Boolean r1 = r6.f39271q     // Catch:{ Throwable -> 0x0102 }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x0102 }
            r0.mo41616a(r1)     // Catch:{ Throwable -> 0x0102 }
        L_0x0083:
            monitor-exit(r6)
            return
        L_0x0085:
            d.h.c.c r0 = r6.mo41307e()     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r8.equals(r0)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x00d0
            d.h.c.d.d r0 = r6.f39269o     // Catch:{ Throwable -> 0x0102 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.ADAPTER_CALLBACK     // Catch:{ Throwable -> 0x0102 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0102 }
            r2.<init>()     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = r8.mo41398o()     // Catch:{ Throwable -> 0x0102 }
            r2.append(r4)     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r4 = " is a Premium adapter, canShowPremium: "
            r2.append(r4)     // Catch:{ Throwable -> 0x0102 }
            boolean r4 = r6.mo41304c()     // Catch:{ Throwable -> 0x0102 }
            r2.append(r4)     // Catch:{ Throwable -> 0x0102 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0102 }
            r0.mo41427b(r1, r2, r3)     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r6.mo41304c()     // Catch:{ Throwable -> 0x0102 }
            if (r0 != 0) goto L_0x00d0
            d.h.c.c$a r0 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_SESSION     // Catch:{ Throwable -> 0x0102 }
            r8.mo41388a(r0)     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r6.m42092d(r5)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x00ce
            d.h.c.f.ja r0 = r6.f39821z     // Catch:{ Throwable -> 0x0102 }
            java.lang.Boolean r1 = r6.f39271q     // Catch:{ Throwable -> 0x0102 }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x0102 }
            r0.mo41616a(r1)     // Catch:{ Throwable -> 0x0102 }
        L_0x00ce:
            monitor-exit(r6)
            return
        L_0x00d0:
            boolean r0 = r8.mo41381A()     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0101
            d.h.c.h.f r0 = r6.f39261g     // Catch:{ Throwable -> 0x0102 }
            boolean r0 = r0.mo41689c(r8)     // Catch:{ Throwable -> 0x0102 }
            if (r0 != 0) goto L_0x0101
            if (r7 == 0) goto L_0x00f2
            boolean r0 = r6.m42092d(r3)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x0101
            d.h.c.f.ja r0 = r6.f39821z     // Catch:{ Throwable -> 0x0102 }
            java.lang.Boolean r1 = r6.f39271q     // Catch:{ Throwable -> 0x0102 }
            boolean r1 = r1.booleanValue()     // Catch:{ Throwable -> 0x0102 }
            r0.mo41616a(r1)     // Catch:{ Throwable -> 0x0102 }
            goto L_0x0101
        L_0x00f2:
            boolean r0 = r6.m42092d(r5)     // Catch:{ Throwable -> 0x0102 }
            if (r0 == 0) goto L_0x00fb
            r6.m42102n()     // Catch:{ Throwable -> 0x0102 }
        L_0x00fb:
            r6.m42100l()     // Catch:{ Throwable -> 0x0102 }
            r6.m42095g()     // Catch:{ Throwable -> 0x0102 }
        L_0x0101:
            goto L_0x0131
        L_0x0102:
            r0 = move-exception
            d.h.c.d.d r1 = r6.f39269o     // Catch:{ all -> 0x0133 }
            d.h.c.d.c$a r2 = p019d.p273h.p276c.p280d.C12800c.C12801a.ADAPTER_CALLBACK     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r3.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "onRewardedVideoAvailabilityChanged(available:"
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            r3.append(r7)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = ", "
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = "provider:"
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = r8.mo41403t()     // Catch:{ all -> 0x0133 }
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r4 = ")"
            r3.append(r4)     // Catch:{ all -> 0x0133 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0133 }
            r1.mo41426a(r2, r3, r0)     // Catch:{ all -> 0x0133 }
        L_0x0131:
            monitor-exit(r6)
            return
        L_0x0133:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12934na.mo41647a(boolean, d.h.c.pa):void");
    }

    /* renamed from: b */
    public void mo41648b(C12938pa smash) {
        String str = "mCurrentPlacement is null";
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdRewarded()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (this.f39814D == null) {
            this.f39814D = C12747I.m41186g().mo41224d().mo41692a().mo41482e().mo41564b();
        }
        JSONObject data = C12916j.m41962a((C12791c) smash, this.f39276v);
        try {
            if (this.f39814D != null) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39814D.mo41504c());
                data.put("rewardName", this.f39814D.mo41506e());
                data.put("rewardAmount", this.f39814D.mo41505d());
            } else {
                this.f39269o.mo41427b(C12801a.INTERNAL, str, 3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12733b event = new C12733b(10, data);
        if (!TextUtils.isEmpty(this.f39268n)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(Long.toString(event.mo41159d()));
            sb2.append(this.f39268n);
            sb2.append(smash.mo41403t());
            event.mo41156a("transId", C12916j.m41974b(sb2.toString()));
            if (!TextUtils.isEmpty(C12747I.m41186g().mo41227e())) {
                event.mo41156a("dynamicUserId", C12747I.m41186g().mo41227e());
            }
            Map<String, String> rvServerParams = C12747I.m41186g().mo41238l();
            if (rvServerParams != null) {
                for (String key : rvServerParams.keySet()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("custom_");
                    sb3.append(key);
                    event.mo41156a(sb3.toString(), rvServerParams.get(key));
                }
            }
        }
        C12787k.m41517g().mo41369d(event);
        C12820l lVar = this.f39814D;
        if (lVar == null) {
            this.f39269o.mo41427b(C12801a.INTERNAL, str, 3);
        } else if (this.f39276v) {
            this.f39811A.onRewardedVideoAdRewarded(smash.mo41406w(), this.f39814D);
        } else {
            this.f39821z.mo41612a(lVar);
        }
    }

    /* renamed from: a */
    public void mo41646a(C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdClicked()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (this.f39814D == null) {
            this.f39814D = C12747I.m41186g().mo41224d().mo41692a().mo41482e().mo41564b();
        }
        C12820l lVar = this.f39814D;
        if (lVar == null) {
            this.f39269o.mo41427b(C12801a.INTERNAL, "mCurrentPlacement is null", 3);
            return;
        }
        m42084a(128, (C12791c) smash, new Object[][]{new Object[]{VungleActivity.PLACEMENT_EXTRA, lVar.mo41504c()}});
        if (this.f39276v) {
            this.f39811A.onRewardedVideoAdClicked(smash.mo41406w(), this.f39814D);
        } else {
            this.f39821z.mo41619b(this.f39814D);
        }
    }

    /* renamed from: d */
    public void mo41650d(C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onRewardedVideoAdVisible()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        C12820l lVar = this.f39814D;
        if (lVar != null) {
            m42084a(11, (C12791c) smash, new Object[][]{new Object[]{VungleActivity.PLACEMENT_EXTRA, lVar.mo41504c()}});
            return;
        }
        this.f39269o.mo41427b(C12801a.INTERNAL, "mCurrentPlacement is null", 3);
    }

    /* renamed from: a */
    public void mo41148a(boolean connected) {
        if (this.f39270p) {
            C12802d dVar = this.f39269o;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("Network Availability Changed To: ");
            sb.append(connected);
            dVar.mo41427b(aVar, sb.toString(), 0);
            if (m42093e(connected)) {
                this.f39812B = !connected;
                this.f39821z.mo41616a(connected);
            }
        }
    }

    /* renamed from: e */
    private boolean m42093e(boolean networkState) {
        boolean shouldNotify = false;
        Boolean bool = this.f39271q;
        if (bool == null) {
            return false;
        }
        if (networkState && !bool.booleanValue() && m42096h()) {
            this.f39271q = Boolean.valueOf(true);
            shouldNotify = true;
        } else if (!networkState && this.f39271q.booleanValue()) {
            this.f39271q = Boolean.valueOf(false);
            shouldNotify = true;
        }
        return shouldNotify;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo41743c(boolean enabled) {
        this.f39813C = enabled;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41737a(C12820l currentPlacement) {
        this.f39814D = currentPlacement;
    }

    /* renamed from: f */
    private synchronized C12775b m42094f(C12938pa smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39818w);
        sb.append(":startAdapter(");
        sb.append(smash.mo41398o());
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        try {
            C12775b providerAdapter = mo41300b((C12791c) smash);
            if (providerAdapter == null) {
                return null;
            }
            C12747I.m41186g().mo41225d(providerAdapter);
            providerAdapter.setLogListener(this.f39269o);
            smash.mo41387a(providerAdapter);
            smash.mo41388a(C12792a.INITIATED);
            mo41306d(smash);
            smash.mo41756a(this.f39266l, this.f39268n, this.f39267m);
            return providerAdapter;
        } catch (Throwable e) {
            C12802d dVar2 = this.f39269o;
            C12801a aVar2 = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f39818w);
            sb2.append(":startAdapter(");
            sb2.append(smash.mo41403t());
            sb2.append(")");
            dVar2.mo41426a(aVar2, sb2.toString(), e);
            smash.mo41388a(C12792a.INIT_FAILED);
            if (m42092d(false)) {
                this.f39821z.mo41616a(this.f39271q.booleanValue());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(smash.mo41403t());
            sb3.append(" initialization failed - please verify that required dependencies are in you build path.");
            this.f39269o.mo41427b(C12801a.API, C12913g.m41923b(sb3.toString(), "Rewarded Video").toString(), 2);
            return null;
        }
    }

    /* renamed from: l */
    private C12775b m42100l() {
        C12775b initiatedAdapter = null;
        int activeAdapters = 0;
        for (int i = 0; i < this.f39263i.size() && initiatedAdapter == null; i++) {
            if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.AVAILABLE || ((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.INITIATED) {
                activeAdapters++;
                if (activeAdapters >= this.f39262h) {
                    break;
                }
            } else if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.NOT_INITIATED) {
                initiatedAdapter = m42094f((C12938pa) this.f39263i.get(i));
                if (initiatedAdapter == null) {
                    ((C12791c) this.f39263i.get(i)).mo41388a(C12792a.INIT_FAILED);
                }
            }
        }
        return initiatedAdapter;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41741b(int manualLoadInterval) {
        this.f39816F = manualLoadInterval;
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m42104p() {
        if (this.f39816F <= 0) {
            this.f39269o.mo41427b(C12801a.INTERNAL, "load interval is not set, ignoring", 1);
            return;
        }
        Timer timer = this.f39815E;
        if (timer != null) {
            timer.cancel();
        }
        this.f39815E = new Timer();
        this.f39815E.schedule(new C12931ma(this), (long) (this.f39816F * 1000));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        return;
     */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m42101m() {
        /*
            r8 = this;
            monitor-enter(r8)
            android.app.Activity r0 = r8.f39266l     // Catch:{ all -> 0x0089 }
            boolean r0 = p019d.p273h.p276c.p284h.C12916j.m41982c(r0)     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0087
            java.lang.Boolean r0 = r8.f39271q     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0087
        L_0x000f:
            java.lang.Boolean r0 = r8.f39271q     // Catch:{ all -> 0x0089 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0085
            r0 = 102(0x66, float:1.43E-43)
            r1 = 0
            r8.m42085a(r0, r1)     // Catch:{ all -> 0x0089 }
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r0 = r8.f39263i     // Catch:{ all -> 0x0089 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0089 }
        L_0x0023:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0089 }
            d.h.c.c r1 = (p019d.p273h.p276c.C12791c) r1     // Catch:{ all -> 0x0089 }
            d.h.c.c$a r2 = r1.mo41402s()     // Catch:{ all -> 0x0089 }
            d.h.c.c$a r3 = p019d.p273h.p276c.C12791c.C12792a.NOT_AVAILABLE     // Catch:{ all -> 0x0089 }
            if (r2 != r3) goto L_0x0084
            r2 = 1
            d.h.c.d.d r3 = r8.f39269o     // Catch:{ Throwable -> 0x0060 }
            d.h.c.d.c$a r4 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ Throwable -> 0x0060 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0060 }
            r5.<init>()     // Catch:{ Throwable -> 0x0060 }
            java.lang.String r6 = "Fetch from timer: "
            r5.append(r6)     // Catch:{ Throwable -> 0x0060 }
            java.lang.String r6 = r1.mo41398o()     // Catch:{ Throwable -> 0x0060 }
            r5.append(r6)     // Catch:{ Throwable -> 0x0060 }
            java.lang.String r6 = ":reload smash"
            r5.append(r6)     // Catch:{ Throwable -> 0x0060 }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x0060 }
            r3.mo41427b(r4, r5, r2)     // Catch:{ Throwable -> 0x0060 }
            r3 = r1
            d.h.c.pa r3 = (p019d.p273h.p276c.C12938pa) r3     // Catch:{ Throwable -> 0x0060 }
            r3.mo41752E()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0084
        L_0x0060:
            r3 = move-exception
            d.h.c.d.d r4 = r8.f39269o     // Catch:{ all -> 0x0089 }
            d.h.c.d.c$a r5 = p019d.p273h.p276c.p280d.C12800c.C12801a.NATIVE     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r6.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = r1.mo41398o()     // Catch:{ all -> 0x0089 }
            r6.append(r7)     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = " Failed to call fetchVideo(), "
            r6.append(r7)     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0089 }
            r6.append(r7)     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0089 }
            r4.mo41427b(r5, r6, r2)     // Catch:{ all -> 0x0089 }
        L_0x0084:
            goto L_0x0023
        L_0x0085:
            monitor-exit(r8)
            return
        L_0x0087:
            monitor-exit(r8)
            return
        L_0x0089:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x008d
        L_0x008c:
            throw r0
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12934na.m42101m():void");
    }

    /* renamed from: o */
    private synchronized void m42103o() {
        boolean mediationStatus = false;
        Iterator it = this.f39263i.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (((C12791c) it.next()).mo41402s() == C12792a.AVAILABLE) {
                mediationStatus = true;
                break;
            }
        }
        m42085a(3, new Object[][]{new Object[]{"status", String.valueOf(mediationStatus)}});
        Iterator it2 = this.f39263i.iterator();
        while (it2.hasNext()) {
            C12791c smash = (C12791c) it2.next();
            if (smash.mo41402s() == C12792a.AVAILABLE) {
                m42084a(3, smash, new Object[][]{new Object[]{"status", "true"}});
            } else if (smash.mo41402s() == C12792a.NOT_AVAILABLE || smash.mo41402s() == C12792a.INITIATED) {
                m42084a(3, smash, new Object[][]{new Object[]{"status", AdultContentAnalytics.UNLOCK}});
            }
        }
        if (!(mo41305d() == null || mo41305d().mo41397n() == null)) {
            C12791c d = mo41305d();
            Object[][] objArr = new Object[1][];
            Object[] objArr2 = new Object[2];
            objArr2[0] = "status";
            objArr2[1] = m42098j() ? "true" : AdultContentAnalytics.UNLOCK;
            objArr[0] = objArr2;
            m42084a(3, d, objArr);
        }
    }

    /* renamed from: d */
    private synchronized boolean m42092d(boolean adapterAvailability) {
        boolean shouldNotify;
        shouldNotify = false;
        if (this.f39271q == null) {
            m42104p();
            if (adapterAvailability) {
                this.f39271q = Boolean.valueOf(true);
                shouldNotify = true;
            } else if (!m42098j() && m42097i()) {
                this.f39271q = Boolean.valueOf(false);
                shouldNotify = true;
            }
        } else if (adapterAvailability && !this.f39271q.booleanValue()) {
            this.f39271q = Boolean.valueOf(true);
            shouldNotify = true;
        } else if (!adapterAvailability && this.f39271q.booleanValue() && !m42096h() && !m42098j()) {
            this.f39271q = Boolean.valueOf(false);
            shouldNotify = true;
        }
        return shouldNotify;
    }

    /* renamed from: i */
    private synchronized boolean m42097i() {
        int countInactive;
        countInactive = 0;
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41402s() == C12792a.INIT_FAILED || smash.mo41402s() == C12792a.CAPPED_PER_DAY || smash.mo41402s() == C12792a.CAPPED_PER_SESSION || smash.mo41402s() == C12792a.NOT_AVAILABLE || smash.mo41402s() == C12792a.EXHAUSTED) {
                countInactive++;
            }
        }
        return this.f39263i.size() == countInactive;
    }

    /* renamed from: h */
    private synchronized boolean m42096h() {
        boolean hasAvailableSmash;
        hasAvailableSmash = false;
        Iterator it = this.f39263i.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((C12791c) it.next()).mo41402s() == C12792a.AVAILABLE) {
                    hasAvailableSmash = true;
                    break;
                }
            } else {
                break;
            }
        }
        return hasAvailableSmash;
    }

    /* renamed from: j */
    private synchronized boolean m42098j() {
        if (mo41305d() == null) {
            return false;
        }
        return ((C12938pa) mo41305d()).mo41753F();
    }

    /* renamed from: c */
    private void m42091c(String placementName) {
        for (int i = 0; i < this.f39263i.size(); i++) {
            if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.AVAILABLE) {
                m42087a((C12791c) this.f39263i.get(i), placementName, true);
            } else if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.NOT_AVAILABLE) {
                m42087a((C12791c) this.f39263i.get(i), placementName, false);
            }
        }
        if (mo41305d() != null && mo41305d().mo41397n() != null) {
            m42087a(mo41305d(), placementName, m42098j());
        }
    }

    /* renamed from: a */
    private void m42086a(C12791c selectedSmash, int priority, String placementName) {
        m42089b(selectedSmash, placementName, true);
        if (!this.f39276v) {
            int i = 0;
            while (i < this.f39263i.size() && i < priority) {
                C12791c smash = (C12791c) this.f39263i.get(i);
                if (smash.mo41402s() == C12792a.NOT_AVAILABLE) {
                    m42089b(smash, placementName, false);
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    private void m42087a(C12791c smash, String placementName, boolean status) {
        Object[][] objArr = new Object[2][];
        objArr[0] = new Object[]{VungleActivity.PLACEMENT_EXTRA, placementName};
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = status ? "true" : AdultContentAnalytics.UNLOCK;
        objArr[1] = objArr2;
        m42084a(19, smash, objArr);
    }

    /* renamed from: b */
    private void m42089b(C12791c smash, String placementName, boolean status) {
        Object[][] objArr = new Object[2][];
        objArr[0] = new Object[]{VungleActivity.PLACEMENT_EXTRA, placementName};
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = status ? "true" : AdultContentAnalytics.UNLOCK;
        objArr[1] = objArr2;
        m42084a(119, smash, objArr);
    }

    /* renamed from: n */
    private synchronized void m42102n() {
        if (mo41305d() != null && !this.f39272r) {
            this.f39272r = true;
            if (m42094f((C12938pa) mo41305d()) == null) {
                this.f39821z.mo41616a(this.f39271q.booleanValue());
            }
        } else if (!m42098j()) {
            this.f39821z.mo41616a(this.f39271q.booleanValue());
        } else if (m42092d(true)) {
            this.f39821z.mo41616a(this.f39271q.booleanValue());
        }
    }

    /* renamed from: g */
    private synchronized void m42095g() {
        if (m42099k()) {
            this.f39269o.mo41427b(C12801a.INTERNAL, "Reset Iteration", 0);
            boolean isAvailable = false;
            Iterator it = this.f39263i.iterator();
            while (it.hasNext()) {
                C12791c smash = (C12791c) it.next();
                if (smash.mo41402s() == C12792a.EXHAUSTED) {
                    smash.mo41184k();
                }
                if (smash.mo41402s() == C12792a.AVAILABLE) {
                    isAvailable = true;
                }
            }
            this.f39269o.mo41427b(C12801a.INTERNAL, "End of Reset Iteration", 0);
            if (m42092d(isAvailable)) {
                this.f39821z.mo41616a(this.f39271q.booleanValue());
            }
        }
    }

    /* renamed from: k */
    private synchronized boolean m42099k() {
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41402s() == C12792a.NOT_INITIATED || smash.mo41402s() == C12792a.INITIATED) {
                return false;
            }
            if (smash.mo41402s() == C12792a.AVAILABLE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m42085a(int eventId, Object[][] keyVals) {
        JSONObject data = C12916j.m41965a(this.f39276v);
        if (keyVals != null) {
            try {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            } catch (Exception e) {
                C12802d dVar = this.f39269o;
                C12801a aVar = C12801a.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("RewardedVideoManager logMediationEvent ");
                sb.append(Log.getStackTraceString(e));
                dVar.mo41427b(aVar, sb.toString(), 3);
            }
        }
        C12787k.m41517g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: a */
    private void m42084a(int eventId, C12791c smash, Object[][] keyVals) {
        JSONObject data = C12916j.m41962a(smash, this.f39276v);
        if (keyVals != null) {
            try {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            } catch (Exception e) {
                C12802d dVar = this.f39269o;
                C12801a aVar = C12801a.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("RewardedVideoManager logProviderEvent ");
                sb.append(Log.getStackTraceString(e));
                dVar.mo41427b(aVar, sb.toString(), 3);
            }
        }
        C12787k.m41517g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: b */
    public void mo41684b() {
        boolean atLeastOneSmashBecameAvailable = false;
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41402s() == C12792a.CAPPED_PER_DAY) {
                m42084a(150, smash, new Object[][]{new Object[]{"status", AdultContentAnalytics.UNLOCK}});
                smash.mo41388a(C12792a.NOT_AVAILABLE);
                if (((C12938pa) smash).mo41753F() && smash.mo41381A()) {
                    smash.mo41388a(C12792a.AVAILABLE);
                    atLeastOneSmashBecameAvailable = true;
                }
            }
        }
        if (atLeastOneSmashBecameAvailable && m42092d(true)) {
            this.f39821z.mo41616a(true);
        }
    }
}
