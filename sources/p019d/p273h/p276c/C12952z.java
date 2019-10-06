package p019d.p273h.p276c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mopub.mobileads.VastIconXmlManager;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p278b.C12784h;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12817i;
import p019d.p273h.p276c.p282f.C12858Z;
import p019d.p273h.p276c.p282f.C12867da;
import p019d.p273h.p276c.p282f.C12869ea;
import p019d.p273h.p276c.p282f.C12871fa;
import p019d.p273h.p276c.p282f.C12872g;
import p019d.p273h.p276c.p282f.C12882l;
import p019d.p273h.p276c.p282f.C12884m;
import p019d.p273h.p276c.p282f.C12886n;
import p019d.p273h.p276c.p284h.C12908c;
import p019d.p273h.p276c.p284h.C12908c.C12909a;
import p019d.p273h.p276c.p284h.C12910d;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.z */
/* compiled from: InterstitialManager */
class C12952z extends C12771a implements C12882l, C12886n, C12756c, C12871fa, C12867da, C12910d {

    /* renamed from: A */
    private boolean f39863A = false;

    /* renamed from: B */
    private boolean f39864B = false;

    /* renamed from: C */
    private boolean f39865C;

    /* renamed from: D */
    private C12817i f39866D;

    /* renamed from: E */
    private C12937p f39867E = C12937p.m42122a();

    /* renamed from: F */
    private boolean f39868F = false;

    /* renamed from: G */
    private Map<String, C12740C> f39869G = new ConcurrentHashMap();

    /* renamed from: H */
    private CopyOnWriteArraySet<String> f39870H = new CopyOnWriteArraySet<>();

    /* renamed from: I */
    private long f39871I;

    /* renamed from: J */
    private boolean f39872J = false;

    /* renamed from: w */
    private final String f39873w = getClass().getName();

    /* renamed from: x */
    private C12858Z f39874x;

    /* renamed from: y */
    private C12869ea f39875y;

    /* renamed from: z */
    private C12872g f39876z;

    C12952z() {
    }

    /* renamed from: a */
    public void mo41782a(C12884m listener) {
        this.f39874x = (C12858Z) listener;
        this.f39867E.mo41748a(listener);
    }

    /* renamed from: a */
    public void mo41780a(C12869ea listener) {
        this.f39875y = listener;
    }

