package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionResult> CREATOR = new zzg();

    /* renamed from: a */
    private final List<ActivityTransitionEvent> f30469a;

    @Constructor
    public ActivityTransitionResult(@Param(id = 1) List<ActivityTransitionEvent> list) {
        Preconditions.m21858a(list, (Object) "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i = 1; i < list.size(); i++) {
                Preconditions.m21863a(((ActivityTransitionEvent) list.get(i)).mo32997c() >= ((ActivityTransitionEvent) list.get(i + -1)).mo32997c());
            }
        }
        this.f30469a = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    public List<ActivityTransitionEvent> mo33007a() {
        return this.f30469a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ActivityTransitionResult.class != obj.getClass()) {
            return false;
        }
        return this.f30469a.equals(((ActivityTransitionResult) obj).f30469a);
    }

    public int hashCode() {
        return this.f30469a.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21977c(parcel, 1, mo33007a(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
