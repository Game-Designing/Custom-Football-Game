package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.p */
/* compiled from: lambda */
public final /* synthetic */ class C2812p implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6040a;

    /* renamed from: b */
    private final /* synthetic */ String f6041b;

    /* renamed from: c */
    private final /* synthetic */ String f6042c;

    public /* synthetic */ C2812p(Class cls, String str, String str2) {
        this.f6040a = cls;
        this.f6041b = str;
        this.f6042c = str2;
    }

    public final Object call(Object obj) {
        return Database.m194b(this.f6040a, this.f6041b, this.f6042c, (C13990F) obj);
    }
}
