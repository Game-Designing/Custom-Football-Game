package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzah implements Creator<LocationSettingsResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                status = (Status) SafeParcelReader.m21921a(parcel, a, Status.CREATOR);
            } else if (a2 != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.m21921a(parcel, a, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
