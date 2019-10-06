package com.google.gson.p192b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.gson.b.j */
/* compiled from: ConstructorConstructor */
class C10150j implements C10170z<T> {

    /* renamed from: a */
    final /* synthetic */ Constructor f30810a;

    /* renamed from: b */
    final /* synthetic */ C10157q f30811b;

    C10150j(C10157q this$0, Constructor constructor) {
        this.f30811b = this$0;
        this.f30810a = constructor;
    }

    /* renamed from: a */
    public T mo33363a() {
        String str = " with no args";
        String str2 = "Failed to invoke ";
        try {
            return this.f30810a.newInstance(null);
        } catch (InstantiationException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(this.f30810a);
            sb.append(str);
            throw new RuntimeException(sb.toString(), e);
        } catch (InvocationTargetException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(this.f30810a);
            sb2.append(str);
            throw new RuntimeException(sb2.toString(), e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
