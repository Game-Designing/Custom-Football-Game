package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class JsonMappingException extends JsonProcessingException {
    protected LinkedList<Reference> _path;
    protected transient Closeable _processor;

    public static class Reference implements Serializable {
        protected String _desc;
        protected String _fieldName;
        protected transient Object _from;
        protected int _index = -1;

        protected Reference() {
        }

        public Reference(Object from, String fieldName) {
            this._from = from;
            if (fieldName != null) {
                this._fieldName = fieldName;
                return;
            }
            throw new NullPointerException("Cannot pass null fieldName");
        }

        public Reference(Object from, int index) {
            this._from = from;
            this._index = index;
        }

        public String getDescription() {
            if (this._desc == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this._from;
                if (obj != null) {
                    Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
                    int arrays = 0;
                    while (cls.isArray()) {
                        cls = cls.getComponentType();
                        arrays++;
                    }
                    sb.append(cls.getName());
                    while (true) {
                        arrays--;
                        if (arrays < 0) {
                            break;
                        }
                        sb.append("[]");
                    }
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append('[');
                if (this._fieldName != null) {
                    sb.append('\"');
                    sb.append(this._fieldName);
                    sb.append('\"');
                } else {
                    int i = this._index;
                    if (i >= 0) {
                        sb.append(i);
                    } else {
                        sb.append('?');
                    }
                }
                sb.append(']');
                this._desc = sb.toString();
            }
            return this._desc;
        }

        public String toString() {
            return getDescription();
        }

        /* access modifiers changed from: 0000 */
        public Object writeReplace() {
            getDescription();
            return this;
        }
    }

    public JsonMappingException(Closeable processor, String msg) {
        super(msg);
        this._processor = processor;
        if (processor instanceof JsonParser) {
            this._location = ((JsonParser) processor).getTokenLocation();
        }
    }

    public JsonMappingException(Closeable processor, String msg, Throwable problem) {
        super(msg, problem);
        this._processor = processor;
        if (processor instanceof JsonParser) {
            this._location = ((JsonParser) processor).getTokenLocation();
        }
    }

    public JsonMappingException(Closeable processor, String msg, JsonLocation loc) {
        super(msg, loc);
        this._processor = processor;
    }

    public static JsonMappingException from(JsonParser p, String msg) {
        return new JsonMappingException(p, msg);
    }

    public static JsonMappingException from(JsonParser p, String msg, Throwable problem) {
        return new JsonMappingException((Closeable) p, msg, problem);
    }

    public static JsonMappingException from(JsonGenerator g, String msg) {
        return new JsonMappingException((Closeable) g, msg, (Throwable) null);
    }

    public static JsonMappingException from(JsonGenerator g, String msg, Throwable problem) {
        return new JsonMappingException((Closeable) g, msg, problem);
    }

    public static JsonMappingException from(DeserializationContext ctxt, String msg) {
        return new JsonMappingException(ctxt.getParser(), msg);
    }

    public static JsonMappingException from(DeserializationContext ctxt, String msg, Throwable t) {
        return new JsonMappingException((Closeable) ctxt.getParser(), msg, t);
    }

    public static JsonMappingException fromUnexpectedIOE(IOException src) {
        return new JsonMappingException(null, String.format("Unexpected IOException (of type %s): %s", new Object[]{src.getClass().getName(), src.getMessage()}));
    }

    public static JsonMappingException wrapWithPath(Throwable src, Object refFrom, String refFieldName) {
        return wrapWithPath(src, new Reference(refFrom, refFieldName));
    }

    public static JsonMappingException wrapWithPath(Throwable src, Object refFrom, int index) {
        return wrapWithPath(src, new Reference(refFrom, index));
    }

    public static JsonMappingException wrapWithPath(Throwable src, Reference ref) {
        JsonMappingException jme;
        if (src instanceof JsonMappingException) {
            jme = (JsonMappingException) src;
        } else {
            String msg = src.getMessage();
            if (msg == null || msg.length() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("(was ");
                sb.append(src.getClass().getName());
                sb.append(")");
                msg = sb.toString();
            }
            Closeable proc = null;
            if (src instanceof JsonProcessingException) {
                Object proc0 = ((JsonProcessingException) src).getProcessor();
                if (proc0 instanceof Closeable) {
                    proc = (Closeable) proc0;
                }
            }
            jme = new JsonMappingException(proc, msg, src);
        }
        jme.prependPath(ref);
        return jme;
    }

    public StringBuilder getPathReference(StringBuilder sb) {
        _appendPathDesc(sb);
        return sb;
    }

    public void prependPath(Object referrer, String fieldName) {
        prependPath(new Reference(referrer, fieldName));
    }

    public void prependPath(Reference r) {
        if (this._path == null) {
            this._path = new LinkedList<>();
        }
        if (this._path.size() < 1000) {
            this._path.addFirst(r);
        }
    }

    @JsonIgnore
    public Object getProcessor() {
        return this._processor;
    }

    public String getLocalizedMessage() {
        return _buildMessage();
    }

    public String getMessage() {
        return _buildMessage();
    }

    /* access modifiers changed from: protected */
    public String _buildMessage() {
        String msg = super.getMessage();
        if (this._path == null) {
            return msg;
        }
        StringBuilder sb = msg == null ? new StringBuilder() : new StringBuilder(msg);
        sb.append(" (through reference chain: ");
        StringBuilder sb2 = getPathReference(sb);
        sb2.append(')');
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(": ");
        sb.append(getMessage());
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void _appendPathDesc(StringBuilder sb) {
        LinkedList<Reference> linkedList = this._path;
        if (linkedList != null) {
            Iterator<Reference> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(((Reference) it.next()).toString());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
    }
}
