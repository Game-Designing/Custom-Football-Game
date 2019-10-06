package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaym extends AbstractSafeParcelable {
    public static final Creator<zzaym> CREATOR = new zzayo();

    /* renamed from: a */
    public final String f24990a;

    /* renamed from: b */
    public final int f24991b;

    /* renamed from: a */
    public static zzaym m26243a(Throwable th, int i) {
        return new zzaym(th.getMessage(), i);
    }

    @Constructor
    zzaym(@Param(id = 1) String str, @Param(id = 2) int i) {
        if (str == null) {
            str = "";
        }
        this.f24990a = str;
        this.f24991b = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, this.f24990a, false);
        SafeParcelWriter.m21957a(parcel, 2, this.f24991b);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
