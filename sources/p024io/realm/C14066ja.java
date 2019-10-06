package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.Store;
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

/* renamed from: io.realm.ja */
/* compiled from: StoreRealmProxy */
public class C14066ja extends Store implements C7344p, C0108ka {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42618a = m44923e();

    /* renamed from: b */
    private static final List<String> f42619b;

    /* renamed from: c */
    private C14067a f42620c;

    /* renamed from: d */
    private C13986D<Store> f42621d;

    /* renamed from: io.realm.ja$a */
    /* compiled from: StoreRealmProxy */
    static final class C14067a extends C7327c {

        /* renamed from: c */
        long f42622c;

        /* renamed from: d */
        long f42623d;

        /* renamed from: e */
        long f42624e;

        /* renamed from: f */
        long f42625f;

        /* renamed from: g */
        long f42626g;

        /* renamed from: h */
        long f42627h;

        /* renamed from: i */
        long f42628i;

        C14067a(SharedRealm realm, Table table) {
            super(7);
            this.f42622c = mo23757a(table, Store.STORE_ID, RealmFieldType.INTEGER);
            this.f42623d = mo23757a(table, Store.ICON_PATH, RealmFieldType.STRING);
            this.f42624e = mo23757a(table, "theme", RealmFieldType.STRING);
            this.f42625f = mo23757a(table, "downloads", RealmFieldType.INTEGER);
            this.f42626g = mo23757a(table, "storeName", RealmFieldType.STRING);
            this.f42627h = mo23757a(table, "username", RealmFieldType.STRING);
            this.f42628i = mo23757a(table, Store.PASSWORD_SHA1, RealmFieldType.STRING);
        }

        C14067a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14067a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14067a src = (C14067a) rawSrc;
            C14067a dst = (C14067a) rawDst;
            dst.f42622c = src.f42622c;
            dst.f42623d = src.f42623d;
            dst.f42624e = src.f42624e;
            dst.f42625f = src.f42625f;
            dst.f42626g = src.f42626g;
            dst.f42627h = src.f42627h;
            dst.f42628i = src.f42628i;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add(Store.STORE_ID);
        fieldNames.add(Store.ICON_PATH);
        fieldNames.add("theme");
        fieldNames.add("downloads");
        fieldNames.add("storeName");
        fieldNames.add("username");
        fieldNames.add(Store.PASSWORD_SHA1);
        f42619b = Collections.unmodifiableList(fieldNames);
    }

