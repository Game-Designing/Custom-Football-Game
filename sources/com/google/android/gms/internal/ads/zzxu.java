package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzxu implements Creator<zzxt> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzxt[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str2 = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzxt(str, str2);
    }
}
