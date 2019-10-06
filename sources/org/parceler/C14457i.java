package org.parceler;

import android.os.Parcel;
import org.parceler.NonParcelRepository.CollectionParcelable;
import org.parceler.p386a.C14433a;

/* renamed from: org.parceler.i */
/* compiled from: NonParcelRepository */
class C14457i extends C14433a {
    C14457i() {
    }

    /* renamed from: b */
    public Object mo45538b(Parcel parcel) {
        return C14377B.m45945a(parcel.readParcelable(CollectionParcelable.class.getClassLoader()));
    }

    /* renamed from: b */
    public void mo45539b(Object input, Parcel parcel) {
        parcel.writeParcelable(C14377B.m45944a(input), 0);
    }
}
