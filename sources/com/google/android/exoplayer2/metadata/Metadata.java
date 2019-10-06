package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Creator<Metadata> CREATOR = new C8344a();

    /* renamed from: a */
    private final Entry[] f18071a;

    public interface Entry extends Parcelable {
    }

    public Metadata(Entry... entries) {
        this.f18071a = entries == null ? new Entry[0] : entries;
    }

    public Metadata(List<? extends Entry> entries) {
        if (entries != null) {
            this.f18071a = new Entry[entries.size()];
            entries.toArray(this.f18071a);
            return;
        }
        this.f18071a = new Entry[0];
    }

    Metadata(Parcel in) {
        this.f18071a = new Entry[in.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.f18071a;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) in.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public int mo25541a() {
        return this.f18071a.length;
    }

    /* renamed from: a */
    public Entry mo25542a(int index) {
        return this.f18071a[index];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f18071a, ((Metadata) obj).f18071a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f18071a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f18071a.length);
        for (Entry entry : this.f18071a) {
            dest.writeParcelable(entry, 0);
        }
    }
}
