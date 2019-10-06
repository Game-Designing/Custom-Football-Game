package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzi implements Creator<zzh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                z = SafeParcelReader.m21945s(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzh(i, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }
}
