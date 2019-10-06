package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzdbb extends AbstractSafeParcelable {
    public static final Creator<zzdbb> CREATOR = new zzdbc();

    /* renamed from: a */
    private final int f27758a;

    /* renamed from: b */
    private final String f27759b;

    /* renamed from: c */
    private final String f27760c;

    @Constructor
    zzdbb(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2) {
        this.f27758a = i;
        this.f27759b = str;
        this.f27760c = str2;
    }

    public zzdbb(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f27758a);
        SafeParcelWriter.m21965a(parcel, 2, this.f27759b, false);
        SafeParcelWriter.m21965a(parcel, 3, this.f27760c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
