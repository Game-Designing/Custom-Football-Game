package android.support.constraint.p034a;

import android.support.constraint.p034a.C0203i.C0204a;
import android.support.constraint.p034a.p035a.C0175f;
import android.support.constraint.p034a.p035a.C0175f.C0178c;
import android.support.constraint.p034a.p035a.C0180h;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: android.support.constraint.a.e */
/* compiled from: LinearSystem */
public class C0198e {

    /* renamed from: a */
    private static int f539a = 1000;

    /* renamed from: b */
    public static C0200f f540b;

    /* renamed from: c */
    int f541c = 0;

    /* renamed from: d */
    private HashMap<String, C0203i> f542d = null;

    /* renamed from: e */
    private C0199a f543e;

    /* renamed from: f */
    private int f544f = 32;

    /* renamed from: g */
    private int f545g;

    /* renamed from: h */
    C0195b[] f546h;

    /* renamed from: i */
    public boolean f547i;

    /* renamed from: j */
    private boolean[] f548j;

    /* renamed from: k */
    int f549k;

    /* renamed from: l */
    int f550l;

    /* renamed from: m */
    private int f551m;

    /* renamed from: n */
    final C0196c f552n;

    /* renamed from: o */
    private C0203i[] f553o;

    /* renamed from: p */
    private int f554p;

    /* renamed from: q */
    private C0195b[] f555q;

    /* renamed from: r */
    private final C0199a f556r;

    /* renamed from: android.support.constraint.a.e$a */
    /* compiled from: LinearSystem */
    interface C0199a {
        /* renamed from: a */
        C0203i mo3991a(C0198e eVar, boolean[] zArr);

        /* renamed from: a */
        void mo3993a(C0199a aVar);

        /* renamed from: a */
        void mo3994a(C0203i iVar);

        void clear();

        C0203i getKey();
    }

    public C0198e() {
        int i = this.f544f;
        this.f545g = i;
        this.f546h = null;
        this.f547i = false;
        this.f548j = new boolean[i];
        this.f549k = 1;
        this.f550l = 0;
        this.f551m = i;
        this.f553o = new C0203i[f539a];
        this.f554p = 0;
        this.f555q = new C0195b[i];
        this.f546h = new C0195b[i];
        m1155j();
        this.f552n = new C0196c();
        this.f543e = new C0197d(this.f552n);
        this.f556r = new C0195b(this.f552n);
    }

    /* renamed from: e */
    public static C0200f m1152e() {
        return f540b;
    }

