package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.Installation;
import p005cm.aptoide.p006pt.database.realm.Installed;
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

/* renamed from: io.realm.p */
/* compiled from: InstallationRealmProxy */
public class C14081p extends Installation implements C7344p, C14083q {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42691a = m44993e();

    /* renamed from: b */
    private static final List<String> f42692b;

    /* renamed from: c */
    private C14082a f42693c;

    /* renamed from: d */
    private C13986D<Installation> f42694d;

    /* renamed from: io.realm.p$a */
    /* compiled from: InstallationRealmProxy */
    static final class C14082a extends C7327c {

        /* renamed from: c */
        long f42695c;

        /* renamed from: d */
        long f42696d;

        /* renamed from: e */
        long f42697e;

        /* renamed from: f */
        long f42698f;

        /* renamed from: g */
        long f42699g;

        C14082a(SharedRealm realm, Table table) {
            super(5);
            this.f42695c = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42696d = mo23757a(table, "icon", RealmFieldType.STRING);
            this.f42697e = mo23757a(table, "name", RealmFieldType.STRING);
            this.f42698f = mo23757a(table, "versionCode", RealmFieldType.INTEGER);
            this.f42699g = mo23757a(table, Installed.VERSION_NAME, RealmFieldType.STRING);
        }

        C14082a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14082a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14082a src = (C14082a) rawSrc;
            C14082a dst = (C14082a) rawDst;
            dst.f42695c = src.f42695c;
            dst.f42696d = src.f42696d;
            dst.f42697e = src.f42697e;
            dst.f42698f = src.f42698f;
            dst.f42699g = src.f42699g;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("packageName");
        fieldNames.add("icon");
        fieldNames.add("name");
        fieldNames.add("versionCode");
        fieldNames.add(Installed.VERSION_NAME);
        f42692b = Collections.unmodifiableList(fieldNames);
    }

    C14081p() {
        this.f42694d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42694d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42693c = (C14082a) context.mo43700c();
            this.f42694d = new C13986D<>(this);
            this.f42694d.mo43507a(context.mo43702e());
            this.f42694d.mo43513b(context.mo43703f());
            this.f42694d.mo43509a(context.mo43699b());
            this.f42694d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$packageName() {
        this.f42694d.mo43514c().mo43690d();
        return this.f42694d.mo43515d().mo23720m(this.f42693c.f42695c);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42694d.mo43517f()) {
            this.f42694d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'packageName' cannot be changed after object was created.");
        }
    }

    public String realmGet$icon() {
        this.f42694d.mo43514c().mo43690d();
        return this.f42694d.mo43515d().mo23720m(this.f42693c.f42696d);
    }

