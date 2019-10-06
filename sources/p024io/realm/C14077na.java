package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.Update;
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

/* renamed from: io.realm.na */
/* compiled from: UpdateRealmProxy */
public class C14077na extends Update implements C7344p, C14080oa {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42665a = m44979e();

    /* renamed from: b */
    private static final List<String> f42666b;

    /* renamed from: c */
    private C14078a f42667c;

    /* renamed from: d */
    private C13986D<Update> f42668d;

    /* renamed from: io.realm.na$a */
    /* compiled from: UpdateRealmProxy */
    static final class C14078a extends C7327c {

        /* renamed from: c */
        long f42669c;

        /* renamed from: d */
        long f42670d;

        /* renamed from: e */
        long f42671e;

        /* renamed from: f */
        long f42672f;

        /* renamed from: g */
        long f42673g;

        /* renamed from: h */
        long f42674h;

        /* renamed from: i */
        long f42675i;

        /* renamed from: j */
        long f42676j;

        /* renamed from: k */
        long f42677k;

        /* renamed from: l */
        long f42678l;

        /* renamed from: m */
        long f42679m;

        /* renamed from: n */
        long f42680n;

        /* renamed from: o */
        long f42681o;

        /* renamed from: p */
        long f42682p;

        /* renamed from: q */
        long f42683q;

        /* renamed from: r */
        long f42684r;

        /* renamed from: s */
        long f42685s;

        /* renamed from: t */
        long f42686t;

        /* renamed from: u */
        long f42687u;

        /* renamed from: v */
        long f42688v;

        /* renamed from: w */
        long f42689w;

        /* renamed from: x */
        long f42690x;

        C14078a(SharedRealm realm, Table table) {
            super(22);
            this.f42669c = mo23757a(table, "packageName", RealmFieldType.STRING);
            this.f42670d = mo23757a(table, "appId", RealmFieldType.INTEGER);
            this.f42671e = mo23757a(table, Update.LABEL, RealmFieldType.STRING);
            this.f42672f = mo23757a(table, "icon", RealmFieldType.STRING);
            this.f42673g = mo23757a(table, "versionCode", RealmFieldType.INTEGER);
            this.f42674h = mo23757a(table, "timestamp", RealmFieldType.INTEGER);
            this.f42675i = mo23757a(table, "md5", RealmFieldType.STRING);
            this.f42676j = mo23757a(table, Update.APK_PATH, RealmFieldType.STRING);
            this.f42677k = mo23757a(table, "size", RealmFieldType.INTEGER);
            this.f42678l = mo23757a(table, Update.UPDATE_VERSION_NAME, RealmFieldType.STRING);
            this.f42679m = mo23757a(table, Update.UPDATE_VERSION_CODE, RealmFieldType.INTEGER);
            this.f42680n = mo23757a(table, Update.EXCLUDED, RealmFieldType.BOOLEAN);
            this.f42681o = mo23757a(table, "trustedBadge", RealmFieldType.STRING);
            this.f42682p = mo23757a(table, Update.ALTERNATIVE_URL, RealmFieldType.STRING);
            this.f42683q = mo23757a(table, Update.APPC_UPGRADE, RealmFieldType.BOOLEAN);
            this.f42684r = mo23757a(table, "mainObbName", RealmFieldType.STRING);
            this.f42685s = mo23757a(table, "mainObbPath", RealmFieldType.STRING);
            this.f42686t = mo23757a(table, "mainObbMd5", RealmFieldType.STRING);
            this.f42687u = mo23757a(table, "patchObbName", RealmFieldType.STRING);
            this.f42688v = mo23757a(table, "patchObbPath", RealmFieldType.STRING);
            this.f42689w = mo23757a(table, "patchObbMd5", RealmFieldType.STRING);
            this.f42690x = mo23757a(table, "hasAppc", RealmFieldType.BOOLEAN);
        }

