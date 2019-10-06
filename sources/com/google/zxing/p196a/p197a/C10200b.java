package com.google.zxing.p196a.p197a;

import com.google.zxing.p198b.C10208a;

/* renamed from: com.google.zxing.a.a.b */
/* compiled from: BinaryShiftToken */
final class C10200b extends C10206h {

    /* renamed from: c */
    private final short f30907c;

    /* renamed from: d */
    private final short f30908d;

    C10200b(C10206h previous, int binaryShiftStart, int binaryShiftByteCount) {
        super(previous);
        this.f30907c = (short) binaryShiftStart;
        this.f30908d = (short) binaryShiftByteCount;
    }

    /* renamed from: a */
    public void mo33495a(C10208a bitArray, byte[] text) {
        int i = 0;
        while (true) {
            short s = this.f30908d;
            if (i < s) {
                if (i == 0 || (i == 31 && s <= 62)) {
                    bitArray.mo33520a(31, 5);
                    short s2 = this.f30908d;
                    if (s2 > 62) {
                        bitArray.mo33520a(s2 - 31, 16);
                    } else if (i == 0) {
                        bitArray.mo33520a(Math.min(s2, 31), 5);
                    } else {
                        bitArray.mo33520a(s2 - 31, 5);
                    }
                }
                bitArray.mo33520a(text[this.f30907c + i], 8);
                i++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f30907c);
        sb.append("::");
        sb.append((this.f30907c + this.f30908d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
