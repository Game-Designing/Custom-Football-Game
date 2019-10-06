package com.google.gson;

import java.lang.reflect.Field;

/* 'enum' access flag removed */
/* renamed from: com.google.gson.d */
/* compiled from: FieldNamingPolicy */
class C10173d extends C10178i {
    C10173d(String str, int i) {
        super(str, i, null);
    }

    public String translateName(Field f) {
        return f.getName();
    }
}
