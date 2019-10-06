package p024io.realm;

import p024io.realm.C0105Y;
import p024io.realm.internal.Collection;
import p024io.realm.internal.LinkView;
import p024io.realm.internal.SortDescriptor;
import p024io.realm.internal.Table;
import p024io.realm.internal.TableQuery;
import p024io.realm.internal.p156a.C7317c;
import p024io.realm.internal.p156a.C7317c.C7318a;

/* renamed from: io.realm.ca */
/* compiled from: RealmQuery */
public class C14047ca<E extends C0105Y> {

    /* renamed from: a */
    private final Table f42555a;

    /* renamed from: b */
    private final C14048d f42556b;

    /* renamed from: c */
    private final TableQuery f42557c;

    /* renamed from: d */
    private final C14042ba f42558d;

    /* renamed from: e */
    private Class<E> f42559e;

    /* renamed from: f */
    private String f42560f;

    /* renamed from: g */
    private LinkView f42561g;

    /* renamed from: a */
    public static <E extends C0105Y> C14047ca<E> m44752a(C13990F realm, Class<E> clazz) {
        return new C14047ca<>(realm, clazz);
    }

    /* renamed from: a */
    public static <E extends C0105Y> C14047ca<E> m44753a(C14061h realm, String className) {
        return new C14047ca<>((C14048d) realm, className);
    }

    private C14047ca(C13990F realm, Class<E> clazz) {
        this.f42556b = realm;
        this.f42559e = clazz;
        this.f42558d = realm.mo43546v().mo43716b(clazz);
        this.f42555a = this.f42558d.mo43660c();
        this.f42561g = null;
        this.f42557c = this.f42555a.mo23676k();
    }

    private C14047ca(C14048d realm, String className) {
        this.f42556b = realm;
        this.f42560f = className;
        this.f42558d = realm.mo43546v().mo43725e(className);
        this.f42555a = this.f42558d.mo43660c();
        this.f42557c = this.f42555a.mo23676k();
    }

    /* renamed from: b */
    public C14047ca<E> mo43679b(String fieldName, String value) {
        mo43680b(fieldName, value, C14053e.SENSITIVE);
        return this;
    }

    /* renamed from: b */
    public C14047ca<E> mo43680b(String fieldName, String value, C14053e casing) {
        this.f42556b.mo43690d();
        m44758d(fieldName, value, casing);
        return this;
    }

    /* renamed from: d */
    private C14047ca<E> m44758d(String fieldName, String value, C14053e casing) {
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.STRING);
        this.f42557c.mo23691b(fd.mo23732a(), fd.mo23735d(), value, casing);
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43669a(String fieldName, Integer value) {
        this.f42556b.mo43690d();
        m44756b(fieldName, value);
        return this;
    }

    /* renamed from: b */
    private C14047ca<E> m44756b(String fieldName, Integer value) {
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.f42557c.mo23685a(fd.mo23732a(), fd.mo23735d());
        } else {
            this.f42557c.mo23686a(fd.mo23732a(), fd.mo23735d(), (long) value.intValue());
        }
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43670a(String fieldName, Long value) {
        this.f42556b.mo43690d();
        m44757b(fieldName, value);
        return this;
    }

    /* renamed from: b */
    private C14047ca<E> m44757b(String fieldName, Long value) {
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.f42557c.mo23685a(fd.mo23732a(), fd.mo23735d());
        } else {
            this.f42557c.mo23686a(fd.mo23732a(), fd.mo23735d(), value.longValue());
        }
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43668a(String fieldName, Boolean value) {
        this.f42556b.mo43690d();
        m44755b(fieldName, value);
        return this;
    }

    /* renamed from: b */
    private C14047ca<E> m44755b(String fieldName, Boolean value) {
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.BOOLEAN);
        if (value == null) {
            this.f42557c.mo23685a(fd.mo23732a(), fd.mo23735d());
        } else {
            this.f42557c.mo23688a(fd.mo23732a(), fd.mo23735d(), value.booleanValue());
        }
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43674a(String fieldName, String[] values) {
        mo43675a(fieldName, values, C14053e.SENSITIVE);
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43675a(String fieldName, String[] values, C14053e casing) {
        this.f42556b.mo43690d();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Non-empty 'values' must be provided.");
        }
        m44759e();
        m44758d(fieldName, values[0], casing);
        for (int i = 1; i < values.length; i++) {
            m44764j();
            m44758d(fieldName, values[i], casing);
        }
        m44760f();
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43673a(String fieldName, Integer[] values) {
        this.f42556b.mo43690d();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Non-empty 'values' must be provided.");
        }
        m44759e();
        m44756b(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            m44764j();
            m44756b(fieldName, values[i]);
        }
        m44760f();
        return this;
    }

