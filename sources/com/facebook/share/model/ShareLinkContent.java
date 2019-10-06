package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Object> {
    public static final Creator<ShareLinkContent> CREATOR = new C6803b();
    @Deprecated

    /* renamed from: g */
    private final String f12510g;
    @Deprecated

    /* renamed from: h */
    private final String f12511h;
    @Deprecated

    /* renamed from: i */
    private final Uri f12512i;

    /* renamed from: j */
    private final String f12513j;

    ShareLinkContent(Parcel in) {
        super(in);
        this.f12510g = in.readString();
        this.f12511h = in.readString();
        this.f12512i = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.f12513j = in.readString();
    }

    /* renamed from: c */
    public String mo20165c() {
        return this.f12513j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(this.f12510g);
        out.writeString(this.f12511h);
        out.writeParcelable(this.f12512i, 0);
        out.writeString(this.f12513j);
    }
}
