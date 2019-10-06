package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;

public abstract class ShareMedia implements ShareModel {

    /* renamed from: a */
    private final Bundle f12514a;

    ShareMedia(Parcel in) {
        this.f12514a = in.readBundle();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.f12514a);
    }
}