    /* renamed from: i */
    private void m1154i() {
        this.f544f *= 2;
        this.f546h = (C0195b[]) Arrays.copyOf(this.f546h, this.f544f);
        C0196c cVar = this.f552n;
        cVar.f538c = (C0203i[]) Arrays.copyOf(cVar.f538c, this.f544f);
        int i = this.f544f;
        this.f548j = new boolean[i];
        this.f545g = i;
        this.f551m = i;
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f561d++;
            fVar.f572o = Math.max(fVar.f572o, (long) i);
            C0200f fVar2 = f540b;
            fVar2.f557A = fVar2.f572o;
        }
    }

    /* renamed from: j */
    private void m1155j() {
        int i = 0;
        while (true) {
            C0195b[] bVarArr = this.f546h;
            if (i < bVarArr.length) {
                C0195b row = bVarArr[i];
                if (row != null) {
                    this.f552n.f536a.mo4033a(row);
                }
                this.f546h[i] = null;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: g */
    public void mo4030g() {
        C0196c cVar;
        int i = 0;
        while (true) {
            cVar = this.f552n;
            C0203i[] iVarArr = cVar.f538c;
            if (i >= iVarArr.length) {
                break;
            }
            C0203i variable = iVarArr[i];
            if (variable != null) {
                variable.mo4036b();
            }
            i++;
        }
        cVar.f537b.mo4032a(this.f553o, this.f554p);
        this.f554p = 0;
        Arrays.fill(this.f552n.f538c, null);
        HashMap<String, C0203i> hashMap = this.f542d;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f541c = 0;
        this.f543e.clear();
        this.f549k = 1;
        for (int i2 = 0; i2 < this.f550l; i2++) {
            this.f546h[i2].f533c = false;
        }
        m1155j();
        this.f550l = 0;
    }

    /* renamed from: a */
    public C0203i mo4013a(Object anchor) {
        if (anchor == null) {
            return null;
        }
        if (this.f549k + 1 >= this.f545g) {
            m1154i();
        }
        C0203i variable = null;
        if (anchor instanceof C0175f) {
            variable = ((C0175f) anchor).mo3844e();
            if (variable == null) {
                ((C0175f) anchor).mo3837a(this.f552n);
                variable = ((C0175f) anchor).mo3844e();
            }
            int i = variable.f592g;
            if (i == -1 || i > this.f541c || this.f552n.f538c[i] == null) {
                if (variable.f592g != -1) {
                    variable.mo4036b();
                }
                this.f541c++;
                this.f549k++;
                int i2 = this.f541c;
                variable.f592g = i2;
                variable.f597l = C0204a.UNRESTRICTED;
                this.f552n.f538c[i2] = variable;
            }
        }
        return variable;
    }

    /* renamed from: b */
    public C0195b mo4023b() {
        C0195b row = (C0195b) this.f552n.f536a.mo4031a();
        if (row == null) {
            row = new C0195b(this.f552n);
        } else {
            row.mo4005d();
        }
        C0203i.m1186a();
        return row;
    }

    /* renamed from: c */
    public C0203i mo4026c() {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f570m++;
        }
        if (this.f549k + 1 >= this.f545g) {
            m1154i();
        }
        C0203i variable = m1147a(C0204a.SLACK, (String) null);
        this.f541c++;
        this.f549k++;
        int i = this.f541c;
        variable.f592g = i;
        this.f552n.f538c[i] = variable;
        return variable;
    }

    /* renamed from: a */
    public C0203i mo4011a() {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f571n++;
        }
        if (this.f549k + 1 >= this.f545g) {
            m1154i();
        }
        C0203i variable = m1147a(C0204a.SLACK, (String) null);
        this.f541c++;
        this.f549k++;
        int i = this.f541c;
        variable.f592g = i;
        this.f552n.f538c[i] = variable;
        return variable;
    }

    /* renamed from: b */
    private void m1149b(C0195b row) {
        row.mo3984a(this, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4016a(C0195b row, int sign, int strength) {
        row.mo3985a(mo4012a(strength, (String) null), sign);
    }

    /* renamed from: a */
    public C0203i mo4012a(int strength, String prefix) {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f569l++;
        }
        if (this.f549k + 1 >= this.f545g) {
            m1154i();
        }
        C0203i variable = m1147a(C0204a.ERROR, prefix);
        this.f541c++;
        this.f549k++;
        int i = this.f541c;
        variable.f592g = i;
        variable.f594i = strength;
        this.f552n.f538c[i] = variable;
        this.f543e.mo3994a(variable);
        return variable;
    }

    /* renamed from: a */
    private C0203i m1147a(C0204a type, String prefix) {
        C0203i variable = (C0203i) this.f552n.f537b.mo4031a();
        if (variable == null) {
            variable = new C0203i(type, prefix);
            variable.mo4035a(type, prefix);
        } else {
            variable.mo4036b();
            variable.mo4035a(type, prefix);
        }
        int i = this.f554p;
        int i2 = f539a;
        if (i >= i2) {
            f539a = i2 * 2;
            this.f553o = (C0203i[]) Arrays.copyOf(this.f553o, f539a);
        }
        C0203i[] iVarArr = this.f553o;
        int i3 = this.f554p;
        this.f554p = i3 + 1;
        iVarArr[i3] = variable;
        return variable;
    }

    /* renamed from: b */
    public int mo4022b(Object anchor) {
        C0203i variable = ((C0175f) anchor).mo3844e();
        if (variable != null) {
            return (int) (variable.f595j + 0.5f);
        }
        return 0;
    }

    /* renamed from: f */
    public void mo4029f() throws Exception {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f562e++;
        }
        if (this.f547i) {
            C0200f fVar2 = f540b;
            if (fVar2 != null) {
                fVar2.f574q++;
            }
            boolean fullySolved = true;
            int i = 0;
            while (true) {
                if (i >= this.f550l) {
                    break;
                } else if (!this.f546h[i].f535e) {
                    fullySolved = false;
                    break;
                } else {
                    i++;
                }
            }
            if (!fullySolved) {
                mo4017a(this.f543e);
                return;
            }
            C0200f fVar3 = f540b;
            if (fVar3 != null) {
                fVar3.f573p++;
            }
            m1153h();
            return;
        }
        mo4017a(this.f543e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo4017a(C0199a goal) throws Exception {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f576s++;
            fVar.f577t = Math.max(fVar.f577t, (long) this.f549k);
            C0200f fVar2 = f540b;
            fVar2.f578u = Math.max(fVar2.f578u, (long) this.f550l);
        }
        m1151d((C0195b) goal);
        m1148b(goal);
        m1145a(goal, false);
        m1153h();
    }

    /* renamed from: d */
    private final void m1151d(C0195b row) {
        if (this.f550l > 0) {
            row.f534d.mo3820a(row, this.f546h);
            if (row.f534d.f319a == 0) {
                row.f535e = true;
            }
        }
    }

    /* renamed from: a */
    public void mo4015a(C0195b row) {
        if (row != null) {
            C0200f fVar = f540b;
            if (fVar != null) {
                fVar.f563f++;
                if (row.f535e) {
                    fVar.f564g++;
                }
            }
            if (this.f550l + 1 >= this.f551m || this.f549k + 1 >= this.f545g) {
                m1154i();
            }
            boolean added = false;
            if (!row.f535e) {
                m1151d(row);
                if (!row.mo4003c()) {
                    row.mo3992a();
                    if (row.mo3995a(this)) {
                        C0203i extra = mo4011a();
                        row.f531a = extra;
                        m1150c(row);
                        added = true;
                        this.f556r.mo3993a((C0199a) row);
                        m1145a(this.f556r, true);
                        if (extra.f593h == -1) {
                            if (row.f531a == extra) {
                                C0203i pivotCandidate = row.mo4002c(extra);
                                if (pivotCandidate != null) {
                                    C0200f fVar2 = f540b;
                                    if (fVar2 != null) {
                                        fVar2.f567j++;
                                    }
                                    row.mo4006d(pivotCandidate);
                                }
                            }
                            if (!row.f535e) {
                                row.f531a.mo4038c(row);
                            }
                            this.f550l--;
                        }
                    }
                    if (!row.mo3999b()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!added) {
                m1150c(row);
            }
        }
    }

    /* renamed from: c */
    private final void m1150c(C0195b row) {
        C0195b[] bVarArr = this.f546h;
        int i = this.f550l;
        if (bVarArr[i] != null) {
            this.f552n.f536a.mo4033a(bVarArr[i]);
        }
        C0195b[] bVarArr2 = this.f546h;
        int i2 = this.f550l;
        bVarArr2[i2] = row;
        C0203i iVar = row.f531a;
        iVar.f593h = i2;
        this.f550l = i2 + 1;
        iVar.mo4038c(row);
    }

    /* renamed from: a */
    private final int m1145a(C0199a goal, boolean b) {
        C0200f fVar = f540b;
        if (fVar != null) {
            fVar.f565h++;
        }
        boolean done = false;
        int tries = 0;
        for (int i = 0; i < this.f549k; i++) {
            this.f548j[i] = false;
        }
        while (!done) {
            C0200f fVar2 = f540b;
            if (fVar2 != null) {
                fVar2.f566i++;
            }
            tries++;
            if (tries >= this.f549k * 2) {
                return tries;
            }
            if (goal.getKey() != null) {
                this.f548j[goal.getKey().f592g] = true;
            }
            C0203i pivotCandidate = goal.mo3991a(this, this.f548j);
            if (pivotCandidate != null) {
                boolean[] zArr = this.f548j;
                int i2 = pivotCandidate.f592g;
                if (zArr[i2]) {
                    return tries;
                }
                zArr[i2] = true;
            }
            if (pivotCandidate != null) {
                float min = Float.MAX_VALUE;
                int pivotRowIndex = -1;
                for (int i3 = 0; i3 < this.f550l; i3++) {
                    C0195b current = this.f546h[i3];
                    if (current.f531a.f597l != C0204a.UNRESTRICTED && !current.f535e && current.mo4000b(pivotCandidate)) {
                        float a_j = current.f534d.mo3825b(pivotCandidate);
                        if (a_j < 0.0f) {
                            float value = (-current.f532b) / a_j;
                            if (value < min) {
                                min = value;
                                pivotRowIndex = i3;
                            }
                        }
                    }
                }
                if (pivotRowIndex > -1) {
                    C0195b pivotEquation = this.f546h[pivotRowIndex];
                    pivotEquation.f531a.f593h = -1;
                    C0200f fVar3 = f540b;
                    if (fVar3 != null) {
                        fVar3.f567j++;
                    }
                    pivotEquation.mo4006d(pivotCandidate);
                    C0203i iVar = pivotEquation.f531a;
                    iVar.f593h = pivotRowIndex;
                    iVar.mo4038c(pivotEquation);
                } else {
                    done = true;
                }
            } else {
                done = true;
            }
        }
        return tries;
    }

    /* renamed from: b */
    private int m1148b(C0199a goal) throws Exception {
        float f;
        int tries = 0;
        boolean infeasibleSystem = false;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.f550l) {
                break;
            }
            C0195b[] bVarArr = this.f546h;
            if (bVarArr[i].f531a.f597l != C0204a.UNRESTRICTED && bVarArr[i].f532b < 0.0f) {
                infeasibleSystem = true;
                break;
            }
            i++;
        }
        if (infeasibleSystem) {
            boolean done = false;
            tries = 0;
            while (!done) {
                C0200f fVar = f540b;
                if (fVar != null) {
                    fVar.f568k++;
                }
                tries++;
                float min = Float.MAX_VALUE;
                int strength = 0;
                int pivotRowIndex = -1;
                int pivotColumnIndex = -1;
                int i2 = 0;
                while (i2 < this.f550l) {
                    C0195b current = this.f546h[i2];
                    if (current.f531a.f597l != C0204a.UNRESTRICTED && !current.f535e && current.f532b < f) {
                        int j = 1;
                        while (j < this.f549k) {
                            C0203i candidate = this.f552n.f538c[j];
                            float a_j = current.f534d.mo3825b(candidate);
                            if (a_j > f) {
                                for (int k = 0; k < 7; k++) {
                                    float value = candidate.f596k[k] / a_j;
                                    if ((value < min && k == strength) || k > strength) {
                                        min = value;
                                        pivotRowIndex = i2;
                                        pivotColumnIndex = j;
                                        strength = k;
                                    }
                                }
                            }
                            j++;
                            f = 0.0f;
                        }
                    }
                    i2++;
                    f = 0.0f;
                }
                if (pivotRowIndex != -1) {
                    C0195b pivotEquation = this.f546h[pivotRowIndex];
                    pivotEquation.f531a.f593h = -1;
                    C0200f fVar2 = f540b;
                    if (fVar2 != null) {
                        fVar2.f567j++;
                    }
                    pivotEquation.mo4006d(this.f552n.f538c[pivotColumnIndex]);
                    C0203i iVar = pivotEquation.f531a;
                    iVar.f593h = pivotRowIndex;
                    iVar.mo4038c(pivotEquation);
                } else {
                    done = true;
                }
                if (tries > this.f549k / 2) {
                    done = true;
                }
                f = 0.0f;
            }
        }
        return tries;
    }

    /* renamed from: h */
    private void m1153h() {
        for (int i = 0; i < this.f550l; i++) {
            C0195b row = this.f546h[i];
            row.f531a.f595j = row.f532b;
        }
    }

    /* renamed from: d */
    public C0196c mo4028d() {
        return this.f552n;
    }

    /* renamed from: b */
    public void mo4024b(C0203i a, C0203i b, int margin, int strength) {
        C0195b row = mo4023b();
        C0203i slack = mo4026c();
        slack.f594i = 0;
        row.mo3989a(a, b, slack, margin);
        if (strength != 6) {
            mo4016a(row, (int) (-1.0f * row.f534d.mo3825b(slack)), strength);
        }
        mo4015a(row);
    }

    /* renamed from: a */
    public void mo4021a(C0203i a, C0203i b, boolean hasMatchConstraintWidgets) {
        C0195b row = mo4023b();
        C0203i slack = mo4026c();
        slack.f594i = 0;
        row.mo3989a(a, b, slack, 0);
        if (hasMatchConstraintWidgets) {
            mo4016a(row, (int) (-1.0f * row.f534d.mo3825b(slack)), 1);
        }
        mo4015a(row);
    }

    /* renamed from: c */
    public void mo4027c(C0203i a, C0203i b, int margin, int strength) {
        C0195b row = mo4023b();
        C0203i slack = mo4026c();
        slack.f594i = 0;
        row.mo3997b(a, b, slack, margin);
        if (strength != 6) {
            mo4016a(row, (int) (-1.0f * row.f534d.mo3825b(slack)), strength);
        }
        mo4015a(row);
    }

    /* renamed from: b */
    public void mo4025b(C0203i a, C0203i b, boolean hasMatchConstraintWidgets) {
        C0195b row = mo4023b();
        C0203i slack = mo4026c();
        slack.f594i = 0;
        row.mo3997b(a, b, slack, 0);
        if (hasMatchConstraintWidgets) {
            mo4016a(row, (int) (-1.0f * row.f534d.mo3825b(slack)), 1);
        }
        mo4015a(row);
    }

    /* renamed from: a */
    public void mo4019a(C0203i a, C0203i b, int m1, float bias, C0203i c, C0203i d, int m2, int strength) {
        int i = strength;
        C0195b row = mo4023b();
        row.mo3987a(a, b, m1, bias, c, d, m2);
        if (i != 6) {
            row.mo3984a(this, i);
        }
        mo4015a(row);
    }

    /* renamed from: a */
    public void mo4020a(C0203i a, C0203i b, C0203i c, C0203i d, float ratio, int strength) {
        C0195b row = mo4023b();
        row.mo3990a(a, b, c, d, ratio);
        if (strength != 6) {
            row.mo3984a(this, strength);
        }
        mo4015a(row);
    }

    /* renamed from: a */
    public C0195b mo4010a(C0203i a, C0203i b, int margin, int strength) {
        C0195b row = mo4023b();
        row.mo3986a(a, b, margin);
        if (strength != 6) {
            row.mo3984a(this, strength);
        }
        mo4015a(row);
        return row;
    }

    /* renamed from: a */
    public void mo4018a(C0203i a, int value) {
        int idx = a.f593h;
        if (a.f593h != -1) {
            C0195b row = this.f546h[idx];
            if (row.f535e) {
                row.f532b = (float) value;
            } else if (row.f534d.f319a == 0) {
                row.f535e = true;
                row.f532b = (float) value;
            } else {
                C0195b newRow = mo4023b();
                newRow.mo4001c(a, value);
                mo4015a(newRow);
            }
        } else {
            C0195b row2 = mo4023b();
            row2.mo3996b(a, value);
            mo4015a(row2);
        }
    }

    /* renamed from: a */
    public static C0195b m1146a(C0198e linearSystem, C0203i variableA, C0203i variableB, C0203i variableC, float percent, boolean withError) {
        C0195b row = linearSystem.mo4023b();
        if (withError) {
            linearSystem.m1149b(row);
        }
        row.mo3988a(variableA, variableB, variableC, percent);
        return row;
    }

    /* renamed from: a */
    public void mo4014a(C0180h widget, C0180h target, float angle, int radius) {
        C0180h hVar = widget;
        C0180h hVar2 = target;
        float f = angle;
        int i = radius;
        C0203i Al = mo4013a((Object) hVar.mo3858a(C0178c.LEFT));
        C0203i At = mo4013a((Object) hVar.mo3858a(C0178c.TOP));
        C0203i Ar = mo4013a((Object) hVar.mo3858a(C0178c.RIGHT));
        C0203i Ab = mo4013a((Object) hVar.mo3858a(C0178c.BOTTOM));
        C0203i Bl = mo4013a((Object) hVar2.mo3858a(C0178c.LEFT));
        C0203i Bt = mo4013a((Object) hVar2.mo3858a(C0178c.TOP));
        C0203i Br = mo4013a((Object) hVar2.mo3858a(C0178c.RIGHT));
        C0203i Bb = mo4013a((Object) hVar2.mo3858a(C0178c.BOTTOM));
        C0195b row = mo4023b();
        double sin = Math.sin((double) f);
        double d = (double) i;
        Double.isNaN(d);
        float angleComponent = (float) (sin * d);
        float f2 = angleComponent;
        row.mo3998b(At, Ab, Bt, Bb, angleComponent);
        mo4015a(row);
        C0195b row2 = mo4023b();
        double cos = Math.cos((double) f);
        double d2 = (double) i;
        Double.isNaN(d2);
        float angleComponent2 = (float) (cos * d2);
        float f3 = angleComponent2;
        row2.mo3998b(Al, Ar, Bl, Br, angleComponent2);
        mo4015a(row2);
    }
}
