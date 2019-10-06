package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaid implements Creator<zzaic> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaic[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j = 0;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 2:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 3:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 4:
                    bArr = SafeParcelReader.m21933g(parcel2, a);
                    break;
                case 5:
                    strArr = SafeParcelReader.m21942p(parcel2, a);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.m21942p(parcel2, a);
                    break;
                case 7:
                    z2 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 8:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzaic zzaic = new zzaic(z, str, i, bArr, strArr, strArr2, z2, j);
        return zzaic;
    }
}
