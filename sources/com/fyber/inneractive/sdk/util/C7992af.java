package com.fyber.inneractive.sdk.util;

import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;

/* renamed from: com.fyber.inneractive.sdk.util.af */
public final class C7992af implements FieldNamingStrategy {

    /* renamed from: a */
    Class f16315a;

    /* renamed from: b */
    String f16316b;

    /* renamed from: c */
    String f16317c;

    public C7992af(Class cls, String str, String str2) {
        this.f16315a = cls;
        this.f16316b = str;
        this.f16317c = str2;
    }

    public final String translateName(Field field) {
        if (!field.getType().equals(this.f16315a) || !field.getName().equals(this.f16316b)) {
            return field.getName();
        }
        return this.f16317c;
    }
}
