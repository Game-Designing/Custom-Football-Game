package android.support.p001v7.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v7.widget.jb */
/* compiled from: StaggeredGridLayoutManager */
class C1074jb implements Creator<FullSpanItem> {
    C1074jb() {
    }

    public FullSpanItem createFromParcel(Parcel in) {
        return new FullSpanItem(in);
    }

    public FullSpanItem[] newArray(int size) {
        return new FullSpanItem[size];
    }
}
