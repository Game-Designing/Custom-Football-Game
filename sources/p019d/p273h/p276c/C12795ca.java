package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.vungle.warren.p267ui.VungleActivity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12809a;
import p019d.p273h.p276c.p281e.C12820l;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12885ma;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.ca */
/* compiled from: ProgRvSmash */
public class C12795ca extends C12807da implements C12885ma {

    /* renamed from: e */
    private C12796a f39384e = C12796a.NO_INIT;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12774aa f39385f;

    /* renamed from: g */
    private Timer f39386g;

    /* renamed from: h */
    private int f39387h;

    /* renamed from: i */
    private Activity f39388i;

    /* renamed from: j */
    private String f39389j;

    /* renamed from: k */
    private String f39390k;

    /* renamed from: l */
    private String f39391l;

    /* renamed from: m */
    private boolean f39392m;

    /* renamed from: n */
    private boolean f39393n;

    /* renamed from: o */
    private C12820l f39394o;

    /* renamed from: p */
    private long f39395p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f39396q;

    /* renamed from: r */
    private String f39397r;

    /* renamed from: d.h.c.ca$a */
    /* compiled from: ProgRvSmash */
    protected enum C12796a {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public C12795ca(Activity activity, String appKey, String userId, C12826q settings, C12774aa listener, int loadTimeoutSecs, C12775b adapter) {
        super(new C12809a(settings, settings.mo41554k()), adapter);
        this.f39388i = activity;
        this.f39389j = appKey;
        this.f39390k = userId;
        this.f39385f = listener;
        this.f39386g = null;
        this.f39387h = loadTimeoutSecs;
        this.f39422a.addRewardedVideoListener(this);
        this.f39392m = false;
        this.f39393n = false;
        String str = "";
        this.f39391l = str;
        this.f39394o = null;
        this.f39396q = str;
    }

    /* renamed from: s */
    public synchronized boolean mo41423s() {
        return (this.f39384e == C12796a.NO_INIT || this.f39384e == C12796a.INIT_IN_PROGRESS) ? false : true;
    }

    /* renamed from: r */
    public synchronized boolean mo41422r() {
        return this.f39384e == C12796a.INIT_IN_PROGRESS || this.f39384e == C12796a.LOAD_IN_PROGRESS;
    }

    /* renamed from: p */
    public synchronized Map<String, Object> mo41420p() {
        return mo41449o() ? this.f39422a.getRvBiddingData(this.f39425d) : null;
    }

    /* renamed from: q */
    public synchronized void mo41421q() {
        m41584b("initForBidding()");
        m41577a(C12796a.INIT_IN_PROGRESS);
        m41585v();
        this.f39422a.initRvForBidding(this.f39388i, this.f39389j, this.f39390k, this.f39425d, this);
    }

