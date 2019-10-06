package android.support.p000v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.RatingCompat */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C0540g();

    /* renamed from: a */
    private final int f1740a;

    /* renamed from: b */
    private final float f1741b;

    RatingCompat(int ratingStyle, float rating) {
        this.f1740a = ratingStyle;
        this.f1741b = rating;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f1740a);
        sb.append(" rating=");
        float f = this.f1741b;
        if (f < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f);
        }
        sb.append(str);
        return sb.toString();
    }

    public int describeContents() {
        return this.f1740a;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f1740a);
        dest.writeFloat(this.f1741b);
    }
}
