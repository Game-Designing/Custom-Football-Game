package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public class TokenFilter {
    public static final TokenFilter INCLUDE_ALL = new TokenFilter();

    protected TokenFilter() {
    }

    public TokenFilter filterStartObject() {
        return this;
    }

    public TokenFilter filterStartArray() {
        return this;
    }

    public void filterFinishArray() {
    }

    public TokenFilter includeProperty(String name) {
        return this;
    }

    public TokenFilter includeElement(int index) {
        return this;
    }

    public TokenFilter includeRootValue(int index) {
        return this;
    }

    public boolean includeValue(JsonParser p) throws IOException {
        return _includeScalar();
    }

    public String toString() {
        if (this == INCLUDE_ALL) {
            return "TokenFilter.INCLUDE_ALL";
        }
        return super.toString();
    }

    /* access modifiers changed from: protected */
    public boolean _includeScalar() {
        return true;
    }
}
