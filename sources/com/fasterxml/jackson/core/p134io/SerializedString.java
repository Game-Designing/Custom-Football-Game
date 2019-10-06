package com.fasterxml.jackson.core.p134io;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.util.BufferRecyclers;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.fasterxml.jackson.core.io.SerializedString */
public class SerializedString implements SerializableString, Serializable {
    protected transient String _jdkSerializeValue;
    protected char[] _quotedChars;
    protected byte[] _quotedUTF8Ref;
    protected byte[] _unquotedUTF8Ref;
    protected final String _value;

    public SerializedString(String v) {
        if (v != null) {
            this._value = v;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    private void readObject(ObjectInputStream in) throws IOException {
        this._jdkSerializeValue = in.readUTF();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(this._value);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new SerializedString(this._jdkSerializeValue);
    }

    public final String getValue() {
        return this._value;
    }

    public final char[] asQuotedChars() {
        char[] result = this._quotedChars;
        if (result != null) {
            return result;
        }
        char[] result2 = BufferRecyclers.quoteAsJsonText(this._value);
        this._quotedChars = result2;
        return result2;
    }

    public final byte[] asUnquotedUTF8() {
        byte[] result = this._unquotedUTF8Ref;
        if (result != null) {
            return result;
        }
        byte[] result2 = BufferRecyclers.encodeAsUTF8(this._value);
        this._unquotedUTF8Ref = result2;
        return result2;
    }

    public final byte[] asQuotedUTF8() {
        byte[] result = this._quotedUTF8Ref;
        if (result != null) {
            return result;
        }
        byte[] result2 = BufferRecyclers.quoteAsJsonUTF8(this._value);
        this._quotedUTF8Ref = result2;
        return result2;
    }

    public int appendQuotedUTF8(byte[] buffer, int offset) {
        byte[] result = this._quotedUTF8Ref;
        if (result == null) {
            result = BufferRecyclers.quoteAsJsonUTF8(this._value);
            this._quotedUTF8Ref = result;
        }
        int length = result.length;
        if (offset + length > buffer.length) {
            return -1;
        }
        System.arraycopy(result, 0, buffer, offset, length);
        return length;
    }

    public final String toString() {
        return this._value;
    }

    public final int hashCode() {
        return this._value.hashCode();
    }

    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        return this._value.equals(((SerializedString) o)._value);
    }
}
