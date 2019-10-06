package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzace implements Creator<zzacd> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzacd[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 == 3) {
                z2 = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 != 4) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                z3 = SafeParcelReader.m21945s(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzacd(z, z2, z3);
    }
}
