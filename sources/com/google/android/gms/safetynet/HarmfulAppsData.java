package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Creator<HarmfulAppsData> CREATOR = new zzc();

    /* renamed from: a */
    public final String f30555a;

    /* renamed from: b */
    public final byte[] f30556b;

    /* renamed from: c */
    public final int f30557c;

    @Constructor
    public HarmfulAppsData(@Param(id = 2) String str, @Param(id = 3) byte[] bArr, @Param(id = 4) int i) {
        this.f30555a = str;
        this.f30556b = bArr;
        this.f30557c = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, this.f30555a, false);
        SafeParcelWriter.m21969a(parcel, 3, this.f30556b, false);
        SafeParcelWriter.m21957a(parcel, 4, this.f30557c);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
