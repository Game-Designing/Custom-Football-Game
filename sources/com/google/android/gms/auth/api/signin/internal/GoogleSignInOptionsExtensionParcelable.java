package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();

    /* renamed from: a */
    private final int f19464a;

    /* renamed from: b */
    private int f19465b;

    /* renamed from: c */
    private Bundle f19466c;

    @Constructor
    GoogleSignInOptionsExtensionParcelable(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) Bundle bundle) {
        this.f19464a = i;
        this.f19465b = i2;
        this.f19466c = bundle;
    }

    @KeepForSdk
    /* renamed from: a */
    public int mo27217a() {
        return this.f19465b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f19464a);
        SafeParcelWriter.m21957a(parcel, 2, mo27217a());
        SafeParcelWriter.m21959a(parcel, 3, this.f19466c, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
