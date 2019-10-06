package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new zza();

    /* renamed from: a */
    private final int f30526a;

    /* renamed from: b */
    private final String f30527b;

    /* renamed from: c */
    private final String f30528c;

    /* renamed from: d */
    private final String f30529d;

    @Constructor
    PlaceReport(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3) {
        this.f30526a = i;
        this.f30527b = str;
        this.f30528c = str2;
        this.f30529d = str3;
    }

    /* renamed from: a */
    public String mo33048a() {
        return this.f30527b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return Objects.m21851a(this.f30527b, placeReport.f30527b) && Objects.m21851a(this.f30528c, placeReport.f30528c) && Objects.m21851a(this.f30529d, placeReport.f30529d);
    }

    public String getTag() {
        return this.f30528c;
    }

    public int hashCode() {
        return Objects.m21849a(this.f30527b, this.f30528c, this.f30529d);
    }

    public String toString() {
        ToStringHelper a = Objects.m21850a((Object) this);
        a.mo27810a("placeId", this.f30527b);
        a.mo27810a(BundleCons.TAG, this.f30528c);
        if (!"unknown".equals(this.f30529d)) {
            a.mo27810a("source", this.f30529d);
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21957a(parcel, 1, this.f30526a);
        SafeParcelWriter.m21965a(parcel, 2, mo33048a(), false);
        SafeParcelWriter.m21965a(parcel, 3, getTag(), false);
        SafeParcelWriter.m21965a(parcel, 4, this.f30529d, false);
        SafeParcelWriter.m21954a(parcel, a);
    }
}
