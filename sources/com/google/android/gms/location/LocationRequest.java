package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR = new zzab();

    /* renamed from: a */
    private int f30493a;

    /* renamed from: b */
    private long f30494b;

    /* renamed from: c */
    private long f30495c;

    /* renamed from: d */
    private boolean f30496d;

    /* renamed from: e */
    private long f30497e;

    /* renamed from: f */
    private int f30498f;

    /* renamed from: g */
    private float f30499g;

    /* renamed from: h */
    private long f30500h;

    public LocationRequest() {
        this.f30493a = 102;
        this.f30494b = 3600000;
        this.f30495c = 600000;
        this.f30496d = false;
        this.f30497e = Long.MAX_VALUE;
        this.f30498f = MoPubClientPositioning.NO_REPEAT;
        this.f30499g = 0.0f;
        this.f30500h = 0;
    }

    @Constructor
    LocationRequest(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) long j2, @Param(id = 4) boolean z, @Param(id = 5) long j3, @Param(id = 6) int i2, @Param(id = 7) float f, @Param(id = 8) long j4) {
        this.f30493a = i;
        this.f30494b = j;
        this.f30495c = j2;
        this.f30496d = z;
        this.f30497e = j3;
        this.f30498f = i2;
        this.f30499g = f;
        this.f30500h = j4;
    }

    /* renamed from: a */
    public final long mo33026a() {
        long j = this.f30500h;
        long j2 = this.f30494b;
        return j < j2 ? j2 : j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f30493a == locationRequest.f30493a && this.f30494b == locationRequest.f30494b && this.f30495c == locationRequest.f30495c && this.f30496d == locationRequest.f30496d && this.f30497e == locationRequest.f30497e && this.f30498f == locationRequest.f30498f && this.f30499g == locationRequest.f30499g && mo33026a() == locationRequest.mo33026a();
    }

    public final int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30493a), Long.valueOf(this.f30494b), Float.valueOf(this.f30499g), Long.valueOf(this.f30500h));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.f30493a;
        String str = i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY";
        sb.append(str);
        String str2 = "ms";
        if (this.f30493a != 105) {
            sb.append(" requested=");
            sb.append(this.f30494b);
            sb.append(str2);
        }
        sb.append(" fastest=");
        sb.append(this.f30495c);
        sb.append(str2);
        if (this.f30500h > this.f30494b) {
            sb.append(" maxWait=");
            sb.append(this.f30500h);
            sb.append(str2);
        }
        if (this.f30499g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f30499g);
            sb.append(InneractiveMediationDefs.GENDER_MALE);
        }
        long j = this.f30497e;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = j - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime);
            sb.append(str2);
        }
        if (this.f30498f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f30498f);
        }
        sb.append(']');
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30493a);
        SafeParcelWriter.m21958a(parcel, 2, this.f30494b);
        SafeParcelWriter.m21958a(parcel, 3, this.f30495c);
        SafeParcelWriter.m21968a(parcel, 4, this.f30496d);
        SafeParcelWriter.m21958a(parcel, 5, this.f30497e);
        SafeParcelWriter.m21957a(parcel, 6, this.f30498f);
        SafeParcelWriter.m21956a(parcel, 7, this.f30499g);
        SafeParcelWriter.m21958a(parcel, 8, this.f30500h);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
