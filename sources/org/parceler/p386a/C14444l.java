package org.parceler.p386a;

import android.os.Parcel;
import android.util.SparseArray;
import org.parceler.C14473y;

/* renamed from: org.parceler.a.l */
/* compiled from: SparseArrayParcelConverter */
public abstract class C14444l<T> implements C14473y<SparseArray<T>> {
    /* renamed from: b */
    public abstract T mo45549b(Parcel parcel);

    /* renamed from: b */
    public abstract void mo45550b(T t, Parcel parcel);

    /* renamed from: a */
    public void mo45447a(SparseArray<T> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(input.size());
        for (int i = 0; i < input.size(); i++) {
            parcel.writeInt(input.keyAt(i));
            mo45550b(input.valueAt(i), parcel);
        }
    }

    /* renamed from: a */
    public SparseArray<T> m46053a(Parcel parcel) {
        int size = parcel.readInt();
        if (size < 0) {
            return null;
        }
        SparseArray<T> array = new SparseArray<>(size);
        for (int i = 0; i < size; i++) {
            array.append(parcel.readInt(), mo45549b(parcel));
        }
        return array;
    }
}
