package android.support.constraint.p034a;

import android.support.constraint.p034a.C0203i.C0204a;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: android.support.constraint.a.b */
/* compiled from: ArrayRow */
public class C0195b implements C0199a {

    /* renamed from: a */
    C0203i f531a = null;

    /* renamed from: b */
    float f532b = 0.0f;

    /* renamed from: c */
    boolean f533c = false;

    /* renamed from: d */
    public final C0169a f534d;

    /* renamed from: e */
    boolean f535e = false;

    public C0195b(C0196c cache) {
        this.f534d = new C0169a(this, cache);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo3999b() {
        C0203i iVar = this.f531a;
        return iVar != null && (iVar.f597l == C0204a.UNRESTRICTED || this.f532b >= 0.0f);
    }

    public String toString() {
        return mo4007e();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo4007e() {
        String s;
        String s2;
        String s3 = "";
        if (this.f531a == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(s3);
            sb.append(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
            s = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(s3);
            sb2.append(this.f531a);
            s = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append(" = ");
        String s4 = sb3.toString();
        boolean addedVariable = false;
        if (this.f532b != 0.0f) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(s4);
            sb4.append(this.f532b);
            s4 = sb4.toString();
            addedVariable = true;
        }
        int count = this.f534d.f319a;
        for (int i = 0; i < count; i++) {
            C0203i v = this.f534d.mo3814a(i);
            if (v != null) {
                float amount = this.f534d.mo3824b(i);
                if (amount != 0.0f) {
                    String name = v.toString();
                    if (!addedVariable) {
                        if (amount < 0.0f) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(s2);
                            sb5.append("- ");
                            s2 = sb5.toString();
                            amount *= -1.0f;
                        }
                    } else if (amount > 0.0f) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(s2);
                        sb6.append(" + ");
                        s2 = sb6.toString();
                    } else {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(s2);
                        sb7.append(" - ");
                        s2 = sb7.toString();
                        amount *= -1.0f;
                    }
                    if (amount == 1.0f) {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(s2);
                        sb8.append(name);
                        s2 = sb8.toString();
                    } else {
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(s2);
                        sb9.append(amount);
                        sb9.append(" ");
                        sb9.append(name);
                        s2 = sb9.toString();
                    }
                    addedVariable = true;
                }
            }
        }
        if (addedVariable) {
            return s2;
        }
        StringBuilder sb10 = new StringBuilder();
        sb10.append(s2);
        sb10.append("0.0");
        return sb10.toString();
    }

    /* renamed from: d */
    public void mo4005d() {
        this.f531a = null;
        this.f534d.mo3817a();
        this.f532b = 0.0f;
        this.f535e = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo4000b(C0203i v) {
        return this.f534d.mo3823a(v);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C0195b mo3996b(C0203i variable, int value) {
        this.f531a = variable;
        variable.f595j = (float) value;
        this.f532b = (float) value;
        this.f535e = true;
        return this;
    }

    /* renamed from: c */
    public C0195b mo4001c(C0203i variable, int value) {
        if (value < 0) {
            this.f532b = (float) (value * -1);
            this.f534d.mo3821a(variable, 1.0f);
        } else {
            this.f532b = (float) value;
            this.f534d.mo3821a(variable, -1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public C0195b mo3986a(C0203i variableA, C0203i variableB, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f532b = (float) m;
        }
        if (!inverse) {
            this.f534d.mo3821a(variableA, -1.0f);
            this.f534d.mo3821a(variableB, 1.0f);
        } else {
            this.f534d.mo3821a(variableA, 1.0f);
            this.f534d.mo3821a(variableB, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0195b mo3985a(C0203i error, int sign) {
        this.f534d.mo3821a(error, (float) sign);
        return this;
    }

    /* renamed from: a */
    public C0195b mo3989a(C0203i variableA, C0203i variableB, C0203i slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f532b = (float) m;
        }
        if (!inverse) {
            this.f534d.mo3821a(variableA, -1.0f);
            this.f534d.mo3821a(variableB, 1.0f);
            this.f534d.mo3821a(slack, 1.0f);
        } else {
            this.f534d.mo3821a(variableA, 1.0f);
            this.f534d.mo3821a(variableB, -1.0f);
            this.f534d.mo3821a(slack, -1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public C0195b mo3997b(C0203i variableA, C0203i variableB, C0203i slack, int margin) {
        boolean inverse = false;
        if (margin != 0) {
            int m = margin;
            if (m < 0) {
                m *= -1;
                inverse = true;
            }
            this.f532b = (float) m;
        }
        if (!inverse) {
            this.f534d.mo3821a(variableA, -1.0f);
            this.f534d.mo3821a(variableB, 1.0f);
            this.f534d.mo3821a(slack, -1.0f);
        } else {
            this.f534d.mo3821a(variableA, 1.0f);
            this.f534d.mo3821a(variableB, -1.0f);
            this.f534d.mo3821a(slack, 1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public C0195b mo3983a(float currentWeight, float totalWeights, float nextWeight, C0203i variableStartA, C0203i variableEndA, C0203i variableStartB, C0203i variableEndB) {
        this.f532b = 0.0f;
        if (totalWeights == 0.0f || currentWeight == nextWeight) {
            this.f534d.mo3821a(variableStartA, 1.0f);
            this.f534d.mo3821a(variableEndA, -1.0f);
            this.f534d.mo3821a(variableEndB, 1.0f);
            this.f534d.mo3821a(variableStartB, -1.0f);
        } else if (currentWeight == 0.0f) {
            this.f534d.mo3821a(variableStartA, 1.0f);
            this.f534d.mo3821a(variableEndA, -1.0f);
        } else if (nextWeight == 0.0f) {
            this.f534d.mo3821a(variableStartB, 1.0f);
            this.f534d.mo3821a(variableEndB, -1.0f);
        } else {
            float w = (currentWeight / totalWeights) / (nextWeight / totalWeights);
            this.f534d.mo3821a(variableStartA, 1.0f);
            this.f534d.mo3821a(variableEndA, -1.0f);
            this.f534d.mo3821a(variableEndB, w);
            this.f534d.mo3821a(variableStartB, -w);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0195b mo3987a(C0203i variableA, C0203i variableB, int marginA, float bias, C0203i variableC, C0203i variableD, int marginB) {
        if (variableB == variableC) {
            this.f534d.mo3821a(variableA, 1.0f);
            this.f534d.mo3821a(variableD, 1.0f);
            this.f534d.mo3821a(variableB, -2.0f);
            return this;
        }
        if (bias == 0.5f) {
            this.f534d.mo3821a(variableA, 1.0f);
            this.f534d.mo3821a(variableB, -1.0f);
            this.f534d.mo3821a(variableC, -1.0f);
            this.f534d.mo3821a(variableD, 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.f532b = (float) ((-marginA) + marginB);
            }
        } else if (bias <= 0.0f) {
            this.f534d.mo3821a(variableA, -1.0f);
            this.f534d.mo3821a(variableB, 1.0f);
            this.f532b = (float) marginA;
        } else if (bias >= 1.0f) {
            this.f534d.mo3821a(variableC, -1.0f);
            this.f534d.mo3821a(variableD, 1.0f);
            this.f532b = (float) marginB;
        } else {
            this.f534d.mo3821a(variableA, (1.0f - bias) * 1.0f);
            this.f534d.mo3821a(variableB, (1.0f - bias) * -1.0f);
            this.f534d.mo3821a(variableC, -1.0f * bias);
            this.f534d.mo3821a(variableD, bias * 1.0f);
            if (marginA > 0 || marginB > 0) {
                this.f532b = (((float) (-marginA)) * (1.0f - bias)) + (((float) marginB) * bias);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0195b mo3984a(C0198e system, int strength) {
        this.f534d.mo3821a(system.mo4012a(strength, "ep"), 1.0f);
        this.f534d.mo3821a(system.mo4012a(strength, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0195b mo3988a(C0203i variableA, C0203i variableB, C0203i variableC, float percent) {
        this.f534d.mo3821a(variableA, -1.0f);
        this.f534d.mo3821a(variableB, 1.0f - percent);
        this.f534d.mo3821a(variableC, percent);
        return this;
    }

    /* renamed from: a */
    public C0195b mo3990a(C0203i variableA, C0203i variableB, C0203i variableC, C0203i variableD, float ratio) {
        this.f534d.mo3821a(variableA, -1.0f);
        this.f534d.mo3821a(variableB, 1.0f);
        this.f534d.mo3821a(variableC, ratio);
        this.f534d.mo3821a(variableD, -ratio);
        return this;
    }

    /* renamed from: b */
    public C0195b mo3998b(C0203i at, C0203i ab, C0203i bt, C0203i bb, float angleComponent) {
        this.f534d.mo3821a(bt, 0.5f);
        this.f534d.mo3821a(bb, 0.5f);
        this.f534d.mo3821a(at, -0.5f);
        this.f534d.mo3821a(ab, -0.5f);
        this.f532b = -angleComponent;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3992a() {
        float f = this.f532b;
        if (f < 0.0f) {
            this.f532b = f * -1.0f;
            this.f534d.mo3826b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo3995a(C0198e system) {
        boolean addedExtra = false;
        C0203i pivotCandidate = this.f534d.mo3815a(system);
        if (pivotCandidate == null) {
            addedExtra = true;
        } else {
            mo4006d(pivotCandidate);
        }
        if (this.f534d.f319a == 0) {
            this.f535e = true;
        }
        return addedExtra;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C0203i mo4002c(C0203i exclude) {
        return this.f534d.mo3816a((boolean[]) null, exclude);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo4006d(C0203i v) {
        C0203i iVar = this.f531a;
        if (iVar != null) {
            this.f534d.mo3821a(iVar, -1.0f);
            this.f531a = null;
        }
        float amount = this.f534d.mo3813a(v, true) * -1.0f;
        this.f531a = v;
        if (amount != 1.0f) {
            this.f532b /= amount;
            this.f534d.mo3818a(amount);
        }
    }

    /* renamed from: c */
    public boolean mo4003c() {
        return this.f531a == null && this.f532b == 0.0f && this.f534d.f319a == 0;
    }

    /* renamed from: a */
    public C0203i mo3991a(C0198e system, boolean[] avoid) {
        return this.f534d.mo3816a(avoid, (C0203i) null);
    }

    public void clear() {
        this.f534d.mo3817a();
        this.f531a = null;
        this.f532b = 0.0f;
    }

    /* renamed from: a */
    public void mo3993a(C0199a row) {
        if (row instanceof C0195b) {
            C0195b copiedRow = (C0195b) row;
            this.f531a = null;
            this.f534d.mo3817a();
            int i = 0;
            while (true) {
                C0169a aVar = copiedRow.f534d;
                if (i < aVar.f319a) {
                    this.f534d.mo3822a(aVar.mo3814a(i), copiedRow.f534d.mo3824b(i), true);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3994a(C0203i error) {
        float weight = 1.0f;
        int i = error.f594i;
        if (i == 1) {
            weight = 1.0f;
        } else if (i == 2) {
            weight = 1000.0f;
        } else if (i == 3) {
            weight = 1000000.0f;
        } else if (i == 4) {
            weight = 1.0E9f;
        } else if (i == 5) {
            weight = 1.0E12f;
        }
        this.f534d.mo3821a(error, weight);
    }

    public C0203i getKey() {
        return this.f531a;
    }
}
