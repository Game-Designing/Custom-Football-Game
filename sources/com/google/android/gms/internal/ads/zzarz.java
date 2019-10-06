package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzarz extends AbstractSafeParcelable {
    public static final Creator<zzarz> CREATOR = new zzasa();

    /* renamed from: a */
    String f24724a;

    @Constructor
    public zzarz(@Param(id = 2) String str) {
        this.f24724a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f24724a, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
