package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzae extends AbstractSafeParcelable {
    public static final Creator<zzae> CREATOR = new zzaf();

    /* renamed from: a */
    private final String f30530a;

    /* renamed from: b */
    private final String f30531b;

    /* renamed from: c */
    private final String f30532c;

    @Constructor
    zzae(@Param(id = 5) String str, @Param(id = 1) String str2, @Param(id = 2) String str3) {
        this.f30532c = str;
        this.f30530a = str2;
        this.f30531b = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f30530a, false);
        SafeParcelWriter.m21965a(parcel, 2, this.f30531b, false);
        SafeParcelWriter.m21965a(parcel, 5, this.f30532c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
