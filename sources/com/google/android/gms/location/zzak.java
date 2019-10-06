package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzak implements Creator<zzaj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        long j = -1;
        long j2 = -1;
        int i = 1;
        int i2 = 1;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 3) {
                j = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 != 4) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                j2 = SafeParcelReader.m21951y(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzaj zzaj = new zzaj(i, i2, j, j2);
        return zzaj;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaj[i];
    }
}
