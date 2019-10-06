package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzy extends AbstractSafeParcelable {
    public static final Creator<zzy> CREATOR = new zzz();

    /* renamed from: a */
    private final Credential f29819a;

    @Constructor
    public zzy(@Param(id = 1) Credential credential) {
        this.f29819a = credential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) this.f29819a, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
