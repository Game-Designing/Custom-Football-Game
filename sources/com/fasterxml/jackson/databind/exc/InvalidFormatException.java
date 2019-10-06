package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonParser;

public class InvalidFormatException extends MismatchedInputException {
    protected final Object _value;

    public InvalidFormatException(JsonParser p, String msg, Object value, Class<?> targetType) {
        super(p, msg, targetType);
        this._value = value;
    }

    public static InvalidFormatException from(JsonParser p, String msg, Object value, Class<?> targetType) {
        return new InvalidFormatException(p, msg, value, targetType);
    }
}
