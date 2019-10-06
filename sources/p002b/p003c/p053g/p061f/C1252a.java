package p002b.p003c.p053g.p061f;

import java.util.Map;

/* renamed from: b.c.g.f.a */
/* compiled from: ArrayMap */
class C1252a extends C1261j<K, V> {

    /* renamed from: d */
    final /* synthetic */ C1253b f4023d;

    C1252a(C1253b this$0) {
        this.f4023d = this$0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo9024c() {
        return this.f4023d.f4080g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo9017a(int index, int offset) {
        return this.f4023d.f4079f[(index << 1) + offset];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9016a(Object key) {
        return this.f4023d.mo9151a(key);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo9022b(Object value) {
        return this.f4023d.mo9156b(value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<K, V> mo9023b() {
        return this.f4023d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9021a(K key, V value) {
        this.f4023d.put(key, value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public V mo9018a(int index, V value) {
        return this.f4023d.mo9153a(index, value);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9020a(int index) {
        this.f4023d.mo9158c(index);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9019a() {
        this.f4023d.clear();
    }
}
