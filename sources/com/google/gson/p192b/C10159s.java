package com.google.gson.p192b;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.C10058b;
import com.google.gson.C10171c;
import com.google.gson.Gson;
import com.google.gson.p016a.C0087a;
import com.google.gson.p016a.C0090d;
import com.google.gson.p016a.C0091e;
import com.google.gson.p195c.C10172a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.google.gson.b.s */
/* compiled from: Excluder */
public final class C10159s implements C10055D, Cloneable {

    /* renamed from: a */
    public static final C10159s f30826a = new C10159s();

    /* renamed from: b */
    private double f30827b = -1.0d;

    /* renamed from: c */
    private int f30828c = Opcodes.L2I;

    /* renamed from: d */
    private boolean f30829d = true;

    /* renamed from: e */
    private boolean f30830e;

    /* renamed from: f */
    private List<C10058b> f30831f = Collections.emptyList();

    /* renamed from: g */
    private List<C10058b> f30832g = Collections.emptyList();

    /* access modifiers changed from: protected */
    public C10159s clone() {
        try {
            return (C10159s) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public C10159s mo33367a(double ignoreVersionsAfter) {
        C10159s result = clone();
        result.f30827b = ignoreVersionsAfter;
        return result;
    }

    /* renamed from: a */
    public C10159s mo33369a(int... modifiers) {
        C10159s result = clone();
        result.f30828c = 0;
        int length = modifiers.length;
        for (int i = 0; i < length; i++) {
            result.f30828c |= modifiers[i];
        }
        return result;
    }

    /* renamed from: a */
    public C10159s mo33366a() {
        C10159s result = clone();
        result.f30829d = false;
        return result;
    }

    /* renamed from: b */
    public C10159s mo33372b() {
        C10159s result = clone();
        result.f30830e = true;
        return result;
    }

    /* renamed from: a */
    public C10159s mo33368a(C10058b exclusionStrategy, boolean serialization, boolean deserialization) {
        C10159s result = clone();
        if (serialization) {
            result.f30831f = new ArrayList(this.f30831f);
            result.f30831f.add(exclusionStrategy);
        }
        if (deserialization) {
            result.f30832g = new ArrayList(this.f30832g);
            result.f30832g.add(exclusionStrategy);
        }
        return result;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> type) {
        Class<?> rawType = type.mo33420a();
        boolean skipSerialize = mo33370a(rawType, true);
        boolean skipDeserialize = mo33370a(rawType, false);
        if (!skipSerialize && !skipDeserialize) {
            return null;
        }
        C10158r rVar = new C10158r(this, skipDeserialize, skipSerialize, gson, type);
        return rVar;
    }

    /* renamed from: a */
    public boolean mo33371a(Field field, boolean serialize) {
        if ((this.f30828c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f30827b != -1.0d && !m33091a((C0090d) field.getAnnotation(C0090d.class), (C0091e) field.getAnnotation(C0091e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f30830e) {
            C0087a annotation = (C0087a) field.getAnnotation(C0087a.class);
            if (annotation == null || (!serialize ? !annotation.deserialize() : !annotation.serialize())) {
                return true;
            }
        }
        if ((!this.f30829d && m33094b(field.getType())) || m33093a(field.getType())) {
            return true;
        }
        List<C10058b> list = serialize ? this.f30831f : this.f30832g;
        if (!list.isEmpty()) {
            C10171c fieldAttributes = new C10171c(field);
            for (C10058b exclusionStrategy : list) {
                if (exclusionStrategy.mo33256a(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo33370a(Class<?> clazz, boolean serialize) {
        if (this.f30827b != -1.0d && !m33091a((C0090d) clazz.getAnnotation(C0090d.class), (C0091e) clazz.getAnnotation(C0091e.class))) {
            return true;
        }
        if ((!this.f30829d && m33094b(clazz)) || m33093a(clazz)) {
            return true;
        }
        for (C10058b exclusionStrategy : serialize ? this.f30831f : this.f30832g) {
            if (exclusionStrategy.mo33257a(clazz)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m33093a(Class<?> clazz) {
        return !Enum.class.isAssignableFrom(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }

    /* renamed from: b */
    private boolean m33094b(Class<?> clazz) {
        return clazz.isMemberClass() && !m33095c(clazz);
    }

    /* renamed from: c */
    private boolean m33095c(Class<?> clazz) {
        return (clazz.getModifiers() & 8) != 0;
    }

    /* renamed from: a */
    private boolean m33091a(C0090d since, C0091e until) {
        return m33090a(since) && m33092a(until);
    }

    /* renamed from: a */
    private boolean m33090a(C0090d annotation) {
        if (annotation == null || annotation.value() <= this.f30827b) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m33092a(C0091e annotation) {
        if (annotation == null || annotation.value() > this.f30827b) {
            return true;
        }
        return false;
    }
}
