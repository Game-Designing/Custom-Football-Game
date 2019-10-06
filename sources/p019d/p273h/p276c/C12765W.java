package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12809a;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12889p;

/* renamed from: d.h.c.W */
/* compiled from: ProgIsSmash */
public class C12765W extends C12807da implements C12889p {
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12766a f39217e = C12766a.NO_INIT;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12763U f39218f;

    /* renamed from: g */
    private Timer f39219g;

    /* renamed from: h */
    private int f39220h;

    /* renamed from: i */
    private Activity f39221i;

    /* renamed from: j */
    private String f39222j;

    /* renamed from: k */
    private String f39223k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f39224l;

    /* renamed from: d.h.c.W$a */
    /* compiled from: ProgIsSmash */
    protected enum C12766a {
        NO_INIT,
        INIT_IN_PROGRESS,
        INIT_SUCCESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED
    }

    public C12765W(Activity activity, String appKey, String userId, C12826q settings, C12763U listener, int loadTimeout, C12775b adapter) {
        super(new C12809a(settings, settings.mo41549f()), adapter);
        this.f39221i = activity;
        this.f39222j = appKey;
        this.f39223k = userId;
        this.f39218f = listener;
        this.f39219g = null;
        this.f39220h = loadTimeout;
        this.f39422a.addInterstitialListener(this);
    }

    /* renamed from: p */
    public synchronized Map<String, Object> mo41279p() {
        return mo41449o() ? this.f39422a.getIsBiddingData(this.f39425d) : null;
    }

    /* renamed from: s */
    public boolean mo41282s() {
        C12766a aVar = this.f39217e;
        return aVar == C12766a.INIT_SUCCESS || aVar == C12766a.LOADED || aVar == C12766a.LOAD_FAILED;
    }

    /* renamed from: r */
    public boolean mo41281r() {
        C12766a aVar = this.f39217e;
        return aVar == C12766a.INIT_IN_PROGRESS || aVar == C12766a.LOAD_IN_PROGRESS;
    }

    /* renamed from: q */
    public synchronized void mo41280q() {
        m41351c("initForBidding()");
        m41345a(C12766a.INIT_IN_PROGRESS);
        m41352u();
        this.f39422a.initInterstitialForBidding(this.f39221i, this.f39222j, this.f39223k, this.f39425d, this);
    }

    /* renamed from: t */
    public synchronized void mo41283t() {
        m41352u();
        this.f39422a.preInitInterstitial(this.f39221i, this.f39222j, this.f39223k, this.f39425d, this);
    }

