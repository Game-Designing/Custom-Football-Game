package p005cm.aptoide.p006pt.database.accessors;

import io.realm.RealmQuery;
import java.util.Collection;
import java.util.List;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.schedulers.RealmSchedulers;
import p024io.realm.C0105Y;
import p024io.realm.C0106Z;
import p024io.realm.C13990F;
import p024io.realm.C14047ca;
import p024io.realm.C14052da;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;

/* renamed from: cm.aptoide.pt.database.accessors.Database */
public final class Database {
    public C13990F get() {
        return C13990F.m44505A();
    }

    public <E extends C0106Z> C0120S<Long> count(C14047ca<E> query) {
        return C0120S.m652c(Long.valueOf(query.mo43666a())).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2824v.f6055a).mo3612a(Long.valueOf(0));
    }

    /* renamed from: copyFromRealm */
    public <E extends C0106Z> C0120S<List<E>> mo940f(C14052da<E> results) {
        return C0120S.m652c(results).mo3653d((C0132p<? super T, Boolean>) C2721B.f5923a).mo3669j(new C2810o(this)).mo3616a(Schedulers.m776io());
    }

    /* renamed from: b */
    public /* synthetic */ List mo922b(C14052da realmObjects) {
        return get().mo43531a((Iterable<E>) realmObjects);
    }

    public C0120S<Long> count(Class clazz) {
        return getRealm().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2804l<Object,Object>(clazz));
    }

    public C0120S<C13990F> getRealm() {
        return C0120S.m652c(null).mo3616a(RealmSchedulers.getScheduler()).mo3669j(new C2719A(this));
    }

    /* renamed from: a */
    public /* synthetic */ C13990F mo920a(Object something) {
        return get();
    }

    public <E extends C0106Z> C0120S<List<E>> getAll(Class<E> clazz) {
        return getRealm().mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2789g<Object,Object>(clazz)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2783e<Object,Object>(this));
    }

    /* renamed from: a */
    static /* synthetic */ C14047ca m188a(Class clazz, String key, String value, C13990F realm) {
        C14047ca c = realm.mo43540c(clazz);
        c.mo43679b(key, value);
        return c;
    }

    public <E extends C0106Z> C0120S<E> get(Class<E> clazz, String key, String value) {
        return getRealm().mo3669j(new C2786f(clazz, key, value)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2816r<Object,Object>(this));
    }

    /* renamed from: findFirst */
    public <E extends C0106Z> C0120S<E> mo925c(C14047ca<E> query) {
        return C0120S.m652c(query.mo43682c()).mo3653d((C0132p<? super T, Boolean>) C2828x.f6059a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2801k.f6027a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2792h<Object,Object>(this)).mo3612a(null);
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m200f(C0106Z realmObject) {
        return Boolean.valueOf(realmObject != null);
    }

    /* access modifiers changed from: private */
    /* renamed from: copyFromRealm */
    public <E extends C0106Z> C0120S<E> mo937e(E object) {
        return C0120S.m652c(object).mo3653d((C0132p<? super T, Boolean>) C2822u.f6053a).mo3653d((C0132p<? super T, Boolean>) C2723C.f5925a).mo3669j(new C2820t(this)).mo3616a(Schedulers.m776io());
    }

    /* renamed from: c */
    public /* synthetic */ C0106Z mo924c(C0106Z realmObject) {
        return (C0106Z) get().mo43526a(realmObject);
    }

    /* renamed from: a */
    static /* synthetic */ C14047ca m186a(Class clazz, String key, Integer value, C13990F realm) {
        C14047ca c = realm.mo43540c(clazz);
        c.mo43669a(key, value);
        return c;
    }

    public <E extends C0106Z> C0120S<E> get(Class<E> clazz, String key, Integer value) {
        return getRealm().mo3669j(new C2798j(clazz, key, value)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2808n<Object,Object>(this));
    }

    /* renamed from: a */
    static /* synthetic */ C14047ca m187a(Class clazz, String key, Long value, C13990F realm) {
        C14047ca c = realm.mo43540c(clazz);
        c.mo43670a(key, value);
        return c;
    }

    public <E extends C0106Z> C0120S<E> get(Class<E> clazz, String key, Long value) {
        return getRealm().mo3669j(new C2830y(clazz, key, value)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2832z<Object,Object>(this));
    }

    /* renamed from: b */
    static /* synthetic */ C14047ca m194b(Class clazz, String key, String value, C13990F realm) {
        C14047ca c = realm.mo43540c(clazz);
        c.mo43679b(key, value);
        return c;
    }

    public <E extends C0106Z> C0120S<List<E>> getAsList(Class<E> clazz, String key, String value) {
        return getRealm().mo3669j(new C2812p(clazz, key, value)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2814q<Object,Object>(this));
    }

    /* renamed from: findAsList */
    public <E extends C0106Z> C0120S<List<E>> mo938e(C14047ca<E> query) {
        return C0120S.m652c(query.mo43681b()).mo3653d((C0132p<? super T, Boolean>) C2725D.f5927a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) C2806m.f6034a).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2818s<Object,Object>(this)).mo3612a(null);
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m197c(C14052da realmObject) {
        return Boolean.valueOf(realmObject != null);
    }

    /* renamed from: b */
    static /* synthetic */ C14047ca m193b(Class clazz, String key, Long value, C13990F realm) {
        C14047ca c = realm.mo43540c(clazz);
        c.mo43670a(key, value);
        return c;
    }

    public <E extends C0106Z> C0120S<List<E>> getAsList(Class<E> clazz, String key, Long value) {
        return getRealm().mo3669j(new C2795i(clazz, key, value)).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2826w<Object,Object>(this));
    }

    public <E extends C0106Z> void delete(Class<E> clazz, String key, String value) {
        C13990F realm = get();
        try {
            C14047ca c = realm.mo43540c(clazz);
            c.mo43679b(key, value);
            deleteObject(realm, (C0106Z) c.mo43682c());
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void deleteObject(C13990F realm, E obj) {
        realm.mo43533a();
        if (obj != null) {
            try {
                if (obj.isValid()) {
                    obj.deleteFromRealm();
                    realm.mo43543g();
                    return;
                }
            } catch (Exception ex) {
                CrashReport.getInstance().log(ex);
                realm.mo43538b();
                return;
            }
        }
        realm.mo43538b();
    }

    public <E extends C0106Z> void delete(Class<E> clazz, String key, Integer value) {
        C13990F realm = get();
        try {
            C14047ca c = realm.mo43540c(clazz);
            c.mo43669a(key, value);
            deleteObject(realm, (C0106Z) c.mo43682c());
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void delete(Class<E> clazz, String key, Long value) {
        C13990F realm = get();
        try {
            C14047ca c = realm.mo43540c(clazz);
            c.mo43670a(key, value);
            deleteObject(realm, (C0106Z) c.mo43682c());
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void deleteAll(Class<E> clazz) {
        C13990F realm = get();
        try {
            realm.mo43533a();
            realm.mo43534a(clazz);
            realm.mo43543g();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void insertAll(List<E> objects) {
        C13990F realm = get();
        try {
            realm.mo43533a();
            realm.mo43535a((Collection<? extends C0105Y>) objects);
            realm.mo43543g();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void insert(E object) {
        C13990F realm = get();
        try {
            realm.mo43533a();
            realm.mo43542d((C0105Y) object);
            realm.mo43543g();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    public <E extends C0106Z> void deleteAllIn(Class<E> classType, String classField, String[] fieldsIn) {
        C13990F realm = get();
        try {
            realm.mo43533a();
            C14047ca c = realm.mo43540c(classType);
            c.mo43674a(classField, fieldsIn);
            c.mo43681b().mo43485a();
            realm.mo43543g();
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public <E extends C0106Z> void deleteAllExcluding(Class<E> classType, String classField, List<String> fieldsIn) {
        C13990F realm = get();
        try {
            realm.mo43533a();
            RealmQuery<E> query = realm.mo43540c(classType);
            for (String field : fieldsIn) {
                query.mo43683c(classField, field);
            }
            query.mo43681b().mo43485a();
            realm.mo43543g();
            if (realm != null) {
                realm.close();
            }
        } catch (Throwable th) {
            if (realm != null) {
                realm.close();
            }
            throw th;
        }
    }
}
