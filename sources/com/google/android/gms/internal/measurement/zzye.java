package com.google.android.gms.internal.measurement;

public final class zzye implements Cloneable {

    /* renamed from: a */
    private static final C9989mb f30417a = new C9989mb();

    /* renamed from: b */
    private boolean f30418b;

    /* renamed from: c */
    private int[] f30419c;

    /* renamed from: d */
    private C9989mb[] f30420d;

    /* renamed from: e */
    private int f30421e;

    zzye() {
        this(10);
    }

    private zzye(int i) {
        this.f30418b = false;
        int b = m32612b(i);
        this.f30419c = new int[b];
        this.f30420d = new C9989mb[b];
        this.f30421e = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo32960a() {
        return this.f30421e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C9989mb mo32961a(int i) {
        return this.f30420d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzye)) {
            return false;
        }
        zzye zzye = (zzye) obj;
        int i = this.f30421e;
        if (i != zzye.f30421e) {
            return false;
        }
        int[] iArr = this.f30419c;
        int[] iArr2 = zzye.f30419c;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            C9989mb[] mbVarArr = this.f30420d;
            C9989mb[] mbVarArr2 = zzye.f30420d;
            int i3 = this.f30421e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!mbVarArr[i4].equals(mbVarArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f30421e; i2++) {
            i = (((i * 31) + this.f30419c[i2]) * 31) + this.f30420d[i2].hashCode();
        }
        return i;
    }

    /* renamed from: b */
    private static int m32612b(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.f30421e;
        zzye zzye = new zzye(i);
        System.arraycopy(this.f30419c, 0, zzye.f30419c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            C9989mb[] mbVarArr = this.f30420d;
            if (mbVarArr[i2] != null) {
                zzye.f30420d[i2] = (C9989mb) mbVarArr[i2].clone();
            }
        }
        zzye.f30421e = i;
        return zzye;
    }
}
