package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.downloadmanager.Constants;
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

/* renamed from: io.realm.n */
/* compiled from: FileToDownloadRealmProxy */
public class C14075n extends FileToDownload implements C7344p, C14079o {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42649a = m44965e();

    /* renamed from: b */
    private static final List<String> f42650b;

    /* renamed from: c */
    private C14076a f42651c;

    /* renamed from: d */
    private C13986D<FileToDownload> f42652d;

    /* renamed from: io.realm.n$a */
    /* compiled from: FileToDownloadRealmProxy */
    static final class C14076a extends C7327c {

        /* renamed from: c */
        long f42653c;

        /* renamed from: d */
        long f42654d;

        /* renamed from: e */
        long f42655e;

        /* renamed from: f */
        long f42656f;

        /* renamed from: g */
        long f42657g;

        /* renamed from: h */
        long f42658h;

        /* renamed from: i */
        long f42659i;

        /* renamed from: j */
        long f42660j;

        /* renamed from: k */
        long f42661k;

        /* renamed from: l */
        long f42662l;

        /* renamed from: m */
        long f42663m;

        /* renamed from: n */
        long f42664n;

        C14076a(SharedRealm realm, Table table) {
            super(12);
            this.f42653c = mo23757a(table, "md5", RealmFieldType.STRING);
            this.f42654d = mo23757a(table, "downloadId", RealmFieldType.INTEGER);
            this.f42655e = mo23757a(table, "altLink", RealmFieldType.STRING);
            this.f42656f = mo23757a(table, "link", RealmFieldType.STRING);
            this.f42657g = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42658h = mo23757a(table, "path", RealmFieldType.STRING);
            this.f42659i = mo23757a(table, Constants.FILE_TYPE, RealmFieldType.INTEGER);
            this.f42660j = mo23757a(table, "progress", RealmFieldType.INTEGER);
            this.f42661k = mo23757a(table, "status", RealmFieldType.INTEGER);
            this.f42662l = mo23757a(table, "fileName", RealmFieldType.STRING);
            this.f42663m = mo23757a(table, "versionCode", RealmFieldType.INTEGER);
            this.f42664n = mo23757a(table, Installed.VERSION_NAME, RealmFieldType.STRING);
        }

        C14076a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14076a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14076a src = (C14076a) rawSrc;
            C14076a dst = (C14076a) rawDst;
            dst.f42653c = src.f42653c;
            dst.f42654d = src.f42654d;
            dst.f42655e = src.f42655e;
            dst.f42656f = src.f42656f;
            dst.f42657g = src.f42657g;
            dst.f42658h = src.f42658h;
            dst.f42659i = src.f42659i;
            dst.f42660j = src.f42660j;
            dst.f42661k = src.f42661k;
            dst.f42662l = src.f42662l;
            dst.f42663m = src.f42663m;
            dst.f42664n = src.f42664n;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("md5");
        fieldNames.add("downloadId");
        fieldNames.add("altLink");
        fieldNames.add("link");
        fieldNames.add("packageName");
        fieldNames.add("path");
        fieldNames.add(Constants.FILE_TYPE);
        fieldNames.add("progress");
        fieldNames.add("status");
        fieldNames.add("fileName");
        fieldNames.add("versionCode");
        fieldNames.add(Installed.VERSION_NAME);
        f42650b = Collections.unmodifiableList(fieldNames);
    }

