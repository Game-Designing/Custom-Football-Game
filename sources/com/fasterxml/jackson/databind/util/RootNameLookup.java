package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;

public class RootNameLookup implements Serializable {
    protected transient LRUMap<ClassKey, PropertyName> _rootNames = new LRUMap<>(20, 200);

    public PropertyName findRootName(JavaType rootType, MapperConfig<?> config) {
        return findRootName(rootType.getRawClass(), config);
    }

    public PropertyName findRootName(Class<?> rootType, MapperConfig<?> config) {
        ClassKey key = new ClassKey(rootType);
        PropertyName name = (PropertyName) this._rootNames.get(key);
        if (name != null) {
            return name;
        }
        PropertyName name2 = config.getAnnotationIntrospector().findRootName(config.introspectClassAnnotations(rootType).getClassInfo());
        if (name2 == null || !name2.hasSimpleName()) {
            name2 = PropertyName.construct(rootType.getSimpleName());
        }
        this._rootNames.put(key, name2);
        return name2;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new RootNameLookup();
    }
}
