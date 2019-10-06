package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Creator<TrackGroupArray> CREATOR = new C8413z();

    /* renamed from: a */
    public static final TrackGroupArray f18154a = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: b */
    public final int f18155b;

    /* renamed from: c */
    private final TrackGroup[] f18156c;

    /* renamed from: d */
    private int f18157d;

    public TrackGroupArray(TrackGroup... trackGroups) {
        this.f18156c = trackGroups;
        this.f18155b = trackGroups.length;
    }

    TrackGroupArray(Parcel in) {
        this.f18155b = in.readInt();
        this.f18156c = new TrackGroup[this.f18155b];
        for (int i = 0; i < this.f18155b; i++) {
            this.f18156c[i] = (TrackGroup) in.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    /* renamed from: a */
    public TrackGroup mo25651a(int index) {
        return this.f18156c[index];
    }

    /* renamed from: a */
    public int mo25650a(TrackGroup group) {
        for (int i = 0; i < this.f18155b; i++) {
            if (this.f18156c[i] == group) {
                return i;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f18157d == 0) {
            this.f18157d = Arrays.hashCode(this.f18156c);
        }
        return this.f18157d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroupArray other = (TrackGroupArray) obj;
        if (this.f18155b != other.f18155b || !Arrays.equals(this.f18156c, other.f18156c)) {
            z = false;
        }
        return z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f18155b);
        for (int i = 0; i < this.f18155b; i++) {
            dest.writeParcelable(this.f18156c[i], 0);
        }
    }
}