    /* renamed from: c */
    public C14047ca<E> mo43683c(String fieldName, String value) {
        mo43684c(fieldName, value, C14053e.SENSITIVE);
        return this;
    }

    /* renamed from: c */
    public C14047ca<E> mo43684c(String fieldName, String value, C14053e casing) {
        this.f42556b.mo43690d();
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.STRING);
        if (fd.mo23736e() <= 1 || casing.mo43709e()) {
            this.f42557c.mo23694c(fd.mo23732a(), fd.mo23735d(), value, casing);
            return this;
        }
        throw new IllegalArgumentException("Link queries cannot be case insensitive - coming soon.");
    }

    /* renamed from: a */
    public C14047ca<E> mo43667a(String fieldName, long value) {
        this.f42556b.mo43690d();
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.INTEGER);
        this.f42557c.mo23690b(fd.mo23732a(), fd.mo23735d(), value);
        return this;
    }

    /* renamed from: b */
    public C14047ca<E> mo43678b(String fieldName, long value) {
        this.f42556b.mo43690d();
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.INTEGER);
        this.f42557c.mo23693c(fd.mo23732a(), fd.mo23735d(), value);
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43671a(String fieldName, String value) {
        mo43672a(fieldName, value, C14053e.SENSITIVE);
        return this;
    }

    /* renamed from: a */
    public C14047ca<E> mo43672a(String fieldName, String value, C14053e casing) {
        this.f42556b.mo43690d();
        C7317c fd = this.f42558d.mo43655a(fieldName, RealmFieldType.STRING);
        this.f42557c.mo23687a(fd.mo23732a(), fd.mo23735d(), value, casing);
        return this;
    }

    /* renamed from: e */
    private C14047ca<E> m44759e() {
        this.f42557c.mo23696e();
        return this;
    }

    /* renamed from: f */
    private C14047ca<E> m44760f() {
        this.f42557c.mo23689b();
        return this;
    }

    /* renamed from: d */
    public C14047ca<E> mo43685d() {
        this.f42556b.mo43690d();
        m44764j();
        return this;
    }

    /* renamed from: j */
    private C14047ca<E> m44764j() {
        this.f42557c.mo23697f();
        return this;
    }

    /* renamed from: a */
    public long mo43666a() {
        this.f42556b.mo43690d();
        return this.f42557c.mo23684a();
    }

    /* renamed from: b */
    public C14052da<E> mo43681b() {
        this.f42556b.mo43690d();
        return m44754a(this.f42557c, null, null, true);
    }

    /* renamed from: a */
    public C14052da<E> mo43677a(String fieldName, C14064ia sortOrder) {
        this.f42556b.mo43690d();
        return m44754a(this.f42557c, SortDescriptor.m15954a((C7318a) m44761g(), this.f42557c.mo23695d(), fieldName, sortOrder), null, true);
    }

    /* renamed from: a */
    public C14052da<E> mo43676a(String fieldName) {
        return mo43677a(fieldName, C14064ia.ASCENDING);
    }

    /* renamed from: i */
    private boolean m44763i() {
        return this.f42560f != null;
    }

    /* renamed from: c */
    public E mo43682c() {
        this.f42556b.mo43690d();
        long tableRowIndex = m44762h();
        if (tableRowIndex < 0) {
            return null;
        }
        return this.f42556b.mo43686a(this.f42559e, this.f42560f, tableRowIndex);
    }

    /* renamed from: a */
    private C14052da<E> m44754a(TableQuery query, SortDescriptor sortDescriptor, SortDescriptor distinctDescriptor, boolean loadResults) {
        RealmResults<E> results;
        Collection collection = new Collection(this.f42556b.f42568g, query, sortDescriptor, distinctDescriptor);
        if (m44763i()) {
            results = new C14052da<>(this.f42556b, collection, this.f42560f);
        } else {
            results = new C14052da<>(this.f42556b, collection, this.f42559e);
        }
        if (loadResults) {
            results.mo43708d();
        }
        return results;
    }

    /* renamed from: h */
    private long m44762h() {
        return this.f42557c.mo23692c();
    }

    /* renamed from: g */
    private C14062ha m44761g() {
        return new C14062ha(this.f42556b.mo43546v());
    }
}
