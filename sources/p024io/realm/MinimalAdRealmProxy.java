package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p024io.realm.C14048d.C14050b;
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

/* renamed from: io.realm.MinimalAdRealmProxy */
public class MinimalAdRealmProxy extends MinimalAd implements C7344p, C14089v {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42444a = m44633e();

    /* renamed from: b */
    private static final List<String> f42445b;

    /* renamed from: c */
    private C14005a f42446c;

    /* renamed from: d */
    private C13986D<MinimalAd> f42447d;

    /* renamed from: io.realm.MinimalAdRealmProxy$a */
    static final class C14005a extends C7327c {

        /* renamed from: c */
        long f42448c;

        /* renamed from: d */
        long f42449d;

        /* renamed from: e */
        long f42450e;

        /* renamed from: f */
        long f42451f;

        /* renamed from: g */
        long f42452g;

        /* renamed from: h */
        long f42453h;

        /* renamed from: i */
        long f42454i;

        /* renamed from: j */
        long f42455j;

        /* renamed from: k */
        long f42456k;

        /* renamed from: l */
        long f42457l;

        /* renamed from: m */
        long f42458m;

        /* renamed from: n */
        long f42459n;

        /* renamed from: o */
        long f42460o;

        /* renamed from: p */
        long f42461p;

        C14005a(SharedRealm realm, Table table) {
            super(14);
            this.f42448c = mo23757a(table, "cpdUrl", RealmFieldType.STRING);
            this.f42449d = mo23757a(table, Repo.COLUMN_DESCRIPTION, RealmFieldType.STRING);
            this.f42450e = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42451f = mo23757a(table, "networkId", RealmFieldType.INTEGER);
            this.f42452g = mo23757a(table, "clickUrl", RealmFieldType.STRING);
            this.f42453h = mo23757a(table, "cpcUrl", RealmFieldType.STRING);
            this.f42454i = mo23757a(table, "appId", RealmFieldType.INTEGER);
            this.f42455j = mo23757a(table, "adId", RealmFieldType.INTEGER);
            this.f42456k = mo23757a(table, StoredMinimalAd.CPI_URL, RealmFieldType.STRING);
            this.f42457l = mo23757a(table, "name", RealmFieldType.STRING);
            this.f42458m = mo23757a(table, Store.ICON_PATH, RealmFieldType.STRING);
            this.f42459n = mo23757a(table, "downloads", RealmFieldType.INTEGER);
            this.f42460o = mo23757a(table, "stars", RealmFieldType.INTEGER);
            this.f42461p = mo23757a(table, "modified", RealmFieldType.INTEGER);
        }

        C14005a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14005a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14005a src = (C14005a) rawSrc;
            C14005a dst = (C14005a) rawDst;
            dst.f42448c = src.f42448c;
            dst.f42449d = src.f42449d;
            dst.f42450e = src.f42450e;
            dst.f42451f = src.f42451f;
            dst.f42452g = src.f42452g;
            dst.f42453h = src.f42453h;
            dst.f42454i = src.f42454i;
            dst.f42455j = src.f42455j;
            dst.f42456k = src.f42456k;
            dst.f42457l = src.f42457l;
            dst.f42458m = src.f42458m;
            dst.f42459n = src.f42459n;
            dst.f42460o = src.f42460o;
            dst.f42461p = src.f42461p;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("cpdUrl");
        fieldNames.add(Repo.COLUMN_DESCRIPTION);
        fieldNames.add("packageName");
        fieldNames.add("networkId");
        fieldNames.add("clickUrl");
        fieldNames.add("cpcUrl");
        fieldNames.add("appId");
        fieldNames.add("adId");
        fieldNames.add(StoredMinimalAd.CPI_URL);
        fieldNames.add("name");
        fieldNames.add(Store.ICON_PATH);
        fieldNames.add("downloads");
        fieldNames.add("stars");
        fieldNames.add("modified");
        f42445b = Collections.unmodifiableList(fieldNames);
    }

