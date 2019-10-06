package p005cm.aptoide.p006pt.downloadmanager;

import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.downloadmanager.oa */
/* compiled from: lambda */
public final /* synthetic */ class C3029oa implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Download f6325a;

    public /* synthetic */ C3029oa(Download download) {
        this.f6325a = download;
    }

    public final Object call(Object obj) {
        return DownloadTask.m7622b(this.f6325a, (Long) obj);
    }
}
