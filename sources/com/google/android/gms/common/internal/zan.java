package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan implements Creator<ResolveAccountResponse> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 2) {
                iBinder = SafeParcelReader.m21948v(parcel, a);
            } else if (a2 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.m21921a(parcel, a, ConnectionResult.CREATOR);
            } else if (a2 == 4) {
                z = SafeParcelReader.m21945s(parcel, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                z2 = SafeParcelReader.m21945s(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        ResolveAccountResponse resolveAccountResponse = new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
        return resolveAccountResponse;
    }
}
