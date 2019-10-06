package p005cm.aptoide.p006pt.downloadmanager;

import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.downloadmanager.ka */
/* compiled from: lambda */
public final /* synthetic */ class C3021ka implements Callable {

    /* renamed from: a */
    private final /* synthetic */ DownloadTask f6314a;

    /* renamed from: b */
    private final /* synthetic */ Download f6315b;

    public /* synthetic */ C3021ka(DownloadTask downloadTask, Download download) {
        this.f6314a = downloadTask;
        this.f6315b = download;
    }

    public final Object call() {
        return this.f6314a.mo13661b(this.f6315b);
    }
}
