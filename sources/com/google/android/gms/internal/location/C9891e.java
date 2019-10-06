package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzy;

/* renamed from: com.google.android.gms.internal.location.e */
final class C9891e extends zzy {

    /* renamed from: b */
    private final ListenerHolder<LocationListener> f29930b;

    public final synchronized void onLocationChanged(Location location) {
        this.f29930b.mo27527a(new C9892f(this, location));
    }
}
