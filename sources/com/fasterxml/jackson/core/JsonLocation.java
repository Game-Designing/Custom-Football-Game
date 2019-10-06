package com.fasterxml.jackson.core;

import java.io.Serializable;
import java.nio.charset.Charset;

public class JsonLocation implements Serializable {

    /* renamed from: NA */
    public static final JsonLocation f12547NA;
    protected final int _columnNr;
    protected final int _lineNr;
    final transient Object _sourceRef;
    protected final long _totalBytes;
    protected final long _totalChars;

    static {
        JsonLocation jsonLocation = new JsonLocation(null, -1, -1, -1, -1);
        f12547NA = jsonLocation;
    }

    public JsonLocation(Object srcRef, long totalChars, int lineNr, int colNr) {
        this(srcRef, -1, totalChars, lineNr, colNr);
    }

    public JsonLocation(Object sourceRef, long totalBytes, long totalChars, int lineNr, int columnNr) {
        this._sourceRef = sourceRef;
        this._totalBytes = totalBytes;
        this._totalChars = totalChars;
        this._lineNr = lineNr;
        this._columnNr = columnNr;
    }

    public long getByteOffset() {
        return this._totalBytes;
    }

    public int hashCode() {
        Object obj = this._sourceRef;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof JsonLocation)) {
            return false;
        }
        JsonLocation otherLoc = (JsonLocation) other;
        Object obj = this._sourceRef;
        if (obj == null) {
            if (otherLoc._sourceRef != null) {
                return false;
            }
        } else if (!obj.equals(otherLoc._sourceRef)) {
            return false;
        }
        if (!(this._lineNr == otherLoc._lineNr && this._columnNr == otherLoc._columnNr && this._totalChars == otherLoc._totalChars && getByteOffset() == otherLoc.getByteOffset())) {
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        _appendSourceDesc(sb);
        sb.append("; line: ");
        sb.append(this._lineNr);
        sb.append(", column: ");
        sb.append(this._columnNr);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public StringBuilder _appendSourceDesc(StringBuilder sb) {
        int len;
        Object srcRef = this._sourceRef;
        if (srcRef == null) {
            sb.append("UNKNOWN");
            return sb;
        }
        Class<?> srcType = srcRef instanceof Class ? (Class) srcRef : srcRef.getClass();
        String tn = srcType.getName();
        if (tn.startsWith("java.")) {
            tn = srcType.getSimpleName();
        } else if (srcRef instanceof byte[]) {
            tn = "byte[]";
        } else if (srcRef instanceof char[]) {
            tn = "char[]";
        }
        sb.append('(');
        sb.append(tn);
        sb.append(')');
        String charStr = " chars";
        if (srcRef instanceof CharSequence) {
            CharSequence cs = (CharSequence) srcRef;
            int len2 = cs.length();
            len = len2 - _append(sb, cs.subSequence(0, Math.min(len2, 500)).toString());
        } else if (srcRef instanceof char[]) {
            char[] ch = (char[]) srcRef;
            int len3 = ch.length;
            len = len3 - _append(sb, new String(ch, 0, Math.min(len3, 500)));
        } else if (srcRef instanceof byte[]) {
            byte[] b = (byte[]) srcRef;
            int maxLen = Math.min(b.length, 500);
            _append(sb, new String(b, 0, maxLen, Charset.forName("UTF-8")));
            len = b.length - maxLen;
            charStr = " bytes";
        } else {
            len = 0;
        }
        if (len > 0) {
            sb.append("[truncated ");
            sb.append(len);
            sb.append(charStr);
            sb.append(']');
        }
        return sb;
    }

    private int _append(StringBuilder sb, String content) {
        sb.append('\"');
        sb.append(content);
        sb.append('\"');
        return content.length();
    }
}
