package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmEvent;
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

/* renamed from: io.realm.M */
/* compiled from: RealmEventRealmProxy */
public class C14003M extends RealmEvent implements C7344p, C14006N {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42435a = m44620e();

    /* renamed from: b */
    private static final List<String> f42436b;

    /* renamed from: c */
    private C14004a f42437c;

    /* renamed from: d */
    private C13986D<RealmEvent> f42438d;

    /* renamed from: io.realm.M$a */
    /* compiled from: RealmEventRealmProxy */
    static final class C14004a extends C7327c {

        /* renamed from: c */
        long f42439c;

        /* renamed from: d */
        long f42440d;

        /* renamed from: e */
        long f42441e;

        /* renamed from: f */
        long f42442f;

        /* renamed from: g */
        long f42443g;

        C14004a(SharedRealm realm, Table table) {
            super(5);
            this.f42439c = mo23757a(table, "timestamp", RealmFieldType.INTEGER);
            this.f42440d = mo23757a(table, "eventName", RealmFieldType.STRING);
            this.f42441e = mo23757a(table, "action", RealmFieldType.INTEGER);
            this.f42442f = mo23757a(table, "context", RealmFieldType.STRING);
            this.f42443g = mo23757a(table, "data", RealmFieldType.STRING);
        }

        C14004a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14004a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14004a src = (C14004a) rawSrc;
            C14004a dst = (C14004a) rawDst;
            dst.f42439c = src.f42439c;
            dst.f42440d = src.f42440d;
            dst.f42441e = src.f42441e;
            dst.f42442f = src.f42442f;
            dst.f42443g = src.f42443g;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("timestamp");
        fieldNames.add("eventName");
        fieldNames.add("action");
        fieldNames.add("context");
        fieldNames.add("data");
        f42436b = Collections.unmodifiableList(fieldNames);
    }

