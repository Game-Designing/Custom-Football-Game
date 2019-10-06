package android.support.p000v4.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.view.a */
/* compiled from: AbsSavedState */
class C0602a implements ClassLoaderCreator<AbsSavedState> {
    C0602a() {
    }

    public AbsSavedState createFromParcel(Parcel in, ClassLoader loader) {
        if (in.readParcelable(loader) == null) {
            return AbsSavedState.f1791a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public AbsSavedState createFromParcel(Parcel in) {
        return createFromParcel(in, (ClassLoader) null);
    }

    public AbsSavedState[] newArray(int size) {
        return new AbsSavedState[size];
    }
}
