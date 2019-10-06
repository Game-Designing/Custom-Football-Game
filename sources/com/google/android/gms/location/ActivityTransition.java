package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ActivityTransition extends AbstractSafeParcelable {
    public static final Creator<ActivityTransition> CREATOR = new zzc();

    /* renamed from: a */
    private final int f30458a;

    /* renamed from: b */
    private final int f30459b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    public static class Builder {

        /* renamed from: a */
        private int f30460a = -1;

        /* renamed from: b */
        private int f30461b = -1;
    }

    @Constructor
    ActivityTransition(@Param(id = 1) int i, @Param(id = 2) int i2) {
        this.f30458a = i;
        this.f30459b = i2;
    }

    /* renamed from: a */
    public static void m32660a(int i) {
        boolean z = true;
        if (i < 0 || i > 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(41);
        sb.append("Transition type ");
        sb.append(i);
        sb.append(" is not valid.");
        Preconditions.m21864a(z, (Object) sb.toString());
    }

    /* renamed from: a */
    public int mo32990a() {
        return this.f30458a;
    }

    /* renamed from: c */
    public int mo32991c() {
        return this.f30459b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f30458a == activityTransition.f30458a && this.f30459b == activityTransition.f30459b;
    }

    public int hashCode() {
        return Objects.m21849a(Integer.valueOf(this.f30458a), Integer.valueOf(this.f30459b));
    }

    public String toString() {
        int i = this.f30458a;
        int i2 = this.f30459b;
        StringBuilder sb = new StringBuilder(75);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i);
        sb.append(", mTransitionType=");
        sb.append(i2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, mo32990a());
        SafeParcelWriter.m21957a(parcel, 2, mo32991c());
        SafeParcelWriter.m21954a(parcel, a);
    }
}
