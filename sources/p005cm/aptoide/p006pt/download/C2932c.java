package p005cm.aptoide.p006pt.download;

import p005cm.aptoide.p006pt.database.realm.Download;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.download.c */
/* compiled from: lambda */
public final /* synthetic */ class C2932c implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ DownloadInstallationProvider f6211a;

    /* renamed from: b */
    private final /* synthetic */ Download f6212b;

    public /* synthetic */ C2932c(DownloadInstallationProvider downloadInstallationProvider, Download download) {
        this.f6211a = downloadInstallationProvider;
        this.f6212b = download;
    }

    public final Object call(Object obj) {
        return this.f6211a.mo13583a(this.f6212b, (Installed) obj);
    }
}
