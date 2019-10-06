package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Creator<TrackGroup> CREATOR = new C8412y();

    /* renamed from: a */
    public final int f18151a;

    /* renamed from: b */
    private final Format[] f18152b;

    /* renamed from: c */
    private int f18153c;

    public TrackGroup(Format... formats) {
        C8514e.m20490b(formats.length > 0);
        this.f18152b = formats;
        this.f18151a = formats.length;
    }

    TrackGroup(Parcel in) {
        this.f18151a = in.readInt();
        this.f18152b = new Format[this.f18151a];
        for (int i = 0; i < this.f18151a; i++) {
            this.f18152b[i] = (Format) in.readParcelable(Format.class.getClassLoader());
        }
    }

    /* renamed from: a */
    public Format mo25645a(int index) {
        return this.f18152b[index];
    }

    /* renamed from: a */
    public int mo25644a(Format format) {
        int i = 0;
        while (true) {
            Format[] formatArr = this.f18152b;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    public int hashCode() {
        if (this.f18153c == 0) {
            this.f18153c = (17 * 31) + Arrays.hashCode(this.f18152b);
        }
        return this.f18153c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup other = (TrackGroup) obj;
        if (this.f18151a != other.f18151a || !Arrays.equals(this.f18152b, other.f18152b)) {
            z = false;
        }
        return z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f18151a);
        for (int i = 0; i < this.f18151a; i++) {
            dest.writeParcelable(this.f18152b[i], 0);
        }
    }
}
