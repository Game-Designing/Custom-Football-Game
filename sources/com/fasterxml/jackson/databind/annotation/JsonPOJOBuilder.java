package com.fasterxml.jackson.databind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPOJOBuilder {

    public static class Value {
        public final String buildMethodName;
        public final String withPrefix;

        public Value(JsonPOJOBuilder ann) {
            this(ann.buildMethodName(), ann.withPrefix());
        }

        public Value(String buildMethodName2, String withPrefix2) {
            this.buildMethodName = buildMethodName2;
            this.withPrefix = withPrefix2;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
