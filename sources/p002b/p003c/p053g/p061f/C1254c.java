package p002b.p003c.p053g.p061f;

import java.util.Map;

/* renamed from: b.c.g.f.c */
/* compiled from: ArraySet */
class C1254c extends C1261j<E, E> {

    /* renamed from: d */
    final /* synthetic */ C1255d f4025d;

    C1254c(C1255d this$0) {
        this.f4025d = this$0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo9024c() {
        return this.f4025d.f4034i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo9017a(int index, int offset) {
        return this.f4025d.f4033h[index];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9016a(Object key) {
        return this.f4025d.indexOf(key);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo9022b(Object value) {
        return this.f4025d.indexOf(value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<E, E> mo9023b() {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9021a(E key, E e) {
        this.f4025d.add(key);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public E mo9018a(int index, E e) {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9020a(int index) {
        this.f4025d.mo9037h(index);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9019a() {
        this.f4025d.clear();
    }
}
