package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzh extends AbstractSafeParcelable {
    public static final Creator<zzh> CREATOR = new zzi();

    /* renamed from: a */
    private final int f30578a;

    /* renamed from: b */
    private final boolean f30579b;

    @Constructor
    public zzh(@Param(id = 2) int i, @Param(id = 3) boolean z) {
        this.f30578a = i;
        this.f30579b = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 2, this.f30578a);
        SafeParcelWriter.m21968a(parcel, 3, this.f30579b);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
