package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public static final Creator<FavaDiagnosticsEntity> CREATOR = new zaa();

    /* renamed from: a */
    private final int f20190a;

    /* renamed from: b */
    private final String f20191b;

    /* renamed from: c */
    private final int f20192c;

    @Constructor
    public FavaDiagnosticsEntity(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
        this.f20190a = i;
        this.f20191b = str;
        this.f20192c = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20190a);
        SafeParcelWriter.m21965a(parcel, 2, this.f20191b, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f20192c);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
