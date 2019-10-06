package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.RawValue;
import java.io.IOException;

/* compiled from: JsonNodeDeserializer */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> {
    protected final Boolean _supportsUpdates;

    public BaseNodeDeserializer(Class<T> vc, Boolean supportsUpdates) {
        super(vc);
        this._supportsUpdates = supportsUpdates;
    }

    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromAny(p, ctxt);
    }

    public boolean isCachable() {
        return true;
    }

    public Boolean supportsUpdate(DeserializationConfig config) {
        return this._supportsUpdates;
    }

    /* access modifiers changed from: protected */
    public void _handleDuplicateField(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory, String fieldName, ObjectNode objectNode, JsonNode oldValue, JsonNode newValue) throws JsonProcessingException {
        if (ctxt.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            ctxt.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled", fieldName);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final ObjectNode deserializeObject(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonToken t;
        JsonNode value;
        JsonNodeFactory jsonNodeFactory = nodeFactory;
        ObjectNode node = nodeFactory.objectNode();
        JsonNode jsonNode = null;
        String key = p.nextFieldName();
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (t2 == null) {
                t = JsonToken.NOT_AVAILABLE;
            } else {
                t = t2;
            }
            int id = t.mo20316id();
            if (id == 1) {
                value = deserializeObject(p, ctxt, nodeFactory);
            } else if (id == 3) {
                JsonNode value2 = jsonNode;
                value = deserializeArray(p, ctxt, nodeFactory);
            } else if (id == 6) {
                JsonNode value3 = jsonNode;
                value = jsonNodeFactory.textNode(p.getText());
            } else if (id != 7) {
                switch (id) {
                    case 9:
                        JsonNode value4 = jsonNode;
                        value = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        JsonNode value5 = jsonNode;
                        value = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        JsonNode value6 = jsonNode;
                        value = nodeFactory.nullNode();
                        break;
                    case 12:
                        JsonNode value7 = jsonNode;
                        value = _fromEmbedded(p, ctxt, nodeFactory);
                        break;
                    default:
                        JsonNode jsonNode2 = jsonNode;
                        value = deserializeAny(p, ctxt, nodeFactory);
                        break;
                }
            } else {
                JsonNode value8 = jsonNode;
                value = _fromInt(p, ctxt, nodeFactory);
            }
            JsonNode old = node.replace(key, value);
            if (old != null) {
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            }
            key = p.nextFieldName();
            jsonNode = value;
        }
        return node;
    }

    /* access modifiers changed from: protected */
    public final ObjectNode deserializeObjectAtName(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        JsonToken t;
        JsonNode value;
        JsonNodeFactory jsonNodeFactory = nodeFactory;
        ObjectNode node = nodeFactory.objectNode();
        JsonNode jsonNode = null;
        String key = p.getCurrentName();
        while (key != null) {
            JsonToken t2 = p.nextToken();
            if (t2 == null) {
                t = JsonToken.NOT_AVAILABLE;
            } else {
                t = t2;
            }
            int id = t.mo20316id();
            if (id == 1) {
                value = deserializeObject(p, ctxt, nodeFactory);
            } else if (id == 3) {
                JsonNode value2 = jsonNode;
                value = deserializeArray(p, ctxt, nodeFactory);
            } else if (id == 6) {
                JsonNode value3 = jsonNode;
                value = jsonNodeFactory.textNode(p.getText());
            } else if (id != 7) {
                switch (id) {
                    case 9:
                        JsonNode value4 = jsonNode;
                        value = jsonNodeFactory.booleanNode(true);
                        break;
                    case 10:
                        JsonNode value5 = jsonNode;
                        value = jsonNodeFactory.booleanNode(false);
                        break;
                    case 11:
                        JsonNode value6 = jsonNode;
                        value = nodeFactory.nullNode();
                        break;
                    case 12:
                        JsonNode value7 = jsonNode;
                        value = _fromEmbedded(p, ctxt, nodeFactory);
                        break;
                    default:
                        JsonNode jsonNode2 = jsonNode;
                        value = deserializeAny(p, ctxt, nodeFactory);
                        break;
                }
            } else {
                JsonNode value8 = jsonNode;
                value = _fromInt(p, ctxt, nodeFactory);
            }
            JsonNode old = node.replace(key, value);
            if (old != null) {
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            }
            key = p.nextFieldName();
            jsonNode = value;
        }
        return node;
    }

    /* access modifiers changed from: protected */
    public final JsonNode updateObject(JsonParser p, DeserializationContext ctxt, ObjectNode node) throws IOException {
        String key;
        JsonToken t;
        JsonNode value;
        JsonNode value2;
        JsonParser jsonParser = p;
        DeserializationContext deserializationContext = ctxt;
        ObjectNode objectNode = node;
        JsonNode newValue = null;
        if (p.isExpectedStartObjectToken()) {
            key = p.nextFieldName();
        } else if (!jsonParser.hasToken(JsonToken.FIELD_NAME)) {
            return (JsonNode) deserialize(p, ctxt);
        } else {
            key = p.getCurrentName();
        }
        while (key != null) {
            JsonToken t2 = p.nextToken();
            JsonNode old = objectNode.get(key);
            if (old != null) {
                if (old instanceof ObjectNode) {
                    newValue = updateObject(jsonParser, deserializationContext, (ObjectNode) old);
                    if (newValue != old) {
                        objectNode.set(key, newValue);
                    }
                } else if (old instanceof ArrayNode) {
                    newValue = updateArray(jsonParser, deserializationContext, (ArrayNode) old);
                    if (newValue != old) {
                        objectNode.set(key, newValue);
                    }
                }
                key = p.nextFieldName();
            }
            if (t2 == null) {
                t = JsonToken.NOT_AVAILABLE;
            } else {
                t = t2;
            }
            JsonNodeFactory nodeFactory = ctxt.getNodeFactory();
            int id = t.mo20316id();
            if (id == 1) {
                value = deserializeObject(jsonParser, deserializationContext, nodeFactory);
            } else if (id == 3) {
                JsonNode value3 = newValue;
                value = deserializeArray(jsonParser, deserializationContext, nodeFactory);
            } else if (id == 6) {
                JsonNode value4 = newValue;
                value = nodeFactory.textNode(p.getText());
            } else if (id != 7) {
                switch (id) {
                    case 9:
                        JsonNode value5 = newValue;
                        value = nodeFactory.booleanNode(true);
                        break;
                    case 10:
                        JsonNode value6 = newValue;
                        value = nodeFactory.booleanNode(false);
                        break;
                    case 11:
                        JsonNode value7 = newValue;
                        value = nodeFactory.nullNode();
                        break;
                    case 12:
                        JsonNode value8 = newValue;
                        value = _fromEmbedded(jsonParser, deserializationContext, nodeFactory);
                        break;
                    default:
                        JsonNode jsonNode = newValue;
                        value = deserializeAny(jsonParser, deserializationContext, nodeFactory);
                        break;
                }
            } else {
                JsonNode value9 = newValue;
                value = _fromInt(jsonParser, deserializationContext, nodeFactory);
            }
            if (old != null) {
                value2 = value;
                _handleDuplicateField(p, ctxt, nodeFactory, key, node, old, value);
            } else {
                value2 = value;
            }
            JsonNode value10 = value2;
            objectNode.set(key, value10);
            newValue = value10;
            key = p.nextFieldName();
        }
        return objectNode;
    }

    /* access modifiers changed from: protected */
    public final ArrayNode deserializeArray(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        ArrayNode node = nodeFactory.arrayNode();
        while (true) {
            switch (p.nextToken().mo20316id()) {
                case 1:
                    node.add(deserializeObject(p, ctxt, nodeFactory));
                    break;
                case 3:
                    node.add(deserializeArray(p, ctxt, nodeFactory));
                    break;
                case 4:
                    return node;
                case 6:
                    node.add(nodeFactory.textNode(p.getText()));
                    break;
                case 7:
                    node.add(_fromInt(p, ctxt, nodeFactory));
                    break;
                case 9:
                    node.add(nodeFactory.booleanNode(true));
                    break;
                case 10:
                    node.add(nodeFactory.booleanNode(false));
                    break;
                case 11:
                    node.add(nodeFactory.nullNode());
                    break;
                case 12:
                    node.add(_fromEmbedded(p, ctxt, nodeFactory));
                    break;
                default:
                    node.add(deserializeAny(p, ctxt, nodeFactory));
                    break;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode updateArray(JsonParser p, DeserializationContext ctxt, ArrayNode node) throws IOException {
        JsonNodeFactory nodeFactory = ctxt.getNodeFactory();
        while (true) {
            switch (p.nextToken().mo20316id()) {
                case 1:
                    node.add(deserializeObject(p, ctxt, nodeFactory));
                    break;
                case 3:
                    node.add(deserializeArray(p, ctxt, nodeFactory));
                    break;
                case 4:
                    return node;
                case 6:
                    node.add(nodeFactory.textNode(p.getText()));
                    break;
                case 7:
                    node.add(_fromInt(p, ctxt, nodeFactory));
                    break;
                case 9:
                    node.add(nodeFactory.booleanNode(true));
                    break;
                case 10:
                    node.add(nodeFactory.booleanNode(false));
                    break;
                case 11:
                    node.add(nodeFactory.nullNode());
                    break;
                case 12:
                    node.add(_fromEmbedded(p, ctxt, nodeFactory));
                    break;
                default:
                    node.add(deserializeAny(p, ctxt, nodeFactory));
                    break;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode deserializeAny(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        int currentTokenId = p.getCurrentTokenId();
        if (currentTokenId == 2) {
            return nodeFactory.objectNode();
        }
        switch (currentTokenId) {
            case 5:
                return deserializeObjectAtName(p, ctxt, nodeFactory);
            case 6:
                return nodeFactory.textNode(p.getText());
            case 7:
                return _fromInt(p, ctxt, nodeFactory);
            case 8:
                return _fromFloat(p, ctxt, nodeFactory);
            case 9:
                return nodeFactory.booleanNode(true);
            case 10:
                return nodeFactory.booleanNode(false);
            case 11:
                return nodeFactory.nullNode();
            case 12:
                return _fromEmbedded(p, ctxt, nodeFactory);
            default:
                return (JsonNode) ctxt.handleUnexpectedToken(handledType(), p);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromInt(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        NumberType nt;
        int feats = ctxt.getDeserializationFeatures();
        if ((StdDeserializer.F_MASK_INT_COERCIONS & feats) == 0) {
            nt = p.getNumberType();
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(feats)) {
            nt = NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(feats)) {
            nt = NumberType.LONG;
        } else {
            nt = p.getNumberType();
        }
        if (nt == NumberType.INT) {
            return nodeFactory.numberNode(p.getIntValue());
        }
        if (nt == NumberType.LONG) {
            return nodeFactory.numberNode(p.getLongValue());
        }
        return nodeFactory.numberNode(p.getBigIntegerValue());
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromFloat(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        NumberType nt = p.getNumberType();
        if (nt == NumberType.BIG_DECIMAL) {
            return nodeFactory.numberNode(p.getDecimalValue());
        }
        if (ctxt.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (p.isNaN()) {
                return nodeFactory.numberNode(p.getDoubleValue());
            }
            return nodeFactory.numberNode(p.getDecimalValue());
        } else if (nt == NumberType.FLOAT) {
            return nodeFactory.numberNode(p.getFloatValue());
        } else {
            return nodeFactory.numberNode(p.getDoubleValue());
        }
    }

    /* access modifiers changed from: protected */
    public final JsonNode _fromEmbedded(JsonParser p, DeserializationContext ctxt, JsonNodeFactory nodeFactory) throws IOException {
        Object ob = p.getEmbeddedObject();
        if (ob == null) {
            return nodeFactory.nullNode();
        }
        if (ob.getClass() == byte[].class) {
            return nodeFactory.binaryNode((byte[]) ob);
        }
        if (ob instanceof RawValue) {
            return nodeFactory.rawValueNode((RawValue) ob);
        }
        if (ob instanceof JsonNode) {
            return (JsonNode) ob;
        }
        return nodeFactory.pojoNode(ob);
    }
}
