package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzl implements Creator<zzk> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 2) {
                iBinder = SafeParcelReader.m21948v(parcel, a);
            } else if (a2 == 3) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 != 4) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                z2 = SafeParcelReader.m21945s(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzk(str, iBinder, z, z2);
    }
}
