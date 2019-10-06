package com.airbnb.lottie;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.airbnb.lottie.f */
/* compiled from: LottieAnimationView */
class C5823f implements Creator<SavedState> {
    C5823f() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in, null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
