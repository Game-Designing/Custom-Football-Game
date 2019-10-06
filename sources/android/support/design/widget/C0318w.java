package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.design.widget.w */
/* compiled from: BottomSheetBehavior */
class C0318w implements ClassLoaderCreator<SavedState> {
    C0318w() {
    }

    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
        return new SavedState(in, loader);
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in, (ClassLoader) null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
