package com.astuetz;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.astuetz.c */
/* compiled from: PagerSlidingTabStrip */
class C5898c implements Creator<SavedState> {
    C5898c() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in, null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
