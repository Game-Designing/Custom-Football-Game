package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaax extends AbstractSafeParcelable {
    public static final Creator<zzaax> CREATOR = new zzaay();

    /* renamed from: a */
    private final int f23796a;

    @Constructor
    public zzaax(@Param(id = 2) int i) {
        this.f23796a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 2, this.f23796a);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
