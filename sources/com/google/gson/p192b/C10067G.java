package com.google.gson.p192b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: com.google.gson.b.G */
/* compiled from: UnsafeAllocator */
public abstract class C10067G {
    /* renamed from: b */
    public abstract <T> T mo33265b(Class<T> cls) throws Exception;

    /* renamed from: a */
    public static C10067G m32839a() {
        String str = "newInstance";
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return new C10063C(unsafeClass.getMethod("allocateInstance", new Class[]{Class.class}), f.get(null));
        } catch (Exception e) {
            try {
                Method getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                getConstructorId.setAccessible(true);
                int constructorId = ((Integer) getConstructorId.invoke(null, new Object[]{Object.class})).intValue();
                Method newInstance = ObjectStreamClass.class.getDeclaredMethod(str, new Class[]{Class.class, Integer.TYPE});
                newInstance.setAccessible(true);
                return new C10064D(newInstance, constructorId);
            } catch (Exception e2) {
                try {
                    Method newInstance2 = ObjectInputStream.class.getDeclaredMethod(str, new Class[]{Class.class, Class.class});
                    newInstance2.setAccessible(true);
                    return new C10065E(newInstance2);
                } catch (Exception e3) {
                    return new C10066F();
                }
            }
        }
    }

    /* renamed from: a */
    static void m32840a(Class<?> c) {
        int modifiers = c.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Interface can't be instantiated! Interface name: ");
            sb.append(c.getName());
            throw new UnsupportedOperationException(sb.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Abstract class can't be instantiated! Class name: ");
            sb2.append(c.getName());
            throw new UnsupportedOperationException(sb2.toString());
        }
    }
}
