package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Type;

public abstract class DatabindContext {
    public abstract MapperConfig<?> getConfig();

    public abstract TypeFactory getTypeFactory();

    /* access modifiers changed from: protected */
    public abstract JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2);

    public abstract <T> T reportBadDefinition(JavaType javaType, String str) throws JsonMappingException;

    public JavaType constructType(Type type) {
        if (type == null) {
            return null;
        }
        return getTypeFactory().constructType(type);
    }

    public JavaType constructSpecializedType(JavaType baseType, Class<?> subclass) {
        if (baseType.getRawClass() == subclass) {
            return baseType;
        }
        return getConfig().constructSpecializedType(baseType, subclass);
    }

    public JavaType resolveSubType(JavaType baseType, String subClass) throws JsonMappingException {
        if (subClass.indexOf(60) > 0) {
            JavaType t = getTypeFactory().constructFromCanonical(subClass);
            if (t.isTypeOrSubTypeOf(baseType.getRawClass())) {
                return t;
            }
        } else {
            try {
                Class<?> cls = getTypeFactory().findClass(subClass);
                if (baseType.isTypeOrSuperTypeOf(cls)) {
                    return getTypeFactory().constructSpecializedType(baseType, cls);
                }
            } catch (ClassNotFoundException e) {
                return null;
            } catch (Exception e2) {
                throw invalidTypeIdException(baseType, subClass, String.format("problem: (%s) %s", new Object[]{e2.getClass().getName(), e2.getMessage()}));
            }
        }
        throw invalidTypeIdException(baseType, subClass, "Not a subtype");
    }

    public ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated annotated, ObjectIdInfo objectIdInfo) throws JsonMappingException {
        Class<?> implClass = objectIdInfo.getGeneratorType();
        MapperConfig<?> config = getConfig();
        HandlerInstantiator hi = config.getHandlerInstantiator();
        ObjectIdGenerator<?> gen = hi == null ? null : hi.objectIdGeneratorInstance(config, annotated, implClass);
        if (gen == null) {
            gen = (ObjectIdGenerator) ClassUtil.createInstance(implClass, config.canOverrideAccessModifiers());
        }
        return gen.forScope(objectIdInfo.getScope());
    }

    public ObjectIdResolver objectIdResolverInstance(Annotated annotated, ObjectIdInfo objectIdInfo) {
        Class<? extends ObjectIdResolver> implClass = objectIdInfo.getResolverType();
        MapperConfig<?> config = getConfig();
        HandlerInstantiator hi = config.getHandlerInstantiator();
        ObjectIdResolver resolver = hi == null ? null : hi.resolverIdGeneratorInstance(config, annotated, implClass);
        if (resolver == null) {
            return (ObjectIdResolver) ClassUtil.createInstance(implClass, config.canOverrideAccessModifiers());
        }
        return resolver;
    }

    public Converter<Object, Object> converterInstance(Annotated annotated, Object converterDef) throws JsonMappingException {
        Converter<?, ?> conv = null;
        if (converterDef == null) {
            return null;
        }
        if (converterDef instanceof Converter) {
            return (Converter) converterDef;
        }
        if (converterDef instanceof Class) {
            Class<?> converterClass = (Class) converterDef;
            if (converterClass == None.class || ClassUtil.isBogusClass(converterClass)) {
                return null;
            }
            if (Converter.class.isAssignableFrom(converterClass)) {
                MapperConfig<?> config = getConfig();
                HandlerInstantiator hi = config.getHandlerInstantiator();
                if (hi != null) {
                    conv = hi.converterInstance(config, annotated, converterClass);
                }
                if (conv == null) {
                    conv = (Converter) ClassUtil.createInstance(converterClass, config.canOverrideAccessModifiers());
                }
                return conv;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AnnotationIntrospector returned Class ");
            sb.append(converterClass.getName());
            sb.append("; expected Class<Converter>");
            throw new IllegalStateException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AnnotationIntrospector returned Converter definition of type ");
        sb2.append(converterDef.getClass().getName());
        sb2.append("; expected type Converter or Class<Converter> instead");
        throw new IllegalStateException(sb2.toString());
    }

    public <T> T reportBadDefinition(Class<?> type, String msg) throws JsonMappingException {
        return reportBadDefinition(constructType(type), msg);
    }

    /* access modifiers changed from: protected */
    public final String _format(String msg, Object... msgArgs) {
        if (msgArgs.length > 0) {
            return String.format(msg, msgArgs);
        }
        return msg;
    }

    /* access modifiers changed from: protected */
    public final String _truncate(String desc) {
        if (desc == null) {
            return "";
        }
        if (desc.length() <= 500) {
            return desc;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(desc.substring(0, 500));
        sb.append("]...[");
        sb.append(desc.substring(desc.length() - 500));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String _quotedString(String desc) {
        if (desc == null) {
            return "[N/A]";
        }
        return String.format("\"%s\"", new Object[]{_truncate(desc)});
    }

    /* access modifiers changed from: protected */
    public String _colonConcat(String msgBase, String extra) {
        if (extra == null) {
            return msgBase;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(msgBase);
        sb.append(": ");
        sb.append(extra);
        return sb.toString();
    }
}
