package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Named;
import java.io.Serializable;

public interface BeanProperty extends Named {
    public static final Value EMPTY_FORMAT = new Value();
    public static final JsonInclude.Value EMPTY_INCLUDE = JsonInclude.Value.empty();

    public static class Bogus implements BeanProperty {
        public String getName() {
            return "";
        }

        public PropertyName getFullName() {
            return PropertyName.NO_NAME;
        }

        public JavaType getType() {
            return TypeFactory.unknownType();
        }

        public PropertyMetadata getMetadata() {
            return PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
        }

        public AnnotatedMember getMember() {
            return null;
        }

        public Value findPropertyFormat(MapperConfig<?> mapperConfig, Class<?> cls) {
            return Value.empty();
        }

        public JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls) {
            return null;
        }
    }

    public static class Std implements BeanProperty, Serializable {
        protected final AnnotatedMember _member;
        protected final PropertyMetadata _metadata;
        protected final PropertyName _name;
        protected final JavaType _type;
        protected final PropertyName _wrapperName;

        public Std(PropertyName name, JavaType type, PropertyName wrapperName, AnnotatedMember member, PropertyMetadata metadata) {
            this._name = name;
            this._type = type;
            this._wrapperName = wrapperName;
            this._metadata = metadata;
            this._member = member;
        }

        public Value findPropertyFormat(MapperConfig<?> config, Class<?> baseType) {
            Value v0 = config.getDefaultPropertyFormat(baseType);
            AnnotationIntrospector intr = config.getAnnotationIntrospector();
            if (intr != null) {
                AnnotatedMember annotatedMember = this._member;
                if (annotatedMember != null) {
                    Value v = intr.findFormat(annotatedMember);
                    if (v == null) {
                        return v0;
                    }
                    return v0.withOverrides(v);
                }
            }
            return v0;
        }

        public JsonInclude.Value findPropertyInclusion(MapperConfig<?> config, Class<?> baseType) {
            JsonInclude.Value v0 = config.getDefaultInclusion(baseType, this._type.getRawClass());
            AnnotationIntrospector intr = config.getAnnotationIntrospector();
            if (intr != null) {
                AnnotatedMember annotatedMember = this._member;
                if (annotatedMember != null) {
                    JsonInclude.Value v = intr.findPropertyInclusion(annotatedMember);
                    if (v == null) {
                        return v0;
                    }
                    return v0.withOverrides(v);
                }
            }
            return v0;
        }

        public String getName() {
            return this._name.getSimpleName();
        }

        public PropertyName getFullName() {
            return this._name;
        }

        public JavaType getType() {
            return this._type;
        }

        public PropertyName getWrapperName() {
            return this._wrapperName;
        }

        public PropertyMetadata getMetadata() {
            return this._metadata;
        }

        public AnnotatedMember getMember() {
            return this._member;
        }
    }

    Value findPropertyFormat(MapperConfig<?> mapperConfig, Class<?> cls);

    JsonInclude.Value findPropertyInclusion(MapperConfig<?> mapperConfig, Class<?> cls);

    PropertyName getFullName();

    AnnotatedMember getMember();

    PropertyMetadata getMetadata();

    String getName();

    JavaType getType();
}
