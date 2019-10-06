package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ReadableObjectId {
    protected Object _item;
    protected final IdKey _key;
    protected LinkedList<Referring> _referringProperties;
    protected ObjectIdResolver _resolver;

    public static abstract class Referring {
        private final Class<?> _beanType;
        private final UnresolvedForwardReference _reference;

        public abstract void handleResolvedForwardReference(Object obj, Object obj2) throws IOException;

        public Referring(UnresolvedForwardReference ref, Class<?> beanType) {
            this._reference = ref;
            this._beanType = beanType;
        }

        public Referring(UnresolvedForwardReference ref, JavaType beanType) {
            this._reference = ref;
            this._beanType = beanType.getRawClass();
        }

        public JsonLocation getLocation() {
            return this._reference.getLocation();
        }

        public Class<?> getBeanType() {
            return this._beanType;
        }

        public boolean hasId(Object id) {
            return id.equals(this._reference.getUnresolvedId());
        }
    }

    public ReadableObjectId(IdKey key) {
        this._key = key;
    }

    public void setResolver(ObjectIdResolver resolver) {
        this._resolver = resolver;
    }

    public IdKey getKey() {
        return this._key;
    }

    public void appendReferring(Referring currentReferring) {
        if (this._referringProperties == null) {
            this._referringProperties = new LinkedList<>();
        }
        this._referringProperties.add(currentReferring);
    }

    public void bindItem(Object ob) throws IOException {
        this._resolver.bindItem(this._key, ob);
        this._item = ob;
        Object id = this._key.key;
        LinkedList<Referring> linkedList = this._referringProperties;
        if (linkedList != null) {
            Iterator<Referring> it = linkedList.iterator();
            this._referringProperties = null;
            while (it.hasNext()) {
                ((Referring) it.next()).handleResolvedForwardReference(id, ob);
            }
        }
    }

    public Object resolve() {
        Object resolveId = this._resolver.resolveId(this._key);
        this._item = resolveId;
        return resolveId;
    }

    public boolean hasReferringProperties() {
        LinkedList<Referring> linkedList = this._referringProperties;
        return linkedList != null && !linkedList.isEmpty();
    }

    public Iterator<Referring> referringProperties() {
        LinkedList<Referring> linkedList = this._referringProperties;
        if (linkedList == null) {
            return Collections.emptyList().iterator();
        }
        return linkedList.iterator();
    }

    public boolean tryToResolveUnresolved(DeserializationContext ctxt) {
        return false;
    }

    public String toString() {
        return String.valueOf(this._key);
    }
}
