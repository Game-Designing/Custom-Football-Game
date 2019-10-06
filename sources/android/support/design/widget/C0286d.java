package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.design.widget.d */
/* compiled from: AppBarLayout */
class C0286d implements ClassLoaderCreator<SavedState> {
    C0286d() {
    }

    public SavedState createFromParcel(Parcel source, ClassLoader loader) {
        return new SavedState(source, loader);
    }

    public SavedState createFromParcel(Parcel source) {
        return new SavedState(source, null);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
