package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzday extends AbstractSafeParcelable {
    public static final Creator<zzday> CREATOR = new zzdaz();

    /* renamed from: a */
    private final int f27756a;

    /* renamed from: b */
    private final byte[] f27757b;

    @Constructor
    zzday(@Param(id = 1) int i, @Param(id = 2) byte[] bArr) {
        this.f27756a = i;
        this.f27757b = bArr;
    }

    public zzday(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f27756a);
        SafeParcelWriter.m21969a(parcel, 2, this.f27757b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
