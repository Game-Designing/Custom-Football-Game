package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p024io.realm.C14048d.C14050b;
import p024io.realm.exceptions.RealmException;
import p024io.realm.exceptions.RealmMigrationNeededException;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.C7344p;
import p024io.realm.internal.C7344p.C7345a;
import p024io.realm.internal.C7347r;
import p024io.realm.internal.LinkView;
import p024io.realm.internal.OsObject;
import p024io.realm.internal.OsObjectSchemaInfo;
import p024io.realm.internal.OsObjectSchemaInfo.C7309a;
import p024io.realm.internal.SharedRealm;
import p024io.realm.internal.Table;
import p024io.realm.log.RealmLog;

/* renamed from: io.realm.f */
/* compiled from: DownloadRealmProxy */
public class C14055f extends Download implements C7344p, C14059g {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42585a = m44855e();

    /* renamed from: b */
    private static final List<String> f42586b;

    /* renamed from: c */
    private C14056a f42587c;

    /* renamed from: d */
    private C13986D<Download> f42588d;

    /* renamed from: e */
    private C14014U<FileToDownload> f42589e;

    /* renamed from: io.realm.f$a */
    /* compiled from: DownloadRealmProxy */
    static final class C14056a extends C7327c {

        /* renamed from: c */
        long f42590c;

        /* renamed from: d */
        long f42591d;

        /* renamed from: e */
        long f42592e;

        /* renamed from: f */
        long f42593f;

        /* renamed from: g */
        long f42594g;

        /* renamed from: h */
        long f42595h;

        /* renamed from: i */
        long f42596i;

        /* renamed from: j */
        long f42597j;

        /* renamed from: k */
        long f42598k;

        /* renamed from: l */
        long f42599l;

        /* renamed from: m */
        long f42600m;

        /* renamed from: n */
        long f42601n;

        /* renamed from: o */
        long f42602o;

        /* renamed from: p */
        long f42603p;

        /* renamed from: q */
        long f42604q;

        C14056a(SharedRealm realm, Table table) {
            super(15);
            this.f42590c = mo23757a(table, "filesToDownload", RealmFieldType.LIST);
            this.f42591d = mo23757a(table, "overallDownloadStatus", RealmFieldType.INTEGER);
            this.f42592e = mo23757a(table, "overallProgress", RealmFieldType.INTEGER);
            this.f42593f = mo23757a(table, "md5", RealmFieldType.STRING);
            this.f42594g = mo23757a(table, "appName", RealmFieldType.STRING);
            this.f42595h = mo23757a(table, C11307Ea.ICON, RealmFieldType.STRING);
            this.f42596i = mo23757a(table, "timeStamp", RealmFieldType.INTEGER);
            this.f42597j = mo23757a(table, "downloadSpeed", RealmFieldType.INTEGER);
            this.f42598k = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42599l = mo23757a(table, "versionCode", RealmFieldType.INTEGER);
            this.f42600m = mo23757a(table, "action", RealmFieldType.INTEGER);
            this.f42601n = mo23757a(table, Installed.VERSION_NAME, RealmFieldType.STRING);
            this.f42602o = mo23757a(table, "hasAppc", RealmFieldType.BOOLEAN);
            this.f42603p = mo23757a(table, "size", RealmFieldType.INTEGER);
            this.f42604q = mo23757a(table, "downloadError", RealmFieldType.INTEGER);
        }

        C14056a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14056a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14056a src = (C14056a) rawSrc;
            C14056a dst = (C14056a) rawDst;
            dst.f42590c = src.f42590c;
            dst.f42591d = src.f42591d;
            dst.f42592e = src.f42592e;
            dst.f42593f = src.f42593f;
            dst.f42594g = src.f42594g;
            dst.f42595h = src.f42595h;
            dst.f42596i = src.f42596i;
            dst.f42597j = src.f42597j;
            dst.f42598k = src.f42598k;
            dst.f42599l = src.f42599l;
            dst.f42600m = src.f42600m;
            dst.f42601n = src.f42601n;
            dst.f42602o = src.f42602o;
            dst.f42603p = src.f42603p;
            dst.f42604q = src.f42604q;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("filesToDownload");
        fieldNames.add("overallDownloadStatus");
        fieldNames.add("overallProgress");
        fieldNames.add("md5");
        fieldNames.add("appName");
        fieldNames.add(C11307Ea.ICON);
        fieldNames.add("timeStamp");
        fieldNames.add("downloadSpeed");
        fieldNames.add("packageName");
        fieldNames.add("versionCode");
        fieldNames.add("action");
        fieldNames.add(Installed.VERSION_NAME);
        fieldNames.add("hasAppc");
        fieldNames.add("size");
        fieldNames.add("downloadError");
        f42586b = Collections.unmodifiableList(fieldNames);
    }

