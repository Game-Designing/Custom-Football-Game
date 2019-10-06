package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzaf extends AbstractSafeParcelable {
    public static final Creator<zzaf> CREATOR = new zzag();

    /* renamed from: a */
    private final int f29827a = 1;

    /* renamed from: b */
    private final String f29828b;

    /* renamed from: c */
    private final byte[] f29829c;

    @Constructor
    zzaf(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) byte[] bArr) {
        Preconditions.m21857a(str);
        this.f29828b = str;
        Preconditions.m21857a(bArr);
        this.f29829c = bArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f29827a);
        SafeParcelWriter.m21965a(parcel, 2, this.f29828b, false);
        SafeParcelWriter.m21969a(parcel, 3, this.f29829c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
