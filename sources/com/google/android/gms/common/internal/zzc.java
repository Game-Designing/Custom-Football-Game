package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Creator<zzb> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzb[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                bundle = SafeParcelReader.m21932f(parcel, a);
            } else if (a2 != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                featureArr = (Feature[]) SafeParcelReader.m21926b(parcel, a, Feature.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzb(bundle, featureArr);
    }
}
