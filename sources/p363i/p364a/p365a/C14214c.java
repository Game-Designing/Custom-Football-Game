package p363i.p364a.p365a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: i.a.a.c */
public final class C14214c {

    /* renamed from: a */
    private C14214c f43123a;

    /* renamed from: b */
    private C14214c f43124b;

    /* renamed from: c */
    private int f43125c;

    /* renamed from: d */
    private List<C14217e> f43126d = new ArrayList();

    /* renamed from: i.a.a.c$a */
    private enum C14215a {
        ;
        

        /* renamed from: a */
        public static final int f43127a = 0;

        /* renamed from: b */
        public static final int f43128b = 0;

        static {
            f43127a = 1;
            f43128b = 2;
            f43129c = new int[]{f43127a, f43128b};
        }

        /* renamed from: a */
        public static int[] m45750a() {
            return (int[]) f43129c.clone();
        }
    }

    public C14214c(List<C14217e> list) {
        this.f43125c = m45745a(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C14217e eVar : list) {
            if (eVar.mo44320b() < this.f43125c) {
                arrayList.add(eVar);
            } else if (eVar.mo44319a() > this.f43125c) {
                arrayList2.add(eVar);
            } else {
                this.f43126d.add(eVar);
            }
        }
        if (arrayList.size() > 0) {
            this.f43123a = new C14214c(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.f43124b = new C14214c(arrayList2);
        }
    }

    /* renamed from: a */
    private static int m45745a(List<C14217e> list) {
        int i = -1;
        int i2 = -1;
        for (C14217e eVar : list) {
            int a = eVar.mo44319a();
            int b = eVar.mo44320b();
            if (i == -1 || a < i) {
                i = a;
            }
            if (i2 == -1 || b > i2) {
                i2 = b;
            }
        }
        return (i + i2) / 2;
    }

    /* renamed from: a */
    public final List<C14217e> mo44326a(C14217e eVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f43125c < eVar.mo44319a()) {
            m45748a(eVar, arrayList, m45746a(this.f43124b, eVar));
            m45748a(eVar, arrayList, m45747a(eVar, C14215a.f43128b));
        } else if (this.f43125c > eVar.mo44320b()) {
            m45748a(eVar, arrayList, m45746a(this.f43123a, eVar));
            m45748a(eVar, arrayList, m45747a(eVar, C14215a.f43127a));
        } else {
            m45748a(eVar, arrayList, this.f43126d);
            m45748a(eVar, arrayList, m45746a(this.f43123a, eVar));
            m45748a(eVar, arrayList, m45746a(this.f43124b, eVar));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m45748a(C14217e eVar, List<C14217e> list, List<C14217e> list2) {
        for (C14217e eVar2 : list2) {
            if (!eVar2.equals(eVar)) {
                list.add(eVar2);
            }
        }
    }

    /* renamed from: a */
    private List<C14217e> m45747a(C14217e eVar, int i) {
        ArrayList arrayList = new ArrayList();
        for (C14217e eVar2 : this.f43126d) {
            int i2 = C14213b.f43122a[i - 1];
            if (i2 != 1) {
                if (i2 == 2 && eVar2.mo44320b() >= eVar.mo44319a()) {
                    arrayList.add(eVar2);
                }
            } else if (eVar2.mo44319a() <= eVar.mo44320b()) {
                arrayList.add(eVar2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<C14217e> m45746a(C14214c cVar, C14217e eVar) {
        if (cVar == null) {
            return Collections.emptyList();
        }
        return cVar.mo44326a(eVar);
    }
}