    public void realmSet$icon(String value) {
        if (!this.f42694d.mo43517f()) {
            this.f42694d.mo43514c().mo43690d();
            if (value == null) {
                this.f42694d.mo43515d().mo23512b(this.f42693c.f42696d);
            } else {
                this.f42694d.mo43515d().setString(this.f42693c.f42696d, value);
            }
        } else if (this.f42694d.mo43510a()) {
            C7347r row = this.f42694d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42693c.f42696d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42693c.f42696d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$name() {
        this.f42694d.mo43514c().mo43690d();
        return this.f42694d.mo43515d().mo23720m(this.f42693c.f42697e);
    }

    public void realmSet$name(String value) {
        if (!this.f42694d.mo43517f()) {
            this.f42694d.mo43514c().mo43690d();
            if (value == null) {
                this.f42694d.mo43515d().mo23512b(this.f42693c.f42697e);
            } else {
                this.f42694d.mo43515d().setString(this.f42693c.f42697e, value);
            }
        } else if (this.f42694d.mo43510a()) {
            C7347r row = this.f42694d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42693c.f42697e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42693c.f42697e, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$versionCode() {
        this.f42694d.mo43514c().mo43690d();
        return (int) this.f42694d.mo43515d().mo23716h(this.f42693c.f42698f);
    }

    public void realmSet$versionCode(int value) {
        if (!this.f42694d.mo43517f()) {
            this.f42694d.mo43514c().mo43690d();
            this.f42694d.mo43515d().mo23705b(this.f42693c.f42698f, (long) value);
        } else if (this.f42694d.mo43510a()) {
            C7347r row = this.f42694d.mo43515d();
            row.mo23711f().mo23649a(this.f42693c.f42698f, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$versionName() {
        this.f42694d.mo43514c().mo43690d();
        return this.f42694d.mo43515d().mo23720m(this.f42693c.f42699g);
    }

    public void realmSet$versionName(String value) {
        if (!this.f42694d.mo43517f()) {
            this.f42694d.mo43514c().mo43690d();
            if (value == null) {
                this.f42694d.mo43515d().mo23512b(this.f42693c.f42699g);
            } else {
                this.f42694d.mo43515d().setString(this.f42693c.f42699g, value);
            }
        } else if (this.f42694d.mo43510a()) {
            C7347r row = this.f42694d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42693c.f42699g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42693c.f42699g, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44993e() {
        C7309a builder = new C7309a("Installation");
        builder.mo23605a("packageName", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("icon", RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("name", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("versionCode", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a(Installed.VERSION_NAME, RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44991c() {
        return f42691a;
    }

    /* renamed from: a */
    public static C14082a m44988a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Installation";
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
            C14082a columnInfo = new C14082a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'packageName' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42695c) {
                String str2 = "packageName";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42695c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'packageName' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "icon";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'icon' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'icon' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42696d)) {
                        String str4 = "name";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'name' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42697e)) {
                            String str5 = "versionCode";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.INTEGER) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'versionCode' in existing Realm file.");
                            } else if (!table.mo23678l(columnInfo.f42698f)) {
                                String str6 = Installed.VERSION_NAME;
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'versionName' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42699g)) {
                                    return columnInfo;
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionName' is required. Either set @Required to field 'versionName' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'versionCode' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'icon' is required. Either set @Required to field 'icon' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Installation' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44992d() {
        return "class_Installation";
    }

    /* renamed from: b */
    public static Installation m44990b(C13990F realm, Installation object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        Installation installation = object;
        Map<C0105Y, C7344p> map = cache;
        if ((installation instanceof C7344p) && ((C7344p) installation).mo23791a().mo43514c() != null && ((C7344p) installation).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((installation instanceof C7344p) && ((C7344p) installation).mo23791a().mo43514c() != null && ((C7344p) installation).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return installation;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(installation);
            if (cachedRealmObject != null) {
                return (Installation) cachedRealmObject;
            }
            Installation realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Installation.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$packageName();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Installation.class), false, Collections.emptyList());
                            realmObject = new C14081p();
                            map.put(installation, realmObject);
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
                return m44987a(realm, object, update, cache);
            }
            m44986a(f, realmObject, installation, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Installation m44987a(C13990F realm, Installation newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Installation) cachedRealmObject;
        }
        Installation realmObject = (Installation) realm.mo43528a(Installation.class, newObject.realmGet$packageName(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14083q realmObjectSource = newObject;
        Installation installation = realmObject;
        installation.realmSet$icon(realmObjectSource.realmGet$icon());
        installation.realmSet$name(realmObjectSource.realmGet$name());
        installation.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        installation.realmSet$versionName(realmObjectSource.realmGet$versionName());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44984a(C13990F realm, Installation object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Installation installation = object;
        if ((installation instanceof C7344p) && ((C7344p) installation).mo23791a().mo43514c() != null && ((C7344p) installation).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) installation).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Installation.class);
        long tableNativePtr = table.getNativePtr();
        C14082a columnInfo = (C14082a) f.f42569h.mo43710a(Installation.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$packageName();
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
        cache.put(installation, Long.valueOf(rowIndex2));
        String realmGet$icon = object.realmGet$icon();
        if (realmGet$icon != null) {
            long j = pkColumnIndex;
            Table.nativeSetString(tableNativePtr, columnInfo.f42696d, rowIndex2, realmGet$icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42696d, rowIndex2, false);
        }
        String realmGet$name = object.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42697e, rowIndex2, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42697e, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42698f, rowIndex2, (long) object.realmGet$versionCode(), false);
        String realmGet$versionName = object.realmGet$versionName();
        if (realmGet$versionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42699g, rowIndex2, realmGet$versionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42699g, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44989a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Installation.class);
        long tableNativePtr = table.getNativePtr();
        C14082a columnInfo = (C14082a) f.f42569h.mo43710a(Installation.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            Installation object = (Installation) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$packageName();
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
                String realmGet$icon = object.realmGet$icon();
                if (realmGet$icon != null) {
                    String str = primaryKeyValue;
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetString(tableNativePtr, columnInfo.f42696d, rowIndex2, realmGet$icon, false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42696d, rowIndex2, false);
                }
                String realmGet$name = object.realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42697e, rowIndex2, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42697e, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42698f, rowIndex2, (long) object.realmGet$versionCode(), false);
                String realmGet$versionName = object.realmGet$versionName();
                if (realmGet$versionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42699g, rowIndex2, realmGet$versionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42699g, rowIndex2, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            Installation installation = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static Installation m44985a(Installation realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Installation unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Installation();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Installation) cachedObject.f14332b;
        } else {
            unmanagedObject = (Installation) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Installation installation = unmanagedObject;
        C14083q realmSource = realmObject;
        installation.realmSet$packageName(realmSource.realmGet$packageName());
        installation.realmSet$icon(realmSource.realmGet$icon());
        installation.realmSet$name(realmSource.realmGet$name());
        installation.realmSet$versionCode(realmSource.realmGet$versionCode());
        installation.realmSet$versionName(realmSource.realmGet$versionName());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Installation m44986a(C13990F realm, Installation realmObject, Installation newObject, Map<C0105Y, C7344p> map) {
        Installation installation = realmObject;
        C14083q realmObjectSource = newObject;
        installation.realmSet$icon(realmObjectSource.realmGet$icon());
        installation.realmSet$name(realmObjectSource.realmGet$name());
        installation.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        installation.realmSet$versionName(realmObjectSource.realmGet$versionName());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Installation = proxy[");
        stringBuilder.append("{packageName:");
        String str = "null";
        stringBuilder.append(realmGet$packageName() != null ? realmGet$packageName() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon() != null ? realmGet$icon() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{versionCode:");
        stringBuilder.append(realmGet$versionCode());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{versionName:");
        if (realmGet$versionName() != null) {
            str = realmGet$versionName();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42694d;
    }

    public int hashCode() {
        String realmName = this.f42694d.mo43514c().mo43545j();
        String tableName = this.f42694d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42694d.mo43515d().getIndex();
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
        C14081p aInstallation = (C14081p) o;
        String path = this.f42694d.mo43514c().mo43545j();
        String otherPath = aInstallation.f42694d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42694d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aInstallation.f42694d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42694d.mo43515d().getIndex() != aInstallation.f42694d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
