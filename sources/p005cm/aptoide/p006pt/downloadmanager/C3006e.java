package p005cm.aptoide.p006pt.downloadmanager;

import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.downloadmanager.e */
/* compiled from: lambda */
public final /* synthetic */ class C3006e implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ AppDownloadManager f6292a;

    /* renamed from: b */
    private final /* synthetic */ RetryFileDownloader f6293b;

    public /* synthetic */ C3006e(AppDownloadManager appDownloadManager, RetryFileDownloader retryFileDownloader) {
        this.f6292a = appDownloadManager;
        this.f6293b = retryFileDownloader;
    }

    public final void call(Object obj) {
        this.f6292a.mo13616a(this.f6293b, (FileDownloadCallback) obj);
    }
}
