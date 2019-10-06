package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzbai;

public final class zzn implements Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        zzc zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzbai zzbai = null;
        String str4 = null;
        zzh zzh = null;
        IBinder iBinder6 = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 2:
                    zzc = (zzc) SafeParcelReader.m21921a(parcel2, a, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 7:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 8:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 9:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 11:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 12:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 13:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 14:
                    zzbai = (zzbai) SafeParcelReader.m21921a(parcel2, a, zzbai.CREATOR);
                    break;
                case 16:
                    str4 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 17:
                    zzh = (zzh) SafeParcelReader.m21921a(parcel2, a, zzh.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.m21948v(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzbai, str4, zzh, iBinder6);
        return adOverlayInfoParcel;
    }
}
