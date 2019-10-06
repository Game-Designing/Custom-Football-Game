package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public final class zzaj extends AbstractSafeParcelable {
    public static final Creator<zzaj> CREATOR = new zzak();

    /* renamed from: a */
    private final int f30533a;

    /* renamed from: b */
    private final int f30534b;

    /* renamed from: c */
    private final long f30535c;

    /* renamed from: d */
    private final long f30536d;

    @Constructor
    zzaj(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) long j2) {
        this.f30533a = i;
        this.f30534b = i2;
        this.f30535c = j;
        this.f30536d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaj.class == obj.getClass()) {
            zzaj zzaj = (zzaj) obj;
            return this.f30533a == zzaj.f30533a && this.f30534b == zzaj.f30534b && this.f30535c == zzaj.f30535c && this.f30536d == zzaj.f30536d;
        }
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30534b), Integer.valueOf(this.f30533a), Long.valueOf(this.f30536d), Long.valueOf(this.f30535c));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NetworkLocationStatus:");
        sb.append(" Wifi status: ");
        sb.append(this.f30533a);
        sb.append(" Cell status: ");
        sb.append(this.f30534b);
        sb.append(" elapsed time NS: ");
        sb.append(this.f30536d);
        sb.append(" system time ms: ");
        sb.append(this.f30535c);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30533a);
        SafeParcelWriter.m21957a(parcel, 2, this.f30534b);
        SafeParcelWriter.m21958a(parcel, 3, this.f30535c);
        SafeParcelWriter.m21958a(parcel, 4, this.f30536d);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
