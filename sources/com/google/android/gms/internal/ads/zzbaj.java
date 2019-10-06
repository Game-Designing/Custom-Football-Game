package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbaj implements Creator<zzbai> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbai[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 3) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 4) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 5) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 != 6) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                z2 = SafeParcelReader.m21945s(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzbai zzbai = new zzbai(str, i, i2, z, z2);
        return zzbai;
    }
}
