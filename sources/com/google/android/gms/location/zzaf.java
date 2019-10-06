package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaf implements Creator<zzae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = "";
        String str2 = str;
        String str3 = str2;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                str2 = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 2) {
                str3 = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzae(str, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
