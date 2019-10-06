package p024io.realm;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.ExcludedAd;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.MigratedApp;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.database.realm.RealmAuthorization;
import p005cm.aptoide.p006pt.database.realm.RealmEvent;
import p005cm.aptoide.p006pt.database.realm.RealmExperiment;
import p005cm.aptoide.p006pt.database.realm.RealmInteger;
import p005cm.aptoide.p006pt.database.realm.RealmLocalNotificationSync;
import p005cm.aptoide.p006pt.database.realm.RealmString;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.database.realm.Update;
import p024io.realm.C14048d.C14050b;
import p024io.realm.annotations.RealmModule;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7346q;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.SharedRealm;

@RealmModule
/* renamed from: io.realm.DefaultRealmModuleMediator */
class DefaultRealmModuleMediator extends C7346q {

    /* renamed from: a */
    private static final Set<Class<? extends C0105Y>> f42374a;

    /* renamed from: c */
    public boolean mo23756c() {
        return true;
    }

    DefaultRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(MigratedApp.class);
        modelClasses.add(RealmString.class);
        modelClasses.add(RealmAuthorization.class);
        modelClasses.add(RealmInteger.class);
        modelClasses.add(RealmEvent.class);
        modelClasses.add(Installation.class);
        modelClasses.add(RealmExperiment.class);
        modelClasses.add(Update.class);
        modelClasses.add(Notification.class);
        modelClasses.add(ExcludedAd.class);
        modelClasses.add(Store.class);
        modelClasses.add(RealmLocalNotificationSync.class);
        modelClasses.add(FileToDownload.class);
        modelClasses.add(StoredMinimalAd.class);
        modelClasses.add(Installed.class);
        modelClasses.add(Download.class);
        modelClasses.add(MinimalAd.class);
        f42374a = Collections.unmodifiableSet(modelClasses);
    }

    /* renamed from: a */
    public Map<Class<? extends C0105Y>, OsObjectSchemaInfo> mo23751a() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<>();
        infoMap.put(MigratedApp.class, C14086t.m45019c());
        infoMap.put(RealmString.class, C14057fa.m44867c());
        infoMap.put(RealmAuthorization.class, C13992G.m44553c());
        infoMap.put(RealmInteger.class, C14010Q.m44659c());
        infoMap.put(RealmEvent.class, C14003M.m44618c());
        infoMap.put(Installation.class, C14081p.m44991c());
        infoMap.put(RealmExperiment.class, C14007O.m44645c());
        infoMap.put(Update.class, C14077na.m44977c());
        infoMap.put(Notification.class, C14090w.m45033c());
        infoMap.put(ExcludedAd.class, C14068k.m44935c());
        infoMap.put(Store.class, C14066ja.m44921c());
        infoMap.put(RealmLocalNotificationSync.class, C14017V.m44689c());
        infoMap.put(FileToDownload.class, C14075n.m44963c());
        infoMap.put(StoredMinimalAd.class, C14071la.m44949c());
        infoMap.put(Installed.class, C14084r.m45005c());
        infoMap.put(Download.class, C14055f.m44853c());
        infoMap.put(MinimalAd.class, MinimalAdRealmProxy.m44631c());
        return infoMap;
    }

    /* renamed from: a */
    public C7327c mo23750a(Class<? extends C0105Y> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        C7346q.m16197a(clazz);
        if (clazz.equals(MigratedApp.class)) {
            return C14086t.m45016a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmString.class)) {
            return C14057fa.m44864a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmAuthorization.class)) {
            return C13992G.m44550a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmInteger.class)) {
            return C14010Q.m44656a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmEvent.class)) {
            return C14003M.m44615a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Installation.class)) {
            return C14081p.m44988a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmExperiment.class)) {
            return C14007O.m44642a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Update.class)) {
            return C14077na.m44974a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Notification.class)) {
            return C14090w.m45030a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(ExcludedAd.class)) {
            return C14068k.m44932a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Store.class)) {
            return C14066ja.m44918a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RealmLocalNotificationSync.class)) {
            return C14017V.m44686a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(FileToDownload.class)) {
            return C14075n.m44960a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(StoredMinimalAd.class)) {
            return C14071la.m44946a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Installed.class)) {
            return C14084r.m45002a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(Download.class)) {
            return C14055f.m44850a(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(MinimalAd.class)) {
            return MinimalAdRealmProxy.m44628a(sharedRealm, allowExtraColumns);
        }
        throw C7346q.m16198b(clazz);
    }

    /* renamed from: c */
    public String mo23755c(Class<? extends C0105Y> clazz) {
        C7346q.m16197a(clazz);
        if (clazz.equals(MigratedApp.class)) {
            return C14086t.m45020d();
        }
        if (clazz.equals(RealmString.class)) {
            return C14057fa.m44868d();
        }
        if (clazz.equals(RealmAuthorization.class)) {
            return C13992G.m44554d();
        }
        if (clazz.equals(RealmInteger.class)) {
            return C14010Q.m44660d();
        }
        if (clazz.equals(RealmEvent.class)) {
            return C14003M.m44619d();
        }
        if (clazz.equals(Installation.class)) {
            return C14081p.m44992d();
        }
        if (clazz.equals(RealmExperiment.class)) {
            return C14007O.m44646d();
        }
        if (clazz.equals(Update.class)) {
            return C14077na.m44978d();
        }
        if (clazz.equals(Notification.class)) {
            return C14090w.m45034d();
        }
        if (clazz.equals(ExcludedAd.class)) {
            return C14068k.m44936d();
        }
        if (clazz.equals(Store.class)) {
            return C14066ja.m44922d();
        }
        if (clazz.equals(RealmLocalNotificationSync.class)) {
            return C14017V.m44690d();
        }
        if (clazz.equals(FileToDownload.class)) {
            return C14075n.m44964d();
        }
        if (clazz.equals(StoredMinimalAd.class)) {
            return C14071la.m44950d();
        }
        if (clazz.equals(Installed.class)) {
            return C14084r.m45006d();
        }
        if (clazz.equals(Download.class)) {
            return C14055f.m44854d();
        }
        if (clazz.equals(MinimalAd.class)) {
            return MinimalAdRealmProxy.m44632d();
        }
        throw C7346q.m16198b(clazz);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23749a(Class<E> clazz, Object baseRealm, C7347r row, C7327c columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        C14050b objectContext = (C14050b) C14048d.f42564c.get();
        try {
            objectContext.mo43698a((C14048d) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            C7346q.m16197a(clazz);
            if (clazz.equals(MigratedApp.class)) {
                return (C0105Y) clazz.cast(new C14086t());
            }
            if (clazz.equals(RealmString.class)) {
                E e = (C0105Y) clazz.cast(new C14057fa());
                objectContext.mo43697a();
                return e;
            } else if (clazz.equals(RealmAuthorization.class)) {
                E e2 = (C0105Y) clazz.cast(new C13992G());
                objectContext.mo43697a();
                return e2;
            } else if (clazz.equals(RealmInteger.class)) {
                E e3 = (C0105Y) clazz.cast(new C14010Q());
                objectContext.mo43697a();
                return e3;
            } else if (clazz.equals(RealmEvent.class)) {
                E e4 = (C0105Y) clazz.cast(new C14003M());
                objectContext.mo43697a();
                return e4;
            } else if (clazz.equals(Installation.class)) {
                E e5 = (C0105Y) clazz.cast(new C14081p());
                objectContext.mo43697a();
                return e5;
            } else if (clazz.equals(RealmExperiment.class)) {
                E e6 = (C0105Y) clazz.cast(new C14007O());
                objectContext.mo43697a();
                return e6;
            } else if (clazz.equals(Update.class)) {
                E e7 = (C0105Y) clazz.cast(new C14077na());
                objectContext.mo43697a();
                return e7;
            } else if (clazz.equals(Notification.class)) {
                E e8 = (C0105Y) clazz.cast(new C14090w());
                objectContext.mo43697a();
                return e8;
            } else if (clazz.equals(ExcludedAd.class)) {
                E e9 = (C0105Y) clazz.cast(new C14068k());
                objectContext.mo43697a();
                return e9;
            } else if (clazz.equals(Store.class)) {
                E e10 = (C0105Y) clazz.cast(new C14066ja());
                objectContext.mo43697a();
                return e10;
            } else if (clazz.equals(RealmLocalNotificationSync.class)) {
                E e11 = (C0105Y) clazz.cast(new C14017V());
                objectContext.mo43697a();
                return e11;
            } else if (clazz.equals(FileToDownload.class)) {
                E e12 = (C0105Y) clazz.cast(new C14075n());
                objectContext.mo43697a();
                return e12;
            } else if (clazz.equals(StoredMinimalAd.class)) {
                E e13 = (C0105Y) clazz.cast(new C14071la());
                objectContext.mo43697a();
                return e13;
            } else if (clazz.equals(Installed.class)) {
                E e14 = (C0105Y) clazz.cast(new C14084r());
                objectContext.mo43697a();
                return e14;
            } else if (clazz.equals(Download.class)) {
                E e15 = (C0105Y) clazz.cast(new C14055f());
                objectContext.mo43697a();
                return e15;
            } else if (clazz.equals(MinimalAd.class)) {
                E e16 = (C0105Y) clazz.cast(new MinimalAdRealmProxy());
                objectContext.mo43697a();
                return e16;
            } else {
                throw C7346q.m16198b(clazz);
            }
        } finally {
            objectContext.mo43697a();
        }
    }

    /* renamed from: b */
    public Set<Class<? extends C0105Y>> mo23754b() {
        return f42374a;
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23747a(C13990F realm, E obj, boolean update, Map<C0105Y, C7344p> cache) {
        Class<E> clazz = obj instanceof C7344p ? obj.getClass().getSuperclass() : obj.getClass();
        if (clazz.equals(MigratedApp.class)) {
            return (C0105Y) clazz.cast(C14086t.m45018b(realm, (MigratedApp) obj, update, cache));
        }
        if (clazz.equals(RealmString.class)) {
            return (C0105Y) clazz.cast(C14057fa.m44866b(realm, (RealmString) obj, update, cache));
        }
        if (clazz.equals(RealmAuthorization.class)) {
            return (C0105Y) clazz.cast(C13992G.m44552b(realm, (RealmAuthorization) obj, update, cache));
        }
        if (clazz.equals(RealmInteger.class)) {
            return (C0105Y) clazz.cast(C14010Q.m44658b(realm, (RealmInteger) obj, update, cache));
        }
        if (clazz.equals(RealmEvent.class)) {
            return (C0105Y) clazz.cast(C14003M.m44617b(realm, (RealmEvent) obj, update, cache));
        }
        if (clazz.equals(Installation.class)) {
            return (C0105Y) clazz.cast(C14081p.m44990b(realm, (Installation) obj, update, cache));
        }
        if (clazz.equals(RealmExperiment.class)) {
            return (C0105Y) clazz.cast(C14007O.m44644b(realm, (RealmExperiment) obj, update, cache));
        }
        if (clazz.equals(Update.class)) {
            return (C0105Y) clazz.cast(C14077na.m44976b(realm, (Update) obj, update, cache));
        }
        if (clazz.equals(Notification.class)) {
            return (C0105Y) clazz.cast(C14090w.m45032b(realm, (Notification) obj, update, cache));
        }
        if (clazz.equals(ExcludedAd.class)) {
            return (C0105Y) clazz.cast(C14068k.m44934b(realm, (ExcludedAd) obj, update, cache));
        }
        if (clazz.equals(Store.class)) {
            return (C0105Y) clazz.cast(C14066ja.m44920b(realm, (Store) obj, update, cache));
        }
        if (clazz.equals(RealmLocalNotificationSync.class)) {
            return (C0105Y) clazz.cast(C14017V.m44688b(realm, (RealmLocalNotificationSync) obj, update, cache));
        }
        if (clazz.equals(FileToDownload.class)) {
            return (C0105Y) clazz.cast(C14075n.m44962b(realm, (FileToDownload) obj, update, cache));
        }
        if (clazz.equals(StoredMinimalAd.class)) {
            return (C0105Y) clazz.cast(C14071la.m44948b(realm, (StoredMinimalAd) obj, update, cache));
        }
        if (clazz.equals(Installed.class)) {
            return (C0105Y) clazz.cast(C14084r.m45004b(realm, (Installed) obj, update, cache));
        }
        if (clazz.equals(Download.class)) {
            return (C0105Y) clazz.cast(C14055f.m44852b(realm, (Download) obj, update, cache));
        }
        if (clazz.equals(MinimalAd.class)) {
            return (C0105Y) clazz.cast(MinimalAdRealmProxy.m44630b(realm, (MinimalAd) obj, update, cache));
        }
        throw C7346q.m16198b(clazz);
    }

    /* renamed from: a */
    public void mo23752a(C13990F realm, C0105Y obj, Map<C0105Y, Long> cache) {
        Class<RealmModel> clazz = obj instanceof C7344p ? obj.getClass().getSuperclass() : obj.getClass();
        if (clazz.equals(MigratedApp.class)) {
            C14086t.m45012a(realm, (MigratedApp) obj, cache);
        } else if (clazz.equals(RealmString.class)) {
            C14057fa.m44860a(realm, (RealmString) obj, cache);
        } else if (clazz.equals(RealmAuthorization.class)) {
            C13992G.m44546a(realm, (RealmAuthorization) obj, cache);
        } else if (clazz.equals(RealmInteger.class)) {
            C14010Q.m44652a(realm, (RealmInteger) obj, cache);
        } else if (clazz.equals(RealmEvent.class)) {
            C14003M.m44611a(realm, (RealmEvent) obj, cache);
        } else if (clazz.equals(Installation.class)) {
            C14081p.m44984a(realm, (Installation) obj, cache);
        } else if (clazz.equals(RealmExperiment.class)) {
            C14007O.m44638a(realm, (RealmExperiment) obj, cache);
        } else if (clazz.equals(Update.class)) {
            C14077na.m44970a(realm, (Update) obj, cache);
        } else if (clazz.equals(Notification.class)) {
            C14090w.m45026a(realm, (Notification) obj, cache);
        } else if (clazz.equals(ExcludedAd.class)) {
            C14068k.m44928a(realm, (ExcludedAd) obj, cache);
        } else if (clazz.equals(Store.class)) {
            C14066ja.m44914a(realm, (Store) obj, cache);
        } else if (clazz.equals(RealmLocalNotificationSync.class)) {
            C14017V.m44682a(realm, (RealmLocalNotificationSync) obj, cache);
        } else if (clazz.equals(FileToDownload.class)) {
            C14075n.m44956a(realm, (FileToDownload) obj, cache);
        } else if (clazz.equals(StoredMinimalAd.class)) {
            C14071la.m44942a(realm, (StoredMinimalAd) obj, cache);
        } else if (clazz.equals(Installed.class)) {
            C14084r.m44998a(realm, (Installed) obj, cache);
        } else if (clazz.equals(Download.class)) {
            C14055f.m44846a(realm, (Download) obj, cache);
        } else if (clazz.equals(MinimalAd.class)) {
            MinimalAdRealmProxy.m44625a(realm, (MinimalAd) obj, cache);
        } else {
            throw C7346q.m16198b(clazz);
        }
    }

    /* renamed from: a */
    public void mo23753a(C13990F realm, Collection<? extends C0105Y> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        Map<RealmModel, Long> cache = new HashMap<>(objects.size());
        if (iterator.hasNext()) {
            C0105Y object = (C0105Y) iterator.next();
            Class<RealmModel> clazz = object instanceof C7344p ? object.getClass().getSuperclass() : object.getClass();
            if (clazz.equals(MigratedApp.class)) {
                C14086t.m45012a(realm, (MigratedApp) object, cache);
            } else if (clazz.equals(RealmString.class)) {
                C14057fa.m44860a(realm, (RealmString) object, cache);
            } else if (clazz.equals(RealmAuthorization.class)) {
                C13992G.m44546a(realm, (RealmAuthorization) object, cache);
            } else if (clazz.equals(RealmInteger.class)) {
                C14010Q.m44652a(realm, (RealmInteger) object, cache);
            } else if (clazz.equals(RealmEvent.class)) {
                C14003M.m44611a(realm, (RealmEvent) object, cache);
            } else if (clazz.equals(Installation.class)) {
                C14081p.m44984a(realm, (Installation) object, cache);
            } else if (clazz.equals(RealmExperiment.class)) {
                C14007O.m44638a(realm, (RealmExperiment) object, cache);
            } else if (clazz.equals(Update.class)) {
                C14077na.m44970a(realm, (Update) object, cache);
            } else if (clazz.equals(Notification.class)) {
                C14090w.m45026a(realm, (Notification) object, cache);
            } else if (clazz.equals(ExcludedAd.class)) {
                C14068k.m44928a(realm, (ExcludedAd) object, cache);
            } else if (clazz.equals(Store.class)) {
                C14066ja.m44914a(realm, (Store) object, cache);
            } else if (clazz.equals(RealmLocalNotificationSync.class)) {
                C14017V.m44682a(realm, (RealmLocalNotificationSync) object, cache);
            } else if (clazz.equals(FileToDownload.class)) {
                C14075n.m44956a(realm, (FileToDownload) object, cache);
            } else if (clazz.equals(StoredMinimalAd.class)) {
                C14071la.m44942a(realm, (StoredMinimalAd) object, cache);
            } else if (clazz.equals(Installed.class)) {
                C14084r.m44998a(realm, (Installed) object, cache);
            } else if (clazz.equals(Download.class)) {
                C14055f.m44846a(realm, (Download) object, cache);
            } else if (clazz.equals(MinimalAd.class)) {
                MinimalAdRealmProxy.m44625a(realm, (MinimalAd) object, cache);
            } else {
                throw C7346q.m16198b(clazz);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (clazz.equals(MigratedApp.class)) {
                C14086t.m45017a(realm, iterator, cache);
            } else if (clazz.equals(RealmString.class)) {
                C14057fa.m44865a(realm, iterator, cache);
            } else if (clazz.equals(RealmAuthorization.class)) {
                C13992G.m44551a(realm, iterator, cache);
            } else if (clazz.equals(RealmInteger.class)) {
                C14010Q.m44657a(realm, iterator, cache);
            } else if (clazz.equals(RealmEvent.class)) {
                C14003M.m44616a(realm, iterator, cache);
            } else if (clazz.equals(Installation.class)) {
                C14081p.m44989a(realm, iterator, cache);
            } else if (clazz.equals(RealmExperiment.class)) {
                C14007O.m44643a(realm, iterator, cache);
            } else if (clazz.equals(Update.class)) {
                C14077na.m44975a(realm, iterator, cache);
            } else if (clazz.equals(Notification.class)) {
                C14090w.m45031a(realm, iterator, cache);
            } else if (clazz.equals(ExcludedAd.class)) {
                C14068k.m44933a(realm, iterator, cache);
            } else if (clazz.equals(Store.class)) {
                C14066ja.m44919a(realm, iterator, cache);
            } else if (clazz.equals(RealmLocalNotificationSync.class)) {
                C14017V.m44687a(realm, iterator, cache);
            } else if (clazz.equals(FileToDownload.class)) {
                C14075n.m44961a(realm, iterator, cache);
            } else if (clazz.equals(StoredMinimalAd.class)) {
                C14071la.m44947a(realm, iterator, cache);
            } else if (clazz.equals(Installed.class)) {
                C14084r.m45003a(realm, iterator, cache);
            } else if (clazz.equals(Download.class)) {
                C14055f.m44851a(realm, iterator, cache);
            } else if (clazz.equals(MinimalAd.class)) {
                MinimalAdRealmProxy.m44629a(realm, iterator, cache);
            } else {
                throw C7346q.m16198b(clazz);
            }
        }
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo23748a(E realmObject, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Class<E> clazz = realmObject.getClass().getSuperclass();
        if (clazz.equals(MigratedApp.class)) {
            return (C0105Y) clazz.cast(C14086t.m45013a((MigratedApp) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmString.class)) {
            return (C0105Y) clazz.cast(C14057fa.m44861a((RealmString) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmAuthorization.class)) {
            return (C0105Y) clazz.cast(C13992G.m44547a((RealmAuthorization) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmInteger.class)) {
            return (C0105Y) clazz.cast(C14010Q.m44653a((RealmInteger) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmEvent.class)) {
            return (C0105Y) clazz.cast(C14003M.m44612a((RealmEvent) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Installation.class)) {
            return (C0105Y) clazz.cast(C14081p.m44985a((Installation) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmExperiment.class)) {
            return (C0105Y) clazz.cast(C14007O.m44639a((RealmExperiment) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Update.class)) {
            return (C0105Y) clazz.cast(C14077na.m44971a((Update) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Notification.class)) {
            return (C0105Y) clazz.cast(C14090w.m45027a((Notification) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(ExcludedAd.class)) {
            return (C0105Y) clazz.cast(C14068k.m44929a((ExcludedAd) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Store.class)) {
            return (C0105Y) clazz.cast(C14066ja.m44915a((Store) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(RealmLocalNotificationSync.class)) {
            return (C0105Y) clazz.cast(C14017V.m44683a((RealmLocalNotificationSync) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(FileToDownload.class)) {
            return (C0105Y) clazz.cast(C14075n.m44957a((FileToDownload) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(StoredMinimalAd.class)) {
            return (C0105Y) clazz.cast(C14071la.m44943a((StoredMinimalAd) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Installed.class)) {
            return (C0105Y) clazz.cast(C14084r.m44999a((Installed) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(Download.class)) {
            return (C0105Y) clazz.cast(C14055f.m44847a((Download) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(MinimalAd.class)) {
            return (C0105Y) clazz.cast(MinimalAdRealmProxy.m44626a((MinimalAd) realmObject, 0, maxDepth, cache));
        }
        throw C7346q.m16198b(clazz);
    }
}
