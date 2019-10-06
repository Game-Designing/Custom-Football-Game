package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.f */
/* compiled from: lambda */
public final /* synthetic */ class C2786f implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Class f6006a;

    /* renamed from: b */
    private final /* synthetic */ String f6007b;

    /* renamed from: c */
    private final /* synthetic */ String f6008c;

    public /* synthetic */ C2786f(Class cls, String str, String str2) {
        this.f6006a = cls;
        this.f6007b = str;
        this.f6008c = str2;
    }

    public final Object call(Object obj) {
        return Database.m188a(this.f6006a, this.f6007b, this.f6008c, (C13990F) obj);
    }
}
