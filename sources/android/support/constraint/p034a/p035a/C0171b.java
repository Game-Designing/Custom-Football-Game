package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.C0200f;
import android.support.constraint.p034a.C0203i;
import android.support.constraint.p034a.p035a.C0180h.C0181a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.b */
/* compiled from: Barrier */
public class C0171b extends C0186m {

    /* renamed from: xa */
    private int f330xa = 0;

    /* renamed from: ya */
    private ArrayList<C0189p> f331ya = new ArrayList<>(4);

    /* renamed from: za */
    private boolean f332za = true;

    /* renamed from: a */
    public boolean mo3832a() {
        return true;
    }

    /* renamed from: t */
    public void mo3834t(int barrierType) {
        this.f330xa = barrierType;
    }

    /* renamed from: c */
    public void mo3833c(boolean allowsGoneWidget) {
        this.f332za = allowsGoneWidget;
    }

    /* renamed from: F */
    public void mo3828F() {
        super.mo3828F();
        this.f331ya.clear();
    }

    /* renamed from: a */
    public void mo3830a(int optimizationLevel) {
        C0189p node;
        C0180h hVar = this.f387G;
        if (hVar != null && ((C0182i) hVar).mo3834t(2)) {
            int i = this.f330xa;
            if (i == 0) {
                node = this.f448v.mo3843d();
            } else if (i == 1) {
                node = this.f450x.mo3843d();
            } else if (i == 2) {
                node = this.f449w.mo3843d();
            } else if (i == 3) {
                node = this.f451y.mo3843d();
            } else {
                return;
            }
            node.mo3962b(5);
            int i2 = this.f330xa;
            if (i2 == 0 || i2 == 1) {
                this.f449w.mo3843d().mo3958a((C0189p) null, 0.0f);
                this.f451y.mo3843d().mo3958a((C0189p) null, 0.0f);
            } else {
                this.f448v.mo3843d().mo3958a((C0189p) null, 0.0f);
                this.f450x.mo3843d().mo3958a((C0189p) null, 0.0f);
            }
            this.f331ya.clear();
            for (int i3 = 0; i3 < this.f502wa; i3++) {
                C0180h widget = this.f501va[i3];
                if (this.f332za || widget.mo3832a()) {
                    C0189p depends = null;
                    int i4 = this.f330xa;
                    if (i4 == 0) {
                        depends = widget.f448v.mo3843d();
                    } else if (i4 == 1) {
                        depends = widget.f450x.mo3843d();
                    } else if (i4 == 2) {
                        depends = widget.f449w.mo3843d();
                    } else if (i4 == 3) {
                        depends = widget.f451y.mo3843d();
                    }
                    if (depends != null) {
                        this.f331ya.add(depends);
                        depends.mo3973a(node);
                    }
                }
            }
        }
    }

    /* renamed from: G */
    public void mo3829G() {
        C0189p node;
        float value = 0.0f;
        int i = this.f330xa;
        if (i == 0) {
            node = this.f448v.mo3843d();
            value = Float.MAX_VALUE;
        } else if (i == 1) {
            node = this.f450x.mo3843d();
        } else if (i == 2) {
            node = this.f449w.mo3843d();
            value = Float.MAX_VALUE;
        } else if (i == 3) {
            node = this.f451y.mo3843d();
        } else {
            return;
        }
        int count = this.f331ya.size();
        C0189p resolvedTarget = null;
        int i2 = 0;
        while (i2 < count) {
            C0189p n = (C0189p) this.f331ya.get(i2);
            if (n.f519b == 1) {
                int i3 = this.f330xa;
                if (i3 == 0 || i3 == 2) {
                    if (n.f509h < value) {
                        value = n.f509h;
                        resolvedTarget = n.f508g;
                    }
                } else if (n.f509h > value) {
                    value = n.f509h;
                    resolvedTarget = n.f508g;
                }
                i2++;
            } else {
                return;
            }
        }
        if (C0198e.m1152e() != null) {
            C0200f e = C0198e.m1152e();
            e.f582y++;
        }
        node.f508g = resolvedTarget;
        node.f509h = value;
        node.mo3972a();
        int i4 = this.f330xa;
        if (i4 == 0) {
            this.f450x.mo3843d().mo3958a(resolvedTarget, value);
        } else if (i4 == 1) {
            this.f448v.mo3843d().mo3958a(resolvedTarget, value);
        } else if (i4 == 2) {
            this.f451y.mo3843d().mo3958a(resolvedTarget, value);
        } else if (i4 == 3) {
            this.f449w.mo3843d().mo3958a(resolvedTarget, value);
        }
    }

