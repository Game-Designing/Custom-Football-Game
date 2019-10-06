package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzp implements Creator<zzo> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        List list = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel, a);
                    break;
                case 2:
                    list = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 3:
                    list2 = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 4:
                    list3 = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 5:
                    list4 = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 6:
                    list5 = SafeParcelReader.m21943q(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzo zzo = new zzo(i, list, list2, list3, list4, list5);
        return zzo;
    }
}
