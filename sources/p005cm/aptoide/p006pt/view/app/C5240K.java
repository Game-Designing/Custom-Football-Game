package p005cm.aptoide.p006pt.view.app;

import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.GetAppMetaFile;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppVersions;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.app.K */
/* compiled from: lambda */
public final /* synthetic */ class C5240K implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ AppService f9010a;

    /* renamed from: b */
    private final /* synthetic */ App f9011b;

    /* renamed from: c */
    private final /* synthetic */ GetAppMetaFile f9012c;

    /* renamed from: d */
    private final /* synthetic */ AppFlags f9013d;

    /* renamed from: e */
    private final /* synthetic */ AppDeveloper f9014e;

    /* renamed from: f */
    private final /* synthetic */ AppMedia f9015f;

    /* renamed from: g */
    private final /* synthetic */ AppStats f9016g;

    /* renamed from: h */
    private final /* synthetic */ ListAppVersions f9017h;

    /* renamed from: i */
    private final /* synthetic */ String f9018i;

    public /* synthetic */ C5240K(AppService appService, App app, GetAppMetaFile getAppMetaFile, AppFlags appFlags, AppDeveloper appDeveloper, AppMedia appMedia, AppStats appStats, ListAppVersions listAppVersions, String str) {
        this.f9010a = appService;
        this.f9011b = app;
        this.f9012c = getAppMetaFile;
        this.f9013d = appFlags;
        this.f9014e = appDeveloper;
        this.f9015f = appMedia;
        this.f9016g = appStats;
        this.f9017h = listAppVersions;
        this.f9018i = str;
    }

    public final Object call(Object obj) {
        return this.f9010a.mo16963a(this.f9011b, this.f9012c, this.f9013d, this.f9014e, this.f9015f, this.f9016g, this.f9017h, this.f9018i, (PaidApp) obj);
    }
}
