package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;

public class TypeKey {
    protected Class<?> _class;
    protected int _hashCode;
    protected boolean _isTyped;
    protected JavaType _type;

    public TypeKey() {
    }

    public TypeKey(Class<?> key, boolean typed) {
        this._class = key;
        this._type = null;
        this._isTyped = typed;
        this._hashCode = typed ? typedHash(key) : untypedHash(key);
    }

    public TypeKey(JavaType key, boolean typed) {
        this._type = key;
        this._class = null;
        this._isTyped = typed;
        this._hashCode = typed ? typedHash(key) : untypedHash(key);
    }

    public static final int untypedHash(Class<?> cls) {
        return cls.getName().hashCode();
    }

    public static final int typedHash(Class<?> cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int untypedHash(JavaType type) {
        return type.hashCode() - 1;
    }

    public static final int typedHash(JavaType type) {
        return type.hashCode() - 2;
    }

    public boolean isTyped() {
        return this._isTyped;
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public JavaType getType() {
        return this._type;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public final String toString() {
        String str = "}";
        String str2 = ", typed? ";
        if (this._class != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{class: ");
            sb.append(this._class.getName());
            sb.append(str2);
            sb.append(this._isTyped);
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{type: ");
        sb2.append(this._type);
        sb2.append(str2);
        sb2.append(this._isTyped);
        sb2.append(str);
        return sb2.toString();
    }

    public final boolean equals(Object o) {
        boolean z = false;
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        TypeKey other = (TypeKey) o;
        if (other._isTyped != this._isTyped) {
            return false;
        }
        Class<?> cls = this._class;
        if (cls == null) {
            return this._type.equals(other._type);
        }
        if (other._class == cls) {
            z = true;
        }
        return z;
    }
}
