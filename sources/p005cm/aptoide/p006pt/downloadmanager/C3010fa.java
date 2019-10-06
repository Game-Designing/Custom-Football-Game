package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.fa */
/* compiled from: lambda */
public final /* synthetic */ class C3010fa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ DownloadTask f6297a;

    /* renamed from: b */
    private final /* synthetic */ Download f6298b;

    /* renamed from: c */
    private final /* synthetic */ Analytics f6299c;

    /* renamed from: d */
    private final /* synthetic */ OldAptoideDownloadManager f6300d;

    public /* synthetic */ C3010fa(DownloadTask downloadTask, Download download, Analytics analytics, OldAptoideDownloadManager oldAptoideDownloadManager) {
        this.f6297a = downloadTask;
        this.f6298b = download;
        this.f6299c = analytics;
        this.f6300d = oldAptoideDownloadManager;
    }

    public final Object call(Object obj) {
        return this.f6297a.mo13656a(this.f6298b, this.f6299c, this.f6300d, (Download) obj);
    }
}
