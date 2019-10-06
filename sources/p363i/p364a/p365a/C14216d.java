package p363i.p364a.p365a;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/* renamed from: i.a.a.d */
public final class C14216d {

    /* renamed from: a */
    private final C14214c f43130a;

    public C14216d(List<C14217e> list) {
        this.f43130a = new C14214c(list);
    }

    /* renamed from: a */
    public final List<C14217e> mo44327a(List<C14217e> list) {
        Collections.sort(list, new C14219g());
        TreeSet<C14217e> treeSet = new TreeSet<>();
        for (C14217e eVar : list) {
            if (!treeSet.contains(eVar)) {
                treeSet.addAll(this.f43130a.mo44326a(eVar));
            }
        }
        for (C14217e remove : treeSet) {
            list.remove(remove);
        }
        Collections.sort(list, new C14218f());
        return list;
    }
}
