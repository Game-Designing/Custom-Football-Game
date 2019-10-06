package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareOpenGraphAction.C6800a;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C6806e();

    /* renamed from: g */
    private final ShareOpenGraphAction f12515g;

    /* renamed from: h */
    private final String f12516h;

    ShareOpenGraphContent(Parcel in) {
        super(in);
        this.f12515g = new C6800a().mo20168a(in).mo20171a();
        this.f12516h = in.readString();
    }

    /* renamed from: c */
    public ShareOpenGraphAction mo20172c() {
        return this.f12515g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(this.f12515g, 0);
        out.writeString(this.f12516h);
    }
}
