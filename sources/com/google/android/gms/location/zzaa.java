package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaa implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        zzaj[] zzajArr = null;
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                i3 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 3) {
                j = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 == 4) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                zzajArr = (zzaj[]) SafeParcelReader.m21926b(parcel, a, zzaj.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        LocationAvailability locationAvailability = new LocationAvailability(i, i2, i3, j, zzajArr);
        return locationAvailability;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
