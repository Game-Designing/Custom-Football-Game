package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<LocationAvailability> CREATOR = new zzaa();
    @Deprecated

    /* renamed from: a */
    private int f30488a;
    @Deprecated

    /* renamed from: b */
    private int f30489b;

    /* renamed from: c */
    private long f30490c;

    /* renamed from: d */
    private int f30491d;

    /* renamed from: e */
    private zzaj[] f30492e;

    @Constructor
    LocationAvailability(@Param(id = 4) int i, @Param(id = 1) int i2, @Param(id = 2) int i3, @Param(id = 3) long j, @Param(id = 5) zzaj[] zzajArr) {
        this.f30491d = i;
        this.f30488a = i2;
        this.f30489b = i3;
        this.f30490c = j;
        this.f30492e = zzajArr;
    }

    /* renamed from: a */
    public final boolean mo33021a() {
        return this.f30491d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            return this.f30488a == locationAvailability.f30488a && this.f30489b == locationAvailability.f30489b && this.f30490c == locationAvailability.f30490c && this.f30491d == locationAvailability.f30491d && Arrays.equals(this.f30492e, locationAvailability.f30492e);
        }
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30491d), Integer.valueOf(this.f30488a), Integer.valueOf(this.f30489b), Long.valueOf(this.f30490c), this.f30492e);
    }

    public final String toString() {
        boolean a = mo33021a();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(a);
        sb.append("]");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30488a);
        SafeParcelWriter.m21957a(parcel, 2, this.f30489b);
        SafeParcelWriter.m21958a(parcel, 3, this.f30490c);
        SafeParcelWriter.m21957a(parcel, 4, this.f30491d);
        SafeParcelWriter.m21970a(parcel, 5, (T[]) this.f30492e, i, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
