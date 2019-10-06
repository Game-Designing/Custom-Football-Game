package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.y */
/* compiled from: lambda */
public final /* synthetic */ class C2830y implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6061a;

    /* renamed from: b */
    private final /* synthetic */ String f6062b;

    /* renamed from: c */
    private final /* synthetic */ Long f6063c;

    public /* synthetic */ C2830y(Class cls, String str, Long l) {
        this.f6061a = cls;
        this.f6062b = str;
        this.f6063c = l;
    }

    public final Object call(Object obj) {
        return Database.m187a(this.f6061a, this.f6062b, this.f6063c, (C13990F) obj);
    }
}
