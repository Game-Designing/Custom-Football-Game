package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzad extends AbstractSafeParcelable implements Result {
    public static final Creator<zzad> CREATOR = new zzae();

    /* renamed from: a */
    private static final zzad f29935a = new zzad(Status.f19597a);

    /* renamed from: b */
    private final Status f29936b;

    @Constructor
    public zzad(@Param(id = 1) Status status) {
        this.f29936b = status;
    }

    public final Status getStatus() {
        return this.f29936b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21962a(parcel, 1, (Parcelable) getStatus(), i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
