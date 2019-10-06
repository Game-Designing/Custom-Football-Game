package com.fasterxml.jackson.databind.jsontype;

import java.io.Serializable;

public final class NamedType implements Serializable {
    protected final Class<?> _class;
    protected final int _hashCode;
    protected String _name;

    public NamedType(Class<?> c) {
        this(c, null);
    }

    public NamedType(Class<?> c, String name) {
        this._class = c;
        this._hashCode = c.getName().hashCode();
        setName(name);
    }

    public Class<?> getType() {
        return this._class;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = (name == null || name.length() == 0) ? null : name;
    }

    public boolean hasName() {
        return this._name != null;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (this._class != ((NamedType) o)._class) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[NamedType, class ");
        sb.append(this._class.getName());
        sb.append(", name: ");
        if (this._name == null) {
            str = "null";
        } else {
            StringBuilder sb2 = new StringBuilder();
            String str2 = "'";
            sb2.append(str2);
            sb2.append(this._name);
            sb2.append(str2);
            str = sb2.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
