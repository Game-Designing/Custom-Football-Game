package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TypeParser implements Serializable {
    protected final TypeFactory _factory;

    static final class MyTokenizer extends StringTokenizer {
        protected int _index;
        protected final String _input;
        protected String _pushbackToken;

        public MyTokenizer(String str) {
            super(str, "<,>", true);
            this._input = str;
        }

        public boolean hasMoreTokens() {
            return this._pushbackToken != null || super.hasMoreTokens();
        }

        public String nextToken() {
            if (this._pushbackToken != null) {
                String token = this._pushbackToken;
                this._pushbackToken = null;
                return token;
            }
            String token2 = super.nextToken();
            this._index += token2.length();
            return token2.trim();
        }

        public void pushBack(String token) {
            this._pushbackToken = token;
        }

        public String getAllInput() {
            return this._input;
        }

        public String getRemainingInput() {
            return this._input.substring(this._index);
        }
    }

    public TypeParser(TypeFactory f) {
        this._factory = f;
    }

    public JavaType parse(String canonical) throws IllegalArgumentException {
        MyTokenizer tokens = new MyTokenizer(canonical.trim());
        JavaType type = parseType(tokens);
        if (!tokens.hasMoreTokens()) {
            return type;
        }
        throw _problem(tokens, "Unexpected tokens after complete type");
    }

    /* access modifiers changed from: protected */
    public JavaType parseType(MyTokenizer tokens) throws IllegalArgumentException {
        if (tokens.hasMoreTokens()) {
            Class<?> base = findClass(tokens.nextToken(), tokens);
            if (tokens.hasMoreTokens()) {
                String token = tokens.nextToken();
                if ("<".equals(token)) {
                    return this._factory._fromClass(null, base, TypeBindings.create(base, parseTypes(tokens)));
                }
                tokens.pushBack(token);
            }
            return this._factory._fromClass(null, base, null);
        }
        throw _problem(tokens, "Unexpected end-of-string");
    }

    /* access modifiers changed from: protected */
    public List<JavaType> parseTypes(MyTokenizer tokens) throws IllegalArgumentException {
        ArrayList<JavaType> types = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            types.add(parseType(tokens));
            if (!tokens.hasMoreTokens()) {
                break;
            }
            String token = tokens.nextToken();
            if (">".equals(token)) {
                return types;
            }
            if (!",".equals(token)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected token '");
                sb.append(token);
                sb.append("', expected ',' or '>')");
                throw _problem(tokens, sb.toString());
            }
        }
        throw _problem(tokens, "Unexpected end-of-string");
    }

    /* access modifiers changed from: protected */
    public Class<?> findClass(String className, MyTokenizer tokens) {
        try {
            return this._factory.findClass(className);
        } catch (Exception e) {
            ClassUtil.throwIfRTE(e);
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot locate class '");
            sb.append(className);
            sb.append("', problem: ");
            sb.append(e.getMessage());
            throw _problem(tokens, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public IllegalArgumentException _problem(MyTokenizer tokens, String msg) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", new Object[]{tokens.getAllInput(), tokens.getRemainingInput(), msg}));
    }
}
