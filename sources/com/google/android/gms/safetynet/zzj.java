package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzj implements Creator<SafeBrowsingData> {
    /* renamed from: a */
    static void m32732a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int a = SafeParcelWriter.m21953a(parcel);
        SafeParcelWriter.m21965a(parcel, 2, safeBrowsingData.mo33122e(), false);
        SafeParcelWriter.m21962a(parcel, 3, (Parcelable) safeBrowsingData.mo33119a(), i, false);
        SafeParcelWriter.m21962a(parcel, 4, (Parcelable) safeBrowsingData.mo33120c(), i, false);
        SafeParcelWriter.m21958a(parcel, 5, safeBrowsingData.mo33121d());
        SafeParcelWriter.m21969a(parcel, 6, safeBrowsingData.mo33123f(), false);
        SafeParcelWriter.m21954a(parcel, a);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 2) {
                str = SafeParcelReader.m21941o(parcel, a);
            } else if (a2 == 3) {
                dataHolder = (DataHolder) SafeParcelReader.m21921a(parcel, a, DataHolder.CREATOR);
            } else if (a2 == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.m21921a(parcel, a, ParcelFileDescriptor.CREATOR);
            } else if (a2 == 5) {
                j = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 != 6) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                bArr = SafeParcelReader.m21933g(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        SafeBrowsingData safeBrowsingData = new SafeBrowsingData(str, dataHolder, parcelFileDescriptor, j, bArr);
        return safeBrowsingData;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
