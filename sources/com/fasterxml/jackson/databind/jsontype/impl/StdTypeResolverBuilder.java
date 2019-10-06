package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.C0079Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.lang.reflect.Type;
import java.util.Collection;

public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    protected TypeIdResolver _customIdResolver;
    protected Class<?> _defaultImpl;
    protected C0079Id _idType;
    protected C0078As _includeAs;
    protected boolean _typeIdVisible = false;
    protected String _typeProperty;

    /* renamed from: com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder$1 */
    static /* synthetic */ class C68341 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As = new int[C0078As.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id = new int[C0079Id.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[C0079Id.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[C0079Id.MINIMAL_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[C0079Id.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[C0079Id.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[C0079Id.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.WRAPPER_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.WRAPPER_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.EXTERNAL_PROPERTY.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.EXISTING_PROPERTY.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    public static StdTypeResolverBuilder noTypeInfoBuilder() {
        StdTypeResolverBuilder stdTypeResolverBuilder = new StdTypeResolverBuilder();
        stdTypeResolverBuilder.init(C0079Id.NONE, (TypeIdResolver) null);
        return stdTypeResolverBuilder;
    }

    public StdTypeResolverBuilder init(C0079Id idType, TypeIdResolver idRes) {
        if (idType != null) {
            this._idType = idType;
            this._customIdResolver = idRes;
            this._typeProperty = idType.getDefaultPropertyName();
            return this;
        }
        throw new IllegalArgumentException("idType cannot be null");
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
        if (this._idType == C0079Id.NONE || baseType.isPrimitive()) {
            return null;
        }
        TypeIdResolver idRes = idResolver(config, baseType, subtypes, true, false);
        int i = C68341.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[this._includeAs.ordinal()];
        if (i == 1) {
            return new AsArrayTypeSerializer(idRes, null);
        }
        if (i == 2) {
            return new AsPropertyTypeSerializer(idRes, null, this._typeProperty);
        }
        if (i == 3) {
            return new AsWrapperTypeSerializer(idRes, null);
        }
        if (i == 4) {
            return new AsExternalTypeSerializer(idRes, null, this._typeProperty);
        }
        if (i == 5) {
            return new AsExistingPropertyTypeSerializer(idRes, null, this._typeProperty);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Do not know how to construct standard type serializer for inclusion type: ");
        sb.append(this._includeAs);
        throw new IllegalStateException(sb.toString());
    }

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
        JavaType defaultImpl;
        if (this._idType == C0079Id.NONE || baseType.isPrimitive()) {
            return null;
        }
        TypeIdResolver idRes = idResolver(config, baseType, subtypes, false, true);
        Class<?> cls = this._defaultImpl;
        if (cls == null) {
            defaultImpl = null;
        } else if (cls == Void.class || cls == NoClass.class) {
            defaultImpl = config.getTypeFactory().constructType((Type) this._defaultImpl);
        } else {
            defaultImpl = config.getTypeFactory().constructSpecializedType(baseType, this._defaultImpl);
        }
        int i = C68341.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[this._includeAs.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    AsWrapperTypeDeserializer asWrapperTypeDeserializer = new AsWrapperTypeDeserializer(baseType, idRes, this._typeProperty, this._typeIdVisible, defaultImpl);
                    return asWrapperTypeDeserializer;
                } else if (i == 4) {
                    AsExternalTypeDeserializer asExternalTypeDeserializer = new AsExternalTypeDeserializer(baseType, idRes, this._typeProperty, this._typeIdVisible, defaultImpl);
                    return asExternalTypeDeserializer;
                } else if (i != 5) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Do not know how to construct standard type serializer for inclusion type: ");
                    sb.append(this._includeAs);
                    throw new IllegalStateException(sb.toString());
                }
            }
            AsPropertyTypeDeserializer asPropertyTypeDeserializer = new AsPropertyTypeDeserializer(baseType, idRes, this._typeProperty, this._typeIdVisible, defaultImpl, this._includeAs);
            return asPropertyTypeDeserializer;
        }
        AsArrayTypeDeserializer asArrayTypeDeserializer = new AsArrayTypeDeserializer(baseType, idRes, this._typeProperty, this._typeIdVisible, defaultImpl);
        return asArrayTypeDeserializer;
    }

    public StdTypeResolverBuilder inclusion(C0078As includeAs) {
        if (includeAs != null) {
            this._includeAs = includeAs;
            return this;
        }
        throw new IllegalArgumentException("includeAs cannot be null");
    }

    public StdTypeResolverBuilder typeProperty(String typeIdPropName) {
        if (typeIdPropName == null || typeIdPropName.length() == 0) {
            typeIdPropName = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = typeIdPropName;
        return this;
    }

    public StdTypeResolverBuilder defaultImpl(Class<?> defaultImpl) {
        this._defaultImpl = defaultImpl;
        return this;
    }

    public StdTypeResolverBuilder typeIdVisibility(boolean isVisible) {
        this._typeIdVisible = isVisible;
        return this;
    }

    public Class<?> getDefaultImpl() {
        return this._defaultImpl;
    }

    /* access modifiers changed from: protected */
    public TypeIdResolver idResolver(MapperConfig<?> config, JavaType baseType, Collection<NamedType> subtypes, boolean forSer, boolean forDeser) {
        TypeIdResolver typeIdResolver = this._customIdResolver;
        if (typeIdResolver != null) {
            return typeIdResolver;
        }
        C0079Id id = this._idType;
        if (id != null) {
            int i = C68341.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$Id[id.ordinal()];
            if (i == 1) {
                return new ClassNameIdResolver(baseType, config.getTypeFactory());
            }
            if (i == 2) {
                return new MinimalClassNameIdResolver(baseType, config.getTypeFactory());
            }
            if (i == 3) {
                return TypeNameIdResolver.construct(config, baseType, subtypes, forSer, forDeser);
            }
            if (i == 4) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Do not know how to construct standard type id resolver for idType: ");
            sb.append(this._idType);
            throw new IllegalStateException(sb.toString());
        }
        throw new IllegalStateException("Cannot build, 'init()' not yet called");
    }
}
