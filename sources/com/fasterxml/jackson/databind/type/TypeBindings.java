package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TypeBindings implements Serializable {
    private static final TypeBindings EMPTY = new TypeBindings(NO_STRINGS, NO_TYPES, null);
    private static final String[] NO_STRINGS = new String[0];
    private static final JavaType[] NO_TYPES = new JavaType[0];
    private final int _hashCode;
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;

    static final class AsKey {
        private final int _hash;
        private final JavaType[] _params;
        private final Class<?> _raw;

        public AsKey(Class<?> raw, JavaType[] params, int hash) {
            this._raw = raw;
            this._params = params;
            this._hash = hash;
        }

        public int hashCode() {
            return this._hash;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            AsKey other = (AsKey) o;
            if (this._hash == other._hash && this._raw == other._raw) {
                JavaType[] otherParams = other._params;
                int len = this._params.length;
                if (len == otherParams.length) {
                    for (int i = 0; i < len; i++) {
                        if (!this._params[i].equals(otherParams[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this._raw.getName());
            sb.append("<>");
            return sb.toString();
        }
    }

    static class TypeParamStash {
        private static final TypeVariable<?>[] VARS_ABSTRACT_LIST = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ARRAY_LIST = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_COLLECTION = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_HASH_MAP = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ITERABLE = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LINKED_HASH_MAP = LinkedHashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LIST = List.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_MAP = Map.class.getTypeParameters();

        public static TypeVariable<?>[] paramsFor1(Class<?> erasedType) {
            if (erasedType == Collection.class) {
                return VARS_COLLECTION;
            }
            if (erasedType == List.class) {
                return VARS_LIST;
            }
            if (erasedType == ArrayList.class) {
                return VARS_ARRAY_LIST;
            }
            if (erasedType == AbstractList.class) {
                return VARS_ABSTRACT_LIST;
            }
            if (erasedType == Iterable.class) {
                return VARS_ITERABLE;
            }
            return erasedType.getTypeParameters();
        }

        public static TypeVariable<?>[] paramsFor2(Class<?> erasedType) {
            if (erasedType == Map.class) {
                return VARS_MAP;
            }
            if (erasedType == HashMap.class) {
                return VARS_HASH_MAP;
            }
            if (erasedType == LinkedHashMap.class) {
                return VARS_LINKED_HASH_MAP;
            }
            return erasedType.getTypeParameters();
        }
    }

    private TypeBindings(String[] names, JavaType[] types, String[] uvars) {
        this._names = names == null ? NO_STRINGS : names;
        this._types = types == null ? NO_TYPES : types;
        int length = this._names.length;
        JavaType[] javaTypeArr = this._types;
        if (length == javaTypeArr.length) {
            int h = 1;
            for (int i = 0; i < javaTypeArr.length; i++) {
                h += this._types[i].hashCode();
            }
            this._unboundVariables = uvars;
            this._hashCode = h;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Mismatching names (");
        sb.append(this._names.length);
        sb.append("), types (");
        sb.append(this._types.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings emptyBindings() {
        return EMPTY;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        String[] strArr = this._names;
        if (strArr == null || strArr.length == 0) {
            return EMPTY;
        }
        return this;
    }

    public static TypeBindings create(Class<?> erasedType, List<JavaType> typeList) {
        return create(erasedType, (typeList == null || typeList.isEmpty()) ? NO_TYPES : (JavaType[]) typeList.toArray(new JavaType[typeList.size()]));
    }

    public static TypeBindings create(Class<?> erasedType, JavaType[] types) {
        String[] names;
        if (types == null) {
            types = NO_TYPES;
        } else {
            int length = types.length;
            if (length == 1) {
                return create(erasedType, types[0]);
            }
            if (length == 2) {
                return create(erasedType, types[0], types[1]);
            }
        }
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            names = NO_STRINGS;
        } else {
            int len = vars.length;
            names = new String[len];
            for (int i = 0; i < len; i++) {
                names[i] = vars[i].getName();
            }
        }
        if (names.length == types.length) {
            return new TypeBindings(names, types, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(erasedType.getName());
        sb.append(" with ");
        sb.append(types.length);
        sb.append(" type parameter");
        sb.append(types.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(names.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1) {
        TypeVariable<?>[] vars = TypeParamStash.paramsFor1(erasedType);
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 1) {
            return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(erasedType.getName());
        sb.append(" with 1 type parameter: class expects ");
        sb.append(varLen);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1, JavaType typeArg2) {
        TypeVariable<?>[] vars = TypeParamStash.paramsFor2(erasedType);
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 2) {
            return new TypeBindings(new String[]{vars[0].getName(), vars[1].getName()}, new JavaType[]{typeArg1, typeArg2}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(erasedType.getName());
        sb.append(" with 2 type parameters: class expects ");
        sb.append(varLen);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType typeArg1) {
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 0) {
            return EMPTY;
        }
        if (varLen == 1) {
            return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(erasedType.getName());
        sb.append(" with 1 type parameter: class expects ");
        sb.append(varLen);
        throw new IllegalArgumentException(sb.toString());
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType[] types) {
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            return EMPTY;
        }
        if (types == null) {
            types = NO_TYPES;
        }
        int len = vars.length;
        String[] names = new String[len];
        for (int i = 0; i < len; i++) {
            names[i] = vars[i].getName();
        }
        if (names.length == types.length) {
            return new TypeBindings(names, types, null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(erasedType.getName());
        sb.append(" with ");
        sb.append(types.length);
        sb.append(" type parameter");
        sb.append(types.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(names.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public TypeBindings withUnboundVariable(String name) {
        String[] strArr = this._unboundVariables;
        int len = strArr == null ? 0 : strArr.length;
        String[] names = len == 0 ? new String[1] : (String[]) Arrays.copyOf(this._unboundVariables, len + 1);
        names[len] = name;
        return new TypeBindings(this._names, this._types, names);
    }

    public JavaType findBoundType(String name) {
        int len = this._names.length;
        for (int i = 0; i < len; i++) {
            if (name.equals(this._names[i])) {
                JavaType t = this._types[i];
                if (t instanceof ResolvedRecursiveType) {
                    JavaType t2 = ((ResolvedRecursiveType) t).getSelfReferencedType();
                    if (t2 != null) {
                        t = t2;
                    }
                }
                return t;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this._types.length == 0;
    }

    public int size() {
        return this._types.length;
    }

    public JavaType getBoundType(int index) {
        if (index >= 0) {
            JavaType[] javaTypeArr = this._types;
            if (index < javaTypeArr.length) {
                return javaTypeArr[index];
            }
        }
        return null;
    }

    public List<JavaType> getTypeParameters() {
        JavaType[] javaTypeArr = this._types;
        if (javaTypeArr.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(javaTypeArr);
    }

    public boolean hasUnbound(String name) {
        String[] strArr = this._unboundVariables;
        if (strArr != null) {
            int i = strArr.length;
            do {
                i--;
                if (i >= 0) {
                }
            } while (!name.equals(this._unboundVariables[i]));
            return true;
        }
        return false;
    }

    public Object asKey(Class<?> rawBase) {
        return new AsKey(rawBase, this._types, this._hashCode);
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int len = this._types.length;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this._types[i].getGenericSignature());
        }
        sb.append('>');
        return sb.toString();
    }

    public int hashCode() {
        return this._hashCode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, getClass())) {
            return false;
        }
        TypeBindings other = (TypeBindings) o;
        int len = this._types.length;
        if (len != other.size()) {
            return false;
        }
        JavaType[] otherTypes = other._types;
        for (int i = 0; i < len; i++) {
            if (!otherTypes[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public JavaType[] typeParameterArray() {
        return this._types;
    }
}
