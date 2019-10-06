package com.google.gson.p016a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.google.gson.a.a */
/* compiled from: Expose */
public @interface C0087a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
