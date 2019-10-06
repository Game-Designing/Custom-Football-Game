package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzad extends AbstractSafeParcelable {
    public static final Creator<zzad> CREATOR = new zzae();

    /* renamed from: a */
    private final int f29825a = 1;

    /* renamed from: b */
    private final String f29826b;

    @Constructor
    zzad(@Param(id = 1) int i, @Param(id = 2) String str) {
        Preconditions.m21857a(str);
        this.f29826b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29825a);
        SafeParcelWriter.m21965a(parcel, 2, this.f29826b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
