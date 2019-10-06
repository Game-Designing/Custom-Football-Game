package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.zxing.common.reedsolomon.c */
/* compiled from: ReedSolomonEncoder */
public final class C10229c {

    /* renamed from: a */
    private final C10227a f31025a;

    /* renamed from: b */
    private final List<C10228b> f31026b = new ArrayList();

    public C10229c(C10227a field) {
        this.f31025a = field;
        this.f31026b.add(new C10228b(field, new int[]{1}));
    }

    /* renamed from: a */
    private C10228b m33361a(int degree) {
        if (degree >= this.f31026b.size()) {
            List<C10228b> list = this.f31026b;
            C10228b lastGenerator = (C10228b) list.get(list.size() - 1);
            for (int d = this.f31026b.size(); d <= degree; d++) {
                C10227a aVar = this.f31025a;
                C10228b nextGenerator = lastGenerator.mo33594c(new C10228b(aVar, new int[]{1, aVar.mo33581a((d - 1) + aVar.mo33580a())}));
                this.f31026b.add(nextGenerator);
                lastGenerator = nextGenerator;
            }
        }
        return (C10228b) this.f31026b.get(degree);
    }

    /* renamed from: a */
    public void mo33597a(int[] toEncode, int ecBytes) {
        if (ecBytes != 0) {
            int length = toEncode.length - ecBytes;
            int dataBytes = length;
            if (length > 0) {
                C10228b generator = m33361a(ecBytes);
                int[] infoCoefficients = new int[dataBytes];
                System.arraycopy(toEncode, 0, infoCoefficients, 0, dataBytes);
                int[] coefficients = new C10228b(this.f31025a, infoCoefficients).mo33589a(ecBytes, 1).mo33593b(generator)[1].mo33591a();
                int numZeroCoefficients = ecBytes - coefficients.length;
                for (int i = 0; i < numZeroCoefficients; i++) {
                    toEncode[dataBytes + i] = 0;
                }
                System.arraycopy(coefficients, 0, toEncode, dataBytes + numZeroCoefficients, coefficients.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
