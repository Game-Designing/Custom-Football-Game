package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
    public static final Creator<LocationSettingsResult> CREATOR = new zzah();

    /* renamed from: a */
    private final Status f30517a;

    /* renamed from: b */
    private final LocationSettingsStates f30518b;

    @Constructor
    public LocationSettingsResult(@Param(id = 1) Status status, @Param(id = 2) LocationSettingsStates locationSettingsStates) {
        this.f30517a = status;
        this.f30518b = locationSettingsStates;
    }

    /* renamed from: a */
    public final LocationSettingsStates mo33037a() {
        return this.f30518b;
    }

    public final Status getStatus() {
        return this.f30517a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) getStatus(), i, false);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) mo33037a(), i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
