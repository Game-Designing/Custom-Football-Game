package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzard
public final class zzapj extends AbstractSafeParcelable {
    public static final Creator<zzapj> CREATOR = new zzapk();

    /* renamed from: a */
    private final int f24521a;

    /* renamed from: b */
    private final int f24522b;

    /* renamed from: c */
    private final int f24523c;

    /* renamed from: a */
    public static zzapj m25624a(VersionInfo versionInfo) {
        return new zzapj(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    @Constructor
    zzapj(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3) {
        this.f24521a = i;
        this.f24522b = i2;
        this.f24523c = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f24521a);
        SafeParcelWriter.m21957a(parcel, 2, this.f24522b);
        SafeParcelWriter.m21957a(parcel, 3, this.f24523c);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final String toString() {
        int i = this.f24521a;
        int i2 = this.f24522b;
        int i3 = this.f24523c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        String str = ".";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }
}
