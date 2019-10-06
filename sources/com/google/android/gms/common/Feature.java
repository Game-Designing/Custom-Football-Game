package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.unity3d.ads.metadata.MediationMetaData;

@KeepForSdk
public class Feature extends AbstractSafeParcelable {
    public static final Creator<Feature> CREATOR = new zzb();

    /* renamed from: a */
    private final String f19517a;
    @Deprecated

    /* renamed from: b */
    private final int f19518b;

    /* renamed from: c */
    private final long f19519c;

    @Constructor
    public Feature(@Param(id = 1) String str, @Param(id = 2) int i, @Param(id = 3) long j) {
        this.f19517a = str;
        this.f19518b = i;
        this.f19519c = j;
    }

    @KeepForSdk
    /* renamed from: a */
    public String mo27288a() {
        return this.f19517a;
    }

    @KeepForSdk
    /* renamed from: c */
    public long mo27289c() {
        long j = this.f19519c;
        return j == -1 ? (long) this.f19518b : j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 1, mo27288a(), false);
        SafeParcelWriter.m21957a(parcel, 2, this.f19518b);
        SafeParcelWriter.m21958a(parcel, 3, mo27289c());
        SafeParcelWriter.m21954a(parcel, a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        if (((mo27288a() == null || !mo27288a().equals(feature.mo27288a())) && (mo27288a() != null || feature.mo27288a() != null)) || mo27289c() != feature.mo27289c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.m21849a(mo27288a(), Long.valueOf(mo27289c()));
    }

    public String toString() {
        return Objects.m21850a((Object) this).mo27810a("name", mo27288a()).mo27810a(MediationMetaData.KEY_VERSION, Long.valueOf(mo27289c())).toString();
    }
}
