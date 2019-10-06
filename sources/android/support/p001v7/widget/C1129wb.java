package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.p001v7.widget.Toolbar.SavedState;

/* renamed from: android.support.v7.widget.wb */
/* compiled from: Toolbar */
class C1129wb implements ClassLoaderCreator<SavedState> {
    C1129wb() {
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
