package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.ListParcelable;
import org.parceler.p386a.C14433a;

/* renamed from: org.parceler.q */
/* compiled from: NonParcelRepository */
class C14465q extends C14433a {
    C14465q() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(ListParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
