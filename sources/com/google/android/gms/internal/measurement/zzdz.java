package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdz implements Creator<zzdy> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdy[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 2:
                    j2 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 3:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 4:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 5:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 6:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 7:
                    bundle = SafeParcelReader.m21932f(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzdy zzdy = new zzdy(j, j2, z, str, str2, str3, bundle);
        return zzdy;
    }
}
