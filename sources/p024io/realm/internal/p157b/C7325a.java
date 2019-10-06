package p024io.realm.internal.p157b;

import io.realm.RealmModel;
import io.realm.internal.RealmProxyMediator;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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

/* renamed from: io.realm.internal.b.a */
/* compiled from: CompositeMediator */
public class C7325a extends C7346q {

    /* renamed from: a */
    private final Map<Class<? extends C0105Y>, C7346q> f14298a;

    public C7325a(C7346q... mediators) {
        HashMap<Class<? extends RealmModel>, RealmProxyMediator> tempMediators = new HashMap<>();
        if (mediators != null) {
            for (C7346q mediator : mediators) {
                for (Class<? extends RealmModel> realmClass : mediator.mo23754b()) {
                    tempMediators.put(realmClass, mediator);
                }
            }
        }
        this.f14298a = Collections.unmodifiableMap(tempMediators);
    }

    /* renamed from: a */
    public Map<Class<? extends C0105Y>, OsObjectSchemaInfo> mo23751a() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<>();
        for (C7346q mediator : this.f14298a.values()) {
            infoMap.putAll(mediator.mo23751a());
        }
        return infoMap;
    }

    /* renamed from: a */
    public C7327c mo23750a(Class<? extends C0105Y> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        return m16091d(clazz).mo23750a(clazz, sharedRealm, allowExtraColumns);
    }

    /* renamed from: c */
    public String mo23755c(Class<? extends C0105Y> clazz) {
        return m16091d(clazz).mo23755c(clazz);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23749a(Class<E> clazz, Object baseRealm, C7347r row, C7327c columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        return m16091d(clazz).mo23749a(clazz, baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
    }

    /* renamed from: b */
    public Set<Class<? extends C0105Y>> mo23754b() {
        return this.f14298a.keySet();
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23747a(C13990F realm, E object, boolean update, Map<C0105Y, C7344p> cache) {
        return m16091d(Util.m16050a(object.getClass())).mo23747a(realm, object, update, cache);
    }

    /* renamed from: a */
    public void mo23752a(C13990F realm, C0105Y object, Map<C0105Y, Long> cache) {
        m16091d(Util.m16050a(object.getClass())).mo23752a(realm, object, cache);
    }

    /* renamed from: a */
    public void mo23753a(C13990F realm, Collection<? extends C0105Y> objects) {
        m16091d(Util.m16050a(Util.m16050a(((C0105Y) objects.iterator().next()).getClass()))).mo23753a(realm, objects);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23748a(E realmObject, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        return m16091d(Util.m16050a(realmObject.getClass())).mo23748a(realmObject, maxDepth, cache);
    }

    /* renamed from: c */
    public boolean mo23756c() {
        for (Entry<Class<? extends RealmModel>, RealmProxyMediator> entry : this.f14298a.entrySet()) {
            if (!((C7346q) entry.getValue()).mo23756c()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private C7346q m16091d(Class<? extends C0105Y> clazz) {
        C7346q mediator = (C7346q) this.f14298a.get(clazz);
        if (mediator != null) {
            return mediator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName());
        sb.append(" is not part of the schema for this Realm");
        throw new IllegalArgumentException(sb.toString());
    }
}
