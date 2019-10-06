package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzary implements Creator<zzarx> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzarx[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        Bundle bundle = null;
        zzbai zzbai = null;
        ApplicationInfo applicationInfo = null;
        String str = null;
        List list = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    bundle = SafeParcelReader.m21932f(parcel, a);
                    break;
                case 2:
                    zzbai = (zzbai) SafeParcelReader.m21921a(parcel, a, zzbai.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.m21921a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 5:
                    list = SafeParcelReader.m21943q(parcel, a);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.m21921a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = SafeParcelReader.m21941o(parcel, a);
                    break;
                case 8:
                    z = SafeParcelReader.m21945s(parcel, a);
                    break;
                case 9:
                    str3 = SafeParcelReader.m21941o(parcel, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        zzarx zzarx = new zzarx(bundle, zzbai, applicationInfo, str, list, packageInfo, str2, z, str3);
        return zzarx;
    }
}
