package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.p134io.SerializedString;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class MapperConfig<T extends MapperConfig<T>> implements MixInResolver, Serializable {
    protected static final Value EMPTY_FORMAT = Value.empty();
    protected static final JsonInclude.Value EMPTY_INCLUDE = JsonInclude.Value.empty();
    protected final BaseSettings _base;
    protected final int _mapperFeatures;

    public abstract ConfigOverride getConfigOverride(Class<?> cls);

    public abstract JsonInclude.Value getDefaultInclusion(Class<?> cls, Class<?> cls2);

    public abstract Boolean getDefaultMergeable();

    public abstract Value getDefaultPropertyFormat(Class<?> cls);

    public abstract JsonInclude.Value getDefaultPropertyInclusion(Class<?> cls);

    public abstract JsonSetter.Value getDefaultSetterInfo();

    public abstract VisibilityChecker<?> getDefaultVisibilityChecker(Class<?> cls, AnnotatedClass annotatedClass);

    protected MapperConfig(BaseSettings base, int mapperFeatures) {
        this._base = base;
        this._mapperFeatures = mapperFeatures;
    }

    protected MapperConfig(MapperConfig<T> src, int mapperFeatures) {
        this._base = src._base;
        this._mapperFeatures = mapperFeatures;
    }

    protected MapperConfig(MapperConfig<T> src, BaseSettings base) {
        this._base = base;
        this._mapperFeatures = src._mapperFeatures;
    }

    public static <F extends Enum<F> & ConfigFeature> int collectFeatureDefaults(Class<F> enumClass) {
        F[] arr$;
        int flags = 0;
        for (F value : (Enum[]) enumClass.getEnumConstants()) {
            if (((ConfigFeature) value).enabledByDefault()) {
                flags |= ((ConfigFeature) value).getMask();
            }
        }
        return flags;
    }

    public final boolean isEnabled(MapperFeature f) {
        return (this._mapperFeatures & f.getMask()) != 0;
    }

    public final boolean isAnnotationProcessingEnabled() {
        return isEnabled(MapperFeature.USE_ANNOTATIONS);
    }

    public final boolean canOverrideAccessModifiers() {
        return isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final boolean shouldSortPropertiesAlphabetically() {
        return isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public SerializableString compileString(String src) {
        return new SerializedString(src);
    }

    public ClassIntrospector getClassIntrospector() {
        return this._base.getClassIntrospector();
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        if (isEnabled(MapperFeature.USE_ANNOTATIONS)) {
            return this._base.getAnnotationIntrospector();
        }
        return NopAnnotationIntrospector.instance;
    }

    public final PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._base.getPropertyNamingStrategy();
    }

    public final HandlerInstantiator getHandlerInstantiator() {
        return this._base.getHandlerInstantiator();
    }

    public final TypeResolverBuilder<?> getDefaultTyper(JavaType baseType) {
        return this._base.getTypeResolverBuilder();
    }

    public final TypeFactory getTypeFactory() {
        return this._base.getTypeFactory();
    }

    public final JavaType constructType(Class<?> cls) {
        return getTypeFactory().constructType((Type) cls);
    }

    public JavaType constructSpecializedType(JavaType baseType, Class<?> subclass) {
        return getTypeFactory().constructSpecializedType(baseType, subclass);
    }

    public BeanDescription introspectClassAnnotations(Class<?> cls) {
        return introspectClassAnnotations(constructType(cls));
    }

    public BeanDescription introspectClassAnnotations(JavaType type) {
        return getClassIntrospector().forClassAnnotations(this, type, this);
    }

    public JsonInclude.Value getDefaultPropertyInclusion(Class<?> baseType, JsonInclude.Value defaultIncl) {
        JsonInclude.Value v = getConfigOverride(baseType).getInclude();
        if (v != null) {
            return v;
        }
        return defaultIncl;
    }

    public JsonInclude.Value getDefaultInclusion(Class<?> baseType, Class<?> propertyType, JsonInclude.Value defaultIncl) {
        return JsonInclude.Value.mergeAll(defaultIncl, getConfigOverride(baseType).getInclude(), getConfigOverride(propertyType).getIncludeAsProperty());
    }

    public final DateFormat getDateFormat() {
        return this._base.getDateFormat();
    }

    public final Locale getLocale() {
        return this._base.getLocale();
    }

    public final TimeZone getTimeZone() {
        return this._base.getTimeZone();
    }

    public Base64Variant getBase64Variant() {
        return this._base.getBase64Variant();
    }

    public TypeResolverBuilder<?> typeResolverBuilderInstance(Annotated annotated, Class<? extends TypeResolverBuilder<?>> builderClass) {
        HandlerInstantiator hi = getHandlerInstantiator();
        if (hi != null) {
            TypeResolverBuilder<?> builder = hi.typeResolverBuilderInstance(this, annotated, builderClass);
            if (builder != null) {
                return builder;
            }
        }
        return (TypeResolverBuilder) ClassUtil.createInstance(builderClass, canOverrideAccessModifiers());
    }

    public TypeIdResolver typeIdResolverInstance(Annotated annotated, Class<? extends TypeIdResolver> resolverClass) {
        HandlerInstantiator hi = getHandlerInstantiator();
        if (hi != null) {
            TypeIdResolver builder = hi.typeIdResolverInstance(this, annotated, resolverClass);
            if (builder != null) {
                return builder;
            }
        }
        return (TypeIdResolver) ClassUtil.createInstance(resolverClass, canOverrideAccessModifiers());
    }
}
