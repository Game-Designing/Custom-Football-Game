package android.support.p000v4.widget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p002b.p003c.p053g.p061f.C1269m;
import p002b.p003c.p053g.p061f.C1270n;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: android.support.v4.widget.l */
/* compiled from: DirectedAcyclicGraph */
public final class C0705l<T> {

    /* renamed from: a */
    private final C1269m<ArrayList<T>> f2059a = new C1270n(10);

    /* renamed from: b */
    private final C1273q<T, ArrayList<T>> f2060b = new C1273q<>();

    /* renamed from: c */
    private final ArrayList<T> f2061c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f2062d = new HashSet<>();

    /* renamed from: a */
    public void mo6010a(T node) {
        if (!this.f2060b.containsKey(node)) {
            this.f2060b.put(node, null);
        }
    }

    /* renamed from: b */
    public boolean mo6013b(T node) {
        return this.f2060b.containsKey(node);
    }

    /* renamed from: a */
    public void mo6011a(T node, T incomingEdge) {
        if (!this.f2060b.containsKey(node) || !this.f2060b.containsKey(incomingEdge)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> edges = (ArrayList) this.f2060b.get(node);
        if (edges == null) {
            edges = m3321c();
            this.f2060b.put(node, edges);
        }
        edges.add(incomingEdge);
    }

    /* renamed from: c */
    public List mo6014c(T node) {
        return (List) this.f2060b.get(node);
    }

    /* renamed from: d */
    public List<T> mo6015d(T node) {
        ArrayList arrayList = null;
        int size = this.f2060b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = (ArrayList) this.f2060b.mo9162d(i);
            if (edges != null && edges.contains(node)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2060b.mo9157b(i));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean mo6016e(T node) {
        int size = this.f2060b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = (ArrayList) this.f2060b.mo9162d(i);
            if (edges != null && edges.contains(node)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo6009a() {
        int size = this.f2060b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = (ArrayList) this.f2060b.mo9162d(i);
            if (edges != null) {
                m3320a(edges);
            }
        }
        this.f2060b.clear();
    }

    /* renamed from: b */
    public ArrayList<T> mo6012b() {
        this.f2061c.clear();
        this.f2062d.clear();
        int size = this.f2060b.size();
        for (int i = 0; i < size; i++) {
            m3319a(this.f2060b.mo9157b(i), this.f2061c, this.f2062d);
        }
        return this.f2061c;
    }

    /* renamed from: a */
    private void m3319a(T node, ArrayList<T> result, HashSet<T> tmpMarked) {
        if (!result.contains(node)) {
            if (!tmpMarked.contains(node)) {
                tmpMarked.add(node);
                ArrayList<T> edges = (ArrayList) this.f2060b.get(node);
                if (edges != null) {
                    int size = edges.size();
                    for (int i = 0; i < size; i++) {
                        m3319a(edges.get(i), result, tmpMarked);
                    }
                }
                tmpMarked.remove(node);
                result.add(node);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    /* renamed from: c */
    private ArrayList<T> m3321c() {
        ArrayList<T> list = (ArrayList) this.f2059a.mo9148a();
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    /* renamed from: a */
    private void m3320a(ArrayList<T> list) {
        list.clear();
        this.f2059a.mo9149a(list);
    }
}
