package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zah extends AbstractSafeParcelable {
    public static final Creator<zah> CREATOR = new zai();

    /* renamed from: a */
    private final int f30599a;

    /* renamed from: b */
    private final ResolveAccountRequest f30600b;

    @Constructor
    zah(@Param(id = 1) int i, @Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.f30599a = i;
        this.f30600b = resolveAccountRequest;
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30599a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f30600b, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
