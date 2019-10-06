package com.fasterxml.jackson.core.p134io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fasterxml.jackson.core.io.UTF8Writer */
public final class UTF8Writer extends Writer {
    private final IOContext _context;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd = (this._outBuffer.length - 4);
    private int _outPtr = 0;
    private int _surrogate;

    public UTF8Writer(IOContext ctxt, OutputStream out) {
        this._context = ctxt;
        this._out = out;
        this._outBuffer = ctxt.allocWriteEncodingBuffer();
    }

    public Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public void close() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            OutputStream out = this._out;
            this._out = null;
            byte[] buf = this._outBuffer;
            if (buf != null) {
                this._outBuffer = null;
                this._context.releaseWriteEncodingBuffer(buf);
            }
            out.close();
            int code = this._surrogate;
            this._surrogate = 0;
            if (code > 0) {
                illegalSurrogate(code);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i = this._outPtr;
            if (i > 0) {
                outputStream.write(this._outBuffer, 0, i);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r11v3, types: [char, int] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(char[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 2
            if (r12 >= r0) goto L_0x000c
            r0 = 1
            if (r12 != r0) goto L_0x000b
            char r0 = r10[r11]
            r9.write(r0)
        L_0x000b:
            return
        L_0x000c:
            int r0 = r9._surrogate
            if (r0 <= 0) goto L_0x001e
            int r0 = r11 + 1
            char r11 = r10[r11]
            int r12 = r12 + -1
            int r1 = r9.convertSurrogate(r11)
            r9.write(r1)
            r11 = r0
        L_0x001e:
            int r0 = r9._outPtr
            byte[] r1 = r9._outBuffer
            int r2 = r9._outBufferEnd
            int r12 = r12 + r11
        L_0x0025:
            if (r11 >= r12) goto L_0x00eb
            if (r0 < r2) goto L_0x0030
            java.io.OutputStream r3 = r9._out
            r4 = 0
            r3.write(r1, r4, r0)
            r0 = 0
        L_0x0030:
            int r3 = r11 + 1
            char r11 = r10[r11]
            r4 = 128(0x80, float:1.794E-43)
            if (r11 >= r4) goto L_0x005d
            int r5 = r0 + 1
            byte r6 = (byte) r11
            r1[r0] = r6
            int r0 = r12 - r3
            int r6 = r2 - r5
            if (r0 <= r6) goto L_0x0044
            r0 = r6
        L_0x0044:
            int r7 = r0 + r3
            r0 = r11
            r11 = r3
        L_0x0048:
            if (r11 < r7) goto L_0x004c
            r0 = r5
            goto L_0x0025
        L_0x004c:
            int r3 = r11 + 1
            char r0 = r10[r11]
            if (r0 < r4) goto L_0x0055
            r11 = r0
            r0 = r5
            goto L_0x005d
        L_0x0055:
            int r11 = r5 + 1
            byte r8 = (byte) r0
            r1[r5] = r8
            r5 = r11
            r11 = r3
            goto L_0x0048
        L_0x005d:
            r5 = 2048(0x800, float:2.87E-42)
            if (r11 >= r5) goto L_0x0074
            int r5 = r0 + 1
            int r6 = r11 >> 6
            r6 = r6 | 192(0xc0, float:2.69E-43)
            byte r6 = (byte) r6
            r1[r0] = r6
            int r0 = r5 + 1
            r6 = r11 & 63
            r4 = r4 | r6
            byte r4 = (byte) r4
            r1[r5] = r4
            r11 = r3
            goto L_0x00be
        L_0x0074:
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r11 < r5) goto L_0x00cc
            r5 = 57343(0xdfff, float:8.0355E-41)
            if (r11 <= r5) goto L_0x007f
            goto L_0x00cc
        L_0x007f:
            r5 = 56319(0xdbff, float:7.892E-41)
            r6 = 0
            if (r11 > r5) goto L_0x00c6
            r9._surrogate = r11
            if (r3 < r12) goto L_0x008b
            r11 = r3
            goto L_0x00eb
        L_0x008b:
            int r5 = r3 + 1
            char r3 = r10[r3]
            int r11 = r9.convertSurrogate(r3)
            r3 = 1114111(0x10ffff, float:1.561202E-39)
            if (r11 > r3) goto L_0x00c0
            int r3 = r0 + 1
            int r6 = r11 >> 18
            r6 = r6 | 240(0xf0, float:3.36E-43)
            byte r6 = (byte) r6
            r1[r0] = r6
            int r0 = r3 + 1
            int r6 = r11 >> 12
            r6 = r6 & 63
            r6 = r6 | r4
            byte r6 = (byte) r6
            r1[r3] = r6
            int r3 = r0 + 1
            int r6 = r11 >> 6
            r6 = r6 & 63
            r6 = r6 | r4
            byte r6 = (byte) r6
            r1[r0] = r6
            int r0 = r3 + 1
            r6 = r11 & 63
            r4 = r4 | r6
            byte r4 = (byte) r4
            r1[r3] = r4
            r11 = r5
        L_0x00be:
            goto L_0x0025
        L_0x00c0:
            r9._outPtr = r0
            illegalSurrogate(r11)
            throw r6
        L_0x00c6:
            r9._outPtr = r0
            illegalSurrogate(r11)
            throw r6
        L_0x00cc:
            int r5 = r0 + 1
            int r6 = r11 >> 12
            r6 = r6 | 224(0xe0, float:3.14E-43)
            byte r6 = (byte) r6
            r1[r0] = r6
            int r0 = r5 + 1
            int r6 = r11 >> 6
            r6 = r6 & 63
            r6 = r6 | r4
            byte r6 = (byte) r6
            r1[r5] = r6
            int r5 = r0 + 1
            r6 = r11 & 63
            r4 = r4 | r6
            byte r4 = (byte) r4
            r1[r0] = r4
            r11 = r3
            r0 = r5
            goto L_0x0025
        L_0x00eb:
            r9._outPtr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.p134io.UTF8Writer.write(char[], int, int):void");
    }

    public void write(int c) throws IOException {
        int ptr;
        if (this._surrogate > 0) {
            c = convertSurrogate(c);
        } else if (c >= 55296 && c <= 57343) {
            if (c <= 56319) {
                this._surrogate = c;
                return;
            } else {
                illegalSurrogate(c);
                throw null;
            }
        }
        int i = this._outPtr;
        if (i >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i);
            this._outPtr = 0;
        }
        if (c < 128) {
            byte[] bArr = this._outBuffer;
            int i2 = this._outPtr;
            this._outPtr = i2 + 1;
            bArr[i2] = (byte) c;
        } else {
            int ptr2 = this._outPtr;
            if (c < 2048) {
                byte[] bArr2 = this._outBuffer;
                int ptr3 = ptr2 + 1;
                bArr2[ptr2] = (byte) ((c >> 6) | Opcodes.CHECKCAST);
                ptr = ptr3 + 1;
                bArr2[ptr3] = (byte) (128 | (c & 63));
            } else if (c <= 65535) {
                byte[] bArr3 = this._outBuffer;
                int ptr4 = ptr2 + 1;
                bArr3[ptr2] = (byte) ((c >> 12) | 224);
                int ptr5 = ptr4 + 1;
                bArr3[ptr4] = (byte) (((c >> 6) & 63) | 128);
                int ptr6 = ptr5 + 1;
                bArr3[ptr5] = (byte) (128 | (c & 63));
                ptr = ptr6;
            } else if (c <= 1114111) {
                byte[] bArr4 = this._outBuffer;
                int ptr7 = ptr2 + 1;
                bArr4[ptr2] = (byte) ((c >> 18) | 240);
                int ptr8 = ptr7 + 1;
                bArr4[ptr7] = (byte) (((c >> 12) & 63) | 128);
                int ptr9 = ptr8 + 1;
                bArr4[ptr8] = (byte) (((c >> 6) & 63) | 128);
                ptr = ptr9 + 1;
                bArr4[ptr9] = (byte) (128 | (c & 63));
            } else {
                illegalSurrogate(c);
                throw null;
            }
            this._outPtr = ptr;
        }
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int outPtr, int len) throws IOException {
        if (len < 2) {
            if (len == 1) {
                write((int) str.charAt(outPtr));
            }
            return;
        }
        if (this._surrogate > 0) {
            int off = outPtr + 1;
            len--;
            write(convertSurrogate(str.charAt(outPtr)));
            outPtr = off;
        }
        int outPtr2 = this._outPtr;
        byte[] outBuf = this._outBuffer;
        int outBufLast = this._outBufferEnd;
        int len2 = len + outPtr;
        while (true) {
            if (outPtr >= len2) {
                break;
            }
            if (outPtr2 >= outBufLast) {
                this._out.write(outBuf, 0, outPtr2);
                outPtr2 = 0;
            }
            int off2 = outPtr + 1;
            int outPtr3 = str.charAt(outPtr);
            if (outPtr3 < 128) {
                int outPtr4 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) outPtr3;
                int maxInCount = len2 - off2;
                int maxOutCount = outBufLast - outPtr4;
                if (maxInCount > maxOutCount) {
                    maxInCount = maxOutCount;
                }
                int maxInCount2 = maxInCount + off2;
                int maxInCount3 = outPtr3;
                outPtr = off2;
                while (outPtr < maxInCount2) {
                    off2 = outPtr + 1;
                    int charAt = str.charAt(outPtr);
                    if (charAt >= 128) {
                        outPtr3 = charAt;
                        outPtr2 = outPtr4;
                    } else {
                        int outPtr5 = outPtr4 + 1;
                        outBuf[outPtr4] = (byte) charAt;
                        outPtr4 = outPtr5;
                        outPtr = off2;
                    }
                }
                outPtr2 = outPtr4;
            }
            if (outPtr3 < 2048) {
                int outPtr6 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((outPtr3 >> 6) | Opcodes.CHECKCAST);
                outPtr2 = outPtr6 + 1;
                outBuf[outPtr6] = (byte) (128 | (outPtr3 & 63));
                outPtr = off2;
            } else if (outPtr3 < 55296 || outPtr3 > 57343) {
                int outPtr7 = outPtr2 + 1;
                outBuf[outPtr2] = (byte) ((outPtr3 >> 12) | 224);
                int outPtr8 = outPtr7 + 1;
                outBuf[outPtr7] = (byte) (((outPtr3 >> 6) & 63) | 128);
                int outPtr9 = outPtr8 + 1;
                outBuf[outPtr8] = (byte) (128 | (outPtr3 & 63));
                outPtr = off2;
                outPtr2 = outPtr9;
            } else if (outPtr3 <= 56319) {
                this._surrogate = outPtr3;
                if (off2 >= len2) {
                    int c = off2;
                    break;
                }
                int off3 = off2 + 1;
                int c2 = convertSurrogate(str.charAt(off2));
                if (c2 <= 1114111) {
                    int outPtr10 = outPtr2 + 1;
                    outBuf[outPtr2] = (byte) ((c2 >> 18) | 240);
                    int outPtr11 = outPtr10 + 1;
                    outBuf[outPtr10] = (byte) (((c2 >> 12) & 63) | 128);
                    int outPtr12 = outPtr11 + 1;
                    outBuf[outPtr11] = (byte) (((c2 >> 6) & 63) | 128);
                    outPtr2 = outPtr12 + 1;
                    outBuf[outPtr12] = (byte) (128 | (c2 & 63));
                    outPtr = off3;
                } else {
                    this._outPtr = outPtr2;
                    illegalSurrogate(c2);
                    throw null;
                }
            } else {
                this._outPtr = outPtr2;
                illegalSurrogate(outPtr3);
                throw null;
            }
        }
        this._outPtr = outPtr2;
    }

    /* access modifiers changed from: protected */
    public int convertSurrogate(int secondPart) throws IOException {
        int firstPart = this._surrogate;
        this._surrogate = 0;
        if (secondPart >= 56320 && secondPart <= 57343) {
            return ((firstPart - 55296) << 10) + 65536 + (secondPart - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(firstPart));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(secondPart));
        sb.append("; illegal combination");
        throw new IOException(sb.toString());
    }

    protected static void illegalSurrogate(int code) throws IOException {
        throw new IOException(illegalSurrogateDesc(code));
    }

    protected static String illegalSurrogateDesc(int code) {
        String str = "Illegal character point (0x";
        if (code > 1114111) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Integer.toHexString(code));
            sb.append(") to output; max is 0x10FFFF as per RFC 4627");
            return sb.toString();
        } else if (code >= 55296) {
            String str2 = ")";
            if (code <= 56319) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unmatched first part of surrogate pair (0x");
                sb2.append(Integer.toHexString(code));
                sb2.append(str2);
                return sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unmatched second part of surrogate pair (0x");
            sb3.append(Integer.toHexString(code));
            sb3.append(str2);
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(Integer.toHexString(code));
            sb4.append(") to output");
            return sb4.toString();
        }
    }
}
