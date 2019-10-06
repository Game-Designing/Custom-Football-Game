package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzk implements Creator<TokenData> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        Long l = null;
        List list = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 2:
                    str = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 3:
                    l = SafeParcelReader.m21952z(parcel, a);
                    break;
                case 4:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 5:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 6:
                    list = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 7:
                    str2 = SafeParcelReader.m21941o(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        TokenData tokenData = new TokenData(i, str, l, z, z2, list, str2);
        return tokenData;
    }
}
