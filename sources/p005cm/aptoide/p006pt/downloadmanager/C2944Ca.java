package p005cm.aptoide.p006pt.downloadmanager;

import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.downloadmanager.Ca */
/* compiled from: lambda */
public final /* synthetic */ class C2944Ca implements Callable {

    /* renamed from: a */
    private final /* synthetic */ OldAptoideDownloadManager f6226a;

    /* renamed from: b */
    private final /* synthetic */ Download f6227b;

    public /* synthetic */ C2944Ca(OldAptoideDownloadManager oldAptoideDownloadManager, Download download) {
        this.f6226a = oldAptoideDownloadManager;
        this.f6227b = download;
    }

    public final Object call() {
        return this.f6226a.mo13700h(this.f6227b);
    }
}