    /* renamed from: u */
    public synchronized void mo41425u() {
        if (mo41449o()) {
            m41577a(C12796a.NOT_LOADED);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r2.f39384e == p019d.p273h.p276c.C12795ca.C12796a.f39402e && r2.f39422a.isRewardedVideoAvailable(r2.f39425d);
     */
    /* renamed from: t */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo41424t() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.mo41449o()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x001c
            d.h.c.ca$a r0 = r2.f39384e     // Catch:{ all -> 0x0026 }
            d.h.c.ca$a r1 = p019d.p273h.p276c.C12795ca.C12796a.LOADED     // Catch:{ all -> 0x0026 }
            if (r0 != r1) goto L_0x0019
            d.h.c.b r0 = r2.f39422a     // Catch:{ all -> 0x0026 }
            org.json.JSONObject r1 = r2.f39425d     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isRewardedVideoAvailable(r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0019
            r0 = 1
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            monitor-exit(r2)
            return r0
        L_0x001c:
            d.h.c.b r0 = r2.f39422a     // Catch:{ all -> 0x0026 }
            org.json.JSONObject r1 = r2.f39425d     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isRewardedVideoAvailable(r1)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return r0
        L_0x0026:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12795ca.mo41424t():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41412a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "loadVideo()"
            r10.m41584b(r0)     // Catch:{ all -> 0x00ba }
            r0 = 0
            r10.mo41443c(r0)     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r0 = r10.f39384e     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r1 = p019d.p273h.p276c.C12795ca.C12796a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x00ba }
            r2 = 1
            if (r0 != r1) goto L_0x001e
            r10.f39393n = r2     // Catch:{ all -> 0x00ba }
            r10.f39397r = r12     // Catch:{ all -> 0x00ba }
            r10.f39391l = r11     // Catch:{ all -> 0x00ba }
            d.h.c.aa r0 = r10.f39385f     // Catch:{ all -> 0x00ba }
            r0.mo41296b(r10, r12)     // Catch:{ all -> 0x00ba }
            monitor-exit(r10)
            return
        L_0x001e:
            d.h.c.ca$a r0 = r10.f39384e     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r1 = p019d.p273h.p276c.C12795ca.C12796a.SHOW_IN_PROGRESS     // Catch:{ all -> 0x00ba }
            if (r0 != r1) goto L_0x002c
            r10.f39392m = r2     // Catch:{ all -> 0x00ba }
            r10.f39397r = r12     // Catch:{ all -> 0x00ba }
            r10.f39391l = r11     // Catch:{ all -> 0x00ba }
            monitor-exit(r10)
            return
        L_0x002c:
            r10.f39396q = r12     // Catch:{ all -> 0x00ba }
            boolean r0 = r10.mo41449o()     // Catch:{ all -> 0x00ba }
            r1 = 1001(0x3e9, float:1.403E-42)
            if (r0 == 0) goto L_0x0055
            d.h.c.ca$a r0 = p019d.p273h.p276c.C12795ca.C12796a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x00ba }
            r10.m41577a(r0)     // Catch:{ all -> 0x00ba }
            r10.m41586w()     // Catch:{ all -> 0x00ba }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00ba }
            r0.<init>()     // Catch:{ all -> 0x00ba }
            long r2 = r0.getTime()     // Catch:{ all -> 0x00ba }
            r10.f39395p = r2     // Catch:{ all -> 0x00ba }
            r10.m41574a(r1)     // Catch:{ all -> 0x00ba }
            d.h.c.b r0 = r10.f39422a     // Catch:{ all -> 0x00ba }
            org.json.JSONObject r1 = r10.f39425d     // Catch:{ all -> 0x00ba }
            r0.loadVideo(r1, r10, r11)     // Catch:{ all -> 0x00ba }
            monitor-exit(r10)
            return
        L_0x0055:
            d.h.c.ca$a r0 = r10.f39384e     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r2 = p019d.p273h.p276c.C12795ca.C12796a.NO_INIT     // Catch:{ all -> 0x00ba }
            if (r0 != r2) goto L_0x0086
            java.lang.String r0 = "loadVideo try to load adapter"
            r10.m41584b(r0)     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r0 = p019d.p273h.p276c.C12795ca.C12796a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x00ba }
            r10.m41577a(r0)     // Catch:{ all -> 0x00ba }
            r10.m41586w()     // Catch:{ all -> 0x00ba }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00ba }
            r0.<init>()     // Catch:{ all -> 0x00ba }
            long r2 = r0.getTime()     // Catch:{ all -> 0x00ba }
            r10.f39395p = r2     // Catch:{ all -> 0x00ba }
            r10.m41574a(r1)     // Catch:{ all -> 0x00ba }
            d.h.c.b r4 = r10.f39422a     // Catch:{ all -> 0x00ba }
            android.app.Activity r5 = r10.f39388i     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r10.f39389j     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = r10.f39390k     // Catch:{ all -> 0x00ba }
            org.json.JSONObject r8 = r10.f39425d     // Catch:{ all -> 0x00ba }
            r9 = r10
            r4.initRewardedVideo(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00ba }
            monitor-exit(r10)
            return
        L_0x0086:
            d.h.c.b r0 = r10.f39422a     // Catch:{ all -> 0x00ba }
            org.json.JSONObject r2 = r10.f39425d     // Catch:{ all -> 0x00ba }
            boolean r0 = r0.isRewardedVideoAvailable(r2)     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = "loadVideo already loaded"
            r10.m41584b(r0)     // Catch:{ all -> 0x00ba }
            d.h.c.ca$a r0 = p019d.p273h.p276c.C12795ca.C12796a.LOADED     // Catch:{ all -> 0x00ba }
            r10.m41577a(r0)     // Catch:{ all -> 0x00ba }
            d.h.c.aa r0 = r10.f39385f     // Catch:{ all -> 0x00ba }
            r0.mo41289a(r10, r12)     // Catch:{ all -> 0x00ba }
            goto L_0x00b8
        L_0x00a0:
            r10.m41586w()     // Catch:{ all -> 0x00ba }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00ba }
            r0.<init>()     // Catch:{ all -> 0x00ba }
            long r2 = r0.getTime()     // Catch:{ all -> 0x00ba }
            r10.f39395p = r2     // Catch:{ all -> 0x00ba }
            r10.m41574a(r1)     // Catch:{ all -> 0x00ba }
            d.h.c.b r0 = r10.f39422a     // Catch:{ all -> 0x00ba }
            org.json.JSONObject r1 = r10.f39425d     // Catch:{ all -> 0x00ba }
            r0.fetchRewardedVideo(r1)     // Catch:{ all -> 0x00ba }
        L_0x00b8:
            monitor-exit(r10)
            return
        L_0x00ba:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12795ca.mo41412a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41577a(C12796a state) {
        StringBuilder sb = new StringBuilder();
        sb.append("current state=");
        sb.append(this.f39384e);
        sb.append(", new state=");
        sb.append(state);
        m41584b(sb.toString());
        this.f39384e = state;
    }

