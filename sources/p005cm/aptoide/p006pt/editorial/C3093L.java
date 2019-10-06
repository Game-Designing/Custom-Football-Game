package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.L */
/* compiled from: lambda */
public final /* synthetic */ class C3093L implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialManager f6438a;

    /* renamed from: b */
    private final /* synthetic */ EditorialDownloadEvent f6439b;

    public /* synthetic */ C3093L(EditorialManager editorialManager, EditorialDownloadEvent editorialDownloadEvent) {
        this.f6438a = editorialManager;
        this.f6439b = editorialDownloadEvent;
    }

    public final Object call(Object obj) {
        return this.f6438a.mo13858a(this.f6439b, (Download) obj);
    }
}