    /* renamed from: a */
    public synchronized void mo41278a(String serverData) {
        this.f39224l = new Date().getTime();
        m41351c("loadInterstitial");
        mo41443c(false);
        if (mo41449o()) {
            m41353v();
            m41345a(C12766a.LOAD_IN_PROGRESS);
            this.f39422a.loadInterstitial(this.f39425d, this, serverData);
        } else if (this.f39217e == C12766a.NO_INIT) {
            m41353v();
            m41345a(C12766a.INIT_IN_PROGRESS);
            m41352u();
            this.f39422a.initInterstitial(this.f39221i, this.f39222j, this.f39223k, this.f39425d, this);
        } else {
            m41353v();
            m41345a(C12766a.LOAD_IN_PROGRESS);
            this.f39422a.loadInterstitial(this.f39425d, this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41345a(C12766a state) {
        StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(state);
        m41351c(sb.toString());
        this.f39217e = state;
    }

    /* renamed from: u */
    private void m41352u() {
        try {
            Integer age = C12747I.m41186g().mo41217b();
            if (age != null) {
                this.f39422a.setAge(age.intValue());
            }
            String gender = C12747I.m41186g().mo41229f();
            if (!TextUtils.isEmpty(gender)) {
                this.f39422a.setGender(gender);
            }
            String segment = C12747I.m41186g().mo41236j();
            if (!TextUtils.isEmpty(segment)) {
                this.f39422a.setMediationSegment(segment);
            }
            String pluginType = C12772a.m41416a().mo41311c();
            if (!TextUtils.isEmpty(pluginType)) {
                this.f39422a.setPluginData(pluginType, C12772a.m41416a().mo41310b());
            }
            Boolean consent = C12747I.m41186g().mo41221c();
            if (consent != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("setConsent(");
                sb.append(consent);
                sb.append(")");
                m41351c(sb.toString());
                this.f39422a.setConsent(consent.booleanValue());
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setCustomParams() ");
            sb2.append(e.getMessage());
            m41351c(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInterstitialInitSuccess() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r0.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "onInterstitialInitSuccess state="
            r0.append(r1)     // Catch:{ all -> 0x0048 }
            d.h.c.W$a r1 = r2.f39217e     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x0048 }
            r0.append(r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0048 }
            r2.m41349b(r0)     // Catch:{ all -> 0x0048 }
            d.h.c.W$a r0 = r2.f39217e     // Catch:{ all -> 0x0048 }
            d.h.c.W$a r1 = p019d.p273h.p276c.C12765W.C12766a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0048 }
            if (r0 == r1) goto L_0x0023
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            return
        L_0x0023:
            d.h.c.U r0 = r2.f39218f     // Catch:{ all -> 0x0048 }
            r0.mo41265a(r2)     // Catch:{ all -> 0x0048 }
            r2.m41354w()     // Catch:{ all -> 0x0048 }
            boolean r0 = r2.mo41449o()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0037
            d.h.c.W$a r0 = p019d.p273h.p276c.C12765W.C12766a.INIT_SUCCESS     // Catch:{ all -> 0x0048 }
            r2.m41345a(r0)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0037:
            d.h.c.W$a r0 = p019d.p273h.p276c.C12765W.C12766a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x0048 }
            r2.m41345a(r0)     // Catch:{ all -> 0x0048 }
            r2.m41353v()     // Catch:{ all -> 0x0048 }
            d.h.c.b r0 = r2.f39422a     // Catch:{ all -> 0x0048 }
            org.json.JSONObject r1 = r2.f39425d     // Catch:{ all -> 0x0048 }
            r0.loadInterstitial(r1, r2)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12765W.onInterstitialInitSuccess():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0054, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo41180d(p019d.p273h.p276c.p280d.C12799b r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "onInterstitialInitFailed error"
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r5.mo41429b()     // Catch:{ all -> 0x0055 }
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = " state="
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            d.h.c.W$a r1 = r4.f39217e     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r1.name()     // Catch:{ all -> 0x0055 }
            r0.append(r1)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0055 }
            r4.m41349b(r0)     // Catch:{ all -> 0x0055 }
            d.h.c.W$a r0 = r4.f39217e     // Catch:{ all -> 0x0055 }
            d.h.c.W$a r1 = p019d.p273h.p276c.C12765W.C12766a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0055 }
            if (r0 == r1) goto L_0x002f
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            return
        L_0x002f:
            d.h.c.U r0 = r4.f39218f     // Catch:{ all -> 0x0055 }
            r0.mo41272b(r5, r4)     // Catch:{ all -> 0x0055 }
            r4.m41354w()     // Catch:{ all -> 0x0055 }
            d.h.c.W$a r0 = p019d.p273h.p276c.C12765W.C12766a.NO_INIT     // Catch:{ all -> 0x0055 }
            r4.m41345a(r0)     // Catch:{ all -> 0x0055 }
            boolean r0 = r4.mo41449o()     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0053
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            long r0 = r0.getTime()     // Catch:{ all -> 0x0055 }
            long r2 = r4.f39224l     // Catch:{ all -> 0x0055 }
            long r0 = r0 - r2
            d.h.c.U r2 = r4.f39218f     // Catch:{ all -> 0x0055 }
            r2.mo41268a(r5, r4, r0)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            return
        L_0x0055:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12765W.mo41180d(d.h.c.d.b):void");
    }

    /* renamed from: a */
    public void mo41171a() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialAdReady state=");
            sb.append(this.f39217e.name());
            m41349b(sb.toString());
            m41354w();
            if (this.f39217e == C12766a.LOAD_IN_PROGRESS) {
                m41345a(C12766a.LOADED);
                this.f39218f.mo41266a(this, new Date().getTime() - this.f39224l);
            }
        }
    }

    /* renamed from: a */
    public void mo41173a(C12799b error) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialAdLoadFailed error=");
            sb.append(error.mo41429b());
            sb.append(" state=");
            sb.append(this.f39217e.name());
            m41349b(sb.toString());
            m41354w();
            if (this.f39217e == C12766a.LOAD_IN_PROGRESS) {
                m41345a(C12766a.LOAD_FAILED);
                this.f39218f.mo41268a(error, this, new Date().getTime() - this.f39224l);
            }
        }
    }

    /* renamed from: d */
    public void mo41179d() {
        synchronized (this) {
            m41349b("onInterstitialAdOpened");
            this.f39218f.mo41273c(this);
        }
    }

    /* renamed from: b */
    public void mo41176b() {
        synchronized (this) {
            m41349b("onInterstitialAdClosed");
            this.f39218f.mo41274d(this);
        }
    }

    /* renamed from: e */
    public void mo41181e() {
        synchronized (this) {
            m41349b("onInterstitialAdShowSucceeded");
            this.f39218f.mo41276f(this);
        }
    }

    /* renamed from: b */
    public void mo41177b(C12799b error) {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("onInterstitialAdShowFailed error=");
            sb.append(error.mo41429b());
            m41349b(sb.toString());
            this.f39218f.mo41267a(error, this);
        }
    }

    /* renamed from: c */
    public void mo41178c() {
        synchronized (this) {
            m41349b("onInterstitialAdClicked");
            this.f39218f.mo41275e(this);
        }
    }

    /* renamed from: f */
    public void mo41182f() {
        synchronized (this) {
            m41349b("onInterstitialAdVisible");
            this.f39218f.mo41271b(this);
        }
    }

    /* renamed from: w */
    private void m41354w() {
        Timer timer = this.f39219g;
        if (timer != null) {
            timer.cancel();
            this.f39219g = null;
        }
    }

    /* renamed from: v */
    private void m41353v() {
        m41351c("start timer");
        m41354w();
        this.f39219g = new Timer();
        this.f39219g.schedule(new C12764V(this), (long) (this.f39220h * 1000));
    }

    /* renamed from: b */
    private void m41349b(String line) {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgIsSmash ");
        sb.append(mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.ADAPTER_CALLBACK, sb.toString(), 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41351c(String line) {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgIsSmash ");
        sb.append(mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, sb.toString(), 0);
    }
}
