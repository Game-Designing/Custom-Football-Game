package p005cm.aptoide.p006pt.app.migration;

import p005cm.aptoide.p006pt.database.realm.Installed;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.migration.a */
/* compiled from: lambda */
public final /* synthetic */ class C1740a implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ String f4719a;

    /* renamed from: b */
    private final /* synthetic */ int f4720b;

    /* renamed from: c */
    private final /* synthetic */ long f4721c;

    /* renamed from: d */
    private final /* synthetic */ boolean f4722d;

    public /* synthetic */ C1740a(String str, int i, long j, boolean z) {
        this.f4719a = str;
        this.f4720b = i;
        this.f4721c = j;
        this.f4722d = z;
    }

    public final Object call(Object obj) {
        return AppcMigrationManager.m6478a(this.f4719a, this.f4720b, this.f4721c, this.f4722d, (Installed) obj);
    }
}
