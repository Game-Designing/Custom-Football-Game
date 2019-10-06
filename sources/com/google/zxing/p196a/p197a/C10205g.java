package com.google.zxing.p196a.p197a;

import com.google.zxing.aztec.encoder.Token;
import com.google.zxing.p198b.C10208a;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.zxing.a.a.g */
/* compiled from: State */
final class C10205g {

    /* renamed from: a */
    static final C10205g f30918a = new C10205g(C10206h.f30923a, 0, 0, 0);

    /* renamed from: b */
    private final int f30919b;

    /* renamed from: c */
    private final C10206h f30920c;

    /* renamed from: d */
    private final int f30921d;

    /* renamed from: e */
    private final int f30922e;

    private C10205g(C10206h token, int mode, int binaryBytes, int bitCount) {
        this.f30920c = token;
        this.f30919b = mode;
        this.f30921d = binaryBytes;
        this.f30922e = bitCount;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo33509c() {
        return this.f30919b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo33501a() {
        return this.f30921d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public int mo33506b() {
        return this.f30922e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10205g mo33503a(int mode, int value) {
        int bitCount = this.f30922e;
        C10206h token = this.f30920c;
        int i = this.f30919b;
        if (mode != i) {
            int latch = C10203e.f30912b[i][mode];
            token = token.mo33512a(65535 & latch, latch >> 16);
            bitCount += latch >> 16;
        }
        int latchModeBitCount = mode == 2 ? 4 : 5;
        return new C10205g(token.mo33512a(value, latchModeBitCount), mode, 0, bitCount + latchModeBitCount);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10205g mo33508b(int mode, int value) {
        C10206h token = this.f30920c;
        int thisModeBitCount = this.f30919b == 2 ? 4 : 5;
        return new C10205g(token.mo33512a(C10203e.f30914d[this.f30919b][mode], thisModeBitCount).mo33512a(value, 5), this.f30919b, 0, this.f30922e + thisModeBitCount + 5);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10205g mo33502a(int index) {
        C10206h token = this.f30920c;
        int mode = this.f30919b;
        int bitCount = this.f30922e;
        int i = this.f30919b;
        if (i == 4 || i == 2) {
            int latch = C10203e.f30912b[mode][0];
            token = token.mo33512a(65535 & latch, latch >> 16);
            bitCount += latch >> 16;
            mode = 0;
        }
        int latch2 = this.f30921d;
        int deltaBitCount = (latch2 == 0 || latch2 == 31) ? 18 : latch2 == 62 ? 9 : 8;
        C10205g gVar = new C10205g(token, mode, this.f30921d + 1, bitCount + deltaBitCount);
        C10205g result = gVar;
        if (gVar.f30921d == 2078) {
            return result.mo33507b(index + 1);
        }
        return result;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10205g mo33507b(int index) {
        int i = this.f30921d;
        if (i == 0) {
            return this;
        }
        return new C10205g(this.f30920c.mo33513b(index - i, i), this.f30919b, 0, this.f30922e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo33505a(C10205g other) {
        int mySize = this.f30922e + (C10203e.f30912b[this.f30919b][other.f30919b] >> 16);
        int i = other.f30921d;
        if (i > 0) {
            int i2 = this.f30921d;
            if (i2 == 0 || i2 > i) {
                mySize += 10;
            }
        }
        return mySize <= other.f30922e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10208a mo33504a(byte[] text) {
        Deque<Token> symbols = new LinkedList<>();
        for (C10206h token = mo33507b(text.length).f30920c; token != null; token = token.mo33511a()) {
            symbols.addFirst(token);
        }
        C10208a bitArray = new C10208a();
        Iterator it = symbols.iterator();
        while (it.hasNext()) {
            ((C10206h) it.next()).mo33495a(bitArray, text);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{C10203e.f30911a[this.f30919b], Integer.valueOf(this.f30922e), Integer.valueOf(this.f30921d)});
    }
}
