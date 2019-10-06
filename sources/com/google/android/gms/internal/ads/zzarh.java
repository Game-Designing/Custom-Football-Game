package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

public final class zzarh implements Creator<zzarg> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzarg[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        zzxz zzxz = null;
        zzyd zzyd = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzbai zzbai = null;
        Bundle bundle2 = null;
        List list = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        zzady zzady = null;
        List list3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzaax zzaax = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        List list4 = null;
        String str15 = null;
        List list5 = null;
        ArrayList arrayList = null;
        String str16 = null;
        zzaiy zzaiy = null;
        String str17 = null;
        Bundle bundle6 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 2:
                    bundle = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 3:
                    zzxz = (zzxz) SafeParcelReader.m21921a(parcel2, a, zzxz.CREATOR);
                    break;
                case 4:
                    zzyd = (zzyd) SafeParcelReader.m21921a(parcel2, a, zzyd.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.m21921a(parcel2, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.m21921a(parcel2, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 9:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 10:
                    str4 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 11:
                    zzbai = (zzbai) SafeParcelReader.m21921a(parcel2, a, zzbai.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 13:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 14:
                    list = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 16:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 18:
                    i3 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 19:
                    i4 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 20:
                    f = SafeParcelReader.m21947u(parcel2, a);
                    break;
                case 21:
                    str5 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 25:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 26:
                    str6 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 27:
                    list2 = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 28:
                    str7 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 29:
                    zzady = (zzady) SafeParcelReader.m21921a(parcel2, a, zzady.CREATOR);
                    break;
                case 30:
                    list3 = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 31:
                    j2 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 33:
                    str8 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 34:
                    f2 = SafeParcelReader.m21947u(parcel2, a);
                    break;
                case 35:
                    i5 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 36:
                    i6 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 37:
                    z3 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 38:
                    z4 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 39:
                    str9 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 40:
                    z2 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 41:
                    str10 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 42:
                    z5 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 43:
                    i7 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 45:
                    str11 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 46:
                    zzaax = (zzaax) SafeParcelReader.m21921a(parcel2, a, zzaax.CREATOR);
                    break;
                case 47:
                    z6 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 49:
                    str12 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 50:
                    str13 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 51:
                    str14 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 52:
                    z7 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 53:
                    list4 = SafeParcelReader.m21937k(parcel2, a);
                    break;
                case 54:
                    str15 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 55:
                    list5 = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 56:
                    i8 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 57:
                    z8 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 58:
                    z9 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 59:
                    z10 = SafeParcelReader.m21945s(parcel2, a);
                    break;
                case 60:
                    arrayList = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 61:
                    str16 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 63:
                    zzaiy = (zzaiy) SafeParcelReader.m21921a(parcel2, a, zzaiy.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.m21932f(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        zzarg zzarg = new zzarg(i, bundle, zzxz, zzyd, str, applicationInfo, packageInfo, str2, str3, str4, zzbai, bundle2, i2, list, bundle3, z, i3, i4, f, str5, j, str6, list2, str7, zzady, list3, j2, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzaax, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i8, z8, z9, z10, arrayList, str16, zzaiy, str17, bundle6);
        return zzarg;
    }
}
