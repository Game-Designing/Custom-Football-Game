package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Timer;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12868e;

/* renamed from: d.h.c.c */
/* compiled from: AbstractSmash */
public abstract class C12791c implements C12868e {

    /* renamed from: a */
    C12792a f39350a;

    /* renamed from: b */
    C12775b f39351b;

    /* renamed from: c */
    C12826q f39352c;

    /* renamed from: d */
    String f39353d;

    /* renamed from: e */
    String f39354e;

    /* renamed from: f */
    boolean f39355f;

    /* renamed from: g */
    boolean f39356g;

    /* renamed from: h */
    String f39357h;

    /* renamed from: i */
    String f39358i;

    /* renamed from: j */
    int f39359j;

    /* renamed from: k */
    int f39360k;

    /* renamed from: l */
    Timer f39361l;

    /* renamed from: m */
    Timer f39362m;

    /* renamed from: n */
    int f39363n = this.f39831v.optInt("maxAdsPerIteration", 99);

    /* renamed from: o */
    int f39364o = this.f39831v.optInt("maxAdsPerSession", 99);

    /* renamed from: p */
    int f39365p = this.f39831v.optInt("maxAdsPerDay", 99);

    /* renamed from: q */
    int f39366q;

    /* renamed from: r */
    C12802d f39367r;

    /* renamed from: s */
    final String f39368s = "maxAdsPerSession";

    /* renamed from: t */
    final String f39369t = "maxAdsPerIteration";

    /* renamed from: u */
    final String f39370u = "maxAdsPerDay";

    /* renamed from: d.h.c.c$a */
    /* compiled from: AbstractSmash */
    public enum C12792a {
        NOT_INITIATED(0),
        INIT_FAILED(1),
        INITIATED(2),
        AVAILABLE(3),
        NOT_AVAILABLE(4),
        EXHAUSTED(5),
        CAPPED_PER_SESSION(6),
        INIT_PENDING(7),
        LOAD_PENDING(8),
        CAPPED_PER_DAY(9);
        

        /* renamed from: l */
        private int f39382l;

        private C12792a(int value) {
            this.f39382l = value;
        }

