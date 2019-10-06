package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

public final class Base64Variant implements Serializable {
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final transient int _maxLineLength;
    final String _name;
    private final transient char _paddingChar;
    private final transient boolean _usesPadding;

    public Base64Variant(String name, String base64Alphabet, boolean usesPadding, char paddingChar, int maxLineLength) {
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = name;
        this._usesPadding = usesPadding;
        this._paddingChar = paddingChar;
        this._maxLineLength = maxLineLength;
        int alphaLen = base64Alphabet.length();
        if (alphaLen == 64) {
            base64Alphabet.getChars(0, alphaLen, this._base64ToAsciiC, 0);
            Arrays.fill(this._asciiToBase64, -1);
            for (int i = 0; i < alphaLen; i++) {
                char alpha = this._base64ToAsciiC[i];
                this._base64ToAsciiB[i] = (byte) alpha;
                this._asciiToBase64[alpha] = i;
            }
            if (usesPadding) {
                this._asciiToBase64[paddingChar] = -2;
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Base64Alphabet length must be exactly 64 (was ");
        sb.append(alphaLen);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public Base64Variant(Base64Variant base, String name, int maxLineLength) {
        this(base, name, base._usesPadding, base._paddingChar, maxLineLength);
    }

    public Base64Variant(Base64Variant base, String name, boolean usesPadding, char paddingChar, int maxLineLength) {
        this._asciiToBase64 = new int[128];
        this._base64ToAsciiC = new char[64];
        this._base64ToAsciiB = new byte[64];
        this._name = name;
        byte[] srcB = base._base64ToAsciiB;
        System.arraycopy(srcB, 0, this._base64ToAsciiB, 0, srcB.length);
        char[] srcC = base._base64ToAsciiC;
        System.arraycopy(srcC, 0, this._base64ToAsciiC, 0, srcC.length);
        int[] srcV = base._asciiToBase64;
        System.arraycopy(srcV, 0, this._asciiToBase64, 0, srcV.length);
        this._usesPadding = usesPadding;
        this._paddingChar = paddingChar;
        this._maxLineLength = maxLineLength;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c) {
        return c == this._paddingChar;
    }

    public boolean usesPaddingChar(int ch) {
        return ch == this._paddingChar;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public int decodeBase64Char(char c) {
        int ch = c;
        if (ch <= 127) {
            return this._asciiToBase64[ch];
        }
        return -1;
    }

    public int decodeBase64Char(int ch) {
        if (ch <= 127) {
            return this._asciiToBase64[ch];
        }
        return -1;
    }

    public int encodeBase64Chunk(int b24, char[] buffer, int ptr) {
        int ptr2 = ptr + 1;
        char[] cArr = this._base64ToAsciiC;
        buffer[ptr] = cArr[(b24 >> 18) & 63];
        int ptr3 = ptr2 + 1;
        buffer[ptr2] = cArr[(b24 >> 12) & 63];
        int ptr4 = ptr3 + 1;
        buffer[ptr3] = cArr[(b24 >> 6) & 63];
        int ptr5 = ptr4 + 1;
        buffer[ptr4] = cArr[b24 & 63];
        return ptr5;
    }

    public void encodeBase64Chunk(StringBuilder sb, int b24) {
        sb.append(this._base64ToAsciiC[(b24 >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(b24 >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(b24 >> 6) & 63]);
        sb.append(this._base64ToAsciiC[b24 & 63]);
    }

    public int encodeBase64Partial(int bits, int outputBytes, char[] buffer, int outPtr) {
        int outPtr2 = outPtr + 1;
        char[] cArr = this._base64ToAsciiC;
        buffer[outPtr] = cArr[(bits >> 18) & 63];
        int outPtr3 = outPtr2 + 1;
        buffer[outPtr2] = cArr[(bits >> 12) & 63];
        if (this._usesPadding) {
            int outPtr4 = outPtr3 + 1;
            buffer[outPtr3] = outputBytes == 2 ? cArr[(bits >> 6) & 63] : this._paddingChar;
            int outPtr5 = outPtr4 + 1;
            buffer[outPtr4] = this._paddingChar;
            return outPtr5;
        } else if (outputBytes != 2) {
            return outPtr3;
        } else {
            int outPtr6 = outPtr3 + 1;
            buffer[outPtr3] = cArr[(bits >> 6) & 63];
            return outPtr6;
        }
    }

    public void encodeBase64Partial(StringBuilder sb, int bits, int outputBytes) {
        sb.append(this._base64ToAsciiC[(bits >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(bits >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(outputBytes == 2 ? this._base64ToAsciiC[(bits >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (outputBytes == 2) {
            sb.append(this._base64ToAsciiC[(bits >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int b24, byte[] buffer, int ptr) {
        int ptr2 = ptr + 1;
        byte[] bArr = this._base64ToAsciiB;
        buffer[ptr] = bArr[(b24 >> 18) & 63];
        int ptr3 = ptr2 + 1;
        buffer[ptr2] = bArr[(b24 >> 12) & 63];
        int ptr4 = ptr3 + 1;
        buffer[ptr3] = bArr[(b24 >> 6) & 63];
        int ptr5 = ptr4 + 1;
        buffer[ptr4] = bArr[b24 & 63];
        return ptr5;
    }

    public int encodeBase64Partial(int bits, int outputBytes, byte[] buffer, int outPtr) {
        int outPtr2 = outPtr + 1;
        byte[] bArr = this._base64ToAsciiB;
        buffer[outPtr] = bArr[(bits >> 18) & 63];
        int outPtr3 = outPtr2 + 1;
        buffer[outPtr2] = bArr[(bits >> 12) & 63];
        if (this._usesPadding) {
            byte pb = (byte) this._paddingChar;
            int outPtr4 = outPtr3 + 1;
            buffer[outPtr3] = outputBytes == 2 ? bArr[(bits >> 6) & 63] : pb;
            int outPtr5 = outPtr4 + 1;
            buffer[outPtr4] = pb;
            return outPtr5;
        } else if (outputBytes != 2) {
            return outPtr3;
        } else {
            int outPtr6 = outPtr3 + 1;
            buffer[outPtr3] = bArr[(bits >> 6) & 63];
            return outPtr6;
        }
    }

    public String encode(byte[] input) {
        return encode(input, false);
    }

    public String encode(byte[] input, boolean addQuotes) {
        int inputEnd = input.length;
        StringBuilder sb = new StringBuilder((inputEnd >> 2) + inputEnd + (inputEnd >> 3));
        if (addQuotes) {
            sb.append('\"');
        }
        int chunksBeforeLF = getMaxLineLength() >> 2;
        int b24 = 0;
        int safeInputEnd = inputEnd - 3;
        while (b24 <= safeInputEnd) {
            int inputPtr = b24 + 1;
            int inputPtr2 = inputPtr + 1;
            int inputPtr3 = inputPtr2 + 1;
            encodeBase64Chunk(sb, (((input[b24] << 8) | (input[inputPtr] & 255)) << 8) | (input[inputPtr2] & 255));
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                sb.append('\\');
                sb.append('n');
                chunksBeforeLF = getMaxLineLength() >> 2;
            }
            b24 = inputPtr3;
        }
        int inputLeft = inputEnd - b24;
        if (inputLeft > 0) {
            int inputPtr4 = b24 + 1;
            int b242 = input[b24] << ExecutionDataWriter.BLOCK_SESSIONINFO;
            if (inputLeft == 2) {
                int i = inputPtr4 + 1;
                b242 |= (input[inputPtr4] & 255) << 8;
            }
            encodeBase64Partial(sb, b242, inputLeft);
        } else {
            int inputPtr5 = b24;
        }
        if (addQuotes) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public byte[] decode(String input) throws IllegalArgumentException {
        ByteArrayBuilder b = new ByteArrayBuilder();
        decode(input, b);
        return b.toByteArray();
    }

    public void decode(String str, ByteArrayBuilder builder) throws IllegalArgumentException {
        int ptr = 0;
        int len = str.length();
        while (ptr < len) {
            int ptr2 = ptr + 1;
            char ch = str.charAt(ptr);
            if (ch > ' ') {
                int bits = decodeBase64Char(ch);
                if (bits < 0) {
                    _reportInvalidBase64(ch, 0, null);
                }
                int decodedData = bits;
                if (ptr2 >= len) {
                    _reportBase64EOF();
                }
                int ptr3 = ptr2 + 1;
                char ch2 = str.charAt(ptr2);
                int bits2 = decodeBase64Char(ch2);
                if (bits2 < 0) {
                    _reportInvalidBase64(ch2, 1, null);
                }
                int decodedData2 = (decodedData << 6) | bits2;
                if (ptr3 >= len) {
                    if (!usesPadding()) {
                        builder.append(decodedData2 >> 4);
                        int i = ptr3;
                        return;
                    }
                    _reportBase64EOF();
                }
                int ptr4 = ptr3 + 1;
                char ch3 = str.charAt(ptr3);
                int bits3 = decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        _reportInvalidBase64(ch3, 2, null);
                    }
                    if (ptr4 >= len) {
                        _reportBase64EOF();
                    }
                    int ptr5 = ptr4 + 1;
                    char ch4 = str.charAt(ptr4);
                    if (!usesPaddingChar(ch4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected padding character '");
                        sb.append(getPaddingChar());
                        sb.append("'");
                        _reportInvalidBase64(ch4, 3, sb.toString());
                    }
                    builder.append(decodedData2 >> 4);
                    ptr = ptr5;
                } else {
                    int decodedData3 = (decodedData2 << 6) | bits3;
                    if (ptr4 >= len) {
                        if (!usesPadding()) {
                            builder.appendTwoBytes(decodedData3 >> 2);
                            int i2 = ptr4;
                            return;
                        }
                        _reportBase64EOF();
                    }
                    int ptr6 = ptr4 + 1;
                    char ch5 = str.charAt(ptr4);
                    int bits4 = decodeBase64Char(ch5);
                    if (bits4 < 0) {
                        if (bits4 != -2) {
                            _reportInvalidBase64(ch5, 3, null);
                        }
                        builder.appendTwoBytes(decodedData3 >> 2);
                    } else {
                        builder.appendThreeBytes((decodedData3 << 6) | bits4);
                    }
                    ptr = ptr6;
                }
            } else {
                ptr = ptr2;
            }
        }
    }

    public String toString() {
        return this._name;
    }

    public boolean equals(Object o) {
        return o == this;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidBase64(char ch, int bindex, String msg) throws IllegalArgumentException {
        String base;
        if (ch <= ' ') {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal white space character (code 0x");
            sb.append(Integer.toHexString(ch));
            sb.append(") as character #");
            sb.append(bindex + 1);
            sb.append(" of 4-char base64 unit: can only used between units");
            base = sb.toString();
        } else if (usesPaddingChar(ch)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected padding character ('");
            sb2.append(getPaddingChar());
            sb2.append("') as character #");
            sb2.append(bindex + 1);
            sb2.append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
            base = sb2.toString();
        } else {
            String str = ") in base64 content";
            if (!Character.isDefined(ch) || Character.isISOControl(ch)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Illegal character (code 0x");
                sb3.append(Integer.toHexString(ch));
                sb3.append(str);
                base = sb3.toString();
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Illegal character '");
                sb4.append(ch);
                sb4.append("' (code 0x");
                sb4.append(Integer.toHexString(ch));
                sb4.append(str);
                base = sb4.toString();
            }
        }
        if (msg != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(base);
            sb5.append(": ");
            sb5.append(msg);
            base = sb5.toString();
        }
        throw new IllegalArgumentException(base);
    }

    /* access modifiers changed from: protected */
    public void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }
}
