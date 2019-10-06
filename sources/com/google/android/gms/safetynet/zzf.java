package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzf extends AbstractSafeParcelable {
    public static final Creator<zzf> CREATOR = new zzg();

    /* renamed from: a */
    private final String f30577a;

    @Constructor
    public zzf(@Param(id = 2) String str) {
        this.f30577a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f30577a, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
