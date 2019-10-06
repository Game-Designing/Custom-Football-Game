package org.parceler.p386a;

import android.os.Parcel;
import org.parceler.C14473y;

/* renamed from: org.parceler.a.b */
/* compiled from: BooleanArrayParcelConverter */
public class C14434b implements C14473y<boolean[]> {
    /* renamed from: a */
    public void mo45447a(boolean[] array, Parcel parcel) {
        if (array == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(array.length);
        parcel.writeBooleanArray(array);
    }

    /* renamed from: a */
    public boolean[] m46017a(Parcel parcel) {
        int size = parcel.readInt();
        if (size == -1) {
            return null;
        }
        boolean[] array = new boolean[size];
        parcel.readBooleanArray(array);
        return array;
    }
}
