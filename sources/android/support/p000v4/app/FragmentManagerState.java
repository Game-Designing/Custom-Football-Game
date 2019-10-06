package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.FragmentManagerState */
/* compiled from: FragmentManager */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C0420C();

    /* renamed from: a */
    FragmentState[] f1405a;

    /* renamed from: b */
    int[] f1406b;

    /* renamed from: c */
    BackStackState[] f1407c;

    /* renamed from: d */
    int f1408d = -1;

    /* renamed from: e */
    int f1409e;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel in) {
        this.f1405a = (FragmentState[]) in.createTypedArray(FragmentState.CREATOR);
        this.f1406b = in.createIntArray();
        this.f1407c = (BackStackState[]) in.createTypedArray(BackStackState.CREATOR);
        this.f1408d = in.readInt();
        this.f1409e = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.f1405a, flags);
        dest.writeIntArray(this.f1406b);
        dest.writeTypedArray(this.f1407c, flags);
        dest.writeInt(this.f1408d);
        dest.writeInt(this.f1409e);
    }
}
