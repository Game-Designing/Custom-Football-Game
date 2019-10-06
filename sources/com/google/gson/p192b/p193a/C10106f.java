package com.google.gson.p192b.p193a;

import com.google.gson.C10054C;
import com.google.gson.C10055D;
import com.google.gson.Gson;
import com.google.gson.p016a.C0088b;
import com.google.gson.p192b.C10157q;
import com.google.gson.p195c.C10172a;

/* renamed from: com.google.gson.b.a.f */
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory */
public final class C10106f implements C10055D {

    /* renamed from: a */
    private final C10157q f30683a;

    public C10106f(C10157q constructorConstructor) {
        this.f30683a = constructorConstructor;
    }

    /* renamed from: a */
    public <T> C10054C<T> mo33201a(Gson gson, C10172a<T> targetType) {
        C0088b annotation = (C0088b) targetType.mo33420a().getAnnotation(C0088b.class);
        if (annotation == null) {
            return null;
        }
        return mo33293a(this.f30683a, gson, targetType, annotation);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.gson.C, com.google.gson.C<?>] */
    /* JADX WARNING: type inference failed for: r1v14, types: [com.google.gson.C] */
    /* JADX WARNING: type inference failed for: r1v16, types: [com.google.gson.C] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.gson.C10054C<?> mo33293a(com.google.gson.p192b.C10157q r10, com.google.gson.Gson r11, com.google.gson.p195c.C10172a<?> r12, com.google.gson.p016a.C0088b r13) {
        /*
            r9 = this;
            java.lang.Class r0 = r13.value()
            com.google.gson.c.a r0 = com.google.gson.p195c.C10172a.m33119a(r0)
            com.google.gson.b.z r0 = r10.mo33364a(r0)
            java.lang.Object r0 = r0.mo33363a()
            boolean r1 = r0 instanceof com.google.gson.C10054C
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.google.gson.C r1 = (com.google.gson.C10054C) r1
            goto L_0x007a
        L_0x0018:
            boolean r1 = r0 instanceof com.google.gson.C10055D
            if (r1 == 0) goto L_0x0024
            r1 = r0
            com.google.gson.D r1 = (com.google.gson.C10055D) r1
            com.google.gson.C r1 = r1.mo33201a(r11, r12)
            goto L_0x007a
        L_0x0024:
            boolean r1 = r0 instanceof com.google.gson.C10194x
            if (r1 != 0) goto L_0x005d
            boolean r1 = r0 instanceof com.google.gson.C10187r
            if (r1 == 0) goto L_0x002d
            goto L_0x005d
        L_0x002d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid attempt to bind an instance of "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = " as a @JsonAdapter for "
            r2.append(r3)
            java.lang.String r3 = r12.toString()
            r2.append(r3)
            java.lang.String r3 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x005d:
            boolean r1 = r0 instanceof com.google.gson.C10194x
            r2 = 0
            if (r1 == 0) goto L_0x0067
            r1 = r0
            com.google.gson.x r1 = (com.google.gson.C10194x) r1
            r4 = r1
            goto L_0x0068
        L_0x0067:
            r4 = r2
        L_0x0068:
            boolean r1 = r0 instanceof com.google.gson.C10187r
            if (r1 == 0) goto L_0x006f
            r2 = r0
            com.google.gson.r r2 = (com.google.gson.C10187r) r2
        L_0x006f:
            r5 = r2
            com.google.gson.b.a.v r1 = new com.google.gson.b.a.v
            r8 = 0
            r3 = r1
            r6 = r11
            r7 = r12
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x007a:
            if (r1 == 0) goto L_0x0086
            boolean r2 = r13.nullSafe()
            if (r2 == 0) goto L_0x0086
            com.google.gson.C r1 = r1.mo33199a()
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p192b.p193a.C10106f.mo33293a(com.google.gson.b.q, com.google.gson.Gson, com.google.gson.c.a, com.google.gson.a.b):com.google.gson.C");
    }
}
