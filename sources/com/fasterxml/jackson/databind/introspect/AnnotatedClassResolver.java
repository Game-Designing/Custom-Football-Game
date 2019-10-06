package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;

public class AnnotatedClassResolver {
    private static final Annotations NO_ANNOTATIONS = AnnotationCollector.emptyAnnotations();
    private final TypeBindings _bindings;
    private final Class<?> _class;
    private final MapperConfig<?> _config;
    private final AnnotationIntrospector _intr;
    private final MixInResolver _mixInResolver;
    private final Class<?> _primaryMixin;
    private final JavaType _type;

    AnnotatedClassResolver(MapperConfig<?> config, JavaType type, MixInResolver r) {
        this._config = config;
        this._type = type;
        this._class = type.getRawClass();
        this._mixInResolver = r;
        this._bindings = type.getBindings();
        this._intr = config.isAnnotationProcessingEnabled() ? config.getAnnotationIntrospector() : null;
        this._primaryMixin = this._config.findMixInClassFor(this._class);
    }

    AnnotatedClassResolver(MapperConfig<?> config, Class<?> cls, MixInResolver r) {
        this._config = config;
        AnnotationIntrospector annotationIntrospector = null;
        this._type = null;
        this._class = cls;
        this._mixInResolver = r;
        this._bindings = TypeBindings.emptyBindings();
        if (config == null) {
            this._intr = null;
            this._primaryMixin = null;
            return;
        }
        if (config.isAnnotationProcessingEnabled()) {
            annotationIntrospector = config.getAnnotationIntrospector();
        }
        this._intr = annotationIntrospector;
        this._primaryMixin = this._config.findMixInClassFor(this._class);
    }

    public static AnnotatedClass resolve(MapperConfig<?> config, JavaType forType, MixInResolver r) {
        if (!forType.isArrayType() || !skippableArray(config, forType.getRawClass())) {
            return new AnnotatedClassResolver(config, forType, r).resolveFully();
        }
        return createArrayType(config, forType.getRawClass());
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> config, Class<?> forType) {
        return resolveWithoutSuperTypes(config, forType, config);
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> config, Class<?> forType, MixInResolver r) {
        if (!forType.isArray() || !skippableArray(config, forType)) {
            return new AnnotatedClassResolver(config, forType, r).resolveWithoutSuperTypes();
        }
        return createArrayType(config, forType);
    }

    private static boolean skippableArray(MapperConfig<?> config, Class<?> type) {
        return config == null || config.findMixInClassFor(type) == null;
    }

    static AnnotatedClass createPrimordial(Class<?> raw) {
        return new AnnotatedClass(raw);
    }

    static AnnotatedClass createArrayType(MapperConfig<?> mapperConfig, Class<?> raw) {
        return new AnnotatedClass(raw);
    }

    /* access modifiers changed from: 0000 */
    public AnnotatedClass resolveFully() {
        List<JavaType> superTypes = ClassUtil.findSuperTypes(this._type, null, false);
        AnnotatedClass annotatedClass = new AnnotatedClass(this._type, this._class, superTypes, this._primaryMixin, resolveClassAnnotations(superTypes), this._bindings, this._intr, this._mixInResolver, this._config.getTypeFactory());
        return annotatedClass;
    }

    /* access modifiers changed from: 0000 */
    public AnnotatedClass resolveWithoutSuperTypes() {
        List<JavaType> superTypes = Collections.emptyList();
        Class<?> cls = this._class;
        Class<?> cls2 = this._primaryMixin;
        Annotations resolveClassAnnotations = resolveClassAnnotations(superTypes);
        TypeBindings typeBindings = this._bindings;
        AnnotationIntrospector annotationIntrospector = this._intr;
        MapperConfig<?> mapperConfig = this._config;
        AnnotatedClass annotatedClass = new AnnotatedClass(null, cls, superTypes, cls2, resolveClassAnnotations, typeBindings, annotationIntrospector, mapperConfig, mapperConfig.getTypeFactory());
        return annotatedClass;
    }

    private Annotations resolveClassAnnotations(List<JavaType> superTypes) {
        if (this._intr == null) {
            return NO_ANNOTATIONS;
        }
        AnnotationCollector resolvedCA = AnnotationCollector.emptyCollector();
        Class<?> cls = this._primaryMixin;
        if (cls != null) {
            resolvedCA = _addClassMixIns(resolvedCA, this._class, cls);
        }
        AnnotationCollector resolvedCA2 = _addAnnotationsIfNotPresent(resolvedCA, ClassUtil.findClassAnnotations(this._class));
        for (JavaType type : superTypes) {
            if (this._mixInResolver != null) {
                Class<?> cls2 = type.getRawClass();
                resolvedCA2 = _addClassMixIns(resolvedCA2, cls2, this._mixInResolver.findMixInClassFor(cls2));
            }
            resolvedCA2 = _addAnnotationsIfNotPresent(resolvedCA2, ClassUtil.findClassAnnotations(type.getRawClass()));
        }
        MixInResolver mixInResolver = this._mixInResolver;
        if (mixInResolver != null) {
            resolvedCA2 = _addClassMixIns(resolvedCA2, Object.class, mixInResolver.findMixInClassFor(Object.class));
        }
        return resolvedCA2.asAnnotations();
    }

    private AnnotationCollector _addClassMixIns(AnnotationCollector annotations, Class<?> target, Class<?> mixin) {
        if (mixin != null) {
            annotations = _addAnnotationsIfNotPresent(annotations, ClassUtil.findClassAnnotations(mixin));
            for (Class<?> parent : ClassUtil.findSuperClasses(mixin, target, false)) {
                annotations = _addAnnotationsIfNotPresent(annotations, ClassUtil.findClassAnnotations(parent));
            }
        }
        return annotations;
    }

    private AnnotationCollector _addAnnotationsIfNotPresent(AnnotationCollector c, Annotation[] anns) {
        Annotation[] arr$;
        if (anns != null) {
            for (Annotation ann : anns) {
                if (!c.isPresent(ann)) {
                    c = c.addOrOverride(ann);
                    if (this._intr.isAnnotationBundle(ann)) {
                        c = _addFromBundleIfNotPresent(c, ann);
                    }
                }
            }
        }
        return c;
    }

    private AnnotationCollector _addFromBundleIfNotPresent(AnnotationCollector c, Annotation bundle) {
        Annotation[] arr$;
        for (Annotation ann : ClassUtil.findClassAnnotations(bundle.annotationType())) {
            if (!(ann instanceof Target) && !(ann instanceof Retention) && !c.isPresent(ann)) {
                c = c.addOrOverride(ann);
                if (this._intr.isAnnotationBundle(ann)) {
                    c = _addFromBundleIfNotPresent(c, ann);
                }
            }
        }
        return c;
    }
}