    C14075n() {
        this.f42652d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42652d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42651c = (C14076a) context.mo43700c();
            this.f42652d = new C13986D<>(this);
            this.f42652d.mo43507a(context.mo43702e());
            this.f42652d.mo43513b(context.mo43703f());
            this.f42652d.mo43509a(context.mo43699b());
            this.f42652d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$md5() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42653c);
    }

    public void realmSet$md5(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'md5' cannot be changed after object was created.");
        }
    }

    public int realmGet$downloadId() {
        this.f42652d.mo43514c().mo43690d();
        return (int) this.f42652d.mo43515d().mo23716h(this.f42651c.f42654d);
    }

    public void realmSet$downloadId(int value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            this.f42652d.mo43515d().mo23705b(this.f42651c.f42654d, (long) value);
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            row.mo23711f().mo23649a(this.f42651c.f42654d, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$altLink() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42655e);
    }

    public void realmSet$altLink(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42655e);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42655e, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42655e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42655e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$link() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42656f);
    }

    public void realmSet$link(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42656f);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42656f, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42656f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42656f, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$packageName() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42657g);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42657g);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42657g, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42657g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42657g, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$path() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42658h);
    }

    public void realmSet$path(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42658h);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42658h, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42658h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42658h, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$fileType() {
        this.f42652d.mo43514c().mo43690d();
        return (int) this.f42652d.mo43515d().mo23716h(this.f42651c.f42659i);
    }

    public void realmSet$fileType(int value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            this.f42652d.mo43515d().mo23705b(this.f42651c.f42659i, (long) value);
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            row.mo23711f().mo23649a(this.f42651c.f42659i, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$progress() {
        this.f42652d.mo43514c().mo43690d();
        return (int) this.f42652d.mo43515d().mo23716h(this.f42651c.f42660j);
    }

    public void realmSet$progress(int value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            this.f42652d.mo43515d().mo23705b(this.f42651c.f42660j, (long) value);
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            row.mo23711f().mo23649a(this.f42651c.f42660j, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$status() {
        this.f42652d.mo43514c().mo43690d();
        return (int) this.f42652d.mo43515d().mo23716h(this.f42651c.f42661k);
    }

    public void realmSet$status(int value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            this.f42652d.mo43515d().mo23705b(this.f42651c.f42661k, (long) value);
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            row.mo23711f().mo23649a(this.f42651c.f42661k, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$fileName() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42662l);
    }

    public void realmSet$fileName(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42662l);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42662l, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42662l, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42662l, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$versionCode() {
        this.f42652d.mo43514c().mo43690d();
        return (int) this.f42652d.mo43515d().mo23716h(this.f42651c.f42663m);
    }

    public void realmSet$versionCode(int value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            this.f42652d.mo43515d().mo23705b(this.f42651c.f42663m, (long) value);
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            row.mo23711f().mo23649a(this.f42651c.f42663m, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$versionName() {
        this.f42652d.mo43514c().mo43690d();
        return this.f42652d.mo43515d().mo23720m(this.f42651c.f42664n);
    }

    public void realmSet$versionName(String value) {
        if (!this.f42652d.mo43517f()) {
            this.f42652d.mo43514c().mo43690d();
            if (value == null) {
                this.f42652d.mo43515d().mo23512b(this.f42651c.f42664n);
            } else {
                this.f42652d.mo43515d().setString(this.f42651c.f42664n, value);
            }
        } else if (this.f42652d.mo43510a()) {
            C7347r row = this.f42652d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42651c.f42664n, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42651c.f42664n, row.getIndex(), value, true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44965e() {
        C7309a builder = new C7309a("FileToDownload");
        builder.mo23605a("md5", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("downloadId", RealmFieldType.INTEGER, false, false, true);
        C7309a aVar2 = builder;
        aVar2.mo23605a("altLink", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("link", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("packageName", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("path", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(Constants.FILE_TYPE, RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a("progress", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("status", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a("fileName", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("versionCode", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a(Installed.VERSION_NAME, RealmFieldType.STRING, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44963c() {
        return f42649a;
    }

    /* renamed from: a */
    public static C14076a m44960a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_FileToDownload";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 12) {
                if (columnCount < 12) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 12 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 12 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 12 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14076a columnInfo = new C14076a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'md5' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42653c) {
                String str2 = "md5";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'md5' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'md5' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42653c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'md5' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "downloadId";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'downloadId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'downloadId' in existing Realm file.");
                    } else if (!table.mo23678l(columnInfo.f42654d)) {
                        String str4 = "altLink";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'altLink' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'altLink' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42655e)) {
                            String str5 = "link";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'link' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'link' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42656f)) {
                                String str6 = "packageName";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42657g)) {
                                    String str7 = "path";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'path' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'path' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42658h)) {
                                        String str8 = Constants.FILE_TYPE;
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'fileType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.INTEGER) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'fileType' in existing Realm file.");
                                        } else if (!table.mo23678l(columnInfo.f42659i)) {
                                            String str9 = "progress";
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'progress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.INTEGER) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'progress' in existing Realm file.");
                                            } else if (!table.mo23678l(columnInfo.f42660j)) {
                                                String str10 = "status";
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.INTEGER) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'status' in existing Realm file.");
                                                } else if (!table.mo23678l(columnInfo.f42661k)) {
                                                    String str11 = "fileName";
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'fileName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'fileName' in existing Realm file.");
                                                    } else if (table.mo23678l(columnInfo.f42662l)) {
                                                        String str12 = "versionCode";
                                                        if (!columnTypes.containsKey(str12)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str12) != RealmFieldType.INTEGER) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'versionCode' in existing Realm file.");
                                                        } else if (!table.mo23678l(columnInfo.f42663m)) {
                                                            String str13 = Installed.VERSION_NAME;
                                                            if (!columnTypes.containsKey(str13)) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                            } else if (columnTypes.get(str13) != RealmFieldType.STRING) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'versionName' in existing Realm file.");
                                                            } else if (table.mo23678l(columnInfo.f42664n)) {
                                                                return columnInfo;
                                                            } else {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionName' is required. Either set @Required to field 'versionName' or migrate using RealmObjectSchema.setNullable().");
                                                            }
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'versionCode' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'fileName' is required. Either set @Required to field 'fileName' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'status' does support null values in the existing Realm file. Use corresponding boxed type for field 'status' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'progress' does support null values in the existing Realm file. Use corresponding boxed type for field 'progress' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'fileType' does support null values in the existing Realm file. Use corresponding boxed type for field 'fileType' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'path' is required. Either set @Required to field 'path' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' is required. Either set @Required to field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'link' is required. Either set @Required to field 'link' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'altLink' is required. Either set @Required to field 'altLink' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'downloadId' does support null values in the existing Realm file. Use corresponding boxed type for field 'downloadId' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'md5' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field md5");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'FileToDownload' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44964d() {
        return "class_FileToDownload";
    }

    /* renamed from: b */
    public static FileToDownload m44962b(C13990F realm, FileToDownload object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        FileToDownload fileToDownload = object;
        Map<C0105Y, C7344p> map = cache;
        if ((fileToDownload instanceof C7344p) && ((C7344p) fileToDownload).mo23791a().mo43514c() != null && ((C7344p) fileToDownload).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((fileToDownload instanceof C7344p) && ((C7344p) fileToDownload).mo23791a().mo43514c() != null && ((C7344p) fileToDownload).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return fileToDownload;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(fileToDownload);
            if (cachedRealmObject != null) {
                return (FileToDownload) cachedRealmObject;
            }
            FileToDownload realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(FileToDownload.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$md5();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(FileToDownload.class), false, Collections.emptyList());
                            realmObject = new C14075n();
                            map.put(fileToDownload, realmObject);
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
                return m44959a(realm, object, update, cache);
            }
            m44958a(f, realmObject, fileToDownload, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static FileToDownload m44959a(C13990F realm, FileToDownload newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (FileToDownload) cachedRealmObject;
        }
        FileToDownload realmObject = (FileToDownload) realm.mo43528a(FileToDownload.class, newObject.realmGet$md5(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14079o realmObjectSource = newObject;
        FileToDownload fileToDownload = realmObject;
        fileToDownload.realmSet$downloadId(realmObjectSource.realmGet$downloadId());
        fileToDownload.realmSet$altLink(realmObjectSource.realmGet$altLink());
        fileToDownload.realmSet$link(realmObjectSource.realmGet$link());
        fileToDownload.realmSet$packageName(realmObjectSource.realmGet$packageName());
        fileToDownload.realmSet$path(realmObjectSource.realmGet$path());
        fileToDownload.realmSet$fileType(realmObjectSource.realmGet$fileType());
        fileToDownload.realmSet$progress(realmObjectSource.realmGet$progress());
        fileToDownload.realmSet$status(realmObjectSource.realmGet$status());
        fileToDownload.realmSet$fileName(realmObjectSource.realmGet$fileName());
        fileToDownload.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        fileToDownload.realmSet$versionName(realmObjectSource.realmGet$versionName());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44956a(C13990F realm, FileToDownload object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        FileToDownload fileToDownload = object;
        if ((fileToDownload instanceof C7344p) && ((C7344p) fileToDownload).mo23791a().mo43514c() != null && ((C7344p) fileToDownload).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) fileToDownload).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(FileToDownload.class);
        long tableNativePtr = table.getNativePtr();
        C14076a columnInfo = (C14076a) f.f42569h.mo43710a(FileToDownload.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$md5();
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
        cache.put(fileToDownload, Long.valueOf(rowIndex2));
        long j = pkColumnIndex;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42654d, rowIndex2, (long) object.realmGet$downloadId(), false);
        String realmGet$altLink = object.realmGet$altLink();
        if (realmGet$altLink != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42655e, rowIndex2, realmGet$altLink, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42655e, rowIndex2, false);
        }
        String realmGet$link = object.realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42656f, rowIndex2, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42656f, rowIndex2, false);
        }
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42657g, rowIndex2, realmGet$packageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42657g, rowIndex2, false);
        }
        String realmGet$path = object.realmGet$path();
        if (realmGet$path != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42658h, rowIndex2, realmGet$path, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42658h, rowIndex2, false);
        }
        long j2 = rowIndex2;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42659i, j2, (long) object.realmGet$fileType(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42660j, j2, (long) object.realmGet$progress(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42661k, j2, (long) object.realmGet$status(), false);
        String realmGet$fileName = object.realmGet$fileName();
        if (realmGet$fileName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42662l, rowIndex2, realmGet$fileName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42662l, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42663m, rowIndex2, (long) object.realmGet$versionCode(), false);
        String realmGet$versionName = object.realmGet$versionName();
        if (realmGet$versionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42664n, rowIndex2, realmGet$versionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42664n, rowIndex2, false);
        }
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44961a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(FileToDownload.class);
        long tableNativePtr = table.getNativePtr();
        C14076a columnInfo = (C14076a) f.f42569h.mo43710a(FileToDownload.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            FileToDownload object = (FileToDownload) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$md5();
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
                long pkColumnIndex3 = (long) object.realmGet$downloadId();
                String str = primaryKeyValue;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42654d, rowIndex2, pkColumnIndex3, false);
                String realmGet$altLink = object.realmGet$altLink();
                if (realmGet$altLink != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42655e, rowIndex2, realmGet$altLink, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42655e, rowIndex2, false);
                }
                String realmGet$link = object.realmGet$link();
                if (realmGet$link != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42656f, rowIndex2, realmGet$link, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42656f, rowIndex2, false);
                }
                String realmGet$packageName = object.realmGet$packageName();
                if (realmGet$packageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42657g, rowIndex2, realmGet$packageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42657g, rowIndex2, false);
                }
                String realmGet$path = object.realmGet$path();
                if (realmGet$path != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42658h, rowIndex2, realmGet$path, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42658h, rowIndex2, false);
                }
                long j = rowIndex2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42659i, j, (long) object.realmGet$fileType(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42660j, j, (long) object.realmGet$progress(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42661k, j, (long) object.realmGet$status(), false);
                String realmGet$fileName = object.realmGet$fileName();
                if (realmGet$fileName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42662l, rowIndex2, realmGet$fileName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42662l, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42663m, rowIndex2, (long) object.realmGet$versionCode(), false);
                String realmGet$versionName = object.realmGet$versionName();
                if (realmGet$versionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42664n, rowIndex2, realmGet$versionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42664n, rowIndex2, false);
                }
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            FileToDownload fileToDownload = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static FileToDownload m44957a(FileToDownload realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        FileToDownload unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new FileToDownload();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (FileToDownload) cachedObject.f14332b;
        } else {
            unmanagedObject = (FileToDownload) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        FileToDownload fileToDownload = unmanagedObject;
        C14079o realmSource = realmObject;
        fileToDownload.realmSet$md5(realmSource.realmGet$md5());
        fileToDownload.realmSet$downloadId(realmSource.realmGet$downloadId());
        fileToDownload.realmSet$altLink(realmSource.realmGet$altLink());
        fileToDownload.realmSet$link(realmSource.realmGet$link());
        fileToDownload.realmSet$packageName(realmSource.realmGet$packageName());
        fileToDownload.realmSet$path(realmSource.realmGet$path());
        fileToDownload.realmSet$fileType(realmSource.realmGet$fileType());
        fileToDownload.realmSet$progress(realmSource.realmGet$progress());
        fileToDownload.realmSet$status(realmSource.realmGet$status());
        fileToDownload.realmSet$fileName(realmSource.realmGet$fileName());
        fileToDownload.realmSet$versionCode(realmSource.realmGet$versionCode());
        fileToDownload.realmSet$versionName(realmSource.realmGet$versionName());
        return unmanagedObject;
    }

    /* renamed from: a */
    static FileToDownload m44958a(C13990F realm, FileToDownload realmObject, FileToDownload newObject, Map<C0105Y, C7344p> map) {
        FileToDownload fileToDownload = realmObject;
        C14079o realmObjectSource = newObject;
        fileToDownload.realmSet$downloadId(realmObjectSource.realmGet$downloadId());
        fileToDownload.realmSet$altLink(realmObjectSource.realmGet$altLink());
        fileToDownload.realmSet$link(realmObjectSource.realmGet$link());
        fileToDownload.realmSet$packageName(realmObjectSource.realmGet$packageName());
        fileToDownload.realmSet$path(realmObjectSource.realmGet$path());
        fileToDownload.realmSet$fileType(realmObjectSource.realmGet$fileType());
        fileToDownload.realmSet$progress(realmObjectSource.realmGet$progress());
        fileToDownload.realmSet$status(realmObjectSource.realmGet$status());
        fileToDownload.realmSet$fileName(realmObjectSource.realmGet$fileName());
        fileToDownload.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        fileToDownload.realmSet$versionName(realmObjectSource.realmGet$versionName());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FileToDownload = proxy[");
        stringBuilder.append("{md5:");
        String str = "null";
        stringBuilder.append(realmGet$md5() != null ? realmGet$md5() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{downloadId:");
        stringBuilder.append(realmGet$downloadId());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{altLink:");
        stringBuilder.append(realmGet$altLink() != null ? realmGet$altLink() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link() != null ? realmGet$link() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{packageName:");
        stringBuilder.append(realmGet$packageName() != null ? realmGet$packageName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{path:");
        stringBuilder.append(realmGet$path() != null ? realmGet$path() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{fileType:");
        stringBuilder.append(realmGet$fileType());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{progress:");
        stringBuilder.append(realmGet$progress());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{fileName:");
        stringBuilder.append(realmGet$fileName() != null ? realmGet$fileName() : str);
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
        return this.f42652d;
    }
}
