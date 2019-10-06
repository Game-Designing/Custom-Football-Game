package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.p134io.IOContext;
import com.fasterxml.jackson.core.p134io.MergedStream;
import com.fasterxml.jackson.core.p134io.UTF32Reader;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

public final class ByteSourceJsonBootstrapper {
    private boolean _bigEndian = true;
    private final boolean _bufferRecyclable;
    private int _bytesPerChar;
    private final IOContext _context;
    private final InputStream _in;
    private final byte[] _inputBuffer;
    private int _inputEnd;
    private int _inputPtr;

    public ByteSourceJsonBootstrapper(IOContext ctxt, InputStream in) {
        this._context = ctxt;
        this._in = in;
        this._inputBuffer = ctxt.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._bufferRecyclable = true;
    }

    public JsonEncoding detectEncoding() throws IOException {
        JsonEncoding enc;
        boolean foundEncoding = false;
        if (ensureLoaded(4)) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            int quad = (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO) | ((bArr[i + 2] & 255) << 8);
            if (handleBOM(quad)) {
                foundEncoding = true;
            } else if (checkUTF32(quad)) {
                foundEncoding = true;
            } else if (checkUTF16(quad >>> 16)) {
                foundEncoding = true;
            }
        } else if (ensureLoaded(2)) {
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            if (checkUTF16((bArr2[i2 + 1] & 255) | ((bArr2[i2] & 255) << 8))) {
                foundEncoding = true;
            }
        }
        if (!foundEncoding) {
            enc = JsonEncoding.UTF8;
        } else {
            int i3 = this._bytesPerChar;
            if (i3 == 1) {
                enc = JsonEncoding.UTF8;
            } else if (i3 == 2) {
                enc = this._bigEndian ? JsonEncoding.UTF16_BE : JsonEncoding.UTF16_LE;
            } else if (i3 == 4) {
                enc = this._bigEndian ? JsonEncoding.UTF32_BE : JsonEncoding.UTF32_LE;
            } else {
                throw new RuntimeException("Internal error");
            }
        }
        this._context.setEncoding(enc);
        return enc;
    }

    public Reader constructReader() throws IOException {
        JsonEncoding enc = this._context.getEncoding();
        int bits = enc.bits();
        if (bits == 8 || bits == 16) {
            InputStream in = this._in;
            if (in == 0) {
                in = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
            } else {
                int i = this._inputPtr;
                int i2 = this._inputEnd;
                if (i < i2) {
                    MergedStream mergedStream = new MergedStream(this._context, in, this._inputBuffer, i, i2);
                    in = mergedStream;
                }
            }
            return new InputStreamReader(in, enc.getJavaName());
        } else if (bits == 32) {
            IOContext iOContext = this._context;
            UTF32Reader uTF32Reader = new UTF32Reader(iOContext, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, iOContext.getEncoding().isBigEndian());
            return uTF32Reader;
        } else {
            throw new RuntimeException("Internal error");
        }
    }

    public JsonParser constructParser(int parserFeatures, ObjectCodec codec, ByteQuadsCanonicalizer rootByteSymbols, CharsToNameCanonicalizer rootCharSymbols, int factoryFeatures) throws IOException {
        int i = factoryFeatures;
        if (detectEncoding() != JsonEncoding.UTF8) {
            ByteQuadsCanonicalizer byteQuadsCanonicalizer = rootByteSymbols;
        } else if (Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i)) {
            UTF8StreamJsonParser uTF8StreamJsonParser = new UTF8StreamJsonParser(this._context, parserFeatures, this._in, codec, rootByteSymbols.makeChild(i), this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
            return uTF8StreamJsonParser;
        } else {
            ByteQuadsCanonicalizer byteQuadsCanonicalizer2 = rootByteSymbols;
        }
        ReaderBasedJsonParser readerBasedJsonParser = new ReaderBasedJsonParser(this._context, parserFeatures, constructReader(), codec, rootCharSymbols.makeChild(factoryFeatures));
        return readerBasedJsonParser;
    }

    private boolean handleBOM(int quad) throws IOException {
        if (quad == -16842752) {
            reportWeirdUCS4("3412");
            throw null;
        } else if (quad == -131072) {
            this._inputPtr += 4;
            this._bytesPerChar = 4;
            this._bigEndian = false;
            return true;
        } else if (quad == 65279) {
            this._bigEndian = true;
            this._inputPtr += 4;
            this._bytesPerChar = 4;
            return true;
        } else if (quad != 65534) {
            int msw = quad >>> 16;
            if (msw == 65279) {
                this._inputPtr += 2;
                this._bytesPerChar = 2;
                this._bigEndian = true;
                return true;
            } else if (msw == 65534) {
                this._inputPtr += 2;
                this._bytesPerChar = 2;
                this._bigEndian = false;
                return true;
            } else if ((quad >>> 8) != 15711167) {
                return false;
            } else {
                this._inputPtr += 3;
                this._bytesPerChar = 1;
                this._bigEndian = true;
                return true;
            }
        } else {
            reportWeirdUCS4("2143");
            throw null;
        }
    }

    private boolean checkUTF32(int quad) throws IOException {
        if ((quad >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & quad) == 0) {
            this._bigEndian = false;
        } else if ((-16711681 & quad) == 0) {
            reportWeirdUCS4("3412");
            throw null;
        } else if ((-65281 & quad) != 0) {
            return false;
        } else {
            reportWeirdUCS4("2143");
            throw null;
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean checkUTF16(int i16) {
        if ((65280 & i16) == 0) {
            this._bigEndian = true;
        } else if ((i16 & 255) != 0) {
            return false;
        } else {
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private void reportWeirdUCS4(String type) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported UCS-4 endianness (");
        sb.append(type);
        sb.append(") detected");
        throw new CharConversionException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public boolean ensureLoaded(int minimum) throws IOException {
        int count;
        int gotten = this._inputEnd - this._inputPtr;
        while (gotten < minimum) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                count = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i = this._inputEnd;
                count = inputStream.read(bArr, i, bArr.length - i);
            }
            if (count < 1) {
                return false;
            }
            this._inputEnd += count;
            gotten += count;
        }
        return true;
    }
}