        C14078a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14078a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14078a src = (C14078a) rawSrc;
            C14078a dst = (C14078a) rawDst;
            dst.f42669c = src.f42669c;
            dst.f42670d = src.f42670d;
            dst.f42671e = src.f42671e;
            dst.f42672f = src.f42672f;
            dst.f42673g = src.f42673g;
            dst.f42674h = src.f42674h;
            dst.f42675i = src.f42675i;
            dst.f42676j = src.f42676j;
            dst.f42677k = src.f42677k;
            dst.f42678l = src.f42678l;
            dst.f42679m = src.f42679m;
            dst.f42680n = src.f42680n;
            dst.f42681o = src.f42681o;
            dst.f42682p = src.f42682p;
            dst.f42683q = src.f42683q;
            dst.f42684r = src.f42684r;
            dst.f42685s = src.f42685s;
            dst.f42686t = src.f42686t;
            dst.f42687u = src.f42687u;
            dst.f42688v = src.f42688v;
            dst.f42689w = src.f42689w;
            dst.f42690x = src.f42690x;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("packageName");
        fieldNames.add("appId");
        fieldNames.add(Update.LABEL);
        fieldNames.add("icon");
        fieldNames.add("versionCode");
        fieldNames.add("timestamp");
        fieldNames.add("md5");
        fieldNames.add(Update.APK_PATH);
        fieldNames.add("size");
        fieldNames.add(Update.UPDATE_VERSION_NAME);
        fieldNames.add(Update.UPDATE_VERSION_CODE);
        fieldNames.add(Update.EXCLUDED);
        fieldNames.add("trustedBadge");
        fieldNames.add(Update.ALTERNATIVE_URL);
        fieldNames.add(Update.APPC_UPGRADE);
        fieldNames.add("mainObbName");
        fieldNames.add("mainObbPath");
        fieldNames.add("mainObbMd5");
        fieldNames.add("patchObbName");
        fieldNames.add("patchObbPath");
        fieldNames.add("patchObbMd5");
        fieldNames.add("hasAppc");
        f42666b = Collections.unmodifiableList(fieldNames);
    }

