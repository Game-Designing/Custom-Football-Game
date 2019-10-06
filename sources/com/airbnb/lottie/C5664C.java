package com.airbnb.lottie;

import java.util.Arrays;

/* renamed from: com.airbnb.lottie.C */
/* compiled from: LottieResult */
public final class C5664C<V> {

    /* renamed from: a */
    private final V f9619a;

    /* renamed from: b */
    private final Throwable f9620b;

    public C5664C(V value) {
        this.f9619a = value;
        this.f9620b = null;
    }

    public C5664C(Throwable exception) {
        this.f9620b = exception;
        this.f9619a = null;
    }

    /* renamed from: b */
    public V mo17867b() {
        return this.f9619a;
    }

    /* renamed from: a */
    public Throwable mo17866a() {
        return this.f9620b;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof C5664C)) {
            return false;
        }
        LottieResult<?> that = (C5664C) o;
        if (mo17867b() != null && mo17867b().equals(that.mo17867b())) {
            return true;
        }
        if (mo17866a() == null || that.mo17866a() == null) {
            return false;
        }
        return mo17866a().toString().equals(mo17866a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{mo17867b(), mo17866a()});
    }
}
