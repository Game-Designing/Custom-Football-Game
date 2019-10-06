package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
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

/* renamed from: io.realm.la */
/* compiled from: StoredMinimalAdRealmProxy */
public class C14071la extends StoredMinimalAd implements C7344p, C14074ma {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42634a = m44951e();

    /* renamed from: b */
    private static final List<String> f42635b;

    /* renamed from: c */
    private C14072a f42636c;

    /* renamed from: d */
    private C13986D<StoredMinimalAd> f42637d;

    /* renamed from: io.realm.la$a */
    /* compiled from: StoredMinimalAdRealmProxy */
    static final class C14072a extends C7327c {

        /* renamed from: c */
        long f42638c;

        /* renamed from: d */
        long f42639d;

        /* renamed from: e */
        long f42640e;

        /* renamed from: f */
        long f42641f;

        /* renamed from: g */
        long f42642g;

        /* renamed from: h */
        long f42643h;

        /* renamed from: i */
        long f42644i;

        C14072a(SharedRealm realm, Table table) {
            super(7);
            this.f42638c = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42639d = mo23757a(table, StoredMinimalAd.REFERRER, RealmFieldType.STRING);
            this.f42640e = mo23757a(table, "cpcUrl", RealmFieldType.STRING);
            this.f42641f = mo23757a(table, "cpdUrl", RealmFieldType.STRING);
            this.f42642g = mo23757a(table, StoredMinimalAd.CPI_URL, RealmFieldType.STRING);
            this.f42643h = mo23757a(table, "timestamp", RealmFieldType.INTEGER);
            this.f42644i = mo23757a(table, "adId", RealmFieldType.INTEGER);
        }

        C14072a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14072a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14072a src = (C14072a) rawSrc;
            C14072a dst = (C14072a) rawDst;
            dst.f42638c = src.f42638c;
            dst.f42639d = src.f42639d;
            dst.f42640e = src.f42640e;
            dst.f42641f = src.f42641f;
            dst.f42642g = src.f42642g;
            dst.f42643h = src.f42643h;
            dst.f42644i = src.f42644i;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("packageName");
        fieldNames.add(StoredMinimalAd.REFERRER);
        fieldNames.add("cpcUrl");
        fieldNames.add("cpdUrl");
        fieldNames.add(StoredMinimalAd.CPI_URL);
        fieldNames.add("timestamp");
        fieldNames.add("adId");
        f42635b = Collections.unmodifiableList(fieldNames);
    }

    C14071la() {
        this.f42637d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42637d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42636c = (C14072a) context.mo43700c();
            this.f42637d = new C13986D<>(this);
            this.f42637d.mo43507a(context.mo43702e());
            this.f42637d.mo43513b(context.mo43703f());
            this.f42637d.mo43509a(context.mo43699b());
            this.f42637d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$packageName() {
        this.f42637d.mo43514c().mo43690d();
        return this.f42637d.mo43515d().mo23720m(this.f42636c.f42638c);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'packageName' cannot be changed after object was created.");
        }
    }

    public String realmGet$referrer() {
        this.f42637d.mo43514c().mo43690d();
        return this.f42637d.mo43515d().mo23720m(this.f42636c.f42639d);
    }

