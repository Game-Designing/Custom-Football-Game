package com.google.zxing.p204f.p206b;

import java.lang.reflect.Array;

/* renamed from: com.google.zxing.f.b.b */
/* compiled from: ByteMatrix */
public final class C10269b {

    /* renamed from: a */
    private final byte[][] f31124a;

    /* renamed from: b */
    private final int f31125b;

    /* renamed from: c */
    private final int f31126c;

    public C10269b(int width, int height) {
        this.f31124a = (byte[][]) Array.newInstance(byte.class, new int[]{height, width});
        this.f31125b = width;
        this.f31126c = height;
    }

    /* renamed from: b */
    public int mo33636b() {
        return this.f31126c;
    }

    /* renamed from: c */
    public int mo33637c() {
        return this.f31125b;
    }

    /* renamed from: a */
    public byte mo33631a(int x, int y) {
        return this.f31124a[y][x];
    }

    /* renamed from: a */
    public byte[][] mo33635a() {
        return this.f31124a;
    }

    /* renamed from: a */
    public void mo33633a(int x, int y, int value) {
        this.f31124a[y][x] = (byte) value;
    }

    /* renamed from: a */
    public void mo33634a(int x, int y, boolean value) {
        this.f31124a[y][x] = value ? (byte) 1 : 0;
    }

    /* renamed from: a */
    public void mo33632a(byte value) {
        for (int y = 0; y < this.f31126c; y++) {
            for (int x = 0; x < this.f31125b; x++) {
                this.f31124a[y][x] = value;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder((this.f31125b * 2 * this.f31126c) + 2);
        for (int y = 0; y < this.f31126c; y++) {
            for (int x = 0; x < this.f31125b; x++) {
                byte b = this.f31124a[y][x];
                if (b == 0) {
                    result.append(" 0");
                } else if (b != 1) {
                    result.append("  ");
                } else {
                    result.append(" 1");
                }
            }
            result.append(10);
        }
        return result.toString();
    }
}
