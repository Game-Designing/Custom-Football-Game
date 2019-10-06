package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaiw extends AbstractSafeParcelable {
    public static final Creator<zzaiw> CREATOR = new zzaix();

    /* renamed from: a */
    public final String f24369a;

    /* renamed from: b */
    public final Bundle f24370b;

    @Constructor
    public zzaiw(@Param(id = 1) String str, @Param(id = 2) Bundle bundle) {
        this.f24369a = str;
        this.f24370b = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24369a, false);
        SafeParcelWriter.m21959a(parcel, 2, this.f24370b, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
