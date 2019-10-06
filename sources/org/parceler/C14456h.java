package org.parceler;

import android.os.Parcel;
import org.parceler.p386a.C14443k;

/* renamed from: org.parceler.h */
/* compiled from: NonParcelRepository */
class C14456h extends C14443k<Character> {
    C14456h() {
    }

    /* renamed from: b */
    public Character m46083b(Parcel parcel) {
        return Character.valueOf(parcel.createCharArray()[0]);
    }

    /* renamed from: a */
    public void mo45547b(Character input, Parcel parcel) {
        parcel.writeCharArray(new char[]{input.charValue()});
    }
}
