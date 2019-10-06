package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

/* renamed from: io.realm.r */
/* compiled from: InstalledRealmProxy */
public class C14084r extends Installed implements C7344p, C0109s {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42700a = m45007e();

    /* renamed from: b */
    private static final List<String> f42701b;

    /* renamed from: c */
    private C14085a f42702c;

    /* renamed from: d */
    private C13986D<Installed> f42703d;

    /* renamed from: io.realm.r$a */
    /* compiled from: InstalledRealmProxy */
    static final class C14085a extends C7327c {

        /* renamed from: c */
        long f42704c;

        /* renamed from: d */
        long f42705d;

        /* renamed from: e */
        long f42706e;

        /* renamed from: f */
        long f42707f;

        /* renamed from: g */
        long f42708g;

        /* renamed from: h */
        long f42709h;

        /* renamed from: i */
        long f42710i;

        /* renamed from: j */
        long f42711j;

        /* renamed from: k */
        long f42712k;

        /* renamed from: l */
        long f42713l;

        /* renamed from: m */
        long f42714m;

        C14085a(SharedRealm realm, Table table) {
            super(11);
            this.f42704c = mo23757a(table, "packageAndVersionCode", RealmFieldType.STRING);
            this.f42705d = mo23757a(table, "icon", RealmFieldType.STRING);
            this.f42706e = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42707f = mo23757a(table, "name", RealmFieldType.STRING);
            this.f42708g = mo23757a(table, "versionCode", RealmFieldType.INTEGER);
            this.f42709h = mo23757a(table, Installed.VERSION_NAME, RealmFieldType.STRING);
            this.f42710i = mo23757a(table, "signature", RealmFieldType.STRING);
            this.f42711j = mo23757a(table, "systemApp", RealmFieldType.BOOLEAN);
            this.f42712k = mo23757a(table, "storeName", RealmFieldType.STRING);
            this.f42713l = mo23757a(table, "status", RealmFieldType.INTEGER);
            this.f42714m = mo23757a(table, "type", RealmFieldType.INTEGER);
        }

        C14085a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14085a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14085a src = (C14085a) rawSrc;
            C14085a dst = (C14085a) rawDst;
            dst.f42704c = src.f42704c;
            dst.f42705d = src.f42705d;
            dst.f42706e = src.f42706e;
            dst.f42707f = src.f42707f;
            dst.f42708g = src.f42708g;
            dst.f42709h = src.f42709h;
            dst.f42710i = src.f42710i;
            dst.f42711j = src.f42711j;
            dst.f42712k = src.f42712k;
            dst.f42713l = src.f42713l;
            dst.f42714m = src.f42714m;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("packageAndVersionCode");
        fieldNames.add("icon");
        fieldNames.add("packageName");
        fieldNames.add("name");
        fieldNames.add("versionCode");
        fieldNames.add(Installed.VERSION_NAME);
        fieldNames.add("signature");
        fieldNames.add("systemApp");
        fieldNames.add("storeName");
        fieldNames.add("status");
        fieldNames.add("type");
        f42701b = Collections.unmodifiableList(fieldNames);
    }

