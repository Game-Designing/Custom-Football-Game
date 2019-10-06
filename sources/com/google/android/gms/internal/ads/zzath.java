package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzath extends AbstractSafeParcelable {
    public static final Creator<zzath> CREATOR = new zzati();

    /* renamed from: a */
    public final zzxz f24811a;

    /* renamed from: b */
    public final String f24812b;

    @Constructor
    public zzath(@Param(id = 2) zzxz zzxz, @Param(id = 3) String str) {
        this.f24811a = zzxz;
        this.f24812b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f24811a, i, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f24812b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
