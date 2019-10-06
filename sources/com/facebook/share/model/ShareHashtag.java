package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ShareHashtag implements ShareModel {
    public static final Creator<ShareHashtag> CREATOR = new C6802a();

    /* renamed from: a */
    private final String f12508a;

    /* renamed from: com.facebook.share.model.ShareHashtag$a */
    public static class C6799a implements C6804c<ShareHashtag, C6799a> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f12509a;

        /* renamed from: a */
        public C6799a mo20163a(String hashtag) {
            this.f12509a = hashtag;
            return this;
        }

        /* renamed from: a */
        public C6799a mo20162a(ShareHashtag model) {
            if (model == null) {
                return this;
            }
            mo20163a(model.mo20158a());
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6799a mo20161a(Parcel parcel) {
            mo20162a((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            return this;
        }

        /* renamed from: a */
        public ShareHashtag mo20164a() {
            return new ShareHashtag(this, null);
        }
    }

    /* synthetic */ ShareHashtag(C6799a x0, C6802a x1) {
        this(x0);
    }

    private ShareHashtag(C6799a builder) {
        this.f12508a = builder.f12509a;
    }

    ShareHashtag(Parcel in) {
        this.f12508a = in.readString();
    }

    /* renamed from: a */
    public String mo20158a() {
        return this.f12508a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f12508a);
    }
}
