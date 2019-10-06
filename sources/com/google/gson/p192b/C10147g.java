package com.google.gson.p192b;

import java.lang.reflect.Type;

/* renamed from: com.google.gson.b.g */
/* compiled from: ConstructorConstructor */
class C10147g implements C10170z<T> {

    /* renamed from: a */
    private final C10067G f30800a = C10067G.m32839a();

    /* renamed from: b */
    final /* synthetic */ Class f30801b;

    /* renamed from: c */
    final /* synthetic */ Type f30802c;

    /* renamed from: d */
    final /* synthetic */ C10157q f30803d;

    C10147g(C10157q this$0, Class cls, Type type) {
        this.f30803d = this$0;
        this.f30801b = cls;
        this.f30802c = type;
    }

    /* renamed from: a */
    public T mo33363a() {
        try {
            return this.f30800a.mo33265b(this.f30801b);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to invoke no-args constructor for ");
            sb.append(this.f30802c);
            sb.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            throw new RuntimeException(sb.toString(), e);
        }
    }
}
