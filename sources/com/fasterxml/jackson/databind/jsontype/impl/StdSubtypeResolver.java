package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class StdSubtypeResolver extends SubtypeResolver implements Serializable {
    protected LinkedHashSet<NamedType> _registeredSubtypes;

    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedMember property, JavaType baseType) {
        MapperConfig<?> mapperConfig = config;
        AnnotatedMember annotatedMember = property;
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        Class rawType = baseType == null ? property.getRawType() : baseType.getRawClass();
        HashMap<NamedType, NamedType> collected = new HashMap<>();
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            Iterator i$ = linkedHashSet.iterator();
            while (i$.hasNext()) {
                NamedType subtype = (NamedType) i$.next();
                if (rawType.isAssignableFrom(subtype.getType())) {
                    _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, subtype.getType()), subtype, config, ai, collected);
                }
            }
        }
        if (annotatedMember != null) {
            Collection<NamedType> st = ai.findSubtypes(annotatedMember);
            if (st != null) {
                for (NamedType nt : st) {
                    _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, nt.getType()), nt, config, ai, collected);
                }
            }
        }
        _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(mapperConfig, rawType), new NamedType(rawType, null), config, ai, collected);
        return new ArrayList(collected.values());
    }

    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> config, AnnotatedClass type) {
        AnnotationIntrospector ai = config.getAnnotationIntrospector();
        HashMap<NamedType, NamedType> subtypes = new HashMap<>();
        if (this._registeredSubtypes != null) {
            Class<?> rawBase = type.getRawType();
            Iterator i$ = this._registeredSubtypes.iterator();
            while (i$.hasNext()) {
                NamedType subtype = (NamedType) i$.next();
                if (rawBase.isAssignableFrom(subtype.getType())) {
                    _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(config, subtype.getType()), subtype, config, ai, subtypes);
                }
            }
        }
        _collectAndResolve(type, new NamedType(type.getRawType(), null), config, ai, subtypes);
        return new ArrayList(subtypes.values());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<com.fasterxml.jackson.databind.jsontype.NamedType> collectAndResolveSubtypesByTypeId(com.fasterxml.jackson.databind.cfg.MapperConfig<?> r19, com.fasterxml.jackson.databind.introspect.AnnotatedMember r20, com.fasterxml.jackson.databind.JavaType r21) {
        /*
            r18 = this;
            r9 = r18
            r10 = r19
            r11 = r20
            com.fasterxml.jackson.databind.AnnotationIntrospector r12 = r19.getAnnotationIntrospector()
            java.lang.Class r13 = r21.getRawClass()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r14 = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r15 = r0
            com.fasterxml.jackson.databind.jsontype.NamedType r2 = new com.fasterxml.jackson.databind.jsontype.NamedType
            r0 = 0
            r2.<init>(r13, r0)
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r6 = com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver.resolveWithoutSuperTypes(r10, r13)
            r0 = r18
            r1 = r6
            r3 = r19
            r4 = r14
            r5 = r15
            r0._collectAndResolveByTypeId(r1, r2, r3, r4, r5)
            if (r11 == 0) goto L_0x0062
            java.util.List r0 = r12.findSubtypes(r11)
            if (r0 == 0) goto L_0x0062
            java.util.Iterator r1 = r0.iterator()
        L_0x003a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r1.next()
            r16 = r3
            com.fasterxml.jackson.databind.jsontype.NamedType r16 = (com.fasterxml.jackson.databind.jsontype.NamedType) r16
            java.lang.Class r3 = r16.getType()
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r17 = com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver.resolveWithoutSuperTypes(r10, r3)
            r3 = r18
            r4 = r17
            r5 = r16
            r6 = r19
            r7 = r14
            r8 = r15
            r3._collectAndResolveByTypeId(r4, r5, r6, r7, r8)
            r6 = r17
            goto L_0x003a
        L_0x0060:
            r0 = r6
            goto L_0x0063
        L_0x0062:
            r0 = r6
        L_0x0063:
            java.util.LinkedHashSet<com.fasterxml.jackson.databind.jsontype.NamedType> r1 = r9._registeredSubtypes
            if (r1 == 0) goto L_0x0099
            java.util.Iterator r1 = r1.iterator()
        L_0x006b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0099
            java.lang.Object r3 = r1.next()
            r16 = r3
            com.fasterxml.jackson.databind.jsontype.NamedType r16 = (com.fasterxml.jackson.databind.jsontype.NamedType) r16
            java.lang.Class r3 = r16.getType()
            boolean r3 = r13.isAssignableFrom(r3)
            if (r3 == 0) goto L_0x0098
            java.lang.Class r3 = r16.getType()
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r17 = com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver.resolveWithoutSuperTypes(r10, r3)
            r3 = r18
            r4 = r17
            r5 = r16
            r6 = r19
            r7 = r14
            r8 = r15
            r3._collectAndResolveByTypeId(r4, r5, r6, r7, r8)
        L_0x0098:
            goto L_0x006b
        L_0x0099:
            java.util.Collection r1 = r9._combineNamedAndUnnamed(r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver.collectAndResolveSubtypesByTypeId(com.fasterxml.jackson.databind.cfg.MapperConfig, com.fasterxml.jackson.databind.introspect.AnnotatedMember, com.fasterxml.jackson.databind.JavaType):java.util.Collection");
    }

    public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> config, AnnotatedClass baseType) {
        Class<?> rawBase = baseType.getRawType();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _collectAndResolveByTypeId(baseType, new NamedType(rawBase, null), config, hashSet, linkedHashMap);
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            Iterator i$ = linkedHashSet.iterator();
            while (i$.hasNext()) {
                NamedType subtype = (NamedType) i$.next();
                if (rawBase.isAssignableFrom(subtype.getType())) {
                    _collectAndResolveByTypeId(AnnotatedClassResolver.resolveWithoutSuperTypes(config, subtype.getType()), subtype, config, hashSet, linkedHashMap);
                }
            }
        }
        return _combineNamedAndUnnamed(rawBase, hashSet, linkedHashMap);
    }

    /* access modifiers changed from: protected */
    public void _collectAndResolve(AnnotatedClass annotatedType, NamedType namedType, MapperConfig<?> config, AnnotationIntrospector ai, HashMap<NamedType, NamedType> collectedSubtypes) {
        if (!namedType.hasName()) {
            String name = ai.findTypeName(annotatedType);
            if (name != null) {
                namedType = new NamedType(namedType.getType(), name);
            }
        }
        if (collectedSubtypes.containsKey(namedType)) {
            if (namedType.hasName() && !((NamedType) collectedSubtypes.get(namedType)).hasName()) {
                collectedSubtypes.put(namedType, namedType);
            }
            return;
        }
        collectedSubtypes.put(namedType, namedType);
        Collection<NamedType> st = ai.findSubtypes(annotatedType);
        if (st != null && !st.isEmpty()) {
            for (NamedType subtype : st) {
                _collectAndResolve(AnnotatedClassResolver.resolveWithoutSuperTypes(config, subtype.getType()), subtype, config, ai, collectedSubtypes);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void _collectAndResolveByTypeId(com.fasterxml.jackson.databind.introspect.AnnotatedClass r17, com.fasterxml.jackson.databind.jsontype.NamedType r18, com.fasterxml.jackson.databind.cfg.MapperConfig<?> r19, java.util.Set<java.lang.Class<?>> r20, java.util.Map<java.lang.String, com.fasterxml.jackson.databind.jsontype.NamedType> r21) {
        /*
            r16 = this;
            r0 = r17
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r19.getAnnotationIntrospector()
            boolean r2 = r18.hasName()
            if (r2 != 0) goto L_0x001c
            java.lang.String r2 = r1.findTypeName(r0)
            if (r2 == 0) goto L_0x001c
            com.fasterxml.jackson.databind.jsontype.NamedType r3 = new com.fasterxml.jackson.databind.jsontype.NamedType
            java.lang.Class r4 = r18.getType()
            r3.<init>(r4, r2)
            goto L_0x001e
        L_0x001c:
            r3 = r18
        L_0x001e:
            boolean r2 = r3.hasName()
            if (r2 == 0) goto L_0x002e
            java.lang.String r2 = r3.getName()
            r10 = r21
            r10.put(r2, r3)
            goto L_0x0030
        L_0x002e:
            r10 = r21
        L_0x0030:
            java.lang.Class r2 = r3.getType()
            r11 = r20
            boolean r2 = r11.add(r2)
            if (r2 == 0) goto L_0x0077
            java.util.List r2 = r1.findSubtypes(r0)
            if (r2 == 0) goto L_0x0074
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0074
            java.util.Iterator r12 = r2.iterator()
        L_0x004c:
            boolean r4 = r12.hasNext()
            if (r4 == 0) goto L_0x0071
            java.lang.Object r4 = r12.next()
            r13 = r4
            com.fasterxml.jackson.databind.jsontype.NamedType r13 = (com.fasterxml.jackson.databind.jsontype.NamedType) r13
            java.lang.Class r4 = r13.getType()
            r14 = r19
            com.fasterxml.jackson.databind.introspect.AnnotatedClass r15 = com.fasterxml.jackson.databind.introspect.AnnotatedClassResolver.resolveWithoutSuperTypes(r14, r4)
            r4 = r16
            r5 = r15
            r6 = r13
            r7 = r19
            r8 = r20
            r9 = r21
            r4._collectAndResolveByTypeId(r5, r6, r7, r8, r9)
            goto L_0x004c
        L_0x0071:
            r14 = r19
            goto L_0x0079
        L_0x0074:
            r14 = r19
            goto L_0x0079
        L_0x0077:
            r14 = r19
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver._collectAndResolveByTypeId(com.fasterxml.jackson.databind.introspect.AnnotatedClass, com.fasterxml.jackson.databind.jsontype.NamedType, com.fasterxml.jackson.databind.cfg.MapperConfig, java.util.Set, java.util.Map):void");
    }

    /* access modifiers changed from: protected */
    public Collection<NamedType> _combineNamedAndUnnamed(Class<?> rawBase, Set<Class<?>> typesHandled, Map<String, NamedType> byName) {
        ArrayList<NamedType> result = new ArrayList<>(byName.values());
        for (NamedType t : byName.values()) {
            typesHandled.remove(t.getType());
        }
        for (Class<?> cls : typesHandled) {
            if (cls != rawBase || !Modifier.isAbstract(cls.getModifiers())) {
                result.add(new NamedType(cls));
            }
        }
        return result;
    }
}
