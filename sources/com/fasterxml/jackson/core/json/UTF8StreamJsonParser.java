package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.p134io.CharTypes;
import com.fasterxml.jackson.core.p134io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p024io.realm.internal.Collection;

public class UTF8StreamJsonParser extends ParserBase {
    protected static final int FEAT_MASK_TRAILING_COMMA = Feature.ALLOW_TRAILING_COMMA.getMask();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    private static final int[] _icUTF8 = CharTypes.getInputCodeUtf8();
    protected boolean _bufferRecyclable;
    protected byte[] _inputBuffer;
    protected InputStream _inputStream;
    protected int _nameStartCol;
    protected int _nameStartOffset;
    protected int _nameStartRow;
    protected ObjectCodec _objectCodec;
    private int _quad1;
    protected int[] _quadBuffer = new int[16];
    protected final ByteQuadsCanonicalizer _symbols;
    protected boolean _tokenIncomplete;

    public UTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        super(ctxt, features);
        this._inputStream = in;
        this._objectCodec = codec;
        this._symbols = sym;
        this._inputBuffer = inputBuffer;
        this._inputPtr = start;
        this._inputEnd = end;
        this._currInputRowStart = start;
        this._currInputProcessed = (long) (-start);
        this._bufferRecyclable = bufferRecyclable;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    /* access modifiers changed from: protected */
    public final boolean _loadMore() throws IOException {
        int bufSize = this._inputEnd;
        long j = this._currInputProcessed;
        int i = this._inputEnd;
        this._currInputProcessed = j + ((long) i);
        this._currInputRowStart -= i;
        this._nameStartOffset -= bufSize;
        InputStream inputStream = this._inputStream;
        if (inputStream != null) {
            byte[] bArr = this._inputBuffer;
            int space = bArr.length;
            if (space == 0) {
                return false;
            }
            int count = inputStream.read(bArr, 0, space);
            if (count > 0) {
                this._inputPtr = 0;
                this._inputEnd = count;
                return true;
            }
            _closeInput();
            if (count == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("InputStream.read() returned 0 characters when trying to read ");
                sb.append(this._inputBuffer.length);
                sb.append(" bytes");
                throw new IOException(sb.toString());
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() throws IOException {
        super._releaseBuffers();
        this._symbols.release();
        if (this._bufferRecyclable) {
            byte[] buf = this._inputBuffer;
            if (buf != null) {
                this._inputBuffer = ParserMinimalBase.NO_BYTES;
                this._ioContext.releaseReadIOBuffer(buf);
            }
        }
    }

    public String getText() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return _getText2(jsonToken);
        }
        if (!this._tokenIncomplete) {
            return this._textBuffer.contentsAsString();
        }
        this._tokenIncomplete = false;
        return _finishAndReturnString();
    }

    public String getValueAsString() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            }
            this._tokenIncomplete = false;
            return _finishAndReturnString();
        } else if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return super.getValueAsString(null);
        }
    }

    public String getValueAsString(String defValue) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            }
            this._tokenIncomplete = false;
            return _finishAndReturnString();
        } else if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return super.getValueAsString(defValue);
        }
    }

    public int getValueAsInt() throws IOException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_NUMBER_INT && t != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.getValueAsInt(0);
        }
        int i = this._numTypesValid;
        if ((i & 1) == 0) {
            if (i == 0) {
                return _parseIntValue();
            }
            if ((i & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    public int getValueAsInt(int defValue) throws IOException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_NUMBER_INT && t != JsonToken.VALUE_NUMBER_FLOAT) {
            return super.getValueAsInt(defValue);
        }
        int i = this._numTypesValid;
        if ((i & 1) == 0) {
            if (i == 0) {
                return _parseIntValue();
            }
            if ((i & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
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

    public char[] getTextCharacters() throws IOException {
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

    public int getTextLength() throws IOException {
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
    public int getTextOffset() throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser.getTextOffset():int");
    }

    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING || (jsonToken == JsonToken.VALUE_EMBEDDED_OBJECT && this._binaryValue != null)) {
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
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r9 < 0) goto L_0x015b;
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
            byte[] r8 = r0._inputBuffer
            int r9 = r0._inputPtr
            int r10 = r9 + 1
            r0._inputPtr = r10
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r9 = 32
            if (r8 <= r9) goto L_0x015a
            int r9 = r1.decodeBase64Char(r8)
            r10 = 34
            r11 = 0
            if (r9 >= 0) goto L_0x003c
            if (r8 != r10) goto L_0x0033
            goto L_0x011b
        L_0x0033:
            int r9 = r0._decodeBase64Escape(r1, r8, r11)
            if (r9 >= 0) goto L_0x003c
            r9 = 3
            goto L_0x015b
        L_0x003c:
            if (r4 <= r5) goto L_0x0043
            int r7 = r7 + r4
            r2.write(r3, r11, r4)
            r4 = 0
        L_0x0043:
            r12 = r9
            int r13 = r0._inputPtr
            int r14 = r0._inputEnd
            if (r13 < r14) goto L_0x004d
            r16._loadMoreGuaranteed()
        L_0x004d:
            byte[] r13 = r0._inputBuffer
            int r14 = r0._inputPtr
            int r15 = r14 + 1
            r0._inputPtr = r15
            byte r13 = r13[r14]
            r8 = r13 & 255(0xff, float:3.57E-43)
            int r9 = r1.decodeBase64Char(r8)
            if (r9 >= 0) goto L_0x0064
            r13 = 1
            int r9 = r0._decodeBase64Escape(r1, r8, r13)
        L_0x0064:
            int r13 = r12 << 6
            r12 = r13 | r9
            int r13 = r0._inputPtr
            int r14 = r0._inputEnd
            if (r13 < r14) goto L_0x0071
            r16._loadMoreGuaranteed()
        L_0x0071:
            byte[] r13 = r0._inputBuffer
            int r14 = r0._inputPtr
            int r15 = r14 + 1
            r0._inputPtr = r15
            byte r13 = r13[r14]
            r8 = r13 & 255(0xff, float:3.57E-43)
            int r9 = r1.decodeBase64Char(r8)
            r13 = 2
            r14 = -2
            if (r9 >= 0) goto L_0x00e3
            if (r9 == r14) goto L_0x009d
            if (r8 != r10) goto L_0x0099
            boolean r15 = r17.usesPadding()
            if (r15 != 0) goto L_0x0099
            int r6 = r12 >> 4
            int r10 = r4 + 1
            byte r12 = (byte) r6
            r3[r4] = r12
            r4 = r10
            goto L_0x011b
        L_0x0099:
            int r9 = r0._decodeBase64Escape(r1, r8, r13)
        L_0x009d:
            if (r9 != r14) goto L_0x00e3
            int r10 = r0._inputPtr
            int r11 = r0._inputEnd
            if (r10 < r11) goto L_0x00a8
            r16._loadMoreGuaranteed()
        L_0x00a8:
            byte[] r10 = r0._inputBuffer
            int r11 = r0._inputPtr
            int r13 = r11 + 1
            r0._inputPtr = r13
            byte r10 = r10[r11]
            r8 = r10 & 255(0xff, float:3.57E-43)
            boolean r10 = r1.usesPaddingChar(r8)
            if (r10 == 0) goto L_0x00c4
            int r10 = r12 >> 4
            int r11 = r4 + 1
            byte r12 = (byte) r10
            r3[r4] = r12
            r4 = r11
            goto L_0x000d
        L_0x00c4:
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
        L_0x00e3:
            int r15 = r12 << 6
            r12 = r15 | r9
            int r15 = r0._inputPtr
            int r6 = r0._inputEnd
            if (r15 < r6) goto L_0x00f0
            r16._loadMoreGuaranteed()
        L_0x00f0:
            byte[] r6 = r0._inputBuffer
            int r15 = r0._inputPtr
            int r11 = r15 + 1
            r0._inputPtr = r11
            byte r6 = r6[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r8 = r1.decodeBase64Char(r6)
            if (r8 >= 0) goto L_0x013f
            if (r8 == r14) goto L_0x012b
            if (r6 != r10) goto L_0x0125
            boolean r9 = r17.usesPadding()
            if (r9 != 0) goto L_0x0125
            int r9 = r12 >> 2
            int r10 = r4 + 1
            int r11 = r9 >> 8
            byte r11 = (byte) r11
            r3[r4] = r11
            int r4 = r10 + 1
            byte r11 = (byte) r9
            r3[r10] = r11
        L_0x011b:
            r6 = 0
            r0._tokenIncomplete = r6
            if (r4 <= 0) goto L_0x0124
            int r7 = r7 + r4
            r2.write(r3, r6, r4)
        L_0x0124:
            return r7
        L_0x0125:
            r9 = 3
            int r8 = r0._decodeBase64Escape(r1, r6, r9)
            goto L_0x012c
        L_0x012b:
            r9 = 3
        L_0x012c:
            if (r8 != r14) goto L_0x0140
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
        L_0x013f:
            r9 = 3
        L_0x0140:
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
        L_0x015a:
            r9 = 3
        L_0x015b:
            r6 = 3
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    public JsonToken nextToken() throws IOException {
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
        if (i == 93) {
            _closeArrayScope();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (i == 125) {
            _closeObjectScope();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i == 44) {
                    i = _skipWS();
                    if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                        return _closeScope(i);
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
            if (!this._parsingContext.inObject()) {
                _updateLocation();
                return _nextTokenNotInObject(i);
            }
            _updateNameLocation();
            this._parsingContext.setCurrentName(_parseName(i));
            this._currToken = JsonToken.FIELD_NAME;
            int i2 = _skipColon();
            _updateLocation();
            if (i2 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return this._currToken;
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
                        t = _handleUnexpectedValue(i2);
                        break;
                }
            } else {
                t = JsonToken.START_OBJECT;
            }
            this._nextToken = t;
            return this._currToken;
        }
    }

    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (i == 45) {
            JsonToken _parseNegNumber = _parseNegNumber();
            this._currToken = _parseNegNumber;
            return _parseNegNumber;
        } else if (i == 91) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            JsonToken jsonToken2 = JsonToken.START_ARRAY;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else if (i == 102) {
            _matchFalse();
            JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
            this._currToken = jsonToken3;
            return jsonToken3;
        } else if (i == 110) {
            _matchNull();
            JsonToken jsonToken4 = JsonToken.VALUE_NULL;
            this._currToken = jsonToken4;
            return jsonToken4;
        } else if (i == 116) {
            _matchTrue();
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
                default:
                    JsonToken _handleUnexpectedValue = _handleUnexpectedValue(i);
                    this._currToken = _handleUnexpectedValue;
                    return _handleUnexpectedValue;
            }
        } else {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            JsonToken jsonToken6 = JsonToken.START_OBJECT;
            this._currToken = jsonToken6;
            return jsonToken6;
        }
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
        if (i == 93) {
            _closeArrayScope();
            this._currToken = JsonToken.END_ARRAY;
            return null;
        } else if (i == 125) {
            _closeObjectScope();
            this._currToken = JsonToken.END_OBJECT;
            return null;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i == 44) {
                    i = _skipWS();
                    if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                        _closeScope(i);
                        return null;
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
            if (!this._parsingContext.inObject()) {
                _updateLocation();
                _nextTokenNotInObject(i);
                return null;
            }
            _updateNameLocation();
            String nameStr = _parseName(i);
            this._parsingContext.setCurrentName(nameStr);
            this._currToken = JsonToken.FIELD_NAME;
            int i2 = _skipColon();
            _updateLocation();
            if (i2 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return nameStr;
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
                        t = _handleUnexpectedValue(i2);
                        break;
                }
            } else {
                t = JsonToken.START_OBJECT;
            }
            this._nextToken = t;
            return nameStr;
        }
    }

    public String nextTextValue() throws IOException {
        String str = null;
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t != JsonToken.VALUE_STRING) {
                if (t == JsonToken.START_ARRAY) {
                    this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                } else if (t == JsonToken.START_OBJECT) {
                    this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                }
                return null;
            } else if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            } else {
                this._tokenIncomplete = false;
                return _finishAndReturnString();
            }
        } else {
            if (nextToken() == JsonToken.VALUE_STRING) {
                str = getText();
            }
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public JsonToken _parsePosNumber(int c) throws IOException {
        byte b;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        if (c == 48) {
            c = _verifyNoLeadingZeroes();
        }
        outBuf[0] = (char) c;
        int end = Math.min(this._inputEnd, (this._inputPtr + outBuf.length) - 1);
        int intLen = 1;
        int outPtr = 1;
        while (true) {
            int intLen2 = this._inputPtr;
            if (intLen2 >= end) {
                return _parseNumber2(outBuf, outPtr, false, intLen);
            }
            byte[] bArr = this._inputBuffer;
            this._inputPtr = intLen2 + 1;
            b = bArr[intLen2] & 255;
            if (b >= 48 && b <= 57) {
                intLen++;
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = (char) b;
                outPtr = outPtr2;
            }
        }
        if (b == 46 || b == 101 || b == 69) {
            return _parseFloat(outBuf, outPtr, b, false, intLen);
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(b);
        }
        return resetInt(false, intLen);
    }

    /* access modifiers changed from: protected */
    public JsonToken _parseNegNumber() throws IOException {
        int i;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = 0 + 1;
        outBuf[0] = '-';
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int c = bArr[i2] & 255;
        if (c <= 48) {
            if (c != 48) {
                return _handleInvalidNumberStart(c, true);
            }
            c = _verifyNoLeadingZeroes();
        } else if (c > 57) {
            return _handleInvalidNumberStart(c, true);
        }
        int outPtr2 = outPtr + 1;
        outBuf[outPtr] = (char) c;
        int end = Math.min(this._inputEnd, (this._inputPtr + outBuf.length) - outPtr2);
        int intLen = 1;
        int outPtr3 = outPtr2;
        while (true) {
            int intLen2 = this._inputPtr;
            if (intLen2 >= end) {
                return _parseNumber2(outBuf, outPtr3, true, intLen);
            }
            byte[] bArr2 = this._inputBuffer;
            this._inputPtr = intLen2 + 1;
            i = bArr2[intLen2] & 255;
            if (i >= 48 && i <= 57) {
                intLen++;
                int outPtr4 = outPtr3 + 1;
                outBuf[outPtr3] = (char) i;
                outPtr3 = outPtr4;
                int outPtr5 = i;
            }
        }
        if (i == 46 || i == 101 || i == 69) {
            return _parseFloat(outBuf, outPtr3, i, true, intLen);
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr3);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(i);
        }
        return resetInt(true, intLen);
    }

    private final JsonToken _parseNumber2(char[] outBuf, int outPtr, boolean negative, int intPartLength) throws IOException {
        byte b;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                b = bArr[i] & 255;
                if (b <= 57 && b >= 48) {
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    int outPtr2 = outPtr + 1;
                    outBuf[outPtr] = (char) b;
                    intPartLength++;
                    outPtr = outPtr2;
                }
            } else {
                this._textBuffer.setCurrentLength(outPtr);
                return resetInt(negative, intPartLength);
            }
        }
        if (b == 46 || b == 101 || b == 69) {
            return _parseFloat(outBuf, outPtr, b, negative, intPartLength);
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr);
        if (this._parsingContext.inRoot()) {
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            _verifyRootSpace(bArr2[i2] & 255);
        }
        return resetInt(negative, intPartLength);
    }

    private final int _verifyNoLeadingZeroes() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return 48;
        }
        int ch = this._inputBuffer[this._inputPtr] & 255;
        if (ch < 48 || ch > 57) {
            return 48;
        }
        if (isEnabled(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            this._inputPtr++;
            if (ch == 48) {
                do {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        break;
                    }
                    byte[] bArr = this._inputBuffer;
                    int i = this._inputPtr;
                    ch = bArr[i] & 255;
                    if (ch < 48 || ch > 57) {
                        return 48;
                    }
                    this._inputPtr = i + 1;
                } while (ch == 48);
            }
            return ch;
        }
        reportInvalidNumber("Leading zeroes not allowed");
        throw null;
    }

    private final JsonToken _parseFloat(char[] outBuf, int outPtr, int outPtr2, boolean negative, int integerPartLength) throws IOException {
        int fractLen = 0;
        boolean eof = false;
        if (outPtr2 == 46) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr3 = outPtr + 1;
            outBuf[outPtr] = (char) outPtr2;
            while (true) {
                outPtr = outPtr3;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                outPtr2 = bArr[i] & 255;
                if (outPtr2 < 48 || outPtr2 > 57) {
                    break;
                }
                fractLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr3 = outPtr + 1;
                outBuf[outPtr] = (char) outPtr2;
            }
            if (fractLen == 0) {
                reportUnexpectedNumberChar(outPtr2, "Decimal point not followed by a digit");
                throw null;
            }
        }
        int expLen = 0;
        if (outPtr == 101 || outPtr == 69) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int outPtr4 = outPtr + 1;
            outBuf[outPtr] = (char) outPtr;
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            int c = bArr2[i2] & 255;
            if (c == 45 || c == 43) {
                if (outPtr4 >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr4 = 0;
                }
                int outPtr5 = outPtr4 + 1;
                outBuf[outPtr4] = (char) c;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int c2 = bArr3[i3] & 255;
                outPtr4 = outPtr5;
                outPtr = c2;
            } else {
                outPtr = c;
            }
            while (true) {
                if (outPtr >= 48 && outPtr <= 57) {
                    expLen++;
                    if (outPtr4 >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr4 = 0;
                    }
                    outPtr = outPtr4 + 1;
                    outBuf[outPtr4] = (char) outPtr;
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        eof = true;
                        break;
                    }
                    byte[] bArr4 = this._inputBuffer;
                    int i4 = this._inputPtr;
                    this._inputPtr = i4 + 1;
                    outPtr = bArr4[i4] & 255;
                    outPtr4 = outPtr;
                } else {
                    outPtr = outPtr4;
                }
            }
            outPtr = outPtr4;
            if (expLen == 0) {
                reportUnexpectedNumberChar(outPtr, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!eof) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(outPtr);
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        return resetFloat(negative, integerPartLength, fractLen, expLen);
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
    public final String _parseName(int i) throws IOException {
        if (i != 34) {
            return _handleOddName(i);
        }
        int i2 = this._inputPtr;
        if (i2 + 13 > this._inputEnd) {
            return slowParseName();
        }
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        this._inputPtr = i2 + 1;
        int q = input[i2] & 255;
        if (codes[q] == 0) {
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q2 = (q << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q3 = (q2 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & 255;
                    if (codes[i8] == 0) {
                        int q4 = (q3 << 8) | i8;
                        int i9 = this._inputPtr;
                        this._inputPtr = i9 + 1;
                        int i10 = input[i9] & 255;
                        if (codes[i10] == 0) {
                            this._quad1 = q4;
                            return parseMediumName(i10);
                        } else if (i10 == 34) {
                            return findName(q4, 4);
                        } else {
                            return parseName(q4, i10, 4);
                        }
                    } else if (i8 == 34) {
                        return findName(q3, 3);
                    } else {
                        return parseName(q3, i8, 3);
                    }
                } else if (i6 == 34) {
                    return findName(q2, 2);
                } else {
                    return parseName(q2, i6, 2);
                }
            } else if (i4 == 34) {
                return findName(q, 1);
            } else {
                return parseName(q, i4, 1);
            }
        } else if (q == 34) {
            return "";
        } else {
            return parseName(0, q, 0);
        }
    }

    /* access modifiers changed from: protected */
    public final String parseMediumName(int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = input[i] & 255;
        if (codes[i2] == 0) {
            int q22 = (q2 << 8) | i2;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q23 = (q22 << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q24 = (q23 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & 255;
                    if (codes[i8] == 0) {
                        return parseMediumName2(i8, q24);
                    }
                    if (i8 == 34) {
                        return findName(this._quad1, q24, 4);
                    }
                    return parseName(this._quad1, q24, i8, 4);
                } else if (i6 == 34) {
                    return findName(this._quad1, q23, 3);
                } else {
                    return parseName(this._quad1, q23, i6, 3);
                }
            } else if (i4 == 34) {
                return findName(this._quad1, q22, 2);
            } else {
                return parseName(this._quad1, q22, i4, 2);
            }
        } else if (i2 == 34) {
            return findName(this._quad1, q2, 1);
        } else {
            return parseName(this._quad1, q2, i2, 1);
        }
    }

    /* access modifiers changed from: protected */
    public final String parseMediumName2(int q3, int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = input[i] & 255;
        if (codes[i2] == 0) {
            int q32 = (q3 << 8) | i2;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q33 = (q32 << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q34 = (q33 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    byte b = input[i7] & 255;
                    if (codes[b] == 0) {
                        return parseLongName(b, q2, q34);
                    }
                    if (b == 34) {
                        return findName(this._quad1, q2, q34, 4);
                    }
                    return parseName(this._quad1, q2, q34, b, 4);
                } else if (i6 == 34) {
                    return findName(this._quad1, q2, q33, 3);
                } else {
                    return parseName(this._quad1, q2, q33, i6, 3);
                }
            } else if (i4 == 34) {
                return findName(this._quad1, q2, q32, 2);
            } else {
                return parseName(this._quad1, q2, q32, i4, 2);
            }
        } else if (i2 == 34) {
            return findName(this._quad1, q2, q3, 1);
        } else {
            return parseName(this._quad1, q2, q3, i2, 1);
        }
    }

    /* access modifiers changed from: protected */
    public final String parseLongName(int q, int q2, int q3) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = this._quad1;
        iArr[1] = q2;
        iArr[2] = q3;
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int qlen = 3;
        while (true) {
            int i = this._inputPtr;
            if (i + 4 <= this._inputEnd) {
                this._inputPtr = i + 1;
                int i2 = input[i] & 255;
                if (codes[i2] == 0) {
                    int q4 = (q << 8) | i2;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    int i4 = input[i3] & 255;
                    if (codes[i4] == 0) {
                        int q5 = (q4 << 8) | i4;
                        int i5 = this._inputPtr;
                        this._inputPtr = i5 + 1;
                        int i6 = input[i5] & 255;
                        if (codes[i6] == 0) {
                            int q6 = (q5 << 8) | i6;
                            int i7 = this._inputPtr;
                            this._inputPtr = i7 + 1;
                            int i8 = input[i7] & 255;
                            if (codes[i8] == 0) {
                                int[] iArr2 = this._quadBuffer;
                                if (qlen >= iArr2.length) {
                                    this._quadBuffer = ParserBase.growArrayBy(iArr2, qlen);
                                }
                                int qlen2 = qlen + 1;
                                this._quadBuffer[qlen] = q6;
                                q = i8;
                                qlen = qlen2;
                            } else if (i8 == 34) {
                                return findName(this._quadBuffer, qlen, q6, 4);
                            } else {
                                return parseEscapedName(this._quadBuffer, qlen, q6, i8, 4);
                            }
                        } else if (i6 == 34) {
                            return findName(this._quadBuffer, qlen, q5, 3);
                        } else {
                            return parseEscapedName(this._quadBuffer, qlen, q5, i6, 3);
                        }
                    } else if (i4 == 34) {
                        return findName(this._quadBuffer, qlen, q4, 2);
                    } else {
                        return parseEscapedName(this._quadBuffer, qlen, q4, i4, 2);
                    }
                } else if (i2 == 34) {
                    return findName(this._quadBuffer, qlen, q, 1);
                } else {
                    return parseEscapedName(this._quadBuffer, qlen, q, i2, 1);
                }
            } else {
                return parseEscapedName(this._quadBuffer, qlen, 0, q, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String slowParseName() throws IOException {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte b = bArr[i] & 255;
            if (b == 34) {
                return "";
            }
            return parseEscapedName(this._quadBuffer, 0, 0, b, 0);
        }
        _reportInvalidEOF(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
        throw null;
    }

    private final String parseName(int q1, int ch, int lastQuadBytes) throws IOException {
        return parseEscapedName(this._quadBuffer, 0, q1, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int ch, int lastQuadBytes) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = q1;
        return parseEscapedName(iArr, 1, q2, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int q3, int ch, int lastQuadBytes) throws IOException {
        int[] iArr = this._quadBuffer;
        iArr[0] = q1;
        iArr[1] = q2;
        return parseEscapedName(iArr, 2, q3, ch, lastQuadBytes);
    }

    /* access modifiers changed from: protected */
    public final String parseEscapedName(int[] quads, int qlen, int currQuad, int ch, int currQuadBytes) throws IOException {
        int[] codes = _icLatin1;
        while (true) {
            if (codes[ch] != 0) {
                if (ch == 34) {
                    if (currQuadBytes > 0) {
                        if (qlen >= quads.length) {
                            int[] growArrayBy = ParserBase.growArrayBy(quads, quads.length);
                            quads = growArrayBy;
                            this._quadBuffer = growArrayBy;
                        }
                        int qlen2 = qlen + 1;
                        quads[qlen] = _padLastQuad(currQuad, currQuadBytes);
                        qlen = qlen2;
                    }
                    String name = this._symbols.findName(quads, qlen);
                    if (name == null) {
                        return addName(quads, qlen, currQuadBytes);
                    }
                    return name;
                }
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            int[] growArrayBy2 = ParserBase.growArrayBy(quads, quads.length);
                            quads = growArrayBy2;
                            this._quadBuffer = growArrayBy2;
                        }
                        int qlen3 = qlen + 1;
                        quads[qlen] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                        qlen = qlen3;
                    }
                    if (ch < 2048) {
                        currQuad = (currQuad << 8) | (ch >> 6) | Opcodes.CHECKCAST;
                        currQuadBytes++;
                    } else {
                        int currQuad2 = (currQuad << 8) | (ch >> 12) | 224;
                        int currQuadBytes2 = currQuadBytes + 1;
                        if (currQuadBytes2 >= 4) {
                            if (qlen >= quads.length) {
                                int[] growArrayBy3 = ParserBase.growArrayBy(quads, quads.length);
                                quads = growArrayBy3;
                                this._quadBuffer = growArrayBy3;
                            }
                            int qlen4 = qlen + 1;
                            quads[qlen] = currQuad2;
                            currQuad2 = 0;
                            currQuadBytes2 = 0;
                            qlen = qlen4;
                        }
                        currQuad = (currQuad2 << 8) | ((ch >> 6) & 63) | 128;
                        currQuadBytes = currQuadBytes2 + 1;
                    }
                    ch = (ch & 63) | 128;
                }
            }
            if (currQuadBytes < 4) {
                currQuadBytes = currQuadBytes + 1;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] growArrayBy4 = ParserBase.growArrayBy(quads, quads.length);
                    quads = growArrayBy4;
                    this._quadBuffer = growArrayBy4;
                }
                int qlen5 = qlen + 1;
                quads[qlen] = currQuad;
                currQuadBytes = 1;
                currQuad = ch;
                qlen = qlen5;
            }
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                ch = bArr[i] & 255;
            } else {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String _handleOddName(int ch) throws IOException {
        int qlen;
        if (ch == 39 && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseAposName();
        }
        if (isEnabled(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] codes = CharTypes.getInputCodeUtf8JsNames();
            if (codes[ch] == 0) {
                int[] quads = this._quadBuffer;
                int currQuad = 0;
                int currQuad2 = 0;
                int currQuadBytes = 0;
                while (true) {
                    if (currQuadBytes < 4) {
                        currQuadBytes++;
                        currQuad2 = (currQuad2 << 8) | ch;
                    } else {
                        if (currQuad >= quads.length) {
                            int[] growArrayBy = ParserBase.growArrayBy(quads, quads.length);
                            quads = growArrayBy;
                            this._quadBuffer = growArrayBy;
                        }
                        int qlen2 = currQuad + 1;
                        quads[currQuad] = currQuad2;
                        currQuadBytes = 1;
                        currQuad2 = ch;
                        currQuad = qlen2;
                    }
                    if (this._inputPtr < this._inputEnd || _loadMore()) {
                        byte[] bArr = this._inputBuffer;
                        int i = this._inputPtr;
                        ch = bArr[i] & 255;
                        if (codes[ch] != 0) {
                            if (currQuadBytes > 0) {
                                if (currQuad >= quads.length) {
                                    int[] growArrayBy2 = ParserBase.growArrayBy(quads, quads.length);
                                    quads = growArrayBy2;
                                    this._quadBuffer = growArrayBy2;
                                }
                                qlen = currQuad + 1;
                                quads[currQuad] = currQuad2;
                            } else {
                                qlen = currQuad;
                            }
                            String name = this._symbols.findName(quads, qlen);
                            if (name == null) {
                                name = addName(quads, qlen, currQuadBytes);
                            }
                            return name;
                        }
                        this._inputPtr = i + 1;
                    } else {
                        _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                        throw null;
                    }
                }
            } else {
                _reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
                throw null;
            }
        } else {
            _reportUnexpectedChar((char) _decodeCharForError(ch), "was expecting double-quote to start field name");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public String _parseAposName() throws IOException {
        int currQuadBytes;
        int currQuad;
        int qlen;
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch == 39) {
                return "";
            }
            int[] quads = this._quadBuffer;
            int qlen2 = 0;
            int currQuad2 = 0;
            int currQuadBytes2 = 0;
            int[] codes = _icLatin1;
            while (ch != 39) {
                if (!(codes[ch] == 0 || ch == '\"')) {
                    if (ch != '\\') {
                        _throwUnquotedSpace(ch, "name");
                    } else {
                        ch = _decodeEscaped();
                    }
                    if (ch > 127) {
                        if (currQuadBytes >= 4) {
                            if (qlen2 >= quads.length) {
                                int[] growArrayBy = ParserBase.growArrayBy(quads, quads.length);
                                quads = growArrayBy;
                                this._quadBuffer = growArrayBy;
                            }
                            int qlen3 = qlen2 + 1;
                            quads[qlen2] = currQuad;
                            currQuad = 0;
                            currQuadBytes = 0;
                            qlen2 = qlen3;
                        }
                        if (ch < 2048) {
                            currQuad = (currQuad << 8) | (ch >> 6) | Opcodes.CHECKCAST;
                            currQuadBytes++;
                        } else {
                            int currQuad3 = (currQuad << 8) | (ch >> 12) | 224;
                            int currQuadBytes3 = currQuadBytes + 1;
                            if (currQuadBytes3 >= 4) {
                                if (qlen2 >= quads.length) {
                                    int[] growArrayBy2 = ParserBase.growArrayBy(quads, quads.length);
                                    quads = growArrayBy2;
                                    this._quadBuffer = growArrayBy2;
                                }
                                int qlen4 = qlen2 + 1;
                                quads[qlen2] = currQuad3;
                                currQuad3 = 0;
                                currQuadBytes3 = 0;
                                qlen2 = qlen4;
                            }
                            currQuad = (currQuad3 << 8) | ((ch >> 6) & 63) | 128;
                            currQuadBytes = currQuadBytes3 + 1;
                        }
                        ch = (ch & 63) | 128;
                    }
                }
                if (currQuadBytes < 4) {
                    currQuadBytes2 = currQuadBytes + 1;
                    currQuad2 = (currQuad << 8) | ch;
                } else {
                    if (qlen2 >= quads.length) {
                        int[] growArrayBy3 = ParserBase.growArrayBy(quads, quads.length);
                        quads = growArrayBy3;
                        this._quadBuffer = growArrayBy3;
                    }
                    int qlen5 = qlen2 + 1;
                    quads[qlen2] = currQuad;
                    currQuadBytes2 = 1;
                    currQuad2 = ch;
                    qlen2 = qlen5;
                }
                if (this._inputPtr < this._inputEnd || _loadMore()) {
                    byte[] bArr2 = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    ch = bArr2[i2] & 255;
                } else {
                    _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                    throw null;
                }
            }
            if (currQuadBytes > 0) {
                if (qlen2 >= quads.length) {
                    int[] growArrayBy4 = ParserBase.growArrayBy(quads, quads.length);
                    int[] quads2 = growArrayBy4;
                    this._quadBuffer = growArrayBy4;
                    quads = quads2;
                }
                qlen = qlen2 + 1;
                quads[qlen2] = _padLastQuad(currQuad, currQuadBytes);
            } else {
                qlen = qlen2;
            }
            String name = this._symbols.findName(quads, qlen);
            if (name == null) {
                name = addName(quads, qlen, currQuadBytes);
            }
            return name;
        }
        _reportInvalidEOF(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
        throw null;
    }

    private final String findName(int q1, int lastQuadBytes) throws JsonParseException {
        int q12 = _padLastQuad(q1, lastQuadBytes);
        String name = this._symbols.findName(q12);
        if (name != null) {
            return name;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = q12;
        return addName(iArr, 1, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int lastQuadBytes) throws JsonParseException {
        int q22 = _padLastQuad(q2, lastQuadBytes);
        String name = this._symbols.findName(q1, q22);
        if (name != null) {
            return name;
        }
        int[] iArr = this._quadBuffer;
        iArr[0] = q1;
        iArr[1] = q22;
        return addName(iArr, 2, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int q3, int lastQuadBytes) throws JsonParseException {
        int q32 = _padLastQuad(q3, lastQuadBytes);
        String name = this._symbols.findName(q1, q2, q32);
        if (name != null) {
            return name;
        }
        int[] quads = this._quadBuffer;
        quads[0] = q1;
        quads[1] = q2;
        quads[2] = _padLastQuad(q32, lastQuadBytes);
        return addName(quads, 3, lastQuadBytes);
    }

    private final String findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) throws JsonParseException {
        if (qlen >= quads.length) {
            int[] growArrayBy = ParserBase.growArrayBy(quads, quads.length);
            quads = growArrayBy;
            this._quadBuffer = growArrayBy;
        }
        int qlen2 = qlen + 1;
        quads[qlen] = _padLastQuad(lastQuad, lastQuadBytes);
        String name = this._symbols.findName(quads, qlen2);
        if (name == null) {
            return addName(quads, qlen2, lastQuadBytes);
        }
        return name;
    }

    private final String addName(int[] quads, int qlen, int lastQuadBytes) throws JsonParseException {
        int lastQuad;
        int needed;
        int ch;
        int[] iArr = quads;
        int i = qlen;
        int i2 = lastQuadBytes;
        int byteLen = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            lastQuad = iArr[i - 1];
            iArr[i - 1] = lastQuad << ((4 - i2) << 3);
        } else {
            lastQuad = 0;
        }
        char[] cbuf = this._textBuffer.emptyAndGetCurrentSegment();
        int cix = 0;
        int ix = 0;
        while (ix < byteLen) {
            int ch2 = (iArr[ix >> 2] >> ((3 - (ix & 3)) << 3)) & 255;
            ix++;
            if (ch2 > 127) {
                if ((ch2 & 224) == 192) {
                    ch = ch2 & 31;
                    needed = 1;
                } else if ((ch2 & 240) == 224) {
                    ch = ch2 & 15;
                    needed = 2;
                } else if ((ch2 & 248) == 240) {
                    ch = ch2 & 7;
                    needed = 3;
                } else {
                    _reportInvalidInitial(ch2);
                    throw null;
                }
                if (ix + needed <= byteLen) {
                    int ch22 = iArr[ix >> 2] >> ((3 - (ix & 3)) << 3);
                    ix++;
                    if ((ch22 & Opcodes.CHECKCAST) == 128) {
                        ch2 = (ch << 6) | (ch22 & 63);
                        if (needed > 1) {
                            int ch23 = iArr[ix >> 2] >> ((3 - (ix & 3)) << 3);
                            ix++;
                            if ((ch23 & Opcodes.CHECKCAST) == 128) {
                                ch2 = (ch2 << 6) | (ch23 & 63);
                                if (needed > 2) {
                                    int ch24 = iArr[ix >> 2] >> ((3 - (ix & 3)) << 3);
                                    ix++;
                                    if ((ch24 & Opcodes.CHECKCAST) == 128) {
                                        ch2 = (ch2 << 6) | (ch24 & 63);
                                    } else {
                                        _reportInvalidOther(ch24 & 255);
                                        throw null;
                                    }
                                }
                            } else {
                                _reportInvalidOther(ch23);
                                throw null;
                            }
                        }
                        if (needed > 2) {
                            int ch3 = ch2 - 65536;
                            if (cix >= cbuf.length) {
                                cbuf = this._textBuffer.expandCurrentSegment();
                            }
                            int cix2 = cix + 1;
                            cbuf[cix] = (char) ((ch3 >> 10) + 55296);
                            ch2 = (ch3 & 1023) | 56320;
                            cix = cix2;
                        }
                    } else {
                        _reportInvalidOther(ch22);
                        throw null;
                    }
                } else {
                    _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                    throw null;
                }
            }
            if (cix >= cbuf.length) {
                cbuf = this._textBuffer.expandCurrentSegment();
            }
            int cix3 = cix + 1;
            cbuf[cix] = (char) ch2;
            cix = cix3;
        }
        String baseName = new String(cbuf, 0, cix);
        if (i2 < 4) {
            iArr[i - 1] = lastQuad;
        }
        return this._symbols.addName(baseName, iArr, i);
    }

    private static final int _padLastQuad(int q, int bytes) {
        return bytes == 4 ? q : (-1 << (bytes << 3)) | q;
    }

    /* access modifiers changed from: protected */
    public void _loadMoreGuaranteed() throws IOException {
        if (!_loadMore()) {
            _reportInvalidEOF();
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _finishString() throws IOException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            _loadMoreGuaranteed();
            ptr = this._inputPtr;
        }
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int max = Math.min(this._inputEnd, outBuf.length + ptr);
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (ptr >= max) {
                break;
            }
            int c = inputBuffer[ptr] & 255;
            if (codes[c] == 0) {
                ptr++;
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = (char) c;
                outPtr = outPtr2;
            } else if (c == 34) {
                this._inputPtr = ptr + 1;
                this._textBuffer.setCurrentLength(outPtr);
                return;
            }
        }
        this._inputPtr = ptr;
        _finishString2(outBuf, outPtr);
    }

    /* access modifiers changed from: protected */
    public String _finishAndReturnString() throws IOException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            _loadMoreGuaranteed();
            ptr = this._inputPtr;
        }
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int max = Math.min(this._inputEnd, outBuf.length + ptr);
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (ptr >= max) {
                break;
            }
            int c = inputBuffer[ptr] & 255;
            if (codes[c] == 0) {
                ptr++;
                int outPtr2 = outPtr + 1;
                outBuf[outPtr] = (char) c;
                outPtr = outPtr2;
            } else if (c == 34) {
                this._inputPtr = ptr + 1;
                return this._textBuffer.setCurrentAndReturn(outPtr);
            }
        }
        this._inputPtr = ptr;
        _finishString2(outBuf, outPtr);
        return this._textBuffer.contentsAsString();
    }

    private final void _finishString2(char[] outBuf, int outPtr) throws IOException {
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            int ptr = this._inputPtr;
            if (ptr >= this._inputEnd) {
                _loadMoreGuaranteed();
                ptr = this._inputPtr;
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = Math.min(this._inputEnd, (outBuf.length - outPtr) + ptr);
            while (true) {
                if (ptr >= max) {
                    this._inputPtr = ptr;
                    break;
                }
                int ptr2 = ptr + 1;
                int c = inputBuffer[ptr] & 255;
                if (codes[c] != 0) {
                    this._inputPtr = ptr2;
                    if (c == 34) {
                        this._textBuffer.setCurrentLength(outPtr);
                        return;
                    }
                    int i = codes[c];
                    if (i == 1) {
                        c = _decodeEscaped();
                    } else if (i == 2) {
                        c = _decodeUtf8_2(c);
                    } else if (i != 3) {
                        if (i == 4) {
                            int c2 = _decodeUtf8_4(c);
                            int outPtr2 = outPtr + 1;
                            outBuf[outPtr] = (char) (55296 | (c2 >> 10));
                            if (outPtr2 >= outBuf.length) {
                                outBuf = this._textBuffer.finishCurrentSegment();
                                outPtr = 0;
                            } else {
                                outPtr = outPtr2;
                            }
                            c = (c2 & 1023) | 56320;
                        } else if (c < 32) {
                            _throwUnquotedSpace(c, "string value");
                        } else {
                            _reportInvalidChar(c);
                            throw null;
                        }
                    } else if (this._inputEnd - this._inputPtr >= 2) {
                        c = _decodeUtf8_3fast(c);
                    } else {
                        c = _decodeUtf8_3(c);
                    }
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    int outPtr3 = outPtr + 1;
                    outBuf[outPtr] = (char) c;
                    outPtr = outPtr3;
                } else {
                    int outPtr4 = outPtr + 1;
                    outBuf[outPtr] = (char) c;
                    ptr = ptr2;
                    outPtr = outPtr4;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            int ptr = this._inputPtr;
            int max = this._inputEnd;
            if (ptr >= max) {
                _loadMoreGuaranteed();
                ptr = this._inputPtr;
                max = this._inputEnd;
            }
            while (true) {
                if (ptr >= max) {
                    this._inputPtr = ptr;
                    break;
                }
                int ptr2 = ptr + 1;
                int c = inputBuffer[ptr] & 255;
                if (codes[c] != 0) {
                    this._inputPtr = ptr2;
                    if (c != 34) {
                        int i = codes[c];
                        if (i == 1) {
                            _decodeEscaped();
                        } else if (i == 2) {
                            _skipUtf8_2();
                        } else if (i == 3) {
                            _skipUtf8_3();
                        } else if (i == 4) {
                            _skipUtf8_4(c);
                        } else if (c < 32) {
                            _throwUnquotedSpace(c, "string value");
                        } else {
                            _reportInvalidChar(c);
                            throw null;
                        }
                    } else {
                        return;
                    }
                } else {
                    ptr = ptr2;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r4 != 44) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r3._parsingContext.inArray() == false) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            r1 = 0
            if (r4 == r0) goto L_0x0098
            r0 = 73
            r2 = 1
            if (r4 == r0) goto L_0x007e
            r0 = 78
            if (r4 == r0) goto L_0x0064
            r0 = 93
            if (r4 == r0) goto L_0x0045
            r0 = 125(0x7d, float:1.75E-43)
            if (r4 == r0) goto L_0x005e
            r0 = 43
            if (r4 == r0) goto L_0x0020
            r0 = 44
            if (r4 == r0) goto L_0x004e
            goto L_0x00a5
        L_0x0020:
            int r0 = r3._inputPtr
            int r2 = r3._inputEnd
            if (r0 < r2) goto L_0x0033
            boolean r0 = r3._loadMore()
            if (r0 == 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3._reportInvalidEOFInValue(r4)
            throw r1
        L_0x0033:
            byte[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            int r2 = r1 + 1
            r3._inputPtr = r2
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            com.fasterxml.jackson.core.JsonToken r0 = r3._handleInvalidNumberStart(r0, r1)
            return r0
        L_0x0045:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L_0x004e
            goto L_0x00a5
        L_0x004e:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_MISSING_VALUES
            boolean r0 = r3.isEnabled(r0)
            if (r0 == 0) goto L_0x005e
            int r0 = r3._inputPtr
            int r0 = r0 - r2
            r3._inputPtr = r0
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r0
        L_0x005e:
            java.lang.String r0 = "expected a value"
            r3._reportUnexpectedChar(r4, r0)
            throw r1
        L_0x0064:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r2 = r3.isEnabled(r2)
            if (r2 == 0) goto L_0x0078
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r0 = r3.resetAsNaN(r0, r1)
            return r0
        L_0x0078:
            java.lang.String r4 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r4)
            throw r1
        L_0x007e:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r2 = r3.isEnabled(r2)
            if (r2 == 0) goto L_0x0092
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r0 = r3.resetAsNaN(r0, r1)
            return r0
        L_0x0092:
            java.lang.String r4 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r4)
            throw r1
        L_0x0098:
            com.fasterxml.jackson.core.JsonParser$Feature r0 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES
            boolean r0 = r3.isEnabled(r0)
            if (r0 == 0) goto L_0x00a5
            com.fasterxml.jackson.core.JsonToken r0 = r3._handleApos()
            return r0
        L_0x00a5:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto L_0x00c3
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
        L_0x00c3:
            java.lang.String r0 = "expected a valid value (number, String, array, object, 'true', 'false' or 'null')"
            r3._reportUnexpectedChar(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    /* access modifiers changed from: protected */
    public JsonToken _handleApos() throws IOException {
        int c;
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = this._inputEnd;
            int max2 = this._inputPtr + (outBuf.length - outPtr);
            if (max2 < max) {
                max = max2;
            }
            while (true) {
                int max22 = this._inputPtr;
                if (max22 >= max) {
                    break;
                }
                this._inputPtr = max22 + 1;
                int c2 = inputBuffer[max22] & 255;
                if (c2 != 39 && codes[c2] == 0) {
                    int outPtr2 = outPtr + 1;
                    outBuf[outPtr] = (char) c2;
                    outPtr = outPtr2;
                } else if (c2 == 39) {
                    this._textBuffer.setCurrentLength(outPtr);
                    return JsonToken.VALUE_STRING;
                } else {
                    int i = codes[c2];
                    if (i == 1) {
                        c = _decodeEscaped();
                    } else if (i == 2) {
                        c = _decodeUtf8_2(c2);
                    } else if (i != 3) {
                        if (i != 4) {
                            if (c2 < 32) {
                                _throwUnquotedSpace(c2, "string value");
                            }
                            _reportInvalidChar(c2);
                            throw null;
                        }
                        int c3 = _decodeUtf8_4(c2);
                        int outPtr3 = outPtr + 1;
                        outBuf[outPtr] = (char) (55296 | (c3 >> 10));
                        if (outPtr3 >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                        } else {
                            outPtr = outPtr3;
                        }
                        c = (c3 & 1023) | 56320;
                    } else if (this._inputEnd - this._inputPtr >= 2) {
                        c = _decodeUtf8_3fast(c2);
                    } else {
                        c = _decodeUtf8_3(c2);
                    }
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.finishCurrentSegment();
                        outPtr = 0;
                    }
                    int outPtr4 = outPtr + 1;
                    outBuf[outPtr] = (char) c;
                    outPtr = outPtr4;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=byte, for r5v0, types: [int] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(byte r5, boolean r6) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 73
            r1 = 0
            if (r5 != r0) goto L_0x0057
            int r0 = r4._inputPtr
            int r2 = r4._inputEnd
            if (r0 < r2) goto L_0x0018
            boolean r0 = r4._loadMore()
            if (r0 == 0) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT
            r4._reportInvalidEOFInValue(r5)
            throw r1
        L_0x0018:
            byte[] r0 = r4._inputBuffer
            int r2 = r4._inputPtr
            int r3 = r2 + 1
            r4._inputPtr = r3
            byte r5 = r0[r2]
            r0 = 78
            if (r5 != r0) goto L_0x002e
            if (r6 == 0) goto L_0x002b
            java.lang.String r0 = "-INF"
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = "+INF"
        L_0x002d:
            goto L_0x0039
        L_0x002e:
            r0 = 110(0x6e, float:1.54E-43)
            if (r5 != r0) goto L_0x0057
            if (r6 == 0) goto L_0x0037
            java.lang.String r0 = "-Infinity"
            goto L_0x0039
        L_0x0037:
            java.lang.String r0 = "+Infinity"
        L_0x0039:
            r2 = 3
            r4._matchToken(r0, r2)
            com.fasterxml.jackson.core.JsonParser$Feature r2 = com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS
            boolean r2 = r4.isEnabled(r2)
            if (r2 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x004a
            r1 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L_0x004c
        L_0x004a:
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
        L_0x004c:
            com.fasterxml.jackson.core.JsonToken r1 = r4.resetAsNaN(r0, r1)
            return r1
        L_0x0051:
            java.lang.String r5 = "Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r4._reportError(r5, r0)
            throw r1
        L_0x0057:
            java.lang.String r6 = "expected digit (0-9) to follow minus sign, for valid numeric value"
            r4.reportUnexpectedNumberChar(r5, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleInvalidNumberStart(int, boolean):com.fasterxml.jackson.core.JsonToken");
    }

    /* access modifiers changed from: protected */
    public final void _matchTrue() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 114) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 117) {
                    int ptr4 = ptr3 + 1;
                    if (buf[ptr3] == 101) {
                        int ch = buf[ptr4] & 255;
                        if (ch < 48 || ch == 93 || ch == 125) {
                            this._inputPtr = ptr4;
                            return;
                        }
                    }
                    int ch2 = ptr4;
                }
            } else {
                int i = ptr2;
            }
        }
        _matchToken2("true", 1);
    }

    /* access modifiers changed from: protected */
    public final void _matchFalse() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 4 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 97) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 108) {
                    ptr2 = ptr3 + 1;
                    if (buf[ptr3] == 115) {
                        int ptr4 = ptr2 + 1;
                        if (buf[ptr2] == 101) {
                            int ch = buf[ptr4] & 255;
                            if (ch < 48 || ch == 93 || ch == 125) {
                                this._inputPtr = ptr4;
                                return;
                            }
                        }
                    }
                }
            }
        }
        _matchToken2(AdultContentAnalytics.UNLOCK, 1);
    }

    /* access modifiers changed from: protected */
    public final void _matchNull() throws IOException {
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 117) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 108) {
                    int ptr4 = ptr3 + 1;
                    if (buf[ptr3] == 108) {
                        int ch = buf[ptr4] & 255;
                        if (ch < 48 || ch == 93 || ch == 125) {
                            this._inputPtr = ptr4;
                            return;
                        }
                    }
                    int ch2 = ptr4;
                }
            } else {
                int i = ptr2;
            }
        }
        _matchToken2("null", 1);
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
                int ch = this._inputBuffer[this._inputPtr] & 255;
                if (!(ch < 48 || ch == 93 || ch == 125)) {
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
            int ch = this._inputBuffer[this._inputPtr] & 255;
            if (!(ch < 48 || ch == 93 || ch == 125)) {
                _checkMatchEnd(matchStr, i, ch);
            }
        }
    }

    private final void _checkMatchEnd(String matchStr, int i, int ch) throws IOException {
        if (Character.isJavaIdentifierPart((char) _decodeCharForError(ch))) {
            _reportInvalidToken(matchStr.substring(0, i));
            throw null;
        }
    }

    private final int _skipWS() throws IOException {
        while (true) {
            int i = this._inputPtr;
            if (i >= this._inputEnd) {
                return _skipWS2();
            }
            byte[] bArr = this._inputBuffer;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 != 47 && i2 != 35) {
                    return i2;
                }
                this._inputPtr--;
                return _skipWS2();
            } else if (i2 != 32) {
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
        }
    }

    private final int _skipWS2() throws IOException {
        int i;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                i = bArr[i2] & 255;
                if (i > 32) {
                    if (i == 47) {
                        _skipComment();
                    } else if (i != 35 || !_skipYAMLComment()) {
                        return i;
                    }
                } else if (i == 32) {
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
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 <= 32) {
            if (i2 != 32) {
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
                byte[] bArr2 = this._inputBuffer;
                this._inputPtr = i3 + 1;
                int i4 = bArr2[i3] & 255;
                if (i4 > 32) {
                    if (i4 != 47 && i4 != 35) {
                        return i4;
                    }
                    this._inputPtr--;
                    return _skipWSOrEnd2();
                } else if (i4 != 32) {
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
        } else if (i2 != 47 && i2 != 35) {
            return i2;
        } else {
            this._inputPtr--;
            return _skipWSOrEnd2();
        }
    }

    private final int _skipWSOrEnd2() throws IOException {
        int i;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            i = bArr[i2] & 255;
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    return i;
                }
            } else if (i == 32) {
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

    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v1, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v5, types: [byte] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int _skipColon() throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r10._inputPtr
            int r1 = r0 + 4
            int r2 = r10._inputEnd
            r3 = 0
            if (r1 < r2) goto L_0x000e
            int r0 = r10._skipColon2(r3)
            return r0
        L_0x000e:
            byte[] r1 = r10._inputBuffer
            byte r2 = r1[r0]
            r4 = 58
            r5 = 9
            r6 = 35
            r7 = 47
            r8 = 32
            r9 = 1
            if (r2 != r4) goto L_0x005a
            int r0 = r0 + r9
            r10._inputPtr = r0
            byte r0 = r1[r0]
            if (r0 <= r8) goto L_0x0036
            if (r0 == r7) goto L_0x0031
            if (r0 != r6) goto L_0x002b
            goto L_0x0031
        L_0x002b:
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            return r0
        L_0x0031:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x0036:
            if (r0 == r8) goto L_0x003a
            if (r0 != r5) goto L_0x0055
        L_0x003a:
            byte[] r1 = r10._inputBuffer
            int r2 = r10._inputPtr
            int r2 = r2 + r9
            r10._inputPtr = r2
            byte r0 = r1[r2]
            if (r0 <= r8) goto L_0x0055
            if (r0 == r7) goto L_0x0050
            if (r0 != r6) goto L_0x004a
            goto L_0x0050
        L_0x004a:
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            return r0
        L_0x0050:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x0055:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x005a:
            if (r2 == r8) goto L_0x005e
            if (r2 != r5) goto L_0x0067
        L_0x005e:
            byte[] r0 = r10._inputBuffer
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            byte r2 = r0[r1]
        L_0x0067:
            if (r2 != r4) goto L_0x00a8
            byte[] r0 = r10._inputBuffer
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            byte r0 = r0[r1]
            if (r0 <= r8) goto L_0x0084
            if (r0 == r7) goto L_0x007f
            if (r0 != r6) goto L_0x0079
            goto L_0x007f
        L_0x0079:
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            return r0
        L_0x007f:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x0084:
            if (r0 == r8) goto L_0x0088
            if (r0 != r5) goto L_0x00a3
        L_0x0088:
            byte[] r1 = r10._inputBuffer
            int r2 = r10._inputPtr
            int r2 = r2 + r9
            r10._inputPtr = r2
            byte r0 = r1[r2]
            if (r0 <= r8) goto L_0x00a3
            if (r0 == r7) goto L_0x009e
            if (r0 != r6) goto L_0x0098
            goto L_0x009e
        L_0x0098:
            int r1 = r10._inputPtr
            int r1 = r1 + r9
            r10._inputPtr = r1
            return r0
        L_0x009e:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x00a3:
            int r1 = r10._skipColon2(r9)
            return r1
        L_0x00a8:
            int r0 = r10._skipColon2(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._skipColon():int");
    }

    private final int _skipColon2(boolean gotColon) throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        _skipComment();
                    } else if (i2 != 35 || !_skipYAMLComment()) {
                        if (gotColon) {
                            return i2;
                        }
                        if (i2 == 58) {
                            gotColon = true;
                        } else {
                            _reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
                            throw null;
                        }
                    }
                } else if (i2 == 32) {
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

    private final void _skipComment() throws IOException {
        if (!isEnabled(Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
            throw null;
        } else if (this._inputPtr < this._inputEnd || _loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int c = bArr[i] & 255;
            if (c == 47) {
                _skipLine();
            } else if (c == 42) {
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

    private final void _skipCComment() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            int code = codes[i2];
            if (code != 0) {
                if (code == 2) {
                    _skipUtf8_2();
                } else if (code == 3) {
                    _skipUtf8_3();
                } else if (code == 4) {
                    _skipUtf8_4(i2);
                } else if (code == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (code == 13) {
                    _skipCR();
                } else if (code == 42) {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        break;
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    if (bArr2[i3] == 47) {
                        this._inputPtr = i3 + 1;
                        return;
                    }
                } else {
                    _reportInvalidChar(i2);
                    throw null;
                }
            }
        }
        _reportInvalidEOF(" in a comment", null);
        throw null;
    }

    private final boolean _skipYAMLComment() throws IOException {
        if (!isEnabled(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _skipLine() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & 255;
                int code = codes[i2];
                if (code != 0) {
                    if (code == 2) {
                        _skipUtf8_2();
                    } else if (code == 3) {
                        _skipUtf8_3();
                    } else if (code == 4) {
                        _skipUtf8_4(i2);
                    } else if (code == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                        return;
                    } else if (code == 13) {
                        _skipCR();
                        return;
                    } else if (code != 42 && code < 0) {
                        _reportInvalidChar(i2);
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
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte c = bArr[i];
            if (c == 34 || c == 47 || c == 92) {
                return (char) c;
            }
            if (c == 98) {
                return 8;
            }
            if (c == 102) {
                return 12;
            }
            if (c == 110) {
                return 10;
            }
            if (c == 114) {
                return 13;
            }
            if (c == 116) {
                return 9;
            }
            if (c != 117) {
                char _decodeCharForError = (char) _decodeCharForError(c);
                _handleUnrecognizedCharacterEscape(_decodeCharForError);
                return _decodeCharForError;
            }
            int value = 0;
            int i2 = 0;
            while (i2 < 4) {
                if (this._inputPtr < this._inputEnd || _loadMore()) {
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    byte ch = bArr2[i3];
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

    /* access modifiers changed from: protected */
    public int _decodeCharForError(int firstByte) throws IOException {
        int needed;
        int c;
        int c2 = firstByte & 255;
        if (c2 <= 127) {
            return c2;
        }
        if ((c2 & 224) == 192) {
            c = c2 & 31;
            needed = 1;
        } else if ((c2 & 240) == 224) {
            c = c2 & 15;
            needed = 2;
        } else if ((c2 & 248) == 240) {
            c = c2 & 7;
            needed = 3;
        } else {
            _reportInvalidInitial(c2 & 255);
            throw null;
        }
        int d = nextByte();
        if ((d & Opcodes.CHECKCAST) == 128) {
            int c3 = (c << 6) | (d & 63);
            if (needed <= 1) {
                return c3;
            }
            int d2 = nextByte();
            if ((d2 & Opcodes.CHECKCAST) == 128) {
                int c4 = (c3 << 6) | (d2 & 63);
                if (needed <= 2) {
                    return c4;
                }
                int d3 = nextByte();
                if ((d3 & Opcodes.CHECKCAST) == 128) {
                    return (c4 << 6) | (d3 & 63);
                }
                _reportInvalidOther(d3 & 255);
                throw null;
            }
            _reportInvalidOther(d2 & 255);
            throw null;
        }
        _reportInvalidOther(d & 255);
        throw null;
    }

    private final int _decodeUtf8_2(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) == 128) {
            return ((c & 31) << 6) | (d & 63);
        }
        _reportInvalidOther(d & 255, this._inputPtr);
        throw null;
    }

    private final int _decodeUtf8_3(int c1) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) == 128) {
            int c = (c12 << 6) | (d & 63);
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte d2 = bArr2[i2];
            if ((d2 & 192) == 128) {
                return (c << 6) | (d2 & 63);
            }
            _reportInvalidOther(d2 & 255, this._inputPtr);
            throw null;
        }
        _reportInvalidOther(d & 255, this._inputPtr);
        throw null;
    }

    private final int _decodeUtf8_3fast(int c1) throws IOException {
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) == 128) {
            int c = (c12 << 6) | (d & 63);
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte d2 = bArr[i2];
            if ((d2 & Opcodes.CHECKCAST) == 128) {
                return (c << 6) | (d2 & 63);
            }
            _reportInvalidOther(d2 & 255, this._inputPtr);
            throw null;
        }
        _reportInvalidOther(d & 255, this._inputPtr);
        throw null;
    }

    private final int _decodeUtf8_4(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) == 128) {
            int c2 = ((c & 7) << 6) | (d & 63);
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte d2 = bArr2[i2];
            if ((d2 & 192) == 128) {
                int c3 = (c2 << 6) | (d2 & 63);
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                byte d3 = bArr3[i3];
                if ((d3 & 192) == 128) {
                    return ((c3 << 6) | (d3 & 63)) - Collection.MODE_EMPTY;
                }
                _reportInvalidOther(d3 & 255, this._inputPtr);
                throw null;
            }
            _reportInvalidOther(d2 & 255, this._inputPtr);
            throw null;
        }
        _reportInvalidOther(d & 255, this._inputPtr);
        throw null;
    }

    private final void _skipUtf8_2() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte c = bArr[i];
        if ((c & 192) != 128) {
            _reportInvalidOther(c & 255, this._inputPtr);
            throw null;
        }
    }

    private final void _skipUtf8_3() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte c = bArr[i];
        if ((c & 192) == 128) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte c2 = bArr2[i2];
            if ((c2 & 192) != 128) {
                _reportInvalidOther(c2 & 255, this._inputPtr);
                throw null;
            }
            return;
        }
        _reportInvalidOther(c & 255, this._inputPtr);
        throw null;
    }

    private final void _skipUtf8_4(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte d = bArr[i];
        if ((d & 192) == 128) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte d2 = bArr2[i2];
            if ((d2 & 192) == 128) {
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                byte d3 = bArr3[i3];
                if ((d3 & 192) != 128) {
                    _reportInvalidOther(d3 & 255, this._inputPtr);
                    throw null;
                }
                return;
            }
            _reportInvalidOther(d2 & 255, this._inputPtr);
            throw null;
        }
        _reportInvalidOther(d & 255, this._inputPtr);
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void _skipCR() throws IOException {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            if (bArr[i] == 10) {
                this._inputPtr = i + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private int nextByte() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & 255;
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
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = (char) _decodeCharForError(bArr[i]);
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            sb.append(c);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb, msg);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidChar(int c) throws JsonParseException {
        if (c < 32) {
            _throwInvalidSpace(c);
            throw null;
        } else {
            _reportInvalidInitial(c);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidInitial(int mask) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 start byte 0x");
        sb.append(Integer.toHexString(mask));
        _reportError(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidOther(int mask) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 middle byte 0x");
        sb.append(Integer.toHexString(mask));
        _reportError(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidOther(int mask, int ptr) throws JsonParseException {
        this._inputPtr = ptr;
        _reportInvalidOther(mask);
        throw null;
    }

    /* access modifiers changed from: protected */
    public final byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch > 32) {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == 34) {
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
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int ch2 = bArr2[i2] & 255;
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData2 = (decodedData << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int ch3 = bArr3[i3] & 255;
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 != 34 || b64variant.usesPadding()) {
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
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        int ch4 = bArr4[i4] & 255;
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
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int ch5 = bArr5[i5] & 255;
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 != 34 || b64variant.usesPadding()) {
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
            JsonLocation jsonLocation = new JsonLocation(_getSourceReference(), this._currInputProcessed + ((long) (this._nameStartOffset - 1)), -1, this._nameStartRow, this._nameStartCol);
            return jsonLocation;
        }
        JsonLocation jsonLocation2 = new JsonLocation(_getSourceReference(), this._tokenInputTotal - 1, -1, this._tokenInputRow, this._tokenInputCol);
        return jsonLocation2;
    }

    public JsonLocation getCurrentLocation() {
        JsonLocation jsonLocation = new JsonLocation(_getSourceReference(), this._currInputProcessed + ((long) this._inputPtr), -1, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
        return jsonLocation;
    }

    private final void _updateLocation() {
        this._tokenInputRow = this._currInputRow;
        int ptr = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + ((long) ptr);
        this._tokenInputCol = ptr - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        this._nameStartRow = this._currInputRow;
        int ptr = this._inputPtr;
        this._nameStartOffset = ptr;
        this._nameStartCol = ptr - this._currInputRowStart;
    }

    private final JsonToken _closeScope(int i) throws JsonParseException {
        if (i == 125) {
            _closeObjectScope();
            JsonToken jsonToken = JsonToken.END_OBJECT;
            this._currToken = jsonToken;
            return jsonToken;
        }
        _closeArrayScope();
        JsonToken jsonToken2 = JsonToken.END_ARRAY;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    private final void _closeArrayScope() throws JsonParseException {
        _updateLocation();
        if (this._parsingContext.inArray()) {
            this._parsingContext = this._parsingContext.clearAndGetParent();
        } else {
            _reportMismatchedEndMarker(93, '}');
            throw null;
        }
    }

    private final void _closeObjectScope() throws JsonParseException {
        _updateLocation();
        if (this._parsingContext.inObject()) {
            this._parsingContext = this._parsingContext.clearAndGetParent();
        } else {
            _reportMismatchedEndMarker(Opcodes.LUSHR, ']');
            throw null;
        }
    }
}
