package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo.C0078As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.core.type.WritableTypeId.Inclusion;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.BeanProperty;
import java.io.IOException;

public abstract class TypeSerializer {

    /* renamed from: com.fasterxml.jackson.databind.jsontype.TypeSerializer$1 */
    static /* synthetic */ class C00821 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As = new int[C0078As.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.EXISTING_PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.EXTERNAL_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.WRAPPER_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[C0078As.WRAPPER_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public abstract TypeSerializer forProperty(BeanProperty beanProperty);

    public abstract String getPropertyName();

    public abstract C0078As getTypeInclusion();

    public abstract WritableTypeId writeTypePrefix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;

    public abstract WritableTypeId writeTypeSuffix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException;

    public WritableTypeId typeId(Object value, JsonToken valueShape) {
        WritableTypeId typeIdDef = new WritableTypeId(value, valueShape);
        int i = C00821.$SwitchMap$com$fasterxml$jackson$annotation$JsonTypeInfo$As[getTypeInclusion().ordinal()];
        if (i == 1) {
            typeIdDef.include = Inclusion.PAYLOAD_PROPERTY;
            typeIdDef.asProperty = getPropertyName();
        } else if (i == 2) {
            typeIdDef.include = Inclusion.PARENT_PROPERTY;
            typeIdDef.asProperty = getPropertyName();
        } else if (i == 3) {
            typeIdDef.include = Inclusion.METADATA_PROPERTY;
            typeIdDef.asProperty = getPropertyName();
        } else if (i == 4) {
            typeIdDef.include = Inclusion.WRAPPER_ARRAY;
        } else if (i == 5) {
            typeIdDef.include = Inclusion.WRAPPER_OBJECT;
        } else {
            VersionUtil.throwInternal();
            throw null;
        }
        return typeIdDef;
    }

    public WritableTypeId typeId(Object value, JsonToken valueShape, Object id) {
        WritableTypeId typeId = typeId(value, valueShape);
        typeId.f12553id = id;
        return typeId;
    }

    public WritableTypeId typeId(Object value, Class<?> typeForId, JsonToken valueShape) {
        WritableTypeId typeId = typeId(value, valueShape);
        typeId.forValueType = typeForId;
        return typeId;
    }
}
