package p019d.p143b.p144a.p147c;

import java.util.Iterator;
import java.util.LinkedHashSet;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Qb */
class C7105Qb extends C7184mb {
    C7105Qb(C7142c cVar) {
        super("TaskInitializeSdk", cVar);
    }

    /* renamed from: a */
    private void m14869a(C7204rb<String> rbVar, C7063Fc fc) {
        String str = (String) this.f13625b.mo23039a(rbVar);
        if (str.length() > 0) {
            for (String a : C7178l.m15309a(str)) {
                C7257g a2 = C7257g.m15776a(a);
                if (a2 != null) {
                    this.f13625b.mo23063h().mo22963g(C7059Ec.m14670a(a2, C7258h.f14102a, fc, this.f13625b));
                    if (C7257g.f14096c.mo23473b().equals(a2.mo23473b())) {
                        m14870b(fc == C7063Fc.f13210b ? C7196pb.f13748R : C7196pb.f13752S, fc);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m14870b(C7204rb<Boolean> rbVar, C7063Fc fc) {
        if (((Boolean) this.f13625b.mo23039a(rbVar)).booleanValue()) {
            this.f13625b.mo23063h().mo22963g(C7059Ec.m14670a(C7257g.f14096c, C7258h.f14103b, fc, this.f13625b));
        }
    }

    /* renamed from: b */
    private boolean m14871b() {
        if (C7206s.m15422a("android.permission.INTERNET", this.f13627d)) {
            return true;
        }
        this.f13626c.mo22921e(mo23203a(), "Unable to enable AppLovin SDK: no android.permission.INTERNET");
        return false;
    }

    /* renamed from: c */
    private void m14872c() {
        this.f13625b.mo23027C().mo22971a((C7184mb) new C7224wb(this.f13625b), C7113Tb.MAIN, 500);
    }

    /* renamed from: d */
    private void m14873d() {
        m14874e();
        m14869a(C7196pb.f13739P, C7063Fc.f13210b);
        m14869a(C7196pb.f13744Q, C7063Fc.f13211c);
        m14875f();
    }

    /* renamed from: e */
    private void m14874e() {
        LinkedHashSet b = this.f13625b.mo23029E().mo22823b();
        if (!b.isEmpty()) {
            C7262l lVar = this.f13626c;
            String a = mo23203a();
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling preload(s) for ");
            sb.append(b.size());
            sb.append(" zone(s)");
            lVar.mo22918c(a, sb.toString());
            Iterator it = b.iterator();
            while (it.hasNext()) {
                C7059Ec ec = (C7059Ec) it.next();
                if (ec.mo22804e()) {
                    this.f13625b.m15077c().mo22981a(ec);
                } else {
                    this.f13625b.m15057a().mo23011b(ec);
                }
            }
        }
    }

    /* renamed from: f */
    private void m14875f() {
        if (((Boolean) this.f13625b.mo23039a(C7196pb.f13889ub)).booleanValue()) {
            this.f13625b.mo23064i().mo22963g(C7059Ec.m14685j(this.f13625b));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00cb, code lost:
        if (r13.f13625b.mo23032H() != false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00f5, code lost:
        if (r13.f13625b.mo23032H() == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00f8, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00f9, code lost:
        r9.append(r2);
        r9.append(r1);
        r9.append(java.lang.System.currentTimeMillis() - r5);
        r9.append(r0);
        r7.mo22918c(r8, r9.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0111, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = " in "
            java.lang.String r2 = "succeeded"
            java.lang.String r3 = "failed"
            java.lang.String r4 = "AppLovin SDK 8.1.4 initialization "
            long r5 = java.lang.System.currentTimeMillis()
            d.b.d.l r7 = r13.f13626c
            java.lang.String r8 = r13.mo23203a()
            java.lang.String r9 = "Initializing AppLovin SDK 8.1.4..."
            r7.mo22918c(r8, r9)
            r7 = 0
            boolean r8 = r13.m14871b()     // Catch:{ Throwable -> 0x00d0 }
            if (r8 == 0) goto L_0x00a7
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.J r8 = r8.mo23061f()     // Catch:{ Throwable -> 0x00d0 }
            r8.mo22867c()     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r9 = "ad_imp_session"
            r8.mo22868c(r9)     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.H r8 = r8.mo23072q()     // Catch:{ Throwable -> 0x00d0 }
            android.content.Context r9 = r13.f13627d     // Catch:{ Throwable -> 0x00d0 }
            r8.mo22837d(r9)     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.H r8 = r8.mo23072q()     // Catch:{ Throwable -> 0x00d0 }
            android.content.Context r9 = r13.f13627d     // Catch:{ Throwable -> 0x00d0 }
            r8.mo22836c(r9)     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.e r8 = r8.mo23076u()     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23094a()     // Catch:{ Throwable -> 0x00d0 }
            r13.m14873d()     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.I r8 = r8.mo23062g()     // Catch:{ Throwable -> 0x00d0 }
            r8.mo22852a()     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23031G()     // Catch:{ Throwable -> 0x00d0 }
            r13.m14872c()     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.s r8 = r8.mo23070o()     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23246e()     // Catch:{ Throwable -> 0x00d0 }
            android.content.Context r8 = r13.f13627d     // Catch:{ Throwable -> 0x00d0 }
            android.content.SharedPreferences r8 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8)     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r9 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.ub<java.lang.String> r10 = p019d.p143b.p144a.p147c.C7216ub.f13974a     // Catch:{ Throwable -> 0x00d0 }
            r11 = 0
            java.lang.Object r9 = r9.mo23042a(r10, r11, r8)     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Throwable -> 0x00d0 }
            boolean r9 = p019d.p143b.p150d.C7269s.m15819a(r9)     // Catch:{ Throwable -> 0x00d0 }
            r10 = 1
            if (r9 != 0) goto L_0x008d
            d.b.a.c.c r9 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.ub<java.lang.String> r11 = p019d.p143b.p144a.p147c.C7216ub.f13974a     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r12 = java.lang.Boolean.toString(r10)     // Catch:{ Throwable -> 0x00d0 }
            r9.mo23053b(r11, r12, r8)     // Catch:{ Throwable -> 0x00d0 }
        L_0x008d:
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23048a(r10)     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.cb r8 = r8.mo23077v()     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23083a()     // Catch:{ Throwable -> 0x00d0 }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            d.b.d.k r8 = r8.mo23071p()     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r9 = "landing"
            r8.mo23089a(r9)     // Catch:{ Throwable -> 0x00d0 }
            goto L_0x00b7
        L_0x00a7:
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ Throwable -> 0x00d0 }
            r8.mo23048a(r7)     // Catch:{ Throwable -> 0x00d0 }
            d.b.d.l r8 = r13.f13626c     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r9 = r13.mo23203a()     // Catch:{ Throwable -> 0x00d0 }
            java.lang.String r10 = "Couldn't initialize the AppLovin SDK due to missing INTERNET permission"
            r8.mo22921e(r9, r10)     // Catch:{ Throwable -> 0x00d0 }
        L_0x00b7:
            d.b.d.l r7 = r13.f13626c
            java.lang.String r8 = r13.mo23203a()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            d.b.a.c.c r4 = r13.f13625b
            boolean r4 = r4.mo23032H()
            if (r4 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00ce:
            r7 = move-exception
            goto L_0x0112
        L_0x00d0:
            r8 = move-exception
            d.b.d.l r9 = r13.f13626c     // Catch:{ all -> 0x00ce }
            java.lang.String r10 = r13.mo23203a()     // Catch:{ all -> 0x00ce }
            java.lang.String r11 = "Unable to initialize SDK. Exception occurred: %@"
            r9.mo22917b(r10, r11, r8)     // Catch:{ all -> 0x00ce }
            d.b.a.c.c r8 = r13.f13625b     // Catch:{ all -> 0x00ce }
            r8.mo23048a(r7)     // Catch:{ all -> 0x00ce }
            d.b.d.l r7 = r13.f13626c
            java.lang.String r8 = r13.mo23203a()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            d.b.a.c.c r4 = r13.f13625b
            boolean r4 = r4.mo23032H()
            if (r4 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r2 = r3
        L_0x00f9:
            r9.append(r2)
            r9.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r5
            r9.append(r1)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r7.mo22918c(r8, r0)
            return
        L_0x0112:
            d.b.d.l r8 = r13.f13626c
            java.lang.String r9 = r13.mo23203a()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            d.b.a.c.c r4 = r13.f13625b
            boolean r4 = r4.mo23032H()
            if (r4 == 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r2 = r3
        L_0x012a:
            r10.append(r2)
            r10.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r5
            r10.append(r1)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r8.mo22918c(r9, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7105Qb.run():void");
    }
}
