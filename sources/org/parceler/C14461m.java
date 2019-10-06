package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.m */
/* compiled from: NonParcelRepository */
class C14461m extends C14443k<Integer> {
    C14461m() {
    }

    /* renamed from: b */
    public Integer m46101b(Parcel parcel) {
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: a */
    public void mo45547b(Integer input, Parcel parcel) {
        parcel.writeInt(input.intValue());
    }
}
