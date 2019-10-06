package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzvt implements Creator<zzvs> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzvs[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            if (SafeParcelReader.m21919a(a) != 2) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.m21921a(parcel, a, ParcelFileDescriptor.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzvs(parcelFileDescriptor);
    }
}
