package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new zzb();

    /* renamed from: a */
    private List<DetectedActivity> f30453a;

    /* renamed from: b */
    private long f30454b;

    /* renamed from: c */
    private long f30455c;

    /* renamed from: d */
    private int f30456d;

    /* renamed from: e */
    private Bundle f30457e;

    @Constructor
    public ActivityRecognitionResult(@Param(id = 1) List<DetectedActivity> list, @Param(id = 2) long j, @Param(id = 3) long j2, @Param(id = 4) int i, @Param(id = 5) Bundle bundle) {
        boolean z = true;
        Preconditions.m21864a(list != null && list.size() > 0, (Object) "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        Preconditions.m21864a(z, (Object) "Must set times");
        this.f30453a = list;
        this.f30454b = j;
        this.f30455c = j2;
        this.f30456d = i;
        this.f30457e = bundle;
    }

    /* renamed from: a */
    private static boolean m32659a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || ((bundle != null && bundle2 == null) || bundle.size() != bundle2.size())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!m32659a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityRecognitionResult.class == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            return this.f30454b == activityRecognitionResult.f30454b && this.f30455c == activityRecognitionResult.f30455c && this.f30456d == activityRecognitionResult.f30456d && Objects.m21851a(this.f30453a, activityRecognitionResult.f30453a) && m32659a(this.f30457e, activityRecognitionResult.f30457e);
        }
    }

    public int hashCode() {
        return Objects.m21849a(Long.valueOf(this.f30454b), Long.valueOf(this.f30455c), Integer.valueOf(this.f30456d), this.f30453a, this.f30457e);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f30453a);
        long j = this.f30454b;
        long j2 = this.f30455c;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + Opcodes.IUSHR);
        sb.append("ActivityRecognitionResult [probableActivities=");
        sb.append(valueOf);
        sb.append(", timeMillis=");
        sb.append(j);
        sb.append(", elapsedRealtimeMillis=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21977c(parcel, 1, this.f30453a, false);
        SafeParcelWriter.m21958a(parcel, 2, this.f30454b);
        SafeParcelWriter.m21958a(parcel, 3, this.f30455c);
        SafeParcelWriter.m21957a(parcel, 4, this.f30456d);
        SafeParcelWriter.m21959a(parcel, 5, this.f30457e, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
