package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzye implements Creator<zzyd> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzyd[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        zzyd[] zzydArr = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
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
                    i = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 5:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 6:
                    i3 = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 7:
                    i4 = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 8:
                    zzydArr = (zzyd[]) SafeParcelReader.m21926b(parcel, a, zzyd.CREATOR);
                    break;
                case 9:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 10:
                    z3 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 11:
                    z4 = SafeParcelReader.m21945s(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzyd zzyd = new zzyd(str, i, i2, z, i3, i4, zzydArr, z2, z3, z4);
        return zzyd;
    }
}
