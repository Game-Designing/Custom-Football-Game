package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzarl implements Creator<zzark> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzark[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        boolean z = false;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                arrayList = SafeParcelReader.m21943q(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzark(z, arrayList);
    }
}
