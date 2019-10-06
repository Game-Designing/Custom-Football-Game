package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzauz implements Creator<zzauy> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzauy[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
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
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 5:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 6:
                    list = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 7:
                    z3 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 8:
                    z4 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 9:
                    list2 = SafeParcelReader.m21943q(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzauy zzauy = new zzauy(str, str2, z, z2, list, z3, z4, list2);
        return zzauy;
    }
}
