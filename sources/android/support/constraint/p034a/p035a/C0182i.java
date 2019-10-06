package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.p035a.C0175f.C0178c;
import android.support.constraint.p034a.p035a.C0180h.C0181a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.constraint.a.a.i */
/* compiled from: ConstraintWidgetContainer */
public class C0182i extends C0194t {

    /* renamed from: Aa */
    int f458Aa;

    /* renamed from: Ba */
    int f459Ba;

    /* renamed from: Ca */
    int f460Ca;

    /* renamed from: Da */
    int f461Da = 0;

    /* renamed from: Ea */
    int f462Ea = 0;

    /* renamed from: Fa */
    C0173d[] f463Fa = new C0173d[4];

    /* renamed from: Ga */
    C0173d[] f464Ga = new C0173d[4];

    /* renamed from: Ha */
    public List<C0183j> f465Ha = new ArrayList();

    /* renamed from: Ia */
    public boolean f466Ia = false;

    /* renamed from: Ja */
    public boolean f467Ja = false;

    /* renamed from: Ka */
    public boolean f468Ka = false;

    /* renamed from: La */
    public int f469La = 0;

    /* renamed from: Ma */
    public int f470Ma = 0;

    /* renamed from: Na */
    private int f471Na = 7;

    /* renamed from: Oa */
    public boolean f472Oa = false;

    /* renamed from: Pa */
    private boolean f473Pa = false;

    /* renamed from: Qa */
    private boolean f474Qa = false;

    /* renamed from: Ra */
    int f475Ra = 0;

    /* renamed from: wa */
    private boolean f476wa = false;

    /* renamed from: xa */
    protected C0198e f477xa = new C0198e();

    /* renamed from: ya */
    private C0192s f478ya;

    /* renamed from: za */
    int f479za;

    /* renamed from: u */
    public void mo3945u(int value) {
        this.f471Na = value;
    }

    /* renamed from: M */
    public int mo3931M() {
        return this.f471Na;
    }

    /* renamed from: t */
    public boolean mo3834t(int feature) {
        return (this.f471Na & feature) == feature;
    }

    /* renamed from: D */
    public void mo3854D() {
        this.f477xa.mo4030g();
        this.f479za = 0;
        this.f459Ba = 0;
        this.f458Aa = 0;
        this.f460Ca = 0;
        this.f465Ha.clear();
        this.f472Oa = false;
        super.mo3854D();
    }

    /* renamed from: Q */
    public boolean mo3935Q() {
        return this.f473Pa;
    }

    /* renamed from: O */
    public boolean mo3933O() {
        return this.f474Qa;
    }

    /* renamed from: d */
    public boolean mo3943d(C0198e system) {
        mo3831a(system);
        int count = this.f530va.size();
        for (int i = 0; i < count; i++) {
            C0180h widget = (C0180h) this.f530va.get(i);
            if (widget instanceof C0182i) {
                C0181a[] aVarArr = widget.f386F;
                C0181a horizontalBehaviour = aVarArr[0];
                C0181a verticalBehaviour = aVarArr[1];
                if (horizontalBehaviour == C0181a.WRAP_CONTENT) {
                    widget.mo3865a(C0181a.FIXED);
                }
                if (verticalBehaviour == C0181a.WRAP_CONTENT) {
                    widget.mo3878b(C0181a.FIXED);
                }
                widget.mo3831a(system);
                if (horizontalBehaviour == C0181a.WRAP_CONTENT) {
                    widget.mo3865a(horizontalBehaviour);
                }
                if (verticalBehaviour == C0181a.WRAP_CONTENT) {
                    widget.mo3878b(verticalBehaviour);
                }
            } else {
                C0187n.m1082a(this, system, widget);
                widget.mo3831a(system);
            }
        }
        if (this.f461Da > 0) {
            C0172c.m933a(this, system, 0);
        }
        if (this.f462Ea > 0) {
            C0172c.m933a(this, system, 1);
        }
        return true;
    }

