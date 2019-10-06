package android.support.p000v4.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.p000v4.view.ViewPager.SavedState;

/* renamed from: android.support.v4.view.E */
/* compiled from: ViewPager */
class C0580E implements ClassLoaderCreator<SavedState> {
    C0580E() {
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
