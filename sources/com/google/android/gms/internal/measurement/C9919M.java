package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.M */
final class C9919M {

    /* renamed from: a */
    private final zztv f30018a;

    /* renamed from: b */
    private final byte[] f30019b;

    private C9919M(int i) {
        this.f30019b = new byte[i];
        this.f30018a = zztv.m32409a(this.f30019b);
    }

    /* renamed from: a */
    public final zzte mo32589a() {
        if (this.f30018a.mo32850a() == 0) {
            return new C9923O(this.f30019b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* renamed from: b */
    public final zztv mo32590b() {
        return this.f30018a;
    }

    /* synthetic */ C9919M(int i, C9907G g) {
        this(i);
    }
}
