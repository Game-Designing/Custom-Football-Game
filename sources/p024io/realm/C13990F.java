package p024io.realm;

import android.content.Context;
import android.os.SystemClock;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy.CacheData;
import io.realm.internal.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import p024io.realm.C14001L.C14002a;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmFileException;
import p024io.realm.exceptions.RealmFileException.Kind;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7324b;
import p024io.realm.internal.C7335j;
import p024io.realm.internal.C7342n;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7346q;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsSchemaInfo;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.internal.p158c.C7329a;

/* renamed from: io.realm.F */
/* compiled from: Realm */
public class C13990F extends C14048d {

    /* renamed from: i */
    private static final Object f42375i = new Object();

    /* renamed from: j */
    private static C14001L f42376j;

    /* renamed from: io.realm.F$a */
    /* compiled from: Realm */
    public interface C13991a {
        /* renamed from: a */
        void mo43549a(C13990F f);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo43533a() {
        super.mo43533a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo43538b() {
        super.mo43538b();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ void mo43543g() {
        super.mo43543g();
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ C14001L mo43544i() {
        return super.mo43544i();
    }

    /* renamed from: j */
    public /* bridge */ /* synthetic */ String mo43545j() {
        return super.mo43545j();
    }

    /* renamed from: v */
    public /* bridge */ /* synthetic */ C14054ea mo43546v() {
        return super.mo43546v();
    }

    /* renamed from: x */
    public /* bridge */ /* synthetic */ long mo43547x() {
        return super.mo43547x();
    }

    /* renamed from: y */
    public /* bridge */ /* synthetic */ boolean mo43548y() {
        return super.mo43548y();
    }

    private C13990F(C13996J cache) {
        super(cache);
    }

    /* renamed from: a */
    public static synchronized void m44511a(Context context) {
        synchronized (C13990F.class) {
            if (C14048d.f42562a == null) {
                if (context != null) {
                    m44517b(context);
                    C7342n.m16192a(context);
                    m44518c(new C14002a(context).mo43583a());
                    C7335j.m16148a().mo23772a(context);
                    C14048d.f42562a = context.getApplicationContext();
                    SharedRealm.m15931a(new File(context.getFilesDir(), ".realm.temp"));
                } else {
                    throw new IllegalArgumentException("Non-null context required.");
                }
            }
        }
    }

    /* renamed from: b */
    private static void m44517b(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            if (!filesDir.exists()) {
                try {
                    filesDir.mkdirs();
                } catch (SecurityException e) {
                }
            } else {
                return;
            }
        }
        if (filesDir == null || !filesDir.exists()) {
            long[] timeoutsMs = {1, 2, 5, 10, 16};
            long currentTotalWaitMs = 0;
            int waitIndex = -1;
            do {
                if (context.getFilesDir() != null && context.getFilesDir().exists()) {
                    break;
                }
                waitIndex++;
                long waitMs = timeoutsMs[Math.min(waitIndex, timeoutsMs.length - 1)];
                SystemClock.sleep(waitMs);
                currentTotalWaitMs += waitMs;
            } while (currentTotalWaitMs <= 200);
        }
        if (context.getFilesDir() == null || !context.getFilesDir().exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Context.getFilesDir() returns ");
            sb.append(context.getFilesDir());
            sb.append(" which is not an existing directory. See https://issuetracker.google.com/issues/36918154");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* renamed from: A */
    public static C13990F m44505A() {
        C14001L configuration = m44522z();
        if (configuration != null) {
            return (C13990F) C13996J.m44562a(configuration, C13990F.class);
        }
        if (C14048d.f42562a == null) {
            throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
        }
        throw new IllegalStateException("Set default configuration by using `Realm.setDefaultConfiguration(RealmConfiguration)`.");
    }

    /* renamed from: b */
    public static C13990F m44516b(C14001L configuration) {
        if (configuration != null) {
            return (C13990F) C13996J.m44562a(configuration, C13990F.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    /* renamed from: c */
    public static void m44518c(C14001L configuration) {
        if (configuration != null) {
            synchronized (f42375i) {
                f42376j = configuration;
            }
            return;
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    /* renamed from: z */
    public static C14001L m44522z() {
        C14001L l;
        synchronized (f42375i) {
            l = f42376j;
        }
        return l;
    }

    /* renamed from: a */
    static C13990F m44507a(C13996J cache) {
        C14001L configuration = cache.mo43553a();
        try {
            return m44515b(cache);
        } catch (RealmMigrationNeededException e) {
            if (configuration.mo43578s()) {
                m44514a(configuration);
            } else {
                try {
                    if (configuration.mo43566g() != null) {
                        m44513a(configuration, e);
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    throw new RealmFileException(Kind.NOT_FOUND, (Throwable) fileNotFoundException);
                }
            }
            return m44515b(cache);
        }
    }

    /* renamed from: b */
    private static C13990F m44515b(C13996J cache) {
        C13990F realm = new C13990F(cache);
        C14001L configuration = realm.f42566e;
        long currentVersion = realm.mo43547x();
        long requiredVersion = configuration.mo43573m();
        C7324b columnIndices = C13996J.m44563a(cache.mo43556b(), requiredVersion);
        if (columnIndices != null) {
            realm.f42569h.mo43713a(columnIndices);
        } else {
            if (!configuration.mo43576q() && currentVersion != -1) {
                if (currentVersion < requiredVersion) {
                    realm.mo43694h();
                    throw new RealmMigrationNeededException(configuration.mo43567h(), String.format(Locale.US, "Realm on disk need to migrate from v%s to v%s", new Object[]{Long.valueOf(currentVersion), Long.valueOf(requiredVersion)}));
                } else if (requiredVersion < currentVersion) {
                    realm.mo43694h();
                    throw new IllegalArgumentException(String.format(Locale.US, "Realm on disk is newer than the one specified: v%s vs. v%s", new Object[]{Long.valueOf(currentVersion), Long.valueOf(requiredVersion)}));
                }
            }
            try {
                m44512a(realm);
            } catch (RuntimeException e) {
                realm.mo43694h();
                throw e;
            }
        }
        return realm;
    }

    /* renamed from: a */
    private static void m44512a(C13990F realm) {
        C13990F f = realm;
        boolean commitChanges = false;
        boolean unversioned = true;
        try {
            f.mo43688a(true);
            C14001L configuration = realm.mo43544i();
            long currentVersion = realm.mo43547x();
            if (currentVersion != -1) {
                unversioned = false;
            }
            long newVersion = configuration.mo43573m();
            C7346q mediator = configuration.mo43572l();
            Set<Class<? extends RealmModel>> modelClasses = mediator.mo23754b();
            if (configuration.mo43576q()) {
                if (!configuration.mo43575o()) {
                    f.f42568g.mo23619a(new OsSchemaInfo(mediator.mo23751a().values()), newVersion);
                    commitChanges = true;
                }
            } else if (unversioned) {
                if (!configuration.mo43575o()) {
                    f.f42568g.mo23619a(new OsSchemaInfo(mediator.mo23751a().values()), newVersion);
                    commitChanges = true;
                } else {
                    throw new IllegalArgumentException("Cannot create the Realm schema in a read-only file.");
                }
            }
            Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> columnInfoMap = new HashMap<>(modelClasses.size());
            for (Class<? extends RealmModel> modelClass : modelClasses) {
                long currentVersion2 = currentVersion;
                columnInfoMap.put(C7329a.m16121a(modelClass, Table.m15958a(mediator.mo23755c(modelClass))), mediator.mo23750a(modelClass, f.f42568g, configuration.mo43576q()));
                currentVersion = currentVersion2;
            }
            realm.mo43546v().mo43712a(unversioned ? newVersion : currentVersion, columnInfoMap);
            C13991a transaction = configuration.mo43565f();
            if (transaction != null && unversioned) {
                transaction.mo43549a(f);
            }
            if (commitChanges) {
                realm.mo43543g();
            } else if (realm.mo43548y()) {
                realm.mo43538b();
            }
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                realm.mo43543g();
            } else if (realm.mo43548y()) {
                realm.mo43538b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <E extends C0105Y> E mo43529a(Class<E> clazz, boolean acceptDefaultValue, List<String> excludeFields) {
        Table table = this.f42569h.mo43722c(clazz);
        if (!table.mo23671h()) {
            return this.f42566e.mo43572l().mo23749a(clazz, this, OsObject.m15910a(table), this.f42569h.mo43710a(clazz), acceptDefaultValue, excludeFields);
        }
        throw new RealmException(String.format(Locale.US, "'%s' has a primary key, use 'createObject(Class<E>, Object)' instead.", new Object[]{table.mo23659c()}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <E extends C0105Y> E mo43528a(Class<E> clazz, Object primaryKeyValue, boolean acceptDefaultValue, List<String> excludeFields) {
        return this.f42566e.mo43572l().mo23749a(clazz, this, OsObject.m15912b(this.f42569h.mo43722c(clazz), primaryKeyValue), this.f42569h.mo43710a(clazz), acceptDefaultValue, excludeFields);
    }

    /* renamed from: b */
    public <E extends C0105Y> E mo43536b(E object) {
        m44520e(object);
        return m44509a(object, false, (Map<C0105Y, C7344p>) new HashMap<C0105Y,C7344p>());
    }

    /* renamed from: c */
    public <E extends C0105Y> E mo43539c(E object) {
        m44520e(object);
        m44519d(object.getClass());
        return m44509a(object, true, (Map<C0105Y, C7344p>) new HashMap<C0105Y,C7344p>());
    }

    /* renamed from: a */
    public void mo43535a(Collection<? extends C0105Y> objects) {
        mo43691e();
        if (objects == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        } else if (!objects.isEmpty()) {
            this.f42566e.mo43572l().mo23753a(this, objects);
        }
    }

    /* renamed from: d */
    public void mo43542d(C0105Y object) {
        mo43691e();
        if (object != null) {
            this.f42566e.mo43572l().mo23752a(this, object, new HashMap<>());
            return;
        }
        throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
    }

    /* renamed from: a */
    public <E extends C0105Y> List<E> mo43531a(Iterable<E> realmObjects) {
        return mo43532a(realmObjects, (int) MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: a */
    public <E extends C0105Y> List<E> mo43532a(Iterable<E> realmObjects, int maxDepth) {
        m44510a(maxDepth);
        if (realmObjects == null) {
            return new ArrayList(0);
        }
        ArrayList<E> unmanagedObjects = new ArrayList<>();
        Map<RealmModel, CacheData<RealmModel>> listCache = new HashMap<>();
        for (E object : realmObjects) {
            m44521f(object);
            unmanagedObjects.add(m44508a(object, maxDepth, listCache));
        }
        return unmanagedObjects;
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo43526a(E realmObject) {
        return mo43527a(realmObject, (int) MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: a */
    public <E extends C0105Y> E mo43527a(E realmObject, int maxDepth) {
        m44510a(maxDepth);
        m44521f(realmObject);
        return m44508a(realmObject, maxDepth, (Map<C0105Y, C7345a<C0105Y>>) new HashMap<C0105Y,C7345a<C0105Y>>());
    }

    /* renamed from: c */
    public <E extends C0105Y> C14047ca<E> mo43540c(Class<E> clazz) {
        mo43690d();
        return C14047ca.m44752a(this, clazz);
    }

    /* renamed from: a */
    public void mo43534a(Class<? extends C0105Y> clazz) {
        mo43690d();
        this.f42569h.mo43722c(clazz).mo23657b();
    }

    /* renamed from: a */
    private <E extends C0105Y> E m44509a(E object, boolean update, Map<C0105Y, C7344p> cache) {
        mo43690d();
        return this.f42566e.mo43572l().mo23747a(this, object, update, cache);
    }

    /* renamed from: a */
    private <E extends C0105Y> E m44508a(E object, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        mo43690d();
        return this.f42566e.mo43572l().mo23748a(object, maxDepth, cache);
    }

    /* renamed from: e */
    private <E extends C0105Y> void m44520e(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        }
    }

    /* renamed from: d */
    private void m44519d(Class<? extends C0105Y> clazz) {
        if (!this.f42569h.mo43722c(clazz).mo23671h()) {
            StringBuilder sb = new StringBuilder();
            sb.append("A RealmObject with no @PrimaryKey cannot be updated: ");
            sb.append(clazz.toString());
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private void m44510a(int maxDepth) {
        if (maxDepth < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("maxDepth must be > 0. It was: ");
            sb.append(maxDepth);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f */
    private <E extends C0105Y> void m44521f(E realmObject) {
        if (realmObject == null) {
            throw new IllegalArgumentException("Null objects cannot be copied from Realm.");
        } else if (!C0106Z.isManaged(realmObject) || !C0106Z.isValid(realmObject)) {
            throw new IllegalArgumentException("Only valid managed objects can be copied from Realm.");
        } else if (realmObject instanceof C14065j) {
            throw new IllegalArgumentException("DynamicRealmObject cannot be copied from Realm.");
        }
    }

    /* renamed from: a */
    private static void m44513a(C14001L configuration, RealmMigrationNeededException cause) throws FileNotFoundException {
        C14048d.m44786a(configuration, null, new C13989E(), cause);
    }

    /* renamed from: a */
    public static boolean m44514a(C14001L configuration) {
        return C14048d.m44787a(configuration);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Table mo43537b(Class<? extends C0105Y> clazz) {
        return this.f42569h.mo43722c(clazz);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7324b mo43530a(C7324b[] globalCacheArray) {
        long currentSchemaVersion = this.f42568g.mo23631g();
        if (currentSchemaVersion == this.f42569h.mo43720c()) {
            return null;
        }
        C7324b createdGlobalCache = null;
        C7324b cacheForCurrentVersion = C13996J.m44563a(globalCacheArray, currentSchemaVersion);
        if (cacheForCurrentVersion == null) {
            C7346q mediator = mo43544i().mo43572l();
            Set<Class<? extends RealmModel>> modelClasses = mediator.mo23754b();
            Map<Pair<Class<? extends RealmModel>, String>, ColumnInfo> map = new HashMap<>(modelClasses.size());
            try {
                for (Class<? extends RealmModel> clazz : modelClasses) {
                    map.put(C7329a.m16121a(clazz, Table.m15958a(mediator.mo23755c(clazz))), mediator.mo23750a(clazz, this.f42568g, true));
                }
                C7324b bVar = new C7324b(currentSchemaVersion, map);
                createdGlobalCache = bVar;
                cacheForCurrentVersion = bVar;
            } catch (RealmMigrationNeededException e) {
                throw e;
            }
        }
        this.f42569h.mo43719b(cacheForCurrentVersion);
        return createdGlobalCache;
    }

    /* renamed from: B */
    public static Object m44506B() {
        String str = "Could not create an instance of ";
        String moduleName = "io.realm.DefaultRealmModule";
        try {
            Constructor<?> constructor = Class.forName(moduleName).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (InvocationTargetException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(moduleName);
            throw new RealmException(sb.toString(), e2);
        } catch (InstantiationException e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(moduleName);
            throw new RealmException(sb2.toString(), e3);
        } catch (IllegalAccessException e4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(moduleName);
            throw new RealmException(sb3.toString(), e4);
        }
    }
}
