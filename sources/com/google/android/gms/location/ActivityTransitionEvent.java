package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionEvent> CREATOR = new zzd();

    /* renamed from: a */
    private final int f30462a;

    /* renamed from: b */
    private final int f30463b;

    /* renamed from: c */
    private final long f30464c;

    @Constructor
    public ActivityTransitionEvent(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) long j) {
        DetectedActivity.m32667a(i);
        ActivityTransition.m32660a(i2);
        this.f30462a = i;
        this.f30463b = i2;
        this.f30464c = j;
    }

    /* renamed from: a */
    public int mo32996a() {
        return this.f30462a;
    }

    /* renamed from: c */
    public long mo32997c() {
        return this.f30464c;
    }

    /* renamed from: d */
    public int mo32998d() {
        return this.f30463b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f30462a == activityTransitionEvent.f30462a && this.f30463b == activityTransitionEvent.f30463b && this.f30464c == activityTransitionEvent.f30464c;
    }

    public int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30462a), Integer.valueOf(this.f30463b), Long.valueOf(this.f30464c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.f30462a;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i);
        sb.append(sb2.toString());
        String str = " ";
        sb.append(str);
        int i2 = this.f30463b;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i2);
        sb.append(sb3.toString());
        sb.append(str);
        long j = this.f30464c;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j);
        sb.append(sb4.toString());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, mo32996a());
        SafeParcelWriter.m21957a(parcel, 2, mo32998d());
        SafeParcelWriter.m21958a(parcel, 3, mo32997c());
        SafeParcelWriter.m21954a(parcel, a);
    }
}
