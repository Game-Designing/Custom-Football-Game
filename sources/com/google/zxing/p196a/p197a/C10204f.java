package com.google.zxing.p196a.p197a;

import com.google.zxing.p198b.C10208a;

/* renamed from: com.google.zxing.a.a.f */
/* compiled from: SimpleToken */
final class C10204f extends C10206h {

    /* renamed from: c */
    private final short f30916c;

    /* renamed from: d */
    private final short f30917d;

    C10204f(C10206h previous, int value, int bitCount) {
        super(previous);
        this.f30916c = (short) value;
        this.f30917d = (short) bitCount;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33495a(C10208a bitArray, byte[] text) {
        bitArray.mo33520a(this.f30916c, this.f30917d);
    }

    public String toString() {
        int i = this.f30916c;
        short s = this.f30917d;
        int value = (i & ((1 << s) - 1)) | (1 << s);
        StringBuilder sb = new StringBuilder("<");
        sb.append(Integer.toBinaryString((1 << this.f30917d) | value).substring(1));
        sb.append('>');
        return sb.toString();
    }
}
