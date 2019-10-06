package com.google.zxing.p204f.p206b;

import com.google.zxing.C10211c;
import com.google.zxing.WriterException;
import com.google.zxing.common.reedsolomon.C10227a;
import com.google.zxing.common.reedsolomon.C10229c;
import com.google.zxing.p198b.C10208a;
import com.google.zxing.p198b.C10210c;
import com.google.zxing.p204f.p205a.C10263a;
import com.google.zxing.p204f.p205a.C10264b;
import com.google.zxing.p204f.p205a.C10265c;
import com.google.zxing.p204f.p205a.C10265c.C10267b;
import com.google.zxing.qrcode.encoder.BlockPair;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.zxing.f.b.d */
/* compiled from: Encoder */
public final class C10271d {

    /* renamed from: a */
    private static final int[] f31128a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: a */
    private static int m33465a(C10269b matrix) {
        return C10272e.m33484a(matrix) + C10272e.m33489b(matrix) + C10272e.m33490c(matrix) + C10272e.m33491d(matrix);
    }

    /* renamed from: a */
    public static C10274g m33470a(String content, C10263a ecLevel, Map<C10211c, ?> hints) throws WriterException {
        C10265c version;
        String encoding = "ISO-8859-1";
        if (hints != null && hints.containsKey(C10211c.CHARACTER_SET)) {
            encoding = hints.get(C10211c.CHARACTER_SET).toString();
        }
        C10264b mode = m33467a(content, encoding);
        C10208a headerBits = new C10208a();
        if (mode == C10264b.BYTE && !"ISO-8859-1".equals(encoding)) {
            C10210c a = C10210c.m33254a(encoding);
            C10210c eci = a;
            if (a != null) {
                m33474a(eci, headerBits);
            }
        }
        m33475a(mode, headerBits);
        C10208a dataBits = new C10208a();
        m33479a(content, mode, dataBits, encoding);
        if (hints == null || !hints.containsKey(C10211c.QR_VERSION)) {
            version = m33469a(ecLevel, mode, headerBits, dataBits);
        } else {
            version = C10265c.m33441a(Integer.parseInt(hints.get(C10211c.QR_VERSION).toString()));
            if (!m33480a(m33464a(mode, headerBits, dataBits, version), version, ecLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        C10208a aVar = new C10208a();
        C10208a headerAndDataBits = aVar;
        aVar.mo33522a(headerBits);
        m33473a(mode == C10264b.BYTE ? dataBits.mo33525b() : content.length(), version, mode, headerAndDataBits);
        headerAndDataBits.mo33522a(dataBits);
        C10267b ecBlocks = version.mo33619a(ecLevel);
        int b = version.mo33620b() - ecBlocks.mo33628d();
        int numDataBytes = b;
        m33472a(b, headerAndDataBits);
        C10208a finalBits = m33466a(headerAndDataBits, version.mo33620b(), numDataBytes, ecBlocks.mo33627c());
        C10274g gVar = new C10274g();
        C10274g qrCode = gVar;
        gVar.mo33640a(ecLevel);
        qrCode.mo33641a(mode);
        qrCode.mo33642a(version);
        int dimension = version.mo33618a();
        C10269b matrix = new C10269b(dimension, dimension);
        int maskPattern = m33463a(finalBits, ecLevel, version, matrix);
        qrCode.mo33644b(maskPattern);
        C10273f.m33496a(finalBits, ecLevel, version, maskPattern, matrix);
        qrCode.mo33643a(matrix);
        return qrCode;
    }

    /* renamed from: a */
    private static C10265c m33469a(C10263a ecLevel, C10264b mode, C10208a headerBits, C10208a dataBits) throws WriterException {
        return m33468a(m33464a(mode, headerBits, dataBits, m33468a(m33464a(mode, headerBits, dataBits, C10265c.m33441a(1)), ecLevel)), ecLevel);
    }

    /* renamed from: a */
    private static int m33464a(C10264b mode, C10208a headerBits, C10208a dataBits, C10265c version) {
        return headerBits.mo33519a() + mode.mo33616a(version) + dataBits.mo33519a();
    }

    /* renamed from: a */
    static int m33462a(int code) {
        int[] iArr = f31128a;
        if (code < iArr.length) {
            return iArr[code];
        }
        return -1;
    }

    /* renamed from: a */
    private static C10264b m33467a(String content, String encoding) {
        if ("Shift_JIS".equals(encoding) && m33481a(content)) {
            return C10264b.KANJI;
        }
        boolean hasNumeric = false;
        boolean hasAlphanumeric = false;
        for (int i = 0; i < content.length(); i++) {
            char charAt = content.charAt(i);
            char c = charAt;
            if (charAt >= '0' && c <= '9') {
                hasNumeric = true;
            } else if (m33462a((int) c) == -1) {
                return C10264b.BYTE;
            } else {
                hasAlphanumeric = true;
            }
        }
        if (hasAlphanumeric) {
            return C10264b.ALPHANUMERIC;
        }
        if (hasNumeric) {
            return C10264b.NUMERIC;
        }
        return C10264b.BYTE;
    }

    /* renamed from: a */
    private static boolean m33481a(String content) {
        try {
            byte[] bytes = content.getBytes("Shift_JIS");
            int length = bytes.length;
            int length2 = length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length2; i += 2) {
                int i2 = bytes[i] & 255;
                int byte1 = i2;
                if ((i2 < 129 || byte1 > 159) && (byte1 < 224 || byte1 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static int m33463a(C10208a bits, C10263a ecLevel, C10265c version, C10269b matrix) throws WriterException {
        int minPenalty = MoPubClientPositioning.NO_REPEAT;
        int bestMaskPattern = -1;
        for (int maskPattern = 0; maskPattern < 8; maskPattern++) {
            C10273f.m33496a(bits, ecLevel, version, maskPattern, matrix);
            int a = m33465a(matrix);
            int penalty = a;
            if (a < minPenalty) {
                minPenalty = penalty;
                bestMaskPattern = maskPattern;
            }
        }
        return bestMaskPattern;
    }

    /* renamed from: a */
    private static C10265c m33468a(int numInputBits, C10263a ecLevel) throws WriterException {
        for (int versionNum = 1; versionNum <= 40; versionNum++) {
            C10265c version = C10265c.m33441a(versionNum);
            if (m33480a(numInputBits, version, ecLevel)) {
                return version;
            }
        }
        throw new WriterException("Data too big");
    }

    /* renamed from: a */
    private static boolean m33480a(int numInputBits, C10265c version, C10263a ecLevel) {
        return version.mo33620b() - version.mo33619a(ecLevel).mo33628d() >= (numInputBits + 7) / 8;
    }

    /* renamed from: a */
    static void m33472a(int numDataBytes, C10208a bits) throws WriterException {
        int capacity = numDataBytes << 3;
        if (bits.mo33519a() <= capacity) {
            for (int i = 0; i < 4 && bits.mo33519a() < capacity; i++) {
                bits.mo33523a(false);
            }
            int a = bits.mo33519a() & 7;
            int numBitsInLastByte = a;
            if (a > 0) {
                for (int i2 = numBitsInLastByte; i2 < 8; i2++) {
                    bits.mo33523a(false);
                }
            }
            int numPaddingBytes = numDataBytes - bits.mo33525b();
            for (int i3 = 0; i3 < numPaddingBytes; i3++) {
                bits.mo33520a((i3 & 1) == 0 ? 236 : 17, 8);
            }
            if (bits.mo33519a() != capacity) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        StringBuilder sb = new StringBuilder("data bits cannot fit in the QR Code");
        sb.append(bits.mo33519a());
        sb.append(" > ");
        sb.append(capacity);
        throw new WriterException(sb.toString());
    }

    /* renamed from: a */
    static void m33471a(int numTotalBytes, int numDataBytes, int numRSBlocks, int blockID, int[] numDataBytesInBlock, int[] numECBytesInBlock) throws WriterException {
        int i = numTotalBytes;
        int i2 = numRSBlocks;
        int i3 = blockID;
        if (i3 < i2) {
            int numRsBlocksInGroup2 = i % i2;
            int numRsBlocksInGroup1 = i2 - numRsBlocksInGroup2;
            int i4 = i / i2;
            int i5 = numDataBytes / i2;
            int numDataBytesInGroup1 = i5;
            int numDataBytesInGroup2 = i5 + 1;
            int numEcBytesInGroup1 = i4 - numDataBytesInGroup1;
            int numEcBytesInGroup2 = (i4 + 1) - numDataBytesInGroup2;
            if (numEcBytesInGroup1 != numEcBytesInGroup2) {
                throw new WriterException("EC bytes mismatch");
            } else if (i2 != numRsBlocksInGroup1 + numRsBlocksInGroup2) {
                throw new WriterException("RS blocks mismatch");
            } else if (i != ((numDataBytesInGroup1 + numEcBytesInGroup1) * numRsBlocksInGroup1) + ((numDataBytesInGroup2 + numEcBytesInGroup2) * numRsBlocksInGroup2)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i3 < numRsBlocksInGroup1) {
                numDataBytesInBlock[0] = numDataBytesInGroup1;
                numECBytesInBlock[0] = numEcBytesInGroup1;
            } else {
                numDataBytesInBlock[0] = numDataBytesInGroup2;
                numECBytesInBlock[0] = numEcBytesInGroup2;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    /* renamed from: a */
    static C10208a m33466a(C10208a bits, int numTotalBytes, int numDataBytes, int numRSBlocks) throws WriterException {
        int i = numTotalBytes;
        int i2 = numDataBytes;
        int i3 = numRSBlocks;
        if (bits.mo33525b() == i2) {
            Collection<BlockPair> blocks = new ArrayList<>(i3);
            int dataBytesOffset = 0;
            int maxNumDataBytes = 0;
            int maxNumEcBytes = 0;
            int size = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                int[] numDataBytesInBlock = new int[1];
                int[] numEcBytesInBlock = new int[1];
                int[] numDataBytesInBlock2 = numDataBytesInBlock;
                m33471a(numTotalBytes, numDataBytes, numRSBlocks, i4, numDataBytesInBlock, numEcBytesInBlock);
                int i5 = numDataBytesInBlock2[0];
                int i6 = size;
                size = i5;
                byte[] dataBytes = new byte[i5];
                bits.mo33521a(dataBytesOffset << 3, dataBytes, 0, size);
                byte[] ecBytes = m33482a(dataBytes, numEcBytesInBlock[0]);
                blocks.add(new C10268a(dataBytes, ecBytes));
                maxNumDataBytes = Math.max(maxNumDataBytes, size);
                maxNumEcBytes = Math.max(maxNumEcBytes, ecBytes.length);
                dataBytesOffset += numDataBytesInBlock2[0];
            }
            C10208a aVar = bits;
            if (i2 == dataBytesOffset) {
                C10208a result = new C10208a();
                for (int i7 = 0; i7 < maxNumDataBytes; i7++) {
                    Iterator it = blocks.iterator();
                    while (it.hasNext()) {
                        byte[] dataBytes2 = ((C10268a) it.next()).mo33629a();
                        if (i7 < dataBytes2.length) {
                            result.mo33520a(dataBytes2[i7], 8);
                        }
                    }
                }
                for (int i8 = 0; i8 < maxNumEcBytes; i8++) {
                    Iterator it2 = blocks.iterator();
                    while (it2.hasNext()) {
                        byte[] ecBytes2 = ((C10268a) it2.next()).mo33630b();
                        if (i8 < ecBytes2.length) {
                            result.mo33520a(ecBytes2[i8], 8);
                        }
                    }
                }
                if (i == result.mo33525b()) {
                    return result;
                }
                StringBuilder sb = new StringBuilder("Interleaving error: ");
                sb.append(i);
                sb.append(" and ");
                sb.append(result.mo33525b());
                sb.append(" differ.");
                throw new WriterException(sb.toString());
            }
            throw new WriterException("Data bytes does not match offset");
        }
        C10208a aVar2 = bits;
        throw new WriterException("Number of bits and data bytes does not match");
    }

    /* renamed from: a */
    static byte[] m33482a(byte[] dataBytes, int numEcBytesInBlock) {
        int length = dataBytes.length;
        int numDataBytes = length;
        int[] toEncode = new int[(length + numEcBytesInBlock)];
        for (int i = 0; i < numDataBytes; i++) {
            toEncode[i] = dataBytes[i] & 255;
        }
        new C10229c(C10227a.f31012e).mo33597a(toEncode, numEcBytesInBlock);
        byte[] ecBytes = new byte[numEcBytesInBlock];
        for (int i2 = 0; i2 < numEcBytesInBlock; i2++) {
            ecBytes[i2] = (byte) toEncode[numDataBytes + i2];
        }
        return ecBytes;
    }

    /* renamed from: a */
    static void m33475a(C10264b mode, C10208a bits) {
        bits.mo33520a(mode.mo33617e(), 4);
    }

    /* renamed from: a */
    static void m33473a(int numLetters, C10265c version, C10264b mode, C10208a bits) throws WriterException {
        int numBits = mode.mo33616a(version);
        if (numLetters < (1 << numBits)) {
            bits.mo33520a(numLetters, numBits);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numLetters);
        sb.append(" is bigger than ");
        sb.append((1 << numBits) - 1);
        throw new WriterException(sb.toString());
    }

    /* renamed from: a */
    static void m33479a(String content, C10264b mode, C10208a bits, String encoding) throws WriterException {
        int i = C10270c.f31127a[mode.ordinal()];
        if (i == 1) {
            m33483b(content, bits);
        } else if (i == 2) {
            m33476a((CharSequence) content, bits);
        } else if (i == 3) {
            m33478a(content, bits, encoding);
        } else if (i == 4) {
            m33477a(content, bits);
        } else {
            StringBuilder sb = new StringBuilder("Invalid mode: ");
            sb.append(mode);
            throw new WriterException(sb.toString());
        }
    }

    /* renamed from: b */
    static void m33483b(CharSequence content, C10208a bits) {
        int length = content.length();
        int i = 0;
        while (i < length) {
            int num1 = content.charAt(i) - '0';
            if (i + 2 < length) {
                bits.mo33520a((num1 * 100) + ((content.charAt(i + 1) - '0') * 10) + (content.charAt(i + 2) - '0'), 10);
                i += 3;
            } else if (i + 1 < length) {
                bits.mo33520a((num1 * 10) + (content.charAt(i + 1) - '0'), 7);
                i += 2;
            } else {
                bits.mo33520a(num1, 4);
                i++;
            }
        }
    }

    /* renamed from: a */
    static void m33476a(CharSequence content, C10208a bits) throws WriterException {
        int length = content.length();
        int i = 0;
        while (i < length) {
            int a = m33462a((int) content.charAt(i));
            int code1 = a;
            if (a == -1) {
                throw new WriterException();
            } else if (i + 1 < length) {
                int a2 = m33462a((int) content.charAt(i + 1));
                int code2 = a2;
                if (a2 != -1) {
                    bits.mo33520a((code1 * 45) + code2, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                bits.mo33520a(code1, 6);
                i++;
            }
        }
    }

    /* renamed from: a */
    static void m33478a(String content, C10208a bits, String encoding) throws WriterException {
        try {
            for (byte b : content.getBytes(encoding)) {
                bits.mo33520a(b, 8);
            }
        } catch (UnsupportedEncodingException uee) {
            throw new WriterException((Throwable) uee);
        }
    }

    /* renamed from: a */
    static void m33477a(String content, C10208a bits) throws WriterException {
        try {
            byte[] bytes = content.getBytes("Shift_JIS");
            int length = bytes.length;
            int i = 0;
            while (i < length) {
                int code = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                int subtracted = -1;
                if (code >= 33088 && code <= 40956) {
                    subtracted = code - 33088;
                } else if (code >= 57408 && code <= 60351) {
                    subtracted = code - 49472;
                }
                if (subtracted != -1) {
                    bits.mo33520a(((subtracted >> 8) * Opcodes.CHECKCAST) + (subtracted & 255), 13);
                    i += 2;
                } else {
                    throw new WriterException("Invalid byte sequence");
                }
            }
        } catch (UnsupportedEncodingException uee) {
            throw new WriterException((Throwable) uee);
        }
    }

    /* renamed from: a */
    private static void m33474a(C10210c eci, C10208a bits) {
        bits.mo33520a(C10264b.ECI.mo33617e(), 4);
        bits.mo33520a(eci.mo33542e(), 8);
    }
}
