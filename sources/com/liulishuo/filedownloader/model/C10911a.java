package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: com.liulishuo.filedownloader.model.a */
/* compiled from: FileDownloadHeader */
class C10911a implements Creator<FileDownloadHeader> {
    C10911a() {
    }

    public FileDownloadHeader createFromParcel(Parcel source) {
        return new FileDownloadHeader(source);
    }

    public FileDownloadHeader[] newArray(int size) {
        return new FileDownloadHeader[size];
    }
}
