package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.design.widget.da */
/* compiled from: TextInputLayout */
class C0287da implements ClassLoaderCreator<SavedState> {
    C0287da() {
    }

    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
        return new SavedState(in, loader);
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in, null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