    C14003M() {
        this.f42438d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42438d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42437c = (C14004a) context.mo43700c();
            this.f42438d = new C13986D<>(this);
            this.f42438d.mo43507a(context.mo43702e());
            this.f42438d.mo43513b(context.mo43703f());
            this.f42438d.mo43509a(context.mo43699b());
            this.f42438d.mo43508a(context.mo43701d());
        }
    }

    public long realmGet$timestamp() {
        this.f42438d.mo43514c().mo43690d();
        return this.f42438d.mo43515d().mo23716h(this.f42437c.f42439c);
    }

    public void realmSet$timestamp(long value) {
        if (!this.f42438d.mo43517f()) {
            this.f42438d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'timestamp' cannot be changed after object was created.");
        }
    }

    public String realmGet$eventName() {
        this.f42438d.mo43514c().mo43690d();
        return this.f42438d.mo43515d().mo23720m(this.f42437c.f42440d);
    }

    public void realmSet$eventName(String value) {
        if (!this.f42438d.mo43517f()) {
            this.f42438d.mo43514c().mo43690d();
            if (value == null) {
                this.f42438d.mo43515d().mo23512b(this.f42437c.f42440d);
            } else {
                this.f42438d.mo43515d().setString(this.f42437c.f42440d, value);
            }
        } else if (this.f42438d.mo43510a()) {
            C7347r row = this.f42438d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42437c.f42440d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42437c.f42440d, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$action() {
        this.f42438d.mo43514c().mo43690d();
        return (int) this.f42438d.mo43515d().mo23716h(this.f42437c.f42441e);
    }

    public void realmSet$action(int value) {
        if (!this.f42438d.mo43517f()) {
            this.f42438d.mo43514c().mo43690d();
            this.f42438d.mo43515d().mo23705b(this.f42437c.f42441e, (long) value);
        } else if (this.f42438d.mo43510a()) {
            C7347r row = this.f42438d.mo43515d();
            row.mo23711f().mo23649a(this.f42437c.f42441e, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$context() {
        this.f42438d.mo43514c().mo43690d();
        return this.f42438d.mo43515d().mo23720m(this.f42437c.f42442f);
    }

    public void realmSet$context(String value) {
        if (!this.f42438d.mo43517f()) {
            this.f42438d.mo43514c().mo43690d();
            if (value == null) {
                this.f42438d.mo43515d().mo23512b(this.f42437c.f42442f);
            } else {
                this.f42438d.mo43515d().setString(this.f42437c.f42442f, value);
            }
        } else if (this.f42438d.mo43510a()) {
            C7347r row = this.f42438d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42437c.f42442f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42437c.f42442f, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$data() {
        this.f42438d.mo43514c().mo43690d();
        return this.f42438d.mo43515d().mo23720m(this.f42437c.f42443g);
    }

    public void realmSet$data(String value) {
        if (!this.f42438d.mo43517f()) {
            this.f42438d.mo43514c().mo43690d();
            if (value == null) {
                this.f42438d.mo43515d().mo23512b(this.f42437c.f42443g);
            } else {
                this.f42438d.mo43515d().setString(this.f42437c.f42443g, value);
            }
        } else if (this.f42438d.mo43510a()) {
            C7347r row = this.f42438d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42437c.f42443g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42437c.f42443g, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44620e() {
        C7309a builder = new C7309a("RealmEvent");
        builder.mo23605a("timestamp", RealmFieldType.INTEGER, true, true, true);
        C7309a aVar = builder;
        aVar.mo23605a("eventName", RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("action", RealmFieldType.INTEGER, false, false, true);
        C7309a aVar3 = builder;
        aVar3.mo23605a("context", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("data", RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44618c() {
        return f42435a;
    }

    /* renamed from: a */
    public static C14004a m44615a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmEvent";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 5 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 5 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 5 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14004a columnInfo = new C14004a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'timestamp' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42439c) {
                String str2 = "timestamp";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'timestamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.INTEGER) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'timestamp' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42439c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'timestamp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timestamp' or migrate using RealmObjectSchema.setNullable().");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "eventName";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'eventName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'eventName' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42440d)) {
                        String str4 = "action";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'action' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.INTEGER) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'action' in existing Realm file.");
                        } else if (!table.mo23678l(columnInfo.f42441e)) {
                            String str5 = "context";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'context' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'context' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42442f)) {
                                String str6 = "data";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'data' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'data' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42443g)) {
                                    return columnInfo;
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'data' is required. Either set @Required to field 'data' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'context' is required. Either set @Required to field 'context' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'action' does support null values in the existing Realm file. Use corresponding boxed type for field 'action' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'eventName' is required. Either set @Required to field 'eventName' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'timestamp' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field timestamp");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmEvent' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44619d() {
        return "class_RealmEvent";
    }

    /* renamed from: b */
    public static RealmEvent m44617b(C13990F realm, RealmEvent object, boolean update, Map<C0105Y, C7344p> cache) {
        C13990F f = realm;
        RealmEvent realmEvent = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmEvent instanceof C7344p) && ((C7344p) realmEvent).mo23791a().mo43514c() != null && ((C7344p) realmEvent).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmEvent instanceof C7344p) && ((C7344p) realmEvent).mo23791a().mo43514c() != null && ((C7344p) realmEvent).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmEvent;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmEvent);
            if (cachedRealmObject != null) {
                return (RealmEvent) cachedRealmObject;
            }
            RealmEvent realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmEvent.class);
                long pkColumnIndex = table.mo23666f();
                long rowIndex = table.mo23655b(pkColumnIndex, object.realmGet$timestamp());
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmEvent.class), false, Collections.emptyList());
                            realmObject = new C14003M();
                            map.put(realmEvent, realmObject);
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
                return m44614a(realm, object, update, cache);
            }
            m44613a(f, realmObject, realmEvent, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmEvent m44614a(C13990F realm, RealmEvent newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmEvent) cachedRealmObject;
        }
        RealmEvent realmObject = (RealmEvent) realm.mo43528a(RealmEvent.class, Long.valueOf(newObject.realmGet$timestamp()), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14006N realmObjectSource = newObject;
        RealmEvent realmEvent = realmObject;
        realmEvent.realmSet$eventName(realmObjectSource.realmGet$eventName());
        realmEvent.realmSet$action(realmObjectSource.realmGet$action());
        realmEvent.realmSet$context(realmObjectSource.realmGet$context());
        realmEvent.realmSet$data(realmObjectSource.realmGet$data());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44611a(C13990F realm, RealmEvent object, Map<C0105Y, Long> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmEvent realmEvent = object;
        if ((realmEvent instanceof C7344p) && ((C7344p) realmEvent).mo23791a().mo43514c() != null && ((C7344p) realmEvent).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmEvent).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmEvent.class);
        long tableNativePtr = table.getNativePtr();
        C14004a columnInfo = (C14004a) f.f42569h.mo43710a(RealmEvent.class);
        long pkColumnIndex = table.mo23666f();
        long rowIndex2 = -1;
        if (Long.valueOf(object.realmGet$timestamp()) != null) {
            rowIndex2 = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, object.realmGet$timestamp());
        }
        if (rowIndex2 == -1) {
            rowIndex = OsObject.m15909a(table, (Object) Long.valueOf(object.realmGet$timestamp()));
        } else {
            rowIndex = rowIndex2;
        }
        cache.put(realmEvent, Long.valueOf(rowIndex));
        String realmGet$eventName = object.realmGet$eventName();
        if (realmGet$eventName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42440d, rowIndex, realmGet$eventName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42440d, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42441e, rowIndex, (long) object.realmGet$action(), false);
        String realmGet$context = object.realmGet$context();
        if (realmGet$context != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42442f, rowIndex, realmGet$context, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42442f, rowIndex, false);
        }
        String realmGet$data = object.realmGet$data();
        if (realmGet$data != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42443g, rowIndex, realmGet$data, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42443g, rowIndex, false);
        }
        return rowIndex;
    }

    /* renamed from: a */
    public static void m44616a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        RealmEvent object;
        long rowIndex;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmEvent.class);
        long tableNativePtr = table.getNativePtr();
        C14004a columnInfo = (C14004a) f.f42569h.mo43710a(RealmEvent.class);
        long pkColumnIndex = table.mo23666f();
        while (objects.hasNext()) {
            RealmEvent object2 = (RealmEvent) objects.next();
            if (map.containsKey(object2)) {
                object = object2;
            } else if (!(object2 instanceof C7344p) || ((C7344p) object2).mo23791a().mo43514c() == null || !((C7344p) object2).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                long rowIndex2 = -1;
                if (Long.valueOf(object2.realmGet$timestamp()) != null) {
                    rowIndex2 = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, object2.realmGet$timestamp());
                }
                if (rowIndex2 == -1) {
                    rowIndex = OsObject.m15909a(table, (Object) Long.valueOf(object2.realmGet$timestamp()));
                } else {
                    rowIndex = rowIndex2;
                }
                map.put(object2, Long.valueOf(rowIndex));
                String realmGet$eventName = object2.realmGet$eventName();
                if (realmGet$eventName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42440d, rowIndex, realmGet$eventName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42440d, rowIndex, false);
                }
                object = object2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42441e, rowIndex, (long) object2.realmGet$action(), false);
                String realmGet$context = object.realmGet$context();
                if (realmGet$context != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42442f, rowIndex, realmGet$context, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42442f, rowIndex, false);
                }
                String realmGet$data = object.realmGet$data();
                if (realmGet$data != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42443g, rowIndex, realmGet$data, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42443g, rowIndex, false);
                }
            } else {
                map.put(object2, Long.valueOf(((C7344p) object2).mo23791a().mo43515d().getIndex()));
                object = object2;
            }
            RealmEvent realmEvent = object;
        }
    }

    /* renamed from: a */
    public static RealmEvent m44612a(RealmEvent realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmEvent unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmEvent();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmEvent) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmEvent) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmEvent realmEvent = unmanagedObject;
        C14006N realmSource = realmObject;
        realmEvent.realmSet$timestamp(realmSource.realmGet$timestamp());
        realmEvent.realmSet$eventName(realmSource.realmGet$eventName());
        realmEvent.realmSet$action(realmSource.realmGet$action());
        realmEvent.realmSet$context(realmSource.realmGet$context());
        realmEvent.realmSet$data(realmSource.realmGet$data());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmEvent m44613a(C13990F realm, RealmEvent realmObject, RealmEvent newObject, Map<C0105Y, C7344p> map) {
        RealmEvent realmEvent = realmObject;
        C14006N realmObjectSource = newObject;
        realmEvent.realmSet$eventName(realmObjectSource.realmGet$eventName());
        realmEvent.realmSet$action(realmObjectSource.realmGet$action());
        realmEvent.realmSet$context(realmObjectSource.realmGet$context());
        realmEvent.realmSet$data(realmObjectSource.realmGet$data());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmEvent = proxy[");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        String str = "}";
        stringBuilder.append(str);
        String str2 = ",";
        stringBuilder.append(str2);
        stringBuilder.append("{eventName:");
        String str3 = "null";
        stringBuilder.append(realmGet$eventName() != null ? realmGet$eventName() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{action:");
        stringBuilder.append(realmGet$action());
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{context:");
        stringBuilder.append(realmGet$context() != null ? realmGet$context() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{data:");
        if (realmGet$data() != null) {
            str3 = realmGet$data();
        }
        stringBuilder.append(str3);
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42438d;
    }

    public int hashCode() {
        String realmName = this.f42438d.mo43514c().mo43545j();
        String tableName = this.f42438d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42438d.mo43515d().getIndex();
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
        C14003M aRealmEvent = (C14003M) o;
        String path = this.f42438d.mo43514c().mo43545j();
        String otherPath = aRealmEvent.f42438d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42438d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmEvent.f42438d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42438d.mo43515d().getIndex() != aRealmEvent.f42438d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
