package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzab extends AbstractSafeParcelable {
    public static final Creator<zzab> CREATOR = new zzac();

    /* renamed from: a */
    private final int f29822a = 1;

    /* renamed from: b */
    private final String f29823b;

    /* renamed from: c */
    private final int f29824c;

    @Constructor
    zzab(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
        Preconditions.m21857a(str);
        this.f29823b = str;
        this.f29824c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29822a);
        SafeParcelWriter.m21965a(parcel, 2, this.f29823b, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f29824c);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
