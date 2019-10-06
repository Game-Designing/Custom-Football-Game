package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.P */
/* compiled from: lambda */
public final /* synthetic */ class C2970P implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideDownloadManager f6253a;

    /* renamed from: b */
    private final /* synthetic */ String f6254b;

    /* renamed from: c */
    private final /* synthetic */ Download f6255c;

    public /* synthetic */ C2970P(AptoideDownloadManager aptoideDownloadManager, String str, Download download) {
        this.f6253a = aptoideDownloadManager;
        this.f6254b = str;
        this.f6255c = download;
    }

    public final Object call(Object obj) {
        return this.f6253a.mo2022a(this.f6254b, this.f6255c, (AppDownloader) obj);
    }
}
