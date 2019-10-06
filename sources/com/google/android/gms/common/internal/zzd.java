package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Creator<GetServiceRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 2:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 3:
                    i3 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 4:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 5:
                    iBinder = SafeParcelReader.m21948v(parcel2, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.m21926b(parcel2, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.m21932f(parcel2, a);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.m21921a(parcel2, a, Account.CREATOR);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.m21926b(parcel2, a, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.m21926b(parcel2, a, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        GetServiceRequest getServiceRequest = new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z);
        return getServiceRequest;
    }
}
