package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zac implements Creator<DataHolder> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                strArr = SafeParcelReader.m21942p(parcel, a);
            } else if (a2 == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.m21926b(parcel, a, CursorWindow.CREATOR);
            } else if (a2 == 3) {
                i2 = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 == 4) {
                bundle = SafeParcelReader.m21932f(parcel, a);
            } else if (a2 != 1000) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                i = SafeParcelReader.m21949w(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
        dataHolder.mo27671d();
        return dataHolder;
    }
}