    /* renamed from: v */
    private void m41585v() {
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
                m41584b(sb.toString());
                this.f39422a.setConsent(consent.booleanValue());
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setCustomParams() ");
            sb2.append(e.getMessage());
            m41584b(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41413a(boolean r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.m41587x()     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            r0.<init>()     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = "onRewardedVideoAvailabilityChanged available="
            r0.append(r1)     // Catch:{ all -> 0x0097 }
            r0.append(r9)     // Catch:{ all -> 0x0097 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0097 }
            r8.m41580a(r0)     // Catch:{ all -> 0x0097 }
            d.h.c.ca$a r0 = r8.f39384e     // Catch:{ all -> 0x0097 }
            d.h.c.ca$a r1 = p019d.p273h.p276c.C12795ca.C12796a.LOAD_IN_PROGRESS     // Catch:{ all -> 0x0097 }
            if (r0 == r1) goto L_0x002f
            if (r9 == 0) goto L_0x0023
            r0 = 1207(0x4b7, float:1.691E-42)
            goto L_0x0025
        L_0x0023:
            r0 = 1208(0x4b8, float:1.693E-42)
        L_0x0025:
            r8.m41574a(r0)     // Catch:{ all -> 0x0097 }
            d.h.c.aa r0 = r8.f39385f     // Catch:{ all -> 0x0097 }
            r0.mo41292a(r9, r8)     // Catch:{ all -> 0x0097 }
            monitor-exit(r8)
            return
        L_0x002f:
            if (r9 == 0) goto L_0x0034
            d.h.c.ca$a r0 = p019d.p273h.p276c.C12795ca.C12796a.LOADED     // Catch:{ all -> 0x0097 }
            goto L_0x0036
        L_0x0034:
            d.h.c.ca$a r0 = p019d.p273h.p276c.C12795ca.C12796a.NOT_LOADED     // Catch:{ all -> 0x0097 }
        L_0x0036:
            r8.m41577a(r0)     // Catch:{ all -> 0x0097 }
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x0097 }
            r0.<init>()     // Catch:{ all -> 0x0097 }
            long r0 = r0.getTime()     // Catch:{ all -> 0x0097 }
            long r2 = r8.f39395p     // Catch:{ all -> 0x0097 }
            long r0 = r0 - r2
            r2 = 2
            r3 = 1
            r4 = 0
            if (r9 == 0) goto L_0x0060
            r5 = 1002(0x3ea, float:1.404E-42)
            java.lang.Object[][] r6 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = "duration"
            r2[r4] = r7     // Catch:{ all -> 0x0097 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0097 }
            r2[r3] = r7     // Catch:{ all -> 0x0097 }
            r6[r4] = r2     // Catch:{ all -> 0x0097 }
            r8.m41575a(r5, r6)     // Catch:{ all -> 0x0097 }
            goto L_0x0075
        L_0x0060:
            r5 = 1200(0x4b0, float:1.682E-42)
            java.lang.Object[][] r6 = new java.lang.Object[r3][]     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0097 }
            java.lang.String r7 = "duration"
            r2[r4] = r7     // Catch:{ all -> 0x0097 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x0097 }
            r2[r3] = r7     // Catch:{ all -> 0x0097 }
            r6[r4] = r2     // Catch:{ all -> 0x0097 }
            r8.m41575a(r5, r6)     // Catch:{ all -> 0x0097 }
        L_0x0075:
            boolean r2 = r8.f39393n     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0084
            r8.f39393n = r4     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = r8.f39391l     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r8.f39397r     // Catch:{ all -> 0x0097 }
            r8.mo41412a(r2, r3)     // Catch:{ all -> 0x0097 }
            monitor-exit(r8)
            return
        L_0x0084:
            if (r9 == 0) goto L_0x008e
            d.h.c.aa r2 = r8.f39385f     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r8.f39396q     // Catch:{ all -> 0x0097 }
            r2.mo41289a(r8, r3)     // Catch:{ all -> 0x0097 }
            goto L_0x0095
        L_0x008e:
            d.h.c.aa r2 = r8.f39385f     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r8.f39396q     // Catch:{ all -> 0x0097 }
            r2.mo41296b(r8, r3)     // Catch:{ all -> 0x0097 }
        L_0x0095:
            monitor-exit(r8)
            return
        L_0x0097:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12795ca.mo41413a(boolean):void");
    }