    MinimalAdRealmProxy() {
        this.f42447d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42447d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42446c = (C14005a) context.mo43700c();
            this.f42447d = new C13986D<>(this);
            this.f42447d.mo43507a(context.mo43702e());
            this.f42447d.mo43513b(context.mo43703f());
            this.f42447d.mo43509a(context.mo43699b());
            this.f42447d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$cpdUrl() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42448c);
    }

    public void realmSet$cpdUrl(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42448c);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42448c, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42448c, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42448c, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$description() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42449d);
    }

    public void realmSet$description(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42449d);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42449d, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42449d, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42449d, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$packageName() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42450e);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42450e);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42450e, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42450e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42450e, row.getIndex(), value, true);
            }
        }
    }

    public Long realmGet$networkId() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42451f)) {
            return null;
        }
        return Long.valueOf(this.f42447d.mo43515d().mo23716h(this.f42446c.f42451f));
    }

    public void realmSet$networkId(Long value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42451f);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42451f, value.longValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42451f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42451f, row.getIndex(), value.longValue(), true);
            }
        }
    }

    public String realmGet$clickUrl() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42452g);
    }

    public void realmSet$clickUrl(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42452g);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42452g, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42452g, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42452g, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$cpcUrl() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42453h);
    }

    public void realmSet$cpcUrl(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42453h);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42453h, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42453h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42453h, row.getIndex(), value, true);
            }
        }
    }

    public Long realmGet$appId() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42454i)) {
            return null;
        }
        return Long.valueOf(this.f42447d.mo43515d().mo23716h(this.f42446c.f42454i));
    }

    public void realmSet$appId(Long value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42454i);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42454i, value.longValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42454i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42454i, row.getIndex(), value.longValue(), true);
            }
        }
    }

    public Long realmGet$adId() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42455j)) {
            return null;
        }
        return Long.valueOf(this.f42447d.mo43515d().mo23716h(this.f42446c.f42455j));
    }

    public void realmSet$adId(Long value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42455j);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42455j, value.longValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42455j, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42455j, row.getIndex(), value.longValue(), true);
            }
        }
    }

    public String realmGet$cpiUrl() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42456k);
    }

    public void realmSet$cpiUrl(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42456k);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42456k, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42456k, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42456k, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$name() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42457l);
    }

    public void realmSet$name(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42457l);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42457l, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42457l, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42457l, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$iconPath() {
        this.f42447d.mo43514c().mo43690d();
        return this.f42447d.mo43515d().mo23720m(this.f42446c.f42458m);
    }

    public void realmSet$iconPath(String value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42458m);
            } else {
                this.f42447d.mo43515d().setString(this.f42446c.f42458m, value);
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42458m, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42446c.f42458m, row.getIndex(), value, true);
            }
        }
    }

    public Integer realmGet$downloads() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42459n)) {
            return null;
        }
        return Integer.valueOf((int) this.f42447d.mo43515d().mo23716h(this.f42446c.f42459n));
    }

    public void realmSet$downloads(Integer value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42459n);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42459n, (long) value.intValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42459n, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42459n, row.getIndex(), (long) value.intValue(), true);
            }
        }
    }

    public Integer realmGet$stars() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42460o)) {
            return null;
        }
        return Integer.valueOf((int) this.f42447d.mo43515d().mo23716h(this.f42446c.f42460o));
    }

    public void realmSet$stars(Integer value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42460o);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42460o, (long) value.intValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42460o, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42460o, row.getIndex(), (long) value.intValue(), true);
            }
        }
    }

    public Long realmGet$modified() {
        this.f42447d.mo43514c().mo43690d();
        if (this.f42447d.mo43515d().mo23511a(this.f42446c.f42461p)) {
            return null;
        }
        return Long.valueOf(this.f42447d.mo43515d().mo23716h(this.f42446c.f42461p));
    }

    public void realmSet$modified(Long value) {
        if (!this.f42447d.mo43517f()) {
            this.f42447d.mo43514c().mo43690d();
            if (value == null) {
                this.f42447d.mo43515d().mo23512b(this.f42446c.f42461p);
            } else {
                this.f42447d.mo43515d().mo23705b(this.f42446c.f42461p, value.longValue());
            }
        } else if (this.f42447d.mo43510a()) {
            C7347r row = this.f42447d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42446c.f42461p, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42446c.f42461p, row.getIndex(), value.longValue(), true);
            }
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44633e() {
        C7309a builder = new C7309a("MinimalAd");
        builder.mo23605a("cpdUrl", RealmFieldType.STRING, false, false, false);
        C7309a aVar = builder;
        aVar.mo23605a(Repo.COLUMN_DESCRIPTION, RealmFieldType.STRING, false, false, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("packageName", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("networkId", RealmFieldType.INTEGER, false, false, false);
        aVar2.mo23605a("clickUrl", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("cpcUrl", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("appId", RealmFieldType.INTEGER, false, false, false);
        aVar3.mo23605a("adId", RealmFieldType.INTEGER, false, false, false);
        aVar2.mo23605a(StoredMinimalAd.CPI_URL, RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("name", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(Store.ICON_PATH, RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("downloads", RealmFieldType.INTEGER, false, false, false);
        aVar2.mo23605a("stars", RealmFieldType.INTEGER, false, false, false);
        aVar3.mo23605a("modified", RealmFieldType.INTEGER, false, false, false);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44631c() {
        return f42444a;
    }

    /* renamed from: a */
    public static C14005a m44628a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_MinimalAd";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 14) {
                if (columnCount < 14) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 14 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 14 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 14 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14005a columnInfo = new C14005a(sharedRealm, table);
            if (!table.mo23671h()) {
                String str2 = "cpdUrl";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpdUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpdUrl' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42448c)) {
                    String str3 = Repo.COLUMN_DESCRIPTION;
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'description' in existing Realm file.");
                    } else if (table.mo23678l(columnInfo.f42449d)) {
                        String str4 = "packageName";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42450e)) {
                            String str5 = "networkId";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'networkId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.INTEGER) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'networkId' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42451f)) {
                                String str6 = "clickUrl";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'clickUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.STRING) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'clickUrl' in existing Realm file.");
                                } else if (table.mo23678l(columnInfo.f42452g)) {
                                    String str7 = "cpcUrl";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpcUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpcUrl' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42453h)) {
                                        String str8 = "appId";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'appId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.INTEGER) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'appId' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42454i)) {
                                            String str9 = "adId";
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'adId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.INTEGER) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'adId' in existing Realm file.");
                                            } else if (table.mo23678l(columnInfo.f42455j)) {
                                                String str10 = StoredMinimalAd.CPI_URL;
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'cpiUrl' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.STRING) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'cpiUrl' in existing Realm file.");
                                                } else if (table.mo23678l(columnInfo.f42456k)) {
                                                    String str11 = "name";
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'name' in existing Realm file.");
                                                    } else if (table.mo23678l(columnInfo.f42457l)) {
                                                        String str12 = Store.ICON_PATH;
                                                        if (!columnTypes.containsKey(str12)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'iconPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str12) != RealmFieldType.STRING) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'iconPath' in existing Realm file.");
                                                        } else if (table.mo23678l(columnInfo.f42458m)) {
                                                            String str13 = "downloads";
                                                            if (!columnTypes.containsKey(str13)) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'downloads' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                            } else if (columnTypes.get(str13) != RealmFieldType.INTEGER) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Integer' for field 'downloads' in existing Realm file.");
                                                            } else if (table.mo23678l(columnInfo.f42459n)) {
                                                                String str14 = "stars";
                                                                if (!columnTypes.containsKey(str14)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'stars' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(str14) != RealmFieldType.INTEGER) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Integer' for field 'stars' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42460o)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'stars' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'stars' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("modified")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'modified' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("modified") != RealmFieldType.INTEGER) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'modified' in existing Realm file.");
                                                                } else if (table.mo23678l(columnInfo.f42461p)) {
                                                                    return columnInfo;
                                                                } else {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'modified' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'modified' or migrate using RealmObjectSchema.setNullable().");
                                                                }
                                                            } else {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'downloads' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'downloads' or migrate using RealmObjectSchema.setNullable().");
                                                            }
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'iconPath' is required. Either set @Required to field 'iconPath' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpiUrl' is required. Either set @Required to field 'cpiUrl' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'adId' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'adId' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'appId' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'appId' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpcUrl' is required. Either set @Required to field 'cpcUrl' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'clickUrl' is required. Either set @Required to field 'clickUrl' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'networkId' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'networkId' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'packageName' is required. Either set @Required to field 'packageName' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'cpdUrl' is required. Either set @Required to field 'cpdUrl' or migrate using RealmObjectSchema.setNullable().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key defined for field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" was removed.");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'MinimalAd' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44632d() {
        return "class_MinimalAd";
    }

    /* renamed from: b */
    public static MinimalAd m44630b(C13990F realm, MinimalAd object, boolean update, Map<C0105Y, C7344p> cache) {
        if ((object instanceof C7344p) && ((C7344p) object).mo23791a().mo43514c() != null && ((C7344p) object).mo23791a().mo43514c().f42565d != realm.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((object instanceof C7344p) && ((C7344p) object).mo23791a().mo43514c() != null && ((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return object;
        } else {
            Object obj = C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) cache.get(object);
            if (cachedRealmObject != null) {
                return (MinimalAd) cachedRealmObject;
            }
            return m44627a(realm, object, update, cache);
        }
    }

    /* renamed from: a */
    public static MinimalAd m44627a(C13990F realm, MinimalAd newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (MinimalAd) cachedRealmObject;
        }
        MinimalAd realmObject = (MinimalAd) realm.mo43529a(MinimalAd.class, false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14089v realmObjectSource = newObject;
        MinimalAd minimalAd = realmObject;
        minimalAd.realmSet$cpdUrl(realmObjectSource.realmGet$cpdUrl());
        minimalAd.realmSet$description(realmObjectSource.realmGet$description());
        minimalAd.realmSet$packageName(realmObjectSource.realmGet$packageName());
        minimalAd.realmSet$networkId(realmObjectSource.realmGet$networkId());
        minimalAd.realmSet$clickUrl(realmObjectSource.realmGet$clickUrl());
        minimalAd.realmSet$cpcUrl(realmObjectSource.realmGet$cpcUrl());
        minimalAd.realmSet$appId(realmObjectSource.realmGet$appId());
        minimalAd.realmSet$adId(realmObjectSource.realmGet$adId());
        minimalAd.realmSet$cpiUrl(realmObjectSource.realmGet$cpiUrl());
        minimalAd.realmSet$name(realmObjectSource.realmGet$name());
        minimalAd.realmSet$iconPath(realmObjectSource.realmGet$iconPath());
        minimalAd.realmSet$downloads(realmObjectSource.realmGet$downloads());
        minimalAd.realmSet$stars(realmObjectSource.realmGet$stars());
        minimalAd.realmSet$modified(realmObjectSource.realmGet$modified());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44625a(C13990F realm, MinimalAd object, Map<C0105Y, Long> cache) {
        C13990F f = realm;
        MinimalAd minimalAd = object;
        if ((minimalAd instanceof C7344p) && ((C7344p) minimalAd).mo23791a().mo43514c() != null && ((C7344p) minimalAd).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) minimalAd).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(MinimalAd.class);
        long tableNativePtr = table.getNativePtr();
        C14005a columnInfo = (C14005a) f.f42569h.mo43710a(MinimalAd.class);
        long rowIndex = OsObject.m15911b(table);
        cache.put(minimalAd, Long.valueOf(rowIndex));
        String realmGet$cpdUrl = object.realmGet$cpdUrl();
        if (realmGet$cpdUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42448c, rowIndex, realmGet$cpdUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42448c, rowIndex, false);
        }
        String realmGet$description = object.realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42449d, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42449d, rowIndex, false);
        }
        String realmGet$packageName = object.realmGet$packageName();
        if (realmGet$packageName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42450e, rowIndex, realmGet$packageName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42450e, rowIndex, false);
        }
        Long realmGet$networkId = object.realmGet$networkId();
        if (realmGet$networkId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42451f, rowIndex, realmGet$networkId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42451f, rowIndex, false);
        }
        String realmGet$clickUrl = object.realmGet$clickUrl();
        if (realmGet$clickUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42452g, rowIndex, realmGet$clickUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42452g, rowIndex, false);
        }
        String realmGet$cpcUrl = object.realmGet$cpcUrl();
        if (realmGet$cpcUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42453h, rowIndex, realmGet$cpcUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42453h, rowIndex, false);
        }
        Long realmGet$appId = object.realmGet$appId();
        if (realmGet$appId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42454i, rowIndex, realmGet$appId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42454i, rowIndex, false);
        }
        Long realmGet$adId = object.realmGet$adId();
        if (realmGet$adId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42455j, rowIndex, realmGet$adId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42455j, rowIndex, false);
        }
        String realmGet$cpiUrl = object.realmGet$cpiUrl();
        if (realmGet$cpiUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42456k, rowIndex, realmGet$cpiUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42456k, rowIndex, false);
        }
        String realmGet$name = object.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42457l, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42457l, rowIndex, false);
        }
        String realmGet$iconPath = object.realmGet$iconPath();
        if (realmGet$iconPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42458m, rowIndex, realmGet$iconPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42458m, rowIndex, false);
        }
        Integer realmGet$downloads = object.realmGet$downloads();
        if (realmGet$downloads != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42459n, rowIndex, realmGet$downloads.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42459n, rowIndex, false);
        }
        Integer realmGet$stars = object.realmGet$stars();
        if (realmGet$stars != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42460o, rowIndex, realmGet$stars.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42460o, rowIndex, false);
        }
        Long realmGet$modified = object.realmGet$modified();
        if (realmGet$modified != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.f42461p, rowIndex, realmGet$modified.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42461p, rowIndex, false);
        }
        return rowIndex;
    }

    /* renamed from: a */
    public static void m44629a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(MinimalAd.class);
        long tableNativePtr = table.getNativePtr();
        C14005a columnInfo = (C14005a) f.f42569h.mo43710a(MinimalAd.class);
        while (objects.hasNext()) {
            MinimalAd object = (MinimalAd) objects.next();
            if (!map.containsKey(object)) {
                if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                    long rowIndex = OsObject.m15911b(table);
                    map.put(object, Long.valueOf(rowIndex));
                    String realmGet$cpdUrl = object.realmGet$cpdUrl();
                    if (realmGet$cpdUrl != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42448c, rowIndex, realmGet$cpdUrl, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42448c, rowIndex, false);
                    }
                    String realmGet$description = object.realmGet$description();
                    if (realmGet$description != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42449d, rowIndex, realmGet$description, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42449d, rowIndex, false);
                    }
                    String realmGet$packageName = object.realmGet$packageName();
                    if (realmGet$packageName != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42450e, rowIndex, realmGet$packageName, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42450e, rowIndex, false);
                    }
                    Long realmGet$networkId = object.realmGet$networkId();
                    if (realmGet$networkId != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42451f, rowIndex, realmGet$networkId.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42451f, rowIndex, false);
                    }
                    String realmGet$clickUrl = object.realmGet$clickUrl();
                    if (realmGet$clickUrl != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42452g, rowIndex, realmGet$clickUrl, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42452g, rowIndex, false);
                    }
                    String realmGet$cpcUrl = object.realmGet$cpcUrl();
                    if (realmGet$cpcUrl != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42453h, rowIndex, realmGet$cpcUrl, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42453h, rowIndex, false);
                    }
                    Long realmGet$appId = object.realmGet$appId();
                    if (realmGet$appId != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42454i, rowIndex, realmGet$appId.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42454i, rowIndex, false);
                    }
                    Long realmGet$adId = object.realmGet$adId();
                    if (realmGet$adId != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42455j, rowIndex, realmGet$adId.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42455j, rowIndex, false);
                    }
                    String realmGet$cpiUrl = object.realmGet$cpiUrl();
                    if (realmGet$cpiUrl != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42456k, rowIndex, realmGet$cpiUrl, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42456k, rowIndex, false);
                    }
                    String realmGet$name = object.realmGet$name();
                    if (realmGet$name != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42457l, rowIndex, realmGet$name, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42457l, rowIndex, false);
                    }
                    String realmGet$iconPath = object.realmGet$iconPath();
                    if (realmGet$iconPath != null) {
                        Table.nativeSetString(tableNativePtr, columnInfo.f42458m, rowIndex, realmGet$iconPath, false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42458m, rowIndex, false);
                    }
                    Integer realmGet$downloads = object.realmGet$downloads();
                    if (realmGet$downloads != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42459n, rowIndex, realmGet$downloads.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42459n, rowIndex, false);
                    }
                    Integer realmGet$stars = object.realmGet$stars();
                    if (realmGet$stars != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42460o, rowIndex, realmGet$stars.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42460o, rowIndex, false);
                    }
                    Long realmGet$modified = object.realmGet$modified();
                    if (realmGet$modified != null) {
                        Table.nativeSetLong(tableNativePtr, columnInfo.f42461p, rowIndex, realmGet$modified.longValue(), false);
                    } else {
                        Table.nativeSetNull(tableNativePtr, columnInfo.f42461p, rowIndex, false);
                    }
                } else {
                    map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                }
            }
            MinimalAd minimalAd = object;
        }
    }

    /* renamed from: a */
    public static MinimalAd m44626a(MinimalAd realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        MinimalAd unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new MinimalAd();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (MinimalAd) cachedObject.f14332b;
        } else {
            unmanagedObject = (MinimalAd) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        MinimalAd minimalAd = unmanagedObject;
        C14089v realmSource = realmObject;
        minimalAd.realmSet$cpdUrl(realmSource.realmGet$cpdUrl());
        minimalAd.realmSet$description(realmSource.realmGet$description());
        minimalAd.realmSet$packageName(realmSource.realmGet$packageName());
        minimalAd.realmSet$networkId(realmSource.realmGet$networkId());
        minimalAd.realmSet$clickUrl(realmSource.realmGet$clickUrl());
        minimalAd.realmSet$cpcUrl(realmSource.realmGet$cpcUrl());
        minimalAd.realmSet$appId(realmSource.realmGet$appId());
        minimalAd.realmSet$adId(realmSource.realmGet$adId());
        minimalAd.realmSet$cpiUrl(realmSource.realmGet$cpiUrl());
        minimalAd.realmSet$name(realmSource.realmGet$name());
        minimalAd.realmSet$iconPath(realmSource.realmGet$iconPath());
        minimalAd.realmSet$downloads(realmSource.realmGet$downloads());
        minimalAd.realmSet$stars(realmSource.realmGet$stars());
        minimalAd.realmSet$modified(realmSource.realmGet$modified());
        return unmanagedObject;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r4v39, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r4v46 */
    /* JADX WARNING: type inference failed for: r4v47, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v48 */
    /* JADX WARNING: type inference failed for: r4v49, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r4v54 */
    /* JADX WARNING: type inference failed for: r4v55, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r4v60 */
    /* JADX WARNING: type inference failed for: r4v61 */
    /* JADX WARNING: type inference failed for: r4v65 */
    /* JADX WARNING: type inference failed for: r4v66 */
    /* JADX WARNING: type inference failed for: r4v69 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
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
            java.lang.String r1 = "MinimalAd = proxy["
            r0.<init>(r1)
            java.lang.String r1 = "{cpdUrl:"
            r0.append(r1)
            java.lang.String r1 = r5.realmGet$cpdUrl()
            java.lang.String r2 = "null"
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r5.realmGet$cpdUrl()
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            r0.append(r1)
            java.lang.String r1 = "}"
            r0.append(r1)
            java.lang.String r3 = ","
            r0.append(r3)
            java.lang.String r4 = "{description:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$description()
            if (r4 == 0) goto L_0x0040
            java.lang.String r4 = r5.realmGet$description()
            goto L_0x0041
        L_0x0040:
            r4 = r2
        L_0x0041:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{packageName:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$packageName()
            if (r4 == 0) goto L_0x005a
            java.lang.String r4 = r5.realmGet$packageName()
            goto L_0x005b
        L_0x005a:
            r4 = r2
        L_0x005b:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{networkId:"
            r0.append(r4)
            java.lang.Long r4 = r5.realmGet$networkId()
            if (r4 == 0) goto L_0x0074
            java.lang.Long r4 = r5.realmGet$networkId()
            goto L_0x0075
        L_0x0074:
            r4 = r2
        L_0x0075:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{clickUrl:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$clickUrl()
            if (r4 == 0) goto L_0x008e
            java.lang.String r4 = r5.realmGet$clickUrl()
            goto L_0x008f
        L_0x008e:
            r4 = r2
        L_0x008f:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{cpcUrl:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$cpcUrl()
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = r5.realmGet$cpcUrl()
            goto L_0x00a9
        L_0x00a8:
            r4 = r2
        L_0x00a9:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{appId:"
            r0.append(r4)
            java.lang.Long r4 = r5.realmGet$appId()
            if (r4 == 0) goto L_0x00c2
            java.lang.Long r4 = r5.realmGet$appId()
            goto L_0x00c3
        L_0x00c2:
            r4 = r2
        L_0x00c3:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{adId:"
            r0.append(r4)
            java.lang.Long r4 = r5.realmGet$adId()
            if (r4 == 0) goto L_0x00dc
            java.lang.Long r4 = r5.realmGet$adId()
            goto L_0x00dd
        L_0x00dc:
            r4 = r2
        L_0x00dd:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{cpiUrl:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$cpiUrl()
            if (r4 == 0) goto L_0x00f6
            java.lang.String r4 = r5.realmGet$cpiUrl()
            goto L_0x00f7
        L_0x00f6:
            r4 = r2
        L_0x00f7:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{name:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$name()
            if (r4 == 0) goto L_0x0110
            java.lang.String r4 = r5.realmGet$name()
            goto L_0x0111
        L_0x0110:
            r4 = r2
        L_0x0111:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{iconPath:"
            r0.append(r4)
            java.lang.String r4 = r5.realmGet$iconPath()
            if (r4 == 0) goto L_0x012a
            java.lang.String r4 = r5.realmGet$iconPath()
            goto L_0x012b
        L_0x012a:
            r4 = r2
        L_0x012b:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{downloads:"
            r0.append(r4)
            java.lang.Integer r4 = r5.realmGet$downloads()
            if (r4 == 0) goto L_0x0144
            java.lang.Integer r4 = r5.realmGet$downloads()
            goto L_0x0145
        L_0x0144:
            r4 = r2
        L_0x0145:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r4 = "{stars:"
            r0.append(r4)
            java.lang.Integer r4 = r5.realmGet$stars()
            if (r4 == 0) goto L_0x015e
            java.lang.Integer r4 = r5.realmGet$stars()
            goto L_0x015f
        L_0x015e:
            r4 = r2
        L_0x015f:
            r0.append(r4)
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "{modified:"
            r0.append(r3)
            java.lang.Long r3 = r5.realmGet$modified()
            if (r3 == 0) goto L_0x0177
            java.lang.Long r2 = r5.realmGet$modified()
        L_0x0177:
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r1 = r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p024io.realm.MinimalAdRealmProxy.toString():java.lang.String");
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42447d;
    }

    public int hashCode() {
        String realmName = this.f42447d.mo43514c().mo43545j();
        String tableName = this.f42447d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42447d.mo43515d().getIndex();
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
        MinimalAdRealmProxy aMinimalAd = (MinimalAdRealmProxy) o;
        String path = this.f42447d.mo43514c().mo43545j();
        String otherPath = aMinimalAd.f42447d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42447d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aMinimalAd.f42447d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42447d.mo43515d().getIndex() != aMinimalAd.f42447d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
