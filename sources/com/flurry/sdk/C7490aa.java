package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.aa */
public class C7490aa {

    /* renamed from: a */
    public static final String f14738a = C7490aa.class.getSimpleName();

    /* renamed from: b */
    public static int f14739b;

    /* renamed from: c */
    public static int f14740c;

    /* renamed from: d */
    public static AtomicInteger f14741d;

    /* renamed from: e */
    static C7443Qb<List<C7505da>> f14742e;

    /* renamed from: f */
    private static C7490aa f14743f;

    /* renamed from: g */
    private static Map<Integer, C7505da> f14744g;

    /* renamed from: h */
    private final AtomicInteger f14745h;

    /* renamed from: i */
    private long f14746i;

    /* renamed from: j */
    private C7452Sb<C7553lb> f14747j = new C7460U(this);

    @SuppressLint({"UseSparseArrays"})
    private C7490aa() {
        f14744g = new ConcurrentHashMap();
        this.f14745h = new AtomicInteger(0);
        f14741d = new AtomicInteger(0);
        if (f14740c == 0) {
            f14740c = 600000;
        }
        if (f14739b == 0) {
            f14739b = 15;
        }
        this.f14746i = C7379Fb.m16300a().f14432d.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0);
        if (f14742e == null) {
            m16583f();
        }
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.NetworkStateEvent", this.f14747j);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m16583f() {
        String str = ".yflurryanongoingpulsecallbackreporter";
        f14742e = new C7443Qb<>(C7379Fb.m16300a().f14432d.getFileStreamPath(str), str, 2, new C7465V());
    }

    /* renamed from: a */
    public static void m16574a(int i) {
        f14739b = i;
    }

    /* renamed from: b */
    public static void m16577b(int i) {
        f14740c = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo23929a(com.flurry.sdk.C7505da r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 3
            if (r6 != 0) goto L_0x000d
            java.lang.String r6 = f14738a     // Catch:{ all -> 0x0080 }
            java.lang.String r1 = "Must add valid PulseCallbackAsyncReportInfo"
            com.flurry.sdk.C7513ec.m16639a(r0, r6, r1)     // Catch:{ all -> 0x0080 }
            monitor-exit(r5)
            return
        L_0x000d:
            java.lang.String r1 = f14738a     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = "Adding and sending "
            r2.<init>(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = r6.f14792h     // Catch:{ all -> 0x0080 }
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r3 = " report to PulseCallbackManager."
            r2.append(r3)     // Catch:{ all -> 0x0080 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.C7513ec.m16639a(r0, r1, r2)     // Catch:{ all -> 0x0080 }
            java.util.List r0 = r6.mo23941a()     // Catch:{ all -> 0x0080 }
            int r0 = r0.size()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007e
            long r0 = r5.f14746i     // Catch:{ all -> 0x0080 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x004f
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0080 }
            int r2 = f14740c     // Catch:{ all -> 0x0080 }
            long r2 = (long) r2     // Catch:{ all -> 0x0080 }
            long r0 = r0 + r2
            r5.f14746i = r0     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.Fb r0 = com.flurry.sdk.C7379Fb.m16300a()     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.W r1 = new com.flurry.sdk.W     // Catch:{ all -> 0x0080 }
            r1.<init>(r5)     // Catch:{ all -> 0x0080 }
            r0.mo23817b(r1)     // Catch:{ all -> 0x0080 }
        L_0x004f:
            int r0 = r5.m16585h()     // Catch:{ all -> 0x0080 }
            r6.f14791g = r0     // Catch:{ all -> 0x0080 }
            java.util.Map<java.lang.Integer, com.flurry.sdk.da> r1 = f14744g     // Catch:{ all -> 0x0080 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0080 }
            r1.put(r0, r6)     // Catch:{ all -> 0x0080 }
            java.util.List r6 = r6.mo23941a()     // Catch:{ all -> 0x0080 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0080 }
        L_0x0067:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x007e
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.N r0 = (com.flurry.sdk.C7423N) r0     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.Rd r1 = com.flurry.sdk.C7449Rd.m16479a()     // Catch:{ all -> 0x0080 }
            com.flurry.sdk.K r1 = r1.f14639d     // Catch:{ all -> 0x0080 }
            r1.mo23799b(r0)     // Catch:{ all -> 0x0080 }
            goto L_0x0067
        L_0x007e:
            monitor-exit(r5)
            return
        L_0x0080:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x0084
        L_0x0083:
            throw r6
        L_0x0084:
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7490aa.mo23929a(com.flurry.sdk.da):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m16584g() {
        Editor edit = C7379Fb.m16300a().f14432d.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong("timeToSendNextPulseReport", this.f14746i);
        edit.apply();
    }

    /* renamed from: h */
    private synchronized int m16585h() {
        return this.f14745h.incrementAndGet();
    }

    /* renamed from: b */
    public final synchronized void mo23932b(C7505da daVar) {
        if (daVar == null) {
            C7513ec.m16639a(3, f14738a, "Must add valid PulseCallbackAsyncReportInfo");
            return;
        }
        if (this.f14746i == 0) {
            this.f14746i = System.currentTimeMillis() + ((long) f14740c);
            C7379Fb.m16300a().mo23817b(new C7474X(this));
        }
        int h = m16585h();
        daVar.f14791g = h;
        f14744g.put(Integer.valueOf(h), daVar);
        for (C7423N n : daVar.mo23941a()) {
            Iterator it = n.f14557m.iterator();
            while (it.hasNext()) {
                it.next();
                f14741d.incrementAndGet();
                if (m16587j()) {
                    C7513ec.m16639a(3, f14738a, "Max Callback Attempts threshold reached. Sending callback logging reports");
                    m16589l();
                }
            }
        }
        if (m16588k()) {
            C7513ec.m16639a(3, f14738a, "Time threshold reached. Sending callback logging reports");
            m16589l();
        }
        String str = f14738a;
        StringBuilder sb = new StringBuilder("Restoring ");
        sb.append(daVar.f14792h);
        sb.append(" report to PulseCallbackManager. Number of stored completed callbacks: ");
        sb.append(f14741d.get());
        C7513ec.m16639a(3, str, sb.toString());
    }

    /* renamed from: a */
    public final synchronized void mo23928a(C7440Q q) {
        String str = f14738a;
        StringBuilder sb = new StringBuilder();
        sb.append(q.f14615m.f14558n.f14792h);
        sb.append(" report sent successfully to ");
        sb.append(q.f14615m.f14563s);
        C7513ec.m16639a(3, str, sb.toString());
        q.f14609g = C7450S.COMPLETE;
        q.f14610h = "";
        m16580c(q);
        if (C7513ec.m16647c() <= 3 && C7513ec.m16652d()) {
            C7379Fb.m16300a().mo23815a((Runnable) new C7478Y(this, q));
        }
    }

    /* renamed from: c */
    private void m16580c(C7440Q q) {
        q.f14607e = true;
        q.mo23880a();
        f14741d.incrementAndGet();
        q.f14615m.mo23861b();
        String str = f14738a;
        StringBuilder sb = new StringBuilder();
        sb.append(q.f14615m.f14558n.f14792h);
        sb.append(" report to ");
        sb.append(q.f14615m.f14563s);
        sb.append(" finalized.");
        C7513ec.m16639a(3, str, sb.toString());
        mo23927a();
        m16586i();
    }

    /* renamed from: a */
    public final void mo23927a() {
        C7379Fb.m16300a().mo23817b(new C7482Z(this));
    }

    /* renamed from: i */
    private void m16586i() {
        if (m16587j() || m16588k()) {
            C7513ec.m16639a(3, f14738a, "Threshold reached. Sending callback logging reports");
            m16589l();
        }
    }

    /* renamed from: b */
    public static List<C7505da> m16576b() {
        return new ArrayList(f14744g.values());
    }

    /* renamed from: c */
    public static synchronized C7490aa m16578c() {
        C7490aa aaVar;
        synchronized (C7490aa.class) {
            if (f14743f == null) {
                f14743f = new C7490aa();
            }
            aaVar = f14743f;
        }
        return aaVar;
    }

    /* renamed from: j */
    private static boolean m16587j() {
        return f14741d.intValue() >= f14739b;
    }

    /* renamed from: k */
    private boolean m16588k() {
        return System.currentTimeMillis() > this.f14746i;
    }

    /* renamed from: l */
    private void m16589l() {
        Iterator it = m16576b().iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                C7505da daVar = (C7505da) it.next();
                for (C7423N n : daVar.mo23941a()) {
                    Iterator it2 = n.f14557m.iterator();
                    while (it2.hasNext()) {
                        C7440Q q = (C7440Q) it2.next();
                        if (q.f14613k) {
                            it2.remove();
                        } else if (!q.f14609g.equals(C7450S.PENDING_COMPLETION)) {
                            q.f14613k = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    C7523ga.m16673a().mo23952a(daVar);
                }
            } else {
                C7523ga.m16673a().mo23953b();
                this.f14746i = System.currentTimeMillis() + ((long) f14740c);
                m16584g();
                m16590m();
                f14741d = new AtomicInteger(0);
                mo23927a();
                return;
            }
        }
    }

    /* renamed from: m */
    private void m16590m() {
        for (C7505da daVar : m16576b()) {
            if (daVar.mo23942b()) {
                m16579c(daVar.f14791g);
            } else {
                for (C7423N n : daVar.mo23941a()) {
                    if (n.f14564t) {
                        daVar.f14795k.remove(Long.valueOf(n.f14552h));
                    } else {
                        Iterator it = n.f14557m.iterator();
                        while (it.hasNext()) {
                            if (((C7440Q) it.next()).f14613k) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private synchronized void m16579c(int i) {
        String str = f14738a;
        StringBuilder sb = new StringBuilder("Removing report ");
        sb.append(i);
        sb.append(" from PulseCallbackManager");
        C7513ec.m16639a(3, str, sb.toString());
        f14744g.remove(Integer.valueOf(i));
    }

    /* renamed from: a */
    public final synchronized boolean mo23930a(C7440Q q, String str) {
        q.f14611i++;
        q.f14612j = System.currentTimeMillis();
        if (!(q.f14611i > q.f14615m.f14554j)) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = f14738a;
                StringBuilder sb = new StringBuilder("Report to ");
                sb.append(q.f14615m.f14563s);
                sb.append(" redirecting to url: ");
                sb.append(str);
                C7513ec.m16639a(3, str2, sb.toString());
                q.f14615m.f15063e = str;
                mo23927a();
                return true;
            }
        }
        String str3 = f14738a;
        StringBuilder sb2 = new StringBuilder("Maximum number of redirects attempted. Aborting: ");
        sb2.append(q.f14615m.f14558n.f14792h);
        sb2.append(" report to ");
        sb2.append(q.f14615m.f14563s);
        C7513ec.m16639a(3, str3, sb2.toString());
        q.f14609g = C7450S.INVALID_RESPONSE;
        q.f14610h = "";
        m16580c(q);
        return false;
    }

    /* renamed from: b */
    public final synchronized void mo23931b(C7440Q q) {
        String str = f14738a;
        StringBuilder sb = new StringBuilder("Maximum number of attempts reached. Aborting: ");
        sb.append(q.f14615m.f14558n.f14792h);
        C7513ec.m16639a(3, str, sb.toString());
        q.f14609g = C7450S.TIMEOUT;
        q.f14612j = System.currentTimeMillis();
        q.f14610h = "";
        m16580c(q);
    }

    /* renamed from: b */
    public final synchronized boolean mo23933b(C7440Q q, String str) {
        boolean z;
        q.f14609g = C7450S.INVALID_RESPONSE;
        q.f14612j = System.currentTimeMillis();
        if (str == null) {
            str = "";
        }
        q.f14610h = str;
        C7423N n = q.f14615m;
        z = false;
        if (n.f15061c >= n.f14553i) {
            String str2 = f14738a;
            StringBuilder sb = new StringBuilder("Maximum number of attempts reached. Aborting: ");
            sb.append(q.f14615m.f14558n.f14792h);
            sb.append(" report to ");
            sb.append(q.f14615m.f14563s);
            C7513ec.m16639a(3, str2, sb.toString());
            m16580c(q);
        } else if (!C7381Fd.m16310a(q.f14615m.f15063e)) {
            String str3 = f14738a;
            StringBuilder sb2 = new StringBuilder("Url: ");
            sb2.append(q.f14615m.f15063e);
            sb2.append(" is invalid.");
            C7513ec.m16639a(3, str3, sb2.toString());
            m16580c(q);
        } else {
            String str4 = f14738a;
            StringBuilder sb3 = new StringBuilder("Retrying callback to ");
            sb3.append(q.f14615m.f14558n.f14792h);
            sb3.append(" in: ");
            sb3.append(q.f14615m.f14559o / 1000);
            sb3.append(" seconds.");
            C7513ec.m16639a(3, str4, sb3.toString());
            q.mo23880a();
            f14741d.incrementAndGet();
            mo23927a();
            m16586i();
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    public static List<C7505da> m16581d() {
        if (f14742e == null) {
            m16583f();
        }
        return (List) f14742e.mo23881a();
    }
}
