package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.J */
/* compiled from: lambda */
public final /* synthetic */ class C2958J implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f6241a;

    public /* synthetic */ C2958J(Download download) {
        this.f6241a = download;
    }

    public final Object call(Object obj) {
        Download download = this.f6241a;
        AptoideDownloadManager.m265a(download, (AppDownloader) obj);
        return download;
    }
}
