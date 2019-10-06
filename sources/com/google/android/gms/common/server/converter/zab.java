package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zab implements Creator<zaa> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zaa[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.m21921a(parcel, a, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zaa(i, stringToIntConverter);
    }
}
