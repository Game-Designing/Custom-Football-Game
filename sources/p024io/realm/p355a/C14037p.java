package p024io.realm.p355a;

import java.util.IdentityHashMap;
import java.util.Map;
import p024io.realm.C0105Y;
import p024io.realm.C13990F;
import p024io.realm.C14014U;
import p024io.realm.C14052da;
import p024io.realm.C14061h;
import p024io.realm.C14065j;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;

/* renamed from: io.realm.a.p */
/* compiled from: RealmObservableFactory */
public class C14037p implements C14039q {

    /* renamed from: a */
    ThreadLocal<C14038a<C14052da>> f42536a = new C14028g(this);

    /* renamed from: b */
    ThreadLocal<C14038a<C14014U>> f42537b = new C14029h(this);

    /* renamed from: c */
    ThreadLocal<C14038a<C0105Y>> f42538c = new C14030i(this);

    /* renamed from: io.realm.a.p$a */
    /* compiled from: RealmObservableFactory */
    private static class C14038a<K> {

        /* renamed from: a */
        private final Map<K, Integer> f42539a;

        private C14038a() {
            this.f42539a = new IdentityHashMap();
        }

        /* synthetic */ C14038a(C14028g x0) {
            this();
        }

        /* renamed from: a */
        public void mo43649a(K object) {
            Integer count = (Integer) this.f42539a.get(object);
            if (count == null) {
                this.f42539a.put(object, Integer.valueOf(1));
            } else {
                this.f42539a.put(object, Integer.valueOf(count.intValue() + 1));
            }
        }

        /* renamed from: b */
        public void mo43650b(K object) {
            Integer count = (Integer) this.f42539a.get(object);
            if (count == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Object does not have any references: ");
                sb.append(object);
                throw new IllegalStateException(sb.toString());
            } else if (count.intValue() > 1) {
                this.f42539a.put(object, Integer.valueOf(count.intValue() - 1));
            } else if (count.intValue() == 1) {
                this.f42539a.remove(object);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid reference count: ");
                sb2.append(count);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public <E extends C0105Y> C0120S<C14052da<E>> mo43644a(C13990F realm, C14052da<E> results) {
        return C0120S.m634a((C0122a<T>) new C14033l<T>(this, realm.mo43544i(), results));
    }

    /* renamed from: a */
    public C0120S<C14052da<C14065j>> mo43645a(C14061h realm, C14052da<C14065j> results) {
        return C0120S.m634a((C0122a<T>) new C14036o<T>(this, realm.mo43544i(), results));
    }

    /* renamed from: a */
    public <E extends C0105Y> C0120S<E> mo43643a(C13990F realm, E object) {
        return C0120S.m634a((C0122a<T>) new C14024c<T>(this, realm.mo43544i(), object));
    }

    /* renamed from: a */
    public C0120S<C14065j> mo43646a(C14061h realm, C14065j object) {
        return C0120S.m634a((C0122a<T>) new C14027f<T>(this, realm.mo43544i(), object));
    }

    public boolean equals(Object o) {
        return o instanceof C14037p;
    }

    public int hashCode() {
        return 37;
    }
}
