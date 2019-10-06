package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.ExcludedAd;
import p024io.realm.C14048d.C14050b;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.OsObjectSchemaInfo.C7309a;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.k */
/* compiled from: ExcludedAdRealmProxy */
public class C14068k extends ExcludedAd implements C7344p, C14070l {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42629a = m44937e();

    /* renamed from: b */
    private static final List<String> f42630b;

    /* renamed from: c */
    private C14069a f42631c;

    /* renamed from: d */
    private C13986D<ExcludedAd> f42632d;

    /* renamed from: io.realm.k$a */
    /* compiled from: ExcludedAdRealmProxy */
    static final class C14069a extends C7327c {

        /* renamed from: c */
        long f42633c;

        C14069a(SharedRealm realm, Table table) {
            super(1);
            this.f42633c = mo23757a(table, "packageName", RealmFieldType.STRING);
        }

        C14069a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14069a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            ((C14069a) rawDst).f42633c = ((C14069a) rawSrc).f42633c;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("packageName");
        f42630b = Collections.unmodifiableList(fieldNames);
    }

    C14068k() {
        this.f42632d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42632d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42631c = (C14069a) context.mo43700c();
            this.f42632d = new C13986D<>(this);
            this.f42632d.mo43507a(context.mo43702e());
            this.f42632d.mo43513b(context.mo43703f());
            this.f42632d.mo43509a(context.mo43699b());
            this.f42632d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$packageName() {
        this.f42632d.mo43514c().mo43690d();
        return this.f42632d.mo43515d().mo23720m(this.f42631c.f42633c);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42632d.mo43517f()) {
            this.f42632d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'packageName' cannot be changed after object was created.");
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44937e() {
        C7309a builder = new C7309a("ExcludedAd");
        builder.mo23605a("packageName", RealmFieldType.STRING, true, true, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44935c() {
        return f42629a;
    }

    /* renamed from: a */
    public static C14069a m44932a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_ExcludedAd";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 1) {
                if (columnCount < 1) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 1 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 1 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 1 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14069a columnInfo = new C14069a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'packageName' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42633c) {
                String str2 = "packageName";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42633c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    return columnInfo;
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'packageName' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field packageName");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'ExcludedAd' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44936d() {
        return "class_ExcludedAd";
    }

    /* renamed from: b */
    public static ExcludedAd m44934b(C13990F realm, ExcludedAd object, boolean update, Map<C0105Y, C7344p> cache) {
        C13990F f = realm;
        ExcludedAd excludedAd = object;
        Map<C0105Y, C7344p> map = cache;
        if ((excludedAd instanceof C7344p) && ((C7344p) excludedAd).mo23791a().mo43514c() != null && ((C7344p) excludedAd).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((excludedAd instanceof C7344p) && ((C7344p) excludedAd).mo23791a().mo43514c() != null && ((C7344p) excludedAd).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return excludedAd;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(excludedAd);
            if (cachedRealmObject != null) {
                return (ExcludedAd) cachedRealmObject;
            }
            ExcludedAd realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(ExcludedAd.class);
                long pkColumnIndex = table.mo23666f();
                long rowIndex = table.mo23641a(pkColumnIndex, object.realmGet$packageName());
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(ExcludedAd.class), false, Collections.emptyList());
                            realmObject = new C14068k();
                            map.put(excludedAd, realmObject);
                            objectContext.mo43697a();
                        } catch (Throwable th) {
                            th = th;
                            objectContext.mo43697a();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        long j3 = rowIndex;
                        long j4 = pkColumnIndex;
                        objectContext.mo43697a();
                        throw th;
                    }
                } else {
                    long j5 = pkColumnIndex;
                    canUpdate = false;
                }
            }
            if (!canUpdate) {
                return m44931a(realm, object, update, cache);
            }
            m44930a(f, realmObject, excludedAd, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static ExcludedAd m44931a(C13990F realm, ExcludedAd newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (ExcludedAd) cachedRealmObject;
        }
        ExcludedAd realmObject = (ExcludedAd) realm.mo43528a(ExcludedAd.class, newObject.realmGet$packageName(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        ExcludedAd excludedAd = newObject;
        ExcludedAd excludedAd2 = realmObject;
        return realmObject;
    }

    /* renamed from: a */
    public static long m44928a(C13990F realm, ExcludedAd object, Map<C0105Y, Long> cache) {
        if ((object instanceof C7344p) && ((C7344p) object).mo23791a().mo43514c() != null && ((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) object).mo23791a().mo43515d().getIndex();
        }
        Table table = realm.mo43537b(ExcludedAd.class);
        long tableNativePtr = table.getNativePtr();
        C7327c a = realm.f42569h.mo43710a(ExcludedAd.class);
        long pkColumnIndex = table.mo23666f();
        long rowIndex = -1;
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, realmGet$packageName);
        }
        if (rowIndex == -1) {
            rowIndex = OsObject.m15909a(table, (Object) realmGet$packageName);
        }
        cache.put(object, Long.valueOf(rowIndex));
        return rowIndex;
    }

    /* renamed from: a */
    public static void m44933a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        Table table = realm.mo43537b(ExcludedAd.class);
        long tableNativePtr = table.getNativePtr();
        C7327c a = realm.f42569h.mo43710a(ExcludedAd.class);
        long pkColumnIndex = table.mo23666f();
        while (objects.hasNext()) {
            ExcludedAd object = (ExcludedAd) objects.next();
            if (!cache.containsKey(object)) {
                if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                    long rowIndex = -1;
                    String realmGet$packageName = object.realmGet$packageName();
                    if (realmGet$packageName != null) {
                        rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, realmGet$packageName);
                    }
                    if (rowIndex == -1) {
                        rowIndex = OsObject.m15909a(table, (Object) realmGet$packageName);
                    }
                    cache.put(object, Long.valueOf(rowIndex));
                } else {
                    cache.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                }
            }
        }
    }

    /* renamed from: a */
    public static ExcludedAd m44929a(ExcludedAd realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        ExcludedAd unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new ExcludedAd();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (ExcludedAd) cachedObject.f14332b;
        } else {
            unmanagedObject = (ExcludedAd) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        unmanagedObject.realmSet$packageName(realmObject.realmGet$packageName());
        return unmanagedObject;
    }

    /* renamed from: a */
    static ExcludedAd m44930a(C13990F realm, ExcludedAd realmObject, ExcludedAd newObject, Map<C0105Y, C7344p> map) {
        ExcludedAd excludedAd = realmObject;
        ExcludedAd excludedAd2 = newObject;
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ExcludedAd = proxy[");
        stringBuilder.append("{packageName:");
        stringBuilder.append(realmGet$packageName());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42632d;
    }

    public int hashCode() {
        String realmName = this.f42632d.mo43514c().mo43545j();
        String tableName = this.f42632d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42632d.mo43515d().getIndex();
        int i = 0;
        int result = ((17 * 31) + (realmName != null ? realmName.hashCode() : 0)) * 31;
        if (tableName != null) {
            i = tableName.hashCode();
        }
        return ((result + i) * 31) + ((int) ((rowIndex >>> 32) ^ rowIndex));
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C14068k aExcludedAd = (C14068k) o;
        String path = this.f42632d.mo43514c().mo43545j();
        String otherPath = aExcludedAd.f42632d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42632d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aExcludedAd.f42632d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42632d.mo43515d().getIndex() != aExcludedAd.f42632d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
