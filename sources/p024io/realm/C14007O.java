package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmExperiment;
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

/* renamed from: io.realm.O */
/* compiled from: RealmExperimentRealmProxy */
public class C14007O extends RealmExperiment implements C7344p, C14009P {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42462a = m44647e();

    /* renamed from: b */
    private static final List<String> f42463b;

    /* renamed from: c */
    private C14008a f42464c;

    /* renamed from: d */
    private C13986D<RealmExperiment> f42465d;

    /* renamed from: io.realm.O$a */
    /* compiled from: RealmExperimentRealmProxy */
    static final class C14008a extends C7327c {

        /* renamed from: c */
        long f42466c;

        /* renamed from: d */
        long f42467d;

        /* renamed from: e */
        long f42468e;

        /* renamed from: f */
        long f42469f;

        /* renamed from: g */
        long f42470g;

        /* renamed from: h */
        long f42471h;

        C14008a(SharedRealm realm, Table table) {
            super(6);
            this.f42466c = mo23757a(table, "experimentName", RealmFieldType.STRING);
            this.f42467d = mo23757a(table, "requestTime", RealmFieldType.INTEGER);
            this.f42468e = mo23757a(table, "assignment", RealmFieldType.STRING);
            this.f42469f = mo23757a(table, "payload", RealmFieldType.STRING);
            this.f42470g = mo23757a(table, "partOfExperiment", RealmFieldType.BOOLEAN);
            this.f42471h = mo23757a(table, "experimentOver", RealmFieldType.BOOLEAN);
        }

        C14008a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14008a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14008a src = (C14008a) rawSrc;
            C14008a dst = (C14008a) rawDst;
            dst.f42466c = src.f42466c;
            dst.f42467d = src.f42467d;
            dst.f42468e = src.f42468e;
            dst.f42469f = src.f42469f;
            dst.f42470g = src.f42470g;
            dst.f42471h = src.f42471h;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("experimentName");
        fieldNames.add("requestTime");
        fieldNames.add("assignment");
        fieldNames.add("payload");
        fieldNames.add("partOfExperiment");
        fieldNames.add("experimentOver");
        f42463b = Collections.unmodifiableList(fieldNames);
    }

    C14007O() {
        this.f42465d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42465d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42464c = (C14008a) context.mo43700c();
            this.f42465d = new C13986D<>(this);
            this.f42465d.mo43507a(context.mo43702e());
            this.f42465d.mo43513b(context.mo43703f());
            this.f42465d.mo43509a(context.mo43699b());
            this.f42465d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$experimentName() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23720m(this.f42464c.f42466c);
    }

