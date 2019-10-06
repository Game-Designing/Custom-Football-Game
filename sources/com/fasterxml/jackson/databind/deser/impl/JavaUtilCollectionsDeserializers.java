package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class JavaUtilCollectionsDeserializers {
    private static final Class<?> CLASS_AS_ARRAYS_LIST = Arrays.asList(new Object[]{null, null}).getClass();
    private static final Class<?> CLASS_SINGLETON_LIST;
    private static final Class<?> CLASS_SINGLETON_MAP;
    private static final Class<?> CLASS_SINGLETON_SET;
    private static final Class<?> CLASS_UNMODIFIABLE_LIST;
    private static final Class<?> CLASS_UNMODIFIABLE_MAP;
    private static final Class<?> CLASS_UNMODIFIABLE_SET;

    private static class JavaUtilCollectionsConverter implements Converter<Object, Object> {
        private final JavaType _inputType;
        private final int _kind;

        private JavaUtilCollectionsConverter(int kind, JavaType inputType) {
            this._inputType = inputType;
            this._kind = kind;
        }

        public Object convert(Object value) {
            if (value == null) {
                return null;
            }
            switch (this._kind) {
                case 1:
                    Set<?> set = (Set) value;
                    _checkSingleton(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List<?> list = (List) value;
                    _checkSingleton(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map<?, ?> map = (Map) value;
                    _checkSingleton(map.size());
                    Entry<?, ?> entry = (Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) value);
                case 5:
                    return Collections.unmodifiableList((List) value);
                case 6:
                    return Collections.unmodifiableMap((Map) value);
                default:
                    return value;
            }
        }

        public JavaType getInputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        public JavaType getOutputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        private void _checkSingleton(int size) {
            if (size != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can not deserialize Singleton container from ");
                sb.append(size);
                sb.append(" entries");
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    static {
        Set<?> set = Collections.singleton(Boolean.TRUE);
        CLASS_SINGLETON_SET = set.getClass();
        CLASS_UNMODIFIABLE_SET = Collections.unmodifiableSet(set).getClass();
        List<?> list = Collections.singletonList(Boolean.TRUE);
        CLASS_SINGLETON_LIST = list.getClass();
        CLASS_UNMODIFIABLE_LIST = Collections.unmodifiableList(list).getClass();
        Map<?, ?> map = Collections.singletonMap("a", "b");
        CLASS_SINGLETON_MAP = map.getClass();
        CLASS_UNMODIFIABLE_MAP = Collections.unmodifiableMap(map).getClass();
    }

    public static JsonDeserializer<?> findForCollection(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        JavaUtilCollectionsConverter conv;
        if (type.hasRawClass(CLASS_AS_ARRAYS_LIST)) {
            conv = converter(7, type, List.class);
        } else if (type.hasRawClass(CLASS_SINGLETON_LIST)) {
            conv = converter(2, type, List.class);
        } else if (type.hasRawClass(CLASS_SINGLETON_SET)) {
            conv = converter(1, type, Set.class);
        } else if (type.hasRawClass(CLASS_UNMODIFIABLE_LIST)) {
            conv = converter(5, type, List.class);
        } else if (!type.hasRawClass(CLASS_UNMODIFIABLE_SET)) {
            return null;
        } else {
            conv = converter(4, type, Set.class);
        }
        return new StdDelegatingDeserializer(conv);
    }

    public static JsonDeserializer<?> findForMap(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        JavaUtilCollectionsConverter conv;
        if (type.hasRawClass(CLASS_SINGLETON_MAP)) {
            conv = converter(3, type, Map.class);
        } else if (!type.hasRawClass(CLASS_UNMODIFIABLE_MAP)) {
            return null;
        } else {
            conv = converter(6, type, Map.class);
        }
        return new StdDelegatingDeserializer(conv);
    }

    static JavaUtilCollectionsConverter converter(int kind, JavaType concreteType, Class<?> rawSuper) {
        return new JavaUtilCollectionsConverter(kind, concreteType.findSuperType(rawSuper));
    }
}
