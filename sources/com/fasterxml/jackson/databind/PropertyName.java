package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p134io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;

public class PropertyName implements Serializable {
    public static final PropertyName NO_NAME;
    public static final PropertyName USE_DEFAULT;
    protected SerializableString _encodedSimple;
    protected final String _namespace;
    protected final String _simpleName;

    static {
        String str = "";
        USE_DEFAULT = new PropertyName(str, null);
        NO_NAME = new PropertyName(new String(str), null);
    }

    public PropertyName(String simpleName) {
        this(simpleName, null);
    }

    public PropertyName(String simpleName, String namespace) {
        this._simpleName = ClassUtil.nonNullString(simpleName);
        this._namespace = namespace;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        if (this._namespace == null) {
            String str = this._simpleName;
            if (str == null || "".equals(str)) {
                return USE_DEFAULT;
            }
        }
        return this;
    }

    public static PropertyName construct(String simpleName) {
        if (simpleName == null || simpleName.length() == 0) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(simpleName), null);
    }

    public static PropertyName construct(String simpleName, String ns) {
        if (simpleName == null) {
            simpleName = "";
        }
        if (ns == null && simpleName.length() == 0) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(simpleName), ns);
    }

    public PropertyName internSimpleName() {
        if (this._simpleName.length() == 0) {
            return this;
        }
        String interned = InternCache.instance.intern(this._simpleName);
        if (interned == this._simpleName) {
            return this;
        }
        return new PropertyName(interned, this._namespace);
    }

    public PropertyName withSimpleName(String simpleName) {
        if (simpleName == null) {
            simpleName = "";
        }
        if (simpleName.equals(this._simpleName)) {
            return this;
        }
        return new PropertyName(simpleName, this._namespace);
    }

    public String getSimpleName() {
        return this._simpleName;
    }

    public SerializableString simpleAsEncoded(MapperConfig<?> config) {
        SerializableString sstr = this._encodedSimple;
        if (sstr == null) {
            if (config == null) {
                sstr = new SerializedString(this._simpleName);
            } else {
                sstr = config.compileString(this._simpleName);
            }
            this._encodedSimple = sstr;
        }
        return sstr;
    }

    public boolean hasSimpleName() {
        return this._simpleName.length() > 0;
    }

    public boolean hasSimpleName(String str) {
        return this._simpleName.equals(str);
    }

    public boolean hasNamespace() {
        return this._namespace != null;
    }

    public boolean isEmpty() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        PropertyName other = (PropertyName) o;
        String str = this._simpleName;
        if (str == null) {
            if (other._simpleName != null) {
                return false;
            }
        } else if (!str.equals(other._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 != null) {
            return str2.equals(other._namespace);
        }
        if (other._namespace != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        String str = this._namespace;
        if (str == null) {
            return this._simpleName.hashCode();
        }
        return str.hashCode() ^ this._simpleName.hashCode();
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this._namespace);
        sb.append("}");
        sb.append(this._simpleName);
        return sb.toString();
    }
}
