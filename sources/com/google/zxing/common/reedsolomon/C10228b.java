package com.google.zxing.common.reedsolomon;

/* renamed from: com.google.zxing.common.reedsolomon.b */
/* compiled from: GenericGFPoly */
final class C10228b {

    /* renamed from: a */
    private final C10227a f31023a;

    /* renamed from: b */
    private final int[] f31024b;

    C10228b(C10227a field, int[] coefficients) {
        if (coefficients.length != 0) {
            this.f31023a = field;
            int length = coefficients.length;
            int coefficientsLength = length;
            if (length <= 1 || coefficients[0] != 0) {
                this.f31024b = coefficients;
                return;
            }
            int firstNonZero = 1;
            while (firstNonZero < coefficientsLength && coefficients[firstNonZero] == 0) {
                firstNonZero++;
            }
            if (firstNonZero == coefficientsLength) {
                this.f31024b = new int[]{0};
                return;
            }
            this.f31024b = new int[(coefficientsLength - firstNonZero)];
            int[] iArr = this.f31024b;
            System.arraycopy(coefficients, firstNonZero, iArr, 0, iArr.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int[] mo33591a() {
        return this.f31024b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo33592b() {
        return this.f31024b.length - 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo33595c() {
        return this.f31024b[0] == 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo33588a(int degree) {
        int[] iArr = this.f31024b;
        return iArr[(iArr.length - 1) - degree];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10228b mo33590a(C10228b other) {
        if (!this.f31023a.equals(other.f31023a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo33595c()) {
            return other;
        } else {
            if (other.mo33595c()) {
                return this;
            }
            int[] smallerCoefficients = this.f31024b;
            int[] largerCoefficients = other.f31024b;
            if (smallerCoefficients.length > largerCoefficients.length) {
                int[] temp = smallerCoefficients;
                smallerCoefficients = largerCoefficients;
                largerCoefficients = temp;
            }
            int[] sumDiff = new int[largerCoefficients.length];
            int lengthDiff = largerCoefficients.length - smallerCoefficients.length;
            System.arraycopy(largerCoefficients, 0, sumDiff, 0, lengthDiff);
            for (int i = lengthDiff; i < largerCoefficients.length; i++) {
                sumDiff[i] = C10227a.m33345a(smallerCoefficients[i - lengthDiff], largerCoefficients[i]);
            }
            return new C10228b(this.f31023a, sumDiff);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C10228b mo33594c(C10228b other) {
        if (!this.f31023a.equals(other.f31023a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (mo33595c() || other.mo33595c()) {
            return this.f31023a.mo33583b();
        } else {
            int[] iArr = this.f31024b;
            int[] aCoefficients = iArr;
            int aLength = iArr.length;
            int[] iArr2 = other.f31024b;
            int[] bCoefficients = iArr2;
            int bLength = iArr2.length;
            int[] product = new int[((aLength + bLength) - 1)];
            for (int i = 0; i < aLength; i++) {
                int aCoeff = aCoefficients[i];
                for (int j = 0; j < bLength; j++) {
                    product[i + j] = C10227a.m33345a(product[i + j], this.f31023a.mo33586c(aCoeff, bCoefficients[j]));
                }
            }
            return new C10228b(this.f31023a, product);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10228b mo33589a(int degree, int coefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        } else if (coefficient == 0) {
            return this.f31023a.mo33583b();
        } else {
            int length = this.f31024b.length;
            int size = length;
            int[] product = new int[(length + degree)];
            for (int i = 0; i < size; i++) {
                product[i] = this.f31023a.mo33586c(this.f31024b[i], coefficient);
            }
            return new C10228b(this.f31023a, product);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10228b[] mo33593b(C10228b other) {
        if (!this.f31023a.equals(other.f31023a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (!other.mo33595c()) {
            C10228b quotient = this.f31023a.mo33583b();
            C10228b remainder = this;
            int inverseDenominatorLeadingTerm = this.f31023a.mo33582b(other.mo33588a(other.mo33592b()));
            while (remainder.mo33592b() >= other.mo33592b() && !remainder.mo33595c()) {
                int degreeDifference = remainder.mo33592b() - other.mo33592b();
                int scale = this.f31023a.mo33586c(remainder.mo33588a(remainder.mo33592b()), inverseDenominatorLeadingTerm);
                C10228b term = other.mo33589a(degreeDifference, scale);
                quotient = quotient.mo33590a(this.f31023a.mo33584b(degreeDifference, scale));
                remainder = remainder.mo33590a(term);
            }
            return new C10228b[]{quotient, remainder};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder(mo33592b() * 8);
        for (int degree = mo33592b(); degree >= 0; degree--) {
            int a = mo33588a(degree);
            int coefficient = a;
            if (a != 0) {
                if (coefficient < 0) {
                    result.append(" - ");
                    coefficient = -coefficient;
                } else if (result.length() > 0) {
                    result.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int c = this.f31023a.mo33585c(coefficient);
                    int alphaPower = c;
                    if (c == 0) {
                        result.append('1');
                    } else if (alphaPower == 1) {
                        result.append('a');
                    } else {
                        result.append("a^");
                        result.append(alphaPower);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        result.append('x');
                    } else {
                        result.append("x^");
                        result.append(degree);
                    }
                }
            }
        }
        return result.toString();
    }
}
