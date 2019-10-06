package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class EnumResolver implements Serializable {
    protected final Enum<?> _defaultValue;
    protected final Class<Enum<?>> _enumClass;
    protected final Enum<?>[] _enums;
    protected final HashMap<String, Enum<?>> _enumsById;

    protected EnumResolver(Class<Enum<?>> enumClass, Enum<?>[] enums, HashMap<String, Enum<?>> map, Enum<?> defaultValue) {
        this._enumClass = enumClass;
        this._enums = enums;
        this._enumsById = map;
        this._defaultValue = defaultValue;
    }

    public static EnumResolver constructFor(Class<Enum<?>> enumCls, AnnotationIntrospector ai) {
        Enum<?>[] enumValues = (Enum[]) enumCls.getEnumConstants();
        if (enumValues != null) {
            String[] names = ai.findEnumValues(enumCls, enumValues, new String[enumValues.length]);
            HashMap<String, Enum<?>> map = new HashMap<>();
            int len = enumValues.length;
            for (int i = 0; i < len; i++) {
                String name = names[i];
                if (name == null) {
                    name = enumValues[i].name();
                }
                map.put(name, enumValues[i]);
            }
            return new EnumResolver(enumCls, enumValues, map, ai.findDefaultEnumValue(enumCls));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No enum constants for class ");
        sb.append(enumCls.getName());
        throw new IllegalArgumentException(sb.toString());
    }

    public static EnumResolver constructUsingToString(Class<Enum<?>> enumCls, AnnotationIntrospector ai) {
        Enum<?>[] enumValues = (Enum[]) enumCls.getEnumConstants();
        HashMap<String, Enum<?>> map = new HashMap<>();
        int i = enumValues.length;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            Enum<?> e = enumValues[i];
            map.put(e.toString(), e);
        }
        return new EnumResolver(enumCls, enumValues, map, ai == null ? null : ai.findDefaultEnumValue(enumCls));
    }

    public static EnumResolver constructUsingMethod(Class<Enum<?>> enumCls, AnnotatedMember accessor, AnnotationIntrospector ai) {
        Enum<?>[] enumValues = (Enum[]) enumCls.getEnumConstants();
        HashMap<String, Enum<?>> map = new HashMap<>();
        int i = enumValues.length;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            Enum<?> en = enumValues[i];
            try {
                Object o = accessor.getValue(en);
                if (o != null) {
                    map.put(o.toString(), en);
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to access @JsonValue of Enum value ");
                sb.append(en);
                sb.append(": ");
                sb.append(e.getMessage());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return new EnumResolver(enumCls, enumValues, map, ai != null ? ai.findDefaultEnumValue(enumCls) : null);
    }

    public static EnumResolver constructUnsafe(Class<?> rawEnumCls, AnnotationIntrospector ai) {
        return constructFor(rawEnumCls, ai);
    }

    public static EnumResolver constructUnsafeUsingToString(Class<?> rawEnumCls, AnnotationIntrospector ai) {
        return constructUsingToString(rawEnumCls, ai);
    }

    public static EnumResolver constructUnsafeUsingMethod(Class<?> rawEnumCls, AnnotatedMember accessor, AnnotationIntrospector ai) {
        return constructUsingMethod(rawEnumCls, accessor, ai);
    }

    public CompactStringObjectMap constructLookup() {
        return CompactStringObjectMap.construct(this._enumsById);
    }

    public Enum<?> findEnum(String key) {
        return (Enum) this._enumsById.get(key);
    }

    public Enum<?> getDefaultValue() {
        return this._defaultValue;
    }

    public Enum<?>[] getRawEnums() {
        return this._enums;
    }

    public Collection<String> getEnumIds() {
        return this._enumsById.keySet();
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }
}
