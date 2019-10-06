package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p001v7.widget.StaggeredGridLayoutManager.SavedState;

/* renamed from: android.support.v7.widget.kb */
/* compiled from: StaggeredGridLayoutManager */
class C1078kb implements Creator<SavedState> {
    C1078kb() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
