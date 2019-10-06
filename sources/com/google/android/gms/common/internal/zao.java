package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zao implements Creator<SignInButtonConfig> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInButtonConfig[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 3) {
                i3 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 4) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.m21926b(parcel, a, Scope.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new SignInButtonConfig(i, i2, i3, scopeArr);
    }
}
