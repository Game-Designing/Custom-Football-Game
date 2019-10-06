package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence extends JsonParserDelegate {
    protected final boolean _checkForExistingToken;
    protected boolean _hasToken;
    protected int _nextParserIndex;
    protected final JsonParser[] _parsers;

    protected JsonParserSequence(boolean checkForExistingToken, JsonParser[] parsers) {
        boolean z = false;
        super(parsers[0]);
        this._checkForExistingToken = checkForExistingToken;
        if (checkForExistingToken && this.delegate.hasCurrentToken()) {
            z = true;
        }
        this._hasToken = z;
        this._parsers = parsers;
        this._nextParserIndex = 1;
    }

    public static JsonParserSequence createFlattened(boolean checkForExistingToken, JsonParser first, JsonParser second) {
        if ((first instanceof JsonParserSequence) || (second instanceof JsonParserSequence)) {
            ArrayList<JsonParser> p = new ArrayList<>();
            if (first instanceof JsonParserSequence) {
                ((JsonParserSequence) first).addFlattenedActiveParsers(p);
            } else {
                p.add(first);
            }
            if (second instanceof JsonParserSequence) {
                ((JsonParserSequence) second).addFlattenedActiveParsers(p);
            } else {
                p.add(second);
            }
            return new JsonParserSequence(checkForExistingToken, (JsonParser[]) p.toArray(new JsonParser[p.size()]));
        }
        return new JsonParserSequence(checkForExistingToken, new JsonParser[]{first, second});
    }

    /* access modifiers changed from: protected */
    public void addFlattenedActiveParsers(List<JsonParser> listToAddIn) {
        int len = this._parsers.length;
        for (int i = this._nextParserIndex - 1; i < len; i++) {
            JsonParser p = this._parsers[i];
            if (p instanceof JsonParserSequence) {
                ((JsonParserSequence) p).addFlattenedActiveParsers(listToAddIn);
            } else {
                listToAddIn.add(p);
            }
        }
    }

    public void close() throws IOException {
        do {
            this.delegate.close();
        } while (switchToNext());
    }

    public JsonToken nextToken() throws IOException {
        JsonParser jsonParser = this.delegate;
        if (jsonParser == null) {
            return null;
        }
        if (this._hasToken) {
            this._hasToken = false;
            return jsonParser.currentToken();
        }
        JsonToken t = jsonParser.nextToken();
        if (t == null) {
            return switchAndReturnNext();
        }
        return t;
    }

    public JsonParser skipChildren() throws IOException {
        if (this.delegate.currentToken() != JsonToken.START_OBJECT && this.delegate.currentToken() != JsonToken.START_ARRAY) {
            return this;
        }
        int open = 1;
        while (true) {
            JsonToken t = nextToken();
            if (t == null) {
                return this;
            }
            if (t.isStructStart()) {
                open++;
            } else if (t.isStructEnd()) {
                open--;
                if (open == 0) {
                    return this;
                }
            } else {
                continue;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean switchToNext() {
        int i = this._nextParserIndex;
        JsonParser[] jsonParserArr = this._parsers;
        if (i >= jsonParserArr.length) {
            return false;
        }
        this._nextParserIndex = i + 1;
        this.delegate = jsonParserArr[i];
        return true;
    }

    /* access modifiers changed from: protected */
    public JsonToken switchAndReturnNext() throws IOException {
        JsonToken t;
        do {
            int i = this._nextParserIndex;
            JsonParser[] jsonParserArr = this._parsers;
            if (i >= jsonParserArr.length) {
                return null;
            }
            this._nextParserIndex = i + 1;
            this.delegate = jsonParserArr[i];
            if (this._checkForExistingToken && this.delegate.hasCurrentToken()) {
                return this.delegate.getCurrentToken();
            }
            t = this.delegate.nextToken();
        } while (t == null);
        return t;
    }
}
