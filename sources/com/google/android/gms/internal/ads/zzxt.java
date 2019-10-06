package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzxt extends AbstractSafeParcelable {
    public static final Creator<zzxt> CREATOR = new zzxu();

    /* renamed from: a */
    public final String f29719a;

    /* renamed from: b */
    public final String f29720b;

    @Constructor
    public zzxt(@Param(id = 1) String str, @Param(id = 2) String str2) {
        this.f29719a = str;
        this.f29720b = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f29719a, false);
        SafeParcelWriter.m21965a(parcel, 2, this.f29720b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
