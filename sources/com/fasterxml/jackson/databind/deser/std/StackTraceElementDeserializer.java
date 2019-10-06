package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;

public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    public StackTraceElementDeserializer() {
        super(StackTraceElement.class);
    }

    public StackTraceElement deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonParser jsonParser = p;
        DeserializationContext deserializationContext = ctxt;
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            String className = "";
            String methodName = "";
            String fileName = "";
            String moduleName = null;
            String moduleVersion = null;
            String classLoaderName = null;
            int lineNumber = -1;
            while (true) {
                JsonToken nextValue = p.nextValue();
                JsonToken t2 = nextValue;
                if (nextValue == JsonToken.END_OBJECT) {
                    return constructValue(ctxt, className, methodName, fileName, lineNumber, moduleName, moduleVersion, classLoaderName);
                }
                String propName = p.getCurrentName();
                if ("className".equals(propName)) {
                    className = p.getText();
                } else if ("classLoaderName".equals(propName)) {
                    classLoaderName = p.getText();
                } else if ("fileName".equals(propName)) {
                    fileName = p.getText();
                } else if ("lineNumber".equals(propName)) {
                    if (t2.isNumeric()) {
                        lineNumber = p.getIntValue();
                    } else {
                        lineNumber = _parseIntPrimitive(p, ctxt);
                    }
                } else if ("methodName".equals(propName)) {
                    methodName = p.getText();
                } else if (!"nativeMethod".equals(propName)) {
                    if ("moduleName".equals(propName)) {
                        moduleName = p.getText();
                    } else if ("moduleVersion".equals(propName)) {
                        moduleVersion = p.getText();
                    } else if (!"declaringClass".equals(propName)) {
                        handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, propName);
                    }
                }
                p.skipChildren();
                JsonToken jsonToken = t2;
            }
        } else if (t != JsonToken.START_ARRAY || !deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            return (StackTraceElement) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        } else {
            p.nextToken();
            StackTraceElement value = deserialize(p, ctxt);
            if (p.nextToken() == JsonToken.END_ARRAY) {
                return value;
            }
            handleMissingEndArrayForSingle(p, ctxt);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public StackTraceElement constructValue(DeserializationContext ctxt, String className, String methodName, String fileName, int lineNumber, String moduleName, String moduleVersion, String classLoaderName) {
        return new StackTraceElement(className, methodName, fileName, lineNumber);
    }
}
