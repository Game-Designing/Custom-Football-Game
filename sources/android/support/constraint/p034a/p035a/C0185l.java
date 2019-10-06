package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.C0203i;
import android.support.constraint.p034a.p035a.C0175f.C0178c;
import android.support.constraint.p034a.p035a.C0180h.C0181a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.l */
/* compiled from: Guideline */
public class C0185l extends C0180h {

    /* renamed from: Aa */
    private boolean f492Aa = false;

    /* renamed from: Ba */
    private int f493Ba = 0;

    /* renamed from: Ca */
    private C0188o f494Ca = new C0188o();

    /* renamed from: Da */
    private int f495Da = 8;

    /* renamed from: va */
    protected float f496va = -1.0f;

    /* renamed from: wa */
    protected int f497wa = -1;

    /* renamed from: xa */
    protected int f498xa = -1;

    /* renamed from: ya */
    private C0175f f499ya = this.f449w;

    /* renamed from: za */
    private int f500za = 0;

    public C0185l() {
        this.f385E.clear();
        this.f385E.add(this.f499ya);
        int count = this.f384D.length;
        for (int i = 0; i < count; i++) {
            this.f384D[i] = this.f499ya;
        }
    }

    /* renamed from: a */
    public boolean mo3832a() {
        return true;
    }

    /* renamed from: v */
    public void mo3954v(int orientation) {
        if (this.f500za != orientation) {
            this.f500za = orientation;
            this.f385E.clear();
            if (this.f500za == 1) {
                this.f499ya = this.f448v;
            } else {
                this.f499ya = this.f449w;
            }
            this.f385E.add(this.f499ya);
            int count = this.f384D.length;
            for (int i = 0; i < count; i++) {
                this.f384D[i] = this.f499ya;
            }
        }
    }

    /* renamed from: J */
    public int mo3951J() {
        return this.f500za;
    }

    /* renamed from: a */
    public C0175f mo3858a(C0178c anchorType) {
        switch (C0184k.f491a[anchorType.ordinal()]) {
            case 1:
            case 2:
                if (this.f500za == 1) {
                    return this.f499ya;
                }
                break;
            case 3:
            case 4:
                if (this.f500za == 0) {
                    return this.f499ya;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(anchorType.name());
    }

    /* renamed from: b */
    public ArrayList<C0175f> mo3874b() {
        return this.f385E;
    }

    /* renamed from: e */
    public void mo3952e(float value) {
        if (value > -1.0f) {
            this.f496va = value;
            this.f497wa = -1;
            this.f498xa = -1;
        }
    }

    /* renamed from: t */
    public void mo3834t(int value) {
        if (value > -1) {
            this.f496va = -1.0f;
            this.f497wa = value;
            this.f498xa = -1;
        }
    }

    /* renamed from: u */
    public void mo3953u(int value) {
        if (value > -1) {
            this.f496va = -1.0f;
            this.f497wa = -1;
            this.f498xa = value;
        }
    }

    /* renamed from: a */
    public void mo3830a(int optimizationLevel) {
        C0180h constraintWidgetContainer = mo3904k();
        if (constraintWidgetContainer != null) {
            if (mo3951J() == 1) {
                this.f449w.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), 0);
                this.f451y.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), 0);
                if (this.f497wa != -1) {
                    this.f448v.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), this.f497wa);
                    this.f450x.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), this.f497wa);
                } else if (this.f498xa != -1) {
                    this.f448v.mo3843d().mo3957a(1, constraintWidgetContainer.f450x.mo3843d(), -this.f498xa);
                    this.f450x.mo3843d().mo3957a(1, constraintWidgetContainer.f450x.mo3843d(), -this.f498xa);
                } else if (this.f496va != -1.0f && constraintWidgetContainer.mo3902j() == C0181a.FIXED) {
                    int position = (int) (((float) constraintWidgetContainer.f388H) * this.f496va);
                    this.f448v.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), position);
                    this.f450x.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), position);
                }
            } else {
                this.f448v.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), 0);
                this.f450x.mo3843d().mo3957a(1, constraintWidgetContainer.f448v.mo3843d(), 0);
                if (this.f497wa != -1) {
                    this.f449w.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), this.f497wa);
                    this.f451y.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), this.f497wa);
                } else if (this.f498xa != -1) {
                    this.f449w.mo3843d().mo3957a(1, constraintWidgetContainer.f451y.mo3843d(), -this.f498xa);
                    this.f451y.mo3843d().mo3957a(1, constraintWidgetContainer.f451y.mo3843d(), -this.f498xa);
                } else if (this.f496va != -1.0f && constraintWidgetContainer.mo3916q() == C0181a.FIXED) {
                    int position2 = (int) (((float) constraintWidgetContainer.f389I) * this.f496va);
                    this.f449w.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), position2);
                    this.f451y.mo3843d().mo3957a(1, constraintWidgetContainer.f449w.mo3843d(), position2);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3831a(C0198e system) {
        C0182i parent = (C0182i) mo3904k();
        if (parent != null) {
            C0175f begin = parent.mo3858a(C0178c.LEFT);
            C0175f end = parent.mo3858a(C0178c.RIGHT);
            C0180h hVar = this.f387G;
            boolean z = true;
            boolean parentWrapContent = hVar != null && hVar.f386F[0] == C0181a.WRAP_CONTENT;
            if (this.f500za == 0) {
                begin = parent.mo3858a(C0178c.TOP);
                end = parent.mo3858a(C0178c.BOTTOM);
                C0180h hVar2 = this.f387G;
                if (hVar2 == null || hVar2.f386F[1] != C0181a.WRAP_CONTENT) {
                    z = false;
                }
                parentWrapContent = z;
            }
            if (this.f497wa != -1) {
                C0203i guide = system.mo4013a((Object) this.f499ya);
                system.mo4010a(guide, system.mo4013a((Object) begin), this.f497wa, 6);
                if (parentWrapContent) {
                    system.mo4024b(system.mo4013a((Object) end), guide, 0, 5);
                }
            } else if (this.f498xa != -1) {
                C0203i guide2 = system.mo4013a((Object) this.f499ya);
                C0203i parentRight = system.mo4013a((Object) end);
                system.mo4010a(guide2, parentRight, -this.f498xa, 6);
                if (parentWrapContent) {
                    system.mo4024b(guide2, system.mo4013a((Object) begin), 0, 5);
                    system.mo4024b(parentRight, guide2, 0, 5);
                }
            } else if (this.f496va != -1.0f) {
                system.mo4015a(C0198e.m1146a(system, system.mo4013a((Object) this.f499ya), system.mo4013a((Object) begin), system.mo4013a((Object) end), this.f496va, this.f492Aa));
            }
        }
    }

    /* renamed from: c */
    public void mo3886c(C0198e system) {
        if (mo3904k() != null) {
            int value = system.mo4022b((Object) this.f499ya);
            if (this.f500za == 1) {
                mo3919r(value);
                mo3921s(0);
                mo3897g(mo3904k().mo3900i());
                mo3913o(0);
            } else {
                mo3919r(0);
                mo3921s(value);
                mo3913o(mo3904k().mo3920s());
                mo3897g(0);
            }
        }
    }
}
