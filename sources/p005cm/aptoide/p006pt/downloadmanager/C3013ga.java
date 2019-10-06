package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p019d.p307j.p308a.C13079a;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.ga */
/* compiled from: lambda */
public final /* synthetic */ class C3013ga implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ DownloadTask f6303a;

    /* renamed from: b */
    private final /* synthetic */ C13079a f6304b;

    public /* synthetic */ C3013ga(DownloadTask downloadTask, C13079a aVar) {
        this.f6303a = downloadTask;
        this.f6304b = aVar;
    }

    public final Object call(Object obj) {
        return this.f6303a.mo13662b(this.f6304b, (FileToDownload) obj);
    }
}
