package com.google.gson.p016a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.google.gson.a.b */
/* compiled from: JsonAdapter */
public @interface C0088b {
    boolean nullSafe() default true;

    Class<?> value();
}
