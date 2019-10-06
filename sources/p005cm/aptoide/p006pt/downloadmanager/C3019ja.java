package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.FileToDownload;
import p019d.p307j.p308a.C13079a;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.downloadmanager.ja */
/* compiled from: lambda */
public final /* synthetic */ class C3019ja implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ DownloadTask f6310a;

    /* renamed from: b */
    private final /* synthetic */ FileToDownload f6311b;

    /* renamed from: c */
    private final /* synthetic */ C13079a f6312c;

    public /* synthetic */ C3019ja(DownloadTask downloadTask, FileToDownload fileToDownload, C13079a aVar) {
        this.f6310a = downloadTask;
        this.f6311b = fileToDownload;
        this.f6312c = aVar;
    }

    public final void call(Object obj) {
        this.f6310a.mo13658a(this.f6311b, this.f6312c, (Boolean) obj);
    }
}
