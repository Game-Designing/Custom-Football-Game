package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.p001v7.widget.RecyclerView.SavedState;

/* renamed from: android.support.v7.widget.Ka */
/* compiled from: RecyclerView */
class C0951Ka implements ClassLoaderCreator<SavedState> {
    C0951Ka() {
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
