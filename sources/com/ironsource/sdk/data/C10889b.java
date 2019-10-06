package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.ironsource.sdk.data.b */
/* compiled from: AdUnitsState */
class C10889b implements Creator<AdUnitsState> {
    C10889b() {
    }

    public AdUnitsState createFromParcel(Parcel source) {
        return new AdUnitsState(source, null);
    }

    public AdUnitsState[] newArray(int size) {
        return new AdUnitsState[size];
    }
}
