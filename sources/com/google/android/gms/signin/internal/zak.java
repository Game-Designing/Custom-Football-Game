package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zak implements Creator<zaj> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zaj[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.m21921a(parcel, a, ConnectionResult.CREATOR);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.m21921a(parcel, a, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zaj(i, connectionResult, resolveAccountResponse);
    }
}
