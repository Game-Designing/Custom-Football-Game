package p024io.realm;

import io.realm.internal.RealmObjectProxy.CacheData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.database.realm.Notification;
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

/* renamed from: io.realm.w */
/* compiled from: NotificationRealmProxy */
public class C14090w extends Notification implements C7344p, C0110x {

    /* renamed from: a */
    private static final OsObjectSchemaInfo f42720a = m45035e();

    /* renamed from: b */
    private static final List<String> f42721b;

    /* renamed from: c */
    private C14091a f42722c;

    /* renamed from: d */
    private C13986D<Notification> f42723d;

    /* renamed from: io.realm.w$a */
    /* compiled from: NotificationRealmProxy */
    static final class C14091a extends C7327c {

        /* renamed from: c */
        long f42724c;

        /* renamed from: d */
        long f42725d;

        /* renamed from: e */
        long f42726e;

        /* renamed from: f */
        long f42727f;

        /* renamed from: g */
        long f42728g;

        /* renamed from: h */
        long f42729h;

        /* renamed from: i */
        long f42730i;

        /* renamed from: j */
        long f42731j;

        /* renamed from: k */
        long f42732k;

        /* renamed from: l */
        long f42733l;

        /* renamed from: m */
        long f42734m;

        /* renamed from: n */
        long f42735n;

        /* renamed from: o */
        long f42736o;

        /* renamed from: p */
        long f42737p;

        /* renamed from: q */
        long f42738q;

        /* renamed from: r */
        long f42739r;

        /* renamed from: s */
        long f42740s;

        /* renamed from: t */
        long f42741t;

        C14091a(SharedRealm realm, Table table) {
            super(18);
            this.f42724c = mo23757a(table, "expire", RealmFieldType.INTEGER);
            this.f42725d = mo23757a(table, Notification.KEY, RealmFieldType.STRING);
            this.f42726e = mo23757a(table, "abTestingGroup", RealmFieldType.STRING);
            this.f42727f = mo23757a(table, "body", RealmFieldType.STRING);
            this.f42728g = mo23757a(table, "campaignId", RealmFieldType.INTEGER);
            this.f42729h = mo23757a(table, "img", RealmFieldType.STRING);
            this.f42730i = mo23757a(table, "lang", RealmFieldType.STRING);
            this.f42731j = mo23757a(table, "title", RealmFieldType.STRING);
            this.f42732k = mo23757a(table, "url", RealmFieldType.STRING);
            this.f42733l = mo23757a(table, "urlTrack", RealmFieldType.STRING);
            this.f42734m = mo23757a(table, "notificationCenterUrlTrack", RealmFieldType.STRING);
            this.f42735n = mo23757a(table, "type", RealmFieldType.INTEGER);
            this.f42736o = mo23757a(table, "timeStamp", RealmFieldType.INTEGER);
            this.f42737p = mo23757a(table, "dismissed", RealmFieldType.INTEGER);
            this.f42738q = mo23757a(table, "appName", RealmFieldType.STRING);
            this.f42739r = mo23757a(table, "graphic", RealmFieldType.STRING);
            this.f42740s = mo23757a(table, "ownerId", RealmFieldType.STRING);
            this.f42741t = mo23757a(table, "processed", RealmFieldType.BOOLEAN);
        }

