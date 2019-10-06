package android.support.constraint.p034a;

import android.support.constraint.p034a.C0203i.C0204a;
import java.util.Arrays;

/* renamed from: android.support.constraint.a.a */
/* compiled from: ArrayLinkedVariables */
public class C0169a {

    /* renamed from: a */
    int f319a = 0;

    /* renamed from: b */
    private final C0195b f320b;

    /* renamed from: c */
    private final C0196c f321c;

    /* renamed from: d */
    private int f322d = 8;

    /* renamed from: e */
    private C0203i f323e = null;

    /* renamed from: f */
    private int[] f324f;

    /* renamed from: g */
    private int[] f325g;

    /* renamed from: h */
    private float[] f326h;

    /* renamed from: i */
    private int f327i;

    /* renamed from: j */
    private int f328j;

    /* renamed from: k */
    private boolean f329k;

    C0169a(C0195b arrayRow, C0196c cache) {
        int i = this.f322d;
        this.f324f = new int[i];
        this.f325g = new int[i];
        this.f326h = new float[i];
        this.f327i = -1;
        this.f328j = -1;
        this.f329k = false;
        this.f320b = arrayRow;
        this.f321c = cache;
    }

    /* renamed from: a */
    public final void mo3821a(C0203i variable, float value) {
        if (value == 0.0f) {
            mo3813a(variable, true);
        } else if (this.f327i == -1) {
            this.f327i = 0;
            float[] fArr = this.f326h;
            int i = this.f327i;
            fArr[i] = value;
            this.f324f[i] = variable.f592g;
            this.f325g[i] = -1;
            variable.f600o++;
            variable.mo4034a(this.f320b);
            this.f319a++;
            if (!this.f329k) {
                this.f328j++;
                int i2 = this.f328j;
                int[] iArr = this.f324f;
                if (i2 >= iArr.length) {
                    this.f329k = true;
                    this.f328j = iArr.length - 1;
                }
            }
        } else {
            int current = this.f327i;
            int previous = -1;
            int counter = 0;
            while (current != -1 && counter < this.f319a) {
                int[] iArr2 = this.f324f;
                int i3 = iArr2[current];
                int i4 = variable.f592g;
                if (i3 == i4) {
                    this.f326h[current] = value;
                    return;
                }
                if (iArr2[current] < i4) {
                    previous = current;
                }
                current = this.f325g[current];
                counter++;
            }
            int i5 = this.f328j;
            int availableIndice = i5 + 1;
            if (this.f329k) {
                int[] iArr3 = this.f324f;
                if (iArr3[i5] == -1) {
                    availableIndice = this.f328j;
                } else {
                    availableIndice = iArr3.length;
                }
            }
            int[] iArr4 = this.f324f;
            if (availableIndice >= iArr4.length && this.f319a < iArr4.length) {
                int i6 = 0;
                while (true) {
                    int[] iArr5 = this.f324f;
                    if (i6 >= iArr5.length) {
                        break;
                    } else if (iArr5[i6] == -1) {
                        availableIndice = i6;
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            int[] iArr6 = this.f324f;
            if (availableIndice >= iArr6.length) {
                availableIndice = iArr6.length;
                this.f322d *= 2;
                this.f329k = false;
                this.f328j = availableIndice - 1;
                this.f326h = Arrays.copyOf(this.f326h, this.f322d);
                this.f324f = Arrays.copyOf(this.f324f, this.f322d);
                this.f325g = Arrays.copyOf(this.f325g, this.f322d);
            }
            this.f324f[availableIndice] = variable.f592g;
            this.f326h[availableIndice] = value;
            if (previous != -1) {
                int[] iArr7 = this.f325g;
                iArr7[availableIndice] = iArr7[previous];
                iArr7[previous] = availableIndice;
            } else {
                this.f325g[availableIndice] = this.f327i;
                this.f327i = availableIndice;
            }
            variable.f600o++;
            variable.mo4034a(this.f320b);
            this.f319a++;
            if (!this.f329k) {
                this.f328j++;
            }
            if (this.f319a >= this.f324f.length) {
                this.f329k = true;
            }
            int i7 = this.f328j;
            int[] iArr8 = this.f324f;
            if (i7 >= iArr8.length) {
                this.f329k = true;
                this.f328j = iArr8.length - 1;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo3822a(C0203i variable, float value, boolean removeFromDefinition) {
        if (value != 0.0f) {
            if (this.f327i == -1) {
                this.f327i = 0;
                float[] fArr = this.f326h;
                int i = this.f327i;
                fArr[i] = value;
                this.f324f[i] = variable.f592g;
                this.f325g[i] = -1;
                variable.f600o++;
                variable.mo4034a(this.f320b);
                this.f319a++;
                if (!this.f329k) {
                    this.f328j++;
                    int i2 = this.f328j;
                    int[] iArr = this.f324f;
                    if (i2 >= iArr.length) {
                        this.f329k = true;
                        this.f328j = iArr.length - 1;
                    }
                }
                return;
            }
            int current = this.f327i;
            int previous = -1;
            int counter = 0;
            while (current != -1 && counter < this.f319a) {
                int[] iArr2 = this.f324f;
                int idx = iArr2[current];
                int i3 = variable.f592g;
                if (idx == i3) {
                    float[] fArr2 = this.f326h;
                    fArr2[current] = fArr2[current] + value;
                    if (fArr2[current] == 0.0f) {
                        if (current == this.f327i) {
                            this.f327i = this.f325g[current];
                        } else {
                            int[] iArr3 = this.f325g;
                            iArr3[previous] = iArr3[current];
                        }
                        if (removeFromDefinition) {
                            variable.mo4037b(this.f320b);
                        }
                        if (this.f329k) {
                            this.f328j = current;
                        }
                        variable.f600o--;
                        this.f319a--;
                    }
                    return;
                }
                if (iArr2[current] < i3) {
                    previous = current;
                }
                current = this.f325g[current];
                counter++;
            }
            int i4 = this.f328j;
            int availableIndice = i4 + 1;
            if (this.f329k) {
                int[] iArr4 = this.f324f;
                if (iArr4[i4] == -1) {
                    availableIndice = this.f328j;
                } else {
                    availableIndice = iArr4.length;
                }
            }
            int[] iArr5 = this.f324f;
            if (availableIndice >= iArr5.length && this.f319a < iArr5.length) {
                int i5 = 0;
                while (true) {
                    int[] iArr6 = this.f324f;
                    if (i5 >= iArr6.length) {
                        break;
                    } else if (iArr6[i5] == -1) {
                        availableIndice = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            int[] iArr7 = this.f324f;
            if (availableIndice >= iArr7.length) {
                availableIndice = iArr7.length;
                this.f322d *= 2;
                this.f329k = false;
                this.f328j = availableIndice - 1;
                this.f326h = Arrays.copyOf(this.f326h, this.f322d);
                this.f324f = Arrays.copyOf(this.f324f, this.f322d);
                this.f325g = Arrays.copyOf(this.f325g, this.f322d);
            }
            this.f324f[availableIndice] = variable.f592g;
            this.f326h[availableIndice] = value;
            if (previous != -1) {
                int[] iArr8 = this.f325g;
                iArr8[availableIndice] = iArr8[previous];
                iArr8[previous] = availableIndice;
            } else {
                this.f325g[availableIndice] = this.f327i;
                this.f327i = availableIndice;
            }
            variable.f600o++;
            variable.mo4034a(this.f320b);
            this.f319a++;
            if (!this.f329k) {
                this.f328j++;
            }
            int i6 = this.f328j;
            int[] iArr9 = this.f324f;
            if (i6 >= iArr9.length) {
                this.f329k = true;
                this.f328j = iArr9.length - 1;
            }
        }
    }

    /* renamed from: a */
    public final float mo3813a(C0203i variable, boolean removeFromDefinition) {
        if (this.f323e == variable) {
            this.f323e = null;
        }
        if (this.f327i == -1) {
            return 0.0f;
        }
        int current = this.f327i;
        int previous = -1;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            if (this.f324f[current] == variable.f592g) {
                if (current == this.f327i) {
                    this.f327i = this.f325g[current];
                } else {
                    int[] iArr = this.f325g;
                    iArr[previous] = iArr[current];
                }
                if (removeFromDefinition) {
                    variable.mo4037b(this.f320b);
                }
                variable.f600o--;
                this.f319a--;
                this.f324f[current] = -1;
                if (this.f329k) {
                    this.f328j = current;
                }
                return this.f326h[current];
            }
            previous = current;
            current = this.f325g[current];
            counter++;
        }
        return 0.0f;
    }

    /* renamed from: a */
    public final void mo3817a() {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            C0203i variable = this.f321c.f538c[this.f324f[current]];
            if (variable != null) {
                variable.mo4037b(this.f320b);
            }
            current = this.f325g[current];
            counter++;
        }
        this.f327i = -1;
        this.f328j = -1;
        this.f329k = false;
        this.f319a = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo3823a(C0203i variable) {
        if (this.f327i == -1) {
            return false;
        }
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            if (this.f324f[current] == variable.f592g) {
                return true;
            }
            current = this.f325g[current];
            counter++;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo3826b() {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            float[] fArr = this.f326h;
            fArr[current] = fArr[current] * -1.0f;
            current = this.f325g[current];
            counter++;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3818a(float amount) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            float[] fArr = this.f326h;
            fArr[current] = fArr[current] / amount;
            current = this.f325g[current];
            counter++;
        }
    }

    /* renamed from: a */
    private boolean m899a(C0203i variable, C0198e system) {
        return variable.f600o <= 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0203i mo3815a(C0198e system) {
        float f;
        C0198e eVar = system;
        C0203i restrictedCandidate = null;
        C0203i unrestrictedCandidate = null;
        float unrestrictedCandidateAmount = 0.0f;
        float restrictedCandidateAmount = 0.0f;
        boolean unrestrictedCandidateIsNew = false;
        boolean restrictedCandidateIsNew = false;
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            float[] fArr = this.f326h;
            float amount = fArr[current];
            C0203i variable = this.f321c.f538c[this.f324f[current]];
            if (amount < 0.0f) {
                if (amount > (-0.001f)) {
                    fArr[current] = 0.0f;
                    amount = 0.0f;
                    variable.mo4037b(this.f320b);
                    f = 0.0f;
                } else {
                    f = 0.0f;
                }
            } else if (amount < 0.001f) {
                f = 0.0f;
                fArr[current] = 0.0f;
                amount = 0.0f;
                variable.mo4037b(this.f320b);
            } else {
                f = 0.0f;
            }
            if (amount != f) {
                if (variable.f597l == C0204a.UNRESTRICTED) {
                    if (unrestrictedCandidate == null) {
                        unrestrictedCandidate = variable;
                        unrestrictedCandidateAmount = amount;
                        unrestrictedCandidateIsNew = m899a(variable, eVar);
                    } else if (unrestrictedCandidateAmount > amount) {
                        unrestrictedCandidate = variable;
                        unrestrictedCandidateAmount = amount;
                        unrestrictedCandidateIsNew = m899a(variable, eVar);
                    } else if (!unrestrictedCandidateIsNew && m899a(variable, eVar)) {
                        unrestrictedCandidate = variable;
                        unrestrictedCandidateAmount = amount;
                        unrestrictedCandidateIsNew = true;
                    }
                } else if (unrestrictedCandidate == null && amount < 0.0f) {
                    if (restrictedCandidate == null) {
                        restrictedCandidate = variable;
                        restrictedCandidateAmount = amount;
                        restrictedCandidateIsNew = m899a(variable, eVar);
                    } else if (restrictedCandidateAmount > amount) {
                        restrictedCandidate = variable;
                        restrictedCandidateAmount = amount;
                        restrictedCandidateIsNew = m899a(variable, eVar);
                    } else if (!restrictedCandidateIsNew && m899a(variable, eVar)) {
                        restrictedCandidate = variable;
                        restrictedCandidateAmount = amount;
                        restrictedCandidateIsNew = true;
                    }
                }
            }
            current = this.f325g[current];
            counter++;
        }
        if (unrestrictedCandidate != null) {
            return unrestrictedCandidate;
        }
        return restrictedCandidate;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo3819a(C0195b self, C0195b definition, boolean removeFromDefinition) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            int i = this.f324f[current];
            C0203i iVar = definition.f531a;
            if (i == iVar.f592g) {
                float value = this.f326h[current];
                mo3813a(iVar, removeFromDefinition);
                C0169a definitionVariables = definition.f534d;
                int definitionCurrent = definitionVariables.f327i;
                int definitionCounter = 0;
                while (definitionCurrent != -1 && definitionCounter < definitionVariables.f319a) {
                    mo3822a(this.f321c.f538c[definitionVariables.f324f[definitionCurrent]], definitionVariables.f326h[definitionCurrent] * value, removeFromDefinition);
                    definitionCurrent = definitionVariables.f325g[definitionCurrent];
                    definitionCounter++;
                }
                self.f532b += definition.f532b * value;
                if (removeFromDefinition) {
                    definition.f531a.mo4037b(self);
                }
                current = this.f327i;
                counter = 0;
            } else {
                current = this.f325g[current];
                counter++;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3820a(C0195b self, C0195b[] rows) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            C0203i variable = this.f321c.f538c[this.f324f[current]];
            if (variable.f593h != -1) {
                float value = this.f326h[current];
                mo3813a(variable, true);
                C0195b definition = rows[variable.f593h];
                if (!definition.f535e) {
                    C0169a definitionVariables = definition.f534d;
                    int definitionCurrent = definitionVariables.f327i;
                    int definitionCounter = 0;
                    while (definitionCurrent != -1 && definitionCounter < definitionVariables.f319a) {
                        mo3822a(this.f321c.f538c[definitionVariables.f324f[definitionCurrent]], definitionVariables.f326h[definitionCurrent] * value, true);
                        definitionCurrent = definitionVariables.f325g[definitionCurrent];
                        definitionCounter++;
                    }
                }
                self.f532b += definition.f532b * value;
                definition.f531a.mo4037b(self);
                current = this.f327i;
                counter = 0;
            } else {
                current = this.f325g[current];
                counter++;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0203i mo3816a(boolean[] avoid, C0203i exclude) {
        int current = this.f327i;
        int counter = 0;
        C0203i pivot = null;
        float value = 0.0f;
        while (current != -1 && counter < this.f319a) {
            if (this.f326h[current] < 0.0f) {
                C0203i v = this.f321c.f538c[this.f324f[current]];
                if ((avoid == null || !avoid[v.f592g]) && v != exclude) {
                    C0204a aVar = v.f597l;
                    if (aVar == C0204a.SLACK || aVar == C0204a.ERROR) {
                        float currentValue = this.f326h[current];
                        if (currentValue < value) {
                            value = currentValue;
                            pivot = v;
                        }
                    }
                }
            }
            current = this.f325g[current];
            counter++;
        }
        return pivot;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C0203i mo3814a(int index) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            if (counter == index) {
                return this.f321c.f538c[this.f324f[current]];
            }
            current = this.f325g[current];
            counter++;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final float mo3824b(int index) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            if (counter == index) {
                return this.f326h[current];
            }
            current = this.f325g[current];
            counter++;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public final float mo3825b(C0203i v) {
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            if (this.f324f[current] == v.f592g) {
                return this.f326h[current];
            }
            current = this.f325g[current];
            counter++;
        }
        return 0.0f;
    }

    public String toString() {
        String result = "";
        int current = this.f327i;
        int counter = 0;
        while (current != -1 && counter < this.f319a) {
            StringBuilder sb = new StringBuilder();
            sb.append(result);
            sb.append(" -> ");
            String result2 = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(result2);
            sb2.append(this.f326h[current]);
            sb2.append(" : ");
            String result3 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(result3);
            sb3.append(this.f321c.f538c[this.f324f[current]]);
            result = sb3.toString();
            current = this.f325g[current];
            counter++;
        }
        return result;
    }
}