    public void realmSet$experimentName(String value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'experimentName' cannot be changed after object was created.");
        }
    }

    public long realmGet$requestTime() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23716h(this.f42464c.f42467d);
    }

    public void realmSet$requestTime(long value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            this.f42465d.mo43515d().mo23705b(this.f42464c.f42467d, value);
        } else if (this.f42465d.mo43510a()) {
            C7347r row = this.f42465d.mo43515d();
            row.mo23711f().mo23649a(this.f42464c.f42467d, row.getIndex(), value, true);
        }
    }

    public String realmGet$assignment() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23720m(this.f42464c.f42468e);
    }

    public void realmSet$assignment(String value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            if (value == null) {
                this.f42465d.mo43515d().mo23512b(this.f42464c.f42468e);
            } else {
                this.f42465d.mo43515d().setString(this.f42464c.f42468e, value);
            }
        } else if (this.f42465d.mo43510a()) {
            C7347r row = this.f42465d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42464c.f42468e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42464c.f42468e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$payload() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23720m(this.f42464c.f42469f);
    }

    public void realmSet$payload(String value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            if (value == null) {
                this.f42465d.mo43515d().mo23512b(this.f42464c.f42469f);
            } else {
                this.f42465d.mo43515d().setString(this.f42464c.f42469f, value);
            }
        } else if (this.f42465d.mo43510a()) {
            C7347r row = this.f42465d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42464c.f42469f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42464c.f42469f, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$partOfExperiment() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23712g(this.f42464c.f42470g);
    }

    public void realmSet$partOfExperiment(boolean value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            this.f42465d.mo43515d().mo23703a(this.f42464c.f42470g, value);
        } else if (this.f42465d.mo43510a()) {
            C7347r row = this.f42465d.mo43515d();
            row.mo23711f().mo23653a(this.f42464c.f42470g, row.getIndex(), value, true);
        }
    }

    public boolean realmGet$experimentOver() {
        this.f42465d.mo43514c().mo43690d();
        return this.f42465d.mo43515d().mo23712g(this.f42464c.f42471h);
    }

    public void realmSet$experimentOver(boolean value) {
        if (!this.f42465d.mo43517f()) {
            this.f42465d.mo43514c().mo43690d();
            this.f42465d.mo43515d().mo23703a(this.f42464c.f42471h, value);
        } else if (this.f42465d.mo43510a()) {
            C7347r row = this.f42465d.mo43515d();
            row.mo23711f().mo23653a(this.f42464c.f42471h, row.getIndex(), value, true);
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44647e() {
        C7309a builder = new C7309a("RealmExperiment");
        builder.mo23605a("experimentName", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("requestTime", RealmFieldType.INTEGER, false, false, true);
        C7309a aVar2 = builder;
        aVar2.mo23605a("assignment", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("payload", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("partOfExperiment", RealmFieldType.BOOLEAN, false, false, true);
        aVar3.mo23605a("experimentOver", RealmFieldType.BOOLEAN, false, false, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44645c() {
        return f42462a;
    }

    /* renamed from: a */
    public static C14008a m44642a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmExperiment";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 6) {
                if (columnCount < 6) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 6 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 6 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 6 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14008a columnInfo = new C14008a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'experimentName' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42466c) {
                String str2 = "experimentName";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'experimentName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'experimentName' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42466c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'experimentName' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "requestTime";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'requestTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'requestTime' in existing Realm file.");
                    } else if (!table.mo23678l(columnInfo.f42467d)) {
                        String str4 = "assignment";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'assignment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'assignment' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42468e)) {
                            String str5 = "payload";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'payload' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'payload' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42469f)) {
                                String str6 = "partOfExperiment";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'partOfExperiment' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.BOOLEAN) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'partOfExperiment' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42470g)) {
                                    String str7 = "experimentOver";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'experimentOver' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.BOOLEAN) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'experimentOver' in existing Realm file.");
                                    } else if (!table.mo23678l(columnInfo.f42471h)) {
                                        return columnInfo;
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'experimentOver' does support null values in the existing Realm file. Use corresponding boxed type for field 'experimentOver' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'partOfExperiment' does support null values in the existing Realm file. Use corresponding boxed type for field 'partOfExperiment' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'payload' is required. Either set @Required to field 'payload' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'assignment' is required. Either set @Required to field 'assignment' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'requestTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'requestTime' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'experimentName' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field experimentName");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmExperiment' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44646d() {
        return "class_RealmExperiment";
    }

    /* renamed from: b */
    public static RealmExperiment m44644b(C13990F realm, RealmExperiment object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmExperiment realmExperiment = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmExperiment instanceof C7344p) && ((C7344p) realmExperiment).mo23791a().mo43514c() != null && ((C7344p) realmExperiment).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmExperiment instanceof C7344p) && ((C7344p) realmExperiment).mo23791a().mo43514c() != null && ((C7344p) realmExperiment).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmExperiment;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmExperiment);
            if (cachedRealmObject != null) {
                return (RealmExperiment) cachedRealmObject;
            }
            RealmExperiment realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmExperiment.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$experimentName();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmExperiment.class), false, Collections.emptyList());
                            realmObject = new C14007O();
                            map.put(realmExperiment, realmObject);
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
                return m44641a(realm, object, update, cache);
            }
            m44640a(f, realmObject, realmExperiment, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmExperiment m44641a(C13990F realm, RealmExperiment newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmExperiment) cachedRealmObject;
        }
        RealmExperiment realmObject = (RealmExperiment) realm.mo43528a(RealmExperiment.class, newObject.realmGet$experimentName(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14009P realmObjectSource = newObject;
        RealmExperiment realmExperiment = realmObject;
        realmExperiment.realmSet$requestTime(realmObjectSource.realmGet$requestTime());
        realmExperiment.realmSet$assignment(realmObjectSource.realmGet$assignment());
        realmExperiment.realmSet$payload(realmObjectSource.realmGet$payload());
        realmExperiment.realmSet$partOfExperiment(realmObjectSource.realmGet$partOfExperiment());
        realmExperiment.realmSet$experimentOver(realmObjectSource.realmGet$experimentOver());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44638a(C13990F realm, RealmExperiment object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        RealmExperiment realmExperiment = object;
        if ((realmExperiment instanceof C7344p) && ((C7344p) realmExperiment).mo23791a().mo43514c() != null && ((C7344p) realmExperiment).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmExperiment).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmExperiment.class);
        long tableNativePtr = table.getNativePtr();
        C14008a columnInfo = (C14008a) f.f42569h.mo43710a(RealmExperiment.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$experimentName();
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
        cache.put(realmExperiment, Long.valueOf(rowIndex2));
        long j = pkColumnIndex;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42467d, rowIndex2, object.realmGet$requestTime(), false);
        String realmGet$assignment = object.realmGet$assignment();
        if (realmGet$assignment != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42468e, rowIndex2, realmGet$assignment, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42468e, rowIndex2, false);
        }
        String realmGet$payload = object.realmGet$payload();
        if (realmGet$payload != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42469f, rowIndex2, realmGet$payload, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42469f, rowIndex2, false);
        }
        long j2 = tableNativePtr;
        long j3 = rowIndex2;
        Table.nativeSetBoolean(j2, columnInfo.f42470g, j3, object.realmGet$partOfExperiment(), false);
        Table.nativeSetBoolean(j2, columnInfo.f42471h, j3, object.realmGet$experimentOver(), false);
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44643a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmExperiment.class);
        long tableNativePtr = table.getNativePtr();
        C14008a columnInfo = (C14008a) f.f42569h.mo43710a(RealmExperiment.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            RealmExperiment object = (RealmExperiment) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$experimentName();
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
                pkColumnIndex = pkColumnIndex2;
                String str = primaryKeyValue;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42467d, rowIndex2, object.realmGet$requestTime(), false);
                String realmGet$assignment = object.realmGet$assignment();
                if (realmGet$assignment != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42468e, rowIndex2, realmGet$assignment, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42468e, rowIndex2, false);
                }
                String realmGet$payload = object.realmGet$payload();
                if (realmGet$payload != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42469f, rowIndex2, realmGet$payload, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42469f, rowIndex2, false);
                }
                long j = tableNativePtr;
                long j2 = rowIndex2;
                Table.nativeSetBoolean(j, columnInfo.f42470g, j2, object.realmGet$partOfExperiment(), false);
                Table.nativeSetBoolean(j, columnInfo.f42471h, j2, object.realmGet$experimentOver(), false);
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            RealmExperiment realmExperiment = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static RealmExperiment m44639a(RealmExperiment realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmExperiment unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmExperiment();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmExperiment) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmExperiment) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmExperiment realmExperiment = unmanagedObject;
        C14009P realmSource = realmObject;
        realmExperiment.realmSet$experimentName(realmSource.realmGet$experimentName());
        realmExperiment.realmSet$requestTime(realmSource.realmGet$requestTime());
        realmExperiment.realmSet$assignment(realmSource.realmGet$assignment());
        realmExperiment.realmSet$payload(realmSource.realmGet$payload());
        realmExperiment.realmSet$partOfExperiment(realmSource.realmGet$partOfExperiment());
        realmExperiment.realmSet$experimentOver(realmSource.realmGet$experimentOver());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmExperiment m44640a(C13990F realm, RealmExperiment realmObject, RealmExperiment newObject, Map<C0105Y, C7344p> map) {
        RealmExperiment realmExperiment = realmObject;
        C14009P realmObjectSource = newObject;
        realmExperiment.realmSet$requestTime(realmObjectSource.realmGet$requestTime());
        realmExperiment.realmSet$assignment(realmObjectSource.realmGet$assignment());
        realmExperiment.realmSet$payload(realmObjectSource.realmGet$payload());
        realmExperiment.realmSet$partOfExperiment(realmObjectSource.realmGet$partOfExperiment());
        realmExperiment.realmSet$experimentOver(realmObjectSource.realmGet$experimentOver());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmExperiment = proxy[");
        stringBuilder.append("{experimentName:");
        String str = "null";
        stringBuilder.append(realmGet$experimentName() != null ? realmGet$experimentName() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{requestTime:");
        stringBuilder.append(realmGet$requestTime());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{assignment:");
        stringBuilder.append(realmGet$assignment() != null ? realmGet$assignment() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{payload:");
        if (realmGet$payload() != null) {
            str = realmGet$payload();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{partOfExperiment:");
        stringBuilder.append(realmGet$partOfExperiment());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{experimentOver:");
        stringBuilder.append(realmGet$experimentOver());
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42465d;
    }

    public int hashCode() {
        String realmName = this.f42465d.mo43514c().mo43545j();
        String tableName = this.f42465d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42465d.mo43515d().getIndex();
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
        C14007O aRealmExperiment = (C14007O) o;
        String path = this.f42465d.mo43514c().mo43545j();
        String otherPath = aRealmExperiment.f42465d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42465d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmExperiment.f42465d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42465d.mo43515d().getIndex() != aRealmExperiment.f42465d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
