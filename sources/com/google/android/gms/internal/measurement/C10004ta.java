package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.ta */
final class C10004ta {

    /* renamed from: a */
    private static final C10000ra f30174a = m32199c();

    /* renamed from: b */
    private static final C10000ra f30175b = new C10002sa();

    /* renamed from: a */
    static C10000ra m32197a() {
        return f30174a;
    }

    /* renamed from: b */
    static C10000ra m32198b() {
        return f30175b;
    }

    /* renamed from: c */
    private static C10000ra m32199c() {
        try {
            return (C10000ra) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
