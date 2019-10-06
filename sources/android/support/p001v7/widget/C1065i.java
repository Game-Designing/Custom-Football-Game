package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v7.widget.i */
/* compiled from: ActionMenuPresenter */
class C1065i implements Creator<SavedState> {
    C1065i() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
