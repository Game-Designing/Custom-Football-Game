package com.google.gson;

import java.lang.reflect.Field;

/* 'enum' access flag removed */
/* renamed from: com.google.gson.e */
/* compiled from: FieldNamingPolicy */
class C10174e extends C10178i {
    C10174e(String str, int i) {
        super(str, i, null);
    }

    public String translateName(Field f) {
        return C10178i.m33125a(f.getName());
    }
}
