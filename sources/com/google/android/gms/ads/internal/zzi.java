package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzi implements Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f = 0.0f;
        int i = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 2:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 3:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 4:
                    str = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 5:
                    z3 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 6:
                    f = SafeParcelReader.m21947u(parcel, a);
                    break;
                case 7:
                    i = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 8:
                    z4 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 9:
                    z5 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 10:
                    z6 = SafeParcelReader.m21945s(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzh zzh = new zzh(z, z2, str, z3, f, i, z4, z5, z6);
        return zzh;
    }
}
