package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SharePhoto extends ShareMedia {
    public static final Creator<SharePhoto> CREATOR = new C6808g();

    /* renamed from: b */
    private final Bitmap f12519b;

    /* renamed from: c */
    private final Uri f12520c;

    /* renamed from: d */
    private final boolean f12521d;

    /* renamed from: e */
    private final String f12522e;

    SharePhoto(Parcel in) {
        super(in);
        this.f12519b = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
        this.f12520c = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.f12521d = in.readByte() != 0;
        this.f12522e = in.readString();
    }

    /* renamed from: a */
    public Uri mo20181a() {
        return this.f12520c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.f12519b, 0);
        out.writeParcelable(this.f12520c, 0);
        out.writeByte(this.f12521d ? (byte) 1 : 0);
        out.writeString(this.f12522e);
    }
}