    /* renamed from: c */
    public synchronized void mo41414c(C12799b error) {
        StringBuilder sb = new StringBuilder();
        sb.append("onRewardedVideoAdShowFailed error=");
        sb.append(error.mo41429b());
        m41580a(sb.toString());
        m41577a(C12796a.NOT_LOADED);
        this.f39385f.mo41290a(error, this);
        m41583b(1202, new Object[][]{new Object[]{"errorCode", Integer.valueOf(error.mo41428a())}, new Object[]{"reason", error.mo41429b().substring(0, Math.min(error.mo41429b().length(), 39))}});
    }

    public synchronized void onRewardedVideoAdOpened() {
        m41580a("onRewardedVideoAdOpened");
        this.f39385f.mo41287a(this);
        m41582b(1005);
    }

    /* renamed from: g */
    public synchronized void mo41415g() {
        m41580a("onRewardedVideoAdVisible");
        m41582b(1206);
    }

    public synchronized void onRewardedVideoAdClosed() {
        m41580a("onRewardedVideoAdClosed");
        this.f39385f.mo41294b(this);
        m41582b(1203);
        m41577a(C12796a.NOT_LOADED);
        if (this.f39392m) {
            this.f39392m = false;
            mo41412a(this.f39391l, this.f39397r);
            this.f39391l = "";
            this.f39397r = "";
        }
    }

    /* renamed from: i */
    public synchronized void mo41417i() {
        m41580a("onRewardedVideoAdRewarded");
        this.f39385f.mo41288a(this, this.f39394o);
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{VungleActivity.PLACEMENT_EXTRA, this.f39394o.mo41504c()});
        data.add(new Object[]{"rewardName", this.f39394o.mo41506e()});
        data.add(new Object[]{"rewardAmount", Integer.valueOf(this.f39394o.mo41505d())});
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(new Date().getTime()));
        sb.append(this.f39389j);
        sb.append(mo41444j());
        data.add(new Object[]{"transId", C12916j.m41974b(sb.toString())});
        if (!TextUtils.isEmpty(C12747I.m41186g().mo41227e())) {
            data.add(new Object[]{"dynamicUserId", C12747I.m41186g().mo41227e()});
        }
        if (C12747I.m41186g().mo41238l() != null) {
            for (String key : C12747I.m41186g().mo41238l().keySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("custom_");
                sb2.append(key);
                data.add(new Object[]{sb2.toString(), C12747I.m41186g().mo41238l().get(key)});
            }
        }
        m41575a(1010, (Object[][]) data.toArray((Object[][]) Array.newInstance(Object.class, new int[]{2, data.size()})));
    }

    /* renamed from: h */
    public synchronized void mo41416h() {
        m41580a("onRewardedVideoAdClicked");
        this.f39385f.mo41295b(this, this.f39394o);
        m41582b(1006);
    }

    /* renamed from: x */
    private void m41587x() {
        Timer timer = this.f39386g;
        if (timer != null) {
            timer.cancel();
            this.f39386g = null;
        }
    }

    /* renamed from: w */
    private void m41586w() {
        m41587x();
        this.f39386g = new Timer();
        this.f39386g.schedule(new C12790ba(this), (long) (this.f39387h * 1000));
    }

    /* renamed from: a */
    private void m41580a(String line) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.ADAPTER_CALLBACK, sb.toString(), 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41584b(String line) {
        StringBuilder sb = new StringBuilder();
        sb.append(mo41444j());
        sb.append(" : ");
        sb.append(line);
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, sb.toString(), 0);
    }

    /* renamed from: b */
    private void m41582b(int eventId) {
        m41583b(eventId, null);
    }

    /* renamed from: b */
    private void m41583b(int eventId, Object[][] keyVals) {
        m41576a(eventId, keyVals, true);
    }

    /* renamed from: a */
    private void m41574a(int eventId) {
        m41576a(eventId, null, false);
    }

    /* renamed from: a */
    private void m41575a(int eventId, Object[][] keyVals) {
        m41576a(eventId, keyVals, false);
    }

    /* renamed from: a */
    private void m41576a(int eventId, Object[][] keyVals, boolean isAddPlacement) {
        Map<String, Object> data = new HashMap<>();
        if (!TextUtils.isEmpty(this.f39396q)) {
            data.put("auctionId", this.f39396q);
        }
        if (isAddPlacement) {
            C12820l lVar = this.f39394o;
            if (lVar != null && !TextUtils.isEmpty(lVar.mo41504c())) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39394o.mo41504c());
            }
        }
        if (keyVals != null) {
            try {
                for (Object[] pair : keyVals) {
                    data.put(pair[0].toString(), pair[1]);
                }
            } catch (Exception e) {
                C12802d c = C12802d.m41613c();
                C12801a aVar = C12801a.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("RV sendMediationEvent ");
                sb.append(Log.getStackTraceString(e));
                c.mo41427b(aVar, sb.toString(), 3);
            }
        }
        C12787k.m41517g().mo41369d(new C12733b(eventId, new JSONObject(data)));
    }
}
