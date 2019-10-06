package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzd extends AbstractSafeParcelable {
    public static final Creator<zzd> CREATOR = new zze();

    /* renamed from: a */
    public final long f30573a;

    /* renamed from: b */
    public final HarmfulAppsData[] f30574b;

    /* renamed from: c */
    public final int f30575c;

    /* renamed from: d */
    private final boolean f30576d;

    @Constructor
    public zzd(@Param(id = 2) long j, @Param(id = 3) HarmfulAppsData[] harmfulAppsDataArr, @Param(id = 4) int i, @Param(id = 5) boolean z) {
        this.f30573a = j;
        this.f30574b = harmfulAppsDataArr;
        this.f30576d = z;
        if (z) {
            this.f30575c = i;
        } else {
            this.f30575c = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21958a(parcel, 2, this.f30573a);
        SafeParcelWriter.m21970a(parcel, 3, (T[]) this.f30574b, i, false);
        SafeParcelWriter.m21957a(parcel, 4, this.f30575c);
        SafeParcelWriter.m21968a(parcel, 5, this.f30576d);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
