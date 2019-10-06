package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators$PropertyGenerator {
    protected final BeanPropertyWriter _property;

    public PropertyBasedObjectIdGenerator(ObjectIdInfo oid, BeanPropertyWriter prop) {
        this(oid.getScope(), prop);
    }

    protected PropertyBasedObjectIdGenerator(Class<?> scope, BeanPropertyWriter prop) {
        super(scope);
        this._property = prop;
    }

    public boolean canUseFor(ObjectIdGenerator<?> gen) {
        boolean z = false;
        if (gen.getClass() == getClass()) {
            PropertyBasedObjectIdGenerator other = (PropertyBasedObjectIdGenerator) gen;
            if (other.getScope() == this._scope) {
                if (other._property == this._property) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    public Object generateId(Object forPojo) {
        try {
            return this._property.get(forPojo);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Problem accessing property '");
            sb.append(this._property.getName());
            sb.append("': ");
            sb.append(e2.getMessage());
            throw new IllegalStateException(sb.toString(), e2);
        }
    }

    public ObjectIdGenerator<Object> forScope(Class<?> scope) {
        return scope == this._scope ? this : new PropertyBasedObjectIdGenerator(scope, this._property);
    }

    public ObjectIdGenerator<Object> newForSerialization(Object context) {
        return this;
    }

    public IdKey key(Object key) {
        if (key == null) {
            return null;
        }
        return new IdKey(getClass(), this._scope, key);
    }
}
