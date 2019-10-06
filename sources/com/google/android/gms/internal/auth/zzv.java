package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzv extends AbstractSafeParcelable {
    public static final Creator<zzv> CREATOR = new zzw();

    /* renamed from: a */
    private final int f29895a = 1;

    /* renamed from: b */
    private final String f29896b;

    @Constructor
    zzv(@Param(id = 1) int i, @Param(id = 2) String str) {
        Preconditions.m21857a(str);
        this.f29896b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29895a);
        SafeParcelWriter.m21965a(parcel, 2, this.f29896b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