    C14077na() {
        this.f42668d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42668d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42667c = (C14078a) context.mo43700c();
            this.f42668d = new C13986D<>(this);
            this.f42668d.mo43507a(context.mo43702e());
            this.f42668d.mo43513b(context.mo43703f());
            this.f42668d.mo43509a(context.mo43699b());
            this.f42668d.mo43508a(context.mo43701d());
        }
    }

    public String realmGet$packageName() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42669c);
    }

    public void realmSet$packageName(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'packageName' cannot be changed after object was created.");
        }
    }

    public long realmGet$appId() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23716h(this.f42667c.f42670d);
    }

    public void realmSet$appId(long value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23705b(this.f42667c.f42670d, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23649a(this.f42667c.f42670d, row.getIndex(), value, true);
        }
    }

    public String realmGet$label() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42671e);
    }

    public void realmSet$label(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42671e);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42671e, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42671e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42671e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$icon() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42672f);
    }

    public void realmSet$icon(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42672f);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42672f, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42672f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42672f, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$versionCode() {
        this.f42668d.mo43514c().mo43690d();
        return (int) this.f42668d.mo43515d().mo23716h(this.f42667c.f42673g);
    }

    public void realmSet$versionCode(int value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23705b(this.f42667c.f42673g, (long) value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23649a(this.f42667c.f42673g, row.getIndex(), (long) value, true);
        }
    }

    public long realmGet$timestamp() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23716h(this.f42667c.f42674h);
    }

    public void realmSet$timestamp(long value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23705b(this.f42667c.f42674h, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23649a(this.f42667c.f42674h, row.getIndex(), value, true);
        }
    }

    public String realmGet$md5() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42675i);
    }

    public void realmSet$md5(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42675i);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42675i, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42675i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42675i, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$apkPath() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42676j);
    }

    public void realmSet$apkPath(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42676j);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42676j, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42676j, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42676j, row.getIndex(), value, true);
            }
        }
    }

    public long realmGet$size() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23716h(this.f42667c.f42677k);
    }

    public void realmSet$size(long value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23705b(this.f42667c.f42677k, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23649a(this.f42667c.f42677k, row.getIndex(), value, true);
        }
    }

    public String realmGet$updateVersionName() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42678l);
    }

    public void realmSet$updateVersionName(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42678l);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42678l, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42678l, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42678l, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$updateVersionCode() {
        this.f42668d.mo43514c().mo43690d();
        return (int) this.f42668d.mo43515d().mo23716h(this.f42667c.f42679m);
    }

    public void realmSet$updateVersionCode(int value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23705b(this.f42667c.f42679m, (long) value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23649a(this.f42667c.f42679m, row.getIndex(), (long) value, true);
        }
    }

    public boolean realmGet$excluded() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23712g(this.f42667c.f42680n);
    }

    public void realmSet$excluded(boolean value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23703a(this.f42667c.f42680n, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23653a(this.f42667c.f42680n, row.getIndex(), value, true);
        }
    }

    public String realmGet$trustedBadge() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42681o);
    }

    public void realmSet$trustedBadge(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42681o);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42681o, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42681o, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42681o, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$alternativeApkPath() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42682p);
    }

    public void realmSet$alternativeApkPath(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42682p);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42682p, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42682p, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42682p, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$appcUpgrade() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23712g(this.f42667c.f42683q);
    }

    public void realmSet$appcUpgrade(boolean value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23703a(this.f42667c.f42683q, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23653a(this.f42667c.f42683q, row.getIndex(), value, true);
        }
    }

    public String realmGet$mainObbName() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42684r);
    }

    public void realmSet$mainObbName(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42684r);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42684r, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42684r, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42684r, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$mainObbPath() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42685s);
    }

    public void realmSet$mainObbPath(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42685s);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42685s, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42685s, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42685s, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$mainObbMd5() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42686t);
    }

    public void realmSet$mainObbMd5(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42686t);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42686t, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42686t, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42686t, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$patchObbName() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42687u);
    }

    public void realmSet$patchObbName(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42687u);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42687u, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42687u, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42687u, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$patchObbPath() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42688v);
    }

    public void realmSet$patchObbPath(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42688v);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42688v, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42688v, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42688v, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$patchObbMd5() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23720m(this.f42667c.f42689w);
    }

    public void realmSet$patchObbMd5(String value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            if (value == null) {
                this.f42668d.mo43515d().mo23512b(this.f42667c.f42689w);
            } else {
                this.f42668d.mo43515d().setString(this.f42667c.f42689w, value);
            }
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42667c.f42689w, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42667c.f42689w, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$hasAppc() {
        this.f42668d.mo43514c().mo43690d();
        return this.f42668d.mo43515d().mo23712g(this.f42667c.f42690x);
    }

    public void realmSet$hasAppc(boolean value) {
        if (!this.f42668d.mo43517f()) {
            this.f42668d.mo43514c().mo43690d();
            this.f42668d.mo43515d().mo23703a(this.f42667c.f42690x, value);
        } else if (this.f42668d.mo43510a()) {
            C7347r row = this.f42668d.mo43515d();
            row.mo23711f().mo23653a(this.f42667c.f42690x, row.getIndex(), value, true);
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m44979e() {
        C7309a builder = new C7309a("Update");
        builder.mo23605a("packageName", RealmFieldType.STRING, true, true, false);
        C7309a aVar = builder;
        aVar.mo23605a("appId", RealmFieldType.INTEGER, false, false, true);
        C7309a aVar2 = builder;
        aVar2.mo23605a(Update.LABEL, RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("icon", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("versionCode", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a("timestamp", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("md5", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a(Update.APK_PATH, RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("size", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a(Update.UPDATE_VERSION_NAME, RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(Update.UPDATE_VERSION_CODE, RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a(Update.EXCLUDED, RealmFieldType.BOOLEAN, false, false, true);
        aVar2.mo23605a("trustedBadge", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a(Update.ALTERNATIVE_URL, RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a(Update.APPC_UPGRADE, RealmFieldType.BOOLEAN, false, false, true);
        aVar3.mo23605a("mainObbName", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("mainObbPath", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("mainObbMd5", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("patchObbName", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("patchObbPath", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("patchObbMd5", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("hasAppc", RealmFieldType.BOOLEAN, false, false, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m44977c() {
        return f42665a;
    }

    /* renamed from: a */
    public static C14078a m44974a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Update";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 22) {
                if (columnCount < 22) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 22 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 22 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 22 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14078a columnInfo = new C14078a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'packageName' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42669c) {
                String str2 = "packageName";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'packageName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.STRING) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'packageName' in existing Realm file.");
                } else if (!table.mo23678l(columnInfo.f42669c)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'packageName' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                } else if (table.mo23677k(table.mo23656b(str2))) {
                    String str3 = "appId";
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'appId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.INTEGER) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'appId' in existing Realm file.");
                    } else if (!table.mo23678l(columnInfo.f42670d)) {
                        String str4 = Update.LABEL;
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'label' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'label' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42671e)) {
                            String str5 = "icon";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'icon' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'icon' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42672f)) {
                                String str6 = "versionCode";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'versionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.INTEGER) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'versionCode' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42673g)) {
                                    String str7 = "timestamp";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'timestamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.INTEGER) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'timestamp' in existing Realm file.");
                                    } else if (!table.mo23678l(columnInfo.f42674h)) {
                                        String str8 = "md5";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'md5' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'md5' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42675i)) {
                                            String str9 = Update.APK_PATH;
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'apkPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.STRING) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'apkPath' in existing Realm file.");
                                            } else if (table.mo23678l(columnInfo.f42676j)) {
                                                String str10 = "size";
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'size' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.INTEGER) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'size' in existing Realm file.");
                                                } else if (!table.mo23678l(columnInfo.f42677k)) {
                                                    String str11 = Update.UPDATE_VERSION_NAME;
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'updateVersionName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'updateVersionName' in existing Realm file.");
                                                    } else if (table.mo23678l(columnInfo.f42678l)) {
                                                        String str12 = Update.UPDATE_VERSION_CODE;
                                                        if (!columnTypes.containsKey(str12)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'updateVersionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str12) != RealmFieldType.INTEGER) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'updateVersionCode' in existing Realm file.");
                                                        } else if (!table.mo23678l(columnInfo.f42679m)) {
                                                            String str13 = Update.EXCLUDED;
                                                            if (!columnTypes.containsKey(str13)) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'excluded' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                            } else if (columnTypes.get(str13) != RealmFieldType.BOOLEAN) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'excluded' in existing Realm file.");
                                                            } else if (!table.mo23678l(columnInfo.f42680n)) {
                                                                String str14 = "trustedBadge";
                                                                if (!columnTypes.containsKey(str14)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'trustedBadge' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(str14) != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'trustedBadge' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42681o)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'trustedBadge' is required. Either set @Required to field 'trustedBadge' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey(Update.ALTERNATIVE_URL)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'alternativeApkPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(Update.ALTERNATIVE_URL) != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'alternativeApkPath' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42682p)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'alternativeApkPath' is required. Either set @Required to field 'alternativeApkPath' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey(Update.APPC_UPGRADE)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'appcUpgrade' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(Update.APPC_UPGRADE) != RealmFieldType.BOOLEAN) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'appcUpgrade' in existing Realm file.");
                                                                } else if (table.mo23678l(columnInfo.f42683q)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'appcUpgrade' does support null values in the existing Realm file. Use corresponding boxed type for field 'appcUpgrade' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("mainObbName")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'mainObbName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("mainObbName") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'mainObbName' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42684r)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'mainObbName' is required. Either set @Required to field 'mainObbName' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("mainObbPath")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'mainObbPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("mainObbPath") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'mainObbPath' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42685s)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'mainObbPath' is required. Either set @Required to field 'mainObbPath' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("mainObbMd5")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'mainObbMd5' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("mainObbMd5") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'mainObbMd5' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42686t)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'mainObbMd5' is required. Either set @Required to field 'mainObbMd5' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("patchObbName")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'patchObbName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("patchObbName") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'patchObbName' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42687u)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'patchObbName' is required. Either set @Required to field 'patchObbName' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("patchObbPath")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'patchObbPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("patchObbPath") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'patchObbPath' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42688v)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'patchObbPath' is required. Either set @Required to field 'patchObbPath' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("patchObbMd5")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'patchObbMd5' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("patchObbMd5") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'patchObbMd5' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42689w)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'patchObbMd5' is required. Either set @Required to field 'patchObbMd5' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("hasAppc")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'hasAppc' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("hasAppc") != RealmFieldType.BOOLEAN) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'hasAppc' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42690x)) {
                                                                    return columnInfo;
                                                                } else {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'hasAppc' does support null values in the existing Realm file. Use corresponding boxed type for field 'hasAppc' or migrate using RealmObjectSchema.setNullable().");
                                                                }
                                                            } else {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'excluded' does support null values in the existing Realm file. Use corresponding boxed type for field 'excluded' or migrate using RealmObjectSchema.setNullable().");
                                                            }
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'updateVersionCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'updateVersionCode' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'updateVersionName' is required. Either set @Required to field 'updateVersionName' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'size' does support null values in the existing Realm file. Use corresponding boxed type for field 'size' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'apkPath' is required. Either set @Required to field 'apkPath' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'md5' is required. Either set @Required to field 'md5' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'timestamp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timestamp' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'versionCode' does support null values in the existing Realm file. Use corresponding boxed type for field 'versionCode' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'icon' is required. Either set @Required to field 'icon' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'label' is required. Either set @Required to field 'label' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'appId' does support null values in the existing Realm file. Use corresponding boxed type for field 'appId' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Update' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m44978d() {
        return "class_Update";
    }

    /* renamed from: b */
    public static Update m44976b(C13990F realm, Update object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        Update update2 = object;
        Map<C0105Y, C7344p> map = cache;
        if ((update2 instanceof C7344p) && ((C7344p) update2).mo23791a().mo43514c() != null && ((C7344p) update2).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((update2 instanceof C7344p) && ((C7344p) update2).mo23791a().mo43514c() != null && ((C7344p) update2).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return update2;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(update2);
            if (cachedRealmObject != null) {
                return (Update) cachedRealmObject;
            }
            Update realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Update.class);
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Update.class), false, Collections.emptyList());
                            realmObject = new C14077na();
                            map.put(update2, realmObject);
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
                return m44973a(realm, object, update, cache);
            }
            m44972a(f, realmObject, update2, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Update m44973a(C13990F realm, Update newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Update) cachedRealmObject;
        }
        Update realmObject = (Update) realm.mo43528a(Update.class, newObject.realmGet$packageName(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C14080oa realmObjectSource = newObject;
        Update update2 = realmObject;
        update2.realmSet$appId(realmObjectSource.realmGet$appId());
        update2.realmSet$label(realmObjectSource.realmGet$label());
        update2.realmSet$icon(realmObjectSource.realmGet$icon());
        update2.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        update2.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        update2.realmSet$md5(realmObjectSource.realmGet$md5());
        update2.realmSet$apkPath(realmObjectSource.realmGet$apkPath());
        update2.realmSet$size(realmObjectSource.realmGet$size());
        update2.realmSet$updateVersionName(realmObjectSource.realmGet$updateVersionName());
        update2.realmSet$updateVersionCode(realmObjectSource.realmGet$updateVersionCode());
        update2.realmSet$excluded(realmObjectSource.realmGet$excluded());
        update2.realmSet$trustedBadge(realmObjectSource.realmGet$trustedBadge());
        update2.realmSet$alternativeApkPath(realmObjectSource.realmGet$alternativeApkPath());
        update2.realmSet$appcUpgrade(realmObjectSource.realmGet$appcUpgrade());
        update2.realmSet$mainObbName(realmObjectSource.realmGet$mainObbName());
        update2.realmSet$mainObbPath(realmObjectSource.realmGet$mainObbPath());
        update2.realmSet$mainObbMd5(realmObjectSource.realmGet$mainObbMd5());
        update2.realmSet$patchObbName(realmObjectSource.realmGet$patchObbName());
        update2.realmSet$patchObbPath(realmObjectSource.realmGet$patchObbPath());
        update2.realmSet$patchObbMd5(realmObjectSource.realmGet$patchObbMd5());
        update2.realmSet$hasAppc(realmObjectSource.realmGet$hasAppc());
        return realmObject;
    }

    /* renamed from: a */
    public static long m44970a(C13990F realm, Update object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Update update = object;
        if ((update instanceof C7344p) && ((C7344p) update).mo23791a().mo43514c() != null && ((C7344p) update).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) update).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Update.class);
        long tableNativePtr = table.getNativePtr();
        C14078a columnInfo = (C14078a) f.f42569h.mo43710a(Update.class);
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
        cache.put(update, Long.valueOf(rowIndex2));
        long j = pkColumnIndex;
        Table.nativeSetLong(tableNativePtr, columnInfo.f42670d, rowIndex2, object.realmGet$appId(), false);
        String realmGet$label = object.realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42671e, rowIndex2, realmGet$label, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42671e, rowIndex2, false);
        }
        String realmGet$icon = object.realmGet$icon();
        if (realmGet$icon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42672f, rowIndex2, realmGet$icon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42672f, rowIndex2, false);
        }
        long j2 = tableNativePtr;
        long j3 = rowIndex2;
        Table.nativeSetLong(j2, columnInfo.f42673g, j3, (long) object.realmGet$versionCode(), false);
        Table.nativeSetLong(j2, columnInfo.f42674h, j3, object.realmGet$timestamp(), false);
        String realmGet$md5 = object.realmGet$md5();
        if (realmGet$md5 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42675i, rowIndex2, realmGet$md5, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42675i, rowIndex2, false);
        }
        String realmGet$apkPath = object.realmGet$apkPath();
        if (realmGet$apkPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42676j, rowIndex2, realmGet$apkPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42676j, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42677k, rowIndex2, object.realmGet$size(), false);
        String realmGet$updateVersionName = object.realmGet$updateVersionName();
        if (realmGet$updateVersionName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42678l, rowIndex2, realmGet$updateVersionName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42678l, rowIndex2, false);
        }
        long j4 = tableNativePtr;
        long j5 = rowIndex2;
        Table.nativeSetLong(j4, columnInfo.f42679m, j5, (long) object.realmGet$updateVersionCode(), false);
        Table.nativeSetBoolean(j4, columnInfo.f42680n, j5, object.realmGet$excluded(), false);
        String realmGet$trustedBadge = object.realmGet$trustedBadge();
        if (realmGet$trustedBadge != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42681o, rowIndex2, realmGet$trustedBadge, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42681o, rowIndex2, false);
        }
        String realmGet$alternativeApkPath = object.realmGet$alternativeApkPath();
        if (realmGet$alternativeApkPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42682p, rowIndex2, realmGet$alternativeApkPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42682p, rowIndex2, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.f42683q, rowIndex2, object.realmGet$appcUpgrade(), false);
        String realmGet$mainObbName = object.realmGet$mainObbName();
        if (realmGet$mainObbName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42684r, rowIndex2, realmGet$mainObbName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42684r, rowIndex2, false);
        }
        String realmGet$mainObbPath = object.realmGet$mainObbPath();
        if (realmGet$mainObbPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42685s, rowIndex2, realmGet$mainObbPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42685s, rowIndex2, false);
        }
        String realmGet$mainObbMd5 = object.realmGet$mainObbMd5();
        if (realmGet$mainObbMd5 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42686t, rowIndex2, realmGet$mainObbMd5, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42686t, rowIndex2, false);
        }
        String realmGet$patchObbName = object.realmGet$patchObbName();
        if (realmGet$patchObbName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42687u, rowIndex2, realmGet$patchObbName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42687u, rowIndex2, false);
        }
        String realmGet$patchObbPath = object.realmGet$patchObbPath();
        if (realmGet$patchObbPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42688v, rowIndex2, realmGet$patchObbPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42688v, rowIndex2, false);
        }
        String realmGet$patchObbMd5 = object.realmGet$patchObbMd5();
        if (realmGet$patchObbMd5 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42689w, rowIndex2, realmGet$patchObbMd5, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42689w, rowIndex2, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.f42690x, rowIndex2, object.realmGet$hasAppc(), false);
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m44975a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Update.class);
        long tableNativePtr = table.getNativePtr();
        C14078a columnInfo = (C14078a) f.f42569h.mo43710a(Update.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            Update object = (Update) objects.next();
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
                pkColumnIndex = pkColumnIndex2;
                String str = primaryKeyValue;
                Table.nativeSetLong(tableNativePtr, columnInfo.f42670d, rowIndex2, object.realmGet$appId(), false);
                String realmGet$label = object.realmGet$label();
                if (realmGet$label != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42671e, rowIndex2, realmGet$label, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42671e, rowIndex2, false);
                }
                String realmGet$icon = object.realmGet$icon();
                if (realmGet$icon != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42672f, rowIndex2, realmGet$icon, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42672f, rowIndex2, false);
                }
                long j = tableNativePtr;
                long j2 = rowIndex2;
                Table.nativeSetLong(j, columnInfo.f42673g, j2, (long) object.realmGet$versionCode(), false);
                Table.nativeSetLong(j, columnInfo.f42674h, j2, object.realmGet$timestamp(), false);
                String realmGet$md5 = object.realmGet$md5();
                if (realmGet$md5 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42675i, rowIndex2, realmGet$md5, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42675i, rowIndex2, false);
                }
                String realmGet$apkPath = object.realmGet$apkPath();
                if (realmGet$apkPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42676j, rowIndex2, realmGet$apkPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42676j, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42677k, rowIndex2, object.realmGet$size(), false);
                String realmGet$updateVersionName = object.realmGet$updateVersionName();
                if (realmGet$updateVersionName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42678l, rowIndex2, realmGet$updateVersionName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42678l, rowIndex2, false);
                }
                long j3 = tableNativePtr;
                long j4 = rowIndex2;
                Table.nativeSetLong(j3, columnInfo.f42679m, j4, (long) object.realmGet$updateVersionCode(), false);
                Table.nativeSetBoolean(j3, columnInfo.f42680n, j4, object.realmGet$excluded(), false);
                String realmGet$trustedBadge = object.realmGet$trustedBadge();
                if (realmGet$trustedBadge != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42681o, rowIndex2, realmGet$trustedBadge, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42681o, rowIndex2, false);
                }
                String realmGet$alternativeApkPath = object.realmGet$alternativeApkPath();
                if (realmGet$alternativeApkPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42682p, rowIndex2, realmGet$alternativeApkPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42682p, rowIndex2, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.f42683q, rowIndex2, object.realmGet$appcUpgrade(), false);
                String realmGet$mainObbName = object.realmGet$mainObbName();
                if (realmGet$mainObbName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42684r, rowIndex2, realmGet$mainObbName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42684r, rowIndex2, false);
                }
                String realmGet$mainObbPath = object.realmGet$mainObbPath();
                if (realmGet$mainObbPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42685s, rowIndex2, realmGet$mainObbPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42685s, rowIndex2, false);
                }
                String realmGet$mainObbMd5 = object.realmGet$mainObbMd5();
                if (realmGet$mainObbMd5 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42686t, rowIndex2, realmGet$mainObbMd5, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42686t, rowIndex2, false);
                }
                String realmGet$patchObbName = object.realmGet$patchObbName();
                if (realmGet$patchObbName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42687u, rowIndex2, realmGet$patchObbName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42687u, rowIndex2, false);
                }
                String realmGet$patchObbPath = object.realmGet$patchObbPath();
                if (realmGet$patchObbPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42688v, rowIndex2, realmGet$patchObbPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42688v, rowIndex2, false);
                }
                String realmGet$patchObbMd5 = object.realmGet$patchObbMd5();
                if (realmGet$patchObbMd5 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42689w, rowIndex2, realmGet$patchObbMd5, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42689w, rowIndex2, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.f42690x, rowIndex2, object.realmGet$hasAppc(), false);
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            Update update = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static Update m44971a(Update realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Update unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Update();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Update) cachedObject.f14332b;
        } else {
            unmanagedObject = (Update) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Update update = unmanagedObject;
        C14080oa realmSource = realmObject;
        update.realmSet$packageName(realmSource.realmGet$packageName());
        update.realmSet$appId(realmSource.realmGet$appId());
        update.realmSet$label(realmSource.realmGet$label());
        update.realmSet$icon(realmSource.realmGet$icon());
        update.realmSet$versionCode(realmSource.realmGet$versionCode());
        update.realmSet$timestamp(realmSource.realmGet$timestamp());
        update.realmSet$md5(realmSource.realmGet$md5());
        update.realmSet$apkPath(realmSource.realmGet$apkPath());
        update.realmSet$size(realmSource.realmGet$size());
        update.realmSet$updateVersionName(realmSource.realmGet$updateVersionName());
        update.realmSet$updateVersionCode(realmSource.realmGet$updateVersionCode());
        update.realmSet$excluded(realmSource.realmGet$excluded());
        update.realmSet$trustedBadge(realmSource.realmGet$trustedBadge());
        update.realmSet$alternativeApkPath(realmSource.realmGet$alternativeApkPath());
        update.realmSet$appcUpgrade(realmSource.realmGet$appcUpgrade());
        update.realmSet$mainObbName(realmSource.realmGet$mainObbName());
        update.realmSet$mainObbPath(realmSource.realmGet$mainObbPath());
        update.realmSet$mainObbMd5(realmSource.realmGet$mainObbMd5());
        update.realmSet$patchObbName(realmSource.realmGet$patchObbName());
        update.realmSet$patchObbPath(realmSource.realmGet$patchObbPath());
        update.realmSet$patchObbMd5(realmSource.realmGet$patchObbMd5());
        update.realmSet$hasAppc(realmSource.realmGet$hasAppc());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Update m44972a(C13990F realm, Update realmObject, Update newObject, Map<C0105Y, C7344p> map) {
        Update update = realmObject;
        C14080oa realmObjectSource = newObject;
        update.realmSet$appId(realmObjectSource.realmGet$appId());
        update.realmSet$label(realmObjectSource.realmGet$label());
        update.realmSet$icon(realmObjectSource.realmGet$icon());
        update.realmSet$versionCode(realmObjectSource.realmGet$versionCode());
        update.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        update.realmSet$md5(realmObjectSource.realmGet$md5());
        update.realmSet$apkPath(realmObjectSource.realmGet$apkPath());
        update.realmSet$size(realmObjectSource.realmGet$size());
        update.realmSet$updateVersionName(realmObjectSource.realmGet$updateVersionName());
        update.realmSet$updateVersionCode(realmObjectSource.realmGet$updateVersionCode());
        update.realmSet$excluded(realmObjectSource.realmGet$excluded());
        update.realmSet$trustedBadge(realmObjectSource.realmGet$trustedBadge());
        update.realmSet$alternativeApkPath(realmObjectSource.realmGet$alternativeApkPath());
        update.realmSet$appcUpgrade(realmObjectSource.realmGet$appcUpgrade());
        update.realmSet$mainObbName(realmObjectSource.realmGet$mainObbName());
        update.realmSet$mainObbPath(realmObjectSource.realmGet$mainObbPath());
        update.realmSet$mainObbMd5(realmObjectSource.realmGet$mainObbMd5());
        update.realmSet$patchObbName(realmObjectSource.realmGet$patchObbName());
        update.realmSet$patchObbPath(realmObjectSource.realmGet$patchObbPath());
        update.realmSet$patchObbMd5(realmObjectSource.realmGet$patchObbMd5());
        update.realmSet$hasAppc(realmObjectSource.realmGet$hasAppc());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Update = proxy[");
        stringBuilder.append("{packageName:");
        String str = "null";
        stringBuilder.append(realmGet$packageName() != null ? realmGet$packageName() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{appId:");
        stringBuilder.append(realmGet$appId());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{label:");
        stringBuilder.append(realmGet$label() != null ? realmGet$label() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon() != null ? realmGet$icon() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{versionCode:");
        stringBuilder.append(realmGet$versionCode());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{md5:");
        stringBuilder.append(realmGet$md5() != null ? realmGet$md5() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{apkPath:");
        stringBuilder.append(realmGet$apkPath() != null ? realmGet$apkPath() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{size:");
        stringBuilder.append(realmGet$size());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{updateVersionName:");
        stringBuilder.append(realmGet$updateVersionName() != null ? realmGet$updateVersionName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{updateVersionCode:");
        stringBuilder.append(realmGet$updateVersionCode());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{excluded:");
        stringBuilder.append(realmGet$excluded());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{trustedBadge:");
        stringBuilder.append(realmGet$trustedBadge() != null ? realmGet$trustedBadge() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{alternativeApkPath:");
        stringBuilder.append(realmGet$alternativeApkPath() != null ? realmGet$alternativeApkPath() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{appcUpgrade:");
        stringBuilder.append(realmGet$appcUpgrade());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{mainObbName:");
        stringBuilder.append(realmGet$mainObbName() != null ? realmGet$mainObbName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{mainObbPath:");
        stringBuilder.append(realmGet$mainObbPath() != null ? realmGet$mainObbPath() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{mainObbMd5:");
        stringBuilder.append(realmGet$mainObbMd5() != null ? realmGet$mainObbMd5() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{patchObbName:");
        stringBuilder.append(realmGet$patchObbName() != null ? realmGet$patchObbName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{patchObbPath:");
        stringBuilder.append(realmGet$patchObbPath() != null ? realmGet$patchObbPath() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{patchObbMd5:");
        if (realmGet$patchObbMd5() != null) {
            str = realmGet$patchObbMd5();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{hasAppc:");
        stringBuilder.append(realmGet$hasAppc());
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42668d;
    }

    public int hashCode() {
        String realmName = this.f42668d.mo43514c().mo43545j();
        String tableName = this.f42668d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42668d.mo43515d().getIndex();
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
        C14077na aUpdate = (C14077na) o;
        String path = this.f42668d.mo43514c().mo43545j();
        String otherPath = aUpdate.f42668d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42668d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aUpdate.f42668d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42668d.mo43515d().getIndex() != aUpdate.f42668d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
