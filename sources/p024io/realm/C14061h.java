package p024io.realm;

import p024io.realm.internal.Table;

/* renamed from: io.realm.h */
/* compiled from: DynamicRealm */
public class C14061h extends C14048d {
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo43533a() {
        super.mo43533a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo43538b() {
        super.mo43538b();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ void mo43543g() {
        super.mo43543g();
    }

    /* renamed from: i */
    public /* bridge */ /* synthetic */ C14001L mo43544i() {
        return super.mo43544i();
    }

    /* renamed from: j */
    public /* bridge */ /* synthetic */ String mo43545j() {
        return super.mo43545j();
    }

    /* renamed from: v */
    public /* bridge */ /* synthetic */ C14054ea mo43546v() {
        return super.mo43546v();
    }

    /* renamed from: x */
    public /* bridge */ /* synthetic */ long mo43547x() {
        return super.mo43547x();
    }

    /* renamed from: y */
    public /* bridge */ /* synthetic */ boolean mo43548y() {
        return super.mo43548y();
    }

    private C14061h(C13996J cache) {
        super(cache);
    }

    private C14061h(C14001L configuration) {
        super(configuration);
    }

    /* renamed from: c */
    public static C14061h m44876c(C14001L configuration) {
        if (configuration != null) {
            return (C14061h) C13996J.m44562a(configuration, C14061h.class);
        }
        throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
    }

    /* renamed from: b */
    public C14047ca<C14065j> mo43736b(String className) {
        mo43690d();
        if (this.f42568g.mo23625c(Table.m15962c(className))) {
            return C14047ca.m44753a(this, className);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class does not exist in the Realm and cannot be queried: ");
        sb.append(className);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    public void mo43735a(String className) {
        mo43690d();
        mo43689c();
        this.f42569h.mo43726f(className).mo23657b();
    }

    /* renamed from: a */
    static C14061h m44874a(C13996J cache) {
        return new C14061h(cache);
    }

    /* renamed from: b */
    static C14061h m44875b(C14001L configuration) {
        return new C14061h(configuration);
    }
}
