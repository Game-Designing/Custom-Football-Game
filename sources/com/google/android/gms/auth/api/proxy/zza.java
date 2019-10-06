package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Creator<ProxyRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 2) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 3) {
                j = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 == 4) {
                bArr = SafeParcelReader.m21933g(parcel, a);
            } else if (a2 == 5) {
                bundle = SafeParcelReader.m21932f(parcel, a);
            } else if (a2 != 1000) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                i = SafeParcelReader.m21949w(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        ProxyRequest proxyRequest = new ProxyRequest(i, str, i2, j, bArr, bundle);
        return proxyRequest;
    }
}
