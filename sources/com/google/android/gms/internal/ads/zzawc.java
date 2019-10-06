package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzawc extends AbstractSafeParcelable {
    public static final Creator<zzawc> CREATOR = new zzawd();

    /* renamed from: a */
    public final String f24873a;

    /* renamed from: b */
    public final String f24874b;

    /* renamed from: c */
    public final zzyd f24875c;

    @Constructor
    public zzawc(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) zzyd zzyd) {
        this.f24873a = str;
        this.f24874b = str2;
        this.f24875c = zzyd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24873a, false);
        SafeParcelWriter.m21965a(parcel, 2, this.f24874b, false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) this.f24875c, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
