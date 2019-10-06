package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;

/* renamed from: com.google.android.gms.internal.location.a */
final class C9887a extends zzv {

    /* renamed from: b */
    private final ListenerHolder<LocationCallback> f29927b;

    /* renamed from: a */
    public final void mo32481a(LocationAvailability locationAvailability) {
        this.f29927b.mo27527a(new C9889c(this, locationAvailability));
    }

    /* renamed from: a */
    public final void mo32482a(LocationResult locationResult) {
        this.f29927b.mo27527a(new C9888b(this, locationResult));
    }
}
