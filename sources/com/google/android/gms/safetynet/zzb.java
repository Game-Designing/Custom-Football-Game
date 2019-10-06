package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Creator<zza> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            if (SafeParcelReader.m21919a(a) != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zza(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
