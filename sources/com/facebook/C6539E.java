package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.facebook.E */
/* compiled from: Profile */
class C6539E implements Creator<Profile> {
    C6539E() {
    }

    public Profile createFromParcel(Parcel source) {
        return new Profile(source, null);
    }

    public Profile[] newArray(int size) {
        return new Profile[size];
    }
}
