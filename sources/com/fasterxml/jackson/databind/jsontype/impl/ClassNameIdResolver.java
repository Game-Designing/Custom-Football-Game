package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;

public class ClassNameIdResolver extends TypeIdResolverBase {
    public ClassNameIdResolver(JavaType baseType, TypeFactory typeFactory) {
        super(baseType, typeFactory);
    }

    public String idFromValue(Object value) {
        return _idFrom(value, value.getClass(), this._typeFactory);
    }

    public String idFromValueAndType(Object value, Class<?> type) {
        return _idFrom(value, type, this._typeFactory);
    }

    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        return _typeFromId(id, context);
    }

    /* access modifiers changed from: protected */
    public JavaType _typeFromId(String id, DatabindContext ctxt) throws IOException {
        JavaType t = ctxt.resolveSubType(this._baseType, id);
        if (t != null || !(ctxt instanceof DeserializationContext)) {
            return t;
        }
        return ((DeserializationContext) ctxt).handleUnknownTypeId(this._baseType, id, this, "no such class found");
    }

    /* access modifiers changed from: protected */
    public String _idFrom(Object value, Class<?> cls, TypeFactory typeFactory) {
        if (Enum.class.isAssignableFrom(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String str = cls.getName();
        if (str.startsWith("java.util.")) {
            if (value instanceof EnumSet) {
                return typeFactory.constructCollectionType(EnumSet.class, ClassUtil.findEnumType((EnumSet) value)).toCanonical();
            } else if (!(value instanceof EnumMap)) {
                return str;
            } else {
                return typeFactory.constructMapType(EnumMap.class, ClassUtil.findEnumType((EnumMap) value), Object.class).toCanonical();
            }
        } else if (str.indexOf(36) < 0 || ClassUtil.getOuterClass(cls) == null || ClassUtil.getOuterClass(this._baseType.getRawClass()) != null) {
            return str;
        } else {
            return this._baseType.getRawClass().getName();
        }
    }

    public String getDescForKnownTypeIds() {
        return "class name used as type id";
    }
}
