package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p134io.CharTypes;

public abstract class JsonStreamContext {
    protected int _index;
    protected int _type;

    public abstract String getCurrentName();

    public abstract Object getCurrentValue();

    public abstract JsonStreamContext getParent();

    public abstract void setCurrentValue(Object obj);

    protected JsonStreamContext() {
    }

    protected JsonStreamContext(JsonStreamContext base) {
        this._type = base._type;
        this._index = base._index;
    }

    protected JsonStreamContext(int type, int index) {
        this._type = type;
        this._index = index;
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    public String typeDesc() {
        int i = this._type;
        if (i == 0) {
            return "root";
        }
        if (i == 1) {
            return "Array";
        }
        if (i != 2) {
            return "?";
        }
        return "Object";
    }

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this._type;
        if (i == 0) {
            sb.append("/");
        } else if (i != 1) {
            sb.append('{');
            String currentName = getCurrentName();
            if (currentName != null) {
                sb.append('\"');
                CharTypes.appendQuoted(sb, currentName);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            sb.append(getCurrentIndex());
            sb.append(']');
        }
        return sb.toString();
    }
}
