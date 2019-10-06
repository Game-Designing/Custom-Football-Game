package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmInteger;
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

/* renamed from: io.realm.Q */
/* compiled from: RealmIntegerRealmProxy */
public class C14010Q extends RealmInteger implements C7344p, C14012S {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42472a = m44661e();

    /* renamed from: b */
    private static final List<String> f42473b;

    /* renamed from: c */
    private C14011a f42474c;

    /* renamed from: d */
    private C13986D<RealmInteger> f42475d;

    /* renamed from: io.realm.Q$a */
    /* compiled from: RealmIntegerRealmProxy */
    static final class C14011a extends C7327c {

        /* renamed from: c */
        long f42476c;

        /* renamed from: d */
        long f42477d;

        C14011a(SharedRealm realm, Table table) {
            super(2);
            this.f42476c = mo23757a(table, "id", RealmFieldType.STRING);
            this.f42477d = mo23757a(table, "integer", RealmFieldType.INTEGER);
        }

        C14011a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14011a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14011a src = (C14011a) rawSrc;
            C14011a dst = (C14011a) rawDst;
            dst.f42476c = src.f42476c;
            dst.f42477d = src.f42477d;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("id");
        fieldNames.add("integer");
        f42473b = Collections.unmodifiableList(fieldNames);
    }

