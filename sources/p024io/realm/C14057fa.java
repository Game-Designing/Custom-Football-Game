package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmString;
import p024io.realm.C14048d.C14050b;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.OsObjectSchemaInfo.C7309a;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.fa */
/* compiled from: RealmStringRealmProxy */
public class C14057fa extends RealmString implements C7344p, C14060ga {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42605a = m44869e();

    /* renamed from: b */
    private static final List<String> f42606b;

    /* renamed from: c */
    private C14058a f42607c;

    /* renamed from: d */
    private C13986D<RealmString> f42608d;

    /* renamed from: io.realm.fa$a */
    /* compiled from: RealmStringRealmProxy */
    static final class C14058a extends C7327c {

        /* renamed from: c */
        long f42609c;

        /* renamed from: d */
        long f42610d;

        C14058a(SharedRealm realm, Table table) {
            super(2);
            this.f42609c = mo23757a(table, "id", RealmFieldType.STRING);
            this.f42610d = mo23757a(table, "string", RealmFieldType.STRING);
        }

        C14058a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14058a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14058a src = (C14058a) rawSrc;
            C14058a dst = (C14058a) rawDst;
            dst.f42609c = src.f42609c;
            dst.f42610d = src.f42610d;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("id");
        fieldNames.add("string");
        f42606b = Collections.unmodifiableList(fieldNames);
    }

    C14057fa() {
        this.f42608d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42608d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42607c = (C14058a) context.mo43700c();
            this.f42608d = new C13986D<>(this);
            this.f42608d.mo43507a(context.mo43702e());
            this.f42608d.mo43513b(context.mo43703f());
            this.f42608d.mo43509a(context.mo43699b());
            this.f42608d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$id() {
        this.f42608d.mo43514c().mo43690d();
        return this.f42608d.mo43515d().mo23720m(this.f42607c.f42609c);
    }

    public void realmSet$id(String value) {
        if (!this.f42608d.mo43517f()) {
            this.f42608d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public String realmGet$string() {
        this.f42608d.mo43514c().mo43690d();
        return this.f42608d.mo43515d().mo23720m(this.f42607c.f42610d);
    }

    public void realmSet$string(String value) {
        if (!this.f42608d.mo43517f()) {
            this.f42608d.mo43514c().mo43690d();
            if (value == null) {
                this.f42608d.mo43515d().mo23512b(this.f42607c.f42610d);
            } else {
                this.f42608d.mo43515d().setString(this.f42607c.f42610d, value);
            }
        } else if (this.f42608d.mo43510a()) {
            C7347r row = this.f42608d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42607c.f42610d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42607c.f42610d, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44869e() {
        C7309a builder = new C7309a("RealmString");
        builder.mo23605a("id", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("string", RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44867c() {
        return f42605a;
    }

    /* renamed from: a */
    public static C14058a m44864a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmString";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 2 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 2 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 2 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14058a columnInfo = new C14058a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42609c) {
                String str2 = "id";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'id' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42609c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "string";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'string' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'string' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42610d)) {
                        return columnInfo;
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'string' is required. Either set @Required to field 'string' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field id");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmString' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44868d() {
        return "class_RealmString";
    }

    /* renamed from: b */
    public static RealmString m44866b(C13990F realm, RealmString object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmString realmString = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmString instanceof C7344p) && ((C7344p) realmString).mo23791a().mo43514c() != null && ((C7344p) realmString).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmString instanceof C7344p) && ((C7344p) realmString).mo23791a().mo43514c() != null && ((C7344p) realmString).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmString;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmString);
            if (cachedRealmObject != null) {
                return (RealmString) cachedRealmObject;
            }
            RealmString realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmString.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$id();
                if (value == null) {
                    rowIndex = table.mo23662d(pkColumnIndex);
                } else {
                    rowIndex = table.mo23641a(pkColumnIndex, value);
                }
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmString.class), false, Collections.emptyList());
                            realmObject = new C14057fa();
                            map.put(realmString, realmObject);
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
                return m44863a(realm, object, update, cache);
            }
            m44862a(f, realmObject, realmString, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmString m44863a(C13990F realm, RealmString newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmString) cachedRealmObject;
        }
        RealmString realmObject = (RealmString) realm.mo43528a(RealmString.class, newObject.realmGet$id(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        realmObject.realmSet$string(newObject.realmGet$string());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44860a(C13990F realm, RealmString object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        RealmString realmString = object;
        if ((realmString instanceof C7344p) && ((C7344p) realmString).mo23791a().mo43514c() != null && ((C7344p) realmString).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmString).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmString.class);
        long tableNativePtr = table.getNativePtr();
        C14058a columnInfo = (C14058a) f.f42569h.mo43710a(RealmString.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$id();
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == -1) {
            rowIndex2 = OsObject.m15909a(table, (Object) primaryKeyValue);
        } else {
            rowIndex2 = rowIndex;
        }
        cache.put(realmString, Long.valueOf(rowIndex2));
        String realmGet$string = object.realmGet$string();
        if (realmGet$string != null) {
            String str = primaryKeyValue;
            Table.nativeSetString(tableNativePtr, columnInfo.f42610d, rowIndex2, realmGet$string, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42610d, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44865a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        RealmString object;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmString.class);
        long tableNativePtr = table.getNativePtr();
        C14058a columnInfo = (C14058a) f.f42569h.mo43710a(RealmString.class);
        long pkColumnIndex = table.mo23666f();
        while (objects.hasNext()) {
            RealmString object2 = (RealmString) objects.next();
            if (map.containsKey(object2)) {
                object = object2;
            } else if (!(object2 instanceof C7344p) || ((C7344p) object2).mo23791a().mo43514c() == null || !((C7344p) object2).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object2.realmGet$id();
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == -1) {
                    rowIndex2 = OsObject.m15909a(table, (Object) primaryKeyValue);
                } else {
                    rowIndex2 = rowIndex;
                }
                map.put(object2, Long.valueOf(rowIndex2));
                String realmGet$string = object2.realmGet$string();
                if (realmGet$string != null) {
                    String str = primaryKeyValue;
                    object = object2;
                    Table.nativeSetString(tableNativePtr, columnInfo.f42610d, rowIndex2, realmGet$string, false);
                } else {
                    object = object2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42610d, rowIndex2, false);
                }
            } else {
                map.put(object2, Long.valueOf(((C7344p) object2).mo23791a().mo43515d().getIndex()));
                object = object2;
            }
            RealmString realmString = object;
        }
    }

    /* renamed from: a */
    public static RealmString m44861a(RealmString realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmString unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmString();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmString) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmString) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmString realmString = unmanagedObject;
        C14060ga realmSource = realmObject;
        realmString.realmSet$id(realmSource.realmGet$id());
        realmString.realmSet$string(realmSource.realmGet$string());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmString m44862a(C13990F realm, RealmString realmObject, RealmString newObject, Map<C0105Y, C7344p> map) {
        realmObject.realmSet$string(newObject.realmGet$string());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmString = proxy[");
        stringBuilder.append("{id:");
        String str = "null";
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        stringBuilder.append(",");
        stringBuilder.append("{string:");
        if (realmGet$string() != null) {
            str = realmGet$string();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42608d;
    }

    public int hashCode() {
        String realmName = this.f42608d.mo43514c().mo43545j();
        String tableName = this.f42608d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42608d.mo43515d().getIndex();
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
        C14057fa aRealmString = (C14057fa) o;
        String path = this.f42608d.mo43514c().mo43545j();
        String otherPath = aRealmString.f42608d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42608d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmString.f42608d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42608d.mo43515d().getIndex() != aRealmString.f42608d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
