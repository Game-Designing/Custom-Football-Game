package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import java.util.Collections;
import java.util.List;

public class BeanSerializerBuilder {
    private static final BeanPropertyWriter[] NO_PROPERTIES = new BeanPropertyWriter[0];
    protected AnyGetterWriter _anyGetter;
    protected final BeanDescription _beanDesc;
    protected SerializationConfig _config;
    protected Object _filterId;
    protected BeanPropertyWriter[] _filteredProperties;
    protected ObjectIdWriter _objectIdWriter;
    protected List<BeanPropertyWriter> _properties = Collections.emptyList();
    protected AnnotatedMember _typeId;

    public BeanSerializerBuilder(BeanDescription beanDesc) {
        this._beanDesc = beanDesc;
    }

    /* access modifiers changed from: protected */
    public void setConfig(SerializationConfig config) {
        this._config = config;
    }

    public void setProperties(List<BeanPropertyWriter> properties) {
        this._properties = properties;
    }

    public void setFilteredProperties(BeanPropertyWriter[] properties) {
        if (properties == null || properties.length == this._properties.size()) {
            this._filteredProperties = properties;
        } else {
            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", new Object[]{Integer.valueOf(properties.length), Integer.valueOf(this._properties.size())}));
        }
    }

    public void setAnyGetter(AnyGetterWriter anyGetter) {
        this._anyGetter = anyGetter;
    }

    public void setFilterId(Object filterId) {
        this._filterId = filterId;
    }

    public void setTypeId(AnnotatedMember idProp) {
        if (this._typeId == null) {
            this._typeId = idProp;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Multiple type ids specified with ");
        sb.append(this._typeId);
        sb.append(" and ");
        sb.append(idProp);
        throw new IllegalArgumentException(sb.toString());
    }

    public void setObjectIdWriter(ObjectIdWriter w) {
        this._objectIdWriter = w;
    }

    public BeanDescription getBeanDescription() {
        return this._beanDesc;
    }

    public List<BeanPropertyWriter> getProperties() {
        return this._properties;
    }

    public AnyGetterWriter getAnyGetter() {
        return this._anyGetter;
    }

    public Object getFilterId() {
        return this._filterId;
    }

    public AnnotatedMember getTypeId() {
        return this._typeId;
    }

    public ObjectIdWriter getObjectIdWriter() {
        return this._objectIdWriter;
    }

    public JsonSerializer<?> build() {
        BeanPropertyWriter[] properties;
        List<BeanPropertyWriter> list = this._properties;
        if (list != null && !list.isEmpty()) {
            List<BeanPropertyWriter> list2 = this._properties;
            properties = (BeanPropertyWriter[]) list2.toArray(new BeanPropertyWriter[list2.size()]);
            if (this._config.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (BeanPropertyWriter fixAccess : properties) {
                    fixAccess.fixAccess(this._config);
                }
            }
        } else if (this._anyGetter == null && this._objectIdWriter == null) {
            return null;
        } else {
            properties = NO_PROPERTIES;
        }
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProperties;
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == this._properties.size()) {
            AnyGetterWriter anyGetterWriter = this._anyGetter;
            if (anyGetterWriter != null) {
                anyGetterWriter.fixAccess(this._config);
            }
            if (this._typeId != null && this._config.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                this._typeId.fixAccess(this._config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new BeanSerializer(this._beanDesc.getType(), this, properties, this._filteredProperties);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", new Object[]{Integer.valueOf(this._properties.size()), Integer.valueOf(this._filteredProperties.length)}));
    }

    public BeanSerializer createDummy() {
        return BeanSerializer.createDummy(this._beanDesc.getType());
    }
}
