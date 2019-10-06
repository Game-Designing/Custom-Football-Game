package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.i */
/* compiled from: lambda */
public final /* synthetic */ class C2795i implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6017a;

    /* renamed from: b */
    private final /* synthetic */ String f6018b;

    /* renamed from: c */
    private final /* synthetic */ Long f6019c;

    public /* synthetic */ C2795i(Class cls, String str, Long l) {
        this.f6017a = cls;
        this.f6018b = str;
        this.f6019c = l;
    }

    public final Object call(Object obj) {
        return Database.m193b(this.f6017a, this.f6018b, this.f6019c, (C13990F) obj);
    }
}