    C14066ja() {
        this.f42621d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42621d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42620c = (C14067a) context.mo43700c();
            this.f42621d = new C13986D<>(this);
            this.f42621d.mo43507a(context.mo43702e());
            this.f42621d.mo43513b(context.mo43703f());
            this.f42621d.mo43509a(context.mo43699b());
            this.f42621d.mo43508a(context.mo43701d());
        }
    }

    public long realmGet$storeId() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23716h(this.f42620c.f42622c);
    }

    public void realmSet$storeId(long value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'storeId' cannot be changed after object was created.");
        }
    }

    public String realmGet$iconPath() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23720m(this.f42620c.f42623d);
    }

    public void realmSet$iconPath(String value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            if (value == null) {
                this.f42621d.mo43515d().mo23512b(this.f42620c.f42623d);
            } else {
                this.f42621d.mo43515d().setString(this.f42620c.f42623d, value);
            }
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42620c.f42623d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42620c.f42623d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$theme() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23720m(this.f42620c.f42624e);
    }

    public void realmSet$theme(String value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            if (value == null) {
                this.f42621d.mo43515d().mo23512b(this.f42620c.f42624e);
            } else {
                this.f42621d.mo43515d().setString(this.f42620c.f42624e, value);
            }
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42620c.f42624e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42620c.f42624e, row.getIndex(), value, true);
            }
        }
    }

    public long realmGet$downloads() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23716h(this.f42620c.f42625f);
    }

    public void realmSet$downloads(long value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            this.f42621d.mo43515d().mo23705b(this.f42620c.f42625f, value);
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            row.mo23711f().mo23649a(this.f42620c.f42625f, row.getIndex(), value, true);
        }
    }

    public String realmGet$storeName() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23720m(this.f42620c.f42626g);
    }

    public void realmSet$storeName(String value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            if (value == null) {
                this.f42621d.mo43515d().mo23512b(this.f42620c.f42626g);
            } else {
                this.f42621d.mo43515d().setString(this.f42620c.f42626g, value);
            }
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42620c.f42626g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42620c.f42626g, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$username() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23720m(this.f42620c.f42627h);
    }

    public void realmSet$username(String value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            if (value == null) {
                this.f42621d.mo43515d().mo23512b(this.f42620c.f42627h);
            } else {
                this.f42621d.mo43515d().setString(this.f42620c.f42627h, value);
            }
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42620c.f42627h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42620c.f42627h, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$passwordSha1() {
        this.f42621d.mo43514c().mo43690d();
        return this.f42621d.mo43515d().mo23720m(this.f42620c.f42628i);
    }

    public void realmSet$passwordSha1(String value) {
        if (!this.f42621d.mo43517f()) {
            this.f42621d.mo43514c().mo43690d();
            if (value == null) {
                this.f42621d.mo43515d().mo23512b(this.f42620c.f42628i);
            } else {
                this.f42621d.mo43515d().setString(this.f42620c.f42628i, value);
            }
        } else if (this.f42621d.mo43510a()) {
            C7347r row = this.f42621d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42620c.f42628i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42620c.f42628i, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44923e() {
        C7309a builder = new C7309a("Store");
        builder.mo23605a(Store.STORE_ID, RealmFieldType.INTEGER, true, true, true);
        C7309a aVar = builder;
        aVar.mo23605a(Store.ICON_PATH, RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("theme", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("downloads", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("storeName", RealmFieldType.STRING, false, true, false);
        aVar3.mo23605a("username", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(Store.PASSWORD_SHA1, RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44921c() {
        return f42618a;
    }

    /* renamed from: a */
    public static C14067a m44918a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Store";
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
            C14067a columnInfo = new C14067a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'storeId' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42622c) {
                String str2 = Store.STORE_ID;
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'storeId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.INTEGER) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'storeId' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42622c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'storeId' does support null values in the existing Realm file. Use corresponding boxed type for field 'storeId' or migrate using RealmObjectSchema.setNullable().");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = Store.ICON_PATH;
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'iconPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'iconPath' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42623d)) {
                        String str4 = "theme";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'theme' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'theme' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42624e)) {
                            String str5 = "downloads";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'downloads' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.INTEGER) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'downloads' in existing Realm file.");
                            } else if (!table.mo23678l(columnInfo.f42625f)) {
                                String str6 = "storeName";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'storeName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'storeName' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42626g)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'storeName' is required. Either set @Required to field 'storeName' or migrate using RealmObjectSchema.setNullable().");
                                } else if (table.mo23677k(table.mo23656b(str6))) {
                                    String str7 = "username";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'username' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'username' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42627h)) {
                                        String str8 = Store.PASSWORD_SHA1;
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'passwordSha1' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'passwordSha1' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42628i)) {
                                            return columnInfo;
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'passwordSha1' is required. Either set @Required to field 'passwordSha1' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'username' is required. Either set @Required to field 'username' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'storeName' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'downloads' does support null values in the existing Realm file. Use corresponding boxed type for field 'downloads' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'theme' is required. Either set @Required to field 'theme' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'iconPath' is required. Either set @Required to field 'iconPath' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'storeId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field storeId");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Store' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44922d() {
        return "class_Store";
    }

    /* renamed from: b */
    public static Store m44920b(C13990F realm, Store object, boolean update, Map<C0105Y, C7344p> cache) {
        C13990F f = realm;
        Store store = object;
        Map<C0105Y, C7344p> map = cache;
        if ((store instanceof C7344p) && ((C7344p) store).mo23791a().mo43514c() != null && ((C7344p) store).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((store instanceof C7344p) && ((C7344p) store).mo23791a().mo43514c() != null && ((C7344p) store).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return store;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(store);
            if (cachedRealmObject != null) {
                return (Store) cachedRealmObject;
            }
            Store realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Store.class);
                long pkColumnIndex = table.mo23666f();
                long rowIndex = table.mo23655b(pkColumnIndex, object.realmGet$storeId());
                if (rowIndex != -1) {
                    try {
                        long j = rowIndex;
                        long j2 = pkColumnIndex;
                        try {
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Store.class), false, Collections.emptyList());
                            realmObject = new C14066ja();
                            map.put(store, realmObject);
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
                return m44917a(realm, object, update, cache);
            }
            m44916a(f, realmObject, store, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Store m44917a(C13990F realm, Store newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Store) cachedRealmObject;
        }
        Store realmObject = (Store) realm.mo43528a(Store.class, Long.valueOf(newObject.realmGet$storeId()), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C0108ka realmObjectSource = newObject;
        Store store = realmObject;
        store.realmSet$iconPath(realmObjectSource.realmGet$iconPath());
        store.realmSet$theme(realmObjectSource.realmGet$theme());
        store.realmSet$downloads(realmObjectSource.realmGet$downloads());
        store.realmSet$storeName(realmObjectSource.realmGet$storeName());
        store.realmSet$username(realmObjectSource.realmGet$username());
        store.realmSet$passwordSha1(realmObjectSource.realmGet$passwordSha1());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44914a(C13990F realm, Store object, Map<C0105Y, Long> cache) {
        long rowIndex;
        C13990F f = realm;
        Store store = object;
        if ((store instanceof C7344p) && ((C7344p) store).mo23791a().mo43514c() != null && ((C7344p) store).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) store).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Store.class);
        long tableNativePtr = table.getNativePtr();
        C14067a columnInfo = (C14067a) f.f42569h.mo43710a(Store.class);
        long pkColumnIndex = table.mo23666f();
        long rowIndex2 = -1;
        if (Long.valueOf(object.realmGet$storeId()) != null) {
            rowIndex2 = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, object.realmGet$storeId());
        }
        if (rowIndex2 == -1) {
            rowIndex = OsObject.m15909a(table, (Object) Long.valueOf(object.realmGet$storeId()));
        } else {
            rowIndex = rowIndex2;
        }
        cache.put(store, Long.valueOf(rowIndex));
        String realmGet$iconPath = object.realmGet$iconPath();
        if (realmGet$iconPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42623d, rowIndex, realmGet$iconPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42623d, rowIndex, false);
        }
        String realmGet$theme = object.realmGet$theme();
        if (realmGet$theme != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42624e, rowIndex, realmGet$theme, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42624e, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42625f, rowIndex, object.realmGet$downloads(), false);
        String realmGet$storeName = object.realmGet$storeName();
        if (realmGet$storeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42626g, rowIndex, realmGet$storeName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42626g, rowIndex, false);
        }
        String realmGet$username = object.realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42627h, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42627h, rowIndex, false);
        }
        String realmGet$passwordSha1 = object.realmGet$passwordSha1();
        if (realmGet$passwordSha1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42628i, rowIndex, realmGet$passwordSha1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42628i, rowIndex, false);
        }
        return rowIndex;
    }

    /* renamed from: a */
    public static void m44919a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        Store object;
        long rowIndex;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Store.class);
        long tableNativePtr = table.getNativePtr();
        C14067a columnInfo = (C14067a) f.f42569h.mo43710a(Store.class);
        long pkColumnIndex = table.mo23666f();
        while (objects.hasNext()) {
            Store object2 = (Store) objects.next();
            if (map.containsKey(object2)) {
                object = object2;
            } else if (!(object2 instanceof C7344p) || ((C7344p) object2).mo23791a().mo43514c() == null || !((C7344p) object2).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                long rowIndex2 = -1;
                if (Long.valueOf(object2.realmGet$storeId()) != null) {
                    rowIndex2 = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, object2.realmGet$storeId());
                }
                if (rowIndex2 == -1) {
                    rowIndex = OsObject.m15909a(table, (Object) Long.valueOf(object2.realmGet$storeId()));
                } else {
                    rowIndex = rowIndex2;
                }
                map.put(object2, Long.valueOf(rowIndex));
                String realmGet$iconPath = object2.realmGet$iconPath();
                if (realmGet$iconPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42623d, rowIndex, realmGet$iconPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42623d, rowIndex, false);
                }
                String realmGet$theme = object2.realmGet$theme();
                if (realmGet$theme != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42624e, rowIndex, realmGet$theme, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42624e, rowIndex, false);
                }
                object = object2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42625f, rowIndex, object2.realmGet$downloads(), false);
                String realmGet$storeName = object.realmGet$storeName();
                if (realmGet$storeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42626g, rowIndex, realmGet$storeName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42626g, rowIndex, false);
                }
                String realmGet$username = object.realmGet$username();
                if (realmGet$username != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42627h, rowIndex, realmGet$username, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42627h, rowIndex, false);
                }
                String realmGet$passwordSha1 = object.realmGet$passwordSha1();
                if (realmGet$passwordSha1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42628i, rowIndex, realmGet$passwordSha1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42628i, rowIndex, false);
                }
            } else {
                map.put(object2, Long.valueOf(((C7344p) object2).mo23791a().mo43515d().getIndex()));
                object = object2;
            }
            Store store = object;
        }
    }

    /* renamed from: a */
    public static Store m44915a(Store realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Store unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Store();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Store) cachedObject.f14332b;
        } else {
            unmanagedObject = (Store) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Store store = unmanagedObject;
        C0108ka realmSource = realmObject;
        store.realmSet$storeId(realmSource.realmGet$storeId());
        store.realmSet$iconPath(realmSource.realmGet$iconPath());
        store.realmSet$theme(realmSource.realmGet$theme());
        store.realmSet$downloads(realmSource.realmGet$downloads());
        store.realmSet$storeName(realmSource.realmGet$storeName());
        store.realmSet$username(realmSource.realmGet$username());
        store.realmSet$passwordSha1(realmSource.realmGet$passwordSha1());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Store m44916a(C13990F realm, Store realmObject, Store newObject, Map<C0105Y, C7344p> map) {
        Store store = realmObject;
        C0108ka realmObjectSource = newObject;
        store.realmSet$iconPath(realmObjectSource.realmGet$iconPath());
        store.realmSet$theme(realmObjectSource.realmGet$theme());
        store.realmSet$downloads(realmObjectSource.realmGet$downloads());
        store.realmSet$storeName(realmObjectSource.realmGet$storeName());
        store.realmSet$username(realmObjectSource.realmGet$username());
        store.realmSet$passwordSha1(realmObjectSource.realmGet$passwordSha1());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Store = proxy[");
        stringBuilder.append("{storeId:");
        stringBuilder.append(realmGet$storeId());
        String str = "}";
        stringBuilder.append(str);
        String str2 = ",";
        stringBuilder.append(str2);
        stringBuilder.append("{iconPath:");
        String str3 = "null";
        stringBuilder.append(realmGet$iconPath() != null ? realmGet$iconPath() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{theme:");
        stringBuilder.append(realmGet$theme() != null ? realmGet$theme() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{downloads:");
        stringBuilder.append(realmGet$downloads());
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{storeName:");
        stringBuilder.append(realmGet$storeName() != null ? realmGet$storeName() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : str3);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("{passwordSha1:");
        if (realmGet$passwordSha1() != null) {
            str3 = realmGet$passwordSha1();
        }
        stringBuilder.append(str3);
        stringBuilder.append(str);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42621d;
    }

    public int hashCode() {
        String realmName = this.f42621d.mo43514c().mo43545j();
        String tableName = this.f42621d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42621d.mo43515d().getIndex();
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
        C14066ja aStore = (C14066ja) o;
        String path = this.f42621d.mo43514c().mo43545j();
        String otherPath = aStore.f42621d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42621d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aStore.f42621d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42621d.mo43515d().getIndex() != aStore.f42621d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
