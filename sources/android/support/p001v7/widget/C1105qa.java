package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p001v7.widget.LinearLayoutManager.SavedState;

/* renamed from: android.support.v7.widget.qa */
/* compiled from: LinearLayoutManager */
class C1105qa implements Creator<SavedState> {
    C1105qa() {
    }

    public SavedState createFromParcel(Parcel in) {
        return new SavedState(in);
    }

    public SavedState[] newArray(int size) {
        return new SavedState[size];
    }
}
