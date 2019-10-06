package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class zzj extends AbstractSafeParcelable {
    public static final Creator<zzj> CREATOR = new zzk();

    /* renamed from: a */
    private boolean f30540a;

    /* renamed from: b */
    private long f30541b;

    /* renamed from: c */
    private float f30542c;

    /* renamed from: d */
    private long f30543d;

    /* renamed from: e */
    private int f30544e;

    public zzj() {
        this(true, 50, 0.0f, Long.MAX_VALUE, MoPubClientPositioning.NO_REPEAT);
    }

    @Constructor
    zzj(@Param(id = 1) boolean z, @Param(id = 2) long j, @Param(id = 3) float f, @Param(id = 4) long j2, @Param(id = 5) int i) {
        this.f30540a = z;
        this.f30541b = j;
        this.f30542c = f;
        this.f30543d = j2;
        this.f30544e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        return this.f30540a == zzj.f30540a && this.f30541b == zzj.f30541b && Float.compare(this.f30542c, zzj.f30542c) == 0 && this.f30543d == zzj.f30543d && this.f30544e == zzj.f30544e;
    }

    public final int hashCode() {
        return Objects.m21849a(Boolean.valueOf(this.f30540a), Long.valueOf(this.f30541b), Float.valueOf(this.f30542c), Long.valueOf(this.f30543d), Integer.valueOf(this.f30544e));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f30540a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f30541b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f30542c);
        long j = this.f30543d;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = j - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime);
            sb.append("ms");
        }
        if (this.f30544e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f30544e);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21968a(parcel, 1, this.f30540a);
        SafeParcelWriter.m21958a(parcel, 2, this.f30541b);
        SafeParcelWriter.m21956a(parcel, 3, this.f30542c);
        SafeParcelWriter.m21958a(parcel, 4, this.f30543d);
        SafeParcelWriter.m21957a(parcel, 5, this.f30544e);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
