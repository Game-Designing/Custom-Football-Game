package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zza extends AbstractSafeParcelable {
    public static final Creator<zza> CREATOR = new zzb();

    /* renamed from: a */
    private final String f30572a;

    @Constructor
    public zza(@Param(id = 2) String str) {
        this.f30572a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f30572a, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