    C14084r() {
        this.f42703d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42703d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42702c = (C14085a) context.mo43700c();
            this.f42703d = new C13986D<>(this);
            this.f42703d.mo43507a(context.mo43702e());
            this.f42703d.mo43513b(context.mo43703f());
            this.f42703d.mo43509a(context.mo43699b());
            this.f42703d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$packageAndVersionCode() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42704c);
    }

    public void realmSet$packageAndVersionCode(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'packageAndVersionCode' cannot be changed after object was created.");
        }
    }

    public String realmGet$icon() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42705d);
    }

    public void realmSet$icon(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42705d);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42705d, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42705d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42705d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$packageName() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42706e);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42706e);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42706e, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42706e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42706e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$name() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42707f);
    }

    public void realmSet$name(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42707f);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42707f, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42707f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42707f, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$versionCode() {
        this.f42703d.mo43514c().mo43690d();
        return (int) this.f42703d.mo43515d().mo23716h(this.f42702c.f42708g);
    }

    public void realmSet$versionCode(int value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            this.f42703d.mo43515d().mo23705b(this.f42702c.f42708g, (long) value);
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            row.mo23711f().mo23649a(this.f42702c.f42708g, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$versionName() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42709h);
    }

    public void realmSet$versionName(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42709h);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42709h, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42709h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42709h, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$signature() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42710i);
    }

    public void realmSet$signature(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42710i);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42710i, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42710i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42710i, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$systemApp() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23712g(this.f42702c.f42711j);
    }

    public void realmSet$systemApp(boolean value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            this.f42703d.mo43515d().mo23703a(this.f42702c.f42711j, value);
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            row.mo23711f().mo23653a(this.f42702c.f42711j, row.getIndex(), value, true);
        }
    }

    public String realmGet$storeName() {
        this.f42703d.mo43514c().mo43690d();
        return this.f42703d.mo43515d().mo23720m(this.f42702c.f42712k);
    }

    public void realmSet$storeName(String value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            if (value == null) {
                this.f42703d.mo43515d().mo23512b(this.f42702c.f42712k);
            } else {
                this.f42703d.mo43515d().setString(this.f42702c.f42712k, value);
            }
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42702c.f42712k, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42702c.f42712k, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$status() {
        this.f42703d.mo43514c().mo43690d();
        return (int) this.f42703d.mo43515d().mo23716h(this.f42702c.f42713l);
    }

    public void realmSet$status(int value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            this.f42703d.mo43515d().mo23705b(this.f42702c.f42713l, (long) value);
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            row.mo23711f().mo23649a(this.f42702c.f42713l, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$type() {
        this.f42703d.mo43514c().mo43690d();
        return (int) this.f42703d.mo43515d().mo23716h(this.f42702c.f42714m);
    }

    public void realmSet$type(int value) {
        if (!this.f42703d.mo43517f()) {
            this.f42703d.mo43514c().mo43690d();
            this.f42703d.mo43515d().mo23705b(this.f42702c.f42714m, (long) value);
        } else if (this.f42703d.mo43510a()) {
            C7347r row = this.f42703d.mo43515d();
            row.mo23711f().mo23649a(this.f42702c.f42714m, row.getIndex(), (long) value, true);
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m45007e() {
        C7309a builder = new C7309a("Installed");
        builder.mo23605a("packageAndVersionCode", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("icon", RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("packageName", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("name", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("versionCode", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a(Installed.VERSION_NAME, RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("signature", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("systemApp", RealmFieldType.BOOLEAN, false, false, true);
        aVar2.mo23605a("storeName", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("status", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("type", RealmFieldType.INTEGER, false, false, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m45005c() {
        return f42700a;
    }

    /* renamed from: a */
    public static C14085a m45002a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Installed";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 11) {
                if (columnCount < 11) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 11 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 11 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 11 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14085a columnInfo = new C14085a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'packageAndVersionCode' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42704c) {
                String str2 = "packageAndVersionCode";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageAndVersionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageAndVersionCode' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42704c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'packageAndVersionCode' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "icon";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'icon' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'icon' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42705d)) {
                        String str4 = "packageName";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42706e)) {
                            String str5 = "name";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'name' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42707f)) {
                                String str6 = "versionCode";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.INTEGER) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'versionCode' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42708g)) {
                                    String str7 = Installed.VERSION_NAME;
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'versionName' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42709h)) {
                                        String str8 = "signature";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'signature' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'signature' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42710i)) {
                                            String str9 = "systemApp";
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'systemApp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.BOOLEAN) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'systemApp' in existing Realm file.");
                                            } else if (!table.mo23678l(columnInfo.f42711j)) {
                                                String str10 = "storeName";
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'storeName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.STRING) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'storeName' in existing Realm file.");
                                                } else if (table.mo23678l(columnInfo.f42712k)) {
                                                    String str11 = "status";
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.INTEGER) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'status' in existing Realm file.");
                                                    } else if (!table.mo23678l(columnInfo.f42713l)) {
                                                        String str12 = "type";
                                                        if (!columnTypes.containsKey(str12)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str12) != RealmFieldType.INTEGER) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'type' in existing Realm file.");
                                                        } else if (!table.mo23678l(columnInfo.f42714m)) {
                                                            return columnInfo;
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'type' does support null values in the existing Realm file. Use corresponding boxed type for field 'type' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'status' does support null values in the existing Realm file. Use corresponding boxed type for field 'status' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'storeName' is required. Either set @Required to field 'storeName' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'systemApp' does support null values in the existing Realm file. Use corresponding boxed type for field 'systemApp' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'signature' is required. Either set @Required to field 'signature' or migrate using RealmObjectSchema.setNullable().");
                                        }
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
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' is required. Either set @Required to field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'icon' is required. Either set @Required to field 'icon' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'packageAndVersionCode' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field packageAndVersionCode");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Installed' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m45006d() {
        return "class_Installed";
    }

    /* renamed from: b */
    public static Installed m45004b(C13990F realm, Installed object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        Installed installed = object;
        Map<C0105Y, C7344p> map = cache;
        if ((installed instanceof C7344p) && ((C7344p) installed).mo23791a().mo43514c() != null && ((C7344p) installed).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((installed instanceof C7344p) && ((C7344p) installed).mo23791a().mo43514c() != null && ((C7344p) installed).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return installed;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(installed);
            if (cachedRealmObject != null) {
                return (Installed) cachedRealmObject;
            }
            Installed realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Installed.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$packageAndVersionCode();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Installed.class), false, Collections.emptyList());
                            realmObject = new C14084r();
                            map.put(installed, realmObject);
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
                return m45001a(realm, object, update, cache);
            }
            m45000a(f, realmObject, installed, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Installed m45001a(C13990F realm, Installed newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Installed) cachedRealmObject;
        }
        Installed realmObject = (Installed) realm.mo43528a(Installed.class, newObject.realmGet$packageAndVersionCode(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C0109s realmObjectSource = newObject;
        Installed installed = realmObject;
        installed.realmSet$icon(realmObjectSource.realmGet$icon());
        installed.realmSet$packageName(realmObjectSource.realmGet$packageName());
        installed.realmSet$name(realmObjectSource.realmGet$name());
        installed.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        installed.realmSet$versionName(realmObjectSource.realmGet$versionName());
        installed.realmSet$signature(realmObjectSource.realmGet$signature());
        installed.realmSet$systemApp(realmObjectSource.realmGet$systemApp());
        installed.realmSet$storeName(realmObjectSource.realmGet$storeName());
        installed.realmSet$status(realmObjectSource.realmGet$status());
        installed.realmSet$type(realmObjectSource.realmGet$type());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44998a(C13990F realm, Installed object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Installed installed = object;
        if ((installed instanceof C7344p) && ((C7344p) installed).mo23791a().mo43514c() != null && ((C7344p) installed).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) installed).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Installed.class);
        long tableNativePtr = table.getNativePtr();
        C14085a columnInfo = (C14085a) f.f42569h.mo43710a(Installed.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$packageAndVersionCode();
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
        cache.put(installed, Long.valueOf(rowIndex2));
        String realmGet$icon = object.realmGet$icon();
        if (realmGet$icon != null) {
            long j = pkColumnIndex;
            Table.nativeSetString(tableNativePtr, columnInfo.f42705d, rowIndex2, realmGet$icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42705d, rowIndex2, false);
        }
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42706e, rowIndex2, realmGet$packageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42706e, rowIndex2, false);
        }
        String realmGet$name = object.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42707f, rowIndex2, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42707f, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42708g, rowIndex2, (long) object.realmGet$versionCode(), false);
        String realmGet$versionName = object.realmGet$versionName();
        if (realmGet$versionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42709h, rowIndex2, realmGet$versionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42709h, rowIndex2, false);
        }
        String realmGet$signature = object.realmGet$signature();
        if (realmGet$signature != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42710i, rowIndex2, realmGet$signature, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42710i, rowIndex2, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.f42711j, rowIndex2, object.realmGet$systemApp(), false);
        String realmGet$storeName = object.realmGet$storeName();
        if (realmGet$storeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42712k, rowIndex2, realmGet$storeName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42712k, rowIndex2, false);
        }
        long j2 = rowIndex2;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42713l, j2, (long) object.realmGet$status(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42714m, j2, (long) object.realmGet$type(), false);
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m45003a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Installed.class);
        long tableNativePtr = table.getNativePtr();
        C14085a columnInfo = (C14085a) f.f42569h.mo43710a(Installed.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            Installed object = (Installed) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$packageAndVersionCode();
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
                    Table.nativeSetString(tableNativePtr, columnInfo.f42705d, rowIndex2, realmGet$icon, false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42705d, rowIndex2, false);
                }
                String realmGet$packageName = object.realmGet$packageName();
                if (realmGet$packageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42706e, rowIndex2, realmGet$packageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42706e, rowIndex2, false);
                }
                String realmGet$name = object.realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42707f, rowIndex2, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42707f, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42708g, rowIndex2, (long) object.realmGet$versionCode(), false);
                String realmGet$versionName = object.realmGet$versionName();
                if (realmGet$versionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42709h, rowIndex2, realmGet$versionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42709h, rowIndex2, false);
                }
                String realmGet$signature = object.realmGet$signature();
                if (realmGet$signature != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42710i, rowIndex2, realmGet$signature, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42710i, rowIndex2, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.f42711j, rowIndex2, object.realmGet$systemApp(), false);
                String realmGet$storeName = object.realmGet$storeName();
                if (realmGet$storeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42712k, rowIndex2, realmGet$storeName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42712k, rowIndex2, false);
                }
                long j = rowIndex2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42713l, j, (long) object.realmGet$status(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42714m, j, (long) object.realmGet$type(), false);
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            Installed installed = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static Installed m44999a(Installed realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Installed unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Installed();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Installed) cachedObject.f14332b;
        } else {
            unmanagedObject = (Installed) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Installed installed = unmanagedObject;
        C0109s realmSource = realmObject;
        installed.realmSet$packageAndVersionCode(realmSource.realmGet$packageAndVersionCode());
        installed.realmSet$icon(realmSource.realmGet$icon());
        installed.realmSet$packageName(realmSource.realmGet$packageName());
        installed.realmSet$name(realmSource.realmGet$name());
        installed.realmSet$versionCode(realmSource.realmGet$versionCode());
        installed.realmSet$versionName(realmSource.realmGet$versionName());
        installed.realmSet$signature(realmSource.realmGet$signature());
        installed.realmSet$systemApp(realmSource.realmGet$systemApp());
        installed.realmSet$storeName(realmSource.realmGet$storeName());
        installed.realmSet$status(realmSource.realmGet$status());
        installed.realmSet$type(realmSource.realmGet$type());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Installed m45000a(C13990F realm, Installed realmObject, Installed newObject, Map<C0105Y, C7344p> map) {
        Installed installed = realmObject;
        C0109s realmObjectSource = newObject;
        installed.realmSet$icon(realmObjectSource.realmGet$icon());
        installed.realmSet$packageName(realmObjectSource.realmGet$packageName());
        installed.realmSet$name(realmObjectSource.realmGet$name());
        installed.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        installed.realmSet$versionName(realmObjectSource.realmGet$versionName());
        installed.realmSet$signature(realmObjectSource.realmGet$signature());
        installed.realmSet$systemApp(realmObjectSource.realmGet$systemApp());
        installed.realmSet$storeName(realmObjectSource.realmGet$storeName());
        installed.realmSet$status(realmObjectSource.realmGet$status());
        installed.realmSet$type(realmObjectSource.realmGet$type());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Installed = proxy[");
        stringBuilder.append("{packageAndVersionCode:");
        String str = "null";
        stringBuilder.append(realmGet$packageAndVersionCode() != null ? realmGet$packageAndVersionCode() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon() != null ? realmGet$icon() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{packageName:");
        stringBuilder.append(realmGet$packageName() != null ? realmGet$packageName() : str);
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
        stringBuilder.append(realmGet$versionName() != null ? realmGet$versionName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{signature:");
        stringBuilder.append(realmGet$signature() != null ? realmGet$signature() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{systemApp:");
        stringBuilder.append(realmGet$systemApp());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{storeName:");
        if (realmGet$storeName() != null) {
            str = realmGet$storeName();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42703d;
    }
}