    /* renamed from: a */
    public void mo3831a(C0198e system) {
        C0175f[] fVarArr;
        C0175f[] fVarArr2 = this.f384D;
        fVarArr2[0] = this.f448v;
        fVarArr2[2] = this.f449w;
        fVarArr2[1] = this.f450x;
        fVarArr2[3] = this.f451y;
        int i = 0;
        while (true) {
            fVarArr = this.f384D;
            if (i >= fVarArr.length) {
                break;
            }
            fVarArr[i].f360j = system.mo4013a((Object) fVarArr[i]);
            i++;
        }
        int i2 = this.f330xa;
        if (i2 >= 0 && i2 < 4) {
            C0175f position = fVarArr[i2];
            boolean hasMatchConstraintWidgets = false;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f502wa) {
                    break;
                }
                C0180h widget = this.f501va[i3];
                if (this.f332za || widget.mo3832a()) {
                    int i4 = this.f330xa;
                    if ((i4 != 0 && i4 != 1) || widget.mo3902j() != C0181a.MATCH_CONSTRAINT) {
                        int i5 = this.f330xa;
                        if ((i5 == 2 || i5 == 3) && widget.mo3916q() == C0181a.MATCH_CONSTRAINT) {
                            hasMatchConstraintWidgets = true;
                            break;
                        }
                    } else {
                        hasMatchConstraintWidgets = true;
                        break;
                    }
                }
                i3++;
            }
            int i6 = this.f330xa;
            if (i6 == 0 || i6 == 1) {
                if (mo3904k().mo3902j() == C0181a.WRAP_CONTENT) {
                    hasMatchConstraintWidgets = false;
                }
            } else if (mo3904k().mo3916q() == C0181a.WRAP_CONTENT) {
                hasMatchConstraintWidgets = false;
            }
            for (int i7 = 0; i7 < this.f502wa; i7++) {
                C0180h widget2 = this.f501va[i7];
                if (this.f332za || widget2.mo3832a()) {
                    C0203i target = system.mo4013a((Object) widget2.f384D[this.f330xa]);
                    C0175f[] fVarArr3 = widget2.f384D;
                    int i8 = this.f330xa;
                    fVarArr3[i8].f360j = target;
                    if (i8 == 0 || i8 == 2) {
                        system.mo4025b(position.f360j, target, hasMatchConstraintWidgets);
                    } else {
                        system.mo4021a(position.f360j, target, hasMatchConstraintWidgets);
                    }
                }
            }
            int i9 = this.f330xa;
            if (i9 == 0) {
                system.mo4010a(this.f450x.f360j, this.f448v.f360j, 0, 6);
                if (!hasMatchConstraintWidgets) {
                    system.mo4010a(this.f448v.f360j, this.f387G.f450x.f360j, 0, 5);
                }
            } else if (i9 == 1) {
                system.mo4010a(this.f448v.f360j, this.f450x.f360j, 0, 6);
                if (!hasMatchConstraintWidgets) {
                    system.mo4010a(this.f448v.f360j, this.f387G.f448v.f360j, 0, 5);
                }
            } else if (i9 == 2) {
                system.mo4010a(this.f451y.f360j, this.f449w.f360j, 0, 6);
                if (!hasMatchConstraintWidgets) {
                    system.mo4010a(this.f449w.f360j, this.f387G.f451y.f360j, 0, 5);
                }
            } else if (i9 == 3) {
                system.mo4010a(this.f449w.f360j, this.f451y.f360j, 0, 6);
                if (!hasMatchConstraintWidgets) {
                    system.mo4010a(this.f449w.f360j, this.f387G.f449w.f360j, 0, 5);
                }
            }
        }
    }
}
