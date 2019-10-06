package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.C0200f;
import android.support.constraint.p034a.C0203i;
import android.support.constraint.p034a.p035a.C0175f.C0178c;

/* renamed from: android.support.constraint.a.a.p */
/* compiled from: ResolutionAnchor */
public class C0189p extends C0191r {

    /* renamed from: c */
    C0175f f504c;

    /* renamed from: d */
    float f505d;

    /* renamed from: e */
    C0189p f506e;

    /* renamed from: f */
    float f507f;

    /* renamed from: g */
    C0189p f508g;

    /* renamed from: h */
    float f509h;

    /* renamed from: i */
    int f510i = 0;

    /* renamed from: j */
    private C0189p f511j;

    /* renamed from: k */
    private float f512k;

    /* renamed from: l */
    private C0190q f513l = null;

    /* renamed from: m */
    private int f514m = 1;

    /* renamed from: n */
    private C0190q f515n = null;

    /* renamed from: o */
    private int f516o = 1;

    public C0189p(C0175f anchor) {
        this.f504c = anchor;
    }

    public String toString() {
        if (this.f519b == 1) {
            String str = ", RESOLVED: ";
            String str2 = "[";
            if (this.f508g == this) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(this.f504c);
                sb.append(str);
                sb.append(this.f509h);
                sb.append("]  type: ");
                sb.append(mo3956a(this.f510i));
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f504c);
            sb2.append(str);
            sb2.append(this.f508g);
            sb2.append(":");
            sb2.append(this.f509h);
            sb2.append("] type: ");
            sb2.append(mo3956a(this.f510i));
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("{ ");
        sb3.append(this.f504c);
        sb3.append(" UNRESOLVED} type: ");
        sb3.append(mo3956a(this.f510i));
        return sb3.toString();
    }

