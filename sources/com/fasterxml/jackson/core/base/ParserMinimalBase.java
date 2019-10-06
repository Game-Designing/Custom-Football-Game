package com.fasterxml.jackson.core.base;

import android.support.p001v7.widget.LinearLayoutManager;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.p134io.JsonEOFException;
import com.fasterxml.jackson.core.p134io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ParserMinimalBase extends JsonParser {
    protected static final BigDecimal BD_MAX_INT = new BigDecimal(BI_MAX_INT);
    protected static final BigDecimal BD_MAX_LONG = new BigDecimal(BI_MAX_LONG);
    protected static final BigDecimal BD_MIN_INT = new BigDecimal(BI_MIN_INT);
    protected static final BigDecimal BD_MIN_LONG = new BigDecimal(BI_MIN_LONG);
    protected static final BigInteger BI_MAX_INT = BigInteger.valueOf(2147483647L);
    protected static final BigInteger BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    protected static final BigInteger BI_MIN_INT = BigInteger.valueOf(-2147483648L);
    protected static final BigInteger BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    protected static final byte[] NO_BYTES = new byte[0];
    protected static final int[] NO_INTS = new int[0];
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;

    /* access modifiers changed from: protected */
    public abstract void _handleEOF() throws JsonParseException;

    protected ParserMinimalBase(int features) {
        super(features);
    }

    public JsonToken currentToken() {
        return this._currToken;
    }

    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    public int getCurrentTokenId() {
        JsonToken t = this._currToken;
        if (t == null) {
            return 0;
        }
        return t.mo20316id();
    }

    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    public boolean hasTokenId(int id) {
        JsonToken t = this._currToken;
        boolean z = true;
        if (t == null) {
            if (id != 0) {
                z = false;
            }
            return z;
        }
        if (t.mo20316id() != id) {
            z = false;
        }
        return z;
    }

    public boolean hasToken(JsonToken t) {
        return this._currToken == t;
    }

    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    public JsonToken nextValue() throws IOException {
        JsonToken t = nextToken();
        if (t == JsonToken.FIELD_NAME) {
            return nextToken();
        }
        return t;
    }

    public JsonParser skipChildren() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.START_OBJECT && jsonToken != JsonToken.START_ARRAY) {
            return this;
        }
        int open = 1;
        while (true) {
            JsonToken t = nextToken();
            if (t == null) {
                _handleEOF();
                return this;
            } else if (t.isStructStart()) {
                open++;
            } else if (t.isStructEnd()) {
                open--;
                if (open == 0) {
                    return this;
                }
            } else {
                continue;
            }
        }
    }

    public void clearCurrentToken() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != null) {
            this._lastClearedToken = jsonToken;
            this._currToken = null;
        }
    }

    public int getValueAsInt() throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        return getValueAsInt(0);
    }

    public int getValueAsInt(int defaultValue) throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            return getIntValue();
        }
        if (t != null) {
            int id = t.mo20316id();
            if (id != 6) {
                switch (id) {
                    case 9:
                        return 1;
                    case 10:
                        return 0;
                    case 11:
                        return 0;
                    case 12:
                        Object value = getEmbeddedObject();
                        if (value instanceof Number) {
                            return ((Number) value).intValue();
                        }
                        break;
                }
            } else {
                String str = getText();
                if (_hasTextualNull(str)) {
                    return 0;
                }
                return NumberInput.parseAsInt(str, defaultValue);
            }
        }
        return defaultValue;
    }

    public long getValueAsLong() throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            return getLongValue();
        }
        return getValueAsLong(0);
    }

    public long getValueAsLong(long defaultValue) throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_NUMBER_INT || t == JsonToken.VALUE_NUMBER_FLOAT) {
            return getLongValue();
        }
        if (t != null) {
            int id = t.mo20316id();
            if (id != 6) {
                switch (id) {
                    case 9:
                        return 1;
                    case 10:
                    case 11:
                        return 0;
                    case 12:
                        Object value = getEmbeddedObject();
                        if (value instanceof Number) {
                            return ((Number) value).longValue();
                        }
                        break;
                }
            } else {
                String str = getText();
                if (_hasTextualNull(str)) {
                    return 0;
                }
                return NumberInput.parseAsLong(str, defaultValue);
            }
        }
        return defaultValue;
    }

    public String getValueAsString() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return getText();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        return getValueAsString(null);
    }

    public String getValueAsString(String defaultValue) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return getText();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        if (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue()) {
            return defaultValue;
        }
        return getText();
    }

    /* access modifiers changed from: protected */
    public void _decodeBase64(String str, ByteArrayBuilder builder, Base64Variant b64variant) throws IOException {
        try {
            b64variant.decode(str, builder);
        } catch (IllegalArgumentException e) {
            _reportError(e.getMessage());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean _hasTextualNull(String value) {
        return "null".equals(value);
    }

    /* access modifiers changed from: protected */
    public void reportUnexpectedNumberChar(int ch, String comment) throws JsonParseException {
        String msg = String.format("Unexpected character (%s) in numeric value", new Object[]{_getCharDesc(ch)});
        if (comment != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg);
            sb.append(": ");
            sb.append(comment);
            msg = sb.toString();
        }
        _reportError(msg);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void reportInvalidNumber(String msg) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid numeric value: ");
        sb.append(msg);
        _reportError(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void reportOverflowInt() throws IOException {
        _reportError(String.format("Numeric value (%s) out of range of int (%d - %s)", new Object[]{getText(), Integer.valueOf(LinearLayoutManager.INVALID_OFFSET), Integer.valueOf(MoPubClientPositioning.NO_REPEAT)}));
        throw null;
    }

    /* access modifiers changed from: protected */
    public void reportOverflowLong() throws IOException {
        _reportError(String.format("Numeric value (%s) out of range of long (%d - %s)", new Object[]{getText(), Long.valueOf(Long.MIN_VALUE), Long.valueOf(Long.MAX_VALUE)}));
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportUnexpectedChar(int ch, String comment) throws JsonParseException {
        if (ch >= 0) {
            String msg = String.format("Unexpected character (%s)", new Object[]{_getCharDesc(ch)});
            if (comment != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(msg);
                sb.append(": ");
                sb.append(comment);
                msg = sb.toString();
            }
            _reportError(msg);
            throw null;
        }
        _reportInvalidEOF();
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOF() throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append(" in ");
        sb.append(this._currToken);
        _reportInvalidEOF(sb.toString(), this._currToken);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOFInValue(JsonToken type) throws JsonParseException {
        String msg;
        if (type == JsonToken.VALUE_STRING) {
            msg = " in a String value";
        } else if (type == JsonToken.VALUE_NUMBER_INT || type == JsonToken.VALUE_NUMBER_FLOAT) {
            msg = " in a Number value";
        } else {
            msg = " in a value";
        }
        _reportInvalidEOF(msg, type);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _reportInvalidEOF(String msg, JsonToken currToken) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end-of-input");
        sb.append(msg);
        throw new JsonEOFException(this, currToken, sb.toString());
    }

    /* access modifiers changed from: protected */
    public void _reportMissingRootWS(int ch) throws JsonParseException {
        _reportUnexpectedChar(ch, "Expected space separating root-level values");
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _throwInvalidSpace(int i) throws JsonParseException {
        char c = (char) i;
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal character (");
        sb.append(_getCharDesc(c));
        sb.append("): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        _reportError(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void _throwUnquotedSpace(int i, String ctxtDesc) throws JsonParseException {
        if (!isEnabled(Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i > 32) {
            char c = (char) i;
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal unquoted character (");
            sb.append(_getCharDesc(c));
            sb.append("): has to be escaped using backslash to be included in ");
            sb.append(ctxtDesc);
            _reportError(sb.toString());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public char _handleUnrecognizedCharacterEscape(char ch) throws JsonProcessingException {
        if (isEnabled(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return ch;
        }
        if (ch == '\'' && isEnabled(Feature.ALLOW_SINGLE_QUOTES)) {
            return ch;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized character escape ");
        sb.append(_getCharDesc(ch));
        _reportError(sb.toString());
        throw null;
    }

    protected static final String _getCharDesc(int ch) {
        char c = (char) ch;
        String str = ")";
        if (Character.isISOControl(c)) {
            StringBuilder sb = new StringBuilder();
            sb.append("(CTRL-CHAR, code ");
            sb.append(ch);
            sb.append(str);
            return sb.toString();
        }
        String str2 = "' (code ";
        String str3 = "'";
        if (ch > 255) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(c);
            sb2.append(str2);
            sb2.append(ch);
            sb2.append(" / 0x");
            sb2.append(Integer.toHexString(ch));
            sb2.append(str);
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(c);
        sb3.append(str2);
        sb3.append(ch);
        sb3.append(str);
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public final void _reportError(String msg) throws JsonParseException {
        throw _constructError(msg);
    }

    /* access modifiers changed from: protected */
    public final void _reportError(String msg, Object arg) throws JsonParseException {
        throw _constructError(String.format(msg, new Object[]{arg}));
    }

    /* access modifiers changed from: protected */
    public final void _reportError(String msg, Object arg1, Object arg2) throws JsonParseException {
        throw _constructError(String.format(msg, new Object[]{arg1, arg2}));
    }

    /* access modifiers changed from: protected */
    public final void _wrapError(String msg, Throwable t) throws JsonParseException {
        throw _constructError(msg, t);
    }

    /* access modifiers changed from: protected */
    public final void _throwInternal() {
        VersionUtil.throwInternal();
        throw null;
    }

    /* access modifiers changed from: protected */
    public final JsonParseException _constructError(String msg, Throwable t) {
        return new JsonParseException(this, msg, t);
    }
}