        C14091a(C7327c src, boolean mutable) {
            super(src, mutable);
            mo23761a(src, this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final C7327c mo23759a(boolean mutable) {
            return new C14091a((C7327c) this, mutable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo23761a(C7327c rawSrc, C7327c rawDst) {
            C14091a src = (C14091a) rawSrc;
            C14091a dst = (C14091a) rawDst;
            dst.f42724c = src.f42724c;
            dst.f42725d = src.f42725d;
            dst.f42726e = src.f42726e;
            dst.f42727f = src.f42727f;
            dst.f42728g = src.f42728g;
            dst.f42729h = src.f42729h;
            dst.f42730i = src.f42730i;
            dst.f42731j = src.f42731j;
            dst.f42732k = src.f42732k;
            dst.f42733l = src.f42733l;
            dst.f42734m = src.f42734m;
            dst.f42735n = src.f42735n;
            dst.f42736o = src.f42736o;
            dst.f42737p = src.f42737p;
            dst.f42738q = src.f42738q;
            dst.f42739r = src.f42739r;
            dst.f42740s = src.f42740s;
            dst.f42741t = src.f42741t;
        }
    }

    static {
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("expire");
        fieldNames.add(Notification.KEY);
        fieldNames.add("abTestingGroup");
        fieldNames.add("body");
        fieldNames.add("campaignId");
        fieldNames.add("img");
        fieldNames.add("lang");
        fieldNames.add("title");
        fieldNames.add("url");
        fieldNames.add("urlTrack");
        fieldNames.add("notificationCenterUrlTrack");
        fieldNames.add("type");
        fieldNames.add("timeStamp");
        fieldNames.add("dismissed");
        fieldNames.add("appName");
        fieldNames.add("graphic");
        fieldNames.add("ownerId");
        fieldNames.add("processed");
        f42721b = Collections.unmodifiableList(fieldNames);
    }

    C14090w() {
        this.f42723d.mo43520i();
    }

    /* renamed from: b */
    public void mo23792b() {
        if (this.f42723d == null) {
            C14050b context = (C14050b) C14048d.f42564c.get();
            this.f42722c = (C14091a) context.mo43700c();
            this.f42723d = new C13986D<>(this);
            this.f42723d.mo43507a(context.mo43702e());
            this.f42723d.mo43513b(context.mo43703f());
            this.f42723d.mo43509a(context.mo43699b());
            this.f42723d.mo43508a(context.mo43701d());
        }
    }

    public Long realmGet$expire() {
        this.f42723d.mo43514c().mo43690d();
        if (this.f42723d.mo43515d().mo23511a(this.f42722c.f42724c)) {
            return null;
        }
        return Long.valueOf(this.f42723d.mo43515d().mo23716h(this.f42722c.f42724c));
    }

    public void realmSet$expire(Long value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42724c);
            } else {
                this.f42723d.mo43515d().mo23705b(this.f42722c.f42724c, value.longValue());
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42724c, row.getIndex(), true);
            } else {
                row.mo23711f().mo23649a(this.f42722c.f42724c, row.getIndex(), value.longValue(), true);
            }
        }
    }