    C14055f() {
        this.f42588d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42588d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42587c = (C14056a) context.mo43700c();
            this.f42588d = new C13986D<>(this);
            this.f42588d.mo43507a(context.mo43702e());
            this.f42588d.mo43513b(context.mo43703f());
            this.f42588d.mo43509a(context.mo43699b());
            this.f42588d.mo43508a(context.mo43701d());
        }
    }

    public C14014U<FileToDownload> realmGet$filesToDownload() {
        this.f42588d.mo43514c().mo43690d();
        C14014U<FileToDownload> u = this.f42589e;
        if (u != null) {
            return u;
        }
        this.f42589e = new C14014U<>(FileToDownload.class, this.f42588d.mo43515d().mo23710f(this.f42587c.f42590c), this.f42588d.mo43514c());
        return this.f42589e;
    }

    public void realmSet$filesToDownload(C14014U<FileToDownload> value) {
        if (this.f42588d.mo43517f()) {
            if (!this.f42588d.mo43510a() || this.f42588d.mo43511b().contains("filesToDownload")) {
                return;
            }
            if (value != null && !value.mo43600a()) {
                C13990F realm = (C13990F) this.f42588d.mo43514c();
                C14014U<FileToDownload> u = value;
                value = new C14014U<>();
                Iterator it = u.iterator();
                while (it.hasNext()) {
                    FileToDownload item = (FileToDownload) it.next();
                    if (item == null || C0106Z.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.mo43536b(item));
                    }
                }
            }
        }
        this.f42588d.mo43514c().mo43690d();
        LinkView links = this.f42588d.mo43515d().mo23710f(this.f42587c.f42590c);
        links.mo23586a();
        if (value != null) {
            Iterator it2 = value.iterator();
            while (it2.hasNext()) {
                C0105Y linkedObject = (C0105Y) it2.next();
                if (!C0106Z.isManaged(linkedObject) || !C0106Z.isValid(linkedObject)) {
                    throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
                } else if (((C7344p) linkedObject).mo23791a().mo43514c() == this.f42588d.mo43514c()) {
                    links.mo23587a(((C7344p) linkedObject).mo23791a().mo43515d().getIndex());
                } else {
                    throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
                }
            }
        }
    }

    public int realmGet$overallDownloadStatus() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42591d);
    }

    public void realmSet$overallDownloadStatus(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42591d, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42591d, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$overallProgress() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42592e);
    }

    public void realmSet$overallProgress(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42592e, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42592e, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$md5() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23720m(this.f42587c.f42593f);
    }

    public void realmSet$md5(String value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'md5' cannot be changed after object was created.");
        }
    }

    public String realmGet$appName() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23720m(this.f42587c.f42594g);
    }

    public void realmSet$appName(String value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            if (value == null) {
                this.f42588d.mo43515d().mo23512b(this.f42587c.f42594g);
            } else {
                this.f42588d.mo43515d().setString(this.f42587c.f42594g, value);
            }
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42587c.f42594g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42587c.f42594g, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$Icon() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23720m(this.f42587c.f42595h);
    }

    public void realmSet$Icon(String value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            if (value == null) {
                this.f42588d.mo43515d().mo23512b(this.f42587c.f42595h);
            } else {
                this.f42588d.mo43515d().setString(this.f42587c.f42595h, value);
            }
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42587c.f42595h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42587c.f42595h, row.getIndex(), value, true);
            }
        }
    }

    public long realmGet$timeStamp() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23716h(this.f42587c.f42596i);
    }

    public void realmSet$timeStamp(long value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42596i, value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42596i, row.getIndex(), value, true);
        }
    }

    public int realmGet$downloadSpeed() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42597j);
    }

    public void realmSet$downloadSpeed(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42597j, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42597j, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$packageName() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23720m(this.f42587c.f42598k);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            if (value == null) {
                this.f42588d.mo43515d().mo23512b(this.f42587c.f42598k);
            } else {
                this.f42588d.mo43515d().setString(this.f42587c.f42598k, value);
            }
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42587c.f42598k, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42587c.f42598k, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$versionCode() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42599l);
    }

    public void realmSet$versionCode(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42599l, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42599l, row.getIndex(), (long) value, true);
        }
    }

    public int realmGet$action() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42600m);
    }

    public void realmSet$action(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42600m, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42600m, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$versionName() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23720m(this.f42587c.f42601n);
    }

    public void realmSet$versionName(String value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            if (value == null) {
                this.f42588d.mo43515d().mo23512b(this.f42587c.f42601n);
            } else {
                this.f42588d.mo43515d().setString(this.f42587c.f42601n, value);
            }
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42587c.f42601n, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42587c.f42601n, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$hasAppc() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23712g(this.f42587c.f42602o);
    }

    public void realmSet$hasAppc(boolean value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23703a(this.f42587c.f42602o, value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23653a(this.f42587c.f42602o, row.getIndex(), value, true);
        }
    }

    public long realmGet$size() {
        this.f42588d.mo43514c().mo43690d();
        return this.f42588d.mo43515d().mo23716h(this.f42587c.f42603p);
    }

    public void realmSet$size(long value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42603p, value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42603p, row.getIndex(), value, true);
        }
    }

    public int realmGet$downloadError() {
        this.f42588d.mo43514c().mo43690d();
        return (int) this.f42588d.mo43515d().mo23716h(this.f42587c.f42604q);
    }

    public void realmSet$downloadError(int value) {
        if (!this.f42588d.mo43517f()) {
            this.f42588d.mo43514c().mo43690d();
            this.f42588d.mo43515d().mo23705b(this.f42587c.f42604q, (long) value);
        } else if (this.f42588d.mo43510a()) {
            C7347r row = this.f42588d.mo43515d();
            row.mo23711f().mo23649a(this.f42587c.f42604q, row.getIndex(), (long) value, true);
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44855e() {
        C7309a builder = new C7309a("Download");
        builder.mo23604a("filesToDownload", RealmFieldType.LIST, "FileToDownload");
        C7309a aVar = builder;
        aVar.mo23605a("overallDownloadStatus", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("overallProgress", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("md5", RealmFieldType.STRING, true, true, false);
        aVar.mo23605a("appName", RealmFieldType.STRING, false, false, false);
        aVar.mo23605a(C11307Ea.ICON, RealmFieldType.STRING, false, false, false);
        aVar.mo23605a("timeStamp", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("downloadSpeed", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("packageName", RealmFieldType.STRING, false, false, false);
        aVar.mo23605a("versionCode", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("action", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a(Installed.VERSION_NAME, RealmFieldType.STRING, false, false, false);
        aVar.mo23605a("hasAppc", RealmFieldType.BOOLEAN, false, false, true);
        aVar.mo23605a("size", RealmFieldType.INTEGER, false, false, true);
        aVar.mo23605a("downloadError", RealmFieldType.INTEGER, false, false, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44853c() {
        return f42585a;
    }

    /* renamed from: a */
    public static C14056a m44850a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Download";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 15) {
                if (columnCount < 15) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 15 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 15 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 15 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14056a columnInfo = new C14056a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'md5' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42593f) {
                String str2 = "filesToDownload";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'filesToDownload'");
                } else if (columnTypes.get(str2) == RealmFieldType.LIST) {
                    String str3 = "class_FileToDownload";
                    if (sharedRealm.mo23625c(str3)) {
                        Table table_0 = sharedRealm.mo23622b(str3);
                        if (table.mo23670h(columnInfo.f42590c).mo23654a(table_0)) {
                            String str4 = "overallDownloadStatus";
                            if (!columnTypes.containsKey(str4)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'overallDownloadStatus' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str4) != RealmFieldType.INTEGER) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'overallDownloadStatus' in existing Realm file.");
                            } else if (!table.mo23678l(columnInfo.f42591d)) {
                                String str5 = "overallProgress";
                                if (!columnTypes.containsKey(str5)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'overallProgress' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str5) != RealmFieldType.INTEGER) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'overallProgress' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42592e)) {
                                    String str6 = "md5";
                                    if (!columnTypes.containsKey(str6)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'md5' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'md5' in existing Realm file.");
                                    } else if (!table.mo23678l(columnInfo.f42593f)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'md5' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                                    } else if (table.mo23677k(table.mo23656b(str6))) {
                                        String str7 = "appName";
                                        if (!columnTypes.containsKey(str7)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'appName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'appName' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42594g)) {
                                            String str8 = C11307Ea.ICON;
                                            if (!columnTypes.containsKey(str8)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'Icon' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'Icon' in existing Realm file.");
                                            } else if (table.mo23678l(columnInfo.f42595h)) {
                                                String str9 = "timeStamp";
                                                if (!columnTypes.containsKey(str9)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'timeStamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str9) != RealmFieldType.INTEGER) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'timeStamp' in existing Realm file.");
                                                } else if (!table.mo23678l(columnInfo.f42596i)) {
                                                    String str10 = "downloadSpeed";
                                                    if (!columnTypes.containsKey(str10)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'downloadSpeed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str10) != RealmFieldType.INTEGER) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'downloadSpeed' in existing Realm file.");
                                                    } else if (!table.mo23678l(columnInfo.f42597j)) {
                                                        String str11 = "packageName";
                                                        if (!columnTypes.containsKey(str11)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                                                        } else if (table.mo23678l(columnInfo.f42598k)) {
                                                            String str12 = "versionCode";
                                                            if (!columnTypes.containsKey(str12)) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                            } else if (columnTypes.get(str12) != RealmFieldType.INTEGER) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'versionCode' in existing Realm file.");
                                                            } else if (!table.mo23678l(columnInfo.f42599l)) {
                                                                String str13 = "action";
                                                                if (!columnTypes.containsKey(str13)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'action' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(str13) != RealmFieldType.INTEGER) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'action' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42600m)) {
                                                                    String str14 = Installed.VERSION_NAME;
                                                                    if (!columnTypes.containsKey(str14)) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                    } else if (columnTypes.get(str14) != RealmFieldType.STRING) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'versionName' in existing Realm file.");
                                                                    } else if (!table.mo23678l(columnInfo.f42601n)) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionName' is required. Either set @Required to field 'versionName' or migrate using RealmObjectSchema.setNullable().");
                                                                    } else if (!columnTypes.containsKey("hasAppc")) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'hasAppc' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                    } else if (columnTypes.get("hasAppc") != RealmFieldType.BOOLEAN) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'hasAppc' in existing Realm file.");
                                                                    } else if (table.mo23678l(columnInfo.f42602o)) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'hasAppc' does support null values in the existing Realm file. Use corresponding boxed type for field 'hasAppc' or migrate using RealmObjectSchema.setNullable().");
                                                                    } else if (!columnTypes.containsKey("size")) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'size' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                    } else if (columnTypes.get("size") != RealmFieldType.INTEGER) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'size' in existing Realm file.");
                                                                    } else if (table.mo23678l(columnInfo.f42603p)) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'size' does support null values in the existing Realm file. Use corresponding boxed type for field 'size' or migrate using RealmObjectSchema.setNullable().");
                                                                    } else if (!columnTypes.containsKey("downloadError")) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'downloadError' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                    } else if (columnTypes.get("downloadError") != RealmFieldType.INTEGER) {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'downloadError' in existing Realm file.");
                                                                    } else if (!table.mo23678l(columnInfo.f42604q)) {
                                                                        return columnInfo;
                                                                    } else {
                                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'downloadError' does support null values in the existing Realm file. Use corresponding boxed type for field 'downloadError' or migrate using RealmObjectSchema.setNullable().");
                                                                    }
                                                                } else {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'action' does support null values in the existing Realm file. Use corresponding boxed type for field 'action' or migrate using RealmObjectSchema.setNullable().");
                                                                }
                                                            } else {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'versionCode' or migrate using RealmObjectSchema.setNullable().");
                                                            }
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' is required. Either set @Required to field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'downloadSpeed' does support null values in the existing Realm file. Use corresponding boxed type for field 'downloadSpeed' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'timeStamp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timeStamp' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'Icon' is required. Either set @Required to field 'Icon' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'appName' is required. Either set @Required to field 'appName' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'md5' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'overallProgress' does support null values in the existing Realm file. Use corresponding boxed type for field 'overallProgress' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'overallDownloadStatus' does support null values in the existing Realm file. Use corresponding boxed type for field 'overallDownloadStatus' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            String f3 = sharedRealm.mo23630f();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Invalid RealmList type for field 'filesToDownload': '");
                            sb3.append(table.mo23670h(columnInfo.f42590c).mo23665e());
                            sb3.append("' expected - was '");
                            sb3.append(table_0.mo23665e());
                            sb3.append("'");
                            throw new RealmMigrationNeededException(f3, sb3.toString());
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing class 'class_FileToDownload' for field 'filesToDownload'");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'FileToDownload' for field 'filesToDownload'");
                }
            } else {
                String f4 = sharedRealm.mo23630f();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Primary Key annotation definition was changed, from field ");
                sb4.append(table.mo23667f(table.mo23666f()));
                sb4.append(" to field md5");
                throw new RealmMigrationNeededException(f4, sb4.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Download' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44854d() {
        return "class_Download";
    }

    /* renamed from: b */
    public static Download m44852b(C13990F realm, Download object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        Download download = object;
        Map<C0105Y, C7344p> map = cache;
        if ((download instanceof C7344p) && ((C7344p) download).mo23791a().mo43514c() != null && ((C7344p) download).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((download instanceof C7344p) && ((C7344p) download).mo23791a().mo43514c() != null && ((C7344p) download).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return download;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(download);
            if (cachedRealmObject != null) {
                return (Download) cachedRealmObject;
            }
            Download realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Download.class);
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Download.class), false, Collections.emptyList());
                            realmObject = new C14055f();
                            map.put(download, realmObject);
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
                return m44849a(realm, object, update, cache);
            }
            m44848a(f, realmObject, download, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Download m44849a(C13990F realm, Download newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Download) cachedRealmObject;
        }
        Download realmObject = (Download) realm.mo43528a(Download.class, newObject.realmGet$md5(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14059g realmObjectSource = newObject;
        Download download = realmObject;
        RealmList<FileToDownload> filesToDownloadList = realmObjectSource.realmGet$filesToDownload();
        if (filesToDownloadList != null) {
            RealmList<FileToDownload> filesToDownloadRealmList = download.realmGet$filesToDownload();
            for (int i = 0; i < filesToDownloadList.size(); i++) {
                FileToDownload filesToDownloadItem = (FileToDownload) filesToDownloadList.get(i);
                FileToDownload cachefilesToDownload = (FileToDownload) cache.get(filesToDownloadItem);
                if (cachefilesToDownload != null) {
                    filesToDownloadRealmList.add(cachefilesToDownload);
                } else {
                    filesToDownloadRealmList.add(C14075n.m44962b(realm, filesToDownloadItem, update, cache));
                }
            }
        }
        download.realmSet$overallDownloadStatus(realmObjectSource.realmGet$overallDownloadStatus());
        download.realmSet$overallProgress(realmObjectSource.realmGet$overallProgress());
        download.realmSet$appName(realmObjectSource.realmGet$appName());
        download.realmSet$Icon(realmObjectSource.realmGet$Icon());
        download.realmSet$timeStamp(realmObjectSource.realmGet$timeStamp());
        download.realmSet$downloadSpeed(realmObjectSource.realmGet$downloadSpeed());
        download.realmSet$packageName(realmObjectSource.realmGet$packageName());
        download.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        download.realmSet$action(realmObjectSource.realmGet$action());
        download.realmSet$versionName(realmObjectSource.realmGet$versionName());
        download.realmSet$hasAppc(realmObjectSource.realmGet$hasAppc());
        download.realmSet$size(realmObjectSource.realmGet$size());
        download.realmSet$downloadError(realmObjectSource.realmGet$downloadError());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44846a(C13990F realm, Download object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Download download = object;
        Map<C0105Y, Long> map = cache;
        if ((download instanceof C7344p) && ((C7344p) download).mo23791a().mo43514c() != null && ((C7344p) download).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) download).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Download.class);
        long tableNativePtr = table.getNativePtr();
        C14056a columnInfo = (C14056a) f.f42569h.mo43710a(Download.class);
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
        map.put(download, Long.valueOf(rowIndex2));
        long filesToDownloadNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.f42590c, rowIndex2);
        LinkView.nativeClear(filesToDownloadNativeLinkViewPtr);
        RealmList<FileToDownload> filesToDownloadList = object.realmGet$filesToDownload();
        if (filesToDownloadList != null) {
            Iterator it = filesToDownloadList.iterator();
            while (it.hasNext()) {
                FileToDownload filesToDownloadItem = (FileToDownload) it.next();
                Long cacheItemIndexfilesToDownload = (Long) map.get(filesToDownloadItem);
                if (cacheItemIndexfilesToDownload == null) {
                    cacheItemIndexfilesToDownload = Long.valueOf(C14075n.m44956a(f, filesToDownloadItem, map));
                }
                LinkView.nativeAdd(filesToDownloadNativeLinkViewPtr, cacheItemIndexfilesToDownload.longValue());
                f = realm;
                Download download2 = object;
            }
        }
        long j = tableNativePtr;
        long j2 = filesToDownloadNativeLinkViewPtr;
        long filesToDownloadNativeLinkViewPtr2 = rowIndex2;
        long j3 = pkColumnIndex;
        String str = primaryKeyValue;
        Table.nativeSetLong(j, columnInfo.f42591d, filesToDownloadNativeLinkViewPtr2, (long) object.realmGet$overallDownloadStatus(), false);
        Table.nativeSetLong(j, columnInfo.f42592e, filesToDownloadNativeLinkViewPtr2, (long) object.realmGet$overallProgress(), false);
        String realmGet$appName = object.realmGet$appName();
        if (realmGet$appName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42594g, rowIndex2, realmGet$appName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42594g, rowIndex2, false);
        }
        String realmGet$Icon = object.realmGet$Icon();
        if (realmGet$Icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42595h, rowIndex2, realmGet$Icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42595h, rowIndex2, false);
        }
        long j4 = rowIndex2;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42596i, j4, object.realmGet$timeStamp(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42597j, j4, (long) object.realmGet$downloadSpeed(), false);
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42598k, rowIndex2, realmGet$packageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42598k, rowIndex2, false);
        }
        long j5 = rowIndex2;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42599l, j5, (long) object.realmGet$versionCode(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42600m, j5, (long) object.realmGet$action(), false);
        String realmGet$versionName = object.realmGet$versionName();
        if (realmGet$versionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42601n, rowIndex2, realmGet$versionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42601n, rowIndex2, false);
        }
        long j6 = tableNativePtr;
        long j7 = rowIndex2;
        Table.nativeSetBoolean(j6, columnInfo.f42602o, j7, object.realmGet$hasAppc(), false);
        Table.nativeSetLong(j6, columnInfo.f42603p, j7, object.realmGet$size(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.f42604q, j7, (long) object.realmGet$downloadError(), false);
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44851a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Download.class);
        long tableNativePtr = table.getNativePtr();
        C14056a columnInfo = (C14056a) f.f42569h.mo43710a(Download.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            Download object = (Download) objects.next();
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
                long filesToDownloadNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.f42590c, rowIndex2);
                LinkView.nativeClear(filesToDownloadNativeLinkViewPtr);
                RealmList<FileToDownload> filesToDownloadList = object.realmGet$filesToDownload();
                if (filesToDownloadList != null) {
                    Iterator it = filesToDownloadList.iterator();
                    while (it.hasNext()) {
                        FileToDownload filesToDownloadItem = (FileToDownload) it.next();
                        Long cacheItemIndexfilesToDownload = (Long) map.get(filesToDownloadItem);
                        if (cacheItemIndexfilesToDownload == null) {
                            cacheItemIndexfilesToDownload = Long.valueOf(C14075n.m44956a(f, filesToDownloadItem, map));
                        }
                        LinkView.nativeAdd(filesToDownloadNativeLinkViewPtr, cacheItemIndexfilesToDownload.longValue());
                        f = realm;
                        map = cache;
                    }
                }
                long j = tableNativePtr;
                long j2 = filesToDownloadNativeLinkViewPtr;
                long filesToDownloadNativeLinkViewPtr2 = rowIndex2;
                pkColumnIndex = pkColumnIndex2;
                String str = primaryKeyValue;
                Table.nativeSetLong(j, columnInfo.f42591d, filesToDownloadNativeLinkViewPtr2, (long) object.realmGet$overallDownloadStatus(), false);
                Table.nativeSetLong(j, columnInfo.f42592e, filesToDownloadNativeLinkViewPtr2, (long) object.realmGet$overallProgress(), false);
                String realmGet$appName = object.realmGet$appName();
                if (realmGet$appName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42594g, rowIndex2, realmGet$appName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42594g, rowIndex2, false);
                }
                String realmGet$Icon = object.realmGet$Icon();
                if (realmGet$Icon != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42595h, rowIndex2, realmGet$Icon, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42595h, rowIndex2, false);
                }
                long j3 = rowIndex2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42596i, j3, object.realmGet$timeStamp(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42597j, j3, (long) object.realmGet$downloadSpeed(), false);
                String realmGet$packageName = object.realmGet$packageName();
                if (realmGet$packageName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42598k, rowIndex2, realmGet$packageName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42598k, rowIndex2, false);
                }
                long j4 = rowIndex2;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42599l, j4, (long) object.realmGet$versionCode(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42600m, j4, (long) object.realmGet$action(), false);
                String realmGet$versionName = object.realmGet$versionName();
                if (realmGet$versionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42601n, rowIndex2, realmGet$versionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42601n, rowIndex2, false);
                }
                long j5 = tableNativePtr;
                long j6 = rowIndex2;
                Table.nativeSetBoolean(j5, columnInfo.f42602o, j6, object.realmGet$hasAppc(), false);
                Table.nativeSetLong(j5, columnInfo.f42603p, j6, object.realmGet$size(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.f42604q, j6, (long) object.realmGet$downloadError(), false);
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            f = realm;
            map = cache;
            Download download = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static Download m44847a(Download realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Download unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Download();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Download) cachedObject.f14332b;
        } else {
            unmanagedObject = (Download) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Download download = unmanagedObject;
        C14059g realmSource = realmObject;
        if (currentDepth == maxDepth) {
            download.realmSet$filesToDownload(null);
        } else {
            RealmList<FileToDownload> managedfilesToDownloadList = realmSource.realmGet$filesToDownload();
            RealmList<FileToDownload> unmanagedfilesToDownloadList = new C14014U<>();
            download.realmSet$filesToDownload(unmanagedfilesToDownloadList);
            int nextDepth = currentDepth + 1;
            int size = managedfilesToDownloadList.size();
            for (int i = 0; i < size; i++) {
                unmanagedfilesToDownloadList.add(C14075n.m44957a((FileToDownload) managedfilesToDownloadList.get(i), nextDepth, maxDepth, cache));
            }
        }
        download.realmSet$overallDownloadStatus(realmSource.realmGet$overallDownloadStatus());
        download.realmSet$overallProgress(realmSource.realmGet$overallProgress());
        download.realmSet$md5(realmSource.realmGet$md5());
        download.realmSet$appName(realmSource.realmGet$appName());
        download.realmSet$Icon(realmSource.realmGet$Icon());
        download.realmSet$timeStamp(realmSource.realmGet$timeStamp());
        download.realmSet$downloadSpeed(realmSource.realmGet$downloadSpeed());
        download.realmSet$packageName(realmSource.realmGet$packageName());
        download.realmSet$versionCode(realmSource.realmGet$versionCode());
        download.realmSet$action(realmSource.realmGet$action());
        download.realmSet$versionName(realmSource.realmGet$versionName());
        download.realmSet$hasAppc(realmSource.realmGet$hasAppc());
        download.realmSet$size(realmSource.realmGet$size());
        download.realmSet$downloadError(realmSource.realmGet$downloadError());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Download m44848a(C13990F realm, Download realmObject, Download newObject, Map<C0105Y, C7344p> cache) {
        Download download = realmObject;
        C14059g realmObjectSource = newObject;
        RealmList<FileToDownload> filesToDownloadList = realmObjectSource.realmGet$filesToDownload();
        RealmList<FileToDownload> filesToDownloadRealmList = download.realmGet$filesToDownload();
        filesToDownloadRealmList.clear();
        if (filesToDownloadList != null) {
            for (int i = 0; i < filesToDownloadList.size(); i++) {
                FileToDownload filesToDownloadItem = (FileToDownload) filesToDownloadList.get(i);
                FileToDownload cachefilesToDownload = (FileToDownload) cache.get(filesToDownloadItem);
                if (cachefilesToDownload != null) {
                    filesToDownloadRealmList.add(cachefilesToDownload);
                } else {
                    filesToDownloadRealmList.add(C14075n.m44962b(realm, filesToDownloadItem, true, cache));
                }
            }
        }
        download.realmSet$overallDownloadStatus(realmObjectSource.realmGet$overallDownloadStatus());
        download.realmSet$overallProgress(realmObjectSource.realmGet$overallProgress());
        download.realmSet$appName(realmObjectSource.realmGet$appName());
        download.realmSet$Icon(realmObjectSource.realmGet$Icon());
        download.realmSet$timeStamp(realmObjectSource.realmGet$timeStamp());
        download.realmSet$downloadSpeed(realmObjectSource.realmGet$downloadSpeed());
        download.realmSet$packageName(realmObjectSource.realmGet$packageName());
        download.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        download.realmSet$action(realmObjectSource.realmGet$action());
        download.realmSet$versionName(realmObjectSource.realmGet$versionName());
        download.realmSet$hasAppc(realmObjectSource.realmGet$hasAppc());
        download.realmSet$size(realmObjectSource.realmGet$size());
        download.realmSet$downloadError(realmObjectSource.realmGet$downloadError());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Download = proxy[");
        stringBuilder.append("{filesToDownload:");
        stringBuilder.append("RealmList<FileToDownload>[");
        stringBuilder.append(realmGet$filesToDownload().size());
        String str = "]";
        stringBuilder.append(str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{overallDownloadStatus:");
        stringBuilder.append(realmGet$overallDownloadStatus());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{overallProgress:");
        stringBuilder.append(realmGet$overallProgress());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{md5:");
        String str4 = "null";
        stringBuilder.append(realmGet$md5() != null ? realmGet$md5() : str4);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{appName:");
        stringBuilder.append(realmGet$appName() != null ? realmGet$appName() : str4);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{Icon:");
        stringBuilder.append(realmGet$Icon() != null ? realmGet$Icon() : str4);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{timeStamp:");
        stringBuilder.append(realmGet$timeStamp());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{downloadSpeed:");
        stringBuilder.append(realmGet$downloadSpeed());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{packageName:");
        stringBuilder.append(realmGet$packageName() != null ? realmGet$packageName() : str4);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{versionCode:");
        stringBuilder.append(realmGet$versionCode());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{action:");
        stringBuilder.append(realmGet$action());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{versionName:");
        if (realmGet$versionName() != null) {
            str4 = realmGet$versionName();
        }
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{hasAppc:");
        stringBuilder.append(realmGet$hasAppc());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{size:");
        stringBuilder.append(realmGet$size());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{downloadError:");
        stringBuilder.append(realmGet$downloadError());
        stringBuilder.append(str2);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42588d;
    }
}
