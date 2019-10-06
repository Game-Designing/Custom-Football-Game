package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzag();

    /* renamed from: a */
    private final List<LocationRequest> f30509a;

    /* renamed from: b */
    private final boolean f30510b;

    /* renamed from: c */
    private final boolean f30511c;

    /* renamed from: d */
    private zzae f30512d;

    public static final class Builder {

        /* renamed from: a */
        private final ArrayList<LocationRequest> f30513a = new ArrayList<>();

        /* renamed from: b */
        private boolean f30514b = false;

        /* renamed from: c */
        private boolean f30515c = false;

        /* renamed from: d */
        private zzae f30516d = null;
    }

    @Constructor
    LocationSettingsRequest(@Param(id = 1) List<LocationRequest> list, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 5) zzae zzae) {
        this.f30509a = list;
        this.f30510b = z;
        this.f30511c = z2;
        this.f30512d = zzae;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21977c(parcel, 1, Collections.unmodifiableList(this.f30509a), false);
        SafeParcelWriter.m21968a(parcel, 2, this.f30510b);
        SafeParcelWriter.m21968a(parcel, 3, this.f30511c);
        SafeParcelWriter.m21962a(parcel, 5, (Parcelable) this.f30512d, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
