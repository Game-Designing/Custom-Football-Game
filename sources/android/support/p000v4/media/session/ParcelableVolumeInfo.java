package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C0561k();

    /* renamed from: a */
    public int f1752a;

    /* renamed from: b */
    public int f1753b;

    /* renamed from: c */
    public int f1754c;

    /* renamed from: d */
    public int f1755d;

    /* renamed from: e */
    public int f1756e;

    public ParcelableVolumeInfo(Parcel from) {
        this.f1752a = from.readInt();
        this.f1754c = from.readInt();
        this.f1755d = from.readInt();
        this.f1756e = from.readInt();
        this.f1753b = from.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f1752a);
        dest.writeInt(this.f1754c);
        dest.writeInt(this.f1755d);
        dest.writeInt(this.f1756e);
        dest.writeInt(this.f1753b);
    }
}