    C14010Q() {
        this.f42475d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42475d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42474c = (C14011a) context.mo43700c();
            this.f42475d = new C13986D<>(this);
            this.f42475d.mo43507a(context.mo43702e());
            this.f42475d.mo43513b(context.mo43703f());
            this.f42475d.mo43509a(context.mo43699b());
            this.f42475d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$id() {
        this.f42475d.mo43514c().mo43690d();
        return this.f42475d.mo43515d().mo23720m(this.f42474c.f42476c);
    }

    public void realmSet$id(String value) {
        if (!this.f42475d.mo43517f()) {
            this.f42475d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'id' cannot be changed after object was created.");
        }
    }

    public Integer realmGet$integer() {
        this.f42475d.mo43514c().mo43690d();
        if (this.f42475d.mo43515d().mo23511a(this.f42474c.f42477d)) {
            return null;
        }
        return Integer.valueOf((int) this.f42475d.mo43515d().mo23716h(this.f42474c.f42477d));
    }

    public void realmSet$integer(Integer value) {
        if (!this.f42475d.mo43517f()) {
            this.f42475d.mo43514c().mo43690d();
            if (value == null) {
                this.f42475d.mo43515d().mo23512b(this.f42474c.f42477d);
            } else {
                this.f42475d.mo43515d().mo23705b(this.f42474c.f42477d, (long) value.intValue());
            }
        } else if (this.f42475d.mo43510a()) {
            C7347r row = this.f42475d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42474c.f42477d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42474c.f42477d, row.getIndex(), (long) value.intValue(), true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44661e() {
        C7309a builder = new C7309a("RealmInteger");
        builder.mo23605a("id", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("integer", RealmFieldType.INTEGER, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44659c() {
        return f42472a;
    }

    /* renamed from: a */
    public static C14011a m44656a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmInteger";
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
            C14011a columnInfo = new C14011a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42476c) {
                String str2 = "id";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'id' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42476c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "integer";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'integer' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Integer' for field 'integer' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42477d)) {
                        return columnInfo;
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'integer' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'integer' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmInteger' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44660d() {
        return "class_RealmInteger";
    }

    /* renamed from: b */
    public static RealmInteger m44658b(C13990F realm, RealmInteger object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmInteger realmInteger = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmInteger instanceof C7344p) && ((C7344p) realmInteger).mo23791a().mo43514c() != null && ((C7344p) realmInteger).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmInteger instanceof C7344p) && ((C7344p) realmInteger).mo23791a().mo43514c() != null && ((C7344p) realmInteger).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmInteger;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmInteger);
            if (cachedRealmObject != null) {
                return (RealmInteger) cachedRealmObject;
            }
            RealmInteger realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmInteger.class);
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmInteger.class), false, Collections.emptyList());
                            realmObject = new C14010Q();
                            map.put(realmInteger, realmObject);
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
                return m44655a(realm, object, update, cache);
            }
            m44654a(f, realmObject, realmInteger, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmInteger m44655a(C13990F realm, RealmInteger newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmInteger) cachedRealmObject;
        }
        RealmInteger realmObject = (RealmInteger) realm.mo43528a(RealmInteger.class, newObject.realmGet$id(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        realmObject.realmSet$integer(newObject.realmGet$integer());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44652a(C13990F realm, RealmInteger object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        RealmInteger realmInteger = object;
        if ((realmInteger instanceof C7344p) && ((C7344p) realmInteger).mo23791a().mo43514c() != null && ((C7344p) realmInteger).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmInteger).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmInteger.class);
        long tableNativePtr = table.getNativePtr();
        C14011a columnInfo = (C14011a) f.f42569h.mo43710a(RealmInteger.class);
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
        cache.put(realmInteger, Long.valueOf(rowIndex2));
        Integer realmGet$integer = object.realmGet$integer();
        if (realmGet$integer != null) {
            long j = pkColumnIndex;
            Table.nativeSetLong(tableNativePtr, columnInfo.f42477d, rowIndex2, realmGet$integer.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42477d, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44657a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmInteger.class);
        long tableNativePtr = table.getNativePtr();
        C14011a columnInfo = (C14011a) f.f42569h.mo43710a(RealmInteger.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            RealmInteger object = (RealmInteger) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$id();
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex2);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex2, primaryKeyValue);
                }
                if (rowIndex == -1) {
                    rowIndex2 = OsObject.m15909a(table, (Object) primaryKeyValue);
                } else {
                    rowIndex2 = rowIndex;
                }
                map.put(object, Long.valueOf(rowIndex2));
                Integer realmGet$integer = object.realmGet$integer();
                if (realmGet$integer != null) {
                    pkColumnIndex = pkColumnIndex2;
                    String str = primaryKeyValue;
                    Table.nativeSetLong(tableNativePtr, columnInfo.f42477d, rowIndex2, realmGet$integer.longValue(), false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    String str2 = primaryKeyValue;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42477d, rowIndex2, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            RealmInteger realmInteger = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static RealmInteger m44653a(RealmInteger realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmInteger unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmInteger();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmInteger) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmInteger) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmInteger realmInteger = unmanagedObject;
        C14012S realmSource = realmObject;
        realmInteger.realmSet$id(realmSource.realmGet$id());
        realmInteger.realmSet$integer(realmSource.realmGet$integer());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmInteger m44654a(C13990F realm, RealmInteger realmObject, RealmInteger newObject, Map<C0105Y, C7344p> map) {
        realmObject.realmSet$integer(newObject.realmGet$integer());
        return realmObject;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            boolean r0 = p024io.realm.C0106Z.isValid(r4)
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = "Invalid object"
            return r0
        L_0x0009:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "RealmInteger = proxy["
            r0.<init>(r1)
            java.lang.String r1 = "{id:"
            r0.append(r1)
            java.lang.String r1 = r4.realmGet$id()
            java.lang.String r2 = "null"
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r4.realmGet$id()
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            r0.append(r1)
            java.lang.String r1 = "}"
            r0.append(r1)
            java.lang.String r3 = ","
            r0.append(r3)
            java.lang.String r3 = "{integer:"
            r0.append(r3)
            java.lang.Integer r3 = r4.realmGet$integer()
            if (r3 == 0) goto L_0x003f
            java.lang.Integer r2 = r4.realmGet$integer()
        L_0x003f:
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C14010Q.toString():java.lang.String");
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42475d;
    }

    public int hashCode() {
        String realmName = this.f42475d.mo43514c().mo43545j();
        String tableName = this.f42475d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42475d.mo43515d().getIndex();
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
        C14010Q aRealmInteger = (C14010Q) o;
        String path = this.f42475d.mo43514c().mo43545j();
        String otherPath = aRealmInteger.f42475d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42475d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmInteger.f42475d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42475d.mo43515d().getIndex() != aRealmInteger.f42475d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
