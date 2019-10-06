package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.C6801a;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends C6801a> implements ShareModel {

    /* renamed from: a */
    private final Bundle f12517a;

    /* renamed from: com.facebook.share.model.ShareOpenGraphValueContainer$a */
    public static abstract class C6801a<P extends ShareOpenGraphValueContainer, E extends C6801a> implements C6804c<P, E> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Bundle f12518a = new Bundle();

        /* renamed from: a */
        public E mo20180a(String key, String value) {
            this.f12518a.putString(key, value);
            return this;
        }

        /* renamed from: a */
        public E mo20179a(P model) {
            if (model != null) {
                this.f12518a.putAll(model.mo20173a());
            }
            return this;
        }
    }

    protected ShareOpenGraphValueContainer(C6801a<P, E> builder) {
        this.f12517a = (Bundle) builder.f12518a.clone();
    }

    ShareOpenGraphValueContainer(Parcel in) {
        this.f12517a = in.readBundle(C6801a.class.getClassLoader());
    }

    /* renamed from: a */
    public Object mo20174a(String key) {
        return this.f12517a.get(key);
    }

    /* renamed from: b */
    public String mo20175b(String key) {
        return this.f12517a.getString(key);
    }

    /* renamed from: a */
    public Bundle mo20173a() {
        return (Bundle) this.f12517a.clone();
    }

    /* renamed from: b */
    public Set<String> mo20176b() {
        return this.f12517a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeBundle(this.f12517a);
    }
}
