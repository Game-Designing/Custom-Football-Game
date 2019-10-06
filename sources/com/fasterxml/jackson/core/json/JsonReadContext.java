package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;

public final class JsonReadContext extends JsonStreamContext {
    protected JsonReadContext _child;
    protected int _columnNr;
    protected String _currentName;
    protected Object _currentValue;
    protected DupDetector _dups;
    protected int _lineNr;
    protected final JsonReadContext _parent;

    public JsonReadContext(JsonReadContext parent, DupDetector dups, int type, int lineNr, int colNr) {
        this._parent = parent;
        this._dups = dups;
        this._type = type;
        this._lineNr = lineNr;
        this._columnNr = colNr;
    }

    /* access modifiers changed from: protected */
    public void reset(int type, int lineNr, int colNr) {
        this._type = type;
        this._index = -1;
        this._lineNr = lineNr;
        this._columnNr = colNr;
        this._currentName = null;
        this._currentValue = null;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            dupDetector.reset();
        }
    }

    public JsonReadContext withDupDetector(DupDetector dups) {
        this._dups = dups;
        return this;
    }

    public Object getCurrentValue() {
        return this._currentValue;
    }

    public void setCurrentValue(Object v) {
        this._currentValue = v;
    }

    public static JsonReadContext createRootContext(DupDetector dups) {
        JsonReadContext jsonReadContext = new JsonReadContext(null, dups, 0, 1, 0);
        return jsonReadContext;
    }

    public JsonReadContext createChildArrayContext(int lineNr, int colNr) {
        JsonReadContext ctxt = this._child;
        if (ctxt == null) {
            DupDetector dupDetector = this._dups;
            JsonReadContext jsonReadContext = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 1, lineNr, colNr);
            JsonReadContext ctxt2 = jsonReadContext;
            this._child = jsonReadContext;
            return ctxt2;
        }
        ctxt.reset(1, lineNr, colNr);
        return ctxt;
    }

    public JsonReadContext createChildObjectContext(int lineNr, int colNr) {
        JsonReadContext ctxt = this._child;
        if (ctxt == null) {
            DupDetector dupDetector = this._dups;
            JsonReadContext jsonReadContext = new JsonReadContext(this, dupDetector == null ? null : dupDetector.child(), 2, lineNr, colNr);
            JsonReadContext ctxt2 = jsonReadContext;
            this._child = jsonReadContext;
            return ctxt2;
        }
        ctxt.reset(2, lineNr, colNr);
        return ctxt;
    }

    public String getCurrentName() {
        return this._currentName;
    }

    public JsonReadContext getParent() {
        return this._parent;
    }

    public JsonLocation getStartLocation(Object srcRef) {
        JsonLocation jsonLocation = new JsonLocation(srcRef, -1, this._lineNr, this._columnNr);
        return jsonLocation;
    }

    public JsonReadContext clearAndGetParent() {
        this._currentValue = null;
        return this._parent;
    }

    public DupDetector getDupDetector() {
        return this._dups;
    }

    public boolean expectComma() {
        int ix = this._index + 1;
        this._index = ix;
        if (this._type == 0 || ix <= 0) {
            return false;
        }
        return true;
    }

    public void setCurrentName(String name) throws JsonProcessingException {
        this._currentName = name;
        DupDetector dupDetector = this._dups;
        if (dupDetector != null) {
            _checkDup(dupDetector, name);
        }
    }

    private void _checkDup(DupDetector dd, String name) throws JsonProcessingException {
        if (dd.isDup(name)) {
            Object src = dd.getSource();
            JsonParser jsonParser = src instanceof JsonParser ? (JsonParser) src : null;
            StringBuilder sb = new StringBuilder();
            sb.append("Duplicate field '");
            sb.append(name);
            sb.append("'");
            throw new JsonParseException(jsonParser, sb.toString());
        }
    }
}
