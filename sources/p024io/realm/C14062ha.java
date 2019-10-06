package p024io.realm;

import p024io.realm.internal.C7327c;
import p024io.realm.internal.p156a.C7317c.C7318a;

/* renamed from: io.realm.ha */
/* compiled from: SchemaConnector */
class C14062ha implements C7318a {

    /* renamed from: a */
    private final C14054ea f42611a;

    public C14062ha(C14054ea schema) {
        this.f42611a = schema;
    }

    /* renamed from: a */
    public boolean mo23738a() {
        return this.f42611a.mo43724d();
    }

    /* renamed from: a */
    public C7327c mo23737a(String tableName) {
        return this.f42611a.mo43723d(tableName);
    }

    /* renamed from: b */
    public long mo23739b(String targetTable) {
        return this.f42611a.mo43726f(targetTable).getNativePtr();
    }
}
