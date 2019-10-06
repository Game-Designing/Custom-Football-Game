package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TypeNameIdResolver extends TypeIdResolverBase {
    protected final MapperConfig<?> _config;
    protected final Map<String, JavaType> _idToType;
    protected final Map<String, String> _typeToId;

    protected TypeNameIdResolver(MapperConfig<?> config, JavaType baseType, Map<String, String> typeToId, Map<String, JavaType> idToType) {
        super(baseType, config.getTypeFactory());
        this._config = config;
        this._typeToId = typeToId;
        this._idToType = idToType;
    }

    public static TypeNameIdResolver construct(MapperConfig<?> config, JavaType baseType, Collection<NamedType> subtypes, boolean forSer, boolean forDeser) {
        if (forSer != forDeser) {
            Map<String, String> typeToId = null;
            Map<String, JavaType> idToType = null;
            if (forSer) {
                typeToId = new HashMap<>();
            }
            if (forDeser) {
                idToType = new HashMap<>();
                typeToId = new TreeMap<>();
            }
            if (subtypes != null) {
                for (NamedType t : subtypes) {
                    Class<?> cls = t.getType();
                    String id = t.hasName() ? t.getName() : _defaultTypeId(cls);
                    if (forSer) {
                        typeToId.put(cls.getName(), id);
                    }
                    if (forDeser) {
                        JavaType prev = (JavaType) idToType.get(id);
                        if (prev == null || !cls.isAssignableFrom(prev.getRawClass())) {
                            idToType.put(id, config.constructType(cls));
                        }
                    }
                }
            }
            return new TypeNameIdResolver(config, baseType, typeToId, idToType);
        }
        throw new IllegalArgumentException();
    }

    public String idFromValue(Object value) {
        return idFromClass(value.getClass());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String idFromClass(java.lang.Class<?> r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.fasterxml.jackson.databind.type.TypeFactory r1 = r7._typeFactory
            com.fasterxml.jackson.databind.JavaType r1 = r1.constructType(r8)
            java.lang.Class r1 = r1.getRawClass()
            java.lang.String r2 = r1.getName()
            java.util.Map<java.lang.String, java.lang.String> r3 = r7._typeToId
            monitor-enter(r3)
            java.util.Map<java.lang.String, java.lang.String> r4 = r7._typeToId     // Catch:{ all -> 0x004b }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x004b }
            r0 = r4
            if (r0 != 0) goto L_0x0049
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r4 = r7._config     // Catch:{ all -> 0x004e }
            boolean r4 = r4.isAnnotationProcessingEnabled()     // Catch:{ all -> 0x004e }
            if (r4 == 0) goto L_0x003d
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r4 = r7._config     // Catch:{ all -> 0x004e }
            com.fasterxml.jackson.databind.BeanDescription r4 = r4.introspectClassAnnotations(r1)     // Catch:{ all -> 0x004e }
            com.fasterxml.jackson.databind.cfg.MapperConfig<?> r5 = r7._config     // Catch:{ all -> 0x004e }
            com.fasterxml.jackson.databind.AnnotationIntrospector r5 = r5.getAnnotationIntrospector()     // Catch:{ all -> 0x004e }
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r6 = r4.getClassInfo()     // Catch:{ all -> 0x004e }
            java.lang.String r5 = r5.findTypeName(r6)     // Catch:{ all -> 0x004e }
            r0 = r5
        L_0x003d:
            if (r0 != 0) goto L_0x0044
            java.lang.String r4 = _defaultTypeId(r1)     // Catch:{ all -> 0x004e }
            r0 = r4
        L_0x0044:
            java.util.Map<java.lang.String, java.lang.String> r4 = r7._typeToId     // Catch:{ all -> 0x004e }
            r4.put(r2, r0)     // Catch:{ all -> 0x004e }
        L_0x0049:
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            return r0
        L_0x004b:
            r4 = move-exception
        L_0x004c:
            monitor-exit(r3)     // Catch:{ all -> 0x004e }
            throw r4
        L_0x004e:
            r4 = move-exception
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.jsontype.impl.TypeNameIdResolver.idFromClass(java.lang.Class):java.lang.String");
    }

    public String idFromValueAndType(Object value, Class<?> type) {
        if (value == null) {
            return idFromClass(type);
        }
        return idFromValue(value);
    }

    public JavaType typeFromId(DatabindContext context, String id) {
        return _typeFromId(id);
    }

    /* access modifiers changed from: protected */
    public JavaType _typeFromId(String id) {
        return (JavaType) this._idToType.get(id);
    }

    public String getDescForKnownTypeIds() {
        return new TreeSet(this._idToType.keySet()).toString();
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", new Object[]{getClass().getName(), this._idToType});
    }

    protected static String _defaultTypeId(Class<?> cls) {
        String n = cls.getName();
        int ix = n.lastIndexOf(46);
        return ix < 0 ? n : n.substring(ix + 1);
    }
}
