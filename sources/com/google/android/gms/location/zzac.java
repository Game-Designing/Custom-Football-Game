package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzac implements Creator<LocationResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        List<Location> list = LocationResult.f30501a;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            if (SafeParcelReader.m21919a(a) != 1) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                list = SafeParcelReader.m21929c(parcel, a, Location.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationResult[i];
    }
}
