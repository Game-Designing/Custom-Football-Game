package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.HashSet;

public final class zzs implements Creator<zzr> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        zzt zzt = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
                hashSet.add(Integer.valueOf(1));
            } else if (a2 == 2) {
                zzt = (zzt) SafeParcelReader.m21921a(parcel, a, zzt.CREATOR);
                hashSet.add(Integer.valueOf(2));
            } else if (a2 == 3) {
                str = SafeParcelReader.m21941o(parcel, a);
                hashSet.add(Integer.valueOf(3));
            } else if (a2 == 4) {
                str2 = SafeParcelReader.m21941o(parcel, a);
                hashSet.add(Integer.valueOf(4));
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str3 = SafeParcelReader.m21941o(parcel, a);
                hashSet.add(Integer.valueOf(5));
            }
        }
        if (parcel.dataPosition() == b) {
            zzr zzr = new zzr(hashSet, i, zzt, str, str2, str3);
            return zzr;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(b);
        throw new ParseException(sb.toString(), parcel);
    }
}
