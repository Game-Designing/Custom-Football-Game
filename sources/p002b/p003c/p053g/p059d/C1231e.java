package p002b.p003c.p053g.p059d;

import java.util.Comparator;

/* renamed from: b.c.g.d.e */
/* compiled from: FontsContractCompat */
class C1231e implements Comparator<byte[]> {
    C1231e() {
    }

    /* renamed from: a */
    public int compare(byte[] l, byte[] r) {
        if (l.length != r.length) {
            return l.length - r.length;
        }
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) {
                return l[i] - r[i];
            }
        }
        return 0;
    }
}
