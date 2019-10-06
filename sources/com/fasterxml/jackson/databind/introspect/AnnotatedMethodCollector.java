package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnnotatedMethodCollector extends CollectorBase {
    private final MixInResolver _mixInResolver;

    private static final class MethodBuilder {
        public AnnotationCollector annotations;
        public Method method;
        public TypeResolutionContext typeContext;

        public MethodBuilder(TypeResolutionContext tc, Method m, AnnotationCollector ann) {
            this.typeContext = tc;
            this.method = m;
            this.annotations = ann;
        }

        public AnnotatedMethod build() {
            Method method2 = this.method;
            if (method2 == null) {
                return null;
            }
            return new AnnotatedMethod(this.typeContext, method2, this.annotations.asAnnotationMap(), null);
        }
    }

    AnnotatedMethodCollector(AnnotationIntrospector intr, MixInResolver mixins) {
        super(intr);
        this._mixInResolver = intr == null ? null : mixins;
    }

    public static AnnotatedMethodMap collectMethods(AnnotationIntrospector intr, TypeResolutionContext tc, MixInResolver mixins, TypeFactory types, JavaType type, List<JavaType> superTypes, Class<?> primaryMixIn) {
        return new AnnotatedMethodCollector(intr, mixins).collect(types, tc, type, superTypes, primaryMixIn);
    }

    /* access modifiers changed from: 0000 */
    public AnnotatedMethodMap collect(TypeFactory typeFactory, TypeResolutionContext tc, JavaType mainType, List<JavaType> superTypes, Class<?> primaryMixIn) {
        Map<MemberKey, MethodBuilder> methods = new LinkedHashMap<>();
        _addMemberMethods(tc, mainType.getRawClass(), methods, primaryMixIn);
        for (JavaType type : superTypes) {
            MixInResolver mixInResolver = this._mixInResolver;
            _addMemberMethods(new Basic(typeFactory, type.getBindings()), type.getRawClass(), methods, mixInResolver == null ? null : mixInResolver.findMixInClassFor(type.getRawClass()));
        }
        if (methods.isEmpty()) {
            return new AnnotatedMethodMap();
        }
        Map<MemberKey, AnnotatedMethod> actual = new LinkedHashMap<>(methods.size());
        for (Entry<MemberKey, MethodBuilder> entry : methods.entrySet()) {
            AnnotatedMethod am = ((MethodBuilder) entry.getValue()).build();
            if (am != null) {
                actual.put(entry.getKey(), am);
            }
        }
        return new AnnotatedMethodMap(actual);
    }

    private void _addMemberMethods(TypeResolutionContext tc, Class<?> cls, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        Method[] arr$;
        if (mixInCls != null) {
            _addMethodMixIns(tc, cls, methods, mixInCls);
        }
        if (cls != null) {
            for (Method m : ClassUtil.getClassMethods(cls)) {
                if (_isIncludableMemberMethod(m)) {
                    MemberKey key = new MemberKey(m);
                    MethodBuilder b = (MethodBuilder) methods.get(key);
                    if (b == null) {
                        methods.put(key, new MethodBuilder(tc, m, this._intr == null ? AnnotationCollector.emptyCollector() : collectAnnotations(m.getDeclaredAnnotations())));
                    } else {
                        if (this._intr != null) {
                            b.annotations = collectDefaultAnnotations(b.annotations, m.getDeclaredAnnotations());
                        }
                        Method old = b.method;
                        if (old == null) {
                            b.method = m;
                        } else if (Modifier.isAbstract(old.getModifiers()) && !Modifier.isAbstract(m.getModifiers())) {
                            b.method = m;
                            b.typeContext = tc;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addMethodMixIns(TypeResolutionContext tc, Class<?> targetClass, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        Iterator i$;
        Map<MemberKey, MethodBuilder> map = methods;
        if (this._intr != null) {
            Iterator i$2 = ClassUtil.findRawSuperTypes(mixInCls, targetClass, true).iterator();
            while (i$2.hasNext()) {
                Method[] arr$ = ClassUtil.getDeclaredMethods((Class) i$2.next());
                int len$ = arr$.length;
                int i$3 = 0;
                while (i$3 < len$) {
                    Method m = arr$[i$3];
                    if (!_isIncludableMemberMethod(m)) {
                        i$ = i$2;
                        TypeResolutionContext typeResolutionContext = tc;
                    } else {
                        MemberKey key = new MemberKey(m);
                        MethodBuilder b = (MethodBuilder) map.get(key);
                        Annotation[] anns = m.getDeclaredAnnotations();
                        if (b == null) {
                            i$ = i$2;
                            map.put(key, new MethodBuilder(tc, null, collectAnnotations(anns)));
                        } else {
                            i$ = i$2;
                            TypeResolutionContext typeResolutionContext2 = tc;
                            b.annotations = collectDefaultAnnotations(b.annotations, anns);
                        }
                    }
                    i$3++;
                    i$2 = i$;
                }
                Iterator i$4 = i$2;
                TypeResolutionContext typeResolutionContext3 = tc;
                i$2 = i$4;
            }
            TypeResolutionContext typeResolutionContext4 = tc;
        }
    }

    private boolean _isIncludableMemberMethod(Method m) {
        boolean z = false;
        if (Modifier.isStatic(m.getModifiers()) || m.isSynthetic() || m.isBridge()) {
            return false;
        }
        if (m.getParameterTypes().length <= 2) {
            z = true;
        }
        return z;
    }
}
