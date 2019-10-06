package p024io.realm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p024io.realm.C0105Y;
import p024io.realm.C13990F;
import p024io.realm.exceptions.RealmException;
import p024io.realm.internal.C7344p.C7345a;

/* renamed from: io.realm.internal.q */
/* compiled from: RealmProxyMediator */
public abstract class C7346q {
    /* renamed from: a */
    public abstract <E extends C0105Y> E mo23747a(C13990F f, E e, boolean z, Map<C0105Y, C7344p> map);

    /* renamed from: a */
    public abstract <E extends C0105Y> E mo23748a(E e, int i, Map<C0105Y, C7345a<C0105Y>> map);

    /* renamed from: a */
    public abstract <E extends C0105Y> E mo23749a(Class<E> cls, Object obj, C7347r rVar, C7327c cVar, boolean z, List<String> list);

    /* renamed from: a */
    public abstract C7327c mo23750a(Class<? extends C0105Y> cls, SharedRealm sharedRealm, boolean z);

    /* renamed from: a */
    public abstract Map<Class<? extends C0105Y>, OsObjectSchemaInfo> mo23751a();

    /* renamed from: a */
    public abstract void mo23752a(C13990F f, C0105Y y, Map<C0105Y, Long> map);

    /* renamed from: a */
    public abstract void mo23753a(C13990F f, Collection<? extends C0105Y> collection);

    /* renamed from: b */
    public abstract Set<Class<? extends C0105Y>> mo23754b();

    /* renamed from: c */
    public abstract String mo23755c(Class<? extends C0105Y> cls);

    /* renamed from: c */
    public boolean mo23756c() {
        return false;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C7346q)) {
            return false;
        }
        return mo23754b().equals(((C7346q) o).mo23754b());
    }

    public int hashCode() {
        return mo23754b().hashCode();
    }

    /* renamed from: a */
    protected static void m16197a(Class<? extends C0105Y> clazz) {
        if (clazz == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
    }

    /* renamed from: b */
    protected static RealmException m16198b(Class<? extends C0105Y> clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz);
        sb.append(" is not part of the schema for this Realm.");
        return new RealmException(sb.toString());
    }
}
