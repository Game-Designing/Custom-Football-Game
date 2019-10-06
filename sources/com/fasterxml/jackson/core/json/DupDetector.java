package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

public class DupDetector {
    protected String _firstName;
    protected String _secondName;
    protected HashSet<String> _seen;
    protected final Object _source;

    private DupDetector(Object src) {
        this._source = src;
    }

    public static DupDetector rootDetector(JsonParser p) {
        return new DupDetector(p);
    }

    public static DupDetector rootDetector(JsonGenerator g) {
        return new DupDetector(g);
    }

    public DupDetector child() {
        return new DupDetector(this._source);
    }

    public void reset() {
        this._firstName = null;
        this._secondName = null;
        this._seen = null;
    }

    public Object getSource() {
        return this._source;
    }

    public boolean isDup(String name) throws JsonParseException {
        String str = this._firstName;
        if (str == null) {
            this._firstName = name;
            return false;
        } else if (name.equals(str)) {
            return true;
        } else {
            String str2 = this._secondName;
            if (str2 == null) {
                this._secondName = name;
                return false;
            } else if (name.equals(str2)) {
                return true;
            } else {
                if (this._seen == null) {
                    this._seen = new HashSet<>(16);
                    this._seen.add(this._firstName);
                    this._seen.add(this._secondName);
                }
                return !this._seen.add(name);
            }
        }
    }
}
