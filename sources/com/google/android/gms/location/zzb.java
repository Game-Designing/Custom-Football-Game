package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzb implements Creator<ActivityRecognitionResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = SafeParcelReader.m21925b(parcel);
        long j = 0;
        long j2 = 0;
        List list = null;
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = SafeParcelReader.m21920a(parcel);
            int a2 = SafeParcelReader.m21919a(a);
            if (a2 == 1) {
                list = SafeParcelReader.m21929c(parcel, a, DetectedActivity.CREATOR);
            } else if (a2 == 2) {
                j = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 == 3) {
                j2 = SafeParcelReader.m21951y(parcel, a);
            } else if (a2 == 4) {
                i = SafeParcelReader.m21949w(parcel, a);
            } else if (a2 != 5) {
                SafeParcelReader.m21918C(parcel, a);
            } else {
                bundle = SafeParcelReader.m21932f(parcel, a);
            }
        }
        SafeParcelReader.m21944r(parcel, b);
        ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult(list, j, j2, i, bundle);
        return activityRecognitionResult;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
