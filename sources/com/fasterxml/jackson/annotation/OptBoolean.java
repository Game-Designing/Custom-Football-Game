package com.fasterxml.jackson.annotation;

public enum OptBoolean {
    TRUE,
    FALSE,
    DEFAULT;

    public Boolean asBoolean() {
        if (this == DEFAULT) {
            return null;
        }
        return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean equals(Boolean b1, Boolean b2) {
        if (b1 != null) {
            return b1.equals(b2);
        }
        return b2 == null;
    }
}
