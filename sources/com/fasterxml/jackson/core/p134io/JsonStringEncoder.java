package com.fasterxml.jackson.core.p134io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fasterxml.jackson.core.io.JsonStringEncoder */
public final class JsonStringEncoder {

    /* renamed from: HB */
    private static final byte[] f12550HB = CharTypes.copyHexBytes();

    /* renamed from: HC */
    private static final char[] f12551HC = CharTypes.copyHexChars();
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf = new char[6];
    protected TextBuffer _text;

    public JsonStringEncoder() {
        char[] cArr = this._qbuf;
        cArr[0] = '\\';
        cArr[2] = '0';
        cArr[3] = '0';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r8 >= 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r9 = _appendNumeric(r4, r14._qbuf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r9 = _appendNamed(r8, r14._qbuf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if ((r6 + r9) <= r1.length) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r10 = r1.length - r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r10 <= 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        java.lang.System.arraycopy(r14._qbuf, 0, r1, r6, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r1 = r0.finishCurrentSegment();
        r11 = r9 - r10;
        java.lang.System.arraycopy(r14._qbuf, r10, r1, 0, r11);
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        java.lang.System.arraycopy(r14._qbuf, 0, r1, r6, r9);
        r6 = r6 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        r7 = r4 + 1;
        r4 = r15.charAt(r4);
        r8 = r2[r4];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public char[] quoteAsString(java.lang.String r15) {
        /*
            r14 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r14._text
            if (r0 != 0) goto L_0x000d
            com.fasterxml.jackson.core.util.TextBuffer r1 = new com.fasterxml.jackson.core.util.TextBuffer
            r2 = 0
            r1.<init>(r2)
            r0 = r1
            r14._text = r1
        L_0x000d:
            char[] r1 = r0.emptyAndGetCurrentSegment()
            int[] r2 = com.fasterxml.jackson.core.p134io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            r4 = 0
            int r5 = r15.length()
            r6 = 0
        L_0x001c:
            if (r4 >= r5) goto L_0x0078
        L_0x001e:
            char r7 = r15.charAt(r4)
            if (r7 >= r3) goto L_0x0064
            r8 = r2[r7]
            if (r8 == 0) goto L_0x0064
            int r7 = r4 + 1
            char r4 = r15.charAt(r4)
            r8 = r2[r4]
            if (r8 >= 0) goto L_0x003a
            char[] r9 = r14._qbuf
            int r9 = r14._appendNumeric(r4, r9)
            goto L_0x0040
        L_0x003a:
            char[] r9 = r14._qbuf
            int r9 = r14._appendNamed(r8, r9)
        L_0x0040:
            int r10 = r6 + r9
            int r11 = r1.length
            r12 = 0
            if (r10 <= r11) goto L_0x005c
            int r10 = r1.length
            int r10 = r10 - r6
            if (r10 <= 0) goto L_0x004f
            char[] r11 = r14._qbuf
            java.lang.System.arraycopy(r11, r12, r1, r6, r10)
        L_0x004f:
            char[] r1 = r0.finishCurrentSegment()
            int r11 = r9 - r10
            char[] r13 = r14._qbuf
            java.lang.System.arraycopy(r13, r10, r1, r12, r11)
            r6 = r11
            goto L_0x0062
        L_0x005c:
            char[] r10 = r14._qbuf
            java.lang.System.arraycopy(r10, r12, r1, r6, r9)
            int r6 = r6 + r9
        L_0x0062:
            r4 = r7
            goto L_0x001c
        L_0x0064:
            int r8 = r1.length
            if (r6 < r8) goto L_0x006c
            char[] r1 = r0.finishCurrentSegment()
            r6 = 0
        L_0x006c:
            int r8 = r6 + 1
            r1[r6] = r7
            int r4 = r4 + 1
            if (r4 < r5) goto L_0x0076
            r6 = r8
            goto L_0x0078
        L_0x0076:
            r6 = r8
            goto L_0x001e
        L_0x0078:
            r0.setCurrentLength(r6)
            char[] r7 = r0.contentsAsArray()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p134io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r4 < r5.length) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r7 = r2 + 1;
        r2 = r11.charAt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r2 > 127) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r4 = _appendByte(r2, r6[r2], r0, r4);
        r5 = r0.getCurrentSegment();
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r2 > 2047) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r8 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 6) | org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes.CHECKCAST);
        r2 = (r2 & 63) | 128;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r2 < 55296) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        if (r2 <= 57343) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        if (r2 > 56319) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        if (r7 >= r3) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0082, code lost:
        r8 = r7 + 1;
        r2 = _convert(r2, r11.charAt(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r2 > 1114111) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r7 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 18) | 240);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009b, code lost:
        if (r7 < r5.length) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009d, code lost:
        r5 = r0.finishCurrentSegment();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        r4 = r7 + 1;
        r5[r7] = (byte) (((r2 >> 12) & 63) | 128);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        if (r4 < r5.length) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        r7 = r4 + 1;
        r5[r4] = (byte) (((r2 >> 6) & 63) | 128);
        r2 = (r2 & 63) | 128;
        r4 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c7, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ca, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cb, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ce, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cf, code lost:
        _illegal(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r8 = r4 + 1;
        r5[r4] = (byte) ((r2 >> 12) | 224);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r8 < r5.length) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00df, code lost:
        r5 = r0.finishCurrentSegment();
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e4, code lost:
        r4 = r8 + 1;
        r5[r8] = (byte) (((r2 >> 6) & 63) | 128);
        r2 = (r2 & 63) | 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f4, code lost:
        if (r4 < r5.length) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r5 = r0.finishCurrentSegment();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fb, code lost:
        r8 = r4 + 1;
        r5[r4] = (byte) r2;
        r2 = r7;
        r4 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] quoteAsUTF8(java.lang.String r11) {
        /*
            r10 = this;
            com.fasterxml.jackson.core.util.ByteArrayBuilder r0 = r10._bytes
            r1 = 0
            if (r0 != 0) goto L_0x000d
            com.fasterxml.jackson.core.util.ByteArrayBuilder r2 = new com.fasterxml.jackson.core.util.ByteArrayBuilder
            r2.<init>(r1)
            r0 = r2
            r10._bytes = r2
        L_0x000d:
            r2 = 0
            int r3 = r11.length()
            r4 = 0
            byte[] r5 = r0.resetAndGetFirstSegment()
        L_0x0017:
            if (r2 >= r3) goto L_0x0104
            int[] r6 = com.fasterxml.jackson.core.p134io.CharTypes.get7BitOutputEscapes()
        L_0x001d:
            char r7 = r11.charAt(r2)
            r8 = 127(0x7f, float:1.78E-43)
            if (r7 > r8) goto L_0x0040
            r9 = r6[r7]
            if (r9 == 0) goto L_0x002a
            goto L_0x0040
        L_0x002a:
            int r8 = r5.length
            if (r4 < r8) goto L_0x0032
            byte[] r5 = r0.finishCurrentSegment()
            r4 = 0
        L_0x0032:
            int r8 = r4 + 1
            byte r9 = (byte) r7
            r5[r4] = r9
            int r2 = r2 + 1
            if (r2 < r3) goto L_0x003e
            r4 = r8
            goto L_0x0104
        L_0x003e:
            r4 = r8
            goto L_0x001d
        L_0x0040:
            int r7 = r5.length
            if (r4 < r7) goto L_0x0048
            byte[] r5 = r0.finishCurrentSegment()
            r4 = 0
        L_0x0048:
            int r7 = r2 + 1
            char r2 = r11.charAt(r2)
            if (r2 > r8) goto L_0x005c
            r8 = r6[r2]
            int r4 = r10._appendByte(r2, r8, r0, r4)
            byte[] r5 = r0.getCurrentSegment()
            r2 = r7
            goto L_0x0017
        L_0x005c:
            r8 = 2047(0x7ff, float:2.868E-42)
            if (r2 > r8) goto L_0x0070
            int r8 = r4 + 1
            int r9 = r2 >> 6
            r9 = r9 | 192(0xc0, float:2.69E-43)
            byte r9 = (byte) r9
            r5[r4] = r9
            r4 = r2 & 63
            r2 = r4 | 128(0x80, float:1.794E-43)
            r4 = r8
            goto L_0x00f3
        L_0x0070:
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r8) goto L_0x00d3
            r8 = 57343(0xdfff, float:8.0355E-41)
            if (r2 <= r8) goto L_0x007b
            goto L_0x00d3
        L_0x007b:
            r8 = 56319(0xdbff, float:7.892E-41)
            if (r2 > r8) goto L_0x00cf
            if (r7 >= r3) goto L_0x00cb
            int r8 = r7 + 1
            char r7 = r11.charAt(r7)
            int r2 = _convert(r2, r7)
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r2 > r7) goto L_0x00c7
            int r7 = r4 + 1
            int r9 = r2 >> 18
            r9 = r9 | 240(0xf0, float:3.36E-43)
            byte r9 = (byte) r9
            r5[r4] = r9
            int r4 = r5.length
            if (r7 < r4) goto L_0x00a2
            byte[] r5 = r0.finishCurrentSegment()
            r7 = 0
        L_0x00a2:
            int r4 = r7 + 1
            int r9 = r2 >> 12
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r7] = r9
            int r7 = r5.length
            if (r4 < r7) goto L_0x00b5
            byte[] r5 = r0.finishCurrentSegment()
            r4 = 0
        L_0x00b5:
            int r7 = r4 + 1
            int r9 = r2 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r4] = r9
            r4 = r2 & 63
            r2 = r4 | 128(0x80, float:1.794E-43)
            r4 = r7
            r7 = r8
            goto L_0x00f3
        L_0x00c7:
            _illegal(r2)
            throw r1
        L_0x00cb:
            _illegal(r2)
            throw r1
        L_0x00cf:
            _illegal(r2)
            throw r1
        L_0x00d3:
            int r8 = r4 + 1
            int r9 = r2 >> 12
            r9 = r9 | 224(0xe0, float:3.14E-43)
            byte r9 = (byte) r9
            r5[r4] = r9
            int r4 = r5.length
            if (r8 < r4) goto L_0x00e4
            byte[] r5 = r0.finishCurrentSegment()
            r8 = 0
        L_0x00e4:
            int r4 = r8 + 1
            int r9 = r2 >> 6
            r9 = r9 & 63
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9
            r5[r8] = r9
            r8 = r2 & 63
            r2 = r8 | 128(0x80, float:1.794E-43)
        L_0x00f3:
            int r8 = r5.length
            if (r4 < r8) goto L_0x00fb
            byte[] r5 = r0.finishCurrentSegment()
            r4 = 0
        L_0x00fb:
            int r8 = r4 + 1
            byte r9 = (byte) r2
            r5[r4] = r9
            r2 = r7
            r4 = r8
            goto L_0x0017
        L_0x0104:
            com.fasterxml.jackson.core.util.ByteArrayBuilder r1 = r10._bytes
            byte[] r1 = r1.completeAndCoalesce(r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p134io.JsonStringEncoder.quoteAsUTF8(java.lang.String):byte[]");
    }

    public byte[] encodeAsUTF8(String text) {
        int outputPtr;
        ByteArrayBuilder byteBuilder = this._bytes;
        if (byteBuilder == null) {
            ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            byteBuilder = byteArrayBuilder;
            this._bytes = byteArrayBuilder;
        }
        int c = 0;
        int inputEnd = text.length();
        int outputPtr2 = 0;
        byte[] outputBuffer = byteBuilder.resetAndGetFirstSegment();
        int outputEnd = outputBuffer.length;
        loop0:
        while (true) {
            if (c >= inputEnd) {
                break;
            }
            int inputPtr = c + 1;
            int c2 = text.charAt(c);
            while (c2 <= 127) {
                if (outputPtr2 >= outputEnd) {
                    outputBuffer = byteBuilder.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr2 = 0;
                }
                int outputPtr3 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) c2;
                if (inputPtr >= inputEnd) {
                    int c3 = inputPtr;
                    outputPtr2 = outputPtr3;
                    break loop0;
                }
                int inputPtr2 = inputPtr + 1;
                c2 = text.charAt(inputPtr);
                inputPtr = inputPtr2;
                outputPtr2 = outputPtr3;
            }
            if (outputPtr2 >= outputEnd) {
                outputBuffer = byteBuilder.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr2 = 0;
            }
            if (c2 < 2048) {
                int outputPtr4 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) ((c2 >> 6) | Opcodes.CHECKCAST);
                outputPtr = outputPtr4;
            } else if (c2 < 55296 || c2 > 57343) {
                int outputPtr5 = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) ((c2 >> 12) | 224);
                if (outputPtr5 >= outputEnd) {
                    outputBuffer = byteBuilder.finishCurrentSegment();
                    outputEnd = outputBuffer.length;
                    outputPtr5 = 0;
                }
                outputPtr = outputPtr5 + 1;
                outputBuffer[outputPtr5] = (byte) (((c2 >> 6) & 63) | 128);
            } else if (c2 > 56319) {
                _illegal(c2);
                throw null;
            } else if (inputPtr < inputEnd) {
                int inputPtr3 = inputPtr + 1;
                c2 = _convert(c2, text.charAt(inputPtr));
                if (c2 <= 1114111) {
                    int outputPtr6 = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) ((c2 >> 18) | 240);
                    if (outputPtr6 >= outputEnd) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputEnd = outputBuffer.length;
                        outputPtr6 = 0;
                    }
                    int outputPtr7 = outputPtr6 + 1;
                    outputBuffer[outputPtr6] = (byte) (((c2 >> 12) & 63) | 128);
                    if (outputPtr7 >= outputEnd) {
                        outputBuffer = byteBuilder.finishCurrentSegment();
                        outputEnd = outputBuffer.length;
                        outputPtr7 = 0;
                    }
                    int outputPtr8 = outputPtr7 + 1;
                    outputBuffer[outputPtr7] = (byte) (((c2 >> 6) & 63) | 128);
                    outputPtr = outputPtr8;
                    inputPtr = inputPtr3;
                } else {
                    _illegal(c2);
                    throw null;
                }
            } else {
                _illegal(c2);
                throw null;
            }
            if (outputPtr >= outputEnd) {
                outputBuffer = byteBuilder.finishCurrentSegment();
                outputEnd = outputBuffer.length;
                outputPtr = 0;
            }
            int outputPtr9 = outputPtr + 1;
            outputBuffer[outputPtr] = (byte) ((c2 & 63) | 128);
            c = inputPtr;
            outputPtr2 = outputPtr9;
        }
        return this._bytes.completeAndCoalesce(outputPtr2);
    }

    private int _appendNumeric(int value, char[] qbuf) {
        qbuf[1] = 'u';
        char[] cArr = f12551HC;
        qbuf[4] = cArr[value >> 4];
        qbuf[5] = cArr[value & 15];
        return 6;
    }

    private int _appendNamed(int esc, char[] qbuf) {
        qbuf[1] = (char) esc;
        return 2;
    }

    private int _appendByte(int ch, int esc, ByteArrayBuilder bb, int ptr) {
        bb.setCurrentSegmentLength(ptr);
        bb.append(92);
        if (esc < 0) {
            bb.append(117);
            if (ch > 255) {
                int hi = ch >> 8;
                bb.append(f12550HB[hi >> 4]);
                bb.append(f12550HB[hi & 15]);
                ch &= 255;
            } else {
                bb.append(48);
                bb.append(48);
            }
            bb.append(f12550HB[ch >> 4]);
            bb.append(f12550HB[ch & 15]);
        } else {
            bb.append((byte) esc);
        }
        return bb.getCurrentSegmentLength();
    }

    private static int _convert(int p1, int p2) {
        if (p2 >= 56320 && p2 <= 57343) {
            return ((p1 - 55296) << 10) + 65536 + (p2 - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(p1));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(p2));
        sb.append("; illegal combination");
        throw new IllegalArgumentException(sb.toString());
    }

    private static void _illegal(int c) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(c));
    }
}