    public void realmSet$referrer(String value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42639d);
            } else {
                this.f42637d.mo43515d().setString(this.f42636c.f42639d, value);
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42639d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42636c.f42639d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$cpcUrl() {
        this.f42637d.mo43514c().mo43690d();
        return this.f42637d.mo43515d().mo23720m(this.f42636c.f42640e);
    }

    public void realmSet$cpcUrl(String value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42640e);
            } else {
                this.f42637d.mo43515d().setString(this.f42636c.f42640e, value);
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42640e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42636c.f42640e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$cpdUrl() {
        this.f42637d.mo43514c().mo43690d();
        return this.f42637d.mo43515d().mo23720m(this.f42636c.f42641f);
    }

    public void realmSet$cpdUrl(String value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42641f);
            } else {
                this.f42637d.mo43515d().setString(this.f42636c.f42641f, value);
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42641f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42636c.f42641f, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$cpiUrl() {
        this.f42637d.mo43514c().mo43690d();
        return this.f42637d.mo43515d().mo23720m(this.f42636c.f42642g);
    }

    public void realmSet$cpiUrl(String value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42642g);
            } else {
                this.f42637d.mo43515d().setString(this.f42636c.f42642g, value);
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42642g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42636c.f42642g, row.getIndex(), value, true);
            }
        }
    }

    public Long realmGet$timestamp() {
        this.f42637d.mo43514c().mo43690d();
        if (this.f42637d.mo43515d().mo23511a(this.f42636c.f42643h)) {
            return null;
        }
        return Long.valueOf(this.f42637d.mo43515d().mo23716h(this.f42636c.f42643h));
    }

    public void realmSet$timestamp(Long value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42643h);
            } else {
                this.f42637d.mo43515d().mo23705b(this.f42636c.f42643h, value.longValue());
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42643h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42636c.f42643h, row.getIndex(), value.longValue(), true);
            }
        }
    }

    public Long realmGet$adId() {
        this.f42637d.mo43514c().mo43690d();
        if (this.f42637d.mo43515d().mo23511a(this.f42636c.f42644i)) {
            return null;
        }
        return Long.valueOf(this.f42637d.mo43515d().mo23716h(this.f42636c.f42644i));
    }

    public void realmSet$adId(Long value) {
        if (!this.f42637d.mo43517f()) {
            this.f42637d.mo43514c().mo43690d();
            if (value == null) {
                this.f42637d.mo43515d().mo23512b(this.f42636c.f42644i);
            } else {
                this.f42637d.mo43515d().mo23705b(this.f42636c.f42644i, value.longValue());
            }
        } else if (this.f42637d.mo43510a()) {
            C7347r row = this.f42637d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42636c.f42644i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42636c.f42644i, row.getIndex(), value.longValue(), true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44951e() {
        C7309a builder = new C7309a("StoredMinimalAd");
        builder.mo23605a("packageName", RealmFieldType.STRING, true, true, true);
        C7309a aVar = builder;
        aVar.mo23605a(StoredMinimalAd.REFERRER, RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("cpcUrl", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("cpdUrl", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(StoredMinimalAd.CPI_URL, RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("timestamp", RealmFieldType.INTEGER, false, false, false);
        aVar2.mo23605a("adId", RealmFieldType.INTEGER, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44949c() {
        return f42634a;
    }

    /* renamed from: a */
    public static C14072a m44946a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_StoredMinimalAd";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 7) {
                if (columnCount < 7) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 7 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 7 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 7 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14072a columnInfo = new C14072a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'packageName' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42638c) {
                String str2 = "packageName";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42638c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' does support null values in the existing Realm file. Remove @Required or @PrimaryKey from field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = StoredMinimalAd.REFERRER;
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'referrer' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'referrer' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42639d)) {
                        String str4 = "cpcUrl";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpcUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpcUrl' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42640e)) {
                            String str5 = "cpdUrl";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpdUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpdUrl' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42641f)) {
                                String str6 = StoredMinimalAd.CPI_URL;
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpiUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpiUrl' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42642g)) {
                                    String str7 = "timestamp";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'timestamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.INTEGER) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'timestamp' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42643h)) {
                                        String str8 = "adId";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'adId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.INTEGER) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'adId' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42644i)) {
                                            return columnInfo;
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'adId' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'adId' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'timestamp' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'timestamp' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpiUrl' is required. Either set @Required to field 'cpiUrl' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpdUrl' is required. Either set @Required to field 'cpdUrl' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpcUrl' is required. Either set @Required to field 'cpcUrl' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'referrer' is required. Either set @Required to field 'referrer' or migrate using RealmObjectSchema.setNullable().");
                    }
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
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'StoredMinimalAd' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44950d() {
        return "class_StoredMinimalAd";
    }

    /* renamed from: b */
    public static StoredMinimalAd m44948b(C13990F realm, StoredMinimalAd object, boolean update, Map<C0105Y, C7344p> cache) {
        C13990F f = realm;
        StoredMinimalAd storedMinimalAd = object;
        Map<C0105Y, C7344p> map = cache;
        if ((storedMinimalAd instanceof C7344p) && ((C7344p) storedMinimalAd).mo23791a().mo43514c() != null && ((C7344p) storedMinimalAd).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((storedMinimalAd instanceof C7344p) && ((C7344p) storedMinimalAd).mo23791a().mo43514c() != null && ((C7344p) storedMinimalAd).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return storedMinimalAd;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(storedMinimalAd);
            if (cachedRealmObject != null) {
                return (StoredMinimalAd) cachedRealmObject;
            }
            StoredMinimalAd realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(StoredMinimalAd.class);
                long pkColumnIndex = table.mo23666f();
                long rowIndex = table.mo23641a(pkColumnIndex, object.realmGet$packageName());
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(StoredMinimalAd.class), false, Collections.emptyList());
                            realmObject = new C14071la();
                            map.put(storedMinimalAd, realmObject);
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
                return m44945a(realm, object, update, cache);
            }
            m44944a(f, realmObject, storedMinimalAd, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static StoredMinimalAd m44945a(C13990F realm, StoredMinimalAd newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (StoredMinimalAd) cachedRealmObject;
        }
        StoredMinimalAd realmObject = (StoredMinimalAd) realm.mo43528a(StoredMinimalAd.class, newObject.realmGet$packageName(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14074ma realmObjectSource = newObject;
        StoredMinimalAd storedMinimalAd = realmObject;
        storedMinimalAd.realmSet$referrer(realmObjectSource.realmGet$referrer());
        storedMinimalAd.realmSet$cpcUrl(realmObjectSource.realmGet$cpcUrl());
        storedMinimalAd.realmSet$cpdUrl(realmObjectSource.realmGet$cpdUrl());
        storedMinimalAd.realmSet$cpiUrl(realmObjectSource.realmGet$cpiUrl());
        storedMinimalAd.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        storedMinimalAd.realmSet$adId(realmObjectSource.realmGet$adId());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44942a(C13990F realm, StoredMinimalAd object, Map<C0105Y, Long> cache) {
        long rowIndex;
        C13990F f = realm;
        StoredMinimalAd storedMinimalAd = object;
        if ((storedMinimalAd instanceof C7344p) && ((C7344p) storedMinimalAd).mo23791a().mo43514c() != null && ((C7344p) storedMinimalAd).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) storedMinimalAd).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(StoredMinimalAd.class);
        long tableNativePtr = table.getNativePtr();
        C14072a columnInfo = (C14072a) f.f42569h.mo43710a(StoredMinimalAd.class);
        long pkColumnIndex = table.mo23666f();
        long rowIndex2 = -1;
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            rowIndex2 = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, realmGet$packageName);
        }
        if (rowIndex2 == -1) {
            rowIndex = OsObject.m15909a(table, (Object) realmGet$packageName);
        } else {
            rowIndex = rowIndex2;
        }
        cache.put(storedMinimalAd, Long.valueOf(rowIndex));
        String realmGet$referrer = object.realmGet$referrer();
        if (realmGet$referrer != null) {
            long j = pkColumnIndex;
            Table.nativeSetString(tableNativePtr, columnInfo.f42639d, rowIndex, realmGet$referrer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42639d, rowIndex, false);
        }
        String realmGet$cpcUrl = object.realmGet$cpcUrl();
        if (realmGet$cpcUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42640e, rowIndex, realmGet$cpcUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42640e, rowIndex, false);
        }
        String realmGet$cpdUrl = object.realmGet$cpdUrl();
        if (realmGet$cpdUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42641f, rowIndex, realmGet$cpdUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42641f, rowIndex, false);
        }
        String realmGet$cpiUrl = object.realmGet$cpiUrl();
        if (realmGet$cpiUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42642g, rowIndex, realmGet$cpiUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42642g, rowIndex, false);
        }
        Long realmGet$timestamp = object.realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42643h, rowIndex, realmGet$timestamp.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42643h, rowIndex, false);
        }
        Long realmGet$adId = object.realmGet$adId();
        if (realmGet$adId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42644i, rowIndex, realmGet$adId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42644i, rowIndex, false);
        }
        return rowIndex;
    }

    /* renamed from: a */
    public static void m44947a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(StoredMinimalAd.class);
        long tableNativePtr = table.getNativePtr();
        C14072a columnInfo = (C14072a) f.f42569h.mo43710a(StoredMinimalAd.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            StoredMinimalAd object = (StoredMinimalAd) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                long rowIndex2 = -1;
                String realmGet$packageName = object.realmGet$packageName();
                if (realmGet$packageName != null) {
                    rowIndex2 = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex2, realmGet$packageName);
                }
                if (rowIndex2 == -1) {
                    rowIndex = OsObject.m15909a(table, (Object) realmGet$packageName);
                } else {
                    rowIndex = rowIndex2;
                }
                map.put(object, Long.valueOf(rowIndex));
                String realmGet$referrer = object.realmGet$referrer();
                if (realmGet$referrer != null) {
                    String str = realmGet$packageName;
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetString(tableNativePtr, columnInfo.f42639d, rowIndex, realmGet$referrer, false);
                } else {
                    String str2 = realmGet$packageName;
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42639d, rowIndex, false);
                }
                String realmGet$cpcUrl = object.realmGet$cpcUrl();
                if (realmGet$cpcUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42640e, rowIndex, realmGet$cpcUrl, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42640e, rowIndex, false);
                }
                String realmGet$cpdUrl = object.realmGet$cpdUrl();
                if (realmGet$cpdUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42641f, rowIndex, realmGet$cpdUrl, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42641f, rowIndex, false);
                }
                String realmGet$cpiUrl = object.realmGet$cpiUrl();
                if (realmGet$cpiUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42642g, rowIndex, realmGet$cpiUrl, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42642g, rowIndex, false);
                }
                Long realmGet$timestamp = object.realmGet$timestamp();
                if (realmGet$timestamp != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.f42643h, rowIndex, realmGet$timestamp.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42643h, rowIndex, false);
                }
                Long realmGet$adId = object.realmGet$adId();
                if (realmGet$adId != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.f42644i, rowIndex, realmGet$adId.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42644i, rowIndex, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            StoredMinimalAd storedMinimalAd = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static StoredMinimalAd m44943a(StoredMinimalAd realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        StoredMinimalAd unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new StoredMinimalAd();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (StoredMinimalAd) cachedObject.f14332b;
        } else {
            unmanagedObject = (StoredMinimalAd) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        StoredMinimalAd storedMinimalAd = unmanagedObject;
        C14074ma realmSource = realmObject;
        storedMinimalAd.realmSet$packageName(realmSource.realmGet$packageName());
        storedMinimalAd.realmSet$referrer(realmSource.realmGet$referrer());
        storedMinimalAd.realmSet$cpcUrl(realmSource.realmGet$cpcUrl());
        storedMinimalAd.realmSet$cpdUrl(realmSource.realmGet$cpdUrl());
        storedMinimalAd.realmSet$cpiUrl(realmSource.realmGet$cpiUrl());
        storedMinimalAd.realmSet$timestamp(realmSource.realmGet$timestamp());
        storedMinimalAd.realmSet$adId(realmSource.realmGet$adId());
        return unmanagedObject;
    }

    /* renamed from: a */
    static StoredMinimalAd m44944a(C13990F realm, StoredMinimalAd realmObject, StoredMinimalAd newObject, Map<C0105Y, C7344p> map) {
        StoredMinimalAd storedMinimalAd = realmObject;
        C14074ma realmObjectSource = newObject;
        storedMinimalAd.realmSet$referrer(realmObjectSource.realmGet$referrer());
        storedMinimalAd.realmSet$cpcUrl(realmObjectSource.realmGet$cpcUrl());
        storedMinimalAd.realmSet$cpdUrl(realmObjectSource.realmGet$cpdUrl());
        storedMinimalAd.realmSet$cpiUrl(realmObjectSource.realmGet$cpiUrl());
        storedMinimalAd.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        storedMinimalAd.realmSet$adId(realmObjectSource.realmGet$adId());
        return realmObject;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            boolean r0 = p024io.realm.C0106Z.isValid(r5)
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = "Invalid object"
            return r0
        L_0x0009:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "StoredMinimalAd = proxy["
            r0.<init>(r1)
            java.lang.String r1 = "{packageName:"
            r0.append(r1)
            java.lang.String r1 = r5.realmGet$packageName()
            r0.append(r1)
            java.lang.String r1 = "}"
            r0.append(r1)
            java.lang.String r2 = ","
            r0.append(r2)
            java.lang.String r3 = "{referrer:"
            r0.append(r3)
            java.lang.String r3 = r5.realmGet$referrer()
            java.lang.String r4 = "null"
            if (r3 == 0) goto L_0x0038
            java.lang.String r3 = r5.realmGet$referrer()
            goto L_0x0039
        L_0x0038:
            r3 = r4
        L_0x0039:
            r0.append(r3)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r3 = "{cpcUrl:"
            r0.append(r3)
            java.lang.String r3 = r5.realmGet$cpcUrl()
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = r5.realmGet$cpcUrl()
            goto L_0x0053
        L_0x0052:
            r3 = r4
        L_0x0053:
            r0.append(r3)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r3 = "{cpdUrl:"
            r0.append(r3)
            java.lang.String r3 = r5.realmGet$cpdUrl()
            if (r3 == 0) goto L_0x006c
            java.lang.String r3 = r5.realmGet$cpdUrl()
            goto L_0x006d
        L_0x006c:
            r3 = r4
        L_0x006d:
            r0.append(r3)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r3 = "{cpiUrl:"
            r0.append(r3)
            java.lang.String r3 = r5.realmGet$cpiUrl()
            if (r3 == 0) goto L_0x0086
            java.lang.String r3 = r5.realmGet$cpiUrl()
            goto L_0x0087
        L_0x0086:
            r3 = r4
        L_0x0087:
            r0.append(r3)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r3 = "{timestamp:"
            r0.append(r3)
            java.lang.Long r3 = r5.realmGet$timestamp()
            if (r3 == 0) goto L_0x00a0
            java.lang.Long r3 = r5.realmGet$timestamp()
            goto L_0x00a1
        L_0x00a0:
            r3 = r4
        L_0x00a1:
            r0.append(r3)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r2 = "{adId:"
            r0.append(r2)
            java.lang.Long r2 = r5.realmGet$adId()
            if (r2 == 0) goto L_0x00b9
            java.lang.Long r4 = r5.realmGet$adId()
        L_0x00b9:
            r0.append(r4)
            r0.append(r1)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.C14071la.toString():java.lang.String");
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42637d;
    }

    public int hashCode() {
        String realmName = this.f42637d.mo43514c().mo43545j();
        String tableName = this.f42637d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42637d.mo43515d().getIndex();
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
        C14071la aStoredMinimalAd = (C14071la) o;
        String path = this.f42637d.mo43514c().mo43545j();
        String otherPath = aStoredMinimalAd.f42637d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42637d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aStoredMinimalAd.f42637d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42637d.mo43515d().getIndex() != aStoredMinimalAd.f42637d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
