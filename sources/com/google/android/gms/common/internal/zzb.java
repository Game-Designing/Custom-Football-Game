package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzb extends AbstractSafeParcelable {
    public static final Creator<zzb> CREATOR = new zzc();

    /* renamed from: a */
    Bundle f20173a;

    /* renamed from: b */
    Feature[] f20174b;

    @Constructor
    zzb(@Param(id = 1) Bundle bundle, @Param(id = 2) Feature[] featureArr) {
        this.f20173a = bundle;
        this.f20174b = featureArr;
    }

    public zzb() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21959a(parcel, 1, this.f20173a, false);
        SafeParcelWriter.m21970a(parcel, 2, (T[]) this.f20174b, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
