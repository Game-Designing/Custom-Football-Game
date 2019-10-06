package org.parceler.p386a;

import android.os.Parcel;
import org.parceler.C14473y;

/* renamed from: org.parceler.a.c */
/* compiled from: CharArrayParcelConverter */
public class C14435c implements C14473y<char[]> {
    /* renamed from: a */
    public void mo45447a(char[] array, Parcel parcel) {
        if (array == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(array.length);
        parcel.writeCharArray(array);
    }

    /* renamed from: a */
    public char[] m46021a(Parcel parcel) {
        int size = parcel.readInt();
        if (size == -1) {
            return null;
        }
        char[] array = new char[size];
        parcel.readCharArray(array);
        return array;
    }
}
