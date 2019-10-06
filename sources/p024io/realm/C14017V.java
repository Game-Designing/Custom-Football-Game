package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.RealmLocalNotificationSync;
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

/* renamed from: io.realm.V */
/* compiled from: RealmLocalNotificationSyncRealmProxy */
public class C14017V extends RealmLocalNotificationSync implements C7344p, C14019W {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42489a = m44691e();

    /* renamed from: b */
    private static final List<String> f42490b;

    /* renamed from: c */
    private C14018a f42491c;

    /* renamed from: d */
    private C13986D<RealmLocalNotificationSync> f42492d;

    /* renamed from: io.realm.V$a */
    /* compiled from: RealmLocalNotificationSyncRealmProxy */
    static final class C14018a extends C7327c {

        /* renamed from: c */
        long f42493c;

        /* renamed from: d */
        long f42494d;

        /* renamed from: e */
        long f42495e;

        /* renamed from: f */
        long f42496f;

        /* renamed from: g */
        long f42497g;

        /* renamed from: h */
        long f42498h;

        /* renamed from: i */
        long f42499i;

        C14018a(SharedRealm realm, Table table) {
            super(7);
            this.f42493c = mo23757a(table, "notificationId", RealmFieldType.STRING);
            this.f42494d = mo23757a(table, "title", RealmFieldType.STRING);
            this.f42495e = mo23757a(table, "body", RealmFieldType.STRING);
            this.f42496f = mo23757a(table, "image", RealmFieldType.STRING);
            this.f42497g = mo23757a(table, "navigationUrl", RealmFieldType.STRING);
            this.f42498h = mo23757a(table, "trigger", RealmFieldType.INTEGER);
            this.f42499i = mo23757a(table, "id", RealmFieldType.STRING);
        }

        C14018a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14018a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14018a src = (C14018a) rawSrc;
            C14018a dst = (C14018a) rawDst;
            dst.f42493c = src.f42493c;
            dst.f42494d = src.f42494d;
            dst.f42495e = src.f42495e;
            dst.f42496f = src.f42496f;
            dst.f42497g = src.f42497g;
            dst.f42498h = src.f42498h;
            dst.f42499i = src.f42499i;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("notificationId");
        fieldNames.add("title");
        fieldNames.add("body");
        fieldNames.add("image");
        fieldNames.add("navigationUrl");
        fieldNames.add("trigger");
        fieldNames.add("id");
        f42490b = Collections.unmodifiableList(fieldNames);
    }

