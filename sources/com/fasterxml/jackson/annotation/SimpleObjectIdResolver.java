package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import java.util.HashMap;
import java.util.Map;

public class SimpleObjectIdResolver implements ObjectIdResolver {
    protected Map<IdKey, Object> _items;

    public void bindItem(IdKey id, Object ob) {
        Map<IdKey, Object> map = this._items;
        if (map == null) {
            this._items = new HashMap();
        } else if (map.containsKey(id)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Already had POJO for id (");
            sb.append(id.key.getClass().getName());
            sb.append(") [");
            sb.append(id);
            sb.append("]");
            throw new IllegalStateException(sb.toString());
        }
        this._items.put(id, ob);
    }

    public Object resolveId(IdKey id) {
        Map<IdKey, Object> map = this._items;
        if (map == null) {
            return null;
        }
        return map.get(id);
    }

    public boolean canUseFor(ObjectIdResolver resolverType) {
        return resolverType.getClass() == getClass();
    }

    public ObjectIdResolver newForDeserialization(Object context) {
        return new SimpleObjectIdResolver();
    }
}
