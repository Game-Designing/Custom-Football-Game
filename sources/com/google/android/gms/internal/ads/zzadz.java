package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzadz implements Creator<zzady> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzady[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        zzacd zzacd = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 2:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 3:
                    i2 = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 4:
                    z2 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 6:
                    zzacd = (zzacd) SafeParcelReader.m21921a(parcel, a, zzacd.CREATOR);
                    break;
                case 7:
                    z3 = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 8:
                    i4 = SafeParcelReader.m21949w(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzady zzady = new zzady(i, z, i2, z2, i3, zzacd, z3, i4);
        return zzady;
    }
}
