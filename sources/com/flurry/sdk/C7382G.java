package com.flurry.sdk;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.flurry.sdk.C7607ud.C7608a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.G */
public class C7382G implements C7608a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f14442a = C7382G.class.getSimpleName();

    /* renamed from: b */
    private final C7536ic<C7510e> f14443b = new C7536ic<>("proton config request", new C7564na());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C7536ic<C7515f> f14444c = new C7536ic<>("proton config response", new C7569oa());

    /* renamed from: d */
    private final C7598t f14445d = new C7598t();

    /* renamed from: e */
    private final C7426Nb<String, C7533i> f14446e = new C7426Nb<>();

    /* renamed from: f */
    private final List<C7505da> f14447f = new ArrayList();

    /* renamed from: g */
    private C7443Qb<C7592s> f14448g;

    /* renamed from: h */
    private C7443Qb<List<C7505da>> f14449h;

    /* renamed from: i */
    private boolean f14450i;

    /* renamed from: j */
    private String f14451j;

    /* renamed from: k */
    private boolean f14452k = true;

    /* renamed from: l */
    private boolean f14453l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f14454m = 10000;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public long f14455n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f14456o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C7515f f14457p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f14458q;

    /* renamed from: r */
    public final Runnable f14459r = new C7615w(this);

    /* renamed from: s */
    public final C7452Sb<C7524gb> f14460s = new C7350A(this);

    /* renamed from: t */
    public final C7452Sb<C7529hb> f14461t = new C7355B(this);

    /* renamed from: u */
    public final C7452Sb<C7553lb> f14462u = new C7360C(this);

    public C7382G() {
        C7602td a = C7602td.m16825a();
        String str = "ProtonEnabled";
        this.f14450i = ((Boolean) a.mo24023a(str)).booleanValue();
        a.mo24024a(str, (C7608a) this);
        String str2 = f14442a;
        StringBuilder sb = new StringBuilder("initSettings, protonEnabled = ");
        sb.append(this.f14450i);
        C7513ec.m16639a(4, str2, sb.toString());
        String str3 = "ProtonConfigUrl";
        this.f14451j = (String) a.mo24023a(str3);
        a.mo24024a(str3, (C7608a) this);
        String str4 = f14442a;
        StringBuilder sb2 = new StringBuilder("initSettings, protonConfigUrl = ");
        sb2.append(this.f14451j);
        C7513ec.m16639a(4, str4, sb2.toString());
        String str5 = "analyticsEnabled";
        this.f14452k = ((Boolean) a.mo24023a(str5)).booleanValue();
        a.mo24024a(str5, (C7608a) this);
        String str6 = f14442a;
        StringBuilder sb3 = new StringBuilder("initSettings, AnalyticsEnabled = ");
        sb3.append(this.f14452k);
        C7513ec.m16639a(4, str6, sb3.toString());
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.IdProviderFinishedEvent", this.f14460s);
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", this.f14461t);
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.NetworkStateEvent", this.f14462u);
        Context context = C7379Fb.m16300a().f14432d;
        String str7 = ".yflurryprotonconfig.";
        StringBuilder sb4 = new StringBuilder(str7);
        sb4.append(Long.toString(C7354Ad.m16269f(C7379Fb.m16300a().f14436h), 16));
        this.f14448g = new C7443Qb<>(context.getFileStreamPath(sb4.toString()), str7, 1, new C7365D(this));
        String str8 = ".yflurryprotonreport.";
        StringBuilder sb5 = new StringBuilder(str8);
        sb5.append(Long.toString(C7354Ad.m16269f(C7379Fb.m16300a().f14436h), 16));
        this.f14449h = new C7443Qb<>(context.getFileStreamPath(sb5.toString()), str8, 1, new C7372E(this));
        C7379Fb.m16300a().mo23817b(new C7377F(this));
        C7379Fb.m16300a().mo23817b(new C7603u(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo23820a(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1720015653(0xffffffff997aa4db, float:-1.2957989E-23)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 640941243(0x2633fcbb, float:6.2445614E-16)
            if (r0 == r1) goto L_0x0020
            r1 = 1591403975(0x5edae5c7, float:7.886616E18)
            if (r0 == r1) goto L_0x0016
        L_0x0015:
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "ProtonConfigUrl"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "ProtonEnabled"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "analyticsEnabled"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0015
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            r0 = 4
            if (r5 == 0) goto L_0x007d
            if (r5 == r3) goto L_0x0063
            if (r5 == r2) goto L_0x0045
            r5 = 6
            java.lang.String r6 = f14442a
            java.lang.String r0 = "onSettingUpdate internal error!"
            com.flurry.sdk.C7513ec.m16639a(r5, r6, r0)
            return
        L_0x0045:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            r4.f14452k = r5
            java.lang.String r5 = f14442a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, AnalyticsEnabled = "
            r6.<init>(r1)
            boolean r1 = r4.f14452k
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r5, r6)
            return
        L_0x0063:
            java.lang.String r6 = (java.lang.String) r6
            r4.f14451j = r6
            java.lang.String r5 = f14442a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, protonConfigUrl = "
            r6.<init>(r1)
            java.lang.String r1 = r4.f14451j
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r5, r6)
            return
        L_0x007d:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            r4.f14450i = r5
            java.lang.String r5 = f14442a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "onSettingUpdate, protonEnabled = "
            r6.<init>(r1)
            boolean r1 = r4.f14450i
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.flurry.sdk.C7513ec.m16639a(r0, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7382G.mo23820a(java.lang.String, java.lang.Object):void");
    }

    /* renamed from: a */
    public final synchronized void mo23818a() {
        if (this.f14450i) {
            C7354Ad.m16260a();
            C7475Xa.m16549a();
            C7404K.f14518l = C7475Xa.m16551c();
            this.f14458q = false;
            m16329e();
        }
    }

    /* renamed from: b */
    public final synchronized void mo23822b() {
        if (this.f14450i) {
            C7354Ad.m16260a();
            C7475Xa.m16549a();
            m16321b(C7475Xa.m16551c());
            m16336i();
        }
    }

    /* renamed from: a */
    public final synchronized void mo23819a(long j) {
        if (this.f14450i) {
            C7354Ad.m16260a();
            m16321b(j);
            m16323b("flurry.session_end", null);
            C7379Fb.m16300a().mo23817b(new C7609v(this));
        }
    }

    /* renamed from: c */
    public final synchronized void mo23823c() {
        if (this.f14450i) {
            C7354Ad.m16260a();
            m16336i();
        }
    }

    /* renamed from: a */
    public final synchronized void mo23821a(String str, Map<String, String> map) {
        if (this.f14450i) {
            C7354Ad.m16260a();
            m16323b(str, map);
        }
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [byte[], RequestObjectType] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v3, types: [byte[], RequestObjectType]
      assigns: [byte[]]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], byte[], RequestObjectType]
      mth insns count: 109
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16329e() {
        /*
            r15 = this;
            monitor-enter(r15)
            boolean r0 = r15.f14450i     // Catch:{ all -> 0x00fa }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r15)
            return
        L_0x0007:
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ all -> 0x00fa }
            boolean r0 = r15.f14453l     // Catch:{ all -> 0x00fa }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r15)
            return
        L_0x0010:
            com.flurry.sdk.fb r0 = com.flurry.sdk.C7517fb.m16656a()     // Catch:{ all -> 0x00fa }
            boolean r0 = r0.mo23947b()     // Catch:{ all -> 0x00fa }
            if (r0 != 0) goto L_0x001c
            monitor-exit(r15)
            return
        L_0x001c:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.fb r2 = com.flurry.sdk.C7517fb.m16656a()     // Catch:{ all -> 0x00fa }
            boolean r2 = r2.mo23950e()     // Catch:{ all -> 0x00fa }
            r3 = 1
            if (r2 != 0) goto L_0x002d
            r2 = 1
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            com.flurry.sdk.f r4 = r15.f14457p     // Catch:{ all -> 0x00fa }
            r5 = 3
            if (r4 == 0) goto L_0x008b
            boolean r4 = r15.f14456o     // Catch:{ all -> 0x00fa }
            r6 = 0
            if (r4 == r2) goto L_0x0042
            java.lang.String r3 = f14442a     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "Limit ad tracking value has changed, purging"
            com.flurry.sdk.C7513ec.m16639a(r5, r3, r4)     // Catch:{ all -> 0x00fa }
            r15.f14457p = r6     // Catch:{ all -> 0x00fa }
            goto L_0x008b
        L_0x0042:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fa }
            long r9 = r15.f14455n     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.f r4 = r15.f14457p     // Catch:{ all -> 0x00fa }
            long r11 = r4.f14823b     // Catch:{ all -> 0x00fa }
            r13 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r13
            long r9 = r9 + r11
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0069
            java.lang.String r0 = f14442a     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Cached Proton config valid, no need to refresh"
            com.flurry.sdk.C7513ec.m16639a(r5, r0, r1)     // Catch:{ all -> 0x00fa }
            boolean r0 = r15.f14458q     // Catch:{ all -> 0x00fa }
            if (r0 != 0) goto L_0x0067
            r15.f14458q = r3     // Catch:{ all -> 0x00fa }
            java.lang.String r0 = "flurry.session_start"
            r15.m16323b(r0, r6)     // Catch:{ all -> 0x00fa }
        L_0x0067:
            monitor-exit(r15)
            return
        L_0x0069:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fa }
            long r7 = r15.f14455n     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.f r9 = r15.f14457p     // Catch:{ all -> 0x00fa }
            long r9 = r9.f14824c     // Catch:{ all -> 0x00fa }
            java.lang.Long.signum(r9)
            long r9 = r9 * r13
            long r7 = r7 + r9
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x008b
            java.lang.String r3 = f14442a     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "Cached Proton config expired, purging"
            com.flurry.sdk.C7513ec.m16639a(r5, r3, r4)     // Catch:{ all -> 0x00fa }
            r15.f14457p = r6     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.Nb<java.lang.String, com.flurry.sdk.i> r3 = r15.f14446e     // Catch:{ all -> 0x00fa }
            r3.mo23865a()     // Catch:{ all -> 0x00fa }
        L_0x008b:
            com.flurry.sdk.zb r3 = com.flurry.sdk.C7633zb.m16869a()     // Catch:{ all -> 0x00fa }
            r3.mo23938a(r15)     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = f14442a     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "Requesting proton config"
            com.flurry.sdk.C7513ec.m16639a(r5, r3, r4)     // Catch:{ all -> 0x00fa }
            byte[] r3 = r15.m16331f()     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x00a1
            monitor-exit(r15)
            return
        L_0x00a1:
            com.flurry.sdk.lc r4 = new com.flurry.sdk.lc     // Catch:{ all -> 0x00fa }
            r4.<init>()     // Catch:{ all -> 0x00fa }
            java.lang.String r5 = r15.f14451j     // Catch:{ all -> 0x00fa }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00fa }
            if (r5 == 0) goto L_0x00b1
            java.lang.String r5 = "https://proton.flurry.com/sdk/v1/config"
            goto L_0x00b3
        L_0x00b1:
            java.lang.String r5 = r15.f14451j     // Catch:{ all -> 0x00fa }
        L_0x00b3:
            r4.f15002i = r5     // Catch:{ all -> 0x00fa }
            r5 = 5000(0x1388, float:7.006E-42)
            r4.f14426d = r5     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.pc$a r5 = com.flurry.sdk.C7577pc.C7578a.kPost     // Catch:{ all -> 0x00fa }
            r4.f15003j = r5     // Catch:{ all -> 0x00fa }
            java.lang.String r5 = "application/x-flurry;version=2"
            java.lang.String r6 = "application/x-flurry;version=2"
            int r7 = com.flurry.sdk.C7536ic.m16698a(r3)     // Catch:{ all -> 0x00fa }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00fa }
            java.lang.String r8 = "Content-Type"
            r4.mo23988a(r8, r5)     // Catch:{ all -> 0x00fa }
            java.lang.String r5 = "Accept"
            r4.mo23988a(r5, r6)     // Catch:{ all -> 0x00fa }
            java.lang.String r5 = "FM-Checksum"
            r4.mo23988a(r5, r7)     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.Vc r5 = new com.flurry.sdk.Vc     // Catch:{ all -> 0x00fa }
            r5.<init>()     // Catch:{ all -> 0x00fa }
            r4.f14937F = r5     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.Vc r5 = new com.flurry.sdk.Vc     // Catch:{ all -> 0x00fa }
            r5.<init>()     // Catch:{ all -> 0x00fa }
            r4.f14938G = r5     // Catch:{ all -> 0x00fa }
            r4.f14935D = r3     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.y r3 = new com.flurry.sdk.y     // Catch:{ all -> 0x00fa }
            r3.<init>(r15, r0, r2)     // Catch:{ all -> 0x00fa }
            r4.f14934C = r3     // Catch:{ all -> 0x00fa }
            com.flurry.sdk.zb r0 = com.flurry.sdk.C7633zb.m16869a()     // Catch:{ all -> 0x00fa }
            r0.mo23939a(r15, r4)     // Catch:{ all -> 0x00fa }
            monitor-exit(r15)
            return
        L_0x00fa:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7382G.m16329e():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0224, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d5  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16323b(java.lang.String r34, java.util.Map<java.lang.String, java.lang.String> r35) {
        /*
            r33 = this;
            r1 = r33
            r0 = r34
            r2 = r35
            monitor-enter(r33)
            java.lang.String r3 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r4 = "Event triggered: "
            java.lang.String r5 = java.lang.String.valueOf(r34)     // Catch:{ all -> 0x0225 }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0225 }
            r11 = 3
            com.flurry.sdk.C7513ec.m16639a(r11, r3, r4)     // Catch:{ all -> 0x0225 }
            boolean r3 = r1.f14452k     // Catch:{ all -> 0x0225 }
            if (r3 != 0) goto L_0x0024
            java.lang.String r0 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r2 = "Analytics and pulse have been disabled."
            com.flurry.sdk.C7513ec.m16651d(r0, r2)     // Catch:{ all -> 0x0225 }
            monitor-exit(r33)
            return
        L_0x0024:
            com.flurry.sdk.f r3 = r1.f14457p     // Catch:{ all -> 0x0225 }
            if (r3 != 0) goto L_0x0031
            java.lang.String r0 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r2 = "Config response is empty. No events to fire."
            com.flurry.sdk.C7513ec.m16639a(r11, r0, r2)     // Catch:{ all -> 0x0225 }
            monitor-exit(r33)
            return
        L_0x0031:
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ all -> 0x0225 }
            boolean r3 = android.text.TextUtils.isEmpty(r34)     // Catch:{ all -> 0x0225 }
            if (r3 == 0) goto L_0x003c
            monitor-exit(r33)
            return
        L_0x003c:
            com.flurry.sdk.Nb<java.lang.String, com.flurry.sdk.i> r3 = r1.f14446e     // Catch:{ all -> 0x0225 }
            java.util.List r3 = r3.mo23863a(r0)     // Catch:{ all -> 0x0225 }
            if (r3 != 0) goto L_0x004d
            java.lang.String r0 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r2 = "No events to fire. Returning."
            com.flurry.sdk.C7513ec.m16639a(r11, r0, r2)     // Catch:{ all -> 0x0225 }
            monitor-exit(r33)
            return
        L_0x004d:
            int r4 = r3.size()     // Catch:{ all -> 0x0225 }
            if (r4 != 0) goto L_0x005c
            java.lang.String r0 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r2 = "No events to fire. Returning."
            com.flurry.sdk.C7513ec.m16639a(r11, r0, r2)     // Catch:{ all -> 0x0225 }
            monitor-exit(r33)
            return
        L_0x005c:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0225 }
            r7 = 1
            if (r2 == 0) goto L_0x0065
            r8 = 1
            goto L_0x0066
        L_0x0065:
            r8 = 0
        L_0x0066:
            r9 = -1
            int r10 = r34.hashCode()     // Catch:{ all -> 0x0225 }
            r12 = 645204782(0x26750b2e, float:8.50166E-16)
            r13 = 2
            if (r10 == r12) goto L_0x0090
            r12 = 1371447545(0x51bea0f9, float:1.02343057E11)
            if (r10 == r12) goto L_0x0086
            r12 = 1579613685(0x5e26fdf5, float:3.00826079E18)
            if (r10 == r12) goto L_0x007c
        L_0x007b:
            goto L_0x0099
        L_0x007c:
            java.lang.String r10 = "flurry.session_start"
            boolean r10 = r0.equals(r10)     // Catch:{ all -> 0x0225 }
            if (r10 == 0) goto L_0x007b
            r9 = 0
            goto L_0x0099
        L_0x0086:
            java.lang.String r10 = "flurry.app_install"
            boolean r10 = r0.equals(r10)     // Catch:{ all -> 0x0225 }
            if (r10 == 0) goto L_0x007b
            r9 = 2
            goto L_0x0099
        L_0x0090:
            java.lang.String r10 = "flurry.session_end"
            boolean r10 = r0.equals(r10)     // Catch:{ all -> 0x0225 }
            if (r10 == 0) goto L_0x007b
            r9 = 1
        L_0x0099:
            if (r9 == 0) goto L_0x00a8
            if (r9 == r7) goto L_0x00a5
            if (r9 == r13) goto L_0x00a2
            com.flurry.sdk.la r9 = com.flurry.sdk.C7552la.APPLICATION_EVENT     // Catch:{ all -> 0x0225 }
            goto L_0x00ab
        L_0x00a2:
            com.flurry.sdk.la r9 = com.flurry.sdk.C7552la.INSTALL     // Catch:{ all -> 0x0225 }
            goto L_0x00ab
        L_0x00a5:
            com.flurry.sdk.la r9 = com.flurry.sdk.C7552la.SESSION_END     // Catch:{ all -> 0x0225 }
            goto L_0x00ab
        L_0x00a8:
            com.flurry.sdk.la r9 = com.flurry.sdk.C7552la.SESSION_START     // Catch:{ all -> 0x0225 }
        L_0x00ab:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x0225 }
            r10.<init>()     // Catch:{ all -> 0x0225 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0225 }
        L_0x00b4:
            boolean r12 = r3.hasNext()     // Catch:{ all -> 0x0225 }
            if (r12 == 0) goto L_0x01cf
            java.lang.Object r12 = r3.next()     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.i r12 = (com.flurry.sdk.C7533i) r12     // Catch:{ all -> 0x0225 }
            boolean r13 = r12 instanceof com.flurry.sdk.C7539j     // Catch:{ all -> 0x0225 }
            if (r13 == 0) goto L_0x0131
            java.lang.String r13 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r14 = "Event contains triggers."
            r15 = 4
            com.flurry.sdk.C7513ec.m16639a(r15, r13, r14)     // Catch:{ all -> 0x0225 }
            r13 = r12
            com.flurry.sdk.j r13 = (com.flurry.sdk.C7539j) r13     // Catch:{ all -> 0x0225 }
            java.lang.String[] r13 = r13.f14894d     // Catch:{ all -> 0x0225 }
            if (r13 != 0) goto L_0x00dd
            java.lang.String r14 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r6 = "Template does not contain trigger values. Firing."
            com.flurry.sdk.C7513ec.m16639a(r15, r14, r6)     // Catch:{ all -> 0x0225 }
            r6 = 1
            goto L_0x00f4
        L_0x00dd:
            int r6 = r13.length     // Catch:{ all -> 0x0225 }
            if (r6 != 0) goto L_0x00e9
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r14 = "Template does not contain trigger values. Firing."
            com.flurry.sdk.C7513ec.m16639a(r15, r6, r14)     // Catch:{ all -> 0x0225 }
            r6 = 1
            goto L_0x00f4
        L_0x00e9:
            if (r2 != 0) goto L_0x00f3
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = "Publisher has not passed in params list. Not firing."
            com.flurry.sdk.C7513ec.m16639a(r15, r6, r12)     // Catch:{ all -> 0x0225 }
            goto L_0x00b4
        L_0x00f3:
            r6 = 0
        L_0x00f4:
            r14 = r12
            com.flurry.sdk.j r14 = (com.flurry.sdk.C7539j) r14     // Catch:{ all -> 0x0225 }
            java.lang.String r14 = r14.f14893c     // Catch:{ all -> 0x0225 }
            java.lang.Object r14 = r2.get(r14)     // Catch:{ all -> 0x0225 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x0225 }
            if (r14 != 0) goto L_0x0109
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = "Publisher params has no value associated with proton key. Not firing."
            com.flurry.sdk.C7513ec.m16639a(r15, r6, r12)     // Catch:{ all -> 0x0225 }
            goto L_0x00b4
        L_0x0109:
            int r7 = r13.length     // Catch:{ all -> 0x0225 }
            r11 = 0
        L_0x010b:
            if (r11 >= r7) goto L_0x011c
            r15 = r13[r11]     // Catch:{ all -> 0x0225 }
            boolean r15 = r15.equals(r14)     // Catch:{ all -> 0x0225 }
            if (r15 == 0) goto L_0x0118
            r6 = 1
            goto L_0x011c
        L_0x0118:
            int r11 = r11 + 1
            r15 = 4
            goto L_0x010b
        L_0x011c:
            if (r6 != 0) goto L_0x0129
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r7 = "Publisher params list does not match proton param values. Not firing."
            r11 = 4
            com.flurry.sdk.C7513ec.m16639a(r11, r6, r7)     // Catch:{ all -> 0x0225 }
            r7 = 1
            r11 = 3
            goto L_0x00b4
        L_0x0129:
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r7 = "Publisher params match proton values. Firing."
            r11 = 4
            com.flurry.sdk.C7513ec.m16639a(r11, r6, r7)     // Catch:{ all -> 0x0225 }
        L_0x0131:
            com.flurry.sdk.c r6 = r12.f14876b     // Catch:{ all -> 0x0225 }
            if (r6 != 0) goto L_0x0141
            java.lang.String r6 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r7 = "Template is empty. Not firing current event."
            r11 = 3
            com.flurry.sdk.C7513ec.m16639a(r11, r6, r7)     // Catch:{ all -> 0x0225 }
            r7 = 1
            r11 = 3
            goto L_0x00b4
        L_0x0141:
            java.lang.String r7 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = "Creating callback report for partner: "
            r11.<init>(r12)     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = r6.f14762b     // Catch:{ all -> 0x0225 }
            r11.append(r12)     // Catch:{ all -> 0x0225 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0225 }
            r12 = 3
            com.flurry.sdk.C7513ec.m16639a(r12, r7, r11)     // Catch:{ all -> 0x0225 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0225 }
            r7.<init>()     // Catch:{ all -> 0x0225 }
            java.lang.String r11 = "event_name"
            r7.put(r11, r0)     // Catch:{ all -> 0x0225 }
            java.lang.String r11 = "event_time_millis"
            java.lang.String r12 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0225 }
            r7.put(r11, r12)     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.t r11 = r1.f14445d     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = r6.f14765e     // Catch:{ all -> 0x0225 }
            java.lang.String r20 = r11.mo24019a(r12, r7)     // Catch:{ all -> 0x0225 }
            r11 = 0
            java.lang.String r12 = r6.f14766f     // Catch:{ all -> 0x0225 }
            if (r12 == 0) goto L_0x0182
            com.flurry.sdk.t r11 = r1.f14445d     // Catch:{ all -> 0x0225 }
            java.lang.String r12 = r6.f14766f     // Catch:{ all -> 0x0225 }
            java.lang.String r7 = r11.mo24019a(r12, r7)     // Catch:{ all -> 0x0225 }
            r29 = r7
            goto L_0x0184
        L_0x0182:
            r29 = r11
        L_0x0184:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0225 }
            r13 = 259200000(0xf731400, double:1.280618154E-315)
            long r21 = r11 + r13
            com.flurry.sdk.N r7 = new com.flurry.sdk.N     // Catch:{ all -> 0x0225 }
            java.lang.String r11 = r6.f14762b     // Catch:{ all -> 0x0225 }
            long r12 = r6.f14761a     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.f r14 = r1.f14457p     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.d r14 = r14.f14826e     // Catch:{ all -> 0x0225 }
            int r14 = r14.f14781b     // Catch:{ all -> 0x0225 }
            int r15 = r6.f14767g     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.ka r2 = r6.f14764d     // Catch:{ all -> 0x0225 }
            r30 = r3
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f14770j     // Catch:{ all -> 0x0225 }
            r31 = r4
            int r4 = r6.f14769i     // Catch:{ all -> 0x0225 }
            int r5 = r6.f14768h     // Catch:{ all -> 0x0225 }
            r16 = r7
            r17 = r11
            r18 = r12
            r23 = r14
            r24 = r15
            r25 = r2
            r26 = r3
            r27 = r4
            r28 = r5
            r16.<init>(r17, r18, r20, r21, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0225 }
            long r2 = r6.f14761a     // Catch:{ all -> 0x0225 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0225 }
            r10.put(r2, r7)     // Catch:{ all -> 0x0225 }
            r2 = r35
            r3 = r30
            r4 = r31
            r7 = 1
            r11 = 3
            goto L_0x00b4
        L_0x01cf:
            int r2 = r10.size()     // Catch:{ all -> 0x0225 }
            if (r2 == 0) goto L_0x0223
            com.flurry.sdk.da r11 = new com.flurry.sdk.da     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.C7475Xa.m16549a()     // Catch:{ all -> 0x0225 }
            long r5 = com.flurry.sdk.C7475Xa.m16551c()     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.C7475Xa.m16549a()     // Catch:{ all -> 0x0225 }
            long r12 = com.flurry.sdk.C7475Xa.m16554f()     // Catch:{ all -> 0x0225 }
            r2 = r11
            r3 = r34
            r4 = r8
            r7 = r12
            r2.<init>(r3, r4, r5, r7, r9, r10)     // Catch:{ all -> 0x0225 }
            java.lang.String r2 = "flurry.session_end"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0225 }
            if (r2 == 0) goto L_0x020c
            java.lang.String r2 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r3 = "Storing Pulse callbacks for event: "
            java.lang.String r0 = java.lang.String.valueOf(r34)     // Catch:{ all -> 0x0225 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0225 }
            r3 = 3
            com.flurry.sdk.C7513ec.m16639a(r3, r2, r0)     // Catch:{ all -> 0x0225 }
            java.util.List<com.flurry.sdk.da> r0 = r1.f14447f     // Catch:{ all -> 0x0225 }
            r0.add(r11)     // Catch:{ all -> 0x0225 }
            monitor-exit(r33)
            return
        L_0x020c:
            java.lang.String r2 = f14442a     // Catch:{ all -> 0x0225 }
            java.lang.String r3 = "Firing Pulse callbacks for event: "
            java.lang.String r0 = java.lang.String.valueOf(r34)     // Catch:{ all -> 0x0225 }
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0225 }
            r3 = 3
            com.flurry.sdk.C7513ec.m16639a(r3, r2, r0)     // Catch:{ all -> 0x0225 }
            com.flurry.sdk.aa r0 = com.flurry.sdk.C7490aa.m16578c()     // Catch:{ all -> 0x0225 }
            r0.mo23929a(r11)     // Catch:{ all -> 0x0225 }
        L_0x0223:
            monitor-exit(r33)
            return
        L_0x0225:
            r0 = move-exception
            monitor-exit(r33)
            goto L_0x0229
        L_0x0228:
            throw r0
        L_0x0229:
            goto L_0x0228
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7382G.m16323b(java.lang.String, java.util.Map):void");
    }

    /* renamed from: f */
    private byte[] m16331f() {
        try {
            C7510e eVar = new C7510e();
            eVar.f14801a = C7379Fb.m16300a().f14436h;
            eVar.f14802b = C7619wd.m16849a(C7379Fb.m16300a().f14432d);
            eVar.f14803c = C7619wd.m16850b(C7379Fb.m16300a().f14432d);
            eVar.f14804d = C7384Gb.m16351a();
            eVar.f14805e = 3;
            C7588rb.m16810a();
            eVar.f14806f = C7588rb.m16811b();
            eVar.f14807g = !C7517fb.m16656a().mo23950e();
            eVar.f14808h = new C7527h();
            eVar.f14808h.f14863a = new C7494b();
            eVar.f14808h.f14863a.f14750a = Build.MODEL;
            eVar.f14808h.f14863a.f14751b = Build.BRAND;
            eVar.f14808h.f14863a.f14752c = Build.ID;
            eVar.f14808h.f14863a.f14753d = Build.DEVICE;
            eVar.f14808h.f14863a.f14754e = Build.PRODUCT;
            eVar.f14808h.f14863a.f14755f = VERSION.RELEASE;
            eVar.f14809i = new ArrayList();
            for (Entry entry : Collections.unmodifiableMap(C7517fb.m16656a().f14832d).entrySet()) {
                C7522g gVar = new C7522g();
                gVar.f14849a = ((C7583qb) entry.getKey()).f15034e;
                if (((C7583qb) entry.getKey()).f15035f) {
                    gVar.f14850b = new String((byte[]) entry.getValue());
                } else {
                    gVar.f14850b = C7354Ad.m16259a((byte[]) entry.getValue());
                }
                eVar.f14809i.add(gVar);
            }
            Location f = C7547kb.m16712a().mo23968f();
            if (f != null) {
                int c = C7547kb.m16717c();
                eVar.f14810j = new C7551l();
                eVar.f14810j.f14925a = new C7545k();
                eVar.f14810j.f14925a.f14899a = C7354Ad.m16256a(f.getLatitude(), c);
                eVar.f14810j.f14925a.f14900b = C7354Ad.m16256a(f.getLongitude(), c);
                eVar.f14810j.f14925a.f14901c = (float) C7354Ad.m16256a((double) f.getAccuracy(), c);
            }
            String str = (String) C7602td.m16825a().mo24023a("UserId");
            if (!str.equals("")) {
                eVar.f14811k = new C7568o();
                eVar.f14811k.f14966a = str;
            }
            C7536ic<C7510e> icVar = this.f14443b;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            icVar.f14882d.mo23856a(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str2 = C7536ic.f14879a;
            StringBuilder sb = new StringBuilder("Encoding ");
            sb.append(icVar.f14881c);
            sb.append(": ");
            sb.append(new String(byteArray));
            C7513ec.m16639a(3, str2, sb.toString());
            C7477Xc xc = new C7477Xc(new C7468Vc());
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            xc.mo23856a(byteArrayOutputStream2, byteArray);
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            C7536ic.m16699b(byteArray2);
            return byteArray2;
        } catch (Exception e) {
            C7513ec.m16639a(5, f14442a, "Proton config request failed with exception: ".concat(String.valueOf(e)));
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m16314a(long j, boolean z, byte[] bArr) {
        if (bArr != null) {
            C7513ec.m16639a(4, f14442a, "Saving proton config response");
            C7592s sVar = new C7592s();
            sVar.f15068a = j;
            sVar.f15069b = z;
            sVar.f15070c = bArr;
            this.f14448g.mo23882a(sVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r12.equals(r4) != false) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007c A[EDGE_INSN: B:50:0x007c->B:33:0x007c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0085 A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m16324b(com.flurry.sdk.C7515f r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.flurry.sdk.d r1 = r12.f14826e
            r2 = 3
            r3 = 1
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0088
            java.util.List<com.flurry.sdk.c> r5 = r1.f14780a
            if (r5 == 0) goto L_0x0088
            r5 = 0
        L_0x0011:
            java.util.List<com.flurry.sdk.c> r6 = r1.f14780a
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0088
            java.util.List<com.flurry.sdk.c> r6 = r1.f14780a
            java.lang.Object r6 = r6.get(r5)
            com.flurry.sdk.c r6 = (com.flurry.sdk.C7499c) r6
            if (r6 == 0) goto L_0x0085
            java.lang.String r7 = r6.f14762b
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x007c
            long r7 = r6.f14761a
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x007c
            java.lang.String r7 = r6.f14765e
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x007c
            java.util.List<com.flurry.sdk.i> r6 = r6.f14763c
            if (r6 == 0) goto L_0x0079
            java.util.Iterator r6 = r6.iterator()
        L_0x0044:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0079
            java.lang.Object r7 = r6.next()
            com.flurry.sdk.i r7 = (com.flurry.sdk.C7533i) r7
            java.lang.String r8 = r7.f14875a
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0061
            java.lang.String r6 = f14442a
            java.lang.String r7 = "An event is missing a name"
            com.flurry.sdk.C7513ec.m16639a(r2, r6, r7)
            r6 = 0
            goto L_0x007a
        L_0x0061:
            boolean r8 = r7 instanceof com.flurry.sdk.C7539j
            if (r8 == 0) goto L_0x0078
            com.flurry.sdk.j r7 = (com.flurry.sdk.C7539j) r7
            java.lang.String r7 = r7.f14893c
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0078
            java.lang.String r6 = f14442a
            java.lang.String r7 = "An event trigger is missing a param name"
            com.flurry.sdk.C7513ec.m16639a(r2, r6, r7)
            r6 = 0
            goto L_0x007a
        L_0x0078:
            goto L_0x0044
        L_0x0079:
            r6 = 1
        L_0x007a:
            if (r6 != 0) goto L_0x0085
        L_0x007c:
            java.lang.String r1 = f14442a
            java.lang.String r5 = "A callback template is missing required values"
            com.flurry.sdk.C7513ec.m16639a(r2, r1, r5)
            r1 = 0
            goto L_0x0089
        L_0x0085:
            int r5 = r5 + 1
            goto L_0x0011
        L_0x0088:
            r1 = 1
        L_0x0089:
            if (r1 == 0) goto L_0x009b
            com.flurry.sdk.d r12 = r12.f14826e
            if (r12 == 0) goto L_0x009a
            java.lang.String r12 = r12.f14784e
            if (r12 == 0) goto L_0x009a
            boolean r12 = r12.equals(r4)
            if (r12 == 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            return r3
        L_0x009b:
            java.lang.String r12 = f14442a
            java.lang.String r1 = "Config response is missing required values."
            com.flurry.sdk.C7513ec.m16639a(r2, r12, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7382G.m16324b(com.flurry.sdk.f):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16332g() {
        if (this.f14457p != null) {
            C7513ec.m16639a(5, f14442a, "Processing config response");
            C7490aa.m16574a(this.f14457p.f14826e.f14782c);
            C7490aa.m16577b(this.f14457p.f14826e.f14783d * 1000);
            C7523ga a = C7523ga.m16673a();
            String str = this.f14457p.f14826e.f14784e;
            if (str != null && !str.endsWith(".do")) {
                C7513ec.m16639a(5, C7523ga.f14851a, "overriding analytics agent report URL without an endpoint, are you sure?");
            }
            a.f14853c = str;
            if (this.f14450i) {
                C7602td.m16825a().mo24025a("analyticsEnabled", (Object) Boolean.valueOf(this.f14457p.f14827f.f14982b));
            }
            this.f14446e.mo23865a();
            C7504d dVar = this.f14457p.f14826e;
            if (dVar != null) {
                List<C7499c> list = dVar.f14780a;
                if (list != null) {
                    for (C7499c cVar : list) {
                        if (cVar != null) {
                            List<C7533i> list2 = cVar.f14763c;
                            if (list2 != null) {
                                for (C7533i iVar : list2) {
                                    if (iVar != null && !TextUtils.isEmpty(iVar.f14875a)) {
                                        iVar.f14876b = cVar;
                                        this.f14446e.mo23866a(iVar.f14875a, iVar);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m16334h() {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f14450i     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            com.flurry.sdk.C7354Ad.m16260a()     // Catch:{ all -> 0x0034 }
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ all -> 0x0034 }
            android.content.Context r0 = r0.f14432d     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "FLURRY_SHARED_PREFERENCES"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "com.flurry.android.flurryAppInstall"
            r3 = 1
            boolean r1 = r0.getBoolean(r1, r3)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "flurry.app_install"
            r3 = 0
            r4.m16323b(r1, r3)     // Catch:{ all -> 0x0034 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "com.flurry.android.flurryAppInstall"
            r0.putBoolean(r1, r2)     // Catch:{ all -> 0x0034 }
            r0.apply()     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r4)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7382G.m16334h():void");
    }

    /* renamed from: b */
    private synchronized void m16321b(long j) {
        Iterator it = this.f14447f.iterator();
        while (it.hasNext()) {
            if (j == ((C7505da) it.next()).f14786b) {
                it.remove();
            }
        }
    }

    /* renamed from: i */
    private synchronized void m16336i() {
        if (!this.f14452k) {
            C7513ec.m16651d(f14442a, "Analytics disabled, not sending pulse reports.");
            return;
        }
        String str = f14442a;
        StringBuilder sb = new StringBuilder("Sending ");
        sb.append(this.f14447f.size());
        sb.append(" queued reports.");
        C7513ec.m16639a(4, str, sb.toString());
        for (C7505da daVar : this.f14447f) {
            String str2 = f14442a;
            StringBuilder sb2 = new StringBuilder("Firing Pulse callbacks for event: ");
            sb2.append(daVar.f14792h);
            C7513ec.m16639a(3, str2, sb2.toString());
            C7490aa.m16578c().mo23929a(daVar);
        }
        m16339j();
    }

    /* renamed from: j */
    private synchronized void m16339j() {
        this.f14447f.clear();
        this.f14449h.mo23883b();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public synchronized void m16341k() {
        C7513ec.m16639a(4, f14442a, "Saving queued report data.");
        this.f14449h.mo23882a(this.f14447f);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public synchronized void m16342l() {
        C7515f fVar;
        C7592s sVar = (C7592s) this.f14448g.mo23881a();
        if (sVar != null) {
            C7515f fVar2 = null;
            try {
                fVar = (C7515f) this.f14444c.mo23963c(sVar.f15070c);
            } catch (Exception e) {
                C7513ec.m16639a(5, f14442a, "Failed to decode saved proton config response: ".concat(String.valueOf(e)));
                this.f14448g.mo23883b();
                fVar = null;
            }
            if (m16324b(fVar)) {
                fVar2 = fVar;
            }
            if (fVar2 != null) {
                C7513ec.m16639a(4, f14442a, "Loaded saved proton config response");
                this.f14454m = 10000;
                this.f14455n = sVar.f15068a;
                this.f14456o = sVar.f15069b;
                this.f14457p = fVar2;
                m16332g();
            }
        }
        this.f14453l = true;
        C7379Fb.m16300a().mo23817b(new C7630z(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public synchronized void m16343m() {
        C7513ec.m16639a(4, f14442a, "Loading queued report data.");
        List list = (List) this.f14449h.mo23881a();
        if (list != null) {
            this.f14447f.addAll(list);
        }
    }
}
