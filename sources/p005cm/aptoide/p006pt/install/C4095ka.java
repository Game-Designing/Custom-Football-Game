package p005cm.aptoide.p006pt.install;

import android.content.Context;
import p005cm.aptoide.p006pt.database.realm.Download;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.install.ka */
/* compiled from: lambda */
public final /* synthetic */ class C4095ka implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ InstallService f7633a;

    /* renamed from: b */
    private final /* synthetic */ Context f7634b;

    /* renamed from: c */
    private final /* synthetic */ boolean f7635c;

    /* renamed from: d */
    private final /* synthetic */ boolean f7636d;

    public /* synthetic */ C4095ka(InstallService installService, Context context, boolean z, boolean z2) {
        this.f7633a = installService;
        this.f7634b = context;
        this.f7635c = z;
        this.f7636d = z2;
    }

    public final Object call(Object obj) {
        return this.f7633a.mo15031a(this.f7634b, this.f7635c, this.f7636d, (Download) obj);
    }
}
