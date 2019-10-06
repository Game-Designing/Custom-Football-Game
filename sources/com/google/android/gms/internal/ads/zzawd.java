package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzawd implements Creator<zzawc> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzawc[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        String str2 = null;
        zzyd zzyd = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 2) {
                str2 = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                zzyd = (zzyd) SafeParcelReader.m21921a(parcel, a, zzyd.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzawc(str, str2, zzyd);
    }
}
