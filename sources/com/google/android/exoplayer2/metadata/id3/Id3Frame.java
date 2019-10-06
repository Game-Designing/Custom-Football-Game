package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class Id3Frame implements Entry {

    /* renamed from: a */
    public final String f18095a;

    public Id3Frame(String id) {
        this.f18095a = id;
    }

    public String toString() {
        return this.f18095a;
    }

    public int describeContents() {
        return 0;
    }
}
