package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.measurement.H */
final class C9909H implements Comparator<zzte> {
    C9909H() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzte zzte = (zzte) obj;
        zzte zzte2 = (zzte) obj2;
        zztl zztl = (zztl) zzte.iterator();
        zztl zztl2 = (zztl) zzte2.iterator();
        while (zztl.hasNext() && zztl2.hasNext()) {
            int compare = Integer.compare(zzte.m32390b(zztl.nextByte()), zzte.m32390b(zztl2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzte.size(), zzte2.size());
    }
}