    public String realmGet$key() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42725d);
    }

    public void realmSet$key(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            throw new RealmException("Primary key field 'key' cannot be changed after object was created.");
        }
    }

    public String realmGet$abTestingGroup() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42726e);
    }

    public void realmSet$abTestingGroup(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42726e);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42726e, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42726e, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42726e, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$body() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42727f);
    }

    public void realmSet$body(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42727f);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42727f, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42727f, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42727f, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$campaignId() {
        this.f42723d.mo43514c().mo43690d();
        return (int) this.f42723d.mo43515d().mo23716h(this.f42722c.f42728g);
    }

    public void realmSet$campaignId(int value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            this.f42723d.mo43515d().mo23705b(this.f42722c.f42728g, (long) value);
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            row.mo23711f().mo23649a(this.f42722c.f42728g, row.getIndex(), (long) value, true);
        }
    }

    public String realmGet$img() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42729h);
    }

    public void realmSet$img(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42729h);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42729h, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42729h, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42729h, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$lang() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42730i);
    }

    public void realmSet$lang(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42730i);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42730i, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42730i, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42730i, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$title() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42731j);
    }

    public void realmSet$title(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42731j);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42731j, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42731j, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42731j, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$url() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42732k);
    }

    public void realmSet$url(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42732k);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42732k, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42732k, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42732k, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$urlTrack() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42733l);
    }

    public void realmSet$urlTrack(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42733l);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42733l, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42733l, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42733l, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$notificationCenterUrlTrack() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42734m);
    }

    public void realmSet$notificationCenterUrlTrack(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42734m);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42734m, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42734m, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42734m, row.getIndex(), value, true);
            }
        }
    }

    public int realmGet$type() {
        this.f42723d.mo43514c().mo43690d();
        return (int) this.f42723d.mo43515d().mo23716h(this.f42722c.f42735n);
    }

    public void realmSet$type(int value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            this.f42723d.mo43515d().mo23705b(this.f42722c.f42735n, (long) value);
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            row.mo23711f().mo23649a(this.f42722c.f42735n, row.getIndex(), (long) value, true);
        }
    }

    public long realmGet$timeStamp() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23716h(this.f42722c.f42736o);
    }

    public void realmSet$timeStamp(long value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            this.f42723d.mo43515d().mo23705b(this.f42722c.f42736o, value);
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            row.mo23711f().mo23649a(this.f42722c.f42736o, row.getIndex(), value, true);
        }
    }

    public long realmGet$dismissed() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23716h(this.f42722c.f42737p);
    }

    public void realmSet$dismissed(long value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            this.f42723d.mo43515d().mo23705b(this.f42722c.f42737p, value);
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            row.mo23711f().mo23649a(this.f42722c.f42737p, row.getIndex(), value, true);
        }
    }

    public String realmGet$appName() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42738q);
    }

    public void realmSet$appName(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42738q);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42738q, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42738q, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42738q, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$graphic() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42739r);
    }

    public void realmSet$graphic(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42739r);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42739r, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42739r, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42739r, row.getIndex(), value, true);
            }
        }
    }

    public String realmGet$ownerId() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23720m(this.f42722c.f42740s);
    }

    public void realmSet$ownerId(String value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            if (value == null) {
                this.f42723d.mo43515d().mo23512b(this.f42722c.f42740s);
            } else {
                this.f42723d.mo43515d().setString(this.f42722c.f42740s, value);
            }
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            if (value == null) {
                row.mo23711f().mo23652a(this.f42722c.f42740s, row.getIndex(), true);
            } else {
                row.mo23711f().mo23651a(this.f42722c.f42740s, row.getIndex(), value, true);
            }
        }
    }

    public boolean realmGet$processed() {
        this.f42723d.mo43514c().mo43690d();
        return this.f42723d.mo43515d().mo23712g(this.f42722c.f42741t);
    }

    public void realmSet$processed(boolean value) {
        if (!this.f42723d.mo43517f()) {
            this.f42723d.mo43514c().mo43690d();
            this.f42723d.mo43515d().mo23703a(this.f42722c.f42741t, value);
        } else if (this.f42723d.mo43510a()) {
            C7347r row = this.f42723d.mo43515d();
            row.mo23711f().mo23653a(this.f42722c.f42741t, row.getIndex(), value, true);
        }
    }

    /* renamed from: e */
    private static OsObjectSchemaInfo m45035e() {
        C7309a builder = new C7309a("Notification");
        builder.mo23605a("expire", RealmFieldType.INTEGER, false, false, false);
        C7309a aVar = builder;
        aVar.mo23605a(Notification.KEY, RealmFieldType.STRING, true, true, false);
        C7309a aVar2 = builder;
        aVar2.mo23605a("abTestingGroup", RealmFieldType.STRING, false, false, false);
        C7309a aVar3 = builder;
        aVar3.mo23605a("body", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("campaignId", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a("img", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("lang", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("title", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("url", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("urlTrack", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("notificationCenterUrlTrack", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("type", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("timeStamp", RealmFieldType.INTEGER, false, false, true);
        aVar3.mo23605a("dismissed", RealmFieldType.INTEGER, false, false, true);
        aVar2.mo23605a("appName", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("graphic", RealmFieldType.STRING, false, false, false);
        aVar2.mo23605a("ownerId", RealmFieldType.STRING, false, false, false);
        aVar3.mo23605a("processed", RealmFieldType.BOOLEAN, false, false, true);
        return builder.mo23606a();
    }

    /* renamed from: c */
    public static OsObjectSchemaInfo m45033c() {
        return f42720a;
    }

    /* renamed from: a */
    public static C14091a m45030a(SharedRealm sharedRealm, boolean allowExtraColumns) {
        String str = "class_Notification";
        if (sharedRealm.mo23625c(str)) {
            Table table = sharedRealm.mo23622b(str);
            long columnCount = table.mo23661d();
            if (columnCount != 18) {
                if (columnCount < 18) {
                    String f = sharedRealm.mo23630f();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Field count is less than expected - expected 18 but was ");
                    sb.append(columnCount);
                    throw new RealmMigrationNeededException(f, sb.toString());
                } else if (allowExtraColumns) {
                    RealmLog.m16234a("Field count is more than expected - expected 18 but was %1$d", Long.valueOf(columnCount));
                } else {
                    String f2 = sharedRealm.mo23630f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Field count is more than expected - expected 18 but was ");
                    sb2.append(columnCount);
                    throw new RealmMigrationNeededException(f2, sb2.toString());
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.mo23667f(i), table.mo23668g(i));
            }
            C14091a columnInfo = new C14091a(sharedRealm, table);
            if (!table.mo23671h()) {
                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Primary key not defined for field 'key' in existing Realm file. @PrimaryKey was added.");
            } else if (table.mo23666f() == columnInfo.f42725d) {
                String str2 = "expire";
                if (!columnTypes.containsKey(str2)) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'expire' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                } else if (columnTypes.get(str2) != RealmFieldType.INTEGER) {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'Long' for field 'expire' in existing Realm file.");
                } else if (table.mo23678l(columnInfo.f42724c)) {
                    String str3 = Notification.KEY;
                    if (!columnTypes.containsKey(str3)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'key' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                    } else if (columnTypes.get(str3) != RealmFieldType.STRING) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'key' in existing Realm file.");
                    } else if (!table.mo23678l(columnInfo.f42725d)) {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "@PrimaryKey field 'key' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
                    } else if (table.mo23677k(table.mo23656b(str3))) {
                        String str4 = "abTestingGroup";
                        if (!columnTypes.containsKey(str4)) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'abTestingGroup' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                        } else if (columnTypes.get(str4) != RealmFieldType.STRING) {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'abTestingGroup' in existing Realm file.");
                        } else if (table.mo23678l(columnInfo.f42726e)) {
                            String str5 = "body";
                            if (!columnTypes.containsKey(str5)) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'body' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                            } else if (columnTypes.get(str5) != RealmFieldType.STRING) {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'body' in existing Realm file.");
                            } else if (table.mo23678l(columnInfo.f42727f)) {
                                String str6 = "campaignId";
                                if (!columnTypes.containsKey(str6)) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'campaignId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                } else if (columnTypes.get(str6) != RealmFieldType.INTEGER) {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'campaignId' in existing Realm file.");
                                } else if (!table.mo23678l(columnInfo.f42728g)) {
                                    String str7 = "img";
                                    if (!columnTypes.containsKey(str7)) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'img' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                    } else if (columnTypes.get(str7) != RealmFieldType.STRING) {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'img' in existing Realm file.");
                                    } else if (table.mo23678l(columnInfo.f42729h)) {
                                        String str8 = "lang";
                                        if (!columnTypes.containsKey(str8)) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'lang' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                        } else if (columnTypes.get(str8) != RealmFieldType.STRING) {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'lang' in existing Realm file.");
                                        } else if (table.mo23678l(columnInfo.f42730i)) {
                                            String str9 = "title";
                                            if (!columnTypes.containsKey(str9)) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                            } else if (columnTypes.get(str9) != RealmFieldType.STRING) {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'title' in existing Realm file.");
                                            } else if (table.mo23678l(columnInfo.f42731j)) {
                                                String str10 = "url";
                                                if (!columnTypes.containsKey(str10)) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                } else if (columnTypes.get(str10) != RealmFieldType.STRING) {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'url' in existing Realm file.");
                                                } else if (table.mo23678l(columnInfo.f42732k)) {
                                                    String str11 = "urlTrack";
                                                    if (!columnTypes.containsKey(str11)) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'urlTrack' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                    } else if (columnTypes.get(str11) != RealmFieldType.STRING) {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'urlTrack' in existing Realm file.");
                                                    } else if (table.mo23678l(columnInfo.f42733l)) {
                                                        String str12 = "notificationCenterUrlTrack";
                                                        if (!columnTypes.containsKey(str12)) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'notificationCenterUrlTrack' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                        } else if (columnTypes.get(str12) != RealmFieldType.STRING) {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'notificationCenterUrlTrack' in existing Realm file.");
                                                        } else if (table.mo23678l(columnInfo.f42734m)) {
                                                            String str13 = "type";
                                                            if (!columnTypes.containsKey(str13)) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                            } else if (columnTypes.get(str13) != RealmFieldType.INTEGER) {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'int' for field 'type' in existing Realm file.");
                                                            } else if (!table.mo23678l(columnInfo.f42735n)) {
                                                                String str14 = "timeStamp";
                                                                if (!columnTypes.containsKey(str14)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'timeStamp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get(str14) != RealmFieldType.INTEGER) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'timeStamp' in existing Realm file.");
                                                                } else if (table.mo23678l(columnInfo.f42736o)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'timeStamp' does support null values in the existing Realm file. Use corresponding boxed type for field 'timeStamp' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("dismissed")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'dismissed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("dismissed") != RealmFieldType.INTEGER) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'long' for field 'dismissed' in existing Realm file.");
                                                                } else if (table.mo23678l(columnInfo.f42737p)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'dismissed' does support null values in the existing Realm file. Use corresponding boxed type for field 'dismissed' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("appName")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'appName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("appName") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'appName' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42738q)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'appName' is required. Either set @Required to field 'appName' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("graphic")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'graphic' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("graphic") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'graphic' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42739r)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'graphic' is required. Either set @Required to field 'graphic' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("ownerId")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'ownerId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("ownerId") != RealmFieldType.STRING) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'String' for field 'ownerId' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42740s)) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'ownerId' is required. Either set @Required to field 'ownerId' or migrate using RealmObjectSchema.setNullable().");
                                                                } else if (!columnTypes.containsKey("processed")) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Missing field 'processed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
                                                                } else if (columnTypes.get("processed") != RealmFieldType.BOOLEAN) {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Invalid type 'boolean' for field 'processed' in existing Realm file.");
                                                                } else if (!table.mo23678l(columnInfo.f42741t)) {
                                                                    return columnInfo;
                                                                } else {
                                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'processed' does support null values in the existing Realm file. Use corresponding boxed type for field 'processed' or migrate using RealmObjectSchema.setNullable().");
                                                                }
                                                            } else {
                                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'type' does support null values in the existing Realm file. Use corresponding boxed type for field 'type' or migrate using RealmObjectSchema.setNullable().");
                                                            }
                                                        } else {
                                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'notificationCenterUrlTrack' is required. Either set @Required to field 'notificationCenterUrlTrack' or migrate using RealmObjectSchema.setNullable().");
                                                        }
                                                    } else {
                                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'urlTrack' is required. Either set @Required to field 'urlTrack' or migrate using RealmObjectSchema.setNullable().");
                                                    }
                                                } else {
                                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'url' is required. Either set @Required to field 'url' or migrate using RealmObjectSchema.setNullable().");
                                                }
                                            } else {
                                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
                                            }
                                        } else {
                                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'lang' is required. Either set @Required to field 'lang' or migrate using RealmObjectSchema.setNullable().");
                                        }
                                    } else {
                                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'img' is required. Either set @Required to field 'img' or migrate using RealmObjectSchema.setNullable().");
                                    }
                                } else {
                                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'campaignId' does support null values in the existing Realm file. Use corresponding boxed type for field 'campaignId' or migrate using RealmObjectSchema.setNullable().");
                                }
                            } else {
                                throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'body' is required. Either set @Required to field 'body' or migrate using RealmObjectSchema.setNullable().");
                            }
                        } else {
                            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'abTestingGroup' is required. Either set @Required to field 'abTestingGroup' or migrate using RealmObjectSchema.setNullable().");
                        }
                    } else {
                        throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Index not defined for field 'key' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
                    }
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "Field 'expire' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'expire' or migrate using RealmObjectSchema.setNullable().");
                }
            } else {
                String f3 = sharedRealm.mo23630f();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Primary Key annotation definition was changed, from field ");
                sb3.append(table.mo23667f(table.mo23666f()));
                sb3.append(" to field key");
                throw new RealmMigrationNeededException(f3, sb3.toString());
            }
        } else {
            throw new RealmMigrationNeededException(sharedRealm.mo23630f(), "The 'Notification' class is missing from the schema for this Realm.");
        }
    }

    /* renamed from: d */
    public static String m45034d() {
        return "class_Notification";
    }

    /* renamed from: b */
    public static Notification m45032b(C13990F realm, Notification object, boolean update, Map<C0105Y, C7344p> cache) {
        long rowIndex;
        C13990F f = realm;
        Notification notification = object;
        Map<C0105Y, C7344p> map = cache;
        if ((notification instanceof C7344p) && ((C7344p) notification).mo23791a().mo43514c() != null && ((C7344p) notification).mo23791a().mo43514c().f42565d != f.f42565d) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        } else if ((notification instanceof C7344p) && ((C7344p) notification).mo23791a().mo43514c() != null && ((C7344p) notification).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return notification;
        } else {
            C14050b objectContext = (C14050b) C14048d.f42564c.get();
            C7344p cachedRealmObject = (C7344p) map.get(notification);
            if (cachedRealmObject != null) {
                return (Notification) cachedRealmObject;
            }
            Notification realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = f.mo43537b(Notification.class);
                long pkColumnIndex = table.mo23666f();
                String value = object.realmGet$key();
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
                            objectContext.mo43698a(realm, table.mo23672i(rowIndex), f.f42569h.mo43710a(Notification.class), false, Collections.emptyList());
                            realmObject = new C14090w();
                            map.put(notification, realmObject);
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
                return m45029a(realm, object, update, cache);
            }
            m45028a(f, realmObject, notification, map);
            return realmObject;
        }
    }

    /* renamed from: a */
    public static Notification m45029a(C13990F realm, Notification newObject, boolean update, Map<C0105Y, C7344p> cache) {
        C7344p cachedRealmObject = (C7344p) cache.get(newObject);
        if (cachedRealmObject != null) {
            return (Notification) cachedRealmObject;
        }
        Notification realmObject = (Notification) realm.mo43528a(Notification.class, newObject.realmGet$key(), false, Collections.emptyList());
        cache.put(newObject, (C7344p) realmObject);
        C0110x realmObjectSource = newObject;
        Notification notification = realmObject;
        notification.realmSet$expire(realmObjectSource.realmGet$expire());
        notification.realmSet$abTestingGroup(realmObjectSource.realmGet$abTestingGroup());
        notification.realmSet$body(realmObjectSource.realmGet$body());
        notification.realmSet$campaignId(realmObjectSource.realmGet$campaignId());
        notification.realmSet$img(realmObjectSource.realmGet$img());
        notification.realmSet$lang(realmObjectSource.realmGet$lang());
        notification.realmSet$title(realmObjectSource.realmGet$title());
        notification.realmSet$url(realmObjectSource.realmGet$url());
        notification.realmSet$urlTrack(realmObjectSource.realmGet$urlTrack());
        notification.realmSet$notificationCenterUrlTrack(realmObjectSource.realmGet$notificationCenterUrlTrack());
        notification.realmSet$type(realmObjectSource.realmGet$type());
        notification.realmSet$timeStamp(realmObjectSource.realmGet$timeStamp());
        notification.realmSet$dismissed(realmObjectSource.realmGet$dismissed());
        notification.realmSet$appName(realmObjectSource.realmGet$appName());
        notification.realmSet$graphic(realmObjectSource.realmGet$graphic());
        notification.realmSet$ownerId(realmObjectSource.realmGet$ownerId());
        notification.realmSet$processed(realmObjectSource.realmGet$processed());
        return realmObject;
    }

    /* renamed from: a */
    public static long m45026a(C13990F realm, Notification object, Map<C0105Y, Long> cache) {
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Notification notification = object;
        if ((notification instanceof C7344p) && ((C7344p) notification).mo23791a().mo43514c() != null && ((C7344p) notification).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
            return ((C7344p) notification).mo23791a().mo43515d().getIndex();
        }
        Table table = f.mo43537b(Notification.class);
        long tableNativePtr = table.getNativePtr();
        C14091a columnInfo = (C14091a) f.f42569h.mo43710a(Notification.class);
        long pkColumnIndex = table.mo23666f();
        String primaryKeyValue = object.realmGet$key();
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
        cache.put(notification, Long.valueOf(rowIndex2));
        Long realmGet$expire = object.realmGet$expire();
        if (realmGet$expire != null) {
            long j = pkColumnIndex;
            Table.nativeSetLong(tableNativePtr, columnInfo.f42724c, rowIndex2, realmGet$expire.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42724c, rowIndex2, false);
        }
        String realmGet$abTestingGroup = object.realmGet$abTestingGroup();
        if (realmGet$abTestingGroup != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42726e, rowIndex2, realmGet$abTestingGroup, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42726e, rowIndex2, false);
        }
        String realmGet$body = object.realmGet$body();
        if (realmGet$body != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42727f, rowIndex2, realmGet$body, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42727f, rowIndex2, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.f42728g, rowIndex2, (long) object.realmGet$campaignId(), false);
        String realmGet$img = object.realmGet$img();
        if (realmGet$img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42729h, rowIndex2, realmGet$img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42729h, rowIndex2, false);
        }
        String realmGet$lang = object.realmGet$lang();
        if (realmGet$lang != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42730i, rowIndex2, realmGet$lang, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42730i, rowIndex2, false);
        }
        String realmGet$title = object.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42731j, rowIndex2, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42731j, rowIndex2, false);
        }
        String realmGet$url = object.realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42732k, rowIndex2, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42732k, rowIndex2, false);
        }
        String realmGet$urlTrack = object.realmGet$urlTrack();
        if (realmGet$urlTrack != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42733l, rowIndex2, realmGet$urlTrack, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42733l, rowIndex2, false);
        }
        String realmGet$notificationCenterUrlTrack = object.realmGet$notificationCenterUrlTrack();
        if (realmGet$notificationCenterUrlTrack != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42734m, rowIndex2, realmGet$notificationCenterUrlTrack, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42734m, rowIndex2, false);
        }
        long j2 = tableNativePtr;
        long j3 = rowIndex2;
        Table.nativeSetLong(j2, columnInfo.f42735n, j3, (long) object.realmGet$type(), false);
        Table.nativeSetLong(j2, columnInfo.f42736o, j3, object.realmGet$timeStamp(), false);
        Table.nativeSetLong(j2, columnInfo.f42737p, j3, object.realmGet$dismissed(), false);
        String realmGet$appName = object.realmGet$appName();
        if (realmGet$appName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42738q, rowIndex2, realmGet$appName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42738q, rowIndex2, false);
        }
        String realmGet$graphic = object.realmGet$graphic();
        if (realmGet$graphic != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42739r, rowIndex2, realmGet$graphic, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42739r, rowIndex2, false);
        }
        String realmGet$ownerId = object.realmGet$ownerId();
        if (realmGet$ownerId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.f42740s, rowIndex2, realmGet$ownerId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.f42740s, rowIndex2, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.f42741t, rowIndex2, object.realmGet$processed(), false);
        return rowIndex2;
    }

    /* renamed from: a */
    public static void m45031a(C13990F realm, Iterator<? extends C0105Y> objects, Map<C0105Y, Long> cache) {
        long pkColumnIndex;
        long rowIndex;
        long rowIndex2;
        C13990F f = realm;
        Map<C0105Y, Long> map = cache;
        Table table = f.mo43537b(Notification.class);
        long tableNativePtr = table.getNativePtr();
        C14091a columnInfo = (C14091a) f.f42569h.mo43710a(Notification.class);
        long pkColumnIndex2 = table.mo23666f();
        while (objects.hasNext()) {
            Notification object = (Notification) objects.next();
            if (map.containsKey(object)) {
                pkColumnIndex = pkColumnIndex2;
            } else if (!(object instanceof C7344p) || ((C7344p) object).mo23791a().mo43514c() == null || !((C7344p) object).mo23791a().mo43514c().mo43545j().equals(realm.mo43545j())) {
                String primaryKeyValue = object.realmGet$key();
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
                Long realmGet$expire = object.realmGet$expire();
                if (realmGet$expire != null) {
                    pkColumnIndex = pkColumnIndex2;
                    String str = primaryKeyValue;
                    Table.nativeSetLong(tableNativePtr, columnInfo.f42724c, rowIndex2, realmGet$expire.longValue(), false);
                } else {
                    pkColumnIndex = pkColumnIndex2;
                    String str2 = primaryKeyValue;
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42724c, rowIndex2, false);
                }
                String realmGet$abTestingGroup = object.realmGet$abTestingGroup();
                if (realmGet$abTestingGroup != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42726e, rowIndex2, realmGet$abTestingGroup, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42726e, rowIndex2, false);
                }
                String realmGet$body = object.realmGet$body();
                if (realmGet$body != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42727f, rowIndex2, realmGet$body, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42727f, rowIndex2, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.f42728g, rowIndex2, (long) object.realmGet$campaignId(), false);
                String realmGet$img = object.realmGet$img();
                if (realmGet$img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42729h, rowIndex2, realmGet$img, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42729h, rowIndex2, false);
                }
                String realmGet$lang = object.realmGet$lang();
                if (realmGet$lang != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42730i, rowIndex2, realmGet$lang, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42730i, rowIndex2, false);
                }
                String realmGet$title = object.realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42731j, rowIndex2, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42731j, rowIndex2, false);
                }
                String realmGet$url = object.realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42732k, rowIndex2, realmGet$url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42732k, rowIndex2, false);
                }
                String realmGet$urlTrack = object.realmGet$urlTrack();
                if (realmGet$urlTrack != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42733l, rowIndex2, realmGet$urlTrack, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42733l, rowIndex2, false);
                }
                String realmGet$notificationCenterUrlTrack = object.realmGet$notificationCenterUrlTrack();
                if (realmGet$notificationCenterUrlTrack != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42734m, rowIndex2, realmGet$notificationCenterUrlTrack, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42734m, rowIndex2, false);
                }
                long j = tableNativePtr;
                long j2 = rowIndex2;
                Table.nativeSetLong(j, columnInfo.f42735n, j2, (long) object.realmGet$type(), false);
                Table.nativeSetLong(j, columnInfo.f42736o, j2, object.realmGet$timeStamp(), false);
                Table.nativeSetLong(j, columnInfo.f42737p, j2, object.realmGet$dismissed(), false);
                String realmGet$appName = object.realmGet$appName();
                if (realmGet$appName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42738q, rowIndex2, realmGet$appName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42738q, rowIndex2, false);
                }
                String realmGet$graphic = object.realmGet$graphic();
                if (realmGet$graphic != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42739r, rowIndex2, realmGet$graphic, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42739r, rowIndex2, false);
                }
                String realmGet$ownerId = object.realmGet$ownerId();
                if (realmGet$ownerId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.f42740s, rowIndex2, realmGet$ownerId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.f42740s, rowIndex2, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.f42741t, rowIndex2, object.realmGet$processed(), false);
            } else {
                map.put(object, Long.valueOf(((C7344p) object).mo23791a().mo43515d().getIndex()));
                pkColumnIndex = pkColumnIndex2;
            }
            Notification notification = object;
            pkColumnIndex2 = pkColumnIndex;
        }
    }

    /* renamed from: a */
    public static Notification m45027a(Notification realmObject, int currentDepth, int maxDepth, Map<C0105Y, C7345a<C0105Y>> cache) {
        Notification unmanagedObject;
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = (C7345a) cache.get(realmObject);
        if (cachedObject == null) {
            unmanagedObject = new Notification();
            cache.put(realmObject, new C7345a(currentDepth, unmanagedObject));
        } else if (currentDepth >= cachedObject.f14331a) {
            return (Notification) cachedObject.f14332b;
        } else {
            unmanagedObject = (Notification) cachedObject.f14332b;
            cachedObject.f14331a = currentDepth;
        }
        Notification notification = unmanagedObject;
        C0110x realmSource = realmObject;
        notification.realmSet$expire(realmSource.realmGet$expire());
        notification.realmSet$key(realmSource.realmGet$key());
        notification.realmSet$abTestingGroup(realmSource.realmGet$abTestingGroup());
        notification.realmSet$body(realmSource.realmGet$body());
        notification.realmSet$campaignId(realmSource.realmGet$campaignId());
        notification.realmSet$img(realmSource.realmGet$img());
        notification.realmSet$lang(realmSource.realmGet$lang());
        notification.realmSet$title(realmSource.realmGet$title());
        notification.realmSet$url(realmSource.realmGet$url());
        notification.realmSet$urlTrack(realmSource.realmGet$urlTrack());
        notification.realmSet$notificationCenterUrlTrack(realmSource.realmGet$notificationCenterUrlTrack());
        notification.realmSet$type(realmSource.realmGet$type());
        notification.realmSet$timeStamp(realmSource.realmGet$timeStamp());
        notification.realmSet$dismissed(realmSource.realmGet$dismissed());
        notification.realmSet$appName(realmSource.realmGet$appName());
        notification.realmSet$graphic(realmSource.realmGet$graphic());
        notification.realmSet$ownerId(realmSource.realmGet$ownerId());
        notification.realmSet$processed(realmSource.realmGet$processed());
        return unmanagedObject;
    }

    /* renamed from: a */
    static Notification m45028a(C13990F realm, Notification realmObject, Notification newObject, Map<C0105Y, C7344p> map) {
        Notification notification = realmObject;
        C0110x realmObjectSource = newObject;
        notification.realmSet$expire(realmObjectSource.realmGet$expire());
        notification.realmSet$abTestingGroup(realmObjectSource.realmGet$abTestingGroup());
        notification.realmSet$body(realmObjectSource.realmGet$body());
        notification.realmSet$campaignId(realmObjectSource.realmGet$campaignId());
        notification.realmSet$img(realmObjectSource.realmGet$img());
        notification.realmSet$lang(realmObjectSource.realmGet$lang());
        notification.realmSet$title(realmObjectSource.realmGet$title());
        notification.realmSet$url(realmObjectSource.realmGet$url());
        notification.realmSet$urlTrack(realmObjectSource.realmGet$urlTrack());
        notification.realmSet$notificationCenterUrlTrack(realmObjectSource.realmGet$notificationCenterUrlTrack());
        notification.realmSet$type(realmObjectSource.realmGet$type());
        notification.realmSet$timeStamp(realmObjectSource.realmGet$timeStamp());
        notification.realmSet$dismissed(realmObjectSource.realmGet$dismissed());
        notification.realmSet$appName(realmObjectSource.realmGet$appName());
        notification.realmSet$graphic(realmObjectSource.realmGet$graphic());
        notification.realmSet$ownerId(realmObjectSource.realmGet$ownerId());
        notification.realmSet$processed(realmObjectSource.realmGet$processed());
        return realmObject;
    }

    public String toString() {
        if (!C0106Z.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Notification = proxy[");
        stringBuilder.append("{expire:");
        String str = "null";
        stringBuilder.append(realmGet$expire() != null ? realmGet$expire() : str);
        String str2 = "}";
        stringBuilder.append(str2);
        String str3 = ",";
        stringBuilder.append(str3);
        stringBuilder.append("{key:");
        stringBuilder.append(realmGet$key() != null ? realmGet$key() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{abTestingGroup:");
        stringBuilder.append(realmGet$abTestingGroup() != null ? realmGet$abTestingGroup() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{body:");
        stringBuilder.append(realmGet$body() != null ? realmGet$body() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{campaignId:");
        stringBuilder.append(realmGet$campaignId());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{img:");
        stringBuilder.append(realmGet$img() != null ? realmGet$img() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{lang:");
        stringBuilder.append(realmGet$lang() != null ? realmGet$lang() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{urlTrack:");
        stringBuilder.append(realmGet$urlTrack() != null ? realmGet$urlTrack() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{notificationCenterUrlTrack:");
        stringBuilder.append(realmGet$notificationCenterUrlTrack() != null ? realmGet$notificationCenterUrlTrack() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{timeStamp:");
        stringBuilder.append(realmGet$timeStamp());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{dismissed:");
        stringBuilder.append(realmGet$dismissed());
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{appName:");
        stringBuilder.append(realmGet$appName() != null ? realmGet$appName() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{graphic:");
        stringBuilder.append(realmGet$graphic() != null ? realmGet$graphic() : str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{ownerId:");
        if (realmGet$ownerId() != null) {
            str = realmGet$ownerId();
        }
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append("{processed:");
        stringBuilder.append(realmGet$processed());
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public C13986D<?> mo23791a() {
        return this.f42723d;
    }

    public int hashCode() {
        String realmName = this.f42723d.mo43514c().mo43545j();
        String tableName = this.f42723d.mo43515d().mo23711f().mo23665e();
        long rowIndex = this.f42723d.mo43515d().getIndex();
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
        C14090w aNotification = (C14090w) o;
        String path = this.f42723d.mo43514c().mo43545j();
        String otherPath = aNotification.f42723d.mo43514c().mo43545j();
        if (path == null ? otherPath != null : !path.equals(otherPath)) {
            return false;
        }
        String tableName = this.f42723d.mo43515d().mo23711f().mo23665e();
        String otherTableName = aNotification.f42723d.mo43515d().mo23711f().mo23665e();
        if (tableName == null ? otherTableName != null : !tableName.equals(otherTableName)) {
            return false;
        }
        if (this.f42723d.mo43515d().getIndex() != aNotification.f42723d.mo43515d().getIndex()) {
            return false;
        }
        return true;
    }
}
