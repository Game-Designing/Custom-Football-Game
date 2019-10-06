package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzyb implements Creator<zzxz> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzxz[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        Bundle bundle = null;
        List list = null;
        String str = null;
        zzaca zzaca = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        zzxt zzxt = null;
        String str5 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 2:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 3:
                    bundle = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 4:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 5:
                    list = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 6:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 7:
                    i3 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 8:
                    z2 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 9:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 10:
                    zzaca = (zzaca) SafeParcelReader.m21921a(parcel2, a, zzaca.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.m21921a(parcel2, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 15:
                    list2 = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 16:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 17:
                    str4 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 18:
                    z3 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 19:
                    zzxt = (zzxt) SafeParcelReader.m21921a(parcel2, a, zzxt.CREATOR);
                    break;
                case 20:
                    i4 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 21:
                    str5 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzxz zzxz = new zzxz(i, j, bundle, i2, list, z, i3, z2, str, zzaca, location, str2, bundle2, bundle3, list2, str3, str4, z3, zzxt, i4, str5);
        return zzxz;
    }
}
