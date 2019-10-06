package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class DeserializerCache implements Serializable {
    protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap<>(64, 0.75f, 4);
    protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap<>(8);

    /* access modifiers changed from: 0000 */
    public Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }

    public JsonDeserializer<Object> findValueDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType propertyType) throws JsonMappingException {
        JsonDeserializer<Object> deser = _findCachedDeserializer(propertyType);
        if (deser != null) {
            return deser;
        }
        JsonDeserializer<Object> deser2 = _createAndCacheValueDeserializer(ctxt, factory, propertyType);
        if (deser2 == null) {
            return _handleUnknownValueDeserializer(ctxt, propertyType);
        }
        return deser2;
    }

    public KeyDeserializer findKeyDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType type) throws JsonMappingException {
        KeyDeserializer kd = factory.createKeyDeserializer(ctxt, type);
        if (kd == null) {
            return _handleUnknownKeyDeserializer(ctxt, type);
        }
        if (kd instanceof ResolvableDeserializer) {
            ((ResolvableDeserializer) kd).resolve(ctxt);
        }
        return kd;
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _findCachedDeserializer(JavaType type) {
        if (type == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        } else if (_hasCustomHandlers(type)) {
            return null;
        } else {
            return (JsonDeserializer) this._cachedDeserializers.get(type);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> _createAndCacheValueDeserializer(com.fasterxml.jackson.databind.DeserializationContext r6, com.fasterxml.jackson.databind.deser.DeserializerFactory r7, com.fasterxml.jackson.databind.JavaType r8) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r5 = this;
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r0 = r5._incompleteDeserializers
            monitor-enter(r0)
            com.fasterxml.jackson.databind.JsonDeserializer r1 = r5._findCachedDeserializer(r8)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x000b:
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r2 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            int r2 = r2.size()     // Catch:{ all -> 0x0047 }
            if (r2 <= 0) goto L_0x0020
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r3 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0047 }
            com.fasterxml.jackson.databind.JsonDeserializer r3 = (com.fasterxml.jackson.databind.JsonDeserializer) r3     // Catch:{ all -> 0x0047 }
            r1 = r3
            if (r1 == 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r1
        L_0x0020:
            com.fasterxml.jackson.databind.JsonDeserializer r3 = r5._createAndCache2(r6, r7, r8)     // Catch:{ all -> 0x0035 }
            if (r2 != 0) goto L_0x0033
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r4 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            int r4 = r4.size()     // Catch:{ all -> 0x0047 }
            if (r4 <= 0) goto L_0x0033
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r4 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            r4.clear()     // Catch:{ all -> 0x0047 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r3
        L_0x0035:
            r3 = move-exception
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r4 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            int r4 = r4.size()     // Catch:{ all -> 0x0047 }
            if (r4 <= 0) goto L_0x0045
            java.util.HashMap<com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object>> r4 = r5._incompleteDeserializers     // Catch:{ all -> 0x0047 }
            r4.clear()     // Catch:{ all -> 0x0047 }
        L_0x0045:
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.DeserializerCache._createAndCacheValueDeserializer(com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.deser.DeserializerFactory, com.fasterxml.jackson.databind.JavaType):com.fasterxml.jackson.databind.JsonDeserializer");
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _createAndCache2(DeserializationContext ctxt, DeserializerFactory factory, JavaType type) throws JsonMappingException {
        try {
            JsonDeserializer<Object> deser = _createDeserializer(ctxt, factory, type);
            if (deser == null) {
                return null;
            }
            boolean addToCache = !_hasCustomHandlers(type) && deser.isCachable();
            if (deser instanceof ResolvableDeserializer) {
                this._incompleteDeserializers.put(type, deser);
                ((ResolvableDeserializer) deser).resolve(ctxt);
                this._incompleteDeserializers.remove(type);
            }
            if (addToCache) {
                this._cachedDeserializers.put(type, deser);
            }
            return deser;
        } catch (IllegalArgumentException iae) {
            throw JsonMappingException.from(ctxt, iae.getMessage(), (Throwable) iae);
        }
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _createDeserializer(DeserializationContext ctxt, DeserializerFactory factory, JavaType type) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        if (type.isAbstract() || type.isMapLikeType() || type.isCollectionLikeType()) {
            type = factory.mapAbstractType(config, type);
        }
        BeanDescription beanDesc = config.introspect(type);
        JsonDeserializer<Object> deser = findDeserializerFromAnnotation(ctxt, beanDesc.getClassInfo());
        if (deser != null) {
            return deser;
        }
        JavaType newType = modifyTypeByAnnotation(ctxt, beanDesc.getClassInfo(), type);
        if (newType != type) {
            type = newType;
            beanDesc = config.introspect(newType);
        }
        Class<?> builder = beanDesc.findPOJOBuilder();
        if (builder != null) {
            return factory.createBuilderBasedDeserializer(ctxt, type, beanDesc, builder);
        }
        Converter<Object, Object> conv = beanDesc.findDeserializationConverter();
        if (conv == null) {
            return _createDeserializer2(ctxt, factory, type, beanDesc);
        }
        JavaType delegateType = conv.getInputType(ctxt.getTypeFactory());
        if (!delegateType.hasRawClass(type.getRawClass())) {
            beanDesc = config.introspect(delegateType);
        }
        return new StdDelegatingDeserializer(conv, delegateType, _createDeserializer2(ctxt, factory, delegateType, beanDesc));
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<?> _createDeserializer2(DeserializationContext ctxt, DeserializerFactory factory, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
        DeserializationConfig config = ctxt.getConfig();
        if (type.isEnumType()) {
            return factory.createEnumDeserializer(ctxt, type, beanDesc);
        }
        if (type.isContainerType()) {
            if (type.isArrayType()) {
                return factory.createArrayDeserializer(ctxt, (ArrayType) type, beanDesc);
            }
            if (type.isMapLikeType()) {
                Value format = beanDesc.findExpectedFormat(null);
                if (format == null || format.getShape() != Shape.OBJECT) {
                    MapLikeType mlt = (MapLikeType) type;
                    if (mlt.isTrueMapType()) {
                        return factory.createMapDeserializer(ctxt, (MapType) mlt, beanDesc);
                    }
                    return factory.createMapLikeDeserializer(ctxt, mlt, beanDesc);
                }
            }
            if (type.isCollectionLikeType()) {
                Value format2 = beanDesc.findExpectedFormat(null);
                if (format2 == null || format2.getShape() != Shape.OBJECT) {
                    CollectionLikeType clt = (CollectionLikeType) type;
                    if (clt.isTrueCollectionType()) {
                        return factory.createCollectionDeserializer(ctxt, (CollectionType) clt, beanDesc);
                    }
                    return factory.createCollectionLikeDeserializer(ctxt, clt, beanDesc);
                }
            }
        }
        if (type.isReferenceType()) {
            return factory.createReferenceDeserializer(ctxt, (ReferenceType) type, beanDesc);
        }
        if (JsonNode.class.isAssignableFrom(type.getRawClass())) {
            return factory.createTreeDeserializer(config, type, beanDesc);
        }
        return factory.createBeanDeserializer(ctxt, type, beanDesc);
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext ctxt, Annotated ann) throws JsonMappingException {
        Object deserDef = ctxt.getAnnotationIntrospector().findDeserializer(ann);
        if (deserDef == null) {
            return null;
        }
        return findConvertingDeserializer(ctxt, ann, ctxt.deserializerInstance(ann, deserDef));
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> findConvertingDeserializer(DeserializationContext ctxt, Annotated a, JsonDeserializer<Object> deser) throws JsonMappingException {
        Converter<Object, Object> conv = findConverter(ctxt, a);
        if (conv == null) {
            return deser;
        }
        return new StdDelegatingDeserializer(conv, conv.getInputType(ctxt.getTypeFactory()), deser);
    }

    /* access modifiers changed from: protected */
    public Converter<Object, Object> findConverter(DeserializationContext ctxt, Annotated a) throws JsonMappingException {
        Object convDef = ctxt.getAnnotationIntrospector().findDeserializationConverter(a);
        if (convDef == null) {
            return null;
        }
        return ctxt.converterInstance(a, convDef);
    }

    private JavaType modifyTypeByAnnotation(DeserializationContext ctxt, Annotated a, JavaType type) throws JsonMappingException {
        AnnotationIntrospector intr = ctxt.getAnnotationIntrospector();
        if (intr == null) {
            return type;
        }
        if (type.isMapLikeType()) {
            JavaType keyType = type.getKeyType();
            if (keyType != null && keyType.getValueHandler() == null) {
                Object kdDef = intr.findKeyDeserializer(a);
                if (kdDef != null) {
                    KeyDeserializer kd = ctxt.keyDeserializerInstance(a, kdDef);
                    if (kd != null) {
                        type = ((MapLikeType) type).withKeyValueHandler(kd);
                        type.getKeyType();
                        type = type;
                    }
                }
            }
        }
        JavaType contentType = type.getContentType();
        if (contentType != null && contentType.getValueHandler() == null) {
            Object cdDef = intr.findContentDeserializer(a);
            if (cdDef != null) {
                JsonDeserializer<?> cd = null;
                if (cdDef instanceof JsonDeserializer) {
                    Object cdDef2 = (JsonDeserializer) cdDef;
                } else {
                    Class<?> cdClass = _verifyAsClass(cdDef, "findContentDeserializer", None.class);
                    if (cdClass != null) {
                        cd = ctxt.deserializerInstance(a, cdClass);
                    }
                }
                if (cd != null) {
                    type = type.withContentValueHandler(cd);
                }
            }
        }
        return intr.refineDeserializationType(ctxt.getConfig(), a, type);
    }

    private boolean _hasCustomHandlers(JavaType t) {
        if (t.isContainerType()) {
            JavaType ct = t.getContentType();
            if (ct != null && (ct.getValueHandler() != null || ct.getTypeHandler() != null)) {
                return true;
            }
            if (t.isMapLikeType() && t.getKeyType().getValueHandler() != null) {
                return true;
            }
        }
        return false;
    }

    private Class<?> _verifyAsClass(Object src, String methodName, Class<?> noneClass) {
        if (src == null) {
            return null;
        }
        if (src instanceof Class) {
            Class<?> cls = (Class) src;
            if (cls == noneClass || ClassUtil.isBogusClass(cls)) {
                return null;
            }
            return cls;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AnnotationIntrospector.");
        sb.append(methodName);
        sb.append("() returned value of type ");
        sb.append(src.getClass().getName());
        sb.append(": expected type JsonSerializer or Class<JsonSerializer> instead");
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public JsonDeserializer<Object> _handleUnknownValueDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        if (!ClassUtil.isConcrete(type.getRawClass())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find a Value deserializer for abstract type ");
            sb.append(type);
            ctxt.reportBadDefinition(type, sb.toString());
            throw null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find a Value deserializer for type ");
        sb2.append(type);
        ctxt.reportBadDefinition(type, sb2.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public KeyDeserializer _handleUnknownKeyDeserializer(DeserializationContext ctxt, JavaType type) throws JsonMappingException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find a (Map) Key deserializer for type ");
        sb.append(type);
        ctxt.reportBadDefinition(type, sb.toString());
        throw null;
    }
}
