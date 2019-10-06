package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Creator<ActivityTransitionRequest> CREATOR = new zzf();

    /* renamed from: a */
    public static final Comparator<ActivityTransition> f30465a = new C10031c();

    /* renamed from: b */
    private final List<ActivityTransition> f30466b;

    /* renamed from: c */
    private final String f30467c;

    /* renamed from: d */
    private final List<ClientIdentity> f30468d;

    @Constructor
    public ActivityTransitionRequest(@Param(id = 1) List<ActivityTransition> list, @Param(id = 2) String str, @Param(id = 3) List<ClientIdentity> list2) {
        Preconditions.m21858a(list, (Object) "transitions can't be null");
        Preconditions.m21864a(list.size() > 0, (Object) "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(f30465a);
        for (ActivityTransition activityTransition : list) {
            Preconditions.m21864a(treeSet.add(activityTransition), (Object) String.format("Found duplicated transition: %s.", new Object[]{activityTransition}));
        }
        this.f30466b = Collections.unmodifiableList(list);
        this.f30467c = str;
        this.f30468d = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityTransitionRequest.class == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            return Objects.m21851a(this.f30466b, activityTransitionRequest.f30466b) && Objects.m21851a(this.f30467c, activityTransitionRequest.f30467c) && Objects.m21851a(this.f30468d, activityTransitionRequest.f30468d);
        }
    }

    public int hashCode() {
        int hashCode = this.f30466b.hashCode() * 31;
        String str = this.f30467c;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f30468d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f30466b);
        String str = this.f30467c;
        String valueOf2 = String.valueOf(this.f30468d);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61 + String.valueOf(str).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21977c(parcel, 1, this.f30466b, false);
        SafeParcelWriter.m21965a(parcel, 2, this.f30467c, false);
        SafeParcelWriter.m21977c(parcel, 3, this.f30468d, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