    /* renamed from: a */
    public void mo3941a(C0198e system, boolean[] flags) {
        flags[2] = false;
        mo3886c(system);
        int count = this.f530va.size();
        for (int i = 0; i < count; i++) {
            C0180h widget = (C0180h) this.f530va.get(i);
            widget.mo3886c(system);
            if (widget.f386F[0] == C0181a.MATCH_CONSTRAINT && widget.mo3920s() < widget.mo3924u()) {
                flags[2] = true;
            }
            if (widget.f386F[1] == C0181a.MATCH_CONSTRAINT && widget.mo3900i() < widget.mo3922t()) {
                flags[2] = true;
            }
        }
    }

    /* renamed from: c */
    public void mo3942c(boolean isRtl) {
        this.f476wa = isRtl;
    }

    /* renamed from: P */
    public boolean mo3934P() {
        return this.f476wa;
    }

    /* renamed from: a */
    public void mo3830a(int optimizationLevel) {
        super.mo3830a(optimizationLevel);
        int count = this.f530va.size();
        for (int i = 0; i < count; i++) {
            ((C0180h) this.f530va.get(i)).mo3830a(optimizationLevel);
        }
    }

    /* JADX WARNING: type inference failed for: r17v3, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v25, types: [boolean[]] */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean[], code=null, for r0v25, types: [boolean[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v7
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 361
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
    /* JADX WARNING: Removed duplicated region for block: B:114:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01f0  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3930K() {
        /*
            r24 = this;
            r1 = r24
            int r2 = r1.f392L
            int r3 = r1.f393M
            int r0 = r24.mo3920s()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r24.mo3900i()
            int r6 = java.lang.Math.max(r4, r0)
            r1.f473Pa = r4
            r1.f474Qa = r4
            android.support.constraint.a.a.h r0 = r1.f387G
            if (r0 == 0) goto L_0x0046
            android.support.constraint.a.a.s r0 = r1.f478ya
            if (r0 != 0) goto L_0x002a
            android.support.constraint.a.a.s r0 = new android.support.constraint.a.a.s
            r0.<init>(r1)
            r1.f478ya = r0
        L_0x002a:
            android.support.constraint.a.a.s r0 = r1.f478ya
            r0.mo3977b(r1)
            int r0 = r1.f479za
            r1.mo3919r(r0)
            int r0 = r1.f458Aa
            r1.mo3921s(r0)
            r24.mo3855E()
            android.support.constraint.a.e r0 = r1.f477xa
            android.support.constraint.a.c r0 = r0.mo4028d()
            r1.mo3868a(r0)
            goto L_0x004a
        L_0x0046:
            r1.f392L = r4
            r1.f393M = r4
        L_0x004a:
            int r0 = r1.f471Na
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.mo3834t(r8)
            if (r0 != 0) goto L_0x005c
            r24.mo3937S()
        L_0x005c:
            boolean r0 = r1.mo3834t(r7)
            if (r0 != 0) goto L_0x0065
            r24.mo3936R()
        L_0x0065:
            android.support.constraint.a.e r0 = r1.f477xa
            r0.f547i = r9
            goto L_0x006e
        L_0x006a:
            android.support.constraint.a.e r0 = r1.f477xa
            r0.f547i = r4
        L_0x006e:
            r0 = 0
            android.support.constraint.a.a.h$a[] r10 = r1.f386F
            r11 = r10[r9]
            r10 = r10[r4]
            r24.m1038V()
            java.util.List<android.support.constraint.a.a.j> r12 = r1.f465Ha
            int r12 = r12.size()
            if (r12 != 0) goto L_0x0091
            java.util.List<android.support.constraint.a.a.j> r12 = r1.f465Ha
            r12.clear()
            java.util.List<android.support.constraint.a.a.j> r12 = r1.f465Ha
            android.support.constraint.a.a.j r13 = new android.support.constraint.a.a.j
            java.util.ArrayList<android.support.constraint.a.a.h> r14 = r1.f530va
            r13.<init>(r14)
            r12.add(r4, r13)
        L_0x0091:
            r12 = 0
            java.util.List<android.support.constraint.a.a.j> r13 = r1.f465Ha
            int r13 = r13.size()
            java.util.ArrayList<android.support.constraint.a.a.h> r14 = r1.f530va
            android.support.constraint.a.a.h$a r15 = r24.mo3902j()
            android.support.constraint.a.a.h$a r8 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r15 == r8) goto L_0x00ad
            android.support.constraint.a.a.h$a r8 = r24.mo3916q()
            android.support.constraint.a.a.h$a r15 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r8 != r15) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r8 = 0
            goto L_0x00ae
        L_0x00ad:
            r8 = 1
        L_0x00ae:
            r15 = 0
        L_0x00af:
            if (r15 >= r13) goto L_0x0329
            boolean r9 = r1.f472Oa
            if (r9 != 0) goto L_0x0329
            java.util.List<android.support.constraint.a.a.j> r9 = r1.f465Ha
            java.lang.Object r9 = r9.get(r15)
            android.support.constraint.a.a.j r9 = (android.support.constraint.p034a.p035a.C0183j) r9
            boolean r9 = r9.f483d
            if (r9 == 0) goto L_0x00c5
            r22 = r13
            goto L_0x031f
        L_0x00c5:
            boolean r9 = r1.mo3834t(r7)
            if (r9 == 0) goto L_0x00fa
            android.support.constraint.a.a.h$a r9 = r24.mo3902j()
            android.support.constraint.a.a.h$a r7 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            if (r9 != r7) goto L_0x00ec
            android.support.constraint.a.a.h$a r7 = r24.mo3916q()
            android.support.constraint.a.a.h$a r9 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            if (r7 != r9) goto L_0x00ec
            java.util.List<android.support.constraint.a.a.j> r7 = r1.f465Ha
            java.lang.Object r7 = r7.get(r15)
            android.support.constraint.a.a.j r7 = (android.support.constraint.p034a.p035a.C0183j) r7
            java.util.List r7 = r7.mo3946a()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f530va = r7
            goto L_0x00fa
        L_0x00ec:
            java.util.List<android.support.constraint.a.a.j> r7 = r1.f465Ha
            java.lang.Object r7 = r7.get(r15)
            android.support.constraint.a.a.j r7 = (android.support.constraint.p034a.p035a.C0183j) r7
            java.util.List<android.support.constraint.a.a.h> r7 = r7.f480a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.f530va = r7
        L_0x00fa:
            r24.m1038V()
            java.util.ArrayList<android.support.constraint.a.a.h> r7 = r1.f530va
            int r7 = r7.size()
            r9 = 0
            r12 = 0
        L_0x0105:
            if (r12 >= r7) goto L_0x0121
            java.util.ArrayList<android.support.constraint.a.a.h> r4 = r1.f530va
            java.lang.Object r4 = r4.get(r12)
            android.support.constraint.a.a.h r4 = (android.support.constraint.p034a.p035a.C0180h) r4
            r19 = r9
            boolean r9 = r4 instanceof android.support.constraint.p034a.p035a.C0194t
            if (r9 == 0) goto L_0x011b
            r9 = r4
            android.support.constraint.a.a.t r9 = (android.support.constraint.p034a.p035a.C0194t) r9
            r9.mo3930K()
        L_0x011b:
            int r12 = r12 + 1
            r9 = r19
            r4 = 0
            goto L_0x0105
        L_0x0121:
            r19 = r9
            r4 = 1
            r9 = r0
        L_0x0125:
            if (r4 == 0) goto L_0x0308
            int r12 = r19 + 1
            android.support.constraint.a.e r0 = r1.f477xa     // Catch:{ Exception -> 0x0175 }
            r0.mo4030g()     // Catch:{ Exception -> 0x0175 }
            r24.m1038V()     // Catch:{ Exception -> 0x0175 }
            android.support.constraint.a.e r0 = r1.f477xa     // Catch:{ Exception -> 0x0175 }
            r1.mo3879b(r0)     // Catch:{ Exception -> 0x0175 }
            r0 = 0
        L_0x0137:
            if (r0 >= r7) goto L_0x0157
            r20 = r4
            java.util.ArrayList<android.support.constraint.a.a.h> r4 = r1.f530va     // Catch:{ Exception -> 0x0151 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0151 }
            android.support.constraint.a.a.h r4 = (android.support.constraint.p034a.p035a.C0180h) r4     // Catch:{ Exception -> 0x0151 }
            r21 = r9
            android.support.constraint.a.e r9 = r1.f477xa     // Catch:{ Exception -> 0x0171 }
            r4.mo3879b(r9)     // Catch:{ Exception -> 0x0171 }
            int r0 = r0 + 1
            r4 = r20
            r9 = r21
            goto L_0x0137
        L_0x0151:
            r0 = move-exception
            r21 = r9
            r4 = r20
            goto L_0x017a
        L_0x0157:
            r20 = r4
            r21 = r9
            android.support.constraint.a.e r0 = r1.f477xa     // Catch:{ Exception -> 0x0171 }
            boolean r0 = r1.mo3943d(r0)     // Catch:{ Exception -> 0x0171 }
            r4 = r0
            if (r4 == 0) goto L_0x016c
            android.support.constraint.a.e r0 = r1.f477xa     // Catch:{ Exception -> 0x016a }
            r0.mo4029f()     // Catch:{ Exception -> 0x016a }
            goto L_0x016c
        L_0x016a:
            r0 = move-exception
            goto L_0x017a
        L_0x016c:
            r19 = r4
            r22 = r13
            goto L_0x0197
        L_0x0171:
            r0 = move-exception
            r4 = r20
            goto L_0x017a
        L_0x0175:
            r0 = move-exception
            r20 = r4
            r21 = r9
        L_0x017a:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r19 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r22 = r13
            java.lang.String r13 = "EXCEPTION : "
            r4.append(r13)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r9.println(r4)
        L_0x0197:
            if (r19 == 0) goto L_0x01a1
            android.support.constraint.a.e r4 = r1.f477xa
            boolean[] r9 = android.support.constraint.p034a.p035a.C0187n.f503a
            r1.mo3941a(r4, r9)
            goto L_0x01ed
        L_0x01a1:
            android.support.constraint.a.e r4 = r1.f477xa
            r1.mo3886c(r4)
            r4 = 0
        L_0x01a7:
            if (r4 >= r7) goto L_0x01ed
            java.util.ArrayList<android.support.constraint.a.a.h> r9 = r1.f530va
            java.lang.Object r9 = r9.get(r4)
            android.support.constraint.a.a.h r9 = (android.support.constraint.p034a.p035a.C0180h) r9
            android.support.constraint.a.a.h$a[] r13 = r9.f386F
            r18 = 0
            r13 = r13[r18]
            android.support.constraint.a.a.h$a r0 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r13 != r0) goto L_0x01d0
            int r0 = r9.mo3920s()
            int r13 = r9.mo3924u()
            if (r0 >= r13) goto L_0x01cd
            boolean[] r0 = android.support.constraint.p034a.p035a.C0187n.f503a
            r13 = 2
            r17 = 1
            r0[r13] = r17
            goto L_0x01ed
        L_0x01cd:
            r17 = 1
            goto L_0x01d2
        L_0x01d0:
            r17 = 1
        L_0x01d2:
            android.support.constraint.a.a.h$a[] r0 = r9.f386F
            r0 = r0[r17]
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r0 != r13) goto L_0x01ea
            int r0 = r9.mo3900i()
            int r13 = r9.mo3922t()
            if (r0 >= r13) goto L_0x01ea
            boolean[] r0 = android.support.constraint.p034a.p035a.C0187n.f503a
            r13 = 2
            r0[r13] = r17
            goto L_0x01ed
        L_0x01ea:
            int r4 = r4 + 1
            goto L_0x01a7
        L_0x01ed:
            r0 = 0
            if (r8 == 0) goto L_0x0275
            r4 = 8
            if (r12 >= r4) goto L_0x0275
            boolean[] r9 = android.support.constraint.p034a.p035a.C0187n.f503a
            r13 = 2
            boolean r9 = r9[r13]
            if (r9 == 0) goto L_0x0275
            r9 = 0
            r13 = 0
            r16 = 0
            r4 = r13
            r13 = r9
            r9 = r16
        L_0x0203:
            if (r9 >= r7) goto L_0x0230
            r19 = r0
            java.util.ArrayList<android.support.constraint.a.a.h> r0 = r1.f530va
            java.lang.Object r0 = r0.get(r9)
            android.support.constraint.a.a.h r0 = (android.support.constraint.p034a.p035a.C0180h) r0
            r23 = r7
            int r7 = r0.f392L
            int r20 = r0.mo3920s()
            int r7 = r7 + r20
            int r13 = java.lang.Math.max(r13, r7)
            int r7 = r0.f393M
            int r20 = r0.mo3900i()
            int r7 = r7 + r20
            int r4 = java.lang.Math.max(r4, r7)
            int r9 = r9 + 1
            r0 = r19
            r7 = r23
            goto L_0x0203
        L_0x0230:
            r19 = r0
            r23 = r7
            int r0 = r1.f403W
            int r0 = java.lang.Math.max(r0, r13)
            int r7 = r1.f404X
            int r4 = java.lang.Math.max(r7, r4)
            android.support.constraint.a.a.h$a r7 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r10 != r7) goto L_0x0259
            int r7 = r24.mo3920s()
            if (r7 >= r0) goto L_0x0259
            r1.mo3913o(r0)
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            android.support.constraint.a.a.h$a r9 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            r13 = 0
            r7[r13] = r9
            r9 = 1
            r7 = 1
            r19 = r7
            goto L_0x025b
        L_0x0259:
            r9 = r21
        L_0x025b:
            android.support.constraint.a.a.h$a r7 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r11 != r7) goto L_0x027b
            int r7 = r24.mo3900i()
            if (r7 >= r4) goto L_0x027b
            r1.mo3897g(r4)
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            r17 = 1
            r7[r17] = r13
            r9 = 1
            r7 = 1
            r19 = r7
            goto L_0x027b
        L_0x0275:
            r19 = r0
            r23 = r7
            r9 = r21
        L_0x027b:
            int r0 = r1.f403W
            int r4 = r24.mo3920s()
            int r0 = java.lang.Math.max(r0, r4)
            int r4 = r24.mo3920s()
            if (r0 <= r4) goto L_0x0298
            r1.mo3913o(r0)
            android.support.constraint.a.a.h$a[] r4 = r1.f386F
            android.support.constraint.a.a.h$a r7 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            r13 = 0
            r4[r13] = r7
            r9 = 1
            r19 = 1
        L_0x0298:
            int r4 = r1.f404X
            int r7 = r24.mo3900i()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r24.mo3900i()
            if (r4 <= r7) goto L_0x02b6
            r1.mo3897g(r4)
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            r17 = 1
            r7[r17] = r13
            r9 = 1
            r19 = 1
        L_0x02b6:
            if (r9 != 0) goto L_0x02fe
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            r13 = 0
            r7 = r7[r13]
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r7 != r13) goto L_0x02da
            if (r5 <= 0) goto L_0x02da
            int r7 = r24.mo3920s()
            if (r7 <= r5) goto L_0x02da
            r7 = 1
            r1.f473Pa = r7
            r9 = 1
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            r18 = 0
            r7[r18] = r13
            r1.mo3913o(r5)
            r19 = 1
        L_0x02da:
            android.support.constraint.a.a.h$a[] r7 = r1.f386F
            r13 = 1
            r7 = r7[r13]
            android.support.constraint.a.a.h$a r13 = android.support.constraint.p034a.p035a.C0180h.C0181a.WRAP_CONTENT
            if (r7 != r13) goto L_0x02fb
            if (r6 <= 0) goto L_0x02fb
            int r7 = r24.mo3900i()
            if (r7 <= r6) goto L_0x02fb
            r7 = 1
            r1.f474Qa = r7
            r9 = 1
            android.support.constraint.a.a.h$a[] r13 = r1.f386F
            android.support.constraint.a.a.h$a r17 = android.support.constraint.p034a.p035a.C0180h.C0181a.FIXED
            r13[r7] = r17
            r1.mo3897g(r6)
            r7 = 1
            r4 = r7
            goto L_0x0300
        L_0x02fb:
            r4 = r19
            goto L_0x0300
        L_0x02fe:
            r4 = r19
        L_0x0300:
            r19 = r12
            r13 = r22
            r7 = r23
            goto L_0x0125
        L_0x0308:
            r20 = r4
            r23 = r7
            r21 = r9
            r22 = r13
            java.util.List<android.support.constraint.a.a.j> r0 = r1.f465Ha
            java.lang.Object r0 = r0.get(r15)
            android.support.constraint.a.a.j r0 = (android.support.constraint.p034a.p035a.C0183j) r0
            r0.mo3950b()
            r12 = r19
            r0 = r21
        L_0x031f:
            int r15 = r15 + 1
            r13 = r22
            r4 = 0
            r7 = 32
            r9 = 1
            goto L_0x00af
        L_0x0329:
            r22 = r13
            r1.f530va = r14
            android.support.constraint.a.a.h r4 = r1.f387G
            if (r4 == 0) goto L_0x035d
            int r4 = r1.f403W
            int r7 = r24.mo3920s()
            int r4 = java.lang.Math.max(r4, r7)
            int r7 = r1.f404X
            int r9 = r24.mo3900i()
            int r7 = java.lang.Math.max(r7, r9)
            android.support.constraint.a.a.s r9 = r1.f478ya
            r9.mo3976a(r1)
            int r9 = r1.f479za
            int r9 = r9 + r4
            int r13 = r1.f459Ba
            int r9 = r9 + r13
            r1.mo3913o(r9)
            int r9 = r1.f458Aa
            int r9 = r9 + r7
            int r13 = r1.f460Ca
            int r9 = r9 + r13
            r1.mo3897g(r9)
            goto L_0x0361
        L_0x035d:
            r1.f392L = r2
            r1.f393M = r3
        L_0x0361:
            if (r0 == 0) goto L_0x036b
            android.support.constraint.a.a.h$a[] r4 = r1.f386F
            r7 = 0
            r4[r7] = r10
            r7 = 1
            r4[r7] = r11
        L_0x036b:
            android.support.constraint.a.e r4 = r1.f477xa
            android.support.constraint.a.c r4 = r4.mo4028d()
            r1.mo3868a(r4)
            android.support.constraint.a.a.i r4 = r24.mo3951J()
            if (r1 != r4) goto L_0x037d
            r24.mo3856H()
        L_0x037d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.p034a.p035a.C0182i.mo3930K():void");
    }

    /* renamed from: T */
    public void mo3938T() {
        mo3937S();
        mo3830a(this.f471Na);
    }

    /* renamed from: U */
    public void mo3939U() {
        C0189p leftNode = mo3858a(C0178c.LEFT).mo3843d();
        C0189p topNode = mo3858a(C0178c.TOP).mo3843d();
        leftNode.mo3958a((C0189p) null, 0.0f);
        topNode.mo3958a((C0189p) null, 0.0f);
    }

    /* renamed from: f */
    public void mo3944f(int width, int height) {
        if (this.f386F[0] != C0181a.WRAP_CONTENT) {
            C0190q qVar = this.f412d;
            if (qVar != null) {
                qVar.mo3970a(width);
            }
        }
        if (this.f386F[1] != C0181a.WRAP_CONTENT) {
            C0190q qVar2 = this.f414e;
            if (qVar2 != null) {
                qVar2.mo3970a(height);
            }
        }
    }

    /* renamed from: S */
    public void mo3937S() {
        int count = this.f530va.size();
        mo3828F();
        for (int i = 0; i < count; i++) {
            ((C0180h) this.f530va.get(i)).mo3828F();
        }
    }

    /* renamed from: R */
    public void mo3936R() {
        if (!mo3834t(8)) {
            mo3830a(this.f471Na);
        }
        mo3939U();
    }

    /* renamed from: N */
    public boolean mo3932N() {
        return false;
    }

    /* renamed from: V */
    private void m1038V() {
        this.f461Da = 0;
        this.f462Ea = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3940a(C0180h constraintWidget, int type) {
        C0180h widget = constraintWidget;
        if (type == 0) {
            m1039d(widget);
        } else if (type == 1) {
            m1040e(widget);
        }
    }

    /* renamed from: d */
    private void m1039d(C0180h widget) {
        int i = this.f461Da + 1;
        C0173d[] dVarArr = this.f464Ga;
        if (i >= dVarArr.length) {
            this.f464Ga = (C0173d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.f464Ga[this.f461Da] = new C0173d(widget, 0, mo3934P());
        this.f461Da++;
    }

    /* renamed from: e */
    private void m1040e(C0180h widget) {
        int i = this.f462Ea + 1;
        C0173d[] dVarArr = this.f463Fa;
        if (i >= dVarArr.length) {
            this.f463Fa = (C0173d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.f463Fa[this.f462Ea] = new C0173d(widget, 1, mo3934P());
        this.f462Ea++;
    }
}
