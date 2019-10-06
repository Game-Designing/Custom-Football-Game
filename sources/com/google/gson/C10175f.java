package com.google.gson;

import java.lang.reflect.Field;

/* 'enum' access flag removed */
/* renamed from: com.google.gson.f */
/* compiled from: FieldNamingPolicy */
class C10175f extends C10178i {
    C10175f(String str, int i) {
        super(str, i, null);
    }

    public String translateName(Field f) {
        return C10178i.m33125a(C10178i.m33126a(f.getName(), " "));
    }
}
