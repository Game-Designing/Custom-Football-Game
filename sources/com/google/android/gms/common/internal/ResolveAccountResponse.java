package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new zan();

    /* renamed from: a */
    private final int f20125a;

    /* renamed from: b */
    private IBinder f20126b;

    /* renamed from: c */
    private ConnectionResult f20127c;

    /* renamed from: d */
    private boolean f20128d;

    /* renamed from: e */
    private boolean f20129e;

    @Constructor
    ResolveAccountResponse(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder, @Param(id = 3) ConnectionResult connectionResult, @Param(id = 4) boolean z, @Param(id = 5) boolean z2) {
        this.f20125a = i;
        this.f20126b = iBinder;
        this.f20127c = connectionResult;
        this.f20128d = z;
        this.f20129e = z2;
    }

    /* renamed from: a */
    public IAccountAccessor mo27817a() {
        return Stub.m21835a(this.f20126b);
    }

    /* renamed from: c */
    public ConnectionResult mo27818c() {
        return this.f20127c;
    }

    /* renamed from: d */
    public boolean mo27819d() {
        return this.f20128d;
    }

    /* renamed from: e */
    public boolean mo27820e() {
        return this.f20129e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f20125a);
        SafeParcelWriter.m21960a(parcel, 2, this.f20126b, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) mo27818c(), i, false);
        SafeParcelWriter.m21968a(parcel, 4, mo27819d());
        SafeParcelWriter.m21968a(parcel, 5, mo27820e());
        SafeParcelWriter.m21954a(parcel, a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        if (!this.f20127c.equals(resolveAccountResponse.f20127c) || !mo27817a().equals(resolveAccountResponse.mo27817a())) {
            return false;
        }
        return true;
    }
}
