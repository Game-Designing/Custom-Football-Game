package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectNode extends ContainerNode<ObjectNode> {
    protected final Map<String, JsonNode> _children = new LinkedHashMap();

    public ObjectNode(JsonNodeFactory nc) {
        super(nc);
    }

    public boolean isEmpty(SerializerProvider serializers) {
        return this._children.isEmpty();
    }

    public int size() {
        return this._children.size();
    }

    public Iterator<JsonNode> elements() {
        return this._children.values().iterator();
    }

    public JsonNode get(String fieldName) {
        return (JsonNode) this._children.get(fieldName);
    }

    public void serialize(JsonGenerator g, SerializerProvider provider) throws IOException {
        boolean trimEmptyArray = provider != null && !provider.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        g.writeStartObject(this);
        for (Entry<String, JsonNode> en : this._children.entrySet()) {
            BaseJsonNode value = (BaseJsonNode) en.getValue();
            if (!trimEmptyArray || !value.isArray() || !value.isEmpty(provider)) {
                g.writeFieldName((String) en.getKey());
                value.serialize(g, provider);
            }
        }
        g.writeEndObject();
    }

    public void serializeWithType(JsonGenerator g, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        boolean trimEmptyArray = provider != null && !provider.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        WritableTypeId typeIdDef = typeSer.writeTypePrefix(g, typeSer.typeId(this, JsonToken.START_OBJECT));
        for (Entry<String, JsonNode> en : this._children.entrySet()) {
            BaseJsonNode value = (BaseJsonNode) en.getValue();
            if (!trimEmptyArray || !value.isArray() || !value.isEmpty(provider)) {
                g.writeFieldName((String) en.getKey());
                value.serialize(g, provider);
            }
        }
        typeSer.writeTypeSuffix(g, typeIdDef);
    }

    public JsonNode set(String fieldName, JsonNode value) {
        if (value == null) {
            value = nullNode();
        }
        this._children.put(fieldName, value);
        return this;
    }

    public JsonNode replace(String fieldName, JsonNode value) {
        if (value == null) {
            value = nullNode();
        }
        return (JsonNode) this._children.put(fieldName, value);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o != null && (o instanceof ObjectNode)) {
            return _childrenEqual((ObjectNode) o);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean _childrenEqual(ObjectNode other) {
        return this._children.equals(other._children);
    }

    public int hashCode() {
        return this._children.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() << 4) + 32);
        sb.append("{");
        int count = 0;
        for (Entry<String, JsonNode> en : this._children.entrySet()) {
            if (count > 0) {
                sb.append(",");
            }
            count++;
            TextNode.appendQuoted(sb, (String) en.getKey());
            sb.append(':');
            sb.append(((JsonNode) en.getValue()).toString());
        }
        sb.append("}");
        return sb.toString();
    }
}
