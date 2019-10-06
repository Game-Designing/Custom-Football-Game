package com.google.gson.p192b;

/* renamed from: com.google.gson.b.F */
/* compiled from: UnsafeAllocator */
class C10066F extends C10067G {
    C10066F() {
    }

    /* renamed from: b */
    public <T> T mo33265b(Class<T> c) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot allocate ");
        sb.append(c);
        throw new UnsupportedOperationException(sb.toString());
    }
}
