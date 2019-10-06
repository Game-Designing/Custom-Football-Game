package org.parceler.p386a;

import android.os.Parcel;
import java.util.Map;
import java.util.Map.Entry;
import org.parceler.C14382D;

/* renamed from: org.parceler.a.j */
/* compiled from: MapParcelConverter */
public abstract class C14442j<K, V, M extends Map<K, V>> implements C14382D<Map<K, V>, M> {
    /* renamed from: a */
    public abstract M mo45540a();

    /* renamed from: b */
    public abstract K mo45542b(Parcel parcel);

    /* renamed from: b */
    public abstract void mo45543b(K k, Parcel parcel);

    /* renamed from: c */
    public abstract V mo45544c(Parcel parcel);

    /* renamed from: c */
    public abstract void mo45545c(V v, Parcel parcel);

    /* renamed from: a */
    public void mo45447a(Map<K, V> input, Parcel parcel) {
        if (input == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(input.size());
        for (Entry<K, V> entry : input.entrySet()) {
            mo45543b(entry.getKey(), parcel);
            mo45545c(entry.getValue(), parcel);
        }
    }

    /* renamed from: a */
    public M m46041a(Parcel parcel) {
        int size = parcel.readInt();
        if (size == -1) {
            return null;
        }
        M map = mo45540a();
        for (int i = 0; i < size; i++) {
            map.put(mo45542b(parcel), mo45544c(parcel));
        }
        return map;
    }
}
