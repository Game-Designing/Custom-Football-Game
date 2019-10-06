package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzdy extends AbstractSafeParcelable {
    public static final Creator<zzdy> CREATOR = new zzdz();

    /* renamed from: a */
    public final long f30216a;

    /* renamed from: b */
    public final long f30217b;

    /* renamed from: c */
    public final boolean f30218c;

    /* renamed from: d */
    public final String f30219d;

    /* renamed from: e */
    public final String f30220e;

    /* renamed from: f */
    public final String f30221f;

    /* renamed from: g */
    public final Bundle f30222g;

    @Constructor
    zzdy(@Param(id = 1) long j, @Param(id = 2) long j2, @Param(id = 3) boolean z, @Param(id = 4) String str, @Param(id = 5) String str2, @Param(id = 6) String str3, @Param(id = 7) Bundle bundle) {
        this.f30216a = j;
        this.f30217b = j2;
        this.f30218c = z;
        this.f30219d = str;
        this.f30220e = str2;
        this.f30221f = str3;
        this.f30222g = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21958a(parcel, 1, this.f30216a);
        SafeParcelWriter.m21958a(parcel, 2, this.f30217b);
        SafeParcelWriter.m21968a(parcel, 3, this.f30218c);
        SafeParcelWriter.m21965a(parcel, 4, this.f30219d, false);
        SafeParcelWriter.m21965a(parcel, 5, this.f30220e, false);
        SafeParcelWriter.m21965a(parcel, 6, this.f30221f, false);
        SafeParcelWriter.m21959a(parcel, 7, this.f30222g, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
