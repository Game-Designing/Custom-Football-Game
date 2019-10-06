package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileDownloadHeader implements Parcelable {
    public static final Creator<FileDownloadHeader> CREATOR = new C10911a();

    /* renamed from: a */
    private HashMap<String, List<String>> f33336a;

    /* renamed from: a */
    public void mo35713a(String name, String value) {
        if (name == null) {
            throw new NullPointerException("name == null");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else if (value != null) {
            if (this.f33336a == null) {
                this.f33336a = new HashMap<>();
            }
            List list = (List) this.f33336a.get(name);
            if (list == null) {
                list = new ArrayList();
                this.f33336a.put(name, list);
            }
            if (!list.contains(value)) {
                list.add(value);
            }
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(this.f33336a);
    }

    /* renamed from: a */
    public HashMap<String, List<String>> mo35712a() {
        return this.f33336a;
    }

    public FileDownloadHeader() {
    }

    protected FileDownloadHeader(Parcel in) {
        this.f33336a = in.readHashMap(String.class.getClassLoader());
    }

    public String toString() {
        return this.f33336a.toString();
    }
}
