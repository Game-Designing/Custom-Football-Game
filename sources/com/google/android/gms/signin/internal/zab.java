package com.google.android.gms.signin.internal;

import android.content.Intent;
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
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                intent = (Intent) SafeParcelReader.m21921a(parcel, a, Intent.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zaa(i, i2, intent);
    }
}
