package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaiy extends AbstractSafeParcelable {
    public static final Creator<zzaiy> CREATOR = new zzaiz();

    /* renamed from: a */
    public final int f24371a;

    @Constructor
    public zzaiy(@Param(id = 1) int i) {
        this.f24371a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f24371a);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
