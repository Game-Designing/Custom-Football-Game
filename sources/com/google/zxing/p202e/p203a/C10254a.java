package com.google.zxing.p202e.p203a;

import java.lang.reflect.Array;

/* renamed from: com.google.zxing.e.a.a */
/* compiled from: BarcodeMatrix */
public final class C10254a {

    /* renamed from: a */
    private final C10255b[] f31062a;

    /* renamed from: b */
    private int f31063b;

    /* renamed from: c */
    private final int f31064c;

    /* renamed from: d */
    private final int f31065d;

    C10254a(int height, int width) {
        this.f31062a = new C10255b[height];
        int matrixLength = this.f31062a.length;
        for (int i = 0; i < matrixLength; i++) {
            this.f31062a[i] = new C10255b(((width + 4) * 17) + 1);
        }
        this.f31065d = width * 17;
        this.f31064c = height;
        this.f31063b = -1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo33602b() {
        this.f31063b++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10255b mo33600a() {
        return this.f31062a[this.f31063b];
    }

    /* renamed from: a */
    public byte[][] mo33601a(int xScale, int yScale) {
        byte[][] matrixOut = (byte[][]) Array.newInstance(byte.class, new int[]{this.f31064c * yScale, this.f31065d * xScale});
        int yMax = this.f31064c * yScale;
        for (int i = 0; i < yMax; i++) {
            matrixOut[(yMax - i) - 1] = this.f31062a[i / yScale].mo33604a(xScale);
        }
        return matrixOut;
    }
}
