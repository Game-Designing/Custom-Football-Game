package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* 'enum' access flag removed */
/* renamed from: com.google.gson.h */
/* compiled from: FieldNamingPolicy */
class C10177h extends C10178i {
    C10177h(String str, int i) {
        super(str, i, null);
    }

    public String translateName(Field f) {
        return C10178i.m33126a(f.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
}
