package com.crashlytics.android.p124a;

import java.util.Set;

/* renamed from: com.crashlytics.android.a.G */
/* compiled from: SamplingEventFilter */
class C6365G implements C6400w {

    /* renamed from: a */
    static final Set<C6373b> f11349a = new C6364F();

    /* renamed from: b */
    final int f11350b;

    public C6365G(int samplingRate) {
        this.f11350b = samplingRate;
    }

    /* renamed from: a */
    public boolean mo19341a(C6371M sessionEvent) {
        boolean canBeSampled = f11349a.contains(sessionEvent.f11360c) && sessionEvent.f11358a.f11387e == null;
        boolean isSampledId = Math.abs(sessionEvent.f11358a.f11385c.hashCode() % this.f11350b) != 0;
        if (!canBeSampled || !isSampledId) {
            return false;
        }
        return true;
    }
}