        /* renamed from: e */
        public int mo41410e() {
            return this.f39382l;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public abstract void mo41184k();

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public abstract String mo41185m();

    C12791c(C12826q adapterConfigs) {
        this.f39353d = adapterConfigs.mo41552i();
        this.f39354e = adapterConfigs.mo41550g();
        this.f39355f = adapterConfigs.mo41556m();
        this.f39352c = adapterConfigs;
        this.f39357h = adapterConfigs.mo41555l();
        this.f39358i = adapterConfigs.mo41532a();
        this.f39360k = 0;
        this.f39359j = 0;
        this.f39350a = C12792a.NOT_INITIATED;
        this.f39367r = C12802d.m41613c();
        this.f39356g = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41387a(C12775b adapter) {
        this.f39351b = adapter;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: z */
    public boolean mo41409z() {
        return this.f39360k >= this.f39363n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: y */
    public boolean mo41408y() {
        return this.f39359j >= this.f39364o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: x */
    public boolean mo41407x() {
        return this.f39350a == C12792a.CAPPED_PER_DAY;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public boolean mo41381A() {
        return !mo41409z() && !mo41408y() && !mo41407x();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: B */
    public void mo41382B() {
        this.f39360k++;
        this.f39359j++;
        if (mo41408y()) {
            mo41388a(C12792a.CAPPED_PER_SESSION);
        } else if (mo41409z()) {
            mo41388a(C12792a.EXHAUSTED);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public void mo41383C() {
        try {
            if (this.f39361l != null) {
                this.f39361l.cancel();
            }
        } catch (Exception e) {
            mo41390a("stopInitTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.f39361l = null;
            throw th;
        }
        this.f39361l = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: D */
    public void mo41384D() {
        try {
            if (this.f39362m != null) {
                this.f39362m.cancel();
            }
        } catch (Exception e) {
            mo41390a("stopLoadTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.f39362m = null;
            throw th;
        }
        this.f39362m = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41394b(String pluginType, String pluginFrameworkVersion) {
        C12775b bVar = this.f39351b;
        if (bVar != null) {
            bVar.setPluginData(pluginType, pluginFrameworkVersion);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public C12792a mo41402s() {
        return this.f39350a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public String mo41404u() {
        return this.f39353d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public String mo41398o() {
        return this.f39354e;
    }

    /* renamed from: t */
    public String mo41403t() {
        if (this.f39355f) {
            return this.f39353d;
        }
        return this.f39354e;
    }

    /* renamed from: w */
    public String mo41406w() {
        return this.f39357h;
    }

    /* renamed from: l */
    public String mo41396l() {
        if (!TextUtils.isEmpty(this.f39358i)) {
            return this.f39358i;
        }
        return mo41403t();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public int mo41401r() {
        return this.f39364o;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public int mo41400q() {
        return this.f39363n;
    }

    /* renamed from: p */
    public int mo41399p() {
        return this.f39365p;
    }

    /* renamed from: n */
    public C12775b mo41397n() {
        return this.f39351b;
    }

    /* renamed from: v */
    public int mo41405v() {
        return this.f39366q;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41388a(p019d.p273h.p276c.C12791c.C12792a r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            d.h.c.c$a r0 = r4.f39350a     // Catch:{ all -> 0x0049 }
            if (r0 != r5) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r4.f39350a = r5     // Catch:{ all -> 0x0049 }
            d.h.c.d.d r0 = r4.f39367r     // Catch:{ all -> 0x0049 }
            d.h.c.d.c$a r1 = p019d.p273h.p276c.p280d.C12800c.C12801a.INTERNAL     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "Smart Loading - "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = r4.mo41398o()     // Catch:{ all -> 0x0049 }
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " state changed to "
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0049 }
            r2.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0049 }
            r3 = 0
            r0.mo41427b(r1, r2, r3)     // Catch:{ all -> 0x0049 }
            d.h.c.b r0 = r4.f39351b     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0047
            d.h.c.c$a r0 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_SESSION     // Catch:{ all -> 0x0049 }
            if (r5 == r0) goto L_0x003e
            d.h.c.c$a r0 = p019d.p273h.p276c.C12791c.C12792a.CAPPED_PER_DAY     // Catch:{ all -> 0x0049 }
            if (r5 != r0) goto L_0x0047
        L_0x003e:
            d.h.c.b r0 = r4.f39351b     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r4.mo41185m()     // Catch:{ all -> 0x0049 }
            r0.setMediationState(r5, r1)     // Catch:{ all -> 0x0049 }
        L_0x0047:
            monitor-exit(r4)
            return
        L_0x0049:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.C12791c.mo41388a(d.h.c.c$a):void");
    }

    /* renamed from: b */
    public void mo41392b(Activity activity) {
        C12775b bVar = this.f39351b;
        if (bVar != null) {
            bVar.onResume(activity);
        }
        this.f39356g = true;
    }

    /* renamed from: a */
    public void mo41386a(Activity activity) {
        C12775b bVar = this.f39351b;
        if (bVar != null) {
            bVar.onPause(activity);
        }
        this.f39356g = false;
    }

    /* renamed from: a */
    public void mo41385a(int age) {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41403t());
            sb.append(":setAge(age:");
            sb.append(age);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.setAge(age);
        }
    }

    /* renamed from: a */
    public void mo41389a(String gender) {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41403t());
            sb.append(":setGender(gender:");
            sb.append(gender);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.setGender(gender);
        }
    }

    /* renamed from: b */
    public void mo41393b(String segment) {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41403t());
            sb.append(":setMediationSegment(segment:");
            sb.append(segment);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.setMediationSegment(segment);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41391b(int providerPriority) {
        this.f39366q = providerPriority;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41395b(boolean consent) {
        if (this.f39351b != null) {
            C12802d dVar = this.f39367r;
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(mo41403t());
            sb.append(" | ");
            sb.append(mo41185m());
            sb.append("| setConsent(consent:");
            sb.append(consent);
            sb.append(")");
            dVar.mo41427b(aVar, sb.toString(), 1);
            this.f39351b.setConsent(consent);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41390a(String methodName, String errorMessage) {
        C12802d dVar = this.f39367r;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(methodName);
        sb.append(" exception: ");
        sb.append(mo41398o());
        sb.append(" | ");
        sb.append(errorMessage);
        dVar.mo41427b(aVar, sb.toString(), 3);
    }
}
