package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaay implements Creator<zzaax> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaax[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            if (SafeParcelReader.m21919a(a) != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                i = SafeParcelReader.m21949w(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzaax(i);
    }
}
