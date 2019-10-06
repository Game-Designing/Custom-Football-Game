package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.editorial.Z */
/* compiled from: lambda */
public final /* synthetic */ class C3134Z implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ EditorialPresenter f6492a;

    /* renamed from: b */
    private final /* synthetic */ EditorialDownloadEvent f6493b;

    /* renamed from: c */
    private final /* synthetic */ Action f6494c;

    public /* synthetic */ C3134Z(EditorialPresenter editorialPresenter, EditorialDownloadEvent editorialDownloadEvent, Action action) {
        this.f6492a = editorialPresenter;
        this.f6493b = editorialDownloadEvent;
        this.f6494c = action;
    }

    public final Object call(Object obj) {
        return this.f6492a.mo13896a(this.f6493b, this.f6494c, (EditorialViewModel) obj);
    }
}
