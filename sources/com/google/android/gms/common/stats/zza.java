package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zza implements Creator<WakeLockEvent> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        List list = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            switch (SafeParcelReader.m21919a(a)) {
                case 1:
                    i = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 2:
                    j = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 4:
                    str = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 5:
                    i3 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 6:
                    list = SafeParcelReader.m21943q(parcel2, a);
                    break;
                case 8:
                    j2 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 10:
                    str3 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 11:
                    i2 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 12:
                    str2 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 13:
                    str4 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 14:
                    i4 = SafeParcelReader.m21949w(parcel2, a);
                    break;
                case 15:
                    f = SafeParcelReader.m21947u(parcel2, a);
                    break;
                case 16:
                    j3 = SafeParcelReader.m21951y(parcel2, a);
                    break;
                case 17:
                    str5 = SafeParcelReader.m21941o(parcel2, a);
                    break;
                case 18:
                    z = SafeParcelReader.m21945s(parcel2, a);
                    break;
                default:
                    SafeParcelReader.m21918C(parcel2, a);
                    break;
            }
        }
        SafeParcelReader.m21944r(parcel2, b);
        WakeLockEvent wakeLockEvent = new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5, z);
        return wakeLockEvent;
    }
}
