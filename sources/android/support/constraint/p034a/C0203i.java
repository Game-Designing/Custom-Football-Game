package android.support.constraint.p034a;

import java.util.Arrays;

/* renamed from: android.support.constraint.a.i */
/* compiled from: SolverVariable */
public class C0203i {

    /* renamed from: a */
    private static int f586a = 1;

    /* renamed from: b */
    private static int f587b = 1;

    /* renamed from: c */
    private static int f588c = 1;

    /* renamed from: d */
    private static int f589d = 1;

    /* renamed from: e */
    private static int f590e = 1;

    /* renamed from: f */
    private String f591f;

    /* renamed from: g */
    public int f592g = -1;

    /* renamed from: h */
    int f593h = -1;

    /* renamed from: i */
    public int f594i = 0;

    /* renamed from: j */
    public float f595j;

    /* renamed from: k */
    float[] f596k = new float[7];

    /* renamed from: l */
    C0204a f597l;

    /* renamed from: m */
    C0195b[] f598m = new C0195b[8];

    /* renamed from: n */
    int f599n = 0;

    /* renamed from: o */
    public int f600o = 0;

    /* renamed from: android.support.constraint.a.i$a */
    /* compiled from: SolverVariable */
    public enum C0204a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* renamed from: a */
    static void m1186a() {
        f587b++;
    }

    public C0203i(C0204a type, String prefix) {
        this.f597l = type;
    }

    /* renamed from: a */
    public final void mo4034a(C0195b row) {
        int i = 0;
        while (true) {
            int i2 = this.f599n;
            if (i >= i2) {
                C0195b[] bVarArr = this.f598m;
                if (i2 >= bVarArr.length) {
                    this.f598m = (C0195b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                C0195b[] bVarArr2 = this.f598m;
                int i3 = this.f599n;
                bVarArr2[i3] = row;
                this.f599n = i3 + 1;
                return;
            } else if (this.f598m[i] != row) {
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public final void mo4037b(C0195b row) {
        int count = this.f599n;
        for (int i = 0; i < count; i++) {
            if (this.f598m[i] == row) {
                for (int j = 0; j < (count - i) - 1; j++) {
                    C0195b[] bVarArr = this.f598m;
                    bVarArr[i + j] = bVarArr[i + j + 1];
                }
                this.f599n--;
                return;
            }
        }
    }

    /* renamed from: c */
    public final void mo4038c(C0195b definition) {
        int count = this.f599n;
        for (int i = 0; i < count; i++) {
            C0195b[] bVarArr = this.f598m;
            bVarArr[i].f534d.mo3819a(bVarArr[i], definition, false);
        }
        this.f599n = 0;
    }

    /* renamed from: b */
    public void mo4036b() {
        this.f591f = null;
        this.f597l = C0204a.UNKNOWN;
        this.f594i = 0;
        this.f592g = -1;
        this.f593h = -1;
        this.f595j = 0.0f;
        this.f599n = 0;
        this.f600o = 0;
    }

    /* renamed from: a */
    public void mo4035a(C0204a type, String prefix) {
        this.f597l = type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f591f);
        return sb.toString();
    }
}
