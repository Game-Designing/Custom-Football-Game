package p005cm.aptoide.p006pt.editorial;

import p005cm.aptoide.p006pt.app.DownloadModel.Action;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.editorial.va */
/* compiled from: lambda */
public final /* synthetic */ class C3221va implements C0128a {

    /* renamed from: a */
    private final /* synthetic */ EditorialPresenter f6591a;

    /* renamed from: b */
    private final /* synthetic */ EditorialDownloadEvent f6592b;

    /* renamed from: c */
    private final /* synthetic */ Action f6593c;

    public /* synthetic */ C3221va(EditorialPresenter editorialPresenter, EditorialDownloadEvent editorialDownloadEvent, Action action) {
        this.f6591a = editorialPresenter;
        this.f6592b = editorialDownloadEvent;
        this.f6593c = action;
    }

    public final void call() {
        this.f6591a.mo13907a(this.f6592b, this.f6593c);
    }
}
