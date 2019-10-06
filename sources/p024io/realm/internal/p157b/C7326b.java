package p024io.realm.internal.p157b;

import io.realm.RealmModel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p024io.realm.C0105Y;
import p024io.realm.C13990F;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7346q;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Util;

/* renamed from: io.realm.internal.b.b */
/* compiled from: FilterableMediator */
public class C7326b extends C7346q {

    /* renamed from: a */
    private final C7346q f14299a;

    /* renamed from: b */
    private final Set<Class<? extends C0105Y>> f14300b;

    public C7326b(C7346q originalMediator, Collection<Class<? extends C0105Y>> allowedClasses) {
        this.f14299a = originalMediator;
        Set<Class<? extends RealmModel>> tempAllowedClasses = new HashSet<>();
        if (originalMediator != null) {
            Set<Class<? extends RealmModel>> originalClasses = originalMediator.mo23754b();
            for (Class<? extends RealmModel> clazz : allowedClasses) {
                if (originalClasses.contains(clazz)) {
                    tempAllowedClasses.add(clazz);
                }
            }
        }
        this.f14300b = Collections.unmodifiableSet(tempAllowedClasses);
    }

    /* renamed from: a */
    public Map<Class<? extends C0105Y>, OsObjectSchemaInfo> mo23751a() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<>();
        for (Entry<Class<? extends RealmModel>, OsObjectSchemaInfo> entry : this.f14299a.mo23751a().entrySet()) {
            if (this.f14300b.contains(entry.getKey())) {
                infoMap.put(entry.getKey(), entry.getValue());
            }
        }
        return infoMap;
    }

    /* renamed from: a */
    public C7327c mo23750a(Class<? extends C0105Y> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        m16102d(clazz);
        return this.f14299a.mo23750a(clazz, sharedRealm, allowExtraColumns);
    }

    /* renamed from: c */
    public String mo23755c(Class<? extends C0105Y> clazz) {
        m16102d(clazz);
        return this.f14299a.mo23755c(clazz);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23749a(Class<E> clazz, Object baseRealm, C7347r row, C7327c columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        m16102d(clazz);
        return this.f14299a.mo23749a(clazz, baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
    }

    /* renamed from: b */
    public Set<Class<? extends C0105Y>> mo23754b() {
        return this.f14300b;
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23747a(C13990F realm, E object, boolean update, Map<C0105Y, C7344p> cache) {
        m16102d(Util.m16050a(object.getClass()));
        return this.f14299a.mo23747a(realm, object, update, cache);
    }

    /* renamed from: a */
    public void mo23752a(C13990F realm, C0105Y object, Map<C0105Y, Long> cache) {
        m16102d(Util.m16050a(object.getClass()));
        this.f14299a.mo23752a(realm, object, cache);
    }

    /* renamed from: a */
    public void mo23753a(C13990F realm, Collection<? extends C0105Y> objects) {
        m16102d(Util.m16050a(((C0105Y) objects.iterator().next()).getClass()));
        this.f14299a.mo23753a(realm, objects);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23748a(E realmObject, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        m16102d(Util.m16050a(realmObject.getClass()));
        return this.f14299a.mo23748a(realmObject, maxDepth, cache);
    }

    /* renamed from: c */
    public boolean mo23756c() {
        C7346q qVar = this.f14299a;
        if (qVar == null) {
            return true;
        }
        return qVar.mo23756c();
    }

    /* renamed from: d */
    private void m16102d(Class<? extends C0105Y> clazz) {
        if (!this.f14300b.contains(clazz)) {
            StringBuilder sb = new StringBuilder();
            sb.append(clazz.getSimpleName());
            sb.append(" is not part of the schema for this Realm");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
