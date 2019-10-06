package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p134io.CharTypes;
import com.fasterxml.jackson.core.p134io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

public class ReaderBasedJsonParser extends ParserBase {
    protected static final int FEAT_MASK_TRAILING_COMMA = Feature.ALLOW_TRAILING_COMMA.getMask();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    protected boolean _bufferRecyclable;
    protected final int _hashSeed;
    protected char[] _inputBuffer;
    protected int _nameStartCol;
    protected long _nameStartOffset;
    protected int _nameStartRow;
    protected ObjectCodec _objectCodec;
    protected Reader _reader;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public ReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st, char[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        super(ctxt, features);
        this._reader = r;
        this._inputBuffer = inputBuffer;
        this._inputPtr = start;
        this._inputEnd = end;
        this._objectCodec = codec;
        this._symbols = st;
        this._hashSeed = st.hashSeed();
        this._bufferRecyclable = bufferRecyclable;
    }

    public ReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st) {
        super(ctxt, features);
        this._reader = r;
        this._inputBuffer = ctxt.allocTokenBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._objectCodec = codec;
        this._symbols = st;
        this._hashSeed = st.hashSeed();
        this._bufferRecyclable = true;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public char getNextChar(String eofMsg) throws IOException {
        return getNextChar(eofMsg, null);
    }

    /* access modifiers changed from: protected */
    public char getNextChar(String eofMsg, JsonToken forToken) throws IOException {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            return cArr[i];
        }
        _reportInvalidEOF(eofMsg, forToken);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
            this._reader = null;
        }
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        this._symbols.release();
        if (this._bufferRecyclable) {
            char[] buf = this._inputBuffer;
            if (buf != null) {
                this._inputBuffer = null;
                this._ioContext.releaseTokenBuffer(buf);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _loadMoreGuaranteed() throws IOException {
        if (!_loadMore()) {
            _reportInvalidEOF();
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean _loadMore() throws IOException {
        int bufSize = this._inputEnd;
        this._currInputProcessed += (long) bufSize;
        this._currInputRowStart -= bufSize;
        this._nameStartOffset -= (long) bufSize;
        Reader reader = this._reader;
        if (reader != null) {
            char[] cArr = this._inputBuffer;
            int count = reader.read(cArr, 0, cArr.length);
            if (count > 0) {
                this._inputPtr = 0;
                this._inputEnd = count;
                return true;
            }
            _closeInput();
            if (count == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Reader returned 0 characters when trying to read ");
                sb.append(this._inputEnd);
                throw new IOException(sb.toString());
            }
        }
        return false;
    }

    public final String getText() throws IOException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_STRING) {
            return _getText2(t);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    public final String getValueAsString() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        } else if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return super.getValueAsString(null);
        }
    }

    public final String getValueAsString(String defValue) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        } else if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return super.getValueAsString(defValue);
        }
    }

    /* access modifiers changed from: protected */
    public final String _getText2(JsonToken t) {
        if (t == null) {
            return null;
        }
        int id = t.mo20316id();
        if (id == 5) {
            return this._parsingContext.getCurrentName();
        }
        if (id == 6 || id == 7 || id == 8) {
            return this._textBuffer.contentsAsString();
        }
        return t.asString();
    }

    public final char[] getTextCharacters() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        int id = jsonToken.mo20316id();
        if (id != 5) {
            if (id != 6) {
                if (!(id == 7 || id == 8)) {
                    return this._currToken.asCharArray();
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextBuffer();
        }
        if (!this._nameCopied) {
            String name = this._parsingContext.getCurrentName();
            int nameLen = name.length();
            char[] cArr = this._nameCopyBuffer;
            if (cArr == null) {
                this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(nameLen);
            } else if (cArr.length < nameLen) {
                this._nameCopyBuffer = new char[nameLen];
            }
            name.getChars(0, nameLen, this._nameCopyBuffer, 0);
            this._nameCopied = true;
        }
        return this._nameCopyBuffer;
    }

    public final int getTextLength() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        int id = jsonToken.mo20316id();
        if (id == 5) {
            return this._parsingContext.getCurrentName().length();
        }
        if (id != 6) {
            if (!(id == 7 || id == 8)) {
                return this._currToken.asCharArray().length;
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 != 8) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getTextOffset() throws java.io.IOException {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3._currToken
            r1 = 0
            if (r0 == 0) goto L_0x0028
            int r0 = r0.mo20316id()
            r2 = 5
            if (r0 == r2) goto L_0x0027
            r2 = 6
            if (r0 == r2) goto L_0x0017
            r2 = 7
            if (r0 == r2) goto L_0x0020
            r2 = 8
            if (r0 == r2) goto L_0x0020
            goto L_0x0028
        L_0x0017:
            boolean r0 = r3._tokenIncomplete
            if (r0 == 0) goto L_0x0020
            r3._tokenIncomplete = r1
            r3._finishString()
        L_0x0020:
            com.fasterxml.jackson.core.util.TextBuffer r0 = r3._textBuffer
            int r0 = r0.getTextOffset()
            return r0
        L_0x0027:
            return r1
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.getTextOffset():int");
    }

    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            byte[] bArr = this._binaryValue;
            if (bArr != null) {
                return bArr;
            }
        }
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                try {
                    this._binaryValue = _decodeBase64(b64variant);
                    this._tokenIncomplete = false;
                } catch (IllegalArgumentException iae) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to decode VALUE_STRING as base64 (");
                    sb.append(b64variant);
                    sb.append("): ");
                    sb.append(iae.getMessage());
                    throw _constructError(sb.toString());
                }
            } else if (this._binaryValue == null) {
                ByteArrayBuilder builder = _getByteArrayBuilder();
                _decodeBase64(getText(), builder, b64variant);
                this._binaryValue = builder.toByteArray();
            }
            return this._binaryValue;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current token (");
        sb2.append(this._currToken);
        sb2.append(") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        _reportError(sb2.toString());
        throw null;
    }

    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] b = getBinaryValue(b64variant);
            out.write(b);
            return b.length;
        }
        byte[] buf = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(b64variant, out, buf);
        } finally {
            this._ioContext.releaseBase64Buffer(buf);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r9 < 0) goto L_0x0151;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int _readBinary(com.fasterxml.jackson.core.Base64Variant r17, java.io.OutputStream r18, byte[] r19) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = 0
            int r5 = r3.length
            r6 = 3
            int r5 = r5 - r6
            r7 = 0
        L_0x000d:
            int r8 = r0._inputPtr
            int r9 = r0._inputEnd
            if (r8 < r9) goto L_0x0016
            r16._loadMoreGuaranteed()
        L_0x0016:
            char[] r8 = r0._inputBuffer
            int r9 = r0._inputPtr
            int r10 = r9 + 1
            r0._inputPtr = r10
            char r8 = r8[r9]
            r9 = 32
            if (r8 <= r9) goto L_0x0150
            int r9 = r1.decodeBase64Char(r8)
            r10 = 34
            r11 = 0
            if (r9 >= 0) goto L_0x003a
            if (r8 != r10) goto L_0x0031
            goto L_0x0111
        L_0x0031:
            int r9 = r0._decodeBase64Escape(r1, r8, r11)
            if (r9 >= 0) goto L_0x003a
            r9 = 3
            goto L_0x0151
        L_0x003a:
            if (r4 <= r5) goto L_0x0041
            int r7 = r7 + r4
            r2.write(r3, r11, r4)
            r4 = 0
        L_0x0041:
            r12 = r9
            int r13 = r0._inputPtr
            int r14 = r0._inputEnd
            if (r13 < r14) goto L_0x004b
            r16._loadMoreGuaranteed()
        L_0x004b:
            char[] r13 = r0._inputBuffer
            int r14 = r0._inputPtr
            int r15 = r14 + 1
            r0._inputPtr = r15
            char r8 = r13[r14]
            int r9 = r1.decodeBase64Char(r8)
            if (r9 >= 0) goto L_0x0060
            r13 = 1
            int r9 = r0._decodeBase64Escape(r1, r8, r13)
        L_0x0060:
            int r13 = r12 << 6
            r12 = r13 | r9
            int r13 = r0._inputPtr
            int r14 = r0._inputEnd
            if (r13 < r14) goto L_0x006d
            r16._loadMoreGuaranteed()
        L_0x006d:
            char[] r13 = r0._inputBuffer
            int r14 = r0._inputPtr
            int r15 = r14 + 1
            r0._inputPtr = r15
            char r8 = r13[r14]
            int r9 = r1.decodeBase64Char(r8)
            r13 = 2
            r14 = -2
            if (r9 >= 0) goto L_0x00db
            if (r9 == r14) goto L_0x0097
            if (r8 != r10) goto L_0x0093
            boolean r15 = r17.usesPadding()
            if (r15 != 0) goto L_0x0093
            int r6 = r12 >> 4
            int r10 = r4 + 1
            byte r12 = (byte) r6
            r3[r4] = r12
            r4 = r10
            goto L_0x0111
        L_0x0093:
            int r9 = r0._decodeBase64Escape(r1, r8, r13)
        L_0x0097:
            if (r9 != r14) goto L_0x00db
            int r10 = r0._inputPtr
            int r11 = r0._inputEnd
            if (r10 < r11) goto L_0x00a2
            r16._loadMoreGuaranteed()
        L_0x00a2:
            char[] r10 = r0._inputBuffer
            int r11 = r0._inputPtr
            int r13 = r11 + 1
            r0._inputPtr = r13
            char r8 = r10[r11]
            boolean r10 = r1.usesPaddingChar(r8)
            if (r10 == 0) goto L_0x00bc
            int r10 = r12 >> 4
            int r11 = r4 + 1
            byte r12 = (byte) r10
            r3[r4] = r12
            r4 = r11
            goto L_0x000d
        L_0x00bc:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "expected padding character '"
            r10.append(r11)
            char r11 = r17.getPaddingChar()
            r10.append(r11)
            java.lang.String r11 = "'"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r6 = r0.reportInvalidBase64Char(r1, r8, r6, r10)
            throw r6
        L_0x00db:
            int r15 = r12 << 6
            r12 = r15 | r9
            int r15 = r0._inputPtr
            int r6 = r0._inputEnd
            if (r15 < r6) goto L_0x00e8
            r16._loadMoreGuaranteed()
        L_0x00e8:
            char[] r6 = r0._inputBuffer
            int r15 = r0._inputPtr
            int r11 = r15 + 1
            r0._inputPtr = r11
            char r6 = r6[r15]
            int r8 = r1.decodeBase64Char(r6)
            if (r8 >= 0) goto L_0x0135
            if (r8 == r14) goto L_0x0121
            if (r6 != r10) goto L_0x011b
            boolean r9 = r17.usesPadding()
            if (r9 != 0) goto L_0x011b
            int r9 = r12 >> 2
            int r10 = r4 + 1
            int r11 = r9 >> 8
            byte r11 = (byte) r11
            r3[r4] = r11
            int r4 = r10 + 1
            byte r11 = (byte) r9
            r3[r10] = r11
        L_0x0111:
            r6 = 0
            r0._tokenIncomplete = r6
            if (r4 <= 0) goto L_0x011a
            int r7 = r7 + r4
            r2.write(r3, r6, r4)
        L_0x011a:
            return r7
        L_0x011b:
            r9 = 3
            int r8 = r0._decodeBase64Escape(r1, r6, r9)
            goto L_0x0122
        L_0x0121:
            r9 = 3
        L_0x0122:
            if (r8 != r14) goto L_0x0136
            int r10 = r12 >> 2
            int r11 = r4 + 1
            int r12 = r10 >> 8
            byte r12 = (byte) r12
            r3[r4] = r12
            int r4 = r11 + 1
            byte r12 = (byte) r10
            r3[r11] = r12
            r6 = 3
            goto L_0x000d
        L_0x0135:
            r9 = 3
        L_0x0136:
            int r10 = r12 << 6
            r10 = r10 | r8
            int r11 = r4 + 1
            int r12 = r10 >> 16
            byte r12 = (byte) r12
            r3[r4] = r12
            int r4 = r11 + 1
            int r12 = r10 >> 8
            byte r12 = (byte) r12
            r3[r11] = r12
            int r11 = r4 + 1
            byte r12 = (byte) r10
            r3[r4] = r12
            r4 = r11
            r6 = 3
            goto L_0x000d
        L_0x0150:
            r9 = 3
        L_0x0151:
            r6 = 3
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    public final JsonToken nextToken() throws IOException {
        String name;
        JsonToken t;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            i = _skipComma(i);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return this._currToken;
            }
        }
        boolean inObject = this._parsingContext.inObject();
        if (inObject) {
            _updateNameLocation();
            name = i == 34 ? _parseName() : _handleOddName(i);
            this._parsingContext.setCurrentName(name);
            this._currToken = JsonToken.FIELD_NAME;
            i = _skipColon();
        } else {
            name = null;
        }
        _updateLocation();
        if (i == 34) {
            this._tokenIncomplete = true;
            t = JsonToken.VALUE_STRING;
        } else if (i == 45) {
            String str = name;
            t = _parseNegNumber();
        } else if (i == 91) {
            String str2 = name;
            if (!inObject) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            }
            t = JsonToken.START_ARRAY;
        } else if (i == 102) {
            String str3 = name;
            _matchFalse();
            t = JsonToken.VALUE_FALSE;
        } else if (i == 110) {
            String str4 = name;
            _matchNull();
            t = JsonToken.VALUE_NULL;
        } else if (i == 116) {
            String str5 = name;
            _matchTrue();
            t = JsonToken.VALUE_TRUE;
        } else if (i == 123) {
            String str6 = name;
            if (!inObject) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            t = JsonToken.START_OBJECT;
        } else if (i != 125) {
            switch (i) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    String str7 = name;
                    t = _parsePosNumber(i);
                    break;
                default:
                    String str8 = name;
                    t = _handleOddValue(i);
                    break;
            }
        } else {
            _reportUnexpectedChar(i, "expected a value");
            throw null;
        }
        if (inObject) {
            this._nextToken = t;
            return this._currToken;
        }
        this._currToken = t;
        return t;
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = t;
        return t;
    }

    public String nextFieldName() throws IOException {
        JsonToken t;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            i = _skipComma(i);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i);
            return null;
        }
        _updateNameLocation();
        String name = i == 34 ? _parseName() : _handleOddName(i);
        this._parsingContext.setCurrentName(name);
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
        _updateLocation();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return name;
        }
        if (i2 == 45) {
            t = _parseNegNumber();
        } else if (i2 == 91) {
            t = JsonToken.START_ARRAY;
        } else if (i2 == 102) {
            _matchFalse();
            t = JsonToken.VALUE_FALSE;
        } else if (i2 == 110) {
            _matchNull();
            t = JsonToken.VALUE_NULL;
        } else if (i2 == 116) {
            _matchTrue();
            t = JsonToken.VALUE_TRUE;
        } else if (i2 != 123) {
            switch (i2) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    t = _parsePosNumber(i2);
                    break;
                default:
                    t = _handleOddValue(i2);
                    break;
            }
        } else {
            t = JsonToken.START_OBJECT;
        }
        this._nextToken = t;
        return name;
    }

    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        if (i != 44) {
            if (i == 45) {
                JsonToken _parseNegNumber = _parseNegNumber();
                this._currToken = _parseNegNumber;
                return _parseNegNumber;
            } else if (i == 91) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this._currToken = jsonToken2;
                return jsonToken2;
            } else if (i != 93) {
                if (i == 102) {
                    _matchToken(AdultContentAnalytics.UNLOCK, 1);
                    JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                    this._currToken = jsonToken3;
                    return jsonToken3;
                } else if (i == 110) {
                    _matchToken("null", 1);
                    JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                    this._currToken = jsonToken4;
                    return jsonToken4;
                } else if (i == 116) {
                    _matchToken("true", 1);
                    JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
                    this._currToken = jsonToken5;
                    return jsonToken5;
                } else if (i != 123) {
                    switch (i) {
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            JsonToken _parsePosNumber = _parsePosNumber(i);
                            this._currToken = _parsePosNumber;
                            return _parsePosNumber;
                    }
                    JsonToken _handleOddValue = _handleOddValue(i);
                    this._currToken = _handleOddValue;
                    return _handleOddValue;
                } else {
                    this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                    JsonToken jsonToken6 = JsonToken.START_OBJECT;
                    this._currToken = jsonToken6;
                    return jsonToken6;
                }
            }
        }
        if (isEnabled(Feature.ALLOW_MISSING_VALUES)) {
            this._inputPtr--;
            JsonToken jsonToken7 = JsonToken.VALUE_NULL;
            this._currToken = jsonToken7;
            return jsonToken7;
        }
        JsonToken _handleOddValue2 = _handleOddValue(i);
        this._currToken = _handleOddValue2;
        return _handleOddValue2;
    }

    public final String nextTextValue() throws IOException {
        String str = null;
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                }
                return this._textBuffer.contentsAsString();
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            } else if (t == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            return null;
        }
        if (nextToken() == JsonToken.VALUE_STRING) {
            str = getText();
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final JsonToken _parsePosNumber(int ch) throws IOException {
        int ptr = this._inputPtr;
        int startPtr = ptr - 1;
        int inputLen = this._inputEnd;
        if (ch == 48) {
            return _parseNumber2(false, startPtr);
        }
        int intLen = 1;
        while (ptr < inputLen) {
            int ptr2 = ptr + 1;
            char ch2 = this._inputBuffer[ptr];
            if (ch2 >= '0' && ch2 <= '9') {
                intLen++;
                ptr = ptr2;
            } else if (ch2 == '.' || ch2 == 'e' || ch2 == 'E') {
                this._inputPtr = ptr2;
                return _parseFloat(ch2, startPtr, ptr2, false, intLen);
            } else {
                int ptr3 = ptr2 - 1;
                this._inputPtr = ptr3;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(ch2);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, startPtr, ptr3 - startPtr);
                return resetInt(false, intLen);
            }
        }
        this._inputPtr = startPtr;
        return _parseNumber2(false, startPtr);
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [int] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r9v2, types: [int] */
    /* JADX WARNING: type inference failed for: r6v1, types: [char[]] */
    /* JADX WARNING: type inference failed for: r9v3, types: [char] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v5, types: [int] */
    /* JADX WARNING: type inference failed for: r6v2, types: [char[]] */
    /* JADX WARNING: type inference failed for: r9v6, types: [char] */
    /* JADX WARNING: type inference failed for: r11v8, types: [char[]] */
    /* JADX WARNING: type inference failed for: r9v7, types: [char] */
    /* JADX WARNING: type inference failed for: r5v5, types: [char[]] */
    /* JADX WARNING: type inference failed for: r9v8, types: [char, int] */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r9v3, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r9v6, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r9v7, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r9v8, types: [char, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r11v8, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r5v5, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r6v1, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r6v2, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r9v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v4
      assigns: []
      uses: []
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.fasterxml.jackson.core.JsonToken _parseFloat(int r9, int r10, int r11, boolean r12, int r13) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8._inputEnd
            r1 = 0
            r2 = 0
            r3 = 57
            r4 = 48
            r5 = 46
            if (r9 != r5) goto L_0x002c
        L_0x000c:
            if (r11 < r0) goto L_0x0013
            com.fasterxml.jackson.core.JsonToken r2 = r8._parseNumber2(r12, r10)
            return r2
        L_0x0013:
            char[] r5 = r8._inputBuffer
            int r6 = r11 + 1
            char r9 = r5[r11]
            if (r9 < r4) goto L_0x0022
            if (r9 <= r3) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            int r1 = r1 + 1
            r11 = r6
            goto L_0x000c
        L_0x0022:
            if (r1 == 0) goto L_0x0026
            r11 = r6
            goto L_0x002c
        L_0x0026:
            java.lang.String r10 = "Decimal point not followed by a digit"
            r8.reportUnexpectedNumberChar(r9, r10)
            throw r2
        L_0x002c:
            r5 = 0
            r6 = 101(0x65, float:1.42E-43)
            if (r9 == r6) goto L_0x0035
            r6 = 69
            if (r9 != r6) goto L_0x0078
        L_0x0035:
            if (r11 < r0) goto L_0x003e
            r8._inputPtr = r10
            com.fasterxml.jackson.core.JsonToken r2 = r8._parseNumber2(r12, r10)
            return r2
        L_0x003e:
            char[] r6 = r8._inputBuffer
            int r7 = r11 + 1
            char r9 = r6[r11]
            r11 = 45
            if (r9 == r11) goto L_0x004f
            r11 = 43
            if (r9 != r11) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r11 = r7
            goto L_0x005f
        L_0x004f:
            if (r7 < r0) goto L_0x0058
            r8._inputPtr = r10
            com.fasterxml.jackson.core.JsonToken r11 = r8._parseNumber2(r12, r10)
            return r11
        L_0x0058:
            char[] r11 = r8._inputBuffer
            int r6 = r7 + 1
            char r9 = r11[r7]
            r11 = r6
        L_0x005f:
            if (r9 > r3) goto L_0x0076
            if (r9 < r4) goto L_0x0076
            int r5 = r5 + 1
            if (r11 < r0) goto L_0x006e
            r8._inputPtr = r10
            com.fasterxml.jackson.core.JsonToken r2 = r8._parseNumber2(r12, r10)
            return r2
        L_0x006e:
            char[] r6 = r8._inputBuffer
            int r7 = r11 + 1
            char r9 = r6[r11]
            r11 = r7
            goto L_0x005f
        L_0x0076:
            if (r5 == 0) goto L_0x0095
        L_0x0078:
            int r11 = r11 + -1
            r8._inputPtr = r11
            com.fasterxml.jackson.core.json.JsonReadContext r2 = r8._parsingContext
            boolean r2 = r2.inRoot()
            if (r2 == 0) goto L_0x0087
            r8._verifyRootSpace(r9)
        L_0x0087:
            int r2 = r11 - r10
            com.fasterxml.jackson.core.util.TextBuffer r3 = r8._textBuffer
            char[] r4 = r8._inputBuffer
            r3.resetWithShared(r4, r10, r2)
            com.fasterxml.jackson.core.JsonToken r3 = r8.resetFloat(r12, r13, r1, r5)
            return r3
        L_0x0095:
            java.lang.String r10 = "Exponent indicator not followed by a digit"
            r8.reportUnexpectedNumberChar(r9, r10)
            goto L_0x009c
        L_0x009b:
            throw r2
        L_0x009c:
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._parseFloat(int, int, int, boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    /* access modifiers changed from: protected */
    public final JsonToken _parseNegNumber() throws IOException {
        int ptr = this._inputPtr;
        int startPtr = ptr - 1;
        int inputLen = this._inputEnd;
        if (ptr >= inputLen) {
            return _parseNumber2(true, startPtr);
        }
        int ptr2 = ptr + 1;
        char ch = this._inputBuffer[ptr];
        if (ch > '9' || ch < '0') {
            this._inputPtr = ptr2;
            return _handleInvalidNumberStart(ch, true);
        } else if (ch == '0') {
            return _parseNumber2(true, startPtr);
        } else {
            int intLen = 1;
            while (ptr2 < inputLen) {
                int ptr3 = ptr2 + 1;
                char ch2 = this._inputBuffer[ptr2];
                if (ch2 >= '0' && ch2 <= '9') {
                    intLen++;
                    ptr2 = ptr3;
                } else if (ch2 == '.' || ch2 == 'e' || ch2 == 'E') {
                    this._inputPtr = ptr3;
                    return _parseFloat(ch2, startPtr, ptr3, true, intLen);
                } else {
                    int ptr4 = ptr3 - 1;
                    this._inputPtr = ptr4;
                    if (this._parsingContext.inRoot()) {
                        _verifyRootSpace(ch2);
                    }
                    this._textBuffer.resetWithShared(this._inputBuffer, startPtr, ptr4 - startPtr);
                    return resetInt(true, intLen);
                }
            }
            return _parseNumber2(true, startPtr);
        }
    }

    private final JsonToken _parseNumber2(boolean neg, int startPtr) throws IOException {
        char c;
        int outPtr;
        char c2;
        char c3;
        boolean z = neg;
        this._inputPtr = z ? startPtr + 1 : startPtr;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr2 = 0;
        if (z) {
            int outPtr3 = 0 + 1;
            outBuf[0] = '-';
            outPtr2 = outPtr3;
        }
        int intLen = 0;
        int i = this._inputPtr;
        if (i < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            this._inputPtr = i + 1;
            c = cArr[i];
        } else {
            c = getNextChar("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (c == '0') {
            c = _verifyNoLeadingZeroes();
        }
        boolean eof = false;
        while (true) {
            if (c < '0' || c > '9') {
                break;
            }
            intLen++;
            if (outPtr2 >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr2 = 0;
            }
            int outPtr4 = outPtr2 + 1;
            outBuf[outPtr2] = c;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                c = 0;
                eof = true;
                outPtr2 = outPtr4;
                break;
            }
            char[] cArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            c = cArr2[i2];
            outPtr2 = outPtr4;
        }
        if (intLen == 0) {
            return _handleInvalidNumberStart(c, z);
        }
        int fractLen = 0;
        if (c == '.') {
            if (outPtr2 >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr2 = 0;
            }
            int outPtr5 = outPtr2 + 1;
            outBuf[outPtr2] = c;
            while (true) {
                outPtr2 = outPtr5;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                c = cArr3[i3];
                if (c < '0' || c > '9') {
                    break;
                }
                fractLen++;
                if (outPtr2 >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr2 = 0;
                }
                outPtr5 = outPtr2 + 1;
                outBuf[outPtr2] = c;
            }
            if (fractLen == 0) {
                reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
                throw null;
            }
        }
        int expLen = 0;
        if (c == 'e' || c == 'E') {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr6 = outPtr + 1;
            outBuf[outPtr] = c;
            int i4 = this._inputPtr;
            String str = "expected a digit for number exponent";
            if (i4 < this._inputEnd) {
                char[] cArr4 = this._inputBuffer;
                this._inputPtr = i4 + 1;
                c2 = cArr4[i4];
            } else {
                c2 = getNextChar(str);
            }
            if (c2 == '-' || c2 == '+') {
                if (outPtr6 >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr6 = 0;
                }
                int outPtr7 = outPtr6 + 1;
                outBuf[outPtr6] = c2;
                int i5 = this._inputPtr;
                if (i5 < this._inputEnd) {
                    char[] cArr5 = this._inputBuffer;
                    this._inputPtr = i5 + 1;
                    c3 = cArr5[i5];
                } else {
                    c3 = getNextChar(str);
                }
                outPtr6 = outPtr7;
            } else {
                c3 = c2;
            }
            while (true) {
                if (c <= '9' && c >= '0') {
                    expLen++;
                    if (outPtr6 >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr6 = 0;
                    }
                    outPtr = outPtr6 + 1;
                    outBuf[outPtr6] = c;
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        eof = true;
                        break;
                    }
                    char[] cArr6 = this._inputBuffer;
                    int i6 = this._inputPtr;
                    this._inputPtr = i6 + 1;
                    c3 = cArr6[i6];
                    outPtr6 = outPtr;
                } else {
                    outPtr = outPtr6;
                }
            }
            outPtr = outPtr6;
            if (expLen == 0) {
                reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!eof) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(c);
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        return reset(z, intLen, fractLen, expLen);
    }

    private final char _verifyNoLeadingZeroes() throws IOException {
        int i = this._inputPtr;
        if (i < this._inputEnd) {
            char ch = this._inputBuffer[i];
            if (ch < '0' || ch > '9') {
                return '0';
            }
        }
        return _verifyNLZ2();
    }

    private char _verifyNLZ2() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return '0';
        }
        char ch = this._inputBuffer[this._inputPtr];
        if (ch < '0' || ch > '9') {
            return '0';
        }
        if (isEnabled(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            this._inputPtr++;
            if (ch == '0') {
                do {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        break;
                    }
                    char[] cArr = this._inputBuffer;
                    int i = this._inputPtr;
                    ch = cArr[i];
                    if (ch < '0' || ch > '9') {
                        return '0';
                    }
                    this._inputPtr = i + 1;
                } while (ch == '0');
            }
            return ch;
        }
        reportInvalidNumber("Leading zeroes not allowed");
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=char, for r10v0, types: [int] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(char r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            r1 = 73
            if (r10 != r1) goto L_0x0095
            int r1 = r9._inputPtr
            int r2 = r9._inputEnd
            if (r1 < r2) goto L_0x0018
            boolean r1 = r9._loadMore()
            if (r1 == 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            com.fasterxml.jackson.core.JsonToken r10 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r9._reportInvalidEOFInValue(r10)
            throw r0
        L_0x0018:
            char[] r1 = r9._inputBuffer
            int r2 = r9._inputPtr
            int r3 = r2 + 1
            r9._inputPtr = r3
            char r10 = r1[r2]
            r1 = 78
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r4 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            java.lang.String r6 = "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            java.lang.String r7 = "Non-standard token '"
            r8 = 3
            if (r10 != r1) goto L_0x0060
            if (r11 == 0) goto L_0x0034
            java.lang.String r1 = "-INF"
            goto L_0x0036
        L_0x0034:
            java.lang.String r1 = "+INF"
        L_0x0036:
            r9._matchToken(r1, r8)
            com.fasterxml.jackson.core.JsonParser$Feature r8 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r8 = r9.isEnabled(r8)
            if (r8 == 0) goto L_0x004a
            if (r11 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r2 = r4
        L_0x0045:
            com.fasterxml.jackson.core.JsonToken r0 = r9.resetAsNaN(r1, r2)
            return r0
        L_0x004a:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r1)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r9._reportError(r10)
            throw r0
        L_0x0060:
            r1 = 110(0x6e, float:1.54E-43)
            if (r10 != r1) goto L_0x0095
            if (r11 == 0) goto L_0x0069
            java.lang.String r1 = "-Infinity"
            goto L_0x006b
        L_0x0069:
            java.lang.String r1 = "+Infinity"
        L_0x006b:
            r9._matchToken(r1, r8)
            com.fasterxml.jackson.core.JsonParser$Feature r8 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r8 = r9.isEnabled(r8)
            if (r8 == 0) goto L_0x007f
            if (r11 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r2 = r4
        L_0x007a:
            com.fasterxml.jackson.core.JsonToken r0 = r9.resetAsNaN(r1, r2)
            return r0
        L_0x007f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r1)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r9._reportError(r10)
            throw r0
        L_0x0095:
            java.lang.String r11 = "expected digit (0-9) to follow minus sign, for valid numeric value"
            r9.reportUnexpectedNumberChar(r10, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleInvalidNumberStart(int, boolean):com.fasterxml.jackson.core.JsonToken");
    }

    private final void _verifyRootSpace(int ch) throws IOException {
        this._inputPtr++;
        if (ch != 9) {
            if (ch == 10) {
                this._currInputRow++;
                this._currInputRowStart = this._inputPtr;
            } else if (ch == 13) {
                _skipCR();
            } else if (ch != 32) {
                _reportMissingRootWS(ch);
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String _parseName() throws IOException {
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int[] codes = _icLatin1;
        while (true) {
            if (ptr >= this._inputEnd) {
                break;
            }
            char[] cArr = this._inputBuffer;
            char ch = cArr[ptr];
            if (ch >= codes.length || codes[ch] == 0) {
                hash = (hash * 33) + ch;
                ptr++;
            } else if (ch == '\"') {
                int start = this._inputPtr;
                this._inputPtr = ptr + 1;
                return this._symbols.findSymbol(cArr, start, ptr - start, hash);
            }
        }
        int start2 = this._inputPtr;
        this._inputPtr = ptr;
        return _parseName2(start2, hash, 34);
    }

    private String _parseName2(int startPtr, int hash, int endChar) throws IOException {
        this._textBuffer.resetWithShared(this._inputBuffer, startPtr, this._inputPtr - startPtr);
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                char c2 = c;
                if (c2 <= '\\') {
                    if (c2 == '\\') {
                        c = _decodeEscaped();
                    } else if (c2 <= endChar) {
                        if (c2 == endChar) {
                            this._textBuffer.setCurrentLength(outPtr);
                            TextBuffer tb = this._textBuffer;
                            return this._symbols.findSymbol(tb.getTextBuffer(), tb.getTextOffset(), tb.size(), hash);
                        } else if (c2 < ' ') {
                            _throwUnquotedSpace(c2, "name");
                        }
                    }
                }
                hash = (hash * 33) + c;
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = c;
                if (outPtr2 >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                } else {
                    outPtr = outPtr2;
                }
            } else {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String _handleOddName(int i) throws IOException {
        if (i == 39 && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseAposName();
        }
        if (isEnabled(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] codes = CharTypes.getInputCodeLatin1JsNames();
            int maxCode = codes.length;
            boolean firstOk = i < maxCode ? codes[i] == 0 : Character.isJavaIdentifierPart((char) i);
            if (firstOk) {
                int ptr = this._inputPtr;
                int hash = this._hashSeed;
                int inputLen = this._inputEnd;
                if (ptr < inputLen) {
                    do {
                        char[] cArr = this._inputBuffer;
                        char ch = cArr[ptr];
                        if (ch < maxCode) {
                            if (codes[ch] != 0) {
                                int start = this._inputPtr - 1;
                                this._inputPtr = ptr;
                                return this._symbols.findSymbol(cArr, start, ptr - start, hash);
                            }
                        } else if (!Character.isJavaIdentifierPart((char) ch)) {
                            int start2 = this._inputPtr - 1;
                            this._inputPtr = ptr;
                            return this._symbols.findSymbol(this._inputBuffer, start2, ptr - start2, hash);
                        }
                        hash = (hash * 33) + ch;
                        ptr++;
                    } while (ptr < inputLen);
                }
                int start3 = this._inputPtr - 1;
                this._inputPtr = ptr;
                return _handleOddName2(start3, hash, codes);
            }
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            throw null;
        }
        _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        throw null;
    }

    /* access modifiers changed from: protected */
    public String _parseAposName() throws IOException {
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = _icLatin1;
            int maxCode = codes.length;
            do {
                char[] cArr = this._inputBuffer;
                char ch = cArr[ptr];
                if (ch != '\'') {
                    if (ch < maxCode && codes[ch] != 0) {
                        break;
                    }
                    hash = (hash * 33) + ch;
                    ptr++;
                } else {
                    int start = this._inputPtr;
                    this._inputPtr = ptr + 1;
                    return this._symbols.findSymbol(cArr, start, ptr - start, hash);
                }
            } while (ptr < inputLen);
        }
        int start2 = this._inputPtr;
        this._inputPtr = ptr;
        return _parseName2(start2, hash, 39);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r4 != 44) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r3._parsingContext.inArray() == false) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.JsonToken _handleOddValue(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            r1 = 0
            if (r4 == r0) goto L_0x008c
            r0 = 73
            r2 = 1
            if (r4 == r0) goto L_0x0072
            r0 = 78
            if (r4 == r0) goto L_0x0058
            r0 = 93
            if (r4 == r0) goto L_0x003f
            r0 = 43
            if (r4 == r0) goto L_0x001c
            r0 = 44
            if (r4 == r0) goto L_0x0048
            goto L_0x0099
        L_0x001c:
            int r0 = r3._inputPtr
            int r2 = r3._inputEnd
            if (r0 < r2) goto L_0x002f
            boolean r0 = r3._loadMore()
            if (r0 == 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3._reportInvalidEOFInValue(r4)
            throw r1
        L_0x002f:
            char[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            int r2 = r1 + 1
            r3._inputPtr = r2
            char r0 = r0[r1]
            r1 = 0
            com.fasterxml.jackson.core.JsonToken r0 = r3._handleInvalidNumberStart(r0, r1)
            return r0
        L_0x003f:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L_0x0048
            goto L_0x0099
        L_0x0048:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r0 = r3.isEnabled(r0)
            if (r0 == 0) goto L_0x0099
            int r0 = r3._inputPtr
            int r0 = r0 - r2
            r3._inputPtr = r0
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r0
        L_0x0058:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r2 = r3.isEnabled(r2)
            if (r2 == 0) goto L_0x006c
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r0 = r3.resetAsNaN(r0, r1)
            return r0
        L_0x006c:
            java.lang.String r4 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r4)
            throw r1
        L_0x0072:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r2 = r3.isEnabled(r2)
            if (r2 == 0) goto L_0x0086
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r0 = r3.resetAsNaN(r0, r1)
            return r0
        L_0x0086:
            java.lang.String r4 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r4)
            throw r1
        L_0x008c:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r3.isEnabled(r0)
            if (r0 == 0) goto L_0x0099
            com.fasterxml.jackson.core.JsonToken r0 = r3._handleApos()
            return r0
        L_0x0099:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto L_0x00b7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = ""
            r0.append(r2)
            char r4 = (char) r4
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "('true', 'false' or 'null')"
            r3._reportInvalidToken(r4, r0)
            throw r1
        L_0x00b7:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r3._reportUnexpectedChar(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    /* access modifiers changed from: protected */
    public JsonToken _handleApos() throws IOException {
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                char c2 = c;
                if (c2 <= '\\') {
                    if (c2 == '\\') {
                        c = _decodeEscaped();
                    } else if (c2 <= '\'') {
                        if (c2 == '\'') {
                            this._textBuffer.setCurrentLength(outPtr);
                            return JsonToken.VALUE_STRING;
                        } else if (c2 < ' ') {
                            _throwUnquotedSpace(c2, "string value");
                        }
                    }
                }
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = c;
                outPtr = outPtr2;
            } else {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                throw null;
            }
        }
    }

    private String _handleOddName2(int startPtr, int hash, int[] codes) throws IOException {
        this._textBuffer.resetWithShared(this._inputBuffer, startPtr, this._inputPtr - startPtr);
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        int maxCode = codes.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            char c2 = c;
            if (c2 > maxCode) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (codes[c2] != 0) {
                break;
            }
            this._inputPtr++;
            hash = (hash * 33) + c2;
            int outPtr2 = outPtr + 1;
            outBuf[outPtr] = c;
            if (outPtr2 >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            } else {
                outPtr = outPtr2;
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        TextBuffer tb = this._textBuffer;
        return this._symbols.findSymbol(tb.getTextBuffer(), tb.getTextOffset(), tb.size(), hash);
    }

    /* access modifiers changed from: protected */
    public final void _finishString() throws IOException {
        int ptr = this._inputPtr;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = _icLatin1;
            int maxCode = codes.length;
            while (true) {
                char[] cArr = this._inputBuffer;
                char ch = cArr[ptr];
                if (ch >= maxCode || codes[ch] == 0) {
                    ptr++;
                    if (ptr >= inputLen) {
                        break;
                    }
                } else if (ch == '\"') {
                    TextBuffer textBuffer = this._textBuffer;
                    int i = this._inputPtr;
                    textBuffer.resetWithShared(cArr, i, ptr - i);
                    this._inputPtr = ptr + 1;
                    return;
                }
            }
        }
        TextBuffer textBuffer2 = this._textBuffer;
        char[] cArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        textBuffer2.resetWithCopy(cArr2, i2, ptr - i2);
        this._inputPtr = ptr;
        _finishString2();
    }

    /* access modifiers changed from: protected */
    public void _finishString2() throws IOException {
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        int[] codes = _icLatin1;
        int maxCode = codes.length;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                char c2 = c;
                if (c2 < maxCode && codes[c2] != 0) {
                    if (c2 == '\"') {
                        this._textBuffer.setCurrentLength(outPtr);
                        return;
                    } else if (c2 == '\\') {
                        c = _decodeEscaped();
                    } else if (c2 < ' ') {
                        _throwUnquotedSpace(c2, "string value");
                    }
                }
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = c;
                outPtr = outPtr2;
            } else {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int inPtr = this._inputPtr;
        int inLen = this._inputEnd;
        char[] inBuf = this._inputBuffer;
        while (true) {
            if (inPtr >= inLen) {
                this._inputPtr = inPtr;
                if (_loadMore()) {
                    inPtr = this._inputPtr;
                    inLen = this._inputEnd;
                } else {
                    _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                    throw null;
                }
            }
            int inPtr2 = inPtr + 1;
            int i = inBuf[inPtr];
            if (i <= 92) {
                if (i == 92) {
                    this._inputPtr = inPtr2;
                    _decodeEscaped();
                    int inPtr3 = this._inputPtr;
                    inLen = this._inputEnd;
                    inPtr = inPtr3;
                } else if (i <= 34) {
                    if (i == 34) {
                        this._inputPtr = inPtr2;
                        return;
                    } else if (i < 32) {
                        this._inputPtr = inPtr2;
                        _throwUnquotedSpace(i, "string value");
                    }
                }
            }
            inPtr = inPtr2;
        }
    }

    /* access modifiers changed from: protected */
    public final void _skipCR() throws IOException {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            if (cArr[i] == 10) {
                this._inputPtr = i + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private final int _skipColon() throws IOException {
        int i = this._inputPtr;
        if (i + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        char[] cArr = this._inputBuffer;
        char c = cArr[i];
        if (c == ':') {
            int i2 = i + 1;
            this._inputPtr = i2;
            char i3 = cArr[i2];
            if (i3 <= ' ') {
                if (i3 == ' ' || i3 == 9) {
                    char[] cArr2 = this._inputBuffer;
                    int i4 = this._inputPtr + 1;
                    this._inputPtr = i4;
                    char i5 = cArr2[i4];
                    if (i5 > ' ') {
                        if (i5 == '/' || i5 == '#') {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return i5;
                    }
                }
                return _skipColon2(true);
            } else if (i3 == '/' || i3 == '#') {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return i3;
            }
        } else {
            if (c == ' ' || c == 9) {
                char[] cArr3 = this._inputBuffer;
                int i6 = this._inputPtr + 1;
                this._inputPtr = i6;
                c = cArr3[i6];
            }
            if (c != ':') {
                return _skipColon2(false);
            }
            char[] cArr4 = this._inputBuffer;
            int i7 = this._inputPtr + 1;
            this._inputPtr = i7;
            char i8 = cArr4[i7];
            if (i8 <= ' ') {
                if (i8 == ' ' || i8 == 9) {
                    char[] cArr5 = this._inputBuffer;
                    int i9 = this._inputPtr + 1;
                    this._inputPtr = i9;
                    char i10 = cArr5[i9];
                    if (i10 > ' ') {
                        if (i10 == '/' || i10 == '#') {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return i10;
                    }
                }
                return _skipColon2(true);
            } else if (i8 == '/' || i8 == '#') {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return i8;
            }
        }
    }

    private final int _skipColon2(boolean gotColon) throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char i2 = cArr[i];
                if (i2 > ' ') {
                    if (i2 == '/') {
                        _skipComment();
                    } else if (i2 != '#' || !_skipYAMLComment()) {
                        if (gotColon) {
                            return i2;
                        }
                        if (i2 == ':') {
                            gotColon = true;
                        } else {
                            _reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
                            throw null;
                        }
                    }
                } else if (i2 >= ' ') {
                    continue;
                } else if (i2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                    throw null;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(" within/between ");
                sb.append(this._parsingContext.typeDesc());
                sb.append(" entries");
                _reportInvalidEOF(sb.toString(), null);
                throw null;
            }
        }
    }

    private final int _skipComma(int i) throws IOException {
        if (i == 44) {
            while (true) {
                int i2 = this._inputPtr;
                if (i2 >= this._inputEnd) {
                    return _skipAfterComma2();
                }
                char[] cArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                char i3 = cArr[i2];
                if (i3 > ' ') {
                    if (i3 != '/' && i3 != '#') {
                        return i3;
                    }
                    this._inputPtr--;
                    return _skipAfterComma2();
                } else if (i3 < ' ') {
                    if (i3 == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (i3 == 13) {
                        _skipCR();
                    } else if (i3 != 9) {
                        _throwInvalidSpace(i3);
                        throw null;
                    }
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("was expecting comma to separate ");
            sb.append(this._parsingContext.typeDesc());
            sb.append(" entries");
            _reportUnexpectedChar(i, sb.toString());
            throw null;
        }
    }

    private final int _skipAfterComma2() throws IOException {
        char i;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                i = cArr[i2];
                if (i > ' ') {
                    if (i == '/') {
                        _skipComment();
                    } else if (i != '#' || !_skipYAMLComment()) {
                        return i;
                    }
                } else if (i >= ' ') {
                    continue;
                } else if (i == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i == 13) {
                    _skipCR();
                } else if (i != 9) {
                    _throwInvalidSpace(i);
                    throw null;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected end-of-input within/between ");
                sb.append(this._parsingContext.typeDesc());
                sb.append(" entries");
                throw _constructError(sb.toString());
            }
        }
        return i;
    }

    private final int _skipWSOrEnd() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char i2 = cArr[i];
        if (i2 <= ' ') {
            if (i2 != ' ') {
                if (i2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                    throw null;
                }
            }
            while (true) {
                int i3 = this._inputPtr;
                if (i3 >= this._inputEnd) {
                    return _skipWSOrEnd2();
                }
                char[] cArr2 = this._inputBuffer;
                this._inputPtr = i3 + 1;
                char i4 = cArr2[i3];
                if (i4 > ' ') {
                    if (i4 != '/' && i4 != '#') {
                        return i4;
                    }
                    this._inputPtr--;
                    return _skipWSOrEnd2();
                } else if (i4 != ' ') {
                    if (i4 == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (i4 == 13) {
                        _skipCR();
                    } else if (i4 != 9) {
                        _throwInvalidSpace(i4);
                        throw null;
                    }
                }
            }
        } else if (i2 != '/' && i2 != '#') {
            return i2;
        } else {
            this._inputPtr--;
            return _skipWSOrEnd2();
        }
    }

    private int _skipWSOrEnd2() throws IOException {
        char i;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            i = cArr[i2];
            if (i > ' ') {
                if (i == '/') {
                    _skipComment();
                } else if (i != '#' || !_skipYAMLComment()) {
                    return i;
                }
            } else if (i == ' ') {
                continue;
            } else if (i == 10) {
                this._currInputRow++;
                this._currInputRowStart = this._inputPtr;
            } else if (i == 13) {
                _skipCR();
            } else if (i != 9) {
                _throwInvalidSpace(i);
                throw null;
            }
        }
        return i;
    }

    private void _skipComment() throws IOException {
        if (!isEnabled(Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
            throw null;
        } else if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c == '/') {
                _skipLine();
            } else if (c == '*') {
                _skipCComment();
            } else {
                _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        } else {
            _reportInvalidEOF(" in a comment", null);
            throw null;
        }
    }

    private void _skipCComment() throws IOException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char i2 = cArr[i];
            if (i2 <= '*') {
                if (i2 == '*') {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        break;
                    }
                    char[] cArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    if (cArr2[i3] == '/') {
                        this._inputPtr = i3 + 1;
                        return;
                    }
                } else if (i2 >= ' ') {
                    continue;
                } else if (i2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                    throw null;
                }
            }
        }
        _reportInvalidEOF(" in a comment", null);
        throw null;
    }

    private boolean _skipYAMLComment() throws IOException {
        if (!isEnabled(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        _skipLine();
        return true;
    }

    private void _skipLine() throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char i2 = cArr[i];
                if (i2 < ' ') {
                    if (i2 == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                        return;
                    } else if (i2 == 13) {
                        _skipCR();
                        return;
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                        throw null;
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public char _decodeEscaped() throws IOException {
        String str = " in character escape sequence";
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c == '\"' || c == '/' || c == '\\') {
                return c;
            }
            if (c == 'b') {
                return 8;
            }
            if (c == 'f') {
                return 12;
            }
            if (c == 'n') {
                return 10;
            }
            if (c == 'r') {
                return 13;
            }
            if (c == 't') {
                return 9;
            }
            if (c != 'u') {
                _handleUnrecognizedCharacterEscape(c);
                return c;
            }
            int value = 0;
            int i2 = 0;
            while (i2 < 4) {
                if (this._inputPtr < this._inputEnd || _loadMore()) {
                    char[] cArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    char ch = cArr2[i3];
                    int digit = CharTypes.charToHex(ch);
                    if (digit >= 0) {
                        value = (value << 4) | digit;
                        i2++;
                    } else {
                        _reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
                        throw null;
                    }
                } else {
                    _reportInvalidEOF(str, JsonToken.VALUE_STRING);
                    throw null;
                }
            }
            return (char) value;
        }
        _reportInvalidEOF(str, JsonToken.VALUE_STRING);
        throw null;
    }

    private final void _matchTrue() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr] == 'r') {
                int ptr2 = ptr + 1;
                if (b[ptr2] == 'u') {
                    int ptr3 = ptr2 + 1;
                    if (b[ptr3] == 'e') {
                        int ptr4 = ptr3 + 1;
                        char c = b[ptr4];
                        if (c < '0' || c == ']' || c == '}') {
                            this._inputPtr = ptr4;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("true", 1);
    }

    private final void _matchFalse() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 4 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr] == 'a') {
                int ptr2 = ptr + 1;
                if (b[ptr2] == 'l') {
                    int ptr3 = ptr2 + 1;
                    if (b[ptr3] == 's') {
                        int ptr4 = ptr3 + 1;
                        if (b[ptr4] == 'e') {
                            int ptr5 = ptr4 + 1;
                            char c = b[ptr5];
                            if (c < '0' || c == ']' || c == '}') {
                                this._inputPtr = ptr5;
                                return;
                            }
                        }
                    }
                }
            }
        }
        _matchToken(AdultContentAnalytics.UNLOCK, 1);
    }

    private final void _matchNull() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr] == 'u') {
                int ptr2 = ptr + 1;
                if (b[ptr2] == 'l') {
                    int ptr3 = ptr2 + 1;
                    if (b[ptr3] == 'l') {
                        int ptr4 = ptr3 + 1;
                        char c = b[ptr4];
                        if (c < '0' || c == ']' || c == '}') {
                            this._inputPtr = ptr4;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("null", 1);
    }

    /* access modifiers changed from: protected */
    public final void _matchToken(String matchStr, int i) throws IOException {
        int len = matchStr.length();
        if (this._inputPtr + len >= this._inputEnd) {
            _matchToken2(matchStr, i);
            return;
        }
        while (this._inputBuffer[this._inputPtr] == matchStr.charAt(i)) {
            this._inputPtr++;
            i++;
            if (i >= len) {
                char ch = this._inputBuffer[this._inputPtr];
                if (!(ch < '0' || ch == ']' || ch == '}')) {
                    _checkMatchEnd(matchStr, i, ch);
                }
                return;
            }
        }
        _reportInvalidToken(matchStr.substring(0, i));
        throw null;
    }

    private final void _matchToken2(String matchStr, int i) throws IOException {
        int len = matchStr.length();
        do {
            if ((this._inputPtr < this._inputEnd || _loadMore()) && this._inputBuffer[this._inputPtr] == matchStr.charAt(i)) {
                this._inputPtr++;
                i++;
            } else {
                _reportInvalidToken(matchStr.substring(0, i));
                throw null;
            }
        } while (i < len);
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char ch = this._inputBuffer[this._inputPtr];
            if (!(ch < '0' || ch == ']' || ch == '}')) {
                _checkMatchEnd(matchStr, i, ch);
            }
        }
    }

    private final void _checkMatchEnd(String matchStr, int i, int c) throws IOException {
        if (Character.isJavaIdentifierPart((char) c)) {
            _reportInvalidToken(matchStr.substring(0, i));
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char ch = cArr[i];
            if (ch > ' ') {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == '\"') {
                        return builder.toByteArray();
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                int decodedData = bits;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                char ch2 = cArr2[i2];
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData2 = (decodedData << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                char ch3 = cArr3[i3];
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 != '\"' || b64variant.usesPadding()) {
                            bits3 = _decodeBase64Escape(b64variant, ch3, 2);
                        } else {
                            builder.append(decodedData2 >> 4);
                            return builder.toByteArray();
                        }
                    }
                    if (bits3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        char ch4 = cArr4[i4];
                        if (b64variant.usesPaddingChar(ch4)) {
                            builder.append(decodedData2 >> 4);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("expected padding character '");
                            sb.append(b64variant.getPaddingChar());
                            sb.append("'");
                            throw reportInvalidBase64Char(b64variant, ch4, 3, sb.toString());
                        }
                    }
                }
                int decodedData3 = (decodedData2 << 6) | bits3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                char ch5 = cArr5[i5];
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 != '\"' || b64variant.usesPadding()) {
                            bits4 = _decodeBase64Escape(b64variant, ch5, 3);
                        } else {
                            builder.appendTwoBytes(decodedData3 >> 2);
                            return builder.toByteArray();
                        }
                    }
                    if (bits4 == -2) {
                        builder.appendTwoBytes(decodedData3 >> 2);
                    }
                }
                builder.appendThreeBytes((decodedData3 << 6) | bits4);
            }
        }
    }

    public JsonLocation getTokenLocation() {
        if (this._currToken == JsonToken.FIELD_NAME) {
            JsonLocation jsonLocation = new JsonLocation(_getSourceReference(), -1, this._currInputProcessed + (this._nameStartOffset - 1), this._nameStartRow, this._nameStartCol);
            return jsonLocation;
        }
        JsonLocation jsonLocation2 = new JsonLocation(_getSourceReference(), -1, this._tokenInputTotal - 1, this._tokenInputRow, this._tokenInputCol);
        return jsonLocation2;
    }

    public JsonLocation getCurrentLocation() {
        int col = (this._inputPtr - this._currInputRowStart) + 1;
        JsonLocation jsonLocation = new JsonLocation(_getSourceReference(), -1, ((long) this._inputPtr) + this._currInputProcessed, this._currInputRow, col);
        return jsonLocation;
    }

    private final void _updateLocation() {
        int ptr = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + ((long) ptr);
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = ptr - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        int ptr = this._inputPtr;
        this._nameStartOffset = (long) ptr;
        this._nameStartRow = this._currInputRow;
        this._nameStartCol = ptr - this._currInputRowStart;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidToken(String matchedPart) throws IOException {
        _reportInvalidToken(matchedPart, "'null', 'true', 'false' or NaN");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidToken(String matchedPart, String msg) throws IOException {
        StringBuilder sb = new StringBuilder(matchedPart);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this._inputPtr++;
            sb.append(c);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb, msg);
        throw null;
    }

    private void _closeScope(int i) throws JsonParseException {
        if (i == 93) {
            _updateLocation();
            if (this._parsingContext.inArray()) {
                this._parsingContext = this._parsingContext.clearAndGetParent();
                this._currToken = JsonToken.END_ARRAY;
            } else {
                _reportMismatchedEndMarker(i, '}');
                throw null;
            }
        }
        if (i == 125) {
            _updateLocation();
            if (this._parsingContext.inObject()) {
                this._parsingContext = this._parsingContext.clearAndGetParent();
                this._currToken = JsonToken.END_OBJECT;
                return;
            }
            _reportMismatchedEndMarker(i, ']');
            throw null;
        }
    }
}
