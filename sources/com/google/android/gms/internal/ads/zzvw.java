package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzvw implements Creator<zzvv> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzvv[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 2:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 3:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 4:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 5:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 6:
                    str4 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 7:
                    bundle = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 8:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 9:
                    j2 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzvv zzvv = new zzvv(str, j, str2, str3, str4, bundle, z, j2);
        return zzvv;
    }
}
