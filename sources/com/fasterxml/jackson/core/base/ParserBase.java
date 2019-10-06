package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.p134io.IOContext;
import com.fasterxml.jackson.core.p134io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public abstract class ParserBase extends ParserMinimalBase {
    protected byte[] _binaryValue;
    protected ByteArrayBuilder _byteArrayBuilder;
    protected boolean _closed;
    protected long _currInputProcessed;
    protected int _currInputRow = 1;
    protected int _currInputRowStart;
    protected int _expLength;
    protected int _fractLength;
    protected int _inputEnd;
    protected int _inputPtr;
    protected int _intLength;
    protected final IOContext _ioContext;
    protected boolean _nameCopied;
    protected char[] _nameCopyBuffer;
    protected JsonToken _nextToken;
    protected int _numTypesValid = 0;
    protected BigDecimal _numberBigDecimal;
    protected BigInteger _numberBigInt;
    protected double _numberDouble;
    protected int _numberInt;
    protected long _numberLong;
    protected boolean _numberNegative;
    protected JsonReadContext _parsingContext;
    protected final TextBuffer _textBuffer;
    protected int _tokenInputCol;
    protected int _tokenInputRow = 1;
    protected long _tokenInputTotal;

    /* access modifiers changed from: protected */
    public abstract void _closeInput() throws IOException;

    /* access modifiers changed from: protected */
    public abstract char _decodeEscaped() throws IOException;

    protected ParserBase(IOContext ctxt, int features) {
        super(features);
        this._ioContext = ctxt;
        this._textBuffer = ctxt.constructTextBuffer();
        this._parsingContext = JsonReadContext.createRootContext(Feature.STRICT_DUPLICATE_DETECTION.enabledIn(features) ? DupDetector.rootDetector((JsonParser) this) : null);
    }

    public void setCurrentValue(Object v) {
        this._parsingContext.setCurrentValue(v);
    }

    @Deprecated
    public JsonParser setFeatureMask(int newMask) {
        int changes = this._features ^ newMask;
        if (changes != 0) {
            this._features = newMask;
            _checkStdFeatureChanges(newMask, changes);
        }
        return this;
    }

    public JsonParser overrideStdFeatures(int values, int mask) {
        int oldState = this._features;
        int newState = ((mask ^ -1) & oldState) | (values & mask);
        int changed = oldState ^ newState;
        if (changed != 0) {
            this._features = newState;
            _checkStdFeatureChanges(newState, changed);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void _checkStdFeatureChanges(int newFeatureFlags, int changedFeatures) {
        int f = Feature.STRICT_DUPLICATE_DETECTION.getMask();
        if ((changedFeatures & f) != 0 && (newFeatureFlags & f) != 0) {
            if (this._parsingContext.getDupDetector() == null) {
                JsonReadContext jsonReadContext = this._parsingContext;
                jsonReadContext.withDupDetector(DupDetector.rootDetector((JsonParser) this));
                this._parsingContext = jsonReadContext;
                return;
            }
            JsonReadContext jsonReadContext2 = this._parsingContext;
            jsonReadContext2.withDupDetector(null);
            this._parsingContext = jsonReadContext2;
        }
    }

    public String getCurrentName() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            JsonReadContext parent = this._parsingContext.getParent();
            if (parent != null) {
                return parent.getCurrentName();
            }
        }
        return this._parsingContext.getCurrentName();
    }

    public void close() throws IOException {
        if (!this._closed) {
            this._inputPtr = Math.max(this._inputPtr, this._inputEnd);
            this._closed = true;
            try {
                _closeInput();
            } finally {
                _releaseBuffers();
            }
        }
    }

    public JsonReadContext getParsingContext() {
        return this._parsingContext;
    }

    public boolean hasTextCharacters() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return true;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._nameCopied;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() throws IOException {
        this._textBuffer.releaseBuffers();
        char[] buf = this._nameCopyBuffer;
        if (buf != null) {
            this._nameCopyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(buf);
        }
    }

    /* access modifiers changed from: protected */
    public void _handleEOF() throws JsonParseException {
        if (!this._parsingContext.inRoot()) {
            _reportInvalidEOF(String.format(": expected close marker for %s (start marker at %s)", new Object[]{this._parsingContext.inArray() ? "Array" : "Object", this._parsingContext.getStartLocation(_getSourceReference())}), null);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final int _eofAsNextChar() throws JsonParseException {
        _handleEOF();
        return -1;
    }

    public ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this._byteArrayBuilder;
        if (byteArrayBuilder == null) {
            this._byteArrayBuilder = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this._byteArrayBuilder;
    }

    /* access modifiers changed from: protected */
    public final JsonToken reset(boolean negative, int intLen, int fractLen, int expLen) {
        if (fractLen >= 1 || expLen >= 1) {
            return resetFloat(negative, intLen, fractLen, expLen);
        }
        return resetInt(negative, intLen);
    }

    /* access modifiers changed from: protected */
    public final JsonToken resetInt(boolean negative, int intLen) {
        this._numberNegative = negative;
        this._intLength = intLen;
        this._fractLength = 0;
        this._expLength = 0;
        this._numTypesValid = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }

    /* access modifiers changed from: protected */
    public final JsonToken resetFloat(boolean negative, int intLen, int fractLen, int expLen) {
        this._numberNegative = negative;
        this._intLength = intLen;
        this._fractLength = fractLen;
        this._expLength = expLen;
        this._numTypesValid = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    /* access modifiers changed from: protected */
    public final JsonToken resetAsNaN(String valueStr, double value) {
        this._textBuffer.resetWithString(valueStr);
        this._numberDouble = value;
        this._numTypesValid = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public boolean isNaN() {
        boolean z = false;
        if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT || (this._numTypesValid & 8) == 0) {
            return false;
        }
        double d = this._numberDouble;
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            z = true;
        }
        return z;
    }

    public Number getNumberValue() throws IOException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i & 4) != 0) {
                return this._numberBigInt;
            }
            return this._numberBigDecimal;
        }
        int i2 = this._numTypesValid;
        if ((i2 & 16) != 0) {
            return this._numberBigDecimal;
        }
        if ((i2 & 8) != 0) {
            return Double.valueOf(this._numberDouble);
        }
        _throwInternal();
        throw null;
    }

    public NumberType getNumberType() throws IOException {
        if (this._numTypesValid == 0) {
            _parseNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return NumberType.INT;
            }
            if ((i & 2) != 0) {
                return NumberType.LONG;
            }
            return NumberType.BIG_INTEGER;
        } else if ((this._numTypesValid & 16) != 0) {
            return NumberType.BIG_DECIMAL;
        } else {
            return NumberType.DOUBLE;
        }
    }

    public int getIntValue() throws IOException {
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

    public long getLongValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 2) == 0) {
            if (i == 0) {
                _parseNumericValue(2);
            }
            if ((this._numTypesValid & 2) == 0) {
                convertNumberToLong();
            }
        }
        return this._numberLong;
    }

    public BigInteger getBigIntegerValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 4) == 0) {
            if (i == 0) {
                _parseNumericValue(4);
            }
            if ((this._numTypesValid & 4) == 0) {
                convertNumberToBigInteger();
            }
        }
        return this._numberBigInt;
    }

    public float getFloatValue() throws IOException {
        return (float) getDoubleValue();
    }

    public double getDoubleValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 8) == 0) {
            if (i == 0) {
                _parseNumericValue(8);
            }
            if ((this._numTypesValid & 8) == 0) {
                convertNumberToDouble();
            }
        }
        return this._numberDouble;
    }

    public BigDecimal getDecimalValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) == 0) {
            if (i == 0) {
                _parseNumericValue(16);
            }
            if ((this._numTypesValid & 16) == 0) {
                convertNumberToBigDecimal();
            }
        }
        return this._numberBigDecimal;
    }

    /* access modifiers changed from: protected */
    public void _parseNumericValue(int expType) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            int len = this._intLength;
            if (len <= 9) {
                this._numberInt = this._textBuffer.contentsAsInt(this._numberNegative);
                this._numTypesValid = 1;
            } else if (len <= 18) {
                long l = this._textBuffer.contentsAsLong(this._numberNegative);
                if (len == 10) {
                    if (this._numberNegative) {
                        if (l >= -2147483648L) {
                            this._numberInt = (int) l;
                            this._numTypesValid = 1;
                            return;
                        }
                    } else if (l <= 2147483647L) {
                        this._numberInt = (int) l;
                        this._numTypesValid = 1;
                        return;
                    }
                }
                this._numberLong = l;
                this._numTypesValid = 2;
            } else {
                _parseSlowInt(expType);
            }
        } else if (jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            _parseSlowFloat(expType);
        } else {
            _reportError("Current token (%s) not numeric, can not use numeric value accessors", jsonToken);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public int _parseIntValue() throws IOException {
        if (this._currToken != JsonToken.VALUE_NUMBER_INT || this._intLength > 9) {
            _parseNumericValue(1);
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
            return this._numberInt;
        }
        int i = this._textBuffer.contentsAsInt(this._numberNegative);
        this._numberInt = i;
        this._numTypesValid = 1;
        return i;
    }

    private void _parseSlowFloat(int expType) throws IOException {
        if (expType == 16) {
            try {
                this._numberBigDecimal = this._textBuffer.contentsAsDecimal();
                this._numTypesValid = 16;
            } catch (NumberFormatException nex) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed numeric value '");
                sb.append(this._textBuffer.contentsAsString());
                sb.append("'");
                _wrapError(sb.toString(), nex);
                throw null;
            }
        } else {
            this._numberDouble = this._textBuffer.contentsAsDouble();
            this._numTypesValid = 8;
        }
    }

    private void _parseSlowInt(int expType) throws IOException {
        String numStr = this._textBuffer.contentsAsString();
        try {
            int len = this._intLength;
            char[] buf = this._textBuffer.getTextBuffer();
            int offset = this._textBuffer.getTextOffset();
            if (this._numberNegative) {
                offset++;
            }
            if (NumberInput.inLongRange(buf, offset, len, this._numberNegative)) {
                this._numberLong = Long.parseLong(numStr);
                this._numTypesValid = 2;
                return;
            }
            this._numberBigInt = new BigInteger(numStr);
            this._numTypesValid = 4;
        } catch (NumberFormatException nex) {
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed numeric value '");
            sb.append(numStr);
            sb.append("'");
            _wrapError(sb.toString(), nex);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void convertNumberToInt() throws IOException {
        int i = this._numTypesValid;
        if ((i & 2) != 0) {
            long j = this._numberLong;
            int result = (int) j;
            if (((long) result) == j) {
                this._numberInt = result;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Numeric value (");
                sb.append(getText());
                sb.append(") out of range of int");
                _reportError(sb.toString());
                throw null;
            }
        } else if ((i & 4) != 0) {
            if (ParserMinimalBase.BI_MIN_INT.compareTo(this._numberBigInt) > 0 || ParserMinimalBase.BI_MAX_INT.compareTo(this._numberBigInt) < 0) {
                reportOverflowInt();
                throw null;
            }
            this._numberInt = this._numberBigInt.intValue();
        } else if ((i & 8) != 0) {
            double d = this._numberDouble;
            if (d < -2.147483648E9d || d > 2.147483647E9d) {
                reportOverflowInt();
                throw null;
            }
            this._numberInt = (int) d;
        } else if ((i & 16) == 0) {
            _throwInternal();
            throw null;
        } else if (ParserMinimalBase.BD_MIN_INT.compareTo(this._numberBigDecimal) > 0 || ParserMinimalBase.BD_MAX_INT.compareTo(this._numberBigDecimal) < 0) {
            reportOverflowInt();
            throw null;
        } else {
            this._numberInt = this._numberBigDecimal.intValue();
        }
        this._numTypesValid |= 1;
    }

    /* access modifiers changed from: protected */
    public void convertNumberToLong() throws IOException {
        int i = this._numTypesValid;
        if ((i & 1) != 0) {
            this._numberLong = (long) this._numberInt;
        } else if ((i & 4) != 0) {
            if (ParserMinimalBase.BI_MIN_LONG.compareTo(this._numberBigInt) > 0 || ParserMinimalBase.BI_MAX_LONG.compareTo(this._numberBigInt) < 0) {
                reportOverflowLong();
                throw null;
            }
            this._numberLong = this._numberBigInt.longValue();
        } else if ((i & 8) != 0) {
            double d = this._numberDouble;
            if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                reportOverflowLong();
                throw null;
            }
            this._numberLong = (long) d;
        } else if ((i & 16) == 0) {
            _throwInternal();
            throw null;
        } else if (ParserMinimalBase.BD_MIN_LONG.compareTo(this._numberBigDecimal) > 0 || ParserMinimalBase.BD_MAX_LONG.compareTo(this._numberBigDecimal) < 0) {
            reportOverflowLong();
            throw null;
        } else {
            this._numberLong = this._numberBigDecimal.longValue();
        }
        this._numTypesValid |= 2;
    }

    /* access modifiers changed from: protected */
    public void convertNumberToBigInteger() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberBigInt = this._numberBigDecimal.toBigInteger();
        } else if ((i & 2) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigInt = BigInteger.valueOf((long) this._numberInt);
        } else if ((i & 8) != 0) {
            this._numberBigInt = BigDecimal.valueOf(this._numberDouble).toBigInteger();
        } else {
            _throwInternal();
            throw null;
        }
        this._numTypesValid |= 4;
    }

    /* access modifiers changed from: protected */
    public void convertNumberToDouble() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberDouble = this._numberBigDecimal.doubleValue();
        } else if ((i & 4) != 0) {
            this._numberDouble = this._numberBigInt.doubleValue();
        } else if ((i & 2) != 0) {
            this._numberDouble = (double) this._numberLong;
        } else if ((i & 1) != 0) {
            this._numberDouble = (double) this._numberInt;
        } else {
            _throwInternal();
            throw null;
        }
        this._numTypesValid |= 8;
    }

    /* access modifiers changed from: protected */
    public void convertNumberToBigDecimal() throws IOException {
        int i = this._numTypesValid;
        if ((i & 8) != 0) {
            this._numberBigDecimal = NumberInput.parseBigDecimal(getText());
        } else if ((i & 4) != 0) {
            this._numberBigDecimal = new BigDecimal(this._numberBigInt);
        } else if ((i & 2) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf((long) this._numberInt);
        } else {
            _throwInternal();
            throw null;
        }
        this._numTypesValid |= 16;
    }

    /* access modifiers changed from: protected */
    public void _reportMismatchedEndMarker(int actCh, char expCh) throws JsonParseException {
        JsonReadContext ctxt = getParsingContext();
        _reportError(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", new Object[]{Character.valueOf((char) actCh), Character.valueOf(expCh), ctxt.typeDesc(), ctxt.getStartLocation(_getSourceReference())}));
        throw null;
    }

    /* access modifiers changed from: protected */
    public final int _decodeBase64Escape(Base64Variant b64variant, int ch, int index) throws IOException {
        if (ch == 92) {
            int unescaped = _decodeEscaped();
            if (unescaped <= 32 && index == 0) {
                return -1;
            }
            int bits = b64variant.decodeBase64Char(unescaped);
            if (bits >= 0) {
                return bits;
            }
            throw reportInvalidBase64Char(b64variant, unescaped, index);
        }
        throw reportInvalidBase64Char(b64variant, ch, index);
    }

    /* access modifiers changed from: protected */
    public final int _decodeBase64Escape(Base64Variant b64variant, char ch, int index) throws IOException {
        if (ch == '\\') {
            char unescaped = _decodeEscaped();
            if (unescaped <= ' ' && index == 0) {
                return -1;
            }
            int bits = b64variant.decodeBase64Char(unescaped);
            if (bits >= 0) {
                return bits;
            }
            throw reportInvalidBase64Char(b64variant, unescaped, index);
        }
        throw reportInvalidBase64Char(b64variant, ch, index);
    }

    /* access modifiers changed from: protected */
    public IllegalArgumentException reportInvalidBase64Char(Base64Variant b64variant, int ch, int bindex) throws IllegalArgumentException {
        return reportInvalidBase64Char(b64variant, ch, bindex, null);
    }

    /* access modifiers changed from: protected */
    public IllegalArgumentException reportInvalidBase64Char(Base64Variant b64variant, int ch, int bindex, String msg) throws IllegalArgumentException {
        String base;
        if (ch <= 32) {
            base = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", new Object[]{Integer.toHexString(ch), Integer.valueOf(bindex + 1)});
        } else if (b64variant.usesPaddingChar(ch)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected padding character ('");
            sb.append(b64variant.getPaddingChar());
            sb.append("') as character #");
            sb.append(bindex + 1);
            sb.append(" of 4-char base64 unit: padding only legal as 3rd or 4th character");
            base = sb.toString();
        } else {
            String str = ") in base64 content";
            if (!Character.isDefined(ch) || Character.isISOControl(ch)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Illegal character (code 0x");
                sb2.append(Integer.toHexString(ch));
                sb2.append(str);
                base = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Illegal character '");
                sb3.append((char) ch);
                sb3.append("' (code 0x");
                sb3.append(Integer.toHexString(ch));
                sb3.append(str);
                base = sb3.toString();
            }
        }
        if (msg != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(base);
            sb4.append(": ");
            sb4.append(msg);
            base = sb4.toString();
        }
        return new IllegalArgumentException(base);
    }

    /* access modifiers changed from: protected */
    public Object _getSourceReference() {
        if (Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(this._features)) {
            return this._ioContext.getSourceReference();
        }
        return null;
    }

    protected static int[] growArrayBy(int[] arr, int more) {
        if (arr == null) {
            return new int[more];
        }
        return Arrays.copyOf(arr, arr.length + more);
    }
}
