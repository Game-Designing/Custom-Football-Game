package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaio extends AbstractSafeParcelable {
    public static final Creator<zzaio> CREATOR = new zzaip();

    /* renamed from: a */
    private final String f24365a;

    /* renamed from: b */
    public final boolean f24366b;

    /* renamed from: c */
    public final int f24367c;

    /* renamed from: d */
    public final String f24368d;

    @Constructor
    public zzaio(@Param(id = 1) String str, @Param(id = 2) boolean z, @Param(id = 3) int i, @Param(id = 4) String str2) {
        this.f24365a = str;
        this.f24366b = z;
        this.f24367c = i;
        this.f24368d = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24365a, false);
        SafeParcelWriter.m21968a(parcel, 2, this.f24366b);
        SafeParcelWriter.m21957a(parcel, 3, this.f24367c);
        SafeParcelWriter.m21965a(parcel, 4, this.f24368d, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
