package com.google.gson.p192b;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* renamed from: com.google.gson.b.l */
/* compiled from: ConstructorConstructor */
class C10152l implements C10170z<T> {

    /* renamed from: a */
    final /* synthetic */ Type f30813a;

    /* renamed from: b */
    final /* synthetic */ C10157q f30814b;

    C10152l(C10157q this$0, Type type) {
        this.f30814b = this$0;
        this.f30813a = type;
    }

    /* renamed from: a */
    public T mo33363a() {
        Type type = this.f30813a;
        String str = "Invalid EnumSet type: ";
        if (type instanceof ParameterizedType) {
            Type elementType = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (elementType instanceof Class) {
                return EnumSet.noneOf((Class) elementType);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f30813a.toString());
            throw new JsonIOException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f30813a.toString());
        throw new JsonIOException(sb2.toString());
    }
}