    C14017V() {
        this.f42492d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42492d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42491c = (C14018a) context.mo43700c();
            this.f42492d = new C13986D<>(this);
            this.f42492d.mo43507a(context.mo43702e());
            this.f42492d.mo43513b(context.mo43703f());
            this.f42492d.mo43509a(context.mo43699b());
            this.f42492d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$notificationId() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42493c);
    }

    public void realmSet$notificationId(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'notificationId' cannot be changed after object was created.");
        }
    }

    public String realmGet$title() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42494d);
    }

    public void realmSet$title(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            if (value == null) {
                this.f42492d.mo43515d().mo23512b(this.f42491c.f42494d);
            } else {
                this.f42492d.mo43515d().setString(this.f42491c.f42494d, value);
            }
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42491c.f42494d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42491c.f42494d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$body() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42495e);
    }

    public void realmSet$body(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            if (value == null) {
                this.f42492d.mo43515d().mo23512b(this.f42491c.f42495e);
            } else {
                this.f42492d.mo43515d().setString(this.f42491c.f42495e, value);
            }
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42491c.f42495e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42491c.f42495e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$image() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42496f);
    }

    public void realmSet$image(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            if (value == null) {
                this.f42492d.mo43515d().mo23512b(this.f42491c.f42496f);
            } else {
                this.f42492d.mo43515d().setString(this.f42491c.f42496f, value);
            }
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42491c.f42496f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42491c.f42496f, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$navigationUrl() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42497g);
    }

    public void realmSet$navigationUrl(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            if (value == null) {
                this.f42492d.mo43515d().mo23512b(this.f42491c.f42497g);
            } else {
                this.f42492d.mo43515d().setString(this.f42491c.f42497g, value);
            }
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42491c.f42497g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42491c.f42497g, row.getIndex(), value, true);
            }
        }
    }

    public long realmGet$trigger() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23716h(this.f42491c.f42498h);
    }

    public void realmSet$trigger(long value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            this.f42492d.mo43515d().mo23705b(this.f42491c.f42498h, value);
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            row.mo23711f().mo23649a(this.f42491c.f42498h, row.getIndex(), value, true);
        }
    }

    public String realmGet$id() {
        this.f42492d.mo43514c().mo43690d();
        return this.f42492d.mo43515d().mo23720m(this.f42491c.f42499i);
    }

    public void realmSet$id(String value) {
        if (!this.f42492d.mo43517f()) {
            this.f42492d.mo43514c().mo43690d();
            if (value == null) {
                this.f42492d.mo43515d().mo23512b(this.f42491c.f42499i);
            } else {
                this.f42492d.mo43515d().setString(this.f42491c.f42499i, value);
            }
        } else if (this.f42492d.mo43510a()) {
            C7347r row = this.f42492d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42491c.f42499i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42491c.f42499i, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44691e() {
        C7309a builder = new C7309a("RealmLocalNotificationSync");
        builder.mo23605a("notificationId", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("title", RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("body", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("image", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("navigationUrl", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("trigger", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("id", RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44689c() {
        return f42489a;
    }

    /* renamed from: a */
    public static C14018a m44686a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_RealmLocalNotificationSync";
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
            C14018a columnInfo = new C14018a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'notificationId' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42493c) {
                String str2 = "notificationId";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'notificationId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'notificationId' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42493c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'notificationId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "title";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'title' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42494d)) {
                        String str4 = "body";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'body' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'body' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42495e)) {
                            String str5 = "image";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'image' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'image' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42496f)) {
                                String str6 = "navigationUrl";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'navigationUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'navigationUrl' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42497g)) {
                                    String str7 = "trigger";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'trigger' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.INTEGER) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'trigger' in existing Realm file.");
                                    } else if (!table.mo23678l(columnInfo.f42498h)) {
                                        String str8 = "id";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'id' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42499i)) {
                                            return columnInfo;
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'trigger' does support null values in the existing Realm file. Use corresponding boxed type for field 'trigger' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'navigationUrl' is required. Either set @Required to field 'navigationUrl' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'image' is required. Either set @Required to field 'image' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'body' is required. Either set @Required to field 'body' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'notificationId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field notificationId");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'RealmLocalNotificationSync' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44690d() {
        return "class_RealmLocalNotificationSync";
    }

    /* renamed from: b */
    public static RealmLocalNotificationSync m44688b(C13990F realm, RealmLocalNotificationSync object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        RealmLocalNotificationSync realmLocalNotificationSync = object;
        Map<C0105Y, C7344p> map = cache;
        if ((realmLocalNotificationSync instanceof C7344p) && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c() != null && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((realmLocalNotificationSync instanceof C7344p) && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c() != null && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return realmLocalNotificationSync;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(realmLocalNotificationSync);
            if (cachedRealmObject != null) {
                return (RealmLocalNotificationSync) cachedRealmObject;
            }
            RealmLocalNotificationSync realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(RealmLocalNotificationSync.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$notificationId();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(RealmLocalNotificationSync.class), false, Collections.emptyList());
                            realmObject = new C14017V();
                            map.put(realmLocalNotificationSync, realmObject);
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
                return m44685a(realm, object, update, cache);
            }
            m44684a(f, realmObject, realmLocalNotificationSync, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static RealmLocalNotificationSync m44685a(C13990F realm, RealmLocalNotificationSync newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (RealmLocalNotificationSync) cachedRealmObject;
        }
        RealmLocalNotificationSync realmObject = (RealmLocalNotificationSync) realm.mo43528a(RealmLocalNotificationSync.class, newObject.realmGet$notificationId(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14019W realmObjectSource = newObject;
        RealmLocalNotificationSync realmLocalNotificationSync = realmObject;
        realmLocalNotificationSync.realmSet$title(realmObjectSource.realmGet$title());
        realmLocalNotificationSync.realmSet$body(realmObjectSource.realmGet$body());
        realmLocalNotificationSync.realmSet$image(realmObjectSource.realmGet$image());
        realmLocalNotificationSync.realmSet$navigationUrl(realmObjectSource.realmGet$navigationUrl());
        realmLocalNotificationSync.realmSet$trigger(realmObjectSource.realmGet$trigger());
        realmLocalNotificationSync.realmSet$id(realmObjectSource.realmGet$id());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44682a(C13990F realm, RealmLocalNotificationSync object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        RealmLocalNotificationSync realmLocalNotificationSync = object;
        if ((realmLocalNotificationSync instanceof C7344p) && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c() != null && ((C7344p) realmLocalNotificationSync).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) realmLocalNotificationSync).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(RealmLocalNotificationSync.class);
        long tableNativePtr = table.getNativePtr();
        C14018a columnInfo = (C14018a) f.f42569h.mo43710a(RealmLocalNotificationSync.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$notificationId();
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
        cache.put(realmLocalNotificationSync, Long.valueOf(rowIndex2));
        String realmGet$title = object.realmGet$title();
        if (realmGet$title != null) {
            long j = pkColumnIndex;
            Table.nativeSetString(tableNativePtr, columnInfo.f42494d, rowIndex2, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42494d, rowIndex2, false);
        }
        String realmGet$body = object.realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42495e, rowIndex2, realmGet$body, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42495e, rowIndex2, false);
        }
        String realmGet$image = object.realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42496f, rowIndex2, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42496f, rowIndex2, false);
        }
        String realmGet$navigationUrl = object.realmGet$navigationUrl();
        if (realmGet$navigationUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42497g, rowIndex2, realmGet$navigationUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42497g, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42498h, rowIndex2, object.realmGet$trigger(), false);
        String realmGet$id = object.realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42499i, rowIndex2, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42499i, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44687a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(RealmLocalNotificationSync.class);
        long tableNativePtr = table.getNativePtr();
        C14018a columnInfo = (C14018a) f.f42569h.mo43710a(RealmLocalNotificationSync.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            RealmLocalNotificationSync object = (RealmLocalNotificationSync) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$notificationId();
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
                String realmGet$title = object.realmGet$title();
                if (realmGet$title != null) {
                    String str = primaryKeyValue;
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetString(tableNativePtr, columnInfo.f42494d, rowIndex2, realmGet$title, false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42494d, rowIndex2, false);
                }
                String realmGet$body = object.realmGet$body();
                if (realmGet$body != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42495e, rowIndex2, realmGet$body, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42495e, rowIndex2, false);
                }
                String realmGet$image = object.realmGet$image();
                if (realmGet$image != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42496f, rowIndex2, realmGet$image, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42496f, rowIndex2, false);
                }
                String realmGet$navigationUrl = object.realmGet$navigationUrl();
                if (realmGet$navigationUrl != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42497g, rowIndex2, realmGet$navigationUrl, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42497g, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42498h, rowIndex2, object.realmGet$trigger(), false);
                String realmGet$id = object.realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42499i, rowIndex2, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42499i, rowIndex2, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            RealmLocalNotificationSync realmLocalNotificationSync = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static RealmLocalNotificationSync m44683a(RealmLocalNotificationSync realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        RealmLocalNotificationSync unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new RealmLocalNotificationSync();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (RealmLocalNotificationSync) cachedObject.f14332b;
        } else {
            unmanagedObject = (RealmLocalNotificationSync) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        RealmLocalNotificationSync realmLocalNotificationSync = unmanagedObject;
        C14019W realmSource = realmObject;
        realmLocalNotificationSync.realmSet$notificationId(realmSource.realmGet$notificationId());
        realmLocalNotificationSync.realmSet$title(realmSource.realmGet$title());
        realmLocalNotificationSync.realmSet$body(realmSource.realmGet$body());
        realmLocalNotificationSync.realmSet$image(realmSource.realmGet$image());
        realmLocalNotificationSync.realmSet$navigationUrl(realmSource.realmGet$navigationUrl());
        realmLocalNotificationSync.realmSet$trigger(realmSource.realmGet$trigger());
        realmLocalNotificationSync.realmSet$id(realmSource.realmGet$id());
        return unmanagedObject;
    }

    /* renamed from: a */
    static RealmLocalNotificationSync m44684a(C13990F realm, RealmLocalNotificationSync realmObject, RealmLocalNotificationSync newObject, Map<C0105Y, C7344p> map) {
        RealmLocalNotificationSync realmLocalNotificationSync = realmObject;
        C14019W realmObjectSource = newObject;
        realmLocalNotificationSync.realmSet$title(realmObjectSource.realmGet$title());
        realmLocalNotificationSync.realmSet$body(realmObjectSource.realmGet$body());
        realmLocalNotificationSync.realmSet$image(realmObjectSource.realmGet$image());
        realmLocalNotificationSync.realmSet$navigationUrl(realmObjectSource.realmGet$navigationUrl());
        realmLocalNotificationSync.realmSet$trigger(realmObjectSource.realmGet$trigger());
        realmLocalNotificationSync.realmSet$id(realmObjectSource.realmGet$id());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmLocalNotificationSync = proxy[");
        stringBuilder.append("{notificationId:");
        String str = "null";
        stringBuilder.append(realmGet$notificationId() != null ? realmGet$notificationId() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{body:");
        stringBuilder.append(realmGet$body() != null ? realmGet$body() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{navigationUrl:");
        stringBuilder.append(realmGet$navigationUrl() != null ? realmGet$navigationUrl() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{trigger:");
        stringBuilder.append(realmGet$trigger());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{id:");
        if (realmGet$id() != null) {
            str = realmGet$id();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42492d;
    }

    public int hashCode() {
        String realmName = this.f42492d.mo43514c().mo43545j();
        String tableName = this.f42492d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42492d.mo43515d().getIndex();
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
        C14017V aRealmLocalNotificationSync = (C14017V) o;
        String path = this.f42492d.mo43514c().mo43545j();
        String otherPath = aRealmLocalNotificationSync.f42492d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42492d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aRealmLocalNotificationSync.f42492d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42492d.mo43515d().getIndex() != aRealmLocalNotificationSync.f42492d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
