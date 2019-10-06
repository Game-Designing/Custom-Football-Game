package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzaic extends AbstractSafeParcelable {
    public static final Creator<zzaic> CREATOR = new zzaid();

    /* renamed from: a */
    public final boolean f24355a;

    /* renamed from: b */
    public final String f24356b;

    /* renamed from: c */
    public final int f24357c;

    /* renamed from: d */
    public final byte[] f24358d;

    /* renamed from: e */
    public final String[] f24359e;

    /* renamed from: f */
    public final String[] f24360f;

    /* renamed from: g */
    public final boolean f24361g;

    /* renamed from: h */
    public final long f24362h;

    @Constructor
    zzaic(@Param(id = 1) boolean z, @Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) byte[] bArr, @Param(id = 5) String[] strArr, @Param(id = 6) String[] strArr2, @Param(id = 7) boolean z2, @Param(id = 8) long j) {
        this.f24355a = z;
        this.f24356b = str;
        this.f24357c = i;
        this.f24358d = bArr;
        this.f24359e = strArr;
        this.f24360f = strArr2;
        this.f24361g = z2;
        this.f24362h = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 1, this.f24355a);
        SafeParcelWriter.m21965a(parcel, 2, this.f24356b, false);
        SafeParcelWriter.m21957a(parcel, 3, this.f24357c);
        SafeParcelWriter.m21969a(parcel, 4, this.f24358d, false);
        SafeParcelWriter.m21971a(parcel, 5, this.f24359e, false);
        SafeParcelWriter.m21971a(parcel, 6, this.f24360f, false);
        SafeParcelWriter.m21968a(parcel, 7, this.f24361g);
        SafeParcelWriter.m21958a(parcel, 8, this.f24362h);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
