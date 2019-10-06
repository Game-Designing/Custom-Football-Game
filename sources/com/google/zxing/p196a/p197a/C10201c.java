package com.google.zxing.p196a.p197a;

import com.google.zxing.common.reedsolomon.C10227a;
import com.google.zxing.common.reedsolomon.C10229c;
import com.google.zxing.p198b.C10208a;
import com.google.zxing.p198b.C10209b;

/* renamed from: com.google.zxing.a.a.c */
/* compiled from: Encoder */
public final class C10201c {

    /* renamed from: a */
    private static final int[] f30909a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: a */
    public static C10199a m33205a(byte[] data, int minECCPercent, int userSpecifiedLayers) {
        C10208a stuffedBits;
        int totalBitsInLayer;
        int layers;
        boolean compact;
        int wordSize;
        int eccBits;
        int totalSizeBits;
        int totalBitsInLayer2;
        int totalSizeBits2;
        C10208a bits;
        int eccBits2;
        C10208a a = new C10203e(data).mo33499a();
        Object obj = null;
        C10208a bits2 = a;
        int eccBits3 = ((a.mo33519a() * minECCPercent) / 100) + 11;
        int totalSizeBits3 = bits2.mo33519a() + eccBits3;
        int i = 32;
        if (userSpecifiedLayers != 0) {
            compact = userSpecifiedLayers < 0;
            int abs = Math.abs(userSpecifiedLayers);
            layers = abs;
            if (compact) {
                i = 4;
            }
            if (abs <= i) {
                int totalBitsInLayer3 = m33204a(layers, compact);
                int wordSize2 = f30909a[layers];
                int usableBitsInLayers = totalBitsInLayer3 - (totalBitsInLayer3 % wordSize2);
                C10208a a2 = m33206a(bits2, wordSize2);
                stuffedBits = a2;
                String str = "Data to large for user specified layer";
                if (a2.mo33519a() + eccBits3 > usableBitsInLayers) {
                    throw new IllegalArgumentException(str);
                } else if (!compact || stuffedBits.mo33519a() <= (wordSize2 << 6)) {
                    totalBitsInLayer = totalBitsInLayer3;
                    wordSize = wordSize2;
                } else {
                    throw new IllegalArgumentException(str);
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(userSpecifiedLayers)}));
            }
        } else {
            wordSize = 0;
            C10208a stuffedBits2 = null;
            int i2 = 0;
            while (i2 <= i) {
                boolean z = i2 <= 3;
                boolean compact2 = z;
                int i3 = z ? i2 + 1 : i2;
                int layers2 = i3;
                totalBitsInLayer = m33204a(i3, compact2);
                if (totalSizeBits3 <= totalBitsInLayer) {
                    int[] iArr = f30909a;
                    if (wordSize != iArr[layers2]) {
                        wordSize = iArr[layers2];
                        stuffedBits = m33206a(bits2, wordSize);
                    } else {
                        stuffedBits = stuffedBits2;
                    }
                    int usableBitsInLayers2 = totalBitsInLayer - (totalBitsInLayer % wordSize);
                    if ((!compact2 || stuffedBits.mo33519a() <= (wordSize << 6)) && stuffedBits.mo33519a() + eccBits3 <= usableBitsInLayers2) {
                        compact = compact2;
                        layers = layers2;
                    } else {
                        eccBits2 = eccBits3;
                        bits = bits2;
                        totalSizeBits2 = totalSizeBits3;
                        stuffedBits2 = stuffedBits;
                    }
                } else {
                    eccBits2 = eccBits3;
                    bits = bits2;
                    totalSizeBits2 = totalSizeBits3;
                }
                i2++;
                i = 32;
                byte[] bArr = data;
                obj = obj;
                eccBits3 = eccBits2;
                bits2 = bits;
                totalSizeBits3 = totalSizeBits2;
            }
            C10208a aVar = bits2;
            int i4 = totalSizeBits3;
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        C10208a messageBits = m33212b(stuffedBits, totalBitsInLayer, wordSize);
        int messageSizeInWords = stuffedBits.mo33519a() / wordSize;
        C10208a modeMessage = m33207a(compact, layers, messageSizeInWords);
        int i5 = (compact ? 11 : 14) + (layers << 2);
        int baseMatrixSize = i5;
        int[] alignmentMap = new int[i5];
        if (compact) {
            int matrixSize = baseMatrixSize;
            for (int i6 = 0; i6 < alignmentMap.length; i6++) {
                alignmentMap[i6] = i6;
            }
            int i7 = eccBits3;
            eccBits = matrixSize;
        } else {
            int matrixSize2 = baseMatrixSize + 1 + ((((baseMatrixSize / 2) - 1) / 15) * 2);
            int origCenter = baseMatrixSize / 2;
            int center = matrixSize2 / 2;
            int i8 = eccBits3;
            for (int i9 = 0; i9 < origCenter; i9++) {
                int newOffset = i9 + (i9 / 15);
                alignmentMap[(origCenter - i9) - 1] = (center - newOffset) - 1;
                alignmentMap[origCenter + i9] = center + newOffset + 1;
            }
            eccBits = matrixSize2;
        }
        C10209b matrix = new C10209b(eccBits);
        int i10 = 0;
        int rowOffset = 0;
        while (i10 < layers) {
            int rowSize = ((layers - i10) << 2) + (compact ? 9 : 12);
            C10208a bits3 = bits2;
            int j = 0;
            while (j < rowSize) {
                int columnOffset = j << 1;
                int wordSize3 = wordSize;
                int k = 0;
                while (true) {
                    totalSizeBits = totalSizeBits3;
                    if (k >= 2) {
                        break;
                    }
                    if (messageBits.mo33524a(rowOffset + columnOffset + k)) {
                        totalBitsInLayer2 = totalBitsInLayer;
                        matrix.mo33536b(alignmentMap[(i10 << 1) + k], alignmentMap[(i10 << 1) + j]);
                    } else {
                        totalBitsInLayer2 = totalBitsInLayer;
                    }
                    if (messageBits.mo33524a(rowOffset + (rowSize << 1) + columnOffset + k)) {
                        matrix.mo33536b(alignmentMap[(i10 << 1) + j], alignmentMap[((baseMatrixSize - 1) - (i10 << 1)) - k]);
                    }
                    if (messageBits.mo33524a(rowOffset + (rowSize << 2) + columnOffset + k)) {
                        matrix.mo33536b(alignmentMap[((baseMatrixSize - 1) - (i10 << 1)) - k], alignmentMap[((baseMatrixSize - 1) - (i10 << 1)) - j]);
                    }
                    if (messageBits.mo33524a(rowOffset + (rowSize * 6) + columnOffset + k)) {
                        matrix.mo33536b(alignmentMap[((baseMatrixSize - 1) - (i10 << 1)) - j], alignmentMap[(i10 << 1) + k]);
                    }
                    k++;
                    totalSizeBits3 = totalSizeBits;
                    totalBitsInLayer = totalBitsInLayer2;
                }
                j++;
                totalSizeBits3 = totalSizeBits;
                wordSize = wordSize3;
            }
            int i11 = totalSizeBits3;
            int i12 = totalBitsInLayer;
            rowOffset += rowSize << 3;
            i10++;
            byte[] bArr2 = data;
            bits2 = bits3;
        }
        int i13 = wordSize;
        int i14 = totalSizeBits3;
        int i15 = totalBitsInLayer;
        m33210a(matrix, compact, eccBits, modeMessage);
        if (compact) {
            m33209a(matrix, eccBits / 2, 5);
        } else {
            m33209a(matrix, eccBits / 2, 7);
            int i16 = 0;
            int j2 = 0;
            while (i16 < (baseMatrixSize / 2) - 1) {
                for (int k2 = (eccBits / 2) & 1; k2 < eccBits; k2 += 2) {
                    matrix.mo33536b((eccBits / 2) - j2, k2);
                    matrix.mo33536b((eccBits / 2) + j2, k2);
                    matrix.mo33536b(k2, (eccBits / 2) - j2);
                    matrix.mo33536b(k2, (eccBits / 2) + j2);
                }
                i16 += 15;
                j2 += 16;
            }
        }
        C10199a aVar2 = new C10199a();
        C10199a aztec = aVar2;
        aVar2.mo33492a(compact);
        aztec.mo33494c(eccBits);
        aztec.mo33493b(layers);
        aztec.mo33490a(messageSizeInWords);
        aztec.mo33491a(matrix);
        return aztec;
    }

    /* renamed from: a */
    private static void m33209a(C10209b matrix, int center, int size) {
        for (int i = 0; i < size; i += 2) {
            for (int j = center - i; j <= center + i; j++) {
                matrix.mo33536b(j, center - i);
                matrix.mo33536b(j, center + i);
                matrix.mo33536b(center - i, j);
                matrix.mo33536b(center + i, j);
            }
        }
        matrix.mo33536b(center - size, center - size);
        matrix.mo33536b((center - size) + 1, center - size);
        matrix.mo33536b(center - size, (center - size) + 1);
        matrix.mo33536b(center + size, center - size);
        matrix.mo33536b(center + size, (center - size) + 1);
        matrix.mo33536b(center + size, (center + size) - 1);
    }

    /* renamed from: a */
    static C10208a m33207a(boolean compact, int layers, int messageSizeInWords) {
        C10208a modeMessage = new C10208a();
        if (compact) {
            modeMessage.mo33520a(layers - 1, 2);
            modeMessage.mo33520a(messageSizeInWords - 1, 6);
            return m33212b(modeMessage, 28, 4);
        }
        modeMessage.mo33520a(layers - 1, 5);
        modeMessage.mo33520a(messageSizeInWords - 1, 11);
        return m33212b(modeMessage, 40, 4);
    }

    /* renamed from: a */
    private static void m33210a(C10209b matrix, boolean compact, int matrixSize, C10208a modeMessage) {
        int center = matrixSize / 2;
        if (compact) {
            for (int i = 0; i < 7; i++) {
                int offset = (center - 3) + i;
                if (modeMessage.mo33524a(i)) {
                    matrix.mo33536b(offset, center - 5);
                }
                if (modeMessage.mo33524a(i + 7)) {
                    matrix.mo33536b(center + 5, offset);
                }
                if (modeMessage.mo33524a(20 - i)) {
                    matrix.mo33536b(offset, center + 5);
                }
                if (modeMessage.mo33524a(27 - i)) {
                    matrix.mo33536b(center - 5, offset);
                }
            }
            return;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            int offset2 = (center - 5) + i2 + (i2 / 5);
            if (modeMessage.mo33524a(i2)) {
                matrix.mo33536b(offset2, center - 7);
            }
            if (modeMessage.mo33524a(i2 + 10)) {
                matrix.mo33536b(center + 7, offset2);
            }
            if (modeMessage.mo33524a(29 - i2)) {
                matrix.mo33536b(offset2, center + 7);
            }
            if (modeMessage.mo33524a(39 - i2)) {
                matrix.mo33536b(center - 7, offset2);
            }
        }
    }

    /* renamed from: b */
    private static C10208a m33212b(C10208a bitArray, int totalBits, int wordSize) {
        int messageSizeInWords = bitArray.mo33519a() / wordSize;
        C10229c rs = new C10229c(m33208a(wordSize));
        int totalWords = totalBits / wordSize;
        int[] messageWords = m33211a(bitArray, wordSize, totalWords);
        rs.mo33597a(messageWords, totalWords - messageSizeInWords);
        int startPad = totalBits % wordSize;
        C10208a aVar = new C10208a();
        C10208a messageBits = aVar;
        aVar.mo33520a(0, startPad);
        for (int messageWord : messageWords) {
            messageBits.mo33520a(messageWord, wordSize);
        }
        return messageBits;
    }

    /* renamed from: a */
    private static int[] m33211a(C10208a stuffedBits, int wordSize, int totalWords) {
        int[] message = new int[totalWords];
        int n = stuffedBits.mo33519a() / wordSize;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = 0; j < wordSize; j++) {
                value |= stuffedBits.mo33524a((i * wordSize) + j) ? 1 << ((wordSize - j) - 1) : 0;
            }
            message[i] = value;
        }
        return message;
    }

    /* renamed from: a */
    private static C10227a m33208a(int wordSize) {
        if (wordSize == 4) {
            return C10227a.f31011d;
        }
        if (wordSize == 6) {
            return C10227a.f31010c;
        }
        if (wordSize == 8) {
            return C10227a.f31014g;
        }
        if (wordSize == 10) {
            return C10227a.f31009b;
        }
        if (wordSize == 12) {
            return C10227a.f31008a;
        }
        StringBuilder sb = new StringBuilder("Unsupported word size ");
        sb.append(wordSize);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    static C10208a m33206a(C10208a bits, int wordSize) {
        C10208a out = new C10208a();
        int n = bits.mo33519a();
        int mask = (1 << wordSize) - 2;
        int i = 0;
        while (i < n) {
            int word = 0;
            for (int j = 0; j < wordSize; j++) {
                if (i + j >= n || bits.mo33524a(i + j)) {
                    word |= 1 << ((wordSize - 1) - j);
                }
            }
            if ((word & mask) == mask) {
                out.mo33520a(word & mask, wordSize);
                i--;
            } else if ((word & mask) == 0) {
                out.mo33520a(word | 1, wordSize);
                i--;
            } else {
                out.mo33520a(word, wordSize);
            }
            i += wordSize;
        }
        return out;
    }

    /* renamed from: a */
    private static int m33204a(int layers, boolean compact) {
        return ((compact ? 88 : 112) + (layers << 4)) * layers;
    }
}
