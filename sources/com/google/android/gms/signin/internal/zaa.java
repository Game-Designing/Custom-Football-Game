package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Creator<zaa> CREATOR = new zab();

    /* renamed from: a */
    private final int f30596a;

    /* renamed from: b */
    private int f30597b;

    /* renamed from: c */
    private Intent f30598c;

    @Constructor
    zaa(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) Intent intent) {
        this.f30596a = i;
        this.f30597b = i2;
        this.f30598c = intent;
    }

    public zaa() {
        this(0, null);
    }

    private zaa(int i, Intent intent) {
        this(2, 0, null);
    }

    public final Status getStatus() {
        if (this.f30597b == 0) {
            return Status.f19597a;
        }
        return Status.f19601e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30596a);
        SafeParcelWriter.m21957a(parcel, 2, this.f30597b);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f30598c, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
