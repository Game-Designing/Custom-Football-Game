package com.google.zxing.p199c;

import com.google.zxing.C10197a;
import com.google.zxing.C10207b;
import com.google.zxing.C10211c;
import com.google.zxing.C10275g;
import com.google.zxing.p198b.C10209b;
import com.google.zxing.p199c.p200a.C10217e;
import com.google.zxing.p199c.p200a.C10221i;
import com.google.zxing.p199c.p200a.C10222j;
import com.google.zxing.p199c.p200a.C10223k;
import com.google.zxing.p199c.p200a.C10224l;
import com.google.zxing.p204f.p206b.C10269b;
import java.util.Map;

/* renamed from: com.google.zxing.c.a */
/* compiled from: DataMatrixWriter */
public final class C10212a implements C10275g {
    /* renamed from: a */
    public C10209b mo33488a(String contents, C10197a format, int width, int height, Map<C10211c, ?> hints) {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (format != C10197a.DATA_MATRIX) {
            StringBuilder sb = new StringBuilder("Can only encode DATA_MATRIX, but got ");
            sb.append(format);
            throw new IllegalArgumentException(sb.toString());
        } else if (width < 0 || height < 0) {
            StringBuilder sb2 = new StringBuilder("Requested dimensions are too small: ");
            sb2.append(width);
            sb2.append('x');
            sb2.append(height);
            throw new IllegalArgumentException(sb2.toString());
        } else {
            C10224l shape = C10224l.FORCE_NONE;
            C10207b minSize = null;
            C10207b maxSize = null;
            if (hints != null) {
                C10224l lVar = (C10224l) hints.get(C10211c.DATA_MATRIX_SHAPE);
                C10224l requestedShape = lVar;
                if (lVar != null) {
                    shape = requestedShape;
                }
                C10207b bVar = (C10207b) hints.get(C10211c.MIN_SIZE);
                C10207b requestedMinSize = bVar;
                if (bVar != null) {
                    minSize = requestedMinSize;
                }
                C10207b bVar2 = (C10207b) hints.get(C10211c.MAX_SIZE);
                C10207b requestedMaxSize = bVar2;
                if (bVar2 != null) {
                    maxSize = requestedMaxSize;
                }
            }
            String a = C10222j.m33317a(contents, shape, minSize, maxSize);
            String encoded = a;
            C10223k symbolInfo = C10223k.m33327a(a.length(), shape, minSize, maxSize, true);
            C10217e eVar = new C10217e(C10221i.m33311a(encoded, symbolInfo), symbolInfo.mo33576e(), symbolInfo.mo33575d());
            C10217e placement = eVar;
            eVar.mo33551a();
            return m33256a(placement, symbolInfo);
        }
    }

    /* renamed from: a */
    private static C10209b m33256a(C10217e placement, C10223k symbolInfo) {
        int symbolWidth = symbolInfo.mo33576e();
        int symbolHeight = symbolInfo.mo33575d();
        C10269b matrix = new C10269b(symbolInfo.mo33578g(), symbolInfo.mo33577f());
        int matrixY = 0;
        for (int y = 0; y < symbolHeight; y++) {
            if (y % symbolInfo.f31000g == 0) {
                int matrixX = 0;
                for (int x = 0; x < symbolInfo.mo33578g(); x++) {
                    matrix.mo33634a(matrixX, matrixY, x % 2 == 0);
                    matrixX++;
                }
                matrixY++;
            }
            int matrixX2 = 0;
            for (int x2 = 0; x2 < symbolWidth; x2++) {
                if (x2 % symbolInfo.f30999f == 0) {
                    matrix.mo33634a(matrixX2, matrixY, true);
                    matrixX2++;
                }
                matrix.mo33634a(matrixX2, matrixY, placement.mo33552a(x2, y));
                matrixX2++;
                int i = symbolInfo.f30999f;
                if (x2 % i == i - 1) {
                    matrix.mo33634a(matrixX2, matrixY, y % 2 == 0);
                    matrixX2++;
                }
            }
            matrixY++;
            int i2 = symbolInfo.f31000g;
            if (y % i2 == i2 - 1) {
                int matrixX3 = 0;
                for (int x3 = 0; x3 < symbolInfo.mo33578g(); x3++) {
                    matrix.mo33634a(matrixX3, matrixY, true);
                    matrixX3++;
                }
                matrixY++;
            }
        }
        return m33257a(matrix);
    }

    /* renamed from: a */
    private static C10209b m33257a(C10269b matrix) {
        int matrixWidgth = matrix.mo33637c();
        int matrixHeight = matrix.mo33636b();
        C10209b bVar = new C10209b(matrixWidgth, matrixHeight);
        C10209b output = bVar;
        bVar.mo33532a();
        for (int i = 0; i < matrixWidgth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                if (matrix.mo33631a(i, j) == 1) {
                    output.mo33536b(i, j);
                }
            }
        }
        return output;
    }
}
