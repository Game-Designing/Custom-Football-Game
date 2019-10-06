package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzati implements Creator<zzath> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzath[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        zzxz zzxz = null;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                zzxz = (zzxz) SafeParcelReader.m21921a(parcel, a, zzxz.CREATOR);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzath(zzxz, str);
    }
}
