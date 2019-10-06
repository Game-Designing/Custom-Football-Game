package p005cm.aptoide.p006pt.downloadmanager;

import java.util.concurrent.Callable;
import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.downloadmanager.la */
/* compiled from: lambda */
public final /* synthetic */ class C3023la implements Callable {

    /* renamed from: a */
    private final /* synthetic */ DownloadTask f6317a;

    /* renamed from: b */
    private final /* synthetic */ Download f6318b;

    public /* synthetic */ C3023la(DownloadTask downloadTask, Download download) {
        this.f6317a = downloadTask;
        this.f6318b = download;
    }

    public final Object call() {
        return this.f6317a.mo13655a(this.f6318b);
    }
}
