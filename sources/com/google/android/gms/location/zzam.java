package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzam implements Creator<zzal> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        ArrayList arrayList = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                arrayList = SafeParcelReader.m21943q(parcel, a);
            } else if (a2 == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.m21921a(parcel, a, PendingIntent.CREATOR);
            } else if (a2 != 3) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                str = SafeParcelReader.m21941o(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        return new zzal(arrayList, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzal[i];
    }
}
