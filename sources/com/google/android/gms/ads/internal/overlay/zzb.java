package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Creator<zzc> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Intent intent = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 2:
                    str = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 3:
                    str2 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 4:
                    str3 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 5:
                    str4 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 6:
                    str5 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 7:
                    str6 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 8:
                    str7 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.m21921a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzc zzc = new zzc(str, str2, str3, str4, str5, str6, str7, intent);
        return zzc;
    }
}
