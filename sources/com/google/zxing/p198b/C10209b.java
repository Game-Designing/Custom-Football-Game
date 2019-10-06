package com.google.zxing.p198b;

import java.util.Arrays;

/* renamed from: com.google.zxing.b.b */
/* compiled from: BitMatrix */
public final class C10209b implements Cloneable {

    /* renamed from: a */
    private final int f30929a;

    /* renamed from: b */
    private final int f30930b;

    /* renamed from: c */
    private final int f30931c;

    /* renamed from: d */
    private final int[] f30932d;

    public C10209b(int dimension) {
        this(dimension, dimension);
    }

    public C10209b(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f30929a = width;
        this.f30930b = height;
        this.f30931c = (width + 31) / 32;
        this.f30932d = new int[(this.f30931c * height)];
    }

    private C10209b(int width, int height, int rowSize, int[] bits) {
        this.f30929a = width;
        this.f30930b = height;
        this.f30931c = rowSize;
        this.f30932d = bits;
    }

    /* renamed from: a */
    public boolean mo33534a(int x, int y) {
        return ((this.f30932d[(this.f30931c * y) + (x / 32)] >>> (x & 31)) & 1) != 0;
    }

    /* renamed from: b */
    public void mo33536b(int x, int y) {
        int offset = (this.f30931c * y) + (x / 32);
        int[] iArr = this.f30932d;
        iArr[offset] = iArr[offset] | (1 << (x & 31));
    }

    /* renamed from: a */
    public void mo33532a() {
        int max = this.f30932d.length;
        for (int i = 0; i < max; i++) {
            this.f30932d[i] = 0;
        }
    }

    /* renamed from: a */
    public void mo33533a(int left, int top, int width, int height) {
        if (top < 0 || left < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int right = left + width;
            int i = top + height;
            int bottom = i;
            if (i > this.f30930b || right > this.f30929a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            for (int y = top; y < bottom; y++) {
                int offset = this.f30931c * y;
                for (int x = left; x < right; x++) {
                    int[] iArr = this.f30932d;
                    int i2 = (x / 32) + offset;
                    iArr[i2] = iArr[i2] | (1 << (x & 31));
                }
            }
        }
    }

    /* renamed from: c */
    public int mo33537c() {
        return this.f30929a;
    }

    /* renamed from: b */
    public int mo33535b() {
        return this.f30930b;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C10209b)) {
            return false;
        }
        C10209b other = (C10209b) o;
        if (this.f30929a == other.f30929a && this.f30930b == other.f30930b && this.f30931c == other.f30931c && Arrays.equals(this.f30932d, other.f30932d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f30929a;
        return (((((((i * 31) + i) * 31) + this.f30930b) * 31) + this.f30931c) * 31) + Arrays.hashCode(this.f30932d);
    }

    public String toString() {
        return mo33531a("X ", "  ");
    }

    /* renamed from: a */
    public String mo33531a(String setString, String unsetString) {
        return m33246a(setString, unsetString, "\n");
    }

    /* renamed from: a */
    private String m33246a(String setString, String unsetString, String lineSeparator) {
        StringBuilder result = new StringBuilder(this.f30930b * (this.f30929a + 1));
        for (int y = 0; y < this.f30930b; y++) {
            for (int x = 0; x < this.f30929a; x++) {
                result.append(mo33534a(x, y) ? setString : unsetString);
            }
            result.append(lineSeparator);
        }
        return result.toString();
    }

    public C10209b clone() {
        return new C10209b(this.f30929a, this.f30930b, this.f30931c, (int[]) this.f30932d.clone());
    }
}
