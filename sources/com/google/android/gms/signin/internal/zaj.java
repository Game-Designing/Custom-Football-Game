package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zaj extends AbstractSafeParcelable {
    public static final Creator<zaj> CREATOR = new zak();

    /* renamed from: a */
    private final int f30601a;

    /* renamed from: b */
    private final ConnectionResult f30602b;

    /* renamed from: c */
    private final ResolveAccountResponse f30603c;

    @Constructor
    zaj(@Param(id = 1) int i, @Param(id = 2) ConnectionResult connectionResult, @Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.f30601a = i;
        this.f30602b = connectionResult;
        this.f30603c = resolveAccountResponse;
    }

    public zaj(int i) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }

    /* renamed from: a */
    public final ConnectionResult mo33168a() {
        return this.f30602b;
    }

    /* renamed from: c */
    public final ResolveAccountResponse mo33169c() {
        return this.f30603c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30601a);
        SafeParcelWriter.m21962a(parcel, 2, (Parcelable) this.f30602b, i, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f30603c, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
