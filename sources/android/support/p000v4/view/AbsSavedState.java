package android.support.p000v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.view.AbsSavedState */
public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new C0602a();

    /* renamed from: a */
    public static final AbsSavedState f1791a = new AbsSavedState() {
    };

    /* renamed from: b */
    private final Parcelable f1792b;

    private AbsSavedState() {
        this.f1792b = null;
    }

    protected AbsSavedState(Parcelable superState) {
        if (superState != null) {
            this.f1792b = superState != f1791a ? superState : null;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel source, ClassLoader loader) {
        Parcelable superState = source.readParcelable(loader);
        this.f1792b = superState != null ? superState : f1791a;
    }

    /* renamed from: a */
    public final Parcelable mo5452a() {
        return this.f1792b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.f1792b, flags);
    }
}