    /* renamed from: a */
    public synchronized void mo41778a(Activity activity, String appKey, String userId) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39873w);
        sb.append(":initInterstitial(appKey: ");
        sb.append(appKey);
        sb.append(", userId: ");
        sb.append(userId);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        this.f39268n = appKey;
        this.f39267m = userId;
        this.f39266l = activity;
        if (this.f39276v) {
            this.f39262h = this.f39263i.size();
            Iterator it = new CopyOnWriteArrayList<>(this.f39263i).iterator();
            while (it.hasNext()) {
                C12791c smash = (C12791c) it.next();
                if (!smash.mo41404u().equals("SupersonicAds")) {
                    this.f39263i.remove(smash);
                    C12802d dVar2 = this.f39269o;
                    C12801a aVar2 = C12801a.INTERNAL;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(smash.mo41396l());
                    sb2.append(" has been removed from the IS waterfall due to demand only mode");
                    dVar2.mo41427b(aVar2, sb2.toString(), 1);
                } else if (m42178i((C12740C) smash) == null) {
                    smash.mo41388a(C12792a.INIT_FAILED);
                } else {
                    this.f39869G.put(smash.mo41406w(), (C12740C) smash);
                }
            }
        } else {
            this.f39261g.mo41686a((Context) this.f39266l);
            int dailyCappedCount = 0;
            Iterator it2 = this.f39263i.iterator();
            while (it2.hasNext()) {
                C12791c smash2 = (C12791c) it2.next();
                if (this.f39261g.mo41690d(smash2)) {
                    m42168a(250, smash2, new Object[][]{new Object[]{"status", AdultContentAnalytics.UNLOCK}});
                }
                if (this.f39261g.mo41689c(smash2)) {
                    smash2.mo41388a(C12792a.CAPPED_PER_DAY);
                    dailyCappedCount++;
                }
            }
            if (dailyCappedCount == this.f39263i.size()) {
                this.f39865C = true;
            }
            for (int i = 0; i < this.f39262h && m42181k() != null; i++) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01be, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41787g() {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 2110(0x83e, float:2.957E-42)
            r1 = 2
            r2 = 3
            r3 = 0
            r4 = 1
            boolean r5 = r11.f39872J     // Catch:{ Exception -> 0x0153 }
            if (r5 == 0) goto L_0x0016
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "loadInterstitial() cannot be invoked while showing"
            r5.mo41427b(r6, r7, r2)     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x0016:
            r5 = 0
            r11.f39866D = r5     // Catch:{ Exception -> 0x0153 }
            d.h.c.f.Z r6 = r11.f39874x     // Catch:{ Exception -> 0x0153 }
            r6.mo41611a(r5)     // Catch:{ Exception -> 0x0153 }
            boolean r6 = r11.f39864B     // Catch:{ Exception -> 0x0153 }
            if (r6 != 0) goto L_0x0146
            d.h.c.p r6 = r11.f39867E     // Catch:{ Exception -> 0x0153 }
            boolean r6 = r6.mo41751b()     // Catch:{ Exception -> 0x0153 }
            if (r6 == 0) goto L_0x002c
            goto L_0x0146
        L_0x002c:
            d.h.c.N r6 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ Exception -> 0x0153 }
            d.h.c.N$a r6 = r6.mo41247a()     // Catch:{ Exception -> 0x0153 }
            d.h.c.N$a r7 = p019d.p273h.p276c.C12753N.C12754a.NOT_INIT     // Catch:{ Exception -> 0x0153 }
            if (r6 != r7) goto L_0x0043
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r8 = "init() must be called before loadInterstitial()"
            r5.mo41427b(r7, r8, r2)     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x0043:
            d.h.c.N$a r7 = p019d.p273h.p276c.C12753N.C12754a.INIT_IN_PROGRESS     // Catch:{ Exception -> 0x0153 }
            r8 = 2001(0x7d1, float:2.804E-42)
            if (r6 != r7) goto L_0x007e
            d.h.c.N r7 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ Exception -> 0x0153 }
            boolean r7 = r7.mo41250c()     // Catch:{ Exception -> 0x0153 }
            if (r7 == 0) goto L_0x006a
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r8 = "init() had failed"
            r5.mo41427b(r7, r8, r2)     // Catch:{ Exception -> 0x0153 }
            d.h.c.p r5 = r11.f39867E     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "init() had failed"
            java.lang.String r8 = "Interstitial"
            d.h.c.d.b r7 = p019d.p273h.p276c.p284h.C12913g.m41923b(r7, r8)     // Catch:{ Exception -> 0x0153 }
            r5.mo41746a(r7)     // Catch:{ Exception -> 0x0153 }
            goto L_0x007c
        L_0x006a:
            java.util.Date r7 = new java.util.Date     // Catch:{ Exception -> 0x0153 }
            r7.<init>()     // Catch:{ Exception -> 0x0153 }
            long r9 = r7.getTime()     // Catch:{ Exception -> 0x0153 }
            r11.f39871I = r9     // Catch:{ Exception -> 0x0153 }
            r11.m42170a(r8, r5)     // Catch:{ Exception -> 0x0153 }
            r11.f39863A = r4     // Catch:{ Exception -> 0x0153 }
            r11.f39868F = r4     // Catch:{ Exception -> 0x0153 }
        L_0x007c:
            monitor-exit(r11)
            return
        L_0x007e:
            d.h.c.N$a r7 = p019d.p273h.p276c.C12753N.C12754a.INIT_FAILED     // Catch:{ Exception -> 0x0153 }
            if (r6 != r7) goto L_0x009a
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r8 = "init() had failed"
            r5.mo41427b(r7, r8, r2)     // Catch:{ Exception -> 0x0153 }
            d.h.c.p r5 = r11.f39867E     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "init() had failed"
            java.lang.String r8 = "Interstitial"
            d.h.c.d.b r7 = p019d.p273h.p276c.p284h.C12913g.m41923b(r7, r8)     // Catch:{ Exception -> 0x0153 }
            r5.mo41746a(r7)     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x009a:
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r7 = r11.f39263i     // Catch:{ Exception -> 0x0153 }
            int r7 = r7.size()     // Catch:{ Exception -> 0x0153 }
            if (r7 != 0) goto L_0x00ba
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r7 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r8 = "the server response does not contain interstitial data"
            r5.mo41427b(r7, r8, r2)     // Catch:{ Exception -> 0x0153 }
            d.h.c.p r5 = r11.f39867E     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "the server response does not contain interstitial data"
            java.lang.String r8 = "Interstitial"
            d.h.c.d.b r7 = p019d.p273h.p276c.p284h.C12913g.m41923b(r7, r8)     // Catch:{ Exception -> 0x0153 }
            r5.mo41746a(r7)     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x00ba:
            java.util.Date r7 = new java.util.Date     // Catch:{ Exception -> 0x0153 }
            r7.<init>()     // Catch:{ Exception -> 0x0153 }
            long r9 = r7.getTime()     // Catch:{ Exception -> 0x0153 }
            r11.f39871I = r9     // Catch:{ Exception -> 0x0153 }
            r11.m42170a(r8, r5)     // Catch:{ Exception -> 0x0153 }
            r11.f39868F = r4     // Catch:{ Exception -> 0x0153 }
            r11.m42176h()     // Catch:{ Exception -> 0x0153 }
            d.h.c.c$a[] r5 = new p019d.p273h.p276c.C12791c.C12792a[r4]     // Catch:{ Exception -> 0x0153 }
            d.h.c.c$a r7 = p019d.p273h.p276c.C12791c.C12792a.INITIATED     // Catch:{ Exception -> 0x0153 }
            r5[r3] = r7     // Catch:{ Exception -> 0x0153 }
            int r5 = r11.m42166a(r5)     // Catch:{ Exception -> 0x0153 }
            if (r5 != 0) goto L_0x0112
            boolean r5 = r11.f39865C     // Catch:{ Exception -> 0x0153 }
            if (r5 != 0) goto L_0x00e1
            r11.f39863A = r4     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x00e1:
            java.lang.String r5 = "no ads to load"
            d.h.c.d.b r5 = p019d.p273h.p276c.p284h.C12913g.m41919a(r5)     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.d r7 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r8 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r9 = r5.mo41429b()     // Catch:{ Exception -> 0x0153 }
            r7.mo41427b(r8, r9, r4)     // Catch:{ Exception -> 0x0153 }
            d.h.c.p r7 = r11.f39867E     // Catch:{ Exception -> 0x0153 }
            r7.mo41746a(r5)     // Catch:{ Exception -> 0x0153 }
            java.lang.Object[][] r7 = new java.lang.Object[r4][]     // Catch:{ Exception -> 0x0153 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0153 }
            java.lang.String r9 = "errorCode"
            r8[r3] = r9     // Catch:{ Exception -> 0x0153 }
            int r9 = r5.mo41428a()     // Catch:{ Exception -> 0x0153 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0153 }
            r8[r4] = r9     // Catch:{ Exception -> 0x0153 }
            r7[r3] = r8     // Catch:{ Exception -> 0x0153 }
            r11.m42170a(r0, r7)     // Catch:{ Exception -> 0x0153 }
            r11.f39868F = r3     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x0112:
            r11.f39863A = r4     // Catch:{ Exception -> 0x0153 }
            r11.f39864B = r4     // Catch:{ Exception -> 0x0153 }
            r5 = 0
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r7 = r11.f39263i     // Catch:{ Exception -> 0x0153 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x0153 }
        L_0x011d:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x0153 }
            if (r8 == 0) goto L_0x0145
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x0153 }
            d.h.c.c r8 = (p019d.p273h.p276c.C12791c) r8     // Catch:{ Exception -> 0x0153 }
            d.h.c.c$a r9 = r8.mo41402s()     // Catch:{ Exception -> 0x0153 }
            d.h.c.c$a r10 = p019d.p273h.p276c.C12791c.C12792a.INITIATED     // Catch:{ Exception -> 0x0153 }
            if (r9 != r10) goto L_0x0144
            d.h.c.c$a r9 = p019d.p273h.p276c.C12791c.C12792a.LOAD_PENDING     // Catch:{ Exception -> 0x0153 }
            r8.mo41388a(r9)     // Catch:{ Exception -> 0x0153 }
            r9 = r8
            d.h.c.C r9 = (p019d.p273h.p276c.C12740C) r9     // Catch:{ Exception -> 0x0153 }
            r11.m42177h(r9)     // Catch:{ Exception -> 0x0153 }
            int r5 = r5 + 1
            int r9 = r11.f39262h     // Catch:{ Exception -> 0x0153 }
            if (r5 < r9) goto L_0x0144
            monitor-exit(r11)
            return
        L_0x0144:
            goto L_0x011d
        L_0x0145:
            goto L_0x01bd
        L_0x0146:
            d.h.c.d.d r5 = r11.f39269o     // Catch:{ Exception -> 0x0153 }
            d.h.c.d.c$a r6 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "Load Interstitial is already in progress"
            r5.mo41427b(r6, r7, r2)     // Catch:{ Exception -> 0x0153 }
            monitor-exit(r11)
            return
        L_0x0151:
            r0 = move-exception
            goto L_0x01bf
        L_0x0153:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0151 }
            r6.<init>()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = "loadInterstitial exception "
            r6.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r5.getMessage()     // Catch:{ all -> 0x0151 }
            r6.append(r7)     // Catch:{ all -> 0x0151 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0151 }
            d.h.c.d.b r6 = p019d.p273h.p276c.p284h.C12913g.m41922b(r6)     // Catch:{ all -> 0x0151 }
            d.h.c.d.d r7 = r11.f39269o     // Catch:{ all -> 0x0151 }
            d.h.c.d.c$a r8 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x0151 }
            java.lang.String r9 = r6.mo41429b()     // Catch:{ all -> 0x0151 }
            r7.mo41427b(r8, r9, r2)     // Catch:{ all -> 0x0151 }
            d.h.c.p r2 = r11.f39867E     // Catch:{ all -> 0x0151 }
            r2.mo41746a(r6)     // Catch:{ all -> 0x0151 }
            boolean r2 = r11.f39868F     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x01bd
            r11.f39868F = r3     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = r5.getMessage()     // Catch:{ all -> 0x0151 }
            java.lang.String r7 = r5.getMessage()     // Catch:{ all -> 0x0151 }
            int r7 = r7.length()     // Catch:{ all -> 0x0151 }
            r8 = 39
            int r7 = java.lang.Math.min(r7, r8)     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = r2.substring(r3, r7)     // Catch:{ all -> 0x0151 }
            java.lang.Object[][] r7 = new java.lang.Object[r1][]     // Catch:{ all -> 0x0151 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x0151 }
            java.lang.String r9 = "errorCode"
            r8[r3] = r9     // Catch:{ all -> 0x0151 }
            int r9 = r6.mo41428a()     // Catch:{ all -> 0x0151 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0151 }
            r8[r4] = r9     // Catch:{ all -> 0x0151 }
            r7[r3] = r8     // Catch:{ all -> 0x0151 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0151 }
            java.lang.String r8 = "reason"
            r1[r3] = r8     // Catch:{ all -> 0x0151 }
            r1[r4] = r2     // Catch:{ all -> 0x0151 }
            r7[r4] = r1     // Catch:{ all -> 0x0151 }
            r11.m42170a(r0, r7)     // Catch:{ all -> 0x0151 }
        L_0x01bd:
            monitor-exit(r11)
            return
        L_0x01bf:
            monitor-exit(r11)
            goto L_0x01c2
        L_0x01c1:
            throw r0
        L_0x01c2:
            goto L_0x01c1
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12952z.mo41787g():void");
    }

    /* renamed from: d */
    public void mo41786d(String placementName) {
        if (this.f39872J) {
            this.f39269o.mo41427b(C12801a.API, "showInterstitial() cannot be invoked while showing", 3);
            return;
        }
        String str = "Interstitial";
        if (this.f39270p) {
            Activity activity = this.f39266l;
            if (activity != null && !C12916j.m41982c((Context) activity)) {
                this.f39874x.mo41618b(C12913g.m41926d(str));
                return;
            }
        }
        if (!this.f39863A) {
            this.f39874x.mo41618b(C12913g.m41925c(str, "showInterstitial failed - You need to load interstitial before showing it"));
            return;
        }
        for (int i = 0; i < this.f39263i.size(); i++) {
            C12791c smash = (C12791c) this.f39263i.get(i);
            if (smash.mo41402s() == C12792a.AVAILABLE) {
                C12908c.m41895b((Context) this.f39266l, this.f39866D);
                if (C12908c.m41898c((Context) this.f39266l, this.f39866D) != C12909a.NOT_CAPPED) {
                    m42173b(2400, (Object[][]) null);
                }
                m42172b(2201, smash, null);
                this.f39872J = true;
                ((C12740C) smash).mo41168G();
                if (smash.mo41408y()) {
                    m42167a(2401, smash);
                }
                this.f39261g.mo41688b(smash);
                if (this.f39261g.mo41689c(smash)) {
                    smash.mo41388a(C12792a.CAPPED_PER_DAY);
                    m42168a(250, smash, new Object[][]{new Object[]{"status", "true"}});
                }
                this.f39863A = false;
                if (!smash.mo41381A()) {
                    m42181k();
                }
                return;
            }
        }
        this.f39874x.mo41618b(C12913g.m41925c(str, "showInterstitial failed - No adapters ready to show"));
    }

    /* renamed from: a */
    public void mo41781a(C12872g listener) {
        this.f39876z = listener;
        this.f39867E.mo41747a(listener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41785c(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = 3
            r9.f39866D = r0     // Catch:{ Exception -> 0x00f8 }
            d.h.c.p r2 = r9.f39867E     // Catch:{ Exception -> 0x00f8 }
            boolean r2 = r2.mo41750a(r10)     // Catch:{ Exception -> 0x00f8 }
            r3 = 1
            if (r2 == 0) goto L_0x002d
            d.h.c.d.d r0 = r9.f39269o     // Catch:{ Exception -> 0x00f8 }
            d.h.c.d.c$a r2 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x00f8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f8 }
            r4.<init>()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = "Load Interstitial for "
            r4.append(r5)     // Catch:{ Exception -> 0x00f8 }
            r4.append(r10)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r5 = " is already in progress"
            r4.append(r5)     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00f8 }
            r0.mo41427b(r2, r4, r3)     // Catch:{ Exception -> 0x00f8 }
            monitor-exit(r9)
            return
        L_0x002d:
            d.h.c.N r2 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ Exception -> 0x00f8 }
            d.h.c.N$a r2 = r2.mo41247a()     // Catch:{ Exception -> 0x00f8 }
            d.h.c.N$a r4 = p019d.p273h.p276c.C12753N.C12754a.NOT_INIT     // Catch:{ Exception -> 0x00f8 }
            if (r2 != r4) goto L_0x0044
            d.h.c.d.d r0 = r9.f39269o     // Catch:{ Exception -> 0x00f8 }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r4 = "init() must be called before loadInterstitial()"
            r0.mo41427b(r3, r4, r1)     // Catch:{ Exception -> 0x00f8 }
            monitor-exit(r9)
            return
        L_0x0044:
            d.h.c.N$a r4 = p019d.p273h.p276c.C12753N.C12754a.INIT_IN_PROGRESS     // Catch:{ Exception -> 0x00f8 }
            if (r2 != r4) goto L_0x007b
            d.h.c.N r0 = p019d.p273h.p276c.C12753N.m41255b()     // Catch:{ Exception -> 0x00f8 }
            boolean r0 = r0.mo41250c()     // Catch:{ Exception -> 0x00f8 }
            if (r0 == 0) goto L_0x0069
            d.h.c.d.d r0 = r9.f39269o     // Catch:{ Exception -> 0x00f8 }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r4 = "init() had failed"
            r0.mo41427b(r3, r4, r1)     // Catch:{ Exception -> 0x00f8 }
            d.h.c.p r0 = r9.f39867E     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = "init() had failed"
            java.lang.String r4 = "Interstitial"
            d.h.c.d.b r3 = p019d.p273h.p276c.p284h.C12913g.m41923b(r3, r4)     // Catch:{ Exception -> 0x00f8 }
            r0.mo41749a(r10, r3)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x0079
        L_0x0069:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            long r3 = r0.getTime()     // Catch:{ Exception -> 0x00f8 }
            r9.f39871I = r3     // Catch:{ Exception -> 0x00f8 }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r9.f39870H     // Catch:{ Exception -> 0x00f8 }
            r0.add(r10)     // Catch:{ Exception -> 0x00f8 }
        L_0x0079:
            monitor-exit(r9)
            return
        L_0x007b:
            d.h.c.N$a r4 = p019d.p273h.p276c.C12753N.C12754a.INIT_FAILED     // Catch:{ Exception -> 0x00f8 }
            if (r2 != r4) goto L_0x0097
            d.h.c.d.d r0 = r9.f39269o     // Catch:{ Exception -> 0x00f8 }
            d.h.c.d.c$a r3 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r4 = "init() had failed"
            r0.mo41427b(r3, r4, r1)     // Catch:{ Exception -> 0x00f8 }
            d.h.c.p r0 = r9.f39867E     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r3 = "init() had failed"
            java.lang.String r4 = "Interstitial"
            d.h.c.d.b r3 = p019d.p273h.p276c.p284h.C12913g.m41923b(r3, r4)     // Catch:{ Exception -> 0x00f8 }
            r0.mo41749a(r10, r3)     // Catch:{ Exception -> 0x00f8 }
            monitor-exit(r9)
            return
        L_0x0097:
            java.util.Map<java.lang.String, d.h.c.C> r4 = r9.f39869G     // Catch:{ Exception -> 0x00f8 }
            boolean r4 = r4.containsKey(r10)     // Catch:{ Exception -> 0x00f8 }
            if (r4 != 0) goto L_0x00cc
            java.lang.String r4 = "Interstitial"
            d.h.c.d.b r4 = p019d.p273h.p276c.p284h.C12913g.m41928e(r4)     // Catch:{ Exception -> 0x00f8 }
            d.h.c.p r5 = r9.f39867E     // Catch:{ Exception -> 0x00f8 }
            r5.mo41749a(r10, r4)     // Catch:{ Exception -> 0x00f8 }
            r5 = 2001(0x7d1, float:2.804E-42)
            r9.m42170a(r5, r0)     // Catch:{ Exception -> 0x00f8 }
            r0 = 2110(0x83e, float:2.957E-42)
            java.lang.Object[][] r5 = new java.lang.Object[r3][]     // Catch:{ Exception -> 0x00f8 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r7 = "errorCode"
            r8 = 0
            r6[r8] = r7     // Catch:{ Exception -> 0x00f8 }
            int r7 = r4.mo41428a()     // Catch:{ Exception -> 0x00f8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00f8 }
            r6[r3] = r7     // Catch:{ Exception -> 0x00f8 }
            r5[r8] = r6     // Catch:{ Exception -> 0x00f8 }
            r9.m42170a(r0, r5)     // Catch:{ Exception -> 0x00f8 }
            monitor-exit(r9)
            return
        L_0x00cc:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x00f8 }
            r0.<init>()     // Catch:{ Exception -> 0x00f8 }
            long r3 = r0.getTime()     // Catch:{ Exception -> 0x00f8 }
            r9.f39871I = r3     // Catch:{ Exception -> 0x00f8 }
            java.util.Map<java.lang.String, d.h.c.C> r0 = r9.f39869G     // Catch:{ Exception -> 0x00f8 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ Exception -> 0x00f8 }
            d.h.c.C r0 = (p019d.p273h.p276c.C12740C) r0     // Catch:{ Exception -> 0x00f8 }
            d.h.c.c$a r3 = r0.mo41402s()     // Catch:{ Exception -> 0x00f8 }
            d.h.c.c$a r4 = p019d.p273h.p276c.C12791c.C12792a.INIT_PENDING     // Catch:{ Exception -> 0x00f8 }
            if (r3 != r4) goto L_0x00ed
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r3 = r9.f39870H     // Catch:{ Exception -> 0x00f8 }
            r3.add(r10)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00f5
        L_0x00ed:
            d.h.c.c$a r3 = p019d.p273h.p276c.C12791c.C12792a.LOAD_PENDING     // Catch:{ Exception -> 0x00f8 }
            r0.mo41388a(r3)     // Catch:{ Exception -> 0x00f8 }
            r9.m42177h(r0)     // Catch:{ Exception -> 0x00f8 }
        L_0x00f5:
            goto L_0x010f
        L_0x00f6:
            r10 = move-exception
            goto L_0x0111
        L_0x00f8:
            r0 = move-exception
            java.lang.String r2 = "loadInterstitial exception"
            d.h.c.d.b r2 = p019d.p273h.p276c.p284h.C12913g.m41922b(r2)     // Catch:{ all -> 0x00f6 }
            d.h.c.d.d r3 = r9.f39269o     // Catch:{ all -> 0x00f6 }
            d.h.c.d.c$a r4 = p019d.p273h.p276c.p280d.C12800c.C12801a.API     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r2.mo41429b()     // Catch:{ all -> 0x00f6 }
            r3.mo41427b(r4, r5, r1)     // Catch:{ all -> 0x00f6 }
            d.h.c.p r1 = r9.f39867E     // Catch:{ all -> 0x00f6 }
            r1.mo41746a(r2)     // Catch:{ all -> 0x00f6 }
        L_0x010f:
            monitor-exit(r9)
            return
        L_0x0111:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12952z.mo41785c(java.lang.String):void");
    }

    /* renamed from: a */
    public void mo41783a(String instanceId, String placementName) {
        String str = "Interstitial";
        if (this.f39270p) {
            Activity activity = this.f39266l;
            if (activity != null && !C12916j.m41982c((Context) activity)) {
                this.f39876z.onInterstitialAdShowFailed(instanceId, C12913g.m41926d(str));
                return;
            }
        }
        boolean existingInstanceId = false;
        for (int i = 0; i < this.f39263i.size(); i++) {
            C12791c smash = (C12791c) this.f39263i.get(i);
            if (smash.mo41406w().equals(instanceId)) {
                existingInstanceId = true;
                if (smash.mo41402s() == C12792a.AVAILABLE) {
                    m42167a(2201, smash);
                    ((C12740C) smash).mo41168G();
                    if (smash.mo41408y()) {
                        m42167a(2401, smash);
                    }
                    m42174e(instanceId);
                    return;
                }
            }
        }
        String str2 = "no ads to show";
        if (!existingInstanceId) {
            this.f39876z.onInterstitialAdShowFailed(instanceId, C12913g.m41928e(str2));
        } else {
            this.f39876z.onInterstitialAdShowFailed(instanceId, C12913g.m41925c(str, str2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        return r1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo41784b(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f39270p     // Catch:{ all -> 0x0047 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            android.app.Activity r0 = r4.f39266l     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0014
            android.app.Activity r0 = r4.f39266l     // Catch:{ all -> 0x0047 }
            boolean r0 = p019d.p273h.p276c.p284h.C12916j.m41982c(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0014
            monitor-exit(r4)
            return r1
        L_0x0014:
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r0 = r4.f39263i     // Catch:{ all -> 0x0047 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0047 }
        L_0x001a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0047 }
            d.h.c.c r2 = (p019d.p273h.p276c.C12791c) r2     // Catch:{ all -> 0x0047 }
            java.lang.String r3 = r2.mo41406w()     // Catch:{ all -> 0x0047 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x0044
            d.h.c.c$a r0 = r2.mo41402s()     // Catch:{ all -> 0x0047 }
            d.h.c.c$a r3 = p019d.p273h.p276c.C12791c.C12792a.AVAILABLE     // Catch:{ all -> 0x0047 }
            if (r0 != r3) goto L_0x0042
            r0 = r2
            d.h.c.C r0 = (p019d.p273h.p276c.C12740C) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.mo41166E()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0042
            r1 = 1
        L_0x0042:
            monitor-exit(r4)
            return r1
        L_0x0044:
            goto L_0x001a
        L_0x0045:
            monitor-exit(r4)
            return r1
        L_0x0047:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x004b
        L_0x004a:
            throw r5
        L_0x004b:
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12952z.mo41784b(java.lang.String):boolean");
    }

    /* renamed from: a */
    public synchronized void mo41652a(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(" :onInterstitialInitSuccess()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42167a(2205, (C12791c) smash);
        this.f39865C = true;
        if (this.f39276v) {
            String instanceId = smash.mo41406w();
            if (this.f39870H.contains(instanceId)) {
                this.f39870H.remove(instanceId);
                mo41785c(instanceId);
            }
        } else if (this.f39863A) {
            if (m42166a(C12792a.AVAILABLE, C12792a.LOAD_PENDING) < this.f39262h) {
                smash.mo41388a(C12792a.LOAD_PENDING);
                m42177h(smash);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo41657b(C12799b error, C12740C smash) {
        try {
            C12802d dVar = this.f39269o;
            C12801a aVar = C12801a.ADAPTER_CALLBACK;
            StringBuilder sb = new StringBuilder();
            sb.append(smash.mo41398o());
            sb.append(":onInterstitialInitFailed(");
            sb.append(error);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            String errorReason = error.mo41429b().substring(0, Math.min(error.mo41429b().length(), 39));
            m42168a(2206, (C12791c) smash, new Object[][]{new Object[]{"reason", errorReason}});
            if (this.f39276v) {
                String instanceId = smash.mo41406w();
                if (this.f39870H.contains(instanceId)) {
                    this.f39870H.remove(instanceId);
                    this.f39867E.mo41749a(instanceId, C12913g.m41919a("no ads to show"));
                    m42170a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(510)}});
                    m42168a(2200, (C12791c) smash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}, new Object[]{"reason", errorReason}});
                }
            } else {
                if (m42166a(C12792a.INIT_FAILED) >= this.f39263i.size()) {
                    C12802d dVar2 = this.f39269o;
                    C12801a aVar2 = C12801a.NATIVE;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Smart Loading - initialization failed - no adapters are initiated and no more left to init, error: ");
                    sb2.append(error.mo41429b());
                    dVar2.mo41427b(aVar2, sb2.toString(), 2);
                    if (this.f39863A) {
                        this.f39867E.mo41746a(C12913g.m41919a("no ads to show"));
                        m42170a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(510)}});
                        this.f39868F = false;
                    }
                    this.f39865C = true;
                } else {
                    if (m42181k() == null && this.f39863A) {
                        if (m42166a(C12792a.INIT_FAILED, C12792a.NOT_AVAILABLE, C12792a.CAPPED_PER_SESSION, C12792a.CAPPED_PER_DAY, C12792a.EXHAUSTED) >= this.f39263i.size()) {
                            this.f39867E.mo41746a(new C12799b(509, "No ads to show"));
                            m42170a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(509)}});
                            this.f39868F = false;
                        }
                    }
                    m42179i();
                }
            }
        } catch (Exception e) {
            C12802d dVar3 = this.f39269o;
            C12801a aVar3 = C12801a.ADAPTER_CALLBACK;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onInterstitialInitFailed(error:");
            sb3.append(error);
            sb3.append(", ");
            sb3.append("provider:");
            sb3.append(smash.mo41403t());
            sb3.append(")");
            dVar3.mo41426a(aVar3, sb3.toString(), (Throwable) e);
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo41653a(C12740C smash, long elapsedTime) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdReady()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42168a(2003, (C12791c) smash, new Object[][]{new Object[]{VastIconXmlManager.DURATION, Long.valueOf(elapsedTime)}});
        long totalLoadElapsedTime = new Date().getTime() - this.f39871I;
        if (this.f39276v) {
            smash.mo41388a(C12792a.AVAILABLE);
            this.f39876z.onInterstitialAdReady(smash.mo41406w());
            m42170a(2004, new Object[][]{new Object[]{VastIconXmlManager.DURATION, Long.valueOf(totalLoadElapsedTime)}});
        } else {
            smash.mo41388a(C12792a.AVAILABLE);
            this.f39864B = false;
            if (this.f39868F) {
                this.f39868F = false;
                this.f39874x.mo41609a();
                m42170a(2004, new Object[][]{new Object[]{VastIconXmlManager.DURATION, Long.valueOf(totalLoadElapsedTime)}});
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0119, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41655a(p019d.p273h.p276c.p280d.C12799b r11, p019d.p273h.p276c.C12740C r12, long r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            d.h.c.d.d r0 = r10.f39269o     // Catch:{ all -> 0x011a }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.ADAPTER_CALLBACK     // Catch:{ all -> 0x011a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r2.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r3 = r12.mo41398o()     // Catch:{ all -> 0x011a }
            r2.append(r3)     // Catch:{ all -> 0x011a }
            java.lang.String r3 = ":onInterstitialAdLoadFailed("
            r2.append(r3)     // Catch:{ all -> 0x011a }
            r2.append(r11)     // Catch:{ all -> 0x011a }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x011a }
            r3 = 1
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = r11.mo41429b()     // Catch:{ all -> 0x011a }
            java.lang.String r1 = r11.mo41429b()     // Catch:{ all -> 0x011a }
            int r1 = r1.length()     // Catch:{ all -> 0x011a }
            r2 = 39
            int r1 = java.lang.Math.min(r1, r2)     // Catch:{ all -> 0x011a }
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)     // Catch:{ all -> 0x011a }
            r1 = 2200(0x898, float:3.083E-42)
            r4 = 3
            java.lang.Object[][] r4 = new java.lang.Object[r4][]     // Catch:{ all -> 0x011a }
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "errorCode"
            r6[r2] = r7     // Catch:{ all -> 0x011a }
            int r7 = r11.mo41428a()     // Catch:{ all -> 0x011a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x011a }
            r6[r3] = r7     // Catch:{ all -> 0x011a }
            r4[r2] = r6     // Catch:{ all -> 0x011a }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "reason"
            r6[r2] = r7     // Catch:{ all -> 0x011a }
            r6[r3] = r0     // Catch:{ all -> 0x011a }
            r4[r3] = r6     // Catch:{ all -> 0x011a }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "duration"
            r6[r2] = r7     // Catch:{ all -> 0x011a }
            java.lang.Long r7 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x011a }
            r6[r3] = r7     // Catch:{ all -> 0x011a }
            r4[r5] = r6     // Catch:{ all -> 0x011a }
            r10.m42168a(r1, r12, r4)     // Catch:{ all -> 0x011a }
            boolean r1 = r10.f39276v     // Catch:{ all -> 0x011a }
            r4 = 2110(0x83e, float:2.957E-42)
            if (r1 == 0) goto L_0x0098
            d.h.c.p r1 = r10.f39867E     // Catch:{ all -> 0x011a }
            java.lang.String r6 = r12.mo41406w()     // Catch:{ all -> 0x011a }
            r1.mo41749a(r6, r11)     // Catch:{ all -> 0x011a }
            java.lang.Object[][] r1 = new java.lang.Object[r3][]     // Catch:{ all -> 0x011a }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x011a }
            java.lang.String r6 = "errorCode"
            r5[r2] = r6     // Catch:{ all -> 0x011a }
            int r6 = r11.mo41428a()     // Catch:{ all -> 0x011a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x011a }
            r5[r3] = r6     // Catch:{ all -> 0x011a }
            r1[r2] = r5     // Catch:{ all -> 0x011a }
            r10.m42170a(r4, r1)     // Catch:{ all -> 0x011a }
            goto L_0x0118
        L_0x0098:
            d.h.c.c$a r1 = p019d.p273h.p276c.C12791c.C12792a.NOT_AVAILABLE     // Catch:{ all -> 0x011a }
            r12.mo41388a(r1)     // Catch:{ all -> 0x011a }
            d.h.c.c$a[] r1 = new p019d.p273h.p276c.C12791c.C12792a[r5]     // Catch:{ all -> 0x011a }
            d.h.c.c$a r6 = p019d.p273h.p276c.C12791c.C12792a.AVAILABLE     // Catch:{ all -> 0x011a }
            r1[r2] = r6     // Catch:{ all -> 0x011a }
            d.h.c.c$a r6 = p019d.p273h.p276c.C12791c.C12792a.LOAD_PENDING     // Catch:{ all -> 0x011a }
            r1[r3] = r6     // Catch:{ all -> 0x011a }
            int r1 = r10.m42166a(r1)     // Catch:{ all -> 0x011a }
            int r6 = r10.f39262h     // Catch:{ all -> 0x011a }
            if (r1 < r6) goto L_0x00b1
            monitor-exit(r10)
            return
        L_0x00b1:
            java.util.concurrent.CopyOnWriteArrayList<d.h.c.c> r6 = r10.f39263i     // Catch:{ all -> 0x011a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x011a }
        L_0x00b7:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x011a }
            if (r7 == 0) goto L_0x00d9
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x011a }
            d.h.c.c r7 = (p019d.p273h.p276c.C12791c) r7     // Catch:{ all -> 0x011a }
            d.h.c.c$a r8 = r7.mo41402s()     // Catch:{ all -> 0x011a }
            d.h.c.c$a r9 = p019d.p273h.p276c.C12791c.C12792a.INITIATED     // Catch:{ all -> 0x011a }
            if (r8 != r9) goto L_0x00d8
            d.h.c.c$a r2 = p019d.p273h.p276c.C12791c.C12792a.LOAD_PENDING     // Catch:{ all -> 0x011a }
            r7.mo41388a(r2)     // Catch:{ all -> 0x011a }
            r2 = r7
            d.h.c.C r2 = (p019d.p273h.p276c.C12740C) r2     // Catch:{ all -> 0x011a }
            r10.m42177h(r2)     // Catch:{ all -> 0x011a }
            monitor-exit(r10)
            return
        L_0x00d8:
            goto L_0x00b7
        L_0x00d9:
            d.h.c.b r6 = r10.m42181k()     // Catch:{ all -> 0x011a }
            if (r6 == 0) goto L_0x00e1
            monitor-exit(r10)
            return
        L_0x00e1:
            boolean r6 = r10.f39863A     // Catch:{ all -> 0x011a }
            if (r6 == 0) goto L_0x0118
            d.h.c.c$a[] r6 = new p019d.p273h.p276c.C12791c.C12792a[r3]     // Catch:{ all -> 0x011a }
            d.h.c.c$a r7 = p019d.p273h.p276c.C12791c.C12792a.INIT_PENDING     // Catch:{ all -> 0x011a }
            r6[r2] = r7     // Catch:{ all -> 0x011a }
            int r6 = r10.m42166a(r6)     // Catch:{ all -> 0x011a }
            int r6 = r6 + r1
            if (r6 != 0) goto L_0x0118
            r10.m42179i()     // Catch:{ all -> 0x011a }
            r10.f39864B = r2     // Catch:{ all -> 0x011a }
            d.h.c.p r6 = r10.f39867E     // Catch:{ all -> 0x011a }
            d.h.c.d.b r7 = new d.h.c.d.b     // Catch:{ all -> 0x011a }
            java.lang.String r8 = "No ads to show"
            r9 = 509(0x1fd, float:7.13E-43)
            r7.<init>(r9, r8)     // Catch:{ all -> 0x011a }
            r6.mo41746a(r7)     // Catch:{ all -> 0x011a }
            java.lang.Object[][] r6 = new java.lang.Object[r3][]     // Catch:{ all -> 0x011a }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x011a }
            java.lang.String r7 = "errorCode"
            r5[r2] = r7     // Catch:{ all -> 0x011a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x011a }
            r5[r3] = r7     // Catch:{ all -> 0x011a }
            r6[r2] = r5     // Catch:{ all -> 0x011a }
            r10.m42170a(r4, r6)     // Catch:{ all -> 0x011a }
        L_0x0118:
            monitor-exit(r10)
            return
        L_0x011a:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x011e
        L_0x011d:
            throw r11
        L_0x011e:
            goto L_0x011d
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12952z.mo41655a(d.h.c.d.b, d.h.c.C, long):void");
    }

    /* renamed from: g */
    public void mo41661g(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdOpened()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42172b(2005, smash, null);
        if (this.f39276v) {
            this.f39876z.onInterstitialAdOpened(smash.mo41406w());
        } else {
            this.f39874x.mo41622d();
        }
    }

    /* renamed from: f */
    public void mo41660f(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdClosed()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        mo41309f();
        m42172b(2204, smash, null);
        if (this.f39276v) {
            this.f39876z.onInterstitialAdClosed(smash.mo41406w());
        } else {
            this.f39874x.mo41617b();
        }
        this.f39872J = false;
    }

    /* renamed from: b */
    public void mo41656b(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdShowSucceeded()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42172b(2202, smash, null);
        if (this.f39276v) {
            this.f39876z.onInterstitialAdShowSucceeded(smash.mo41406w());
            return;
        }
        boolean hasAvailable = false;
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c asmash = (C12791c) it.next();
            if (asmash.mo41402s() == C12792a.AVAILABLE) {
                hasAvailable = true;
                m42175f(asmash);
            }
        }
        if (!hasAvailable && (smash.mo41402s() == C12792a.CAPPED_PER_SESSION || smash.mo41402s() == C12792a.EXHAUSTED || smash.mo41402s() == C12792a.CAPPED_PER_DAY)) {
            m42179i();
        }
        m42176h();
        this.f39874x.mo41623e();
    }

    /* renamed from: a */
    public void mo41654a(C12799b error, C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdShowFailed(");
        sb.append(error);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42172b(2203, smash, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}});
        if (this.f39276v) {
            this.f39876z.onInterstitialAdShowFailed(smash.mo41406w(), error);
        } else {
            m42175f((C12791c) smash);
            Iterator it = this.f39263i.iterator();
            while (it.hasNext()) {
                if (((C12791c) it.next()).mo41402s() == C12792a.AVAILABLE) {
                    this.f39863A = true;
                    mo41786d(this.f39866D.mo41496c());
                    return;
                }
            }
            this.f39874x.mo41618b(error);
        }
        this.f39872J = false;
    }

    /* renamed from: c */
    public void mo41658c(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdClicked()");
        dVar.mo41427b(aVar, sb.toString(), 1);
        m42172b(2006, smash, null);
        if (this.f39276v) {
            this.f39876z.onInterstitialAdClicked(smash.mo41406w());
        } else {
            this.f39874x.mo41620c();
        }
    }

    /* renamed from: e */
    public void mo41659e(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append(smash.mo41398o());
        sb.append(":onInterstitialAdVisible()");
        dVar.mo41427b(aVar, sb.toString(), 1);
    }

    /* renamed from: d */
    public void mo41644d(C12740C smash) {
        m42168a(290, (C12791c) smash, (Object[][]) null);
        C12869ea eaVar = this.f39875y;
        if (eaVar != null) {
            eaVar.mo41183j();
        }
    }

    /* renamed from: a */
    public void mo41214a(List<C12742a> list, boolean revived) {
    }

    /* renamed from: a */
    public void mo41212a(String reason) {
        String str = "Interstitial";
        String str2 = "init() had failed";
        if (this.f39276v) {
            Iterator it = this.f39870H.iterator();
            while (it.hasNext()) {
                this.f39867E.mo41749a((String) it.next(), C12913g.m41923b(str2, str));
            }
            this.f39870H.clear();
        } else if (this.f39863A) {
            this.f39867E.mo41746a(C12913g.m41923b(str2, str));
            this.f39863A = false;
            this.f39864B = false;
        }
    }

    /* renamed from: a */
    public void mo41204a() {
        String str = "Interstitial";
        String str2 = "init() had failed";
        if (this.f39276v) {
            Iterator it = this.f39870H.iterator();
            while (it.hasNext()) {
                this.f39867E.mo41749a((String) it.next(), C12913g.m41923b(str2, str));
            }
            this.f39870H.clear();
        } else if (this.f39863A) {
            C12799b error = C12913g.m41923b(str2, str);
            this.f39867E.mo41746a(error);
            this.f39863A = false;
            this.f39864B = false;
            if (this.f39868F) {
                m42170a(2110, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}});
                this.f39868F = false;
            }
        }
    }

    /* renamed from: j */
    private boolean m42180j() {
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41402s() == C12792a.NOT_INITIATED || smash.mo41402s() == C12792a.INIT_PENDING || smash.mo41402s() == C12792a.INITIATED || smash.mo41402s() == C12792a.LOAD_PENDING) {
                return false;
            }
            if (smash.mo41402s() == C12792a.AVAILABLE) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    private void m42179i() {
        if (m42180j()) {
            this.f39269o.mo41427b(C12801a.INTERNAL, "Reset Iteration", 0);
            Iterator it = this.f39263i.iterator();
            while (it.hasNext()) {
                C12791c smash = (C12791c) it.next();
                if (smash.mo41402s() == C12792a.EXHAUSTED) {
                    smash.mo41184k();
                }
            }
            this.f39269o.mo41427b(C12801a.INTERNAL, "End of Reset Iteration", 0);
        }
    }

    /* renamed from: f */
    private void m42175f(C12791c smash) {
        if (!smash.mo41381A()) {
            m42181k();
            m42179i();
            return;
        }
        smash.mo41388a(C12792a.INITIATED);
    }

    /* renamed from: k */
    private C12775b m42181k() {
        C12775b initiatedAdapter = null;
        int activeAdapters = 0;
        for (int i = 0; i < this.f39263i.size() && initiatedAdapter == null; i++) {
            if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.AVAILABLE || ((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.INITIATED || ((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.INIT_PENDING || ((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.LOAD_PENDING) {
                activeAdapters++;
                if (activeAdapters >= this.f39262h) {
                    break;
                }
            } else if (((C12791c) this.f39263i.get(i)).mo41402s() == C12792a.NOT_INITIATED) {
                initiatedAdapter = m42178i((C12740C) this.f39263i.get(i));
                if (initiatedAdapter == null) {
                    ((C12791c) this.f39263i.get(i)).mo41388a(C12792a.INIT_FAILED);
                }
            }
        }
        return initiatedAdapter;
    }

    /* renamed from: i */
    private synchronized C12775b m42178i(C12740C smash) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39873w);
        sb.append(":startAdapter(");
        sb.append(smash.mo41403t());
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        try {
            C12775b providerAdapter = mo41300b((C12791c) smash);
            if (providerAdapter == null) {
                return null;
            }
            C12747I.m41186g().mo41222c(providerAdapter);
            providerAdapter.setLogListener(this.f39269o);
            smash.mo41387a(providerAdapter);
            smash.mo41388a(C12792a.INIT_PENDING);
            if (this.f39875y != null) {
                smash.mo41174a((C12871fa) this);
            }
            mo41306d(smash);
            smash.mo41172a(this.f39266l, this.f39268n, this.f39267m);
            return providerAdapter;
        } catch (Throwable e) {
            C12802d dVar2 = this.f39269o;
            C12801a aVar2 = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f39873w);
            sb2.append(":startAdapter(");
            sb2.append(smash.mo41403t());
            sb2.append(")");
            dVar2.mo41426a(aVar2, sb2.toString(), e);
            smash.mo41388a(C12792a.INIT_FAILED);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(smash.mo41403t());
            sb3.append(" initialization failed - please verify that required dependencies are in you build path.");
            this.f39269o.mo41427b(C12801a.API, C12913g.m41923b(sb3.toString(), "Interstitial").toString(), 2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41779a(C12817i currentPlacement) {
        this.f39866D = currentPlacement;
        if (!this.f39276v) {
            this.f39874x.mo41611a(currentPlacement);
        }
    }

    /* renamed from: h */
    private synchronized void m42177h(C12740C smash) {
        if (this.f39276v) {
            m42170a(2001, (Object[][]) null);
        }
        m42168a(2002, (C12791c) smash, (Object[][]) null);
        smash.mo41167F();
    }

    /* renamed from: e */
    private synchronized void m42174e(String instanceId) {
        C12791c smash;
        Iterator it = this.f39263i.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            smash = (C12791c) it.next();
            if (!smash.mo41406w().equals(instanceId) || !(smash.mo41402s() == C12792a.AVAILABLE || smash.mo41402s() == C12792a.LOAD_PENDING || smash.mo41402s() == C12792a.NOT_AVAILABLE)) {
            }
        }
        smash.mo41388a(C12792a.INITIATED);
    }

    /* renamed from: h */
    private synchronized void m42176h() {
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash.mo41402s() == C12792a.AVAILABLE || smash.mo41402s() == C12792a.LOAD_PENDING || smash.mo41402s() == C12792a.NOT_AVAILABLE) {
                smash.mo41388a(C12792a.INITIATED);
            }
        }
    }

    /* renamed from: a */
    private void m42170a(int eventId, Object[][] keyVals) {
        m42171a(eventId, keyVals, false);
    }

    /* renamed from: b */
    private void m42173b(int eventId, Object[][] keyVals) {
        m42171a(eventId, keyVals, true);
    }

    /* renamed from: a */
    private void m42171a(int eventId, Object[][] keyVals, boolean isAddPlacement) {
        JSONObject data = C12916j.m41965a(this.f39276v);
        try {
            if (!this.f39276v && isAddPlacement && this.f39866D != null && !TextUtils.isEmpty(this.f39866D.mo41496c())) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39866D.mo41496c());
            }
            if (keyVals != null) {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            }
        } catch (Exception e) {
            C12802d dVar = this.f39269o;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("InterstitialManager logMediationEvent ");
            sb.append(Log.getStackTraceString(e));
            dVar.mo41427b(aVar, sb.toString(), 3);
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: a */
    private void m42167a(int eventId, C12791c smash) {
        m42168a(eventId, smash, (Object[][]) null);
    }

    /* renamed from: a */
    private void m42168a(int eventId, C12791c smash, Object[][] keyVals) {
        m42169a(eventId, smash, keyVals, false);
    }

    /* renamed from: b */
    private void m42172b(int eventId, C12791c smash, Object[][] keyVals) {
        m42169a(eventId, smash, keyVals, true);
    }

    /* renamed from: a */
    private void m42169a(int eventId, C12791c smash, Object[][] keyVals, boolean isAddPlacement) {
        JSONObject data = C12916j.m41962a(smash, this.f39276v);
        try {
            if (!this.f39276v && isAddPlacement && this.f39866D != null && !TextUtils.isEmpty(this.f39866D.mo41496c())) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39866D.mo41496c());
            }
            if (keyVals != null) {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            }
        } catch (Exception e) {
            C12802d dVar = this.f39269o;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("InterstitialManager logProviderEvent ");
            sb.append(Log.getStackTraceString(e));
            dVar.mo41427b(aVar, sb.toString(), 3);
        }
        C12784h.m41502g().mo41369d(new C12733b(eventId, data));
    }

    /* renamed from: a */
    private int m42166a(C12792a... states) {
        int ret;
        synchronized (this.f39263i) {
            ret = 0;
            Iterator it = this.f39263i.iterator();
            while (it.hasNext()) {
                C12791c smash = (C12791c) it.next();
                for (C12792a state : states) {
                    if (smash.mo41402s() == state) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    /* renamed from: b */
    public void mo41684b() {
        CopyOnWriteArrayList<C12791c> copyOnWriteArrayList = this.f39263i;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                C12791c smash = (C12791c) it.next();
                if (smash.mo41402s() == C12792a.CAPPED_PER_DAY) {
                    m42168a(250, smash, new Object[][]{new Object[]{"status", AdultContentAnalytics.UNLOCK}});
                    if (smash.mo41408y()) {
                        smash.mo41388a(C12792a.CAPPED_PER_SESSION);
                    } else if (smash.mo41409z()) {
                        smash.mo41388a(C12792a.EXHAUSTED);
                    } else {
                        smash.mo41388a(C12792a.INITIATED);
                    }
                }
            }
        }
    }
}
