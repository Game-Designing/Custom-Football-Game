package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.da */
/* compiled from: lambda */
public final /* synthetic */ class C3004da implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AptoideDownloadManager f6289a;

    /* renamed from: b */
    private final /* synthetic */ AppDownloadStatus f6290b;

    public /* synthetic */ C3004da(AptoideDownloadManager aptoideDownloadManager, AppDownloadStatus appDownloadStatus) {
        this.f6289a = aptoideDownloadManager;
        this.f6290b = appDownloadStatus;
    }

    public final Object call(Object obj) {
        return this.f6289a.mo2020a(this.f6290b, (Download) obj);
    }
}
