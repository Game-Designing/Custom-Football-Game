package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.O */
/* compiled from: lambda */
public final /* synthetic */ class C3102O implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialManager f6453a;

    /* renamed from: b */
    private final /* synthetic */ String f6454b;

    /* renamed from: c */
    private final /* synthetic */ long f6455c;

    public /* synthetic */ C3102O(EditorialManager editorialManager, String str, long j) {
        this.f6453a = editorialManager;
        this.f6454b = str;
        this.f6455c = j;
    }

    public final Object call(Object obj) {
        return this.f6453a.mo13859a(this.f6454b, this.f6455c, (Download) obj);
    }
}