    /* renamed from: a */
    public void mo3958a(C0189p target, float offset) {
        if (this.f519b == 0 || !(this.f508g == target || this.f509h == offset)) {
            this.f508g = target;
            this.f509h = offset;
            if (this.f519b == 1) {
                mo3974b();
            }
            mo3972a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo3956a(int type) {
        if (type == 1) {
            return "DIRECT";
        }
        if (type == 2) {
            return "CENTER";
        }
        if (type == 3) {
            return "MATCH";
        }
        if (type == 4) {
            return "CHAIN";
        }
        if (type == 5) {
            return "BARRIER";
        }
        return "UNCONNECTED";
    }

    /* renamed from: e */
    public void mo3966e() {
        float distance;
        float distance2;
        float percent;
        boolean isEndAnchor = true;
        if (this.f519b != 1 && this.f510i != 4) {
            C0190q qVar = this.f513l;
            if (qVar != null) {
                if (qVar.f519b == 1) {
                    this.f507f = ((float) this.f514m) * qVar.f517c;
                } else {
                    return;
                }
            }
            C0190q qVar2 = this.f515n;
            if (qVar2 != null) {
                if (qVar2.f519b == 1) {
                    this.f512k = ((float) this.f516o) * qVar2.f517c;
                } else {
                    return;
                }
            }
            if (this.f510i == 1) {
                C0189p pVar = this.f506e;
                if (pVar == null || pVar.f519b == 1) {
                    C0189p pVar2 = this.f506e;
                    if (pVar2 == null) {
                        this.f508g = this;
                        this.f509h = this.f507f;
                    } else {
                        this.f508g = pVar2.f508g;
                        this.f509h = pVar2.f509h + this.f507f;
                    }
                    mo3972a();
                }
            }
            if (this.f510i == 2) {
                C0189p pVar3 = this.f506e;
                if (pVar3 != null && pVar3.f519b == 1) {
                    C0189p pVar4 = this.f511j;
                    if (pVar4 != null) {
                        C0189p pVar5 = pVar4.f506e;
                        if (pVar5 != null && pVar5.f519b == 1) {
                            if (C0198e.m1152e() != null) {
                                C0200f e = C0198e.m1152e();
                                e.f579v++;
                            }
                            this.f508g = this.f506e.f508g;
                            C0189p pVar6 = this.f511j;
                            pVar6.f508g = pVar6.f506e.f508g;
                            C0178c cVar = this.f504c.f353c;
                            if (!(cVar == C0178c.RIGHT || cVar == C0178c.BOTTOM)) {
                                isEndAnchor = false;
                            }
                            if (isEndAnchor) {
                                distance = this.f506e.f509h - this.f511j.f506e.f509h;
                            } else {
                                distance = this.f511j.f506e.f509h - this.f506e.f509h;
                            }
                            C0175f fVar = this.f504c;
                            C0178c cVar2 = fVar.f353c;
                            if (cVar2 == C0178c.LEFT || cVar2 == C0178c.RIGHT) {
                                distance2 = distance - ((float) this.f504c.f352b.mo3920s());
                                percent = this.f504c.f352b.f407aa;
                            } else {
                                distance2 = distance - ((float) fVar.f352b.mo3900i());
                                percent = this.f504c.f352b.f409ba;
                            }
                            int margin = this.f504c.mo3841b();
                            int oppositeMargin = this.f511j.f504c.mo3841b();
                            if (this.f504c.mo3846g() == this.f511j.f504c.mo3846g()) {
                                percent = 0.5f;
                                margin = 0;
                                oppositeMargin = 0;
                            }
                            float distance3 = (distance2 - ((float) margin)) - ((float) oppositeMargin);
                            if (isEndAnchor) {
                                C0189p pVar7 = this.f511j;
                                pVar7.f509h = pVar7.f506e.f509h + ((float) oppositeMargin) + (distance3 * percent);
                                this.f509h = (this.f506e.f509h - ((float) margin)) - ((1.0f - percent) * distance3);
                            } else {
                                this.f509h = this.f506e.f509h + ((float) margin) + (distance3 * percent);
                                C0189p pVar8 = this.f511j;
                                pVar8.f509h = (pVar8.f506e.f509h - ((float) oppositeMargin)) - ((1.0f - percent) * distance3);
                            }
                            mo3972a();
                            this.f511j.mo3972a();
                        }
                    }
                }
            }
            if (this.f510i == 3) {
                C0189p pVar9 = this.f506e;
                if (pVar9 != null && pVar9.f519b == 1) {
                    C0189p pVar10 = this.f511j;
                    if (pVar10 != null) {
                        C0189p pVar11 = pVar10.f506e;
                        if (pVar11 != null && pVar11.f519b == 1) {
                            if (C0198e.m1152e() != null) {
                                C0200f e2 = C0198e.m1152e();
                                e2.f580w++;
                            }
                            C0189p pVar12 = this.f506e;
                            this.f508g = pVar12.f508g;
                            C0189p pVar13 = this.f511j;
                            C0189p pVar14 = pVar13.f506e;
                            pVar13.f508g = pVar14.f508g;
                            this.f509h = pVar12.f509h + this.f507f;
                            pVar13.f509h = pVar14.f509h + pVar13.f507f;
                            mo3972a();
                            this.f511j.mo3972a();
                        }
                    }
                }
            }
            if (this.f510i == 5) {
                this.f504c.f352b.mo3829G();
            }
        }
    }

    /* renamed from: b */
    public void mo3962b(int type) {
        this.f510i = type;
    }

    /* renamed from: d */
    public void mo3965d() {
        super.mo3965d();
        this.f506e = null;
        this.f507f = 0.0f;
        this.f513l = null;
        this.f514m = 1;
        this.f515n = null;
        this.f516o = 1;
        this.f508g = null;
        this.f509h = 0.0f;
        this.f505d = 0.0f;
        this.f511j = null;
        this.f512k = 0.0f;
        this.f510i = 0;
    }

    /* renamed from: g */
    public void mo3968g() {
        C0175f targetAnchor = this.f504c.mo3846g();
        if (targetAnchor != null) {
            if (targetAnchor.mo3846g() == this.f504c) {
                this.f510i = 4;
                targetAnchor.mo3843d().f510i = 4;
            }
            int margin = this.f504c.mo3841b();
            C0178c cVar = this.f504c.f353c;
            if (cVar == C0178c.RIGHT || cVar == C0178c.BOTTOM) {
                margin = -margin;
            }
            mo3959a(targetAnchor.mo3843d(), margin);
        }
    }

    /* renamed from: a */
    public void mo3957a(int type, C0189p node, int offset) {
        this.f510i = type;
        this.f506e = node;
        this.f507f = (float) offset;
        this.f506e.mo3973a(this);
    }

    /* renamed from: a */
    public void mo3959a(C0189p node, int offset) {
        this.f506e = node;
        this.f507f = (float) offset;
        this.f506e.mo3973a(this);
    }

    /* renamed from: a */
    public void mo3960a(C0189p node, int multiplier, C0190q dimension) {
        this.f506e = node;
        this.f506e.mo3973a(this);
        this.f513l = dimension;
        this.f514m = multiplier;
        this.f513l.mo3973a(this);
    }

    /* renamed from: b */
    public void mo3963b(C0189p opposite, float oppositeOffset) {
        this.f511j = opposite;
        this.f512k = oppositeOffset;
    }

    /* renamed from: b */
    public void mo3964b(C0189p opposite, int multiplier, C0190q dimension) {
        this.f511j = opposite;
        this.f515n = dimension;
        this.f516o = multiplier;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3961a(C0198e system) {
        C0203i sv = this.f504c.mo3844e();
        C0189p pVar = this.f508g;
        if (pVar == null) {
            system.mo4018a(sv, (int) (this.f509h + 0.5f));
        } else {
            system.mo4010a(sv, system.mo4013a((Object) pVar.f504c), (int) (this.f509h + 0.5f), 6);
        }
    }

    /* renamed from: f */
    public float mo3967f() {
        return this.f509h;
    }
}
