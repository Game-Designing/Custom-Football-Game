package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzai implements Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 2:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 3:
                    z3 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 4:
                    z4 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 5:
                    z5 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 6:
                    z6 = SafeParcelReader.m21945s(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        LocationSettingsStates locationSettingsStates = new LocationSettingsStates(z, z2, z3, z4, z5, z6);
        return locationSettingsStates;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
