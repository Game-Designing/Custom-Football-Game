package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.j */
/* compiled from: lambda */
public final /* synthetic */ class C2798j implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6022a;

    /* renamed from: b */
    private final /* synthetic */ String f6023b;

    /* renamed from: c */
    private final /* synthetic */ Integer f6024c;

    public /* synthetic */ C2798j(Class cls, String str, Integer num) {
        this.f6022a = cls;
        this.f6023b = str;
        this.f6024c = num;
    }

    public final Object call(Object obj) {
        return Database.m186a(this.f6022a, this.f6023b, this.f6024c, (C13990F) obj);
    }
}
