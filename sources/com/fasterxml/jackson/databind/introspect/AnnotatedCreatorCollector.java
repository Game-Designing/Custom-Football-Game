package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass.Creators;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ClassUtil.Ctor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class AnnotatedCreatorCollector extends CollectorBase {
    private AnnotatedConstructor _defaultConstructor;
    private final TypeResolutionContext _typeContext;

    AnnotatedCreatorCollector(AnnotationIntrospector intr, TypeResolutionContext tc) {
        super(intr);
        this._typeContext = tc;
    }

    public static Creators collectCreators(AnnotationIntrospector intr, TypeResolutionContext tc, JavaType type, Class<?> primaryMixIn) {
        return new AnnotatedCreatorCollector(intr, tc).collect(type, primaryMixIn);
    }

    /* access modifiers changed from: 0000 */
    public Creators collect(JavaType type, Class<?> primaryMixIn) {
        List<AnnotatedConstructor> constructors = _findPotentialConstructors(type, primaryMixIn);
        List<AnnotatedMethod> factories = _findPotentialFactories(type, primaryMixIn);
        AnnotationIntrospector annotationIntrospector = this._intr;
        if (annotationIntrospector != null) {
            AnnotatedConstructor annotatedConstructor = this._defaultConstructor;
            if (annotatedConstructor != null && annotationIntrospector.hasIgnoreMarker(annotatedConstructor)) {
                this._defaultConstructor = null;
            }
            int i = constructors.size();
            while (true) {
                i--;
                if (i < 0) {
                    break;
                } else if (this._intr.hasIgnoreMarker((AnnotatedMember) constructors.get(i))) {
                    constructors.remove(i);
                }
            }
            int i2 = factories.size();
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                } else if (this._intr.hasIgnoreMarker((AnnotatedMember) factories.get(i2))) {
                    factories.remove(i2);
                }
            }
        }
        return new Creators(this._defaultConstructor, constructors, factories);
    }

    private List<AnnotatedConstructor> _findPotentialConstructors(JavaType type, Class<?> primaryMixIn) {
        int ctorCount;
        List<AnnotatedConstructor> result;
        Ctor[] arr$;
        Ctor[] arr$2;
        Ctor defaultCtor = null;
        List<Ctor> ctors = null;
        if (!type.isEnumType()) {
            for (Ctor ctor : ClassUtil.getConstructors(type.getRawClass())) {
                if (isIncludableConstructor(ctor.getConstructor())) {
                    if (ctor.getParamCount() == 0) {
                        defaultCtor = ctor;
                    } else {
                        if (ctors == null) {
                            ctors = new ArrayList<>();
                        }
                        ctors.add(ctor);
                    }
                }
            }
        }
        if (ctors == null) {
            result = Collections.emptyList();
            if (defaultCtor == null) {
                return result;
            }
            ctorCount = 0;
        } else {
            ctorCount = ctors.size();
            result = new ArrayList<>(ctorCount);
            for (int i = 0; i < ctorCount; i++) {
                result.add(null);
            }
        }
        if (primaryMixIn != null) {
            MemberKey[] ctorKeys = null;
            for (Ctor mixinCtor : ClassUtil.getConstructors(primaryMixIn)) {
                if (mixinCtor.getParamCount() == 0) {
                    if (defaultCtor != null) {
                        this._defaultConstructor = constructDefaultConstructor(defaultCtor, mixinCtor);
                        defaultCtor = null;
                    }
                } else if (ctors != null) {
                    if (ctorKeys == null) {
                        ctorKeys = new MemberKey[ctorCount];
                        for (int i2 = 0; i2 < ctorCount; i2++) {
                            ctorKeys[i2] = new MemberKey(((Ctor) ctors.get(i2)).getConstructor());
                        }
                    }
                    MemberKey key = new MemberKey(mixinCtor.getConstructor());
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ctorCount) {
                            break;
                        } else if (key.equals(ctorKeys[i3])) {
                            result.set(i3, constructNonDefaultConstructor((Ctor) ctors.get(i3), mixinCtor));
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        if (defaultCtor != null) {
            this._defaultConstructor = constructDefaultConstructor(defaultCtor, null);
        }
        for (int i4 = 0; i4 < ctorCount; i4++) {
            if (((AnnotatedConstructor) result.get(i4)) == null) {
                result.set(i4, constructNonDefaultConstructor((Ctor) ctors.get(i4), null));
            }
        }
        return result;
    }

    private List<AnnotatedMethod> _findPotentialFactories(JavaType type, Class<?> primaryMixIn) {
        Method[] arr$;
        Method[] arr$2;
        List<Method> candidates = null;
        for (Method m : ClassUtil.getClassMethods(type.getRawClass())) {
            if (Modifier.isStatic(m.getModifiers())) {
                if (candidates == null) {
                    candidates = new ArrayList<>();
                }
                candidates.add(m);
            }
        }
        if (candidates == null) {
            return Collections.emptyList();
        }
        int factoryCount = candidates.size();
        List<AnnotatedMethod> result = new ArrayList<>(factoryCount);
        for (int i = 0; i < factoryCount; i++) {
            result.add(null);
        }
        if (primaryMixIn != null) {
            MemberKey[] methodKeys = null;
            for (Method mixinFactory : ClassUtil.getDeclaredMethods(primaryMixIn)) {
                if (Modifier.isStatic(mixinFactory.getModifiers())) {
                    if (methodKeys == null) {
                        methodKeys = new MemberKey[factoryCount];
                        for (int i2 = 0; i2 < factoryCount; i2++) {
                            methodKeys[i2] = new MemberKey((Method) candidates.get(i2));
                        }
                    }
                    MemberKey key = new MemberKey(mixinFactory);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= factoryCount) {
                            break;
                        } else if (key.equals(methodKeys[i3])) {
                            result.set(i3, constructFactoryCreator((Method) candidates.get(i3), mixinFactory));
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        for (int i4 = 0; i4 < factoryCount; i4++) {
            if (((AnnotatedMethod) result.get(i4)) == null) {
                result.set(i4, constructFactoryCreator((Method) candidates.get(i4), null));
            }
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public AnnotatedConstructor constructDefaultConstructor(Ctor ctor, Ctor mixin) {
        if (this._intr == null) {
            return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), CollectorBase._emptyAnnotationMap(), CollectorBase.NO_ANNOTATION_MAPS);
        }
        return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), collectAnnotations(ctor, mixin), collectAnnotations(ctor.getConstructor().getParameterAnnotations(), mixin == null ? null : mixin.getConstructor().getParameterAnnotations()));
    }

    /* access modifiers changed from: protected */
    public AnnotatedConstructor constructNonDefaultConstructor(Ctor ctor, Ctor mixin) {
        AnnotationMap[] resolvedAnnotations;
        int paramCount = ctor.getParamCount();
        if (this._intr == null) {
            return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), CollectorBase._emptyAnnotationMap(), CollectorBase._emptyAnnotationMaps(paramCount));
        }
        if (paramCount == 0) {
            return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), collectAnnotations(ctor, mixin), CollectorBase.NO_ANNOTATION_MAPS);
        }
        Annotation[][] paramAnns = ctor.getParameterAnnotations();
        Annotation[][] annotationArr = null;
        if (paramCount != paramAnns.length) {
            resolvedAnnotations = null;
            Class<?> dc = ctor.getDeclaringClass();
            if (dc.isEnum() && paramCount == paramAnns.length + 2) {
                Annotation[][] old = paramAnns;
                paramAnns = new Annotation[(old.length + 2)][];
                System.arraycopy(old, 0, paramAnns, 2, old.length);
                resolvedAnnotations = collectAnnotations(paramAnns, (Annotation[][]) null);
            } else if (dc.isMemberClass() && paramCount == paramAnns.length + 1) {
                Annotation[][] old2 = paramAnns;
                paramAnns = new Annotation[(old2.length + 1)][];
                System.arraycopy(old2, 0, paramAnns, 1, old2.length);
                paramAnns[0] = CollectorBase.NO_ANNOTATIONS;
                resolvedAnnotations = collectAnnotations(paramAnns, (Annotation[][]) null);
            }
            if (resolvedAnnotations == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", new Object[]{ctor.getDeclaringClass().getName(), Integer.valueOf(paramCount), Integer.valueOf(paramAnns.length)}));
            }
        } else {
            if (mixin != null) {
                annotationArr = mixin.getParameterAnnotations();
            }
            resolvedAnnotations = collectAnnotations(paramAnns, annotationArr);
        }
        return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), collectAnnotations(ctor, mixin), resolvedAnnotations);
    }

    /* access modifiers changed from: protected */
    public AnnotatedMethod constructFactoryCreator(Method m, Method mixin) {
        int paramCount = m.getParameterTypes().length;
        if (this._intr == null) {
            return new AnnotatedMethod(this._typeContext, m, CollectorBase._emptyAnnotationMap(), CollectorBase._emptyAnnotationMaps(paramCount));
        }
        if (paramCount == 0) {
            return new AnnotatedMethod(this._typeContext, m, collectAnnotations((AnnotatedElement) m, (AnnotatedElement) mixin), CollectorBase.NO_ANNOTATION_MAPS);
        }
        return new AnnotatedMethod(this._typeContext, m, collectAnnotations((AnnotatedElement) m, (AnnotatedElement) mixin), collectAnnotations(m.getParameterAnnotations(), mixin == null ? null : mixin.getParameterAnnotations()));
    }

    private AnnotationMap[] collectAnnotations(Annotation[][] mainAnns, Annotation[][] mixinAnns) {
        int count = mainAnns.length;
        AnnotationMap[] result = new AnnotationMap[count];
        for (int i = 0; i < count; i++) {
            AnnotationCollector c = collectAnnotations(AnnotationCollector.emptyCollector(), mainAnns[i]);
            if (mixinAnns != null) {
                c = collectAnnotations(c, mixinAnns[i]);
            }
            result[i] = c.asAnnotationMap();
        }
        return result;
    }

    private AnnotationMap collectAnnotations(Ctor main, Ctor mixin) {
        AnnotationCollector c = collectAnnotations(main.getConstructor().getDeclaredAnnotations());
        if (mixin != null) {
            c = collectAnnotations(c, mixin.getConstructor().getDeclaredAnnotations());
        }
        return c.asAnnotationMap();
    }

    private final AnnotationMap collectAnnotations(AnnotatedElement main, AnnotatedElement mixin) {
        AnnotationCollector c = collectAnnotations(main.getDeclaredAnnotations());
        if (mixin != null) {
            c = collectAnnotations(c, mixin.getDeclaredAnnotations());
        }
        return c.asAnnotationMap();
    }

    private static boolean isIncludableConstructor(Constructor<?> c) {
        return !c.isSynthetic();
    }
}
