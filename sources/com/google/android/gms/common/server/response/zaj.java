package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public final class zaj implements Creator<zam> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zam[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        int i = 0;
        Field field = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                field = (Field) SafeParcelReader.m21921a(parcel, a, (Creator<T>) Field.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zam(i, str, field);
    }
}
