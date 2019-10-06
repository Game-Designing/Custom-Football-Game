package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag.C6799a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShareContent<P extends ShareContent, E> implements ShareModel {

    /* renamed from: a */
    private final Uri f12502a;

    /* renamed from: b */
    private final List<String> f12503b;

    /* renamed from: c */
    private final String f12504c;

    /* renamed from: d */
    private final String f12505d;

    /* renamed from: e */
    private final String f12506e;

    /* renamed from: f */
    private final ShareHashtag f12507f;

    protected ShareContent(Parcel in) {
        this.f12502a = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.f12503b = m13864a(in);
        this.f12504c = in.readString();
        this.f12505d = in.readString();
        this.f12506e = in.readString();
        C6799a aVar = new C6799a();
        aVar.mo20161a(in);
        this.f12507f = aVar.mo20164a();
    }

    /* renamed from: a */
    public Uri mo20154a() {
        return this.f12502a;
    }

    /* renamed from: b */
    public ShareHashtag mo20155b() {
        return this.f12507f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this.f12502a, 0);
        out.writeStringList(this.f12503b);
        out.writeString(this.f12504c);
        out.writeString(this.f12505d);
        out.writeString(this.f12506e);
        out.writeParcelable(this.f12507f, 0);
    }

    /* renamed from: a */
    private List<String> m13864a(Parcel in) {
        List<String> list = new ArrayList<>();
        in.readStringList(list);
        if (list.size() == 0) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }
}
