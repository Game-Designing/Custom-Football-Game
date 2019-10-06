package android.support.p000v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.g */
/* compiled from: RatingCompat */
class C0540g implements Creator<RatingCompat> {
    C0540g() {
    }

    public RatingCompat createFromParcel(Parcel p) {
        return new RatingCompat(p.readInt(), p.readFloat());
    }

    public RatingCompat[] newArray(int size) {
        return new RatingCompat[size];
    }
}
